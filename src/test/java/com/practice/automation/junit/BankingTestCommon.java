package com.practice.automation.junit;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;
import com.sample.framework.ui.PageFactory;
import com.sample.tests.pages.Banking.AddCustomerPage;
import com.sample.tests.pages.Banking.BankManagerCommonPage;
import com.sample.tests.pages.Banking.BankingHomePage;
import com.sample.tests.pages.Banking.CustomersPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BankingTestCommon {
	
	protected BankingHomePage homePage;
	protected BankManagerCommonPage bankManagerMenu;
	protected AddCustomerPage addCustomer;
	protected CustomersPage customers;
	
	  @BeforeClass
	  public static void setupClass() {
	    WebDriverManager.chromedriver().setup();
	  }
	  

	@Before
	public void setUp() throws Exception {
		Configuration.load();
		Configuration.print();
		
       // System.setProperty("webdriver.gecko.driver", new File("drivers/geckodriver").getAbsolutePath());
       // System.setProperty("webdriver.chrome.driver", new File("drivers/chromedriver").getAbsolutePath());
	    DesiredCapabilities cap=new DesiredCapabilities();
        Driver.add(Configuration.get("browser"), cap);
        homePage=PageFactory.init(BankingHomePage.class);
        homePage.navigate(Configuration.get("bankurl"));
        
	}
	  @After
	  public void tearDown() {
		  
		 Driver.current().quit();
	  }

}
