package com.api.allStocks.controllers;

import com.api.allStocks.models.StocksModel;
import com.api.allStocks.services.StocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class StocksController {

    @Autowired
    StocksService service;

    @PostMapping("/stock")
    @ResponseStatus(code = HttpStatus.CREATED)
    public StocksModel postStock(@RequestBody StocksModel newStock) {
        return service.postStock(newStock);
    }

    @PutMapping("/stock/{id}")
    public StocksModel putStock(@RequestBody StocksModel newStock, @PathVariable long id){
        return service.putStock(newStock, id);
    }

    @DeleteMapping("/stock/{id}")
    public String deleteStock(@PathVariable long id) {
        return service.deleteStock(id);
    }

    @GetMapping("/stock")
    public List<StocksModel> getAllStocks() {
        return service.getAllStocks();
    }

}
