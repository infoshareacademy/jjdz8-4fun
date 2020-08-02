package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.ProductDao;
import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.dto.NewProductDto;
import com.infoshare.fourfan.dto.ProductDto;
import com.infoshare.fourfan.repository.ProductRepositoryRest;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class ProductServiceRest {

    @EJB
    private ProductRepositoryRest productRepositoryRest;

    @EJB
    private ProductDao productDao;


    public ProductServiceRest(ProductRepositoryRest productRepositoryRest) {
        this.productRepositoryRest = productRepositoryRest;
    }

    public ProductServiceRest() {
    }


    public ProductDto createProduct(NewProductDto newProductDto) {
        Integer id = productRepositoryRest.getProducts().size() + 1;
        Long timestamp = System.currentTimeMillis();
        Product product = new Product();
        product.setName(newProductDto.getName());
        product.setBrand(newProductDto.getBrand());
        product.setCreated(timestamp);
        product.setId(id);
        productDao.save(product);

        ProductDto productDto = new ProductDto();
        productDto.setName(newProductDto.getName());
        productDto.setBrand(newProductDto.getBrand());
        productDto.setCreated(timestamp);
        productDto.setId(id);

        return productDto;
    }

    public List<ProductDto> getProducts() {
        return productDao.findAllDto()
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

    public ProductDto getProduct(Integer id) {
        Product product = productRepositoryRest.getProduct(id);

        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setBrand(product.getBrand());
        productDto.setLastModified(product.getLastModified());
        productDto.setCreated(product.getCreated());
        productDto.setId(product.getId());

        return productDto;
    }

    public ProductDto updateProduct(Integer id, NewProductDto newProductDto) {
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

    public void removeProduct(Integer id) {
        productRepositoryRest.removeProduct(id);
    }
}
