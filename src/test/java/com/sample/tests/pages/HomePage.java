package com.sample.tests.pages;

import org.openqa.selenium.WebDriver;

import com.sample.framework.Configuration;
import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Control;

public class HomePage extends Page {

	@FindBy(locator="linkText=Sign in")
	public Control signinLink;
	
	@FindBy(locator="linkText=Women")
	public Control menuLinkWomen;
	
	@FindBy(locator="linkText=Dresses")
	public Control menuLinkDresses;	
	
	@FindBy(locator="linkText=T-shirts")
	public Control menuLinkTshirts;

	@FindBy(locator="css=.alert")
	public Control cartAlertTextInfo;
	
	@FindBy(locator="css=a.homefeatured")
	public Control homePopularItemsBlock;
	
	@FindBy(locator="css=a.blockbestsellers")
	public Control bestSellersItemsBlock;

    
	public HomePage(WebDriver driver) {
		super(driver);

	}
	
	@Override
	public Page navigate() {		
		String baseUrl=Configuration.get("url");
		this.getDriver().get(baseUrl);	
		return this;
	}
	
	
	

	
	
}
