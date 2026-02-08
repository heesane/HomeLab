package kr.nexus.core.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "nexus.security.remote.enabled", havingValue = "true")
public class RemoteSecurityConfig {

    @Value("${nexus.security.auth-service-url:http://nexus-auth:8081}")
    private String authServiceUrl;

    @Bean
    public RemoteAuthFilter remoteAuthFilter() {
        return new RemoteAuthFilter(authServiceUrl);
    }
}
