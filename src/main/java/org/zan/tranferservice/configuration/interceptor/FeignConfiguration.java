package org.zan.tranferservice.configuration.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Feign client interceptors.
 * This class defines a Spring configuration bean for registering a custom Feign interceptor.
 * The {@link FeignInterceptor} bean is created and registered with the Spring application context.
 * To use this configuration, you can annotate your Feign client interfaces with
 * {@link org.springframework.cloud.openfeign.FeignClient} and specify the name of the
 * interceptor bean, like this:
 * {@literal @}FeignClient(name = "myFeignInterceptor", url = "https://example.com")
 *
 * @see FeignInterceptor
 * @author :Muhammad Fauzan
 */
@Configuration
public class FeignConfiguration {
    /**
     * Creates and registers a custom Feign interceptor bean.
     *
     * @return The custom Feign interceptor bean.
     */
    @Bean
    public FeignInterceptor myFeignInterceptor() {
        return new FeignInterceptor();
    }
}
