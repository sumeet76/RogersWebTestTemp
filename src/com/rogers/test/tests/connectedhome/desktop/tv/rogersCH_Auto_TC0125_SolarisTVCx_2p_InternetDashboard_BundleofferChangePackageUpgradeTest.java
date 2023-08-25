package com.rogers.test.tests.connectedhome.desktop.tv;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * This class contains the test method to test the HTO 2P flow for Rogers.com
 * TC052_CH-28278_2P-2P_INT dashboard_with Addon SN360 channel_ flex05 to flex20_order review_Validate SN360 not carried over as Add on_Submit order successfully_ON_CH_EN
 * @author nandan.master
 * 
 * Test steps:
 *
 *1. Launch Rogers.com url
 *2. Log into rogers.com url with valid Solaris Account credentials that has either Select or Popular bundle associated to the account/Profile
 *3. Go to Shop menu and select Ignite TV option
 *4. Go to Ignite TV bundle section, and select bundle that is higher than the current bundle and click on Add to Cart
 *5. Click on Ignite Internet speed
 *6. Go to bundle section and click on Rogers Ignite bundle that is higher price than the current bundle
 *7. Validate appropriate information is displayed in Review order page
 *8. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox
 *9. Order confirmation page will be displayed with the order number and validate the order details
 *
 **/

public class rogersCH_Auto_TC0125_SolarisTVCx_2p_InternetDashboard_BundleofferChangePackageUpgradeTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","RogersInternetCH"})
    public void rogersCH_Auto_TC0125_SolarisTVCx_2p_InternetDashboard_BundleofferChangePackageUpgrade() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc21_SolarisInternetAccountForUpgrade.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc21_SolarisInternetAccountForUpgrade.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
    	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc21_SolarisInternetAccountForUpgrade.accountDetails.getBan());
    	reporter.reportLogWithScreenshot("Launched the Account Page");

        getRogersInternetDashboardPage().clkSolarisInternetBadge();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard");
        getRogersInternetDashboardPage().clkSolChangeInternetPackage();
        reporter.reportLogWithScreenshot("Launched the Internet packages page");
        getRogersInternetDashboardPage().selectSolarisInternetPackage(TestDataHandler.tc21_SolarisInternetAccountForUpgrade.getAccountDetails().getUpgradePlanEn(),TestDataHandler.tc21_SolarisInternetAccountForUpgrade.getAccountDetails().getUpgradePlanFr());
        reporter.reportLogWithScreenshot("Launched the agreement page");
        getRogersInternetDashboardPage().verifyPTMmodalHeader();
        reporter.reportLogWithScreenshot("Verified the PTM modal header");
        reporter.hardAssert(getRogersInternetDashboardPage().verifyPTMmodalContent1(), "PTM Model Content Line #1 is validated", "PTM Model Content Line #1 is NOT validated");
        reporter.hardAssert(getRogersInternetDashboardPage().verifyPTMmodalContent2(), "PTM Model Content Line #1 is validated", "PTM Model Content Line #1 is NOT validated");

        getRogersInternetDashboardPage().clkInternetChangeOK();
        reporter.reportLogWithScreenshot("Clicked continue on the PTM modal");

        reporter.hardAssert(getRogersChangePackageChannelsNThemePacksPage().verifyChannelsNThemePacksPage(), "Channels and theme-packs page is verified", "Channels and theme-packs page is not verified.");
        getRogersChangePackageChannelsNThemePacksPage().clkReviewFlexChannels();
        reporter.reportLogWithScreenshot("Clicked continue on the PTM modal");

        List<WebElement> elements = getDriver().findElements(By.xpath("//div[@class='channel-component']//button"));
        int flexCount = 0;
        for (WebElement ele : elements) {
            try {
                flexCount++;
                System.out.println(ele.getText()); // to display the list of channel names
            } catch (StaleElementReferenceException exception) {
            }
        }
        System.out.println(flexCount);
        String[] packageName = TestDataHandler.tc21_SolarisInternetAccountForUpgrade.getAccountDetails().getUpgradePlanEn().split(" ");
        String actualFlexCount = packageName[packageName.length - 1];
        reporter.hardAssert(String.valueOf(flexCount).equals(actualFlexCount), "Total Number of Flex Channels are correct", "Total Number of Flex Channels are NOT correct");

        getRogersChangePackageChannelsNThemePacksPage().clkContinue();
        reporter.reportLogWithScreenshot("Clicked Continue button on Channels & Themepacks page");

        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPageInternet(),"Agreement page has Launched","Agreement page has not Launched");
        reporter.reportLogWithScreenshot("Launched the order review page");
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");

        getRogersOrderReviewPage().clkAcceptenceCheckboxUpdateInternet();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmitUpdateInternet();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.softAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Update order completed","Update order Failed");
        reporter.reportLogWithScreenshot("Verified the Confirmation page");

    	}
	
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() { closeSession();
	}


}


