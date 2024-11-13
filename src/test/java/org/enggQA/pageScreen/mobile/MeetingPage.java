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
public class MeetingPage extends ScreenManager {
    public MeetingPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'logo_iv')]")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@resource-id='live.hms.app2:id/close_btn']")
    public MobileElement logo100ms;

    @AndroidFindBy(xpath="//android.widget.FrameLayout[contains(@resource-id,'icon_participants')]")
    public MobileElement audioLevel;

    @AndroidFindBy(xpath="//androidx.cardview.widget.CardView[contains(@resource-id,'container_name')]")
    public MobileElement nameContainer;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'name_initials')]")
    public MobileElement shortNameIcon;

    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'button_network_quality')]")
    public MobileElement networkQuality;

    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'button_toggle_audio')]")
    public MobileElement mic;

    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'button_toggle_video')]")
    public MobileElement video;

    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'button_switch_camera')]")
    public MobileElement cameraSwitch;

    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'button_open_chat')]")
    public MobileElement chatBtn;

    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'icon_output_device')]")
    public MobileElement speaker;

    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'button_settings_menu')]")
    public MobileElement moreBtn;

    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'close_btn')]")
    public MobileElement closeBtn;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'name_initials')]")
    public MobileElement name_initialsIcon;

    @AndroidFindBy(xpath="//android.widget.ViewGroup[contains(@resource-id,'inset_pill_maximised')]")
    public MobileElement selfSmallScreen;

    @AndroidFindBy(xpath="//android.widget.FrameLayout[contains(@resource-id,'icon_audio_level')]")
    public MobileElement selfAudioIcon;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'name_initials')]")
    public MobileElement selfNameIcon;

    @AndroidFindBy(xpath="//android.widget.ImageButton[contains(@resource-id,'button_end_call')]")
    public MobileElement meetingExitBtn;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'name')]")
    public MobileElement otherPersonName;

    @AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'leave_icon')]")
    public MobileElement meetingLeaveConfirmBtn;

    @AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'end_session_button')]")
    public MobileElement leaveSessionBtn;

    @AndroidFindBy(xpath="//android.widget.ImageButton[contains(@resource-id,'closeCombinedTabButton')]")
    public MobileElement closeChat;


}
