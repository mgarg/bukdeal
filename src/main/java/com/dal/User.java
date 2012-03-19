package com.dal;

import java.util.UUID;

public class User {
    private String   name, username,
            password,
            mobile,
            email;

    public User() {
    }

    private UUID id;

    public String getName() {
        return name;
    }

    public User(String name, String username, String password, String mobile, String email, UUID id) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
