package com.emazon.mstransaction.infraestructure.configuration;



import com.emazon.mstransaction.adapters.driven.jpa.mysql.adapter.SupplyAdapter;
import com.emazon.mstransaction.adapters.driven.jpa.mysql.mapper.ISupplyEntityMapper;
import com.emazon.mstransaction.adapters.driven.jpa.mysql.repository.ISupplyRepository;
import com.emazon.mstransaction.domain.spi.ISupplyPersistencePort;
import com.emazon.mstransaction.domain.api.ISupplyServicePort;
import com.emazon.mstransaction.domain.api.use_case.SupplyUseCase;
import com.emazon.mstransaction.infraestructure.feign_client.StockFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ISupplyRepository supplyRepository;
    private final ISupplyEntityMapper supplyEntityMapper;
    private final StockFeignClient stockFeignClient;
    @Bean
    public ISupplyPersistencePort supplyPersistencePort() {
        return new SupplyAdapter(supplyEntityMapper, supplyRepository, stockFeignClient);
    }
    @Bean
    public ISupplyServicePort supplyServicePort() {
        return new SupplyUseCase(supplyPersistencePort());
    }

}
