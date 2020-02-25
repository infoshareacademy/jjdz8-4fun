package pl.fourfun.accountaccess;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class JsonConverter {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final String jsonUsersFile = "src/main/resources/Users";


    public static void saveUsersToJsonFile(Users users) {
        try (Writer writer = new FileWriter(jsonUsersFile)) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

    public static Users readUsersJsonFile() {
        try (Reader reader = new FileReader(jsonUsersFile)) {
            return gson.fromJson(reader, Users.class);
        } catch (IOException e) {
            System.out.println("Json users file not found: " + e.getMessage());
            return new Users();
        }
    }
}


