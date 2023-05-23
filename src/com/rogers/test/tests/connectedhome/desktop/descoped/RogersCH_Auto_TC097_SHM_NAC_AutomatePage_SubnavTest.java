package com.rogers.test.tests.connectedhome.desktop.descoped;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
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

public class RogersCH_Auto_TC097_SHM_NAC_AutomatePage_SubnavTest extends BaseTestClass {

    final String strLanguage=System.getProperty("Language");
    @Test(groups = {"RegressionCH","RhpAndRhmCH"})
    public void rogersCH_Auto_TC097_SHM_NAC_AutomatePage_Subnav() {
        String actualTitle = getDriver().getTitle();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagesPageTitle(actualTitle, strLanguage), "Title is Verified", "Title Verification is failed");
        reporter.reportLogWithScreenshot("Launched the Automation package Home Page");
        getRogersSecurityPackagesPage().clkProducts();
        reporter.reportLogWithScreenshot("SHM Products");
        getRogersSecurityPackagesPage().clkWhySHM();
        reporter.reportLogWithScreenshot("Why SHM");
        getRogersSecurityPackagesPage().switchTabsUsingPartOfUrl("why");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyWhySHMPage(), "Why SHM? Page is displayed", "Why SHM? page is not displayed");
        reporter.reportLogWithScreenshot("Verify Why Smart Home Monitoring  page");
        getRogersSecurityPackagesPage().switchTabsUsingPartOfUrl("automation-packages");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagesPageTitle(actualTitle, strLanguage), "Launched the Automation package Home Page", "Automation package Home Page not launched");
        reporter.reportLogWithScreenshot("Launched the Automation package Home Page");
        getRogersSecurityPackagesPage().clkProducts();
        reporter.reportLogWithScreenshot("SHM Products");
        getRogersSecurityPackagesPage().clkAutomatePackage();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagePage(), "View Automate Package page is displayed", "View Automate Package page is not displayed");
        reporter.reportLogWithScreenshot("Automation Package page");
        getRogersSecurityPackagesPage().ViewAutomationPackagePage();
        reporter.reportLogWithScreenshot("Scroll to the middle of page");
        getRogersSecurityPackagesPage().MoveToTopOfPage();
        getRogersSecurityPackagesPage().clkProducts();
        reporter.reportLogWithScreenshot("SHM Products");
        getRogersSecurityPackagesPage().clkSecurityPackage();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyHowToGetSecurityPackages(), "Launched  security package Home Page", "Security package Home Page is not Launched");
        reporter.reportLogWithScreenshot("Launched the security package Home Page");
        getRogersSecurityPackagesPage().clkProducts();
        reporter.reportLogWithScreenshot("SHM Products");
        getRogersSecurityPackagesPage().clkHardwarePackage();
        getRogersSecurityPackagesPage().switchTabsUsingPartOfUrl("hardware");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyHardwarePage(), "View Hardware Page is displayed", "View Hardware page is not displayed");
        getRogersSecurityPackagesPage().ViewHardwarePackages();
        reporter.reportLogWithScreenshot("View Hardware packages");
        getRogersSecurityPackagesPage().switchTabsUsingPartOfUrl("automation-packages");
        getDriver().get(System.getProperty("QaUrl") + "/home-security/automation-packages"+ "?setLanguage=" + strLanguage);
        getRogersSecurityPackagesPage().clkProducts();
        reporter.reportLogWithScreenshot("SHM Products");
        getRogersSecurityPackagesPage().clkFeatures();
        reporter.reportLogWithScreenshot("SHM Feature page");
        getRogersSecurityPackagesPage().switchTabsUsingPartOfUrl("features");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySHMFeasturePage(), "SHM features page is displayed", "SHM features page is not displayed");
        reporter.reportLogWithScreenshot("SHM Feature page");
        getRogersSecurityPackagesPage().ViewSHMFeasture();
        reporter.reportLogWithScreenshot("SHM Feature packages");
        getRogersSecurityPackagesPage().switchTabsUsingPartOfUrl("automation-packages");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagesPageTitle(actualTitle, strLanguage), "Launched the Automation package Home Page", "Automation package Home Page not launched");
        reporter.reportLogWithScreenshot("Launched the Automation package Home Page");
        getRogersSecurityPackagesPage().clkApp();
        reporter.reportLogWithScreenshot("SHM App");
        getRogersSecurityPackagesPage().switchTabsUsingPartOfUrl("app");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySHMAppPage(), "Home Monitoring app page is displayed", "Home Monitoring app page is not displayed");
        reporter.reportLogWithScreenshot("Home Monitoring app page");
        getRogersSecurityPackagesPage().ViewSHMAppPage();
        reporter.reportLogWithScreenshot("Home Monitoring app packages");
        getRogersSecurityPackagesPage().switchTabsUsingPartOfUrl("automation-packages");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagesPageTitle(actualTitle, strLanguage), "Launched the Automation package Home Page", "Automation package Home Page not launched");
        reporter.reportLogWithScreenshot("Launched the Automation package Home Page");
        getRogersSecurityPackagesPage().clkHelpAndSupport();
        reporter.reportLogWithScreenshot("Help And Support");
        getRogersSecurityPackagesPage().clkSHMSupport();
        reporter.reportLogWithScreenshot("SHM Support");
        getRogersSecurityPackagesPage().switchTabsUsingPartOfUrl("support");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySHMSupportPage(), "SHM Support page is displayed", "SHM Support page is not displayed");
        reporter.reportLogWithScreenshot("SHM Support page");
        getRogersSecurityPackagesPage().switchTabsUsingPartOfUrl("automation-packages");

        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagesPageTitle(actualTitle, strLanguage), "Launched the Automation package Home Page", "Automation package Home Page not launched");
        reporter.reportLogWithScreenshot("Launched the Automation package Home Page");
        getRogersSecurityPackagesPage().clkHelpAndSupport();
        reporter.reportLogWithScreenshot("Help And Support");
        getRogersSecurityPackagesPage().clkMovingYourServices();
        reporter.reportLogWithScreenshot("Moving Your Services");
        getRogersSecurityPackagesPage().switchTabsUsingPartOfUrl("moving-your-services");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyMovingServicesPage(), "Moving your services page is displayed", "Moving your services is not displayed");
        reporter.reportLogWithScreenshot("Moving your services page");
        getRogersSecurityPackagesPage().switchTabsUsingPartOfUrl("automation-packages");
        getRogersSecurityPackagesPage().clkSeefullDetails();
        reporter.reportLogWithScreenshot("full Details");
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


