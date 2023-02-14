package com.api.allStocks.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "users")
public class UsersModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = false, length = 45)
    private String name;

    @Column(nullable = false, unique = true, length = 60)
    private String email;

    @Column(nullable = false)
    private Boolean send_email;

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
}
