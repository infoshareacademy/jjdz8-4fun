package com.infoshare.fourfan.domain.access;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    @DisplayName("Verifies as group assertions if user created/exists with input necessary parameters (email, password, name, surName & phoneNumber) provided in constructor's arguments")
    public void testIfUserCreatedForValidLoginAndPassword() {
        User user = new User("Peter@gmail.com", "peter-password", "Peter", "Kowalski", "512222999", false);

        assertAll(() -> assertEquals("Peter@gmail.com", user.getEmail()),
                () -> assertEquals("peter-password", user.getPassword()),
                () -> assertEquals("Peter", user.getName()),
                () -> assertEquals("Kowalski", user.getSurName()),
                () -> assertEquals("512222999", user.getPhoneNumber()),
                () -> assertEquals(false, user.isAdmin()),
                () -> assertNotEquals("Kowalcki", user.getSurName()),
                () -> assertNotEquals("512229999", user.getPhoneNumber()));
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException thrown in case of empty email")
    public void testIfExceptionThrownInCaseOfEmptyEmail() {

        assertThrows(IllegalArgumentException.class, () -> new User("", "peter-password", "Peter", "Kowalski", "512222999", false));
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException thrown in case of blank email")
    public void testIfExceptionThrownInCaseOfBlankEmail() {

        assertThrows(IllegalArgumentException.class, () -> new User(" ", "peter-password", "Peter", "Kowalski", "512222999", false));
    }


    @Test
    @DisplayName("Checks that user shoule have false admin credentials")
    public void testIfAdminCredentialsSetUpInCaseOfTrueValue() {
        User user = new User("Peter@gmail.com", "peter-password", "Peter", "Kowalski", "512222999", false);
        // When & then
        assertThat(user.isAdmin()).isFalse();
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException thrown in case of empty password")
    public void testIfExceptionThrownInCaseOfEmptyPassword() {

        assertThrows(IllegalArgumentException.class, () -> new User("Peter@gmail.com", "", "Peter", "Kowalski", "512222999", false));
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException thrown in case of blank password")
    public void testIfExceptionThrownInCaseOfBlankPassword() {

        assertThrows(IllegalArgumentException.class, () -> new User("Peter@gmail.com", " ", "Peter", "Kowalski", "512222999", false));
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException was thrown in case of default constructor creation")
    public void testIfExceptionThrownForDefaultConstructor() {

        assertThrows(IllegalArgumentException.class, () -> new User());
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException thrown in case of null email")
    public void testIfExceptionThrownForNullEmail() {

        assertThrows(IllegalArgumentException.class, () -> new User(null, "peter-password", "Peter", "Kowalski", "512222999", false));
    }

    @Test
    @DisplayName("Checks if IllegalArgumentException thrown in case of null password")
    public void testIfExceptionThrownForNullPassword() {

        assertThrows(IllegalArgumentException.class, () -> new User("Peter@gmail.com", null, "Peter", "Kowalski", "512222999", false));
    }

    @Test
    @DisplayName("Checks if true returned if user has administrator's credentials")
    public void testIfUserisAdmin() {
        // given
        User user = new User("Peter@gmail.com", "peter-password", "Peter", "Kowalski", "512222999", false);

        // when
        boolean result = user.isAdmin();

        // then
        assertFalse(result);
    }


    @Test
    @DisplayName("Checks if IllegalArgumentException thrown in case of empty phone number")
    public void testIfExceptionThrownInCaseOfEmptyPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new User("Peter@gmail.com", "password", "Peter", "Kowalski", "", false));
    }

    @Test
    @DisplayName("Checks if phone number set up for valid data input")
    public void testIfPhoneNumberSetUpAfterValidDataInput() {
        User user = new User("Peter@gmail.com", "peter-newPassword", "Peter", "Kowalski", "512222999", false);
        assertEquals("512222999", user.getPhoneNumber());
    }

    @Test
    @DisplayName("Check if password set up accurately after valid data input")
    public void testIfPasswordSetUpAfterValidDataInput() {
        User user = new User("Peter@gmail.com", "peter-newPassword", "Peter", "Kowalski", "512222999", false);
        assertEquals("peter-newPassword", user.getPassword());
    }

    @Test
    @DisplayName("Check if toString() is generated properly")
    public void checkIfToStringGeneratedAccurately() {
        User user = new User("Peter@gmail.com", "peter-Password", "Peter", "Kowalski", "512222999", false);

        assertEquals("User{" +
                "1. email=" + "Peter@gmail.com" + '\'' +
                " 2. Imie=" + "Peter" + '\'' +
                " 3. Nazwisko=" + "Kowalski" + '\'' +
                " 4. Numer telefonu=" + "512222999" + '\'' +
                " 5. Czy to admin?=" + false +
                '}', user.toString());
    }
}