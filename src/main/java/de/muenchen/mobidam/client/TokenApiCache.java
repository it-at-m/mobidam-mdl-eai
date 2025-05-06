package de.muenchen.mobidam.client;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class TokenApiCache {

    private final Map<String, TokenApi> tokenApis = new HashMap<String, TokenApi>();

    public Optional<TokenApi> getTokenApi(String providerIdentifier) {
        return Optional.ofNullable(tokenApis.get(providerIdentifier));
    }

    public void registerProviderIdentifierApi(String providerIdentifier, TokenApi api) {
        tokenApis.put(providerIdentifier, api);
    }
}
