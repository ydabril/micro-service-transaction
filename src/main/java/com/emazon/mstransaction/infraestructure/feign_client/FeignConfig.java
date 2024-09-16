package com.emazon.mstransaction.infraestructure.feign_client;

import com.emazon.mstransaction.infraestructure.configuration.interceptors.FeignClientInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public FeignClientInterceptor customFeignClientInterceptor() {
        return new FeignClientInterceptor();
    }
}