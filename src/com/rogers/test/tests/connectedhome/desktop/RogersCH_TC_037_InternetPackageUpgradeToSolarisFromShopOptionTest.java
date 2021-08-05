package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * This class contains the test method to verify the upgarde flow for Legacy Internet to solaris internet for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the internet badge.
 *4. Click on Ignite TV under shop drowndown.
 *5. Select the Bundles package and Click on Add to cart.
 *6. Enter home address to validate the serviceability and click on Check Availability.
 *7. Click on Continue.
 *8. Click on 'Yes I understood'button.
 *9. Click "No thanks Continue".
 *10. Click on Continue.
 *11. Select one option for   'Do you have a 4K TV'.
 *12. Click checkout button on cart summary page.
 *13. All the personal information is auto populated.
 *14. Click on continue button.
 *15. In Credit Evaluation page, enter the required info on Credit Check:
 *16. Click Submit.
 *17. Enter 1 or 2 numbers in Choose a phone Number textbox and click on Generate numbers.
 *18. Select any one phone number. 
 *19. Make sure Caller ID and Directory listing fields are populated.
 *20. Click on Continue.
 *21. Select a time in Choose your Date and Time. 
 *22. Enter any valid Mobile number and email address.
 *23. Click on Confirm.
 *24. Select Pre-Authorized credit card option from type of payment dropdown.
 *25. Enter valid Credit Card number details in Credit Card related fields.
 *26. Click on Continue.
 *27. Validate appropriate information is displayed in Review order page.
 *28. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox.
 *29. Order confirmation page will be displayed with the order number and validate the order details.
 *
 **/

public class RogersCH_TC_037_InternetPackageUpgradeToSolarisFromShopOptionTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","RogersCustomerIgniteBuyCH"})
	public void checkInternetPackageUpgrade() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc37_internetAccountUpgrade.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc37_internetAccountUpgrade.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	    reporter.reportLogWithScreenshot("Skip popup");
	    getRogersLoginPage().clkSkipIFrame();
	    getRogersLoginPage().switchOutOfSignInIFrame();
	    getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc37_internetAccountUpgrade.accountDetails.getBan());
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
	    reporter.reportLogWithScreenshot("Launched the Interent dashboard");
	    getRogersHomePage().clkExistingCustomerShop();
        reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
        //getRogersHomePage().clkIgniteTVExistingCustomer();
		getDriver().get(System.getProperty("QaUrl")+"/web/consumer/ignite-bundles/tv-internet");
    	reporter.hardAssert(getRogersHomePage().verifyIgnitepage(),"Ignite page has Launched","Ignite page has not Launched");
    	reporter.reportLogWithScreenshot("Launched the IgniteTV page");
    	getRogersHomePage().clkServiceability();
    	reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String  strAddressLine1=TestDataHandler.tc37_internetAccountUpgrade.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.tc37_internetAccountUpgrade.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(),"Bundles Page has launched","Bundles Page has not launched");
		getRogersIgniteTVBuyPage().clkHomephone();
		getRogersIgniteTVBuyPage().selectSolarisStarterPackage();
		reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPortInOutPage() ,"Port-InOut page has Launched","Port-InOut page has not Launched");
		reporter.reportLogWithScreenshot("Launched the home phone selection page");
		getRogersHomePhoneSelectionPage().clkSkipforNewNumber();
		reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
		getRogersIgniteTVBuyPage().clkHomePhone();

	        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is availabe","4KTV radio button is not availabe");
	        reporter.reportLogWithScreenshot("Launched the cart summary page");
	        getRogersIgniteTVBuyPage().set4KTV();

	        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTVSelection(),"4KTV Selected","4KTV is not Selected");
	        reporter.reportLogWithScreenshot("4k TV selected");
	        getRogersIgniteTVBuyPage().clkCheckout();
	        reporter.reportLogWithScreenshot("Launched the create profile page");
	        getRogersIgniteTVProfileCreationPage().clkSubmitProfile();

		reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPhoneNumberPage(),"Ignite page has Launched","Ignite page has not Launched");
		reporter.reportLogWithScreenshot("Launched the home phone selection page");
		getRogersHomePhoneSelectionPage().clkPhoneNumberGenerator();
		getRogersHomePhoneSelectionPage().clkContinueHomePhoneSelection();

	        reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
	    	//getRogersTechInstallPage().selSelffinstallDateAndTimeMigrartion();
	        reporter.reportLogWithScreenshot("Launched the tech install page");
	       // getRogersTechInstallPage().clkTechInstallSlot();
	        reporter.reportLogWithScreenshot("tech install details");
	        //getRogersTechInstallPage().setMobielNumber();
	        getRogersTechInstallPage().clkTechInstalConsent();
	        reporter.reportLogWithScreenshot("tech install details");
	        getRogersTechInstallPage().clkTechInstallContinue();
        reporter.reportLogWithScreenshot("Launched the order review page");
    	reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
		reporter.reportLogWithScreenshot("Launched the order review page");
		
		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
        
        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
		String ban = getRogersOrderConfirmationPage().getBAN();
		System.out.println("BAN from the portal : " + ban);
		/**
		 * DB Validations in the subscriber table
		 */

		Map<Object, Object> dblists = getDbConnection().connectionMethod(System.getProperty("DbEnvUrl"))
				.executeDBQuery("select BAN,ACCOUNT_SUB_TYPE,SYS_CREATION_DATE from billing_account where BAN='" + ban + "'", false);

		reporter.softAssert(dblists.get("BAN").equals(ban),"Entry is updated in the billing table","BAN is not present in the billing account table");
		reporter.softAssert(dblists.get("ACCOUNT_SUB_TYPE").equals("R"),"ACCOUNT_SUB_TYPE is verified as R","Account type is not updated as R");
    	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_ignitelogin, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}
}
