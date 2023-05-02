package com.rogers.test.tests.connectedhome.desktop.legacy;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to test the IgniteTV buy flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 * Browse Rogers.com in QA
 * Click on Shop-> TV Bundles
 * Click on See available Ignite Bundles
 * Enter Address_2 in serviceability modal and click on check address
 * Select any Bundle and add to cart
 * Click on No I don’t have Ignite TV and Click on Checkout
 * In the Profile page Enter the details as per the RCIS rule sheet for Medium risk class with Different address (Row 74-77) to simulate Medium Risk class scenario.Email ID and Contact number should be used different as the one with which we created the account in RCIS for address_1 to simulate failed verification. Billing address should be same as serviceable address. Click on Proceed once we fill all the details
 * In Credit evaluation page enter the same details which were used for creating Address_1 account in RCIS, also follow the RCIS rule sheet same as above to have the correct details respective to that to simulate Medium Risk Class and Click on Continue
 * Clicking on Cancel and X button should take you back to credit Eval page
 * As the Address retry is set to 2 , in the first retry enter any other address except Address_1 of the account which we created in RCIS and click on Proceed in the new modal
 * In the 2nd retry enter the same address of the account which we created in RCIS i.e Address_1 and click on Proceed
 * Select the required details in Fulfillment page to complete the E2E flow
 *
 **/

public class RogersCH_Auto_TC028_LegacyCx_CRMaddressMismatchWithSGI_ValidateServiceabilityCheck_No4kTVTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","RogersCustomerIgniteBuyCH"})
    public void rogersCH_Auto_TC028_LegacyCx_CRMaddressMismatchWithSGI_ValidateServiceabilityCheck_No4kTV() {
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc28_CRMaddressMismatchWithSGI.getUsername());
		getRogersLoginPage().clkContinueInBrowser();
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc28_CRMaddressMismatchWithSGI.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentials");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc28_CRMaddressMismatchWithSGI.accountDetails.getBan());
		reporter.reportLogWithScreenshot("Launched the Account Page");
		getDriver().get(System.getProperty("QaUrl")+"/bundles");
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		getRogersHomePage().clkNoThnx();
		getRogersHomePage().clkServiceability();
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		getRogersHomePage().selectAddressOnFile();
		getRogersHomePage().clkUseAddress();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		//getRogersIgniteTVBuyPage().selectFlex20PackageMonthToMonthTypeOfContract();
		//reporter.reportLogWithScreenshot("Selected Month-to-month type of contract");
		getRogersIgniteTVBuyPage().selectFlex20Package();
		reporter.reportLogWithScreenshot("Added to cart");

		getRogersIgniteTVBuyPage().clkIUnderstand();
		reporter.reportLogWithScreenshot("Clicked on Yes, I understand");

		reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(), "4KTV radio button is available", "4KTV radio button is not available");
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		getRogersIgniteTVBuyPage().set4KTVNo();
		reporter.reportLogWithScreenshot("4k TV selected");
		getRogersIgniteTVBuyPage().clkCheckout();

		reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(), "Profile page has Launched", "Profile page has not Launched");
		getRogersIgniteTVProfileCreationPage().clkSubmitProfile();

		reporter.hardAssert(getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage(), "Credit Evaluation page has Launched", "Credit Evaluation page has not Launched");
		reporter.reportLogWithScreenshot("Launched the credit evaluation page");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_legacylogin, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


