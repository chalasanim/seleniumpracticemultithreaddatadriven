package com.sample.framework.ui;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;
import com.sample.framework.Platform;
import com.sample.framework.ui.controls.Control;

public class PageFactory {

      public PageFactory() {
    	  
      }
      
      public static By toLocator(String input) {
    	  

	        if (input.matches("^(xpath=|/)(.*)")) {
	            return By.xpath(input.replaceAll("^xpath=", ""));
	        } else if (input.matches("^id=(.*)")) {
	            return By.id(input.substring("id=".length()));
	        } else if (input.matches("^name=(.*)")) {
	            return By.name(input.substring("name=".length()));
	        } else if (input.matches("^css=(.*)")) {
	            return By.cssSelector(input.substring("css=".length()));
	        } else if (input.matches("^class=(.*)")) {
	            return By.className(input.substring("class=".length()));
	        }else if (input.matches("^linkText=(.*)")) {
	        	return By.linkText(input.substring("linkText=".length()));
          
	        }else {
    	  		return By.id(input);
	        }
      	} 
    	     	    
      
           
      public static FindBy getLocatorforPlatform(FindBy locators[],Platform platform) {
    	  
    	  for(FindBy locator: locators) {
    		  
    		  if( locator.platform().equals(platform)) {
    			  return locator;
    		  }
    		  
    	  }
    	  return null;
      }
      
      private static SubItem[] getSubItemsForPlatform(SubItem items[], Platform platform) {
          SubItem[] result = new SubItem[]{};
          for (SubItem item : items) {
              if (item.platform().equals(platform) || item.platform().equals(Platform.ANY)) {
                  result = ArrayUtils.add(result, item);
              }
          }
          return result;
      }
      
      public static <T extends Page>T init(Class<T> pageClass) throws Exception{
    	  
    	  T page=pageClass.getConstructor(WebDriver.class).newInstance(Driver.current());

    	  for (Field field : pageClass.getFields()) {
    		  FindBy locators[]=field.getAnnotationsByType(FindBy.class);
    		  
      		    Platform platform=Configuration.platform();

    		  if (locators!=null || locators.length>0) {
    			  FindBy anno=getLocatorforPlatform(locators,platform);
    			  
    			  if (anno==null) {
    				  anno=getLocatorforPlatform(locators,Platform.ANY);
    			  }
    			     		     		  
    		     if (anno!=null) {
    			     Control control=(Control)field.getType().getConstructor(Page.class,By.class).newInstance
    					  (page,toLocator(anno.locator()));
    			     
    			     control.setItemLocatorText(anno.itemLocator());
    			     
    			     SubItem[] items=field.getAnnotationsByType(SubItem.class);
    			     
    			     //control.addSubItems(getSubItemsforPlatform(items,platform));
    			     control.addSubItems(getSubItemsForPlatform(items,platform));
    			     control.setExcludedFromSearch(anno.excludeFromSearch());
     			     field.set(page, control);
    		      }    		  
    		  }
    	  }
    	  
		return page;
    	  
      }



}
