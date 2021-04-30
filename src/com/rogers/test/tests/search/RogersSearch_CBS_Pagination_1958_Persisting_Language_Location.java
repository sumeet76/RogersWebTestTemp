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

/**
 * This class contains the test method to validate that the selected language is persisted so that user
 * do not land on the 'No results page'.
 *
 * @author naina.agarwal
 **/

public class RogersSearch_CBS_Pagination_1958_Persisting_Language_Location extends BaseTestClass {

    @DataProvider(name = "FilterData", parallel = true)
    public Object[] testData() throws IOException {
        String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterData.csv";
        List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
        Object[] csvRowStrArray = new Object[csvData.size()];
        for (int i = 0; i < csvData.size(); i++) {
            csvRowStrArray[i] = csvData.get(i);
        }
        return csvRowStrArray;
    }

    @Test(dataProvider = "FilterData", groups = {"Search", "Pagination", "Sanity"})
    @Parameters({"strLanguage"})
    public void contextPageValidation(String[] csvRowStrArray) throws UnsupportedEncodingException {
        String languageBeforeToggle;
        String currentURL, freshCurrentURL;
        reporter.reportLogWithScreenshot("Search URL is launched");
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot("Page is loaded");
        getRogersSearchPage().clickSearchIcon();
        getRogersSearchPage().enterTextToBeSearched(csvRowStrArray[0]);
        reporter.reportLogWithScreenshot("Search string " + csvRowStrArray[0] + " is entered in the search text box");
        getRogersSearchPage().clickSubmitSearchIcon();
        getRogersSearchPage().waitTime();
        reporter.reportLogPass(getRogersSearchPage().getSearchResults() + " are displayed");
        languageBeforeToggle = getRogersSearchPage().toggleLanguage();
        reporter.reportLogWithScreenshot("Clicked on Toggle Language : Language displayed before on the toggle was " + languageBeforeToggle);
        currentURL = getDriver().getCurrentUrl();
        reporter.softAssert(getRogersSearchPage().validateLanguageInUrl(languageBeforeToggle), "URL reflects correct language after language toggle. Expected language is " + languageBeforeToggle + " The new url is " + currentURL, "URL reflects correct language after language toggletoggle. Expected language is " + languageBeforeToggle + " The new url is " + currentURL);
        String newURL = getRogersSearchPage().updateURLWithDifferentLanguage();
        reporter.reportLogPassWithScreenshot("Language is changed in the URL, the new URL is: " + newURL);
        reporter.softAssert(getRogersSearchPage().checkLanguageDisplayedOnPage(), "Language on the Toggle is reflected correctly after URL change", "Languae on the toggle not reflected correctly after URL change");
        currentURL = getDriver().getCurrentUrl();
        languageBeforeToggle = getRogersSearchPage().toggleLanguage();
        freshCurrentURL = getDriver().getCurrentUrl();
        reporter.reportLogWithScreenshot("Clicked on Toggle Language : Language before toggle was " + languageBeforeToggle + " and URL is" + freshCurrentURL);
        reporter.softAssert(getRogersSearchPage().validateLanguageInUrl(languageBeforeToggle), "URL reflects correct language after language toggle. Expected language is " + languageBeforeToggle + " The new url is " + currentURL, "URL reflects correct language after language toggletoggle. Expected language is " + languageBeforeToggle + " The new url is " + currentURL);
        getDriver().navigate().back();
        reporter.reportLogPassWithScreenshot("Clicked on the back button on browser");
        if (getDriver().getCurrentUrl().equals(currentURL))
            reporter.reportLogPass("The previous selected state in the URL is displayed ");
        else
            reporter.reportLogFail("The previous selected state in the URL is not displayed ");
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("SearchUrl"), strBrowser, strLanguage, RogersEnums.GroupName.search, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
