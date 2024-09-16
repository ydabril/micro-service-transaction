package com.emazon.mstransaction.adapters.driving.http.mapper;

import com.emazon.mstransaction.adapters.driving.http.dto.request.AddSuppliesRequest;
import com.emazon.mstransaction.domain.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ISupplyRequestMapper {
    @Mapping(target = "registrationDate", ignore = true)
    Supply addSupplyRequest(AddSuppliesRequest addSuppliesRequest);
}
