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
public class JoinPage extends ScreenManager {
    public JoinPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='100ms Logo']")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@content-desc='100ms Logo']")
    public MobileElement logo100ms;

    @AndroidFindBy(xpath="//android.widget.Button[@content-desc='Settings']")
    public MobileElement settingBtn;

    @AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='More options']")
    public MobileElement moreBtn;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'power of 100ms')]")
    public MobileElement powerOf100msText;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'pasting a room link')]")
    public MobileElement aRoomLinkText;

    @AndroidFindBy(xpath="//android.widget.EditText[contains(@resource-id,'edit_text_name')]")
    public MobileElement deviceName;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Joining Link']")
    public MobileElement joinLinktext;

    @AndroidFindBy(xpath="//android.widget.EditText[contains(@resource-id,'edt_meeting_url')]")
    public MobileElement enterJoinLink;

    @AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id,'btn_join_now')]")
    public MobileElement joinNowBtn;

    @AndroidFindBy(xpath="//android.widget.Button[contains(@resource-id,'btn_scan_now')]")
    public MobileElement qrCodeBtn;
}
