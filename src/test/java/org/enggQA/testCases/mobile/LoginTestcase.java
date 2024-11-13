package org.enggQA.testCases.mobile;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.enggQA.base.MobileBaseTest;
import org.testng.annotations.Test;

public class LoginTestcase extends MobileBaseTest {

    public static Logger logger = LogManager.getLogger(LoginTestcase.class);

    @Test()
    public void test112(){
        logger.info("This test validates CT inbox visibility when it is set on More feature tab");

    }
}
