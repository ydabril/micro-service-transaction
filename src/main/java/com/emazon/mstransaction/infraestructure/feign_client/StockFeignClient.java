package com.emazon.mstransaction.infraestructure.feign_client;

import com.emazon.mstransaction.domain.model.Supply;
import com.emazon.mstransaction.infraestructure.Constants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = Constants.STOCK_SERVICE_NAME, url = Constants.STOCK_SERVICE_URL, configuration = FeignConfig.class)
public interface StockFeignClient {

    @PutMapping("/article/update")
    void updateStock(@RequestBody Supply supply);
}