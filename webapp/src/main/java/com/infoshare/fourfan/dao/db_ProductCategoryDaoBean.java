package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.db_ProductCategory;
import com.infoshare.fourfan.dto.db_ProductCategoryDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Stateless
public class db_ProductCategoryDaoBean implements db_ProductCategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(db_ProductCategory db_productCategory) {
        entityManager.persist(db_productCategory);
    }

    @Override
    public void update(db_ProductCategory db_productCategory) {
        entityManager.merge(db_productCategory);
    }

    @Override
    public void delete(db_ProductCategory db_productCategory) {
        entityManager.remove(db_productCategory);
    }

    @Override
    public Optional<db_ProductCategory> findById(Integer id) {
        return Optional.of(entityManager.find(db_ProductCategory.class, id));
    }

    @Override
    public List<db_ProductCategory> findAll() {
        return entityManager.createQuery("SELECT p FROM db_Shop p", db_ProductCategory.class).getResultList();
    }

    @Override
    public List<db_ProductCategoryDto> findAllDto() {
        return entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.db_ProductCategoryDto("+
                "p.id,p.category) FROM db_ProductCategory p", db_ProductCategoryDto.class).getResultList();
    }

    @Override
    public Optional<db_ProductCategoryDto> findCategoryIdDto(Integer id) {
        TypedQuery<db_ProductCategoryDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.db_ProductCategoryDto(" +
                "p.id, p.category) FROM db_ProductCategory p WHERE p.id = :idParm", db_ProductCategoryDto.class);

        query.setParameter("idParm", id);

        try{
            return Optional.of(query.getSingleResult());

        } catch(NoResultException e){
            return Optional.empty();
        }
    }
}
