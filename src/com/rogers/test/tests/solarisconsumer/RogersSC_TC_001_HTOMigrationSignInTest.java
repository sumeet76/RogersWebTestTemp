package com.rogers.test.tests.solarisconsumer;
import java.io.IOException;
import java.lang.reflect.Method;


import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod; 
import org.testng.annotations.Optional;                     
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
    	getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.solarisHTOMigrationSignIn.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.solarisHTOMigrationSignIn.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		reporter.softAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Login Success","Login Failed");
		getRogersHomePage().clkPromotionOfferBadge();
		Assert.assertTrue(getRogersIgniteTVBuyPage().verifyButtonUpgradeNow(), "Upgrade button is not available");
        reporter.reportLogWithScreenshot("Upgrade button on ignite-bundles page");
        getRogersIgniteTVBuyPage().clkButtonUpgradeNow();
        reporter.reportLogWithScreenshot("Modal upgrading to ignite bundels");
        getRogersIgniteTVBuyPage().verifyUpgradingToIgnitebundelsModal();
        getRogersIgniteTVBuyPage().clkOkayUpgradingToIgnitebundelsModal();
        getRogersOrderReviewPage().verifyAgreementPage();
        reporter.reportLogWithScreenshot("Launched the order review page");
        getRogersOrderReviewPage().enterDateOfbirth(TestDataHandler.solarisHTOMigrationSignIn.getAccountDetails().getDateOfBirth());
        
        
        
        
        
        getRogersOrderReviewPage().verifyAgreement();
        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        getRogersOrderConfirmationPage().verifyOrderConfirmation();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.softAssert(getRogersOrderConfirmationPage().verifyOrderConfirmation(),"Order has created successfully","Order has failed");
    }

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,strGroupName, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


