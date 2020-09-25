package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;


public class RogersSearch_CBS_1619_Relevant_Filters_Rendering_Test extends BaseTestClass {


    @DataProvider(name = "FilterData")
    public Object[] testData() throws IOException {
        String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterData.csv";
        List<String[]> csvData = parseCsvData(csvFileName);
        Object[] csvRowStrArray = new Object[csvData.size()];

        for (int i = 0; i < csvData.size(); i++) {
            csvRowStrArray[i] = csvData.get(i);
        }

        return csvRowStrArray;

    }


    @Test(dataProvider = "FilterData")

    public void validateFilters(String[] csvRowStrArray) {

        getDriver().get(System.getProperty("SearchUrl") + csvRowStrArray[0]);

        for (int i = 1; i < csvRowStrArray.length; i++) {

            reporter.softAssert(rogers_search_page.isFilterDisplayed(csvRowStrArray[i]), "Filter " + csvRowStrArray[i] + " is Displayed", "Filter " + csvRowStrArray[i] + " is NOT Displayed");

            reporter.reportLogWithScreenshot("Search QA Page - " + csvRowStrArray[i]);

        }

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
