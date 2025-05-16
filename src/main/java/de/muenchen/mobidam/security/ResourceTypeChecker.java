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

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.tika.Tika;
import org.apache.tika.mime.MediaType;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ResourceTypeChecker {

    public static final MediaType APPLICATION_JSON_TYPE = new MediaType("application", "json");

    private final Tika tika = new Tika();

    private final DefaultMaliciousCodeDetector detector = new DefaultMaliciousCodeDetector();

    public boolean check(final InputStream stream, final List<String> allowedMimeTypes, final Exchange exchange)
            throws IOException {

        var contentType = exchange.getIn().getHeader(Exchange.CONTENT_TYPE, String.class);
        if (contentType != null && allowedMimeTypes.stream().filter(contentType::contains).findAny().isEmpty()) {
            log.error("Mimetype is not allowed: { }", contentType);
            return false;
        }
        String detectedMimeType = getResourceType(stream, contentType, exchange);
        if (detectedMimeType != null && allowedMimeTypes.stream().filter(detectedMimeType::contains).findAny().isEmpty()) {
            log.error("Mimetype is not allowed: {}", detectedMimeType);
            return false;
        }
        return true;

    }

    private String getResourceType(final InputStream stream, String contentType, Exchange exchange) throws IOException {

        if (contentType != null && contentType.contains(APPLICATION_JSON_TYPE.toString())) {
                /*
                  The content type is not provided by the data provider, but in the route builder by marshal().json().
                 */
                return APPLICATION_JSON_TYPE.toString();
        } else
            return tika.detect(stream);
    }
}
