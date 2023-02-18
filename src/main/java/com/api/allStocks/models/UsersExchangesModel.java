package com.api.allStocks.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users_exchanges")
public class UsersExchangesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private UsersModel user;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ExchangesModel exchange;

    public UsersModel getUser() {
        return user;
    }

    public void setUser(UsersModel user) {
        this.user = user;
    }

    public ExchangesModel getExchange() {
        return exchange;
    }

    public void setExchange(ExchangesModel exchange) {
        this.exchange = exchange;
    }
}
