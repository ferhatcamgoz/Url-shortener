package com.urlshortener.demo.user;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqeUserNameValidator implements ConstraintValidator<UniqeUserName,String> {

    @Autowired
    UserRepository userRepository;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
       if(userRepository.findByUserName(s)==null){

           return true;
       }
        return false;
    }
}
