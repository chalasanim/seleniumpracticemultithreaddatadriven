package com.practice.automation.junit;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.controls.Control;
import com.sample.framework.ui.controls.Edit;
import com.sample.tests.pages.HomePage;
import com.sample.tests.pages.SignInPage;
import com.sample.tests.pages.ViewDressPage;
import com.sample.tests.pages.WomenPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType; 
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@RunWith(Parameterized.class)
public class BasicFlowTest {
	
	

    private WebDriver driver;
    String user;
    String pwd;
    

	HomePage homePage;
	SignInPage loginPage;
	WomenPage womenPage;
	ViewDressPage viewDressPage; 
	
    private String menuItem;
    private String dressColor;
    private String cartStatus;
 

  public  BasicFlowTest(String menuItem,String dressColor,String cartStatus) {
	  super();
	  this.menuItem=menuItem;
	  this.dressColor=dressColor;
	  this.cartStatus=cartStatus;	  
  }  
 
  @BeforeClass
  public static void setupClass() {
   //  WebDriverManager.chromedriver().setup();
  }
  
  @Parameters
  public static Collection<Object[]> getParameters(){
	  
	  return Arrays.asList(new Object[][]
			  {
		         {"Women","Pink (1)","1"},
		         {"Women","Yellow (3)","1"},
		         {"Women","Black (2)","1"}
		                  		         
			  }) ;	  
  } 
  
  @Before
  public void setUp() throws Exception {
	Configuration.load();
	Configuration.print();   
    String url=Configuration.get("url");
	user = Configuration.get("username");
	pwd = Configuration.get("passwd");

    DesiredCapabilities cap=new DesiredCapabilities();
    Driver.add(Configuration.get("browser"), cap);
    WebDriver driver = Driver.current();  
    
    homePage=new HomePage(driver);
	loginPage=new SignInPage (driver);
	womenPage=new WomenPage (driver);
	viewDressPage=new ViewDressPage (driver);
    homePage.navigate(); 
    homePage.maximiseWindow();

    
  

  }
  
  @After
  public void tearDown() {
	  
	  Driver.current().quit();
  }
  
  @SuppressWarnings("deprecation")
  
  @Test
  public void Test () throws InterruptedException { 
  
		homePage.signinLink.click();
		
		loginPage.navigate();
			
		loginPage.email.setValue(Configuration.get("username"));
		loginPage.password.setValue(Configuration.get("passwd")); 	
		loginPage.submitButton.click();
		
	    homePage.menuLinkWomen.click();	    
		womenPage.colorOption.click();
		womenPage.blockProduct.click();
		
		viewDressPage.navigate();		
		viewDressPage.colorCheckbox.click();
		viewDressPage.addToCartButton.click();	
		viewDressPage.continueShoppingOption.click();
		
		String cartItems=viewDressPage.cartStatus.getText();    
		assertTrue(cartItems.contains(this.cartStatus));
		viewDressPage.signoutLink.click();
	
  }
  

}
