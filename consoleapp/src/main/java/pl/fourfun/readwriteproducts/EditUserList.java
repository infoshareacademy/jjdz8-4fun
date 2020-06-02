package pl.fourfun.readwriteproducts;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import pl.fourfun.menutypes.LoggedUserMenu;
import pl.fourfun.menutypes.ReadProductMenu;

import java.io.*;
import java.util.*;


public class EditUserList {


    public static void removeOneFromUserList() throws IOException, InterruptedException {

        try {
            ReadUserProducts.readAllProductsUserList();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FileReader jsonFileProductInput2 = new FileReader("UserProductList.json");
        JSONObject jsonObjectReader2 = (JSONObject) JSONValue.parse(jsonFileProductInput2);
        JSONArray jsonArrayProducts2 = (JSONArray) jsonObjectReader2.get("productList");



        Scanner invalue = new Scanner(System.in);
        int inval3 = -1;
        do {
            try {
                System.out.println("podaj ID które chcesz usunąć, lub wybierz 0 aby powrócić do popredniego menu");

                inval3= invalue.nextInt();

            } catch (Exception e) {
                invalue.next();
            }

        } while (( jsonArrayProducts2.size()< inval3) || (inval3< 0));

        if (inval3==0) {
            LoggedUserMenu.showUserMenu();
            return;
        }

        Writer writer2 = new FileWriter("UserProductList.json");
        jsonArrayProducts2.remove(inval3-1);
        jsonObjectReader2.writeJSONString(writer2);
        writer2.close();
    }


    public static void changeAmount() throws IOException, InterruptedException {

        ReadUserProducts.readAllProductsUserList();

        FileReader jsonFileProductInput2 = new FileReader("UserProductList.json");
        JSONObject jsonObjectReader2 = (JSONObject) JSONValue.parse(jsonFileProductInput2);
        JSONArray jsonArrayProducts2 = (JSONArray) jsonObjectReader2.get("productList");

        Scanner invalue = new Scanner(System.in);
        int inval2 = -1;
        do {
            try {
                System.out.println("podaj ID produktu któremu chcesz zmienić ilość, lub wybierz 0 aby powrócić do poprzedniego menu");

                inval2= invalue.nextInt();

            } catch (Exception e) {
                invalue.next();
            }
        }
        while (( jsonArrayProducts2.size()< inval2) || (inval2< 0));

        if (inval2==0){
            ReadProductMenu.readingAddedUserProductMenu();
            return;
        }

        System.out.println("podaj na jaką wartość chcesz zmienić ");
        Scanner newAmount = new Scanner(System.in);
        int newAmount2 = newAmount.nextInt();


        JSONObject jsonObjectReader222 = (JSONObject) jsonArrayProducts2.get(inval2-1);

        JSONObject milestone12 = new JSONObject();
        milestone12.put("name", jsonObjectReader222.get("name").toString());
        milestone12.put("brand", jsonObjectReader222.get("brand").toString());
        milestone12.put("price", jsonObjectReader222.get("price").toString());
        milestone12.put("calories", jsonObjectReader222.get("calories").toString());
        milestone12.put("shop", jsonObjectReader222.get("shop").toString());
        milestone12.put("productCategory", jsonObjectReader222.get("productCategory").toString());
        milestone12.put("amount", newAmount2);

        jsonArrayProducts2.remove(inval2-1);
        jsonArrayProducts2.add(inval2-1, milestone12);

        Writer writer2 = new FileWriter("UserProductList.json");
        jsonObjectReader2.writeJSONString(writer2);
        writer2.close();
    }


    public static void removeAllProductsFromUserList() throws IOException {
        JSONObject jsonObjectReader22 = (JSONObject) JSONValue.parse("{\"productList\":[]}");
        Writer writer22 = new FileWriter("UserProductList.json");
        jsonObjectReader22.writeJSONString(writer22);
        writer22.close();
    }

    public static String countSpacesAndUpdate(String name, int maxLength) {
        int countSpaces = maxLength - name.length();
        String spaces = "";
        for (int i = 0; i < countSpaces; i++) {
            spaces = spaces + " ";
        }
        return name + spaces;
    }
}