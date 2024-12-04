package com.emazon.mstransaction.domain.spi;

import com.emazon.mstransaction.domain.model.Article;
import com.emazon.mstransaction.domain.model.Report;
import com.emazon.mstransaction.domain.model.Supply;

import java.time.LocalDate;

public interface ISupplyPersistencePort {
    void addSupply(Supply supply);

    void addSale(Article article);

    void addReport(Report report);

    void deleteArticleCart(Long cartId);
    LocalDate getEstimatedNextRestockDate(Long articleId);
}