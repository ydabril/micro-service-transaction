package com.emazon.mstransaction.adapters.driven.jpa.mysql.adapter;

import com.emazon.mstransaction.adapters.driven.jpa.mysql.entity.SupplyEntity;
import com.emazon.mstransaction.adapters.driven.jpa.mysql.mapper.ISupplyEntityMapper;
import com.emazon.mstransaction.adapters.driven.jpa.mysql.repository.ISupplyRepository;
import com.emazon.mstransaction.adapters.driven.jpa.mysql.util.FeignErrorUtil;
import com.emazon.mstransaction.adapters.driven.jpa.mysql.util.exception.StockUpdateException;
import com.emazon.mstransaction.domain.model.Article;
import com.emazon.mstransaction.domain.model.Report;
import com.emazon.mstransaction.domain.model.Supply;
import com.emazon.mstransaction.domain.spi.ISupplyPersistencePort;
import com.emazon.mstransaction.domain.util.DomainConstants;
import com.emazon.mstransaction.infraestructure.feign_client.CartFeignClient;
import com.emazon.mstransaction.infraestructure.feign_client.ReportFeignClient;
import com.emazon.mstransaction.infraestructure.feign_client.StockFeignClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class SupplyAdapter implements ISupplyPersistencePort {
    private final ISupplyEntityMapper supplyEntityMapper;
    private final ISupplyRepository supplyRepository;
    private final StockFeignClient stockFeignClient;
    private final CartFeignClient cartFeignClient;
    private final ReportFeignClient reportFeignClient;
    @Override
    public void addSupply(Supply supply) {
        stockFeignClient.updateStock(supply);
        supplyRepository.save(supplyEntityMapper.toEntity(supply));
    }

    @Override
    public void addSale(Article article) {
        stockFeignClient.subtractStock(article);
    }

    @Override
    public void addReport(Report report) {
        reportFeignClient.addReport(report);
    }

    public void deleteArticleCart(Long cartId) {
        cartFeignClient.deleteArticleCart(cartId);
    }

    @Override
    public LocalDate getEstimatedNextRestockDate(Long articleId) {
        return supplyRepository.findTopByArticleIdOrderByRegistrationDateDesc(articleId)
                .map(SupplyEntity::getEstimatedRestockDate)
                .orElse(LocalDate.now().plusDays(DomainConstants.NEXT_DATE_RESTOCK));
    }
}
