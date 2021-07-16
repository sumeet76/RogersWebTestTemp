package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_111_TC_112_BnP_ValidateTheSetUpPTPflowForDelinquentCxWhenCreditCardOrBankIsSelectedAsPaymentMethod extends BaseTestClass {
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                //new Object[]{TestDataHandler.tc111.getUsername(), TestDataHandler.tc111.getPassword(),TestDataHandler.tc111.getAccountDetails().getBan(),"Credit Card"},
                new Object[]{TestDataHandler.tc112.getUsername(), TestDataHandler.tc112.getPassword(),TestDataHandler.tc112.getAccountDetails().getBan(),"Telephone/Online banking"}
        };
    }


    @Test(dataProvider = "data-provider",groups = {"BillingAndPaymentsSS","PTP"})
    public void validateSignInAndAccountOverview(String[] dataRow) {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	getRogersHomePage().clkSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(dataRow[0]);
        getRogersLoginPage().setPasswordIFrame(dataRow[1]);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
        getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();

        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	getRogersAccountOverviewPage().selectAccount(dataRow[2]);
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Passed", "Login Failed");

        reporter.hardAssert(getRogersAccountOverviewPage().verifyPTPWidgetIsDisplayed(),
                "The PTP widget is displayed","The PTP widget is ot displayed for this account");

        getReporter().reportLogWithScreenshot("Set up promise to pay");

        getRogersAccountOverviewPage().clkSetUpAPromiseToPay();
        getReporter().reportLogWithScreenshot("Clicked on link Set up promise to pay");

        getReporter().hardAssert(getRogersAccountOverviewPage().verifySetUpPromiseToPayPageIsLoaded(),
                "Set up promise to pay page is displayed",
                "Set up promise to pay is page NOT displayed");
        String strBalanceValue = getRogersAccountOverviewPage().getBalanceValueForPromise();

        getRogersAccountOverviewPage().selectHowWouldYouLikeToPromiseToPay(dataRow[3]);
        getReporter().reportLogWithScreenshot("Payment type selected as credit card");
        String strDate = getRogersAccountOverviewPage().selectWhenYouWillIkeToPayThePromise();

        getReporter().reportLogWithScreenshot("Promise date selected");

        getRogersAccountOverviewPage().clkSetUpPromise();
        getReporter().reportLogWithScreenshot("Set up promise to pay is displayed");

        getReporter().hardAssert(getRogersAccountOverviewPage().verifyPromiseToSetUpSuccessFul(),
                "Set up promise to pay is set up successfully , balance value: "+strBalanceValue + "Promise Date: "+strDate,
                "Set up promise to pay is NOT set up successfully");
        getReporter().reportLogWithScreenshot("Set up promise success page");
        getRogersAccountOverviewPage().clkDoneSetUpPromiseAfterSuccess();
        getReporter().hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
                "Account overview page loaded",
                "Account overview page didnt load");

    }

  

}
