package com.ilyassan.mediahub.user.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    // @LoadBalanced: tells Spring Cloud to intercept WebClient calls and resolve
    // service names (like "media-service") through Eureka, just like OpenFeign does.
    // Without this, "http://media-service/media" would fail because it's not a real hostname.
    @Bean
    @LoadBalanced
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
