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

    @Column(nullable = false, unique = true, length = 6)
    private String code;

    @ManyToOne
    @JoinColumn(nullable = false)
    private StocksModel sector;

    @Column(nullable = false)
    private float close;

    @Column(nullable = false, length = 150)
    private String logo;

    @Column(nullable = false)
    private float variation;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public StocksModel getSectorId() {
        return sector;
    }

    public void setSectorId(StocksModel sector) {
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

    public float getChange() {
        return variation;
    }

    public void setChange(float change) {
        this.variation = variation;
    }
}
