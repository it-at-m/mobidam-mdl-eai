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
import de.muenchen.mobidam.integration.client.domain.DatentransferCreateDTO;
import de.muenchen.mobidam.integration.service.SstManagementIntegrationService;
import de.muenchen.mobidam.mdl.MdlEaiRouteBuilder;
import org.apache.camel.*;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.builder.ExchangeBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.UseAdviceWith;
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

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@SpringBootTest
@CamelSpringBootTest
@UseAdviceWith
class MdlRouteS3DeactivatedTest {

    @Autowired
    private CamelContext camelContext;

    @Produce(MdlEaiRouteBuilder.MOBIDAM_S3_ROUTE)
    private ProducerTemplate startMdlInfoRequest;

    @Autowired
    private Interfaces interfaces;

    @EndpointInject("mock:mdlInfo")
    private MockEndpoint mdlInfo;

    @MockBean
    private WebClient wb; // Mock WebClient in dependency mobidam-sst-management-integration-starter

    @MockBean
    private SstManagementIntegrationService sstService;

    @Captor
    private ArgumentCaptor<DatentransferCreateDTO> datentransferCaptor;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void test_RouteMdlInfoToS3Deactivated() throws Exception {

        startMdlInfoRequest.start();
        AdviceWith.adviceWith(camelContext, MdlEaiRouteBuilder.MOBIDAM_RESPONSE_ROUTE_ID,
                a -> a.weaveById(MdlEaiRouteBuilder.MOBIDAM_ENDPOINT_S3_ID).replace().toD("mock:s3Destination"));
        camelContext.start();

        var mdlRequest = ExchangeBuilder.anExchange(camelContext)
                .withHeader(Constants.INTERFACE_TYPE, getInterfaceDTO())
                .build();

        Mockito.when(sstService.isActivated("999fcf2d-25bb-4fa9-85ff-f7ed12349999")).thenReturn(false);

        startMdlInfoRequest.send(mdlRequest);

        Mockito.verify(this.sstService, Mockito.times(1)).isActivated("999fcf2d-25bb-4fa9-85ff-f7ed12349999");
        Mockito.verify(this.sstService, Mockito.times(0)).logDatentransfer(datentransferCaptor.capture());

        startMdlInfoRequest.stop();

    }

    private InterfaceDTO getInterfaceDTO() {
        var sst = this.interfaces.getInterfaces().get(this.interfaces.getInterfaces().keySet().iterator().next());
        sst.setIdentifier("test");
        return sst;
    }
}
