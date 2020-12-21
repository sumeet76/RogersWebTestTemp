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

public class RogersSearch_CBS_1683_Clicking_On_Results_With_Selected_Color_Test extends BaseTestClass {

	@Test
	public void validateResultsWithSelectedColors() {
		List<WebElement> resultLinks;
		String strDeviceName;
		String strSelectedColor;
		List<String> strColorFilters;
		String strSearchTerm = "iphone";
		List<String> resultColorOptions;

		getDriver().get(System.getProperty("SearchUrl")+strSearchTerm);

		getRogersSearchPage().clkShopAndThenWirelessFilter();
		reporter.reportLogWithScreenshot("Shop and Wireless Filters clicked");
		//getRogersSearchPage().clkGrandParentFilter("Shop");
		//getRogersSearchPage().clkParentFilter("Shop","Wireless");
		//reporter.reportLogWithScreenshot("Shop and Wireless Filters clicked");

		strColorFilters = getRogersSearchPage().getColorFilters();
		for(int i=0;i<strColorFilters.size();i++) {
			getRogersSearchPage().clkColorType(strColorFilters.get(i));
			reporter.reportLogWithScreenshot(strColorFilters.get(i) + " - Color Selected");
		}

		resultLinks = getRogersSearchPage().getAllResultLinks();
		for(int k=0;k<resultLinks.size();k++) {
			String linkDetails = resultLinks.get(k).getText();

			resultColorOptions = getRogersSearchPage().getResultColorOptions(resultLinks.get(k));
			for (int j=0;j<resultColorOptions.size();j++) {
				getRogersSearchPage().clkResultColor(resultLinks.get(k), resultColorOptions.get(j));
				reporter.reportLogWithScreenshot(resultColorOptions.get(j) + " color selected for Result link-" + (k+1));
				getRogersSearchPage().clkResultLink(resultLinks.get(k));

				strDeviceName = getRogersDeviceConfigPage().getDeviceName();
				if(strDeviceName != null && !strDeviceName.equals("Phones")) {
					reporter.reportLogPassWithScreenshot(strDeviceName + " Page");
					strSelectedColor = getRogersDeviceConfigPage().getSelectedColor();
					reporter.softAssert(strSelectedColor.equals(resultColorOptions.get(j)),
							"Color: Expected="+resultColorOptions.get(j)+"; Actual=" + strSelectedColor,
							"Color: Expected="+resultColorOptions.get(j)+"; Actual=" + strSelectedColor);
					getRogersDeviceConfigPage().navigateBack();
				} else {
					reporter.reportLogFailWithScreenshot("Failed to land on Device Config page for following device: "  + linkDetails + " & following color: " + resultColorOptions.get(j));
					getDriver().get(System.getProperty("SearchUrl")+strSearchTerm);
					getRogersSearchPage().clkShopAndThenWirelessFilter();
					reporter.reportLogWithScreenshot("Shop and Wireless Filters clicked");
					//getRogersSearchPage().clkGrandParentFilter("Shop");
					//getRogersSearchPage().clkParentFilter("Shop","Wireless");
					strColorFilters = getRogersSearchPage().getColorFilters();
					for(int i=0;i<strColorFilters.size();i++) {
						getRogersSearchPage().clkColorType(strColorFilters.get(i));
					}
				}
				resultLinks = getRogersSearchPage().getAllResultLinks();
				resultColorOptions = getRogersSearchPage().getResultColorOptions(resultLinks.get(k));
			}
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