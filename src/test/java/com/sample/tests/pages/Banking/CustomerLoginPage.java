package com.sample.tests.pages.Banking;

import org.openqa.selenium.WebDriver;

import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.SelectList;

public class CustomerLoginPage extends Page {
	
	@FindBy(locator="userSelect")
	public SelectList selectUser;
	
	@FindBy(locator = "//button[text() = 'Login']", excludeFromSearch = true)
	public SelectList loginButton;

	public CustomerLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	

}
