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
 * This class contains the test method to test the SVOD is removed from genre dropdown under Channels tab for Rogers.com
 *
 * @author manpreet.kaur3
 *
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Click on TV bundles
 *3. Click on View Bundles
 *4. Enter home address to validate the serviceability and click on Check Availability
 *5. Click on Channels Tab
 *6. Verify SVOD removed from genre tab
 *
 **/

public class RogersCH_Auto_TC093_14488_NAC_SVODRemovedFromChannelsTabTest extends BaseTestClass {

	@Test(groups = {"RegressionCH"})
	public void rogersCH_Auto_TC093_14488_NAC_SVODRemovedFromChannelsTab() {
		getRogersHomePage().clkTVBundle();
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		reporter.hardAssert(getRogersHomePage().verifyIgnitepage(),"Ignite page has Launched","Ignite page has not Launched");
		getRogersHomePage().clkServiceability();
		//reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(),"Bundles Page has launched","Bundles Page has not launched");
		//getRogersIgniteTVBuyPage().clkEnterAddress();
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		String  strAddressLine1=TestDataHandler.tc04_08_SolarisTVAccount.getAccountDetails().getAddress().get("line1");
		String  strAddressLine2=TestDataHandler.tc04_08_SolarisTVAccount.getAccountDetails().getAddress().get("line2");
		getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
		getRogersHomePage().clkIgniteAddressLookupSubmit();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		getRogersIgniteTVBuyPage().clkChannelsTab();
		reporter.reportLogWithScreenshot("Launched the Channels");
		reporter.hardAssert(getRogersIgniteTVBuyPage().verifySVODRemovedFromGenre(), "SVOD removed from the genre dropdown","SVOD present under genre dropdown");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_igniteanonymous, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


