package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import utils.CSVReader;

public class RogersSearch_CBS_1663_Only_One_Grand_Parent_Filter_Can_Be_Selected_At_A_Time_Test extends BaseTestClass {


    @DataProvider(name = "FilterData")
    public Object[] testData() throws IOException {
        String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterData.csv";
        List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
        Object[] csvRowStrArray = new Object[csvData.size()];

        for (int i = 0; i < csvData.size(); i++) {
            csvRowStrArray[i] = csvData.get(i);
        }

        return csvRowStrArray;


    }

    @Test(dataProvider = "FilterData")

    public void validateGrandParentFilterSelection(String[] csvRowStrArray) {

        getDriver().get(System.getProperty("SearchUrl") + csvRowStrArray[0]);


        String[] strFilters = Arrays.copyOfRange(csvRowStrArray, 1, csvRowStrArray.length);

        reporter.hardAssert(rogers_search_page.verifyOnlyOneGrandParentFilterSelectionDisplay(strFilters), strFilters + "Filter Expanded", strFilters + "Filter Collapsed");

        reporter.reportLogWithScreenshot("Search QA Page - " + strFilters);

        System.out.println("end of set");

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


