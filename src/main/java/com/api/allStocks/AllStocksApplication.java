package com.api.allStocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class AllStocksApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllStocksApplication.class, args);
	}
}
