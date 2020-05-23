package com.infoshare.fourfan.domain.access;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    @DisplayName("Verifies if user created/exists with input login and password provided in constructor's arguments")
    public void testIfUserCreatedForValidLoginAndPassword() {
        // given & when
        User user = new User("Peter", "peter-password");

        // then
        assertAll(() -> assertEquals("Peter", user.getLogin()),
                () -> assertEquals("peter-password", user.getPassword()),
                () -> assertNotEquals("peter", user.getLogin()));
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException thrown in case of empty/blank login")
    public void testIfExceptionThrownInCaseOfEmptyLogin() {
        // given, when & then
        assertThrows(IllegalArgumentException.class, () -> new User("", "password"));
        assertThrows(IllegalArgumentException.class, () -> new User(" ", "password"));
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException thrown in case of empty/blank password")
    public void testIfExceptionThrownInCaseOfEmptyPassword() {
        // given, when & then
        assertThrows(IllegalArgumentException.class, () -> new User("Peter", ""));
        assertThrows(IllegalArgumentException.class, () -> new User("Peter", " "));
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException was thrown in case of default constructor creation")
    public void testIfExceptionThrownForDefaultConstructor() {
        // given, when & then
        assertThrows(IllegalArgumentException.class, () -> new User());
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException thrown in case of null login")
    public void testIfExceptionThrownForNullLogin() {
        // given, when & then
        assertThrows(IllegalArgumentException.class, () -> new User(null, "password-check"));
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException thrown in case of null password")
    public void testIfExceptionThrownForNullPassword() {
        // given, when & then
        assertThrows(IllegalArgumentException.class, () -> new User("Peter", null));
    }
}