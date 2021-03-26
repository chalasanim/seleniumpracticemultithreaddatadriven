package com.sample.framework;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Map.Entry;

public final class Configuration {
	
	// this is  class contains global parameters ,so it is final class with blanck const, static parameters and methods
	private Configuration() {
		// TODO Auto-generated constructor stub
	}
	
	private static Properties properties;
	
	public static void  load() throws IOException{
		
		properties =new Properties();
		InputStream is= new FileInputStream(new File("config.properties"));
		BufferedReader reader=new BufferedReader(new InputStreamReader(is,StandardCharsets.UTF_8));
		
		try {
			properties.load(reader);
		}finally {
			is.close();
			reader.close();
		}			
	}
	
	public static String get(String option) {
		
		String value=properties.getProperty(option)	;	

		return value;		
	}
	
	public static void print() {
		for (Entry<Object,Object> entry : properties.entrySet()) {
			
         System.out.println(String.format("%s=%s", entry.getKey(),entry.getValue()));		
		}
		
	}
	
	public static long timeout() {
		String value=get("timeout");
		return  Long.parseLong(value);
	}

	
	public static Platform platform() {
		  return Platform.fromString(get("browser"));
	}
	
}
