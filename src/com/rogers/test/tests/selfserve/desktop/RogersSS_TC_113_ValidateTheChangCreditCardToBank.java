package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_113_ValidateTheChangCreditCardToBank extends BaseTestClass{
    @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        closeSession();
    }

    private void tryLogin(String strUsername, String strPassword) {
        //getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
        getRogersLoginPage().clkSkipIFrame();
        //getRogersLoginPage().switchOutOfSignInIFrame();
    }


    @Test(groups = {"BillingAndPaymentsSS"})
    public void validateTheChangeCreditCardToBank() {

        getRogersHomePage().clkSignIn();
        String strUsername = TestDataHandler.tc161825.getUsername();
        String strPassword = TestDataHandler.tc161825.getPassword();
        tryLogin(strUsername, strPassword);

        reporter.reportLogWithScreenshot("Account Overview page");
        getCommonBusinessFlows().switchPaymentMethodTo(PaymentMethodType.CREDIT);
        reporter.reportLogWithScreenshot("Account Overview page");
        getCommonBusinessFlows().switchPaymentMethodTo(PaymentMethodType.BANK);

    }
}
