package com.example.gemini;

import feign.RequestInterceptor;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@EnableFeignClients
public class FeignConfig {
    @Bean
    public RequestInterceptor apiKeyInterceptor(@Value("${gemini.api.key}") String apiKey) {
        return requestTemplate -> requestTemplate.header("x-goog-api-key", apiKey);
    }
}
