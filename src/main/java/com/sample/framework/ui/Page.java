package com.sample.framework.ui;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;
import com.sample.framework.ui.controls.Control;

public class Page {

    private static final long TIMEOUT = Configuration.timeout();
    
    private static ConcurrentHashMap<String,Page> currentPages=new ConcurrentHashMap<String,Page>();
    
    private WebDriver driver;

	public Page(WebDriver driverValue) {
		this.driver = driverValue;
		
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public Page navigate() throws Exception {
		return this;
	}
	
	public void navigate(String url) {
		this.getDriver().get(url);
	}
	public String getTitle() {
		return getDriver().getTitle();
	}
	public void maximiseWindow() {
	    this.getDriver().manage().window().maximize();
   
	}
	
	public static Page getCurrent() {
		return currentPages.get(Driver.getThreadName());
	}

	public static void setCurrent(Page newPage) {
		
		currentPages.put(Driver.getThreadName(), newPage);		
	}
	
	public boolean isTextPresent(String text) {
		
		String locator=String.format("//*[text()= '%s' or contains(text(),%s)]",text,text);
		
		Control element =new Control(this,By.xpath(locator));
		
		return element.exists();
		
	}


	public void get(String string) {
		// TODO Auto-generated method stub
		this.get(string);
		
	}

	public void quit() {
		// TODO Auto-generated method stub
		this.getDriver().close();
		
	}
	
	
	
	
	public byte[] takePageScreenShot(){
		
		WebDriver augmentedDriver=new Augmenter().augment(getDriver());
		byte[]data=((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.BYTES);
		return data;
		
	}
	
	public File takePageScreenShot(String destination) throws Exception{
		
		WebDriver augmentedDriver=new Augmenter().augment(getDriver());
 		File srcFile =((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
 		
 		File output= new File(destination)	;
 		FileUtils.copyFile(srcFile, output);
		return output;
		
	}

    public boolean isCurrent(long timeout) throws Exception {
        Field[] fields = this.getClass().getFields();
        for (Field field : fields) {
            if (Control.class.isAssignableFrom(field.getType())) {
                Control control = (Control) field.get(this);
                System.out.println(String.format("Checking %s : '%s'", field.getName(), control.getLocatorText()));
                if (!control.isExcludeFromSearch() && !control.exists(timeout)) {
                    return false;
                }
            }
        }
        return true;
    }

	public boolean isCurrent() throws Exception {
	    return isCurrent(TIMEOUT);
	}
	
	public boolean allElementsAre(Control[] elements,String state) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
				
		for (Control element:elements) {
			if (!(boolean)element.getClass().getMethod(state).invoke(element)) {
				return false;
			}
		}
		return true;		
	}
	
	public boolean anyOfElementsIs(Control[] elements,String state) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		for (Control element:elements) {
			if ((boolean)element.getClass().getMethod(state,long.class).invoke(element,1)) {
				return true;
			}
		}
		return false;		
	}
	
	public boolean allElimentsExist(Control[] elements) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		return allElementsAre(elements,"exists");
	}
	
    public boolean allElementsDoNotExist(Control[] elements) throws Exception {
        return allElementsAre(elements, "disappears");
    }
    public boolean allElementsAreVisible(Control[] elements) throws Exception {
        return allElementsAre(elements, "visible");
    }
    public boolean allElementsAreInvisible(Control[] elements) throws Exception {
        return allElementsAre(elements, "invisible");
    }
    public boolean allElementsAreEnabled(Control[] elements) throws Exception {
        return allElementsAre(elements, "enabled");
    }
    public boolean allElementsAreDisabled(Control[] elements) throws Exception {
        return allElementsAre(elements, "disabled");
    }
    
    public boolean anyOfElementsExist(Control[] elements) throws Exception {
        return anyOfElementsIs(elements, "exists");
    }
    public boolean anyOfElementsDoNotExist(Control[] elements) throws Exception {
        return anyOfElementsIs(elements, "disappears");
    }
    public boolean anyOfElementsIsVisible(Control[] elements) throws Exception {
        return anyOfElementsIs(elements, "visible");
    }
    public boolean anyOfElementsIsInvisible(Control[] elements) throws Exception {
        return anyOfElementsIs(elements, "invisible");
    }
    public boolean anyOfElementsIsEnabled(Control[] elements) throws Exception {
        return anyOfElementsIs(elements, "enabled");
    }
    public boolean anyOfElementsIsDisabled(Control[] elements) throws Exception {
        return anyOfElementsIs(elements, "disabled");
    }
	
}
