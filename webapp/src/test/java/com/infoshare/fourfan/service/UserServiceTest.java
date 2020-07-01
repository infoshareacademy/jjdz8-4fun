package com.infoshare.fourfan.service;

import com.infoshare.fourfan.domain.access.User;
import com.infoshare.fourfan.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private List<User> users;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void add() {
    }

    @Test
    void doesUserByEmailExist() {
    }

    @Test
    void findUserByEmail() {
    }

    @Test
    void findUserBySurName() {
    }

    @Test
    void findAllUsers() {
    }

    @Test
    void printAllUsersNames() {
    }
}