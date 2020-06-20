package com.infoshare.fourfan.domain.access;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private static List<User> users = new ArrayList<>();

    public static List<User> getUsers() {
        if (users.size() == 0) {
            System.out.println("No users registered yet.");
        }
        return users;
    }

    public void add(User user) {
        users.add(user);
    }

    public void printAllUsers() {
        for (User user : this.users) {
            System.out.println(user);
        }
    }

    public static boolean containsUser(User user) {
        List<User> users = getUsers();
        for (User userFromUsers : users) {
            if (userFromUsers.getEmail() == user.getEmail()) {
                return true;
            }
        }
        return false;
    }
}