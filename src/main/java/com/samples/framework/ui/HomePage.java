package com.samples.framework.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.sample.framework.Configuration;
import com.sample.framework.ui.controls.*;

public class HomePage extends Page {
	
	public Control signinLink;
	public Control menuLinkWomen ;	
	public Control menuLinkDresses ;    

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		Control signinLink=new Control(this,By.linkText("Sign in"));
		Control menuLinkWomen=new Control(this,By.linkText("Women"));
		Control menuLinkDresses=new Control(this,By.linkText("Dresses"));
	}
	
	@Override
	public Page navigate() {		
		String baseUrl=Configuration.get("url");
		this.getDriver().get(baseUrl);	
		return this;
	}
	public void maximiseWindow() {
	    this.getDriver().manage().window().maximize();
	}
	

}
