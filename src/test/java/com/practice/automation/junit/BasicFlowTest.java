package com.practice.automation.junit;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;
import com.sample.framework.Platform;
import com.sample.framework.ui.PageFactory;
import com.sample.tests.pages.HomePage;
import com.sample.tests.pages.SignInPage;
import com.sample.tests.pages.ViewDressPage;
import com.sample.tests.pages.WomenPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


@RunWith(Parameterized.class)
public class BasicFlowTest extends TestCommon{
	
    private String menuItem;
    private String dressColor;
    private String cartStatus; 

  public  BasicFlowTest(String menuItem,String dressColor,String cartStatus) {
	  super();
	  this.menuItem=menuItem;
	  this.dressColor=dressColor;
	  this.cartStatus=cartStatus;	    }  

  @Parameters
  public static Collection<Object[]> getParameters(){
	  
	  return Arrays.asList(new Object[][]
			  {
		         {"Women","Pink (1)","1"},
		         {"Women","Yellow (3)","1"},
		         {"Women","Black (2)","1"}
		                  		         
			  }) ;	  
  }   
  
  @SuppressWarnings("deprecation")
  
  //@Test
  public void Test () throws Exception { 
  
		homePage.signinLink.click();
		
		loginPage=PageFactory.init(SignInPage.class);
		loginPage.navigate();			
		loginPage.email.setValue(Configuration.get("username"));
		loginPage.password.setValue(Configuration.get("passwd")); 	
		loginPage.submitButton.click();
		
		homePage.takePageScreenShot("./test-output/Image01.png");		
	    homePage.menuLinkWomen.click();	 
	    
		womenPage=PageFactory.init(WomenPage.class);
		womenPage.colorOption.click();
		womenPage.blockProduct.click();
		
		viewDressPage=PageFactory.init(ViewDressPage.class);
		viewDressPage.navigate();		
		viewDressPage.colorCheckbox.click();
		viewDressPage.addToCartButton.click();	
		
		viewDressPage.takePageScreenShot("./test-output/Image02.png");

		viewDressPage.continueShoppingOption.click();		
		String cartItems=viewDressPage.cartStatus.getText();   
		
		assertTrue(cartItems.contains(this.cartStatus));
		viewDressPage.signoutLink.click();
		

	
  }
  

}
