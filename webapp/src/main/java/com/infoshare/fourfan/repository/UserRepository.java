package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.access.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    public void save(User user);

    public void deleteUser (User user);

    public boolean containsUser(User user);

    public boolean isPasswordCorrect(User user, String password);

    public void changePassword(String email, String password);

    public Optional<User> findByEmail(String email);

    public Optional<User> findByName(String name);

    public Optional<User> findBySurName(String surName);

    public Optional<User> findByPhoneNumber(String phoneNumber);

    public List<User> findAll();
}
