package com.emazon.mstransaction.infraestructure.feign_client;

import com.emazon.mstransaction.domain.model.Supply;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "stock-service", url = "http://localhost:8081", configuration = FeignConfig.class)
public interface StockFeignClient {

    @PutMapping("/article/update")
    void updateStock(@RequestBody Supply supply);
}