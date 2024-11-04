package org.openapijsonschematools.client.paths.stops.get;

import org.openapijsonschematools.client.paths.stops.get.responses.StopsGetCode200Response;
import org.openapijsonschematools.client.paths.stops.get.responses.StopsGetCode401Response;
import org.openapijsonschematools.client.paths.stops.get.responses.StopsGetCode406Response;
import org.openapijsonschematools.client.paths.stops.get.responses.StopsGetCode500Response;
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

public class StopsGetResponses {
    public sealed interface EndpointResponse permits EndpointStopsGetCode200Response {}

    public record EndpointStopsGetCode200Response(
        HttpResponse<byte[]> response,
        StopsGetCode200Response.SealedResponseBody body,
        Void headers
    ) implements EndpointResponse, ApiResponse<StopsGetCode200Response.SealedResponseBody, Void>{
    }

    public sealed interface StatusCodeResponseDeserializer permits StatusStopsGetCode200ResponseDeserializer, StatusStopsGetCode401ResponseDeserializer, StatusStopsGetCode406ResponseDeserializer, StatusStopsGetCode500ResponseDeserializer {}

    public static final class StatusStopsGetCode200ResponseDeserializer extends StopsGetCode200Response.StopsGetCode200Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusStopsGetCode401ResponseDeserializer extends StopsGetCode401Response.StopsGetCode401Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusStopsGetCode406ResponseDeserializer extends StopsGetCode406Response.StopsGetCode406Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusStopsGetCode500ResponseDeserializer extends StopsGetCode500Response.StopsGetCode500Response1 implements StatusCodeResponseDeserializer {
    }

    public static final class StopsGetResponses1 implements ResponsesDeserializer<EndpointResponse> {
        private final Map<String, StatusCodeResponseDeserializer> statusCodeToResponseDeserializer;
        public StopsGetResponses1() {
            this.statusCodeToResponseDeserializer = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("200", new StatusStopsGetCode200ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("401", new StatusStopsGetCode401ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("406", new StatusStopsGetCode406ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("500", new StatusStopsGetCode500ResponseDeserializer())
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
            if (statusCodeDeserializer instanceof StatusStopsGetCode200ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                return new EndpointStopsGetCode200Response(response, deserializedResponse.body(), deserializedResponse.headers());
            } else if (statusCodeDeserializer instanceof StatusStopsGetCode401ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new StopsGetCode401Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusStopsGetCode406ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new StopsGetCode406Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else {
                StatusStopsGetCode500ResponseDeserializer castDeserializer = (StatusStopsGetCode500ResponseDeserializer) statusCodeDeserializer;
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new StopsGetCode500Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            }
        }
    }
}
