package com.urlshortener.demo.user;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {UniqeUserNameValidator.class}
)
public @interface UniqeUserName {
    String message() default "Kullanıcı adı uniqe olmalı";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};
}
