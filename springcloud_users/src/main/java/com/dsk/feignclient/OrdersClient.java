package com.dsk.feignclient;


import com.dsk.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//调用订单服务  服务id
@FeignClient(value = "ORDERS")
public interface OrdersClient {

    // 调用商品服务
    @GetMapping("/order")
    String orderDemo();

    // 零散参数 @RequestParam
    @GetMapping("/order/test")
    String test(@RequestParam("name") String name, @RequestParam("age") Integer age);


    @GetMapping("/order/test1/{id}/{name}")
    String test1(@PathVariable("id") Integer id, @PathVariable("name") String name);


    // 对象接收
    @PostMapping("/order/test2")
    String test2(@RequestBody Order order);
}
