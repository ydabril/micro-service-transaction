package com.emazon.mstransaction.adapters.driven.jpa.mysql.mapper;

import com.emazon.mstransaction.adapters.driven.jpa.mysql.entity.SupplyEntity;
import com.emazon.mstransaction.domain.model.Supply;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISupplyEntityMapper {
    SupplyEntity toEntity(Supply supply);
    Supply toModel(SupplyEntity supplyEntity);
}
