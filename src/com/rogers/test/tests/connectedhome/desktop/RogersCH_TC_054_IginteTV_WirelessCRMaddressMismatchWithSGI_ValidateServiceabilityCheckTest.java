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
 * Click on No I don’t have a Ignite TV and Click on Checkout
 * In the Profile page Enter the details as per the RCIS rule sheet for Medium risk class with Different address (Row 74-77) to simulate Medium Risk class scenario.Email ID and Contact number should be used different as the one with which we created the account in RCIS for address_1 to simulate failed verification. Billing address should be same as serviceable address. Click on Proceed once we fill all the details
 * In Credit evaluation page enter the same details which were used for creating Address_1 account in RCIS, also follow the RCIS rule sheet same as above to have the correct details respective to that to simulate Medium Risk Class and Click on Continue
 * Clicking on Cancel and X button should take you back to credit Eval page
 * As the Address retry is set to 2 , in the first retry enter any other address except Address_1 of the account which we created in RCIS and click on Proceed in the new modal
 * In the 2nd retry enter the same address of the account which we created in RCIS i.e Address_1 and click on Proceed
 * Select the required details in Fulfillment page to complete the E2E flow
 *
 **/

public class RogersCH_TC_054_IginteTV_WirelessCRMaddressMismatchWithSGI_ValidateServiceabilityCheckTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","New"})
    public void checkCRMaddressMismatchWithSGI_ServiceabilityTest() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc54_iginteTVWirelessCRMaddressMismatchWithSGI.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc54_iginteTVWirelessCRMaddressMismatchWithSGI.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		reporter.reportLogWithScreenshot("Skip popup");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc54_iginteTVWirelessCRMaddressMismatchWithSGI.accountDetails.getBan());
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersHomePage().clkExistingCustomerShop();
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
		getRogersHomePage().clkIgniteTVExistingCustomer();
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		getRogersHomePage().clkNoThnx();
		getRogersHomePage().clkServiceability();
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		getRogersHomePage().clkUseThisAddress();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		//reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(),"Bundles Page has launched","Bundles Page has not launched");
		getRogersIgniteTVBuyPage().clkHomephone();
		getRogersIgniteTVBuyPage().selectSolarisStarterPackageNew();
		reporter.reportLogWithScreenshot("Launched the information popup");
		getRogersIgniteTVBuyPage().clkIUnderstand();
		reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPortInOutPage() ,"Port-InOut page has Launched","Port-InOut page has not Launched");
		reporter.reportLogWithScreenshot("Launched the home phone selection page");
		getRogersHomePhoneSelectionPage().clkSkipforNewNumber();
		reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
		getRogersIgniteTVBuyPage().clkHomePhone();

		reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is available","4KTV radio button is not available");
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		getRogersIgniteTVBuyPage().set4KTV();
		reporter.reportLogWithScreenshot("4k TV selected");
		getRogersIgniteTVBuyPage().clkCheckout();
		reporter.reportLogWithScreenshot("Launched the create profile page");
		getRogersIgniteTVProfileCreationPage().clkSubmitProfile();
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		getRogersIgniteTVCreditCheckPage().selectDOBYearExistingCustomerMigration(TestDataHandler.tc54_iginteTVWirelessCRMaddressMismatchWithSGI.getAccountDetails().getYear());
		getRogersIgniteTVCreditCheckPage().selectDOBMonthExistingCustomerMigration(TestDataHandler.tc54_iginteTVWirelessCRMaddressMismatchWithSGI.getAccountDetails().getMonth());
		getRogersIgniteTVCreditCheckPage().selectDOBDayExistingCustomerMigration(TestDataHandler.tc54_iginteTVWirelessCRMaddressMismatchWithSGI.getAccountDetails().getDate());
		reporter.reportLogWithScreenshot("Entered the DOB details");
		getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();
		reporter.reportLogWithScreenshot("Launched the home phone selection page");
		getRogersHomePhoneSelectionPage().clkContinueHomePhoneSelection();

		reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
		reporter.reportLogWithScreenshot("Launched the tech install page");
		getRogersTechInstallPage().selTechInstalStartDate();
		reporter.reportLogWithScreenshot("Selected Start date for Installation");
		getRogersTechInstallPage().selectPreferredTimeSlot("1: AFT");
		reporter.reportLogWithScreenshot("Selected Start date for Installation slot");
		getRogersTechInstallPage().selTechInstalEndDate();
		reporter.reportLogWithScreenshot("Selected End date for Installation");
		getRogersTechInstallPage().selectBackupTimeSlot("1: AFT");
		reporter.reportLogWithScreenshot("Selected End date for Installation slot");
		reporter.reportLogWithScreenshot("tech install details");
		getRogersTechInstallPage().setMobielNumber();
		reporter.reportLogWithScreenshot("tech install details");
		getRogersTechInstallPage().clkTechInstalConsent();

		getRogersTechInstallPage().clkTechInstallContinue();
		reporter.reportLogWithScreenshot("Launched the payment options page");

		getRogersPaymentOptionsPage().clkPaymentConfirm();
		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
		reporter.reportLogWithScreenshot("Launched the order review page");

		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");

		getRogersOrderReviewPage().clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		getRogersOrderReviewPage().clkSubmit();
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_ignitelogin, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


