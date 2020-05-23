package com.infoshare.fourfan.domain.access;
//TODO adjust apache.commons - import might be wrongly implemented; to veryfie

import org.apache.commons.lang3.StringUtils;

public class User {

    private String login;
    private String password;
    private String name;
    private String surName;
    private String email;
    private String phoneNumber;
    private boolean isAdmin;

//TODO:
// - to verify with team - if this constructor due to security should be created
// - Exception better to be thrown to assure user is not created unless name & surname given
//    public User() {
//        name = "";
//        surName = "";
//        phoneNumber = "";
//        email = "";
//        password = "";
//        isAdmin = false;
//    }

    public User() {
        throw new IllegalArgumentException("Login and password are necessary to be given for user to be created");
    }

    public User(String login, String password) {
        if ((StringUtils.isEmpty(login) || StringUtils.isBlank(login)) || ((StringUtils.isEmpty(password)) || StringUtils.isBlank(password))) {
            throw new IllegalArgumentException("Login is necessary to be given for user to be created");
        } else {
            this.login = login;
            this.password = password;
        }
    }

    @Override
    public String toString() {
        return "  1. Name: " + name + "\n" +
                "  2. Surname: " + surName + "\n" +
                "  3. Phone number: " + phoneNumber + "\n" +
                "  4. Email: " + email + "\n" +
                "  5. Password: " + password + "\n";
    }

    //----------- Getters & Setters -----------

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
        if (StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("Password is not allowed to be empty!");
        }
        this.password = password;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return surName;
    }

    public void setLastName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}