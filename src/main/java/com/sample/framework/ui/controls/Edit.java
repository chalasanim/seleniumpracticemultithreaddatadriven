package com.sample.framework.ui.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Edit extends Control {
	
	private Control edit;

	private String value;

	public Edit(WebDriver driver, By locator,String value) {
		super(driver, locator);
		// TODO Auto-generated constructor stub
	}
	
	public void setValue(String value ) {
		this.click();
		this.getElement().clear();
		this.getElement().sendKeys(value);
	}

}
