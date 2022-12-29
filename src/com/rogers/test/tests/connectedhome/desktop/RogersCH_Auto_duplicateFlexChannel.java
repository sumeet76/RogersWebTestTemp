package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
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

public class RogersCH_Auto_duplicateFlexChannel extends BaseTestClass {

    @Test
    public void duplicateChannelCheck() throws InterruptedException {

        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc14_SolarisTVAccountFlex5Package.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc14_SolarisTVAccountFlex5Package.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
        //reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        //getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc14_SolarisTVAccountFlex5Package.accountDetails.getBan());
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
                myChannelLineup.add(ele.getAttribute("id"));System.out.println(ele.getAttribute("id"));
            }catch (StaleElementReferenceException exception){
                break;
            }
        }

        getRogersSolarisTVDashboardPage().clkCloseChannelsPopup();
        getRogersSolarisTVDashboardPage().clkChangeFlexChannels();
        System.out.println("*************************************");
        reporter.reportLogWithScreenshot("");
        //Thread.sleep(10000);
        getRogersSolarisChannelsExchangePage().verifyExchangeChannelPage();
        Set<String> availableChannels = getRogersSolarisChannelsExchangePage().getFlexChannelsListFromExchangeFlexChannels();
        System.out.println("******");
        System.out.println("Before removal " + availableChannels.size());
        availableChannels.removeAll(flexChannels);
        System.out.println("After removal " + availableChannels.size());
        Set<String> duplicateChannels = new HashSet();
        for (String name : availableChannels ) {
            if(myChannelLineup.contains(name)){
                duplicateChannels.add(name);
            }
        }
        System.out.println(duplicateChannels);

        System.out.println("//div[@class='cl-button' and @id='"+flexChannels.stream().findFirst().get()+"']");
        //uncheck Existing flex channel to select the duplicate channel
        //getDriver().findElement(By.xpath("//div[@class='cl-button' and @id='"+flexChannels.stream().findFirst().get()+"']")).click();
        getRogersSolarisChannelsExchangePage().selectOrUnselectChannel(flexChannels.stream().findFirst().get());
        reporter.reportLogWithScreenshot("removed the flex channel");
        //getDriver().findElement(By.xpath("//div[@class='cl-button' and @id='"+duplicateChannels.stream().findFirst().get()+"']")).click();
        getRogersSolarisChannelsExchangePage().selectOrUnselectChannel(duplicateChannels.stream().findFirst().get());
        reporter.reportLogWithScreenshot("Clicked on the duplicate channel");
        getRogersSolarisChannelsExchangePage().clkConfirmExchange();
        reporter.reportLogWithScreenshot("Clicked on the Confirm Exchange, Duplicate Popup");
        getRogersSolarisChannelsExchangePage().clkContinueToDeleteDuplicateChannel();
        reporter.reportLogWithScreenshot("Verify success button");
        getRogersSolarisChannelsExchangePage().verifyExchangeSuccess();
    }

    @BeforeMethod(alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    //login flow
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_login, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
