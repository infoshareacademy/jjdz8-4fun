package pl.fourfun.access;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class JsonConverterAdmins {

    private static final Gson gsonA = new GsonBuilder().setPrettyPrinting().create();
    private static final String jsonAdminsFile = "src/main/resources/Admins";

    public static void saveAdminsToJsonFile(Admins admins) {
        try (Writer writer = new FileWriter(jsonAdminsFile)) {
            gsonA.toJson(admins, writer);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

    public static Admins readAdminsJsonFile() {
        try (Reader reader = new FileReader(jsonAdminsFile)) {
            return gsonA.fromJson(reader, Admins.class);
        } catch (IOException e) {
            System.out.println("Json admins file not found: " + e.getMessage());
            return new Admins();
        }
    }
}
