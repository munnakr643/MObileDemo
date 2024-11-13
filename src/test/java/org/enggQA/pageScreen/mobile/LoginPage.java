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

public class LoginPage extends ScreenManager {
    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath="//android.widget.Button[@text='SKIP']")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='My Profile']")
    public MobileElement skipBtn;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Search here']")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='My Profile']")
    public MobileElement searchHere;

    @AndroidFindBy(xpath="//android.widget.EditText[@text='Search here']")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='My Profile']")
    public MobileElement searchHereEdit;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='India Gate']")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='My Profile']")
    public MobileElement firstDropDown;

}
