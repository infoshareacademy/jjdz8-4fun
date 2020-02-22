package pl.fourfun.accountaccess;

import java.util.Arrays;

public class User {

    private String name;
    private String surName;
    private String phoneNumber;
    private String email;
    private char[] password;

    String blank = "";

    public User() {
        name = "";
        surName = "";
        phoneNumber = "";
        email = "";
        password = blank.toCharArray();
    }

    @Override
    public String toString() {
        return "  1. First name: " + name + "\n" + "  2. Last name: " + surName + "\n" + "  3. Phone Number: " + phoneNumber + "\n" + "  4. Email: " + email + "\n" + "  5. Password: " + Arrays.toString(password) + "\n";
    }

    //----------- Getters & Setters -----------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
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

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
}
