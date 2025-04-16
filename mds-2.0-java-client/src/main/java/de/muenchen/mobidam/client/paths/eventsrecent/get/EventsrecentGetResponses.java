package org.openapijsonschematools.client.paths.eventsrecent.get;

import org.openapijsonschematools.client.paths.eventsrecent.get.responses.EventsrecentGetCode200Response;
import org.openapijsonschematools.client.paths.eventsrecent.get.responses.EventsrecentGetCode400Response;
import org.openapijsonschematools.client.paths.eventsrecent.get.responses.EventsrecentGetCode401Response;
import org.openapijsonschematools.client.paths.eventsrecent.get.responses.EventsrecentGetCode406Response;
import org.openapijsonschematools.client.paths.eventsrecent.get.responses.EventsrecentGetCode500Response;
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

public class EventsrecentGetResponses {
    public sealed interface EndpointResponse permits EndpointEventsrecentGetCode200Response {}

    public record EndpointEventsrecentGetCode200Response(
        HttpResponse<byte[]> response,
        EventsrecentGetCode200Response.SealedResponseBody body,
        Void headers
    ) implements EndpointResponse, ApiResponse<EventsrecentGetCode200Response.SealedResponseBody, Void>{
    }

    public sealed interface StatusCodeResponseDeserializer permits StatusEventsrecentGetCode200ResponseDeserializer, StatusEventsrecentGetCode400ResponseDeserializer, StatusEventsrecentGetCode401ResponseDeserializer, StatusEventsrecentGetCode406ResponseDeserializer, StatusEventsrecentGetCode500ResponseDeserializer {}

    public static final class StatusEventsrecentGetCode200ResponseDeserializer extends EventsrecentGetCode200Response.EventsrecentGetCode200Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusEventsrecentGetCode400ResponseDeserializer extends EventsrecentGetCode400Response.EventsrecentGetCode400Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusEventsrecentGetCode401ResponseDeserializer extends EventsrecentGetCode401Response.EventsrecentGetCode401Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusEventsrecentGetCode406ResponseDeserializer extends EventsrecentGetCode406Response.EventsrecentGetCode406Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusEventsrecentGetCode500ResponseDeserializer extends EventsrecentGetCode500Response.EventsrecentGetCode500Response1 implements StatusCodeResponseDeserializer {
    }

    public static final class EventsrecentGetResponses1 implements ResponsesDeserializer<EndpointResponse> {
        private final Map<String, StatusCodeResponseDeserializer> statusCodeToResponseDeserializer;
        public EventsrecentGetResponses1() {
            this.statusCodeToResponseDeserializer = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("200", new StatusEventsrecentGetCode200ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("400", new StatusEventsrecentGetCode400ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("401", new StatusEventsrecentGetCode401ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("406", new StatusEventsrecentGetCode406ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("500", new StatusEventsrecentGetCode500ResponseDeserializer())
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
            if (statusCodeDeserializer instanceof StatusEventsrecentGetCode200ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                return new EndpointEventsrecentGetCode200Response(response, deserializedResponse.body(), deserializedResponse.headers());
            } else if (statusCodeDeserializer instanceof StatusEventsrecentGetCode400ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new EventsrecentGetCode400Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusEventsrecentGetCode401ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new EventsrecentGetCode401Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusEventsrecentGetCode406ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new EventsrecentGetCode406Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else {
                StatusEventsrecentGetCode500ResponseDeserializer castDeserializer = (StatusEventsrecentGetCode500ResponseDeserializer) statusCodeDeserializer;
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new EventsrecentGetCode500Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            }
        }
    }
}
