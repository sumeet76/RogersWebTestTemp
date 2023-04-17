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
 * This class contains the test method to test invalid promocode popup with paid URL for Rogers.com ON
 * TC044_Negative Scenerio_Invalid ON Promocode paid url validation_Validate Invalid popup model_URL flow_ON_CH_EN
 * 
 * @author manpreet.kaur3
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Browser to the Paid URL
 *3. Enter ON address to validate the serviceability and click on Check button
 *4. Verify the Invalid Promocode popup
 *
 **/

public class RogersCH_Auto_TC116_Negative_PaidUrl_InvalidPromocode_ValidateInvalidOfferPopupTest extends BaseTestClass {
	@Test(groups = {"RegressionCH"})
    public void rogersCH_Auto_TC116_Negative_PaidUrl_InvalidPromocode_ValidateInvalidOfferPopup() throws InterruptedException {
        getDriver().get(System.getProperty("QaUrl")+"/home/internet/offers?promocode=PCRC1ON");
        reporter.reportLogWithScreenshot("Launched the customer availability check popup");
        String  strAddressLine1=TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
        reporter.reportLogWithScreenshot("Address entered for serviceability");
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Check address for serviceability");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyInvalidPromoCodePopup(),"Invalid Promo Code Popup has displayed","Invalid Promo Code validation has failed");
    }

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_igniteanonymous, method);
	}


	 @AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}
}


