package com.rogers.test.tests.connectedhome.desktop.nac;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to validate correct values appear on rate card when switching between internet tiers
 * TC053_CH-32364_Bundle NAC 2P_Validate when the term and M-M is configured for different internet tiers of the same package and when we switch between the packages the presentment in the rate cards should display properly_ON_CH_EN
 * @author nandan.master
 * <p>
 * Test steps:
 * <p>
 * 1. Launch Rogers.com
 * 2. Browser to Shop menu and select Bundle option
 * 3. Scroll down to  Bundles section and click on How to Get it button for a Bundle
 * 4. Enter a serviceable address & hit Check button
 * 5. Verify bundles page is launched successfully
 * 6. Confirm the Guaranteed Term Contract price text appears on rate card
 * 7. Confirm 24 Months Term Contract is selected by default
 * 8. Change Internet Download Speed to 500mbps for Ignite Starter
 * 9. Validate Contract Type is Month to Month & disabled
 * 10. Validate OTBC (One Time Bill Credit) banner
 * 11. Select the Starter pack & validate cart summary
 * 12. Hit Checkout option on Cart Summary
 **/

public class RogersCH_Auto_TC128_2PNAC_Validate_ContractType_Switching_Internet_TiersTest extends BaseTestClass {

    @Test
    public void rogersCH_Auto_TC128_2PNAC_Validate_ContractType_Switching_Internet_Tiers() throws InterruptedException {
        String bundleName = "Ignite Starter";
        reporter.reportLogWithScreenshot("Launched the Main QA Page");
        getDriver().get(System.getProperty("QaUrl") + "/bundles");
        reporter.reportLogWithScreenshot("Launched the IgniteTV page for ON region");
        getRogersHomePage().clkServiceability();
        reporter.reportLogWithScreenshot("Serviceability check popup has been launched");
        String strAddressLine1 = TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line1");
        String strAddressLine2 = TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1 + "," + strAddressLine2);
        reporter.reportLogWithScreenshot("Entered serviceable address");
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the Ignite Bundles page");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(), "Bundles Page has launched", "Bundles Page has not launched");

        reporter.hardAssert(getRogersIgniteTVBuyPage().validateGuaranteedPriceTermContract(bundleName),"Guaranteed Price for term contract text is present on Rate Card for a specified package", "Guaranteed Price for term contract text is NOT present on Rate Card for a specified package");

        // verify the selected type of contract is 24 months on first load
        reporter.hardAssert(getRogersIgniteTVBuyPage().validateSelectedTypeOfContractRateCard(bundleName, "24-month term"),"24 Months Term Contract is selected", "24 Months Term Contract is NOT selected");

        getRogersIgniteTVBuyPage().selectInternetSpeedStarterPack(" 500 Mbps ");
        reporter.reportLogWithScreenshot("Selected 500Mbps Internet Speed for Starter Pack");

        // verify after changing internet tier the type of contract changes to m2m & greyed out
        reporter.hardAssert(getRogersIgniteTVBuyPage().validateIfM2MContractTypeIsDisabled(bundleName),"Contract Type dropdown is greyed out", "Contract Type dropdown is NOT greyed out");

        // validate one time bill credit promo
        reporter.hardAssert(getRogersIgniteTVBuyPage().validateOTBCBundleOffers(bundleName), "OTBC validated for a Bundle on offers page", "OTBC NOT validated for a Bundle on offers page");

        getRogersIgniteTVBuyPage().selectSolarisStarterPackage();
        reporter.reportLogWithScreenshot("Ignite Starter Pack Added to cart");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(), "4KTV radio button is available", "4KTV radio button is not available");
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        getRogersIgniteTVBuyPage().set4KTVNo();
        reporter.reportLogWithScreenshot("Selected NO to 4k TV");
        getRogersIgniteTVBuyPage().clkCheckout();
        reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(), "Profile page has Launched", "Profile page has not Launched");
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_igniteanonymous, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}
