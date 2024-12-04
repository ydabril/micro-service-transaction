package com.emazon.mstransaction.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class Report {
    private List<String> articleNames;
    private Long totalPrice;
    private String email;

    public Report(List<String> articleNames, Long totalPrice, String email) {
        this.articleNames = articleNames;
        this.totalPrice = totalPrice;
        this.email = email;
    }

    public List<String> getArticleNames() {
        return articleNames;
    }

    public void setArticleNames(List<String> articleNames) {
        this.articleNames = articleNames;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
