package com.samples.framework.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sample.framework.ui.controls.Control;

public class WomenPage extends Page {
	
	public Control colorOption;  
	public Control blockProduct ;
	public Control allSpecialsLink;
	public Control specialProductsList;

	public WomenPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		Control colorOption=new Control(this,By.linkText("Pink (1)"));
		Control blockProduct=new Control(this,By.cssSelector(".ajax_block_product:nth-child(5) .replace-2x"));
		Control allSpecialsLink=new Control(this,By.cssSelector(".products-block .btn > span"));
		Control specialProductsList=new Control(this,By.cssSelector(".product_list"));

	}

}
