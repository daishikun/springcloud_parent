package com.dsk.controller;

import com.dsk.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Value("${server.port}")
    private String port;

    public static final Logger log = LoggerFactory.getLogger(OrderController.class);
    @GetMapping
    public String orderDemo(){
        log.info("order demo");
        return "order demo 端口是 "+port;
    }


    // 定义零散参数
    @GetMapping("/test")
    public String test(String name,Integer age){
        log.info("姓名{}-年龄{}",name,age);
        return "order端口是 "+port;
    }

    @GetMapping("/test1/{id}/{name}")
    public String test1(@PathVariable("id") Integer id,@PathVariable("name") String name){
        log.info("id:{}-名字:{}",id,name);
        return "order端口是 "+port;
    }


    // 对象的接收  @RequestParam("order") form
    @PostMapping("/test2")
    public String test2(@RequestBody  Order order){
        log.info(order.toString());
        return "order端口是 "+port;
    }
}
