package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_001_Stress_ValidateSignInAndAccountOverviewTest extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
//    @DataProvider(name = "processDataList", parallel=true)
//    public static Object[][] getProcessDataList() {
//
//        Object[][] serviceProcessDataList = new Object[10][2];
//
//	    for(int i=0; i<=serviceProcessDataList.length; i++){
//	        
//	        serviceProcessDataList[i][0] = TestDataHandler.tc013132.getUsername();
//          serviceProcessDataList[i][1] = TestDataHandler.tc013132.getPassword();
//	    }
//
//
//        return serviceProcessDataList;
//    }
	
	@Test(invocationCount = 100,groups = {"EasyLogin100"})
    public void validateSignInAndAccountOverview() {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc013132.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc013132.getPassword());
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
        getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();

//        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
//        	reporter.reportLogWithScreenshot("Select an account.");
//        	getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc013132.getAccountDetails().getBan());
//        }
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Passed", "Login Failed");
    }

  

}
