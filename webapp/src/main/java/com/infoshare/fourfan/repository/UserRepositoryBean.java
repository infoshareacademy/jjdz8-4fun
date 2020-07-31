package com.infoshare.fourfan.repository;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.List;

import com.infoshare.fourfan.domain.access.User;
import com.infoshare.fourfan.domain.access.Users;
import com.infoshare.fourfan.service.JsonServiceForUser;

import java.util.Optional;

@Stateless
public class UserRepositoryBean implements UserRepository {

    public void addUserToJson(User user) throws IOException {
        Users usersList = JsonServiceForUser.readUsersFromJsonFile();
        usersList.add(user);
        JsonServiceForUser.saveUsersToJsonFile(usersList);
    }

    @Override
    public List<User> findUsersForJson() {
        return JsonServiceForUser.readUsersFromJsonFile().getUsers();
    }

    public Optional<User> findUserByEmailAndPassword(String email, String password) throws IOException {
        Users usersList = JsonServiceForUser.readUsersFromJsonFile();
        return Optional.ofNullable(usersList.getUsers().stream()
                .filter(e -> e.getEmail().equals(email) && e.getPassword().equals(password)).findFirst().orElse(null));
    }

}
