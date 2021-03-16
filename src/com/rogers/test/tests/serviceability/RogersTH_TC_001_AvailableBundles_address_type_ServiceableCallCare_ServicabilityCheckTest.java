package com.rogers.test.tests.serviceability;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.CSVReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;


/**
 * This class contains the test method to test serviceability for given address
 * 
 * @author Rajat.Sharma
 * 
 * Test steps:
 *
 *1. Launch http://www.env25.rogers.com/web/consumer/ignite-bundles/tv-internet
 *2. Click See available bundles button
 *3. Click check address button
 *4. Enter home address to validate the serviceability and click on Check button
 *5. Verify the Headers and Sub-headers in the page
 *
 **/

public class RogersTH_TC_001_AvailableBundles_address_type_ServiceableCallCare_ServicabilityCheckTest extends BaseTestClass {

	@Test(dataProvider = "FilterData")
    public void checkServicabilityTest(String[] csvRowStrArray) throws InterruptedException {
    	reporter.reportLogWithScreenshot("Launched the Home Page");
    	getRogersHomePageRogersHomePageServiceability().clkAvailableBundles();
    	reporter.reportLogWithScreenshot("clicked See available bundles button");
//		getRogersHomePageTechHub().clkCheckServiceability();
//    	reporter.reportLogWithScreenshot("clicked Check Address button on customer type pop up");
		String  strServiceabilityCode= csvRowStrArray[csvRowStrArray.length-1];
		String  strAddress = new String();
		for(int counter=0;counter<=csvRowStrArray.length-2;counter++){
			if(!csvRowStrArray[counter].equals("")) {
				if (counter==0)
			   strAddress+=csvRowStrArray[counter]+"-";
				else
					strAddress+=csvRowStrArray[counter]+" ";
			}
		}
		getRogersHomePageRogersHomePageServiceability().setAddress(strAddress);
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		getRogersHomePageRogersHomePageServiceability().clkCheckServiceability();
		reporter.hardAssert(getRogersHomePageRogersHomePageServiceability().verifyServicebiltyHeader(strServiceabilityCode),"Serviceability header value is as expected","Serviceability header value is not as expected");
		reporter.hardAssert(getRogersHomePageRogersHomePageServiceability().verifyServicebiltySubhead(strServiceabilityCode),"Serviceability sub head value is as expected","Serviceability head value is not as expected");
		reporter.reportLogWithScreenshot("Succesfully verified Serviceability page for given address");

	}


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//legacyAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws  IOException  {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.serviceability, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}
	

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

	@DataProvider(name = "FilterData",parallel=false)
	public Object[] testData() throws IOException {
		String csvFileName = System.getProperty("user.dir") + "/test-data/rogers/serviceability/ServiceableCallCare.csv";
		List<String[]> csvData = CSVReader.parseCsvData(csvFileName);
		Object[] csvRowStrArray = new Object[csvData.size()];
		for (int i = 0; i < csvData.size(); i++) {
			csvRowStrArray[i] = csvData.get(i);
		}
		return csvRowStrArray;
	}





}


