package org.zan.tranferservice.configuration.interceptor;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;


@Slf4j
public class FeignInterceptor implements RequestInterceptor {
    @Value("${authorization}")
    private String authorization;
    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", authorization);
        log.info("Request Headers: {}", template.headers());
    }
}
