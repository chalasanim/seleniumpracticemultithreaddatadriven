package com.practice.automation;

import org.testng.annotations.Test;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class BaicFlowTestNGTest {
	
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  


	    
	    driver.findElement(By.linkText(this.menuItem)).click();
	    driver.findElement(By.linkText(this.dressColor)).click();
	    driver.findElement(By.cssSelector(".ajax_block_product:nth-child(5) .replace-2x")).click();
	    
	    //driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
	    //driver.findElement(By.id("color_24")).click();"Pink (1)"
	    driver.get("http://automationpractice.com/index.php?id_product=4&controller=product");
	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Pink']"))).click();

	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p#add_to_cart>button span"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title='Continue shopping']>span"))).click();
	    String cart=driver.findElement(By.cssSelector(".ajax_cart_quantity:nth-child(2)")).getText();
	    
	    assertTrue(cart.contains(this.cartStatus));
  }
  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {"Women","Pink (1)","1" },
      new Object[] {"Women","Black (2)","1" },
      new Object[] {"Women","Yellow (3)","1"},
      
    };
  }
  @BeforeClass
  public void beforeClass() {
	  

	  private WebDriver driver;
	  private WebDriverWait wait;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  private String username="a.tarigopula@gmail.com";
	  private String passwd="!EDm!k8D8Wfd5PK";
	  
	  
	  private String menuItem;
	  private String dressColor;
	  private String cartStatus;
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  
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
	    wait=new WebDriverWait(driver,20);
	  
	    driver.findElement(By.linkText("Sign in")).click();
	    driver.findElement(By.id("email")).click();	    
	    driver.findElement(By.id("passwd")).sendKeys(passwd);
	    driver.findElement(By.id("email")).sendKeys(username);
	    driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
	    driver.findElement(By.id("columns")).click();
	    
  }

  @AfterTest
  public void afterTest() {
  }

}
