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
 * This class contains the test method to test the HTO 2P flow for Rogers.com
 * CH-8309_CH-9786_2P-2p HTO_Regular_HOT_Sign in MyRogers_Validate the legal text_bundle discount_Add channels_theme pack_One-time fee_saving section discount detail displayed only for campaign applied products_Review_confirmation_ON_CH_EN
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
 * 13. Verify Order Review header
 * 14. Verify PSEF promotion
 * 15. Verify GWP
 * 16. Verify One-Time charges and credits be $0
 * 17. Verify Installation details - Ignite Express Setup Header, fulfilment type: courier delivery, tech install for 3p
 * 18. Click on Learn more about Courier Delivery link
 * 19. Click close Ignite Express Setup popup
 * 20. Use Service Address
 * 21. Click I understand checkbox under Activation
 * 22. Click Email radio button to recieve order summary and agreement
 * 23. Verify Agreement Details block
 * 24. Click Acceptable Use Policy checkbox
 * 25. Click I understand checkbox
 * 26. Click on Submit button
 * 27. Verify Order Confirmation Page
 *
 **/

public class RogersCH_Auto_TC101_2P_HTO_2P_Validate$0ExpressSetupFee_CourierFulfilment_HotCableTest extends BaseTestClass {

    @Test
    public void rogersCH_Auto_TC101_2P_HTO_2P_Validate$0ExpressSetupFee_CourierFulfilment_HotCable() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc101_2P_HTO_HotCableAccount.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc101_2P_HTO_HotCableAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        getRogersLoginPage().clkSkipIFrame();

        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
            reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc101_2P_HTO_HotCableAccount.getAccountDetails().getBan());
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

        String offerPrice = getRogersOrderReviewPage().getOfferPrice();
       // System.out.println(offerPrice);

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

        reporter.hardAssert(getRogersOrderReviewPage().verifyAdditionalSTBs(), "Additional STBs verified","Additional STBs not verified");

        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyDisneyImage(), "PSEF promotion", "PSEF promotion not verified");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyGWPTag(), "GWP verified", "GWP not verified");

        String customPrice = getRogersOrderReviewPage().getCustomPrice();
       // System.out.println(customPrice);

        reporter.hardAssert(getRogersHTOPRomotionPage().verifyBundleOfferPrice(offerPrice, customPrice),"Price match","Price unmatch");
        reporter.reportLogWithScreenshot("Price match on Order review page with promo page");
        reporter.hardAssert(getRogersOrderReviewPage().verifyOneTimeChargeToBeZero(),"One-Time charge is $0.00","One-Time charge is not $0.00");
        reporter.reportLogWithScreenshot("reviewed One-Time charge to be $0.00");

        getRogersOrderReviewPage().clkShowPriceBreakdown();
        reporter.reportLogWithScreenshot("Expand the Show Price Breakdown button under One-Time Charges block");
        reporter.hardAssert(getRogersOrderReviewPage().verifyFulfillmentType(),"Fulfillment Type is Courier Delivery","Fulfillment Type is not Courier Delivery");
        reporter.reportLogWithScreenshot(" Verified Fulfillment Type to be Courier Delivery");

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

