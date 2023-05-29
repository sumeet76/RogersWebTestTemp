package com.rogers.test.tests.connectedhome.desktop.hto;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to verify the Internet package upgrade flow for Rogers.com
 * TC021_CH-13512_Existing 3P oldconstructor cx_targeted with ignite 3P_INT_ Banner_offerType is REGULAR with discounts and promotion,
 * offer already expired_Date populated in generic 1 _
 * Validate Banner_Header_Current and new bundle Pricing_Unified checkout page and confirmation page_ON_FF_FR
 * @author manpreet.kaur3
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on internet package.
 *4. Click on change package button.
 *5. Select a package which has price higher to the current package.
 *6. Validate the PTM modal.
 *7. Click continue on PTM modal.
 *8. Validate the PSEF promotion on Order Review page.
 *9. Validate the GWP on Order Review page.
 *10. Go to Agreement section,  scroll down all the way,  and click on "I have read………." check box
 *11. Click on Submit.
 * 12. Verify Order Confirmation
 *
 **/

public class RogersCH_Auto_TC114_3PCx_OldConstructor_HTO_INT_ValidateExpiryDateText_ON_FRTest extends BaseTestClass {

	@Test
    public void rogersCH_Auto_TC114_3PCx_OldConstructor_HTO_INT_ExpiredOffer_ON_FR() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc99_3PCxInternetAccount.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc99_3PCxInternetAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
        getEnsVerifications().setVerificationCodeCH(TestDataHandler.tc99_3PCxInternetAccount.getUsername());
    	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
       // getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc99_3PCxInternetAccount.accountDetails.getBan());
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersSolarisTVDashboardPage().clkFR();
        reporter.reportLogWithScreenshot("Launched the Account Page FR");
        getRogersInternetDashboardPage().clkSolarisInternetBadge();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard");
        getRogersSolarisTVDashboardPage().scrollToViewPersonalizedOffer();
        reporter.reportLogWithScreenshot("Click on HTO View Offer button");
        getRogersSolarisTVDashboardPage().clkViewOfferBadge();
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyIgnitePromotionPage(),"Ignite Promotion Page Available","Ignite Promotion Page not available");
        reporter.reportLogWithScreenshot("On Ignite Promotion Page");
        reporter.hardAssert(getRogersOrderReviewPage().verifyCurrentOfferEndedText(),"Offer Expired Copy", "Offer Expired Copy fail");
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyIgniteCurrentBundle(),"Current Bundle details Available","Current Bundle details not Available");
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyOfferBundle(),"New Bundle details Available","New Bundle details not Available");
        String offerPrice = getRogersOrderReviewPage().getIgniteOfferPrice();
        getRogersOrderReviewPage().scrollToOfferPrice();
        reporter.reportLogWithScreenshot("Bundle details");
        getRogersHTOPRomotionPage().clickViewTotalChannels();
        reporter.reportLogWithScreenshot("View Total Channels");
        getRogersIgniteTVBuyPage().clkHover4kChannels();
        reporter.reportLogWithScreenshot("what are flex channels Hover message ");
        getRogersIgniteTVBuyPage().clkHoverClose();
        reporter.reportLogWithScreenshot("Close Total Channels popup");
        getRogersHTOPRomotionPage().clickIgniteLearnMore();
        reporter.reportLogWithScreenshot("Clicked on Learn More Link");
        getRogersIgniteTVBuyPage().clkHoverClose();
        reporter.reportLogWithScreenshot("Close Ignite-hto-learn-more-modal-component");
        getRogersHTOPRomotionPage().clickIgniteViewFlexChannels();
        reporter.reportLogWithScreenshot("View Flex Channels");
        getRogersIgniteTVBuyPage().clkHoverPreSelectedChannels();
        reporter.reportLogWithScreenshot("Pre Selected Channels Hover message");
        getRogersIgniteTVBuyPage().clkHoverClose();
        reporter.reportLogWithScreenshot("Close Flex Channels popup");
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyPromoDiscounts(),"Promo discount available","Promo Discount not available");
        getRogersHTOPRomotionPage().clkGetItNow();
        reporter.hardAssert(getRogersOrderReviewPage().verifyIgniteTargetedOfferOrderReviewPage(),"Order Review Page has launched","Order Review Page has not launched");
        reporter.reportLogWithScreenshot("Launched the order review page");

        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyDisneyImage(), "PSEF promotion", "PSEF promotion not verified");

        String customPrice = getRogersOrderReviewPage().getIgniteCustomPrice();
        getRogersOrderReviewPage().scrollToCustomPrice();
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyBundleOfferPrice(offerPrice, customPrice),"Price match","Price unmatch");
        reporter.reportLogWithScreenshot("Price match on Order review page with promo page");

        getRogersOrderReviewPage().clkShowPriceBreakdown();
        reporter.reportLogWithScreenshot("Expand the Show Price Breakdown button under One-Time Charges block");

        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");

        getRogersOrderReviewPage().clkIgniteHTOAgreementCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");

        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
    	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}


}

