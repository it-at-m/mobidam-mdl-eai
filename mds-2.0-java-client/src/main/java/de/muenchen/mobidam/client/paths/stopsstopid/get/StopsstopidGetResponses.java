package org.openapijsonschematools.client.paths.stopsstopid.get;

import org.openapijsonschematools.client.paths.stopsstopid.get.responses.StopsstopidGetCode200Response;
import org.openapijsonschematools.client.paths.stopsstopid.get.responses.StopsstopidGetCode400Response;
import org.openapijsonschematools.client.paths.stopsstopid.get.responses.StopsstopidGetCode401Response;
import org.openapijsonschematools.client.paths.stopsstopid.get.responses.StopsstopidGetCode404Response;
import org.openapijsonschematools.client.paths.stopsstopid.get.responses.StopsstopidGetCode406Response;
import org.openapijsonschematools.client.paths.stopsstopid.get.responses.StopsstopidGetCode500Response;
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

public class StopsstopidGetResponses {
    public sealed interface EndpointResponse permits EndpointStopsstopidGetCode200Response {}

    public record EndpointStopsstopidGetCode200Response(
        HttpResponse<byte[]> response,
        StopsstopidGetCode200Response.SealedResponseBody body,
        Void headers
    ) implements EndpointResponse, ApiResponse<StopsstopidGetCode200Response.SealedResponseBody, Void>{
    }

    public sealed interface StatusCodeResponseDeserializer permits StatusStopsstopidGetCode200ResponseDeserializer, StatusStopsstopidGetCode400ResponseDeserializer, StatusStopsstopidGetCode401ResponseDeserializer, StatusStopsstopidGetCode404ResponseDeserializer, StatusStopsstopidGetCode406ResponseDeserializer, StatusStopsstopidGetCode500ResponseDeserializer {}

    public static final class StatusStopsstopidGetCode200ResponseDeserializer extends StopsstopidGetCode200Response.StopsstopidGetCode200Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusStopsstopidGetCode400ResponseDeserializer extends StopsstopidGetCode400Response.StopsstopidGetCode400Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusStopsstopidGetCode401ResponseDeserializer extends StopsstopidGetCode401Response.StopsstopidGetCode401Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusStopsstopidGetCode404ResponseDeserializer extends StopsstopidGetCode404Response.StopsstopidGetCode404Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusStopsstopidGetCode406ResponseDeserializer extends StopsstopidGetCode406Response.StopsstopidGetCode406Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusStopsstopidGetCode500ResponseDeserializer extends StopsstopidGetCode500Response.StopsstopidGetCode500Response1 implements StatusCodeResponseDeserializer {
    }

    public static final class StopsstopidGetResponses1 implements ResponsesDeserializer<EndpointResponse> {
        private final Map<String, StatusCodeResponseDeserializer> statusCodeToResponseDeserializer;
        public StopsstopidGetResponses1() {
            this.statusCodeToResponseDeserializer = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("200", new StatusStopsstopidGetCode200ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("400", new StatusStopsstopidGetCode400ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("401", new StatusStopsstopidGetCode401ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("404", new StatusStopsstopidGetCode404ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("406", new StatusStopsstopidGetCode406ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("500", new StatusStopsstopidGetCode500ResponseDeserializer())
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
            if (statusCodeDeserializer instanceof StatusStopsstopidGetCode200ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                return new EndpointStopsstopidGetCode200Response(response, deserializedResponse.body(), deserializedResponse.headers());
            } else if (statusCodeDeserializer instanceof StatusStopsstopidGetCode400ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new StopsstopidGetCode400Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusStopsstopidGetCode401ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new StopsstopidGetCode401Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusStopsstopidGetCode404ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new StopsstopidGetCode404Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusStopsstopidGetCode406ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new StopsstopidGetCode406Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else {
                StatusStopsstopidGetCode500ResponseDeserializer castDeserializer = (StatusStopsstopidGetCode500ResponseDeserializer) statusCodeDeserializer;
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new StopsstopidGetCode500Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            }
        }
    }
}
