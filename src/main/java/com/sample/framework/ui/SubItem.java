package com.sample.framework.ui;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.sample.framework.Platform;
import com.sample.framework.ui.controls.Control;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(SubItems.class)
@Target(ElementType.FIELD)

public @interface SubItem {

	String name();
	String locator() default "";	
    Platform platform() default Platform.ANY;	
    Class<? extends Control> controlType() default Control.class;

}
