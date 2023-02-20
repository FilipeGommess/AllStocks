package com.api.allStocks.controllers;

import com.api.allStocks.services.UsersServices;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@SpringBootApplication
@RestController
public class UsersControllers {

    UsersServices service = new UsersServices();

    public UsersControllers (UsersServices service) {
        this.service = service;
    }


   @PostMapping("/createuser")
    public String createUser() {
        return service.createUser();
    }


}
