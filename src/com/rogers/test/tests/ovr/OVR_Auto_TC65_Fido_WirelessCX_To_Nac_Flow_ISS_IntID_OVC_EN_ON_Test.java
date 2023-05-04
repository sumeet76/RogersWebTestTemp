package com.rogers.test.tests.ovr;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC65_Fido_WirelessCX_To_Nac_Flow_ISS_IntID_OVC_EN_ON_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startOVSession(System.getProperty("OVFidoUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","", "", method);
    }
    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        //closeSession();
    }
    @Test(groups = {})
    public void ovr_Auto_TC65_Fido_WirelessCX_To_Nac_Flow_ISS_IntID_OVC_EN_ON_Test(){
        getEnvironmentSelectionPage().launchOneViewFido("986660231", "CO2100013754");
        reporter.reportLogWithScreenshot("OneView Fido Interface has Launched");
    }
}
