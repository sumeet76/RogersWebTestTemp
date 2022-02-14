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
 * TC04 - PROD SANITY - [AAL TERM] - Add a line by choosing tablet device - Till Review order page
 * @author praveen.kumar7
 */

public class RogersBFA_PROD_Sanity_TC04_AALTerm_Tablet_StdShipping_Test extends BaseTestClass {

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("AWSPRODUrl"), strBrowser,strLanguage,RogersEnums.GroupName.buyflows, method);
	}

	@Test(groups = {"PRODSanity","PRODAALSanity"})
	public void rogersProdSanity_AAL_TERM_Tablet() throws InterruptedException {

		reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
		reporter.reportLogWithScreenshot("Home Page");
		getRogersHomePage().clkSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.BFA_ProdTest_tc04_AALTERM_Tablet_StdShipping.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.BFA_ProdTest_tc04_AALTERM_Tablet_StdShipping.getPassword());
		reporter.reportLogWithScreenshot("Login Page");
		getRogersLoginPage().clkSignInIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.BFA_ProdTest_tc04_AALTERM_Tablet_StdShipping.getBan());
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
		reporter.reportLogWithScreenshot("Account Overview Page");

		//getDriver().get(System.getProperty("AWSPRODUrl")+"/phones?flowType=aal");
		reporter.hardAssert(getRogersAccountOverviewPage().isAddALinkDisplayedBelowCTNs(),
				"Add a line link is displayed", "Add a line link is not displayed");
		getRogersAccountOverviewPage().clkAddALink();

		reporter.hardAssert(getRogersDeviceCataloguePage().verifySharedNonSharedModalPresent(),
				"Shared/Nonshared modal displayed", "Shared/Nonshared modal not displayed");
		reporter.reportLogWithScreenshot("Shared/Nonshared modal popup");
		String aalSharingType = TestDataHandler.BFA_ProdTest_tc04_AALTERM_Tablet_StdShipping.getSharingType();
		getRogersDeviceCataloguePage().selectAALSharingType(aalSharingType);
		reporter.reportLogPassWithScreenshot(aalSharingType+ " option selected successfully");
		getRogersDeviceCataloguePage().clickContinueButtonOnModal();

		String deviceName = TestDataHandler.BFA_ProdTest_tc04_AALTERM_Tablet_StdShipping.getNewDevice();
		reporter.hardAssert(getRogersDeviceCataloguePage().verifyDeviceTileCTAButton(deviceName),
				"phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
		reporter.reportLogWithScreenshot("Device Catalog Page");
		getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
		//getDriver().get("https://www.rogers.com/phones/iphone-12-pro?flowType=aal&colour=graphite&storage=128gb&tierType=upfrontEdge&upfrontEdge=true");

		reporter.hardAssert(getRogersDeviceConfigPage().verifyContinueButton(),
				"Continue button on the device config page is present", "Continue button on the device config page is not present");
		reporter.reportLogPassWithScreenshot("Device config page displayed");
		getRogersDeviceConfigPage().clickContinueButton();
		//-------------------------------------Plan config page---------------------------------------------
		getRogersCheckoutPage().clkNoThanks();
		reporter.hardAssert(getRogersPlanConfigPage().verifyPlanConfigPage(), "Plan config page is loaded", "Plan config page is not loaded");
		getRogersPlanConfigPage().selectDeviceCostAndClickOnContinueButton(getRogersPlanConfigPage().getUpdatedDeviceCostIndex(TestDataHandler.BFA_ProdTest_tc04_AALTERM_Tablet_StdShipping.getDeviceCostIndex()));
		reporter.reportLogPassWithScreenshot("Device cost option selected");
		getRogersCheckoutPage().clkNoThanks();
		getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
		reporter.reportLogPassWithScreenshot("Clicked on continue button in addons stepper");
		getRogersPlanConfigPage().clkContinueDeviceProtection();
		reporter.reportLogWithScreenshot("Caller ID Stepper");
		getRogersPlanConfigPage().clkCallerIDContinueBtnForTablet();
		reporter.reportLogWithScreenshot("Clicked on continue button in CalledID stepper");
		getRogersPlanConfigPage().clickCartSummaryContinueButton();

		reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
		getRogersCheckoutPage().clkNoThanks();
		getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.BFA_ProdTest_tc04_AALTERM_Tablet_StdShipping.getCtnCity());
		reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
		getRogersCheckoutPage().clkNoThanks();
		getRogersCheckoutPage().clkChosePhoneNumber();
		reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
		reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed", "Find More Available Number Button not disaplayed");
		getRogersCheckoutPage().clkChooseNumberbutton();
		getRogersCheckoutPage().clkNoThanks();
		reporter.hardAssert(getRogersCheckoutPage().isChooseaNumberLabelDisplayed(), "Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
		reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");

		getRogersCheckoutPage().clkNoThanks();
		getRogersCheckoutPage().clkDeliveryMethod("Express");
		reporter.reportLogPassWithScreenshot("Bopis Delivery selected");
		getRogersCheckoutPage().setEmailShippingPage();
		reporter.hardAssert(getRogersCheckoutPage().verifyExpressLocationMapPresent(), "Express pickup location map is present",
				"Express pickup location map is not available");
		getRogersCheckoutPage().clkContinueBtnShipping();
		reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
		getRogersCheckoutPage().clkNoThanks();
		getRogersCheckoutPage().clksubmitBtnCheckoutPage();
		reporter.reportLogPassWithScreenshot("Clicked submit button below cart summary");

		reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
				"Order Review Page Title is not Present");
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
}
