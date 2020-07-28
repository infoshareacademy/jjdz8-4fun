package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dto.NewProductDto;
import com.infoshare.fourfan.dto.ProductDto;
import com.infoshare.fourfan.repository.ProductRepositoryRest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    private ProductRepositoryRest productRepositoryRest = new ProductRepositoryRest();

    private ProductServiceRest productServiceRest = new ProductServiceRest(productRepositoryRest);


    @Test
    void shouldCreateAccount() {
        NewProductDto newProductDto = new NewProductDto();
        newProductDto.setBrand("Milka");
        newProductDto.setName("czekolada");

        ProductDto productDto = productServiceRest.createProduct(newProductDto);

        assertEquals(productDto.getName(), "czekolada");
        assertEquals(productDto.getBrand(), "Milka");
        assertNull(productDto.getPrice());
        assertNull(productDto.getCalories());
        assertNull(productDto.getShop());
        assertNull(productDto.getProductCategory());
        assertNotNull(productDto.getCreated());
        assertNotNull(productDto.getId());
        assertNull(productDto.getLastModified());
    }

//    @Test
//    void shouldReturnProduct() {
//        Integer id = 1;
//        Long created = System.currentTimeMillis();
//        Product product = new Product();
//        product.setId(id);
//        product.setName("pomarange");
//        product.setBrand("java");
//        product.setPrice(100);
//        product.setCalories(300);
//        product.setShop(Shop.TESCO);
//        product.setProductCategory(ProductCategory.OWOCE);
//        product.setCreated(created);
//
//        productRepositoryRest.saveProduct(product);
//
//        ProductDto productDto = productServiceRest.getProduct(id);
//
//        assertEquals(productDto.getId(), product.getId());
//        assertEquals(productDto.getName(), product.getName());
//        assertEquals(productDto.getBrand(), product.getBrand());
//        assertEquals(productDto.getPrice(), product.getPrice());
//        assertEquals(productDto.getCalories(), product.getCalories());
//        assertEquals(productDto.getShop(), product.getShop());
//        assertEquals(productDto.getProductCategory(), product.getProductCategory());
//        assertEquals(productDto.getCreated(), product.getCreated());
//        assertEquals(productDto.getLastModified(), product.getLastModified());
//    }
}
