package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.db_Product;
import com.infoshare.fourfan.dto.db_ProductDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Stateless
public class db_ProductDaoBean implements db_ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(db_Product product) {
        entityManager.persist(product);
    }

    @Override
    public void update(db_Product product) {
        entityManager.merge(product);
    }

    @Override
    public void delete(db_Product product) {
        entityManager.remove(product);
    }

    @Override
    public Optional<db_Product> findById(Integer id) {
        return Optional.of(entityManager.find(db_Product.class, id));
    }

    @Override
    public List<db_Product> findAll() {
        return entityManager.createQuery("SELECT p FROM db_Product p", db_Product.class).getResultList();
    }

    @Override
    public List<db_ProductDto> findAllDto() {
        return entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.db_ProductDto("+
                "p.id, p.name, p.brand, p.price, p.calories, p.db_shop.shop, p.db_productCategory.category) FROM db_Product p", db_ProductDto.class).getResultList();
    }

    @Override
    public Optional<db_ProductDto> findProductIdDto(Integer id) {
        TypedQuery<db_ProductDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.db_ProductDto(" +
                "p.id, p.name, p.brand, p.price, p.calories, p.db_shop.shop, p.db_productCategory.category) FROM db_Product p WHERE p.id = :idParm", db_ProductDto.class);

        query.setParameter("idParm", id);

        try{
            return Optional.of(query.getSingleResult());

        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<db_ProductDto> findProductNameDto(String name) {
        TypedQuery<db_ProductDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.db_ProductDto(" +
                "p.id, p.name, p.brand, p.price, p.calories, p.db_shop.shop, p.db_productCategory.category) FROM db_Product p WHERE p.name = :nameParm", db_ProductDto.class);

        query.setParameter("nameParm", name);

        try{
            return Optional.of(query.getSingleResult());
        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<db_ProductDto>> findProductCategoryDto(Integer category) {
        TypedQuery<db_ProductDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.db_ProductDto(" +
                "p.id, p.name, p.brand, p.price, p.calories, p.db_shop.shop, p.db_productCategory.category) FROM db_Product p WHERE p.db_productCategory.id = :categoryParm", db_ProductDto.class);

        query.setParameter("categoryParm", category);

        try{
            return Optional.of(query.getResultList());
        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<db_ProductDto>> findProductShopDto(Integer shop) {
        TypedQuery<db_ProductDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.db_ProductDto(" +
                "p.id, p.name, p.brand, p.price, p.calories, p.db_shop.shop, p.db_productCategory.category) FROM db_Product p WHERE p.db_shop.id = :shopParm", db_ProductDto.class);

        query.setParameter("shopParm", shop);

        try{
            return Optional.of(query.getResultList());
        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<db_ProductDto>> findProductCaloriesDto(Integer minCalories, Integer maxCalories) {
        TypedQuery<db_ProductDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.db_ProductDto(" +
                "p.id, p.name, p.brand, p.price, p.calories, p.db_shop.shop, p.db_productCategory.category) FROM db_Product p WHERE p.calories BETWEEN :minCaloriesParm and :maxCaloriesParm", db_ProductDto.class);

        query.setParameter("minCaloriesParm", minCalories);
        query.setParameter("maxCaloriesParm", maxCalories);

        try{
            return Optional.of(query.getResultList());
        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<db_ProductDto>> filterByPrice(Integer priceMin, Integer priceMax) {
        TypedQuery<db_ProductDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.db_ProductDto(" +
                "p.id, p.name, p.brand, p.price, p.calories, p.db_shop.shop, p.db_productCategory.category) FROM db_Product p WHERE p.price BETWEEN :minPriceParm and :maxPriceParm ORDER BY p.db_shop.shop", db_ProductDto.class);

        query.setParameter("minPriceParm", priceMin);
        query.setParameter("maxPriceParm", priceMax);

        try{
            return Optional.of(query.getResultList());
        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<db_ProductDto> findAlreadyExistProductDto(String name,String brand) {
        TypedQuery<db_ProductDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.db_ProductDto(" +
                "p.id, p.name, p.brand, p.price, p.calories, p.db_shop.shop, p.db_productCategory.category) FROM db_Product p WHERE p.name = :nameParm and p.brand = :brandParm", db_ProductDto.class);

        query.setParameter("nameParm", name);
        query.setParameter("brandParm", brand);

        try{
            return Optional.of(query.getSingleResult());
        } catch(NoResultException e){
            return Optional.empty();
        }
    }
}
