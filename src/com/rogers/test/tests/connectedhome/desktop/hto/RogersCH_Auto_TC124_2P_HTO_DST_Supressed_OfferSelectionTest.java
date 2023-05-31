package com.rogers.test.tests.connectedhome.desktop.hto;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to test the HTO 2P flow for Rogers.com
 * CH-8309_CH-9786_2P-2p HTO_Regular_HOT_Sign in MyRogers_Validate the legal text_bundle discount_Add channels_theme pack_One-time fee_saving section discount detail displayed only for campaign applied products_Review_confirmation_ON_CH_EN
 * @author nandan.master
 *
 * Test steps:
 *
 * 1. Launch Rogers.com Home Page
 * 2. Click on Sign In link
 * 3. Enter user credentials & hit Sign in button
 * 4. Select a user account if multiple accounts are linked with the profile
 * 5. Close the special offer pop up if displayed
 * 6. Validate Special Offer text on account overview page
 * 7. Navigated to the Bundles page
 * 8. Clicked on Serviceability button
 * 9. Launched bundle offers page
 * 10. Validated that the DST for bundles (2p legacy HTO) is supressed
 *
 **/

public class RogersCH_Auto_TC124_2P_HTO_DST_Supressed_OfferSelectionTest extends BaseTestClass {

    @Test
    public void RogersCH_Auto_TC124_2P_HTO_DST_Supressed_OfferSelection() {
        reporter.reportLogWithScreenshot("Sign In page is launched");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc101_2P_HTO_HotCableAccount.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc101_2P_HTO_HotCableAccount.getPassword());
        reporter.reportLogWithScreenshot("Entered the account credentials");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc101_2P_HTO_HotCableAccount.getAccountDetails().getBan());
        reporter.reportLogWithScreenshot("Account Selected");
        getRogersAccountOverviewPage().clkCloseNewOfferModalPopup();
        reporter.reportLogWithScreenshot("New Offer Modal Popup closed");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySpecialOfferBadge(), "Special Offer Recommendation Badge Available", "Special Offer Recommendation Badge not available");

        getDriver().get(System.getProperty("QaUrl") + "/bundles");
        reporter.reportLogWithScreenshot("Launched the IgniteTV Bundles page");
        getRogersHomePage().clkServiceability();
        reporter.reportLogWithScreenshot("Serviceability model is launched");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(), "Bundles Page has launched", "Bundles Page has not launched");

        reporter.hardAssert(!getRogersIgniteTVBuyPage().verifyTaketheQuizButton(), "Take quiz (DST) is not present", "Take quiz (DST) is present");
    }


    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_legacylogin, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}
