package com.infoshare.fourfan.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.fourfan.domain.access.Users;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import java.io.*;
import java.util.Objects;

@LocalBean
@Stateful
public class JsonServiceForUser {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String USER_JSON_FILE = Objects.requireNonNull(JsonServiceForUser.class.getClassLoader().getResource("Users.json")).getPath();

    public static void saveUsersToJsonFile(Users usersList) {
        try (Writer writer = new FileWriter(USER_JSON_FILE)) {
            GSON.toJson(usersList, writer);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

    public static Users readUsersFromJsonFile() {
        System.out.println(USER_JSON_FILE);
        try (Reader reader = new FileReader(USER_JSON_FILE)) {
            Users usersList = GSON.fromJson(reader, Users.class);
            return usersList;
        } catch (IOException e) {
            System.out.println("Users json file not found or broken: " + e.getMessage());
        }
        return new Users();
    }
}