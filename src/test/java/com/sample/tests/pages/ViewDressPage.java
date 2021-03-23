package com.sample.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sample.framework.Configuration;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Control;

public class ViewDressPage extends Page {

	public Control addToCartButton ;
	public Control continueShoppingOption ;
	public Control colorCheckbox ;

	public Control signoutLink ;
	public Control cartStatus ;

	public ViewDressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		 colorCheckbox=new Control(this,By.cssSelector("a[title='Pink']"));
		 addToCartButton=new Control(this,By.cssSelector("p#add_to_cart>button span"));
		 continueShoppingOption=new Control(this,By.cssSelector("span[title='Continue shopping']>span"));
		 signoutLink=new Control(this,By.linkText("Sign out"));
		 cartStatus=new Control(this ,By.cssSelector(".ajax_cart_quantity:nth-child(2)"));
	}

	
	@Override
	public Page navigate() {		
		String dressPageUrl="http://automationpractice.com/index.php?id_product=4&controller=product";
		this.getDriver().get(dressPageUrl);	
		return this;
	}
	
}
