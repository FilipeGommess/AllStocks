package com.api.allStocks.controllers;

import com.api.allStocks.models.StocksModel;
import com.api.allStocks.services.StocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class StocksController {

    @Autowired
    StocksService services;

    @PostMapping("/stock")
    @ResponseStatus(code = HttpStatus.CREATED)
    public StocksModel postStock(@RequestBody StocksModel newStock) {
        return services.postStock(newStock);
    }

    @PutMapping("/stock/{id}")
    public StocksModel putStock(@RequestBody StocksModel newStock, @PathVariable long id){
        return services.putStock(newStock, id);
    }

    @DeleteMapping("/stock/{id}")
    public String deleteStock(@PathVariable long id) {
        return services.deleteStock(id);
    }

}
