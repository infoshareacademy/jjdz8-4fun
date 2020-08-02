package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.ProductCategory;
import com.infoshare.fourfan.dto.ProductCategoryDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Stateless
public class ProductCategoryDaoBean implements ProductCategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(ProductCategory productCategory) {
        entityManager.persist(productCategory);
    }

    @Override
    public void update(ProductCategory productCategory) {
        entityManager.merge(productCategory);
    }

    @Override
    public void delete(ProductCategory productCategory) {
        entityManager.remove(productCategory);
    }

    @Override
    public Optional<ProductCategory> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(ProductCategory.class, id));
    }

    @Override
    public List<ProductCategory> findAll() {
        return entityManager.createQuery("SELECT p FROM Shop p", ProductCategory.class).getResultList();
    }

    @Override
    public List<ProductCategoryDto> findAllDto() {
        return entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.ProductCategoryDto("+
                "p.id,p.category) FROM ProductCategory p", ProductCategoryDto.class).getResultList();
    }

    @Override
    public Optional<ProductCategoryDto> findCategoryIdDto(Integer id) {
        TypedQuery<ProductCategoryDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.ProductCategoryDto(" +
                "p.id, p.category) FROM ProductCategory p WHERE p.id = :idParm", ProductCategoryDto.class);

        query.setParameter("idParm", id);

        try{
            return Optional.of(query.getSingleResult());

        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductCategoryDto> findAlreadyExistProductCategoryDto(String name) {
        TypedQuery<ProductCategoryDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.ProductCategoryDto(" +
                "p.id, p.category) FROM ProductCategory p WHERE p.category = :nameParm", ProductCategoryDto.class);

        query.setParameter("nameParm", name);

        try{
            return Optional.of(query.getSingleResult());
        } catch(NoResultException e){
            return Optional.empty();
        }
    }
}
