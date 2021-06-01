package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_023_FR_ValidateAutoRegistrationReminderEmails_Postpaid extends BaseTestClass {
	

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		System.setProperty("PageLoadStrategy", "NONE");
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve_login,method);
		}
	 
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test(groups = {"Autoregister","RegressionSS"})
	public void validateUserChangeContactInformationAndBillingAddress() {
		String strURI = System.getProperty("URIautoRegister");
		reporter.reportLog("URI:"+strURI);
		String strEmail = TestDataHandler.tc23.getUsername();
		String strPassword = TestDataHandler.tc23.getPassword();
		String strBan =TestDataHandler.tc23.getAccountDetails().getBan();
		//================= Email reminder code
		this.autoregisterUser(strURI,strEmail,strBan);
		this.sendreminderEmail(strURI);    
		 
		//Will open a new tab for ENS, to get verification code from ENS		
				reporter.reportLogWithScreenshot("ENS");
				getEnsVerifications().getEmailVerifyPage(strEmail);
				reporter.reportLogWithScreenshot("Email inbox got from ENS.");
				getRogersSetPasswordPage().clkBtnSetPasswordInEmail();
				//Another new page opened
				getRogersSetPasswordPage().switchToSetPasswordTab(3);
				
				getRogersSetPasswordPage().setPassword(strPassword);
				getRogersSetPasswordPage().setConfirmPassword(strPassword);
				reporter.reportLogWithScreenshot("Set password page.");
				getRogersSetPasswordPage().clkBtnSetPassword();
		//Login with recovered user name to verify
		reporter.hardAssert(getRegisterOrAccountRecoveryPage().isPasswordSuccessfullySet(),
				"passowrd reset successful for recover password flow",
				"passowrd reset NOT successful for recover password flow");
		reporter.reportLogWithScreenshot("Password success page");
		getRegisterOrAccountRecoveryPage().clkGoToMyRogers();
		reporter.reportLogWithScreenshot("Go to my rogers clicked");
		getRegisterOrAccountRecoveryPage().switchToDefaultContent();
		reporter.reportLogWithScreenshot("Switch to default content");
		reporter.reportLogWithScreenshot("waiting for account overview....");
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
				"username successfully recovered", "username NOT recovered successfully, please investigate");
		reporter.reportLogWithScreenshot("Account overview");
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
			requestParams.put("language", "fr");
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
			String strURIEmailer = System.getProperty("URIEmailer");
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
		      .and().header("Accept-Language","FR");		
			 
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
