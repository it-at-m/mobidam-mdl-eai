/*
 * The MIT License
 * Copyright © 2024 Landeshauptstadt München | it@M
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.muenchen.mobidam.client;

import de.muenchen.mobidam.client.gen.api.DefaultApi;
import de.muenchen.mobidam.config.InterfaceDTO;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ProviderCache {

    private final TokenCache tokenCache;
    private final TokenApiCache tokenApiCache;
    private final Map<String, DefaultApi> providers = new HashMap<String, DefaultApi>();
    private InterfaceDTO providerInterface;
    private String providerIdentifier;
    private final ProxyConfig proxyConfig;

    public ProviderCache(TokenCache tokenCache, TokenApiCache tokenApiCache, ProxyConfig proxyConfig) {
        this.tokenCache = tokenCache;
        this.tokenApiCache = tokenApiCache;
        this.proxyConfig = proxyConfig;
    }

    public Optional<DefaultApi> getProvider(InterfaceDTO providerInterface) {

        this.providerInterface = providerInterface;
        this.providerIdentifier = providerInterface.getIdentifier();

        log.debug("Process provider '{}' provision started ...", providerIdentifier);

        Optional<DefaultApi> provider = Optional.ofNullable(providers.get(providerIdentifier));
        provider.ifPresentOrElse(this::checkToken, this::createNewProvider);

        log.debug("Process provider '{}' provision end.", providerIdentifier);
        return Optional.of(providers.get(providerInterface.getIdentifier()));
    }

    private void checkToken(@NotNull DefaultApi tokenApi) {

        var token = tokenCache.getToken(this.providerIdentifier);
        token.ifPresentOrElse(this::provideToken, this::provideNewToken);
    }

    private void provideToken(@NotNull PostToken200Response postToken200Response) {

        if (postToken200Response.isValid())
            return;

        provideNewToken();
    }

    private void provideNewToken() {

        Optional<TokenApi> tokenApi = this.tokenApiCache.getTokenApi(this.providerIdentifier);

        tokenApi.ifPresent(api -> {
            PostToken200Response token = api.getToken();
            Optional<DefaultApi> provider = Optional.ofNullable(this.providers.get(this.providerIdentifier));
            provider.ifPresent(p -> p.getApiClient().setBearerToken(token.getAccessToken()));
            this.tokenCache.registerProviderIdentifierToken(this.providerIdentifier, token);

        });
    }

    private void createNewProvider() {

        tokenApiCache.registerProviderIdentifierApi(this.providerIdentifier, new TokenApi(this.providerInterface.getCredentials(), this.proxyConfig));
        providers.put(this.providerIdentifier, new ProviderApi(this.providerInterface, this.proxyConfig));
        provideNewToken();
    }
}
