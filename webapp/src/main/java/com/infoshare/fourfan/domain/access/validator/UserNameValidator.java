package com.infoshare.fourfan.domain.access.validator;

public class UserNameValidator {
    private static final String USER_NAME_INVALID_CHAR = "^(?=.*[!@#]).*$";

    public boolean isUserNameValid(String userName) {
        if (userName.isEmpty()) {
            return false;
        }
        return !userName.matches(USER_NAME_INVALID_CHAR);
    }
}
