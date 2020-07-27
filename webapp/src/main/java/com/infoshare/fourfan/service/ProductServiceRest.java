package com.infoshare.fourfan.service;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.dto.NewProductDto;
import com.infoshare.fourfan.dto.ProductDto;
import com.infoshare.fourfan.repository.ProductRepositoryRest;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
public class ProductServiceRest {

    private ProductRepositoryRest productRepositoryRest;

    @Inject
    public ProductServiceRest(ProductRepositoryRest productRepositoryRest) {
        this.productRepositoryRest = productRepositoryRest;
    }

    public ProductServiceRest() {
    }

    public ProductDto createProduct(NewProductDto newProductDto) {
        String id = UUID.randomUUID().toString();
        Long timestamp = System.currentTimeMillis();
        Product product = new Product();
        product.setName(newProductDto.getName());
        product.setBrand(newProductDto.getBrand());
        product.setCreated(timestamp);
        product.setId(Integer.valueOf(id));

        productRepositoryRest.saveProduct(product);

        ProductDto productDto = new ProductDto();
        productDto.setName(newProductDto.getName());
        productDto.setBrand(newProductDto.getBrand());
        productDto.setCreated(timestamp);
        productDto.setId(Integer.valueOf(id));

        return productDto;
    }

    public List<ProductDto> getProducts() {
        return productRepositoryRest
                .getProducts()
                .stream()
                .map(product -> {
                    ProductDto productDto = new ProductDto();
                    productDto.setName(product.getName());
                    productDto.setBrand(product.getBrand());
                    productDto.setLastModified(product.getLastModified());
                    productDto.setCreated(product.getCreated());
                    productDto.setId(product.getId());
                    return productDto;
                })
                .collect(Collectors.toList());
    }

    public ProductDto getProduct(String id) {
        Product product = productRepositoryRest.getProduct(id);

        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setBrand(product.getBrand());
        productDto.setLastModified(product.getLastModified());
        productDto.setCreated(product.getCreated());
        productDto.setId(product.getId());

        return productDto;
    }

    public ProductDto updateProduct(String id, NewProductDto newProductDto) {
        Product product = productRepositoryRest.getProduct(id);
        product.setName(newProductDto.getName());
        product.setBrand(newProductDto.getBrand());
        product.setLastModified(System.currentTimeMillis());
        productRepositoryRest.saveProduct(product);

        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setBrand(product.getBrand());
        productDto.setLastModified(product.getLastModified());
        productDto.setCreated(product.getCreated());
        productDto.setId(product.getId());

        return productDto;

    }

    public void removeProduct(String id) {
        productRepositoryRest.removeProduct(id);
    }
}
