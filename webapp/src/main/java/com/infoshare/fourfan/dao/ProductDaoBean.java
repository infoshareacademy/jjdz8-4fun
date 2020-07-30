package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.Product;
import com.infoshare.fourfan.dto.ProductDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
    public void delete(Product product) {
        entityManager.remove(product);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return Optional.of(entityManager.find(Product.class, id));
    }

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    @Override
    public List<ProductDto> findAllDto() {
        return entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.ProductDto("+
                "p.id, p.name, p.brand, p.price, p.calories, p.shop.shop, p.productCategory.category) FROM Product p", ProductDto.class).getResultList();
    }

    @Override
    public Optional<ProductDto> findProductIdDto(Integer id) {
        TypedQuery<ProductDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.ProductDto(" +
                "p.id, p.name, p.brand, p.price, p.calories, p.shop.shop, p.productCategory.category) FROM Product p WHERE p.id = :idParm", ProductDto.class);

        query.setParameter("idParm", id);

        try{
            return Optional.of(query.getSingleResult());

        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductDto> findProductNameDto(String name) {
        TypedQuery<ProductDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.ProductDto(" +
                "p.id, p.name, p.brand, p.price, p.calories, p.shop.shop, p.productCategory.category) FROM Product p WHERE p.name = :nameParm", ProductDto.class);

        query.setParameter("nameParm", name);

        try{
            return Optional.of(query.getSingleResult());
        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<ProductDto>> findProductCategoryDto(Integer category) {
        TypedQuery<ProductDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.ProductDto(" +
                "p.id, p.name, p.brand, p.price, p.calories, p.shop.shop, p.productCategory.category) FROM Product p WHERE p.productCategory.id = :categoryParm", ProductDto.class);

        query.setParameter("categoryParm", category);

        try{
            return Optional.of(query.getResultList());
        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<ProductDto>> findProductShopDto(Integer shop) {
        TypedQuery<ProductDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.ProductDto(" +
                "p.id, p.name, p.brand, p.price, p.calories, p.shop.shop, p.productCategory.category) FROM Product p WHERE p.shop.id = :shopParm", ProductDto.class);

        query.setParameter("shopParm", shop);

        try{
            return Optional.of(query.getResultList());
        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<ProductDto>> findProductCaloriesDto(Integer minCalories, Integer maxCalories) {
        TypedQuery<ProductDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.ProductDto(" +
                "p.id, p.name, p.brand, p.price, p.calories, p.shop.shop, p.productCategory.category) FROM Product p WHERE p.calories BETWEEN :minCaloriesParm and :maxCaloriesParm", ProductDto.class);

        query.setParameter("minCaloriesParm", minCalories);
        query.setParameter("maxCaloriesParm", maxCalories);

        try{
            return Optional.of(query.getResultList());
        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<ProductDto>> filterByPrice(Integer priceMin, Integer priceMax) {
        TypedQuery<ProductDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.ProductDto(" +
                "p.id, p.name, p.brand, p.price, p.calories, p.shop.shop, p.productCategory.category) FROM Product p WHERE p.price BETWEEN :minPriceParm and :maxPriceParm ORDER BY p.shop.shop", ProductDto.class);

        query.setParameter("minPriceParm", priceMin);
        query.setParameter("maxPriceParm", priceMax);

        try{
            return Optional.of(query.getResultList());
        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductDto> findAlreadyExistProductDto(String name,String brand) {
        TypedQuery<ProductDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.ProductDto(" +
                "p.id, p.name, p.brand, p.price, p.calories, p.shop.shop, p.productCategory.category) FROM Product p WHERE p.name = :nameParm and p.brand = :brandParm", ProductDto.class);

        query.setParameter("nameParm", name);
        query.setParameter("brandParm", brand);

        try{
            return Optional.of(query.getSingleResult());
        } catch(NoResultException e){
            return Optional.empty();
        }
    }
}
