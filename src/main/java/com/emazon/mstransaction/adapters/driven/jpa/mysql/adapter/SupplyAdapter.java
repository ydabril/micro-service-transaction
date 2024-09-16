package com.emazon.mstransaction.adapters.driven.jpa.mysql.adapter;

import com.emazon.mstransaction.adapters.driven.jpa.mysql.mapper.ISupplyEntityMapper;
import com.emazon.mstransaction.adapters.driven.jpa.mysql.repository.ISupplyRepository;
import com.emazon.mstransaction.adapters.driven.jpa.mysql.util.FeignErrorUtil;
import com.emazon.mstransaction.adapters.driven.jpa.mysql.util.exception.StockUpdateException;
import com.emazon.mstransaction.domain.model.Supply;
import com.emazon.mstransaction.domain.spi.ISupplyPersistencePort;
import com.emazon.mstransaction.infraestructure.feign_client.StockFeignClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SupplyAdapter implements ISupplyPersistencePort {
    private final ISupplyEntityMapper supplyEntityMapper;
    private final ISupplyRepository supplyRepository;
    private final StockFeignClient stockFeignClient;
    @Override
    public void addSupply(Supply supply) {
        try {
            stockFeignClient.updateStock(supply);
        } catch (FeignException e){
            String content = e.contentUTF8();
            String errorMessage = FeignErrorUtil.extractErrorMessage(content);
            throw new StockUpdateException(errorMessage);
        }

        supplyRepository.save(supplyEntityMapper.toEntity(supply));
    }
}
