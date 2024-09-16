package com.emazon.mstransaction.domain.model;

import java.time.LocalDateTime;

public class Supply {
    private final Long articleId;
    private final Long quantity;
    private LocalDateTime registrationDate;

    public Supply(Long articleId, Long quantity, LocalDateTime registrationDate) {
        this.articleId = articleId;
        this.quantity = quantity;
        this.registrationDate = registrationDate;
    }

    public Long getArticleId() {
        return articleId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
