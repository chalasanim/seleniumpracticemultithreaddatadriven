package com.sample.tests.pages;

import org.openqa.selenium.WebDriver;

import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Control;

public class ViewDressPage extends Page {

	@FindBy(locator="css=a[title='Pink']")
	public Control colorCheckbox ;

	@FindBy(locator="css=p#add_to_cart>button span")
	public Control addToCartButton ;
	
	@FindBy(locator="css=span[title='Continue shopping']>span")
	public Control continueShoppingOption ;

	@FindBy(locator="linkText=Sign out")
	public Control signoutLink ;
	
	@FindBy(locator="css=.ajax_cart_quantity:nth-child(2)")
	public Control cartStatus ;

	public ViewDressPage(WebDriver driver) {
		super(driver);
	}

	
	@Override
	public Page navigate() {		
		String dressPageUrl="http://automationpractice.com/index.php?id_product=4&controller=product";
		this.getDriver().get(dressPageUrl);	
		return this;
	}
	
}
