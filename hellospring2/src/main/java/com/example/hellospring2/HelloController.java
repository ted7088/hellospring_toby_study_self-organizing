package com.example.hellospring2;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;


@RestController
public class HelloController implements ApplicationContextAware {
    private final HelloService helloService;
    public HelloController(HelloService helloService ) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name){
//        SimpleHelloService helloService=new SimpleHelloService();
//        return helloService.sayhello(name);
        return helloService.sayhello(Objects.requireNonNull(name));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);
    }
}
