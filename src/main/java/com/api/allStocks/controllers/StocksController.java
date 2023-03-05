package com.api.allStocks.controllers;

import com.api.allStocks.models.StocksModel;
import com.api.allStocks.services.StocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
}
