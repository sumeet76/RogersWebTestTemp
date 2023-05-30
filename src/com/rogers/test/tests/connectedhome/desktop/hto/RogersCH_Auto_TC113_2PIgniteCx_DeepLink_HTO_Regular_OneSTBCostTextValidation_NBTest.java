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
 * This class contains the test method to verify the 2P Ignite Cx login through deep link for Rogers.com
 * TC020_CH-13512_CH-17117_CH-16866_CH-17483_Existing 2P bundle cx_TV Dashboard_targeted with ignite 2P_ Deep Link_Validate Your Current bundle section_Actual price coming CITSEL_Regular offer_without expiry date_Additional STBs on review page_NB_FF_FR
 * @author manpreet.kaur3
 * Test steps:
 *
 *1. Launch deeplink 'Rogers.com/home/hto-eop'
 *2. Login with valid credentails -  sigle profile with multiple accounts
 *3. Select the account linked with profile
 *4. Click on Tv Badge to land on TV dashboard page
 *5. Click on View Offer to view the personalized offer and land on Promo Page
 *6. Validate Current and New Offer details
 *7. Click on Total Channels, validate popup and close
 *8. Click on Flex Channels, validate popup and close
 *9. Click on Learn More, validate popup and close
 *10. Validate promo discounts
 *11. Click get it now button and validate Offer review page
 *12. Validate PSEF promotion
 *13. Validate custom price on order review page with promo page new offer price
 *14. Validate the One TV Box Note with price
 *15. View Agreement and check terms and conditions
 *16. Click on submit
 *17. verify order Confirmation
 **/

public class RogersCH_Auto_TC113_2PIgniteCx_DeepLink_HTO_Regular_OneSTBCostTextValidation_NBTest extends BaseTestClass {
	
	@Test
	public void rogersCH_Auto_TC113_2PIgniteCx_DeepLink_HTO_Regular_OneSTBCostTextValidation_NB() {
		reporter.reportLogWithScreenshot("Launched the Deeplink");
		getDriver().get(System.getProperty("QaUrl")+"/home/hto-eop");
		reporter.reportLogWithScreenshot("Launched the SignIn popup through deeplink");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc04_08_SolarisTVAccount.getUsername());
		getRogersLoginPage().clkContinueInBrowser();
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc04_08_SolarisTVAccount.getPassword());
		reporter.reportLogWithScreenshot("Entered the account credentials");
		getRogersLoginPage().clkSignInIFrame();
		reporter.reportLogWithScreenshot("Sign-in");
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc04_08_SolarisTVAccount.getAccountDetails().getBan());
		reporter.reportLogWithScreenshot("Account Selected");
		getRogersSolarisTVDashboardPage().clkTVBadge();
		reporter.reportLogWithScreenshot("Launched the TV dash board");
		getRogersSolarisTVDashboardPage().scrollToViewPersonalizedOffer();
		reporter.reportLogWithScreenshot("Click on HTO View Offer button");
		getRogersSolarisTVDashboardPage().clkViewOfferBadge();
		reporter.hardAssert(getRogersHTOPRomotionPage().verifyIgnitePromotionPage(),"Ignite Promotion Page Available","Ignite Promotion Page not available");
		reporter.reportLogWithScreenshot("On Ignite Promotion Page");
		reporter.hardAssert(getRogersHTOPRomotionPage().verifyIgniteCurrentBundle(),"Current Bundle details Available","Current Bundle details not Available");
		reporter.reportLogWithScreenshot("Verified Old bundle Details");
		reporter.hardAssert(getRogersHTOPRomotionPage().verifyOfferBundle(),"New Bundle details Available","New Bundle details not Available");
		reporter.reportLogWithScreenshot("Verified New bundle Details");
		String offerPrice = getRogersOrderReviewPage().getIgniteOfferPrice();
		getRogersOrderReviewPage().scrollToOfferPrice();
		getRogersHTOPRomotionPage().clickViewTotalChannels();
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

		reporter.hardAssert(getRogersOrderReviewPage().verifyOneTVBoxHTOText(),"One TV Box copy match", "One TV Box copy match fail");

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
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login , method);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
