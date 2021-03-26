package com.sample.tests.pages.Banking;

import org.openqa.selenium.WebDriver;

import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Control;
import com.sample.framework.ui.controls.Edit;

public class AddCustomerPage extends Page {

	public AddCustomerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(locator="xpath=//input[@type='text']")
	public Edit editFirstName;
	@FindBy(locator="xpath=(//input[@type='text'])[2]")
	public Edit editLastName;
	@FindBy(locator="xpath=(//input[@type='text'])[3]")
	public Edit editPostCode;
	@FindBy(locator="xpath=//button[contains(text(),'Customers')]")
	public Control buttonCustomers;
	@FindBy(locator="xpath=//button[@type='submit']")
	public Edit buttonAddCustomer;
	
	
	@Override
	public Page navigate() throws Exception{
		return this.buttonAddCustomer.clickAndWaitFor(this.getClass());
	}


	
}
