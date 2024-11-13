package org.enggQA.pageScreen.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.Setter;
import org.enggQA.pageScreen.manager.ScreenManager;

@Getter
@Setter
public class HomePage extends ScreenManager {
    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@index='1']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@index='0'])[12]")
    public MobileElement arabicLanguageOnPopup;

    @AndroidFindBy(xpath = "s")
    @iOSXCUITFindBy(xpath = "2")
    public MobileElement test;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@index='1']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@index='0'])[12]")
    public MobileElement home2;
}
