package org.enggQA.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenUtils {
        private final static Logger logger = LogManager.getLogger(ScreenUtils.class);


        public static void captureScreenshot(AppiumDriver<MobileElement> driver, final String path,
                                             final String methodName ) {
            File dsf = driver.getScreenshotAs(OutputType.FILE);
            String fileName = "Method_" + methodName + ".jpg";
            File newFile = new File(path + fileName);
            try {
                FileUtils.copyFile(dsf, newFile);
            } catch (IOException e) {
                logger.error("Error generating the screenshot", e);
            }
        }


        public static String getBase64Screenshot( AppiumDriver<MobileElement> driver ) {
            String base64Screenshot = "data:image/png;base64,"
                    + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            return base64Screenshot;
        }

        public static void takeScreenShotAsImage( AppiumDriver<MobileElement> driver, String fileWithPath ) {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile = new File(fileWithPath);
            try {
                FileUtils.copyFile(SrcFile, DestFile);
            } catch (IOException e) {
                logger.error("Error generating the screenshot", e);
                e.printStackTrace();
            }
        }
}
