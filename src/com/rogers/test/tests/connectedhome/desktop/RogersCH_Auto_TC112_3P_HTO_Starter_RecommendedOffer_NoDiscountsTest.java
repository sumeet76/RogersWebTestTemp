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
 * This class contains the test method to test the HTO 3P flow for Rogers.com
 * TC011_CH-7078_CH-9784_CH-10334_CH-16905_Starter Pack_3P HTO_Cx with Recommended Offer_validate the HTO offer on the new Account Overview Page in a banner_ no discounts_E2E_AUTL_NB_CH_EN
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
 * 9. Verify Srtike through price not available
 * 10. Click on Learn More link
 * 11. Click View Next Feature button
 * 12. Click Close button
 * 13. Click Total Channels
 * 14. Hover 4k channels and close popup
 * 15. Click Flex Channels
 * 16. Hover preselected channles and close popup
 * 17. Click on I want this Upgrade checkbox
 * 18. Click on review your upgrade
 * 19. Verify Order Review header
 * 20. Verify PSEF promotion
 * 21. Verify Installation details - Ignite Express Setup Header, fulfilment type: courier delivery, tech install for 3p
 * 22. Click on Learn more about Courier Delivery link
 * 23. Click close Ignite Express Setup popup
 * 24. Click I understand checkbox under Activation
 * 25. Verify Agreement Details block
 * 26. Click Acceptable Use Policy checkbox
 * 27. Click I understand checkbox
 * 28. Click on Submit button
 * 29. Verify Order Confirmation Page
 *
 **/

public class RogersCH_Auto_TC112_3P_HTO_Starter_RecommendedOffer_NoDiscountsTest extends BaseTestClass {

    @Test
    public void rogersCH_Auto_TC112_3P_HTO_Starter_RecommendedOffer_NoDiscounts() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc112_3P_HTO_RecommendedOffer.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc112_3P_HTO_RecommendedOffer.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
            reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc112_3P_HTO_RecommendedOffer.getAccountDetails().getBan());
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

        reporter.hardAssert(!(getRogersHTOPRomotionPage().verifyPriceStrikeThrough()),"Strike through price not present","Strike through price should not be present");

        getRogersHTOPRomotionPage().clickLearnMore();
        reporter.reportLogWithScreenshot("Clicked on Learn More Link");
        getRogersHTOPRomotionPage().clickViewNextFeature();
        reporter.reportLogWithScreenshot("Clicked on View Next Feature Button");
        getRogersHTOPRomotionPage().clickViewPreviousFeature();
        reporter.reportLogWithScreenshot("Clicked on View Previous Feature Button");
        getRogersHTOPRomotionPage().clickClosePopup();
        reporter.reportLogWithScreenshot("Clicked on Close Button");

        getRogersHTOPRomotionPage().clickViewTotalChannels();
        getRogersIgniteTVBuyPage().clkHover4kChannels();
        reporter.reportLogWithScreenshot("what are flex channels Hover message ");
        getRogersIgniteTVBuyPage().clkHoverClose();
        reporter.reportLogWithScreenshot("Close Total Channels popup");
        getRogersHTOPRomotionPage().clickViewFlexChannels();
        reporter.reportLogWithScreenshot("View Flex Channels");
        getRogersIgniteTVBuyPage().clkHoverPreSelectedChannels();
        reporter.reportLogWithScreenshot("Pre Selected Channels Hover message");
        getRogersIgniteTVBuyPage().clkHoverClose();
        reporter.reportLogWithScreenshot("Close Flex Channels popup");

        reporter.hardAssert(!(getRogersHTOPRomotionPage().verifyPromoDiscounts()),"Promo discount not available","Promo Discount should not be present");
        getRogersHTOPRomotionPage().clickIWantThisUpgrade();
        reporter.reportLogWithScreenshot("Clicked on the Upgrade checkbox");
        getRogersHTOPRomotionPage().clickReviewYourUpgrade();
        reporter.reportLogWithScreenshot("Clicked on Review Your Upgrade button");

        reporter.hardAssert(getRogersOrderReviewPage().verifyTargetedOfferOrderReviewPage(),"Order Review Page has launched","Order Review Page has not launched");
        reporter.reportLogWithScreenshot("Launched the order review page");


        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyDisneyImage(), "PSEF promotion", "PSEF promotion not verified");
        String customPrice = getRogersOrderReviewPage().getCustomPrice();

        reporter.hardAssert(getRogersHTOPRomotionPage().verifyBundleOfferPrice(offerPrice, customPrice),"Price match","Price unmatch");
        reporter.reportLogWithScreenshot("Price match on Order review page with promo page");

        getRogersOrderReviewPage().clkShowPriceBreakdown();
        reporter.reportLogWithScreenshot("Expand the Show Price Breakdown button under One-Time Charges block");
        reporter.hardAssert(getRogersOrderReviewPage().verifyFulfillmentType(),"Fulfillment Type is Courier Delivery","Fulfillment Type is not Courier Delivery");
        reporter.reportLogWithScreenshot(" Verified Fulfillment Type to be Courier Delivery");

        reporter.hardAssert(getRogersOrderReviewPage().verifyInstallationDetailsHeader(),"Installation Details is present","Installation Details not present");
        reporter.reportLogWithScreenshot(" Verified installation details header");

        getRogersOrderReviewPage().clkLearnMoreCourierDelivery();
        reporter.reportLogWithScreenshot(" Clicked on Learn More about courier Delivery");

        reporter.hardAssert(getRogersAccountOverviewPage().isNewOfferModalDisplayed(),"Courier Delivery Popup","Courier Deliver popup not present");
        getRogersAccountOverviewPage().clkCloseNewOfferModalPopup();
        reporter.reportLogWithScreenshot(" Close Courier Delivery popup");

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

