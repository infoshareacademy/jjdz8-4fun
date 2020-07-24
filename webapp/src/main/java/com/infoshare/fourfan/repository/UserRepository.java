package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ShoppingList;

import javax.ejb.Local;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Local
public interface UserRepository {

    Optional<Product> findProductSLById(Integer id) throws IOException;

    void saveNewShoppingList(Product product) throws IOException;

    Optional<Product> findOnShoppingListByName(String name) throws IOException;

    List<Product> findAllJson() throws IOException;

    void saveToJson(Product product) throws IOException;

    void deleteProductFromJson(Product product) throws IOException;

    void deleteAllShoppingList() throws IOException;

    void editProductList(Integer id, Product newProduct) throws IOException;

    ShoppingList showAllProductsList() throws IOException;

}
