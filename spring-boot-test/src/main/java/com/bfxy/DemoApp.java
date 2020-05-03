package com.bfxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApp {


    @Value("${name}")
    private static String name;
    public static void main(String[] args) {
        System.out.println(name);
        SpringApplication.run(DemoApp.class, args);
        System.out.println(name);
    }
}
