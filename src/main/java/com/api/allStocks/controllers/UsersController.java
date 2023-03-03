package com.api.allStocks.controllers;

import com.api.allStocks.models.SectorsModel;
import com.api.allStocks.models.StocksModel;
import com.api.allStocks.models.UsersModel;
import com.api.allStocks.respositories.SectorsRepository;
import com.api.allStocks.respositories.StocksRepository;
import com.api.allStocks.services.UsersService;
import com.api.allStocks.tasks.requests.StocksArrayDataResponse;
import com.api.allStocks.tasks.requests.StocksDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class UsersController {

    UsersService service;

@Autowired
    SectorsRepository sectorsRepository;
@Autowired
    StocksRepository stocksRepository;
    public UsersController(UsersService service) {
        this.service = service;
    }


    @PostMapping("/user")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UsersModel createUser(@RequestBody UsersModel user) {
        return service.createUser(user);
    }


    @GetMapping("/teste")
    public List idonto() {
        List<String> teste = stocksRepository.getStocksName();



        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://brapi.dev/api/quote/list";
        StocksArrayDataResponse stocks = restTemplate.getForObject(fooResourceUrl, StocksArrayDataResponse.class);

        for (int n = 0; n < stocks.getStocks().toArray().length; n++) {
            List<String> allSectorsName = sectorsRepository.getSectorsName();
            StocksDataResponse stocksObject = (StocksDataResponse) Array.get(stocks.getStocks().toArray(), n);

            if (!allSectorsName.contains(stocksObject.getSector()) && stocksObject.getSector() != null) {

                SectorsModel newSector = new SectorsModel();
                newSector.setName(stocksObject.getSector());
                sectorsRepository.save(newSector);
            }

        }
        return stocks.getStocks();
    }
}
