package org.openapijsonschematools.client.paths.telemetry.get;

import org.openapijsonschematools.client.paths.telemetry.get.responses.TelemetryGetCode200Response;
import org.openapijsonschematools.client.paths.telemetry.get.responses.TelemetryGetCode400Response;
import org.openapijsonschematools.client.paths.telemetry.get.responses.TelemetryGetCode401Response;
import org.openapijsonschematools.client.paths.telemetry.get.responses.TelemetryGetCode406Response;
import org.openapijsonschematools.client.paths.telemetry.get.responses.TelemetryGetCode500Response;
import org.openapijsonschematools.client.exceptions.ApiException;
import org.openapijsonschematools.client.exceptions.NotImplementedException;
import org.openapijsonschematools.client.exceptions.ValidationException;
import org.openapijsonschematools.client.response.ApiResponse;
import org.openapijsonschematools.client.response.ResponsesDeserializer;
import org.openapijsonschematools.client.configurations.SchemaConfiguration;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.net.http.HttpResponse;
import java.util.Map;
import java.util.AbstractMap;

public class TelemetryGetResponses {
    public sealed interface EndpointResponse permits EndpointTelemetryGetCode200Response {}

    public record EndpointTelemetryGetCode200Response(
        HttpResponse<byte[]> response,
        TelemetryGetCode200Response.SealedResponseBody body,
        Void headers
    ) implements EndpointResponse, ApiResponse<TelemetryGetCode200Response.SealedResponseBody, Void>{
    }

    public sealed interface StatusCodeResponseDeserializer permits StatusTelemetryGetCode200ResponseDeserializer, StatusTelemetryGetCode400ResponseDeserializer, StatusTelemetryGetCode401ResponseDeserializer, StatusTelemetryGetCode406ResponseDeserializer, StatusTelemetryGetCode500ResponseDeserializer {}

    public static final class StatusTelemetryGetCode200ResponseDeserializer extends TelemetryGetCode200Response.TelemetryGetCode200Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusTelemetryGetCode400ResponseDeserializer extends TelemetryGetCode400Response.TelemetryGetCode400Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusTelemetryGetCode401ResponseDeserializer extends TelemetryGetCode401Response.TelemetryGetCode401Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusTelemetryGetCode406ResponseDeserializer extends TelemetryGetCode406Response.TelemetryGetCode406Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusTelemetryGetCode500ResponseDeserializer extends TelemetryGetCode500Response.TelemetryGetCode500Response1 implements StatusCodeResponseDeserializer {
    }

    public static final class TelemetryGetResponses1 implements ResponsesDeserializer<EndpointResponse> {
        private final Map<String, StatusCodeResponseDeserializer> statusCodeToResponseDeserializer;
        public TelemetryGetResponses1() {
            this.statusCodeToResponseDeserializer = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("200", new StatusTelemetryGetCode200ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("400", new StatusTelemetryGetCode400ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("401", new StatusTelemetryGetCode401ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("406", new StatusTelemetryGetCode406ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("500", new StatusTelemetryGetCode500ResponseDeserializer())
            );
        }

        public EndpointResponse deserialize(HttpResponse<byte[]> response, SchemaConfiguration configuration) throws ValidationException, NotImplementedException, ApiException {
            String statusCode = String.valueOf(response.statusCode());
            @Nullable StatusCodeResponseDeserializer statusCodeDeserializer = statusCodeToResponseDeserializer.get(statusCode);
            if (statusCodeDeserializer == null) {
                throw new ApiException(
                    "Invalid response statusCode="+statusCode+" has no response defined in the openapi document",
                    response
                );
            }
            if (statusCodeDeserializer instanceof StatusTelemetryGetCode200ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                return new EndpointTelemetryGetCode200Response(response, deserializedResponse.body(), deserializedResponse.headers());
            } else if (statusCodeDeserializer instanceof StatusTelemetryGetCode400ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new TelemetryGetCode400Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusTelemetryGetCode401ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new TelemetryGetCode401Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusTelemetryGetCode406ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new TelemetryGetCode406Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else {
                StatusTelemetryGetCode500ResponseDeserializer castDeserializer = (StatusTelemetryGetCode500ResponseDeserializer) statusCodeDeserializer;
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new TelemetryGetCode500Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            }
        }
    }
}
