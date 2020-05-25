package com.rogers.test.tests.connectedhome;
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
import com.rogers.testdatamanagement.TestDataHandler;

public class RogersCH_TC_021_SolarisHAWTFlowExistingInternetPortInTest extends BaseTestClass {

    @Test
    public void checkBuyIginteTVOffer() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
   		rogers_login_page.setUsernameIFrame(TestDataHandler.solarisPortinFlows.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.solarisPortinFlows.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		rogers_account_overview_page.selectAccount(TestDataHandler.solarisPortinFlows.getAccountDetails().getBan());
		reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Login Success","Login Failed");
        rogers_home_page.clkShop(); 
        reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
     	rogers_home_page.clkIgniteTV();
    	reporter.reportLogWithScreenshot("Launched the IgniteTV page");
    	rogers_home_page.clkServiceability();
    	reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
    	String  strAddressLine1=(String) TestDataHandler.solarisPortinFlows.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=(String) TestDataHandler.solarisPortinFlows.getAccountDetails().getAddress().get("line2");
       /* rogers_home_page.setIgniteAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        rogers_home_page.clkIgniteAddressLookupSubmit();*/
        reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
        rogers_igniteTV_buy_page.selectSolarisStarterPackageNew();
        reporter.reportLogWithScreenshot("Launched the port-in popup");
        rogers_igniteTV_buy_page.clickOptPhone();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        rogers_home_phone_port_in_page.setHomePhoneNumber(TestDataHandler.solarisPortinFlows.getAccountDetails().getPhoneNumber());
        rogers_home_phone_port_in_page.clkPhoneNumberEligibiltyCheck();
        rogers_home_phone_port_in_page.verifyPhoneNumberSuccess();
        reporter.reportLogWithScreenshot("Port-in Number validation success");
        rogers_home_phone_port_in_page.setFirstName();
        rogers_home_phone_port_in_page.setLastName();
        rogers_home_phone_port_in_page.setInvoiceAddress(strAddressLine1+", "+strAddressLine2+", CANADA");
        rogers_home_phone_port_in_page.setCurrentPhoneNumber(); 
        reporter.reportLogWithScreenshot("Port-in details set");
        rogers_home_phone_port_in_page.clkPhoneCheck();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        rogers_igniteTV_buy_page.clkHomePhone();
        rogers_igniteTV_buy_page.verify4KTV();
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        rogers_igniteTV_buy_page.set4KTV();
        reporter.reportLogWithScreenshot("4k TV selected");
        rogers_igniteTV_buy_page.clkCheckout();
        reporter.reportLogWithScreenshot("Launched the profile page");
        rogers_igniteTV_profile_creation_page.clkSubmitProfile();  
        reporter.reportLogWithScreenshot("Home Phone selection page has launched");
        rogers_home_phone_selection_page.clkContinueHomePhoneSelection();  
        rogers_tech_install_page.verifyTechInstallPage(); 
        reporter.reportLogWithScreenshot("Launched the tech install page");
        rogers_tech_install_page.selTechInstalStartDate();
        reporter.reportLogWithScreenshot("Selected Start date for Installation slot");
        rogers_tech_install_page.selTechInstalEndDate();
        reporter.reportLogWithScreenshot("Selected End date for Installation slot");
        rogers_tech_install_page.setEmail(); 
        reporter.reportLogWithScreenshot("tech install details");
        rogers_tech_install_page.clkTechInstallContinue();
        rogers_order_review_page.verifyAgreementPage();
        reporter.reportLogWithScreenshot("Launched the order review page");
        rogers_order_review_page.verifyAgreement();
        rogers_order_review_page.clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        rogers_order_review_page.clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.softAssert(rogers_order_confirmation_page.verifyOrderConfirmation(),"Order has created successfully","Order has failed");       
        reporter.reportLogWithScreenshot("Verified the Confirmation page");
    }

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	//IgniteLogin
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(TestDataHandler.rogersConfig.getRogersURL(),  strBrowser,strLanguage,strGroupName, method);
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


