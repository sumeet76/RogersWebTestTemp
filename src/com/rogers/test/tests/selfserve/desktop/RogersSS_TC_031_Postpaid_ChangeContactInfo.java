package com.rogers.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;


import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

import utils.FormFiller;


public class RogersSS_TC_031_Postpaid_ChangeContactInfo extends BaseTestClass {

	private String strAltEmail;

	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
	 
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test(groups = {"SanitySS","ProfileAndSettingsSS"})
	public void validateUserChangeContactInformation() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc013132.getUsername();
    	String strPassword = TestDataHandler.tc013132.getPassword();
    	String strBan = TestDataHandler.tc013132.getAccountDetails().getBan();
    	String strEmail = TestDataHandler.tc013132.getAccountDetails().getContactemail();
    	strAltEmail = FormFiller.generateEmail();
		//getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(strUsername);
		getRogersLoginPage().setPasswordIFrame(strPassword);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();
        
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select BAN.");
            getRogersAccountOverviewPage().selectAccount(strBan);
        }
		reporter.reportLogWithScreenshot("Account overveiew page");
    	getRogersAccountOverviewPage().clkLnkProfileNSettings();
		reporter.reportLogWithScreenshot("Profile & Settings page");
    	getRogersProfileAndSettingsPage().clkBtnContactInfomation();
    	
    	//Add Contact email, can't be the same as user name!!!
    	String strNewEmail="";
    	if(getRogersProfileAndSettingsPage().getContactEmail().contains(strEmail))
    	{
    		getRogersProfileAndSettingsPage().clkLnkAddContactEmail();
        	getRogersProfileAndSettingsPage().setContactEmail(strAltEmail);
        	strNewEmail=strAltEmail;
     
    	}else
    	{
    		getRogersProfileAndSettingsPage().clkLnkAddContactEmail();
        	getRogersProfileAndSettingsPage().setContactEmail(strEmail);
        	strNewEmail=strEmail;
    	}
    	reporter.reportLogWithScreenshot("Contact email information is entered.");
    	getRogersProfileAndSettingsPage().clkBtnContinue();
    	getRogersProfileAndSettingsPage().clkBtnAddContactEmailSubmit();
		reporter.reportLogWithScreenshot("Contact email information submitted.");
	    reporter.hardAssert((getRogersProfileAndSettingsPage().clkBtnAddContactEmailFinish()
	    		&& getRogersProfileAndSettingsPage().verifyContactEmailSuccessfullySet(strNewEmail)),
				"Contact email was successfully add", 
				"Add contact email failed");	    
    	    	    
    	//Update home number, can't be the same as what it already has!!!
    	getRogersProfileAndSettingsPage().clkLnkUpdateHomeNumber();
    	String strHomePhoneNumer = FormFiller.generateRandomNumber(10);
    	getRogersProfileAndSettingsPage().setHomePhone(strHomePhoneNumer);
    	reporter.reportLogWithScreenshot("Home phone number is entered.");
    	getRogersProfileAndSettingsPage().clkBtnUpdateHomeNumberContinue();
    	getRogersProfileAndSettingsPage().clkBtnUpdateHomeNumberSubmit();
		reporter.reportLogWithScreenshot("Home phone number inflormation submitted.");
    	reporter.hardAssert((getRogersProfileAndSettingsPage().clkBtnUpdateHomeNumberFinish()
    			&& getRogersProfileAndSettingsPage().verifyHomeNumber(strHomePhoneNumer.substring(strHomePhoneNumer.length()-4))),
    			"Home phone number was successfully updated",
    			"Update home phone number failed");    	
    	
    	//Add business number, can't be the same as what it already has!!!
    	getRogersProfileAndSettingsPage().clkLnkAddBusinessNumber();
    	String strBusinessNumer = FormFiller.generateRandomNumber(10);
    	getRogersProfileAndSettingsPage().setBusinessPhone(strBusinessNumer);
    	reporter.reportLogWithScreenshot("Business number is entered.");
    	getRogersProfileAndSettingsPage().clkBtnAddBusinessNumberContinue();
    	getRogersProfileAndSettingsPage().clkBtnAddBusinessNumberSubmit();
		reporter.reportLogWithScreenshot("Business phone number inflormation submitted.");
    	reporter.hardAssert((getRogersProfileAndSettingsPage().clkBtnAddBusinessNumberDone()
    			&& getRogersProfileAndSettingsPage().verifyBusinessNumber(strBusinessNumer.substring(strBusinessNumer.length()-4))),
				"Business phone number was successfully Added", 
				"Add business phone number failed");
    	
    	//Change contact language, have to change language!!!
    	String newLanguage="";
    	String existingLanguage = getRogersProfileAndSettingsPage().getExistingLanguage();
    	if(existingLanguage.contains("English")
    	||existingLanguage.contains("Anglais"))
    	{
    		newLanguage = existingLanguage.contains("English") ? "French": "Français";
    		
    		getRogersProfileAndSettingsPage().clkLnkChangeContactLanguage();
    		getRogersProfileAndSettingsPage().clkLanguage(newLanguage);
    	}else
    	{
    		newLanguage = existingLanguage.contains("French") ? "English": "Anglais";
    		getRogersProfileAndSettingsPage().clkLnkChangeContactLanguage();
    		getRogersProfileAndSettingsPage().clkLanguage(newLanguage);
    	}    	    	
    	getRogersProfileAndSettingsPage().clkBtnChangelanguageSubmit();
		reporter.reportLogWithScreenshot("Change contact language inflormation submitted.");
    	reporter.hardAssert((getRogersProfileAndSettingsPage().clkBtnChangeLanguageDone()
    			&& getRogersProfileAndSettingsPage().verifyLanguageSetSuccessfully(newLanguage)),
				"Change language was done successfully", 
				"Change language did not happen successfully");
    	
	}

}
