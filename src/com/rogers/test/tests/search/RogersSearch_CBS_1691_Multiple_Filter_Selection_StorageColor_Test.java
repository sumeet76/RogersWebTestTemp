package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.CSVReader;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class RogersSearch_CBS_1691_Multiple_Filter_Selection_StorageColor_Test extends BaseTestClass {
    @DataProvider(name = "FilterData", parallel = true)
    public Object[] testData() throws IOException {
        String csvFileName = null;
        String language = System.getProperty("Language").toLowerCase();
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
    public void validateParentFilterDeselection(String[] csvRow) {
        boolean isMobile;
        List<String> strStorageOptions;
        List<String> strColorOptions;
        List<WebElement> resultLinks;
        String strDeviceName;
        String strSelectedStorage;
        String strSelectedColor;
        getDriver().get(System.getProperty("SearchUrl") + csvRow[0]);
        getRogersSearchPage().isPageLoaded();
        isMobile = getRogersSearchPage().isMobileSelected();
        if (isMobile) {
            getRogersSearchPage().clkFilterIconMobile();
            reporter.reportLogWithScreenshot("Clicked on Filter Icon");
        }
        String gpfilter = getRogersSearchPage().clkShopFilter();
        reporter.reportLogWithScreenshot(gpfilter + " Filter clicked");
        String pfilter = getRogersSearchPage().clkWirelessFilter();
        reporter.reportLogWithScreenshot(pfilter + " Filter clicked");
        strStorageOptions = getRogersSearchPage().getStorageSelections();
        reporter.hardAssert(strStorageOptions.size() != 0, "Storage Options Available", "Storage Options Unavailable");
        for (int i = 0; i < strStorageOptions.size(); i++) {
            getRogersSearchPage().clkStorageType(strStorageOptions.get(i));
            reporter.reportLogWithScreenshot("Storage: " + strStorageOptions.get(i) + " is selected");
            strColorOptions = getRogersSearchPage().getColorSelections();
            for (int j = 0; j < strColorOptions.size(); j++) {
                getRogersSearchPage().clkColorType(strColorOptions.get(j));
                reporter.reportLogWithScreenshot(" Color:" + strColorOptions.get(j) + " is Selected");
                if (isMobile) {
                    getRogersSearchPage().clkShowResultBtnMobile();
                    reporter.reportLogWithScreenshot("Clicked on Show Results button");
                }
                resultLinks = getRogersSearchPage().getAllResultLinks();
                for (int k = 0; k < resultLinks.size(); k++) {
                    String resultLink = resultLinks.get(k).getText();
                    getRogersSearchPage().clkResultLink(resultLinks.get(k));
                    reporter.reportLogWithScreenshot("Clicked on link:" + resultLink);
                    strDeviceName = getRogersDeviceConfigPage().getDeviceName();
                    if (!strDeviceName.equals("Phones")) {
                        reporter.reportLogPassWithScreenshot(strDeviceName + " Page");
                        strSelectedStorage = getRogersSearchPage().getSelectedStorage();
                        strSelectedColor = getRogersSearchPage().getSelectedColor();
                        reporter.softAssert(strSelectedStorage.equalsIgnoreCase(strStorageOptions.get(i)),
                                "Storage Expected=" + strStorageOptions.get(i) + "; Actual=" + strSelectedStorage,
                                "Storage Expected=" + strStorageOptions.get(i) + "; Actual=" + strSelectedStorage);
                        reporter.softAssert(strSelectedColor.equals(strColorOptions.get(j)),
                                "Color Expected=" + strColorOptions.get(j) + "; Actual=" + strSelectedColor,
                                "Color Expected=" + strColorOptions.get(j) + "; Actual=" + strSelectedColor);
                    } else {
                        reporter.reportLogFailWithScreenshot("Failed to land on Device Config page");
                    }
                    getRogersDeviceConfigPage().navigateBack();
                    getRogersSearchPage().isPageLoaded();
                    resultLinks = getRogersSearchPage().getAllResultLinks();
                }
                getRogersSearchPage().isPageLoaded();
                if (isMobile) {
                    getRogersSearchPage().clkFilterIconMobile();
                    reporter.reportLogWithScreenshot("Clicked on Filter Icon");
                }
                getRogersSearchPage().clkColorType(strColorOptions.get(j));
            }
            getRogersSearchPage().isPageLoaded();
            if (isMobile) {
                getRogersSearchPage().clkFilterIconMobile();
                reporter.reportLogWithScreenshot("Clicked on Filter Icon");
            }
            getRogersSearchPage().clkStorageType(strStorageOptions.get(i));
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