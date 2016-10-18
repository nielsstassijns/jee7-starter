package com.realdolmen.course.domain;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AntiProfanityValidator implements ConstraintValidator<AntiProfanity, String> {
	 
	@Override
	public void initialize(AntiProfanity constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	 public boolean isValid(String value, ConstraintValidatorContext context) {    
		  if (value.contains("shit") ||
				  value.contains("fuck")){
			  return false;
		  }
		  else {
			  return true;
		  }
	 }

	
	
}
