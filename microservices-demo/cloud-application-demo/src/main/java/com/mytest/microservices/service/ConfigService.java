package com.mytest.microservices.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinwen on 2016/11/28.
 */

@RefreshScope
@RestController
public class ConfigService {
    @Value("${testkey1}")
    private String testkey1;

    @RequestMapping("/testconfig")
    public String testconfig() {
        return this.testkey1;
    }
}

