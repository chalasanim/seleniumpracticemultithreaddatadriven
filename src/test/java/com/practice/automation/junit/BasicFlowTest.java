package com.practice.automation.junit;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;
import com.samples.framework.ui.HomePage;
import com.samples.framework.ui.Page;
import com.samples.framework.ui.SignInPage;
import com.samples.framework.ui.ViewDressPage;
import com.samples.framework.ui.WomenPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
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
	
	

 // private WebDriver driver;
	Page basePage;
	HomePage homePage;
	SignInPage loginPage;
	WomenPage womenPage;
	ViewDressPage viewDressPage;

 
  private Map<String, Object> vars;
  JavascriptExecutor js;

  
  
  private String menuItem;
  private String dressColor;
  private String cartStatus;
 

  public  BasicFlowTest(String menuItem,String dressColor,String cartStatus) {
	  super();
	  this.menuItem=menuItem;
	  this.dressColor=dressColor;
	  this.cartStatus=cartStatus;	  
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
    DesiredCapabilities cap=new DesiredCapabilities();
    Driver.add(Configuration.get("browser"), cap);
    WebDriver driver = Driver.current();  
    basePage=new Page(driver);
    homePage=new HomePage(driver);
	loginPage=new SignInPage (driver);
	womenPage=new WomenPage (driver);
	viewDressPage=new ViewDressPage (driver);
    homePage.navigate(); 
    homePage.maximiseWindow();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();

    
  

  }
  
  @After
  public void tearDown() {
    basePage.quit();
  }
  
  @SuppressWarnings("deprecation")
  
  @Test
  public void MultiTest () throws InterruptedException { 

	homePage.signinLink.click();
	loginPage.email.setValue(Configuration.get("username"));
	loginPage.password.setValue(Configuration.get("password")); 	
	loginPage.submitButton.click();
   // driver.findElement(By.id("columns")).click();    
    homePage.menuLinkWomen.click();
	womenPage.colorOption.click();
	womenPage.blockProduct.click();
    basePage.get("http://automationpractice.com/index.php?id_product=4&controller=product");
	viewDressPage.colorCheckbox.click();
	viewDressPage.addToCartButton.click();	
	viewDressPage.continueShoppingOption.click();
	String cartItems=basePage.cartStatus.getText();    
	assertTrue(cartItems.contains(this.cartStatus));
    basePage.signoutLink.click();
    
    //driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
    //driver.findElement(By.id("color_24")).click();"Pink (1)"



    // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Pink']"))).click();
    // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p#add_to_cart>button span"))).click();
    // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='Continue shopping']>span"))).click();
	

 
/*
    
    driver.findElement(By.linkText("Women")).click();
    driver.findElement(By.cssSelector(".products-block .btn > span")).click();
    driver.findElement(By.cssSelector(".product_list")).click();
    //new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[id='color_37']"))).click();
    
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Yellow']"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p#add_to_cart>button span"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='Continue shopping']>span"))).click();
    
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Black']"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p#add_to_cart>button span"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='Continue shopping']>span"))).click();
     
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Orange']"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p#add_to_cart>button span"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='Continue shopping']>span"))).click();
     
    
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Blue']"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p#add_to_cart>button span"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='Continue shopping']>span"))).click();
     

    driver.findElement(By.linkText("Dresses")).click();
    driver.findElement(By.id("selectProductSort")).click();
    {
      WebElement dropdown = driver.findElement(By.id("selectProductSort"));
      dropdown.findElement(By.xpath("//option[. = 'Price: Lowest first']")).click();
    }
    driver.findElement(By.cssSelector("option:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".top-pagination-content")).click();
    driver.findElement(By.id("selectProductSort")).click();
    {
      WebElement dropdown = driver.findElement(By.id("selectProductSort"));
      dropdown.findElement(By.xpath("//option[. = 'Price: Highest first']")).click();
    }
    driver.findElement(By.cssSelector("option:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".top-pagination-content")).click();
    driver.findElement(By.cssSelector(".top-pagination-content")).click();
    driver.findElement(By.cssSelector(".ajax_cart_quantity:nth-child(2)")).click();
    
    driver.findElement(By.linkText("Sign out")).click();  */

  }
  

}
