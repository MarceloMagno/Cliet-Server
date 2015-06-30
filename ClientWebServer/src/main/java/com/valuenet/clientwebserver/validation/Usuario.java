package com.valuenet.clientwebserver.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/*******************************************************************************
*                          Copyright (C) 2015 ValueNET
* ------------------------------------------------------------------------------
* Author: MMB                       date: 22/06/2015
* 
* Name: @interface Usuario.java
* 
*******************************************************************************/
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "([a-zA-Z]{2}\\d{4,18})?")
public @interface Usuario {
	
	@OverridesAttribute(constraint = Pattern.class, name="messagePassword")
	String messagePassword() default "{com.valuenet.clientwebserver.model.validate.Usuario.messagePassword}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

}
