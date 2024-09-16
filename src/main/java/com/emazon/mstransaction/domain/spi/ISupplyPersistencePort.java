package com.emazon.mstransaction.domain.spi;

import com.emazon.mstransaction.domain.model.Supply;

public interface ISupplyPersistencePort {
    void addSupply(Supply supply);
}