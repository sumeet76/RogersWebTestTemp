package com.rogers.test.tests.buyflowsoneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC30-Consuumer_OV_SL Account_Validate if user is blocked in shipping stepper for fraudulent address selection_EN_ON
 * @author praveen.kumar7
 */
public class RogersBFA_OV_TC30_HUPWithPPC_FraudulentAddress_EN_ON_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","RegressionOVBFA","OVHUPBFA"})
	public void rogersHUPWithPPC_FraudulentAddressSelection_EN_Test() {
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.buyFlowsOVtestCase30.getBanNo(), TestDataHandler.buyFlowsOVtestCase30.getContactID());
		reporter.hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
		reporter.reportLogWithScreenshot("Rogers Account overview page");
		reporter.hardAssert(getAccountOverViewPage().verifyAndClickWirelessCTN(TestDataHandler.buyFlowsOVtestCase30.getCtn()),"CTN Found","CTN Not Found");
		getAccountOverViewPage().clkCloseBtnAssignDataManager();
		getAccountOverViewPage().setLanguageFrench();
		//----------------------------------------------Dashboard page--------------------------------------------------
		reporter.hardAssert(getRogersOVWirelessDetailsPage().verifyWirelessPageLoad() ,"Wireless page loaded" , "Wireless page not loaded");
		reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
		getRogersOVWirelessDetailsPage().clkUpgradeMyDevice();
		reporter.reportLogWithScreenshot("Device upgrade button clicked");
		getRogersOVWirelessDetailsPage().setCustomerType(this.getClass().getSimpleName());
		//----------------------------------------Device Catalog & Config page-------------------------------------------
		String deviceName = TestDataHandler.buyFlowsOVtestCase30.getDeviceName();
		reporter.hardAssert(getRogersOVChoosePhonePage().verifyDeviceTileCTAButton(deviceName), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
		getRogersOVChoosePhonePage().clickDeviceTileCTAButton(TestDataHandler.buyFlowsOVtestCase30.getDeviceName());
		getRogersOVChoosePhonePage().clickContinueButton();
		//---------------------------------------------Plan config page-------------------------------------------------
		getRogersOVPlanConfigPage().clkPreCartDeviceCostContinueButtonForNac();
		reporter.reportLogPassWithScreenshot("Device cost option selected");
		getRogersOVPlanConfigPage().clickContinueOnModalToDoWithOldPhone();
		getRogersOVPlanConfigPage().clickShowMoreDetails();
		getRogersOVPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersOVPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.buyFlowsOVtestCase30.getDataOptionIndex()));
		reporter.reportLogPassWithScreenshot("Data option selected");
		getRogersOVPlanConfigPage().clickPreCartTalkOptionContinueButton();
		getRogersOVPlanConfigPage().clickPreCartAddonsContinueButton();
		getRogersOVPlanConfigPage().clickCartSummaryContinueButton();
		getRogersOVPlanConfigPage().clkAdditionalLineOptions();
		//---------------------------------------------Checkout pages---------------------------------------------------
		reporter.hardAssert(getRogersOVCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ",
				"Billing Address is not selected");
		getRogersOVCheckoutPage().clkDeliveryMethod("PRO");
		reporter.reportLogPassWithScreenshot("Standard shipping option selected");
		getRogersOVCheckoutPage().clkContinueBtnShipping();
		reporter.reportLogPassWithScreenshot("Customer is blocked due to fraudulent address");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("OVUrl"),strBrowser, strLanguage,RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(),"", "","", "", method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}