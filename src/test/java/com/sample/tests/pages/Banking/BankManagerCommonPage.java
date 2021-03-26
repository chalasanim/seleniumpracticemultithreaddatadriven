package com.sample.tests.pages.Banking;

import org.openqa.selenium.WebDriver;

import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Control;

public class BankManagerCommonPage extends Page {

	public BankManagerCommonPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(locator="xpath=//button[contains(text(),'Customers')]")
	public Control buttonCustomers;
	
	@FindBy(locator="xpath=//button[contains(text(),'Add Customer')]")
	public Control buttonAddCustomer;
	
	@FindBy(locator="xpath=//button[contains(text(),'Open Account')]")
	protected Control buttonOpenAccount;

}
