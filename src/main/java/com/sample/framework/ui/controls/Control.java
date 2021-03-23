package com.sample.framework.ui.controls;



import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sample.framework.Configuration;
import com.sample.framework.ui.Page;

public class Control {
	
	private static final long TIMEOUT = Configuration.timeout();
	private Page parent;
	private By locator;

	public Control(Page parentValue,By locatorValue) {
		// TODO Auto-generated constructor stub
		super();
		this.parent=parentValue;
		this.locator=locatorValue;
	}
	
	
	public WebElement element() {
		return parent.getDriver().findElement(locator);
	}
	
	public WebDriver getDriver() {
		return parent.getDriver();
	}
	
	public boolean exists(long timeout) {		
	 WebDriverWait wait =new WebDriverWait(getDriver(),timeout);	 
	 try {
		 wait.until(ExpectedConditions.elementToBeClickable(locator));		 
	 }catch(TimeoutException e){
	 return false;
	 }	 
	 return true;	 
	}
	
	public boolean exists() {		
		return exists(TIMEOUT)	; 
		}
	
	public void click() {		
		exists();
		this.element().click();
	}

	public String getText() {
		// TODO Auto-generated method stub
		return this.element().getText();
	}


	
}
