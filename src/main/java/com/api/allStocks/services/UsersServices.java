package com.api.allStocks.services;

import com.api.allStocks.models.UsersModel;
import com.api.allStocks.respositories.UsersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServices {

    @Autowired
    UsersRepositories repository;



    public UsersModel createUser(UsersModel user) {
        repository.save(user);
        return user;
    }


}
