package com.api.allStocks.models;

import jakarta.persistence.*;

@Entity
@Table (name = "exchanges")
public class ExchangesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(nullable = false)
    private CurrenciesModel from;

    @ManyToOne
    @JoinColumn(nullable = false)
    private CurrenciesModel to;

    @Column(nullable = false)
    private float high;

    @Column(nullable = false)
    private float low;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CurrenciesModel getFrom() {
        return from;
    }

    public void setFrom(CurrenciesModel from) {
        this.from = from;
    }

    public CurrenciesModel getTo() {
        return to;
    }

    public void setTo(CurrenciesModel to) {
        this.to = to;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
