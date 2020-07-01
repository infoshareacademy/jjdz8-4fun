package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.access.User;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface UserRepository {

    public void add(User user);

    public boolean doesUserExist(String email);

    public Optional<User> findByEmailUser(String email);


    public void deleteUser(User user);

    public List<User> getAllUsers();
}
