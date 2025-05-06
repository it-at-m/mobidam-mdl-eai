package de.muenchen.mobidam.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class TokenCache {

    private final Map<String, PostToken200Response> tokens = new HashMap<>();

    public Optional<PostToken200Response> getToken(String providerIdentifier) {
        return Optional.ofNullable(tokens.get(providerIdentifier));
    }

    public void registerProviderIdentifierToken(String providerIdentifier, PostToken200Response token) {
        tokens.put(providerIdentifier, token);
    }

}
