package com.rogers.test.tests.selfserve;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;


public class RogersSS_Batch_AccountRegistrations extends BaseTestClass {
	

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve_login,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	 
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@DataProvider(name = "AccountRegistrationData")
	public Iterator<Object[]> testData() throws IOException
	{
	  return parseCsvData(System.getProperty("user.dir") + "/data/selfserve/AccountRegistration.csv");
	}
	
	
	@Test(dataProvider = "AccountRegistrationData")
	public void validateUserChangeContactInformationAndBillingAddress(String strBan, String strPostalCode, String strEmail,String strPassword) {
		reporter.reportLogWithScreenshot("Rogers Launch page");
    	rogers_home_page.clkSignIn();    	 
    	reporter.reportLogWithScreenshot("Sign in overlay");    		
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.clickRegister();
		reporter.reportLogWithScreenshot("Register Now");
		//=== commenting due  to changes in story DC-3077 		
		//rogers_register_page.clickRegisterNow();
		reporter.reportLogWithScreenshot("Wireless Or Resedential Services");
		rogers_register_page.clickWirelessOrResidentialServices();
		reporter.reportLog("Registering account with Ban : "+strBan+
				  " PostCode : "+strPostalCode+
				  " Email "+strEmail+
				  " Password "+strPassword);
		reporter.reportLogWithScreenshot("Set account number and Postal code");
		rogers_register_page.setAccountNumber(strBan);
		rogers_register_page.setPostalCode(strPostalCode);
		reporter.reportLogWithScreenshot("Account number and postal code ");		
		reporter.hardAssert(rogers_register_page.clickContinue(), 
				"The band and account found", 
				"Ban and account not found");
		if(!rogers_register_page.isProfileAlreadyStarted())
		{
			rogers_register_page.setEmail(strEmail);
			rogers_register_page.setReEnterEmail(strEmail);
			reporter.reportLogWithScreenshot("Set email address");
			rogers_register_page.clkContinueEmailVarification();
		}
			
		//Will open a new tab for ENS, to get verification code from ENS		
		try {
			reporter.reportLogWithScreenshot("ENS");
			ensVerifications.getEmailVerifyPage(strEmail);
			reporter.reportLogWithScreenshot("Email inbox got from ENS.");
			rogers_set_password_page.clkBtnSetPasswordInEmail();
			//Another new page opened
			rogers_set_password_page.switchToSetPasswordTab(3);
			rogers_set_password_page.setPassword(strPassword);
			rogers_set_password_page.setConfirmPassword(strPassword);
			reporter.reportLogWithScreenshot("Set password page.");
			rogers_set_password_page.clkBtnSetPassword();
			reporter.softAssert(rogers_set_password_page.verifyMsgReigistrationCompleteIsDisplayed(),
					"Registration completed message displayed",
					"Registration completed message does Not displayed");
			reporter.reportLogWithScreenshot("Set password completed.");
			rogers_set_password_page.clkButtonSignIn();
			rogers_login_page.switchToSignInIFrame();
	        rogers_login_page.setUsernameIFrame(strEmail);
	        rogers_login_page.setPasswordIFrame(strPassword);
	        reporter.reportLogWithScreenshot("Login Credential is entered.");
	        rogers_login_page.clkSignInIFrame();
	        rogers_login_page.clkSkipIFrame();
			rogers_login_page.switchOutOfSignInIFrame();
	        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
	        	reporter.reportLogWithScreenshot("Select an account.");
	        	rogers_account_overview_page.selectAccount(strBan);       
	        }
	        reporter.reportLogWithScreenshot("Account overview page.");
			
			
			
		} catch (ClientProtocolException e) {
			reporter.reportLogWithScreenshot(e.getMessage());
		} catch (IOException e) {
			reporter.reportLogWithScreenshot(e.getMessage());
		}

						
	}
	
	
	private Iterator<Object[]> parseCsvData(String fileName) throws IOException
	{
	  BufferedReader input = null;
	  File file = new File(fileName);
	  input = new BufferedReader(new FileReader(file));
	  String line = null;
	  ArrayList<Object[]> data = new ArrayList<Object[]>();
	  while ((line = input.readLine()) != null)
	  {
	    String in = line.trim();
	    String[] strTempArray = in.split(",");
	    List<Object> arrray = new ArrayList<Object>();
	    for(String strValue : strTempArray)
	    {
	      arrray.add(strValue);
	    }
	    data.add(arrray.toArray());
	  }
	  input.close();
	  return data.iterator();
	}

}
