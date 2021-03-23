package com.sample.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Control;

public class WomenPage extends Page {
	
	public Control colorOption;  
	public Control blockProduct ;
	public Control allSpecialsLink;
	public Control specialProductsList;

	public WomenPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		colorOption=new Control(this,By.linkText("Pink (1)"));
		blockProduct=new Control(this,By.cssSelector(".ajax_block_product:nth-child(5) .replace-2x"));
		allSpecialsLink=new Control(this,By.cssSelector(".products-block .btn > span"));
		specialProductsList=new Control(this,By.cssSelector(".product_list"));
	}

}
