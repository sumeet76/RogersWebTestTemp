package com.rogers.test.tests.connectedhome.desktop.shm;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * This class contains the test method to validate the TV dashboard for Rogers.com   
 * 
 * @author Mirza.Kamran
 * 
 * Test steps:
 *
1.Rogers.com landing page is opened successfully
2. Sign in popup is displayed
3. Account overview page displayed
4. SHM dashboard page should be opened
 *
 **/

public class RogersCH_Auto_TC045_SHMCx_BuyInternet_SameAddressTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","saiCH"})
    public void rogersCH_Auto_TC045_SHMCx_BuyInternet_SameAddress() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc45_sHMSignedInInternetBuy.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc45_sHMSignedInInternetBuy.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
        getEnsVerifications().setVerificationCode();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc45_sHMSignedInInternetBuy.accountDetails.getBan());
        reporter.reportLogWithScreenshot("Launched the Account Page");
      //  getRogersHomePage().clkExistingCustomerShop();
        reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
        getDriver().get(System.getProperty("QaUrl") + "/internet");
        reporter.reportLogWithScreenshot("Launched the Internet page");
        reporter.hardAssert(getRogersHomePage().verifyInternetpage(),"Internet page has Launched","Internet page has not Launched");
        reporter.reportLogWithScreenshot("Launched the Internet packages page");
        getRogersHomePage().clkInternetAvailability();
        reporter.reportLogWithScreenshot("Launched the customer availability check popup");
        getRogersHomePage().selectAddressOnFile();
        reporter.reportLogWithScreenshot("Selected Address on file");
        getRogersHomePage().clkUseAddress();
        reporter.reportLogWithScreenshot("Use the address on file");
        reporter.reportLogWithScreenshot("Launched the Internet packages page");

        getRogersInternetPackageSelectionPage().select150MonthToMonthTypeOfContact();
        reporter.reportLogWithScreenshot("Selected Month-to-month term contract");

        getRogersInternetPackageSelectionPage().clkInternetPackage();
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyCartSummaryHeader(), "Cart Summary Page page has Launched", "Cart Summary Page page has not Launched");
        reporter.reportLogWithScreenshot("Launched the Internet-cart Summary page");
        getRogersInternetPackageSelectionPage().clkInternetBuyContinue();
        reporter.hardAssert(getRogersInternetProfilePage().verifyProfilePageSAI(),"Profile page has Launched","Profile page has not Launched");
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersInternetProfilePage().clkSubmitProfile();

        reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
        reporter.reportLogWithScreenshot("Launched the tech install page");
        getRogersTechInstallPage().clkProInstallUpgradeNo();
        reporter.reportLogWithScreenshot("tech install details");
        getRogersTechInstallPage().clkTechInstallContinueSelf();
        reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallSetUp(),"SetUp page has Launched","SetUp page has not Launched");
        getRogersTechInstallPage().clkTechInstallContinue();

        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
        reporter.reportLogWithScreenshot("Launched the order review page");
        reporter.hardAssert( getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        String ban = getRogersOrderConfirmationPage().getBAN();
        System.out.println("BAN from the portal : " + ban);
        String DbSchema = getDbConnection().getSchemaName(System.getProperty("DbEnvUrl"));
        System.out.println("SCHEMA : " + DbSchema);
        /**
         * DB Validations in the subscriber table
         */
        Map<Object, Object> dblists = getDbConnection().connectionMethod(System.getProperty("DbEnvUrl")).executeDBQuery("select BAN,ACCOUNT_SUB_TYPE,SYS_CREATION_DATE from " + DbSchema +".billing_account where BAN='" + ban + "'", false);
        reporter.softAssert(dblists.get("BAN").equals(ban),"Entry is updated in the billing table","BAN is not present in the billing account table");
        reporter.softAssert(dblists.get("ACCOUNT_SUB_TYPE").equals("R"),"ACCOUNT_SUB_TYPE is verified as R","Account type is not updated as R");
    }

    @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login,method);
				
	}
   	
	
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}

