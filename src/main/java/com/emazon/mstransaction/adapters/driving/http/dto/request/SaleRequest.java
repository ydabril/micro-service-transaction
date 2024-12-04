package com.emazon.mstransaction.adapters.driving.http.dto.request;

import com.emazon.mstransaction.adapters.driving.http.utils.ExceptionMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@AllArgsConstructor
@Getter
public class SaleRequest {
    @NotNull(message = ExceptionMessage.ARTICLE_FIELD_NULL_MESSAGE)
    private final List<ArticleRequest> articles;
    private final List<Long> cartIds;
    private final long totalPrice;
    @NotNull(message = ExceptionMessage.ARTICLE_FIELD_NULL_MESSAGE)
    private final Long userId;
    @NotBlank(message = "Email must not be empty")
    @Email(message = "Must be a well-formed email address")
    private String email;
}
