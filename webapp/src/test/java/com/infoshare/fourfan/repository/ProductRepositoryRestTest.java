package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.domain.datatypes.ProductCategory;
//import com.infoshare.fourfan.exception.ProductNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//public class ProductRepositoryRestTest {

//    private ProductRepositoryRest productRepositoryRest = new ProductRepositoryRest();
//
//    public ProductRepositoryRestTest() {
//    }
//
//    @BeforeEach
//    void cleanup() {
//        this.productRepositoryRest = new ProductRepositoryRest();
//    }
//
//    @Test
//    void shouldCreateProduct() {
//        Product product = new Product();
//        Integer id = 1;
//        Long created = System.currentTimeMillis();
//        product.setId(id);
//        product.setCreated(created);
//        product.setName("Yoghurt");
//        product.setBrand("Danone");
//        product.setPrice(250);
//        product.setCalories(300);
////        product.setProductCategory(ProductCategory.NABIAŁ);
//        assertEquals(this.productRepositoryRest.getProducts().size(), 0);
//        this.productRepositoryRest.saveProduct(product);
//        assertEquals(this.productRepositoryRest.getProducts().size(), 1);
//    }
//
//    @Test
//    void shouldReturnProduct() {
//        Product product = new Product();
//        Integer id = 1;
//        Long created = System.currentTimeMillis();
//        product.setId(id);
//        product.setCreated(created);
//        product.setName("Yoghurt");
//        product.setBrand("Danone");
//        product.setPrice(250);
//        product.setCalories(300);
////        product.setProductCategory(ProductCategory.NABIAŁ);
//        Assertions.assertEquals(this.productRepositoryRest.getProducts().size(), 0);
//        this.productRepositoryRest.saveProduct(product);
//        Assertions.assertEquals(this.productRepositoryRest.getProduct(id), product);
//    }
//
//    @Test
//    void shouldRemoveProduct() {
//        Product product = new Product();
//        Integer id = 1;
//        Long created = System.currentTimeMillis();
//        product.setId(id);
//        product.setCreated(created);
//        product.setName("Yoghurt");
//        product.setBrand("Danone");
//        product.setPrice(250);
//        product.setCalories(300);
////        product.setProductCategory(ProductCategory.NABIAŁ);
//        Assertions.assertEquals(this.productRepositoryRest.getProducts().size(), 0);
//        this.productRepositoryRest.saveProduct(product);
//        Assertions.assertEquals(this.productRepositoryRest.getProducts().size(), 1);
//        this.productRepositoryRest.removeProduct(id);
//        Assertions.assertEquals(this.productRepositoryRest.getProducts().size(), 0);
//
//    }
//
//    @Test
//    void objectsInMapAreUnmodifiable() {
//        Product product = new Product();
//        Integer id = 1;
//        Long created = System.currentTimeMillis();
//        product.setId(id);
//        product.setCreated(created);
//        product.setName("Yoghurt");
//        product.setBrand("Danone");
//        product.setPrice(250);
//        product.setCalories(300);
////        product.setProductCategory(ProductCategory.NABIAŁ);
//        Assertions.assertEquals(this.productRepositoryRest.getProducts().size(), 0);
//        this.productRepositoryRest.saveProduct(product);
//        Product returnedProduct = this.productRepositoryRest.getProduct(id);
//        returnedProduct.setName("Chocolate");
//        Assertions.assertNotEquals(returnedProduct, product);
//    }
//
//    @Test
//    void shouldThrowProductNotFoundExceptionOnRemove() {
//        Assertions.assertThrows(ProductNotFoundException.class, () -> {
//            this.productRepositoryRest.removeProduct(999999999);
//        });
//    }
//
//    @Test
//    void shouldThrowProductNotFoundExceptionOnGetAccount() {
//        Assertions.assertThrows(ProductNotFoundException.class, () -> {
//            this.productRepositoryRest.getProduct(999999999);
//        });
//    }
//
//    @Test
//    void shouldNotAllowToAddNull() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            this.productRepositoryRest.saveProduct(null);
//        });
//    }
//
//
//}
