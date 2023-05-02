package com.rogers.test.tests.connectedhome.desktop.hto;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class RogersCH_Auto_TC115_HTO_RegularOffer_ValidateDiscountIsNotAddedForAdditionalSTB_E2E_AUTL_ON_EN extends BaseTestClass {

    @Test(groups = {"Regression"})
    public void ValidateDiscountIsNotAddedForAdditionalSTB_E2E_AUTL_ON_EN(){

        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc115_3p_hto_regular.getUsername());
        reporter.reportLogWithScreenshot("Entered the username field successfully");
        getRogersLoginPage().clkContinueInBrowser();
        reporter.reportLogWithScreenshot("Clicked on the continue button");
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc115_3p_hto_regular.getPassword());
        reporter.reportLogWithScreenshot("Enter the password successufully");
        getRogersLoginPage().clkSignInIFrame();
        reporter.reportLogWithScreenshot("Clicked on the sign in button");
       // getRogersAccountOverviewPage().selectAnAccountFromTheAccountDropDown();
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc115_3p_hto_regular.getAccountNo());
        reporter.reportLogWithScreenshot("Clicked on the account Number");
        getRogersAccountOverviewPage().clkCloseNewOfferModalPopup();
        reporter.reportLogWithScreenshot("Clicked on the close button in the offer model popup");
        getRogersAccountOverviewPage().clkSpecialOfferBadge();
        reporter.reportLogWithScreenshot("Clicked on the view promotions ");

        getRogersHTOPRomotionPage().clickClosePopup();
        reporter.reportLogWithScreenshot("Close Feature popup");
        /** // commented for reducing execution time. **/
        getRogersHTOPRomotionPage().clickLearnMore();
        reporter.reportLogWithScreenshot("Clicked on the Learn more link");
        getRogersHTOPRomotionPage().clickViewNextFeature();
        reporter.reportLogWithScreenshot("Clicked on the view next feature");
        getRogersHTOPRomotionPage().clickViewNextFeature();
        reporter.reportLogWithScreenshot("Clicked on the view next feature");
        getRogersHTOPRomotionPage().clickViewNextFeature();
        reporter.reportLogWithScreenshot("Clicked on the view next feature");
        getRogersHTOPRomotionPage().clickClosePopup();

        getRogersHTOPRomotionPage().clickAdditionChannelsAndThemePacks();
        reporter.reportLogWithScreenshot("Clicked on the Additional Channels and Themepacks");
        getRogersHTOPRomotionPage().clickClosePopup();
        getRogersHTOPRomotionPage().clkFlexChannelsLink();
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyFlexChannelsPopupModal(),"Flex channel popup displayed","Failed to verify Flex channel popup");
        reporter.reportLogWithScreenshot("Clicked on the view all flex channels link");
        getRogersHTOPRomotionPage().clkCloseFlexChannelsPopupModal();
        reporter.reportLogWithScreenshot("Closed the popup");
        getRogersHTOPRomotionPage().clickIWantThisUpgrade();
        reporter.reportLogWithScreenshot("Clicked on the I want this upgrade checkbox");
        getRogersHTOPRomotionPage().waitForPopupToDisappear();
        getRogersHTOPRomotionPage().clickReviewYourUpgrade();
        getRogersHTOPRomotionPage().waitForPopupToDisappear();

        reporter.reportLogWithScreenshot("Verified order review page.");
        getRogersOrderReviewPage().clkAcceptenceCheckboxHTO();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(), "Order has created successfully", "Order has failed");
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
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
