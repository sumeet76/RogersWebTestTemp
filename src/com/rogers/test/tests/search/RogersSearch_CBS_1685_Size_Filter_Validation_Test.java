package com.rogers.test.tests.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import utils.CSVReader;

public class RogersSearch_CBS_1685_Size_Filter_Validation_Test extends BaseTestClass {

    @DataProvider(name = "FilterData", parallel = true)
    public Object[] testData() throws IOException {
        String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterDataSizeFilter.csv";
        List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
        Object[] csvRow = new Object[csvData.size()];
        for (int i = 0; i < csvData.size(); i++) {
            csvRow[i] = csvData.get(i);
        }
        return csvRow;
    }

    @Test(dataProvider = "FilterData", groups = {"Search", "Filter"})
    public void validateSizeFilterSelection(String[] csvRow) {
        boolean isMobile;
        List<WebElement> resultLinks;
        List<String> strSizeOptions;
        String strSelectedSize, gpfilter, pfilter;
        getDriver().get(System.getProperty("SearchUrl") + csvRow[0]);
        getRogersSearchPage().isPageLoaded();
        isMobile = getRogersSearchPage().isMobileSelected();
        if (isMobile) {
            getRogersSearchPage().clkFilterIconMobile();
            reporter.reportLogWithScreenshot("Clicked on Filter Icon");
        }
        gpfilter = getRogersSearchPage().clkShopFilter();
        reporter.reportLogWithScreenshot(gpfilter + " Filter clicked");
        pfilter = getRogersSearchPage().clkWirelessFilter();
        reporter.reportLogWithScreenshot(pfilter + " Filter clicked");
        strSizeOptions = getRogersSearchPage().getSizeSelections();
        reporter.hardAssert(strSizeOptions.size() != 0, "Size Options Available", "Size Options Unavailable");
        for (int i = 0; i < strSizeOptions.size(); i++) {
            getRogersSearchPage().clkSizeType(strSizeOptions.get(i));
            reporter.reportLogWithScreenshot("Size: " + strSizeOptions.get(i) + " is selected");
            if (isMobile) {
                getRogersSearchPage().clkShowResultBtnMobile();
                reporter.reportLogWithScreenshot("Clicked on Show Results button");
            }
            resultLinks = getRogersSearchPage().getAllResultLinks();
            for (int k = 0; k < resultLinks.size(); k++) {
                getRogersSearchPage().clkResultLink(resultLinks.get(k));
                reporter.reportLogWithScreenshot((k + 1) + ": Result link is clicked");
                strSelectedSize = getRogersDeviceConfigPage().getSelectedSize();
                reporter.softAssert(strSelectedSize.equalsIgnoreCase(strSizeOptions.get(i)),
                        "Size Expected=" + strSizeOptions.get(i) + "; Actual=" + strSelectedSize,
                        "Size Expected=" + strSizeOptions.get(i) + "; Actual=" + strSelectedSize);
                getRogersDeviceConfigPage().navigateBack();
                getRogersSearchPage().isPageLoaded();
                resultLinks = getRogersSearchPage().getAllResultLinks();
            }
            if (isMobile) {
                getRogersSearchPage().clkFilterIconMobile();
                reporter.reportLogWithScreenshot("Clicked on Filter Icon");
            }
            getRogersSearchPage().clkSizeType(strSizeOptions.get(i));
            reporter.reportLogWithScreenshot("Size: " + strSizeOptions.get(i) + " is deselected");
            getRogersSearchPage().isPageLoaded();
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


