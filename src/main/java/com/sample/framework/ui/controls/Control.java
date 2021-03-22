package com.sample.framework.ui.controls;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sample.framework.Configuration;

public class Control {
	
	private static final long TIMEOUT = Configuration.timeout();
	private WebDriver driver;
	private By locator;

	public Control(WebDriver driver,By locator) {
		// TODO Auto-generated constructor stub
		super();
		this.driver=driver;
		this.locator=locator;
	}
	
	public WebElement getElement() {
		return driver.findElement(locator);
	}
	
	public boolean exists(long timeout) {		
	 WebDriverWait wait =new WebDriverWait(driver,timeout);	 
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
		this.getElement().click();
	}

	public String getText() {
		// TODO Auto-generated method stub
		return this.getElement().getText();
	}


	
}
