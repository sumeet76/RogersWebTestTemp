package com.rogers.test.tests.search;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class RogersSearch_CBS_1684_Storage_Filter_Functioning_Test extends BaseTestClass {

	@Test
	public void validateStorageFilterSelection() {
		List<WebElement> resultLinks;
		String strDeviceName;
		String strSelectedStorage;
		List<String> strStorageFilters;
		String strSearchTerm = "iphone";

		getDriver().get(System.getProperty("SearchUrl")+strSearchTerm);

		getRogersSearchPage().clkShopAndThenWirelessFilter();
		reporter.reportLogWithScreenshot("Shop and Wireless Filters clicked");
		strStorageFilters = getRogersSearchPage().getStorageSelections();
		for(int i=0;i<strStorageFilters.size();i++) {
			getRogersSearchPage().clkStorageType(strStorageFilters.get(i));
			reporter.reportLogWithScreenshot(strStorageFilters.get(i) + " - Selected");

			resultLinks = getRogersSearchPage().getAllResultLinks();
			for(int k=0;k< resultLinks.size();k++) {
				getRogersSearchPage().clkResultLink(resultLinks.get(k));
				strDeviceName = getRogersDeviceConfigPage().getDeviceName();
				if(strDeviceName != null && !strDeviceName.equals("Phones")) {
					reporter.reportLogPassWithScreenshot(strDeviceName + " Page");
					strSelectedStorage = getRogersDeviceConfigPage().getSelectedStorage();
					reporter.softAssert(strSelectedStorage.equals(strStorageFilters.get(i)),
							"Storage: Expected="+strStorageFilters.get(i)+"; Actual=" + strSelectedStorage,
							"Storage: Expected="+strStorageFilters.get(i)+"; Actual=" + strSelectedStorage);
					getRogersDeviceConfigPage().navigateBack();
				} else {
					reporter.reportLogFailWithScreenshot("Failed to land on Device Config page");
					getDriver().get(System.getProperty("SearchUrl")+strSearchTerm);
					getRogersSearchPage().clkGrandParentFilter("Shop");
					getRogersSearchPage().clkParentFilter("Shop","Wireless");
					getRogersSearchPage().clkStorageType(strStorageFilters.get(i));
				}
				resultLinks = getRogersSearchPage().getAllResultLinks();
			}
			getRogersSearchPage().clkStorageType(strStorageFilters.get(i));
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