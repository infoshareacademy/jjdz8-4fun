package com.infoshare.fourfan.repository;

import com.infoshare.fourfan.domain.access.User;
import javax.ejb.Local;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Local
public interface UserRepository {

    void addUserToJson (User user) throws IOException;

    List<User> findUsersForJson() throws IOException;

    Optional<User> findUserByEmailAndPassword (String login, String password) throws IOException;

}
