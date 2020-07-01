package com.infoshare.fourfan.service;

import com.infoshare.fourfan.domain.access.User;
import com.infoshare.fourfan.repository.UserRepository;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class UserService {

    @EJB
    UserRepository userRepository;

    public void add(User user) {
        userRepository.add(user);
    }

    public boolean doesUserByEmailExist(String email) {
        userRepository.doesUserExist(email);
    }

    public User findUserByEmail(String email) {
        return userRepository
                .findUserByEmail(email)
                .orElse(null);
    }

    public User findUserBySurName(String surName) {
        return userRepository
                .findUserBySurName(surname)
                .orElse(null);
    }

    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public List<String> printAllUsersNames() {
        return userRepository.printAllUsersNames();
    }
}