package com.api.allStocks.controllers;

import com.api.allStocks.models.UsersModel;
import com.api.allStocks.respositories.SectorsRepository;
import com.api.allStocks.respositories.StocksRepository;
import com.api.allStocks.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @PostMapping("/user")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UsersModel postUser(@RequestBody UsersModel user) {
        return service.createUser(user);
    }

    @PutMapping("/user/{id}")
    public UsersModel putUser(@RequestBody UsersModel newUser, @PathVariable long id) {
            return service.putUser(newUser, id);
    }


}
