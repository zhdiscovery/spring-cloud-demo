package com.zh.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced//这个注解赋予restTemplate负载均衡的能力
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
