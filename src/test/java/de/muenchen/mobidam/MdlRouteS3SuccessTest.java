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

import de.muenchen.mobidam.client.ProviderCache;
import de.muenchen.mobidam.client.gen.api.DefaultApi;
import de.muenchen.mobidam.client.gen.model.GetVehicles200Response;
import de.muenchen.mobidam.client.gen.model.ModelsVehicle;
import de.muenchen.mobidam.config.InterfaceDTO;
import de.muenchen.mobidam.config.Interfaces;
import de.muenchen.mobidam.eai.common.CommonConstants;
import de.muenchen.mobidam.eai.common.s3.S3CredentialProvider;
import de.muenchen.mobidam.integration.client.domain.DatentransferCreateDTO;
import de.muenchen.mobidam.integration.service.SstManagementIntegrationService;
import de.muenchen.mobidam.mdl.MdlEaiRouteBuilder;
import de.muenchen.mobidam.mdl.ProviderRequests;
import de.muenchen.mobidam.sstmanagment.EreignisTyp;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@SpringBootTest
@CamelSpringBootTest
@UseAdviceWith
class MdlRouteS3SuccessTest {

    @Autowired
    private CamelContext camelContext;

    @Produce(MdlEaiRouteBuilder.MOBIDAM_S3_ROUTE)
    private ProducerTemplate startMdlInfoRequest;

    @Autowired
    private Interfaces interfaces;

    @EndpointInject("mock:mdlInfo")
    private MockEndpoint mdlInfo;

    @EndpointInject("mock:s3Destination")
    private MockEndpoint s3Destination;

    @MockBean
    private WebClient wb; // Mock WebClient in dependency mobidam-sst-management-integration-starter

    @MockBean
    private SstManagementIntegrationService sstService;

    @MockBean
    private ProviderCache providerCache;

    @MockBean
    private S3CredentialProvider credentialProvider;

    @MockBean
    private ProviderRequests providerRequest;

    @Produce(MdlEaiRouteBuilder.RECEIVED_DATA_ROUTE)
    private ProducerTemplate receivedDataHandler;

    @Captor
    private ArgumentCaptor<DatentransferCreateDTO> datentransferCaptor;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void test_RouteMdlInfoToS3Success() throws Exception {

        startMdlInfoRequest.start();
        AdviceWith.adviceWith(camelContext, MdlEaiRouteBuilder.MOBIDAM_RESPONSE_ROUTE_ID,
                a -> a.weaveById(MdlEaiRouteBuilder.MOBIDAM_ENDPOINT_S3_ID).replace().toD("mock:s3Destination"));
        camelContext.start();

        var mdlRequest = ExchangeBuilder.anExchange(camelContext)
                .withHeader(Constants.INTERFACE_TYPE, getInterfaceDTO())
                .build();

        Mockito.when(sstService.isActivated("999fcf2d-25bb-4fa9-85ff-f7ed12349999")).thenReturn(true);
        Mockito.when(providerCache.getProvider(getInterfaceDTO())).thenReturn(Optional.of(new DefaultApi()));
        mockCredentialProvider();
        mockProviderRequest();

        mdlInfo.whenAnyExchangeReceived(new MdlInfoMock());
        s3Destination.expectedMessageCount(1);

        startMdlInfoRequest.send(mdlRequest);
        s3Destination.assertIsSatisfied();
        var exchange = s3Destination.getExchanges().get(0);

        String content = new String(exchange.getIn().getBody(InputStream.class).readAllBytes(), StandardCharsets.UTF_8);
        Assertions.assertTrue(content.contains("2024-05-14T00:00:00"));

        Assertions.assertEquals("int-mdasc-mdasdev", exchange.getIn().getHeader(CommonConstants.HEADER_BUCKET_NAME));
        Assertions.assertEquals("accessTestKey", exchange.getIn().getHeader(CommonConstants.HEADER_ACCESS_KEY));
        Assertions.assertEquals("secretTestKey", exchange.getIn().getHeader(CommonConstants.HEADER_SECRET_KEY));
        Assertions.assertTrue(exchange.getIn().getHeader(AWS2S3Constants.KEY, String.class).startsWith("MDAS/Mdl/dev/"));
        Assertions.assertTrue(exchange.getIn().getHeader(AWS2S3Constants.KEY, String.class).endsWith("test.json"));

        Mockito.verify(this.sstService, Mockito.times(1)).isActivated("999fcf2d-25bb-4fa9-85ff-f7ed12349999");
        Mockito.verify(this.sstService, Mockito.times(3)).logDatentransfer(datentransferCaptor.capture());
        Assertions.assertEquals(EreignisTyp.BEGINN.name(), datentransferCaptor.getAllValues().get(0).getEreignis());
        Assertions.assertEquals(EreignisTyp.ERFOLG.name(), datentransferCaptor.getAllValues().get(1).getEreignis());
        Assertions.assertEquals("Interface status code : 'null' (MDAS/Mdl/dev/test.json)", datentransferCaptor.getAllValues().get(1).getInfo());
        Assertions.assertEquals(EreignisTyp.ENDE.name(), datentransferCaptor.getAllValues().get(2).getEreignis());

        startMdlInfoRequest.stop();
    }

    private InterfaceDTO getInterfaceDTO() {
        var sst = this.interfaces.getInterfaces().get(this.interfaces.getInterfaces().keySet().iterator().next());
        sst.setIdentifier("test");
        return sst;
    }

    private void mockProviderRequest() throws Exception {
        Mockito.doAnswer(mockArgs -> {
            Exchange receivedExchange = mockArgs.getArgument(0);
            var clonedExchange = ProviderRequests.cloneExchange(receivedExchange);

            var vehicles = new GetVehicles200Response();
            var vehicle = new ModelsVehicle();
            vehicle.setVehicleId("2024-05-14T00:00:00");
            vehicles.setVehicles(List.of(vehicle));

            clonedExchange.getIn().setBody(vehicles);
            receivedDataHandler.send(clonedExchange);
            return null;
        }).when(providerRequest).process(any(Exchange.class));
    }

    private void mockCredentialProvider() throws Exception {
        Mockito.doAnswer(args -> {
            Exchange ex = args.getArgument(0);
            ex.getMessage().setHeader("accessKey", "accessTestKey");
            ex.getMessage().setHeader("secretKey", "secretTestKey");
            return null;
        }).when(credentialProvider).process(any(Exchange.class));
    }
}
