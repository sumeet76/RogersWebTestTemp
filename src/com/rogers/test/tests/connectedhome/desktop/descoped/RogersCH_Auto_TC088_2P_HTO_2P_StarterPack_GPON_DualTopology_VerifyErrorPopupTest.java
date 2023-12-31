package com.rogers.test.tests.connectedhome.desktop.descoped;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to test the HTO GPON Dual Topology flow for Rogers.com
 *
 * @author Manpreet.Kaur3
 *
 * Test steps:
 *
 * 1. Launch Rogers.com Home Page
 * 2. Click on Sign In link
 * 3. Enter Username/Password in the Sign In frame and log in
 * 4. Verify
 * 5. Select Account
 * 6. Verify and click on special recommendation yellow badge
 * 7. Verify Special Offer text
 * 8. Verify old and new package text
 * 9. Click on Learn More link
 * 10. Click View Next Feature button
 * 10. Click Close button
 * 11. Click on I want this Upgrade checkbox
 * 12. Click on review your upgrade
 * 13. Verify Downgrade LTQ Modal
 *
 **/

public class RogersCH_Auto_TC088_2P_HTO_2P_StarterPack_GPON_DualTopology_VerifyErrorPopupTest extends BaseTestClass {

    @Test(groups = {"RegressionCH"})
    public void rogersCH_Auto_TC088_2P_HTO_2P_StarterPack_GPON_DualTopology_VerifyErrorPopup() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc88_GPON_DualTopology.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc88_GPON_DualTopology.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");

        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
            reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc88_GPON_DualTopology.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account Selected");
        if (getRogersAccountOverviewPage().isNewOfferModalDisplayed()) {
            reporter.reportLogWithScreenshot("New Offer Modal Popup");
            getRogersAccountOverviewPage().clkCloseNewOfferModalPopup();
        }
        reporter.reportLogWithScreenshot("New Offer Modal Popup closed");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySpecialOfferBadge(),"Special Offer Recommendation Badge Available","Special Offer Recommendation Badge not available");
        getRogersAccountOverviewPage().clkSpecialOfferBadge();
        reporter.reportLogWithScreenshot("Clicked on the Special Offer Recommendation Bagde");

        reporter.hardAssert(getRogersHTOPRomotionPage().verifyPromotionPage(),"Promotion Page Available","Promotion Page not available");
        reporter.reportLogWithScreenshot("On Promotion Page");

        reporter.hardAssert(getRogersHTOPRomotionPage().verifyCurrentBundle(),"Old Bundle details Available","Old Bundle details not Available");
        reporter.reportLogWithScreenshot("Verified Old bundle Details");
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyOfferBundle(),"New Bundle details Available","New Bundle details not Available");
        reporter.reportLogWithScreenshot("Verified New bundle Details");
        getRogersHTOPRomotionPage().clickLearnMore();
        reporter.reportLogWithScreenshot("Clicked on Learn More Link");
        getRogersHTOPRomotionPage().clickViewNextFeature();
        reporter.reportLogWithScreenshot("Clicked on View Next Feature Button");
        getRogersHTOPRomotionPage().clickViewPreviousFeature();
        reporter.reportLogWithScreenshot("Clicked on View Previous Feature Button");
        getRogersHTOPRomotionPage().clickClosePopup();
        reporter.reportLogWithScreenshot("Clicked on Close Button");
        getRogersHTOPRomotionPage().clkAvailableChannelsLink();
        reporter.reportLogWithScreenshot("Clicked on the Available Channels");
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyAvailableChannelsPopupModal(),"Available Channels Popup Modal verified","Available Channels Popup Modal not verified");
        getRogersHTOPRomotionPage().clkCloseAvailableChannelsPopupModal();
        reporter.reportLogWithScreenshot("Closed the Available Channels Popup Modal");
        getRogersHTOPRomotionPage().clkFlexChannelsLink();
        reporter.reportLogWithScreenshot("Clicked on the Flex Channels");
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyFlexChannelsPopupModal(),"Flex Channels Popup Modal verified","Flex Channels Popup Modal not verified");
        getRogersHTOPRomotionPage().clkCloseFlexChannelsPopupModal();
        reporter.reportLogWithScreenshot("Closed the Flex Channels Popup Modal"); 
        getRogersHTOPRomotionPage().clickUpgradeNow();
        reporter.reportLogWithScreenshot("Clicked on Upgrade Now button");
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyDowngradeLTQModal(),"Verified the Downgrade LTQ Modal","Downgrade LTQ Modal not verified");
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyWarningIconSorryModal(), "verified the warning icon", "Warning icon not verified");
        reporter.softAssert(getRogersHTOPRomotionPage().verifyPopUpHeader(), "Header Verified", "Header not verified");
        reporter.softAssert(getRogersHTOPRomotionPage().verifySorryHeader(), "Sorry Header Verified", "Sorry Header not verified");
        reporter.softAssert(getRogersHTOPRomotionPage().verifyCallLink(), " Call link Verified", "Call link not verified");
        reporter.softAssert(getRogersHTOPRomotionPage().verifyLiveChatLink(), " Live Chat Link Verified", "Live Chat Link not verified");
        reporter.softAssert(getRogersHTOPRomotionPage().verifyContactUsLink(), " Contact Us Link Verified", "Contact Us Link not verified");
    }


    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    //login flow
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }



}

