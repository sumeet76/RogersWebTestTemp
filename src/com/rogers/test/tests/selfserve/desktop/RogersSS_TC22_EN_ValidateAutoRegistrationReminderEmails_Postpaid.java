package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

import extentreport.ExtentTestManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC22_EN_ValidateAutoRegistrationReminderEmails_Postpaid extends BaseTestClass {
	

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve_login,method);
		}
	 
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test(groups = {"Autoregister"})
	public void validateUserChangeContactInformationAndBillingAddress() {
		String strURI = "https://qa07-mservices.rogers.com/v1/user/registration/mwautocreate";
		reporter.reportLog("URI:"+strURI);
		String strEmail = "Auto1020SS007@yahoo.com";
		String strPassword = "DigiAuto@123";
		String strBan ="938021383";
		//================= Email reminder code
		this.autoregisterUser(strURI,strEmail,strBan);
		this.sendreminderEmail(strURI);    
		 
		//Will open a new tab for ENS, to get verification code from ENS		
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
				reporter.hardAssert(rogers_set_password_page.verifyMsgReigistrationCompleteIsDisplayed(),
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
			}
	
		public void autoregisterUser(String strURI, String strEmail,String strBan) {
			
			RestAssured.baseURI = strURI;
			RequestSpecification request = RestAssured.given();
			// JSONObject is a class that represents a Simple JSON.
			// We can add Key - Value pairs using the put method		
			JSONObject requestParams = new JSONObject();
			requestParams.put("APIKey", "33E65811AA93C04251E841EDE37C9DE9D93FB40336092A7A4B209463A2362E27"); 
			requestParams.put("accountNumber", strBan);		 
			requestParams.put("email", strEmail);
			requestParams.put("language", "en");
			requestParams.put("realm",  "ROGERS");
			requestParams.put("consolidatedAccNumber", "");
			requestParams.put("billType", "1");
		
			// Add a header stating the Request body is a JSON
			request.header("Content-Type", "application/json")
		      .and().header("realm","ROGERS")
		      .and().header("Accept-Language","EN");		
			 
			// Add the Json to the body of the request
			request.body(requestParams.toString());
			reporter.reportLog("BODY:"+requestParams.toString());
	 
			// Post the request and check the response
			Response response = request.post();
			
			int statusCode = response.getStatusCode();
			reporter.reportLog("Response:"+statusCode);
			reporter.reportLog(response.body().asString());
			reporter.hardAssert((statusCode==200), 
					"Auto registartion is Successful", 
					"Failed");
		}
		
		public void sendreminderEmail(String strURI) {
			String strURIEmailer ="https://qa07-mservices.rogers.com/v1/user/registration/retry";
			reporter.reportLog("URI emailer:"+strURIEmailer);
			RestAssured.baseURI = strURIEmailer;
			RequestSpecification request = RestAssured.given();
				
			// JSONObject is a class that represents a Simple JSON.
						// We can add Key - Value pairs using the put method		
			JSONObject requestParams = new JSONObject();
			requestParams.put("APIKey", "33E65811AA93C04251E841EDE37C9DE9D93FB40336092A7A4B209463A2362E27"); 
			requestParams.put("autoRegAPIKey","33E65811AA93C04251E841EDE37C9DE9D93FB40336092A7A4B209463A2362E27");
			requestParams.put("autoRegURL",strURI);		 
			requestParams.put("eventType", "RETRY_PASSWORD_REMINDER_TWO");
			requestParams.put("error", "");
			requestParams.put("retryDays",  "0");
			
		
			// Add a header stating the Request body is a JSON
			request.header("Content-Type", "application/json")
		      .and().header("realm","ROGERS")
		      .and().header("Accept-Language","EN");		
			 
			// Add the Json to the body of the request
			request.body(requestParams.toString());
			reporter.reportLog("BODY:"+requestParams.toString());
	 
			// Post the request and check the response
			Response response = request.post();			
			int statusCode = response.getStatusCode();
			reporter.reportLog("Response code emailer:"+statusCode);
			reporter.reportLog("Response Body emailer :"+response.body().asString());
			reporter.hardAssert((statusCode==200), 
					"Email reminder is Successful", 
					"Email reminder is not successful");
		}
	

}
