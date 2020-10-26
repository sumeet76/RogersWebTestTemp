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
	@DataProvider(name = "FilterData")
	public Object[] testData() throws IOException
	{
		String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/search/FilterData.csv";
		List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
		Object[] csvRow = new Object[csvData.size()];
		 
        for(int i =0; i < csvData.size();i++){
        	csvRow[i] = csvData.get(i);
        }
 
        return csvRow;
	}
	
	@Test(dataProvider = "FilterData")
	public void validateParentFilterDeselection(String[] csvRow) {

		List<String> strStorageOptions;
		List<String> strColorOptions;
		List<WebElement> resultLinks;
		String strDeviceName;
		String strSelectedStorage;
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
		strStorageOptions = rogers_search_page.getStorageSelections();
		reporter.hardAssert(strStorageOptions.size()!=0,"Storage Options Available","Storage Options Unavailable");
		for(int i=0;i< strStorageOptions.size();i++) {
			rogers_search_page.clkStorageType(strStorageOptions.get(i));

			strColorOptions = rogers_search_page.getColorSelections();
			for(int j=0;j< strColorOptions.size();j++) {
				rogers_search_page.clkColorType(strColorOptions.get(j));
				reporter.reportLogWithScreenshot("Storage: " + strStorageOptions.get(i)
						+" and Color:" + strColorOptions.get(j) + " is Selected");

				resultLinks = rogers_search_page.getAllResultLinks();
				for(int k=0;k< resultLinks.size();k++) {
					rogers_search_page.clkResultLink(resultLinks.get(k));
					strDeviceName = rogers_device_config_page.getDeviceName();
					if(!strDeviceName.equals("Phones")) {
						reporter.reportLogPassWithScreenshot(strDeviceName + " Page");
						strSelectedStorage = rogers_device_config_page.getSelectedStorage();
						strSelectedColor = rogers_device_config_page.getSelectedColor();
						reporter.softAssert(strSelectedStorage.equals(strStorageOptions.get(i)),
								"Storage Expected="+strStorageOptions.get(i)+"; Actual=" + strSelectedStorage,
								"Storage Expected="+strStorageOptions.get(i)+"; Actual=" + strSelectedStorage);
						reporter.softAssert(strSelectedColor.equals(strColorOptions.get(j)),
								"Color Expected="+strColorOptions.get(j)+"; Actual=" + strSelectedColor,
								"Color Expected="+strColorOptions.get(j)+"; Actual=" + strSelectedColor);
						//TODO - Results Validation
					} else {
						reporter.reportLogFailWithScreenshot("Failed to land on Device Config page");
					}
					rogers_device_config_page.navigateBack();
					resultLinks = rogers_search_page.getAllResultLinks();
				}
				rogers_search_page.clkColorType(strColorOptions.get(j));
			}
			rogers_search_page.clkStorageType(strStorageOptions.get(i));
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