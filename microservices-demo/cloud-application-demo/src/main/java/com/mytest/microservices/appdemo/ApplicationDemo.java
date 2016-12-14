package com.mytest.microservices.appdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by jinwen on 2016/11/27.
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.mytest.microservices.service")
public class ApplicationDemo {
    public static void main(String[] args){
        SpringApplication.run(ApplicationDemo.class,args);
    }
}
