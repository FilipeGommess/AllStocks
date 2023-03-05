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

    public StocksModel putStock(StocksModel newStock, long id) {
        return repository.findById(id).map(stock -> {
            stock.setName(newStock.getName());
            stock.setStock(newStock.getStock());
            stock.setVariation(newStock.getVariation());
            stock.setClose(newStock.getClose());
            stock.setLogo(newStock.getLogo());
            return repository.save(stock);
        }).orElseGet(() -> {
            newStock.setId(id);
            return repository.save(newStock);
        });
    }

    public String deleteStock(long id) {
        repository.deleteById(id);
        return "Deletado";
    }


}
