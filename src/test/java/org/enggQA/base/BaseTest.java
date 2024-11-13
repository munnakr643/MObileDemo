package org.enggQA.base;

import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.enggQA.report.ExtentTestManager;
import org.enggQA.utilities.ReadConfig;
import org.enggQA.utilities.ScreenUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofSeconds;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.enggQA.capabilitiesManager.MobileCapManager.capabilities;

public class BaseTest {
    public static Logger logger = LogManager.getLogger(BaseTest.class);
     public static AppiumDriver<MobileElement> mobileDriver;
    private final static String LOG4J_PROPERTIES = "./src/main/resources/log4j.properties";

    private final static String platform= ReadConfig.getPlatformName();
    private final static String appiumServer=ReadConfig.getAppiumServer();
    private final static String port=ReadConfig.getPort();
    public AppiumDriver<MobileElement> initDriver() {

        PropertyConfigurator.configure(LOG4J_PROPERTIES);
        logger.info("----Start logging----");

        DesiredCapabilities dscap = capabilities();
        try {
            if (platform.equalsIgnoreCase("Android")) {
                String url="http://"+appiumServer+":"+port+"/wd/hub";
                mobileDriver = new AndroidDriver<>(new URL(url), dscap);
            } else {
                mobileDriver = new IOSDriver<>(new URL("http://"+appiumServer+":"+port+"/wd/hub"), dscap);
            }
        } catch (SessionNotCreatedException | MalformedURLException ec) {
            ec.printStackTrace();
        }
        System.out.println("Sesseion Id : "+mobileDriver.getSessionId());
        return mobileDriver;
    }
    public void waitFor(double sec){
        try {
            Thread.sleep((int)(sec*10000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public String getMeetingLink() {
        String input = "";
        input = System.getenv("meetingLink");
        if (input == null || input.isEmpty()) {
            input = "https://test-videoconf-1314.app.100ms.live/preview/wpe-gthm-cmh";
        }
        return input;
    }

}
