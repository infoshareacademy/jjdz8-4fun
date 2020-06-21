package com.infoshare.fourfan.dao;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface Dao<T> {

    void save(T t);

    void update(T t);

    void delete(T t);

    Optional<T> findById(Integer id);

    List<T> findAll();

}
