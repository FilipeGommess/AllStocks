package com.api.allStocks.tasks.requests;

public class StocksDataResponse {
    long id;
    String name;
    String stock;
    float close;
    String logo;
    String sector;
    double change;

    public String getName() { return name; }
    public String getStock() { return stock; }
    public float getClose() { return close; }
    public String getLogo() { return logo; }
    public String getSector() {
        if (sector == null) { sector = "Outros"; }
        return sector;
    }
    public double getChange() { return change; }

}
