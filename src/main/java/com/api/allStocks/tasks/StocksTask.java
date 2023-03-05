package com.api.allStocks.tasks;


import com.api.allStocks.models.SectorsModel;
import com.api.allStocks.models.StocksModel;
import com.api.allStocks.respositories.SectorsRepository;
import com.api.allStocks.respositories.StocksRepository;
import com.api.allStocks.tasks.requests.StocksArrayDataResponse;
import com.api.allStocks.tasks.requests.StocksDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.List;


@Component
public class StocksTask {
    @Autowired
    SectorsRepository sectorsRepository;

    @Autowired
    StocksRepository stocksRepository;

    @Scheduled(cron="19 14 * * * *")
    public void handle() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://brapi.dev/api/quote/list";
        StocksArrayDataResponse stocks = restTemplate.getForObject(fooResourceUrl, StocksArrayDataResponse.class);

        List<String> allSectorsNames = sectorsRepository.getSectorsName();
        List<String> allStocksNames = stocksRepository.getStocksName();
        for (int n = 0; n < stocks.getStocks().toArray().length; n++) {


            StocksDataResponse stocksObject = (StocksDataResponse) Array.get(stocks.getStocks().toArray(), n);

            if (!allSectorsNames.contains(stocksObject.getSector()) && stocksObject.getSector() != null) {
                SectorsModel newSector = new SectorsModel();
                newSector.setSector(stocksObject.getSector());
                sectorsRepository.save(newSector);
                allSectorsNames = sectorsRepository.getSectorsName();
            }

            if (!allStocksNames.contains(stocksObject.getName())) {
                SectorsModel sectorInStock = new SectorsModel();

                if (stocksObject.getSector() == null) {
                    sectorInStock.setSector("Outros");
                    sectorInStock.setId(sectorsRepository.getSectorIdByName("Outros"));
                }  else {
                    sectorInStock.setSector(stocksObject.getSector());
                    sectorInStock.setId(sectorsRepository.getSectorIdByName(stocksObject.getSector()));
                }

                StocksModel newStock = new StocksModel();
                newStock.setName(stocksObject.getName());
                newStock.setStock(stocksObject.getStock());
                newStock.setVariation(stocksObject.getChange());
                newStock.setLogo(stocksObject.getLogo());
                newStock.setClose(stocksObject.getClose());
                newStock.setSector(sectorInStock);
                stocksRepository.save(newStock);

                allStocksNames = stocksRepository.getStocksName();
            }

        }
    }
}
