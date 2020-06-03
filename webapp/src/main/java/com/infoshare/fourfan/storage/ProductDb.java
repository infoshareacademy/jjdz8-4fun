package com.infoshare.fourfan.storage;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.domain.datatypes.ProductList;
import com.infoshare.fourfan.domain.datatypes.Shop;
import com.infoshare.fourfan.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductDb {

    private static List<Product> productRepository = new ArrayList<>();

    public static List<Product> getRepository() {
        if (productRepository.size() == 0) {
            fillRepositoryWithDefaults();
        }
        return productRepository;
    }

    private static void fillRepositoryWithDefaults() {

        Product product1 = new Product();
        product1.setName("Pomarancz");
        product1.setBrand("Java");
        product1.setCalories(50);
        product1.setShop(Shop.TESCO);
        product1.setProductCategory(ProductCategory.OWOCE);
        productRepository.add(product1);

        Product product2 = new Product();
        product2.setName("Jogurt");
        product2.setBrand("Danone");
        product2.setCalories(69);
        product2.setShop(Shop.AUCHAN);
        product2.setProductCategory(ProductCategory.NABIAŁ);
        productRepository.add(product2);

        Product product3 = new Product();
        product3.setName("Sałata siewna");
        product3.setBrand("No brand");
        product3.setCalories(16);
        product3.setShop(Shop.TESCO);
        product3.setProductCategory(ProductCategory.WARZYWA);
        productRepository.add(product3);

//        ProductList productList = new ProductList();
//        productList.getProductList().add(product1);
//        productList.getProductList().add(product2);
//        productList.getProductList().add(product3);
//
//        ProductService productService = new ProductService();
//        productService.saveProductsToJsonFile(productList);

    }

    public static boolean contains(Product product) {
        List<Product> repository = getRepository();
        for (Product productFromList : repository) {
            if (productFromList.getName() == product.getName()) {
                return true;
            }
        }
        return false;
    }
}
