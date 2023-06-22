package com.rogers.test.tests.connectedhome.desktop.hto;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to test the Deeplink HTO SAI flow for Rogers.com
 * TC032_CH-16493_CH-16905- legacy 1P INT_HTO migration_deep link_ Multiple account_After signing_
 * account selection and choose the targetted offers account_validate the HTO offer on the new Account Overview Page in a banner_ E2E_ON
 * @author Manpreet.Kaur3
 *
 * Test steps:
 *
 * 1. Launch Deep link URL
 * 2. Enter Username and click on continue
 * 3. Enter Password and log in
 * 4. Enter verification code for MFA through ENS protal
 * 5. Select Account
 * 6. Verify and click on special recommendation yellow badge
 * 7. Verify Special Offer text
 * 8. Verify old and new package text
 * 9. Click on Learn More link
 * 10. Click View Next Feature button
 * 10. Click Close button
 * 11. Click on I want this Upgrade checkbox
 * 12. Click on review your upgrade
 * 13. Verify Order Review header
 * 14. Click I understand checkbox under Activation
 * 15. Click Email radio button to recieve order summary and agreement
 * 16. Verify Agreement Details block
 * 17. Click Acceptable Use Policy checkbox
 * 18. Click I understand checkbox
 * 19. Click on Submit button
 * 20. Verify Order Confirmation Page
 *
 **/

public class RogersCH_Auto_TC120_1pLeg_DeepLink_HTO_Recommended_MultipleAccount_ValidateOfferTest extends BaseTestClass {

    @Test(groups = {"RegressionCH",""})
    public void rogersCH_Auto_TC120_1pLeg_DeepLink_HTO_Recommended_MultipleAccount_ValidateOffer() {
        reporter.reportLogWithScreenshot("Launched the Deeplink");
        getDriver().get(System.getProperty("QaUrl")+"/home/hto-eop");
        reporter.reportLogWithScreenshot("Launched the SignIn popup through deeplink");

        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc81_StandaloneInternetAccount.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc81_StandaloneInternetAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");

        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
            reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc81_StandaloneInternetAccount.getAccountDetails().getBan());
            reporter.reportLogWithScreenshot("Account Selected");
        }

        if (getRogersAccountOverviewPage().isNewOfferModalDisplayed()) {
            reporter.reportLogWithScreenshot("New Offer Modal Popup");
            getRogersAccountOverviewPage().clkCloseNewOfferModalPopup();
            reporter.reportLogWithScreenshot("New Offer Modal Popup closed");
        }

        reporter.hardAssert(getRogersAccountOverviewPage().verifySpecialOfferBadge(),"Special Offer Recommendation Badge Available","Special Offer Recommendation Badge not available");
        getRogersAccountOverviewPage().clkSpecialOfferBadge();
        reporter.reportLogWithScreenshot("Clicked on the Special Offer Recommendation Bagde");

        reporter.hardAssert(getRogersHTOPRomotionPage().verifyPromotionPage(),"Promotion Page Available","Promotion Page not available");
        reporter.reportLogWithScreenshot("On Promotion Page");
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyCurrentBundle(),"Old Bundle details Available","Old Bundle details not Available");
        reporter.reportLogWithScreenshot("Verified Old bundle Details");
        reporter.hardAssert(getRogersHTOPRomotionPage().verifyOfferBundle(),"New Bundle details Available","New Bundle details not Available");
        reporter.reportLogWithScreenshot("Verified New bundle Details");

        String offerPrice = getRogersOrderReviewPage().getOfferPrice();
        System.out.println(offerPrice);

        getRogersHTOPRomotionPage().clickIWantThisUpgrade();
        reporter.reportLogWithScreenshot("Clicked on the Upgrade checkbox");
        getRogersHTOPRomotionPage().clickReviewYourUpgrade();
        reporter.reportLogWithScreenshot("Clicked on Review Your Upgrade button");

        reporter.hardAssert(getRogersOrderReviewPage().verifyTargetedOfferOrderReviewPage(),"Order Review Page has launched","Order Review Page has not launched");
        reporter.reportLogWithScreenshot("Launched the order review page");

        String customPrice = getRogersOrderReviewPage().getCustomPrice();
        System.out.println(customPrice);

        reporter.hardAssert(getRogersHTOPRomotionPage().verifyBundleOfferPrice(offerPrice, customPrice),"Price match","Price unmatch");
        reporter.reportLogWithScreenshot("Price match on Order review page with promo page");

        getRogersOrderReviewPage().clkActivationCheckbox();
        reporter.reportLogWithScreenshot(" Clicked on Activation Checkbox");

        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");

        getRogersOrderReviewPage().clkAgreementCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");

        
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

