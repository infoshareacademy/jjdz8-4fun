package com.infoshare.fourfan.domain.access.validator;

import java.util.regex.Pattern;

public class UserEmailValidator {
    private static final String USER_EMAIL_INVALID_CHAR ="^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";

    public boolean isUserEmailValid(String getEmail){
        if(getEmail.isEmpty()){
            return false;
        }
        return !getEmail.matches(USER_EMAIL_INVALID_CHAR);
    }
}
