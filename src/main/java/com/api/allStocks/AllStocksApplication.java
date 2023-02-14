package com.api.allStocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class AllStocksApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllStocksApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "asa";
	}
}
