package org.enggQA.base;

import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.enggQA.pageScreen.mobile.*;
import org.enggQA.report.ExtentTestManager;
import org.enggQA.utilities.ScreenUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofSeconds;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MobileBaseTest extends BaseTest{
    protected AppiumDriver<MobileElement> mobileDriver;
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static JoinPage joinPage;
    public static PreviewPage previewPage;
    public static MeetingPage meetingPage;



    @BeforeMethod(alwaysRun = true)
    public void setUpMobileDriver(){
        logger.info("setUpMobileDriver method active");
        mobileDriver=initDriver();
        initMobilePages();
    }

    @AfterMethod(alwaysRun = true)
    public void driverCloseActivity(ITestResult result){
        ExtentTestManager.getTest().log(LogStatus.INFO, "Appium SessionID " + mobileDriver.getSessionId());
        getScreenShotOnFailures(result);
        mobileDriver.closeApp();
        mobileDriver.quit();
    }

    public void initMobilePages() {
        joinPage=new JoinPage(mobileDriver);
        previewPage=new PreviewPage(mobileDriver);
        meetingPage=new MeetingPage(mobileDriver);
        loginPage=new LoginPage(mobileDriver);
        homePage=new HomePage(mobileDriver);
    }

    public void getScreenShotOnFailures(ITestResult result){
        if (result.getStatus()==ITestResult.FAILURE){
            String scree= ScreenUtils.getBase64Screenshot(mobileDriver);
            ExtentTestManager.getTest().log(LogStatus.FAIL,"Test "+result.getMethod()+" has failed",
                    ExtentTestManager.getTest().addBase64ScreenShot(scree));
        }
    }

    public void waitElement(MobileElement element, int seconds){
        WebDriverWait wait=new WebDriverWait(mobileDriver,seconds);
        wait.until(ExpectedConditions.visibilityOf(element));

    }




    private String getWebContext(AppiumDriver driver) {
        ArrayList<String> contexts = new ArrayList(driver.getContextHandles());
        for (String context : contexts) {
            if (!context.equals("NATIVE_APP")) {
                return context;
            }
        }
        return null;
    }

    public void scrollToTextNclick(String text) {
        mobileDriver.findElement(MobileBy
                        .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"))
                .click();

    }

    /**
     * Method scrolls down to the text on Android Apps
     *
     * @param text
     */
    public void scrollToText(String text) {
        ((AndroidDriver) mobileDriver).findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
    }

    public void scrollForIos() {
        JavascriptExecutor js = (JavascriptExecutor) mobileDriver;
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);
    }


    /**
     * Method scrolls down to the element passed.
     *
     * @param element
     */
    public void scrollDownToIOSElement(MobileElement element) {
        HashMap scrollObjects = new HashMap();
        scrollObjects.put("element", ((RemoteWebElement) element).getId());
        scrollObjects.put("direction", "down");
        mobileDriver.executeScript("mobile: scroll", scrollObjects);
    }

    /**
     * Method scrolls up to the element passed.
     *
     * @param element
     */
    public void scrollUpToIOSElement(MobileElement element) {
        HashMap<String,String> scrollObjects = new HashMap<>();
        scrollObjects.put("element", ((RemoteWebElement) element).getId());
        scrollObjects.put("direction", "up");
        mobileDriver.executeScript("mobile: scroll", scrollObjects);
    }

    /**
     * Method scrolls up for iOS device
     */
    public void scrollUpForIos() {
        JavascriptExecutor js = (JavascriptExecutor) mobileDriver;
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("direction", "up");
        js.executeScript("mobile: scroll", scrollObject);
    }


    /**
     * Method swipe up for iOS device based on direction(down,up,left,right)
     */
    public void swipeForIos(String dir) {
        waitFor(.5);
        JavascriptExecutor js = (JavascriptExecutor) mobileDriver;
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("direction", dir);
        js.executeScript("mobile: scroll", scrollObject);
        waitFor(.5);

    }

    public void swipe(int fromX, int fromY, int toX, int toY) {
        new TouchAction(mobileDriver)
                .press(PointOption.point(fromX, fromY))
                .waitAction(waitOptions(ofSeconds(2)))
                .moveTo(PointOption.point(toX, toY))
                .release()
                .perform();
        logger.info("Page swipe Successfully");

    }

    public void clickCoordinates(int x, int y) {
        new TouchAction(mobileDriver).tap(new PointOption<>().withCoordinates(x, y)).perform();
    }
    public void coordinatesClick(int x, int y) {
        TouchAction touchAction = new TouchAction<>(mobileDriver);
        touchAction.press(PointOption.point(x, y)).perform().release();
    }

    public void isJoiningPageVisible(){
        waitElement(joinPage.getLogo100ms(),3);
        assertThat(joinPage.getSettingBtn().isDisplayed(), equalTo(true));
        assertThat(joinPage.getDeviceName().isDisplayed(), equalTo(true));
        assertThat(joinPage.getJoinLinktext().isDisplayed(), equalTo(true));
        assertThat(joinPage.getEnterJoinLink().isDisplayed(), equalTo(true));
        assertThat(joinPage.getJoinNowBtn().isDisplayed(), equalTo(true));
        logger.info("Visibility of joining page verify successfully");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Visibility of joining page verify successfully");
    }

    public void enterMeetingLink(String link){
        waitElement(joinPage.getEnterJoinLink(),3);
        joinPage.getEnterJoinLink().sendKeys(link);
        logger.info("Enter meeting link successfully");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter meeting link successfully");
    }

    public void clickOnJoinNowButton(){
        waitElement(joinPage.getJoinNowBtn(),3);
        joinPage.getJoinNowBtn().click();
        logger.info("click on join now button successfully");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on join now button successfully");
    }

    public void isPreviewPageVisible(){
        waitElement(previewPage.getLogo100ms(),3);
        assertThat(previewPage.getBackBtn().isDisplayed(), equalTo(true));
        assertThat(previewPage.getGetStartedText().isDisplayed(), equalTo(true));
        assertThat(previewPage.getMic().isDisplayed(), equalTo(true));
        assertThat(previewPage.getVideo().isDisplayed(), equalTo(true));
        assertThat(previewPage.getCameraSwap().isDisplayed(), equalTo(true));
        assertThat(previewPage.getSpeaker().isDisplayed(), equalTo(true));
        assertThat(previewPage.getDeviceName().isDisplayed(), equalTo(true));
        assertThat(previewPage.getJoinBtn().isDisplayed(), equalTo(true));
        assertThat(previewPage.getNoiseCancellation().isDisplayed(), equalTo(true));
        logger.info("Visibility of preview page verify successfully");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Visibility of preview page verify successfully");
    }

    public void clickOnJoinNowButtonOnPreview(){
        waitElement(previewPage.getJoinBtn(),3);
        previewPage.getJoinBtn().click();
        logger.info("click on join now button successfully");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on join now button successfully");
    }
    public void ismeetingPageVisible(){
        waitElement(meetingPage.getLogo100ms(),3);
        assertThat(meetingPage.getCameraSwitch().isDisplayed(), equalTo(true));
        assertThat(meetingPage.getSpeaker().isDisplayed(), equalTo(true));
        assertThat(meetingPage.getMeetingExitBtn().isDisplayed(), equalTo(true));
        assertThat(meetingPage.getMic().isDisplayed(), equalTo(true));
        assertThat(meetingPage.getVideo().isDisplayed(), equalTo(true));
        assertThat(meetingPage.getChatBtn().isDisplayed(), equalTo(true));
        assertThat(meetingPage.getMoreBtn().isDisplayed(), equalTo(true));
        assertThat(meetingPage.getOtherPersonName().isDisplayed(), equalTo(true));
        assertThat(meetingPage.getName_initialsIcon().isDisplayed(), equalTo(true));
        assertThat(meetingPage.getSelfNameIcon().isDisplayed(), equalTo(true));
        logger.info("Visibility of meeting page verify successfully");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Visibility of meeting page verify successfully");
    }

    public void clickOnMoreButton(){
        waitElement(meetingPage.getMoreBtn(),3);
        meetingPage.getMoreBtn().click();
        logger.info("click on more button successfully");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on more button successfully");
    }

    public void clickOnSpeakerButton(){
        waitElement(meetingPage.getSpeaker(),3);
        meetingPage.getSpeaker().click();
        logger.info("click on speaker button successfully");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on speaker button successfully");
    }

    public void clickOnCameraSwitchButton(){
        waitElement(meetingPage.getCameraSwitch(),3);
        meetingPage.getCameraSwitch().click();
        logger.info("click on CameraSwitch button successfully");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on CameraSwitch button successfully");
    }

    public void clickOnMeetingEndButton(){
        waitElement(meetingPage.getMeetingExitBtn(),3);
        meetingPage.getMeetingExitBtn().click();
        logger.info("click on exit button successfully");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on exit button successfully");
    }

    public void clickOnMicButton(){
        waitElement(meetingPage.getMic(),3);
        meetingPage.getMic().click();
        logger.info("click on mic button successfully");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on mic button successfully");
    }

    public void clickOnVideoButton(){
        waitElement(meetingPage.getVideo(),3);
        meetingPage.getVideo().click();
        logger.info("click on video button successfully");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on video button successfully");
    }

    public void clickOnMessageButton(){
        waitElement(meetingPage.getChatBtn(),3);
        meetingPage.getChatBtn().click();
        logger.info("click on chat button successfully");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on chat button successfully");
    }

    public void clickOnMeetingEndConfirmationButton(){
        waitElement(meetingPage.getMeetingLeaveConfirmBtn(),3);
        meetingPage.getMeetingLeaveConfirmBtn().click();
        logger.info("click on MeetingEndConfirmationButton button successfully");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on MeetingEndConfirmationButton button successfully");
    }

    public void clickOnMoreCloseButton(){
        waitElement(meetingPage.getCloseBtn(),3);
        meetingPage.getCloseBtn().click();
        logger.info("click on close button successfully");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on close button successfully");
    }

    public void clickOnChatCloseButton(){
        waitElement(meetingPage.getCloseChat(),3);
        meetingPage.getCloseChat().click();
        logger.info("click on ChatClose button successfully");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on ChatClose button successfully");
    }

    public void clickOnLeaveSessionButton(){
        waitElement(meetingPage.getLeaveSessionBtn(),3);
        meetingPage.getLeaveSessionBtn().click();
        logger.info("click on LeaveSession button successfully");
        ExtentTestManager.getTest().log(LogStatus.PASS, "click on LeaveSession button successfully");
    }

}
