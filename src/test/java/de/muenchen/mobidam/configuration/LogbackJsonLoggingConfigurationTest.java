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
package de.muenchen.mobidam.configuration;

import static de.muenchen.mobidam.TestConstants.SPRING_JSON_LOGGING_PROFILE;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ActiveProfiles(SPRING_JSON_LOGGING_PROFILE)
@ExtendWith(OutputCaptureExtension.class)
@Slf4j
@Disabled("run manually on logback config changes")
class LogbackJsonLoggingConfigurationTest {

    private static final String EXCEPTION_MESSAGE = "EXC_MESSAGE";
    private static final Pattern STACKTRACE_PATTERN = Pattern.compile("stack_trace\":\"([^\"]*)\"");

    private Throwable exception;

    @Configuration
    @SuppressWarnings("PMD.TestClassWithoutTestCases")
    /* default */ static class TestConfiguration {
    }

    @BeforeEach
    void setup() {
        // prepare an exception with huge stacktrace contents
        exception = genExceptionStack(new IllegalArgumentException("rootcause"), 40);
        // make sure generated stacktrace is long enough to test shortening
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        final String untouchedStacktrace = sw.toString();
        assertThat(untouchedStacktrace.length()).isGreaterThan(16_000);
    }

    @AfterEach
    void tearDown() {
        // make sure MDC is clean after tests
        MDC.clear();
    }

    @Test
    void putsMdcInJson(final CapturedOutput output) {
        MDC.put("traceId", "myTraceId");
        MDC.put("spanId", "mySpanId");
        final String message = "my message";
        log.info(message);

        final String line = findLogmessageInOutput(output, message);

        assertThat(line).contains("myTraceId").contains("mySpanId");
    }

    @Test
    void jsonPrintsRootCauseOfStacktraceFirst(final CapturedOutput output) {
        log.error(EXCEPTION_MESSAGE, exception);

        final String line = findLogmessageInOutput(output, EXCEPTION_MESSAGE);

        assertThat(line.indexOf("rootcause")).isLessThan(line.indexOf("stackmessage-#1"));
    }

    @Test
    void shortensLengthOfStacktrace(final CapturedOutput output) {
        log.error(EXCEPTION_MESSAGE, exception);

        final String line = findLogmessageInOutput(output, EXCEPTION_MESSAGE);

        final Matcher matcher = STACKTRACE_PATTERN.matcher(line);
        if (matcher.find()) {
            final String group = matcher.group(1);
            // apparently ShortenedThrowableConverter is not a 100% accurate with "maxLength" - but that is fine
            assertThat(group.length()).isCloseTo(8_192, Percentage.withPercentage(10.0d));
        } else {
            Assertions.fail("Expected to find a stack_trace element in JSON structure, but was not present.");
        }
    }

    private String findLogmessageInOutput(final CapturedOutput output, final String expected) {
        final String fullOutput = output.getOut();
        return Arrays.stream(fullOutput.split("\n"))
                .filter(s -> s.contains(expected))
                .findFirst().orElseThrow();
    }

    private static Throwable genExceptionStack(final Throwable root, final int index) {
        if (index > 0) {
            return new IllegalArgumentException("stackmessage-#%d: (%s)".formatted(index, StringUtils.repeat("abcd ", 20)), genExceptionStack(root, index - 1));
        } else {
            return root;
        }
    }
}
