package org.openapijsonschematools.client.paths.vehiclesstatusdeviceid.get;

import org.openapijsonschematools.client.paths.vehiclesstatusdeviceid.get.responses.VehiclesstatusdeviceidGetCode200Response;
import org.openapijsonschematools.client.paths.vehiclesstatusdeviceid.get.responses.VehiclesstatusdeviceidGetCode400Response;
import org.openapijsonschematools.client.paths.vehiclesstatusdeviceid.get.responses.VehiclesstatusdeviceidGetCode401Response;
import org.openapijsonschematools.client.paths.vehiclesstatusdeviceid.get.responses.VehiclesstatusdeviceidGetCode404Response;
import org.openapijsonschematools.client.paths.vehiclesstatusdeviceid.get.responses.VehiclesstatusdeviceidGetCode406Response;
import org.openapijsonschematools.client.paths.vehiclesstatusdeviceid.get.responses.VehiclesstatusdeviceidGetCode500Response;
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

public class VehiclesstatusdeviceidGetResponses {
    public sealed interface EndpointResponse permits EndpointVehiclesstatusdeviceidGetCode200Response {}

    public record EndpointVehiclesstatusdeviceidGetCode200Response(
        HttpResponse<byte[]> response,
        VehiclesstatusdeviceidGetCode200Response.SealedResponseBody body,
        Void headers
    ) implements EndpointResponse, ApiResponse<VehiclesstatusdeviceidGetCode200Response.SealedResponseBody, Void>{
    }

    public sealed interface StatusCodeResponseDeserializer permits StatusVehiclesstatusdeviceidGetCode200ResponseDeserializer, StatusVehiclesstatusdeviceidGetCode400ResponseDeserializer, StatusVehiclesstatusdeviceidGetCode401ResponseDeserializer, StatusVehiclesstatusdeviceidGetCode404ResponseDeserializer, StatusVehiclesstatusdeviceidGetCode406ResponseDeserializer, StatusVehiclesstatusdeviceidGetCode500ResponseDeserializer {}

    public static final class StatusVehiclesstatusdeviceidGetCode200ResponseDeserializer extends VehiclesstatusdeviceidGetCode200Response.VehiclesstatusdeviceidGetCode200Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesstatusdeviceidGetCode400ResponseDeserializer extends VehiclesstatusdeviceidGetCode400Response.VehiclesstatusdeviceidGetCode400Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesstatusdeviceidGetCode401ResponseDeserializer extends VehiclesstatusdeviceidGetCode401Response.VehiclesstatusdeviceidGetCode401Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesstatusdeviceidGetCode404ResponseDeserializer extends VehiclesstatusdeviceidGetCode404Response.VehiclesstatusdeviceidGetCode404Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesstatusdeviceidGetCode406ResponseDeserializer extends VehiclesstatusdeviceidGetCode406Response.VehiclesstatusdeviceidGetCode406Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesstatusdeviceidGetCode500ResponseDeserializer extends VehiclesstatusdeviceidGetCode500Response.VehiclesstatusdeviceidGetCode500Response1 implements StatusCodeResponseDeserializer {
    }

    public static final class VehiclesstatusdeviceidGetResponses1 implements ResponsesDeserializer<EndpointResponse> {
        private final Map<String, StatusCodeResponseDeserializer> statusCodeToResponseDeserializer;
        public VehiclesstatusdeviceidGetResponses1() {
            this.statusCodeToResponseDeserializer = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("200", new StatusVehiclesstatusdeviceidGetCode200ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("400", new StatusVehiclesstatusdeviceidGetCode400ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("401", new StatusVehiclesstatusdeviceidGetCode401ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("404", new StatusVehiclesstatusdeviceidGetCode404ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("406", new StatusVehiclesstatusdeviceidGetCode406ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("500", new StatusVehiclesstatusdeviceidGetCode500ResponseDeserializer())
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
            if (statusCodeDeserializer instanceof StatusVehiclesstatusdeviceidGetCode200ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                return new EndpointVehiclesstatusdeviceidGetCode200Response(response, deserializedResponse.body(), deserializedResponse.headers());
            } else if (statusCodeDeserializer instanceof StatusVehiclesstatusdeviceidGetCode400ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesstatusdeviceidGetCode400Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusVehiclesstatusdeviceidGetCode401ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesstatusdeviceidGetCode401Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusVehiclesstatusdeviceidGetCode404ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesstatusdeviceidGetCode404Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusVehiclesstatusdeviceidGetCode406ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesstatusdeviceidGetCode406Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else {
                StatusVehiclesstatusdeviceidGetCode500ResponseDeserializer castDeserializer = (StatusVehiclesstatusdeviceidGetCode500ResponseDeserializer) statusCodeDeserializer;
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesstatusdeviceidGetCode500Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            }
        }
    }
}
