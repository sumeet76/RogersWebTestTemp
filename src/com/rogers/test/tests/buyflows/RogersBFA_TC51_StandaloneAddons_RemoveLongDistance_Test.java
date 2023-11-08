package com.rogers.test.tests.buyflows;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class RogersBFA_TC51_StandaloneAddons_RemoveLongDistance_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows , method);
    }

    @Test(groups = {"RegressionBFA","SAABFA"})
    public void tc51_RogersSAA_RemoveLongDistanceTest() {
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc51SAA_RemoveLongDistance.getUsername());
        getRogersLoginPage().clkContinueSignIn();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc51SAA_RemoveLongDistance.getPassword());
        reporter.reportLogWithScreenshot("Login Popup");
        getRogersLoginPage().clkSignInIFrame();
        //getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        reporter.reportLogWithScreenshot("Account Overview page");
        getRogersAccountOverviewPage().clickManageButton();
        reporter.reportLogPassWithScreenshot("Dashboard Page");
        getDriver().get(System.getProperty("AWSUrl") + "/manage-addons");
        reporter.hardAssert(getRogersCheckoutPage().verifyAddonsPage(),
                "Rogers Standalone Addons Page Displayed", "Rogers Standalone Addons Page not Displayed");
        String newAddon = TestDataHandler.tc51SAA_RemoveLongDistance.getAddonName();
        getRogersCheckoutPage().selectAddon(newAddon);
        reporter.reportLogPassWithScreenshot("Addon Getting Removed " + newAddon);
        reporter.hardAssert(getRogersReviewOrderPage().isAddonReviewPageDisplayed(),
                "Addons Order Review Page Displayed", "Addons Order Review Page Not Displayed");
        getRogersReviewOrderPage().clkRemoveBtn();
        reporter.hardAssert(getRogersReviewOrderPage().clkRemovalModalBtn(),
                "Clicked Remove on Addon Removal Modal", "Addon Removal Modal not displayed");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyAddonOrderConfirm(),
                "Addons Remove Confirmation Page Displayed", "Addons Remove Confirmation Page Not Displayed");
        String removeConfirmMessage = getRogersOrderConfirmationPage().getOrderConfirmMsg();
        reporter.reportLogPassWithScreenshot("Addons Remove Confirmation Message: " + removeConfirmMessage);
        getRogersOrderConfirmationPage().clickBackToAddonBtn();
        reporter.hardAssert(getRogersCheckoutPage().verifyAddonsPage(),
                "Rogers Standalone Addons Page Displayed after Add-on Removal", "Rogers Standalone Addons Page not Displayed after Add-on Removal");
    }
    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
