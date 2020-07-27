package com.infoshare.fourfan.repository;


import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ShoppingList;
import com.infoshare.fourfan.service.JsonSaveShoppingListService;
import com.infoshare.fourfan.service.JsonShoppingListService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.ejb.Stateless;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.infoshare.fourfan.domain.access.User;
import com.infoshare.fourfan.domain.access.Users;
import com.infoshare.fourfan.service.JsonServiceForUser;


import javax.ejb.Stateless;
import java.io.IOException;
import java.util.List;

import java.util.Optional;

@Stateless
public class UserRepositoryBean implements UserRepository {

    @Override

    public Optional<Product> findProductSLById(Integer id) throws IOException {
        return showAllProductsList()
                .getShoppingList()
                .stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }
  
    @Override
    public List<Product> findAllJson() {
        return JsonShoppingListService.readShoppingListJsonFile().getShoppingList();
    }

    @Override
    public void saveToJson(Product product) {
        ShoppingList shoppingList = JsonShoppingListService.readShoppingListJsonFile();
        shoppingList.add(product);
        JsonShoppingListService.saveProductShoppingListToJsonFile(shoppingList);
    }

    public void deleteProductFromJson(Product product) {
        ShoppingList shoppingList = JsonShoppingListService.readShoppingListJsonFile();
        shoppingList.delete(product);
        JsonShoppingListService.saveProductShoppingListToJsonFile(shoppingList);
    }

    @Override
    public void deleteAllShoppingList() throws IOException {
        JsonShoppingListService.removeAllShoppingList();
    }


    @Override
    public void editProductList(Integer id, Product newProduct2) throws IOException {
        ShoppingList shoppingList = showAllProductsList();
        shoppingList.set(id, newProduct2);
        JsonShoppingListService.saveProductShoppingListToJsonFile(shoppingList);
    }


    @Override
    public Optional<Product> findOnShoppingListByName(String name) throws IOException {
        return showAllProductsList()
                .getShoppingList()
                .stream()
                .filter(product -> product.getName().contains(name)).findFirst();
    }




    @Override
    public void saveNewShoppingList (Product product) throws IOException {
        JSONObject jsonObjectReader2 = null;
        String shoppingList = Objects.requireNonNull(this.getClass().getClassLoader().getResource("ShoppingList.json")).getPath();
        FileReader jsonFileShoppingListInput = new FileReader(shoppingList);

        jsonObjectReader2 = (JSONObject) JSONValue.parse(jsonFileShoppingListInput);

        JSONArray jsonArrayShoppingList = (JSONArray) jsonObjectReader2.get("shoppingList");
        JSONObject jsonObjectNewProduct2 = new JSONObject();
        if (product.getAmount()==1) {
            jsonObjectNewProduct2.put("id", jsonArrayShoppingList.size() + 1);
        } else {
            jsonObjectNewProduct2.put("id", product.getId());
        }
        jsonObjectNewProduct2.put("name", product.getName());
        jsonObjectNewProduct2.put("brand", product.getBrand());
        jsonObjectNewProduct2.put("price", product.getPrice());
        jsonObjectNewProduct2.put("calories", product.getCalories());
        jsonObjectNewProduct2.put("shop", product.getShop());
        jsonObjectNewProduct2.put("productCategory", product.getProductCategory());
        jsonObjectNewProduct2.put("amount", product.getAmount());

        jsonArrayShoppingList.add(jsonArrayShoppingList.size(), jsonObjectNewProduct2);

        JSONObject zxc2 = new JsonSaveShoppingListService().saveShoppingListJsonFile(jsonObjectReader2);


    }

    @Override
    public ShoppingList showAllProductsList() throws IOException {
        return new JsonSaveShoppingListService().readProductsJsonFile();
    }





    public void addUserToJson(User user) throws IOException {
        Users usersList = JsonServiceForUser.readUsersFromJsonFile();
        usersList.add(user);
        JsonServiceForUser.saveUsersToJsonFile(usersList);
    }

    @Override
    public List<User> findUsersForJson() {
        return JsonServiceForUser.readUsersFromJsonFile().getUsers();
    }

    public Optional<User> findUserByEmailAndPassword(String email, String password) throws IOException {
        Users usersList = JsonServiceForUser.readUsersFromJsonFile();
        return Optional.ofNullable(usersList.getUsers().stream()
                .filter(e -> e.getEmail().equals(email) && e.getPassword().equals(password)).findFirst().orElse(null));
    }

}
