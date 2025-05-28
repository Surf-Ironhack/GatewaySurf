package com.Surf.gateway_surf.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator (RouteLocatorBuilder builder){
        return builder
                .routes()
                .route("monitors", r -> r.path("/monitors/**")
                        .uri("lb://monitors-surf"))
                .route("classes", r -> r.path("/classes/**")
                        .uri("lb://class-surf"))
                .build();
    }
}
