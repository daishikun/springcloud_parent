package com.dsk.feignclient;

import com.dsk.entity.Order;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//调用订单服务  服务id
@FeignClient(value = "ORDERS",fallback = OrdersClientFallback.class)
public interface OrdersClient {
/*
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


    // 数组类型
    @GetMapping("/order/test3")
    String test3(@RequestParam("ids") String[] ids);

    //@GetMapping("/order/test4")  test4?ids=xx&ids=xx
    //public String test4(List<String> ids)
    @GetMapping("/order/test4")
    String test4(@RequestParam("ids") String[] ids);

    // 返回值为对象
    @PostMapping("/order/test5")
    Order test5(@RequestBody  Order order);

*/

    @GetMapping("/order/demo")
    String demo(@RequestParam("id") Integer id);

}
