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

public class RogersSearch_CBS_1732_Refreshing_Results_Based_On_The_Search_Terms_Test extends BaseTestClass {
    @DataProvider(name = "FilterData")
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
    public void validateResultsBasedOnSearchTerms(String[] csvRow) {

        List<String> strSuggestionOptions;
        String strPrevLeftPaneInnerhtml = null;
        String strPrevSupportInnerHtml = null;
        String strCurLeftPaneInnerhtml = null;
        String strCurSupportInnerHtml = null;
        boolean blnPrevLeftPane = false;
        boolean blnPrevSupport = false;
        boolean blnCurLeftPane = false;
        boolean blnCurSupport = false;

        getDriver().get(System.getProperty("SearchUrl"));
        reporter.reportLogWithScreenshot("CBS Search Page");

        rogers_search_page.enterTextSearch(csvRow[0]);
        reporter.reportLogWithScreenshot("Search field entered");
        reporter.hardAssert(rogers_search_page.isSuggestionsSectionDisplayed(),
                "Suggestions Section Visible", "Suggestions Section Not Visible");
        reporter.hardAssert(rogers_search_page.isSupportSectionDisplayed(),
                "Support Section Visible", "Support Section Not Visible");

        strSuggestionOptions = rogers_search_page.getSuggestionSelections();
        reporter.hardAssert(strSuggestionOptions.size()!=0,
                "Suggestions Displayed","Suggestions Not Displayed");
        for(int j=0;j< strSuggestionOptions.size();j++) {
            rogers_search_page.hoverSuggestionsType(strSuggestionOptions.get(j));
            reporter.reportLogWithScreenshot("Hovered on " +strSuggestionOptions.get(j));
            blnCurLeftPane = rogers_search_page.isLeftSectionPopulated();
            blnCurSupport = rogers_search_page.isSupportSectionPopulated();
            if(blnCurSupport || blnCurLeftPane) {
                strCurLeftPaneInnerhtml = rogers_search_page.getLeftSectionInnerhtml();
                strCurSupportInnerHtml = rogers_search_page.getSupportInnerhtml();
                if(j!=0){
                    if(blnPrevLeftPane) {
                        reporter.softAssert(!(strCurLeftPaneInnerhtml.equals(strPrevLeftPaneInnerhtml)),
                                "Left pane results refreshed","Left pane results not refreshed");
                    }
                    if(blnPrevSupport) {
                        reporter.softAssert(!(strCurSupportInnerHtml.equals(strPrevSupportInnerHtml)),
                                "Support links refreshed","Support links not refreshed");
                    }
                }
                strPrevLeftPaneInnerhtml = strCurLeftPaneInnerhtml;
                strPrevSupportInnerHtml = strCurLeftPaneInnerhtml;
            } else {
                reporter.reportLogFailWithScreenshot("Both Left and Support sections are not displayed");
            }
            blnPrevLeftPane = blnCurLeftPane;
            blnPrevSupport = blnCurSupport;
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