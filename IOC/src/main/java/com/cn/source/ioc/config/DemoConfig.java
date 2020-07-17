package com.cn.source.ioc.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {
    public String helloConfig() {
        return "Hello,DemoConfig";
    }
}
