package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.Shop;
import com.infoshare.fourfan.dto.ShopDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Stateless
public class ShopDaoBean implements ShopDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Shop shop) {
        entityManager.persist(shop);
    }

    @Override
    public void update(Shop shop) {
        entityManager.merge(shop);
    }

    @Override
    public void delete(Shop shop) {
        entityManager.remove(shop);
    }

    @Override
    public Optional<Shop> findById(Integer id) {
        return Optional.of(entityManager.find(Shop.class, id));
    }

    @Override
    public List<Shop> findAll() {
        return entityManager.createQuery("SELECT p FROM Shop p", Shop.class).getResultList();
    }

    @Override
    public List<ShopDto> findAllDto() {
        return entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.ShopDto("+
                "p.id,p.shop) FROM Shop p", ShopDto.class).getResultList();
    }

    @Override
    public Optional<ShopDto> findShopIdDto(Integer id) {
        TypedQuery<ShopDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.ShopDto(" +
                "p.id, p.shop) FROM Shop p WHERE p.id = :idParm", ShopDto.class);

        query.setParameter("idParm", id);

        try{
            return Optional.of(query.getSingleResult());

        } catch(NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<ShopDto> findAlreadyExistShopDto(String name) {
        TypedQuery<ShopDto> query = entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.ShopDto(" +
                "p.id, p.shop) FROM Shop p WHERE p.shop = :nameParm", ShopDto.class);

        query.setParameter("nameParm", name);

        try{
            return Optional.of(query.getSingleResult());
        } catch(NoResultException e){
            return Optional.empty();
        }
    }
}
