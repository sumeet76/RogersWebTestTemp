package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class RogersCH_Auto_TC115_HTO_RegularOffer_ValidateDiscountIsNotAddedForAdditionalSTB_E2E_AUTL_ON_EN extends BaseTestClass {

    @Test(groups = {"Regression"})
    public void ValidateDiscountIsNotAddedForAdditionalSTB_E2E_AUTL_ON_EN(){

        getRogersLoginPage().setUsernameIFrame("chqaagile-Sgl190@yahoo.com");
        reporter.reportLogWithScreenshot("Entered the username field successfully");
        getRogersLoginPage().clkContinueInBrowser();
        reporter.reportLogWithScreenshot("Clicked on the continue button");
        getRogersLoginPage().setPasswordIFrame("Rogers123");
        reporter.reportLogWithScreenshot("Enter the password successufully");
        getRogersLoginPage().clkSignInIFrame();
        reporter.reportLogWithScreenshot("Clicked on the sign in button");
        getRogersAccountOverviewPage().selectAccount("265048368300");
        reporter.reportLogWithScreenshot("Clicked on the account Number");
        getRogersAccountOverviewPage().clkCloseNewOfferModalPopup();
        reporter.reportLogWithScreenshot("Clicked on the close button in the offer model popup");
        getRogersAccountOverviewPage().clkSpecialOfferBadge();
        reporter.reportLogWithScreenshot("Clicked on the view promotions ");

        getRogersHTOPRomotionPage().clickClosePopup();
        reporter.reportLogWithScreenshot("Close Feature popup");

        getRogersHTOPRomotionPage().clickLearnMore();
        reporter.reportLogWithScreenshot("Clicked on the Learn more link");
        getRogersHTOPRomotionPage().clickClosePopup();
        getRogersHTOPRomotionPage().clkFlexChannelsLink();
        reporter.reportLogWithScreenshot("Clicked on the view all flex channels link");
        getRogersHTOPRomotionPage().clkCloseFlexChannelsPopupModal();
        reporter.reportLogWithScreenshot("Closed the popup");
        getRogersHTOPRomotionPage().clickIWantThisUpgrade();
        reporter.reportLogWithScreenshot("Clicked on the I want this upgrade checkbox");
        getRogersHTOPRomotionPage().waitForPopupToDisappear();
        getRogersHTOPRomotionPage().clickReviewYourUpgrade();
        getRogersHTOPRomotionPage().waitForPopupToDisappear();
        getRogersReviewOrderPage().getMonthlyFeeAfterTax();
        reporter.reportLogWithScreenshot("Verified order review page.");

    }

    @BeforeMethod(alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    //login flow
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_legacylogin, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        //closeSession();
    }
}
