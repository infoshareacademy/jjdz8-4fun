package com.infoshare.fourfan.domain.access;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.isBlank;

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

    public User(String email, String password, String name, String surName, String phoneNumber, Boolean isAdmin) {
        if (isBlank(email) || (isBlank(password)) || (isBlank(name)) || (isBlank(surName)) || (isBlank(phoneNumber))) {
            throw new IllegalArgumentException("All fields (email, password, name, surname and phone number are mandatory to be given for user's successful registration");
        } else {
            this.email = email;
            this.password = password;
            this.name = name;
            this.surName = surName;
            this.phoneNumber = phoneNumber;
            this.isAdmin = false;
        }
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Phone number is a mandatory field");
        }
        this.phoneNumber = phoneNumber;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "1. email=" + email + '\'' +
                " 2. Imie=" + name + '\'' +
                " 3. Nazwisko=" + surName + '\'' +
                " 4. Numer telefonu=" + phoneNumber + '\'' +
                " 5. Czy to admin?=" + isAdmin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getSurName(), user.getSurName()) &&
                Objects.equals(getPhoneNumber(), user.getPhoneNumber()) &&
                Objects.equals(isAdmin, user.isAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPassword(), getName(), getSurName(), getPhoneNumber(), isAdmin);
    }
}