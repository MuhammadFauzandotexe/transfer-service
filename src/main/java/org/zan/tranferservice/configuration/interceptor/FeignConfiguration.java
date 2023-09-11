package org.zan.tranferservice.configuration.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    @Bean
    public FeignInterceptor myFeignInterceptor() {
        return new FeignInterceptor();
    }
}