package org.enggQA.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {
	public ReadConfig(){
		System.out.println("Hi i am constructor");
	}
	static Properties pro=readConfig();

	private static Properties prop;
	public static Properties readConfig(){
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/global.properties");
			prop = new Properties();
			prop.load(fis);
		}catch (Exception e){
			System.out.println("Exception is " + e.getMessage());
		}
		return prop;

	}

	public static String getPlatformName() {
		String input="";
		input=System.getenv("platform");
		if(input==null || input.isEmpty()){
			input=pro.getProperty("platform");
		}
		return input;
	}

	public static String getDeviceId() {
		String device="";
		device=System.getenv("deviceId");
		if(device==null || device.isEmpty()){
			device=pro.getProperty("deviceName");
		}
		return device;
	}

	public static String getPlatformVersion() {
		String input="";
		input=System.getenv("version");
		if(input==null || input.isEmpty()){
			input=pro.getProperty("platformVersion");
		}
		return input;
	}

	public static String getAppiumServer() {
			String input=pro.getProperty("appiumServer");
		return input;
	}

	public static String getPort() {
		String input="";
		input=System.getenv("port");
		if(input==null || input.isEmpty()){
			input=pro.getProperty("port");
		}
		return input;
	}

	public static String getAppPackage() {
		String input="";
		input=System.getenv("appPackage");
		if(input==null || input.isEmpty()){
			input=pro.getProperty("appPackage");
		}
		return input;
	}

	public static String getAppActivity() {
		String input="";
		input=System.getenv("appAppActivity");
		if(input==null || input.isEmpty()){
			input=pro.getProperty("appAppActivity");
		}
		return input;
	}


	public static String getAutomationName() {
		String input="";
		input=System.getenv("automationName");
		if(input==null || input.isEmpty()){
			input=pro.getProperty("automationName");
		}
		return input;
	}
	public static String getOrientation() {
		String input="";
		input=System.getenv("orientation");
		if(input==null || input.isEmpty()){
			input=pro.getProperty("orientation");
		}
		return input;
	}

	public static String getApkPath() {
		String input="";
		input=System.getenv("appPath");
		if(input==null || input.isEmpty()){
			input=pro.getProperty("appPath");
		}
		return input;
	}



	public static boolean flag(String flagName){
		String env = System.getenv(flagName);
		boolean flagValue = false;
		if (env != null && env.equalsIgnoreCase("true"))
			flagValue = true;
		return flagValue;
	}



	public static boolean isPlatformNameAndroid(){
		return ReadConfig.getPlatformName().equalsIgnoreCase("Android");
	}


}




