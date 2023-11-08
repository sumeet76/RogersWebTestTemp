package com.rogers.test.base;

import com.rogers.oneview.pages.*;
import com.rogers.ovr.pages.*;
import com.rogers.pages.RogersBuildPlanPage;
import com.rogers.pages.RogersChooseAddonsPage;
import com.rogers.pages.RogersChoosePhonePage;
import com.rogers.pages.RogersChoosePlanPage;
import com.rogers.pages.RogersShippingPage;
import com.rogers.pages.RogersWirelessDetailsPage;
import com.rogers.pages.*;
import com.rogers.pages.ens.EnsHomePage;
import com.rogers.pages.ens.EnsNotificationViewPage;
import com.rogers.test.commonbusinessfunctions.CommonBusinessFlows;
import com.rogers.test.commonbusinessfunctions.VerifyInEns;
import com.rogers.test.helpers.CaptchaBypassHandlers;
import com.rogers.test.helpers.DBValidation;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.test.helpers.RogersEnums.SauceCapabilities;
import com.rogers.testdatamanagement.TestDataHandler;
import extentreport.ExtentListener;
import extentreport.ExtentTestManager;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import utils.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


//@Listeners ({com.rogers.test.listeners.TestListener.class ,
//	com.rogers.test.listeners.AnnotationTransformer.class ,
//	com.rogers.test.listeners.TestListener.class })


public class BaseTestClass {

    public enum OS {
        WIN, LIN, MAC
    }

    public enum PaymentMethodType {
        CREDIT, BANK, MANUAL
    }

    ;// Operating systems.

    public Reporter reporter;
    public static DBValidation dbConnection;
    protected static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersHomePage> RogersHomePageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersHTOPromotionPage> RogersHTOPromotionPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersLoginPage> RogersLoginPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersAccountOverviewPage> RogersAccountOverviewPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersProfileAndSettingsPage> RogersProfileAndSettingsPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersWirelessDashboardPage> RogersWirelessDashboardPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersSpeedPassPage> RogersSpeedPassPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersAddDataPage> RogersAddDataPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<EnsHomePage> EnsHomePageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<EnsNotificationViewPage> EnsNotificationViewPageThreadLocal = new ThreadLocal<>();
    protected HashMap<String, String> xmlTestParameters;
    protected static final ThreadLocal<RogersShareEverythingPage> RogersShareEverythingPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersChangeMyCallerIdPage> RogersChangeMyCallerIdPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersRegisterPage> RogersRegisterPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersLinkAccountPage> RogersLinkAccountPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersBillingPage> RogersBillingPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersChangePaymentMethodPage> RogersChangePaymentMethodPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersSecurePaymentPage> RogersSecurePaymentPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersPaymentOptionsPage> RogersPaymentOptionsPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersPaymentHistoryPage> RogersPaymentHistoryPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersMakePaymentPage> RogersMakePaymentPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersManageDataPage> RogersManageDataPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<CommonBusinessFlows> CommonBusinessFlowsThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<VerifyInEns> ensVerificationsThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersSetPasswordPage> RogersSetPasswordPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersRegisterOrAccountRecoveryPage> RogersRecoverPassOrNamePageThreadLocal = new ThreadLocal<>();
    protected BrowserDrivers browserdriver;
    protected static final ThreadLocal<RogersInternetDashboardPage> RogersInternetDashboardPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersChangePackageChannelsNThemePacksPage> RogersChangePackageChannelsNThemePacksPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersInternetPackageSelectionPage> RogersInternetPackageSelectionPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersDigitalTVDashboardPage> RogersDigitalTVDashboardPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersDigitalTVPackageSelectionPage> RogersDigitalTVPackageSelectionPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersSolarisChannelsExchangePage> RogersSolarisChannelsExchangePageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersSolarisTVDashboardPage> RogersSolarisTVDashboardPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersBuyPage> RogersBuyPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersSolarisRHPDashboardPage> RogersSolarisRHPDashboardPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersOrderSummaryPage> RogersOrderSummaryPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersOrderConfirmationPage> RogersOrderConfirmationPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersIgniteTVBuyPage> RogersIgniteTVBuyPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersOrderReviewPage> RogersOrderReviewPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersIgniteTVProfileCreationPage> RogersIgniteTVProfileCreationPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersInternetProfilePage> RogersInternetProfilePageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersIgniteTVCreditCheckPage> RogersIgniteTVCreditCheckPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersInternetCreditCheckPage> RogersInternetCreditCheckPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersHomePhoneSelectionPage> RogersHomePhoneSelectionPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersLegacyBundleBuyPage> RogersLegacyBundleBuyPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersTechInstallPage> RogersTechInstallPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersSolarisTVChannelsAndThemepacksPage> RogersSolarisTVChannelsAndThemepacksPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersHomePhonePortInPage> RogersHomePhonePortInPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersInternetUsagePage> RogersInternetUsagePageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersWirelessDetailsPage> RogersWirelessDetailsPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersChangeSEPlanPage> RogersChangeSEPlanPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersChangePlanPage> RogersChangePlanPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersChoosePhonePage> RogersChoosePhonePageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersBuildPlanPage> RogersBuildPlanPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersChooseAddonsPage> RogersChooseAddonsPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersCartSummaryPage> RogersCartSummaryPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersWirelessProfileCreationPage> RogersWirelessProfileCreationPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersWirelessCreditEvaluationPage> RogersWirelessCreditEvaluationPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersShippingPage> RogersShippingPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersChooseNumberPage> RogersChooseNumberPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersPaymentPage> RogersPaymentPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersChoosePlanPage> RogersChoosePlanPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<EnvironmentSelectionPage> EnvironmentSelectionPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<NacDashboardPage> NacDashboardPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<AccountOverViewPage> AccountOverViewPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<TVDashboardPage> TVDashboardPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<InternetDashboardPage> InternetDashboardPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersInternetUsageOVPage> RogersInternetUsageOVPageThreadLocal = new ThreadLocal<>();

    protected static final ThreadLocal<HomePhonedashboard> HomePhonedashboardThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersIgniteBundlesPage> RogersIgniteBundlesPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersIgniteExchangePage> RogersIgniteExchangePageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersIgniteCampaignPage> RogersIgniteCampaignPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<CustomerProfilePage> CustomerProfilePageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<CreditCheckPage> CreditCheckPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<HomePhoneSelectionPage> HomePhoneSelectionPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<FulfillmentPage> FulfillmentPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<PaymentOptionsPage> PaymentOptionsPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersOVOrderReviewPage> RogersOVOrderReviewPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersOVOrderConfirmationPage> RogersOVOrderConfirmationPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersOVChannelsAndThemePacksPage> RogersOVChannelsAndThemePacksPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<HomePhoneAddonsPage> HomePhoneAddonsPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersSHMDashboardPage> RogersSHMDashboardPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersSmartStreamDashboardPage> RogersSmartStreamDashboardPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<com.rogers.oneview.pages.RogersWirelessDetailsPage> RogersOVWirelessDetailsPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersOVChangeSharePlanPage> RogersOVChangeSharePlanPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<com.rogers.oneview.pages.RogersChoosePhonePage> RogersOVChoosePhonePageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<com.rogers.oneview.pages.RogersBuildPlanPage> RogersOVBuildPlanPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<com.rogers.oneview.pages.RogersChooseAddonsPage> RogersOVChooseAddonsPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<com.rogers.oneview.pages.RogersShippingPage> RogersOVShippingPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<com.rogers.oneview.pages.RogersOVPaymentPage> RogersOVPaymentPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<com.rogers.oneview.pages.RogersChoosePlanPage> RogersOVChoosePlanPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<com.rogers.oneview.pages.RogersOVPlanConfigPage> RogersOVPlanConfigPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<com.rogers.oneview.pages.RogersOVCheckoutPage> RogersOVCheckoutPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<com.rogers.oneview.pages.RogersOVReviewOrderPage> RogersOVReviewOrderPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<com.rogers.oneview.pages.RogersOVOneTimePaymentPage> RogersOVOneTimePaymentPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersSearchPage> RogersSearchPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersDeviceCataloguePage> RogersDeviceCataloguePageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersDeviceConfigPage> RogersDeviceConfigPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersPlanConfigPage> RogersPlanConfigPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersCheckoutPage> RogersCheckoutPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersReviewOrderPage> RogersReviewOrderPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersNACOrderConfirmationPage> RogersNACOrderConfirmationPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersOneTimePaymentPage> RogersOneTimePaymentPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersHomePageServiceability> RogersHomePageServiceabilityThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersSecurityPackagesPage> RogersSecurityPackagesPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<RogersOVInstallationPage> RogersOVInstallationPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<ChampLoginPage> ChampLoginPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<UniLoginPage> UniLoginPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<OVROrderReviewPage> OVROrderReviewPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<OVRAgreementPage> OVRAgreementPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<OVROrderConfirmationPage> OVROrderConfirmationPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<AccountSearchPage> AccountSearchPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<OvrDashboardPage> OvrDashboardPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<CheckAvailabilityPage> CheckAvailabilityPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<BundleBuilderPage>BundleBuilderPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<LNPEligibilityPage>LNPEligibilityPageThreadLocal = new ThreadLocal<>();
    protected  static final  ThreadLocal<CallerInformationPage>CallerInformationPageThreadLocal = new ThreadLocal<>();
    protected static final ThreadLocal<DashboardProfilePage>DASHBOARD_PROFILE_PAGE_THREAD_LOCAL= new ThreadLocal<>();
    protected static final ThreadLocal<DashboardBillingPage>DASHBOARD_BILLING_PAGE_THREAD_LOCAL= new ThreadLocal<>();

    public static CallerInformationPage getCallerInformationPage()
    {
        return CallerInformationPageThreadLocal.get();
    }
    public static RogersPSEFPage getRogersPSEFPage() {
        return RogersPSEFPageThreadLocal.get();
    }

    protected static final ThreadLocal<RogersPSEFPage> RogersPSEFPageThreadLocal = new ThreadLocal<>();

    protected static final ThreadLocal<GetOTP> getOTPThreadLocal = new ThreadLocal<GetOTP>();

    protected static final ThreadLocal<RogersShippingCartPage> RogersShippingCartPageThreadLocal = new ThreadLocal<>();

    AppiumServerJava appiumServer = new AppiumServerJava();
    //int port = 4723;
    private CaptchaBypassHandlers captcha_bypass_handlers;
    private Map<String, String> sauceParameters;
    private Map<String, String> RunParameters;

    public static RogersOVInstallationPage getRogersOVInstallationPage() {
        return RogersOVInstallationPageThreadLocal.get();
    }


    private static final ThreadLocal<RogersFinanceAccessoriesPage> RogersFinanceAccessoriesPagePageThreadLocal = new ThreadLocal<>();

    public BaseTestClass() {
        browserdriver = new BrowserDrivers();
    }

    public static DBValidation getDbConnection(){
        return new DBValidation();
    }

    public Reporter getReporter() {
        return reporter;
    }

    public static RogersHomePage getRogersHomePage() {
        return RogersHomePageThreadLocal.get();
    }

    public static RogersHTOPromotionPage getRogersHTOPRomotionPage() {
        return RogersHTOPromotionPageThreadLocal.get();
    }

    public static RogersLoginPage getRogersLoginPage() {
        return RogersLoginPageThreadLocal.get();
    }

    public static RogersAccountOverviewPage getRogersAccountOverviewPage() {
        return RogersAccountOverviewPageThreadLocal.get();
    }

    public static RogersSecurityPackagesPage getRogersSecurityPackagesPage() {
        return RogersSecurityPackagesPageThreadLocal.get();
    }


    public static RogersProfileAndSettingsPage getRogersProfileAndSettingsPage() {
        return RogersProfileAndSettingsPageThreadLocal.get();
    }

    public static RogersWirelessDashboardPage getRogersWirelessDashboardPage() {
        return RogersWirelessDashboardPageThreadLocal.get();
    }

    public static RogersSpeedPassPage getRogersSpeedPassPage() {
        return RogersSpeedPassPageThreadLocal.get();
    }

    public static RogersAddDataPage getRogersAddDataPage() {
        return RogersAddDataPageThreadLocal.get();
    }

    public static EnsHomePage getEnsHomePage() {
        return EnsHomePageThreadLocal.get();
    }

    public static EnsNotificationViewPage getEnsNotificationViewPage() {
        return EnsNotificationViewPageThreadLocal.get();
    }

    public HashMap<String, String> getXmlTestParameters() {
        return xmlTestParameters;
    }

    public static RogersShareEverythingPage getRogersShareEverythingPage() {
        return RogersShareEverythingPageThreadLocal.get();
    }

    public static RogersChangeMyCallerIdPage getRogersChangeMyCallerIdPage() {
        return RogersChangeMyCallerIdPageThreadLocal.get();
    }

    public static RogersRegisterPage getRogersRegisterPage() {
        return RogersRegisterPageThreadLocal.get();
    }

    public static RogersLinkAccountPage getRogersLinkAccountPage() {
        return RogersLinkAccountPageThreadLocal.get();
    }

    public static RogersBillingPage getRogersBillingPage() {
        return RogersBillingPageThreadLocal.get();
    }

    public static RogersChangePaymentMethodPage getRogersChangePaymentMethodPage() {
        return RogersChangePaymentMethodPageThreadLocal.get();
    }

    public static RogersSecurePaymentPage getRogersSecurePaymentPage() {
        return RogersSecurePaymentPageThreadLocal.get();
    }

    public static RogersPaymentOptionsPage getRogersPaymentOptionsPage() {
        return RogersPaymentOptionsPageThreadLocal.get();
    }

    public static RogersMakePaymentPage getRogersMakePaymentPage() {
        return RogersMakePaymentPageThreadLocal.get();
    }

    public static RogersManageDataPage getRogersManageDataPage() {
        return RogersManageDataPageThreadLocal.get();
    }

    public CommonBusinessFlows getCommonBusinessFlows() {
        return CommonBusinessFlowsThreadLocal.get();
    }

    public VerifyInEns getEnsVerifications() {
        return ensVerificationsThreadLocal.get();
    }

    public static RogersSetPasswordPage getRogersSetPasswordPage() {
        return RogersSetPasswordPageThreadLocal.get();
    }

    public static RogersRegisterOrAccountRecoveryPage getRegisterOrAccountRecoveryPage() {
        return RogersRecoverPassOrNamePageThreadLocal.get();
    }

    public BrowserDrivers getBrowserdriver() {
        return browserdriver;
    }

    public static RogersInternetDashboardPage getRogersInternetDashboardPage() {
        return RogersInternetDashboardPageThreadLocal.get();
    }

    public static RogersChangePackageChannelsNThemePacksPage getRogersChangePackageChannelsNThemePacksPage() {
        return RogersChangePackageChannelsNThemePacksPageThreadLocal.get();
    }

    public static RogersInternetPackageSelectionPage getRogersInternetPackageSelectionPage() {
        return RogersInternetPackageSelectionPageThreadLocal.get();
    }

    public static RogersDigitalTVDashboardPage getRogersDigitalTVDashboardPage() {
        return RogersDigitalTVDashboardPageThreadLocal.get();
    }

    public static RogersDigitalTVPackageSelectionPage getRogersDigitalTVPackageSelectionPage() {
        return RogersDigitalTVPackageSelectionPageThreadLocal.get();
    }

    public static RogersSolarisChannelsExchangePage getRogersSolarisChannelsExchangePage() {
        return RogersSolarisChannelsExchangePageThreadLocal.get();
    }

    public static RogersSolarisTVDashboardPage getRogersSolarisTVDashboardPage() {
        return RogersSolarisTVDashboardPageThreadLocal.get();
    }

    public static RogersBuyPage getRogersBuyPage() {
        return RogersBuyPageThreadLocal.get();
    }

    public static RogersSolarisRHPDashboardPage getRogersSolarisRHPDashboardPage() {
        return RogersSolarisRHPDashboardPageThreadLocal.get();
    }

    public static RogersOrderSummaryPage getRogersOrderSummaryPage() {
        return RogersOrderSummaryPageThreadLocal.get();
    }

    public static RogersOrderConfirmationPage getRogersOrderConfirmationPage() {
        return RogersOrderConfirmationPageThreadLocal.get();
    }

    public static RogersIgniteTVBuyPage getRogersIgniteTVBuyPage() {
        return RogersIgniteTVBuyPageThreadLocal.get();
    }

    public static RogersOrderReviewPage getRogersOrderReviewPage() {
        return RogersOrderReviewPageThreadLocal.get();
    }

    public static RogersIgniteTVProfileCreationPage getRogersIgniteTVProfileCreationPage() {
        return RogersIgniteTVProfileCreationPageThreadLocal.get();
    }

    public static RogersInternetProfilePage getRogersInternetProfilePage() {
        return RogersInternetProfilePageThreadLocal.get();
    }

    public static RogersIgniteTVCreditCheckPage getRogersIgniteTVCreditCheckPage() {
        return RogersIgniteTVCreditCheckPageThreadLocal.get();
    }

    public static RogersInternetCreditCheckPage getRogersInternetCreditCheckPage() {
        return RogersInternetCreditCheckPageThreadLocal.get();
    }

    public static RogersHomePhoneSelectionPage getRogersHomePhoneSelectionPage() {
        return RogersHomePhoneSelectionPageThreadLocal.get();
    }

    public static RogersLegacyBundleBuyPage getRogersLegacyBundleBuyPage() {
        return RogersLegacyBundleBuyPageThreadLocal.get();
    }

    public static RogersTechInstallPage getRogersTechInstallPage() {
        return RogersTechInstallPageThreadLocal.get();
    }

    public static RogersSolarisTVChannelsAndThemepacksPage getRogersSolarisTVChannelsAndThemepacksPage() {
        return RogersSolarisTVChannelsAndThemepacksPageThreadLocal.get();
    }

    public static RogersHomePhonePortInPage getRogersHomePhonePortInPage() {
        return RogersHomePhonePortInPageThreadLocal.get();
    }

    public static RogersInternetUsagePage getRogersInternetUsagePage() {
        return RogersInternetUsagePageThreadLocal.get();
    }

    public static RogersWirelessDetailsPage getRogersWirelessDetailsPage() {
        return RogersWirelessDetailsPageThreadLocal.get();
    }

    public static RogersChangeSEPlanPage getRogersChangeSEPlanPage() {
        return RogersChangeSEPlanPageThreadLocal.get();
    }

    public static RogersChangePlanPage getRogersChangePlanPage() {
        return RogersChangePlanPageThreadLocal.get();
    }

    public static RogersChoosePhonePage getRogersChoosePhonePage() {
        return RogersChoosePhonePageThreadLocal.get();
    }

    public static RogersBuildPlanPage getRogersBuildPlanPage() {
        return RogersBuildPlanPageThreadLocal.get();
    }

    public static RogersChooseAddonsPage getRogersChooseAddonsPage() {
        return RogersChooseAddonsPageThreadLocal.get();
    }

    public static RogersCartSummaryPage getRogersCartSummaryPage() {
        return RogersCartSummaryPageThreadLocal.get();
    }

    public static RogersWirelessProfileCreationPage getRogersWirelessProfileCreationPage() {
        return RogersWirelessProfileCreationPageThreadLocal.get();
    }

    public static RogersWirelessCreditEvaluationPage getRogersWirelessCreditEvaluationPage() {
        return RogersWirelessCreditEvaluationPageThreadLocal.get();
    }

    public static RogersShippingPage getRogersShippingPage() {
        return RogersShippingPageThreadLocal.get();
    }

    public static RogersChooseNumberPage getRogersChooseNumberPage() {
        return RogersChooseNumberPageThreadLocal.get();
    }

    public static RogersPaymentPage getRogersPaymentPage() {
        return RogersPaymentPageThreadLocal.get();
    }

    public static RogersChoosePlanPage getRogersChoosePlanPage() {
        return RogersChoosePlanPageThreadLocal.get();
    }

    public static EnvironmentSelectionPage getEnvironmentSelectionPage() {
        return EnvironmentSelectionPageThreadLocal.get();
    }

    public static NacDashboardPage getNacDashboardPage() {
        return NacDashboardPageThreadLocal.get();
    }

    public static AccountOverViewPage getAccountOverViewPage() {
        return AccountOverViewPageThreadLocal.get();
    }

    public static TVDashboardPage getTVDashboardPage() {
        return TVDashboardPageThreadLocal.get();
    }

    public static InternetDashboardPage getInternetDashboardPage() {
        return InternetDashboardPageThreadLocal.get();
    }

    public static RogersInternetUsageOVPage getRogersInternetUsageOVPage() {
        return RogersInternetUsageOVPageThreadLocal.get();
    }

    public static RogersIgniteBundlesPage getRogersIgniteBundlesPage() {
        return RogersIgniteBundlesPageThreadLocal.get();
    }


    public static RogersIgniteExchangePage getRogersIgniteExchangePage() {
        return RogersIgniteExchangePageThreadLocal.get();
    }

    public static RogersIgniteCampaignPage getRogersIgniteCampaignPage() {
        return RogersIgniteCampaignPageThreadLocal.get();
    }

    public static CustomerProfilePage getCustomerProfilePage() {
        return CustomerProfilePageThreadLocal.get();
    }

    public static CreditCheckPage getCreditCheckPage() {
        return CreditCheckPageThreadLocal.get();
    }

    public static HomePhoneSelectionPage getHomePhoneSelectionPage() {
        return HomePhoneSelectionPageThreadLocal.get();
    }

    public static FulfillmentPage getFulfillmentPage() {
        return FulfillmentPageThreadLocal.get();
    }

    public static PaymentOptionsPage getPaymentOptionsPage() {
        return PaymentOptionsPageThreadLocal.get();
    }

    public static RogersOVOrderReviewPage getRogersOVOrderReviewPage() {
        return RogersOVOrderReviewPageThreadLocal.get();
    }

    public static RogersOVOrderConfirmationPage getRogersOVOrderConfirmationPage() {
        return RogersOVOrderConfirmationPageThreadLocal.get();
    }

    public static RogersOVChannelsAndThemePacksPage getRogersOVChannelsAndThemePacksPage() {
        return RogersOVChannelsAndThemePacksPageThreadLocal.get();
    }

    public static HomePhoneAddonsPage getHomePhoneAddonsPage() {
        return HomePhoneAddonsPageThreadLocal.get();
    }

    public static RogersSHMDashboardPage getRogersSHMDashboardPage() {
        return RogersSHMDashboardPageThreadLocal.get();
    }

    public static RogersSmartStreamDashboardPage getRogersSmartStreamDashboardPage() {
        return RogersSmartStreamDashboardPageThreadLocal.get();
    }

    public static com.rogers.oneview.pages.RogersWirelessDetailsPage getRogersOVWirelessDetailsPage() {
        return RogersOVWirelessDetailsPageThreadLocal.get();
    }

    public static RogersOVChangeSharePlanPage getRogersOVChangeSharePlanPage() {
        return RogersOVChangeSharePlanPageThreadLocal.get();
    }

    public static com.rogers.oneview.pages.HomePhonedashboard getHomePhonedashboard() {
        return HomePhonedashboardThreadLocal.get();
    }

    public static com.rogers.oneview.pages.RogersChoosePhonePage getRogersOVChoosePhonePage() {
        return RogersOVChoosePhonePageThreadLocal.get();
    }

    public static com.rogers.oneview.pages.RogersBuildPlanPage getRogersOVBuildPlanPage() {
        return RogersOVBuildPlanPageThreadLocal.get();
    }

    public static com.rogers.oneview.pages.RogersChooseAddonsPage getRogersOVChooseAddonsPage() {
        return RogersOVChooseAddonsPageThreadLocal.get();
    }

    public static com.rogers.oneview.pages.RogersShippingPage getRogersOVShippingPage() {
        return RogersOVShippingPageThreadLocal.get();
    }

    public static com.rogers.oneview.pages.RogersOVPaymentPage getRogersOVPaymentPage() {
        return RogersOVPaymentPageThreadLocal.get();
    }

    public static com.rogers.oneview.pages.RogersChoosePlanPage getRogersOVChoosePlanPage() {
        return RogersOVChoosePlanPageThreadLocal.get();
    }

    public static com.rogers.oneview.pages.RogersOVPlanConfigPage getRogersOVPlanConfigPage() {
        return RogersOVPlanConfigPageThreadLocal.get();
    }

    public static com.rogers.oneview.pages.RogersOVCheckoutPage getRogersOVCheckoutPage() {
        return RogersOVCheckoutPageThreadLocal.get();
    }

    public static com.rogers.oneview.pages.RogersOVReviewOrderPage getRogersOVReviewOrderPage() {
        return RogersOVReviewOrderPageThreadLocal.get();
    }

    public static com.rogers.oneview.pages.RogersOVOneTimePaymentPage getRogersOVOneTimePaymentPage() {
        return RogersOVOneTimePaymentPageThreadLocal.get();
    }

    public static RogersSearchPage getRogersSearchPage() {
        return RogersSearchPageThreadLocal.get();
    }

    public AppiumServerJava getAppiumServer() {
        return appiumServer;
    }

    public CaptchaBypassHandlers getCaptcha_bypass_handlers() {
        return captcha_bypass_handlers;
    }

    public Map<String, String> getSauceParameters() {
        return sauceParameters;
    }

    public static RogersDeviceCataloguePage getRogersDeviceCataloguePage() {
        return RogersDeviceCataloguePageThreadLocal.get();
    }

    public static RogersDeviceConfigPage getRogersDeviceConfigPage() {
        return RogersDeviceConfigPageThreadLocal.get();
    }

    public static RogersPlanConfigPage getRogersPlanConfigPage() {
        return RogersPlanConfigPageThreadLocal.get();
    }

    public static RogersCheckoutPage getRogersCheckoutPage() {
        return RogersCheckoutPageThreadLocal.get();
    }

    public static RogersReviewOrderPage getRogersReviewOrderPage() {
        return RogersReviewOrderPageThreadLocal.get();
    }

    public static RogersNACOrderConfirmationPage getRogersNACOrderConfirmationPage() {
        return RogersNACOrderConfirmationPageThreadLocal.get();
    }

    public static RogersOneTimePaymentPage getRogersOneTimePaymentPage() {
        return RogersOneTimePaymentPageThreadLocal.get();
    }

    public static RogersPaymentHistoryPage getRogersPaymentHistoryPage() {
        return RogersPaymentHistoryPageThreadLocal.get();
    }

    public static RogersHomePageServiceability getRogersHomePageRogersHomePageServiceability() {
        return RogersHomePageServiceabilityThreadLocal.get();
    }

    public static RogersFinanceAccessoriesPage getRogersFinanceAccessoriesPagePage() {
        return RogersFinanceAccessoriesPagePageThreadLocal.get();
    }

    public static ChampLoginPage getChampLoginPage() {
        return ChampLoginPageThreadLocal.get();
    }

    public static UniLoginPage getUniLoginPage() {
        return UniLoginPageThreadLocal.get();
    }

    public static AccountSearchPage getAccountSearchPage() {
        return AccountSearchPageThreadLocal.get();
    }

    public static OvrDashboardPage getOvrDashboardPage() {
        return OvrDashboardPageThreadLocal.get();
    }

    public static CheckAvailabilityPage getCheckAvailabilityPage() {
        return CheckAvailabilityPageThreadLocal.get();
    }

    public static BundleBuilderPage getBundleBuilderPage() {
        return BundleBuilderPageThreadLocal.get();
    }

    public static LNPEligibilityPage getLNPEligibilityPage() {
        return LNPEligibilityPageThreadLocal.get();
    }

    public static OVROrderReviewPage getOVROrderReviewPage() {return OVROrderReviewPageThreadLocal.get();}

    public  static OVRAgreementPage getOVRAgreementPage() {return  OVRAgreementPageThreadLocal.get();}

    public static OVROrderConfirmationPage getOVROrderConfirmationPage() {return  OVROrderConfirmationPageThreadLocal.get();}

    public static DashboardProfilePage getDashboardProfilePage() {
        return DASHBOARD_PROFILE_PAGE_THREAD_LOCAL.get();
    }
    public static RogersShippingCartPage getRogersShippingCartPage() {
        return RogersShippingCartPageThreadLocal.get();
    }

    public static DashboardBillingPage getDashboardBillingPage() {
        return DASHBOARD_BILLING_PAGE_THREAD_LOCAL.get();
    }

    public Map<String, String> getRunParameters() {
        return RunParameters;
    }

    /**
     * To start a session using given url, browser, language and test case group name.
     *
     * @param strUrl                string of test url
     * @param strBrowser            string of browser name
     * @param strLanguage           string of language to use
     * @param strGroupName          string of group name of the test case
     * @param currentTestMethodName
     * @throws ClientProtocolException org.apache.http.client.ClientProtocolException, Signals an error in the HTTP protocol.
     * @throws IOException             java.io.IOException, Signals that an I/O exception of some sort has occurred, produced by failed or interrupted I/O operations.
     */
    public void startSession(String strUrl, String strBrowser, String strLanguage, String strGroupName, Method currentTestMethodName) throws ClientProtocolException, IOException {
        RunParameters = getExecutionParameters(strBrowser, strLanguage);
        String browser = RunParameters.get("Browser").toLowerCase();
        String language = RunParameters.get("Language").toLowerCase();
        if (browser.contains("sauce")) {
            sauceParameters = initializeSauceParamsMap(browser,strGroupName);;
        }
        webDriverThreadLocal.set(browserdriver.driverInit(browser, sauceParameters, currentTestMethodName, strGroupName));
        ExtentListener.setDriver(getDriver());
        System.out.println(strUrl + "----------------------------------------------------------------------------");
        captcha_bypass_handlers = new CaptchaBypassHandlers(getDriver());
        getOTPThreadLocal.set(new GetOTP());
        switch (strGroupName.toLowerCase().trim()) {
            case "selfserve":
            case "selfserve_login":
            case "mobile_selfserve":
                setImplicitWait(getDriver(), 10);
                getDriver().get(strUrl + "/consumer/easyloginriverpage" + "?setLanguage=" + language);
                captcha_bypass_handlers.captchaBypassUrlLoginFlows(strUrl, language);
                break;

            case "connectedhome_legacyanonymous":
                setImplicitWait(getDriver(), 10);
                getDriver().get(strUrl + "/web/totes/api/v1/bypassCaptchaAuth");
                captcha_bypass_handlers.captchaBypassURLLegacyAnonymousBuyFlows(strUrl, language);
                break;

            case "connectedhome_igniteanonymous":
                setImplicitWait(getDriver(), 10);
//                getDriver().get(strUrl + "/web/totes/browsebuy/v1/byPassCaptcha");
//                captcha_bypass_handlers.captchaBypassURLIgniteAnonymousBuyFlows(strUrl, language);
                break;

            case "connectedhome_shm":
                setImplicitWait(getDriver(), 10);
                getDriver().get(strUrl + "/home-security/security-packages"+ "?setLanguage=" + language);
                break;

            case "connectedhome_shmautomation":
                setImplicitWait(getDriver(), 10);
                getDriver().get(strUrl + "/home-security/automation-packages"+ "?setLanguage=" + language);
                break;

            case "connectedhome_legacylogin":
                setImplicitWait(getDriver(), 10);
                getDriver().get(strUrl + "/web/totes/api/v1/bypassCaptchaAuth");
//                getDriver().manage().deleteAllCookies();
                getDriver().get(strUrl + "/consumer/easyloginriverpage" + "?setLanguage=" + language);
                captcha_bypass_handlers.captchaBypassUrlLoginFlows(strUrl, language);
                break;

            case "connectedhome_ignitelogin":
                setImplicitWait(getDriver(), 10);
                getDriver().get(strUrl + "/web/totes/browsebuy/v1/byPassCaptcha");
                getDriver().get(strUrl + "/consumer/easyloginriverpage" + "?setLanguage=" + language);
                captcha_bypass_handlers.captchaBypassUrlLoginFlows(strUrl, language);
                break;

            case "connectedhome_login":
                setImplicitWait(getDriver(), 10);
//                getDriver().get(strUrl + "/consumer/profile/signin");
                getDriver().get(strUrl + "/consumer/easyloginriverpage" + "?setLanguage=" + language);
                captcha_bypass_handlers.captchaBypassUrlLoginFlows(strUrl, language);
                break;

            case "redesignrogers":
            case "buyflows":
                setImplicitWait(getDriver(), 10);
                getDriver().get(strUrl+"/phones");
//                setCookie(strUrl);
                if(currentTestMethodName.getDeclaringClass().getSimpleName().toUpperCase().contains("NAC_BYOD")) {
                    getDriver().get(strUrl + "/phones/bring-your-own-device?flowType=byod" + "?setLanguage=" + language + "&province=" + "ON");
//                    captcha_bypass_handlers.captchaBypassUrlLoginFlows(strUrl, language);
                }else if(currentTestMethodName.getDeclaringClass().getSimpleName().toUpperCase().contains("NAC") && !(currentTestMethodName.getDeclaringClass().getSimpleName().toUpperCase().contains("SOHO"))){
                    getDriver().get(strUrl + "/phones/" + "?setLanguage=" + language + "&province=" + "ON");
//                    captcha_bypass_handlers.captchaBypassUrlLoginFlows(strUrl, language);
                }else if(currentTestMethodName.getDeclaringClass().getSimpleName().toUpperCase().contains("SOHO") && currentTestMethodName.getDeclaringClass().getSimpleName().toUpperCase().contains("NAC")){
                    getDriver().get(strUrl + "/phones/" + "?type=soho");
                }else if(currentTestMethodName.getDeclaringClass().getSimpleName().toUpperCase().contains("BFA_PROD")) {
                    getDriver().get(strUrl);
//                    captcha_bypass_handlers.captchaBypassUrlLoginFlows(strUrl, language);
                }else{
                    getDriver().get(strUrl + "/consumer/easyloginriverpage" + "?setLanguage=" + language + "&?province=" + "ON");
//                    captcha_bypass_handlers.captchaBypassUrlLoginFlows(strUrl, language);
                }
                break;

            case "serviceability":
            case "buyflowsoneview":
                setImplicitWait(getDriver(), 10);
                getDriver().get(strUrl);
                break;

            case "search":
                getDriver().get(strUrl + "&language=" + System.getProperty("Language").toLowerCase());
                setImplicitWait(getDriver(), 30);
                break;

            case "ovr":
                getDriver().get(strUrl);
                setImplicitWait(getDriver(), 10);
                break;

            default:
                setImplicitWait(getDriver(), 10);
                getDriver().get(strUrl + "?setLanguage=" + language);
                captcha_bypass_handlers.captchaBypassUrlLoginFlows(strUrl, language);
        }

        getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        if (!(browser.contains("sauceandroid") || browser.contains("sauceios"))) {
            getDriver().manage().window().maximize();
        }
        init(strGroupName);
    }

    /**
     * For Buysflows tests to add env headers using DevTools
     */
    private void addEnvHeader(){
        DevToolsUtils utils = new DevToolsUtils();
        DevTools devTools = utils.enableDevTools(getDriver());
        utils.addExtraHeader(devTools, "x-envrnmt", "aks");
        utils.addExtraHeader(devTools, "Pragma", "akamai-x-get-cache-key");
        utils.addExtraHeader(devTools, "X-Akamai-Debug", "RogersFidoHeaders");
    }

    /**
     * This method will initialize a hash map with the sauce parameters
     *
     * @param strBrowser string containing the browser name for sauce
     * @param strGroupName string containing the project name which passing as build name for sauce
     * @return hashmap with sauce capabilities
     * @author Mirza.Kamran
     */
    private Map<String, String> initializeSauceParamsMap(String strBrowser, String strGroupName) {

        Map<String, String> sauceOptions = new HashMap<String, String>();
        sauceOptions.put(SauceCapabilities.seleniumVersion.toString(), TestDataHandler.sauceSettings.getSauceOptions().getSeleniumVersion());
        sauceOptions.put(SauceCapabilities.maxDuration.toString(), TestDataHandler.sauceSettings.getSauceOptions().getMaxDuration());
        sauceOptions.put(SauceCapabilities.commandTimeout.toString(), TestDataHandler.sauceSettings.getSauceOptions().getCommandTimeout());
        sauceOptions.put(SauceCapabilities.idleTimeout.toString(), TestDataHandler.sauceSettings.getSauceOptions().getIdleTimeout());
        //sauceOptions.put(SauceCapabilities.build.toString(), TestDataHandler.sauceSettings.getSauceOptions().getBuild());
        sauceOptions.put(SauceCapabilities.build.toString(), strGroupName.toUpperCase());
        switch (strBrowser.toLowerCase()) {
            case "saucechrome":
                sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getMutableChromeCapabilities().getPlatformName());
                sauceOptions.put(SauceCapabilities.browserVersion.toString(), TestDataHandler.sauceSettings.getMutableChromeCapabilities().getBrowserVersion());
                sauceOptions.put(SauceCapabilities.screenResolution.toString(), TestDataHandler.sauceSettings.getMutableChromeCapabilities().getScreenResolution());
                break;
            case "saucefirefox":
                sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getMutableFireFoxCapabilities().getPlatformName());
                sauceOptions.put(SauceCapabilities.browserVersion.toString(), TestDataHandler.sauceSettings.getMutableFireFoxCapabilities().getBrowserVersion());
                break;
            case "sauceedge":
                sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getMutableEdgeCapabilities().getPlatformName());
                sauceOptions.put(SauceCapabilities.browserVersion.toString(), TestDataHandler.sauceSettings.getMutableEdgeCapabilities().getBrowserVersion());
                break;
            case "saucesafari":
                sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getMutableSafariCapabilities().getPlatformName());
                sauceOptions.put(SauceCapabilities.browserVersion.toString(), TestDataHandler.sauceSettings.getMutableSafariCapabilities().getBrowserVersion());
                sauceOptions.put(SauceCapabilities.screenResolution.toString(), TestDataHandler.sauceSettings.getMutableSafariCapabilities().getScreenResolution());
                break;
            case "sauceandroidchrome":
                sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getAndroidChromeCapabilities().getPlatformName());
                sauceOptions.put(SauceCapabilities.platformVersion.toString(), TestDataHandler.sauceSettings.getAndroidChromeCapabilities().getPlatformVersion());
                sauceOptions.put(SauceCapabilities.appiumVersion.toString(), TestDataHandler.sauceSettings.getAndroidChromeCapabilities().getAppiumVersion());
                sauceOptions.put(SauceCapabilities.deviceName.toString(), TestDataHandler.sauceSettings.getAndroidChromeCapabilities().getDeviceName());
                sauceOptions.put(SauceCapabilities.deviceOrientation.toString(), TestDataHandler.sauceSettings.getAndroidChromeCapabilities().getDeviceOrientation());
                break;
            case "sauceioschrome":
            case "sauceiossafari":
                sauceOptions.put(SauceCapabilities.appiumVersion.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getAppiumVersion());
                sauceOptions.put(SauceCapabilities.deviceName.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getDeviceName());
                sauceOptions.put(SauceCapabilities.deviceOrientation.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getDeviceOrientation());
                sauceOptions.put(SauceCapabilities.platformVersion.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getPlatformVersion());
                sauceOptions.put(SauceCapabilities.platformName.toString(), TestDataHandler.sauceSettings.getIosSafariCapabilities().getPlatformName());
                break;
        }

        return sauceOptions;
    }


    /**
     * To start a session using given url, browser, language and test case group name.
     *
     * @param strUrl                string of test url
     * @param strBrowser            string of browser name
     * @param strLanguage           string of language to use
     * @param enumGroupName         string of group name of the test case
     * @param currentTestMethodName
     * @throws ClientProtocolException org.apache.http.client.ClientProtocolException, Signals an error in the HTTP protocol.
     * @throws IOException             java.io.IOException, Signals that an I/O exception of some sort has occurred, produced by failed or interrupted I/O operations.
     */
    public void startSession(String strUrl, String strBrowser, String strLanguage, RogersEnums.GroupName enumGroupName, Method currentTestMethodName) throws ClientProtocolException, IOException {
        startSession(strUrl, strBrowser, strLanguage, enumGroupName.toString().toLowerCase().trim(), currentTestMethodName);
    }

    /**
     * To start a session using given url, browser, language and test case group name.
     *
     * @param strUrl                string of test url
     * @param strBrowser            string of browser name
     * @param strLanguage           string of language to use
     * @param strGroupName          string of group name of the test case
     * @param currentTestMethodName
     * @throws ClientProtocolException org.apache.http.client.ClientProtocolException, Signals an error in the HTTP protocol.
     * @throws IOException             java.io.IOException, Signals that an I/O exception of some sort has occurred, produced by failed or interrupted I/O operations.
     */
    public void startOVSession(String strUrl, String strBrowser, String strLanguage, String strGroupName, String strContactID, String strAccNo, String strLoginID, String strLanID, Method currentTestMethodName) throws ClientProtocolException, IOException {
        RunParameters = getExecutionParameters(strBrowser, strLanguage);
        String browser = RunParameters.get("Browser").toLowerCase();
        String language = RunParameters.get("Language").toLowerCase();
        if (browser.contains("sauce")) {
            sauceParameters = initializeSauceParamsMap(browser,strGroupName);
        }
        webDriverThreadLocal.set(browserdriver.driverInit(browser, sauceParameters, currentTestMethodName, strGroupName));
        ExtentListener.setDriver(getDriver());
        System.out.println(strUrl + "----------------------------------------------------------------------------");
        captcha_bypass_handlers = new CaptchaBypassHandlers(getDriver());
        captcha_bypass_handlers.chOnewviewFlows(strUrl, strAccNo, strLoginID, strLanID, language, browser, currentTestMethodName, strContactID);
        setImplicitWait(getDriver(), 10);
        init(strGroupName);
    }

    /**
     * To start a session using given url, browser, language and test case group name.
     *
     * @param strUrl                string of test url
     * @param strBrowser            string of browser name
     * @param strLanguage           string of language to use
     * @param strGroupName          string of group name of the test case
     * @param currentTestMethodName
     * @throws ClientProtocolException org.apache.http.client.ClientProtocolException, Signals an error in the HTTP protocol.
     * @throws IOException             java.io.IOException, Signals that an I/O exception of some sort has occurred, produced by failed or interrupted I/O operations.
     */
    public void startOVNACSession(String strUrl, String strBrowser, String strLanguage, String strGroupName, String strContactID, String strLoginID, String strLanID, Method currentTestMethodName) throws ClientProtocolException, IOException {
        RunParameters = getExecutionParameters(strBrowser, strLanguage);
        String browser = RunParameters.get("Browser").toLowerCase();
        String language = RunParameters.get("Language").toLowerCase();
        if (browser.contains("sauce")) {
            sauceParameters = initializeSauceParamsMap(browser,strGroupName);
        }
        webDriverThreadLocal.set(browserdriver.driverInit(browser, sauceParameters, currentTestMethodName, strGroupName));
        ExtentListener.setDriver(getDriver());
        System.out.println(strUrl + "----------------------------------------------------------------------------");
        captcha_bypass_handlers = new CaptchaBypassHandlers(getDriver());
        captcha_bypass_handlers.chOnewviewNACFlows(strUrl, strLoginID, strLanID, language, browser, currentTestMethodName, strContactID);
        setImplicitWait(getDriver(), 10);
        init(strGroupName);
    }


    /**
     * To initiate the page objects based on test case group, will read group name from xml file.
     *
     * @param strGroupName string of group name.
     */
    private void init(String strGroupName) {
        reporter = new ExtentTestManager(getDriver());
        CommonBusinessFlowsThreadLocal.set(new CommonBusinessFlows(this));
        switch (strGroupName) {

            case "search":
                RogersSearchPageThreadLocal.set(new RogersSearchPage(getDriver()));
                RogersDeviceConfigPageThreadLocal.set(new RogersDeviceConfigPage(getDriver()));
                break;

            case "selfserve":
            case "selfserve_login":
                RogersHomePageThreadLocal.set(new RogersHomePage(getDriver()));
                RogersLoginPageThreadLocal.set(new RogersLoginPage(getDriver()));
                RogersShareEverythingPageThreadLocal.set(new RogersShareEverythingPage(getDriver()));
                RogersChangeMyCallerIdPageThreadLocal.set(new RogersChangeMyCallerIdPage(getDriver()));
                RogersWirelessDashboardPageThreadLocal.set(new RogersWirelessDashboardPage(getDriver()));
                RogersAddDataPageThreadLocal.set(new RogersAddDataPage(getDriver()));
                RogersManageDataPageThreadLocal.set(new RogersManageDataPage(getDriver()));
                RogersSpeedPassPageThreadLocal.set(new RogersSpeedPassPage(getDriver()));
                RogersRegisterPageThreadLocal.set(new RogersRegisterPage(getDriver()));
                RogersLinkAccountPageThreadLocal.set(new RogersLinkAccountPage(getDriver()));
                RogersBillingPageThreadLocal.set(new RogersBillingPage(getDriver()));
                RogersChangePaymentMethodPageThreadLocal.set(new RogersChangePaymentMethodPage(getDriver()));
                RogersSecurePaymentPageThreadLocal.set(new RogersSecurePaymentPage(getDriver()));
                RogersProfileAndSettingsPageThreadLocal.set(new RogersProfileAndSettingsPage(getDriver()));
                RogersPaymentOptionsPageThreadLocal.set(new RogersPaymentOptionsPage(getDriver()));
                RogersPaymentHistoryPageThreadLocal.set(new RogersPaymentHistoryPage(getDriver()));
                RogersMakePaymentPageThreadLocal.set(new RogersMakePaymentPage(getDriver()));
                CommonBusinessFlowsThreadLocal.set(new CommonBusinessFlows(this));
                EnsHomePageThreadLocal.set(new EnsHomePage(getDriver()));
                EnsNotificationViewPageThreadLocal.set(new EnsNotificationViewPage(getDriver()));
                ensVerificationsThreadLocal.set(new VerifyInEns(this));
                RogersSetPasswordPageThreadLocal.set(new RogersSetPasswordPage(getDriver()));
                RogersRecoverPassOrNamePageThreadLocal.set(new RogersRegisterOrAccountRecoveryPage(getDriver()));
                RogersSolarisRHPDashboardPageThreadLocal.set(new RogersSolarisRHPDashboardPage(getDriver()));
                RogersInternetDashboardPageThreadLocal.set(new RogersInternetDashboardPage(getDriver()));
                RogersInternetUsagePageThreadLocal.set(new RogersInternetUsagePage(getDriver()));
                RogersSolarisTVDashboardPageThreadLocal.set(new RogersSolarisTVDashboardPage(getDriver()));
                RogersDigitalTVDashboardPageThreadLocal.set(new RogersDigitalTVDashboardPage(getDriver()));
                RogersAccountOverviewPageThreadLocal.set(new RogersAccountOverviewPage(getDriver()));
                RogersSHMDashboardPageThreadLocal.set(new RogersSHMDashboardPage(getDriver()));
                RogersFinanceAccessoriesPagePageThreadLocal.set(new RogersFinanceAccessoriesPage(getDriver()));
                RogersPSEFPageThreadLocal.set(new RogersPSEFPage(getDriver()));
            break;

            case "connectedhome_legacyanonymous":

                RogersHomePageThreadLocal.set(new RogersHomePage(getDriver()));
                RogersBuyPageThreadLocal.set(new RogersBuyPage(getDriver()));
                RogersLoginPageThreadLocal.set(new RogersLoginPage(getDriver()));
                RogersInternetPackageSelectionPageThreadLocal.set(new RogersInternetPackageSelectionPage(getDriver()));
                RogersDigitalTVDashboardPageThreadLocal.set(new RogersDigitalTVDashboardPage(getDriver()));
                RogersDigitalTVPackageSelectionPageThreadLocal.set(new RogersDigitalTVPackageSelectionPage(getDriver()));
                RogersOrderSummaryPageThreadLocal.set(new RogersOrderSummaryPage(getDriver()));
                RogersOrderConfirmationPageThreadLocal.set(new RogersOrderConfirmationPage(getDriver()));
                RogersOrderReviewPageThreadLocal.set(new RogersOrderReviewPage(getDriver()));
                RogersLegacyBundleBuyPageThreadLocal.set(new RogersLegacyBundleBuyPage(getDriver()));
                RogersPaymentOptionsPageThreadLocal.set(new RogersPaymentOptionsPage(getDriver()));
                break;

            case "connectedhome_igniteanonymous":
                RogersHomePageThreadLocal.set(new RogersHomePage(getDriver()));
                RogersBuyPageThreadLocal.set(new RogersBuyPage(getDriver()));
                RogersLoginPageThreadLocal.set(new RogersLoginPage(getDriver()));
                RogersAccountOverviewPageThreadLocal.set(new RogersAccountOverviewPage(getDriver()));
                RogersInternetPackageSelectionPageThreadLocal.set(new RogersInternetPackageSelectionPage(getDriver()));
                RogersHTOPromotionPageThreadLocal.set(new RogersHTOPromotionPage(getDriver()));
                RogersOrderSummaryPageThreadLocal.set(new RogersOrderSummaryPage(getDriver()));
                RogersOrderConfirmationPageThreadLocal.set(new RogersOrderConfirmationPage(getDriver()));
                RogersIgniteTVBuyPageThreadLocal.set(new RogersIgniteTVBuyPage(getDriver()));
                RogersOrderReviewPageThreadLocal.set(new RogersOrderReviewPage(getDriver()));
                RogersIgniteTVProfileCreationPageThreadLocal.set(new RogersIgniteTVProfileCreationPage(getDriver()));
                RogersIgniteTVCreditCheckPageThreadLocal.set(new RogersIgniteTVCreditCheckPage(getDriver()));
                RogersHomePhoneSelectionPageThreadLocal.set(new RogersHomePhoneSelectionPage(getDriver()));
                RogersTechInstallPageThreadLocal.set(new RogersTechInstallPage(getDriver()));
                RogersPaymentOptionsPageThreadLocal.set(new RogersPaymentOptionsPage(getDriver()));
                RogersSolarisTVChannelsAndThemepacksPageThreadLocal.set(new RogersSolarisTVChannelsAndThemepacksPage(getDriver()));
                RogersRegisterPageThreadLocal.set(new RogersRegisterPage(getDriver()));
                RogersHomePhonePortInPageThreadLocal.set(new RogersHomePhonePortInPage(getDriver()));
                RogersInternetProfilePageThreadLocal.set(new RogersInternetProfilePage(getDriver()));
                RogersInternetCreditCheckPageThreadLocal.set(new RogersInternetCreditCheckPage(getDriver()));
                break;

            case "connectedhome_shm":
            case "connectedhome_shmautomation":
                RogersSecurityPackagesPageThreadLocal.set(new RogersSecurityPackagesPage(getDriver()));
                break;

            case "connectedhome_legacylogin":
                EnsHomePageThreadLocal.set(new EnsHomePage(getDriver()));
                EnsNotificationViewPageThreadLocal.set(new EnsNotificationViewPage(getDriver()));
                ensVerificationsThreadLocal.set(new VerifyInEns(this));
                RogersRecoverPassOrNamePageThreadLocal.set(new RogersRegisterOrAccountRecoveryPage(getDriver()));
                RogersHomePageThreadLocal.set(new RogersHomePage(getDriver()));
                RogersBuyPageThreadLocal.set(new RogersBuyPage(getDriver()));
                RogersLoginPageThreadLocal.set(new RogersLoginPage(getDriver()));
                RogersAccountOverviewPageThreadLocal.set(new RogersAccountOverviewPage(getDriver()));
                RogersInternetDashboardPageThreadLocal.set(new RogersInternetDashboardPage(getDriver()));
                RogersInternetPackageSelectionPageThreadLocal.set(new RogersInternetPackageSelectionPage(getDriver()));
                RogersDigitalTVDashboardPageThreadLocal.set(new RogersDigitalTVDashboardPage(getDriver()));
                RogersDigitalTVPackageSelectionPageThreadLocal.set(new RogersDigitalTVPackageSelectionPage(getDriver()));
                RogersOrderSummaryPageThreadLocal.set(new RogersOrderSummaryPage(getDriver()));
                RogersOrderConfirmationPageThreadLocal.set(new RogersOrderConfirmationPage(getDriver()));
                RogersOrderReviewPageThreadLocal.set(new RogersOrderReviewPage(getDriver()));
                RogersHomePhoneSelectionPageThreadLocal.set(new RogersHomePhoneSelectionPage(getDriver()));
                RogersLegacyBundleBuyPageThreadLocal.set(new RogersLegacyBundleBuyPage(getDriver()));
                RogersTechInstallPageThreadLocal.set(new RogersTechInstallPage(getDriver()));
                RogersPaymentOptionsPageThreadLocal.set(new RogersPaymentOptionsPage(getDriver()));
                RogersIgniteTVCreditCheckPageThreadLocal.set(new RogersIgniteTVCreditCheckPage(getDriver()));
                RogersHTOPromotionPageThreadLocal.set(new RogersHTOPromotionPage(getDriver()));
                RogersReviewOrderPageThreadLocal.set(new RogersReviewOrderPage(getDriver()));
                RogersTechInstallPageThreadLocal.set(new RogersTechInstallPage(getDriver()));
            case "connectedhome_ignitelogin":
                RogersHomePageThreadLocal.set(new RogersHomePage(getDriver()));
                RogersBuyPageThreadLocal.set(new RogersBuyPage(getDriver()));
                RogersHTOPromotionPageThreadLocal.set(new RogersHTOPromotionPage(getDriver()));
                RogersReviewOrderPageThreadLocal.set(new RogersReviewOrderPage(getDriver()));
                RogersLoginPageThreadLocal.set(new RogersLoginPage(getDriver()));
                RogersAccountOverviewPageThreadLocal.set(new RogersAccountOverviewPage(getDriver()));
                RogersInternetDashboardPageThreadLocal.set(new RogersInternetDashboardPage(getDriver()));
                RogersChangePackageChannelsNThemePacksPageThreadLocal.set(new RogersChangePackageChannelsNThemePacksPage(getDriver()));
                RogersInternetPackageSelectionPageThreadLocal.set(new RogersInternetPackageSelectionPage(getDriver()));
                RogersDigitalTVDashboardPageThreadLocal.set(new RogersDigitalTVDashboardPage(getDriver()));
                RogersDigitalTVPackageSelectionPageThreadLocal.set(new RogersDigitalTVPackageSelectionPage(getDriver()));
                RogersSolarisTVDashboardPageThreadLocal.set(new RogersSolarisTVDashboardPage(getDriver()));
                RogersOrderSummaryPageThreadLocal.set(new RogersOrderSummaryPage(getDriver()));
                RogersOrderConfirmationPageThreadLocal.set(new RogersOrderConfirmationPage(getDriver()));
                RogersIgniteTVBuyPageThreadLocal.set(new RogersIgniteTVBuyPage(getDriver()));
                RogersInternetUsagePageThreadLocal.set(new RogersInternetUsagePage(getDriver()));
                RogersOrderReviewPageThreadLocal.set(new RogersOrderReviewPage(getDriver()));
                RogersIgniteTVProfileCreationPageThreadLocal.set(new RogersIgniteTVProfileCreationPage(getDriver()));
                RogersIgniteTVCreditCheckPageThreadLocal.set(new RogersIgniteTVCreditCheckPage(getDriver()));
                RogersHomePhoneSelectionPageThreadLocal.set(new RogersHomePhoneSelectionPage(getDriver()));
                RogersTechInstallPageThreadLocal.set(new RogersTechInstallPage(getDriver()));
                RogersPaymentOptionsPageThreadLocal.set(new RogersPaymentOptionsPage(getDriver()));
                RogersRegisterPageThreadLocal.set(new RogersRegisterPage(getDriver()));
                RogersHomePhonePortInPageThreadLocal.set(new RogersHomePhonePortInPage(getDriver()));
                RogersSolarisRHPDashboardPageThreadLocal.set(new RogersSolarisRHPDashboardPage(getDriver()));
                RogersSolarisTVChannelsAndThemepacksPageThreadLocal.set(new RogersSolarisTVChannelsAndThemepacksPage(getDriver()));
                RogersSmartStreamDashboardPageThreadLocal.set(new RogersSmartStreamDashboardPage(getDriver()));
                RogersSHMDashboardPageThreadLocal.set(new RogersSHMDashboardPage(getDriver()));
                RogersIgniteBundlesPageThreadLocal.set(new RogersIgniteBundlesPage(getDriver()));
                break;

            case "connectedhome_login":

                RogersRecoverPassOrNamePageThreadLocal.set(new RogersRegisterOrAccountRecoveryPage(getDriver()));
                EnsHomePageThreadLocal.set(new EnsHomePage(getDriver()));
                EnsNotificationViewPageThreadLocal.set(new EnsNotificationViewPage(getDriver()));
                ensVerificationsThreadLocal.set(new VerifyInEns(this));
                RogersHomePageThreadLocal.set(new RogersHomePage(getDriver()));
                RogersHTOPromotionPageThreadLocal.set(new RogersHTOPromotionPage(getDriver()));
                RogersBuyPageThreadLocal.set(new RogersBuyPage(getDriver()));
                RogersLoginPageThreadLocal.set(new RogersLoginPage(getDriver()));
                RogersChangePackageChannelsNThemePacksPageThreadLocal.set(new RogersChangePackageChannelsNThemePacksPage(getDriver()));
                RogersAccountOverviewPageThreadLocal.set(new RogersAccountOverviewPage(getDriver()));
                RogersInternetDashboardPageThreadLocal.set(new RogersInternetDashboardPage(getDriver()));
                RogersInternetPackageSelectionPageThreadLocal.set(new RogersInternetPackageSelectionPage(getDriver()));
                RogersDigitalTVDashboardPageThreadLocal.set(new RogersDigitalTVDashboardPage(getDriver()));
                RogersDigitalTVPackageSelectionPageThreadLocal.set(new RogersDigitalTVPackageSelectionPage(getDriver()));
                RogersSolarisTVDashboardPageThreadLocal.set(new RogersSolarisTVDashboardPage(getDriver()));
                RogersIgniteBundlesPageThreadLocal.set(new RogersIgniteBundlesPage(getDriver()));
                RogersSolarisRHPDashboardPageThreadLocal.set(new RogersSolarisRHPDashboardPage(getDriver()));
                RogersOrderSummaryPageThreadLocal.set(new RogersOrderSummaryPage(getDriver()));
                RogersOrderConfirmationPageThreadLocal.set(new RogersOrderConfirmationPage(getDriver()));
                RogersIgniteTVBuyPageThreadLocal.set(new RogersIgniteTVBuyPage(getDriver()));
                RogersOrderReviewPageThreadLocal.set(new RogersOrderReviewPage(getDriver()));
                RogersSolarisTVChannelsAndThemepacksPageThreadLocal.set(new RogersSolarisTVChannelsAndThemepacksPage(getDriver()));
                RogersRegisterPageThreadLocal.set(new RogersRegisterPage(getDriver()));
                RogersIgniteTVProfileCreationPageThreadLocal.set(new RogersIgniteTVProfileCreationPage(getDriver()));
                RogersInternetUsagePageThreadLocal.set(new RogersInternetUsagePage(getDriver()));
                RogersBillingPageThreadLocal.set(new RogersBillingPage(getDriver()));
                RogersTechInstallPageThreadLocal.set(new RogersTechInstallPage(getDriver()));
                RogersPaymentOptionsPageThreadLocal.set(new RogersPaymentOptionsPage(getDriver()));
                RogersIgniteTVCreditCheckPageThreadLocal.set(new RogersIgniteTVCreditCheckPage(getDriver()));
                RogersHomePhoneSelectionPageThreadLocal.set(new RogersHomePhoneSelectionPage(getDriver()));
                RogersSHMDashboardPageThreadLocal.set(new RogersSHMDashboardPage(getDriver()));
                RogersSmartStreamDashboardPageThreadLocal.set(new RogersSmartStreamDashboardPage(getDriver()));
                RogersSolarisChannelsExchangePageThreadLocal.set(new RogersSolarisChannelsExchangePage(getDriver()));
                RogersInternetProfilePageThreadLocal.set(new RogersInternetProfilePage(getDriver()));
                RogersInternetCreditCheckPageThreadLocal.set(new RogersInternetCreditCheckPage(getDriver()));
                break;

            case "buyflows":
                RogersHomePageThreadLocal.set(new RogersHomePage(getDriver()));
                RogersLoginPageThreadLocal.set(new RogersLoginPage(getDriver()));
                RogersAccountOverviewPageThreadLocal.set(new RogersAccountOverviewPage(getDriver()));
                RogersShareEverythingPageThreadLocal.set(new RogersShareEverythingPage(getDriver()));
                RogersWirelessDetailsPageThreadLocal.set(new RogersWirelessDetailsPage(getDriver()));
                RogersChangeSEPlanPageThreadLocal.set(new RogersChangeSEPlanPage(getDriver()));
                RogersChoosePhonePageThreadLocal.set(new RogersChoosePhonePage(getDriver()));
                RogersBuildPlanPageThreadLocal.set(new RogersBuildPlanPage(getDriver()));
                RogersChooseAddonsPageThreadLocal.set(new RogersChooseAddonsPage(getDriver()));
                RogersCartSummaryPageThreadLocal.set(new RogersCartSummaryPage(getDriver()));
                RogersWirelessProfileCreationPageThreadLocal.set(new RogersWirelessProfileCreationPage(getDriver()));
                RogersWirelessCreditEvaluationPageThreadLocal.set(new RogersWirelessCreditEvaluationPage(getDriver()));
                RogersShippingPageThreadLocal.set(new RogersShippingPage(getDriver()));
                RogersChooseNumberPageThreadLocal.set(new RogersChooseNumberPage(getDriver()));
                RogersOrderReviewPageThreadLocal.set(new RogersOrderReviewPage(getDriver()));
                RogersOrderConfirmationPageThreadLocal.set(new RogersOrderConfirmationPage(getDriver()));
                RogersPaymentOptionsPageThreadLocal.set(new RogersPaymentOptionsPage(getDriver()));
                RogersPaymentPageThreadLocal.set(new RogersPaymentPage(getDriver()));
                RogersChoosePlanPageThreadLocal.set(new RogersChoosePlanPage(getDriver()));
                RogersChangePlanPageThreadLocal.set(new RogersChangePlanPage(getDriver()));
                RogersOneTimePaymentPageThreadLocal.set(new RogersOneTimePaymentPage(getDriver()));
                RogersDeviceCataloguePageThreadLocal.set(new RogersDeviceCataloguePage(getDriver()));
                RogersDeviceConfigPageThreadLocal.set(new RogersDeviceConfigPage(getDriver()));
                RogersPlanConfigPageThreadLocal.set(new RogersPlanConfigPage(getDriver()));
                RogersCheckoutPageThreadLocal.set(new RogersCheckoutPage(getDriver()));
                RogersReviewOrderPageThreadLocal.set(new RogersReviewOrderPage(getDriver()));
                RogersWirelessDashboardPageThreadLocal.set(new RogersWirelessDashboardPage(getDriver()));
                RogersShippingCartPageThreadLocal.set(new RogersShippingCartPage(getDriver()));
                break;

            case "connectedhome_oneview":

                EnvironmentSelectionPageThreadLocal.set(new EnvironmentSelectionPage(getDriver()));
                AccountOverViewPageThreadLocal.set(new AccountOverViewPage(getDriver()));
                TVDashboardPageThreadLocal.set(new TVDashboardPage(getDriver()));
                InternetDashboardPageThreadLocal.set(new InternetDashboardPage(getDriver()));
                RogersInternetUsagePageThreadLocal.set(new RogersInternetUsagePage(getDriver()));
                HomePhonedashboardThreadLocal.set(new HomePhonedashboard(getDriver()));
                RogersIgniteBundlesPageThreadLocal.set(new RogersIgniteBundlesPage(getDriver()));
                RogersIgniteExchangePageThreadLocal.set(new RogersIgniteExchangePage(getDriver()));
                RogersIgniteCampaignPageThreadLocal.set(new RogersIgniteCampaignPage(getDriver()));
                DASHBOARD_PROFILE_PAGE_THREAD_LOCAL.set(new DashboardProfilePage(getDriver()));
                DASHBOARD_BILLING_PAGE_THREAD_LOCAL.set(new DashboardBillingPage(getDriver()));
                CustomerProfilePageThreadLocal.set(new CustomerProfilePage(getDriver()));
                CreditCheckPageThreadLocal.set(new CreditCheckPage(getDriver()));
                HomePhoneSelectionPageThreadLocal.set(new HomePhoneSelectionPage(getDriver()));
                FulfillmentPageThreadLocal.set(new FulfillmentPage(getDriver()));
                PaymentOptionsPageThreadLocal.set(new PaymentOptionsPage(getDriver()));
                RogersOVOrderReviewPageThreadLocal.set(new RogersOVOrderReviewPage(getDriver()));
                RogersOVOrderConfirmationPageThreadLocal.set(new RogersOVOrderConfirmationPage(getDriver()));
                RogersOVChannelsAndThemePacksPageThreadLocal.set(new RogersOVChannelsAndThemePacksPage(getDriver()));
                HomePhoneAddonsPageThreadLocal.set(new HomePhoneAddonsPage(getDriver()));
                RogersInternetUsageOVPageThreadLocal.set(new RogersInternetUsageOVPage(getDriver()));
                RogersOVInstallationPageThreadLocal.set(new com.rogers.oneview.pages.RogersOVInstallationPage(getDriver()));

                //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
                RogersOVOrderReviewPageThreadLocal.set(new RogersOVOrderReviewPage(getDriver()));
                RogersOVChangeSharePlanPageThreadLocal.set(new RogersOVChangeSharePlanPage(getDriver()));
                RogersOVWirelessDetailsPageThreadLocal.set(new com.rogers.oneview.pages.RogersWirelessDetailsPage(getDriver()));
                RogersOVChoosePhonePageThreadLocal.set(new com.rogers.oneview.pages.RogersChoosePhonePage(getDriver()));
                RogersOVBuildPlanPageThreadLocal.set(new com.rogers.oneview.pages.RogersBuildPlanPage(getDriver()));
                RogersOVChooseAddonsPageThreadLocal.set(new com.rogers.oneview.pages.RogersChooseAddonsPage(getDriver()));
                RogersOVShippingPageThreadLocal.set(new com.rogers.oneview.pages.RogersShippingPage(getDriver()));
                RogersOVPaymentPageThreadLocal.set(new com.rogers.oneview.pages.RogersOVPaymentPage(getDriver()));
                RogersOVChoosePlanPageThreadLocal.set(new com.rogers.oneview.pages.RogersChoosePlanPage(getDriver()));
                RogersOVPlanConfigPageThreadLocal.set(new com.rogers.oneview.pages.RogersOVPlanConfigPage(getDriver()));
                RogersOVCheckoutPageThreadLocal.set(new com.rogers.oneview.pages.RogersOVCheckoutPage(getDriver()));
                RogersOVReviewOrderPageThreadLocal.set(new com.rogers.oneview.pages.RogersOVReviewOrderPage(getDriver()));
                RogersOVOneTimePaymentPageThreadLocal.set(new com.rogers.oneview.pages.RogersOVOneTimePaymentPage(getDriver()));
                CallerInformationPageThreadLocal.set(new com.rogers.oneview.pages.CallerInformationPage(getDriver()));
                OvrDashboardPageThreadLocal.set(new com.rogers.ovr.pages.OvrDashboardPage(getDriver()));
                BundleBuilderPageThreadLocal.set(new com.rogers.ovr.pages.BundleBuilderPage(getDriver()));
                CheckAvailabilityPageThreadLocal.set(new com.rogers.ovr.pages.CheckAvailabilityPage(getDriver()));
                break;

            case "redesignrogers":
                RogersDeviceCataloguePageThreadLocal.set(new RogersDeviceCataloguePage(getDriver()));
                RogersDeviceConfigPageThreadLocal.set(new RogersDeviceConfigPage(getDriver()));
                RogersPlanConfigPageThreadLocal.set(new RogersPlanConfigPage(getDriver()));
                RogersCheckoutPageThreadLocal.set(new RogersCheckoutPage(getDriver()));
                RogersReviewOrderPageThreadLocal.set(new RogersReviewOrderPage(getDriver()));
                RogersNACOrderConfirmationPageThreadLocal.set(new RogersNACOrderConfirmationPage(getDriver()));
                RogersOneTimePaymentPageThreadLocal.set(new RogersOneTimePaymentPage(getDriver()));
                RogersLoginPageThreadLocal.set(new RogersLoginPage(getDriver()));
                RogersShippingCartPageThreadLocal.set(new RogersShippingCartPage(getDriver()));

            case "buyflowsoneview":

                EnvironmentSelectionPageThreadLocal.set(new EnvironmentSelectionPage(getDriver()));
                NacDashboardPageThreadLocal.set(new NacDashboardPage(getDriver()));
                AccountOverViewPageThreadLocal.set(new AccountOverViewPage(getDriver()));
                RogersOVOrderConfirmationPageThreadLocal.set(new RogersOVOrderConfirmationPage(getDriver()));
                RogersOVOrderReviewPageThreadLocal.set(new RogersOVOrderReviewPage(getDriver()));
                RogersOVChangeSharePlanPageThreadLocal.set(new RogersOVChangeSharePlanPage(getDriver()));
                RogersOVWirelessDetailsPageThreadLocal.set(new com.rogers.oneview.pages.RogersWirelessDetailsPage(getDriver()));
                RogersOVChoosePhonePageThreadLocal.set(new com.rogers.oneview.pages.RogersChoosePhonePage(getDriver()));
                RogersOVBuildPlanPageThreadLocal.set(new com.rogers.oneview.pages.RogersBuildPlanPage(getDriver()));
                RogersOVChooseAddonsPageThreadLocal.set(new com.rogers.oneview.pages.RogersChooseAddonsPage(getDriver()));
                RogersOVShippingPageThreadLocal.set(new com.rogers.oneview.pages.RogersShippingPage(getDriver()));
                RogersOVPaymentPageThreadLocal.set(new com.rogers.oneview.pages.RogersOVPaymentPage(getDriver()));
                RogersOVChoosePlanPageThreadLocal.set(new com.rogers.oneview.pages.RogersChoosePlanPage(getDriver()));
                RogersOVPlanConfigPageThreadLocal.set(new com.rogers.oneview.pages.RogersOVPlanConfigPage(getDriver()));
                RogersOVCheckoutPageThreadLocal.set(new com.rogers.oneview.pages.RogersOVCheckoutPage(getDriver()));
                RogersOVReviewOrderPageThreadLocal.set(new com.rogers.oneview.pages.RogersOVReviewOrderPage(getDriver()));
                RogersOVOneTimePaymentPageThreadLocal.set(new com.rogers.oneview.pages.RogersOVOneTimePaymentPage(getDriver()));
               break;


            case "serviceability":

                RogersHomePageServiceabilityThreadLocal.set(new RogersHomePageServiceability(getDriver()));

            case "ovr":
                ChampLoginPageThreadLocal.set(new com.rogers.ovr.pages.ChampLoginPage(getDriver()));
                UniLoginPageThreadLocal.set(new com.rogers.ovr.pages.UniLoginPage(getDriver()));
                AccountSearchPageThreadLocal.set(new com.rogers.ovr.pages.AccountSearchPage(getDriver()));
                OvrDashboardPageThreadLocal.set(new com.rogers.ovr.pages.OvrDashboardPage(getDriver()));
                CheckAvailabilityPageThreadLocal.set(new com.rogers.ovr.pages.CheckAvailabilityPage(getDriver()));
                BundleBuilderPageThreadLocal.set(new com.rogers.ovr.pages.BundleBuilderPage(getDriver()));
                LNPEligibilityPageThreadLocal.set(new com.rogers.ovr.pages.LNPEligibilityPage(getDriver()));
                CustomerProfilePageThreadLocal.set(new CustomerProfilePage(getDriver()));
                CreditCheckPageThreadLocal.set(new CreditCheckPage(getDriver()));
                RogersTechInstallPageThreadLocal.set(new RogersTechInstallPage(getDriver()));
                OVROrderReviewPageThreadLocal.set(new OVROrderReviewPage(getDriver()));
                OVRAgreementPageThreadLocal.set(new OVRAgreementPage(getDriver()));
                OVROrderConfirmationPageThreadLocal.set(new OVROrderConfirmationPage(getDriver()));
                RogersIgniteBundlesPageThreadLocal.set(new RogersIgniteBundlesPage(getDriver()));
                RogersOVCheckoutPageThreadLocal.set(new com.rogers.oneview.pages.RogersOVCheckoutPage(getDriver()));
                HomePhoneAddonsPageThreadLocal.set(new HomePhoneAddonsPage(getDriver()));
                HomePhoneSelectionPageThreadLocal.set(new HomePhoneSelectionPage(getDriver()));
                CallerInformationPageThreadLocal.set(new com.rogers.oneview.pages.CallerInformationPage(getDriver()));
                AccountOverViewPageThreadLocal.set(new AccountOverViewPage(getDriver()));
                InternetDashboardPageThreadLocal.set(new InternetDashboardPage(getDriver()));
                TVDashboardPageThreadLocal.set(new TVDashboardPage(getDriver()));
                HomePhonedashboardThreadLocal.set(new HomePhonedashboard(getDriver()));
                RogersIgniteExchangePageThreadLocal.set(new RogersIgniteExchangePage(getDriver()));
                FulfillmentPageThreadLocal.set(new FulfillmentPage(getDriver()));
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
     *
     * @param driver  the web driver
     * @param seconds wait time by seconds
     */
    public void setImplicitWait(WebDriver driver, long seconds) {
        getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }


    /**
     * To get parameters from XML file, it is called in TestListener.
     *
     * @return HashMap of test parameters
     */
    public HashMap<String, String> getXMLParameters() {
        return xmlTestParameters;
    }

    /**
     * BrowserStack REST API to access and update information about test.
     *
     * @param strStatus
     * @throws ClientProtocolException
     * @throws IOException
     * @throws URISyntaxException
     */
    public void mark(String strStatus) throws ClientProtocolException, IOException, URISyntaxException {
        URI uri = new URI("https://ning28:pgaiJjgQMZERUe51d4ky@api.browserstack.com/automate/sessions/"
                + ((RemoteWebDriver) getDriver()).getSessionId() + ".json");
        HttpPut putRequest = new HttpPut(uri);
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add((new BasicNameValuePair("status", strStatus)));
        nameValuePairs.add((new BasicNameValuePair("reason", "")));
        putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        HttpClientBuilder.create().build().execute(putRequest);
    }


    /**
     * To start a session using given url, browser, language and test case group name.
     *
     * @param strLanguage string of test Language
     * @param strBrowser  string of browser name
     * @return HashMap of test TestParameters
     */
    public static HashMap<String, String> getExecutionParameters(String strBrowser, String strLanguage) {
        if (System.getProperty("Browser") == null || System.getProperty("Browser").isEmpty()) {
            System.setProperty("Browser", strBrowser);
        }
        if (System.getProperty("Language") == null || System.getProperty("Language").isEmpty()) {
            System.setProperty("Language", strLanguage);
        }
        if (System.getProperty("Browser").equals("") && strBrowser.isEmpty()) {
            System.setProperty("Browser", "chrome");
        }
        if (System.getProperty("Language").equals("") && strLanguage.isEmpty()) {
            System.setProperty("Language", "en");
        }
        strBrowser = System.getProperty("Browser");
        strLanguage = System.getProperty("Language");
        HashMap<String, String> TestParameters = new HashMap<>();
        TestParameters.put("Browser", strBrowser);
        TestParameters.put("Language", strLanguage);
        return TestParameters;
    }

    /**
     * This method returns the webdriver instance from the thread ThreadLocal
     *
     * @return
     */

    public WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext iTestContext) throws FileNotFoundException, IOException{
        TestDataHandler.dataInit(iTestContext.getSuite().getAllMethods());
    }

    public static Map<String, String> getAuthHeaders(Map<String, String> authHeaderMap,String franchise) {
        Map<String, String> authCookieMap = new HashMap<>();
        if (franchise.toUpperCase().contains("ROGERS")) {
            authCookieMap.put("Cookie", "Authorization="+authHeaderMap.get("authorization")+"; x-info-token="+authHeaderMap.get("xInfoToken"));
        } else {
            authCookieMap.put("Cookie", "AuthN="+authHeaderMap.get("AuthN")+"; AuthZ="+authHeaderMap.get("AuthZ"));
        }
        return authCookieMap;
    }

    public void setCookie(String strUrl) {
        Cookie cookie = new Cookie("QSI_SI_eOGekr50Kdqo3dQ_intercept", "true", ".rogers.com", "/phones", null);
        getDriver().manage().addCookie(cookie);
    }

    public static GetOTP getOTP(){
        return getOTPThreadLocal.get();
    }

}
