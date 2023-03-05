package com.api.allStocks.services;

import com.api.allStocks.models.UsersModel;
import com.api.allStocks.respositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersService {

    @Autowired
    UsersRepository repository;



    public UsersModel createUser(UsersModel user) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passwordHash = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);

        repository.save(user);
        return user;
    }

    public UsersModel putUser(UsersModel newUser, long id) {
        System.out.println(repository.findById(id));
        return repository.findById(id).map(user -> {
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            user.setSend_email(newUser.getSend_email());
            return repository.save(user);
        }).orElseGet(() -> {
            newUser.setId(id);
            return repository.save(newUser);
        });
    }

    public String deleteUser(long id) {
        repository.deleteById(id);
        return "Deletado";
    }

    public List<UsersModel> getAllUsers() {
        return repository.getAllUsers();
    }
}
