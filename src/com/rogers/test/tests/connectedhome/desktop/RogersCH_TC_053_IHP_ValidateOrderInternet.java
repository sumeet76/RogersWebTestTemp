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
 * This class contains the test method to validate the Solaris home phone dashboard for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 * Launch Rogers.com in QA env
 * Sign-in with valid credential( RHP 1.5 account)
 * click on shop and select Internet from the drop down
 * click on check availability
 * Validate change package message is removed in the modal
 * Validate use this address button
 * Click on use this address and validate another modal advice user to call or live chat
 *
 **/


public class RogersCH_TC_053_IHP_ValidateOrderInternet extends BaseTestClass {

	@Test(groups = {"RegressionCH","IHP","saiCH"})
    public void checkSolarisIhpValidateOrderInternet() {
		String  strAddressLine1=TestDataHandler.tc53_iHPAccount.getAccountDetails().getAddress().get("line1");
		String  strAddressLine2=TestDataHandler.tc53_iHPAccount.getAccountDetails().getAddress().get("line2");
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc53_iHPAccount.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc53_iHPAccount.getPassword());
 		reporter.reportLogWithScreenshot("Enter the account credentails");
 		getRogersLoginPage().clkSignInIFrame();
 		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
 	    reporter.reportLogWithScreenshot("Skip popup");
 	    getRogersLoginPage().clkSkipIFrame();
 	    getRogersLoginPage().switchOutOfSignInIFrame();
 		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
 	    getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc53_iHPAccount.accountDetails.getBan());
 		reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersHomePage().clkExistingCustomerShop();
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
        getRogersHomePage().clkSmartInternet();
		reporter.hardAssert(getRogersHomePage().verifyInternetpage(),"Internet page has Launched","Internet page has not Launched");
		reporter.reportLogWithScreenshot("Launched the Internet packages page");
		getRogersHomePage().clkInternetAvailability();
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
		getRogersHomePage().clkIgniteAddressLookupSubmit();
		reporter.reportLogWithScreenshot("Launched the Internet-bundles page");
		getRogersInternetPackageSelectionPage().clkInternetPackage();
		reporter.reportLogWithScreenshot("Launched the Internet-bundles page");
		getRogersInternetPackageSelectionPage().clkInternetBuyContinue();
		//reporter.hardAssert(getRogersInternetProfilePage().verifyProfilePageSAI(),"Profile page has Launched","Profile page has not Launched");
    	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


