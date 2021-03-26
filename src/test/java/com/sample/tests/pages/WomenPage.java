package com.sample.tests.pages;

import org.openqa.selenium.WebDriver;

import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Control;

public class WomenPage extends Page {
	
	@FindBy(locator="linkText=Pink (1)")
	public Control colorOption;  
	
	@FindBy(locator="css=.ajax_block_product:nth-child(5) .replace-2x")
	public Control blockProduct ;
	
	@FindBy(locator="css=.products-block .btn > span")
	public Control allSpecialsLink;
	
	@FindBy(locator="css=.product_list")
    public Control specialProductsList;
	
	@FindBy(locator="css=#ul_layered_id_attribute_group_3 > li")
	public Control pickColorLisItem;	
	
	
	
	public WomenPage(WebDriver driver) {
		super(driver);

	}

	
		

}
