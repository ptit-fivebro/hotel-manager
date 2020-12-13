package com.springframework.hotel.validator;

import com.springframework.hotel.dto.LoginRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class LoginValidator implements Validator {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(LoginRequest.class);
    }

    @Override
    public void validate(Object object, Errors errors) {
        // Thực hiện validate ở đây
        LoginRequest loginRequest = (LoginRequest) object;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.e001");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.e001");
        if(loginRequest.getPassword().length() < 6){
            errors.rejectValue("password", "password.e002");
        }
        if(!checkEmail(loginRequest.getEmail())){
            errors.rejectValue("email", "email.e002");
        }
    }

    private boolean checkEmail(String email){
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
