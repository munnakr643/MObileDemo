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
public class PreviewPage extends ScreenManager {
    public PreviewPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'close_btn')]")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@resource-id='live.hms.app2:id/close_btn']")
    public MobileElement backBtn;

    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'logo_iv')]")
    public MobileElement logo100ms;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Get Started']")
    public MobileElement getStartedText;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'description_tv')]")
    public MobileElement setupAudioVideoText;

    @AndroidFindBy(xpath="//android.widget.FrameLayout[contains(@resource-id,'icon_participants')]")
    public MobileElement iconParticipants;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'participant_count_text')]")
    public MobileElement participant_count;

    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'button_network_quality')]")
    public MobileElement networkQuality;

    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'button_toggle_audio')]")
    public MobileElement mic;

    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'button_toggle_video')]")
    public MobileElement video;

    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'button_switch_camera')]")
    public MobileElement cameraSwap;

    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'icon_noise_cancellation')]")
    public MobileElement noiseCancellation;

    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'icon_output_device')]")
    public MobileElement speaker;

    @AndroidFindBy(xpath="//android.widget.EditText[contains(@resource-id,'edit_text_name')]")
    public MobileElement deviceName;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Join Now']")
    public MobileElement joinBtn;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'name_initials')]")
    public MobileElement name_initialsIcon;
}
