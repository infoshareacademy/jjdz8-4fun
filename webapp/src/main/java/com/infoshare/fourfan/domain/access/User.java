package com.infoshare.fourfan.domain.access;

import static javax.faces.component.UIInput.isEmpty;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class User {

    private String email;
    private String password;
    private String name;
    private String surName;
    private String phoneNumber;
    private Boolean isAdmin;

    public User() {
        throw new IllegalArgumentException("All fields are mandatory to be given for user to be created");
    }


    public User(String email, String password, String name, String surName, String phoneNumber, Boolean isAdmin) {
        if (isBlank(email) || (isBlank(password)) || (isBlank(name)) || (isBlank(surName)) || (isBlank(phoneNumber))) {
            throw new IllegalArgumentException("All fields (email, password, name, surname and phone number are mandatory to be given for user's successful registration");
        } else {
            this.email = email;
            this.password = password;
            this.name = name;
            this.surName = surName;
            this.phoneNumber = phoneNumber;
        }
        if (isEmpty(isAdmin)) {
            this.isAdmin = isAdmin;
        } else {
            this.isAdmin = true;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "1. email='" + email + '\'' +
                "2. Imie='" + name + '\'' +
                "3. Nazwisko='" + surName + '\'' +
                "4. Numer telefonu='" + phoneNumber + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (isBlank(password)) {
            throw new IllegalArgumentException("Password is not allowed to be empty");
        }
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException("Name is not allowed to be empty");
        }
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        if (isBlank(surName)) {
            throw new IllegalArgumentException("Surname is not allowed to be empty");
        }
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (isBlank(email)) {
            throw new IllegalArgumentException("Email is not allowed to be empty");
        }
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isBlank(phoneNumber)) {
            throw new IllegalArgumentException("Phone number is not allowed to be empty");
        }
        this.phoneNumber = phoneNumber;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }
}