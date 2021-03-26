package com.practice.automation.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;
import com.sample.framework.ui.PageFactory;
import com.sample.tests.pages.HomePage;
import com.sample.tests.pages.SignInPage;
import com.sample.tests.pages.ViewDressPage;
import com.sample.tests.pages.WomenPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCommon {
	
	protected HomePage homePage;
	protected SignInPage loginPage;
	protected WomenPage womenPage;
	protected ViewDressPage viewDressPage; 

	
	 
	  @BeforeClass
	  public static void setupClass() {
	    WebDriverManager.chromedriver().setup();
	  }
	  

	
	  @Before
	  public void setUp() throws Exception {
		Configuration.load();
		Configuration.print();   
	    String url=Configuration.get("url");
		String user = Configuration.get("username");
		String pwd = Configuration.get("passwd");
		

	    DesiredCapabilities cap=new DesiredCapabilities();
	    Driver.add(Configuration.get("browser"), cap);
	    
	    homePage = PageFactory.init(HomePage.class);	
	    homePage.navigate(); 
	    homePage.maximiseWindow();  
	  

	  }
	  
	  @After
	  public void tearDown() {
		  
		 Driver.current().quit();
	  }
}
