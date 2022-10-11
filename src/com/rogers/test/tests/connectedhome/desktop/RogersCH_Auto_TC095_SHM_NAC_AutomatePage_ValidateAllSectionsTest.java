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
 * This class contains the test method to test Legacy Internet Offer Buy flow for Rogers.com
 *
 * @author chinnarao.vattam
 *
 * Test steps:
 * 1.Launch Rogers SAI Tupelo URL in QA Env and click on get it now and enter address and click on continue
 * 2. Click on continue
 * 3. Choose Internet, SmartStream checkbox and click on Load offers
 * 4. Add 1 STB and click on Add to cart
 * 5. Click on Continue
 * 6. Click on Checkout
 * 7. Click on Yes, continue
 * 8. Click on Continue
 * 9. Enter DOB, valid ID details and click on continue
 * 10. Choose Installation type as enhanced self install and click on continue
 * 11. Click on Continue
 * 12. Click on Submit
 *
 **/

public class RogersCH_Auto_TC095_SHM_NAC_AutomatePage_ValidateAllSectionsTest extends BaseTestClass {
    final String strLanguage=System.getProperty("Language");


  @Test(groups = {"RegressionCH","RhpAndRhmCH"})
    public void rogersCH_Auto_TC095_SHM_NAC_AutomatePage_ValidateAllSections() {
      String actualTitle = getDriver().getTitle();
      getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagesPageTitle(actualTitle, strLanguage), "Title is Verified", "Title Verification is failed");

      reporter.reportLogWithScreenshot("View Security package page component in Automate package page");
      checkShmAutomationPageViewSecurityPackages_RedirectTopOfSecurityPackageTest();

      getDriver().get(System.getProperty("QaUrl") + "/home-security/automation-packages"+ "?setLanguage=" + strLanguage);
      reporter.reportLogWithScreenshot("How to get Automate Package test");
      checkShmHowToGetAutomatePackageTest();

      getDriver().get(System.getProperty("QaUrl") + "/home-security/automation-packages"+ "?setLanguage=" + strLanguage);
      reporter.reportLogWithScreenshot("Features Test ");
      checkShmSecurityPageSHMfeaturesTest();

      getDriver().get(System.getProperty("QaUrl") + "/home-security/automation-packages"+ "?setLanguage=" + strLanguage);
      reporter.reportLogWithScreenshot("Hardware Test ");
      checkShmSecurityPageHardwareTest();

      getDriver().get(System.getProperty("QaUrl") + "/home-security/automation-packages"+ "?setLanguage=" + strLanguage);
      reporter.reportLogWithScreenshot("Home Monitoring App Test ");
      checkHomeMonitoringAppTest();

      getDriver().get(System.getProperty("QaUrl") + "/home-security/automation-packages"+ "?setLanguage=" + strLanguage);
      reporter.reportLogWithScreenshot("Automate Package Test");
      checkShmAutomatePackageTest();

    }

    public void checkShmHowToGetAutomatePackageTest(){
        String actualTitle = getDriver().getTitle();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagesPageTitle(actualTitle, strLanguage), "Title is Verified", "Title Verification is failed");
        reporter.reportLogWithScreenshot("Launched the security package Home Page");
        getRogersSecurityPackagesPage().clkHowToGetAutomatePackage();
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String strAddressLine1 = TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line1");
        String strAddressLine2 = TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line2");
        getRogersSecurityPackagesPage().setIgniteAddressLookup(strAddressLine1 + "," + strAddressLine2);
        reporter.reportLogWithScreenshot("Entered address");
        getRogersSecurityPackagesPage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Submit address");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySecurityPackagesModelDisplayed(), "Security Packages Model is Verified", "Security Packages Model Verification is failed");
        getRogersSecurityPackagesPage().clkAddressFoundCloseModal();
        reporter.reportLogWithScreenshot("Modal Closed");
    }
    @Test
    public void checkShmAutomatePackageTest(){
        String actualTitle = getDriver().getTitle();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagesPageTitle(actualTitle, strLanguage), "Title is Verified", "Title Verification is failed");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomatePackageDetails(), "Automate Package Details displayed", "Protect Package Details model is not displayed");
        reporter.reportLogWithScreenshot("Automate Package Details displayed");
        getRogersSecurityPackagesPage().clkAutomatePackageDetails();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomatePackageMoreDetails(), "Automate Package Details model has displayed", "Automate Package Details model is not displayed");
        getRogersSecurityPackagesPage().clkPackageDetailsCloseModal();
        getRogersSecurityPackagesPage().clkHowToGetItAutomatePack();
        reporter.reportLogWithScreenshot("Clicked on How to get it");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySecurityPackagesModelDisplayed(), "Security Packages Model is Verified", "Security Packages Model Verification is failed");
        reporter.reportLogWithScreenshot("Security Packages options Model");
        reporter.reportLogWithScreenshot("Contact Us Test");
        getRogersSecurityPackagesPage().clkSecurityPackagesByLivechat();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyIfrmLiveChatDisplayed(), "LiveChat frame is Verified", "LiveChat frame Verification is failed");
        reporter.reportLogWithScreenshot("Options to Live chat for security package Order");
        getRogersSecurityPackagesPage().switchToLivechatIFrame();
        getRogersSecurityPackagesPage().clkNoShmOption();
        reporter.reportLogWithScreenshot("Options Live chat window questions");
        getRogersSecurityPackagesPage().clkCloseLivechat();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySecurityPackagesModelDisplayed(), "Security Packages Model is Verified", "Security Packages Model Verification is failed");
        getRogersSecurityPackagesPage().clkSecurityPackagesByCall();
        reporter.reportLogWithScreenshot("Options to call CC for security package Order");

    }

    public void checkShmSecurityPageHardwareTest() {
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyViewHardware(), "View Hardware button is displayed", "View Hardware button is not displayed");
        reporter.reportLogWithScreenshot("View Hardware button");
        getRogersSecurityPackagesPage().clkViewHardware();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyHardwarePage(), "View Hardware Page is displayed", "View Hardware page is not displayed");
        reporter.reportLogWithScreenshot("View Hardware page");
        getRogersSecurityPackagesPage().ViewHardwarePackages();
        reporter.reportLogWithScreenshot("View Hardware packages");
    }


    public void checkShmSecurityPageSHMfeaturesTest() {
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySHMfeatures(), "SHM features button is displayed", "SHM features button is not displayed");
        reporter.reportLogWithScreenshot("SHM features button");
        getRogersSecurityPackagesPage().clkSHMfeatures();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySHMFeasturePage(), "SHM features page is displayed", "SHM features page is not displayed");
        reporter.reportLogWithScreenshot("SHM Feasture page");
        getRogersSecurityPackagesPage().ViewSHMFeasture();
        reporter.reportLogWithScreenshot("SHM Feasture packages");
    }


    public void checkHomeMonitoringAppTest() {
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyHomeMonitoringapp(), "Home Monitoring app button is displayed", "Home Monitoring app button is not displayed");
        reporter.reportLogWithScreenshot("Home Monitoring app button");
        getRogersSecurityPackagesPage().clkHomeMonitoringapp();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySHMAppPage(), "Home Monitoring app page is displayed", "Home Monitoring app page is not displayed");

        reporter.reportLogWithScreenshot("Home Monitoring app page");
        getRogersSecurityPackagesPage().ViewSHMAppPage();
        reporter.reportLogWithScreenshot("Home Monitoring app packages");
    }


    public void checkShmAutomationPageViewSecurityPackages_RedirectTopOfSecurityPackageTest() {

        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyViewSecurityPackage(), "View Security Package button is displayed", "View Security Package button is not displayed");
        reporter.reportLogWithScreenshot("View Security Package button");
        getRogersSecurityPackagesPage().clkViewSecurityPackage();
        String actualTitle = getDriver().getTitle();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySecurityPackagesPageTitle(actualTitle, strLanguage), "Title is Verified", "Title Verification is failed");
        reporter.reportLogWithScreenshot("Launched the security package Home Page");
        getRogersSecurityPackagesPage().ViewSecurityPackagePage();
        reporter.reportLogWithScreenshot("security packages");

    }

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    //legacyAnonymous
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_shmautomation, method);
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }



}


