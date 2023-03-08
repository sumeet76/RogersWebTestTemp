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
 * This class contains the test method to validate the TV dashboard for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the TV badge.
 *4. Click on View 'My channel Line Up' link below the Channels at the top left.
 *5. Click on the link to view as pdf and open the pdf.
 *6. Click on 'View My Flex channel' link below the Channels in the top left.
 *7. Click on the link to view as pdf and open the pdf.
 *
 **/

public class RogersCH_Auto_TC073_SAI_NAC_2L7ContractType_BulkBuildingGetsCTAduringServiceability_forNewIgniteBulkInternetOfferTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","RogersInternetCH"})
    public void rogersCH_Auto_TC073_SAI_NAC_2L7ContractType_BulkBuildingGetsCTAduringServiceability_forNewIgniteBulkInternetOffer() {
        getDriver().get(System.getProperty("QaUrl") + "/internet");
        reporter.hardAssert(getRogersHomePage().verifyInternetpage(), "Internet page has Launched", "Internet page has not Launched");
        reporter.reportLogWithScreenshot("Launched the Internet packages page");
        getRogersHomePage().clkInternetAvailability();
        reporter.reportLogWithScreenshot("Launched the customer availability check popup");
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String strAddressLine1 = TestDataHandler.tc67_2L7ContractType3PBulkTenant.getAccountDetails().getAddress().get("line1");
        String strAddressLine2 = TestDataHandler.tc67_2L7ContractType3PBulkTenant.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1 + "," + strAddressLine2);
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.hardAssert(getRogersHomePage().verifyIgniteAddressFoundModal(), "Serviceability success model is displayed", "Serviceability success model is not displayed");
        reporter.reportLogWithScreenshot("Serviceability success model");
    }


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_igniteanonymous, method);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
        closeSession();
	}
}

