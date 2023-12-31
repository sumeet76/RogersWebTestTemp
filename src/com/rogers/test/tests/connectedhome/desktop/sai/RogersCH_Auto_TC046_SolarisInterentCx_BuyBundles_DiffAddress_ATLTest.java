package com.rogers.test.tests.connectedhome.desktop.sai;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;


/**
 * This class contains the test method to verify the Solaris Internet package downgarde flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on internet package.
 *4. Click on chage package button.
 *5. Select a package which has price higher to the current package.
 *6. Scroll down to the last in the page and Click on Checkout.
 *7. Enter appropriate Contact details.
 *8. Pick a date time in step 2 - Most Convenient Time for us to call.
 *9. Click on Continue.
 *10. Go to Agreement section,  scroll down all the way,  and click on "I have read………." check box
 *11. Click on Submit.
 *
 **/

public class RogersCH_Auto_TC046_SolarisInterentCx_BuyBundles_DiffAddress_ATLTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","saiCH"})
    public void rogersCH_Auto_TC046_SolarisInterentCx_BuyBundles_DiffAddress_ATL() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc46_saiAccountForIgniteBundleBuy.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc46_saiAccountForIgniteBundleBuy.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc46_saiAccountForIgniteBundleBuy.accountDetails.getBan());
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getDriver().get(System.getProperty("QaUrl") + "/bundles?setProvince=NL");
        reporter.reportLogWithScreenshot("Launched the IgniteTV page");
        getRogersHomePage().clkServiceability();
        reporter.reportLogWithScreenshot("Launched the customer availability check popup");
        String strAddressLine1 = TestDataHandler.tc46_saiAccountForIgniteBundleBuy.getAccountDetails().getAddress().get("line1");
        String strAddressLine2 = TestDataHandler.tc46_saiAccountForIgniteBundleBuy.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1 + "," + strAddressLine2);
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
        getRogersIgniteTVBuyPage().selectSolarisStarterPackage();
        reporter.reportLogWithScreenshot("TV Bundle is selected");

        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(), "4KTV radio button is available", "4KTV radio button is not available");
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        getRogersIgniteTVBuyPage().set4KTVNo();
        reporter.reportLogWithScreenshot("4k TV selected as NO");
        getRogersIgniteTVBuyPage().clkCheckout();
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersIgniteTVProfileCreationPage().clkSubmitProfile();

        reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(), "TechInstall page has Launched", "TechInstall page has not Launched");
        reporter.reportLogWithScreenshot("Launched the tech install page");
//        getRogersTechInstallPage().clkTechInstalConsent();
        getRogersTechInstallPage().clkProInstallUpgradeNo();
        reporter.reportLogWithScreenshot("tech install details");
        getRogersTechInstallPage().clkTechInstallContinueSelf();
        reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallSetUp(), "SetUp page has Launched", "SetUp page has not Launched");
        getRogersTechInstallPage().clkTechInstallContinue();
       /*getRogersTechInstallPage().clkTechInstalConsent();
       reporter.reportLogWithScreenshot("tech install details");
       getRogersTechInstallPage().clkTechInstallContinue();*/
        reporter.reportLogWithScreenshot("Launched the order review page");
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(), "Agreement page has Launched", "Agreement page has not Launched");
        reporter.reportLogWithScreenshot("Launched the order review page");

        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(), "Agreement has Launched", "Agreement has not Launched");

        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(), "Order has created successfully", "Order has failed");
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
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

