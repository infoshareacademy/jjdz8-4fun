package com.infoshare.fourfan.domain.access.validator;

public class UserNameValidator {
    private static final String USER_NAME_INVALID_CHAR = "^(?=.*[!@#]).*$";

    public boolean isUserNameValid(String petName) {
        if (petName.isEmpty()) {
            return false;
        }
        return !petName.matches(USER_NAME_INVALID_CHAR);
    }
}
