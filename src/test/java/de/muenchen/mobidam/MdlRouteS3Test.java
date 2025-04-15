/*
 * The MIT License
 * Copyright © 2024 Landeshauptstadt München | it@M
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.muenchen.mobidam;

import de.muenchen.mobidam.config.InterfaceDTO;
import de.muenchen.mobidam.config.Interfaces;
import de.muenchen.mobidam.config.ResourceTypes;
import de.muenchen.mobidam.eai.common.CommonConstants;
import de.muenchen.mobidam.eai.common.config.EnvironmentReader;
import de.muenchen.mobidam.exception.MobidamSecurityException;
import de.muenchen.mobidam.integration.client.domain.DatentransferCreateDTO;
import de.muenchen.mobidam.integration.service.SstManagementIntegrationService;
import de.muenchen.mobidam.mdl.MdlEaiRouteBuilder;
import de.muenchen.mobidam.security.ResourceTypeProcessor;
import de.muenchen.mobidam.sstmanagment.EreignisTyp;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.camel.*;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.builder.ExchangeBuilder;
import org.apache.camel.component.aws2.s3.AWS2S3Constants;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.UseAdviceWith;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.reactive.function.client.WebClient;

import static org.mockito.ArgumentMatchers.isA;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@SpringBootTest
@CamelSpringBootTest
@UseAdviceWith
class MdlRouteS3Test {

    @Autowired
    private CamelContext camelContext;

    @Produce
    private ProducerTemplate startMdlInfoRequest;

    @Autowired
    private Interfaces interfaces;

    @EndpointInject("mock:mdlInfo")
    private MockEndpoint mdlInfo;

    @EndpointInject("mock:s3Destination")
    private MockEndpoint s3Destination;

    @Value("${de.muenchen.mobidam.integration.job-execute-route:endpointUriNotFoundDefault}")
    private String endpointUri;

    @MockBean
    private WebClient wb; // Mock WebClient in dependency mobidam-sst-management-integration-starter

    @MockBean
    private SstManagementIntegrationService sstService;

    @MockBean
    private ResourceTypeProcessor resourceTypeProcessor;

    @MockBean
    private ResourceTypes resourceTypes;

    @Captor
    private ArgumentCaptor<DatentransferCreateDTO> datentransferCaptor;

    @MockBean
    private EnvironmentReader environmentReader;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void test_RouteMdlInfoToS3Success() throws Exception {

        startMdlInfoRequest.start();
        AdviceWith.adviceWith(camelContext, MdlEaiRouteBuilder.MOBIDAM_ROUTE_ID,
                a -> a.weaveById(MdlEaiRouteBuilder.MOBIDAM_ENDPOINT_S3_ID).replace().toD("mock:s3Destination"));
        camelContext.start();

        var mdlRequest = ExchangeBuilder.anExchange(camelContext)
                .withHeader(CommonConstants.INTERFACE_TYPE, getInterfaceDTO())
                .build();

        Mockito.when(sstService.isActivated("999fcf2d-25bb-4fa9-85ff-f7ed12349999")).thenReturn(true);
        Mockito.when(environmentReader.getEnvironmentVariable(Mockito.any())).thenReturn("foo");
        Mockito.when(resourceTypes.getResourceTypes(Mockito.any())).thenReturn(List.of("application/json", "text/plain"));

        mdlInfo.whenAnyExchangeReceived(new MdlInfoMock());
        s3Destination.expectedMessageCount(1);

        startMdlInfoRequest.send(endpointUri, mdlRequest);
        s3Destination.assertIsSatisfied();
        var exchange = s3Destination.getExchanges().get(0);

        String content = new String(exchange.getIn().getBody(InputStream.class).readAllBytes(), StandardCharsets.UTF_8);
        Assertions.assertTrue(content.contains("2024-05-14T00:00:00"));

        Assertions.assertEquals("int-mdasc-mdasdev", exchange.getIn().getHeader(CommonConstants.HEADER_BUCKET_NAME));
        Assertions.assertEquals("foo", exchange.getIn().getHeader(CommonConstants.HEADER_ACCESS_KEY));
        Assertions.assertEquals("foo", exchange.getIn().getHeader(CommonConstants.HEADER_SECRET_KEY));
        Assertions.assertTrue(exchange.getIn().getHeader(AWS2S3Constants.KEY, String.class).startsWith("MDAS/Mdl/dev/"));
        Assertions.assertTrue(exchange.getIn().getHeader(AWS2S3Constants.KEY, String.class).endsWith("test.json"));

        Mockito.verify(this.sstService, Mockito.times(1)).isActivated("999fcf2d-25bb-4fa9-85ff-f7ed12349999");
        Mockito.verify(this.sstService, Mockito.times(3)).logDatentransfer(datentransferCaptor.capture());
        Assertions.assertEquals(EreignisTyp.BEGINN.name(), datentransferCaptor.getAllValues().get(0).getEreignis());
        Assertions.assertEquals(EreignisTyp.ERFOLG.name(), datentransferCaptor.getAllValues().get(1).getEreignis());
        Assertions.assertEquals(EreignisTyp.ENDE.name(), datentransferCaptor.getAllValues().get(2).getEreignis());

        startMdlInfoRequest.stop();
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void test_RouteMdlInfoToS3Deactivated() throws Exception {

        startMdlInfoRequest.start();
        AdviceWith.adviceWith(camelContext, MdlEaiRouteBuilder.MOBIDAM_ROUTE_ID,
                a -> a.weaveById(MdlEaiRouteBuilder.MOBIDAM_ENDPOINT_S3_ID).replace().toD("mock:s3Destination"));
        camelContext.start();

        var mdlRequest = ExchangeBuilder.anExchange(camelContext)
                .withHeader(CommonConstants.INTERFACE_TYPE, getInterfaceDTO())
                .build();

        Mockito.when(sstService.isActivated("999fcf2d-25bb-4fa9-85ff-f7ed12349999")).thenReturn(false);

        startMdlInfoRequest.send(endpointUri, mdlRequest);

        Mockito.verify(this.sstService, Mockito.times(1)).isActivated("999fcf2d-25bb-4fa9-85ff-f7ed12349999");
        Mockito.verify(this.sstService, Mockito.times(0)).logDatentransfer(datentransferCaptor.capture());

        startMdlInfoRequest.stop();

    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void test_RouteMdlInfoToS3Error() throws Exception {

        startMdlInfoRequest.start();
        AdviceWith.adviceWith(camelContext, MdlEaiRouteBuilder.MOBIDAM_ROUTE_ID,
                a -> a.weaveById(MdlEaiRouteBuilder.MOBIDAM_ENDPOINT_S3_ID).replace().toD("mock:s3Destination"));
        camelContext.start();

        var mdlRequest = ExchangeBuilder.anExchange(camelContext)
                .withHeader(CommonConstants.INTERFACE_TYPE, getInterfaceDTO())
                .build();

        Mockito.when(sstService.isActivated("999fcf2d-25bb-4fa9-85ff-f7ed12349999")).thenReturn(true);

        startMdlInfoRequest.send(endpointUri, mdlRequest);

        Mockito.verify(this.sstService, Mockito.times(1)).isActivated("999fcf2d-25bb-4fa9-85ff-f7ed12349999");
        Mockito.verify(this.sstService, Mockito.times(3)).logDatentransfer(datentransferCaptor.capture());
        Assertions.assertEquals(EreignisTyp.BEGINN.name(), datentransferCaptor.getAllValues().get(0).getEreignis());
        Assertions.assertEquals(EreignisTyp.FEHLER.name(), datentransferCaptor.getAllValues().get(1).getEreignis());
        Assertions.assertEquals(EreignisTyp.ENDE.name(), datentransferCaptor.getAllValues().get(2).getEreignis());
        Assertions.assertEquals("End interface with error : Bucket not configured: int-mdasc-mdasdev", datentransferCaptor.getAllValues().get(1).getInfo());

        startMdlInfoRequest.stop();

    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void test_RouteMdlInfoToSecurityException() throws Exception {

        startMdlInfoRequest.start();
        AdviceWith.adviceWith(camelContext, MdlEaiRouteBuilder.MOBIDAM_ROUTE_ID,
                a -> a.weaveById(MdlEaiRouteBuilder.MOBIDAM_ENDPOINT_S3_QUARANTINE_ID).replace().toD("mock:s3Destination"));
        camelContext.start();

        var mdlRequest = ExchangeBuilder.anExchange(camelContext)
                .withHeader(CommonConstants.INTERFACE_TYPE, getInterfaceDTO())
                .build();

        Mockito.when(sstService.isActivated("999fcf2d-25bb-4fa9-85ff-f7ed12349999")).thenReturn(true);

        Mockito.doThrow(new MobidamSecurityException("danger!")).when(resourceTypeProcessor).process(isA(Exchange.class));

        startMdlInfoRequest.send(endpointUri, mdlRequest);

        Mockito.verify(this.sstService, Mockito.times(1)).isActivated("999fcf2d-25bb-4fa9-85ff-f7ed12349999");
        Mockito.verify(this.sstService, Mockito.times(3)).logDatentransfer(datentransferCaptor.capture());
        Assertions.assertEquals(EreignisTyp.BEGINN.name(), datentransferCaptor.getAllValues().get(0).getEreignis());
        Assertions.assertEquals(EreignisTyp.FEHLER.name(), datentransferCaptor.getAllValues().get(1).getEreignis());
        Assertions.assertEquals(EreignisTyp.ENDE.name(), datentransferCaptor.getAllValues().get(2).getEreignis());

        s3Destination.expectedMessageCount(1);
        startMdlInfoRequest.stop();

    }

    private InterfaceDTO getInterfaceDTO() {
        var sst = this.interfaces.getInterfaces().get(this.interfaces.getInterfaces().keySet().iterator().next());
        sst.setIdentifier("test");
        return sst;
    }
}
