package com.rogers.test.tests.connectedhome.desktop.tv;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Load Rogers.com Url
 * Click on Sign in button and login with valid login details.
 * Select TV badge
 * Click on exchange flex channels
 * Remove any flex channel and choose another flex channel that is already available in the standalone package
 * Click on exchange button --> Delete duplicate channel pop-up is displayed
 * Click on continue or close button --> Duplicate channels should be deleted successfully as requested
 */

public class RogersCH_Auto_TC110_SolarisTVCx_2P_ValidateDuplicateFlexChannel extends BaseTestClass {

    @Test(groups = {"Regression"})
    public void RogersCH_Auto_TC010_SolarisTVCx_2P_ValidateDuplicateFlexChannel()  {

        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc14_SolarisTVAccountFlex5Package.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc14_SolarisTVAccountFlex5Package.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().clkEmailToAsRecoveryOption();
        //reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
       // reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
      //  getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc14_SolarisTVAccountFlex5Package.accountDetails.getBan());
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersSolarisTVDashboardPage().clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dash board");
        getRogersSolarisTVDashboardPage().clkViewfelxChannels();
        List<WebElement> elements = getDriver().findElements(By.xpath("//div[@class='channel-component']//button"));
        Set<String> flexChannels = new HashSet<>();

        for (WebElement ele:elements) {
            try {
                flexChannels.add(ele.getAttribute("id"));System.out.println(ele.getText());
            }catch (StaleElementReferenceException exception){}
        }
        reporter.reportLogWithScreenshot("Fetch the list of existing flex channels");
        getRogersSolarisTVDashboardPage().clkCloseChannelsPopup();
        getRogersSolarisTVDashboardPage().clkViewMyChannelLineup();
        List<WebElement> elements1 = getDriver().findElements(By.xpath("//div[@class='channel-component']//button"));
        Set<String> myChannelLineup = new HashSet<>();
        for (WebElement ele:elements1) {
            try {
                myChannelLineup.add(ele.getAttribute("id"));
            }catch (StaleElementReferenceException exception){
                break;
            }
        }

        getRogersSolarisTVDashboardPage().clkCloseChannelsPopup();
        getRogersSolarisTVDashboardPage().clkChangeFlexChannels();

        reporter.reportLogWithScreenshot("Verify Exchange channel page");
        getRogersSolarisChannelsExchangePage().verifyExchangeChannelPage();
        Set<String> availableChannels = getRogersSolarisChannelsExchangePage().getFlexChannelsListFromExchangeFlexChannels();
        availableChannels.removeAll(flexChannels);
        Set<String> duplicateChannels = new HashSet();
        for (String name : availableChannels ) {
            if(myChannelLineup.contains(name)){
                duplicateChannels.add(name);
            }
        }
        System.out.println("Duplicate Channels : " + duplicateChannels.stream().findFirst().get());
        //uncheck Existing flex channel to select the duplicate channel
        getRogersSolarisChannelsExchangePage().selectOrUnselectChannel(flexChannels.stream().findFirst().get());
        reporter.reportLogWithScreenshot("removed the flex channel");
        getRogersSolarisChannelsExchangePage().selectOrUnselectChannel(duplicateChannels.stream().findFirst().get());
        reporter.reportLogWithScreenshot("Clicked on the duplicate channel");
        getRogersSolarisChannelsExchangePage().clkConfirmExchange();
        reporter.reportLogWithScreenshot("Clicked on the Confirm Exchange, Duplicate Popup");
        getRogersSolarisChannelsExchangePage().clkContinueToDeleteDuplicateChannel();
        getRogersSolarisChannelsExchangePage().verifyExchangeSuccess();
        reporter.reportLogWithScreenshot("Verify success button");
        getRogersSolarisChannelsExchangePage().clkReturnToDashbaord();
        reporter.reportLogWithScreenshot("Clicked on the return to dashboard");
    }

    @BeforeMethod(alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    //login flow
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws  IOException {
        startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_login, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
