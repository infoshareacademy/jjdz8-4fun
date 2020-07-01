package com.infoshare.fourfan.domain.access.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class UserNameValidatorTest {

    private final UserNameValidator userNameValidator = new UserNameValidator();

    @Test
    @DisplayName("Check if name is valid - true expected")
    public void returnTrueIfNameIsValid() {
        // given
        String nameEx = "Tomasz";

        // when
        boolean result = userNameValidator.isUserNameValid(nameEx);

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Check if false returned in case of incorrect name input")
    @ValueSource(strings = {"", "#tomasz", "T!masz", "T@omasz", "#%&*"})
    public void returnFalseInCaseOfInvalidName(String nameEx) {
        // when
        boolean result = userNameValidator.isUserNameValid(nameEx);
        // then
        assertThat(result).isFalse();
    }
}