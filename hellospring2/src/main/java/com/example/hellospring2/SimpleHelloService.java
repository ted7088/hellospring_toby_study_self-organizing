package com.example.hellospring2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class SimpleHelloService implements HelloService {
    @Override
    public String sayhello(String name){
        return "Hello "+name;
    }
}
