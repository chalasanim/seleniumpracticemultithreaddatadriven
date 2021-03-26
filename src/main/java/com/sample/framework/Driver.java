package com.sample.framework;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


public final class Driver {

	private Driver() {
		// TODO Auto-generated constructor stub
	}
	
	private static ConcurrentHashMap<String,WebDriver> driverThreadMap= new ConcurrentHashMap<String,WebDriver>();
	
	private static final Map <String,Class<?>> driverMap=new HashMap<String,Class<?>>(){
		{
		 put(Platform.CHROME.getValue(),ChromeDriver.class);
		 put(Platform.FIREFOX.getValue(),FirefoxDriver.class);
		 put(Platform.IE.getValue(),InternetExplorerDriver.class);
		 put(Platform.SAFARI.getValue(),SafariDriver.class);
		 put(Platform.OPERA.getValue(),OperaDriver.class);
		 put(Platform.ANDRIOD_NATIVE.getValue(),AndroidDriver.class);
		 put(Platform.IOS_NATIVE.getValue(),IOSDriver.class);
		}
		
	};
	
	public static String getThreadName() {
		return Thread.currentThread().getName()+"-"+Thread.currentThread().getId();
	}
	public static void add(String browser, Capabilities capabilities) throws Exception {
		
		Class<?> driverClass=driverMap.get(browser);
		WebDriver driver=(WebDriver) driverClass.getConstructor(Capabilities.class).newInstance(capabilities);
		String Threadname=getThreadName();
		driverThreadMap.put(Threadname, driver)	;
		
	}
    
	public static WebDriver current() {
		String ThreadName=getThreadName();
		return  driverThreadMap.get(ThreadName);
	}
}
