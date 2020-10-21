package com.rogers.test.tests.search;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;

import utils.CSVReader;

public class RogersSearch_CBS_1741_Search_Box_Close_Icon_Test extends BaseTestClass {

    @Test
    public void validateSearchBoxCloseIcon() {

        getDriver().get(System.getProperty("SearchUrl"));
        reporter.reportLogWithScreenshot("CBS Search Page");
        rogers_search_page.enterTextSearch("wireless");
        reporter.reportLogWithScreenshot("Search field entered");
        reporter.hardAssert(rogers_search_page.validateLabelVisible("Suggestions"), "label Suggestion Visible", "label Suggestion Not Visible");
        reporter.hardAssert(rogers_search_page.validateLabelVisible("Support"), "label Support Visible", "label Support Not Visible");
        reporter.reportLogWithScreenshot("Search Label Validation");
        if(rogers_search_page.validateLinksVisible("Suggestions") || rogers_search_page.validateLinksVisible("Support")) {
            reporter.reportLogPassWithScreenshot("Suggestion or Supports populated");
        } else {
            reporter.reportLogFailWithScreenshot("Suggestion and Support not populated");
        }
        rogers_search_page.clkCloseSearchIcon();
        reporter.hardAssert(rogers_search_page.validateSearchBoxIsEmpty(), "Search Box is Empty", "Search Box is not Empty");
        reporter.reportLogWithScreenshot("Search field reset");
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("SearchUrl") + "wireless", strBrowser, strLanguage, RogersEnums.GroupName.search, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}