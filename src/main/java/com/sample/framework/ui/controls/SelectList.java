package com.sample.framework.ui.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectList extends Control {

	public SelectList(WebDriver driver, By locator,String text) {
		super(driver, locator);
		// TODO Auto-generated constructor stub
	}

	public Select getSelect() {
		return new Select(this.getElement());
	}
	
	public void selectByText(String text) {
		this.exists();
		this.getSelect().selectByVisibleText(text);
	}
	
	
}
