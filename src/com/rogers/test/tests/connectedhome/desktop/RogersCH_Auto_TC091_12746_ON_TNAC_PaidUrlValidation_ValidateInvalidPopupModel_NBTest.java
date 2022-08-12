package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to validate the Invalid offer for Rogers.com NB region
 * 
 * @author Manpreet.Kaur3
 * 
 * Test steps:
 *
 *1. Launch the ON TNAC offer url.
 *2. Enter the NB region address.
 *3. Click on `View Packages`.
 *4. Enter the NB address for validating whether the offer is valid or not for that address.
 *5. Verify the invalid offer popup.
 *
 **/

public class RogersCH_Auto_TC091_12746_ON_TNAC_PaidUrlValidation_ValidateInvalidPopupModel_NBTest extends BaseTestClass {
    @Test
    public void rogersCH_Auto_TC091_12746_ON_TNAC_PaidUrlValidation_ValidateInvalidPopupModel_NB() {
        getDriver().get(System.getProperty("QaUrl")+"home/internet/offers?offerid=TNACRUC2ON");
        reporter.reportLogWithScreenshot("Launched the ON TNAC paid URL");
        String strAddressLine1 = TestDataHandler.tc29_IgniteServiceabilityAddressNB.getAccountDetails().getAddress().get("line1");
        String strAddressLine2 = TestDataHandler.tc29_IgniteServiceabilityAddressNB.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
        getRogersHomePage().clkIgniteAddressLookupSubmitSS();
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        getRogersInternetDashboardPage().clkViewPkgs();
        reporter.reportLogWithScreenshot("Clicked View Packages");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability in NB region");
        getRogersHomePage().clkIgniteAddressLookupSubmitSS();
        reporter.hardAssert(getRogersInternetDashboardPage().verifyInvalidTnacOfferPopup(),"Invalid offer Popup displayed", "Invalid offer popup not displayed");
    	}       


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}

