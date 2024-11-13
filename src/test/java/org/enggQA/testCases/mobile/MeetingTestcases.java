package org.enggQA.testCases.mobile;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.enggQA.base.MobileBaseTest;
import org.enggQA.report.ExtentTestManager;
import org.testng.annotations.Test;

public class MeetingTestcases extends MobileBaseTest {
    private static final Logger logger = LogManager.getLogger(MeetingTestcases.class);


    @Test(priority = 0, groups = {"regression"})
    public void validateEndToEndFlowOfApp(){
        String testId="T12345";
        logger.info(testId +" : This test validates e2e flow of app launch and verify if video is showing up on the app.");
        ExtentTestManager.getTest().setDescription(testId +" :This test validates e2e flow of app launch and verify if video is showing up on the app.");
        isJoiningPageVisible();
        enterMeetingLink(getMeetingLink());
        clickOnJoinNowButton();
        waitFor(1.5);
        isPreviewPageVisible();
        clickOnJoinNowButtonOnPreview();
        waitFor(1.5);
        ismeetingPageVisible();
        clickOnCameraSwitchButton();
        waitFor(.5);
        clickOnMicButton();
        clickOnVideoButton();
        clickOnMessageButton();
        waitFor(.5);
        clickOnChatCloseButton();
        clickOnMoreButton();
        waitFor(.5);
        clickOnMoreCloseButton();
        clickOnMeetingEndButton();
        clickOnMeetingEndConfirmationButton();
        clickOnLeaveSessionButton();
        waitFor(1.5);
        isJoiningPageVisible();
    }
}
