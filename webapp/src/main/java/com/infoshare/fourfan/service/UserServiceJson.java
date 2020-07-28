package com.infoshare.fourfan.service;

import com.infoshare.fourfan.domain.access.User;
import com.infoshare.fourfan.repository.UserRepository;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.io.IOException;
import java.util.Optional;

@RequestScoped
public class UserServiceJson {

    @EJB
    UserRepository userRepository;

    public void createNewUser(User user) throws IOException { userRepository.addUserToJson(user);
    }

    public Optional<User> findByEmailAndPassword(String email, String password) throws IOException {
        return userRepository.findUserByEmailAndPassword(email, password);
    }
}
