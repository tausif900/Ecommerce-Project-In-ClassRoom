package com.study.ecommerce.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

//	Annotations are nothing but the interface, when we want to create our custom annotation we put '@' before interface.

@Documented // to register the annotation we have created.
@Retention(RetentionPolicy.RUNTIME) // to available our annotation on runtime.
@Target(ElementType.TYPE) // type represent class level annotation,means we put annotation on class.
@Constraint(validatedBy = PasswordMatchValidator.class)
public @interface PasswordMatch {
	String message() default "confirm password doesn't match with password";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
