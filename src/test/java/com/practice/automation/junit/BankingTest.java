package com.practice.automation.junit;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.sample.framework.Configuration;
import com.sample.framework.ui.PageFactory;
import com.sample.framework.ui.controls.Control;
import com.sample.tests.pages.Banking.AddCustomerPage;
import com.sample.tests.pages.Banking.BankManagerCommonPage;
import com.sample.tests.pages.Banking.CustomersPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BankingTest extends BankingTestCommon {

	public BankingTest() {
	}
	
	@Test
	public void Test() throws Exception {
		
		bankManagerMenu =homePage.buttonBankManagerLogin.clickAndWaitFor(BankManagerCommonPage.class);
		
		customers=bankManagerMenu.buttonCustomers.clickAndWaitFor(CustomersPage.class);
				
		System.out.println(customers.tableCustomers.getSubItem("First Name", 1).getText());
		Assert.assertTrue(customers.tableCustomers.isNotEmpty());
		
		int rows=customers.tableCustomers.getItemsCount();
		
	
		addCustomer=customers.buttonAddCustomer.clickAndWaitFor(AddCustomerPage.class);
		
		Assert.assertTrue(addCustomer.allElimentsExist(new Control[]{
			
			addCustomer.editFirstName,
			addCustomer.editLastName,
			addCustomer.editPostCode,
			addCustomer.buttonAddCustomer			
			
		}));
		
		Assert.assertTrue(addCustomer.anyOfElementsExist(new Control[]{
				
				addCustomer.editFirstName,
				addCustomer.editLastName,
				addCustomer.editPostCode,
				addCustomer.buttonAddCustomer			
				
			}));	
		
        Thread.sleep(1000);
        
        addCustomer.editFirstName.setValue("Test");
        addCustomer.editLastName.setValue("Test1");
        addCustomer.editPostCode.setValue("DS45");
        
        try {
        customers=addCustomer.buttonAddCustomer.clickAndWaitFor(CustomersPage.class);
        }catch(Exception e) {        	
        	e.printStackTrace();        	
        }
        customers.buttonCustomers.click();
        
        Assert.assertEquals(rows+1,customers.tableCustomers.getItemsCount());
        Assert.assertEquals("Test", customers.tableCustomers.getSubItem("First Name", rows).getText());
        Assert.assertEquals("Test1",customers.tableCustomers.getSubItem("Last Name", rows).getText());
        Assert.assertEquals("DS45", customers.tableCustomers.getSubItem("Post Code", rows).getText());        
        
        customers.tableCustomers.getSubItem("Delete Customer", rows, Control.class).click();        
        Assert.assertEquals(rows,customers.tableCustomers.getItemsCount());
		Assert.assertTrue(customers.tableCustomers.isNotEmpty());        
        
		
	}
 
	
	
}
