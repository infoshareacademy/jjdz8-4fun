package pl.fourfun.accountaccess;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private List<User> users = new ArrayList<>();

    public Users() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void add(User user) {
        users.add(user);
    }
}