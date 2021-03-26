package com.sample.tests.pages.Banking;

import org.openqa.selenium.WebDriver;

import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Control;

public class BankingHomePage extends Page {
	
	 @FindBy(locator = "//button[text() = 'Customer Login']")
	  public Control buttonCustomerLogin;
	    
	 @FindBy(locator = "//button[text() = 'Bank Manager Login']")
	  public Control buttonBankManagerLogin;

	public BankingHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public CustomersCommonPage loginAsCustomer(String name) throws Exception {
		
		CustomerLoginPage loginPage=this.buttonCustomerLogin.clickAndWaitFor(CustomerLoginPage.class);
		loginPage.selectUser.selectByText(name);
		return loginPage.loginButton.clickAndWaitFor(CustomersCommonPage.class);
		
	}
}
