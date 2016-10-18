package com.realdolmen.course.domain;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = {AntiProfanityValidator.class}) // filled in! 
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER}) 
@Retention(RetentionPolicy.RUNTIME) 
public @interface AntiProfanity {
	
	 String message() default "Profane message";    
	 Class<?>[] groups() default {};    
	 Class<? extends Payload>[] payload() default {};

}
