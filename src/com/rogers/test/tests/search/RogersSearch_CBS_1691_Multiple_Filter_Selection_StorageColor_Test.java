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
	@DataProvider(name = "FilterData", parallel = false)
	public Object[] testData() throws IOException {
		String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterData.csv";
		List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
		Object[] csvRow = new Object[csvData.size()];

		for (int i = 0; i < csvData.size(); i++) {
			csvRow[i] = csvData.get(i);
		}

		return csvRow;
	}

	@Test(dataProvider = "FilterData",groups={"Search","Filter", "Sanity"})
	public void validateParentFilterDeselection(String[] csvRow) {

		List<String> strStorageOptions;
		List<String> strColorOptions;
		List<WebElement> resultLinks;
		String strDeviceName;
		String strSelectedStorage;
		String strSelectedColor;

		getDriver().get(System.getProperty("SearchUrl") + csvRow[0]);
		getRogersSearchPage().isPageLoaded();
		getRogersSearchPage().waitTime();
		//reporter.hardAssert(getRogersSearchPage().isGrandParentFilterDisplayed("Shop")
		//		,"Shop filter is Displayed","Shop filter is Not Displayed");
		getRogersSearchPage().clkGrandParentFilter("Shop");
		//reporter.hardAssert(getRogersSearchPage().isParentFilterDisplayed("Shop","Wireless")
		//		,"Shop-Wireless filter is Displayed","Shop-Wireless filter is Not Displayed");
		getRogersSearchPage().clkParentFilter("Shop", "Wireless");
		reporter.hardAssert(getRogersSearchPage().validateResultsTag("Shop", "Wireless")
				, "Results' tags verified", "Results' tags mismatch");
		reporter.reportLogWithScreenshot("Shop-Wireless Expanded");
		strStorageOptions = getRogersSearchPage().getStorageSelections();
		reporter.hardAssert(strStorageOptions.size() != 0, "Storage Options Available", "Storage Options Unavailable");
		for (int i = 0; i < strStorageOptions.size(); i++) {
			getRogersSearchPage().clkStorageType(strStorageOptions.get(i));

			strColorOptions = getRogersSearchPage().getColorSelections();
			for (int j = 0; j < strColorOptions.size(); j++) {
				getRogersSearchPage().clkColorType(strColorOptions.get(j));
				reporter.reportLogWithScreenshot("Storage: " + strStorageOptions.get(i)
						+ " and Color:" + strColorOptions.get(j) + " is Selected");

				resultLinks = getRogersSearchPage().getAllResultLinks();
				for (int k = 0; k < resultLinks.size(); k++) {
					getRogersSearchPage().clkResultLink(resultLinks.get(k));
					strDeviceName = getRogersDeviceConfigPage().getDeviceName();
					if (!strDeviceName.equals("Phones")) {
						reporter.reportLogPassWithScreenshot(strDeviceName + " Page");
						strSelectedStorage = getRogersDeviceConfigPage().getSelectedStorage();
						strSelectedColor = getRogersDeviceConfigPage().getSelectedColor();
						reporter.softAssert(strSelectedStorage.equals(strStorageOptions.get(i)),
								"Storage Expected=" + strStorageOptions.get(i) + "; Actual=" + strSelectedStorage,
								"Storage Expected=" + strStorageOptions.get(i) + "; Actual=" + strSelectedStorage);
						reporter.softAssert(strSelectedColor.equals(strColorOptions.get(j)),
								"Color Expected=" + strColorOptions.get(j) + "; Actual=" + strSelectedColor,
								"Color Expected=" + strColorOptions.get(j) + "; Actual=" + strSelectedColor);
						//TODO - Results Validation
					} else {
						reporter.reportLogFailWithScreenshot("Failed to land on Device Config page");
					}
					getRogersDeviceConfigPage().navigateBack();
					getRogersSearchPage().isPageLoaded();
					getRogersSearchPage().waitTime();
					resultLinks = getRogersSearchPage().getAllResultLinks();
				}
				getRogersSearchPage().isPageLoaded();
				getRogersSearchPage().waitTime();
				getRogersSearchPage().clkColorType(strColorOptions.get(j));
			}
			getRogersSearchPage().isPageLoaded();
			getRogersSearchPage().waitTime();
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
	}}