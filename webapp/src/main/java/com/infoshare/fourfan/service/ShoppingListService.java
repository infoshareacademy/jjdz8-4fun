package com.infoshare.fourfan.service;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.repository.UserRepository;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.List;

@RequestScoped
public class ShoppingListService {

    @EJB
    private UserRepository userRepository;

    public List<Product> findAllJson() throws IOException {
        return userRepository.findAllJson();
    }

    public void deleteProductFromJson(Product product) throws IOException {
        userRepository.deleteProductFromJson(product);
    }

    public void deleteAllShoppingList() throws IOException {
        userRepository.deleteAllShoppingList();
    }


    public Product findProductSLById(Integer id) throws IOException {
        return userRepository.findProductSLById(id).orElse(null);
    }
    public Product findOnShoppingListByName (String name) throws IOException {
        return userRepository.findOnShoppingListByName(name).orElse(null);
    }

    public void editProductList(Integer id, Product newProduct) throws IOException {
        userRepository.editProductList(id, newProduct);
    }


    public void saveNewShoppingList (Product product) throws IOException { userRepository.saveNewShoppingList(product);}
}
