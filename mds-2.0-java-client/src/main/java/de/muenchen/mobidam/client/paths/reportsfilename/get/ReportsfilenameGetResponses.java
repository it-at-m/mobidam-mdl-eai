package org.openapijsonschematools.client.paths.reportsfilename.get;

import org.openapijsonschematools.client.paths.reportsfilename.get.responses.ReportsfilenameGetCode200Response;
import org.openapijsonschematools.client.paths.reportsfilename.get.responses.ReportsfilenameGetCode401Response;
import org.openapijsonschematools.client.paths.reportsfilename.get.responses.ReportsfilenameGetCode404Response;
import org.openapijsonschematools.client.paths.reportsfilename.get.responses.ReportsfilenameGetCode500Response;
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

public class ReportsfilenameGetResponses {
    public sealed interface EndpointResponse permits EndpointReportsfilenameGetCode200Response {}

    public record EndpointReportsfilenameGetCode200Response(
        HttpResponse<byte[]> response,
        ReportsfilenameGetCode200Response.SealedResponseBody body,
        Void headers
    ) implements EndpointResponse, ApiResponse<ReportsfilenameGetCode200Response.SealedResponseBody, Void>{
    }

    public sealed interface StatusCodeResponseDeserializer permits StatusReportsfilenameGetCode200ResponseDeserializer, StatusReportsfilenameGetCode401ResponseDeserializer, StatusReportsfilenameGetCode404ResponseDeserializer, StatusReportsfilenameGetCode500ResponseDeserializer {}

    public static final class StatusReportsfilenameGetCode200ResponseDeserializer extends ReportsfilenameGetCode200Response.ReportsfilenameGetCode200Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusReportsfilenameGetCode401ResponseDeserializer extends ReportsfilenameGetCode401Response.ReportsfilenameGetCode401Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusReportsfilenameGetCode404ResponseDeserializer extends ReportsfilenameGetCode404Response.ReportsfilenameGetCode404Response1 implements StatusCodeResponseDeserializer {
    }
    public static final class StatusReportsfilenameGetCode500ResponseDeserializer extends ReportsfilenameGetCode500Response.ReportsfilenameGetCode500Response1 implements StatusCodeResponseDeserializer {
    }

    public static final class ReportsfilenameGetResponses1 implements ResponsesDeserializer<EndpointResponse> {
        private final Map<String, StatusCodeResponseDeserializer> statusCodeToResponseDeserializer;
        public ReportsfilenameGetResponses1() {
            this.statusCodeToResponseDeserializer = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("200", new StatusReportsfilenameGetCode200ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("401", new StatusReportsfilenameGetCode401ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("404", new StatusReportsfilenameGetCode404ResponseDeserializer()),
                new AbstractMap.SimpleEntry<>("500", new StatusReportsfilenameGetCode500ResponseDeserializer())
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
            if (statusCodeDeserializer instanceof StatusReportsfilenameGetCode200ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                return new EndpointReportsfilenameGetCode200Response(response, deserializedResponse.body(), deserializedResponse.headers());
            } else if (statusCodeDeserializer instanceof StatusReportsfilenameGetCode401ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new ReportsfilenameGetCode401Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else if (statusCodeDeserializer instanceof StatusReportsfilenameGetCode404ResponseDeserializer castDeserializer) {
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new ReportsfilenameGetCode404Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            } else {
                StatusReportsfilenameGetCode500ResponseDeserializer castDeserializer = (StatusReportsfilenameGetCode500ResponseDeserializer) statusCodeDeserializer;
                var deserializedResponse = castDeserializer.deserialize(response, configuration);
                throw new ReportsfilenameGetCode500Response.ResponseApiException(
                    "Received error statusCode response from server",
                    response,
                    deserializedResponse
                );
            }
        }
    }
}
