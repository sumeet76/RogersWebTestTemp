package com.rogers.test.tests.buyflows;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC05 - Regression - [RHUP] - Hardware Upgrade with PPC with POTG shipping - Till Review Order page
 * @author praveen.kumar7
 */

public class RogersBFA_PROD_Sanity_TC05_HUPWithPPC_StdShip_Test extends BaseTestClass {

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("AWSPRODUrl"), strBrowser,strLanguage,RogersEnums.GroupName.buyflows, method);
	}

	@Test(groups = {"PRODSanity"})
	public void tc05_rogersProdSanity_HUPWithPPC() throws InterruptedException {

		reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
		reporter.reportLogWithScreenshot("Home Page");
		getRogersHomePage().clkSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.BFA_ProdTest_tc05_HUPWithPPC_StdShipping.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.BFA_ProdTest_tc05_HUPWithPPC_StdShipping.getPassword());
		reporter.reportLogWithScreenshot("Login Page");
		getRogersLoginPage().clkSignInIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.BFA_ProdTest_tc05_HUPWithPPC_StdShipping.getBanNo());
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
		reporter.reportLogWithScreenshot("Account Overview Page");

		reporter.hardAssert(getRogersAccountOverviewPage().verifyAndClickShareEverythingCTN(TestDataHandler.BFA_ProdTest_tc05_HUPWithPPC_StdShipping.getCtn()),
				"CTN button is clicked", "CTN button is not clicked");
		reporter.reportLogWithScreenshot("Wireless Dashboard page");
		getRogersWirelessDashboardPage().clkLinkUpgradeMyDevice();

		String deviceName = TestDataHandler.BFA_ProdTest_tc05_HUPWithPPC_StdShipping.getNewDevice();
		reporter.hardAssert(getRogersDeviceCataloguePage().verifyDeviceTileCTAButton(deviceName),
				"phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
		reporter.reportLogWithScreenshot("Device Catalog Page");
		getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
		//getDriver().get("https://www.rogers.com/phones/iphone-12-pro?flowType=aal&colour=graphite&storage=128gb&tierType=upfrontEdge&upfrontEdge=true");

		reporter.reportLogWithScreenshot("Device config page is displayed successfully");
		reporter.hardAssert(getRogersDeviceConfigPage().verifyContinueButton(),
				"Continue button on the device config page is present", "Continue button on the device config page is not present");
		reporter.reportLogPassWithScreenshot("Device config page displayed");
		getRogersDeviceConfigPage().clickContinueButton();
		//-------------------------------------Plan config page---------------------------------------------
		getRogersCheckoutPage().clkNoThanks();
		getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
		reporter.reportLogPassWithScreenshot("Device cost option selected");
		getRogersPlanConfigPage().clickShowMoreDetails();
		getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.BFA_ProdTest_tc05_HUPWithPPC_StdShipping.getDataOptionIndex()),this.getClass().getSimpleName());
		reporter.reportLogPassWithScreenshot("Data option selected");
		getRogersCheckoutPage().clkNoThanks();
		getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
		getRogersCheckoutPage().clkNoThanks();
		getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
		reporter.reportLogPassWithScreenshot("Addons option selected");
		getRogersPlanConfigPage().clkContinueDeviceProtection();
		getRogersPlanConfigPage().clickCartSummaryContinueButton();

		getRogersCheckoutPage().clkNoThanks();
		getRogersCheckoutPage().clkDeliveryMethod("STANDARD");
		reporter.reportLogPassWithScreenshot("Standard Delivery selected");
		getRogersCheckoutPage().clkContinueBtnShipping();
		reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
		getRogersCheckoutPage().clkNoThanks();
		getRogersCheckoutPage().clksubmitBtnCheckoutPage();
		reporter.reportLogPassWithScreenshot("Clicked submit button below cart summary");
		getRogersPlanConfigPage().clickGetBPOOffer();
		getRogersCheckoutPage().clkNoThanks();
		getRogersPlanConfigPage().clkContinueOnExistingAddonModal();
		
		reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
				"Order Review Page Title is not Present");

	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
}
