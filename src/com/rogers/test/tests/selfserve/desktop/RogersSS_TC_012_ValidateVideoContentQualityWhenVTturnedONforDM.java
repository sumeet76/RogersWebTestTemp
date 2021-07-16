package com.rogers.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

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



public class RogersSS_TC_012_ValidateVideoContentQualityWhenVTturnedONforDM extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test(groups = {"RegressionSS","FDMSS"})
    public void videoContentQualityWhenVTturnedONforDM() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc01030405.getUsername();
    	//getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc01030405.getPassword();    	
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc01030405.getAccountDetails().getBan());
        }
       reporter.reportLogWithScreenshot("Account overview page.");     
       getRogersAccountOverviewPage().clkMenuUsageAndService();
       reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
       getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
       getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible(); 
     
       reporter.reportLogWithScreenshot("Dashboard page");
       getCommonBusinessFlows().scrollToMiddleOfWebPage();
       reporter.reportLogWithScreenshot("Middle view of Dashboard page");
       getCommonBusinessFlows().scrollToTopOfWebPage();
    
       reporter.hardAssert(getRogersWirelessDashboardPage().verifyStreamSaverDisplayed(),
    		   "Stream saver is displayed",
    		   "Stream saver is not displayed");
       
       reporter.hardAssert(getRogersWirelessDashboardPage().isSetDataAlertDisplayed(),
    		   "Set data alert is displayed for this account", "Set data alert is not available for this account");
       
       double totalDataValue = getRogersWirelessDashboardPage().getTotalDataVolume();
       double dataAlert = totalDataValue*0.8;
       String strDataAlert = Double.toString(dataAlert).replaceAll(",", ".");
       strDataAlert =  String.format("%.2f", new BigDecimal(Double.toString(dataAlert).replaceAll(",", ".")));
       getRogersWirelessDashboardPage().clkSetDataAlert();
       reporter.reportLogWithScreenshot("Set data alert");
       reporter.hardAssert(getRogersWirelessDashboardPage().isSetDataAlertOverlayDisplayed(),
    		   "Set Data alert overlay is  displayed for this account",
    		   "Set Data alert overlay is not available for this account");
	   getRogersWirelessDashboardPage().setAlertOn();
	   reporter.reportLogWithScreenshot("Set Alert ON");
	   getRogersWirelessDashboardPage().setDataAlertValue(strDataAlert);
	   reporter.reportLogWithScreenshot("Set data alert value");
	   getRogersWirelessDashboardPage().clkSaveButtonOnDataAlertOverlay();
	   reporter.reportLogWithScreenshot("Save data alert");
	   reporter.hardAssert(getRogersWirelessDashboardPage().isDataAlertCorrectlySet(strDataAlert),
    		   "Set Data alert is  set correctly for this account", "Set data alert is not set correctly for this account");
	   reporter.reportLogWithScreenshot("Set data alert");
             
       if(!getRogersWirelessDashboardPage().isStreamSaverONDisplayed())
       {    	   
    		reporter.reportLogWithScreenshot("Stream saver is set to OFF, switching it ON");
            getRogersWirelessDashboardPage().clkStreamSaverOn();
            reporter.hardAssert(getRogersWirelessDashboardPage().isStreamSaverONDisplayed(),
         		   "Stream saver is switch ON successfully",
         		   "Stream saver didnt switch ON successfuly , please investigate");   
       }
                  	       	                            
       
    }
    
        	

}
