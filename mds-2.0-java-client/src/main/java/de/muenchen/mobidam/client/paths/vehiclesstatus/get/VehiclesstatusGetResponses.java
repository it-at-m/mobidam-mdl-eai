package org.openapijsonschematools.client.paths.vehiclesstatus.get;

import org.openapijsonschematools.client.paths.vehiclesstatus.get.responses.VehiclesstatusGetCode200Response;
import org.openapijsonschematools.client.paths.vehiclesstatus.get.responses.VehiclesstatusGetCode401Response;
import org.openapijsonschematools.client.paths.vehiclesstatus.get.responses.VehiclesstatusGetCode404Response;
import org.openapijsonschematools.client.paths.vehiclesstatus.get.responses.VehiclesstatusGetCode406Response;
import org.openapijsonschematools.client.paths.vehiclesstatus.get.responses.VehiclesstatusGetCode500Response;
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

public class VehiclesstatusGetResponses {
    public sealed interface EndpointResponse permits EndpointVehiclesstatusGetCode200Response {}

    public record EndpointVehiclesstatusGetCode200Response(
        HttpResponse<byte[]> response,
        VehiclesstatusGetCode200Response.SealedResponseBody body,
        Void headers
    ) implements EndpointResponse, ApiResponse<VehiclesstatusGetCode200Response.SealedResponseBody, Void>{
    }

    public sealed interface StatusCodeResponseDeserializer permits StatusVehiclesstatusGetCode200ResponseDeserializer, StatusVehiclesstatusGetCode401ResponseDeserializer, StatusVehiclesstatusGetCode404ResponseDeserializer, StatusVehiclesstatusGetCode406ResponseDeserializer, StatusVehiclesstatusGetCode500ResponseDeserializer {}

    public static final class StatusVehiclesstatusGetCode200ResponseDeserializer extends VehiclesstatusGetCode200Response.VehiclesstatusGetCode200Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesstatusGetCode401ResponseDeserializer extends VehiclesstatusGetCode401Response.VehiclesstatusGetCode401Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesstatusGetCode404ResponseDeserializer extends VehiclesstatusGetCode404Response.VehiclesstatusGetCode404Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesstatusGetCode406ResponseDeserializer extends VehiclesstatusGetCode406Response.VehiclesstatusGetCode406Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesstatusGetCode500ResponseDeserializer extends VehiclesstatusGetCode500Response.VehiclesstatusGetCode500Response1 implements StatusCodeResponseDeserializer {
    }

    public static final class VehiclesstatusGetResponses1 implements ResponsesDeserializer<EndpointResponse> {
        private final Map<String, StatusCodeResponseDeserializer> statusCodeToResponseDeserializer;
        public VehiclesstatusGetResponses1() {
            this.statusCodeToResponseDeserializer = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("200", new StatusVehiclesstatusGetCode200ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("401", new StatusVehiclesstatusGetCode401ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("404", new StatusVehiclesstatusGetCode404ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("406", new StatusVehiclesstatusGetCode406ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("500", new StatusVehiclesstatusGetCode500ResponseDeserializer())
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
            if (statusCodeDeserializer instanceof StatusVehiclesstatusGetCode200ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                return new EndpointVehiclesstatusGetCode200Response(response, deserializedResponse.body(), deserializedResponse.headers());
            } else if (statusCodeDeserializer instanceof StatusVehiclesstatusGetCode401ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesstatusGetCode401Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusVehiclesstatusGetCode404ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesstatusGetCode404Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusVehiclesstatusGetCode406ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesstatusGetCode406Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else {
                StatusVehiclesstatusGetCode500ResponseDeserializer castDeserializer = (StatusVehiclesstatusGetCode500ResponseDeserializer) statusCodeDeserializer;
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesstatusGetCode500Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            }
        }
    }
}
