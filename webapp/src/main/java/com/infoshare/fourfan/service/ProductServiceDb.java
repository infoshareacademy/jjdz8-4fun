package com.infoshare.fourfan.service;

import com.infoshare.fourfan.dao.ProductDao;
import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.dto.ProductDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class ProductServiceDb {

    @EJB
    private ProductDao productDao;

    public void saveProduct(Product product) {

        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setBrand(product.getBrand());
        newProduct.setPrice(product.getPrice());
        newProduct.setCalories(product.getCalories());
        newProduct.setShop(product.getShop());
        newProduct.setProductCategory(product.getProductCategory());

        productDao.save(newProduct);
    }

    public void update(Product product) {
        productDao.update(product);
    }

    public void updateDb(Integer productId, Product product) {
        productDao.update(product);
    }

    public void delete(Product product) {
        productDao.delete(product);
    }

    public Product findById(Integer id) {
        return productDao.findById(id).orElseThrow();
    }

    public Product findByName(String name) { return productDao.findByName(name); }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public List<ProductDto> getProducts(){
        return productDao.findAllDto();
    };

}
