package com.sample.framework.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sample.framework.ui.controls.Control;

public class Page {

  private WebDriver driver;

	public Page(WebDriver driver) {
		super();
		this.driver = driver;
		
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public Page navigate() {
		return this;
	}
	
	public void navigate(String url) {
		this.getDriver().get(url);
	}
	public String getTitle() {
		return getDriver().getTitle();
	}
	public void maximiseWindow() {
	    this.getDriver().manage().window().maximize();
   
	}
	

	public boolean isTextPresent(String text) {
		
		String locator=String.format("//*[text()= '%s' or contains(text(),%s)]",text,text);
		
		Control element =new Control(this,By.xpath(locator));
		
		return element.exists();
		
	}


	public void get(String string) {
		// TODO Auto-generated method stub
		this.get(string);
		
	}

	public void quit() {
		// TODO Auto-generated method stub
		this.getDriver().close();
		
	}
}
