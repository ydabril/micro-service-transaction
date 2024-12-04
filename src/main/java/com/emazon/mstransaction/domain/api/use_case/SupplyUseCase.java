package com.emazon.mstransaction.domain.api.use_case;

import com.emazon.mstransaction.domain.api.ISupplyServicePort;
import com.emazon.mstransaction.domain.model.Article;
import com.emazon.mstransaction.domain.model.Report;
import com.emazon.mstransaction.domain.model.Sale;
import com.emazon.mstransaction.domain.model.Supply;
import com.emazon.mstransaction.domain.spi.ISupplyPersistencePort;
import com.emazon.mstransaction.domain.util.DomainConstants;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SupplyUseCase implements ISupplyServicePort {
    private ISupplyPersistencePort supplyPersistencePort;

    public SupplyUseCase(ISupplyPersistencePort supplyPersistencePort) {
        this.supplyPersistencePort = supplyPersistencePort;
    }

    @Override
    public void addSupplies(Supply supply) {
        supply.setRegistrationDate(LocalDateTime.now());
        LocalDate nextRestockDate = LocalDate.now().plusDays(DomainConstants.NEXT_DATE_RESTOCK);
        supply.setEstimatedRestockDate(nextRestockDate);
        supplyPersistencePort.addSupply(supply);
    }

    @Override
    public void addSale(Sale sale) {
        sale.setSaleDate(LocalDate.now());
        List<String> articleNames = new ArrayList<>();
        Report report = new Report(articleNames, sale.getTotalPrice(), sale.getEmail());

        for (Long cartId : sale.getCartIds()) {
            supplyPersistencePort.deleteArticleCart(cartId);
        }

        for (Article article : sale.getArticles()) {
            articleNames.add(article.getArticleName());
            supplyPersistencePort.addSale(article);
        }

        report.setArticleNames(articleNames);
        supplyPersistencePort.addReport(report);
    }

    public LocalDate getEstimatedNextRestockDate(Long articleId) {
        return supplyPersistencePort.getEstimatedNextRestockDate(articleId);
    }
}
