package com.rogers.test.tests.connectedhome.desktop;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * This class contains the test method to test the HTO SAI flow for Rogers.com
 *
 * @author Manpreet.Kaur3
 *
 * Test steps:
 *
 * 1. Launch Rogers.com Home Page
 * 2. Click on Sign In link
 * 3. Enter Username/Password in the Sign In frame and log in
 * 4. Verify
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
 * 14. Verify One-Time charges and credits be $0
 * 15. Verify Installation details - Ignite Express Setup Header
 * 16. Click on Learn more about Courier Delivery link
 * 17. Click close Ignite Express Setup popup
 * 18. Use Service Address
 * 19. Click I understand checkbox under Activation
 * 20. Click Email radio button to recieve order summary and agreement
 * 21. Verify Agreement Details block
 * 22. Click Acceptable Use Policy checkbox
 * 23. Click I understand checkbox
 * 24. Click on Submit button
 * 25. Verify Order Summary header
 * 26. DB validation
 *
 **/

public class RogersCH_TC_110_SAI_SAIHTO_Validate$0ExpressSetupFee_CourierFulfilment_HotCableCondition_ON_Test extends BaseTestClass {

    @Test(groups = {"RegressionCH",""})
    public void checkTargetedOfferForSAI() {
        getRogersHomePage().clkSignIn();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc110_StandaloneInternetAccount.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc110_StandaloneInternetAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
            reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc110_StandaloneInternetAccount.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account Selected");
       /** if modal title //h2[@translate='EOP.NEW_OFFER_NOTIFICATION.sai.header']
        * click close //button[@data-dtname='x-close-ignite migration-alert']/span
        * or click view my offer //button[@translate='EOP.CTAS.takeMeThere.label']
        **/
        reporter.hardAssert(getRogersAccountOverviewPage().verifySpecialOfferBadge(),"Special Offer Recommendation Badge Available","Special Offer Recommendation Badge not available");
        getRogersAccountOverviewPage().clkSpecialOfferBadge();
        reporter.reportLogWithScreenshot("Clicked on the Special Offer Recommendation Bagde");
        getDriver().findElement(By.xpath("//p[contains(@class,'dsa-billboard__overline')]")).getText();
        reporter.reportLogWithScreenshot("On Promotion Page");



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

