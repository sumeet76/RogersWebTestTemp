package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to test the 3P Nac flow with DST till cart summary page for Rogers.com
 * TC034_CH-15483_CH-17157_DST_Validate DST For DOCSIS_3P NAC_validate recommeded rate card_Validate flex channel filter and
 * pre-selected flex channels heading is applied by default in the flex channel modal_ON_Edge_EN
 *
 * @author manpreet.kaur3
 * <p>
 * Test steps:
 * <p>
 * 1. Launch Rogers.com
 * 2. Browse to Shop menu and select Ignite TV option
 * 3. Click 'Get it now'
 * 4. Enter home address to validate the serviceability and click on Check Availability
 * 5. Click 'Take a quiz' and select desired options to get the Best Fit recommendation
 * 6. For the best fit Bundle suggested through DST, check total channels count and flex chaanels count
 * 7. Click Total Channels and validate Flex Channels filter in the dropdown, close popup
 * 8. Click Flex Channels and validate `Preselected Flex Channels` text, close popup
 * 9. Click Add to cart
 * 10. Click Skip new number
 * 11. Click on Continue in Home phone add ons page
 * 12. Validate the total channels and flex channles count are unified(with offers page) on cart summary page
 * 13. Click Total channnels and hover 4K channels, close popup
 * 14. Click Flex channnels and hover Pre-selected channels, close popup
 **/

public class RogersCH_Auto_TC104_3PNAC_ValidateDST_ValidateFlexFilterAndPreSelectedFlexHeaderTest extends BaseTestClass {

    @Test
    public void rogersCH_Auto_TC104_3PNAC_ValidateDST_ValidateFlexFilterAndPreSelectedFlexHeader() {
        reporter.reportLogWithScreenshot("Launched the Main QA Page");
        getDriver().get(System.getProperty("QaUrl")+"/bundles/offers?env=qa");
        reporter.reportLogWithScreenshot("Launched the IgniteTV page for ON region with DST");
       // getRogersHomePage().clkServiceability();
        reporter.reportLogWithScreenshot("Launched the customer availability check popup");
        String  strAddressLine1=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1 + "," + strAddressLine2);
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Entered Serviceability address");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(), "Bundles Page has launched", "Bundles Page has not launched");

        getRogersIgniteTVBuyPage().clkTaketheQuiz();
        reporter.reportLogWithScreenshot("Clicked on Take the Quiz");
        getRogersIgniteTVBuyPage().clkLiveTVChannels();
        getRogersIgniteTVBuyPage().clkLiveSports();
        getRogersIgniteTVBuyPage().clkFlexibleChannels();
        getRogersIgniteTVBuyPage().clkMobileApp();
        reporter.reportLogWithScreenshot("Selected entertainment features");
        getRogersIgniteTVBuyPage().clkDSTContinue();
        reporter.reportLogWithScreenshot("Clicked on DST Continue to next question");
        getRogersIgniteTVBuyPage().clkFourStarsNetworkCategory();
        getRogersIgniteTVBuyPage().clkFourStarsNewsCategory();
        getRogersIgniteTVBuyPage().clkFourStarsEntertainmentCategory();
        getRogersIgniteTVBuyPage().clkFourStarsLifestyleCategory();
        reporter.reportLogWithScreenshot("Rated channel categories according to preference");
        getRogersIgniteTVBuyPage().clkDSTContinue();
        reporter.reportLogWithScreenshot("Clicked on DST Continue to next question");
        getRogersIgniteTVBuyPage().clkInternetDevices();
        reporter.reportLogWithScreenshot("Selected Internet Devices");
        getRogersIgniteTVBuyPage().clkDSTContinue();
        reporter.reportLogWithScreenshot("Clicked on DST Continue to next question");
        getRogersIgniteTVBuyPage().clkAddHomePhoneDST();
        reporter.reportLogWithScreenshot("Added Home Phone");
        getRogersIgniteTVBuyPage().clkDSTContinue();
        reporter.reportLogWithScreenshot("Clicked on DST Continue to next question");
		reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBestFit(),"Best Fit verified" ,"Best Fit not verified");
        getRogersIgniteTVBuyPage().clkDSTClose();
        reporter.reportLogWithScreenshot("Closed the DST Recommendation");
		getRogersIgniteTVBuyPage().VerifyYourBestFit();
        reporter.reportLogWithScreenshot("Recommended pack is displayed");
        String bundleName = "Ignite Flex 10";
        String totalChannels  = getRogersIgniteTVBuyPage().getTotalChannelCount(bundleName);
        String flexChannels = getRogersIgniteTVBuyPage().getFlexChannelCount(bundleName);
        getRogersIgniteTVBuyPage().clkTotalChannels(bundleName);
        reporter.reportLogWithScreenshot("Clicked on Total Channels channels link");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyFlexChannelsPresentInGenre(), "Flex Channels verified in the filters","Flex Channels not verified in the filters");
        getRogersIgniteTVBuyPage().clkCloseChannelsPopup();
        reporter.reportLogWithScreenshot("Clicked on Close Total Channels popup Modal");
        getRogersIgniteTVBuyPage().clkFlexChannels(bundleName);
        reporter.reportLogWithScreenshot("Clicked on Flex channels link");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyFlexChannelsHeader(), "PreSelected Flex Channels header verified","PreSelected Flex Channels header not verified");
        getRogersIgniteTVBuyPage().clkCloseChannelsPopup();
        getRogersIgniteTVBuyPage().selectSolarisPackage(bundleName);

        reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPortInOutPage(), "Port-InOut page has Launched", "Port-InOut page has not Launched");
        reporter.reportLogWithScreenshot("Launched the home phone selection page");
        getRogersHomePhoneSelectionPage().clkSkipforNewNumber();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        getRogersIgniteTVBuyPage().clkHomePhone();
        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is available","4KTV radio button is not available");
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyTotalChannelCount(totalChannels),"Total Channels Count verified","Total Channels Count verification failed");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyFlexChannelCount(flexChannels),"Flex Channels Count verified","Flex Channels Count verification failed");
        getRogersIgniteTVBuyPage().clkViewTotalChannels();
        reporter.reportLogWithScreenshot("View Total Channels");
        getRogersIgniteTVBuyPage().clkHover4kChannels();
        reporter.reportLogWithScreenshot("what are flex channels Hover message ");
        getRogersIgniteTVBuyPage().clkHoverClose();
        reporter.reportLogWithScreenshot("Close Total Channels popup");
        getRogersIgniteTVBuyPage().clkViewFlexChannels();
        reporter.reportLogWithScreenshot("View Flex Channels");
        getRogersIgniteTVBuyPage().clkHoverPreSelectedChannels();
        reporter.reportLogWithScreenshot("Pre Selected Channels Hover message");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyFlexChannelsHeader(), "PreSelected Flex Channels header verified","PreSelected Flex Channels header not verified");
        getRogersIgniteTVBuyPage().clkHoverClose();
        reporter.reportLogWithScreenshot("Close Flex Channels popup");

    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    //IgniteAnonymous
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_igniteanonymous, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }


}


