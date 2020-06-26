package com.infoshare.fourfan.domain.access;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    @DisplayName("Verifies as group assertions if user created/exists with input necessary parameters (email, password, name, surName & phoneNumber) provided in constructor's arguments")
    public void testIfUserCreatedForValidLoginAndPassword() {
        User user = new User("Peter@gmail.com", "peter-password", "Peter", "Kowalski", "512222999");

        assertAll(
                () -> assertEquals("peter-password", user.getPassword()),
                () -> assertEquals("Peter", user.getName()),
                () -> assertEquals("Kowalski", user.getSurName()),
                () -> assertEquals("512222999", user.getPhoneNumber()),
                () -> assertNotEquals("Kowalcki", user.getSurName()),
                () -> assertNotEquals("512229999", user.getPhoneNumber()));
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException thrown in case of empty email")
    public void testIfExceptionThrownInCaseOfEmptyEmail() {

        assertThrows(IllegalArgumentException.class, () -> new User("", "peter-password", "Peter", "Kowalski", "512222999"));
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException thrown in case of blank email")
    public void testIfExceptionThrownInCaseOfBlankEmail() {

        assertThrows(IllegalArgumentException.class, () -> new User(" ", "peter-password", "Peter", "Kowalski", "512222999"));
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException thrown in case of empty password")
    public void testIfExceptionThrownInCaseOfEmptyPassword() {

        assertThrows(IllegalArgumentException.class, () -> new User("Peter@gmail.com", "", "Peter", "Kowalski", "512222999"));
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException thrown in case of blank password")
    public void testIfExceptionThrownInCaseOfBlankPassword() {

        assertThrows(IllegalArgumentException.class, () -> new User("Peter@gmail.com", " ", "Peter", "Kowalski", "512222999"));
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException was thrown in case of default constructor creation")
    public void testIfExceptionThrownForDefaultConstructor() {

        assertThrows(IllegalArgumentException.class, () -> new User());
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException thrown in case of null email")
    public void testIfExceptionThrownForNullEmail() {

        assertThrows(IllegalArgumentException.class, () -> new User(null, "peter-password", "Peter", "Kowalski", "512222999"));
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException thrown in case of null password")
    public void testIfExceptionThrownForNullPassword() {

        assertThrows(IllegalArgumentException.class, () -> new User("Peter@gmail.com", null, "Peter", "Kowalski", "512222999"));
    }
}