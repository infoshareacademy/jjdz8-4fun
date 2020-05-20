package com.infoshare.fourfan.domain.access;

import com.infoshare.fourfan.domain.access.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
//TODO check Junit library correct implementation for @Test to work
    //done: typo error i package name (fourfun instead of fourfan)
    @Test
    @DisplayName("Verifies if object UserBuilder created/exists with input name an surname data provided in method's parameter")
    public void testIfUserBuilderCreatedCorrectlyForValidNameAndSurname() {
        // given

        // when

        // then

        User user = new User.UserBuilder("Piotr","Kowalski")
                .build();
        System.out.println(user);
    }
}