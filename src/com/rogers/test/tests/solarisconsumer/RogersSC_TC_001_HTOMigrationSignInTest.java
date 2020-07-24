package com.rogers.test.tests.solarisconsumer;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;
/**
 * This class contains the test method to test the HTO migration signin buy flow for Rogers.com   
 * 
 * @author Saurav.Goyal
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Browse to Shop menu and select Ignite TV option
 *3. Scroll down to Ignite TV bundlessection and select one of available Bundle, click Add to Cart
 **/

public class RogersSC_TC_001_HTOMigrationSignInTest extends BaseTestClass {

    @Test
    public void checkHTOMigrationSignInFlow() {
    	reporter.reportLogWithScreenshot("Launched the Home Page");
    	rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.solarisHTOMigrationSignIn.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.solarisHTOMigrationSignIn.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Login Success","Login Failed");
		rogers_home_page.clkPromotionOfferBadge();
		Assert.assertTrue(rogers_igniteTV_buy_page.verifyButtonUpgradeNow(), "Upgrade button is not available");
        reporter.reportLogWithScreenshot("Upgrade button on ignite-bundles page");
        rogers_igniteTV_buy_page.clkButtonUpgradeNow();
        reporter.reportLogWithScreenshot("Modal upgrading to ignite bundels");
        rogers_igniteTV_buy_page.verifyUpgradingToIgnitebundelsModal();
        rogers_igniteTV_buy_page.clkOkayUpgradingToIgnitebundelsModal();
        rogers_order_review_page.verifyAgreementPage();
        reporter.reportLogWithScreenshot("Launched the order review page");
        rogers_order_review_page.enterDateOfbirth(TestDataHandler.solarisHTOMigrationSignIn.getAccountDetails().getDateOfBirth());
        
        
        
        
        
        rogers_order_review_page.verifyAgreement();
        rogers_order_review_page.clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        rogers_order_review_page.clkSubmit();
        rogers_order_confirmation_page.verifyOrderConfirmation();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.softAssert(rogers_order_confirmation_page.verifyOrderConfirmation(),"Order has created successfully","Order has failed");       
    }

    @BeforeMethod @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	//IgniteLogin
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(TestDataHandler.chConfig.getRogersURL(),  strBrowser,strLanguage,strGroupName, method);
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


