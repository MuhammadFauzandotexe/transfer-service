package org.zan.tranferservice.remote.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.zan.tranferservice.configuration.interceptor.FeignConfiguration;
import org.zan.tranferservice.remote.dto.ResponseDataDTO;

/**
 * This interface defines a Feign client for interacting with a sample CRUD service.
 * It provides methods for retrieving order information by ID.
 * The client is configured using the values specified in the "${app.config.client}" property
 * for the Feign client name and the base URL from the "Constant.SAMPLE_CLIENT_BASE_URL" constant.
 *
 * @author :Muhammad Fauzan
 */
@Service
@FeignClient(name = "SampleCrudClient", url = "${sample.client.base.url}", configuration = FeignConfiguration.class)
public interface SampleCrudClient {

    /**
     * Retrieves order information by its unique identifier.
     *
     * @param id The ID of the order to retrieve.
     * @return A {@link ResponseDataDTO} containing the order data.
     */
    @GetMapping("/order/{id}")
    ResponseDataDTO getOrderById(@PathVariable("id") String id);
}

