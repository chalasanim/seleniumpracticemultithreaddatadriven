package com.sample.framework.ui.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.samples.framework.ui.Page;

public class Edit extends Control {
	
	private Control edit;

	private String value;

	public Edit(Page pageValue, By locator,String value) {
		super(pageValue, locator);
		// TODO Auto-generated constructor stub
	}
	
	public void setValue(String value ) {
		this.click();
		this.getElement().clear();
		this.getElement().sendKeys(value);
	}

}
