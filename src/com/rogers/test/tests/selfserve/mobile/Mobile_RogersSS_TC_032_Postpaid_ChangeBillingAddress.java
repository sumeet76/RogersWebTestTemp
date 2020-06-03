package com.rogers.test.tests.selfserve.mobile;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;


public class Mobile_RogersSS_TC_032_Postpaid_ChangeBillingAddress extends BaseTestClass {
	
    private String strStreetName;
	private String strStreetType;
	private String strApartment;
	private String strApartmentType;
	private String strCityName;
	private String strProvince;
	private String strPostalCode;
	private String strBillingAddress;
	private String strStreetNumber;


	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
	 
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test
	public void validateUserChangeContactInformationAndBillingAddress() {
    	rogers_home_page.clkSignInMobile();
    	String strUsername = TestDataHandler.tc013132.getUsername();
    	String strPassword = TestDataHandler.tc013132.getPassword();
    	String strBan = TestDataHandler.tc013132.getAccountDetails().getBan();

		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.setUsernameIFrame(strUsername);
		rogers_login_page.setPasswordIFrame(strPassword);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
        
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select BAN.");
            rogers_account_overview_page.selectAccount(strBan);
        }
		reporter.reportLogWithScreenshot("Account overveiew page");
    	rogers_account_overview_page.clkLnkProfileNSettingsMobile();
		reporter.reportLogWithScreenshot("Profile & Settings page");

    	//Change Billing settings
		common_business_flows.scrollToMiddleOfWebPage();
		rogers_profile_and_settings_page.clkCloseFeedbackIfAvailableMobile();
    	rogers_profile_and_settings_page.clkBtnBillingInfomation();   
    	reporter.reportLogWithScreenshot("Billing address before make change.");
    	if(rogers_profile_and_settings_page.getExistingBillingAddress().contains("ON N5Y4J1"))
    	{
    		strStreetNumber = "1";
    		strStreetName = "Fleetwood";
    		strStreetType = "ROAD";
    		strApartment = "201";
    		strApartmentType = "Apartment";
    		strCityName = "Brampton";
    		strProvince = "Ontario";
    		strPostalCode = "L6T2E5";
    		strBillingAddress = "ON L6T2E";
    		
    		
    	}else
    	{
    		strStreetNumber = "722";
    		strStreetName = "SEVILLA PARK";
    		strStreetType = "PLACE";
    		strApartment = "";
    		strApartmentType = "Apartment";
    		strCityName = "LONDON";
    		strProvince = "Ontario";
    		strPostalCode = "N5Y4J1";
    		strBillingAddress = "ON N5Y4J";
    		
    	}    	 	
    	rogers_profile_and_settings_page.clkLnkChangeBillingAddressMobile();    	
		rogers_profile_and_settings_page.setStreetNumber(strStreetNumber);
    	rogers_profile_and_settings_page.setStreetname(strStreetName);
    	rogers_profile_and_settings_page.selectStreetType(strStreetType);
    	rogers_profile_and_settings_page.setApartment(strApartment);
    	rogers_profile_and_settings_page.selectAprtmentType(strApartmentType);
    	rogers_profile_and_settings_page.setCityName(strCityName);
    	rogers_profile_and_settings_page.selectProvince(strProvince);
    	rogers_profile_and_settings_page.setPostalCode(strPostalCode);
		reporter.reportLogWithScreenshot("Update billing address page.");
    	rogers_profile_and_settings_page.clkChangeAddresContinueButton();
    	rogers_profile_and_settings_page.selectAndSubmit(); 
    	//rogers_profile_and_settings_page.clkSubmit();
		reporter.reportLogWithScreenshot("New billing address submitted.");
    	reporter.softAssert((rogers_profile_and_settings_page.clickDoneChangeBillingAddress()
    			&& rogers_profile_and_settings_page.verifyBillingAddress(strBillingAddress)),
				"Billing address change was done successfully", 
				"Billing address was not updated, please investigate");
    	reporter.reportLogWithScreenshot("New billing address updated successful");
	}

}
