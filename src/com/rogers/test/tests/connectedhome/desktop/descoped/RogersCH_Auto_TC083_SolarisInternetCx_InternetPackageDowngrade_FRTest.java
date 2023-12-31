package com.rogers.test.tests.connectedhome.desktop.sai;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
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
 *3. Click on Internet badge
 *4. Click on change package button
 *5. Choose a tv package whose price is lower than the current package and click on Select
 *6. Verify the Contact Us Popup
 *7. Verify the contact us header
 *8. Verify the content of contact us popup
 *9. Verify the book a call link
 **/

public class RogersCH_Auto_TC083_SolarisInternetCx_InternetPackageDowngrade_FRTest extends BaseTestClass {

    @Test
    public void rogersCH_Auto_TC083_SolarisInternetCx_InternetPackageDowngrade_FR()
    {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
            reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc17_18_19_20_SolarisInternetAccount.accountDetails.getBan());
        }
        reporter.reportLogWithScreenshot("Account Selected");
        getRogersSolarisTVDashboardPage().clkFR();
        getRogersInternetDashboardPage().clkSolarisInternetBadge();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard");
        //getRogersInternetDashboardPage().clkInternetPopup();
        getRogersInternetDashboardPage().clkSolChangeInternetPackage();
        reporter.reportLogWithScreenshot("Launched the Internet packages page");
        getRogersInternetDashboardPage().selectSolarisInternetPackage(TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getAccountDetails().getDowngradePlanEn(),TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getAccountDetails().getDowngradePlanFr());
        //getRogersInternetDashboardPage().clkInternetChangeOK();


        reporter.hardAssert(getRogersInternetDashboardPage().verifyChangePackagePopupHeader(),"Verified the Change Package Popup Header","Change Package Popup Header is not verified");
      //  reporter.hardAssert(getRogersInternetDashboardPage().verifyContactUsModalContentFR(),"Verified the contact us modal content", "Contact us Modal content is not matching");
        reporter.hardAssert(getRogersInternetDashboardPage().verifyBookACallBack(),"Verified the Book a call back link","Book a call back link not verified");
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

