package com.rogers.test.tests.connectedhome.desktop;
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

/**
 * This class contains the test method to test Digital TV Offer Buy flow for Rogers.com  
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Browser to Shop menu and select Digital TV option
 *3. Scroll down to  TV package section and click on How to Get it button for a TV package
 *4. Enter home address to validate the serviceability and click on Check button
 *
 **/

public class RogersCH_TC_002_DigitalTV_BuyTVOfferTest extends BaseTestClass {

    @Test
    public void checkBuyDigitalTVOffer() throws InterruptedException {
    	reporter.reportLogWithScreenshot("Launched the Home Page");
    	rogers_home_page.clkShop(); 
    	reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the Digital TV");
    	rogers_home_page.clkDTV();
    	reporter.reportLogWithScreenshot("Launched the TV packages page");
    	rogers_buy_page.clkDTVPackage();
        String  strAddressLine1=(String) TestDataHandler.digitalTVAccount.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=(String) TestDataHandler.digitalTVAccount.getAccountDetails().getAddress().get("line2");
        rogers_buy_page.setAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
    	rogers_buy_page.clkAddressLookupSubmit();
    	reporter.reportLogWithScreenshot("Good News for the Service availability");
    	reporter.hardAssert(rogers_buy_page.verifyDTVAvailabilitySuccess(), "Success messsage has displayed","Test has failed as the hasn't displayed");  	                
    }

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	//legacyAnonymous
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(TestDataHandler.rogersConfig.getRogersURL(),  strBrowser,strLanguage,strGroupName, method);
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


