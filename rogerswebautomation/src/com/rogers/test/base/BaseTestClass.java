package com.rogers.test.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.rogers.oneview.pages.AccountOverViewPage;
import com.rogers.oneview.pages.ChannelsAndThemePacksPage;
import com.rogers.oneview.pages.CreditCheckPage;
import com.rogers.oneview.pages.CustomerProfilePage;
import com.rogers.oneview.pages.EnvironmentSelectionPage;
import com.rogers.oneview.pages.FulfillmentPage;
import com.rogers.oneview.pages.HomePhoneAddonsPage;
import com.rogers.oneview.pages.HomePhoneSelectionPage;
import com.rogers.oneview.pages.HomePhonedashboard;
import com.rogers.oneview.pages.InternetDashboardPage;
import com.rogers.oneview.pages.OrderConfirmationPage;
import com.rogers.oneview.pages.OrderReviewPage;
import com.rogers.oneview.pages.PaymentOptionsPage;
import com.rogers.oneview.pages.RogersIgniteBundlesPage;
import com.rogers.oneview.pages.RogersInternetUsageOVPage;
import com.rogers.oneview.pages.TVDashboardPage;
import com.rogers.pages.RogersAccountOverviewPage;
import com.rogers.pages.RogersAddDataPage;
import com.rogers.pages.RogersBillingPage;
import com.rogers.pages.RogersBuildPlanPage;
import com.rogers.pages.RogersBuyPage;
import com.rogers.pages.RogersCartSummaryPage;
import com.rogers.pages.RogersChangeMyCallerIdPage;
import com.rogers.pages.RogersChangePaymentMethodPage;
import com.rogers.pages.RogersChangePlanPage;
import com.rogers.pages.RogersChangeSEPlanPage;
import com.rogers.pages.RogersChooseAddonsPage;
import com.rogers.pages.RogersChooseNumberPage;
import com.rogers.pages.RogersChoosePhonePage;
import com.rogers.pages.RogersChoosePlanPage;
import com.rogers.pages.RogersDigitalTVDashboardPage;
import com.rogers.pages.RogersDigitalTVPackageSelectionPage;
import com.rogers.pages.RogersHomePage;
import com.rogers.pages.RogersHomePhonePortInPage;
import com.rogers.pages.RogersHomePhoneSelectionPage;
import com.rogers.pages.RogersIgniteTVBuyPage;
import com.rogers.pages.RogersIgniteTVCreditCheckPage;
import com.rogers.pages.RogersIgniteTVProfileCreationPage;
import com.rogers.pages.RogersInternetDashboardPage;
import com.rogers.pages.RogersInternetPackageSelectionPage;
import com.rogers.pages.RogersInternetUsagePage;
import com.rogers.pages.RogersLegacyBundleBuyPage;
import com.rogers.pages.RogersLinkAccountPage;
import com.rogers.pages.RogersLoginPage;
import com.rogers.pages.RogersMakePaymentPage;
import com.rogers.pages.RogersManageDataPage;
import com.rogers.pages.RogersOrderConfirmationPage;
import com.rogers.pages.RogersOrderReviewPage;
import com.rogers.pages.RogersOrderSummaryPage;
import com.rogers.pages.RogersPaymentOptionsPage;
import com.rogers.pages.RogersPaymentPage;
import com.rogers.pages.RogersProfileAndSettingsPage;
import com.rogers.pages.RogersRecoverPassOrNamePage;
import com.rogers.pages.RogersRegisterPage;
import com.rogers.pages.RogersSecurePaymentPage;
import com.rogers.pages.RogersSetPasswordPage;
import com.rogers.pages.RogersShareEverythingPage;
import com.rogers.pages.RogersShippingPage;
import com.rogers.pages.RogersSolarisRHPDashboardPage;
import com.rogers.pages.RogersSolarisTVChannelsAndThemepacksPage;
import com.rogers.pages.RogersSolarisTVDashboardPage;
import com.rogers.pages.RogersSpeedPassPage;
import com.rogers.pages.RogersTechInstallPage;
import com.rogers.pages.RogersWirelessCreditEvaluationPage;
import com.rogers.pages.RogersWirelessDashboardPage;
import com.rogers.pages.RogersWirelessDetailsPage;
import com.rogers.pages.RogersWirelessProfileCreationPage;
import com.rogers.pages.ens.EnsHomePage;
import com.rogers.pages.ens.EnsNotificationViewPage;
import com.rogers.test.commonbusinessfunctions.CommonBusinessFlows;
import com.rogers.test.commonbusinessfunctions.VerifyInEns;
import com.rogers.test.helpers.BrowserDrivers;
import com.rogers.test.helpers.CaptchaBypassHandlers;
import com.rogers.test.helpers.RogersEnums;

import extentreport.ExtentTestManager;
import utils.AppiumServerJava;
import utils.Reporter;


@Listeners ({com.rogers.test.listeners.TestListener.class ,
	com.rogers.test.listeners.AnnotationTransformer.class ,
	com.rogers.test.listeners.TestListener.class })


public class BaseTestClass {
		
	public enum OS {
        WIN, LIN, MAC
    };// Operating systems.
	private WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger;
	public Reporter reporter;
	public RogersHomePage rogers_home_page;
	public RogersLoginPage rogers_login_page;
	public RogersAccountOverviewPage rogers_account_overview_page;
	public RogersProfileAndSettingsPage rogers_profile_and_settings_page;
	public RogersWirelessDashboardPage rogers_wireless_dashboard_page;
	public RogersSpeedPassPage rogers_speed_pass_page;
	public RogersAddDataPage rogers_add_data_page;
	public EnsHomePage ensHomePage;
	public EnsNotificationViewPage ensNoteViewPage;
	protected HashMap<String,String> xmlTestParameters;
	protected RogersShareEverythingPage rogers_share_everything_page;
	protected RogersChangeMyCallerIdPage rogers_change_my_caller_id_page;
	protected RogersRegisterPage rogers_register_page;
	protected RogersLinkAccountPage rogers_link_account_page;
	protected RogersBillingPage rogers_billing_page;
	protected RogersChangePaymentMethodPage rogers_change_payment_method_page;
	protected RogersSecurePaymentPage rogers_secure_payment_page;
	protected RogersPaymentOptionsPage rogers_payment_options_page;
	protected RogersMakePaymentPage rogers_make_payment_page;
	protected RogersManageDataPage rogers_manage_data_page;
	protected CommonBusinessFlows common_business_flows; 
	protected VerifyInEns ensVerifications;
	protected RogersSetPasswordPage rogers_set_password_page;
	protected RogersRecoverPassOrNamePage rogers_recover_pass_or_name;
	protected BrowserDrivers browserdriver;
	protected RogersInternetDashboardPage rogers_internet_dashboard_page;
	protected RogersInternetPackageSelectionPage rogers_internet_package_selection_page;
	protected RogersDigitalTVDashboardPage rogers_digital_tv_dashboard_page;
	protected RogersDigitalTVPackageSelectionPage rogers_digital_tv_package_selection_page;
	protected RogersSolarisTVDashboardPage rogers_solaris_tv_dashboard_page;
	protected RogersBuyPage rogers_buy_page;
	protected RogersSolarisRHPDashboardPage rogers_solaris_rhp_dashboard_validation_page;
	protected RogersOrderSummaryPage rogers_order_summary_page;
	protected RogersOrderConfirmationPage rogers_order_confirmation_page;
	protected RogersIgniteTVBuyPage rogers_igniteTV_buy_page;
	protected RogersOrderReviewPage rogers_order_review_page;
	protected RogersIgniteTVProfileCreationPage rogers_igniteTV_profile_creation_page;
	protected RogersIgniteTVCreditCheckPage rogers_igniteTV_credit_check_page;
	protected RogersHomePhoneSelectionPage rogers_home_phone_selection_page;
	protected RogersLegacyBundleBuyPage rogers_legacy_bundle_buy_page;
	protected RogersTechInstallPage rogers_tech_install_page;
	protected RogersSolarisTVChannelsAndThemepacksPage rogers_solaris_tv_channels_and_themepacks_page;
	protected RogersHomePhonePortInPage rogers_home_phone_port_in_page;
	protected RogersInternetUsagePage rogers_internet_usage_page;
	protected RogersBillingPage rogersBillingPage;
	protected RogersWirelessDetailsPage rogers_wireless_details_page;
	protected RogersChangeSEPlanPage rogers_change_se_plan_page;
	protected RogersChangePlanPage rogers_change_plan_page;
	protected RogersChoosePhonePage rogers_choose_phone_page;
	protected RogersBuildPlanPage rogers_build_plan_page;
	protected RogersChooseAddonsPage rogers_choose_addons_page;
	protected RogersCartSummaryPage rogers_cart_summary_page;
	protected RogersWirelessProfileCreationPage rogers_wireless_profile_creation_page;
	protected RogersWirelessCreditEvaluationPage rogers_wireless_credit_evaluation_page;
	protected RogersShippingPage rogers_shipping_page;
	protected RogersChooseNumberPage rogers_choose_number_page;
	protected RogersPaymentPage rogers_payment_page;
	protected RogersChoosePlanPage rogers_choose_plan_page;
	protected EnvironmentSelectionPage environment_selection_page; 
	protected AccountOverViewPage account_over_view_page;
	protected TVDashboardPage tv_dashboard_page;
	protected InternetDashboardPage internet_dashboard_page;
	protected RogersInternetUsageOVPage rogers_internet_usage_ov_page;
	protected HomePhonedashboard home_phone_dashboard;
	protected RogersIgniteBundlesPage rogers_ignite_bundles_page;
	protected CustomerProfilePage customer_Profile_Page;
	protected CreditCheckPage credit_Check_Page;
	protected HomePhoneSelectionPage home_Phone_Selection_Page;
	protected FulfillmentPage fulfillment_Page;
	protected PaymentOptionsPage payment_Options_Page;
	protected OrderReviewPage order_Review_Page;
	protected OrderConfirmationPage order_Confirmation_Page;
	protected ChannelsAndThemePacksPage channels_Theme_Packs_Page;
	protected HomePhoneAddonsPage home_Phone_Addons_Page;
	AppiumServerJava appiumServer = new AppiumServerJava();	
	//int port = 4723;
	
	private CaptchaBypassHandlers captcha_bypass_handlers;
		
		public BaseTestClass() {
			 browserdriver =  new BrowserDrivers();
			 
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
	public void startSession(String strUrl, String strBrowser,  String strLanguage, String strGroupName , Method currentTestMethodName) throws ClientProtocolException, IOException {
		this.driver = browserdriver.driverInit(strBrowser, currentTestMethodName, strGroupName);
		System.out.println(strUrl + "----------------------------------------------------------------------------");
		captcha_bypass_handlers = new CaptchaBypassHandlers(getDriver());
		switch(strGroupName.toLowerCase().trim()) {			
		case "selfserve":
		case "selfserve_login":
			captcha_bypass_handlers.captchaBypassURLSelfserveFlows(strUrl, strLanguage);
			break;
			
		case "connectedhome_legacyanonymous":				
			captcha_bypass_handlers.captchaBypassURLLegacyAnonymousBuyFlows(strUrl, strLanguage); 
			break;	
			
		case "connectedhome_igniteanonymous":				
			captcha_bypass_handlers.captchaBypassURLIgniteAnonymousBuyFlows(strUrl, strLanguage); 
			break;
			
		case "connectedhome_legacylogin":
			captcha_bypass_handlers.captchaBypassURLLegacyLoginFlows(strUrl, strLanguage);
			break; 

		case "connectedhome_ignitelogin":
			captcha_bypass_handlers.captchaBypassURLIgniteLoginFlows(strUrl, strLanguage);
			break; 
			
		case "connectedhome_login":
			captcha_bypass_handlers.captchaBypassURLLoginFlows(strUrl, strLanguage);
			break; 
			
 		default :
 			captcha_bypass_handlers.captchaBypassURLLoginFlows(strUrl, strLanguage);
		}
	    setImplicitWait(getDriver(), 10);
	    init(strGroupName);	 
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
	public void startSession(String strUrl, String strBrowser,  String strLanguage, RogersEnums.GroupName enumGroupName , Method currentTestMethodName) throws ClientProtocolException, IOException {
		startSession(strUrl, strBrowser, strLanguage, enumGroupName.toString().toLowerCase().trim(), currentTestMethodName);
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
	public void startOVSession(String strUrl,  String strBrowser,  String strLanguage, String strGroupName, String strContactID,String strAccNo, String strLoginID,  String strLanID,  Method currentTestMethodName ) throws ClientProtocolException, IOException {
		this.driver = browserdriver.driverInit(strBrowser, currentTestMethodName, strGroupName);
		System.out.println(strUrl + "----------------------------------------------------------------------------");
		captcha_bypass_handlers = new CaptchaBypassHandlers(getDriver());
		captcha_bypass_handlers.chOnewviewFlows(strUrl, strAccNo, strLoginID, strLanID, strLanguage,strBrowser,  currentTestMethodName ,strContactID);
		   setImplicitWait(getDriver(), 10);
		    init(strGroupName);
}
	/**
	 * To initiate the page objects based on test case group, will read group name from xml file.
	 * @param strGroupName string of group name.
	 */
	private void init(String strGroupName) {
		reporter = new ExtentTestManager(getDriver());	
		common_business_flows = new CommonBusinessFlows(this);
		switch(strGroupName) {
		
		case "selfserve":
		case "selfserve_login":
			
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
			break;
			
		case "connectedhome_legacyanonymous":
			
			rogers_home_page = new RogersHomePage(driver);
			rogers_buy_page = new RogersBuyPage(driver);
			rogers_login_page = new RogersLoginPage(driver);
			rogers_internet_package_selection_page = new RogersInternetPackageSelectionPage(driver);
			rogers_digital_tv_dashboard_page = new RogersDigitalTVDashboardPage(driver);
			rogers_digital_tv_package_selection_page = new RogersDigitalTVPackageSelectionPage(driver);
			rogers_order_summary_page = new RogersOrderSummaryPage(driver);
			rogers_order_confirmation_page = new RogersOrderConfirmationPage(driver);
			rogers_order_review_page = new RogersOrderReviewPage(driver);
			rogers_legacy_bundle_buy_page = new RogersLegacyBundleBuyPage(driver);
			rogers_payment_options_page = new RogersPaymentOptionsPage(driver);
			break;
			
		case "connectedhome_igniteanonymous":
			
			rogers_home_page = new RogersHomePage(driver);
			rogers_buy_page = new RogersBuyPage(driver);
			rogers_login_page = new RogersLoginPage(driver);
			rogers_internet_package_selection_page = new RogersInternetPackageSelectionPage(driver);
			rogers_order_summary_page = new RogersOrderSummaryPage(driver);
			rogers_order_confirmation_page = new RogersOrderConfirmationPage(driver);
			rogers_igniteTV_buy_page = new RogersIgniteTVBuyPage(driver);
			rogers_order_review_page = new RogersOrderReviewPage(driver);
			rogers_igniteTV_profile_creation_page = new RogersIgniteTVProfileCreationPage(driver);
			rogers_igniteTV_credit_check_page = new RogersIgniteTVCreditCheckPage(driver);
			rogers_home_phone_selection_page = new RogersHomePhoneSelectionPage(driver);
			rogers_tech_install_page = new RogersTechInstallPage(driver);
			rogers_payment_options_page = new RogersPaymentOptionsPage(driver);
			rogers_solaris_tv_channels_and_themepacks_page = new RogersSolarisTVChannelsAndThemepacksPage(driver);
			rogers_register_page = new RogersRegisterPage(driver);
			rogers_home_phone_port_in_page = new RogersHomePhonePortInPage(driver);
			break;
			
		case "connectedhome_legacylogin":
			
			rogers_home_page = new RogersHomePage(driver);
			rogers_buy_page = new RogersBuyPage(driver);
			rogers_login_page = new RogersLoginPage(driver);
			rogers_account_overview_page = new RogersAccountOverviewPage(driver);
			rogers_internet_dashboard_page = new RogersInternetDashboardPage(driver);
			rogers_internet_package_selection_page = new RogersInternetPackageSelectionPage(driver);
			rogers_digital_tv_dashboard_page = new RogersDigitalTVDashboardPage(driver);
			rogers_digital_tv_package_selection_page = new RogersDigitalTVPackageSelectionPage(driver);
			rogers_order_summary_page = new RogersOrderSummaryPage(driver);
			rogers_order_confirmation_page = new RogersOrderConfirmationPage(driver);
			rogers_order_review_page = new RogersOrderReviewPage(driver);
			rogers_home_phone_selection_page = new RogersHomePhoneSelectionPage(driver);
			rogers_legacy_bundle_buy_page = new RogersLegacyBundleBuyPage(driver);
			rogers_tech_install_page = new RogersTechInstallPage(driver);
			rogers_payment_options_page = new RogersPaymentOptionsPage(driver);
			rogers_igniteTV_credit_check_page = new RogersIgniteTVCreditCheckPage(driver);
			
		case "connectedhome_ignitelogin":
			
			rogers_home_page = new RogersHomePage(driver);
			rogers_buy_page = new RogersBuyPage(driver);
			rogers_login_page = new RogersLoginPage(driver);
			rogers_account_overview_page = new RogersAccountOverviewPage(driver);
			rogers_internet_dashboard_page = new RogersInternetDashboardPage(driver);
			rogers_internet_package_selection_page = new RogersInternetPackageSelectionPage(driver);
			rogers_digital_tv_dashboard_page = new RogersDigitalTVDashboardPage(driver);
			rogers_digital_tv_package_selection_page = new RogersDigitalTVPackageSelectionPage(driver);
			rogers_solaris_tv_dashboard_page = new RogersSolarisTVDashboardPage(driver);
			rogers_order_summary_page = new RogersOrderSummaryPage(driver);
			rogers_order_confirmation_page = new RogersOrderConfirmationPage(driver);
			rogers_igniteTV_buy_page = new RogersIgniteTVBuyPage(driver);
			rogers_internet_usage_page = new RogersInternetUsagePage(driver);
			rogers_order_review_page = new RogersOrderReviewPage(driver);
			rogers_igniteTV_profile_creation_page = new RogersIgniteTVProfileCreationPage(driver);
			rogers_igniteTV_credit_check_page = new RogersIgniteTVCreditCheckPage(driver);
			rogers_home_phone_selection_page = new RogersHomePhoneSelectionPage(driver);
			rogers_tech_install_page = new RogersTechInstallPage(driver);
			rogers_payment_options_page = new RogersPaymentOptionsPage(driver);
			rogers_register_page = new RogersRegisterPage(driver);
			rogers_home_phone_port_in_page = new RogersHomePhonePortInPage(driver);
			rogers_solaris_rhp_dashboard_validation_page = new RogersSolarisRHPDashboardPage(driver);
			rogers_solaris_tv_channels_and_themepacks_page = new RogersSolarisTVChannelsAndThemepacksPage(driver); 
			break;
			
		case "connectedhome_login":
			
			rogers_home_page = new RogersHomePage(driver);
			rogers_buy_page = new RogersBuyPage(driver);
			rogers_login_page = new RogersLoginPage(driver);
			rogers_account_overview_page = new RogersAccountOverviewPage(driver);
			rogers_internet_dashboard_page = new RogersInternetDashboardPage(driver);
			rogers_internet_package_selection_page = new RogersInternetPackageSelectionPage(driver);
			rogers_digital_tv_dashboard_page = new RogersDigitalTVDashboardPage(driver);
			rogers_digital_tv_package_selection_page = new RogersDigitalTVPackageSelectionPage(driver);
			rogers_solaris_tv_dashboard_page = new RogersSolarisTVDashboardPage(getDriver());
			rogers_solaris_rhp_dashboard_validation_page = new RogersSolarisRHPDashboardPage(driver);
			rogers_order_summary_page = new RogersOrderSummaryPage(driver);
			rogers_order_confirmation_page = new RogersOrderConfirmationPage(driver);
			rogers_igniteTV_buy_page = new RogersIgniteTVBuyPage(driver);
			rogers_order_review_page = new RogersOrderReviewPage(driver);
			rogers_solaris_tv_channels_and_themepacks_page = new RogersSolarisTVChannelsAndThemepacksPage(driver);
			rogers_register_page = new RogersRegisterPage(driver);
			rogers_igniteTV_profile_creation_page = new RogersIgniteTVProfileCreationPage(driver);
			rogers_internet_usage_page = new RogersInternetUsagePage(driver);
			rogersBillingPage = new RogersBillingPage(driver);
			rogers_tech_install_page = new RogersTechInstallPage(driver);
			rogers_payment_options_page = new RogersPaymentOptionsPage(driver);
			rogers_igniteTV_credit_check_page = new RogersIgniteTVCreditCheckPage(driver);
			rogers_home_phone_selection_page = new RogersHomePhoneSelectionPage(driver);
			break;
			
		case "buyflows":
			
			rogers_home_page = new RogersHomePage(getDriver());
			rogers_login_page = new RogersLoginPage(getDriver());
			rogers_account_overview_page = new RogersAccountOverviewPage(getDriver());
			rogers_share_everything_page = new RogersShareEverythingPage(getDriver());
			rogers_wireless_details_page = new RogersWirelessDetailsPage(getDriver());
			rogers_change_se_plan_page = new RogersChangeSEPlanPage(getDriver());
			rogers_choose_phone_page = new RogersChoosePhonePage(getDriver());
			rogers_build_plan_page = new RogersBuildPlanPage(getDriver());
			rogers_choose_addons_page = new RogersChooseAddonsPage(getDriver());
			rogers_cart_summary_page = new RogersCartSummaryPage(getDriver());
			rogers_wireless_profile_creation_page = new RogersWirelessProfileCreationPage(getDriver());
			rogers_wireless_credit_evaluation_page = new RogersWirelessCreditEvaluationPage(getDriver());
			rogers_shipping_page = new RogersShippingPage(getDriver());
			rogers_choose_number_page = new RogersChooseNumberPage(getDriver());
			rogers_order_review_page = new RogersOrderReviewPage(getDriver());
			rogers_order_confirmation_page = new RogersOrderConfirmationPage(getDriver());
			rogers_payment_options_page = new RogersPaymentOptionsPage(getDriver());
			rogers_payment_page = new RogersPaymentPage(getDriver());
			rogers_choose_plan_page = new RogersChoosePlanPage(getDriver());
			rogers_change_plan_page = new RogersChangePlanPage(getDriver());
			break;
			
		case "choneview":
			
			environment_selection_page = new EnvironmentSelectionPage(getDriver());
			account_over_view_page= new AccountOverViewPage(getDriver());
			tv_dashboard_page= new TVDashboardPage(getDriver());
			internet_dashboard_page = new InternetDashboardPage(getDriver());
			rogers_internet_usage_page = new RogersInternetUsagePage(getDriver());
			home_phone_dashboard = new HomePhonedashboard(getDriver());
			rogers_ignite_bundles_page=new  RogersIgniteBundlesPage(getDriver());
			customer_Profile_Page=new CustomerProfilePage(getDriver());
			credit_Check_Page=new CreditCheckPage(getDriver());
			home_Phone_Selection_Page=new HomePhoneSelectionPage(getDriver());
			fulfillment_Page=new FulfillmentPage(getDriver());
			payment_Options_Page=new PaymentOptionsPage(getDriver());
			order_Review_Page=new OrderReviewPage(getDriver());
			order_Confirmation_Page=new OrderConfirmationPage(getDriver());
			channels_Theme_Packs_Page=new ChannelsAndThemePacksPage(getDriver());
			home_Phone_Addons_Page=new HomePhoneAddonsPage(getDriver());
			break;
			
		default:
			
		}	
		
	}
	/**
	 * To close session, quit driver and close every associated windows.
	 */
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

	/**
	 * To get the web driver in use.
	 * @return driver, WebDriver which is using
	 */
	public WebDriver getDriver() {
		return this.driver;
	}
	
	
	/**
	 * To get parameters from XML file, it is called in TestListener.
	 * @return HashMap of test parameters
	 */
	public HashMap<String, String> getXMLParameters() {
		return xmlTestParameters;
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
		  			+ ((RemoteWebDriver)driver).getSessionId() + ".json");
		  HttpPut putRequest = new HttpPut(uri);
		  ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		  nameValuePairs.add((new BasicNameValuePair("status", strStatus)));
		  nameValuePairs.add((new BasicNameValuePair("reason", "")));
		  putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		  HttpClientBuilder.create().build().execute(putRequest);
		}
	
}
