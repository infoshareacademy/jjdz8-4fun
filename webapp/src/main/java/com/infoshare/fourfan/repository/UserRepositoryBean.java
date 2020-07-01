package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.access.User;
import com.infoshare.fourfan.storage.UserDb;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class UserRepositoryBean implements UserRepository {


    @Override
    public void add(User user) {
        getUsersRepository().add(user);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return findAllUsers()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public Optional<User> findUserBySurName(String surName) {
        return findAllUsers()
                .stream()
                .filter(user -> user.getSurName().equals(surName))
                .findFirst();
    }

//    @Override
//    public void deleteUser(User user) {
//      UserRepository.de
//
//    }

    public List<User> findAllUsers() {
        return UserDb.getUserRepository();
    }

    @Override
    public List<String> printAllUsersNames() {
        return findAllUsers()
                .stream()
                .map(user -> user.getName())
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public boolean doesUserByEmailExist(String email) {
        Optional<User> user = findUserByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

//    public static boolean containsUser(User user) {
//        List<User> repository = getUsersRepository();
//        for (User userFromList : repository) {
//            if (userFromList.getEmail() == user.getEmail()) {
//                return true;
//            }
//        }
//        return false;
//    }


}
