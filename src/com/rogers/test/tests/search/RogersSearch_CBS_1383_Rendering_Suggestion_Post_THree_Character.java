package com.rogers.test.tests.search;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

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

public class RogersSearch_CBS_1383_Rendering_Suggestion_Post_THree_Character extends BaseTestClass {

    @Test
    public void validateLabelVisible() {
        getDriver().get(System.getProperty("SearchUrl"));
        reporter.reportLogWithScreenshot("CBS Search Page");
        rogers_search_page.enterTextSearch("w");
        reporter.reportLogWithScreenshot("Search field entered with one character");
        reporter.hardAssert(!rogers_search_page.isSuggestionsSectionDisplayed(), "label Suggestion Not Visible", "label Suggestion Visible");
        reporter.hardAssert(!rogers_search_page.isSupportSectionDisplayed(), "label Support Not Visible", "label Support Visible");
        rogers_search_page.enterTextSearch("wi");
        reporter.reportLogWithScreenshot("Search field entered with two characters");
        reporter.hardAssert(!rogers_search_page.isSuggestionsSectionDisplayed(), "label Suggestion Not Visible", "label Suggestion Visible");
        reporter.hardAssert(!rogers_search_page.isSupportSectionDisplayed(), "label Support Not Visible", "label Support Visible");
        rogers_search_page.enterTextSearch("wir");
        reporter.hardAssert(rogers_search_page.isSuggestionsSectionDisplayed(), "label Suggestion Visible", "label Suggestion Not Visible");
        reporter.hardAssert(rogers_search_page.isSupportSectionDisplayed(), "label Support Visible", "label Support Not Visible");
        reporter.reportLogWithScreenshot("Search field entered with three Character");
        reporter.reportLogWithScreenshot("Search Label Validation");
        reporter.hardAssert(rogers_search_page.isSupportSectionPopulated(), "Suggestion Links Visible", "Suggestion Links  Not Visible");
        reporter.hardAssert(rogers_search_page.isLeftSectionPopulated(), "Support Links  Visible", " Support Links Not Visible");
        reporter.reportLogWithScreenshot("Link Validation");
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