package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import com.rogers.test.helpers.CurrencyHelpers;
import com.rogers.test.helpers.DateHelpersFunctions;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RogersAccountOverviewPage extends BasePageClass {




	public RogersAccountOverviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class='ute-icon-internet']")
	WebElement btnInternetBadge;

	@FindAll({
	@FindBy(xpath = "//span[@class='ds-icon rds-icon-tv']"),
	@FindBy(xpath = "//span[@class='ds-icon d-inline-flex rds-icon-tv']")})
	WebElement btnSmartStream;

	@FindAll({
        @FindBy(xpath = "//rss-subscription-detail//a//span[contains(text(),'Internet')]"),
        @FindBy(xpath = "//span[contains(@class,'rui-icon-internet icon')]/ancestor::div[@role='button']")})
	WebElement btnLegacyInternetBadge;
	
	@FindBy (xpath ="//div[@class='ute-dataManager-badgeList-individualBadge']")
	WebElement btnCtnBadge;
			
	@FindAll({
        @FindBy(xpath = "//div[@class='subscription-detail']//rss-subscription-detail//a"),
        @FindBy (xpath ="//div[@class='ute-dataManager-badgeList-individualBadge']//div[@class='ute-dataManager-badgeList-individualBadgeInfo']")})
	List<WebElement> lstCtnBadges;
	
	@FindBy(xpath = "//ds-icon/following-sibling::span[contains(text(),'Suspended')]")
	WebElement suspendedCTN;
	
	@FindBy(xpath = "//rss-subscription-detail//span[text()=' Suspended ' or text()=' Suspendu ']//ancestor::rss-subscription-detail//span[@class='subscription-number']")
	List<WebElement> lstSuspendedCTNs;

	@FindBy(xpath = "//rss-subscription-detail//span[not(text()=' Suspended ') or not(text()=' Suspendu ')]//ancestor::rss-subscription-detail//span[@class='subscription-number']")
	List<WebElement> lstActiveCTNs;
	
	@FindBy(xpath = "//div[@class='row modal-content-header']//button[@class='close']")
	WebElement popUpInternetPopup;

	
	@FindAll({
        @FindBy(xpath = "//rss-subscription-detail//a//span[contains(text(),'TV') or contains(text(),'Télévision')]"),
        @FindBy(xpath = "//span[contains(@class,'rui-icon-tv icon')]/ancestor::div[@role='button']")})
	WebElement btnTVBadge;

	@FindAll({
        @FindBy(xpath = "//rss-subscription-detail//a//span[contains(text(),'Home Phone') or contains(text(),'Téléphonie résidentielle')]"),
        @FindBy(xpath = "//span[@class='ds-icon d-inline-flex rds-icon-home-phone']")})
	WebElement btnRHPBadge;

	@FindBy(xpath = "//div[@linkurl='tvdashboard']/parent::div")
	WebElement btnTVBadgeConsolidated;

	@FindBy(xpath = "//*[@translate='ute.rogers.account.balance.total_balance' or text()='Total balance' or text()='Total du solde'  or text()='Total Balance']")
	WebElement infoBalanceLable;

	@FindBy(xpath = "//h1[@class='mt-24']")
	WebElement infoWelcome;

	@FindBy(xpath = "//span[@translate='ute.rogers.rhpDashboard.contactMangerFeatures']")
	WebElement lnkContactUsToManageFeaturess;
		
	@FindAll({
        @FindBy(xpath = "//span[text()=' View your bill ' or text()=' Afficher votre facture ']"),
        @FindBy(xpath = "//span[@translate='ute.rogers.account.balance.view_your_bill']")})
    WebElement btnViewYourBill;


	@FindAll({
	@FindBy(xpath = "//div[@class='rogers-self-serve-nav']//div[@class='c-dropdown-menu-holder']//span[text()='Lier un autre compte' or text()='Link another account']"),
	@FindBy(xpath = "//span[contains(@data-translate,'linkAnotherAccount')]")
	})
	WebElement lnkLinkAnotherAccount;
	
	@FindBy(xpath = "//div[@translate='linked_acc_success']")
	WebElement lblLinkAccountSuccess;
	
	
	
	@FindAll({
	@FindBy(xpath = "//div[@class='account']//a[@class='dropdown-toggle menu-click']"),
	@FindBy(xpath = "//span[contains(@class,'arrow-down-account')]")})
	WebElement lnkAccountdropdown;
	
	
	@FindAll({
        @FindBy(xpath = "//a[contains(text(),'Billing & Payment') or contains(text(),'Facturation et paiement')]"),
        @FindBy(xpath = "//span[@data-translate='ute.common.label.billAndPayment']")})	
	WebElement lnkBillingAndPayment;
	
	@FindBy(xpath = "//span[@data-translate='ute.common.second.level.navigation.billing.changePaymentMethod']")
	WebElement lnkChangePaymentMethod;
	
	@FindBy(xpath = "//span[@translate='ute.payment.method.mop_title' or text()='Change payment method' or text()='Changer le mode de paiement']")
	WebElement lnkBelowCardChangePaymentMethod;
		
	
   @FindBy(xpath = "//rss-billing-widget//span[contains(text(),'Set up automatic payments') or contains(text(),'Configurer les paiements automatiques')]")	
   WebElement lnkSetUpAutomaticPaymentMethod;
	
	@FindAll({
        @FindBy(xpath = "//*[@id='overview' or @id='survol']//md-list-item//span[@data-translate='ute.common.second.level.navigation.billing.setUpAutomaticPayments']"),
        @FindBy(xpath = "//span[@data-translate='ute.common.second.level.navigation.billing.setUpAutomaticPayments']")})	
	WebElement lnkSetUpAutomaticPaymentMethodMobile;
	
	@FindAll({    
	@FindBy(xpath = "//button/span[@translate='ute.rogers.account.balance.make_a_payment']"),
    @FindBy(xpath = "//span[contains(text(),'Make a payment')]")})
	WebElement btnMakeAPayment;
	
	@FindBy(xpath = "//div[@ng-show='loadingImg']")
	WebElement imgLoadingFingers;

	@FindAll({
			@FindBy(xpath = "//h2[@translate='EOP.NEW_OFFER_NOTIFICATION.sai.header']"),
			@FindBy(xpath = "//p[contains(@translate,'EOP.NEW_OFFER_NOTIFICATION')]")
	})
	WebElement headerOfferNotificationModal;

	@FindBy(xpath = "//button[@data-dtname='x-close-ignite migration-alert']/span")
	WebElement btnCloseOfferModal;
	
	@FindAll({
        @FindBy(xpath = "//a[text()='Profile & Settings' or contains(text(),'Profil et param')]"),
        @FindBy(xpath = "//span[@data-translate='ute.common.label.profileAndSetting']")})
    WebElement menuProfileNSettings;

	@FindAll({
	@FindBy(xpath = "//button[@aria-label='ute.common.label.profileAndSetting']"),
	@FindBy(xpath = "//span[text()='Profile & Settings' or contains(text(),'Profil et param')]/parent::a")})
	WebElement menuProfileAndSettingsMobile;
	

	@FindAll({
		@FindBy(xpath = "//button[@aria-label='ute.common.label.profileAndSetting']"),
		@FindBy(xpath = "//span[text()='Profile & Settings' or text()='Profil et paramètres']/parent::a")})
		WebElement menuAndServices;
	
	@FindAll({
	@FindBy(xpath = "//div[@class='ute-secondLevelNav-bar-m']//button//span[@data-translate='ute.common.label.overview']"),
	@FindBy(xpath = "//button[contains(text(),'Overview') or contains(text(),'Survol')]")})
	WebElement btnOverViewMobile;
				
	@FindAll({
	@FindBy(xpath = "//div[@class='ute-secondLevelNav-bar-m']//button//span[@data-translate='ute.common.label.billAndPayment']"),
	@FindBy(xpath = "//button[contains(text(),'Overview') or contains(text(),'Survol')]")})
	WebElement btnBillingsAndPaymentsMobile;
	
	@FindAll({
		@FindBy (xpath = "//p[text()='Quel compte souhaitez-vous consulter?' or text()='Which account would you like to view today?']"),
		@FindBy (xpath = "//h3[@translate='acc_overview_which_account']")
	})	
	WebElement headerAccountSelect;
	
	@FindBy (xpath = "//h1[@class='profile-header']")
	WebElement headerProfileNSettings;
	
	@FindBy (xpath = "//*[@translate='ute.payment.method.payment_method' or @translate='ute.payment.method.will_auto_charge' or contains(text(),'Will be automatically charged to:') or contains(text(),'Mode de paiement:') or contains(text(),'Sera porté automatiquement à :') or text()='Payment method:' or text()='Mode de paiement:']")
	WebElement lblAutoPayment;
	
	@FindBy(xpath = "//div[@translate='ute.payment.method.account_prefix']")
	WebElement lblAutoPaymentAccountPreFix;
	
	@FindBy(xpath = "//img[@class='bank-icon']")
	WebElement imgBank;
	
	@FindAll({
		@FindBy(xpath = "//span[@class='auto-payment-info']/ds-icon"),
		@FindBy(xpath = "//*[contains(@class,'cc-image') or contains(@class,'cc-icon')]"),
		@FindBy(xpath = "//img[@class='cardImgSize']")
	})	
	WebElement imgCC;

	@FindBy(xpath = "//span[@data-translate='ute.common.second.level.navigation.billing.makePayment']")
	WebElement lnkMakePayment;
	
	@FindAll({
		@FindBy (xpath = "//a[text()='Usage & Services ' or text()='Utilisation et services ']"),
		@FindBy (xpath = "//span[@data-translate='ute.common.label.myServices']")
	})
	WebElement menuUsageAndService;
	
	@FindBy (xpath = "//span[contains(text(),'Wireless Usage') or contains(text(),'Utilisation sans-fil')]")
	WebElement subMenuWirelessUsage;

	@FindBy (xpath = "//div[@id='carouselBlock']")
	WebElement newLookPopUp;
	
	@FindBy (xpath = "//span[@class='ds-icon rds-icon-error']")
	WebElement iconCloseInPopup;

	@FindBy(xpath="//*[@id='paymentAmount']")
	WebElement txtAmount;
	
	@FindAll({
        @FindBy(xpath = "//span[contains(@class,'subscription-name')]"),
        @FindBy(xpath = "//div[@class='ute-dataManager-badgeList-individualBadge']//div[@class='ute-dataManager-badgeList-individualBadgeInfo']")})	
	WebElement lblCTNWirelessName;
	

	@FindAll({
        @FindBy(xpath = "//div[@class='c-dropdown-menu-holder']/a"),
        @FindBy(xpath = "//*[@data-translate='ute.common.second.level.navigation.wireless.phone.prepaid']"),
        @FindBy(xpath = "//span[@data-translate='ute.common.second.level.navigation.wireless.phone']")})	
	WebElement subMenuUsageDropDown;

	@FindBy (xpath = "//div[@class='c-dropdown-menu-holder']/a/span[contains(text(), 'Home Phone') or contains(text(),'Téléphonie')]")
	WebElement submenuHomePhone;

	@FindBy (xpath = "//div[@class='c-dropdown-menu-holder']/a/span[text() = 'TV' or text() = 'Télévision']")
	WebElement submenuTV;

	@FindBy (xpath = "//div[@class='account-number-ctn']")
	WebElement selectAccountMultipleSubscription;
	
	@FindBy(xpath = "//span[@data-translate='ute.common.label.overview']")
	WebElement clkOverview;
	
	@FindBy(xpath = "//div[@class='module-account-overview-dialog']")
	WebElement popUpMultipleAccounts;

	@FindBy(xpath = "//button//span[@class='ute-secondLevelNav-arrow-down ute-secondLevelNav-arrow-down-account']")
	WebElement downArrowAccount;
	
	@FindBy(xpath = "//div[contains(@id,'menu_container_0')]//button")
	List<WebElement> lstAccountBans;

	@FindBy(xpath = "//div[@class='account-ctn']")
	List<WebElement> lstAccountInPopUp;
	
	@FindBy(xpath = "//span[@data-translate='ute.common.label.overview']/ancestor::button[@ng-click='navigationBar.MobileViewOnClick(nav)']")
	WebElement btnNavigationBarMobile;
	
	@FindBy (xpath = "//button[@aria-label='ute.common.label.profileAndSetting']")
	WebElement btnProfileSettingsMobile;
	
	@FindAll({
		@FindBy(xpath = "//span[contains(text(),'Entertainment') or contains(text(),'Divertissement')]/ancestor::div[@class='subscription-detail']"),
        @FindBy(xpath = "//span[@translate='ute.subscriptionBadge.smartStream']")})	
	WebElement btnEntertainmentBadge;
		
	@FindAll({
	@FindBy(xpath = "//button[@aria-label='ute.common.label.billAndPayment']"),
	@FindBy(xpath = "//div[@id='services']//span[contains(text(),'Billing & Payment')]")	
	})
	WebElement menuBillingAndPaymentsMobile;
	
	@FindBy(xpath = "//div[@class='ute-secondLevelNav-bar-m']//button//span[contains(text(),'Billing & Payment')]")
	WebElement menuMainBillingAndPaymentsMobile;

	@FindBy(xpath = "//*[@id='overview' or @id='survol']//md-list-item//span[@data-translate='ute.common.second.level.navigation.billing.changePaymentMethod']/ancestor::h2/parent::div/parent::div/button")
	WebElement submenuChangePaymentMethod;
	
	@FindBy(xpath = "//*[@id='overview' or @id='survol']//md-list-item//span[@data-translate='ute.common.second.level.navigation.billing.setUpAutomaticPayments']/ancestor::h2/parent::div/parent::div/button")
	WebElement submenuSetUpAutomaticPaymentMethodMobile;

	@FindBy(xpath = "//div[contains(@translate,'makeAPayment')]")
	WebElement lblMakeASecurePayment;

	@FindBy(xpath = "//span[@class='auto-payment-info' or @translate='ute.payment.method.ending_number']")
	WebElement txtCC;

	@FindBy(xpath = "//p[contains(text(),'This account has been cancelled, so your access to MyRogers') or contains(text(),'Ce compte a été fermé, votre accès à MonRogers')]") 
	WebElement divAccountCancelled;
	
	@FindBy(xpath = "//span[text()=' - View billing and payment history' or contains(text(),'Consulter votre historique de facture et de paiement')]") 
	WebElement lnkViewBillingAndPayment;
	
	@FindBy(xpath = "//span[contains(text(),'Manage Profile') or contains(text(),'Gérer votre profil')]") 
	WebElement lnkManageProfile;

	@FindBy(xpath = "//span[contains(text(),'Set up automatic payments') or contains(text(),'Configurer les paiements automatiques')]") 
	WebElement lnkSetUpAutomaticPaymentMethodAOPage;

	@FindBy(xpath = "//span[text()='Payment History' or text()='Historique de paiement']") 
	WebElement lnkPaymentHistoryDisplayed;
	
	@FindBy (xpath = "//div[@class='floatingOverview bcStatic']")
	WebElement btnLiveChat;

	@FindBy (xpath = "//span[@class='menu-click']")
	WebElement menuAccountNumber;
		
	@FindBy(xpath = "//div[@class='c-nav-shell-in-mobile']//span[contains(text(),' Account: ')]/span")
	WebElement menuAccountNumberMobile;
	
	@FindBy(xpath = "//iframe[@id='va-iframe']")
	WebElement fraLiveChat;
	
	@FindAll({
		@FindBy (xpath = "//app-welcome-rogers"),
		@FindBy (xpath = "//div[@class='bc-frame-title']")})
		WebElement headerLiveChat;
	
	@FindAll({		
		@FindBy (xpath = "//span[text()='Usage & Services' or text()='Profil et paramètres']/parent::a")})
	WebElement menuUsageAndServicesMobile;

	@FindBy(xpath = "//a[@data-translate='ute.common.reactivate.ctn.backToDevice']")	
	WebElement btnClickBackToDevice;

	@FindBy(xpath = "//p[contains(@class,'dsa-alert') and (contains(text(),'You’ve exceeded your credit limit and your services are now suspended') or contains(text(),'Vous avez dépassé votre limite de crédit et vos services sont suspendus'))]")
	WebElement lblCreditLimitExceeded;

	@FindBy(xpath = "//span[contains(text(),'Add a') or contains(text(),'Ajout d')]/ancestor::div[contains(@class,'subscription-detail')]/child::a")
	WebElement lnkAddALine;

	@FindBy(xpath = "//*[text()='Choose a plan to add your new line to' or text()='Choisir un forfait auquel ajouter votre nouvelle ligne']")
	WebElement headerOverlayforAddLink;
	
	@FindBy(xpath = "//*[@data-id='Add this line to my shared Rogers Infinite plan' or @data-id='Mon forfait Infini de Rogers à partager']")
	WebElement btnAddToSharedPlan;
		
	@FindBy(xpath = "//*[@data-id='Add this line to a separate plan on my account that doesn’t have data-sharing' or @data-id='Forfait distinct sans partage']")
	WebElement btnAddToNonSharedPlan;

	@FindBy(xpath = "//div[contains(@class,'share-everything')]//div[contains(@class,'subscription-detail')]//rss-subscription-detail//a")
	List<WebElement> lstShareEverythingCTNs;
		
	@FindBy(xpath = "//div[contains(@class,'individual_wireless')]//div[contains(@class,'subscription-detail')]//rss-subscription-detail//a")
	List<WebElement> lstIndividualWirelessCTNs;
		
	@FindBy(xpath = "//div[contains(@class,'residential_services')]//div[contains(@class,'subscription-detail')]//rss-subscription-detail//a")
	List<WebElement> lstResidentialServicesCTNs;

	@FindBy(xpath = "//*[@translate='acc_overview_top_up_now' or @title='Top Up Now']")
	WebElement btnPrepaidTopUpNow;

	@FindBy(xpath = "//*[@translate='ute.rogers.account.balance.current.account.balance' or contains(text(),'Current Account Balance') or contains(text(),'Solde actuel du compte')]")
	WebElement lblCurrentAccountBalance;

	@FindBy(xpath = "//*[@class='rogers-amount' or contains(@aria-label,'Current Account Balance') or contains(@aria-label,'Solde actuel du compte')]")
	WebElement lblCurrentBalanceAmount;

	@FindBy(xpath = "//*[@translate='acc_overview_expires_on' or contains(text(),'Expires on:') or contains(text(),'Expire le :')]")
	WebElement lblBalanceExpiresOn;

	@FindBy(xpath = "//*[@data-test-id='myr-accountBalance-expiryDate']")
	WebElement lblExpiryMonth;

	@FindBy(xpath = "//*[@translate='change_method_update' or contains(text(),'Update Payment Method') or contains(text(),'Mettre à jour le mode de paiement')]")
	WebElement lnkUpdatePaymentMethod;

	@FindBy(xpath = "//*[@translate='ute.rogers.account.balance.view.call' or contains(text(),'View Call/Transaction History') or contains(text(),'Voir les appels/Historique des transactions')]")
	WebElement lnkViewCallTransactionHistory;

	@FindBy(xpath = "//div[@ng-if='!ao.mss.loadingData && ao.mss.selectedAccountDetail.isPrepaid']//*[@translate='service_wireless_prepaid']")
	WebElement btnCTNWidgetPrepaid;

	@FindBy(xpath = "//*[@translate='myaccoverview_account_preferences']")
	WebElement lblAccountPreferences;

	@FindBy(xpath = "//*[@translate='myaccoverview_change_contact_information']")
	WebElement lnkChangeContactInfo;

	@FindBy(xpath = "//*[@translate='myaccoverview_change_password']")
	WebElement lnkChangePassword;

	@FindBy(xpath = "//*[@translate='acc_overview_other_services']")
	WebElement lblOtherServicesAvailable;

	@FindBy(xpath = "//a//span[contains(@class,'ds-button__copy') and (contains(text(),'Sign up') or contains(text(),'S’abonner'))]")
	WebElement btnSubscriptionSignUp;

	@FindBy(xpath = "//a//span[contains(@class,'ds-button__copy') and (contains(text(),'Manage') or contains(text(),'Gérer'))]")
	WebElement btnSubscriptionManage;

	@FindAll({
			@FindBy(xpath = "//rss-value-prop-wrapper[@aria-label='Manage your Disney+ subscription' or @aria-label='Gérer l’abonnement Disney+']//a//span[contains(@class,'ds-button__copy') and (contains(text(),'Manage') or contains(text(),'Gérer'))]"),
			@FindBy(xpath = "//rss-value-prop-wrapper//a[@aria-label='Manage your Disney+ subscription' or @aria-label='Gérer l’abonnement Disney+']//span[contains(@class,'ds-button__copy') and (contains(text(),'Manage') or contains(text(),'Gérer'))]")
	})
	WebElement btnDPSubscriptionManage;

	@FindBy(xpath = "//rss-value-prop-wrapper[@title='Start your Disney+ subscription' or @title='Commencer l’abonnement Disney+']//span[contains(text(),'Sign up') or contains(text(),'S’inscrire')]")
	WebElement btnDPSubscriptionSignUp;

	@FindBy(xpath = "//h2[text()='Currently subscribed' or text()='Abonnement en cours']")
	WebElement headerCurrentlySubscribed;

	@FindBy(xpath = "//a[contains(@title,'Cancel the Apple Music subscription for') or contains(@title,'Annuler l’abonnement')]")
	WebElement btnCancelSubscription;

	@FindBy(xpath = "//h1[text()='Cancel subscription' or contains(text(),'Annuler l’abonnement') or contains(text(),'Cancel Apple') or contains(text(),'Annuler ')]")
	WebElement headerCancelSubscription;

	@FindBy(xpath = "//rss-subscriber-info")
	WebElement lblRogersCancellationForSubs;
	
	@FindBy(xpath = "//rss-subscriber-info")
	WebElement lblRogersRedeemForSubs;

	////*[contains(text(),'I’m cancelling this subscription because:')]/ancestor::span/parent::div/ancestor::ds-form-field
	@FindBy(xpath = "//rss-cancel//ds-form-field/div/div[contains(@class,'select')]")
	WebElement selectReasonForCancel;

	@FindBy(xpath = "//*[contains(text(),'Confirm') or contains(text(),'Continue') or contains(text(),'Confirmer') or contains(text(),'Continuer')]")
	WebElement btnConfirm;

	@FindBy(xpath = "//*[text()='OK' or text()='Continue']")
	WebElement btnOK;

	@FindBy(xpath = "//p[text()='Subscription cancelled' or contains(text(),'Abonnement annul')]")
	WebElement headerCancelSuccess;

	@FindBy(xpath = "//span[contains(text(),'This Apple Music subscription has been cancelled immediately and you will not be charged.')]")
	WebElement lblImmediateCancelSuccess;

	
	@FindBy(xpath = "//*[contains(text(),'Subscription successful') or contains(text(),'Abonnement réussi')]")
	WebElement headerSubscriptionSuccess;

	@FindBy(xpath = "//option[@value='0: Object']")
	WebElement optReasonOne;

	@FindBy(xpath = "//option[contains(text(),'I’m already paying for an Apple Music subscription') or contains(text(),'Je paie déjà un abonnement à Apple Music.') or @value='5: Object']")
	WebElement optReasonForImmediateCancel;

	@FindBy(xpath = "//option[contains(text(),'need a music service anymore') or contains(text(),'Je n’ai plus besoin de service de musique') or @value='0: Object']")
	WebElement optReasonForDefferedCancel;

	@FindBy(xpath = "//span[@aria-relevant='additions' or text()='This Apple Music subscription will be cancelled immediately and you will not be charged.' or text()='Cet abonnement à Apple Music sera annulé immédiatement, et aucuns frais ne seront exigés.']")
	WebElement lblImmediateCancelReason;

	@FindBy(xpath = "//span[@aria-relevant='additions' and text()='This Apple Music subscription will be cancelled at the end of the 1-month promotional period and you will not be charged. Keep listening until then!' or text()='Cet abonnement à Apple Music sera annulé à la fin de la période promotionnelle de 1 mois, et aucuns frais ne seront exigés. Continuez d’en profiter jusqu’à ce moment!']")
	WebElement lblDeferredCancel;

	@FindBy(xpath = "//rss-subscriber-info/following-sibling::span//span[text()=' Cancelled ' or contains(text(),' Service annul')]")
	WebElement paneSMPCancelled;
	
	@FindBy(xpath = "//rss-subscriber-info/following-sibling::span//span[contains(text(),'Promotion ends') or contains(text(),'Subscription ends') or contains(text(),'La promotion prend fin le') or contains(text(),'L’abonnement prend fin le')]")
	WebElement lblSMPpromotionEnds;

	@FindBy(xpath = "//rss-subscriber-info/following-sibling::span/following-sibling::span[contains(text(),'This number is not on an eligible plan') or contains(text(),'Ce numéro n’est pas associé à un forfait admissible')]")
	WebElement lblSMPpromotionInEligile;

	@FindBy(xpath = "//rss-subscriber-info/following-sibling::span//span[contains(text(),'Promotion ended') or contains(text(),'ended') or contains(text(),'La promotion prend fin le')]")
	WebElement lblSMPpromotionEnded;


	@FindBy(xpath = "//span[contains(text(),'Promotion started') or contains(text(),'Paid subscription started') or contains(text(),' L’abonnement payant a commencé le') or contains(text(),' La promotion a commencé')]")
	WebElement lblSMPpromotionStarted;

	@FindBy(xpath = "//ds-checkbox")
	WebElement chkRedeemSubs;

	@FindBy(xpath = "//a[@title='Sign up for Apple Music' or contains(@title,'S’abonner à Apple Music')]")
	WebElement btnSignUp;

	@FindAll({
	@FindBy(xpath = "//h2[text()='Terms & Conditions' or text()='']"),
	@FindBy(xpath = "//h1[@class='signup-page-title']")})
	WebElement headerTnC;

	@FindBy(xpath = "//ds-checkbox")
	WebElement chkTnC;
	
	@FindBy(xpath = "//button[@title='Continue and activate this Apple Music subscription' or @title='Continue and start this Apple Music subscription' or contains(@title,'Continuer et activer cet abonnement')]")
	WebElement btnSubscribeToSubsscription;

	@FindBy(xpath = "//button[@title='Continue and start this Disney+ subscription' or @title='Continue and start this Apple Music subscription' or contains(@title,'Continuer et commencer l’abonnement Disney+')]")
	WebElement btnSubscribeToDisneyPlus;

	@FindBy(xpath = "//a[text()='Yes' or contains(text(),'Oui')]")
	WebElement btnCloseFAQ;

	@FindBy(xpath = "//span[@class='vas-subscriber-number']")
	WebElement paneSMPSubsCTN;

	@FindBy(xpath = "//p[text()='One or more of your services are suspended. ' or text()='Au moins un de vos services est suspendu. ']")
	WebElement lblServiceSuspended;

	@FindBy(xpath = "//rds-bold-chat//div[@class='live-chat-link-suspended bcStatic']")
	WebElement btnLiveChatInsideSuspendedNotification;

	@FindBy(xpath = "//div[@title='Rogers Live Chat' or @title='Clavardage en direct de Rogers']")
	WebElement headerRogersLiveChat;

	@FindBy(xpath = "//p[text()='How would you like to pay?' or text()='Comment souhaitez-vous payer?']")
	WebElement lblHowWouldYouPay;

	@FindBy(xpath = "//rss-quick-links//span[contains(text(),'Set up automatic payments') or contains(text(),'Configurer les paiements automatiques')]")
	WebElement lnkSetUpAutoPayment;

	@FindBy(xpath = "//rss-quick-links//span[contains(text(),'Change payment method') or contains(text(),'Changer le mode de paiement')]")
	WebElement lnkChangePaymentMethodQuickLin;

	@FindBy (xpath = "//span[contains(text(),'Payment History') or contains(text(),'Historique de paiement')]")
	WebElement lnkPaymentHistory;

	@FindBy(xpath = "//img[@class='star']")
	WebElement imgSpecialOfferBadge;

	@FindBy(xpath = "//span[@translate='EOP.CTAS.PROMOTION_OFFER_BADGE.LABEL']")
	WebElement lblSpecialOfferBadge;

	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popLoader;

	@FindBy (xpath = "//span[contains(text(),'Change payment method') or contains(text(),'Changer le mode de paiement')]")
	WebElement lnkChangePaymentMethodButton;

	@FindBy (xpath = "//span[contains(text(),' bank account ending') or contains(text(),' compte bancaire se terminant par')]")
	WebElement lblBankPaymentMethodLabel;

	@FindBy (xpath = "//div[@class='ds-price']")
	WebElement lblTotalBalance;

	// **********  PTP ***************** //

	@FindBy(xpath = "//rss-promise-to-pay-alert/dsa-alert")
	WebElement divPTP;

	@FindBy(xpath = "//rss-promise-to-pay-alert/dsa-alert//a")
	WebElement lnkSetUpPromiseToPay;

	@FindBy(xpath = "//select[@formcontrolname='paymentMethod']")
	WebElement selectPayType;

	@FindBy(xpath = "//select[@formcontrolname='paymentDate']")
	WebElement selectDate;

	@FindBy(xpath = "//*[@translate='promise-to-pay.setup-ptp.setup-btn']")
	WebElement btnSetUpPromise;

	@FindBy(xpath = "//h1[@translate='promise-to-pay.header']")
	WebElement headerSetUpPromise;

	@FindBy(xpath = "//span[@translate='promise-to-pay.setup-ptp.total-balance']")
	WebElement lblTotalBalanceToPay;

	@FindBy(xpath = "//select[@formcontrolname='paymentMethod']/parent::div")
	WebElement selectPayTypeDiv;

	@FindBy(xpath = "//*[@translate='promise-to-pay.success-ptp.header']")
	WebElement headerSetUpPromiseSuccessFul;

	@FindBy(xpath = "//*[@translate='promise-to-pay.success-ptp.done-btn']")
	WebElement btnDoneAfterSetUpPromiseSuccessFul;

	@FindBy(xpath = "//a[@class='c-navbar-link dropdown-toggle menu-click' and contains(text(),'Utilisation et services ') or contains(text(),'Usage & Services ')]")
	WebElement btnUsageAndServicesDropDown;

	@FindBy(xpath = "//span[contains(text(),' Financed accessories ') or contains(text(),' Accessoires financés ')]")
	WebElement btnFinancedAccessories;

	/**
	 * Checks if more than one ban present in the pop up window, the count will be more than 1
	 * @return true if more than one ban present else false
	 * @author Saurav.Goyal
	 */
	public boolean isMoreThanOneBanPresentInThePopUp() {
		return (lstAccountInPopUp.size()>1);
	} 
	
	/**
	 * To remove cookie after login successfully
	 * @param cookieName, string cookie name;
	 */
	public void removeCookieAfterLogin(String cookieName) {
		getReusableActionsInstance().removeCookie(cookieName);
	}
	
	/**
	 * Clicks on the 'InternetBadge' option on the dash board
	 * @param strBrowser- strBrowser
	 * @author chinnarao.vattam
	 */
	public void clkInternetBadge(String strBrowser) {
		if (strBrowser.equalsIgnoreCase("chrome"))
		{
		getReusableActionsInstance().clickAndHoldFor(btnInternetBadge, 90);
		}else {
			getReusableActionsInstance().clickIfAvailable(btnInternetBadge, 90);
		}
	}
	
	/**
	 * Click on the link "Payment History"
	 * @author ning.xue
	 */
	public void clkPaymentHistory() {
		getReusableActionsInstance().clickWhenReady(lnkPaymentHistory, 10);
	}

	/**
	 * Clicks on the Legacy 'InternetBadge' option on the dash board
	 * @author chinnarao.vattam
	 */
	public void clkLegacyInternetMobile() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().waitForElementVisibility(btnLegacyInternetBadge, 60);
		getReusableActionsInstance().executeJavaScriptClick(btnLegacyInternetBadge);
	}
	/**
	 * Clicks on the Legacy 'InternetBadge' option on the dash board
	 * @author chinnarao.vattam
	 */
	public void clkLegacyInternetBadge() {
		getReusableActionsInstance().getWhenReady(btnLegacyInternetBadge, 120).click();
	}
	

	/**
	 * To click on the CTN badge in account overview page
	 * @param strLast4DigitCtn, String, last 4 digit of the CTN
	 * @author ning.xue 
	 */
	public void clkCtnBadge(String strLast4DigitCtn) {
		
		getReusableActionsInstance().getWhenReady(By.xpath("//ute-data-manager-badge-list-directive//div[contains(text(),'" + strLast4DigitCtn + "')]/parent::div"), 30).click();
	}
	
	/**
	 * Close the New Look Pop up if visible on the dash board
	 * @author ning.xue
	 */
	public void clkCloseInNewLookPopupIfVisible() {
		if (getReusableActionsInstance().isElementVisible(newLookPopUp, 10)){
			getReusableActionsInstance().getWhenReady(iconCloseInPopup, 10).click();
			//getReusableActionsInstance().clickIfAvailable(iconCloseInPopup,10);
		}
	}
	
	/**
	 * Clicks on the 'InternetPopup' option on the dash board
	 * @author chinnarao.vattam
	 */
	public void clkInternetPopup() {
		getReusableActionsInstance().clickIfAvailable(popUpInternetPopup, 60);
	}

	/**
	 * Clicks on the 'TV Badge' option on the dash board
	 * @author chinnarao.vattam
	 */
	public void clkTVBadge( ) {	
		getReusableActionsInstance().getWhenReady(btnTVBadge, 60).click();
	}
	
	/**
	 * Clicks on the 'TV Badge' option on the dash board
	 * @author chinnarao.vattam
	 */
	public void clkTVBadgeMobile() {
		getReusableActionsInstance().isElementVisible(btnTVBadge,110);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().executeJavaScriptClick(btnTVBadge);
	}
	
	/**
	 * Clicks on the 'RHP Badge' option on the dash board
	 * @author chinnarao.vattam
	 */
	public void clkRHPBadge() {
		getReusableActionsInstance().getWhenReady(btnRHPBadge, 90).click();
		}

	/**
	 * Clicks on the 'Smart Stream Badge' option on the dash board
	 * @author chinnarao.vattam
	 */
	public void clkSmartStream() {
		getReusableActionsInstance().getWhenReady(btnSmartStream, 90).click();
	}

	/**
	 * Clicks on the 'RHP Badge' option on the dash board
	 * @author chinnarao.vattam
	 */
	public void clkRHPBadgeMobile() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(btnRHPBadge, 90).click();
		}
	
	/**
	 * Check if the account selection header display or not
	 * @return true if it display, otherwise false.
	 * @author ning.xue
	 */
	public Boolean isAccountSelectionPopupDisplayed() {
		return getReusableActionsInstance().isElementVisible(headerAccountSelect);
	}

	/**
	 * To Select Account on the accounts popup
	 * @param strAccountNumber account number of the Roger's customer
	 * @author ning.xue
	 */
	public void selectAccount(String strAccountNumber) {		
	getReusableActionsInstance().clickIfAvailable((By.xpath("//span[contains(@class,'account')]/following-sibling::span[text()='" + strAccountNumber + "']")), 30);
	}
	
	/**
	 * To check if account is already linked
	 * @param strAccountNumber account number of the Roger's customer
	 * @return true if the account number match otherwise false.
	 * @author ning.xue
	 */
	public Boolean isAccountLinked(String strAccountNumber) {
		return getReusableActionsInstance().isElementVisible(
				(By.xpath("//span[contains(@class,'account')]/following-sibling::span[text()='" + strAccountNumber + "']")), 
				20);
	}
	
	/**
	 * To click Menu UsageAndService in account overview page.
	 * @author ning.xue
	 */
	public void clkMenuUsageAndService() {
		boolean clickSuccess=false;
		int count=0;
		while (count<=2 && !clickSuccess) {
			System.out.println("Attempt: "+(count+1)+" Usage and service click");
//			// buffer static wait added to handle anomalies on firefox
//			getReusableActionsInstance().staticWait(4000);
			getReusableActionsInstance().getWhenReady(menuUsageAndService,30).click();
			if(getReusableActionsInstance().isElementVisible(subMenuUsageDropDown, 10)
					|| getReusableActionsInstance().isElementVisible(subMenuWirelessUsage, 10))
			{
				System.out.println("Usage and service click successful in attempt: "+(count+1));
				clickSuccess=true;				
				break;
				
			}
			count++;
		}
		
	} 
	
	/**
	 * To click sub-Menu Wireless Usage of UsageAndService drop down in account overview page.
	 * @author ning.xue
	 */
	public void clkSubMenuWirelessUsage() {
		getReusableActionsInstance().clickWhenReady(subMenuWirelessUsage, 10);
	}
	
	/**
	 * To check if account show in Menu UsageAndService drop down on account overview page.
	 * @param strLast4DigAcctNum string account number
	 * @return true if element visible else false
	 * @author Ning.Xue
	 */
	public boolean isAccountShowInDropDown(String strLast4DigAcctNum) {
		return getReusableActionsInstance().isElementVisible(
				(By.xpath("//span[contains(@data-translate-values,'" + strLast4DigAcctNum + "') or contains(text(),'" + strLast4DigAcctNum + "')]")), 
				10);
	}
	
	/**
	 * To check if account show in Menu UsageAndService drop down on account overview page.
	 * @param strLast4DigAcctNum string last four digits of account number
	 * @author Ning.Xue
	 */
	public void clkDropDownAccount(String strLast4DigAcctNum) {
		getReusableActionsInstance().clickWhenReady(
				(By.xpath("//span[contains(@data-translate-values,'" + strLast4DigAcctNum + "') or contains(text(),'" + strLast4DigAcctNum + "')]")));

	}
	
	/**
	 * Click on menu Profile and Settings
	 * @author ning.xue
	 */
	public void clkLnkProfileNSettings() {

		boolean clickSuccess=false;
		int count=0;
		while (count<=3 && !clickSuccess) {
			System.out.println("Attempt: "+(count+1)+" Profile and settings click");
//			// buffer static wait added to handle anomalies on firefox
//			getReusableActionsInstance().staticWait(4000);
			getReusableActionsInstance().getWhenReady(menuProfileNSettings,30).click();
			getReusableActionsInstance().waitForElementVisibility(headerProfileNSettings,60);
			if(getReusableActionsInstance().isElementVisible(headerProfileNSettings))
			{
				System.out.println("Profile and settings click successful in attempt: "+(count+1));
				clickSuccess=true;				
				break;
				
			}
			count++;
		}
	}
	
	/**
	 * Click on menu Profile and Settings on Mobile
	 * @author Mirza.Kamran
	 */
	public void clkLnkProfileNSettingsMobile() {		
		getReusableActionsInstance().getWhenReady(btnOverViewMobile,30).click();
		getReusableActionsInstance().getWhenReady(menuProfileAndSettingsMobile,30).click();
		getReusableActionsInstance().waitForElementVisibility(headerProfileNSettings,60);
					
	}
	
	/**
	 * Click on menu  on Mobile
	 * @author Mirza.Kamran
	 */
	public void clkMenuUsageAndServiceMobile() {		
		getReusableActionsInstance().getWhenReady(btnOverViewMobile,30).click();
		getReusableActionsInstance().getWhenReady(menuUsageAndServicesMobile,30).click();
		//getReusableActionsInstance().waitForElementVisibility(headerProfileNSettings,60);
					
	}
	
	/**
	 * To verify the successful login
	 * @return true if the balance label is present ; else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySuccessfulLogin() {	
		 int counter = 0;
		 boolean overviewPageLoaded = false;
		 getReusableActionsInstance().waitForElementVisibility(menuAccountNumber,60);
		 String strAccountNumber = getReusableActionsInstance().getWhenReady(menuAccountNumber,30).getText();
		 while (counter<3) {
			 
			 if(NumberUtils.isDigits(strAccountNumber))
			 {
				 overviewPageLoaded = true;
				 break;
			 }
			 getReusableActionsInstance().staticWait(5000);
			 strAccountNumber = getReusableActionsInstance().getWhenReady(menuAccountNumber,30).getText();
			 counter++;		 
		}
		 return overviewPageLoaded;
	}
		
	
	/**
	 * To verify the successful login
	 * @return true if the balance label is present ; else false
	 * @author Mirza.Kamran
	 */
	public boolean verifySuccessfulLoginMobile() {	
	 int counter = 0;
	 boolean overviewPageLoaded = false;
	 getReusableActionsInstance().waitForElementVisibility(menuAccountNumberMobile,90);
	 String strAccountNumber = getReusableActionsInstance().getWhenReady(menuAccountNumberMobile,5).getText();
	 while (counter<3) {
		 
		 if(NumberUtils.isDigits(strAccountNumber))
		 {
			 overviewPageLoaded = true;
			 break;
		 }
		 getReusableActionsInstance().staticWait(5000);
		 strAccountNumber = getReusableActionsInstance().getWhenReady(menuAccountNumber,30).getText();
		 counter++;		 
	}
	 return overviewPageLoaded;
	}
	
	
	/**
	 * To verify the successful login
	 * @return true if the balance label is present ; else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLoginSuccessWelcome() {
		return getReusableActionsInstance().isElementVisible(infoWelcome,60);
	}

	/**
	 * To Verify the RHP Banner on the Legacy RHP dash board
	 * @return true if the package name is Home Phone ; else false
	 * @author chinnarao.vattam
	 */
	public boolean verfyContactUsToManageFeaturess() {
		return getReusableActionsInstance().isElementVisible(lnkContactUsToManageFeaturess, 60);
	}
	
	/**
	 * Validates and clicks on the Wireless Phone Number under Share Everything
	 * @param strCTN - Phone Number
	 * @return - true if Phone Number found; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyAndClickShareEverythingCTN(String strCTN) {
		strCTN = strCTN.replace(" ", "");
		strCTN = strCTN.substring(0, 3) + " " + strCTN.substring(3, 6) + "-" + strCTN.subSequence(6, 10);
		String strCTNXpath = "//span[contains(@class,'subscription-number')][text()='"+strCTN+"']/ancestor::a";

		if(getReusableActionsInstance().isElementVisible(By.xpath(strCTNXpath))) {
			getReusableActionsInstance().executeJavaScriptClick(getDriver().findElement(By.xpath(strCTNXpath)));
			return true;
		}
		return false;
	}

	/**
	 * Validates the First Name of the Caller ID under Share Everything 
	 * @param strFirstName First Name of the Caller ID
	 * @return true if the name matches ; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifySECallerIdFirstName(String strFirstName) {
		return getReusableActionsInstance().isElementVisible(By.xpath("//div[contains(@class,'sharedWireless')]//div[contains(text(),'" + strFirstName.toUpperCase() +"')]"),60);
	}
	
	/**
	 * Validates and clicks on the Wireless Phone Number
	 * @param strCTN - Phone Number
	 * @return - true if Phone Number found; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyAndClickWirelessCTN(String strCTN) {
		strCTN = strCTN.replace("-", "").replace(" ", "");
		String strCTNWithUnderScore = strCTN.substring(0, 3) + "-" + strCTN.substring(3, 6) + "-" + strCTN.subSequence(6, 10);	
		String strCTNWithUnderScoreXpath = "//div[@class='myServiceName']//div[contains(text(),'" + strCTNWithUnderScore + "')]";
		
		String strCTNWithoutUnderScore = strCTN.substring(0, 3) + " " + strCTN.substring(3, 6) + "-" + strCTN.subSequence(6, 10);	
		String strCTNWithOutUnderScoreXpath = "//div[@class='service-container mt-24']//span[contains(text(),'" + strCTNWithoutUnderScore + "')]";
		
		if(getReusableActionsInstance().isElementVisible(By.xpath(strCTNWithUnderScoreXpath))) {
			getReusableActionsInstance().scrollToElement(getReusableActionsInstance().getWhenReady(By.xpath(strCTNWithUnderScoreXpath)));
			getReusableActionsInstance().clickWhenReady(By.xpath(strCTNWithUnderScoreXpath), 120);
			return true;
		}else if(getReusableActionsInstance().isElementVisible(By.xpath(strCTNWithOutUnderScoreXpath))){
			getReusableActionsInstance().scrollToElement(getReusableActionsInstance().getWhenReady(By.xpath(strCTNWithOutUnderScoreXpath)));
			getReusableActionsInstance().clickWhenReady(By.xpath(strCTNWithOutUnderScoreXpath), 120);
			return true;
		}else if (verifyAndClickShareEverythingCTN(strCTN)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Validates the First Name of the Caller ID for non-SE subscriber
	 * @param strFirstName First Name of the Caller ID 
	 * @return true if the name matches ; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyWirelessCallerIdCTNBadgeName(String strFirstName) {
		
		return getReusableActionsInstance().getWhenReady(lblCTNWirelessName,20).getText().trim().toLowerCase().contains(strFirstName.toLowerCase());
	}
	
	/**
	 * Validates the Message - 'Your account was successfully linked to your profile!'
	 * @return true if message displayed ; else false;
	 * @author rajesh.varalli1
	 */
	public boolean verifyLinkAccountSuccessful() {
		return getReusableActionsInstance().isElementVisible(lblLinkAccountSuccess,120);
	}
	
	/**
	 * Clicks on the 'Link Another Account' option in the Account menu
	 * @author rajesh.varalli1
	 */
	public void clkLinkAnotherAccount() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		getReusableActionsInstance().clickIfAvailable(lnkAccountdropdown);
		getReusableActionsInstance().clickIfAvailable(lnkLinkAnotherAccount);
	}
	
	/**
	 * Clicks on the 'Billing and Payment' then 'Set up automatic payment' option
	 * @author Mirza.Kamran
	 */
	public void clkSetUpAutomaticPaymentMethod() {
		//getReusableActionsInstance().waitForElementVisibility(lnkBillingAndPayment);
		//getReusableActionsInstance().clickIfAvailable(lnkBillingAndPayment);
		getReusableActionsInstance().getWhenReady(lnkSetUpAutomaticPaymentMethod,60).click();
	}
	
	
	/**
	 * Clicks on the 'Billing and Payment' then 'Set up automatic payment' option
	 * @author Mirza.Kamran
	 */
	public void clkSetUpAutomaticPaymentMethodMobile() {
		if(getReusableActionsInstance().isElementVisible(btnOverViewMobile))
		{
		
		getReusableActionsInstance().getWhenReady(btnOverViewMobile,30).click();
		}else if (getReusableActionsInstance().isElementVisible(menuMainBillingAndPaymentsMobile))
		{
			getReusableActionsInstance().getWhenReady(menuMainBillingAndPaymentsMobile,30).click();
		}	
		getReusableActionsInstance().getWhenReady(menuBillingAndPaymentsMobile,30).click();
		getReusableActionsInstance().waitForElementVisibility(submenuSetUpAutomaticPaymentMethodMobile);
		getReusableActionsInstance().getWhenReady(submenuSetUpAutomaticPaymentMethodMobile).click();
	}
	
	/**
	 * Clicks on the submenu of 'Billing and Payment'  'Set up automatic payment' option
	 * @author Mirza.Kamran
	 */
	public void clkBillngsAndPaymentsSubMenuSetUpAutomaticPaymentMethod() {
		getReusableActionsInstance().waitForElementVisibility(lnkSetUpAutomaticPaymentMethod);
		getReusableActionsInstance().getWhenReady(lnkSetUpAutomaticPaymentMethod).click();
	}
	
	/**
	 * Clicks on the submenu of 'Billing and Payment'  'Set up automatic payment' option
	 * @author Mirza.Kamran
	 */
	public void clkBillngsAndPaymentsSubMenuSetUpAutomaticPaymentMethodMobile() {
		getReusableActionsInstance().waitForElementVisibility(submenuSetUpAutomaticPaymentMethodMobile);
		getReusableActionsInstance().getWhenReady(submenuSetUpAutomaticPaymentMethodMobile).click();
		//getReusableActionsInstance().clickIfAvailable(submenuSetUpAutomaticPaymentMethodMobile);
	}
	
	/**
	 * Clicks on the 'Billing and Payment' then 'Change Payment Method' option
	 * @author Mirza.Kamran
	 */
	public void clkBillingAndPaymentsSubMenuChangePaymentMethod() {		
		getReusableActionsInstance().clickIfAvailable(lnkChangePaymentMethod);
	}
	
	/**
	 * Clicks on the 'Make a payment' button
	 * @author rajesh.varalli1
	 */
	public void clickMakePayment() {
		//getReusableActionsInstance().waitForElementTobeClickable(btnMakeAPayment, 20);
		//getReusableActionsInstance().getWhenReady(btnMakeAPayment,10).click();
		
		boolean clickSuccess=false;
		int count=0;
		while (count<=3 && !clickSuccess) {
			System.out.println("Attempt: "+(count+1)+" Make payment button");

			getReusableActionsInstance().getWhenReady(btnMakeAPayment,30).click();
			getReusableActionsInstance().waitForElementVisibility(lblHowWouldYouPay,10);
			if(getReusableActionsInstance().isElementVisible(lblHowWouldYouPay))
			{
				System.out.println("Make payment button clicked in attempt: "+(count+1));
				clickSuccess=true;				
				break;
				
			}
			count++;
		}
		
		
	}
	
	/**
	 * Clicks on the 'View Your Bill' button
	 * @author rajesh.varalli1
	 */
	public void clickViewYourBill() {
		getReusableActionsInstance().clickIfAvailable(btnViewYourBill);
	}

	/**
	 * Checks if the auto payment is set
	 * @return true if set automatic payment sub menu is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isSetAutoPaymentDisplayed() {
		getReusableActionsInstance().waitForElementTobeClickable(lnkBillingAndPayment, 30);
		getReusableActionsInstance().staticWait(2000);
		getReusableActionsInstance().executeJavaScriptClick(lnkBillingAndPayment);
		getReusableActionsInstance().staticWait(3000); //extra static buffers added for firefox
		return getReusableActionsInstance().isElementVisible(lnkSetUpAutomaticPaymentMethod);
	}
	
	/**
	 * Checks if the auto payment is displayed
	 * @return true if set automatic payment sub menu is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isLnkSetAutoPaymentDisplayed() {		
		return getReusableActionsInstance().isElementVisible(lnkSetUpAutomaticPaymentMethodAOPage);
	}
	
	/**
	 * Checks if the auto payment is set
	 * @return true if set automatic payment sub menu is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isSetAutoPaymentDisplayedMobile() {
		if(getReusableActionsInstance().isElementVisible(btnOverViewMobile))
		{
		
		getReusableActionsInstance().getWhenReady(btnOverViewMobile,30).click();
		}else if (getReusableActionsInstance().isElementVisible(menuMainBillingAndPaymentsMobile))
		{
			getReusableActionsInstance().getWhenReady(menuMainBillingAndPaymentsMobile,30).click();
		}
		getReusableActionsInstance().getWhenReady(menuBillingAndPaymentsMobile,30).click();
		return getReusableActionsInstance().isElementVisible(lnkSetUpAutomaticPaymentMethodMobile);
	}

	/**
	 * Checks if the auto payment option is set successfully
	 * @return true if the payment option is set successfully
	 * @author Mirza.Kamran
	 */
	public boolean verifyThatAutoPaymentIsDisplayedOnAccountOverViewPage() {
		getReusableActionsInstance().waitForElementVisibility(lblAutoPayment);
		return (getReusableActionsInstance().isElementVisible(lblAutoPayment)
			 && getReusableActionsInstance().isElementVisible(imgBank));
	}	
	
	/**
	 * Checks if the auto payment option is set successfully to CC
	 * @return true if the payment option is set successfully
	 * @author Mirza.Kamran
	 */
	public boolean verifyThatAutoPaymentWithCCIsDisplayedOnAccountOverViewPage() {
		// buffer static wait added for pageload
		getReusableActionsInstance().staticWait(4000);
		getReusableActionsInstance().waitForElementVisibility(lblAutoPayment, 50);
		getReusableActionsInstance().staticWait(2000);
		return (getReusableActionsInstance().isElementVisible(lblAutoPayment,20)
			 && getReusableActionsInstance().isElementVisible(imgCC,20));
	}

		
	/**
	 * Checks if the auto payment option is set successfully to CC
	 * @return true if the payment option is set successfully
	 * @author Mirza.Kamran
	 */
	public boolean verifyCCEndingWithIsDisplayedCorrectly() {		
		return getReusableActionsInstance().isElementVisible(txtCC,30);
	}
	
	/**
	 * Checks if the CC auto payment option is displayed on Account overview
	 * @return true if the CC payment option is displayed on account overview, else false
	 * @author Mirza.Kamran
	 */
	public boolean isCCDisplayedOnAccountOverViewPage() {		
		return (getReusableActionsInstance().isElementVisible(lblAutoPayment,30)
			 && getReusableActionsInstance().isElementVisible(imgCC));
	}
	
	/**
	 * Clicks on the menu Billing and Payments and selects the submenu Make Payment option
	 * @author Mirza.Kamran
	 */
	public void clkBillingAndPaymentsMakeAPayment() {	
	
		boolean clickSuccess=false;
		int count=0;
	try {	
		while (count<=3 && !clickSuccess) {
			System.out.println("Attempt: "+(count+1)+" Billing and payments");
			getReusableActionsInstance().waitForElementTobeClickable(lnkBillingAndPayment, 360);
			// buffer static wait added to handle anomalies on firefox
			getReusableActionsInstance().staticWait(4000);
			getReusableActionsInstance().executeJavaScriptClick(lnkBillingAndPayment);
			getReusableActionsInstance().waitForElementVisibility(lnkMakePayment);
			getReusableActionsInstance().executeJavaScriptClick(lnkMakePayment);
			if(getReusableActionsInstance().isElementVisible(txtAmount))
			{
				System.out.println("Billing and payment click successful in attempt: "+(count+1));
				clickSuccess=true;				
				break;
				
			}
			count++;
		}
	}catch (StaleElementReferenceException e) {
		// TODO:  the stale ref exception if encountered
	}
		
		
	}
	
	/**
	 * The Wireless usage and service is visible
	 * @param strFirstName parameter First name
	 * @return boolean true if the ctn is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyWirelessCallerIdUpdatedInDropDownToSelectWirelessUsage(String strFirstName) {					
		return (getReusableActionsInstance().isElementVisible((By.xpath("//a[@class='c-dropdown-item']/span[contains(text(),'" + strFirstName + "')]")),20)
				|| getReusableActionsInstance().isElementVisible((By.xpath("//span[contains(@data-translate-values,'" + strFirstName + "')]")),20)) ;
	}
	
	/**
	 * Checks if more than one ban present, the count will be more than 3
	 * @return true if more than one ban present else false
	 * @author Mirza.Kamran
	 */
	public boolean isMoreThanOneBanPresent() {
		return (lstAccountBans.size()>3);
	} 
	
	/**
	 * Click on the Overview tab
	 * @author Saurav.Goyal
	 */
	public void clickOverview() {
		getReusableActionsInstance().clickWhenReady(clkOverview);
	}
	
	/**
	 * To select first account from the account drop down
	 * @author Saurav.Goyal
	 */
	public void selectAnAccountFromTheAccountDropDown() {
		getReusableActionsInstance().getWhenReady(lstAccountBans.get(1), 120).click();
	}

	/**
	 * Checks if the no of CTNS are more than 5
	 * @return true if the no of CTNS are more than 5
	 * @author Mirza.Kamran
	 */
	public boolean isCTNMoreThanSix() {		
		return lstCtnBadges.size()>5;
	}

	/**
	 * Checks if the no of CTNS are more than 1
	 * @return true if the no of CTNS are more than 5
	 * @author Mirza.Kamran
	 */
	public boolean isCTNMoreThanOne() {		
		return lstCtnBadges.size()>1;
	}
	
	/**
	 * Checks if the no CTNS are displayed
	 * @return true if the no CTNS are displayed
	 * @author Mirza.Kamran
	 */
	public boolean isCTNNotDisplayed() {		
		return lstCtnBadges.size()==0;
	}
	
	/**
	 * retruns total no of CTNS
	 * @return int value total no of CTNs
	 * @author Mirza.Kamran
	 */
	public int getTotalCTN() {		
		return lstCtnBadges.size();
	}
	
	/**
	 * Checks if the suspended CTN is displayed
	 * @return boolean true if the suspended CTN is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isSuspendedCTNAvailable() {	
		
		return getReusableActionsInstance().isElementVisible(lstSuspendedCTNs.get(0));
				
	}
	
	/**
	 * Checks if the suspended CTN is displayed 
	 * @author Mirza.Kamran
	 */
	public void clkSuspendedCTN() {	
		getReusableActionsInstance().getWhenReady(lstSuspendedCTNs.get(0)).click();
	}
	
	
	/**
	 * Click the overview navigation button on the page 
	 * @author ning.xue
	 */
	public void clkBtnNavigationMobile() {		
		getReusableActionsInstance().getWhenVisible(btnNavigationBarMobile, 30).click();
	}
	
	/**
	 * Clicks on Profile and settings button on mobile
	 * @author ning.xue
	 */
	public void clkBtnProfileSettingsMobile() {		
		getReusableActionsInstance().getWhenVisible(btnProfileSettingsMobile, 30).click();
	}
	
	/**
	 * Scroll to middle of page
	 * @author Mirza.Kamran
	 */
	public void scrollToMiddleOfPage() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		
	}

	/**
	 * Scroll to bottom of page
	 * @author Mirza.Kamran
	 */
	public void scrollToBottomOfPage() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		
		
	}

	/**
	 * Scroll to bottom of page
	 * @author Mirza.Kamran
	 */
	public void scrollToTopOfPage() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
	}
	
	/**
	 * Clicks on Tupelo entertainment badge
	 * @author Mirza.Kamran
	 */
	public void clkEntertainmentBadge() {
		getReusableActionsInstance().getWhenReady(btnEntertainmentBadge).click();
		
	}

	/**
	 * Clicks on view bill if available
	 * @author Mirza.Kamran
	 */
	public void clkViewBill() {
	getReusableActionsInstance().clickIfAvailable(btnViewYourBill);
		
	}

	/**
	 * Clicks on view bill if available
	 * @author Mirza.Kamran
	 * @return true if the view bill is displayed else false
	 */
	public boolean isViewBillDisplayed() {
	return getReusableActionsInstance().isElementVisible(btnViewYourBill);
		
	}
	
	/**
	 * Clicks on Billings and payments sub menu change paymeny mobile
	 * @author Mirza.Kamran
	 */
	public void clkBillingAndPaymentsSubMenuChangePaymentMethodMobile() {			
		getReusableActionsInstance().waitForElementVisibility(submenuChangePaymentMethod,60);
		getReusableActionsInstance().getWhenReady(submenuChangePaymentMethod).click();
		
	}

	/**
	 * Is Change payment method displayed
	 * @return true if the change payment method is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isChangePaymentMethodDisplayed() {
		return getReusableActionsInstance().isElementVisible(lnkBelowCardChangePaymentMethod);
	}

	/**
	 * The account is cancelled message is displayed
	 * @author Mirza.Kamran
	 * @return true if the message is displayed else false
	 */
	public boolean isAccountCancelledMessageDisplayed() {
		return getReusableActionsInstance().isElementVisible(divAccountCancelled);
	}
	
	/**
	 * The view billing and payment history is displayed inside account is cancelled message
	 * @author Mirza.Kamran
	 * @return true if the message is displayed else false
	 */
	public boolean isViewBillingAndPaymentHistoryDisplayedInsideAccountCancelledMessage() {
		return getReusableActionsInstance().isElementVisible(lnkViewBillingAndPayment);
	}
	
	/**
	 * The Manage Profile link is displayed inside account is cancelled message
	 * @author Mirza.Kamran
	 * @return true if the message is displayed else false
	 */
	public boolean isManageProfileLinkDisplayedInsideAccountCancelledMessage() {
		return getReusableActionsInstance().isElementVisible(lnkManageProfile);
	}

	/**
	 * Payment history link is displayed
	 * @return true if the payment history link is displayed on account overview page else false
	 * @author Mirza.Kamran
	 */
	public boolean isLnkPaymentHistoryDisplayed() {
		return getReusableActionsInstance().isElementVisible(lnkPaymentHistoryDisplayed);
	}

	/**
	 * To verify if the live chat button display in wireless dashboard page
	 * @return true if the button displayed otherwise false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLiveChatButtonIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(btnLiveChat, 30);
	}
	
	/**
	 * Click the button Live chat in wireless dashboard page
	 * @author Mirza.Kamran
	 */
	public void clkBtnLiveChat() {
		getReusableActionsInstance().getWhenReady(btnLiveChat, 20).click();
	}
	
	/**
	 * To verify if the live chat overlay opened in wireless dashboard page
	 * @return true if the overlay opened otherwise false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLiveChatOverlayOpened() {	
	  if(getReusableActionsInstance().isElementVisible(fraLiveChat))
		{
		getReusableActionsInstance().waitForFrameToBeAvailableAndSwitchToIt(fraLiveChat, 20);
		return getReusableActionsInstance().isElementVisible(headerLiveChat, 30);
		}else
		{
			return getReusableActionsInstance().isElementVisible(headerLiveChat, 30);
		}
		
	}

	/**
	 * To verify if the live chat overlay opened in wireless dashboard page
	 * @return true if the overlay opened otherwise false
	 * @author Mirza.Kamran
	 */
	public boolean verifyLiveChatOverlayOpenedFromSuspensionNotification() {	
	  
			return getReusableActionsInstance().isElementVisible(headerRogersLiveChat, 30);
	}
	
	/**
	 * Clicks on back to devices page
	 * @author Mirza.Kamran
	 */
	public void clkbtnBackToDevices() {
		getReusableActionsInstance().clickWhenReady(btnClickBackToDevice);
	}



	/**
	 * Clicks on make payment on mobile
	 * @author Mirza.Kamran
	 */
	public void clickMakePaymentMobile() {
		getReusableActionsInstance().getWhenReady(btnOverViewMobile,30).click();
		getReusableActionsInstance().getWhenReady(menuBillingAndPaymentsMobile,30).click();
		getReusableActionsInstance().getWhenReady(btnMakeAPayment,30).click();
		
	}

	/**
	 * Checks if the add link is displayed below the list of CTNs
	 * @return true if the CTN displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isAddALinkDisplayedBelowCTNs() {
		return getReusableActionsInstance().isElementVisible(lnkAddALine);
	}

	/**
	 * Clicks  on Add Link 
	 * @author Mirza.Kamran
	 */
	public void clkAddALink() {
		getReusableActionsInstance().getWhenReady(lnkAddALine).click();
		
	}

	/**
	 * Checks if the add link overlay is displayed	 *
	 * @return true if the link is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfAddALinkOverlayOnDeviceSelectionPageIsdisplayed() {
		return getReusableActionsInstance().isElementVisible(headerOverlayforAddLink,30)
				&& getReusableActionsInstance().isElementVisible(btnAddToSharedPlan)
				&& getReusableActionsInstance().isElementVisible(btnAddToNonSharedPlan)
				&& get_Driver_Url().contains("choose-phone?");
	}

	/**
	 * Checks if the Credit limit reached notification is displayed
	 * @return true if the credit limit reached notification is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isCreditLimitReachedNotificationDisplayed() {
		return getReusableActionsInstance().isElementVisible(lblCreditLimitExceeded);
	}

	/**
	 * Checks if Individual Wireless CTNs displayed
	 * @return return true if Individual Wireless is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isIndividualWirelessCTNsDisplayed() {
		return (getReusableActionsInstance().isElementVisible(lstIndividualWirelessCTNs.get(0))
				&& lstShareEverythingCTNs.get(0).getLocation().x<lstIndividualWirelessCTNs.get(0).getLocation().x
				&& lstIndividualWirelessCTNs.get(0).getLocation().x<lstResidentialServicesCTNs.get(0).getLocation().x
			);
	} 
	
	/**
	 * Checks if Residential services CTNs displayed
	 * @return return true if Residential services is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isResidentialServicesCTNsDisplayed() {
		return (getReusableActionsInstance().isElementVisible(lstResidentialServicesCTNs.get(0))
				&& lstIndividualWirelessCTNs.get(0).getLocation().x<lstResidentialServicesCTNs.get(0).getLocation().x
			);
	} 
	
	/**
	 * Checks if share everything CTNs displayed
	 * @return return true if share everything is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isShareEverythingDisplayed() {
		return (getReusableActionsInstance().isElementVisible(lstShareEverythingCTNs.get(0))
				&& lstShareEverythingCTNs.get(0).getLocation().x<lstIndividualWirelessCTNs.get(0).getLocation().x
				);
	}

	/**
	 * Checks if the CTNS are left aligned correctly under each CTN category
	 * @return int values depicting status of alignment
	 * @author Mirza.Kamran
	 */
	public int isShareEverythingCTNLeftAligned() {
		int alignmentvalue = 0;
		int alignmentStatus = 1;
		if(lstShareEverythingCTNs.size()>1)
		{
			alignmentvalue = lstShareEverythingCTNs.get(0).getLocation().x;
			for (WebElement webElement : lstShareEverythingCTNs) {
				if(alignmentvalue!=webElement.getLocation().x)
				{
					alignmentStatus = 3;
				}
			}
		}else
		{
			alignmentStatus = 2;
		}
		
		return alignmentStatus;
	}

	/**
	 * checks if the top up button is displayed
	 * @return true if the button is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isTopUpButtonDisplayed() {
		return getReusableActionsInstance().isElementVisible(btnPrepaidTopUpNow);
	}

	/**
	 * Checks if Current Account Balance is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isCurrentAccountBalanceDisplayed() {
		
		return (getReusableActionsInstance().isElementVisible(lblCurrentAccountBalance)
				&& getReusableActionsInstance().isElementVisible(lblCurrentBalanceAmount));
	}

	/**
	 * Checks if Balance expires is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isBalanceExpiresOnDisplayedOnAOPage() {
		String strValue =getReusableActionsInstance().getWhenReady(lblBalanceExpiresOn).getText().trim();
		strValue = CurrencyHelpers.removeLineBreaksFromString(strValue).split(":")[1].trim();
		return DateHelpersFunctions.isValidDAte(strValue);
		//return (DateHelpersFunctions.isValidDAte(getReusableActionsInstance().getWhenReady(lblBalanceExpiresOn).getText().trim().split(":")[1].trim()));
	}

	
	/**
	 * Checks if Link update payment method is displayed is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isLnkUpdatePaymentMethodDisplayedOnAOPage() {
		return getReusableActionsInstance().isElementVisible(lnkUpdatePaymentMethod);
	}

	/**
	 * Checks if Link view call transaction history is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isLnkViewCallTransactionHistoryDisplayedOnAOPage() {
		return getReusableActionsInstance().isElementVisible(lnkViewCallTransactionHistory);
		
	}

	/**
	 * Checks if CTN widget is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isCTNWidgetIsDisplayedOnAOPg(String strCTN) {
		return getReusableActionsInstance().isElementVisible(By.xpath("//rss-subscription-detail//span[contains(text(),'"+strCTN.substring(strCTN.length()-4)+"')]"));
	}

	/**
	 * Checks if Current Account Balance is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isAccountPreferencesSectionDisplayedAOPg() {
		return getReusableActionsInstance().isElementVisible(lblAccountPreferences)
				&& getReusableActionsInstance().isElementVisible(lnkChangeContactInfo)
				&& getReusableActionsInstance().isElementVisible(lnkChangePassword);
		
	}

	/**
	 * Checks if Other services is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isOtherServicesDisplayedOnAOPg() {
		return getReusableActionsInstance().isElementVisible(lblOtherServicesAvailable);
		
	}

	/**
	 * Clicks on CTN widget is clicked
	 * @author Mirza.Kamran
	 */
	public void clkCTNWidget(String strCTN) {
		getReusableActionsInstance().getWhenReady(By.xpath("//rss-subscription-detail//span[contains(text(),'"+strCTN.substring(strCTN.length()-4)+"')]")).click();
		
	}

	/**
	 * Verifies if the account has subscription available which can be redeem
	 * @return true if available else false
	 * @author Mirza.Kamran
	 */
	public boolean verifySubscriptionIsAvailableForRedeem() {
		return getReusableActionsInstance().isElementVisible(btnSubscriptionSignUp);
	} 
	
	/**
	 * Verifies if the account has subscription available which can be redeem
	 * @return true if available else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfSubscriptionIsAvailableForCancellation() {
		return getReusableActionsInstance().isElementVisible(btnSubscriptionManage);
	}

	/**
	 * Verifies if the account has subscription available which can be redeem
	 * @return true if available else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfDPSubscriptionIsAvailableForCancellation() {
		return getReusableActionsInstance().isElementVisible(btnDPSubscriptionManage);
	}

	/**
	 * Verifies if the account has subscription available which can be redeem
	 * @author Mirza.Kamran
	 */
	public void clickDPlusSignUporManageButton() {
		if(getReusableActionsInstance().isElementVisible(btnSubscriptionSignUp))
		{
			getReusableActionsInstance().getWhenReady(btnSubscriptionSignUp).click();
		}else if(getReusableActionsInstance().isElementVisible(btnDPSubscriptionManage))
		{
			getReusableActionsInstance().getWhenReady(btnDPSubscriptionManage).click();
		}

	}

	/**
	 * Clicks on Manage button
	 * @author Mirza.Kamran
	 */
	public void clkManageOnSubscription() {
		getReusableActionsInstance().getWhenReady(btnSubscriptionManage).click();
	}

	/**
	 * Clicks on Manage button
	 * @author Mirza.Kamran
	 */
	public void clkManageOnSubscriptionDisneyPlus() {
		getReusableActionsInstance().getWhenReady(btnDPSubscriptionManage).click();
	}

	/**
	 * Verifies if the currently subscribed pane is displayed
	 * @return true if available else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfCurrentlySubscribedPaneIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(headerCurrentlySubscribed);
	}
		
	/**
	 * Verifies if the button cancel subscription is displayed
	 * @return true if available else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfButtonCancelSubscriptionIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(btnCancelSubscription);
	}
	
	/**
	 * Clicks on cancel subscription button
	 * @author Mirza.Kamran
	 */
	public void clkCancelSubscription() {
		getReusableActionsInstance().getWhenReady(btnCancelSubscription).click();
	}


	/**
	 * Clicks on cancel subscription button
	 * @author Mirza.Kamran
	 */
	public void clkCancelSubscription(String strCTN) {

		getReusableActionsInstance().getWhenReady(By.xpath("//span[@class='vas-subscriber-number' and contains(text(),'"+strCTN.substring(strCTN.length()-4)+"')]/ancestor::div[contains(@class,'vas-subscriber')]//a[contains(@title,'Cancel the Apple Music subscription for') or contains(@title,'Annuler l’abonnement')]")).click();
	}

		/**
		 * Verifies if the button cancel subscription is displayed
		 * @return true if available else false
		 * @author Mirza.Kamran
		 */
		public boolean verifyIfHeaderCancelSubscriptionIsDisplayed() {
			return getReusableActionsInstance().isElementVisible(headerCancelSubscription);
		}
		
				
		/**
		 * Verifies if the cancel subscription details are correctly displayed
		 * @return true if available else false
		 * @author Mirza.Kamran
		 */
		public boolean verifyIfCancelSubscriptionDetailsIsDisplayedCorrectly(String strSubscriberNumber) {
			return getReusableActionsInstance().getWhenReady(lblRogersCancellationForSubs).getText().trim().replaceAll(" ","").replaceAll("-","").contains(strSubscriberNumber);
		}
		
		/**
		 * Selects the cancellation reason
		 * @author Mirza.Kamran
		 */
		public void selectReasonForCancelSubscription() {
			getReusableActionsInstance().getWhenReady(selectReasonForCancel).click();
			getReusableActionsInstance().waitForElementTobeClickable(optReasonOne, 5);
			getReusableActionsInstance().getWhenReady(optReasonOne).click();
			//getReusableActionsInstance().selectWhenReadyByVisibleText(selectReasonForCancel, " I'm switching to another music service provider ");
		}

	/**
	 * Selects the cancellation reason
	 * @author Mirza.Kamran
	 */
	public void selectReasonForCancelSubscription(String strReason) {
		getReusableActionsInstance().getWhenReady(selectReasonForCancel).click();
		switch (strReason.toLowerCase())
		{

			case "immediate":
			{
				getReusableActionsInstance().waitForElementTobeClickable(optReasonForImmediateCancel, 5);
				getReusableActionsInstance().getWhenReady(optReasonForImmediateCancel).click();
				break;
			}
			case "deferred":
			{
				getReusableActionsInstance().waitForElementTobeClickable(optReasonForDefferedCancel, 5);
				getReusableActionsInstance().getWhenReady(optReasonForDefferedCancel).click();
				break;
			}
		}
	}

		/**
		 * Selects confirm cancel subscription
		 * @author Mirza.Kamran
		 */
		public void clkConfirmCancelSubscription() {
			getReusableActionsInstance().getWhenReady(btnConfirm).click();
		}

		/**
		 * verifies if the cancel success overlay is displayed
		 * @return true if displayed else false
		 * @author Mirza.Kamran
		 */
		public boolean verifyIfCancelSuccessfulOverLayDisplayed() {
			return getReusableActionsInstance().isElementVisible(headerCancelSuccess);
		}

	/**
	 * verifies if the cancel success overlay is displayed
	 * @return true if displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfCancelSuccessfulOverLayMentionsEffectiveImmediate() {
		return getReusableActionsInstance().isElementVisible(lblImmediateCancelSuccess);
	}

	/**
		 * Selects okay on cancel success overlay
		 * @author Mirza.Kamran
		 */
		public void clkOKButtonOnCancelSuccessOverlay() {
			getReusableActionsInstance().getWhenReady(btnOK).click();
		}

		/**
		 * 
		 * @return true if displayed else false
		 * @author Mirza.Kamran
		 */
		public boolean verifyIfSMPIsDisplayedWithCancelledSubscription() {			
			return (getReusableActionsInstance().isElementVisible(paneSMPCancelled)
					&& getReusableActionsInstance().isElementVisible(lblSMPpromotionEnds));
		}



	/**
	 *
	 * @return true if displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfSMPIsDisplayedWithSubscriptionEnded() {
		return (getReusableActionsInstance().isElementVisible(paneSMPCancelled)
				&& getReusableActionsInstance().isElementVisible(lblSMPpromotionEnded));
	}

		/**
		 * Clicks on sign up subscription
		 * @author Mirza.Kamran
		 */
		public void clkSignUpSubscription() {
			getReusableActionsInstance().getWhenReady(btnSubscriptionSignUp).click();
			
		}

		/**
		 * Verifies if the subs is available for redeem
		 * @return true if available else false
		 * @author Mirza.Kamran
		 */
		public boolean verifyIfSubscriptionIsAvailableForRedeem() {		
			return getReusableActionsInstance().isElementVisible(chkRedeemSubs);
		}

		/**
		 * Cliks on sign up subscription
		 * @author Mirza.Kamran
		 */
		public void clkSignUp() {
			getReusableActionsInstance().getWhenReady(btnSignUp).click();
			
		}

		/**
		 * Clicks on redeem check box
		 * @author Mirza.Kamran
		 */
		public void checkRedeem() {
			getReusableActionsInstance().getWhenReady(chkRedeemSubs).click();
		}

		/**
		 * Verifies if TnC is displayed
		 * @return true if displayed else false
		 * @author Mirza.Kamran
		 */
		public boolean verifyIfTnCForSubscriptionIsDisplayed() {			
			return getReusableActionsInstance().isElementVisible(headerTnC);
		}

		/**
		 * selects the TnC check box
		 * @author Mirza.Kamran
		 */
		public void checkTnC() {
			getReusableActionsInstance().getWhenReady(chkTnC).click();
			
		}

		/**
		 * Clicks subscribe button
		 * @author Mirza.Kamran
		 */
		public void clkSubscribeToSubs() {
		getReusableActionsInstance().getWhenReady(btnSubscribeToSubsscription).click();
			
		}

		/**
		 * Verifies if redeem details matches with CTN
		 * @param strSubscriberNumber CTN for which the subscription is redeem
		 * @return true if details match else false
		 * @author Mirza.Kamran
		 */
		public boolean verifyIfRedeemSubscriptionDetailsIsDisplayedCorrectly(String strSubscriberNumber) {			
			return getReusableActionsInstance().getWhenReady(lblRogersRedeemForSubs).getText().trim().replaceAll(" ","").replaceAll("-","").contains(strSubscriberNumber);
		}
		
		/**
		 * verifies if the Subscription success overlay is displayed
		 * @return true if displayed else false
		 * @author Mirza.Kamran
		 */
		public boolean verifyIfSubscriptionSuccessfulOverLayDisplayed() {
			return getReusableActionsInstance().isElementVisible(By.xpath("//*[contains(text(),'Subscription successful') or contains(text(),'Abonnement réussi')]"));
			
		} 
		
		/**
		 * Selects okay on Subscription success overlay
		 * @author Mirza.Kamran
		 */
		public void clkOKButtonOnSubscriptionSuccessOverlay() {
			getReusableActionsInstance().staticWait(15000);
			getReusableActionsInstance().getWhenReady(btnOK).click();
			getReusableActionsInstance().staticWait(3000);
		}

		/**
		 * Clicks close FAQ
		 * @author Mirza.Kamran
		 */
		public void clkCloseFAQ() {
			getReusableActionsInstance().getWhenReady(By.xpath("//a[text()='Yes']")).click();
			
		}

		/**
		 * Verifies if the subscribed details match
		 * @param strSubscriberNumber 
		 * @return true if the details match else false
		 * @author Mirza.Kamran
		 */
		public boolean verifyIfSMPIsDisplayedWithSubscribedCTN(String strSubscriberNumber) {
			return (getReusableActionsInstance().getWhenReady(paneSMPSubsCTN).getText().trim().replaceAll(" ","").replaceAll("-","").contains(strSubscriberNumber)
					&& getReusableActionsInstance().isElementVisible(lblSMPpromotionStarted)
					&& getReusableActionsInstance().isElementVisible(btnCancelSubscription));
		}

		/**
		 * Service suspended notification is displayed
		 * @author Mirza.Kamran
		 * @return true if the suspended service notification is displayed else false
		 */
		public boolean isServicesSuspendedNotificationDisplayed() {			
			return (getReusableActionsInstance().isElementVisible(lblServiceSuspended)
					&& getReusableActionsInstance().isElementVisible(btnLiveChatInsideSuspendedNotification));
		}
		
		/**
		 * Clicks on Button live chat inside the suspension notification
		 * @author Mirza.Kamran
		 */
		public void clkBtnLiveChatInsideSuspensionNotification() {
			getReusableActionsInstance().getWhenReady(btnLiveChatInsideSuspendedNotification).click();
		}

		/**
		 * 
		 * @return
		 */
		public boolean isSetAutoPaymentLinkDisplayed() {			
			return getReusableActionsInstance().isElementVisible(lnkSetUpAutoPayment);
		}

		/**
		 * 
		 */
		public void clkSetUpAutoPaymentQuickLink() {
			getReusableActionsInstance().waitForElementTobeClickable(lnkSetUpAutoPayment, 60);
			getReusableActionsInstance().getWhenReady(lnkSetUpAutoPayment).click();
		}
		
		
		//public void getCurrentPaymentMethod() {
			//getReusableActionsInstance().getWhenReady(locator)
		//}

		/**
		 * 
		 * @return
		 */
		public boolean isAutoPaymentAlreadySet() {
			
			return getReusableActionsInstance().isElementVisible(lblAutoPayment);
		}

		/**
		 *
		 */
		public void clkChangePaymentMethod() {
			getReusableActionsInstance().getWhenReady(lnkChangePaymentMethodQuickLin).click();
		}

	/**
	 * Click on the "Change Payment Method" link
	 * @author Rohit.Kumar
	 */
	public void clkChangePaymentMethodLink() {
		getReusableActionsInstance().clickWhenReady(lnkChangePaymentMethodButton, 10);
	}

	/**
	 * Checks if the Bank payment is displayed
	 * @return true if set Bank payment sub menu is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isBankPaymentDisplayed() {
		return getReusableActionsInstance().isElementVisible(lblBankPaymentMethodLabel);
	}


	/**
	 * Returns the type of Payment Method currently setup on the account
	 * @return Returns either: | Credit | Bank | Manual |
	 * @author Rohit.Kumar
	 */
	public String getCurrentAccountPaymentMethod(){

		if(isLnkSetAutoPaymentDisplayed()){
			return "Manual";
		} else if (isBankPaymentDisplayed()){
			return "Bank";
		} else {
			return "Credit";
		}

	}

	/**
	 * clicks the financed accessories
	 * @author Rohit.Kumar
	 */
	public void clkFinancedAccessories() {
		getReusableActionsInstance().getWhenReady(btnFinancedAccessories).click();
	}

	/**
	 * Verifies if the financed accessories button is visible
	 * @return true if present ; else false
	 * @author Rohit.Kumar
	 */
	public boolean verifyFinancedAccessoriesIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(btnFinancedAccessories);
	}


	/**
	 * Verifies if the balance label is displayed correctly
	 * @return true if the balance label is present ; else false
	 * @author Rohit.Kumar
	 */
	public boolean verifyBillingWidgetBalance() {
		String totalBalanceString = lblTotalBalance.getAttribute("aria-label").replaceAll("[^0-9\\.,$-]","");;

		if(totalBalanceString.startsWith("$") || totalBalanceString.endsWith("$")){
			return true;
		} else {

			return false;
		}

	}

public boolean verifyPTPWidgetIsDisplayed() {
			return getReusableActionsInstance().isElementVisible(divPTP);
    }

	/**
	 *
	 * @return
	 */
	public String selectWhenYouWillIkeToPayThePromise() {
		Select dropdown = new Select(selectDate);
		getReusableActionsInstance().selectWhenReady(selectDate, dropdown.getOptions().size()-1);
		getReusableActionsInstance().staticWait(1000);
		return getReusableActionsInstance().getSelectedValue(selectDate);
	}

	public void clkSetUpPromise() {

		getReusableActionsInstance().getWhenReady(btnSetUpPromise).click();
	}

	public boolean verifySetUpPromiseToPayPageIsLoaded() {


		return (getReusableActionsInstance().isElementVisible(headerSetUpPromise) &&
				getReusableActionsInstance().isElementVisible(lblTotalBalanceToPay));
	}

	public boolean verifyPromiseToSetUpSuccessFul() {

		return getReusableActionsInstance().isElementVisible(headerSetUpPromiseSuccessFul,30);
		//&& reusableActions.getWhenReady(By.xpath("//*[@translate='promise-to-pay.success-ptp.th-1']/parent::div/following-sibling::div")).getText().trim().replace("$", "").replaceAll(",", ".").contains(strBalanceValue.replaceAll(",", "."))
		//&& reusableActions.getWhenReady(By.xpath("//*[@translate='promise-to-pay.success-ptp.th-2']/parent::div/following-sibling::div")).getText().trim().contains(strDate));
	}

	public void clkDoneSetUpPromiseAfterSuccess() {

		getReusableActionsInstance().getWhenReady(btnDoneAfterSetUpPromiseSuccessFul).click();
	}

	public String getBalanceValueForPromise() {

		return getReusableActionsInstance().getWhenReady(By.xpath("//*[@class='ds-price']")).getAttribute("aria-label").trim().replace("$", "");
	}

	public void clkSetUpAPromiseToPay() {
		getReusableActionsInstance().getWhenReady(lnkSetUpPromiseToPay).click();
	}

	public void selectHowWouldYouLikeToPromiseToPay(String strPaymentType) {
		if(strPaymentType.contains("Credit Card"))
		{
			getReusableActionsInstance().selectWhenReady(selectPayType, 0);
		}else
		{
			getReusableActionsInstance().selectWhenReady(selectPayType, 1);
		}

	}

	/**
	 * Verifies if special promotion offer badge is present or not.
	 * return true if star img is visible
	 * @author Manpreet.kaur3
	 */
	public boolean verifySpecialOfferBadge() {
		return getReusableActionsInstance().isElementVisible(imgSpecialOfferBadge, 20);
	}

	/**
	 * Clicks on the special promotion offer badge.
	 * @author Manpreet.kaur3
	 */
	public void clkSpecialOfferBadge() {
		getReusableActionsInstance().getWhenReady(lblSpecialOfferBadge).click();
	}

	/**
	 * clicks the drop and and checks to see if the account show in Menu UsageAndService drop down on account overview page.
	 * @param strLast4DigAcctNum string account number
	 * @return true if element visible else false
	 * @author Rohit.Kumar
	 */
	public boolean checkIfAccountIsShowInDropDown(String strLast4DigAcctNum) {
		getReusableActionsInstance().getWhenReady(btnUsageAndServicesDropDown).click();
		return getReusableActionsInstance().isElementVisible(
				(By.xpath("//span[contains(@data-translate-values,'" + strLast4DigAcctNum + "') or contains(text(),'" + strLast4DigAcctNum + "')]")),
				10);
	}

	public boolean verifyIfEffectiveCancelDateForSubscriptionISImmediate(String test_language) {
		String cancelledEndDate= getReusableActionsInstance().getWhenReady(lblSMPpromotionEnded).getText();
		cancelledEndDate = cancelledEndDate.split("ended")[1].trim();
		DateHelpersFunctions.isValidDAte(cancelledEndDate);
		Locale locale=Locale.CANADA;;
		String datePattern = "MMM. d, u";
		ZoneId defaultZoneId = ZoneId.systemDefault();
		if(test_language=="en")
		{
			locale =Locale.CANADA;
			datePattern = "MMM. d, u";
		}else if(test_language=="fr"){
			locale =Locale.FRENCH;
			datePattern = "dd MMM yyyy";
		}
		LocalDate cancelEffectiveDate = parseDate(cancelledEndDate, datePattern,locale);

		if(isDateEqulas(Date.from(cancelEffectiveDate.atStartOfDay(defaultZoneId).toInstant()),Date.from(getTodaysDate().atStartOfDay(defaultZoneId).toInstant())))
		{
			return true;
		}
		return false;
	}




	public boolean verifyIfTheOrderOfTheCancelledCTNsWillBeDisplayedBasedOnEffectiveCancelDatesForImmediateAndDeferredCancelledCTNs() {


		return ((getReusableActionsInstance().getWhenReady(lblSMPpromotionEnded).getLocation().x <
				getReusableActionsInstance().getWhenReady(lblSMPpromotionEnds).getLocation().x)
				&& (getReusableActionsInstance().getWhenReady(lblSMPpromotionEnds).getLocation().x<
				getReusableActionsInstance().getWhenReady(lblSMPpromotionInEligile).getLocation().x));
	}


	public boolean verifyIfEffectiveCancelDateForSubscriptionIsDefferred(String test_language) {
		String cancelledEndDate= getReusableActionsInstance().getWhenReady(lblSMPpromotionEnds).getText();
		cancelledEndDate = cancelledEndDate.split("ends |fin le ")[1].trim();
		Locale locale=Locale.CANADA;;
		String datePattern = "MMM. d, u";
		ZoneId defaultZoneId = ZoneId.systemDefault();
		if(test_language=="en")
		{
			locale =Locale.CANADA;
			datePattern = "MMM. d, u";
		}else if(test_language=="fr"){
			locale =Locale.FRENCH;
			datePattern = "dd MMM yyyy";
		}
		LocalDate cancelEffectiveDate = parseDate(cancelledEndDate, datePattern,locale);

		if(isDateGreaterThan(Date.from(cancelEffectiveDate.atStartOfDay(defaultZoneId).toInstant()),Date.from(getTodaysDate().atStartOfDay(defaultZoneId).toInstant())))
		{
			return true;
		}
		return false;
	}

	public boolean isDateGreaterThan(Date date1, Date date2)
	{
		return date1.after(date2);
	}

	public boolean isDateEqulas(Date date1, Date date2)
	{
		return date1.equals(date2);
	}
	public LocalDate getTodaysDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		return now.toLocalDate();
	}

	public LocalDate parseDate(String strDate, String pattern, Locale locale){
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern,locale);
		LocalDate date = LocalDate.parse(strDate, dateFormatter);
		return date;
	}

	public List<String> getSuspendedCTNAvailable() {
		List<String> suspendedCTNslst = new ArrayList<>();
		for (WebElement ctn:lstSuspendedCTNs
			 ) {
			suspendedCTNslst.add(CurrencyHelpers.extractNumberFromString(ctn.getText().trim()));
		}
		return  suspendedCTNslst;
	}


	public List<String> getActiveCTNAvailable() {
		List<String> activeCTNslst = new ArrayList<>();
		List<String> suspendedCTNslst = new ArrayList<>();
		for (WebElement ctn:lstSuspendedCTNs
		) {
			suspendedCTNslst.add(CurrencyHelpers.extractNumberFromString(ctn.getText().trim()));
		}


		for (WebElement ctn:lstActiveCTNs
		) {
			if(!checkIfListContainsCTN(suspendedCTNslst,CurrencyHelpers.extractNumberFromString(ctn.getText().trim())))
			{
				activeCTNslst.add(CurrencyHelpers.extractNumberFromString(ctn.getText().trim()));
			}


		}



		return  activeCTNslst;
	}

	private boolean checkIfListContainsCTN(List<String> suspendedCTNslst,String strCTNS){
		boolean found = false;
		for (String ctn:suspendedCTNslst
		) {
			if(ctn.equals(strCTNS))
			{
				found = true;
				break;
			}
		}
		return  found;
	}

	public void clkCloseNewOfferModalPopup() {
		getReusableActionsInstance().clickWhenReady(btnCloseOfferModal, 30);
	}

	public boolean isNewOfferModalDisplayed() {
		return getReusableActionsInstance().isElementVisible(headerOfferNotificationModal, 40);
	}

	/**
	 * Click on Sub-Menu Option Home Phone under Menu Usage and Services
	 * @author Manpreet.Kaur3
	 */
	public void clkHomePhoneUnderUsageAndServiceMenu() {
		getReusableActionsInstance().getWhenReady(menuUsageAndService,30).click();
		if(getReusableActionsInstance().isElementVisible(subMenuUsageDropDown, 10)) {
			getReusableActionsInstance().getWhenReady(submenuHomePhone, 10).click();
		}
	}

	/**
	 * Click on Sub-Menu Option TV under Menu Usage and Services
	 * @author Manpreet.Kaur3
	 */
	public void clkTVUnderUsageAndServiceMenu() {
		getReusableActionsInstance().getWhenReady(menuUsageAndService,30).click();
		getReusableActionsInstance().waitForElementVisibility(subMenuUsageDropDown, 10);
		if(getReusableActionsInstance().isElementVisible(subMenuUsageDropDown, 10)){
			getReusableActionsInstance().getWhenReady(submenuTV, 10).click();
		}
	}
}
