package com.dsk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient//开启服务注册
@EnableFeignClients //开启openfeign
@EnableCircuitBreaker  // hystrix服务熔断
public class UsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class,args);
    }
}
