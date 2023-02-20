package com.api.allStocks.respositories;

import com.api.allStocks.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepositories extends JpaRepository<UsersModel, Long> {

}
