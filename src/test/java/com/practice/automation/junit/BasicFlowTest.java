package com.practice.automation.junit;
import com.sample.framework.Configuration;
import com.sample.framework.Driver;

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
  private WebDriverWait wait;
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
    wait=new WebDriverWait(driver,20);

  }
  @After
  public void tearDown() {
    driver.quit();
  }
  
  @SuppressWarnings("deprecation")
  
  @Test
  public void MultiTest () throws InterruptedException {
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys(username);
    driver.findElement(By.id("passwd")).sendKeys(passwd);
    driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
    driver.findElement(By.id("columns")).click();
    

    
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
    
    driver.findElement(By.linkText("Sign out")).click();

  }
  

}
