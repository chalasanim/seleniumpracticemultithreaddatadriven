package com.sample.framework.ui;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.sample.framework.Platform;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.RetentionPolicy;

@Repeatable(FindByList.class)
@Target(ElementType.FIELD)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface FindBy {
	String locator();
	Platform platform() default Platform.ANY;
	boolean excludeFromSearch() default false;
	String itemLocator() default "";
}
