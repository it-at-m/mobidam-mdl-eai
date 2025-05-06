package de.muenchen.mobidam.client;

import de.muenchen.mobidam.config.InterfaceCredentialsDTO;

import java.time.Duration;
import java.util.Base64;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.ProxyProvider;

  public class TokenApi {

    WebClient webClient;
    InterfaceCredentialsDTO credentials;

    public TokenApi(InterfaceCredentialsDTO credentials, ProxyConfig proxyConfig) {

        this.credentials = credentials;

        HttpClient httpClient = HttpClient.create()
                .proxy(proxy -> proxy.type(ProxyProvider.Proxy.HTTP)
                        .host(proxyConfig.getProxyAuthHost())
                        .port(proxyConfig.getProxyAuthPort()));

        webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(credentials.getUrl())
                .build();

    }

    public PostToken200Response getToken() {

        return webClient.post()
                .uri("/")
                .header("Authorization", "Basic " + encodeCredentials(credentials.getUserId(), credentials.getPassword())) // Füge den Authorization Header für Basic Auth hinzu
                .body(BodyInserters.fromFormData("grant_type", "client_credentials"))
                .retrieve()
                .bodyToMono(PostToken200Response.class)
                .timeout(Duration.ofSeconds(10))
                .block();
    }

    private String encodeCredentials(String username, String password) {
        String credentials = username + ":" + password;
        return Base64.getEncoder().encodeToString(credentials.getBytes());
    }

}
