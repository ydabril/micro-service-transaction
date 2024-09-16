package com.emazon.mstransaction.adapters.driving.http.controller;

import com.emazon.mstransaction.adapters.driving.http.dto.request.AddSuppliesRequest;
import com.emazon.mstransaction.adapters.driving.http.mapper.ISupplyRequestMapper;
import com.emazon.mstransaction.domain.api.ISupplyServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/transaction")
@Validated
@RequiredArgsConstructor
public class SupplyRestController {
    private  final ISupplyServicePort supplyServicePort;
    private  final ISupplyRequestMapper supplyRequestMapper;

    @PreAuthorize("hasRole('AUX_BODEGA')")
    @Operation(summary = "Add a supply", description = "Add new supplies to increase the stock of articles.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Supply successfully created and stock updated"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @PostMapping("/add-supplies")
    public ResponseEntity<Void> addSupplies(@Valid @RequestBody AddSuppliesRequest request) {
        supplyServicePort.addSupplies(supplyRequestMapper.addSupplyRequest(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
