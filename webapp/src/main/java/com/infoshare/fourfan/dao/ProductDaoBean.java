package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.dto.ProductDto;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;
import java.util.Optional;


@Stateless
public class ProductDaoBean implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void updateDb(Integer productId, Product product) {
        entityManager.merge(product);
    }

    @Override
    public void delete(Product product) {
        entityManager.remove(product);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return Optional.of(entityManager.find(Product.class, id));
    }

    @Override
    public Product findByName(String name) {
        return (Product) entityManager.createQuery("SELECT new com.infoshare.fourfan.domain.datatypes.Product(p.id, p.name, p.brand, p.price, p.calories, p.shop, p.productCategory) FROM Product p WHERE p.name LIKE :custName").setParameter("custName", name).getSingleResult();
    }

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    @Override
    public List<ProductDto> findAllDto() {
        return entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.ProductDto(p.id, p.name, p.brand, p.price, p.calories, p.shop, p.productCategory) FROM Product p", ProductDto.class).getResultList();
    }
}
