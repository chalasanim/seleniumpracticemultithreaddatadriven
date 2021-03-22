package com.practice.automation.junit;
import com.sample.framework.Configuration;
import com.sample.framework.Driver;
import com.sample.framework.ui.controls.Control;
import com.sample.framework.ui.controls.Edit;
import com.sample.framework.ui.controls.SelectList;

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
	
	

  private WebDriver driver;

 
  private Map<String, Object> vars;
  JavascriptExecutor js;
  private String username="a.tarigopula@gmail.com";
  private String passwd="!EDm!k8D8Wfd5PK";
  
  
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
    driver=Driver.current();    
    driver.get(url);
    driver.manage().window().maximize();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();

    
  

  }
  
  @After
  public void tearDown() {
    driver.quit();
  }
  
  @SuppressWarnings("deprecation")
  
  @Test
  public void MultiTest () throws InterruptedException {
	  
	Control signinLink=new Control(driver,By.linkText("Sign in"));
	Control signoutLink=new Control(driver,By.linkText("Sign out"));

	Edit email=new Edit(driver,By.id("email"),username);
 	Edit password=new Edit(driver,By.id("passwd"),passwd);
 	Control submitButton=new Control(driver,By.cssSelector("#SubmitLogin > span"));
	Control menuLinkWomen=new Control(driver,By.linkText(this.menuItem));    
	Control colorOption=new Control(driver,By.linkText(this.dressColor));  
	Control blockProduct=new Control(driver,By.cssSelector(".ajax_block_product:nth-child(5) .replace-2x"));
	Control colorCheckbox=new Control(driver,By.cssSelector("a[title='Pink']"));
	Control addToCartButton=new Control(driver,By.cssSelector("p#add_to_cart>button span"));
	Control continueShoppingOption=new Control(driver,By.cssSelector("span[title='Continue shopping']>span"));
	Control cartStatus=new Control(driver,By.cssSelector(".ajax_cart_quantity:nth-child(2)"));

	signinLink.click();
    email.setValue(username);
 	password.setValue(passwd); 	
    submitButton.click();
   // driver.findElement(By.id("columns")).click();    
    menuLinkWomen.click();
	colorOption.click();
	blockProduct.click();
    driver.get("http://automationpractice.com/index.php?id_product=4&controller=product");
	colorCheckbox.click();
	addToCartButton.click();	
	continueShoppingOption.click();
	String cartItems=cartStatus.getText();    
	assertTrue(cartItems.contains(this.cartStatus));
    signoutLink.click();
    
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
