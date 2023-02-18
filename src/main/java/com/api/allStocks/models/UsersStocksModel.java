package com.api.allStocks.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users_stocks")
public class UsersStocksModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private UsersModel user;

    @ManyToOne
    @JoinColumn(nullable = false)
    private StocksModel stock;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UsersModel getUser() {
        return user;
    }

    public void setUser(UsersModel user) {
        this.user = user;
    }

    public StocksModel getStock() {
        return stock;
    }

    public void setStock(StocksModel stock) {
        this.stock = stock;
    }
}
