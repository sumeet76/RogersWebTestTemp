package com.rogers.test.tests.search;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;

public class RogersSearch_CBS_1686_Clicking_On_A_Parent_Filter_After_Selecting_A_Child_Filter_Test extends BaseTestClass {

    @Test(groups = {"Search", "Filter"})
    public void validateChildAndParentFilterSelection() {
        List<WebElement> lstParentFilters;
        List<String> strColorFilters;
        String strParentFilterName;
        int intCounter = 0;
        getDriver().get(System.getProperty("SearchUrl") + "wireless");
        getRogersSearchPage().isPageLoaded();
        String gpfilter = getRogersSearchPage().clkShopFilter();
        reporter.reportLogWithScreenshot(gpfilter + " Filter clicked");
        lstParentFilters = getRogersSearchPage().getParentFilters(gpfilter);
        String pfilter = getRogersSearchPage().clkWirelessFilter();
        reporter.reportLogWithScreenshot(pfilter + " Filter clicked");
        strColorFilters = getRogersSearchPage().getColorFilters();
        for (int i = 0; i < strColorFilters.size(); i++) {
            getRogersSearchPage().clkColorType(strColorFilters.get(i));
            reporter.reportLogWithScreenshot(strColorFilters.get(i) + " - Color Selected");
            reporter.softAssert(getRogersSearchPage().validateResultsTag(gpfilter, pfilter),
                    "Results belong to tag " + gpfilter + "-" + pfilter,
                    "Results do not belong to tag " + gpfilter + "-" + pfilter);
            reporter.softAssert(getRogersSearchPage().validateResultsColor(strColorFilters.get(i)),
                    "All Results belong to color: " + strColorFilters.get(i),
                    "All Results do Not belong to color: " + strColorFilters.get(i));
            if (intCounter == (lstParentFilters.size() - 2)) {
                intCounter = 0;
            }
            strParentFilterName = lstParentFilters.get(intCounter).getText();
            getRogersSearchPage().clkParentFilter(lstParentFilters.get(intCounter));
            reporter.reportLogWithScreenshot("Parent filter " + lstParentFilters.get(intCounter).getText() + " is clicked");
            reporter.softAssert(getRogersSearchPage().validateResultsTag(gpfilter, strParentFilterName),
                    "Results belong to tag " + gpfilter + "-" + strParentFilterName + "'. Navigation Passed",
                    "Results do not belong to tag " + gpfilter + "-" + strParentFilterName + "'. Navigation Failed");
            intCounter++;
            getRogersSearchPage().clkParentFilter(gpfilter, pfilter);
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