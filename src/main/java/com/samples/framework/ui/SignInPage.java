package com.samples.framework.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sample.framework.Configuration;
import com.sample.framework.ui.controls.Control;
import com.sample.framework.ui.controls.Edit;

public class SignInPage extends Page {
	
	String user;
	String pwd;
	
	public Edit email ;
	public Edit password ;
	public Control submitButton ;

	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		Edit email=new Edit(this,By.id("email"),user);
	    Edit password=new Edit(this,By.id("passwd"),pwd);
		Control submitButton=new Control(this,By.cssSelector("#SubmitLogin > span"));
	}

}
