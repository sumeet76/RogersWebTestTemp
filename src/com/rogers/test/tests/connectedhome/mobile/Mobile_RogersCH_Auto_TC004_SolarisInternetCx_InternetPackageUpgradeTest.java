package com.rogers.test.tests.connectedhome.mobile;

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
 * This class contains the test method to verify the Solaris Internet package downgarde flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on internet package.
 *4. Click on chage package button.
 *5. Select a package which has price higher to the current package.
 *6. Scroll down to the last in the page and Click on Checkout.
 *7. Enter appropriate Contact details.
 *8. Pick a date time in step 2 - Most Convenient Time for us to call.
 *9. Click on Continue.
 *10. Go to Agreement section section,  scroll down all the way,  and click on "I have read………." check box
 *11. Click on Submit.
 *
 **/

public class Mobile_RogersCH_Auto_TC004_SolarisInternetCx_InternetPackageUpgradeTest extends BaseTestClass {

    @Test(groups = {"MobileRegressionCH"})
    public void mobile_RogersCH_Auto_TC004_SolarisInternetCx_InternetPackageUpgrade() {

        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        if (getRogersLoginPage().isOverlayContainerDisplayed()) {
            reporter.reportLogWithScreenshot("Select Continue in browser.");
            getRogersLoginPage().clkContinueInBrowser();
            reporter.reportLogWithScreenshot("Continue in Browser Selected");
        }

        getRogersLoginPage().setUsernameMobile(TestDataHandler.tcm04_SolarisInternetAccount.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordMobile(TestDataHandler.tcm04_SolarisInternetAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
    	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");

        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
            reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tcm04_SolarisInternetAccount.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account Selected");
    	reporter.hardAssert(getRogersAccountOverviewPage().verifyLoginSuccessWelcome(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersInternetDashboardPage().clkInternetBadgeMobile();
        getRogersInternetDashboardPage().clkInternetPopup();
        reporter.reportLogWithScreenshot("Launched the Interent dashboard");
        getRogersInternetDashboardPage().clkSolChangeInternetPackageMobile();
        reporter.reportLogWithScreenshot("Launched the Interent packages page");
        getRogersInternetDashboardPage().selectSolarisInternetPackageMobile(TestDataHandler.tcm04_SolarisInternetAccount.getAccountDetails().getUpgradePlanEn(),TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getAccountDetails().getUpgradePlanFr());
        reporter.reportLogWithScreenshot("Launched the agreement page");
        getRogersInternetDashboardPage().clkInternetChangeOK();
        if(getRogersInternetDashboardPage().verifySmartStreamHeader()){
            reporter.reportLogWithScreenshot("Verified the smart stream modal");
            getRogersInternetDashboardPage().clkOnNoThanks();
        }
      //  getRogersInternetDashboardPage().clkContinueToChangeInternetPackage();
		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPageInternet(),"Agreement page has Launched","Agreement page has not Launched");
		reporter.reportLogWithScreenshot("Launched the order review page");
		
		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
		
        getRogersOrderReviewPage().clkAcceptenceCheckboxUpdateInternetMobile();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmitUpdateInternetMobile();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.softAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Update order completed","Update order Failed");
        reporter.reportLogWithScreenshot("Verified the Confirmation page");
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

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}


}

