package org.zan.tranferservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.zan.tranferservice.dto.ResponseDataDTO;

@FeignClient(name = "SampleCrudClient", url = "http://localhost:8080/api/v1")
public interface SampleCrudClient {
    @GetMapping("/order/{id}")
    ResponseDataDTO getOrderById(@PathVariable("id") Integer id);
}
