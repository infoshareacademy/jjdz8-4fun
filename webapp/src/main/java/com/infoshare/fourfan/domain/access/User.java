package com.infoshare.fourfan.domain.access;
//TODO adjust apache.commons - import might be wrongly implemented; to veryfie

import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotEmpty;

public class User {

    private String email;
    private String password;
    private String name;
    private String surName;
    private String phoneNumber;
    private boolean isAdmin;

    public User() {
        throw new IllegalArgumentException("All fields are mandatory to be given for user to be created");
    }

    public User(String email, String password, String name, String surName, String phoneNumber) {
        if (StringUtils.isBlank(email) || (StringUtils.isBlank(password)) || (StringUtils.isBlank(name)) || (StringUtils.isBlank(surName)) || (StringUtils.isBlank(phoneNumber))) {
            throw new IllegalArgumentException("All fields (email, password, name, surname and your phone number are mandatory to be given for user's successful registration");
        } else {
            this.email = email;
            this.password = password;
            this.name = name;
            this.surName = surName;
            this.phoneNumber = phoneNumber;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", Imie='" + name + '\'' +
                ", Nazwisko='" + surName + '\'' +
                ", Numer telefonu='" + phoneNumber + '\'' +
                '}';
    }

    //----------- Getters & Setters -----------
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (StringUtils.isBlank(password)) {
            throw new IllegalArgumentException("Password is not allowed to be empty");
        }
        ;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Name is not allowed to be empty");
        }
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        if (StringUtils.isBlank(surName)) {
            throw new IllegalArgumentException("Surname is not allowed to be empty");
        }
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (StringUtils.isBlank(email)) {
            throw new IllegalArgumentException("Email is not allowed to be empty");
        }
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (StringUtils.isBlank(phoneNumber)) {
            throw new IllegalArgumentException("Phone number is not allowed to be empty");
        }
        this.phoneNumber = phoneNumber;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}