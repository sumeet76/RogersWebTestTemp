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
 * TC33-Consuumer_OV_ML Account_Validate the credit limit exceeded modalin plan config page for a Medium risk customer_EN_BC
 * @author praveen.kumar7
 */
public class RogersBFA_OV_TC33_AdditionalLineHUP_MediumRisk_CLAExceeded_EN_ON_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","RegressionOVBFA","OVHUPBFA"})
	public void rogersHUPOnAdditionLine_CLAExceeded_EN_Test() {
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.buyFlowsOVtestCase33.getBanNo(), TestDataHandler.buyFlowsOVtestCase33.getContactID());
		reporter.hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
		reporter.reportLogWithScreenshot("Rogers Account overview page");
		reporter.hardAssert(getAccountOverViewPage().verifyAndClickWirelessCTN(TestDataHandler.buyFlowsOVtestCase33.getCtn()),"CTN Found","CTN Not Found");
		getAccountOverViewPage().clkCloseBtnAssignDataManager();
		//----------------------------------------------Dashboard page--------------------------------------------------
		reporter.hardAssert(getRogersOVWirelessDetailsPage().verifyWirelessPageLoad() ,"Wireless page loaded" , "Wireless page not loaded");
		reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
		getRogersOVWirelessDetailsPage().clkUpgradeMyDevice();
		reporter.reportLogWithScreenshot("Device upgrade button clicked");
		getRogersOVWirelessDetailsPage().setCustomerType(this.getClass().getSimpleName());
		//----------------------------------------Device Catalog & Config page-------------------------------------------
		/*reporter.hardAssert(getRogersOVChoosePhonePage().isModalDisplayed() , "CTN selection Modal window displayed on the screen " ,"CTN selection Modal window not displayed on the screen");
		reporter.reportLogWithScreenshot("CTN Modal window displayed on the screen");
		getRogersOVChoosePhonePage().selectCTN(TestDataHandler.buyFlowsOVtestCase33.getCtn());
		getRogersOVChoosePhonePage().clkContinueBtnHupCtnSelectionModal();*/
		String deviceName = TestDataHandler.buyFlowsOVtestCase33.getDeviceName();
		reporter.hardAssert(getRogersOVChoosePhonePage().verifyDeviceTileCTAButton(deviceName), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
		getRogersOVChoosePhonePage().clickDeviceTileCTAButton(TestDataHandler.buyFlowsOVtestCase33.getDeviceName());
		getRogersOVChoosePhonePage().clickContinueButton();
		//---------------------------------------------Plan config page-------------------------------------------------
		reporter.hardAssert(getRogersOVPlanConfigPage().verifyCustomerTypeInHeader("CONSUMER"),
				"Customer type in header is displayed correctly", "Customer type in header is not displayed correctly");
		reporter.softAssert(getRogersOVPlanConfigPage().verifyBreadCrumb(deviceName),
				"BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
		reporter.hardAssert(getRogersOVPlanConfigPage().verifySelectedDeviceSection(deviceName), "Plan Config loaded", "Plan config page not loaded");
		reporter.reportLogPassWithScreenshot("Plan Config page loaded successfully");
		getRogersOVPlanConfigPage().clkPreCartDeviceCostContinueButtonForNac();
		reporter.hardAssert(getRogersOVPlanConfigPage().verifyCLMExceededModalPresent(),
				"Credit limit exceeded modall is displayed", "Credit limit exceeded modal is not displayed");
		reporter.hardAssert(getRogersOVPlanConfigPage().verifyCLMExceededTxtInModal(),
				"Credit limit exceeded info present in modal","Credit limit exceeded info is not displayed in modal");
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