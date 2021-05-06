package com.marinin.core_to_boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AnotherConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
