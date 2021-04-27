package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.CSVReader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RogersSearch_CBS_1704_URL_Persist_Selected_State_Test extends BaseTestClass {

    @DataProvider(name = "FilterData", parallel = false)
    public Object[] testData() throws IOException {
        String csvFileName = null;
        String language = getRogersSearchPage().getSystemLanguage().toLowerCase();
        switch (language) {
            case "en":
                csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterData.csv";
                break;
            case "fr":
                csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterDataFR.csv";
                break;
        }
        List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
        Object[] csvRowStrArray = new Object[csvData.size()];
        for (int i = 0; i < csvData.size(); i++) {
            csvRowStrArray[i] = csvData.get(i);
        }
        return csvRowStrArray;
    }

    @Test(dataProvider = "FilterData", groups = {"Search", "Filter"})
    public void urlPersistSelectedState(String[] csvRowStrArray) throws UnsupportedEncodingException {
        String strCurrentUrl, grandParentFilter, strParentFilterName;
        List<WebElement> lstParentFilters;
        List<String> strColorFilters, strStorageFilters, deviceFilters, brandFilters;
        String[] myArrayColor, myArrayStorage, myArrayBrand, myArrayDevice;
        ArrayList<String> listArrayColor, listArrayDevice, listArrayBrand, listArrayStorage;
        reporter.reportLogWithScreenshot("Launching URL");
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot("Page is launched");
        getRogersSearchPage().clickSearchIcon();
        getRogersSearchPage().enterTextToBeSearched(csvRowStrArray[0]);
        reporter.reportLogWithScreenshot("Search string " + csvRowStrArray[0] + " is entered in the search text box");
        getRogersSearchPage().clickSubmitSearchIcon();
        getRogersSearchPage().isPageLoaded();
        grandParentFilter = csvRowStrArray[1];
        getRogersSearchPage().clkGrandParentFilter(grandParentFilter);
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot(grandParentFilter + " grandparent filter is clicked");
        lstParentFilters = getRogersSearchPage().getParentFilters(csvRowStrArray[1]);
        int size = lstParentFilters.size();
        getRogersSearchPage().clkParentFilter(lstParentFilters.get(size - 1));
        getRogersSearchPage().isPageLoaded();
        strParentFilterName = lstParentFilters.get(size - 1).getText();
        reporter.reportLogWithScreenshot(strParentFilterName + " parent filter is selected");
        reporter.softAssert(getRogersSearchPage().validateFiltersInUrl(grandParentFilter, strParentFilterName),
                "URL is appended with correct filters", "URL is not appended with correct filters");
        strCurrentUrl = getDriver().getCurrentUrl();
        getDriver().get("about:blank");
        reporter.reportLogWithScreenshot("Blank Page Launched");
        getDriver().get(strCurrentUrl);
        getRogersSearchPage().waitTime();
        reporter.reportLogWithScreenshot("Browser re-launched with url - " + strCurrentUrl);
        reporter.softAssert(getRogersSearchPage().isGrandParentFilterExpanded(grandParentFilter),
                "Grandparent filter expanded: " + grandParentFilter, "Grandparent filter Not expanded: " + grandParentFilter);
        reporter.softAssert(getRogersSearchPage().isParentFilterExpanded(strParentFilterName), "Parent filter expanded: " + strParentFilterName, "Parent filter Not expanded: " + strParentFilterName);
        grandParentFilter = getRogersSearchPage().clkShopFilter();
        reporter.reportLogWithScreenshot(grandParentFilter + " grandparent filter is clicked");
        strParentFilterName = getRogersSearchPage().clkWirelessFilter();
        reporter.reportLogWithScreenshot(strParentFilterName + " parent filter is selected");
        reporter.softAssert(getRogersSearchPage().validateFiltersInUrl(grandParentFilter, strParentFilterName),
                "URL is appended with correct filters", "URL is not appended with correct filters");
        strColorFilters = getRogersSearchPage().getColorFilters();
        listArrayColor = getRogersSearchPage().filters(strColorFilters, "Color");
        myArrayColor = new String[listArrayColor.size()];
        reporter.softAssert(getRogersSearchPage().validateColorsInUrl(myArrayColor),
                "Colors appended in URL", "Colors not appended in URL");
        strStorageFilters = getRogersSearchPage().getStorageSelections();
        listArrayStorage = getRogersSearchPage().filters(strStorageFilters, "Storage");
        myArrayStorage = new String[listArrayStorage.size()];
        reporter.softAssert(getRogersSearchPage().validateStoragesInUrl(myArrayStorage),
                "Storage appended in URL", "Storage not appended in URL");
        strCurrentUrl = getDriver().getCurrentUrl();
        getDriver().get("about:blank");
        reporter.reportLogWithScreenshot("Blank Page Launched");
        getDriver().get(strCurrentUrl);
        getRogersSearchPage().waitTime();
        reporter.reportLogWithScreenshot("Browser re-launched with url - " + strCurrentUrl);
        reporter.hardAssert(getRogersSearchPage().isGrandParentFilterExpanded(grandParentFilter),
                "Grandparent filter expanded: " + grandParentFilter, "Grandparent filter Not expanded: " + grandParentFilter);
        reporter.hardAssert(getRogersSearchPage().isParentFilterExpanded(strParentFilterName), "Parent filter expanded: " + strParentFilterName, "Parent filter Not expanded: " + strParentFilterName);
        for (int i = 0; i < listArrayColor.size(); i++) {
            reporter.softAssert(getRogersSearchPage().isFilterChecked(strColorFilters.get(i)
            ), strColorFilters.get(i) + " is Checked", strColorFilters.get(i) + " is Not Checked");
        }
        for (int i = 0; i < listArrayStorage.size(); i++) {
            reporter.softAssert(getRogersSearchPage().isFilterChecked(strStorageFilters.get(i)),
                    strStorageFilters.get(i) + " is Checked", strStorageFilters.get(i) + " is Not Checked");
        }
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