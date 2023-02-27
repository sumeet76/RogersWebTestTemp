package com.rogers.test.tests.connectedhome.desktop;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to validate the 1p legacy to Ignite 1p (SAI) HTO offer  - DOB widget removed from offer and review page
 * TC001_CH-10619_11741_11719_CH-16905_Existing Legacy 1P INT Cx_Sign-in from MyROgers_Targeted with Ignite 1p(SAI)_validate the HTO offer on the new Account Overview Page in a banner_Validate the flow is automated_DOB widget removed from offer and review page_E2E_AUTL flow_ON_CH_EN
 * @author nandan.master
 *
 * Test steps:
 *
 * 1. Launch Rogers.com Home Page
 * 2. Click on Sign In link
 * 3. Enter Username/Password in the Sign In frame and log in
 * 4. Select Account
 * 5. Verify and click on special recommendation yellow badge
 * 6. Verify Special Offer text
 * 7. Verify old and new package text
 * 8. Click on Learn More link
 * 9. Click View Next Feature button
 * 10. Click Close button
 * 11. Click on I want this Upgrade checkbox
 * 12. Click on review your upgrade
 * 13. Verify Order Review header
 * 14. Verify bundle price on order review page
 * 15. Verify Installation details - Ignite Express Setup Header, fulfilment type: courier delivery, tech install for 1p
 * 16. Click on Learn more about Courier Delivery link
 * 17. Click close Ignite Express Setup popup
 * 18. Use Service Address
 * 19. Click I understand checkbox under Activation
 * 20. Click Email radio button to recieve order summary and agreement
 * 21. Verify Agreement Details block
 * 22. Click Acceptable Use Policy checkbox
 * 23. Click I understand checkbox
 * 24. Click on Submit button
 * 25. Verify Order Confirmation Page
 *
 **/
public class RogersCH_Auto_TC109_HTO_1pLeg_1pIgnite_ValidateOffer_E2E_ONTest extends BaseTestClass {
    @Test
    public void rogersCH_Auto_TC109_HTO_1pLeg_1pIgnite_ValidateOffer_E2E_ON() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc109_1P_HTO_DOCSIS.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc109_1P_HTO_DOCSIS.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
            reporter.reportLogWithScreenshot("Select an account");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc109_1P_HTO_DOCSIS.getAccountDetails().getBan());
            reporter.reportLogWithScreenshot("Account Selected");
        }
        if (getRogersAccountOverviewPage().isNewOfferModalDisplayed()) {
            reporter.reportLogWithScreenshot("New Offer Modal Popup");
            getRogersAccountOverviewPage().clkCloseNewOfferModalPopup();
            reporter.reportLogWithScreenshot("New Offer Modal Popup closed");
        }
        reporter.hardAssert(getRogersAccountOverviewPage().verifySpecialOfferBadge(),"Special Offer Recommendation Badge Available","Special Offer Recommendation Badge not available");
        getDriver().get(System.getProperty("QaUrl")+"/internet");
        reporter.reportLogWithScreenshot("Launched the Internet page");
        reporter.hardAssert(getRogersHomePage().verifyInternetpage(), "Internet page has Launched", "Internet page has not Launched");
        reporter.reportLogWithScreenshot("Launched the Internet packages page");
        getRogersHomePage().clkInternetAvailability();
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyInternetPackagesPage(),"Packages page has Launched","Packages page has not Launched");
//        String pkgPrice = getRogersInternetPackageSelectionPage().getInternetPkgPrice(TestDataHandler.tc109_1P_HTO_DOCSIS.getAccountDetails().getInternetBundle());
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyPersonalizedOfferBanner(),"Your Personalized Offer section available","Your Personalized Offer section available");
        getRogersInternetPackageSelectionPage().clkPersonalizedOffer();

        reporter.hardAssert(getRogersHTOPRomotionPage().verifyPromotionPage(),"Promotion Page Available","Promotion Page not available");
        reporter.reportLogWithScreenshot("On Promotion Page");
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyCurrentBundle(),"Old Bundle details Available","Old Bundle details not Available");
        reporter.reportLogWithScreenshot("Verified Old bundle Details");
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyOfferBundle(),"New Bundle details Available","New Bundle details not Available");
        reporter.reportLogWithScreenshot("Verified New bundle Details");

        String offerPrice = getRogersHTOPRomotionPage().getOfferBundlePrice();
        // to be uncommented once bundle price issue on Promo page is resolved.
//        reporter.hardAssert(Integer.parseInt(offerPrice) < Integer.parseInt(pkgPrice),"Offer Price is validated","Offer Price is incorrect");

        getRogersHTOPRomotionPage().clickLearnMore();
        reporter.reportLogWithScreenshot("Clicked on Learn More Link");
        getRogersHTOPRomotionPage().clickViewNextFeature();
        reporter.reportLogWithScreenshot("Clicked on View Next Feature Button");
        getRogersHTOPRomotionPage().clickViewPreviousFeature();
        reporter.reportLogWithScreenshot("Clicked on View Previous Feature Button");
        getRogersHTOPRomotionPage().clickClosePopup();
        reporter.reportLogWithScreenshot("Clicked on Close Button");
        getRogersHTOPRomotionPage().clickIWantThisUpgrade();
        reporter.reportLogWithScreenshot("Clicked on the Upgrade checkbox");
        getRogersHTOPRomotionPage().clickReviewYourUpgrade();
        reporter.reportLogWithScreenshot("Clicked on Review Your Upgrade button");

        reporter.hardAssert(getRogersOrderReviewPage().verifyTargetedOfferOrderReviewPage(),"Order Review Page has launched","Order Review Page has not launched");
        reporter.reportLogWithScreenshot("Launched the order review page");

        String customPrice = getRogersOrderReviewPage().getCustomPrice();
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyBundleOfferPrice(offerPrice, customPrice),"Price match","Price unmatch");
        reporter.reportLogWithScreenshot("Price match on Order review page with promo page");

        reporter.hardAssert(getRogersOrderReviewPage().verifyInstallationDetailsHeader(),"Installation Details is present","Installation Details not present");
        reporter.reportLogWithScreenshot(" Verified installation details header");

        getRogersOrderReviewPage().clkActivationCheckbox();
        reporter.reportLogWithScreenshot(" Clicked on Activation Checkbox");

        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");

        getRogersOrderReviewPage().clkAgreementCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");

        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");
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

