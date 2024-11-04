package org.openapijsonschematools.client.paths.reportsfilename.get.responses;

import org.openapijsonschematools.client.configurations.SchemaConfiguration;
import org.openapijsonschematools.client.response.ResponseDeserializer;
import org.openapijsonschematools.client.response.DeserializedHttpResponse;
import org.openapijsonschematools.client.exceptions.ApiException;
import org.openapijsonschematools.client.exceptions.ValidationException;
import org.openapijsonschematools.client.exceptions.NotImplementedException;
import org.openapijsonschematools.client.mediatype.MediaType;
import org.openapijsonschematools.client.paths.reportsfilename.get.responses.code200response.content.textcsv.TextcsvSchema2;

import java.util.AbstractMap;
import java.util.Map;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;

public class ReportsfilenameGetCode200Response {
    public sealed interface SealedMediaType permits TextcsvMediaType {}

    public record TextcsvMediaType(TextcsvSchema2.TextcsvSchema3 schema) implements SealedMediaType, MediaType<TextcsvSchema2.TextcsvSchema3, Void> {
        public TextcsvMediaType() {
            this(TextcsvSchema2.TextcsvSchema3.getInstance());
        }
        @Override
        public Void encoding() {
            return null;
        }
    }
    public sealed interface SealedResponseBody permits TextcsvResponseBody {}
    public record TextcsvResponseBody(TextcsvSchema2.Report1Boxed body) implements SealedResponseBody { }

    public static class ReportsfilenameGetCode200Response1 extends ResponseDeserializer<SealedResponseBody, Void, SealedMediaType> {
        public ReportsfilenameGetCode200Response1() {
            super(
                Map.ofEntries(
                    new AbstractMap.SimpleEntry<>("text/csv", new TextcsvMediaType())
                )
            );
        }

        @Override
        protected SealedResponseBody getBody(String contentType, SealedMediaType mediaType, byte[] body, SchemaConfiguration configuration) throws ValidationException, NotImplementedException {
            TextcsvMediaType thisMediaType = (TextcsvMediaType) mediaType;
            var deserializedBody = deserializeBody(contentType, body, thisMediaType.schema(), configuration);
            return new TextcsvResponseBody(deserializedBody);
        }

        @Override
        protected Void getHeaders(HttpHeaders headers, SchemaConfiguration configuration) {
            return null;
        }
    }

    @SuppressWarnings("serial")
    public static class ResponseApiException extends ApiException {
        public DeserializedHttpResponse<SealedResponseBody, Void> deserializedResponse;

        public ResponseApiException(String s, HttpResponse<byte[]> response, DeserializedHttpResponse<SealedResponseBody, Void> deserializedResponse) {
            super(s, response);
            this.deserializedResponse = deserializedResponse;
        }
    }
}
