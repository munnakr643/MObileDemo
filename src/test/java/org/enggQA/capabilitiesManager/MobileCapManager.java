package org.enggQA.capabilitiesManager;

import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.enggQA.utilities.ReadConfig;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileCapManager {
    public static Logger logger = LogManager.getLogger(MobileCapManager.class);
    private final static String platform= ReadConfig.getPlatformName();
    private final static String version=ReadConfig.getPlatformVersion();
    private final static String deviceName=ReadConfig.getDeviceId();
    private final static String automationName= ReadConfig.getAutomationName();
    private final static String appPackage=ReadConfig.getAppPackage();
    private final static String appActivity=ReadConfig.getAppActivity();
    private final static String orientation=ReadConfig.getOrientation();

    public static DesiredCapabilities capabilities(){
        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platform);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,version);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,automationName);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability(MobileCapabilityType.ORIENTATION,orientation);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        capabilities.setCapability("autoGrantPermissions", "true");
        logger.info("Capabilities: "+ capabilities);
        return capabilities;
    }

}
