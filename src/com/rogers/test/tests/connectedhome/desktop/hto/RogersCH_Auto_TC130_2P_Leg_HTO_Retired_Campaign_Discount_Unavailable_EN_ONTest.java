package com.rogers.test.tests.connectedhome.desktop.hto;
import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;
import com.rogers.test.helpers.RogersEnums;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains test method to validate that for 2p legacy HTO Cx discounts are not appeared on promo / order review for a given campaign that is not valid in Maestro but configured in ATG (KDZ campaign)
 * TC028_CH-17152_Validate whether user is given with the campaign is not valid in Maestro _but configured to ATG Digital_Retired Campaign_2P Legacy HTO_ON_EN
 * Validate the price and legal text_Bundle and two or more STBs with discount_
 * fulfillment_legal text_One-time fee_Offer page_unified checkout_order confirmation_ON_CH_EN
 *
 * @author nandan.master
 * <p>
 * Test steps:
 * <p>
 * 1. Launch Rogers.com Home Page
 * 2. Sign in with 2p legacy Cx profile (with HTO)
 * 4. Close the New Offer Modal if displayed
 * 5. Verify Special Offer badge on AO page
 * 6. Click on Special Offer badge
 * 7. Validate promo page is loaded successfully
 * 8. Verify current and promotional bundle prices
 * 9. Verify the promo price is NOT struck out
 * 8. Verify there are no discounts in Promotions & Discounts section
 * 9. Click on I want this upgrade checkbox
 * 10. Click on review your upgrade
 * 10. Verify Order Review page is launched successfully
 * 11. Validate the discount section is not appeared on Review page
 * 12. Validate discounts not appeared in monthly charges
 * 13. Match Offer prices on promo and order review page
 *
 **/

public class RogersCH_Auto_TC130_2P_Leg_HTO_Retired_Campaign_Discount_Unavailable_EN_ONTest extends BaseTestClass {
    @Test
    public void rogersCH_Auto_TC130_2P_Leg_HTO_Retired_Campaign_Discount_Unavailable_EN_ON() {

        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc102_2P_HTO_ColdCableAccount.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc102_2P_HTO_ColdCableAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");

        if (getRogersAccountOverviewPage().isNewOfferModalDisplayed()) {
            reporter.reportLogWithScreenshot("New Offer Modal Popup is displayed");
            getRogersAccountOverviewPage().clkCloseNewOfferModalPopup();
            reporter.reportLogWithScreenshot("New Offer Modal Popup closed");
        }

        reporter.hardAssert(getRogersAccountOverviewPage().verifySpecialOfferBadge(), "Special Offer Recommendation Badge Available", "Special Offer Recommendation Badge not available");
        getRogersAccountOverviewPage().clkSpecialOfferBadge();
        reporter.reportLogWithScreenshot("Clicked on the Special Offer Recommendation Badge");
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyPromotionPage(), "Promotion Page Available", "Promotion Page not available");
        reporter.reportLogWithScreenshot("On Promotion Page");
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyCurrentBundle(), "Old Bundle details Available", "Old Bundle details not Available");
        reporter.reportLogWithScreenshot("Verified Old bundle Details");
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyOfferBundle(), "New Bundle details Available", "New Bundle details not Available");
        reporter.reportLogWithScreenshot("Verified New bundle Details");

        String offerPrice = getRogersOrderReviewPage().getOfferPrice();

        reporter.hardAssert(!getRogersHTOPRomotionPage().verifyPriceStrikeThrough(), "Strike out price is NOT displayed ", "Strike out price displayed - which is not expected for this campaign");
        reporter.hardAssert(!getRogersHTOPRomotionPage().verifyPromoDiscounts(), "Promo discount is NOT available", "Promo discount is present, which is not expected for this campaign");

        getRogersHTOPRomotionPage().clickIWantThisUpgrade();
        reporter.reportLogWithScreenshot("Clicked on the Upgrade checkbox");
        getRogersHTOPRomotionPage().clickReviewYourUpgrade();
        reporter.reportLogWithScreenshot("Clicked on Review Your Upgrade button");

        reporter.hardAssert(getRogersOrderReviewPage().verifyTargetedOfferOrderReviewPage(), "Order Review Page has launched", "Order Review Page has not launched");
        reporter.reportLogWithScreenshot("Launched the order review page");

        String customPrice = getRogersOrderReviewPage().getCustomPrice();
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyBundleOfferPrice(offerPrice, customPrice), "Price match", "Price unmatch");
        reporter.reportLogWithScreenshot("Price match on Order review page with promo page");
        reporter.hardAssert(!getRogersHTOPRomotionPage().verifyPromoDiscounts(), "Promo discount is NOT available", "Promo discount is present, which is not expected for this campaign");
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    //login flow
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_login, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}
