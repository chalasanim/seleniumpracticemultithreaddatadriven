package com.sample.framework;

import java.util.HashSet;


public enum Platform {
	
	CHROME("chrome"),
	FIREFOX("firefox"),
	IE("ie"),
	OPERA("opera"),
	SAFARI("safari"),
	ANDRIOD_NATIVE("android_native"),
	IOS_NATIVE("ios_native"),
	ANY("any");	

	private String value;

	private Platform(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public boolean isAndroidNative() {
		return this.equals(ANDRIOD_NATIVE);
	}
	
	public boolean isIOSNative() {
		return this.equals(IOS_NATIVE);
	}
	
	
	public boolean isMobile() {
		
		return new HashSet<Platform>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
			add(ANDRIOD_NATIVE);
			add(IOS_NATIVE);
		   }
			
		}.contains(this);
	}
	
	public boolean isWeb() {
		 return new HashSet<Platform>(){
			   /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
			add(FIREFOX);
			add(CHROME);
			add(IE);
			add(OPERA);
			add(SAFARI);
			}
			
		 }.contains(this);				
		
	}
	
	public static Platform fromString(String input) {
		for(Platform platform : Platform.values()) {
			 if(platform.getValue().equals(input)) {
				 return platform;
			 }
			
		}
		return null;
	}
}
