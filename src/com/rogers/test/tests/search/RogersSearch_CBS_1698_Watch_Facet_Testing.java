package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.CSVReader;
import utils.ReusableActions;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class RogersSearch_CBS_1698_Watch_Facet_Testing extends BaseTestClass {
    @DataProvider(name = "FilterData", parallel = false)
    public Object[] testData() throws IOException {
        String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterDataWatchFilter.csv";
        List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
        Object[] csvRow = new Object[csvData.size()];
        for (int i = 0; i < csvData.size(); i++) {
            csvRow[i] = csvData.get(i);
        }
        return csvRow;
    }

    @Test(dataProvider = "FilterData", groups = {"Search", "Filter", "Multilingual"})
    public void validateWatchSizeAndColorFilterSelection(String[] csvRowStrArray) {
        List<String> strSizeOptions;
        List<String> strColorOptions;
        List<WebElement> resultLinks;
        String strSelectedSize;
        String strSelectedColor;
        reporter.reportLogWithScreenshot("Search URL is launched");
        getRogersSearchPage().isPageLoaded();
        reporter.reportLogWithScreenshot("Page is loaded");
        getRogersSearchPage().clickSearchIcon();
        getRogersSearchPage().enterTextToBeSearched(csvRowStrArray[0]);
        reporter.reportLogWithScreenshot("Search string " + csvRowStrArray[0] + " is entered in the search text box");
        getRogersSearchPage().clickSubmitSearchIcon();
        getRogersSearchPage().isPageLoaded();
        String gpfilter = getRogersSearchPage().clkShopFilter();
        reporter.reportLogWithScreenshot(gpfilter + " Filter clicked");
        String pfilter = getRogersSearchPage().clkWirelessFilter();
        reporter.reportLogWithScreenshot(pfilter + " Filter clicked");
        getRogersSearchPage().clkWatchDeviceType();
        strSizeOptions = getRogersSearchPage().getSizeSelections();
        reporter.hardAssert(strSizeOptions.size() != 0, "Size Options Available", "Size Options Unavailable");
        for (int i = 0; i < strSizeOptions.size(); i++) {
            getRogersSearchPage().clkSizeType(strSizeOptions.get(i));
            reporter.reportLogWithScreenshot("Size: " + strSizeOptions.get(i) + " is selected");
            strColorOptions = getRogersSearchPage().getColorSelections();
            for (int j = 0; j < strColorOptions.size(); j++) {
                getRogersSearchPage().clkColorType(strColorOptions.get(j));
                reporter.reportLogWithScreenshot("Color:" + strColorOptions.get(j) + " is Selected");
                resultLinks = getRogersSearchPage().getAllResultLinks();
                for (int k = 0; k < resultLinks.size(); k++) {
                    getRogersSearchPage().clkResultLink(resultLinks.get(k));
                    reporter.reportLogWithScreenshot((k + 1) + ": Result link is clicked");
                    strSelectedSize = getRogersDeviceConfigPage().getSelectedSize();
                    strSelectedColor = getRogersDeviceConfigPage().getSelectedWatchColor();
                    reporter.softAssert(strSelectedSize.equalsIgnoreCase(strSizeOptions.get(i)),
                            "Size Expected=" + strSizeOptions.get(i) + "; Actual=" + strSelectedSize,
                            "Size Expected=" + strSizeOptions.get(i) + "; Actual=" + strSelectedSize);
                    reporter.softAssert(strSelectedColor.equalsIgnoreCase(strColorOptions.get(j)),
                            "Color Expected=" + strColorOptions.get(j) + "; Actual=" + strSelectedColor,
                            "Color Expected=" + strColorOptions.get(j) + "; Actual=" + strSelectedColor);
                    getRogersDeviceConfigPage().navigateBack();
                    getRogersSearchPage().isPageLoaded();
                    resultLinks = getRogersSearchPage().getAllResultLinks();
                }
                getRogersSearchPage().clkColorType(strColorOptions.get(j));
                reporter.reportLogWithScreenshot("Color:" + strColorOptions.get(j) + " is De-Selected");
                getRogersSearchPage().isPageLoaded();
            }
            getRogersSearchPage().clkSizeType(strSizeOptions.get(i));
            reporter.reportLogWithScreenshot("Size: " + strSizeOptions.get(i) + " is selected");
            getRogersSearchPage().isPageLoaded();
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