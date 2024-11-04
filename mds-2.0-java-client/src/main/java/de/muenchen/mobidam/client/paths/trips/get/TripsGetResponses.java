package org.openapijsonschematools.client.paths.trips.get;

import org.openapijsonschematools.client.paths.trips.get.responses.TripsGetCode200Response;
import org.openapijsonschematools.client.paths.trips.get.responses.TripsGetCode202Response;
import org.openapijsonschematools.client.paths.trips.get.responses.TripsGetCode400Response;
import org.openapijsonschematools.client.paths.trips.get.responses.TripsGetCode401Response;
import org.openapijsonschematools.client.paths.trips.get.responses.TripsGetCode404Response;
import org.openapijsonschematools.client.paths.trips.get.responses.TripsGetCode406Response;
import org.openapijsonschematools.client.paths.trips.get.responses.TripsGetCode500Response;
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

public class TripsGetResponses {
    public sealed interface EndpointResponse permits EndpointTripsGetCode200Response, EndpointTripsGetCode202Response {}

    public record EndpointTripsGetCode200Response(
        HttpResponse<byte[]> response,
        TripsGetCode200Response.SealedResponseBody body,
        Void headers
    ) implements EndpointResponse, ApiResponse<TripsGetCode200Response.SealedResponseBody, Void>{
    }

    public record EndpointTripsGetCode202Response(
        HttpResponse<byte[]> response,
        Void body,
        Void headers
    ) implements EndpointResponse, ApiResponse<Void, Void>{
    }

    public sealed interface StatusCodeResponseDeserializer permits StatusTripsGetCode200ResponseDeserializer, StatusTripsGetCode202ResponseDeserializer, StatusTripsGetCode400ResponseDeserializer, StatusTripsGetCode401ResponseDeserializer, StatusTripsGetCode404ResponseDeserializer, StatusTripsGetCode406ResponseDeserializer, StatusTripsGetCode500ResponseDeserializer {}

    public static final class StatusTripsGetCode200ResponseDeserializer extends TripsGetCode200Response.TripsGetCode200Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusTripsGetCode202ResponseDeserializer extends TripsGetCode202Response.TripsGetCode202Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusTripsGetCode400ResponseDeserializer extends TripsGetCode400Response.TripsGetCode400Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusTripsGetCode401ResponseDeserializer extends TripsGetCode401Response.TripsGetCode401Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusTripsGetCode404ResponseDeserializer extends TripsGetCode404Response.TripsGetCode404Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusTripsGetCode406ResponseDeserializer extends TripsGetCode406Response.TripsGetCode406Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusTripsGetCode500ResponseDeserializer extends TripsGetCode500Response.TripsGetCode500Response1 implements StatusCodeResponseDeserializer {
    }

    public static final class TripsGetResponses1 implements ResponsesDeserializer<EndpointResponse> {
        private final Map<String, StatusCodeResponseDeserializer> statusCodeToResponseDeserializer;
        public TripsGetResponses1() {
            this.statusCodeToResponseDeserializer = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("200", new StatusTripsGetCode200ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("202", new StatusTripsGetCode202ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("400", new StatusTripsGetCode400ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("401", new StatusTripsGetCode401ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("404", new StatusTripsGetCode404ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("406", new StatusTripsGetCode406ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("500", new StatusTripsGetCode500ResponseDeserializer())
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
            if (statusCodeDeserializer instanceof StatusTripsGetCode200ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                return new EndpointTripsGetCode200Response(response, deserializedResponse.body(), deserializedResponse.headers());
            } else if (statusCodeDeserializer instanceof StatusTripsGetCode202ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                return new EndpointTripsGetCode202Response(response, deserializedResponse.body(), deserializedResponse.headers());
            } else if (statusCodeDeserializer instanceof StatusTripsGetCode400ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new TripsGetCode400Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusTripsGetCode401ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new TripsGetCode401Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusTripsGetCode404ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new TripsGetCode404Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusTripsGetCode406ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new TripsGetCode406Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else {
                StatusTripsGetCode500ResponseDeserializer castDeserializer = (StatusTripsGetCode500ResponseDeserializer) statusCodeDeserializer;
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new TripsGetCode500Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            }
        }
    }
}
