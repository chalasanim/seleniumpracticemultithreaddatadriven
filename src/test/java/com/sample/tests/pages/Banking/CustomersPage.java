package com.sample.tests.pages.Banking;

import org.openqa.selenium.WebDriver;

import com.sample.framework.ui.FindBy;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.SubItem;
import com.sample.framework.ui.controls.TableView;

public class CustomersPage extends BankManagerCommonPage {

	public CustomersPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	    @FindBy(locator = "//table", itemLocator = "/tbody/tr")
	    @SubItem(name = "First Name", locator = "/td[1]")
	    @SubItem(name = "Last Name", locator = "/td[2]")
	    @SubItem(name = "Post Code", locator = "/td[3]")
	    @SubItem(name = "Account Number", locator = "/td[4]")
	    @SubItem(name = "Delete Customer", locator = "/td[5]/button")
	    public TableView tableCustomers;
	 
	 public Page navigate() throws Exception{
		 return this.buttonCustomers.clickAndWaitFor(this.getClass());
	 }
	
	

}

  