package com.api.allStocks.services;

import com.api.allStocks.models.StocksModel;
import com.api.allStocks.respositories.StocksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StocksService {

    @Autowired
    StocksRepository repository;

    public StocksModel postStock(StocksModel newStock) {
        repository.save(newStock);
        return  newStock;
    }

}
