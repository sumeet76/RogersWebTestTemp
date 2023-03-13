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
 * This class contains a negative test scenario to validate expired promo code (SAI + NAC) on Offers page
 * TC046_Negative Scenerio_Expired Promocode_Organic flow via SAI page_Validate error message_ON_Edge_EN
 * @author nandan.master
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Browser to Shop menu and select Internet option
 *3. Scroll down and click on 'check availibility' button
 *4. Enter home address to validate the serviceability and click on Check Address button
 *5. Expand Promo Code section and input an expired promo code
 *6. Validate error message
 *
 **/

public class RogersCH_Auto_TC118_SAI_NAC_ExpiredPromoCode_OrganicFlow_ValidateErrorMessageTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","saiCH"})
    public void RogersCH_Auto_TC118_SAI_NAC_ExpiredPromoCode_OrganicFlow_ValidateErrorMessageTest() throws InterruptedException {
        String expiredPromoCode = "PCEXPIRED";
        getDriver().get(System.getProperty("QaUrl") + "/internet");
        reporter.reportLogWithScreenshot("Launched Internet Page");
        getRogersHomePage().clkInternetAvailability();
        reporter.reportLogWithScreenshot("Launched the customer availability check popup");
        String strAddressLine1 = TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line1");
        String strAddressLine2 = TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1 + "," + strAddressLine2);
        reporter.reportLogWithScreenshot("Address entered for serviceability");
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyInternetOffersPage(), "Launched the Internet-bundles page", "Internet-bundles page has not displayed");
        reporter.reportLogWithScreenshot("Launched the Internet-packages page");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyPromoCodeButton(), "Promo Code Button has displayed", "Promo Code Button has not displayed");
        getRogersInternetPackageSelectionPage().clkPromoCode();
        reporter.reportLogWithScreenshot("Expanded Promo Code Section");
        getRogersInternetPackageSelectionPage().setIgniteAddressLookup(expiredPromoCode);
        reporter.reportLogWithScreenshot("Promo Code Entered");
        getRogersInternetPackageSelectionPage().clkPromoCodeCheck();
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyExpiredPromoCodeError(), "Promo Code Error has displayed", "Promo Code validation has failed");
    }

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_igniteanonymous, method);
	}

    @AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}
}
