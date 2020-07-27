package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.db_Shop;
import com.infoshare.fourfan.dto.db_ShopDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


@Stateless
public class db_ShopDaoBean implements db_ShopDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(db_Shop shop) {
        entityManager.persist(shop);
    }

    @Override
    public void update(db_Shop shop) {
        entityManager.merge(shop);
    }

    @Override
    public void delete(db_Shop shop) {
        entityManager.remove(shop);
    }

    @Override
    public Optional<db_Shop> findById(Integer id) {
        return Optional.of(entityManager.find(db_Shop.class, id));
    }

    @Override
    public List<db_Shop> findAll() {
        return entityManager.createQuery("SELECT p FROM db_Shop p", db_Shop.class).getResultList();
    }

    @Override
    public List<db_ShopDto> findAllDto() {
        return entityManager.createQuery("SELECT new com.infoshare.fourfan.dto.db_ShopDto("+
                "p.id,p.shop) FROM db_Shop p", db_ShopDto.class).getResultList();
    }
}
