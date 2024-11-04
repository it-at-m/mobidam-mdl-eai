package org.openapijsonschematools.client.paths.vehicles.get;

import org.openapijsonschematools.client.paths.vehicles.get.responses.VehiclesGetCode200Response;
import org.openapijsonschematools.client.paths.vehicles.get.responses.VehiclesGetCode401Response;
import org.openapijsonschematools.client.paths.vehicles.get.responses.VehiclesGetCode404Response;
import org.openapijsonschematools.client.paths.vehicles.get.responses.VehiclesGetCode406Response;
import org.openapijsonschematools.client.paths.vehicles.get.responses.VehiclesGetCode500Response;
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

public class VehiclesGetResponses {
    public sealed interface EndpointResponse permits EndpointVehiclesGetCode200Response {}

    public record EndpointVehiclesGetCode200Response(
        HttpResponse<byte[]> response,
        VehiclesGetCode200Response.SealedResponseBody body,
        Void headers
    ) implements EndpointResponse, ApiResponse<VehiclesGetCode200Response.SealedResponseBody, Void>{
    }

    public sealed interface StatusCodeResponseDeserializer permits StatusVehiclesGetCode200ResponseDeserializer, StatusVehiclesGetCode401ResponseDeserializer, StatusVehiclesGetCode404ResponseDeserializer, StatusVehiclesGetCode406ResponseDeserializer, StatusVehiclesGetCode500ResponseDeserializer {}

    public static final class StatusVehiclesGetCode200ResponseDeserializer extends VehiclesGetCode200Response.VehiclesGetCode200Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesGetCode401ResponseDeserializer extends VehiclesGetCode401Response.VehiclesGetCode401Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesGetCode404ResponseDeserializer extends VehiclesGetCode404Response.VehiclesGetCode404Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesGetCode406ResponseDeserializer extends VehiclesGetCode406Response.VehiclesGetCode406Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesGetCode500ResponseDeserializer extends VehiclesGetCode500Response.VehiclesGetCode500Response1 implements StatusCodeResponseDeserializer {
    }

    public static final class VehiclesGetResponses1 implements ResponsesDeserializer<EndpointResponse> {
        private final Map<String, StatusCodeResponseDeserializer> statusCodeToResponseDeserializer;
        public VehiclesGetResponses1() {
            this.statusCodeToResponseDeserializer = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("200", new StatusVehiclesGetCode200ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("401", new StatusVehiclesGetCode401ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("404", new StatusVehiclesGetCode404ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("406", new StatusVehiclesGetCode406ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("500", new StatusVehiclesGetCode500ResponseDeserializer())
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
            if (statusCodeDeserializer instanceof StatusVehiclesGetCode200ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                return new EndpointVehiclesGetCode200Response(response, deserializedResponse.body(), deserializedResponse.headers());
            } else if (statusCodeDeserializer instanceof StatusVehiclesGetCode401ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesGetCode401Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusVehiclesGetCode404ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesGetCode404Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusVehiclesGetCode406ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesGetCode406Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else {
                StatusVehiclesGetCode500ResponseDeserializer castDeserializer = (StatusVehiclesGetCode500ResponseDeserializer) statusCodeDeserializer;
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesGetCode500Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            }
        }
    }
}
