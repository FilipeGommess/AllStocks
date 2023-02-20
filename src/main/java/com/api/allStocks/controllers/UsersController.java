package com.api.allStocks.controllers;

import com.api.allStocks.models.UsersModel;
import com.api.allStocks.services.UsersServices;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class UsersController {

    UsersServices service;

    public UsersController(UsersServices service) {
        this.service = service;
    }


   @PostMapping("/createuser")
    public UsersModel createUser(@RequestBody UsersModel user) {
        return service.createUser(user);
    }


}
