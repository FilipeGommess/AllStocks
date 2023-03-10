package com.api.allStocks.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "users")
public class UsersModel implements Serializable {
    public UsersModel() {}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = false, length = 45)
    private String name;

    @Column(nullable = false, unique = true, length = 60)
    private String email;

    @Column(nullable = false)
    private Boolean send_email;

    @Column(nullable = false, unique = true)
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSend_email() {
        return send_email;
    }

    public void setSend_email(Boolean send_email) {
        this.send_email = send_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsersModel(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.send_email = false;
        this.password = password;
    }

}
