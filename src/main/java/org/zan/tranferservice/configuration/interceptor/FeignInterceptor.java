package org.zan.tranferservice.configuration.interceptor;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

/**
 * Custom Feign interceptor for adding an "Authorization" header to outgoing requests.
 * This interceptor is responsible for attaching an authorization token to the HTTP headers
 * of Feign client requests.
 * The authorization token is obtained from the Spring configuration properties using the
 * {@code authorization} property.
 * Example usage in a Feign client interface:
 * {@literal @}FeignClient(name = "myFeignInterceptor", url = "https://example.com")
 * public interface MyFeignClient {
 *     // ...
 * }
 *
 * @see RequestInterceptor
 * @author :Muhammad Fauzan
 */
@Slf4j

public class FeignInterceptor implements RequestInterceptor {
//    @Value("${authorization}")
    private final static String authorization = "authorization";

    /**
     * Applies the interceptor by adding the "Authorization" header to the request template.
     *
     * @param template The Feign request template to which the "Authorization" header is added.
     */
    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", authorization);
        log.info("Request Headers: {}", template.headers());
    }
}

