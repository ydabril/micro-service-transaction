package com.emazon.mstransaction.adapters;

import com.emazon.mstransaction.adapters.driven.jpa.mysql.adapter.SupplyAdapter;
import com.emazon.mstransaction.adapters.driven.jpa.mysql.entity.SupplyEntity;
import com.emazon.mstransaction.adapters.driven.jpa.mysql.mapper.ISupplyEntityMapper;
import com.emazon.mstransaction.adapters.driven.jpa.mysql.repository.ISupplyRepository;
import com.emazon.mstransaction.adapters.driven.jpa.mysql.util.exception.StockUpdateException;
import com.emazon.mstransaction.domain.model.Supply;
import com.emazon.mstransaction.infraestructure.feign_client.StockFeignClient;
import feign.FeignException;
import feign.Request;
import feign.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SupplyAdapterTests {
    @Mock
    private ISupplyEntityMapper supplyEntityMapper;

    @Mock
    private ISupplyRepository supplyRepository;

    @Mock
    private StockFeignClient stockFeignClient;

    @InjectMocks
    private SupplyAdapter supplyAdapter;

    @Test
    void addSupply_ShouldCallStockFeignClientAndSaveSupply() {
        // Arrange
        Supply supply = new Supply(1L, 10L, null, null);
        SupplyEntity supplyEntity = new SupplyEntity();

        // Simula el comportamiento del mapper y repositorio
        when(supplyEntityMapper.toEntity(supply)).thenReturn(supplyEntity);
        when(supplyRepository.save(supplyEntity)).thenReturn(supplyEntity);

        // Act
        supplyAdapter.addSupply(supply);

        // Assert
        verify(stockFeignClient).updateStock(supply);
        verify(supplyEntityMapper).toEntity(supply);
        verify(supplyRepository).save(supplyEntity);
    }
}
