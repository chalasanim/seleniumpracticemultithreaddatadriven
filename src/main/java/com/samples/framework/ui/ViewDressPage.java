package com.samples.framework.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sample.framework.ui.controls.Control;

public class ViewDressPage extends Page {

	public Control addToCartButton ;
	public Control continueShoppingOption ;
	public Control colorCheckbox ;

	public ViewDressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		 Control colorCheckbox=new Control(this,By.cssSelector("a[title='Pink']"));
		 Control addToCartButton=new Control(this,By.cssSelector("p#add_to_cart>button span"));
		 Control continueShoppingOption=new Control(this,By.cssSelector("span[title='Continue shopping']>span"));
	}

}
