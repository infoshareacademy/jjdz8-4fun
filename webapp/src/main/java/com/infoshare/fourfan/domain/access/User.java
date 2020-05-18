package com.infoshare.fourfan.domain.access;

import org.apache.commons.lang3.StringUtils;

public class User {

    private final String name;
    private final String surName;
    private String phoneNumber;
    private String email;
    private String password;
    private boolean isAdmin;

    public User() {
        name = "";
        surName = "";
        phoneNumber = "";
        email = "";
        password = "";
        isAdmin = false;
    }

    public User(UserBuilder builder) {

    }

    @Override
    public String toString() {
        return "  1. Imię: " + name + "\n" +
                "  2. Nazwisko: " + surName + "\n" +
                "  3. Numer telefonu: " + phoneNumber + "\n" +
                "  4. Email: " + email + "\n" +
                "  5. Hasło: " + password + "\n";
    }

    //----------- Getters & Setters -----------
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public static class UserBuilder {
        private final String name;
        private final String surName;
        private String phoneNumber;
        private String email;
        private String password;
        private boolean isAdmin;

        public UserBuilder(String name, String surName) {
            if (StringUtils.isEmpty(name)) {
                throw new IllegalArgumentException("Name is a mandatory field");
            }
            this.name = name;

            if (StringUtils.isEmpty(surName)) {
                throw new IllegalArgumentException("Name is a mandatory field");
            }
            this.surName = surName;
        }
    }
}