package com.dsk.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

@Configuration
public class GateWayConfig {
/*
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("order_route",r->r.path("/order")
                        .uri("http://localhost:9990"))
                .build();
    }
    */
public static void main(String[] args) {
    System.out.println(ZonedDateTime.now());
}
}
