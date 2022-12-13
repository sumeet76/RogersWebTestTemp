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
 * This class contains the test method to test 8gbps offer banner and cart summary for 2.5gbps package selection with GPON address - (SAI + ISS) NAC flow
 * TC048_CH-17286_8 Gigabit shop page enhancement_SAI+ISS NAC_GPON_Term Contract_Launch 8 gigabit Url_Validate the shop page is displayed as per mocks_ON_CH_EN
 * @author nandan.master
 *
 * Test steps:
 * 1. Launch Rogers.com
 * 2. Browser to Shop menu and select Internet option
 * 3. Click on Check Availability and enter home address to validate the serviceability
 * 4. Enter home address to validate the serviceability and click on Check button
 * 5. Click on 'How to Get it' button
 * 6. Validate mini banner for signing up for Canada's fastest 8gbps internet
 * 7. Close the model
 * 8. Select 2.5gbps package, click Add to Cart
 * 9. Validate the package on Mini cart
 **/

public class RogersCH_Auto_TC106_SAI_ISS_NAC_GPON_Validate_8gbps_Offer_Page_Banner_ON extends BaseTestClass {

    @Test
    public void rogersCH_Auto_TC106_SAI_ISS_NAC_GPON_Validate_8gbps_Offer_Page_Banner_ON() throws InterruptedException {

        getDriver().get(System.getProperty("QaUrl") + "internet/streaming?env=qa");
        reporter.hardAssert(getRogersHomePage().verifyInternetpage(),"Internet page has Launched","Internet page has not Launched");
        reporter.reportLogWithScreenshot("Launched the Stream Availability check page");
        getRogersInternetPackageSelectionPage().clkSmartStreamAvailability();
        reporter.reportLogWithScreenshot("Launched the Service availability check popup");
        String  strAddressLine1=TestDataHandler.tc90_1P_HTO_GPON_DualTopology.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.tc90_1P_HTO_GPON_DualTopology.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
        reporter.reportLogWithScreenshot("Address entered for serviceability");
        getRogersHomePage().clkIgniteAddressLookupSubmitSS();

        reporter.reportLogWithScreenshot("Launched the Internet - SmartStream packages page");
        getRogersInternetPackageSelectionPage().clkHowToGetItMiniBanner();
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyHowToGetIt8gbPopupHeader(), "8 gbps contact us model header verified ", "8 gbps contact us model header not verified");
        getRogersInternetPackageSelectionPage().clkCloseButton8gbPopup();

        // 24 months term contract is selected by default
//        reporter.hardAssert(getRogersInternetPackageSelectionPage().verify2500mbpsIgniteStreamingIsChecked(), "Ignite Streaming checkbox is selected", "Ignite Streaming checkbox is unchecked");
        getRogersInternetPackageSelectionPage().clkSmartStream2GbpsPackage();
        reporter.reportLogWithScreenshot("Add to cart Smart Stream Package");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyCartSummaryHeader(), "Launched the Internet-cart Summary page", "Cart Summary not verified");

        // validating bundle name correctly appears on mini cart
        getRogersIgniteTVBuyPage().clkChevronDownYourCart();
        reporter.reportLogWithScreenshot("Launched the mini cart Chevron");
        String bundleName = TestDataHandler.tc90_1P_HTO_GPON_DualTopology.getAccountDetails().getInternetBundle();
        System.out.println("Bundle Name from Test method" + bundleName);
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundleNameMiniCart(bundleName), "Bundle Name on Mini Cart Verified", "Bundle Name on Mini Cart NOT Verified");
        getRogersIgniteTVBuyPage().clkChevronUpYourCart();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    //legacyAnonymous
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_igniteanonymous, method);
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
    }

   @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
