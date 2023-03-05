package com.api.allStocks.controllers;

import com.api.allStocks.models.UsersModel;
import com.api.allStocks.services.UsersService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable long id){
        return service.deleteUser(id);
    }

    @GetMapping("/user")
    public List<UsersModel> getAllUsers() {
        return service.getAllUsers();
    }

}
