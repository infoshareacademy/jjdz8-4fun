package pl.fourfun.readwriteproducts;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;

public class CheckProductFile {

    public static void checkingExistProductFile() throws IOException {
        File productJsonFile = new File("Products.json");
        productJsonFile.createNewFile();
        FileOutputStream oFile = new FileOutputStream(productJsonFile, false);

        JSONArray jsonArrayToFile = new JSONArray();
            JSONObject jsonObjectToFile = new JSONObject();
            jsonObjectToFile.put("productList", jsonArrayToFile);

            //Write JSON file
            try (FileWriter file = new FileWriter("Products.json")) {

                file.write(jsonObjectToFile.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    public static void checkingExistUserFile() throws IOException {
        File userProductList = new File("UserProductList.json");
        userProductList.createNewFile();
        FileOutputStream oFile = new FileOutputStream(userProductList, false);

        JSONArray jsonArrayToFile = new JSONArray();
        JSONObject jsonObjectToFile = new JSONObject();
        jsonObjectToFile.put("productList", jsonArrayToFile);

        //Write JSON file
        try (FileWriter file = new FileWriter("UserProductList.json")) {

            file.write(jsonObjectToFile.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

