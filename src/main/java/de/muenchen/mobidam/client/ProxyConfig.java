package de.muenchen.mobidam.client;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "camel.component.http")
@Getter
@Setter
public class ProxyConfig {

    private String proxyAuthHost;
    private Integer proxyAuthPort;
    private String proxyAuthScheme;

}
