package de.muenchen.mobidam.client;

import de.muenchen.mobidam.client.gen.api.DefaultApi;
import de.muenchen.mobidam.client.gen.mds.ApiClient;
import de.muenchen.mobidam.config.InterfaceDTO;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.ProxyProvider;

public class ProviderApi extends DefaultApi {

    public ProviderApi(InterfaceDTO providerConfig, ProxyConfig proxyConfig) {

        HttpClient httpClient = HttpClient.create()
                .proxy(proxy -> proxy.type(ProxyProvider.Proxy.HTTP)
                        .host(proxyConfig.getProxyAuthHost())
                        .port(proxyConfig.getProxyAuthPort()));

        ApiClient apiClient = new ApiClient(WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(providerConfig.getUrl())
                .codecs(configurer ->
                        configurer.defaultCodecs().maxInMemorySize(providerConfig.getDownloadMaxMb() * 1024 * 1024))
                .build());
        apiClient.setBasePath(providerConfig.getUrl());
        super.setApiClient(apiClient);
    }
}
