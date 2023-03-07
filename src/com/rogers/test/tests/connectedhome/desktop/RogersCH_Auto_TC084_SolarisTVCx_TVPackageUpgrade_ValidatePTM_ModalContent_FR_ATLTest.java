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
 * This class contains the test method to verify the solaris TV package upgarde flow for Rogers.com   
 * 
 * @author manpreet.kaur3
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on a TV account
 *4. Click on chage package button
 *5. Choose a tv package whose price is higher than the current package and click on Submit
 *6. Validate the PTM Modal header
 *7. Validate PTM modal Content
 *8. Validate PTM modal Continue and Cancel button
 *
 **/

public class RogersCH_Auto_TC084_SolarisTVCx_TVPackageUpgrade_ValidatePTM_ModalContent_FR_ATLTest extends BaseTestClass {

	 @Test(groups = {"RegressionCH","TVPlanUpgardeCH"})
    public void rogersCH_Auto_TC084_SolarisTVCx_TVPackageUpgrade_ValidatePTM_ModalContent_FR_ATL()
    {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tcm06_IgniteTVAccount.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tcm06_IgniteTVAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
       // reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
       // getRogersAccountOverviewPage().selectAccount(TestDataHandler.tcm06_IgniteTVAccount.accountDetails.getBan());
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersSolarisTVDashboardPage().clkFR();
        getRogersSolarisTVDashboardPage().clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dash board");
        getRogersSolarisTVDashboardPage().clkChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the TV packages page");
        getRogersSolarisTVDashboardPage().selectSolarisTVPackage(TestDataHandler.tc10_SolarisTVAccountForUpgrade.accountDetails.getUpgradePlanEn(),TestDataHandler.tc10_SolarisTVAccountForUpgrade.accountDetails.getUpgradePlanFr());
        reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyChangeTVPackagePopUp(),"Displayed the Change TV Package popup","Download package has failed");
        reporter.reportLogWithScreenshot("Launched the ChangeTV Package popup");
        reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyChangeTVPackagePopupHeader(),"Verified the Change TV Package Popup Header","Change TV Package Popup Header is not verified");
        reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyChangeTVPackageModalContentHeaderFR(),"Verified the Change Package modal content header", "Change Package Modal content header is not matching");
       // reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyChangeTVPackageModalContentFR(),"Verified the Change Package modal content", "Change Package Modal content is not matching");
        reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyPopupChangeTVPackageContinueBtn(),"Verified Change TV Package continue button", "continue button verification failed");
        reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyChangeTVPackageCancelBtn(),"Verified Change TV Package cancel button", "Cancel button verification failed");

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

