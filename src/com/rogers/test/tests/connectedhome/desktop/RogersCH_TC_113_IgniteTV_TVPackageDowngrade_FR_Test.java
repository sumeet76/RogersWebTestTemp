package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to verify the solaris TV package downgrade flow for Rogers.com
 * 
 * @author manpreet.kaur3
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on a TV account
 *4. Click on change package button
 *5. Choose a tv package whose price is lower than the current package and click on Select
 *6. Verify the Contact Us Popup
 *7. Verify the contact us header
 *8. Verify the content of contact us popup
 *9. Verify the book a call link
 **/

public class RogersCH_TC_113_IgniteTV_TVPackageDowngrade_FR_Test extends BaseTestClass {

    @Test(groups = {"SanityCH","RegressionCH","TVPlanUpgardeCH"})
    public void checkSolarisTVPackageUpgrade() 
    {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc04_07_SolarisTVAccount.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc04_07_SolarisTVAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        getRogersLoginPage().clkSkipIFrame();
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc04_07_SolarisTVAccount.accountDetails.getBan());
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersSolarisTVDashboardPage().clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dash board");
        getRogersSolarisTVDashboardPage().clkChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the TV packages page");
        getRogersSolarisTVDashboardPage().selectSolarisTVPackage(TestDataHandler.tc04_07_SolarisTVAccount.accountDetails.getDowngradePlanEn(),TestDataHandler.tc04_07_SolarisTVAccount.accountDetails.getDowngradePlanFr());
        reporter.hardAssert(getRogersSolarisTVDashboardPage().verifycontatUSPopUp(),"Displayed the contat US popup","Download package has failed");
        reporter.reportLogWithScreenshot("Launched the customer care popup");
        reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyChangePackagePopupHeader(),"Verified the Change Package Popup Header","Change Package Popup Header is not verified");
        reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyContactUsModalContentFR(),"Verified the contact us modal content", "Contact us Modal content is not matching");
        reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyBookACallBack(),"Verified the Book a call back link","Book a call back link not verified");
        reporter.reportLogWithScreenshot("Verified the customer care popup content");
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

