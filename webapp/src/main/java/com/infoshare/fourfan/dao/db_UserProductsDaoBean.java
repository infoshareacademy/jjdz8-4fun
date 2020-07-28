package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.db_UserProducts;
import com.infoshare.fourfan.dto.db_UserProductsDto;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;
import java.util.Optional;


@Stateless
public class db_UserProductsDaoBean implements db_UserProductsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(db_UserProducts userProducts) {
        entityManager.persist(userProducts);
    }

    @Override
    public void update(db_UserProducts userProducts) {
        entityManager.merge(userProducts);
    }

    @Override
    public void delete(db_UserProducts userProducts) {
        entityManager.remove(userProducts);
    }

    @Override
    public Optional<db_UserProducts> findById(Integer id) {
        return Optional.of(entityManager.find(db_UserProducts.class, id));
    }

    @Override
    public List<db_UserProducts> findAll() {
        return entityManager.createQuery("SELECT p FROM db_UserProducts p", db_UserProducts.class).getResultList();
    }

    @Override
    public List<db_UserProductsDto> findAllDto() {
        return entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.db_UserProductsDto("+
                "p.id,p.useridInt,p.db_product.name, p.db_product.brand, p.db_product.price, p.db_product.calories, p.db_product.db_shop.shop, p.db_product.db_productCategory.category, p.amount) FROM db_UserProducts p", db_UserProductsDto.class).getResultList();
    }

    @Override
    public Optional<List<db_UserProductsDto>> findProductsUserIdDto(Integer id) {
        TypedQuery<db_UserProductsDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.db_UserProductsDto(" +
                "p.id,p.useridInt,p.db_product.name, p.db_product.brand, p.db_product.price, p.db_product.calories, p.db_product.db_shop.shop, p.db_product.db_productCategory.category, p.amount) FROM db_UserProducts p WHERE p.useridInt = :idParm", db_UserProductsDto.class);

        query.setParameter("idParm", id);

        try{
            return Optional.of(query.getResultList());

        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<db_UserProductsDto> findOneProductUserIdDto(Integer id) {
        TypedQuery<db_UserProductsDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.db_UserProductsDto(" +
                "p.id,p.useridInt,p.db_product.name, p.db_product.brand, p.db_product.price, p.db_product.calories, p.db_product.db_shop.shop, p.db_product.db_productCategory.category, p.amount) FROM db_UserProducts p WHERE p.id = :idParm", db_UserProductsDto.class);

        query.setParameter("idParm", id);

        try{
            return Optional.of(query.getSingleResult());

        } catch(NoResultException e){
            return Optional.empty();
        }
    }

//    @Override
//    public List<db_UserProducts> deleteAllUserShoppingList() {
//        return entityManager.createQuery("SELECT p FROM db_UserProducts p", db_UserProducts.class).getResultList();
//    }
    @Override
    public void deleteAllUserShoppingList(Integer id) {
        Query query = entityManager.createQuery("DELETE FROM db_UserProducts u WHERE u.useridInt = :idParm");
        query.setParameter("idParm", id).executeUpdate();
    }
}
