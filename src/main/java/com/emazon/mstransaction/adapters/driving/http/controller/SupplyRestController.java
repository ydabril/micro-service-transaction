package com.emazon.mstransaction.adapters.driving.http.controller;

import com.emazon.mstransaction.adapters.driving.http.dto.request.AddSuppliesRequest;
import com.emazon.mstransaction.adapters.driving.http.mapper.ISupplyRequestMapper;
import com.emazon.mstransaction.domain.api.ISupplyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
@Validated
@RequiredArgsConstructor
public class SupplyRestController {
    private  final ISupplyServicePort supplyServicePort;
    private  final ISupplyRequestMapper supplyRequestMapper;
    @PreAuthorize("hasRole('AUX_BODEGA')")
    @GetMapping("/add-supplies")
    public ResponseEntity<Void> addSupplies(@RequestBody AddSuppliesRequest request) {
        supplyServicePort.addSupplies(supplyRequestMapper.addSupplyRequest(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
