package com.api.allStocks.tasks;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class StocksTask {

    @Scheduled(cron="19 14 * * * *")
    public void handle() {
        System.out.println("teste");
    }
}
