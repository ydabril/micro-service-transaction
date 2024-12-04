package com.emazon.mstransaction.domain.model;

import java.time.LocalDate;
import java.util.List;

public class Sale {
    private final List<Article>  articles;
    private final List<Long> cartIds;
    private final Long totalPrice;
    private final String email;
    private LocalDate saleDate;

    public Sale(List<Article> articles, List<Long> cartIds, Long totalPrice, String email, LocalDate saleDate) {
        this.articles = articles;
        this.cartIds = cartIds;
        this.totalPrice = totalPrice;
        this.email = email;
        this.saleDate = saleDate;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public List<Long> getCartIds() {
        return cartIds;
    }
}
