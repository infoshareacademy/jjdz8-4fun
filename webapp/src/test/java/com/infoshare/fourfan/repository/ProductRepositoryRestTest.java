package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.AccountNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductRepositoryRestTest {

    private ProductRepositoryRest productRepositoryRest = new ProductRepositoryRest();

    public ProductRepositoryRestTest() {
    }

    @BeforeEach
    void cleanup() {
        this.productRepositoryRest = new ProductRepositoryRest();
    }

    @Test
    void shouldCreateProduct() {
        Product product = new Product();
        Integer id = 1;
        Long created = System.currentTimeMillis();
        product.setId(id);
        product.setCreated(created);
        product.setName("Yoghurt");
        product.setBrand("Danone");
        product.setPrice(250);
        product.setCalories(300);
        product.setProductCategory(ProductCategory.NABIAŁ);
        assertEquals(this.productRepositoryRest.getProducts().size(), 0);
        this.productRepositoryRest.saveProduct(product);
        assertEquals(this.productRepositoryRest.getProducts().size(), 1);
    }

    @Test
    void shouldReturnProduct() throws AccountNotFoundException {
        Product product = new Product();
        Integer id = 1;
        Long created = System.currentTimeMillis();
        product.setId(id);
        product.setCreated(created);
        product.setName("Yoghurt");
        product.setBrand("Danone");
        product.setPrice(250);
        product.setCalories(300);
        product.setProductCategory(ProductCategory.NABIAŁ);
        Assertions.assertEquals(this.productRepositoryRest.getProducts().size(), 0);
        this.productRepositoryRest.saveProduct(product);
        Assertions.assertEquals(this.productRepositoryRest.getProduct(String.valueOf(id)), product);
    }

    @Test
    void shouldRemoveProduct() throws AccountNotFoundException {
        Product product = new Product();
        Integer id = 1;
        Long created = System.currentTimeMillis();
        product.setId(id);
        product.setCreated(created);
        product.setName("Yoghurt");
        product.setBrand("Danone");
        product.setPrice(250);
        product.setCalories(300);
        product.setProductCategory(ProductCategory.NABIAŁ);
        Assertions.assertEquals(this.productRepositoryRest.getProducts().size(), 0);
        this.productRepositoryRest.saveProduct(product);
        Assertions.assertEquals(this.productRepositoryRest.getProducts().size(), 1);
        this.productRepositoryRest.removeProduct(String.valueOf(id));
        Assertions.assertEquals(this.productRepositoryRest.getProducts().size(), 0);

    }

    @Test
    void objectsInMapAreUnmodifiable() throws AccountNotFoundException {
        Product product = new Product();
        Integer id = 1;
        Long created = System.currentTimeMillis();
        product.setId(id);
        product.setCreated(created);
        product.setName("Yoghurt");
        product.setBrand("Danone");
        product.setPrice(250);
        product.setCalories(300);
        product.setProductCategory(ProductCategory.NABIAŁ);
        Assertions.assertEquals(this.productRepositoryRest.getProducts().size(), 0);
        this.productRepositoryRest.saveProduct(product);
        Product returnedProduct = this.productRepositoryRest.getProduct(String.valueOf(id));
        returnedProduct.setName("Chocolate");
        Assertions.assertNotEquals(returnedProduct, product);
    }

    @Test
    void shouldThrowAccountNotFoundExceptionOnRemove() {
        Assertions.assertThrows(AccountNotFoundException.class, () -> {
            this.productRepositoryRest.removeProduct("not existing id");
        });
    }

    @Test
    void shouldThrowAccountNotFoundExceptionOnGetAccount() {
        Assertions.assertThrows(AccountNotFoundException.class, () -> {
            this.productRepositoryRest.getProduct("not existing id");
        });
    }

    @Test
    void shouldNotAllowToAddNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.productRepositoryRest.saveProduct(null);
        });
    }


}
