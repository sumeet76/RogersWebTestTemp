package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class RogersCH_Auto_TC106_SAINAC_No_RogersIgniteBundles_Popup_LoggedIn_Cx_after_twenty_mins extends BaseTestClass {
    @Test
    public void RogersCH_Auto_TC106_SAINAC_No_RogersIgniteBundles_Popup_LoggedIn_Cx_after_twenty_mins(){
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc106StandaloneInternetAccount.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc106StandaloneInternetAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
        //reporter.reportLogWithScreenshot("Skip popup");
        //reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc106StandaloneInternetAccount.accountDetails.getBan());
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");

        getRogersHomePage().clkShop();
        getRogersHomePage().clkAboutTVandStreamingLink();
        getRogersTvStreamingPage().clkGetItNowForIgniteTV();
        getRogersHomePage().selectAddressOnFile();
        getRogersHomePage().clkUseAddress();

        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(),"Bundles Page has launched","Bundles Page has not launched");
        getRogersIgniteTVBuyPage().scrollHorizontalToPremier();
        getRogersIgniteTVBuyPage().clkViewMoreDetails("Ignite Premier");
       /** getRogersIgniteTVBuyPage().selectSolarisPremierPackage();
        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is availabe","4KTV radio button is not availabe");
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        getRogersIgniteTVBuyPage().set4KTVNo();
        reporter.reportLogWithScreenshot("4k TV selected");
        getRogersIgniteTVBuyPage().clkCheckout();

        reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(),"Profile page has Launched","Profile page has not Launched");
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersIgniteTVProfileCreationPage().setEmail(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getUsername());
        getRogersIgniteTVProfileCreationPage().setFirstname(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getFirstName());
        getRogersIgniteTVProfileCreationPage().setLastName(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getLastName());
        getRogersIgniteTVProfileCreationPage().setPhone(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getPhoneNumber());
        getRogersIgniteTVProfileCreationPage().clkSubmitProfile();

        reporter.hardAssert(getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage(),"Credit Evalution page has Launched","Credit Evalution page has not Launched");
        reporter.reportLogWithScreenshot("Launched the credit evalution page");
        getRogersIgniteTVCreditCheckPage().selectDOBYear();
        getRogersIgniteTVCreditCheckPage().selectDOBMonth();
        getRogersIgniteTVCreditCheckPage().selectDOBDay();
        reporter.reportLogWithScreenshot("Entered DOB details");
        getRogersIgniteTVCreditCheckPage().selectFirstID("Driver's License");
        getRogersIgniteTVCreditCheckPage().selectProvince("Ontario");
        getRogersIgniteTVCreditCheckPage().selectExpiryYear(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getYear());
        getRogersIgniteTVCreditCheckPage().selectExpiryMonth(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getMonth());
        getRogersIgniteTVCreditCheckPage().selectExpiryDay(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getDate());
        getRogersIgniteTVCreditCheckPage().setDrivingLicense(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getDrivingLicence());
        reporter.reportLogWithScreenshot("Driving License Details");
        getRogersIgniteTVCreditCheckPage().selectSecondIDOption("Birth Certificate");
        getRogersIgniteTVCreditCheckPage().setBirthCertificateNumber(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getBirthCertNumber());
        getRogersIgniteTVCreditCheckPage().clkCreditConsent();
        reporter.reportLogWithScreenshot("Passport Details");
        getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();
**/

    }


    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    //IgniteAnonymous
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_login, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
       // closeSession();
    }

}
