package com.rogers.test.tests.connectedhome.desktop.nac;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to test the IgniteTV buy flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Browse to Shop menu and select Ignite TV option
 *3. Scroll down to Ignite TV bundlessection and select one of available Bundle, click Add to Cart
 *4. Enter home address to validate the serviceability and click on Check Availability
 *5. Click on Continue
 *6. Click "No thanks Continue"
 *7. Click on Continue in Home phone add ons page
 *8. Select one option for   'Do you have a 4K TV'
 *9. Click checkout button on cart summary page.
 *10. Enter all personal information on user profile creation page - 1) Profile step
 *11. Click on Continue
 *12. In 2) Credit Evaluation page, enter the required info on Credit Check:
 *13. Click Submit
 *14. Enter 1 or 2 numbers in Choose a phone Number textbox and click on Generate numbers
 *15. Select any one phone number
 *16. Make sure Caller ID and Directory listing fields are populated
 *17. Click on Continue
 *18. Validate minicart
 *19. Select a time in Choose your Date and Time 
 *20. Enter any valid Mobile number and email address
 *21. Click on Confirm
 *22. Select Pre-Authorized credit card option from type of payment dropdown
 *23. Enter valid Credit Card number details in Credit Card related fields
 *24. Click on Continue
 *25. Validate appropriate information is displayed in Review order page
 *26. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox
 *27. Click on Submit
 *
 **/

public class RogersCH_Auto_TC033_3PNAC_CartAbandon_ValidateWelcomeBackModalWhenCxRetrievesCartTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","RogersCartAbandon", "BundlesNAC"})
    public void rogersCH_Auto_TC033_3PNAC_CartAbandon_ValidateWelcomeBackModalWhenCxRetrievesCart() {
        getDriver().get(System.getProperty("QaUrl")+"/bundles?setprovince=ON");
        reporter.reportLogWithScreenshot("Launched the IgniteTV page for ON region");
        getRogersHomePage().clkServiceability();
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String strAddressLine1 = TestDataHandler.tc04_08_SolarisTVAccount.getAccountDetails().getAddress().get("line1");
        String strAddressLine2 = TestDataHandler.tc04_08_SolarisTVAccount.getAccountDetails().getAddress().get("line2");reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
        reporter.reportLogWithScreenshot("Address entered");
        getRogersHomePage().clkIgniteAddressLookupSubmit();

        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyOffersPage(),"Offers Page has launched","Offers Page has not launched");
        getRogersIgniteTVBuyPage().clkHomephone();
        reporter.reportLogWithScreenshot("Checked the Home Phone");
        getRogersIgniteTVBuyPage().selectFlex20PackageMonthToMonthTypeOfContract();
        reporter.reportLogWithScreenshot("Selected month-to-month term contract");
        getRogersIgniteTVBuyPage().selectFlex20Package();
        reporter.reportLogWithScreenshot("Added to cart");
        /*getRogersIgniteTVBuyPage().selectStarterPackageMonthToMonthTypeOfContract();
        reporter.reportLogWithScreenshot("Selected month-to-month term contract");
        getRogersIgniteTVBuyPage().selectSolarisStarterPackage();*/




        reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPortInOutPage() ,"Port-InOut page has Launched","Port-InOut page has not Launched");
        getRogersHomePhoneSelectionPage().clkSkipforNewNumber();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        getRogersIgniteTVBuyPage().clkHomePhone();

        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is availabe","4KTV radio button is not availabe");
        reporter.reportLogWithScreenshot("Launched the cart summary page");        
        getRogersIgniteTVBuyPage().clickMyRogers();
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyEmailModal(),"Email Modal is available","EmailModal is not available");
        getRogersIgniteTVBuyPage().setFirstname();
        getRogersIgniteTVBuyPage().setLastName();
        getRogersIgniteTVBuyPage().setEmail();
        getRogersIgniteTVBuyPage().setPhone();
        getRogersIgniteTVBuyPage().clickEmailCheckbox();
        reporter.reportLogWithScreenshot("Entered the details on Email Modal");
        getRogersIgniteTVBuyPage().clickSubmit();

        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyConfirmation(),"Confirmation Modal is available","Confirmation Modal is not available");
        getRogersIgniteTVBuyPage().clickOkay();
        reporter.reportLogWithScreenshot("launched the login page");
        //getDriver().get(System.getProperty("QaUrl")+"/consumer/easyloginriverpage");
        //reporter.reportLogWithScreenshot("Launched the Easy Login Page");
        //getRogersHomePage().clkShop();
        //getRogersHomePage().clkIgniteTV();
        getDriver().get(System.getProperty("QaUrl")+"/home/ignite-bundles/tv-internet");
        reporter.reportLogWithScreenshot("Launched the TV Bundles Page");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyWelcomeBackPopup(),"Welcome Modal has Launched","Welcome Modal has not Launched");
        getRogersIgniteTVBuyPage().clickContinue();
        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"Launched the cart summary page","Cart summary page has not Launched");
        getRogersIgniteTVBuyPage().set4KTV();
        reporter.reportLogWithScreenshot("4k TV selected");
        getRogersIgniteTVBuyPage().clkCheckout();

        reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(),"Profile page has Launched","Profile page has not Launched");
        getRogersIgniteTVProfileCreationPage().setEmail();
        getRogersIgniteTVProfileCreationPage().setFirstname();
        getRogersIgniteTVProfileCreationPage().setLastName();
        getRogersIgniteTVProfileCreationPage().setPhone();
        reporter.reportLogWithScreenshot("Entered the details on Profile page");
        getRogersIgniteTVProfileCreationPage().clkSubmitProfile();

        reporter.hardAssert(getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage(),"Credit Evaluation page has Launched","Credit Evaluation page has not Launched");
        reporter.reportLogWithScreenshot("Launched the credit evaluation page");
    }

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_igniteanonymous, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


