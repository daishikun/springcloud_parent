package com.dsk.controller;

import com.dsk.entity.Order;
import com.dsk.vos.CollectionVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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


    // 对象的接收  @RequestParam("order") form 必须传文件格式
    @PostMapping("/test2")
    public String test2(@RequestBody  Order order){
        log.info(order.toString());
        return "order端口是 "+port;
    }


    // 接受数组类型  /test?ids=21&ids=22
    @GetMapping("/test3")
    public String test3(@RequestParam("ids") String[] ids){
        for (String id : ids) {
            log.info("id:{}",id);
        }
        return "test3 ok order端口是 "+port;
    }

    // 不能直接接受集合类型，必须放入对象  vo  value object 值对象
    // dto  data transfer(传输) object：数据传输对象
    // 暂时有问题
    @GetMapping("/test4")
    public String test4(CollectionVO collectionVO){
        for (String id : collectionVO.getIds()) {
            log.info("id:{}",id);
        }
        return "test4 ok order端口是 "+port;
    }


    // 返回对象
    @PostMapping("/test5")
    public Order test5(@RequestBody  Order order){
        log.info(order.toString());
        return order;
    }
    @GetMapping("demo")
    //熔断之后的处理
    //@HystrixCommand(fallbackMethod = "demoFallback")
    @HystrixCommand(defaultFallback = "defaultFallback")
    public String demo(Integer id){
        System.out.println("demo ok");
        if (id<=0){
            throw new RuntimeException("无效id");
        }
        return "demo ok";
    }
    public String demoFallback(Integer id){
        return "活动过于火爆，服务熔断";

    }

    public String defaultFallback(){
        return "默认的，活动过于火爆，服务熔断";
    }

}
