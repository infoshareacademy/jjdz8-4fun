package com.infoshare.fourfun.domain.access;

import com.infoshare.fourfan.domain.access.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
//TODO check Junit library correct implementation for @Test to work
    @Test
    @DisplayName("Verifies if object UserBuilder created/exists with input name an surname data provided in method's parameter")
    public void testIfUserBuilderCreatedCorrectlyForValidNameAndSurname() {
        User user = new User.UserBuilder("Piotr","Kowalski")
                .build();
        System.out.println(user);
    }
}