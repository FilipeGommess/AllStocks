package com.api.allStocks.respositories;

import com.api.allStocks.models.SectorsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SectorsRepository extends JpaRepository<SectorsModel, Long> {

    @Query("SELECT name FROM SectorsModel")
    List<String> getSectorsName();
}
