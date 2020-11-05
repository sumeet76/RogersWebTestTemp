package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.CSVReader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class RogersSearch_CBS_1734_Typeahead_Result_Links_Test extends BaseTestClass {
    @DataProvider(name = "FilterData",parallel=true)
    public Object[] testData() throws IOException
    {
        String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/SearchBoxText1732.csv";
        List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
        Object[] csvRow = new Object[csvData.size()];

        for(int i =0; i < csvData.size();i++){
            csvRow[i] = csvData.get(i);
        }
        return csvRow;
    }

    @Test(dataProvider = "FilterData")
    public void validateResultsBasedOnSearchTerms(String[] csvRow) throws UnsupportedEncodingException {

        List<String> strSuggestionOptions;
        boolean blnCurLeftPane = false;
        boolean blnCurSupport = false;

        getDriver().get(System.getProperty("SearchUrl"));
        reporter.reportLogWithScreenshot("CBS Search Page");

        getRogersSearchPage().enterTextSearch(csvRow[0]);
        reporter.reportLogWithScreenshot("Search field entered");
        reporter.hardAssert(getRogersSearchPage().isSuggestionsSectionDisplayed(),
                "Suggestions Section Visible", "Suggestions Section Not Visible");
        reporter.hardAssert(getRogersSearchPage().isSupportSectionDisplayed(),
                "Support Section Visible", "Support Section Not Visible");

        strSuggestionOptions = getRogersSearchPage().getSuggestionSelections();
        reporter.hardAssert(strSuggestionOptions.size()!=0,
                "Suggestions Displayed","Suggestions Not Displayed");
        for(int j=0;j< strSuggestionOptions.size();j++) {
            getRogersSearchPage().hoverSuggestionsType(strSuggestionOptions.get(j));
            reporter.reportLogWithScreenshot("Hovered on " +strSuggestionOptions.get(j));
            blnCurLeftPane = getRogersSearchPage().isLeftSectionPopulated();
            blnCurSupport = getRogersSearchPage().isSupportSectionPopulated();
            if(blnCurSupport) {
                reporter.softAssert(getRogersSearchPage().validateSupportLinks(),
                        "All Support Results are Links","All Support Results are Not Links");
            }
            if(blnCurSupport || blnCurLeftPane) {
                getRogersSearchPage().clkSuggestionsType(strSuggestionOptions.get(j));
                reporter.hardAssert(getRogersSearchPage().validateURLContains(strSuggestionOptions.get(j)),
                        "Result Landing Page displayed", "Result Landing Page not displayed");
                reporter.reportLogWithScreenshot("Landing page for suggested result click");
            } else {
                reporter.reportLogFailWithScreenshot("Both Left and Support sections are not displayed");
            }
            getRogersSearchPage().enterTextSearch(csvRow[0]);
        }
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