package com.sample.framework.ui.controls;



import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sample.framework.Configuration;
import com.sample.framework.ui.Page;
import com.sample.framework.ui.PageFactory;
import com.sample.framework.ui.SubItem;

public class Control {
	
	protected static final long TIMEOUT = Configuration.timeout();
	private Page parent;
	private By locator;
    private String locatorText = "";
    private String itemLocatorText = "";
    private boolean excludeFromSearch = false;
    protected HashMap<String, SubItem> subItemsMap;
    
	public Control(Page parentValue,By locatorValue) {
		this.parent=parentValue;
		this.locator=locatorValue;
		this.locatorText=this.locator.toString().replaceFirst("^By\\.(\\S+): ", "");
		subItemsMap = new HashMap<String, SubItem>();
	}
	
	public Page getParent() {
		return parent;
	}	
	
	public WebElement element() {
		return parent.getDriver().findElement(locator);
	}
	
	public WebDriver getDriver() {
		return parent.getDriver();
	}
	

	public String getLocatorText() {
		return locatorText;
	}


    public String getItemLocatorText() {
        return itemLocatorText;
    }

    public void setItemLocatorText(String subItemLocatorText) {
        this.itemLocatorText = subItemLocatorText;
    }
	
    public boolean waitUntil(ExpectedCondition<?> condition, long timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        try {
            wait.until(condition);
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
    
	public boolean exists(long timeout) {		
        return waitUntil(ExpectedConditions.presenceOfElementLocated(locator), timeout);	 
	}
	
	public boolean visible(long timeout) {		
        return waitUntil(ExpectedConditions.visibilityOfElementLocated(locator), timeout);	 
		}
		
	public boolean visible() {		
		return visible(TIMEOUT)	; 
		}
	public boolean exists() {		
		return exists(TIMEOUT)	; 
		}
	
	public boolean disappears(long timeout) {
	        return waitUntil(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(locator)), timeout);
	    }
	
	public boolean disappears() {
	        return disappears(TIMEOUT);
	    }
	public void click() {		
		exists();
		this.element().click();
	}

	public String getText() {
		// TODO Auto-generated method stub
		return this.element().getText();
	}

	
	public void getElementByOption(String optionString) {		
		
			  List<WebElement> options = parent.getDriver().findElements(locator);      
			    for(WebElement option : options){
			        if(option.getText().equals(optionString)){
			        	option.click();
			            break;
			        }
			    }       
			}
	
	public void clickLinkByName(String linkToClick)	{
		
		 List<WebElement> links=parent.getDriver().findElements(locator);
		
		 links.forEach(link -> {
		    if(link.getText().equals(linkToClick)){
		        link.click();
		    }
		
		  });

		}
	
	
    public <T extends Page> T clickAndWaitFor(Class<T> pageClass) throws Exception {
        this.click();
        T page = PageFactory.init(pageClass);
        Assert.assertTrue(String.format("The page of %s class didn't appear during specified timeout", pageClass.getName()),
                page.isCurrent());
        return page;
    }


	public boolean isExcludeFromSearch() {
		// TODO Auto-generated method stub
		return excludeFromSearch;
	}


	public void addSubItems(SubItem[] items) {
		
		for (SubItem item:items) {
			this.subItemsMap.put(item.name(), item);
		}
	}
	
	public HashMap<String,SubItem> getSubItemsMap(){
		
		return subItemsMap;
	}


	public void setExcludedFromSearch(boolean excludeFromSearch) {
		// TODO Auto-generated method stub
		this.excludeFromSearch=excludeFromSearch;
		
	}



	
}
