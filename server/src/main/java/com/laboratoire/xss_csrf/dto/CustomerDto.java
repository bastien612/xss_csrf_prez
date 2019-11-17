package com.laboratoire.xss_csrf.dto;

import com.laboratoire.xss_csrf.model.CustomerModel;

import java.util.UUID;


public class CustomerDto {

    private UUID id;
    private String login;
    private String password;

    public CustomerDto(CustomerModel model) {
        id=model.getId();
        login=model.getLogin();
        password=model.getPassword();
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
