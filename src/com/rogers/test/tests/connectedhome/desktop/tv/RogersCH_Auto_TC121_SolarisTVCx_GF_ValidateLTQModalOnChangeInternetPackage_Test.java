package com.rogers.test.tests.connectedhome.desktop.tv;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to verify the solaris Internet change package flow for Grandfathered 2p cx Rogers.com
 * TC043_Negative Scenerio_Ignite 2p with grandfathered TV bundle_Validate Internet change package_LTQ modal_ON_CH_EN
 * @author manpreet.kaur3
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on Internet badge
 *4. Click on change package button
 *5. Choose a tv package whose price is lower than the current package and click on Select
 *6. Verify the Contact Us Popup
 *7. Verify the contact us header
 *8. Verify the content of contact us popup
 *9. Verify the book a call link
 **/

public class RogersCH_Auto_TC121_SolarisTVCx_GF_ValidateLTQModalOnChangeInternetPackage_Test extends BaseTestClass {

    @Test
    public void rogersCH_Auto_TC121_SolarisTVCx_ValidateLTQModalOnChangeInternetPackage()
    {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc121_SolarisTVAccountGrandFathered.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc121_SolarisTVAccountGrandFathered.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc121_SolarisTVAccountGrandFathered.accountDetails.getBan());
        reporter.reportLogWithScreenshot("Account Selected");
        getRogersInternetDashboardPage().clkSolarisInternetBadge();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard");
        getRogersInternetDashboardPage().clkSolChangeInternetPackage();
        reporter.reportLogWithScreenshot("Launched the Internet packages page");
        reporter.hardAssert(getRogersInternetDashboardPage().verifyChangePackagePopupHeader(),"Verified the Change Package Popup Header","Change Package Popup Header is not verified");
        reporter.hardAssert(getRogersInternetDashboardPage().verifyBookACallBack(),"Verified the Book a call back link","Book a call back link not verified");
        reporter.reportLogWithScreenshot("Verified the LTQ modal when Ignite 2p cx tries to change internet");
    }

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}


}

