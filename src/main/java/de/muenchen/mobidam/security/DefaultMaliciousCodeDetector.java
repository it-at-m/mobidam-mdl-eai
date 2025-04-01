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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import de.muenchen.mobidam.config.MaliciousDataRegex;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.apache.camel.Exchange;
import org.json.JSONObject;
import org.owasp.encoder.Encode;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DefaultMaliciousCodeDetector implements MaliciousCodeDetector {

    private MaliciousDataRegex maliciousPatterns;

    public DefaultMaliciousCodeDetector(MaliciousDataRegex maliciousPatterns) {
        this.maliciousPatterns = maliciousPatterns;
    }

    public DefaultMaliciousCodeDetector() {
    }

    public boolean isValidData(final InputStream stream, Exchange exchange) throws IOException {
        String jsonString = readInputStream(stream);
        try {
            Object json = new JSONObject(jsonString);  // Try parsing as JSONObject
            return isValidJson(json);
        } catch (JSONException e) {
            try {
                // If not JSONObject, try JSONArray
                Object json = new JSONArray(jsonString);
                return isValidJson(json);
            } catch (JSONException ex) {
                // If it cannot be parsed as either, it's invalid JSON
                log.error("Invalid JSON format");
                return false;
            }
        }
    }

    private String readInputStream(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    private boolean isValidJson(Object json) {
        if (json instanceof JSONObject) {
            return validateJsonObject((JSONObject) json);
        } else if (json instanceof JSONArray) {
            return validateJsonArray((JSONArray) json);
        }
        return true;  // If it's a valid structure, return true
    }

    private boolean validateJsonObject(JSONObject jsonObject) {
        for (Iterator<String> it = jsonObject.keys(); it.hasNext(); ) {
            String key = it.next();
            Object value = jsonObject.get(key);
            if (value instanceof String) {
                String textContent = (String) value;
                log.trace("JSON value for key {}: {}", key, textContent);
                String clean = Encode.forHtml(textContent);
                if (!textContent.equals(clean)) {
                    return false;  // Found potentially malicious content
                }
                if(checkForMaliciousPattern(clean)) {
                    return false;
                }
            } else if (value instanceof JSONObject) {
                // Recursively validate nested JSON objects
                if (!validateJsonObject((JSONObject) value)) {
                    return false;
                }
            } else if (value instanceof JSONArray) {
                // Recursively validate arrays
                if (!validateJsonArray((JSONArray) value)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validateJsonArray(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            Object value = jsonArray.get(i);
            if (value instanceof String) {
                String textContent = (String) value;
                log.trace("JSON array element: {}", textContent);
                String clean = Encode.forHtml(textContent);
                if (!textContent.equals(clean)) {
                    return false;  // Found potentially malicious content
                }
                if(checkForMaliciousPattern(clean)) {
                    return false;
                }
            } else if (value instanceof JSONObject) {
                // Recursively validate nested JSON objects
                if (!validateJsonObject((JSONObject) value)) {
                    return false;
                }
            } else if (value instanceof JSONArray) {
                // Recursively validate arrays
                if (!validateJsonArray((JSONArray) value)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkForMaliciousPattern(String cell){
        if(maliciousPatterns != null) {
            for (Map.Entry<String, Pattern> entry : maliciousPatterns.getMaliciousDataPatterns().entrySet()) {
                var match = entry.getValue().matcher(cell).matches();
                if (match) {
                    log.warn("MaliciousCSVCode - {} ({}) : {}", entry.getKey(), maliciousPatterns.getMaliciousDataRegex().get(entry.getKey()), cell);
                    return true;
                }
            }
        }
        return false;
    }

}
