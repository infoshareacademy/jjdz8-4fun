package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.access.User;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface UserRepository {

    void add(User user);

    boolean doesUserByEmailExist(String email);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserBySurName(String surName);

//    void deleteUser(User user);

    List<String> printAllUsersNames();
}
