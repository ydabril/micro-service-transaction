package com.emazon.mstransaction.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Supply {
    private final Long articleId;
    private final Long quantity;
    private LocalDateTime registrationDate;
    private LocalDate estimatedRestockDate;

    public Supply(Long articleId, Long quantity, LocalDateTime registrationDate, LocalDate estimatedRestockDate) {
        this.articleId = articleId;
        this.quantity = quantity;
        this.registrationDate = registrationDate;
        this.estimatedRestockDate = estimatedRestockDate;
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

    public LocalDate getEstimatedRestockDate() {
        return estimatedRestockDate;
    }

    public void setEstimatedRestockDate(LocalDate estimatedRestockDate) {
        this.estimatedRestockDate = estimatedRestockDate;
    }
}
