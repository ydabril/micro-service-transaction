package com.emazon.mstransaction.domain.api.use_case;

import com.emazon.mstransaction.domain.api.ISupplyServicePort;
import com.emazon.mstransaction.domain.model.Supply;
import com.emazon.mstransaction.domain.spi.ISupplyPersistencePort;

import java.time.LocalDateTime;
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
        supplyPersistencePort.addSupply(supply);
    }
}
