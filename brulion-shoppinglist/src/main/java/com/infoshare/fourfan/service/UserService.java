package com.isa.usersengine.service;


import com.infoshare.fourfan.domain.access.User;
import com.infoshare.fourfan.repository.UserRepository;
import com.infoshare.fourfan.repository.UserRepositoryBean;

import java.util.logging.Logger;

public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    public void save(User user) {
        UserRepository userRepository = new UserRepositoryBean();
        userRepository.save(user);
    }

    public User findByEmail(String email) {
        UserRepository userRepository = new UserRepositoryBean();
        userRepository.findByEmail(email).orElse(null);
    }
}