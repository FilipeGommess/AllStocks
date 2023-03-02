package com.api.allStocks.tasks.requests;

import java.io.Serializable;
import java.util.List;

public class StocksArrayDataResponse implements Serializable {
    public List<StocksDataResponse> stocks;

    public List<StocksDataResponse> getStocks() {
        return stocks;
    }
}
