package com.api.allStocks.controllers;

import com.api.allStocks.models.UsersModel;
import com.api.allStocks.services.UsersService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class UsersController {

    UsersService service;

    public UsersController(UsersService service) {
        this.service = service;
    }


   @PostMapping("/createuser")
   @ResponseStatus(code = HttpStatus.CREATED)
    public UsersModel createUser(@RequestBody UsersModel user) {
        return service.createUser(user);
    }


}
