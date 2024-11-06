package com.cb.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.cb.enums.CategoryTypes;

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotation {

	String[] author() default {};
	CategoryTypes[] category() default{};
}
