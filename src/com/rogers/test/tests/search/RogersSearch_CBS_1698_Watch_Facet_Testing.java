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
    @DataProvider(name = "FilterData")
    public Object[] testData() throws IOException
    {
        String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterDataWatchFilter.csv";
        List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
        Object[] csvRow = new Object[csvData.size()];

        for(int i =0; i < csvData.size();i++){
            csvRow[i] = csvData.get(i);
        }

        return csvRow;
    }

    @Test(dataProvider = "FilterData")
    public void validateWatchSizeAndColorFilterSelection(String[] csvRow) {

        List<String> strSizeOptions;
        List<String> strColorOptions;
        List<WebElement> resultLinks;
        String strDeviceName;
        String strSelectedSize;
        String strSelectedColor;

        getDriver().get(System.getProperty("SearchUrl")+csvRow[0]);

        reporter.hardAssert(rogers_search_page.isGrandParentFilterDisplayed("Shop")
                ,"Shop filter is Displayed","Shop filter is Not Displayed");
        rogers_search_page.clkGrandParentFilter("Shop");
        reporter.hardAssert(rogers_search_page.isParentFilterDisplayed("Shop","Wireless")
                ,"Shop-Wireless filter is Displayed","Shop-Wireless filter is Not Displayed");
        rogers_search_page.clkParentFilter("Shop","Wireless");
        reporter.hardAssert(rogers_search_page.validateResultsTag("Shop","Wireless")
                ,"Results' tags verified", "Results' tags mismatch");
        reporter.reportLogWithScreenshot("Shop-Wireless Expanded");
        rogers_search_page.clkDeviceType("Watch");

        strSizeOptions = rogers_search_page.getSizeSelections();
        reporter.hardAssert(strSizeOptions.size()!=0,"Size Options Available","Size Options Unavailable");
        for(int i=0;i< strSizeOptions.size();i++) {
            rogers_search_page.clkSizeType(strSizeOptions.get(i));

            strColorOptions = rogers_search_page.getColorSelections();
            for(int j=0;j< strColorOptions.size();j++) {
                rogers_search_page.clkColorType(strColorOptions.get(j));
                reporter.reportLogWithScreenshot("Size: " + strSizeOptions.get(i)
                        +" and Color:" + strColorOptions.get(j) + " is Selected");

                resultLinks = rogers_search_page.getAllResultLinks();
                for(int k=0;k< resultLinks.size();k++) {
                    rogers_search_page.clkResultLink(resultLinks.get(k));
                    //strDeviceName = rogers_device_config_page.getDeviceName();
                    //if(!strDeviceName.equals("Phones")) {
                    //reporter.reportLogPassWithScreenshot(strDeviceName + " Page");
                    strSelectedSize = rogers_device_config_page.getSelectedSize(strSizeOptions.get(i));
                    strSelectedColor = rogers_device_config_page.getSelectedWatchColor();
                    reporter.softAssert(strSelectedSize.equals(strSizeOptions.get(i)),
                            "Size Expected="+strSizeOptions.get(i)+"; Actual=" + strSelectedSize,
                            "Size Expected="+strSizeOptions.get(i)+"; Actual=" + strSelectedSize);
                    reporter.softAssert(strSelectedColor.equals(strColorOptions.get(j)),
                            "Color Expected="+strColorOptions.get(j)+"; Actual=" + strSelectedColor,
                            "Color Expected="+strColorOptions.get(j)+"; Actual=" + strSelectedColor);
                    //TODO - Results Validation
                    //} else {
                    //reporter.reportLogFailWithScreenshot("Failed to land on Device Config page");

                    rogers_device_config_page.navigateBack();
                    resultLinks = rogers_search_page.getAllResultLinks();
                }

                rogers_search_page.clkColorType(strColorOptions.get(j));

            }

            rogers_search_page.clkSizeType(strSizeOptions.get(i));

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