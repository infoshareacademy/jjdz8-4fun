package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.UserProducts;
import com.infoshare.fourfan.dto.UserProductsDto;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;
import java.util.Optional;


@Stateless
public class UserProductsDaoBean implements UserProductsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(UserProducts userProducts) {
        entityManager.persist(userProducts);
    }

    @Override
    public void update(UserProducts userProducts) {
        entityManager.merge(userProducts);
    }

    @Override
    public void delete(UserProducts userProducts) {
        entityManager.remove(userProducts);
    }

    @Override
    public Optional<UserProducts> findById(Integer id) {
        return Optional.of(entityManager.find(UserProducts.class, id));
    }

    @Override
    public List<UserProducts> findAll() {
        return entityManager.createQuery("SELECT p FROM UserProducts p", UserProducts.class).getResultList();
    }

    @Override
    public List<UserProductsDto> findAllDto() {
        return entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.UserProductsDto("+
                "p.id,p.useridInt,p.product.name, p.product.brand, p.product.price, p.product.calories, p.product.shop.shop, p.product.productCategory.category, p.amount) FROM UserProducts p", UserProductsDto.class).getResultList();
    }

    @Override
    public Optional<List<UserProductsDto>> findProductsUserIdDto(Integer id) {
        TypedQuery<UserProductsDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.UserProductsDto(" +
                "p.id,p.useridInt,p.product.name, p.product.brand, p.product.price, p.product.calories, p.product.shop.shop, p.product.productCategory.category, p.amount) FROM UserProducts p WHERE p.useridInt = :idParm", UserProductsDto.class);

        query.setParameter("idParm", id);

        try{
            return Optional.of(query.getResultList());

        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserProductsDto> findOneProductUserIdDto(Integer id) {
        TypedQuery<UserProductsDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.UserProductsDto(" +
                "p.id,p.useridInt,p.product.name, p.product.brand, p.product.price, p.product.calories, p.product.shop.shop, p.product.productCategory.category, p.amount) FROM UserProducts p WHERE p.id = :idParm", UserProductsDto.class);

        query.setParameter("idParm", id);

        try{
            return Optional.of(query.getSingleResult());

        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public void deleteAllUserShoppingList(Integer id) {
        Query query = entityManager.createQuery("DELETE FROM UserProducts u WHERE u.useridInt = :idParm");
        query.setParameter("idParm", id).executeUpdate();
    }

    @Override
    public Optional<UserProductsDto> findUserProductNameDto(String name) {
        TypedQuery<UserProductsDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.UserProductsDto(" +
                "p.id, p.useridInt, p.product.name, p.product.brand, p.product.price, p.product.calories, p.product.shop.shop, p.product.productCategory.category, p.amount) FROM UserProducts p WHERE p.product.name = :nameParm", UserProductsDto.class);

        query.setParameter("nameParm", name);

        try{
            return Optional.of(query.getSingleResult());
        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<UserProductsDto>> findUserProductIdProductDto(Integer id) {
        TypedQuery<UserProductsDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.UserProductsDto(" +
                "p.id, p.useridInt, p.product.name, p.product.brand, p.product.price, p.product.calories, p.product.shop.shop, p.product.productCategory.category, p.amount) FROM UserProducts p WHERE p.product.id = :idParm", UserProductsDto.class);

        query.setParameter("idParm", id);

        try{
            return Optional.of(query.getResultList());
        } catch(NoResultException e){
            return Optional.empty();
        }
    }
}
