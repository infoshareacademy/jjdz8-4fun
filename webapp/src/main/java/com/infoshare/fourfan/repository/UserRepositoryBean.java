package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.access.User;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Stateless
public class UserRepositoryBean implements UserRepository{

    private final UserRepository userRepository;

    public UserRepositoryBean(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean doesUserExist(String email) {

        return userRepository.
        User user = findUser(email);
        if (user!=null){
            return true;
        }
        return false;
    }

    @Override
    public Optional<User> findByEmailUser(String email) {
        return
    }

    public void add(User user) {
        users.add(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository
                .deleteUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository
                .getAllUsers();
    }
}
