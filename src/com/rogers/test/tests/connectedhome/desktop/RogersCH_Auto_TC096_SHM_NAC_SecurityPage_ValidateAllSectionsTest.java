package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;


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

public class RogersCH_Auto_TC096_SHM_NAC_SecurityPage_ValidateAllSectionsTest extends BaseTestClass {
    final String strLanguage=System.getProperty("Language");

   @Test(groups = {"RegressionCH","RhpAndRhmCH"})
    public void rogersCH_Auto_TC096_SHM_NAC_SecurityPage_ValidateAllSections() {
       String actualTitle = getDriver().getTitle();
       getReporter().hardAssert(getRogersSecurityPackagesPage().verifySecurityPackagesPageTitle(actualTitle, strLanguage), "Title is Verified", "Title Verification is failed");

       reporter.reportLogWithScreenshot("View Automate package page component in Security package page");
       checkShmSecurityPageViewAutomatePackage_RedirectTopOfAutomatePackageTest();

       reporter.reportLogWithScreenshot("How to get Security Package test");
       checkHowToGetSecurityPackageTest();

       reporter.reportLogWithScreenshot("Feature Test");
       checkShmSecurityPageSHMfeaturesTest();

       reporter.reportLogWithScreenshot("Hardware Test");
       checkShmSecurityPageHardwareTest();

       reporter.reportLogWithScreenshot("Home Monitoring App Test");
       checkHomeMonitoringAppTest();

       reporter.reportLogWithScreenshot("Assure Package Test");
       checkShmSecurityPageAssureTest();

       reporter.reportLogWithScreenshot("Control package Test");
       checkShmSecurityPageControlTest();

    }

    public void checkHowToGetSecurityPackageTest(){
        String actualTitle = getDriver().getTitle();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySecurityPackagesPageTitle(actualTitle, strLanguage), "Title is Verified", "Title Verification is failed");
        reporter.reportLogWithScreenshot("Launched the security package Home Page");
        getRogersSecurityPackagesPage().clkHowToGetSecurityPackages();
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String strAddressLine1 = TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line1");
        String strAddressLine2 = TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line2");
        getRogersSecurityPackagesPage().setIgniteAddressLookup(strAddressLine1 + "," + strAddressLine2);
        reporter.reportLogWithScreenshot("Entered address");
        getRogersSecurityPackagesPage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Submit address");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySecurityPackagesModelDisplayed(), "Security Packages Model is Verified", "Security Packages Model Verification is failed");
        reporter.reportLogWithScreenshot("Security Packages options Model");
        getRogersSecurityPackagesPage().clkAddressFoundCloseModal();
        reporter.reportLogWithScreenshot("Modal Closed");
    }

    public void checkShmSecurityPageAssureTest() {
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyHowToGetSecurityPackages(), "Launched  security package Home Page", "Security package Home Page is not Launched");
        reporter.reportLogWithScreenshot("Launched the security package Home Page");
        getRogersSecurityPackagesPage().ViewTopOfPage();
        getRogersSecurityPackagesPage().clkAssurePackDetails();
       // getReporter().hardAssert(getRogersSecurityPackagesPage().verifypopupPackageDetails(), "Assure Package Details model has displayed", "Assure Package Details model is not displayed");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAssurePackageDetails(), "Assure Package Details displayed", "Assure Package Details model is not displayed");
        reporter.reportLogWithScreenshot("Assure Package Details displayed");
        getRogersSecurityPackagesPage().clkPackageDetailsCloseModal();

        getRogersSecurityPackagesPage().clkHowToGetItAssurePack();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySecurityPackagesModelDisplayed(), "Security Packages Model is Verified", "Security Packages Model Verification is failed");
        reporter.reportLogWithScreenshot("Security Packages options Model");

       getRogersSecurityPackagesPage().clkAddressFoundCloseModal();
       reporter.reportLogWithScreenshot("Modal Closed");

    }

    public void checkShmSecurityPageControlTest() {
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyHowToGetSecurityPackages(), "Launched  security package Home Page", "Security package Home Page is not Launched");
        reporter.reportLogWithScreenshot("Launched the security package Home Page");
        getRogersSecurityPackagesPage().ViewTopOfPage();
        getRogersSecurityPackagesPage().clkControlPackDetails();
       // getReporter().hardAssert(getRogersSecurityPackagesPage().verifypopupPackageDetails(), "Control Package Details model has displayed", "Control Package Details model is not displayed");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyControlPackageDetails(), "Control Package Details displayed", "Control Package Details model is not displayed");
        reporter.reportLogWithScreenshot("Control Package Details displayed");
        getRogersSecurityPackagesPage().clkPackageDetailsCloseModal();

        getRogersSecurityPackagesPage().clkHowToGetItControlPack();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySecurityPackagesModelDisplayed(), "Security Packages Model is Verified", "Security Packages Model Verification is failed");
        reporter.reportLogWithScreenshot("Security Packages options Model");

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
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyHowToGetSecurityPackages(), "Launched  security package Home Page", "Security package Home Page is not Launched");
        reporter.reportLogWithScreenshot("Launched the security package Home Page");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyViewHardware(), "View Hardware button is displayed", "View Hardware button is not displayed");
        reporter.reportLogWithScreenshot("View Hardware button");
        getRogersSecurityPackagesPage().clkViewHardware();
        reporter.reportLogWithScreenshot("Clicked on View Hardware");
        switchTabsUsingPartOfUrl("hardware");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyHardwarePage(), "View Hardware Page is displayed", "View Hardware page is not displayed");
        reporter.reportLogWithScreenshot("View Hardware page");
        getRogersSecurityPackagesPage().ViewHardwarePackages();
        reporter.reportLogWithScreenshot("View Hardware packages");
        switchTabsUsingPartOfUrl("security-packages");

    }


    public void checkShmSecurityPageSHMfeaturesTest() {
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyHowToGetSecurityPackages(), "Launched  security package Home Page", "Security package Home Page is not Launched");
        reporter.reportLogWithScreenshot("Launched the security package Home Page");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySHMfeatures(), "SHM features button is displayed", "SHM features button is not displayed");
        reporter.reportLogWithScreenshot("SHM features button");
        getRogersSecurityPackagesPage().clkSHMfeatures();
        reporter.reportLogWithScreenshot("Clicked SHM Feature");
        switchTabsUsingPartOfUrl("features");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySHMFeasturePage(), "SHM features page is displayed", "SHM features page is not displayed");
        reporter.reportLogWithScreenshot("SHM Feature page");
        getRogersSecurityPackagesPage().ViewSHMFeasture();
        reporter.reportLogWithScreenshot("SHM Feature packages");
        switchTabsUsingPartOfUrl("security-packages");
    }


    public void checkHomeMonitoringAppTest() {
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyHowToGetSecurityPackages(), "Launched  security package Home Page", "Security package Home Page is not Launched");
        reporter.reportLogWithScreenshot("Launched the security package Home Page");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyHomeMonitoringapp(), "Home Monitoring app button is displayed", "Home Monitoring app button is not displayed");
        reporter.reportLogWithScreenshot("Home Monitoring app button");
        getRogersSecurityPackagesPage().clkHomeMonitoringapp();
        switchTabsUsingPartOfUrl("app");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifySHMAppPage(), "Home Monitoring app page is displayed", "Home Monitoring app page is not displayed");
        reporter.reportLogWithScreenshot("Home Monitoring app page");
        getRogersSecurityPackagesPage().ViewSHMAppPage();
        reporter.reportLogWithScreenshot("Home Monitoring app packages");
        switchTabsUsingPartOfUrl("security-packages");
    }

    public void checkShmSecurityPageViewAutomatePackage_RedirectTopOfAutomatePackageTest() {
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyHowToGetSecurityPackages(), "Launched  security package Home Page", "Security package Home Page is not Launched");
        reporter.reportLogWithScreenshot("Launched the security package Home Page");
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyViewAutomatePackage(), "View Automate Package button is displayed", "View Automate Package button is not displayed");
        reporter.reportLogWithScreenshot("View Automate Package button");
        getRogersSecurityPackagesPage().clkViewAutomatePackage();
        getReporter().hardAssert(getRogersSecurityPackagesPage().verifyAutomationPackagePage(), "View Automate Package page is displayed", "View Automate Package page is not displayed");
        reporter.reportLogWithScreenshot("Automation page");
        getRogersSecurityPackagesPage().ViewAutomationPackagePage();
        reporter.reportLogWithScreenshot("Automation packages");
    }

    public void switchTabsUsingPartOfUrl(String platform) {
        String currentHandle = null;
        try {
            final Set<String> handles = getDriver().getWindowHandles();
            if (handles.size() > 1) {
                currentHandle = getDriver().getWindowHandle();
            }
            if (currentHandle != null) {
                for (final String handle : handles) {
                    getDriver().switchTo().window(handle);
                    if (getDriver().getCurrentUrl().contains(platform) && !currentHandle.equals(handle)) {
                        break;
                    }
                }
            } else {
                for (final String handle : handles) {
                    getDriver().switchTo().window(handle);
                    if (getDriver().getCurrentUrl().contains(platform)) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Switching tabs failed");
        }
    }




    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    //legacyAnonymous
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_shm, method);
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}


