package com.rogers.test.tests.buyflows;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC02-Validate user able to perform AAL on ML with Fin offer
 * 
 * Launch rogers.com page 
 * Select SHOP-->Wireless-->View all devices
 * Select the device
 * Select "Add a line" option
 * Enter the User name and password
 * Click Ok
 * Select a plan for the new line and click Continue
 * Select a Addon(optional) and Click continue
 * Click continue
 * Select Choose a number and click continue
 * Click continue
 * Enter the payment details and click "Submit order"
 * 
 * @author rajesh.varalli1
 *
 */
public class RogersBFA_TestOld_TC02_AAL_MultiLine_FinancePlan_Test extends BaseTestClass {

	@Test
    public void performAALMultiLine() {
		reporter.reportLogWithScreenshot("Rogers Home page");
        getRogersHomePage().clkShop();
        getRogersHomePage().clkWireless();
        getRogersHomePage().clkViewAllDevices();
        getRogersChoosePhonePage().searchDevice(TestDataHandler.testCase02.getNewDevice());
        reporter.reportLogWithScreenshot("Rogers Choose Phone page");
        reporter.reportLogWithScreenshot("Existing Existing Customer overlay");
        getRogersChoosePhonePage().selectFirstAvailableDevice();
        getRogersChoosePhonePage().clkAddALine();
        getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.testCase02.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.testCase02.getPassword());
        reporter.reportLogWithScreenshot("Rogers login overlay");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.reportLogWithScreenshot("Calling Options overlay");
        getRogersBuildPlanPage().clkCallingOptionsOkay();
        getRogersBuildPlanPage().selectPlanCategory(TestDataHandler.testCase02.getNewPlanCategory());
        getRogersBuildPlanPage().selectFirstAvailablePlan();
        reporter.reportLogWithScreenshot("Rogers Build Plan page");
        getRogersBuildPlanPage().clkContinue();
        reporter.reportLogWithScreenshot("Rogers Choose Addons page");
        getRogersChooseAddonsPage().clkContinue();
        reporter.reportLogWithScreenshot("Rogers Cart Summary page");
        getRogersCartSummaryPage().clkContinue();
        reporter.reportLogWithScreenshot("Rogers Shipping page");
        getRogersShippingPage().clkContinue();
        getRogersChooseNumberPage().clkSelectNewNumber();
        getRogersChooseNumberPage().selectCity(TestDataHandler.testCase02.getCtnCity());
        getRogersChooseNumberPage().clkFindAvailableNumbers();
        getRogersChooseNumberPage().selectFirstAvailableNumber();
        getRogersChooseNumberPage().clkSave();
        reporter.reportLogWithScreenshot("Rogers Choose Number page");
        getRogersChooseNumberPage().clkContinue();
        getRogersOrderReviewPage().clkTermsAgreementCheckbox();
        getRogersOrderReviewPage().clkShieldAgreementCheckbox();
        getRogersOrderReviewPage().selectEmailDigitalCopy(TestDataHandler.testCase02.getUsername());
        reporter.reportLogWithScreenshot("Rogers Order Review page");
        getRogersOrderReviewPage().clkSubmitOrder();
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
        reporter.reportLogWithScreenshot("Rogers Order Confirmation page");
    }

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows, method);
	}

	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }
    
}