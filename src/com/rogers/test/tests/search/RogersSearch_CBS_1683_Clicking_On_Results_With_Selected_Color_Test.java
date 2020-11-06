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
		getDriver().get(System.getProperty("SearchUrl")+strSearchTerm);

		getRogersSearchPage().clkGrandParentFilter("Shop");
		getRogersSearchPage().clkParentFilter("Shop","Wireless");
		reporter.reportLogWithScreenshot("Shop and Wireless Filters clicked");

		strColorFilters = getRogersSearchPage().getColorFilters();
		for(int i=0;i<strColorFilters.size();i++) {
			//Selecting color filter
			getRogersSearchPage().clkColorType(strColorFilters.get(i));
			reporter.reportLogWithScreenshot(strColorFilters.get(i) + " - Color Selected");

			reporter.softAssert(getRogersSearchPage().validateResultsColor(strColorFilters.get(i)),
					"All Results belong to color"+strColorFilters.get(i),
					"All Results do Not belong to color"+strColorFilters.get(i));

			resultLinks = getRogersSearchPage().getAllResultLinks();
			reporter.reportLogWithScreenshot(strColorFilters.get(i) + " - Color Results");

			for(int k=0;k< resultLinks.size();k++) {
				String linkDetails=resultLinks.get(k).getText();
				getRogersSearchPage().clkResultLink(resultLinks.get(k));

				strDeviceName = getRogersDeviceConfigPage().getDeviceName();
				if(strDeviceName != null && !strDeviceName.equals("Phones")) {
					reporter.reportLogPassWithScreenshot(strDeviceName + " Page");
					strSelectedColor = getRogersDeviceConfigPage().getSelectedColor();
					reporter.softAssert(strSelectedColor.equals(strColorFilters.get(i)),
							"Color: Expected="+strColorFilters.get(i)+"; Actual=" + strSelectedColor,
							"Color: Expected="+strColorFilters.get(i)+"; Actual=" + strSelectedColor);
					getRogersDeviceConfigPage().navigateBack();
				} else {
					reporter.reportLogFailWithScreenshot("Failed to land on Device Config page for following device: "  + linkDetails + " & following color: " +strColorFilters.get(i));
					getDriver().get(System.getProperty("SearchUrl")+strSearchTerm);
					getRogersSearchPage().clkGrandParentFilter("Shop");
					getRogersSearchPage().clkParentFilter("Shop","Wireless");
					getRogersSearchPage().clkColorType(strColorFilters.get(i));
				}
				resultLinks = getRogersSearchPage().getAllResultLinks();
			}
			getRogersSearchPage().clkColorType(strColorFilters.get(i));
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