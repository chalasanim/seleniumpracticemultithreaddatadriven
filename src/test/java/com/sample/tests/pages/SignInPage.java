package com.sample.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sample.framework.Configuration;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Control;
import com.sample.framework.ui.controls.Edit;

public class SignInPage extends Page {
	
	public Edit email ;
	public Edit password ;
	public Control submitButton ;

	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	     email=new Edit(this,By.id("email"));
		 password=new Edit(this,By.id("passwd"));
	     submitButton=new Control(this,By.cssSelector("#SubmitLogin > span"));
	}

}
