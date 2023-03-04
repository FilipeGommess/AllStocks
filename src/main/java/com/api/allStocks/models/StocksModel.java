package com.api.allStocks.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "stocks")
public class StocksModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 254)
    private String name;

    @Column(nullable = false, unique = true, length = 8)
    private String stock;

    @ManyToOne(cascade=CascadeType.PERSIST)
    private SectorsModel sector;

    @Column(nullable = false)
    private float close;

    @Column(nullable = false, length = 254)
    private String logo;

    @Column(nullable = false)
    private double variation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public SectorsModel getSector() {
        return sector;
    }

    public void setSector(SectorsModel sector) {
        this.sector = sector;
    }

    public float getClose() {
        return close;
    }

    public void setClose(float close) {
        this.close = close;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public double getVariation() {
        return variation;
    }

    public void setVariation(double variation) {
        this.variation = variation;
    }
}