package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_033_Postpaid_ChangeBillingAddressInEligibleUser extends BaseTestClass {
	
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
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve_login,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
	 
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test(groups = {"SanitySS","ProfileAndSettingsSS"})
	public void validateUserChangeBillingAddress() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc013132.getUsername();
    	String strPassword = TestDataHandler.tc013132.getPassword();
    	String strBan = TestDataHandler.tc013132.getAccountDetails().getBan();

		getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(strUsername);
		getRogersLoginPage().setPasswordIFrame(strPassword);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
        
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select BAN.");
            getRogersAccountOverviewPage().selectAccount(strBan);
        }
		reporter.reportLogWithScreenshot("Account overveiew page");
    	getRogersAccountOverviewPage().clkLnkProfileNSettings();
		reporter.reportLogWithScreenshot("Profile & Settings page");

    	//Change Billing settings
    	getRogersProfileAndSettingsPage().clkBtnBillingInfomation();
    	reporter.reportLogWithScreenshot("Billing address before make change.");
    	if(getRogersProfileAndSettingsPage().getExistingBillingAddress().contains("ON N5Y4J1"))
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
    	getRogersProfileAndSettingsPage().clkLnkChangeBillingAddress();
    	reporter.reportLogWithScreenshot("Change billing address clicked");
    	if(getRogersProfileAndSettingsPage().isVerifyYourIdentityOverlayDisplayed())
    	{
    		reporter.reportLogWithScreenshot("Your identity overlay is displayed");
    		getRogersProfileAndSettingsPage().switchToVerifyIdentityIFrame();
    		getRogersProfileAndSettingsPage().clkContinueVerifyIdentity();
    		reporter.hardAssert(getRogersProfileAndSettingsPage().isInEligibleUser(),
    				"User is taken to eligibility failure modal",
    				"User is NOT taken to eligibility failure modal");
    		reporter.reportLogWithScreenshot("User is taken to eligibility failure modal");
    		getRogersProfileAndSettingsPage().clkClose();
    		reporter.reportLogWithScreenshot("Clicks on close");
    		reporter.hardAssert(getRogersProfileAndSettingsPage().IsBillingAddressDisplayed(),
    				"Profile and Settings page is displayed"
    				, "Profile and Settings page not displayed");
    		
    	}

		
	}

}
