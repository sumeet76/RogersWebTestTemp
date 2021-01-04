package com.rogers.test.tests.selfserve.mobile;

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


public class Mobile_RogersSS_TC_031_Postpaid_ChangeContactInfo extends BaseTestClass {

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
	
	@Test(groups = {"MobileSanitySS"})
	public void validateUserChangeContactInformation() {		
		getRogersHomePage().clkSignInMobile();
    	String strUsername = TestDataHandler.tc013132.getUsername();
    	String strPassword = TestDataHandler.tc013132.getPassword();
    	String strBan = TestDataHandler.tc013132.getAccountDetails().getBan();
    	String strEmail = TestDataHandler.tc013132.getAccountDetails().getContactemail();
    	strAltEmail = FormFiller.generateEmail();
		getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(strUsername);
		getRogersLoginPage().setPasswordIFrame(strPassword);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
        
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select BAN.");
            getRogersAccountOverviewPage().selectAccount(strBan);
        }
		reporter.reportLogWithScreenshot("Account overveiew page");    	
		getRogersAccountOverviewPage().clkLnkProfileNSettingsMobile();
		reporter.reportLogWithScreenshot("Profile & Settings page");
		common_business_flows.scrollToMiddleOfWebPage();
		getRogersProfileAndSettingsPage().clkCloseFeedbackIfAvailableMobile();
    	getRogersProfileAndSettingsPage().clkBtnContactInfomation();
    	
    	//Add Contact email, can't be the same as user name!!!
		getRogersProfileAndSettingsPage().clkBtnChangeEmailMobile();
		//getRogersProfileAndSettingsPage().clkBtnAddEmailMobile();
    	String strNewEmail="";
    	if(getRogersProfileAndSettingsPage().getContactEmailMobile().toLowerCase().contains(strEmail.toLowerCase()))
    	{
        	getRogersProfileAndSettingsPage().setContactEmailMobile(strAltEmail);
        	strNewEmail=strAltEmail;
     
    	}else
    	{
        	getRogersProfileAndSettingsPage().setContactEmailMobile(strEmail);
        	strNewEmail=strEmail;
    	}
    	reporter.reportLogWithScreenshot("Contact email information is entered.");
    	getRogersProfileAndSettingsPage().clkBtnContinue();
    	getRogersProfileAndSettingsPage().clkBtnAddContactEmailSubmit();
		reporter.reportLogWithScreenshot("Contact email information submitted.");
	    reporter.softAssert((getRogersProfileAndSettingsPage().clkBtnAddContactEmailFinish()
	    		&& getRogersProfileAndSettingsPage().verifyContactEmailSuccessfullySet(strNewEmail)),
				"Contact email was successfully add", 
				"Add contact email failed");	    
    	    	    
    	//Update home number, can't be the same as what it already has!!!
    	getRogersProfileAndSettingsPage().clkLnkUpdateHomeNumberMobile();
    	String strHomePhoneNumer = FormFiller.generateRandomNumber(10);
    	getRogersProfileAndSettingsPage().setHomePhoneMobile(strHomePhoneNumer);
    	reporter.reportLogWithScreenshot("Home phone number is entered.");
    	getRogersProfileAndSettingsPage().clkBtnUpdateHomeNumberContinue();
    	getRogersProfileAndSettingsPage().clkBtnUpdateHomeNumberSubmit();
		reporter.reportLogWithScreenshot("Home phone number inflormation submitted.");
    	reporter.softAssert((getRogersProfileAndSettingsPage().clkBtnUpdateHomeNumberFinish()
    			&& getRogersProfileAndSettingsPage().verifyHomeNumber(strHomePhoneNumer.substring(strHomePhoneNumer.length()-4))),
    			"Home phone number was successfully updated",
    			"Update home phone number failed");    	
    	
    	//Add business number, can't be the same as what it already has!!!
    	getRogersProfileAndSettingsPage().clkLnkAddBusinessNumberMobile();
    	String strBusinessNumer = FormFiller.generateRandomNumber(10);
    	getRogersProfileAndSettingsPage().setBusinessPhoneMobile(strBusinessNumer);
    	reporter.reportLogWithScreenshot("Business number is entered.");
    	getRogersProfileAndSettingsPage().clkBtnAddBusinessNumberContinue();
    	getRogersProfileAndSettingsPage().clkBtnAddBusinessNumberSubmit();
		reporter.reportLogWithScreenshot("Business phone number inflormation submitted.");
    	reporter.softAssert((getRogersProfileAndSettingsPage().clkBtnAddBusinessNumberDone()
    			&& getRogersProfileAndSettingsPage().verifyBusinessNumber(strBusinessNumer.substring(strBusinessNumer.length()-4))),
				"Business phone number was successfully Added", 
				"Add business phone number failed");
    	
    	//Change contact language, have to change language!!!
    	String newLanguage="";
    	String existingLanguage = getRogersProfileAndSettingsPage().getExistingLanguageMobile();
    	if(existingLanguage.contains("English")
    	||existingLanguage.contains("Anglais"))
    	{
    		newLanguage = existingLanguage.contains("English") ? "French": "Français";
    		
    		getRogersProfileAndSettingsPage().clkLnkChangeContactLanguageMobile();
    		getRogersProfileAndSettingsPage().clkLanguage(newLanguage);
    	}else
    	{
    		newLanguage = existingLanguage.contains("French") ? "English": "Anglais";
    		getRogersProfileAndSettingsPage().clkLnkChangeContactLanguageMobile();
    		getRogersProfileAndSettingsPage().clkLanguage(newLanguage);
    	}    	    	
    	getRogersProfileAndSettingsPage().clkBtnChangelanguageSubmit();
		reporter.reportLogWithScreenshot("Change contact language inflormation submitted.");
    	reporter.softAssert((getRogersProfileAndSettingsPage().clkBtnChangeLanguageDone()
    			&& getRogersProfileAndSettingsPage().verifyLanguageSetSuccessfully(newLanguage)),
				"Change language was done successfully", 
				"Change language did not happen successfully");
    	
	}

}
