package com.emazon.mstransaction.domain.model;

public class Article {
    private Long articleId;
    private String articleName;
    private Long quantity;

    public Article(Long articleId, String articleName, Long quantity) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.quantity = quantity;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
