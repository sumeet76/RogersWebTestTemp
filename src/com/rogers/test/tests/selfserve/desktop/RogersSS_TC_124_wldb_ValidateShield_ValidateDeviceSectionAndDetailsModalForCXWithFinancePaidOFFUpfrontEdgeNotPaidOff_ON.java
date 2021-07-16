package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_124_wldb_ValidateShield_ValidateDeviceSectionAndDetailsModalForCXWithFinancePaidOFFUpfrontEdgeNotPaidOff_ON extends BaseTestClass {
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test(groups = {"CAMShiled","RegressionSS"})
    public void validateDeviceSectionOnWirelessDashboardPage() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc124.getUsername();
    	//getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc124.getPassword();
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc124.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");  
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc124.getAccountDetails().getCtn();
        String last4Digit = strAccountNum.substring(strAccountNum.length()-4);
        if (getRogersAccountOverviewPage().isAccountShowInDropDown(last4Digit)) {
            getRogersAccountOverviewPage().clkDropDownAccount(last4Digit);
        } else {
        	getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
        }

        //-Container label/title should be "Device Financing Payment"
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyHeaderOfDeviceSection("Device financing payment:"),
        					"Header of Device section shows 'Device financing payment:'in wireless dashboard page verified successfully",
        					"Header of device section in wireless dashboard page didn't show as expected.");


        //Monthly financing amount should be 0$
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyDeviceMonthlyFinancingAmount("0"),
							"Device balance in wireless dashboard page verified successfully", 
							"Device balance in wireless dashboard page didn't show as expected.");

        //- Remaining financing balance should be 0$
        reporter.hardAssert(getRogersWirelessDashboardPage().checkRemainingFinancingBalanceAmount("0.00"),
                "- Remaining financing balance should be 0$",
                "- Remaining financing balance seems not to be 0$, please investigate");

        //- Financing term start and end dates
        reporter.hardAssert(getRogersWirelessDashboardPage().isFinancingAgreementStartDateDisplayed()
                            && getRogersWirelessDashboardPage().isFinancingAgreementEndDateDisplayed(),
                "Financing term start and end dates displayed correctly",
                " Financing term start or end dates not displayed correctly");


        //- User should have a link to view Full Details
        reporter.hardAssert(getRogersWirelessDashboardPage().isViewFinancingDetailsButtonDisplayed(),
                "View Financing Details Button is visible",
                "View Financing Details Button is not visible");

        getRogersWirelessDashboardPage().clkViewFinancingDetails();

        reporter.reportLogWithScreenshot("Device Details Modal.");

        //- Last upgrade / Activation Date
        reporter.hardAssert(getRogersWirelessDashboardPage().isActivationDateDisplayed(),
                "Activation Date is visible",
                "Activation Date is not visible");

        //- Financing Program Balance will be $0 on [date]
        reporter.hardAssert(getRogersWirelessDashboardPage().isFinancingEndDateDisplayed(),
                "Financing End Date will be be $0 on date is visible",
                "Financing End Date will be be $0 on date is not visible");

        //- Upfront Edge Amount: X.XX$

        reporter.hardAssert(getRogersWirelessDashboardPage().isUpfrontEdgeAmountDisplayedCorrect(),
                "Upfront Edge Amount: X.XX$",
                "Upfront Edge Amount not correct it seems: X.XX$");

        //-You will need to return your device by: Mon,DD,YYYY
        reporter.hardAssert(getRogersWirelessDashboardPage().isYouWIllNeedToReturnYourDeviceByDateDisplayedCorrectly(),
                "Upfront Edge Amount: X.XX$",
                "Upfront Edge Amount not correct it seems: X.XX$");

        //Financing Program Balance as of today: $x.xx - 0$
        reporter.hardAssert(getRogersWirelessDashboardPage().isTotalRemainingDeviceFinancingBalanceDisplayed("0.00"),
                "Total Remaining Device Financing Balance is visible",
                "Total Remaining Device Financing Balance is not visible");


        //- Base Financing Device Cost: $x.xx - 0$
        reporter.hardAssert(getRogersWirelessDashboardPage().isRemainingDeviceFinancingBalanceDisplayed("0.00"),
                " Base Financing Device Cost: $x.xx - 0$",
                "Remaining Financing Balance is not visible");

       // - Taxes on Financing Program Balance: $x.xx - 0$
        reporter.hardAssert(getRogersWirelessDashboardPage().isRemainingFinancedTaxesDisplayed("0.00"),
                "Taxes on Financing Program Balance: $x.xx - 0$",
                "Remaining Financed Taxes is not visible");

        //- Financing Program Monthly Payment: $x.xx - 0$
        reporter.hardAssert(getRogersWirelessDashboardPage().isMonthlyFinancingAmountTotalDisplayed("0.00"),
                "Financing Program Monthly Payment: $x.xx - 0$",
                "Monthly Financing Total is not visible");

        //- Base Monthly Payment: $x.xx- - 0$
        reporter.hardAssert(getRogersWirelessDashboardPage().isMonthlyFinancingAmountBaseDisplayed("0.00"),
                "Base Monthly Payment: $x.xx- - 0$",
                "Monthly Financing Amount Base is not visible");

        //Taxes on Monthly Payment: $x.xx  - 0$
        reporter.hardAssert(getRogersWirelessDashboardPage().isMonthlyFinancingTaxesDisplayed("0.00"),
                "Taxes on Monthly Payment: $x.xx  - 0$",
                "Monthly Financing Tax is not visible");

        //- Remaining Months:  0
        reporter.hardAssert(getRogersWirelessDashboardPage().isMonthsRemainingDisplayed("0"),
                "Remaining Months:  0",
                "Months Remaining is not 0 it seems");

        //- Legal Copy for Financing Program
        getRogersWirelessDashboardPage().clkDeviceFinancingDetailsButton();

        reporter.reportLogWithScreenshot("Legal Copy For Financing Program");

        reporter.hardAssert(getRogersWirelessDashboardPage().isLegalCopyForFinancingProgramDisplayed(),
                "Legal Copy For Financing Program is visible",
                "Legal Copy For Financing Program is not visible");
    }
    
}
