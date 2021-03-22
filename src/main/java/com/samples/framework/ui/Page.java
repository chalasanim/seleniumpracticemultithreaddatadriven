package com.samples.framework.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sample.framework.ui.controls.Control;

public class Page {

WebDriver driver;
public Control signoutLink ;
public Control cartStatus ;



	public Page(WebDriver driver) {
		super();
		this.driver = driver;
		Control signoutLink=new Control(this,By.linkText("Sign out"));
		Control cartStatus=new Control(this ,By.cssSelector(".ajax_cart_quantity:nth-child(2)"));
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public String getTitle() {
		return this.getTitle();
	}
	

	public boolean isTextPresent(String text) {
		
		String locator=String.format("*//[text()='%s' or contains(text(),'%s')]",text,text);
		
		Control element =new Control(this,By.xpath(locator));
		
		return element.exists();
		
	}

	 
	public Page navigate() {
		return this;
	}

	public void get(String string) {
		// TODO Auto-generated method stub
		this.get(string);
		
	}

	public void quit() {
		// TODO Auto-generated method stub
		driver.close();
		
	}
}
