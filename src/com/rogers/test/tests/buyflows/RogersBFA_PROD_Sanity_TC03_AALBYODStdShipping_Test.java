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
 * TC03 - PROD SANITY - [RAAL BYOD] - Add a line with with BYOD option along with standard shipping-Till Review order page
 * @author praveen.kumar7
 */

public class RogersBFA_PROD_Sanity_TC03_AALBYODStdShipping_Test extends BaseTestClass {

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("AWSPRODUrl"), strBrowser,strLanguage,RogersEnums.GroupName.buyflows, method);
	}

	@Test(groups = {"PRODSanity","PRODAALSanity"})
	public void rogersProdSanity_AAL_BYOD() throws InterruptedException {

		reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
		reporter.reportLogWithScreenshot("Home Page");
		getRogersHomePage().clkSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.BFA_ProdTest_tc03_AALBYOD_StdShipping.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.BFA_ProdTest_tc03_AALBYOD_StdShipping.getPassword());
		reporter.reportLogWithScreenshot("Login Page");
		getRogersLoginPage().clkSignInIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.BFA_ProdTest_tc03_AALBYOD_StdShipping.getBan());
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
		reporter.reportLogWithScreenshot("Account Overview Page");

		reporter.hardAssert(getRogersAccountOverviewPage().isAddALinkDisplayedBelowCTNs(),
				"Add a line link is displayed", "Add a line link is not displayed");
		getRogersAccountOverviewPage().clkAddALink();

		reporter.hardAssert(getRogersDeviceCataloguePage().verifySharedNonSharedModalPresent(),
				"Shared/Nonshared modal displayed", "Shared/Nonshared modal not displayed");
		reporter.reportLogWithScreenshot("Shared/Nonshared modal popup");
		String aalSharingType = TestDataHandler.BFA_ProdTest_tc03_AALBYOD_StdShipping.getSharingType();
		getRogersDeviceCataloguePage().selectAALSharingType(aalSharingType);
		reporter.reportLogPassWithScreenshot(aalSharingType+ " option selected successfully");
		getRogersDeviceCataloguePage().clickContinueButtonOnModal();

		reporter.hardAssert(getRogersDeviceCataloguePage().verifyByodDeviceTile(), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
		reporter.reportLogWithScreenshot("Device Catalog Page");
		getRogersCheckoutPage().clkNoThanks();
		getRogersDeviceCataloguePage().clkByodDeviceTileContinueBtn();
		//-------------------------------------Plan config page---------------------------------------------
		getRogersCheckoutPage().clkNoThanks();
		reporter.hardAssert(getRogersPlanConfigPage().verifyPlanConfigPage(), "Plan config page is loaded", "Plan config page is not loaded");
		getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
		reporter.reportLogPassWithScreenshot("Data option selected");
		getRogersCheckoutPage().clkNoThanks();
		reporter.hardAssert(getRogersPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.BFA_ProdTest_tc03_AALBYOD_StdShipping.getTalkOptionIndex())),
				"Talk option selected and Addons page in expanded state","Addons page not in expanded state");
		getRogersCheckoutPage().clkNoThanks();
		getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
		reporter.reportLogPassWithScreenshot("Clicked on continue button in addons stepper");
		getRogersPlanConfigPage().clkContinueDeviceProtection();
		getRogersPlanConfigPage().setUserNameCallerID();
		reporter.reportLogWithScreenshot("CalledID details entered");
		getRogersPlanConfigPage().clickCartSummaryContinueButton();

		reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
		getRogersCheckoutPage().clkNoThanks();
		getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.BFA_ProdTest_tc03_AALBYOD_StdShipping.getCtnCity());
		reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
		getRogersCheckoutPage().clkNoThanks();
		getRogersCheckoutPage().clkChosePhoneNumber();
		reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
		getRogersCheckoutPage().clkChooseNumberbutton();
		getRogersCheckoutPage().clkNoThanks();
		reporter.hardAssert(getRogersCheckoutPage().isChooseaNumberLabelDisplayed(), "Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
		reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");

		getRogersCheckoutPage().clkDeliveryMethod("STANDARD");
		reporter.reportLogPassWithScreenshot("Standard Delivery selected");
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
