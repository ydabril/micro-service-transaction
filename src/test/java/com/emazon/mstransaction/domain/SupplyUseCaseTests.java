package com.emazon.mstransaction.domain;

import com.emazon.mstransaction.domain.api.use_case.SupplyUseCase;
import com.emazon.mstransaction.domain.model.Supply;
import com.emazon.mstransaction.domain.spi.ISupplyPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SupplyUseCaseTests {
    @Mock
    private ISupplyPersistencePort supplyPersistencePort;

    @InjectMocks
    private SupplyUseCase supplyUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void SaveSupplyTest(){
        Supply supply = new Supply(1L, 10L, null, null);
        supply.setRegistrationDate(LocalDateTime.now());

        supplyUseCase.addSupplies(supply);

        verify(supplyPersistencePort, times(1)).addSupply(any(Supply.class));
    }
}
