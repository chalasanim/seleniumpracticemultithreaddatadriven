package com.sample.tests.pages.Banking;

import org.openqa.selenium.WebDriver;

import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Control;

public class CustomersCommonPage extends Page {

	public CustomersCommonPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(locator="xpath=//div[@class='center']/strong[2]")
	Control labelBalance;
	
	@FindBy(locator="accountSelect")
	Control AccountSelect;
	
	@FindBy(locator="//button[contains(text()='WithDraw')]")
	Control buttonWithDraw;
	
	@FindBy(locator="//button[contains(text()='Deposit')]")
	Control buttonDeposit;
	
	@FindBy(locator="//button[contains(text()='Transactions')]")
	Control buttonTransactions;
	
	
	
}
