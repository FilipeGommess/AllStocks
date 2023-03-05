package com.api.allStocks.respositories;

import com.api.allStocks.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<UsersModel, Long> {

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<UsersModel> getAllUsers();
}
