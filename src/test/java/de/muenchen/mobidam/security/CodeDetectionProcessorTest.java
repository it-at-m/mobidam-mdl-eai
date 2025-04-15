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
package de.muenchen.mobidam.security;

import de.muenchen.mobidam.config.InterfaceDTO;
import de.muenchen.mobidam.config.MaliciousDataRegex;
import de.muenchen.mobidam.config.ResourceType;
import de.muenchen.mobidam.config.ResourceTypes;
import de.muenchen.mobidam.eai.common.CommonConstants;
import de.muenchen.mobidam.eai.common.exception.MobidamSecurityException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.camel.Exchange;
import org.apache.camel.converter.stream.InputStreamCache;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.DefaultExchange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

public class CodeDetectionProcessorTest {

    private CodeDetectionProcessor processor;

    @BeforeEach
    public void init() {
        MaliciousDataRegex maliciousPatterns = new MaliciousDataRegex();
        maliciousPatterns.setMaliciousDataRegex(Map.of(
                "excel", "^[=]\\w*",
                "script", ".*\\.(exe)",
                "sql", "drop\\s.*",
                "xss", ".*<.*"));
        CodeDetectorFactory factory = new CodeDetectorFactory(new DefaultMaliciousCodeDetector(maliciousPatterns));
        ResourceTypes resourceTypes = new ResourceTypes();
        resourceTypes.setResourceTypes(Map.of("json", new ResourceType(List.of("application/json", "text/plain")),
                "plain", new ResourceType(List.of("text/plain"))));
        processor = new CodeDetectionProcessor(factory, resourceTypes);
    }

    @Test
    public void testProcessJsonWithExtensionPlain() throws Exception {
        Exchange exchange = createExchange(List.of(MediaType.TEXT_PLAIN.getSubtype()));
        assertInvalid("/testdata/invalid-plain-example.json", exchange);
    }

    @Test
    public void testProcessWithValidJsonData() throws Exception {
        Exchange exchange = createExchange(List.of(ResourceTypeChecker.APPLICATION_JSON_TYPE.getSubtype()));
        try (InputStream resStream = this.getClass().getResourceAsStream("/testdata/valid.json")) {
            if (resStream == null) throw new IOException("Resource not found: /testdata/valid.json");
            InputStreamCache stream = new InputStreamCache(resStream.readAllBytes());
            exchange.getIn().setBody(stream);
            processor.process(exchange);
        }
    }

    @Test
    public void testProcessJsonWithExcel() throws Exception {
        Exchange exchange = createExchange(List.of(ResourceTypeChecker.APPLICATION_JSON_TYPE.getSubtype()));
        assertInvalid("/testdata/invalid-excel-example.json", exchange);
    }

    @Test
    public void testProcessJsonWithSQL() throws Exception {
        Exchange exchange = createExchange(List.of(ResourceTypeChecker.APPLICATION_JSON_TYPE.getSubtype()));
        assertInvalid("/testdata/invalid-sql-example.json", exchange);
    }

    @Test
    public void testProcessJsonWithXssScript() throws Exception {
        Exchange exchange = createExchange(List.of(ResourceTypeChecker.APPLICATION_JSON_TYPE.getSubtype()));
        assertInvalid("/testdata/invalid-xss-example.json", exchange);
    }

    @Test
    public void testProcessJsonWithExe() throws Exception {
        Exchange exchange = createExchange(List.of(ResourceTypeChecker.APPLICATION_JSON_TYPE.getSubtype()));
        assertInvalid("/testdata/invalid-script-example.json", exchange);
    }

    private Exchange createExchange(List<String> allowedTypes) {
        Exchange exchange = new DefaultExchange(new DefaultCamelContext());
        InterfaceDTO interfaceDTO = new InterfaceDTO();
        interfaceDTO.setMaliciousCodeDetectionEnabled(true);
        interfaceDTO.setAllowedResourceTypes(allowedTypes);
        exchange.getIn().setHeader(CommonConstants.INTERFACE_TYPE, interfaceDTO);
        return exchange;
    }

    private void assertInvalid(String resource, Exchange exchange) throws IOException {
        try (InputStream resStream = this.getClass().getResourceAsStream(resource)) {
            if (resStream == null) throw new IOException("Resource not found: " + resource);
            InputStreamCache stream = new InputStreamCache(resStream.readAllBytes());
            exchange.getIn().setBody(stream);
            Assertions.assertThrows(MobidamSecurityException.class, () -> processor.process(exchange));
        }
    }

}
