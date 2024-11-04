package org.openapijsonschematools.client.paths.eventshistorical.get;

import org.openapijsonschematools.client.paths.eventshistorical.get.responses.EventshistoricalGetCode200Response;
import org.openapijsonschematools.client.paths.eventshistorical.get.responses.EventshistoricalGetCode202Response;
import org.openapijsonschematools.client.paths.eventshistorical.get.responses.EventshistoricalGetCode400Response;
import org.openapijsonschematools.client.paths.eventshistorical.get.responses.EventshistoricalGetCode401Response;
import org.openapijsonschematools.client.paths.eventshistorical.get.responses.EventshistoricalGetCode404Response;
import org.openapijsonschematools.client.paths.eventshistorical.get.responses.EventshistoricalGetCode406Response;
import org.openapijsonschematools.client.paths.eventshistorical.get.responses.EventshistoricalGetCode500Response;
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

public class EventshistoricalGetResponses {
    public sealed interface EndpointResponse permits EndpointEventshistoricalGetCode200Response, EndpointEventshistoricalGetCode202Response {}

    public record EndpointEventshistoricalGetCode200Response(
        HttpResponse<byte[]> response,
        EventshistoricalGetCode200Response.SealedResponseBody body,
        Void headers
    ) implements EndpointResponse, ApiResponse<EventshistoricalGetCode200Response.SealedResponseBody, Void>{
    }

    public record EndpointEventshistoricalGetCode202Response(
        HttpResponse<byte[]> response,
        Void body,
        Void headers
    ) implements EndpointResponse, ApiResponse<Void, Void>{
    }

    public sealed interface StatusCodeResponseDeserializer permits StatusEventshistoricalGetCode200ResponseDeserializer, StatusEventshistoricalGetCode202ResponseDeserializer, StatusEventshistoricalGetCode400ResponseDeserializer, StatusEventshistoricalGetCode401ResponseDeserializer, StatusEventshistoricalGetCode404ResponseDeserializer, StatusEventshistoricalGetCode406ResponseDeserializer, StatusEventshistoricalGetCode500ResponseDeserializer {}

    public static final class StatusEventshistoricalGetCode200ResponseDeserializer extends EventshistoricalGetCode200Response.EventshistoricalGetCode200Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusEventshistoricalGetCode202ResponseDeserializer extends EventshistoricalGetCode202Response.EventshistoricalGetCode202Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusEventshistoricalGetCode400ResponseDeserializer extends EventshistoricalGetCode400Response.EventshistoricalGetCode400Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusEventshistoricalGetCode401ResponseDeserializer extends EventshistoricalGetCode401Response.EventshistoricalGetCode401Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusEventshistoricalGetCode404ResponseDeserializer extends EventshistoricalGetCode404Response.EventshistoricalGetCode404Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusEventshistoricalGetCode406ResponseDeserializer extends EventshistoricalGetCode406Response.EventshistoricalGetCode406Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusEventshistoricalGetCode500ResponseDeserializer extends EventshistoricalGetCode500Response.EventshistoricalGetCode500Response1 implements StatusCodeResponseDeserializer {
    }

    public static final class EventshistoricalGetResponses1 implements ResponsesDeserializer<EndpointResponse> {
        private final Map<String, StatusCodeResponseDeserializer> statusCodeToResponseDeserializer;
        public EventshistoricalGetResponses1() {
            this.statusCodeToResponseDeserializer = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("200", new StatusEventshistoricalGetCode200ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("202", new StatusEventshistoricalGetCode202ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("400", new StatusEventshistoricalGetCode400ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("401", new StatusEventshistoricalGetCode401ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("404", new StatusEventshistoricalGetCode404ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("406", new StatusEventshistoricalGetCode406ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("500", new StatusEventshistoricalGetCode500ResponseDeserializer())
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
            if (statusCodeDeserializer instanceof StatusEventshistoricalGetCode200ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                return new EndpointEventshistoricalGetCode200Response(response, deserializedResponse.body(), deserializedResponse.headers());
            } else if (statusCodeDeserializer instanceof StatusEventshistoricalGetCode202ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                return new EndpointEventshistoricalGetCode202Response(response, deserializedResponse.body(), deserializedResponse.headers());
            } else if (statusCodeDeserializer instanceof StatusEventshistoricalGetCode400ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new EventshistoricalGetCode400Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusEventshistoricalGetCode401ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new EventshistoricalGetCode401Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusEventshistoricalGetCode404ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new EventshistoricalGetCode404Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusEventshistoricalGetCode406ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new EventshistoricalGetCode406Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else {
                StatusEventshistoricalGetCode500ResponseDeserializer castDeserializer = (StatusEventshistoricalGetCode500ResponseDeserializer) statusCodeDeserializer;
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new EventshistoricalGetCode500Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            }
        }
    }
}
