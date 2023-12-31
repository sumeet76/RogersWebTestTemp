package com.rogers.test.tests.connectedhome.desktop.legacy;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to verify the upgarde flow for Legacy TV to IgniteTV for Rogers.com  
 * 
 * @author Manpreet.Kaur3
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the TV badge
 *4. Click on Ignite TV under shop drowndown
 *5. Click on View Bundles and Select the Bundles package
 *6. Select address on file and click on Check Availability
 *7. Add to Cart the Bundles package and Click on Continue.
 *8. Click on 'Yes I understood'button.
 *9. Click "No thanks Continue".
 *10. Click on Continue.
 *11. Select one option(No) for  'Do you have a 4K TV'.
 *12. Click checkout button on cart summary page.
 *13. All the personal information is auto populated.
 *14. Click on continue button.
 *15. In Credit Evaluation page, enter the required info on Credit Check:
 *16. Click Submit.
 *17. Select Preferred data and time on Tech install page and click Continue.
 *18. Click confirm on Payment options Page.
 *19. Validate appropriate information is displayed in Review order page.
 *20. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox.
 *21. Order confirmation page will be displayed with the order number and validate the order details.
 *
 **/

public class RogersCH_Auto_TC089_1P_DTV_2P_Migration_GPONonlyTopology_Cartsummary_No4K_ProInstallTest extends BaseTestClass {

    @Test(groups = {"RegressionCH"})
	public void rogersCH_Auto_TC089_1P_DTV_2P_Migration_GPONonlyTopology_Cartsummary_No4K_ProInstall() {
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc89_2PMigrationGPON.getUsername());
		getRogersLoginPage().clkContinueInBrowser();
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc89_2PMigrationGPON.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentials");
		getRogersLoginPage().clkSignInIFrame();
		getEnsVerifications().setVerificationCodeCH(TestDataHandler.tc89_2PMigrationGPON.getUsername());
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");

		if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
			reporter.reportLogWithScreenshot("Launched the Account Page");
			getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc89_2PMigrationGPON.accountDetails.getBan());
			reporter.reportLogWithScreenshot("Account Selected");
		}


		getDriver().get(System.getProperty("QaUrl")+"/bundles");
		reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(),"Bundles Page has launched","Bundles Page has not launched");
		getRogersHomePage().clkServiceability();
		//getRogersIgniteTVBuyPage().selectFlex20Package();
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		getRogersHomePage().selectAddressOnFile();
		getRogersHomePage().clkUseAddress();
		reporter.reportLogWithScreenshot("Selected the address on file");

		reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(), "Bundles Page has launched", "Bundles Page has not launched");
		//getRogersIgniteTVBuyPage().selectStarterPackageMonthToMonthTypeOfContract();
		getRogersIgniteTVBuyPage().selectSolarisStarterPackage();
		reporter.reportLogWithScreenshot("Launched the information popup");
		getRogersIgniteTVBuyPage().clkIUnderstand();

        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is available","4KTV radio button is not available");
        reporter.reportLogWithScreenshot("Launched the cart summary page");
		getRogersIgniteTVBuyPage().set4KTVNo();
        reporter.reportLogWithScreenshot("No 4k TV selected");
        getRogersIgniteTVBuyPage().clkCheckout();
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersIgniteTVProfileCreationPage().clkSubmitProfile();

        reporter.reportLogWithScreenshot("Launched the credit evaluation page");
        getRogersIgniteTVCreditCheckPage().selectDOBYearExistingCustomer(TestDataHandler.tc82_Legacy2PtoIgnite2PMigration.getAccountDetails().getYear());
        getRogersIgniteTVCreditCheckPage().selectDOBMonthExistingCustomerMigration(TestDataHandler.tc82_Legacy2PtoIgnite2PMigration.getAccountDetails().getMonth());
        getRogersIgniteTVCreditCheckPage().selectDOBDayExistingCustomerMigration(TestDataHandler.tc82_Legacy2PtoIgnite2PMigration.getAccountDetails().getDate());
        reporter.reportLogWithScreenshot("Entered the DOB details");
		getRogersIgniteTVCreditCheckPage().selectFirstID("Driver's License");
		getRogersIgniteTVCreditCheckPage().selectProvince("Ontario");
		getRogersIgniteTVCreditCheckPage().selectExpiryYear();
		getRogersIgniteTVCreditCheckPage().selectExpiryMonth();
		getRogersIgniteTVCreditCheckPage().selectExpiryDay();
		getRogersIgniteTVCreditCheckPage().setDrivingLicenseNumber("ONTARIO");
		reporter.reportLogWithScreenshot("Driving License Details");
		getRogersIgniteTVCreditCheckPage().selectSecondIDOption("Passport");
		getRogersIgniteTVCreditCheckPage().setPassportNumber();
		getRogersIgniteTVCreditCheckPage().selectPassportExpiryYear();
		getRogersIgniteTVCreditCheckPage().selectPassportExpiryMonth();
		getRogersIgniteTVCreditCheckPage().selectPassportExpiryDay();
		getRogersIgniteTVCreditCheckPage().clkCreditConsent();
		reporter.reportLogWithScreenshot("Passport Details");
		getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();
		//Validate flowType="AUTL" from continueBuy call, will be adding with selenium4

		reporter.reportLogWithScreenshot("Launched the Schedule Appointment Page");
		getRogersTechInstallPage().selectPrefferedDate();
		getRogersTechInstallPage().selectPreferredTimeSlot();
		getRogersTechInstallPage().setContactNumber();
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
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws  IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_legacylogin, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}