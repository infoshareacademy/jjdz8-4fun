package com.infoshare.fourfan.domain;

import com.infoshare.fourfan.domain.access.User;

public class TestDomain {
    public static void main(String[] args) {

        User user1 = new User.UserBuilder("Piotr", "Kowalski")
                .phoneNumber("512356467")
                .email("p.kowalski@gmail.com")
                .password("piotrK-password")
                .isAdmin(false)
                .build();

        System.out.println(user1);
    }
}