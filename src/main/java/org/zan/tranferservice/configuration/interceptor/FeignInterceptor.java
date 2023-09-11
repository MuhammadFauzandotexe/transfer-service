package org.zan.tranferservice.configuration.interceptor;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        log.info("Request Headers: {}", template.headers());
        template.header("Authorization", "Basic dXNlcm5hbWU6cGFzc3dvcmQ=");
    }
}
