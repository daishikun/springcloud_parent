package com.dsk.feignclient;

import com.dsk.feignclient.OrdersClient;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OrdersClientFallback implements OrdersClient {
    @Override
    public String demo(Integer id) {
        return id+"当前服务不可用";
    }
}
