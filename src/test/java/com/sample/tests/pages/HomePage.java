package com.sample.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sample.framework.Configuration;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Control;
import com.sample.framework.ui.controls.Edit;

public class HomePage extends Page {

	public Control signinLink;
	public Control menuLinkWomen;
	public Control menuLinkDresses;


	public HomePage(WebDriver driver) {
		super(driver);
		 signinLink=new Control(this,By.linkText("Sign in"));
		 menuLinkWomen=new Control(this,By.linkText("Women"));
		 menuLinkDresses=new Control(this,By.linkText("Dresses"));

	}
	
	@Override
	public Page navigate() {		
		String baseUrl=Configuration.get("url");
		this.getDriver().get(baseUrl);	
		return this;
	}
	
	
	

	
	
}
