package com.sample.tests.pages;

import org.openqa.selenium.WebDriver;

import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Control;
import com.sample.framework.ui.controls.Edit;

public class SignInPage extends Page {
	
	@FindBy(locator="id=email")
	public Edit email ;
	
	@FindBy(locator="id=passwd")
	public Edit password ;
	
	@FindBy(locator="css=#SubmitLogin > span")
	public Control submitButton ;

	public SignInPage(WebDriver driver) {
		super(driver);
			}

}
