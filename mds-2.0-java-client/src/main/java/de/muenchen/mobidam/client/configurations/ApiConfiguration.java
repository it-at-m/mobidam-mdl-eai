package org.openapijsonschematools.client.configurations;

import org.openapijsonschematools.client.servers.Server;
import org.openapijsonschematools.client.RootServerInfo;
import org.openapijsonschematools.client.securityschemes.SecurityScheme;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.HashMap;

public class ApiConfiguration {
    private final ServerInfo serverInfo;
    private final ServerIndexInfo serverIndexInfo;
    private final @Nullable Duration timeout;
    private final Map<Class<? extends SecurityScheme>, SecurityScheme> securitySchemeInfo;
    private final Map<String, List< String>> defaultHeaders;

    public ApiConfiguration() {
        serverInfo = new ServerInfoBuilder().build();
        serverIndexInfo = new ServerIndexInfoBuilder().build();
        securitySchemeInfo = new HashMap<>();
        timeout = null;
        defaultHeaders = new HashMap<>();
    }

    public ApiConfiguration(ServerInfo serverInfo, ServerIndexInfo serverIndexInfo, List<SecurityScheme> securitySchemes, Duration timeout, Map<String, List< String>> defaultHeaders) {
        this.serverInfo = serverInfo;
        this.serverIndexInfo = serverIndexInfo;
        securitySchemeInfo = new HashMap<>();
        for (SecurityScheme securityScheme: securitySchemes) {
            securitySchemeInfo.put(securityScheme.getClass(), securityScheme);
        }
        this.timeout = timeout;
        this.defaultHeaders = defaultHeaders;
    }

    public static class ServerInfo {
        final RootServerInfo.RootServerInfo1 rootServerInfo;

        ServerInfo(
            RootServerInfo. @Nullable RootServerInfo1 rootServerInfo
        ) {
            this.rootServerInfo = Objects.requireNonNullElse(rootServerInfo, new RootServerInfo.RootServerInfoBuilder().build());
        }
    }

    public static class ServerInfoBuilder {
        private RootServerInfo. @Nullable RootServerInfo1 rootServerInfo;
        public ServerInfoBuilder() {}

        public ServerInfoBuilder rootServerInfo(RootServerInfo.RootServerInfo1 rootServerInfo) {
            this.rootServerInfo = rootServerInfo;
            return this;
        }

        public ServerInfo build() {
            return new ServerInfo(
                rootServerInfo
            );
        }
    }

    public static class ServerIndexInfo {
        final RootServerInfo.ServerIndex rootServerInfoServerIndex;

        ServerIndexInfo(
            RootServerInfo. @Nullable ServerIndex rootServerInfoServerIndex
        ) {
            this.rootServerInfoServerIndex = Objects.requireNonNullElse(rootServerInfoServerIndex, RootServerInfo.ServerIndex.SERVER_0);
        }
    }

    public static class ServerIndexInfoBuilder {
        private RootServerInfo. @Nullable ServerIndex rootServerInfoServerIndex;
        public ServerIndexInfoBuilder() {}

        public ServerIndexInfoBuilder rootServerInfoServerIndex(RootServerInfo.ServerIndex serverIndex) {
            this.rootServerInfoServerIndex = serverIndex;
            return this;
        }

        public ServerIndexInfo build() {
            return new ServerIndexInfo(
                rootServerInfoServerIndex
            );
        }
    }

    public Server getServer(RootServerInfo. @Nullable ServerIndex serverIndex) {
        var serverProvider = serverInfo.rootServerInfo;
        if (serverIndex == null) {
            RootServerInfo.ServerIndex configServerIndex = serverIndexInfo.rootServerInfoServerIndex;
            return serverProvider.getServer(configServerIndex);
        }
        return serverProvider.getServer(serverIndex);
    }

    public SecurityScheme getSecurityScheme(Class<? extends SecurityScheme> securitySchemeClass) {
        @Nullable SecurityScheme securityScheme = securitySchemeInfo.get(securitySchemeClass);
        if (securityScheme == null) {
            throw new RuntimeException("SecurityScheme of class " + securitySchemeClass + "cannot be returned because it is unset. Pass in an instance of it in securitySchemes when instantiating ApiConfiguration.");
        }
        return securityScheme;
    }

    public Map<String, List< String>> getDefaultHeaders() {
        return defaultHeaders;
    }

    public @Nullable Duration getTimeout() {
        return timeout;
    }
}