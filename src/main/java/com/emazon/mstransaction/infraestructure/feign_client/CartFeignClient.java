package com.emazon.mstransaction.infraestructure.feign_client;

import com.emazon.mstransaction.domain.model.Article;
import com.emazon.mstransaction.domain.model.Supply;
import com.emazon.mstransaction.infraestructure.Constants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = Constants.CART_SERVICE_NAME, url = Constants.CART_SERVICE_URL, configuration = FeignConfig.class)
public interface CartFeignClient {

    @PutMapping("/article/update")
    void updateStock(@RequestBody Supply supply);

    @DeleteMapping("/cart/delete-article/{id}")
    void deleteArticleCart(@PathVariable("id") Long id);
}
