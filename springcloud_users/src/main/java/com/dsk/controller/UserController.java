package com.dsk.controller;

import com.dsk.entity.Order;
import com.dsk.feignclient.OrdersClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;//服务注册与发现的客户端对象

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    
    @Autowired
    private OrdersClient ordersClient;

    @GetMapping
    public Order demo(){

        log.info("user demo");
        // http://localhost:9999/order
        //1. RestTemplate restTemplate = new RestTemplate();
        //String orderResult = restTemplate.getForObject("http://localhost:9999/order",String.class);
        //2. 使用robbin+restTemplate实现负载均衡调用

        // List<ServiceInstance> orders = discoveryClient.getInstances("ORDERS");
        //orders.forEach(serviceInstance -> {

            //log.info("服务的主机{}\n服务的端口{}\n服务的地址{}",serviceInstance.getHost(),
           //         serviceInstance.getPort(),serviceInstance.getUri());
        //});

        // 3. 使用loadBalancerClient进行服务调用 默认轮询策略
        ServiceInstance serviceInstance = loadBalancerClient.choose("ORDERS");
       // log.info("服务的主机{}\n服务的端口{}\n服务的地址{}",serviceInstance.getHost(),
        //         serviceInstance.getPort(),serviceInstance.getUri());

       // String orderResult = restTemplate.getForObject(serviceInstance.getUri()+"/order",String.class);
       // 4.使用loadBanlance注解让对象具有负载均衡特性

       // String orderResult = restTemplate.getForObject("http://ORDERS/order", String.class);

        // 5.feigen 
        //String orderResult = ordersClient.orderDemo();
       // String orderResult = ordersClient.test("小代",25);
        // String orderResult = ordersClient.test1(1,"代");


        Order order = new Order();
        order.setId(100);
        order.setName("代柿焜");
       // String orderResult = ordersClient.test2(order);



        //String orderResult = ordersClient.test3(new String[]{"1","2","3"});

       // String orderResult = ordersClient.test4(new String[]{"1","2","3"});
        //log.info(orderResult);
       // return orderResult;

        return ordersClient.test5(order);
    }
}
