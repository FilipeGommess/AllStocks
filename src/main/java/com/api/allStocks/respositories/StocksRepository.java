package com.api.allStocks.respositories;

import com.api.allStocks.models.StocksModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StocksRepository extends JpaRepository<StocksModel, Long> {

    @Query("SELECT name FROM StocksModel")
    List<String> getStocksName();

}
