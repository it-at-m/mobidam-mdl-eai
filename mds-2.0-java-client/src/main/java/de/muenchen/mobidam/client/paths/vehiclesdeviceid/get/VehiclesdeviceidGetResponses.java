package org.openapijsonschematools.client.paths.vehiclesdeviceid.get;

import org.openapijsonschematools.client.paths.vehiclesdeviceid.get.responses.VehiclesdeviceidGetCode200Response;
import org.openapijsonschematools.client.paths.vehiclesdeviceid.get.responses.VehiclesdeviceidGetCode400Response;
import org.openapijsonschematools.client.paths.vehiclesdeviceid.get.responses.VehiclesdeviceidGetCode401Response;
import org.openapijsonschematools.client.paths.vehiclesdeviceid.get.responses.VehiclesdeviceidGetCode404Response;
import org.openapijsonschematools.client.paths.vehiclesdeviceid.get.responses.VehiclesdeviceidGetCode406Response;
import org.openapijsonschematools.client.paths.vehiclesdeviceid.get.responses.VehiclesdeviceidGetCode500Response;
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

public class VehiclesdeviceidGetResponses {
    public sealed interface EndpointResponse permits EndpointVehiclesdeviceidGetCode200Response {}

    public record EndpointVehiclesdeviceidGetCode200Response(
        HttpResponse<byte[]> response,
        VehiclesdeviceidGetCode200Response.SealedResponseBody body,
        Void headers
    ) implements EndpointResponse, ApiResponse<VehiclesdeviceidGetCode200Response.SealedResponseBody, Void>{
    }

    public sealed interface StatusCodeResponseDeserializer permits StatusVehiclesdeviceidGetCode200ResponseDeserializer, StatusVehiclesdeviceidGetCode400ResponseDeserializer, StatusVehiclesdeviceidGetCode401ResponseDeserializer, StatusVehiclesdeviceidGetCode404ResponseDeserializer, StatusVehiclesdeviceidGetCode406ResponseDeserializer, StatusVehiclesdeviceidGetCode500ResponseDeserializer {}

    public static final class StatusVehiclesdeviceidGetCode200ResponseDeserializer extends VehiclesdeviceidGetCode200Response.VehiclesdeviceidGetCode200Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesdeviceidGetCode400ResponseDeserializer extends VehiclesdeviceidGetCode400Response.VehiclesdeviceidGetCode400Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesdeviceidGetCode401ResponseDeserializer extends VehiclesdeviceidGetCode401Response.VehiclesdeviceidGetCode401Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesdeviceidGetCode404ResponseDeserializer extends VehiclesdeviceidGetCode404Response.VehiclesdeviceidGetCode404Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesdeviceidGetCode406ResponseDeserializer extends VehiclesdeviceidGetCode406Response.VehiclesdeviceidGetCode406Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusVehiclesdeviceidGetCode500ResponseDeserializer extends VehiclesdeviceidGetCode500Response.VehiclesdeviceidGetCode500Response1 implements StatusCodeResponseDeserializer {
    }

    public static final class VehiclesdeviceidGetResponses1 implements ResponsesDeserializer<EndpointResponse> {
        private final Map<String, StatusCodeResponseDeserializer> statusCodeToResponseDeserializer;
        public VehiclesdeviceidGetResponses1() {
            this.statusCodeToResponseDeserializer = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("200", new StatusVehiclesdeviceidGetCode200ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("400", new StatusVehiclesdeviceidGetCode400ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("401", new StatusVehiclesdeviceidGetCode401ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("404", new StatusVehiclesdeviceidGetCode404ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("406", new StatusVehiclesdeviceidGetCode406ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("500", new StatusVehiclesdeviceidGetCode500ResponseDeserializer())
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
            if (statusCodeDeserializer instanceof StatusVehiclesdeviceidGetCode200ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                return new EndpointVehiclesdeviceidGetCode200Response(response, deserializedResponse.body(), deserializedResponse.headers());
            } else if (statusCodeDeserializer instanceof StatusVehiclesdeviceidGetCode400ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesdeviceidGetCode400Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusVehiclesdeviceidGetCode401ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesdeviceidGetCode401Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusVehiclesdeviceidGetCode404ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesdeviceidGetCode404Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusVehiclesdeviceidGetCode406ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesdeviceidGetCode406Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else {
                StatusVehiclesdeviceidGetCode500ResponseDeserializer castDeserializer = (StatusVehiclesdeviceidGetCode500ResponseDeserializer) statusCodeDeserializer;
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new VehiclesdeviceidGetCode500Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            }
        }
    }
}
