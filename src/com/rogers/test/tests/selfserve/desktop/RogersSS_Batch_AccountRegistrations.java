package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class RogersSS_Batch_AccountRegistrations extends BaseTestClass {
	

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve_login,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	 
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}

	@DataProvider(name = "AccountRegistrationData", parallel = true)
	public Object[] testData() throws IOException {
		String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/selfserve/AccountRegistration.csv";
		List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
		Object[] csvRowStrArray = new Object[csvData.size()];
		for (int i = 0; i < csvData.size(); i++) {
			csvRowStrArray[i] = csvData.get(i);
		}
		return csvRowStrArray;
	}
	
	@Test(dataProvider = "AccountRegistrationData")
	public void rogersSS_Batch_AccountRegistrations(String[] csvRowStrArray) {
		System.out.println(System.getenv());
		String strBan = csvRowStrArray[0];
		String strPostalCode = csvRowStrArray[1];
		String strEmail = csvRowStrArray[2];
		String strPassword = csvRowStrArray[3];

		reporter.reportLogWithScreenshot("Rogers Launch page");
    	getRogersHomePage().clkSignIn();
    	reporter.reportLogWithScreenshot("Sign in overlay");    		
		getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().clickRegister();
		reporter.reportLogWithScreenshot("Register Now");
		//=== commenting due  to changes in story DC-3077 		
		getRogersRegisterPage().clickRegisterNow();
		reporter.reportLogWithScreenshot("Wireless Or Resedential Services");
		getRogersRegisterPage().clickWirelessOrResidentialServices();
		reporter.reportLog("Registering account with Ban : "+strBan+
				  " PostCode : "+strPostalCode+
				  " Email "+strEmail+
				  " Password "+strPassword);
		reporter.reportLogWithScreenshot("Set account number and Postal code");
		getRogersRegisterPage().setAccountNumber(strBan);
		getRogersRegisterPage().setPostalCode(strPostalCode);
		reporter.reportLogWithScreenshot("Account number and postal code ");		
		reporter.hardAssert(getRogersRegisterPage().clickContinue(),
				"The BAN and postcode found", 
				"Ban and account not found");
		if(!getRogersRegisterPage().isProfileAlreadyStarted())
		{
			getRogersRegisterPage().setEmail(strEmail);
			getRogersRegisterPage().setReEnterEmail(strEmail);
			reporter.reportLogWithScreenshot("Set email address");
			getRogersRegisterPage().clkContinueEmailVarification();
		}
			
		//Will open a new tab for ENS, to get verification code from ENS		

		reporter.reportLogWithScreenshot("ENS");
		ensVerifications.getEmailVerifyPage(strEmail);
		reporter.reportLogWithScreenshot("Email inbox got from ENS.");
		getRogersSetPasswordPage().clkBtnSetPasswordInEmail();
		//Another new page opened
		getRogersSetPasswordPage().switchToSetPasswordTab(3);
		getRogersSetPasswordPage().setPassword(strPassword);
		getRogersSetPasswordPage().setConfirmPassword(strPassword);
		reporter.reportLogWithScreenshot("Set password page.");
		getRogersSetPasswordPage().clkBtnSetPassword();
		reporter.softAssert(getRogersSetPasswordPage().verifyMsgReigistrationCompleteIsDisplayed(),
				"Registration completed message displayed",
				"Registration completed message does Not displayed");
		reporter.reportLogWithScreenshot("Set password completed.");
		getRogersSetPasswordPage().clkButtonSignIn();
		getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strEmail);
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	getRogersAccountOverviewPage().selectAccount(strBan);
        }
        reporter.reportLogWithScreenshot("Account overview page.");
						
	}
	
	
	/**
	 * This method will parse CSV for DataProvider
	 * @param fileName String file name with complete location
	 * @return Iterator array object with parsed CSV data
	 * @throws IOException
	 * @author Mirza.Kamran
	 */
	public Iterator<Object[]> parseCsvDataSS(String fileName) throws IOException
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
