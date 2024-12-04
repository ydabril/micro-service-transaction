package com.emazon.mstransaction.domain.api;

import com.emazon.mstransaction.domain.model.Sale;
import com.emazon.mstransaction.domain.model.Supply;

import java.time.LocalDate;

public interface ISupplyServicePort {
    void addSupplies(Supply supply);

    void addSale(Sale sale);
    LocalDate getEstimatedNextRestockDate(Long articleId);
}
