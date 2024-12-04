package com.emazon.mstransaction.adapters.driving.http.mapper;

import com.emazon.mstransaction.adapters.driving.http.dto.request.AddSuppliesRequest;
import com.emazon.mstransaction.adapters.driving.http.dto.request.SaleRequest;
import com.emazon.mstransaction.domain.model.Sale;
import com.emazon.mstransaction.domain.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ISupplyRequestMapper {
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "estimatedRestockDate", ignore = true)
    Supply addSupplyRequest(AddSuppliesRequest addSuppliesRequest);

    @Mapping(target = "saleDate", ignore = true)
    Sale toSaleModel(SaleRequest saleRequest);
}
