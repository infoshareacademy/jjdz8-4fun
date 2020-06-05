package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.access.User;
import com.infoshare.fourfan.domain.access.Users;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.json.JsonReader;
import java.util.List;
import java.util.Optional;

import static com.infoshare.fourfan.domain.access.Users.getUsers;

@RequestScoped
@Named("UserRepositoryBean")
public class UserRepositoryBean implements UserRepository {
    private final Users users = JsonReader.create(new Users(), FileNames.USERS_JSON);

    @Override
    public void save(User user) {
        getUsers().add(user);
    }

    @Override
    public void deleteUser(User user) {


    }

    @Override
    public boolean containsUser(User user) {
        return false;
    }

    @Override
    public boolean isPasswordCorrect(User user, String password) {
        return false;
    }

    @Override
    public void changePassword(String email, String password) {

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return findAll()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public Optional<User> findByName(String name) {
        return findAll()
                .stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();
    }

    @Override
    public Optional<User> findBySurName(String surName) {
        return findAll()
                .stream()
                .filter(user -> user.getSurName().equals(surName))
                .findFirst();
    }

    @Override
    public Optional<User> findByPhoneNumber(String phoneNumber) {
        return findAll()
                .stream()
                .filter(user -> user.getPhoneNumber().equals(phoneNumber))
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return getUsers();
    }
}