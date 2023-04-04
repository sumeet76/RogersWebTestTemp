package com.rogers.test.tests.connectedhome.desktop;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to validate pending order modal on serviceability check for 2p legacy CX when order is already submitted
 * TC048_Negative_Scenerio_Existing 2p legacy  customer with pending order_Validate legacy cx with Pending Order _serviceability check _pending order model ON_EN
 *
 * @author nandan.master
 * <p>
 * Test steps:
 * <p>
 * 1. Launch the Rogers.com url.
 * 2. Login with valid 2p legacy credentials that has a pending order.
 * 3. Navigate to TV bundles page
 * 4. Click on Serviceability Check button
 * 5. Select existing address on file, and click on Use this address
 * 6. Validate Pending Order pop up
 **/

public class RogersCH_Auto_TC119_Negative_2pLeg_PendingOrder_Validation_Serviceability_CheckTest extends BaseTestClass {
    @Test
    public void rogersCH_Auto_TC119_Negative_2pLeg_PendingOrder_Validation_Serviceability_Check() {
        // TC to be run after tc087 is completed (order submitted) using the same data.
        reporter.reportLogWithScreenshot("Launched the Legacy SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc87_Legacy2PTVToIgnite3P.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc87_Legacy2PTVToIgnite3P.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc87_Legacy2PTVToIgnite3P.getAccountDetails().getBan());
        reporter.reportLogWithScreenshot("Account Selected");
        getDriver().get(System.getProperty("QaUrl") + "/bundles");
        reporter.reportLogWithScreenshot("Launched the IgniteTV page");
        getRogersHomePage().clkServiceability();
        reporter.reportLogWithScreenshot("Clicked on View Bundles");
        getRogersHomePage().selectAddressOnFile();
        reporter.reportLogWithScreenshot("Selected Current Address on file");
        getRogersHomePage().clkUseAddress();
        reporter.reportLogWithScreenshot("Use the address on file");
        getRogersIgniteTVBuyPage().verifyPendingOrderHeader();
        reporter.reportLogWithScreenshot("Use the address on file");
        getRogersIgniteTVBuyPage().clkCloseButtonPendingOrder();
        reporter.reportLogWithScreenshot("Use the address on file");
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    // LegacyLogin
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_legacylogin, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
