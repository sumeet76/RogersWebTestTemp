package com.rogers.test.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;

import com.rogers.pages.RogersAccountOverviewPage;
import com.rogers.pages.RogersAddDataPage;
import com.rogers.pages.RogersBillingPage;
import com.rogers.pages.RogersChangeMyCallerIdPage;
import com.rogers.pages.RogersChangePaymentMethodPage;
import com.rogers.pages.RogersHomePage;
import com.rogers.pages.RogersLinkAccountPage;
import com.rogers.pages.RogersLoginPage;
import com.rogers.pages.RogersMakePaymentPage;
import com.rogers.pages.RogersManageDataPage;
import com.rogers.pages.RogersPaymentOptionsPage;
import com.rogers.pages.RogersProfileAndSettingsPage;
import com.rogers.pages.RogersRecoverPassOrNamePage;
import com.rogers.pages.RogersRegisterPage;
import com.rogers.pages.RogersSecurePaymentPage;
import com.rogers.pages.RogersSetPasswordPage;
import com.rogers.pages.RogersShareEverythingPage;
import com.rogers.pages.RogersSpeedPassPage;
import com.rogers.pages.RogersWirelessDashboardPage;
import com.rogers.pages.ens.EnsHomePage;
import com.rogers.pages.ens.EnsNotificationViewPage;
import com.rogers.test.commonbusinessfunctions.CommonBusinessFlows;
import com.rogers.test.commonbusinessfunctions.VerifyInEns;
import com.rogers.test.helpers.BrowserDrivers;
import com.rogers.test.helpers.CaptchaBypassHandlers;
import com.rogers.test.helpers.RogersEnums;

import extentreport.ExtentTestManager;
import utils.Reporter;


@Listeners ({com.rogers.test.listeners.TestListener.class ,
	com.rogers.test.listeners.AnnotationTransformer.class ,
	com.rogers.test.listeners.TestListener.class })


public class BaseTestClass {
		
	public enum OS {
        WIN, LIN, MAC
    };// Operating systems.
    private static OS os = null;
	private WebDriver driver;
	protected HashMap<String,String> xmlTestParameters;
	public RogersHomePage rogers_home_page;
	public RogersLoginPage rogers_login_page;
	public RogersAccountOverviewPage rogers_account_overview_page;
	protected RogersShareEverythingPage rogers_share_everything_page;
	protected RogersChangeMyCallerIdPage rogers_change_my_caller_id_page;
	protected RogersWirelessDashboardPage rogers_wireless_dashboard_page;
	protected RogersRegisterPage rogers_register_page;
	protected RogersLinkAccountPage rogers_link_account_page;
	protected RogersBillingPage rogers_billing_page;
	protected RogersChangePaymentMethodPage rogers_change_payment_method_page;
	protected RogersSecurePaymentPage rogers_secure_payment_page;
	public RogersProfileAndSettingsPage rogers_profile_and_settings_page;
	protected RogersPaymentOptionsPage rogers_payment_options_page;
	protected RogersMakePaymentPage rogers_make_payment_page;
	protected RogersAddDataPage rogers_add_data_page;
	protected RogersManageDataPage rogers_manage_data_page;
	public RogersSpeedPassPage rogers_speed_pass_page;
	public Reporter reporter;
	protected CommonBusinessFlows common_business_flows; 
	public EnsHomePage ensHomePage;
	public EnsNotificationViewPage ensNoteViewPage;
	protected VerifyInEns ensVerifications;
	protected RogersSetPasswordPage rogers_set_password_page;
	protected RogersRecoverPassOrNamePage rogers_recover_pass_or_name;
	protected BrowserDrivers browserdriver;
		
		private CaptchaBypassHandlers captcha_bypass_handlers;
		
		public BaseTestClass() {
			 browserdriver =  new BrowserDrivers();
			 
		}
	
	private void init() {
		
		rogers_home_page = new RogersHomePage(driver);
		rogers_login_page = new RogersLoginPage(driver);
		rogers_account_overview_page = new RogersAccountOverviewPage(driver);
		rogers_share_everything_page = new RogersShareEverythingPage(driver);
		rogers_change_my_caller_id_page = new RogersChangeMyCallerIdPage(driver);
		rogers_wireless_dashboard_page = new RogersWirelessDashboardPage(driver);
		rogers_add_data_page = new RogersAddDataPage(driver);
		rogers_manage_data_page = new RogersManageDataPage(driver);
		rogers_speed_pass_page = new RogersSpeedPassPage(driver);
		rogers_register_page = new RogersRegisterPage(driver);
		rogers_link_account_page = new RogersLinkAccountPage(driver);
		rogers_billing_page = new RogersBillingPage(driver);
		rogers_change_payment_method_page = new RogersChangePaymentMethodPage(driver);
		rogers_secure_payment_page = new RogersSecurePaymentPage(driver);
		rogers_profile_and_settings_page = new RogersProfileAndSettingsPage(driver);
		rogers_payment_options_page = new RogersPaymentOptionsPage(driver);
		rogers_make_payment_page = new RogersMakePaymentPage(driver);
		reporter = new ExtentTestManager(driver);
		common_business_flows = new CommonBusinessFlows(this);
		ensHomePage = new EnsHomePage(getDriver());
		ensNoteViewPage = new EnsNotificationViewPage(getDriver());
		ensVerifications = new VerifyInEns(this);
		rogers_set_password_page = new RogersSetPasswordPage(getDriver());
		rogers_recover_pass_or_name = new RogersRecoverPassOrNamePage(getDriver());
	}


	 /* To start a session using given url, browser, language and test case group name.
	 * @param strUrl                     string of test url
	 * @param strBrowser                 string of browser name
	 * @param strLanguage                string of language to use
	 * @param enumGroupName               string of group name of the test case
	 * @param currentTestMethodName 
	 * @throws ClientProtocolException   org.apache.http.client.ClientProtocolException, Signals an error in the HTTP protocol.
	 * @throws IOException               java.io.IOException, Signals that an I/O exception of some sort has occurred, produced by failed or interrupted I/O operations.
	 */
	public void startSession(String strUrl, String strBrowser,  String strLanguage, RogersEnums.GroupName enumGroupName, Method currentTestMethodName) throws ClientProtocolException, IOException {
		this.driver = browserdriver.driverInit(strBrowser, currentTestMethodName, enumGroupName.toString());
		System.out.println(strUrl + "----------------------------------------------------------------------------");
		captcha_bypass_handlers = new CaptchaBypassHandlers(getDriver());
		switch(enumGroupName.toString().toLowerCase().trim()) {			
		case "selfserve":
		case "selfserve_login":
			captcha_bypass_handlers.captchaBypassURLSelfserveFlows(strUrl, strLanguage);
			break;

 		default :
 			captcha_bypass_handlers.captchaBypassURLLoginFlows(strUrl, strLanguage);
		}
	    setImplicitWait(getDriver(), 10);
	    init();
 }

	
	
	
	/**
	 * gets the OS type
	 * @return enum containing OS value
	 * @author Mirza.Kamran
	 */
	  public static OS getOS() {
	        if (os == null) {
	            String operSys = System.getProperty("os.name").toLowerCase();
	            if (operSys.contains("win")) {
	                os = OS.WIN;
	            } else if (operSys.contains("nix") || operSys.contains("nux")
	                    || operSys.contains("aix")) {
	                os = OS.LIN;
	            } else if (operSys.contains("mac")) {
	                os = OS.MAC;
	            }
	        }
	        return os;
	    }
	
	/**
	 * This method will set up the sauce capabilities and initiate run
	 * @param strTestName name of the test method
	 * @param strJobName The sauce Job name
	 * @param strBrowser browser name
	 * @throws MalformedURLException exception thrown on malformed url
	 * @author Mirza.Kamran
	 */
	private void setupSauce(String strTestName,String strJobName,String strBrowser) throws MalformedURLException {
        
        String sauceURL ="http://"+System.getenv("SAUCE_USERNAME")+":"+System.getenv("SAUCE_ACCESS_KEY")+"@ondemand.saucelabs.com:80/wd/hub";
                
        //String sauceURL = "https://ondemand.saucelabs.com/wd/hub";	
        MutableCapabilities sauceOpts = new MutableCapabilities();
        //sauceOpts.setCapability("username", sauceUserName);
        //sauceOpts.setCapability("accessKey", sauceAccessKey);        
        sauceOpts.setCapability("seleniumVersion", "3.141.59");
        sauceOpts.setCapability("name", strTestName);
        List<String> tags = Arrays.asList("Fido", "SelfServe", "module4");
        sauceOpts.setCapability("tags", tags);		 		       
        sauceOpts.setCapability("maxDuration", 3600);//test run timeout
        sauceOpts.setCapability("commandTimeout", 600); //selenium command timeout
        sauceOpts.setCapability("idleTimeout", 1000);	       
        sauceOpts.setCapability("build", strJobName);
        ChromeOptions chromeOpts = new ChromeOptions();
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("sauce:options", sauceOpts);
        switch (strBrowser) {
		case "firefox":
			capabilities.setCapability("browserName", "firefox");
			break;
		case "chrome":			
	        chromeOpts.setExperimentalOption("w3c", true);
	        capabilities.setCapability("goog:chromeOptions", chromeOpts);
	        capabilities.setCapability("browserName", "chrome");
			break;
		case "safari":
			capabilities.setCapability("browserName", "safari");
			break;	
		default:
			break;
		}                                
        capabilities.setCapability("platformVersion", "Windows 10");
        capabilities.setCapability("browserVersion", "latest");		 
        driver = new RemoteWebDriver(new URL(sauceURL), capabilities);						
	}

	/**
	 * This method will set up the browser stack capabilities
	 * @author Mirza.Kamran
	 * @throws MalformedURLException 
	 */
	private void setupBrowserStack(String strTestName) throws MalformedURLException {
		  String username = "Mirza.Kamran";
		  String automateKey = "dacb41bf-f530-437e-8d75-4b0e1e9670b9";
		  String url = "https://" + username + ":" + automateKey + "@hub-cloud.browserstack.com/wd/hub";		  
		    DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "10");
		    caps.setCapability("browser", "Chrome");
		    caps.setCapability("browser_version", "77.0");
		    caps.setCapability("resolution", "1920x1080");
		    caps.setCapability("project", "Self-Serve Test");
		    caps.setCapability("name", strTestName);
		    caps.setCapability("browserstack.local", "true");
		    caps.setCapability("browserstack.console", "verbose");
		    caps.setCapability("browserstack.debug", "true");
		    caps.setCapability("idleTimeout", "200");
//		    caps.setCapability("browserstack.networkLogs", "true");

		    driver = new RemoteWebDriver(new URL(url), caps);
		    driver.manage().window().maximize();
	}
	
	/**
	 * BrowserStack REST API to access and update information about test.
	 * @param strStatus
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void mark(String strStatus) throws ClientProtocolException, IOException, URISyntaxException  {
		  URI uri = new URI("https://ning28:pgaiJjgQMZERUe51d4ky@api.browserstack.com/automate/sessions/"
				  			+ ((RemoteWebDriver)getDriver()).getSessionId() + ".json");
		  HttpPut putRequest = new HttpPut(uri);
		  ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		  nameValuePairs.add((new BasicNameValuePair("status", strStatus)));
		  nameValuePairs.add((new BasicNameValuePair("reason", "")));
		  putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		  HttpClientBuilder.create().build().execute(putRequest);
	}

	public void closeSession() {

		getDriver().quit();
	}

	/**
	 * To set implicit wait for the test.
	 * @param driver   the web driver
	 * @param seconds  wait time by seconds
	 */
	public void setImplicitWait(WebDriver driver, long seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * To get parameters from XML file, it is called in TestListener.
	 * @return HashMap of test parameters
	 */
	public HashMap<String, String> getXMLParameters() {
		return xmlTestParameters;
	}
		


}
