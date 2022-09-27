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
    public void tc51_rogersSAARemoveLongDistanceTest() {
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc51SAA_RemoveLongDistance.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc51SAA_RemoveLongDistance.getPassword());
        getReporter().reportLogWithScreenshot("Login Popup");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        getReporter().hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");
        getRogersAccountOverviewPage().clickManageButton();
        getReporter().reportLogPassWithScreenshot("Dashboard Page");
        getDriver().get(System.getProperty("AWSUrl") + "/manage-addons");
        getReporter().hardAssert(getRogersCheckoutPage().verifyAddonsPage(),
                "Rogers Standalone Addons Page Displayed", "Rogers Standalone Addons Page not Displayed");
        String newAddon = TestDataHandler.tc51SAA_RemoveLongDistance.getAddonName();
        getRogersCheckoutPage().selectAddon(newAddon);
        getReporter().reportLogPassWithScreenshot("Addon Getting Removed " + newAddon);
        getReporter().hardAssert(getRogersReviewOrderPage().isAddonReviewPageDisplayed(),
                "Addons Order Review Page Displayed", "Addons Order Review Page Not Displayed");
        getRogersReviewOrderPage().clkRemoveBtn();
        getReporter().hardAssert(getRogersReviewOrderPage().clkRemovalModalBtn(),
                "Clicked Remove on Addon Removal Modal", "Addon Removal Modal not displayed");
        getReporter().hardAssert(getRogersOrderConfirmationPage().verifyAddonOrderConfirm(),
                "Addons Remove Confirmation Page Displayed", "Addons Remove Confirmation Page Not Displayed");
        String removeConfirmMessage = getRogersOrderConfirmationPage().getOrderConfirmMsg();
        getReporter().reportLogPassWithScreenshot("Addons Remove Confirmation Message: " + removeConfirmMessage);
        getRogersOrderConfirmationPage().clickBackToAddonBtn();
        getReporter().hardAssert(getRogersCheckoutPage().verifyAddonsPage(),
                "Rogers Standalone Addons Page Displayed after Add-on Removal", "Rogers Standalone Addons Page not Displayed after Add-on Removal");
    }
    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
