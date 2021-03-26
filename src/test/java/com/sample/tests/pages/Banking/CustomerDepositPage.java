package com.sample.tests.pages.Banking;

import org.openqa.selenium.WebDriver;

import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Control;
import com.sample.framework.ui.controls.Edit;


public class CustomerDepositPage extends Page {

	public CustomerDepositPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
   
	@FindBy(locator="xpath=//input[@type='number']")
	Edit editDepositAmount;
	
	
	@FindBy(locator="//button[text(),'Deposit' and @type='submit']")
	Control buttonDeposit;
	
	@Override
	public Page navigate() throws Exception{
		this.buttonDeposit.click();
		return this;
		
	}
	
}
