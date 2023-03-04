package com.api.allStocks.respositories;

import com.api.allStocks.models.SectorsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SectorsRepository extends JpaRepository<SectorsModel, Long> {

    @Query("SELECT sector FROM SectorsModel")
    List<String> getSectorsName();

    @Query(value = "SELECT id FROM sectors WHERE sectors.sector = ?1", nativeQuery = true)
    int getSectorIdByName(String sector);
}
