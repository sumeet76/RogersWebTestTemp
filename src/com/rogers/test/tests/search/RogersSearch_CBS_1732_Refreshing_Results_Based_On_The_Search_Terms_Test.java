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
            if(blnCurSupport || blnCurLeftPane) {
                strCurLeftPaneInnerhtml = getRogersSearchPage().getLeftSectionInnerhtml();
                strCurSupportInnerHtml = getRogersSearchPage().getSupportInnerhtml();
                if(j!=0){
                    boolean leftPaneRefreshStatus = true;
                    boolean supportPaneRefreshStatus = true;
                    if(blnPrevLeftPane) {
                        if(strCurLeftPaneInnerhtml.equals(strPrevLeftPaneInnerhtml)){
                            leftPaneRefreshStatus=false;
                        }
                    }
                    if(blnPrevSupport) {
                        if(strCurSupportInnerHtml.equals(strPrevSupportInnerHtml)){
                            supportPaneRefreshStatus=false;
                        }
                    }
                    String refreshedPaneStatus="";
                    if (leftPaneRefreshStatus==true&&supportPaneRefreshStatus==true)
                        refreshedPaneStatus= "Results on both the panes have refreshed";
                    else if(leftPaneRefreshStatus!=true&&supportPaneRefreshStatus!=true)
                        refreshedPaneStatus= "Results on neither of the panes have refreshed";
                    else if(leftPaneRefreshStatus==true)
                        refreshedPaneStatus= "Results on the left pane has refreshed";
                    else if(supportPaneRefreshStatus==true)
                        refreshedPaneStatus= "Results on the support pane has refreshed";


                    reporter.softAssert(!(leftPaneRefreshStatus==false&&supportPaneRefreshStatus==false),refreshedPaneStatus,refreshedPaneStatus);
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