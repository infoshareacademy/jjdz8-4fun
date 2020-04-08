package pl.fourfun.access;

import java.util.*;

public class Admins {

    private List<Admin> admins = new ArrayList<>();

    public Admins() {
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void add(Admin admin) {
        admins.add(admin);
    }

}
