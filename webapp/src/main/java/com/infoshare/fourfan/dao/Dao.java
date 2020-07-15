package com.infoshare.fourfan.dao;

import com.infoshare.fourfan.domain.datatypes.Product;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface Dao<T> {

    void save(T t);

    void update(T t);

    void delete(T t);

    Optional<T> findById(Integer id);

    Product findByName(String name);

    List<T> findAll();

}
