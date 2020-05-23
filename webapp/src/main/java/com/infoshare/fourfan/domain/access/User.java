package com.infoshare.fourfan.domain.access;
//TODO adjust apache.commons - import might be wrongly implemented; to veryfie

import freemarker.template.utility.StringUtil;
import org.apache.commons.lang3.StringUtils;

public class User {

    private String name;
    private String surName;
    private String login;
    private String password;
    private String email;
    private String phoneNumber;
    private boolean isAdmin;

//TODO:
// - to verifie with team - if this constructor due to security should be created
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
        if (StringUtils.isEmpty(login)) {
            throw new IllegalArgumentException("Login is necessary to be given for user to be created");
        }
        this.login = login;

        if (StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("Password is necessary to be given for user to be created");
        }
        this.password = password;
    }

//    public User() {
//        name = "";
//        surName = "";
//        phoneNumber = "";
//        email = "";
//        password = "";
//        isAdmin = false;
//    }

//    public User(UserBuilder builder) {
//        this.name = builder.name;
//        this.surName = builder.surName;
//        this.phoneNumber = builder.phoneNumber;
//        this.email = builder.email;
//        this.password = builder.password;
//        this.isAdmin = builder.isAdmin;
//    }

    @Override
    public String toString() {
        return "  1. Name: " + name + "\n" +
                "  2. Surname: " + surName + "\n" +
                "  3. Phone number: " + phoneNumber + "\n" +
                "  4. Email: " + email + "\n" +
                "  5. Password: " + password + "\n";
    }

    //----------- Getters & Setters -----------
    public String getName() {
        return name;
    }

    //    if 'final' to stay -> setter no longer in use
    //    public void setName(String name) {
    //        this.name = name;
    //    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return surName;
    }

    public String getPassword() {
        return password;
    }

    //    if 'final' to stay -> setter no longer in use
    //    public void setLastName(String surName) {
    //        this.surName = surName;
    //    }

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

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        if (StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("Password is not allowed to be empty!");
        }
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

//    public static class UserBuilder {
//        private final String name;
//        private final String surName;
//        private String phoneNumber;
//        private String email;
//        private String password;
//        private boolean isAdmin;

//        public UserBuilder(){
//            throw new IllegalArgumentException("Name and surname are necessary to be given for user to be created.");
//        }
//
//        public UserBuilder(String name, String surName) {
//            if ((name.isEmpty() || name.isBlank())||(surName.isEmpty() || surName.isBlank())) {
//                throw new IllegalArgumentException("Name and surname are mandatory fields, cannot be empty");
//            }
//            this.name = name;
//            this.surName = surName;
//        }
//
//        public UserBuilder phoneNumber(String phoneNumber) {
//            this.phoneNumber = phoneNumber;
//            return this;
//        }
//
//        public UserBuilder email(String email) {
//            this.email = email;
//            return this;
//        }
//
//        public UserBuilder password(String password) {
//            this.password = password;
//            return this;
//        }
//
//        public UserBuilder isAdmin(boolean isAdmin) {
//            this.isAdmin = isAdmin;
//            return this;
//        }
//
//        public User build() {
//            return new User(this);
//        }
//    }
}