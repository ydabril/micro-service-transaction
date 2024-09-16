package com.emazon.mstransaction.adapters.driving.http.dto.request;

import com.emazon.mstransaction.adapters.driving.http.utils.ExceptionMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@Getter
public class AddSuppliesRequest {
    @NotNull(message = ExceptionMessage.ARTICLE_FIELD_NULL_MESSAGE)
    private final Long articleId;
    @NotNull(message = ExceptionMessage.QUANTITY_FIELD_NULL_MESSAGE)
    @Positive(message =ExceptionMessage.QUANTITY_FIELD_POSITIVE)
    private final long quantity;
}
