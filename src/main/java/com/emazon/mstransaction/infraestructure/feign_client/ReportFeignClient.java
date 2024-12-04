package com.emazon.mstransaction.infraestructure.feign_client;

import com.emazon.mstransaction.domain.model.Report;
import com.emazon.mstransaction.domain.model.Supply;
import com.emazon.mstransaction.infraestructure.Constants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = Constants.REPORT_SERVICE_NAME, url = Constants.REPORT_SERVICE_URL, configuration = FeignConfig.class)
public interface ReportFeignClient {
    @PostMapping("/report/add")
    void addReport(@RequestBody Report report);
}
