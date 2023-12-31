package com.rogers.pages;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Pattern;

import com.rogers.test.helpers.DateHelpersFunctions;
//import org.apache.commons.validator.routines.BigDecimalValidator;
//import org.apache.commons.validator.routines.CurrencyValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;


/**
 * @author rajesh.varalli1
 *
 */
public class RogersWirelessDashboardPage extends BasePageClass {

	public RogersWirelessDashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//div//a[@title='English' or @title='Français']/span")
	WebElement menuLanguage;
	
	@FindBy (xpath = "//div[@class='talk-text-wrapper col component_holder show_billing_info']")
	WebElement talkTextOnlyUsageModule;
	
	@FindBy (xpath = "//div[contains(@class,'talk-text-container')]")
	WebElement mixedTalkTextUsageModule;
	
	@FindBy (xpath = "//div[@class='talk-text-card talk-usage']//div[@class='talkText_units']")
	WebElement divMinutesRemaining;
	
	@FindBy (xpath = "//td[text()='Anytime' or text()='Tout Temps']")
	WebElement tdAnytime;
	
	@FindBy (xpath = "//td[text()='Anytime' or text()='Tout Temps']//following-sibling::td[1]/span")
	WebElement minutesInclude;
	
	@FindBy (xpath = "//td[text()='Anytime' or text()='Tout Temps']//following-sibling::td[2]/span")
	WebElement minutesTotalUsed;
	
	@FindBy (xpath = "//div[@class='talk-text-card text-usage']//div[@class='talkText_units']")
	WebElement divTextsRemaining;
	
	@FindBy (xpath = "//td[contains(text(),'Anytime Sent') or contains(text(),'Tout Temps envoyée')]")
	WebElement msgAnytimeSent;
	
	@FindBy (xpath = "//td[contains(text(),'Anytime Sent') or contains(text(),'Tout Temps envoyée')]//following-sibling::td[1]/span")
	WebElement msgIncluded;
	
	@FindBy (xpath = "//td[contains(text(),'Anytime Sent') or contains(text(),'Tout Temps envoyée')]//following-sibling::td[2]/span")
	WebElement msgTotalUsed;
	
	@FindBy (xpath = "//td[contains(text(),'Anytime Received') or contains(text(),'Tout Temps reçus')]")
	WebElement msgAnytimeReceived;
	
	@FindBy (xpath = "//div[@class='talk-text-card talk-usage']//strong[text()='Unlimited' or text()='Illimitées'  or text()='Illimités']")
	WebElement talkUnlimitedMinutes;
	
	@FindBy (xpath = "//td[text()='Weekday' or text()='Jour Sem']")
	WebElement talkWeekday;
	
	@FindBy (xpath = "//td[text()='Weeknight/Weekend' or text()='Soirs/w-end']")
	WebElement talkWeekend;
	
	@FindBy (xpath = "//td[text()='Weekday' or text()='Jour Sem']//following-sibling::td[2]/span")
	WebElement totalUsedMinutes;
	
	@FindBy (xpath = "//div[@class='talk-text-card text-usage']//strong[text()='Unlimited' or text()='Illimitées'  or text()='Illimités']")
	WebElement textUnlimitedTexts;
	
	@FindBy (xpath = "//td[contains(text(),'photo et vidéo') or contains(text(),'Picture/video')]")
	WebElement textPictureAndVideoMsg;
	
	@FindBy (xpath = "//td[contains(text(),'Bundles') or contains(text(),'Trousses')]")
	WebElement textBundlesMsg;
	
	@FindBy (xpath = "//table[@class='table talk-text-details-table']//tbody//tr/td[2]")
	List<WebElement> talkAndTextIncludeValue;
	
	@FindBy (xpath = "//table[@class='table talk-text-details-table']//tbody//tr/td[3]/span")
	List<WebElement> talkAndTextUsedValue;
	
	@FindBy (xpath = "//div[@class='talkText_units']")
	List<WebElement> fullPlanLimitedTalkTextValue;
	
	@FindBy (xpath = "//ds-modal//tbody//tr/td[2]/span")
	List<WebElement> dsModalTalkAndTextIncludeValue;
	
	@FindBy(xpath = "//h2[contains(text(),'My Wireless Usage') or contains(text(),'Mon utilisation des')]")
	WebElement lblMyWlsUsage;

	@FindBy(xpath = "//*[contains(text(),'Change my Caller ID') or contains(text(),'Affichage des appels')]")
	WebElement lnkChangeMyCallerId;
	
	
	@FindAll({
        @FindBy(xpath = "//a[contains(text(),'Overview') or contains(text(),'Survol')]"),
        @FindBy(xpath = "//div[@class='ute-secondLevelNav-bar-text']/span[@data-translate='ute.common.label.overview'] | //a[@translate='nav.overview.header']")})
    WebElement lnkOverview;
	
	@FindBy(xpath = "//span[contains(text(),'Voicemail password') or contains(text(),'de passe de la Messagerie vocale')]")
	WebElement lnkUpdateMyVoicemailPwd;
	
	@FindBy(xpath = "//input[@id='voicemailPin']/parent::div")
	WebElement divNewVoicemailPwd;
	
	@FindBy(xpath = "//input[@id='voicemailPin']")
	WebElement txtNewVoicemailPwd;
	
	@FindBy(xpath = "//input[@id='voicemailConfimPin']/parent::div")
	WebElement divConfirmVoicemailPwd;
	
	@FindBy(xpath = "//input[@id='voicemailConfimPin']")
	WebElement txtConfirmVoicemailPwd;
	
	@FindBy(xpath = "//button[@id='submit-button']")
	WebElement btnVoicemailPwdSubmit;
	
	@FindBy (xpath = "//img[@src='./assets/images/widget-loader.gif']")
	WebElement imgLoading;
	
	@FindBy(xpath = "//p[contains(text(),'been updated.') or contains(text(),'vocale a été modifié')]")
	WebElement msgResetVoicemailPwdSuccess;
	
	@FindBy (xpath = "//span[contains(text(),'Done') or contains(text(),'Termin')]")
	WebElement btnResetVMPwdDone;
	
	@FindAll({
	@FindBy(xpath = "//ins[@translate='plans.btnText']"),
	@FindBy(xpath = "//button/span[@translate='internet_change']")})
	WebElement btnChangePlan;

	@FindBy(xpath = "//div[@class='wireless-plan-holder']//button")
	WebElement lnkChangeCurrentPlan;
	
	@FindBy(xpath = "//div[@role='button']/span[contains(@translate,'device_upgrade')]")
	WebElement btnUpgradeMyDevice;
	
	@FindBy (xpath = "//span[contains(text(),'phone repair claim') or contains(text(),'Repair or trade-in device') or contains(text(),'réparation de téléphone') or contains(text(),'Réparer ou échanger un appareil ')]")
	WebElement lnkTrackRepairClaim;
	
	@FindBy (xpath = "//button[@title='Continue to the site' or contains(@title,'Continuer')] | //span[contains(@translate,'continue')]")
	WebElement btnHlpYrPhoneContinue;
	
	@FindBy (xpath = "//ds-modal-container")
	WebElement repairClaimModal;

	@FindBy (xpath = "//dsa-radio")
	List<WebElement> radiosOfMultiCtnRepairClaim;
	
	@FindBy (xpath = "//*[text()='Change my SIM' or text()='Changer ma carte SIM']")
	WebElement lnkChangeMySIM;

	@FindBy (id = "currentSim")
	WebElement txtCurrentSIMNumber;

	@FindBy (id = "newSim")
	WebElement txtNewSIMNumber;

	@FindBy (xpath = "//span[@translate='ute.rogers.myrSimCard.simCardChange.continue']")
	WebElement btnContinueChangeSIM;

	@FindBy (xpath = "//div[@translate='ute.rogers.myrSimCard.simCardConfirmation.changeMySim']")
	WebElement titleReviewUpdateSIM;

	@FindBy (xpath = "//span[@data-ng-bind='simCardConfirmation.getNewSimCardNumber()']")
	WebElement reviewNewSim;

	@FindBy (xpath = "//div[contains(@class,'alert-section alert-data-delayed')]")
	WebElement lblDataDelayMsg;

	@FindBy (xpath = "//span[@class='remaining-data']")
	WebElement lblDataRemainingOutOfTotalDataBucket;
		
	@FindBy (xpath = "//span[@class='total-data-title']")
	WebElement lblTotalDataPlanPlusAdded;
	
	@FindBy(xpath = "//strong[@class='total-volume']")
	WebElement lblTotalDataDisplayedBelowLabelTotalDataPlusPlanAdded;
	
	@FindBy (xpath = "//div[@class='data-usage-bar-background']")
	WebElement lblDataRemainingBarDataBucket;
		
	@FindBy (xpath = "//div[@class='data-balance-info']")
	WebElement lblDataRemaining;
	
	@FindBy (xpath = "//div[@class='data-balance-info']/strong")
	WebElement lblDataRemainingValue;
	
	
	//@FindBy (xpath = "//div[@class='data-container data-section-only']")
	@FindBy(xpath = "//div[contains(@class,'data-container')]")
	WebElement lblTotalDataBucket;

	@FindBy (xpath = "//span[@data-ng-bind='simCardConfirmation.getNewSimCardNumber()']")
	WebElement lblManageData;

	@FindBy (xpath = "//span[@data-ng-bind='simCardConfirmation.getNewSimCardNumber()']")
	WebElement btnCloseViewDetails;
	
	@FindBy (xpath = "//div[@class='data-usage-details-holder component_holder']/rss-billing/div[@class='bill-cycle']/span[@class='daysRemaining']")
	WebElement lblDaysRemainingInBillCycle;

	@FindBy (xpath = "//div[@class='add-data']")
	WebElement lnkAddDataTopUp;
	
	@FindBy(xpath = "//ins[@translate='plans.addOns']")
	WebElement divAddOns;
	
	@FindBy(xpath = "//span[@class='textRight']")
	WebElement lbltotalDataDisplayedBelowBarRightSide;
	
	@FindBy (xpath = "//a[@title='View Talk and Text details' or @title='Voir les détails des appels et messages texte']//span[contains(text(),'View details') or contains(text(),'Afficher les détails')]")
	WebElement viewDetailTalkText;
	
	@FindBy (xpath = "//ds-modal[contains(@class,'talkTextDetailsModal')]")
	WebElement dsModalTalkTextDetail;

	@FindAll({
			@FindBy (xpath = "//div[@class='talk-text-card talk-usage']"),
			@FindBy(xpath = "//div[contains(@class,'talk-text-card talk-usage')]")})
	WebElement lblTalkUsage;

	@FindAll({
			@FindBy(xpath = "//div[@class='talk-text-card text-usage']"),
			@FindBy(xpath = "//div[contains(@class,'talk-text-card text-usage')]")})
	WebElement lblTextUsage;	

	@FindBy(xpath = "//rss-talk-text[@class='lib-talk-text__holder']")
	WebElement divTalkAndTextContainer;

	@FindAll({
			@FindBy(xpath = "//div[@class='talk-text-card talk-usage']//div[@class='talkText_units']"),
			@FindBy(xpath = "//div[contains(@class,'talk-text-card talk-usage')]//div[contains(@class,'talkText_units')]")})
	WebElement txtNumericValueTalk;

	@FindAll({
			@FindBy(xpath = "//div[@class='talk-text-card text-usage']//div[@class='talkText_units']"),
			@FindBy(xpath = "//div[contains(@class,'talk-text-card text-usage')]//div[contains(@class,'talkText_units')]")})
	WebElement txtNumericValueText;

	@FindBy(xpath = "//div[@class='cdk-overlay-container']//button[@title='Close' or @title='Fermer']")
	WebElement btnCloseOverLay;
	
	@FindBy (xpath = "//li[@id='stolen-link']")
	WebElement lnkLostOrStolenDevice;
	
	@FindBy (xpath = "//span[@data-translate='ute.common.suspend.ctn.confirm.switchOffService']")
	WebElement btnSwitchOffService;
	
	@FindBy (xpath = "//*[contains(text(),'Services suspended') or contains(text(),'Services suspendus')]")
	WebElement msgServiceSuspended;
	
	@FindBy (xpath = "//span[@title='Reactivate your services now.' or @title='Réactivez vos services dès maintenant.']")
	WebElement msgToReactivateService;
	
	@FindBy (xpath = "//span[@title='Reactivate your services now.' or @title='Réactivez vos services dès maintenant.']/a")
	WebElement lnkReactivateService;
	
	@FindBy (xpath = "//*[@class='ute-reactivateCtn-Success-header-title' or text()='Services resumed']")
	WebElement msgServiceResumed;
	
	@FindBy (xpath = "//span/strong[@class='name']")
	WebElement nameSeCtnTab;
	
	@FindBy (xpath = "//div[@class='floatingWirelessDashboard bcStatic']")
	WebElement btnLiveChat;
	
	@FindAll({
	@FindBy (xpath = "//app-welcome-rogers"),
	@FindBy (xpath = "//div[@class='bc-frame-title']")})
	WebElement headerLiveChat;

	@FindBy(xpath = "//iframe[@id='va-iframe']")
	WebElement fraLiveChat;
	
	@FindBy (xpath = "//div[@class='add-data']/span[contains(text(),'Speed Pass') or contains(text(),'Accès Rapido')]")
	WebElement btnSpeedPass;

	@FindBy(xpath = "//h2[contains(text(),'Device') or contains(text(),'appareil')]")
	WebElement headerMyDevice;
	
	@FindBy(xpath = "//rss-device//span[contains(text(),'balance') or contains(text(),'Solde')]")
	WebElement lblDeviceBalance;  
	
	@FindAll({
		@FindBy (xpath = "//div[@class='card-price-info']//span[@class='price']"),
		@FindBy (xpath = "//div[@class='ds-price -inline']//div[@class='ds-price__amountDollars text-semi']")
	})
	WebElement devicePriceMain;

	@FindBy(xpath = "//div[@class='device-title-section']/following-sibling::div/ds-price//div[contains(@class,'ds-price__amountDollars')]")
	WebElement lblMonthlyDeviceFinance;

	@FindAll({
		@FindBy (xpath = "//div[@class='ds-price -inline']//div[contains(@class,'ds-price__amountCents')]"),
		@FindBy (xpath = "//div[@class='card-price-info']//span[@class='cents']")
	})
	WebElement devicePriceCents;

	@FindBy (xpath = "//div[@class='device-title-section']/following-sibling::div//button")
	WebElement lnkUpgradeMyDevice;
	
	@FindBy (xpath = "//div[@id='deviceSection']")
	WebElement sectionChoosePhone;
	
	@FindBy (xpath = "//ds-modal[contains(@class,'device-upgrade-modal')]")
	WebElement modalDeviceUpgrade;
	
	@FindBy (xpath = "//button[@title='Close Device upgrade window' or @title='Fermer la rehaussement Détails de l’appareil']")
	WebElement btnCloseDeviceUpgradeModal;
	
	@FindAll({
		@FindBy (xpath = "//span[contains(text(),'end date') or contains(text(),'Date de fin')]"),
		@FindBy (xpath = "//span[contains(text(),'sera/était de') or contains(text(),'will be/was $0')]")  
	})
	WebElement txtEndDate;
	
	@FindBy (xpath = "//span[contains(text(),'end date') or contains(text(),'Date de fin')]/following-sibling::span")
	WebElement endDate;
	
	@FindBy (xpath = "//rss-device//span[contains(text(),'Détails') or contains(text(),'détails') or contains(text(),'details')]") 
	WebElement lnkViewDeviceDetails;
	
	@FindBy (xpath = "//div[@class='ds-modal__header d-flex align-items-start']")
	WebElement modalDeviceDetails;
	
	@FindAll({
		@FindBy(xpath = "//span[@class='ds-icon rds-icon-error']"),
		@FindBy (xpath = "//span[@class='ds-icon rds-icon-close']"),
		@FindBy (xpath = "//button[@title='Close Device details window' or @title='Fermer la fenêtre Détails de l’appareil']")
	})
	WebElement btnCloseDeviceDetailModal;
	
	@FindAll({
		@FindBy (xpath = "//span[contains(text(),'Device purchased') or contains(text(),'Appareil acheté')]"),
		@FindBy (xpath = "//span[contains(text(),'activation')]")
	})
	WebElement activationDateOnDeviceModal;
	
	@FindAll({
		@FindBy (xpath = "//span[contains(text(),'balance will be $0') or contains(text(),'financement sera de 0')]"),
		@FindBy (xpath = "//span[contains(text(),'Balance will be/was $0 on:') or contains(text(),'Le solde sera/était de 0 $ le :')]")
	})
	WebElement balanceClosingDate;
	
	@FindBy(xpath = "//ins[@translate='plans.infoHeading']")
	WebElement txtPlanHeading;
	
	@FindBy(xpath = "//div[@class='plan-container']//div[@class='price-wrapper']")
	WebElement txtMonthlyServiceCharge;
	
	@FindBy(xpath = "//div[@class='plan-info-sub-heading']")
	WebElement txtPlanName;
		
	@FindBy(xpath = "//ins[@translate='plans.btnText']")
	WebElement btnChangePricePlan;
		
	@FindBy(xpath = "//ins[@translate='plans.includedHeading']")
	WebElement txtHeadingIncluded;
		
	@FindBy(xpath = "//ins[@translate='plans.myPlanDetails']")
	WebElement lnkMyPlanDetails;
		
	@FindBy(xpath = "//div[@class='wireless-plan-bottom col-sm-12']//ins[@translate='plans.myPlanDetails']")
	WebElement lnkMyPlanDetailsAtBottom;
		
	@FindBy(xpath = "//p[text()='Plan details' or text()='Détails du forfait']")
	WebElement lblFullPlanDetailsOverlayHeaders;
	
	@FindBy(xpath = "//button[@title='Close Plan details window' or @title='Fermer la fenêtre Détails du forfait']")
	WebElement btnClosePlanDetailsOverlay;
	
	@FindAll({
		@FindBy(xpath = "//div[@class='data-usage-bar-background low-data-warning']"),
	@FindBy(xpath = "//div[text()='You’re running low!' or text()='Il en reste peu!' or @class='data-usage-bar-background low-data-warning']")})
	WebElement divRunningLowInUsageBar;
	
	@FindBy(xpath = "//span[text()='You have overage charges' or text()='Vous avez des frais d’utilisation excédentaire']")
	WebElement divOverageLowInUsageBar;
	
	@FindBy(xpath = "//div[@class='account-supports']")
	WebElement supportSection;
	
	@FindBy(xpath = "//div[@class='popover_holder']//div[@class='add-data-btn']")
	WebElement divCallOutMsgToAddData;
	
	
	@FindBy(xpath = "//span[text()='Add data to avoid further overage charges.' or text()='Ajoutez des données pour éviter les frais d’utilisation excédentaire']")
	WebElement divCallOutMsgToAddDataForOverage;
	
	@FindBy(xpath = "//span[@class='infinite_text']")
	WebElement lblUnlimitdeData;
	
	@FindBy(xpath = "//div[@class='popover-content']//span[text()='Speed Pass' or text()='Accès Rapido']")
	WebElement divSpeedPassPopOver;
	@FindBy (xpath = "//a[@href='/customer/support/article/unlocking-devices']")
	WebElement lnkFaqUnlockDevice;

	@FindBy (xpath = "//a[@href='/customer/support/article/wireless-my-network ']")
	WebElement lnkNetworkAid;
	 
	@FindBy (xpath = "//a[@href='/consumer/wireless/device-protection#,handset-protection--1']")
	WebElement lnkDeviceProtection;
	
	@FindBy(xpath = "//button[@title='Close' or @title='Fermer']")
	WebElement btnCloseCallOutPopUp;
	@FindBy (xpath = "//p[@class='text-md text-semi add-title mt-15']")
	WebElement addedDataInDataDetail;
	
	@FindBy(xpath = "//span[text()='Using data at reduced speed' or text()='Des données à vitesse réduite']")
	WebElement lblUsingDataAtReducedSpeed;

	@FindBy (xpath = "//div[@class='low-remaining-data']")
	WebElement lblApproachingReducedSpeed;

	@FindBy(xpath = "//div[@class='data-usage-total-data']//span[@class='textRight']")
	WebElement lblTotalData;
	
	@FindBy(xpath = "//strong[contains(@class,'data-value')]")
	WebElement lblremainingData;

	@FindBy(xpath = "//div[@class='data-usage-bar-background']")
	WebElement divUsageBar;

	@FindBy(xpath = "//a[contains(@class,'btn_prev')]")
	WebElement btnLeftScrollCTN;

	@FindBy(xpath = "//a[contains(@class,'btn_next')]")
	WebElement btnRightScrollCTN;
	
	@FindBy(xpath = "//span[@class='cta_no']/parent::span/parent::div")
	List<WebElement> lstOfCTNBadgesOnDashboardPage;

	@FindBy(xpath = "//ancestor::div[contains(@class,'postpaid-addons')]//div[@class='addon-description' or @class='addon-description ng-star-inserted']")
	List<WebElement> lstMyPlanAddOns;

	@FindBy(xpath = "//a[@title='Change the Data Manager for this account' or contains(@title,'Changer le gestionnaire de données pour ce compte')]//span[contains(text(),'Add') or contains(text(),'Ajoute')]")
	WebElement btnAddDataManager;

	@FindBy(xpath = "//p[text()='Choose a Data Manager' or text()='Choisir un gestionnaire de données']")
	WebElement titleChooseDataManager;
	
	@FindBy(xpath = "//select[@formcontrolname='phoneNumber']")
	WebElement selectDataManager;
		
	@FindBy(xpath = "//button//span[contains(text(),'Save') or contains(text(),'Enregistrer')]")
	WebElement btnSaveDataManager;

	@FindBy(xpath = "//div[@class='data-control']//a//span[contains(text(),'Set') or contains(text(),'Configurer')]")
	WebElement btnSetDataAlert;

	@FindBy(xpath = "//ds-switch[@title='Data Alert setting' or @title='Configuration d’alertes de données']//div[@class='ds-toggleArea__label']//span[text()='OFF' or text()='NON']")
	WebElement btnSetAlertOn;

	@FindBy(xpath = "//p[contains(text(),'Set a Data Alert for') or contains(text(),'Configurer une alerte de données pour')]")
	WebElement titleSetDataAlert;
	
	@FindBy(xpath = "//div[contains(@class,'alert_amount_holder')]/ds-form-field")
	WebElement lblSetDataAlert;
	
	@FindBy(xpath = "//div[contains(@class,'alert_amount_holder')]/ds-form-field//input")
	WebElement txtSetDataAlert;

	@FindBy(xpath = "//button//span[contains(text(),'Save') or contains(text(),'Enregistrer')]")
	WebElement btnSaveDataAlert;

	@FindBy(xpath = "//span[contains(@class,'data-alert-value')]")
	WebElement lblDataAlertSetValue;

	@FindBy(xpath = "//a[@title='Change the Data Manager for this account' or @title='Changer le gestionnaire de données pour ce compte']")
	WebElement btnChangeDataManager;

	@FindAll({
			@FindBy(xpath = "//span[@translate='fdmModule.fdm.dataManager']"),
			@FindBy(xpath = "//span[contains(@translate,'fdmModule.dataManager.dataManager')]")})
	WebElement btnDataManagerCTN;

	private By lblMyPlanDetails;
		
	@FindBy(xpath = "//li/span[contains(text(),'Data Access:') or contains(text(),'Accès aux données :')]")
	WebElement lblDataAccess;
		
	@FindBy(xpath = "//li/span[contains(text(),'Stream Saver:') or contains(text(),'Maximiseur de données :')]")
	WebElement lblStreamSaver;
	
	@FindBy(xpath = "//ds-switch[contains(@title,'Stream Saver') or contains(@title,'Maximiseur de donn')]//span[text()='OFF' or text()='NON']")
	WebElement btnStreamSaverSwitchOff;
	
	@FindBy(xpath = "//ds-switch[contains(@title,'Stream Saver for') or contains(@title,'Maximiseur de donn')]//span[text()='ON' or text()='OUI']")
	WebElement btnStreamSaverSwitchON;
		
	@FindBy(xpath = "//li/span[contains(text(),'Data Alert:') or contains(text(),'Alertes de données :')]")
	WebElement lblDataAlert;
		
	@FindBy(xpath = "//li/span[@translate='fdmModule.dataManager.dataManager']")
	WebElement lbldataManager;

	@FindBy(xpath = "//span[contains(text(),'Change my phone number') or contains(text(),'Changer mon numéro de téléphone')]")
	WebElement lnkChangeMyPhoneNumber;

	@FindBy(xpath = "//ds-switch[contains(@title,'Data access for') or contains(@title,'Accès aux données pour')]//Span[text()='ON' or text()='OUI']")
	WebElement divDataAccessOn;
	
	@FindBy(xpath = "//ds-switch[contains(@title,'Data access for') or contains(@title,'Accès aux données pour')]//Span[text()='OFF' or text()='NON']")
	WebElement divDataAccessOFF;

	@FindBy(xpath = "//*[@translate='wirelessPrepaidHeader']")
	WebElement headerPrepaid;

	@FindBy(xpath = "//*[@translate='wirelessPrepaid']")
	WebElement lblPrepaidManageMyPlanAndDataAddOnHeader;

	@FindBy(xpath = "//*[@data-test-id='myr-wirelessPlan-phoneSelected_planDescHTML']")
	WebElement lblPrepaidPlanDetails;

	@FindBy(xpath = "//*[@translate='wireless_prepaid_plan-expires']")
	WebElement lblPrepaidNextPaymentDate;
	
	@FindBy(xpath = "//*[@data-test-id='myr-wirelessPlan-nextPaymentDateEn']/parent::small")
	WebElement lblPrepaidNextPaymentMonthAndDate;

	@FindBy(xpath = "//*[@translate='acc_overview_top_up_now']")
	WebElement btnTopUpNow;

	@FindBy(xpath = "//*[@translate='wireless_prepaid_change-plan']")
	WebElement lnkChangeMyPlan;

	@FindBy(xpath = "//*[@translate='wireless_prepaid_manage-add-ons']")
	WebElement lnkManageMyaddOns;

	@FindBy(xpath = "//*[@translate='wireless_prepaid_wireless-number']")
	WebElement lblMyWireLessNumberHeader;

	@FindBy(xpath = "//*[@data-test-id='myr-wirelessPlan-my-line-number']")
	WebElement lblWirelessNumber;

	@FindBy(xpath = "//*[@data-test-id='myr-wirelessPlan-my-line-number_isCare']")
	WebElement lblPinCode;

	@FindBy(xpath = "//*[@translate='wireless_prepaid_change-pin']")
	WebElement lnkChangeMyPinCode;

	@FindBy(xpath = "//*[@translate='start_track_phone_repair']")
	WebElement lnkStartOrTrackAPhonerepairClaim;

	@FindBy(xpath = "//rss-data-usage-details//rss-billing/div[@class='bill-cycle']/span[@class='daysRemaining']")
	WebElement lblDaysRemainingInBillCycleMobile;
	
	@FindBy(xpath = "//span[contains(text(),'See offers on new phones') or contains(text(),'Voir les offres sur les nouveaux téléphones')]")
	WebElement btnSeeOffersOnNewPhones;

	//device details section
	@FindBy(xpath = "//span[contains(text(),' View financing details ') or contains(text(),' Voir les détails sur le financement ')]")
	WebElement btnViewFinancingDetails;

	@FindBy(xpath = "//div[contains(@aria-label,'Device financing payment:') or contains(@aria-label,'Paiement de financement de l’appareil :')]")
	WebElement monthlyFinancingAmount;

	@FindBy(xpath = "//span[contains(text(),'Remaining financing balance: ') or contains(@aria-label,'Solde de financement restant : ')]/following-sibling::ds-price")
	WebElement remainingFinancingBalance;

	@FindBy(xpath = "//span[contains(text(),'Financing agreement start date: ') or contains(text(),'Date de début de l’entente de financement : ')]/following-sibling::span")
	WebElement financingAgreementStartDate;

	@FindBy(xpath = "//span[contains(text(),'Financing agreement end date: ') or contains(text(),'Date de fin de l’entente de financement : ')]/following-sibling::span")
	WebElement financingAgreementEndDate;


	//device details modal
	@FindBy(xpath = "//span[contains(text(),'Device purchased on:') or contains(text(),'Appareil acheté le :')]/following-sibling::span")
	WebElement modalActivationDate;

	@FindBy(xpath = "//span[contains(text(),'Your financing balance will be $0 on:') or contains(text(),'Votre solde de financement sera de 0 $ le :')]/following-sibling::span")
	WebElement modalFinancingEndDate;

	@FindBy(xpath = "//div[contains(@aria-label,'device.detail-modal.upfront-edge-amount')]")
	WebElement modalUpFrontEdgeAmount;

	@FindBy(xpath = "//span[contains(text(),'You will need to return your device by:') or contains(text(),'Solde total du financement :')]/following-sibling::span")
	WebElement modalneedToReturnDeviceOn;

	@FindBy(xpath = "//span[contains(text(),'Total remaining financing balance:') or contains(text(),'Solde total du financement :')]/following-sibling::ds-price")
	WebElement modalTotalRemainingDeviceFinancingBalance;

	@FindBy(xpath = "//span[contains(text(),'Remaining device financing balance:') or contains(text(),'Solde restant du financement d’appareil :')]/following-sibling::ds-price")
	WebElement modalRemainingDeviceFinancingBalance;

	@FindBy(xpath = "//span[contains(text(),'Remaining financed taxes:') or contains(text(),'Taxes restantes du financement :')]/following-sibling::ds-price")
	WebElement modalRemainingFinancedTaxes;


	@FindBy(xpath = "//span[contains(text(),'Total monthly financing payment:') or contains(text(),'Total mensuel du paiement pour le financement :')]/following-sibling::ds-price")
	WebElement modalMonthlyFinancingAmountTotal;

	@FindBy(xpath = "//span[contains(text(),'Monthly financing payment:') or contains(text(),'Paiement mensuel pour le financement :')]/following-sibling::ds-price")
	WebElement modalMonthlyFinancingAmountBase;

	@FindBy(xpath = "//span[contains(text(),'Monthly financed taxes:') or contains(text(),'Taxes mensuelles sur le financement :')]/following-sibling::ds-price")
	WebElement modalMonthlyFinancingTaxes;

	@FindBy(xpath = "//span[contains(text(),'Months remaining:') or contains(text(),'Mois restants :')]/following-sibling::span")
	WebElement modalMonthsRemaining;

	@FindBy(xpath = "//button[contains(@title,'Show device financing details') or contains(@title,'Afficher les détails sur le financement de l’appareil')]")
	WebElement deviceFinancingDetailsButton;

	@FindBy(xpath = "//p[contains(text(),'Your remaining financing balance is the amount you financed when you purchased your device less any monthly payments.') or contains(text(),'Votre solde de financement correspond au montant financé lorsque vous avez acheté l’appareil, moins les paiements mensuels.')]")
	WebElement legalCopyForFinancingProgram;

	@FindBy(xpath = "//div[@class='ds-price']")
	WebElement deviceRemainingBalance;

	@FindBy(xpath = "//span[contains(text(),'Device balance will be/was $0 on: ') or contains(text(),'Le solde de l’appareil sera/était de 0 $ le : ')]/following-sibling::span")
	WebElement dateDeviceBalanceWillBeZero;

	@FindBy(xpath = "//span[contains(text(),'Device balance (excluding ') or contains(text(),'Solde de votre appareil (excluant le montant ')]/following-sibling::ds-price/div")
	WebElement deviceBalanceAsOfToday;

	@FindBy(xpath = "//div[contains(text(),' You brought your own phone with this plan. ') or contains(text(),' Vous avez apporté votre téléphone pour ce forfait. ')]")
	WebElement lblYouBroughtYourOwnPhone;

	@FindBy(xpath = "//h1[@id='bfa-page-title']")
	WebElement visibleElement;

	@FindBy(xpath = "//span[contains(text(),' View financing details ') or contains(text(),' Voir les détails sur le financement ')]")
	WebElement viewFinancingDetailsLink;

	//modal
	@FindBy(xpath = "//span[contains(text(),'Upfront Edge amount:') or contains(text(),'Votre solde de financement sera de 0 $ le :')]/following-sibling::ds-price")
	WebElement upFrontEdgeAmount;

	@FindBy(xpath = "//span[contains(text(),'You will need to return your device by:') or contains(text(),'Votre solde de financement sera de 0 $ le :')]/following::span")
	WebElement returnYourDevice;





	/**
	 * To click the link of lost or stolen device on wireless dashboard page
	 * @author ning.xue
	 */
	public void clkLnkLostOrStolenDevice() {
		getReusableActionsInstance().getWhenReady(lnkLostOrStolenDevice, 10).click();
	}
	 
	/**
	 * To click the Switch off my service button of report lost or stolen device flow
	 * @author ning.xue
	 */
	public void clkBtnSwitchOffMyService() {
//		getReusableActionsInstance().waitForElementTobeClickable(btnSwitchOffService, 10);
//		getReusableActionsInstance().javascriptScrollByVisibleElement(btnSwitchOffService);
		getReusableActionsInstance().getWhenReady(btnSwitchOffService, 40).click();

	}
	
	/**
	 * Validates whether service suspended message is displayed
	 * @return true if the message is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyServiceSuspendedMsgDisplayed() {
		getReusableActionsInstance().waitForElementVisibility(msgServiceSuspended,10);
		return getReusableActionsInstance().isElementVisible(msgServiceSuspended, 30);
	}
	
	/**
	 * Validates whether message to reactivate my service displayed in wireless dashobard page
	 * @return true if the message is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyToReactivateServiceMsgDisplayed() {
		return getReusableActionsInstance().isElementVisible(msgToReactivateService, 30);
	}
	
	/**
	 * To click the link of reactivate service on wireless dashboard page
	 * @author ning.xue
	 */
	public void clkLnkReactivateService() {
		getReusableActionsInstance().getWhenReady(lnkReactivateService, 10).click();
	}
	
	/**
	 * Validates whether service resumed message is displayed
	 * @return true if the message is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyServiceResumedMsgDisplayed() {
		return getReusableActionsInstance().isElementVisible(msgServiceResumed, 30);
	}
	
	/**
	 * To click the link of track a phone repair claim on wireless dashboard page
	 * @author ning.xue
	 */
	public void clkLnkTrackPhoneRepairClaim() {
		getReusableActionsInstance().getWhenReady(lnkTrackRepairClaim, 10).click();
	}
	
	/**
	 * To click the continue button of track a phone repair claim flow on pop up
	 * @author ning.xue
	 */
	public void clkBtnHelpYourPhoneContinue() {
		getReusableActionsInstance().clickWhenReady(btnHlpYrPhoneContinue, 10);
	} 
	
	/**
	 * Validates whether repair Claim Modal is displayed
	 * @return true if repair Claim Modal is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyRepairClaimModalIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(repairClaimModal, 3);
	}
	
	/**
	 * Click the first CTN in the list for repair claim
	 * @author ning.xue
	 */
	public void clkFirstCtnInListForRepairClaim() {
		getReusableActionsInstance().getWhenReady(radiosOfMultiCtnRepairClaim.get(0),20).click();
	}
	
	/**
	 * To verify if the url opened after click track repair claim is expected.
	 * @param expectedUrl, expected 3rd party url for track phone repair claim
	 * @return true if the url opened is expected, otherwise false
	 * @author ning.xue
	 */
	public boolean verifyBrightstarLinkOpenSuccessfully(String expectedUrl) {
		getReusableActionsInstance().waitForNumberOfWindowsToBe(2, 5);
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs.get(1));
		String urlOpened = getDriver().getCurrentUrl();
		return urlOpened.contains(expectedUrl);
	} 
	
	/**
	 * Validates whether the Talk and Text usage module for full plan is displayed
	 * @return true if the Talk and Text usage module is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyFullPlanTalkTextUsageModuleIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(mixedTalkTextUsageModule, 30);
	}
	
	/**
	 * To click the view details link in talk and text usage module for full plan wireless dash board.
	 */
	public void clkViewDetailsInFullPlanTalkAndTextUsageModule() { 
		getReusableActionsInstance().clickWhenReady(viewDetailTalkText, 10);
	} 
	
	/**
	 * Validates whether the Talk and Text detail ds-modal is displayed
	 * @return true if the Talk and Text detail ds-modal is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyDsModalTalkTextDetailIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(dsModalTalkTextDetail, 10);
	}

	/**
	 * Validates whether the Talk and Text detail ds-modal is displayed
	 * @return true if the Talk and Text detail ds-modal is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyDsModalTalkTextDetailComplyWithTalkTextUsageInWirelessDashboard() {
		ListIterator<WebElement> litr = null;
		litr = fullPlanLimitedTalkTextValue.listIterator();
		ListIterator<WebElement> valueList = null;
		valueList = dsModalTalkAndTextIncludeValue.listIterator();
		while (litr.hasNext()) {
			String strUsed = getReusableActionsInstance().getWhenReady(litr.next()).getText();
			if (valueList.hasNext()) {
				String strDetail = getReusableActionsInstance().getWhenReady(valueList.next()).getText();
				if (!strUsed.equalsIgnoreCase(strDetail)) {
					return false;
				}
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Validates whether the Talk and Text usage module is displayed
	 * @return true if the Talk and Text usage module is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyTalkTextOnlyUsageModuleIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(talkTextOnlyUsageModule, 30);
	}
	
	/**
	 * Validates whether the Talk usage minutes remaining is displayed
	 * @return true if the Talk usage minutes remaining is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyTalkMinutesRemainingIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(divMinutesRemaining, 30);
	}
	
	/**
	 * Validates whether the Talk usage any time is displayed
	 * @return true if the Talk usage any time is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyTalkUsageAnytimeIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(tdAnytime, 30);
	}
	
	/**
	 * checks talk usage detail data accuracy in wireless dash board
	 * @return true if the remaining time equal to total time minus used time, otherwise false
	 * @author Ning.Xue
	 */
	public boolean verifyLimitedTalkUsageDetailsAccuracy() {
		System.out.println("Limited Talk plan usage details is being checked");
		Integer intRemainMinutes = Integer.parseInt(getReusableActionsInstance().getWhenReady(divMinutesRemaining).getText());
		Integer intTotalMinutes = Integer.parseInt(getReusableActionsInstance().getWhenReady(minutesInclude).getText());
		String strMinutesUsed = getReusableActionsInstance().getWhenReady(minutesTotalUsed).getText();
		Integer intMinutesUsed = Integer.parseInt(strMinutesUsed.substring(0, strMinutesUsed.length()-8));
		return intRemainMinutes == intTotalMinutes - intMinutesUsed;
	}	
	
	/**
	 * Validates whether the Text usage texts remaining is displayed
	 * @return true if the Text usage texts remaining is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyLimitedTextsRemainingIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(divTextsRemaining, 30);
	}
	
	/**
	 * Validates whether the Text usage texts message any time sent is displayed
	 * @return true if the Text usage texts message any time sent is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyLimitedTextsMsgSentIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(msgAnytimeSent, 30);
	}
	
	/**
	 * Validates whether the Text usage texts message any time received is displayed
	 * @return true if the Text usage texts message any time received is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyLimitedTextsMsgReceivedIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(msgAnytimeReceived, 30);
	}
	
	/**
	 * checks text usage detail data accuracy in wireless dash board
	 * @return true if the remaining texts equal to total messages minus used messages, otherwise false
	 * @author Ning.Xue
	 */
	public boolean verifyLimitedTextUsageDetailsAccuracy() {
		System.out.println("Limited Text usage details is being checked");
		Integer intRemainTexts = Integer.parseInt(getReusableActionsInstance().getWhenReady(divTextsRemaining).getText());
		Integer intTotalTexts = Integer.parseInt(getReusableActionsInstance().getWhenReady(msgIncluded).getText());
		String strTextsUsed = getReusableActionsInstance().getWhenReady(msgTotalUsed).getText();
		Integer intTextsUsed = Integer.parseInt(strTextsUsed.substring(0, strTextsUsed.length()-9));
		return intRemainTexts == intTotalTexts - intTextsUsed;
	}	
	
	/**
	 * Validates whether the Talk usage unlimited minutes is displayed
	 * @return true if the Talk usage unlimited minutes is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyUnlimitedTalkMinutesIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(talkUnlimitedMinutes, 30);
	} 
	
	/**
	 * Validates whether the unlimited Talk weekday usage is displayed
	 * @return true if the unlimited Talk weekday usage is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyUnlimitedTalkWeekdayUsageIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(talkWeekday, 30);
	}
	
	
	
	/**
	 * Validates whether the unlimited Talk weekday night and weekend usage is displayed
	 * @return true if the unlimited Talk weekday night and weekend usage is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyUnlimitedTalkNightAndWeekendUsageIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(talkWeekend, 30);
	} 
	
	/**
	 * Validates whether the unlimited Talk weekday night and weekend usage is displayed
	 * @return true if the unlimited Talk weekday night and weekend usage is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyUnlimitedTalkWeekdayUsageIsInteger() {
	    try
	    {
	        Integer.parseInt(getReusableActionsInstance().getWhenReady(totalUsedMinutes).getText());
	        return true;
	    } catch (NumberFormatException ex)
	    {
	        return false;
	    }

	}
	
	/**
	 * Validates whether in both Talk usage and Text usage the include value are Unlimited
	 * @return true if in both Talk usage and Text usage the include value are Unlimited, else false
	 * @author ning.xue
	 */
	public boolean verifyTalkUsageAndTextUsageIncludeValueAreUnlimited() {
		ListIterator<WebElement> litr = null;
		litr = talkAndTextIncludeValue.listIterator();
		boolean unlimitedTrue = false;
		while (litr.hasNext()) {
			unlimitedTrue = getReusableActionsInstance().getWhenReady(litr.next()).getText().equalsIgnoreCase("Unlimited")
					|| getReusableActionsInstance().getWhenReady(litr.next()).getText().equalsIgnoreCase("Illimités");
			if (unlimitedTrue == false) {
				return false;
			}
		}
		
		return unlimitedTrue;

	}  
	
	/**
	 * Validates whether in both Talk usage and Text usage the used value are number
	 * @return true if in both Talk usage and Text usage the used value are number, else false
	 * @author ning.xue
	 */
	public boolean verifyTalkUsageAndTextUsageUsedValueAreNumber() {
		ListIterator<WebElement> litr = null;
		litr = talkAndTextUsedValue.listIterator();
		boolean numberTrue = false;
		while (litr.hasNext()) {
			String strUsed = getReusableActionsInstance().getWhenReady(litr.next()).getText();
			String strUsedValue = "";
			if (strUsed.toUpperCase().contains("MINUTE")) {
				strUsedValue = strUsed.substring(0, strUsed.length()-8);
			} else {
				strUsedValue = strUsed.substring(0, strUsed.length()-9);
			}
			numberTrue = strUsedValue.trim().matches("^[0-9,\\.]+$");
			if (numberTrue == false) {
				return false;
			}
		}
		
		return numberTrue;

	}
	
	/**
	 * Validates whether the Text usage unlimited texts is displayed
	 * @return true if the Text usage unlimited texts is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyUnlimitedTextsIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(textUnlimitedTexts, 30);
	} 
	
	/**
	 * Validates whether the Text usage messages picture and video is displayed
	 * @return true if the Text usage messages picture and video is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyUnlimitedTextsPictureAndVideoIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(textPictureAndVideoMsg, 30);
	}
	
	/**
	 * Validates whether the Text usage bundles messages is displayed
	 * @return true if the Text usage bundles messages is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyUnlimitedTextsBundlesMsgIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(textBundlesMsg, 30);
	}
	
	/**
	 * Validates whether Wireless page has loaded successfully
	 * @return true on successful load; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyWirelessPageLoad() {
		return getReusableActionsInstance().isElementVisible(lblMyWlsUsage);
	}
	
	/**
	 * Clicks on the 'Change My Caller Id' link
	 * @author rajesh.varalli1
	 */
	public void clickChangeMyCallerId() {
		getReusableActionsInstance().getWhenReady(lnkChangeMyCallerId, 20).click();
	} 
	
	/**
	 * Validates the First Name of the Caller ID for SE subscriber
	 * @param strFirstName First Name of the Caller ID 
	 * @return true if the name matches ; else false
	 * @author ning.xue
	 */
	public boolean verifyWirelessCallerIdUpdatedInSeCtnTab(String strFirstName) {
				
		return getReusableActionsInstance().getWhenReady(nameSeCtnTab).getText().trim().contains(strFirstName);
	}
	
	/**
	 * Clicks on the Overview button/link on the top menu
	 * @author rajesh.varalli1
	 */
	public void clickOverview() {
		getReusableActionsInstance().waitForElementTobeClickable(lnkOverview, 10);
		getReusableActionsInstance().executeJavaScriptClick(lnkOverview);
	}

	/**
	 * Validates and clicks on the 'Update My Voice mail Password' link
	 * @return true if link found; else false
	 * @author rajesh.varalli1
	 */
	public boolean clickUpdateMyVoicemailPwd() {
		if(getReusableActionsInstance().isElementVisible(lnkUpdateMyVoicemailPwd, 30)) {
			Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
		    String browserName = cap.getBrowserName().toLowerCase();
			if(!browserName.trim().toLowerCase().equalsIgnoreCase("firefox"))
			{
				getReusableActionsInstance().scrollToElement(lnkUpdateMyVoicemailPwd);
			}
			getReusableActionsInstance().clickIfAvailable(lnkUpdateMyVoicemailPwd);
			return true;
		}
		return false;
	}
	
	/**
	 * Enters the password in the new voicemail password field
	 * @param strPassword New voicemail password
	 * @author ning.xue
	 */
	public void setNewVoicemailPassword(String strPassword) {
		getReusableActionsInstance().getWhenReady(divNewVoicemailPwd, 10).click();
		//getReusableActionsInstance().getWhenReady(txtNewVoicemailPwd, 5).clear();
		getReusableActionsInstance().getWhenReady(txtNewVoicemailPwd, 5).sendKeys(strPassword);
	}
	
	/**
	 * Enters the password in the confirm voicemail password field
	 * @param strPassword New voicemail password
	 * @author ning.xue
	 */
	public void setConfirmVoicemailPassword(String strPassword) {
		getReusableActionsInstance().getWhenReady(divConfirmVoicemailPwd, 10).click();
		//getReusableActionsInstance().getWhenReady(txtConfirmVoicemailPwd, 5).clear();
		getReusableActionsInstance().getWhenReady(txtConfirmVoicemailPwd, 5).sendKeys(strPassword);
	}
	
	/**
	 * Clicks on the 'Submit' button
	 * @author rajesh.varalli1
	 */
	public void clickSubmitButton() {
		getReusableActionsInstance().getWhenReady(btnVoicemailPwdSubmit,10).click();
	}
	
	/**
	 * Validates the Reset Voicemail Password successful message
	 * @return true if message displayed; else false
	 * @author ning.xue
	 */
	public boolean verifyResetVoicemailPasswordSuccess() {
//		if (getReusableActionsInstance().isElementVisible(imgLoading)) {
//			getReusableActionsInstance().waitForElementInvisibility(imgLoading, 30);
//		}
		return getReusableActionsInstance().isElementVisible(msgResetVoicemailPwdSuccess,30);
	}
	
	/**
	 * Clicks on the 'Done' button in reset voice mail password flow
	 * @author ning.xue
	 */
	public void clickResetVMPwdDoneButton() {
		getReusableActionsInstance().getWhenReady(btnResetVMPwdDone,10).click();
	}
	
	/**
	 * Clicks on the 'Change Plan' button
	 * @author rajesh.varalli1
	 */
	public void clickChangePlanButton() {
		getReusableActionsInstance().clickIfAvailable(btnChangePlan);
	}
	
	/**
	 * Clicks on the 'Make changes to your current plan' link on the overlay
	 * @author rajesh.varalli1
	 */
	public void clickMakeChangesToCurrentPlan() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(getReusableActionsInstance().getWhenReady(By.xpath("//div[contains(@class,'tabs_lists container')]")));
		getReusableActionsInstance().getWhenReady(lnkChangeCurrentPlan, 30).click();
	}
	
	/**
	 * Scroll to Top of wireless Dashboard page
	 * @author Mirza.Kamran
	 */
	public void scrollToTopOfDasboardPage() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		
	}
	
	/**
	 * Scroll to Mid of wireless Dashboard page
	 * @author Mirza.Kamran
	 */
	public void scrollToMidOfDasboardPage() {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		
	}

	/**
	 * Scroll to bottom of wireless dashboard page
	 * @author Mirza.Kamran
	 */
	public void scrollToBottomOfPage() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		
	}

	/**
	 * Clicks on Change my SIM link
	 * @author Mirza.Kamran
	 */
	public void clkLinkChangeMySIM() {
		getReusableActionsInstance().clickWhenReady(lnkChangeMySIM);
	}

	/**
	 * Sets the string value in Current SIM textbox
	 * @param strOldSimNum String current SIM value
	 * @author Mirza.Kamran
	 */
	public void setOldSimNum(String strOldSimNum) {
		try {					
		getReusableActionsInstance().waitForElementTobeClickable(txtCurrentSIMNumber, 60);
		getReusableActionsInstance().getWhenReady(txtCurrentSIMNumber, 30).clear();
		getReusableActionsInstance().getWhenReady(txtCurrentSIMNumber).sendKeys(strOldSimNum);
		} catch (StaleElementReferenceException e) {
			getReusableActionsInstance().staticWait(5000); // static wait to handle state ref error
			getReusableActionsInstance().waitForElementTobeClickable(txtCurrentSIMNumber, 60);
			getReusableActionsInstance().getWhenReady(txtCurrentSIMNumber, 30).clear();
			getReusableActionsInstance().getWhenReady(txtCurrentSIMNumber).sendKeys(strOldSimNum);
		}
		
	}

	/**
	 * Sets the value for New SIM number
	 * @param strNewSimNum string value for new SIM number
	 * @author Mirza.Kamran
	 */
	public void setNewSimNum(String strNewSimNum) {
		getReusableActionsInstance().waitForElementTobeClickable(txtNewSIMNumber, 60);
		//getReusableActionsInstance().getWhenReady(txtNewSIMNumber, 30).clear();
		getReusableActionsInstance().getWhenReady(txtNewSIMNumber).sendKeys(strNewSimNum);
	}

	/**
	 * Clicks button update SIM Continue
	 * @author Mirza.Kamran 
	 */
	public void clkBtnUpdateSimNext() {
		getReusableActionsInstance().clickWhenReady(btnContinueChangeSIM);
		
	}

	/**
	 * Verifies the Update SIM review page
	 * @param strOldSimNum string value current SIM
	 * @param strNewSimNum string value new SIM
	 * @return true if the SIM values are correct else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyUpdateSimReview(String strOldSimNum, String strNewSimNum) {
		if (getReusableActionsInstance().isElementVisible(titleReviewUpdateSIM, 30)
				&& getReusableActionsInstance().getWhenReady(reviewNewSim).getText().trim().contains(strNewSimNum)) {
			return true;
		}
		return false;
	}

	/**
	 * Verifies if the data delay message is displayed on dashboard
	 * @return true if element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDataDelayMessage() {		
		return getReusableActionsInstance().isElementVisible(lblDataDelayMsg, 60);
	}

	/**
	 * Verifies if the data remaining out of total data bucket is displayed
	 * @return true if element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDataRemainingOutOfTotalDataBucket() {		
		return getReusableActionsInstance().isElementVisible(lblDataRemainingOutOfTotalDataBucket, 30);
		
	}

	/**
	 * gets the data remaining out of total data bucket is displayed
	 * @return returns the data remaining
	 * @author Mirza.Kamran
	 */
	public double getDataRemainingOutOfTotalDataBucket() {				
		String strTotalData = getReusableActionsInstance().getWhenReady(lblDataRemainingValue, 30).getText().replaceAll(",", ".").trim();
		return Double.parseDouble(strTotalData.substring(0, strTotalData.length()-2).trim());
	}
	
	/**
	 * Verifies if total data bucket is displayed
	 * @return true if element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTotalDataBucket() {
	
		return getReusableActionsInstance().isElementVisible(lblTotalDataBucket, 30);
	}
	
	/**
	 * Verifies if total data bucket is displayed
	 * @return true if element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean getTotalDataBucket() {
	
		return getReusableActionsInstance().isElementVisible(lblTotalDataBucket, 30);
	}
	
	/**
	 * verify the added data is reflected in total data volume after successfully add data.
	 * @param origDataVolume, the total data volume before add data.
	 * @param addedDataVolume, the added data volume
	 * @return true if the added data is reflected in total data volume
	 * @author ning.xue
	 */
	public boolean verifyAddedDataReflectedInTotalDataBucket(double origDataVolume, double addedDataVolume) {
		double newTotalDataVolume = this.getTotalDataVolume();
		double total = origDataVolume + addedDataVolume;
		
		double diff=0;
		if(newTotalDataVolume>total)
		{
			diff=newTotalDataVolume-total;
		}else
		{
			diff=total-newTotalDataVolume;
		}
		return (newTotalDataVolume == origDataVolume + addedDataVolume) || (diff<=0.1);
	}
	
	/**
	 * To get the total data volume in total data bucket for SE accounts.
	 * @return double, the value of total data.
	 * @author ning.xue
	 */
	public double getTotalDataVolume() {
		String strTotalData = getReusableActionsInstance().getWhenReady(lblTotalDataDisplayedBelowLabelTotalDataPlusPlanAdded, 30).getText().trim().replaceAll(",", ".");
		return Double.parseDouble(strTotalData.substring(0, strTotalData.length()-2).trim());
	}

	/**
	 * Verifies if the data remaining out of total data bucket is displayed
	 * @return true if element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDaysRemainingInTheBillCycleIsDisplayed() {		
		return getReusableActionsInstance().isElementVisible(lblDaysRemainingInBillCycle, 30);
	}
	
	/**
	 * Verifies if the data remaining out of total data bucket is displayed
	 * @return true if element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDaysRemainingInTheBillCycleIsDisplayedMobile() {		
		return getReusableActionsInstance().isElementVisible(lblDaysRemainingInBillCycleMobile, 30);
	}
	
	
	/**
	 * Verifies if add data button displayed
	 * @return true if element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAddDataButtonIsDisplayed() {			
		return (getReusableActionsInstance().getWhenReady(lnkAddDataTopUp, 30).getText().toLowerCase().contains("add data")
				||getReusableActionsInstance().getWhenReady(lnkAddDataTopUp, 30).getText().toLowerCase().contains("ajouter des données"));
	}
	
	/**
	 * verifies if the data has values up to two decimal places
	 * @return true if values matched expected else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAllMBAmountsConvertedToGBUptoTwoDecimalPlacesForTotalDataPlusAddedPlan() {		
		//compares English and French 
		return ((matchTwoDecimalPlacesPatterMatch(getReusableActionsInstance().getWhenReady(lblTotalDataDisplayedBelowLabelTotalDataPlusPlanAdded, 30).getText().split("GB")[0].trim())
				  || matchTwoDecimalPlacesPatterMatch(getReusableActionsInstance().getWhenReady(lblTotalDataDisplayedBelowLabelTotalDataPlusPlanAdded, 30).getText().split("Go")[0].trim())));
			
	}
	
	
	/**
	 * verifies if the data has values up to two decimal places
	 * @return true if values matched expected else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAllMBAmountsConvertedToGBUptoTwoDecimalPlacesOnLabelDataRemaining() {		
		//compares English and French
		return ((matchTwoDecimalPlacesPatterMatch(getReusableActionsInstance().getWhenReady(lblDataRemaining, 30).getText().split("GB")[0].trim())
				  || matchTwoDecimalPlacesPatterMatch(getReusableActionsInstance().getWhenReady(lblDataRemaining, 30).getText().split("Go")[0].trim())));
			
	}
	
	
	/**
	 * verifies if the data has values up to two decimal places
	 * @return true if values matched expected else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAllMBAmountsConvertedToGBUptoTwoDecimalPlacesOnTotalDataBelowUsageBarRightSide() {		
		//compares English and French 
		return ((matchTwoDecimalPlacesPatterMatch(getReusableActionsInstance().getWhenReady(lbltotalDataDisplayedBelowBarRightSide, 30).getText().split("GB")[0].trim())
				  || matchTwoDecimalPlacesPatterMatch(getReusableActionsInstance().getWhenReady(lbltotalDataDisplayedBelowBarRightSide, 30).getText().split("Go")[0].trim())));
	}
	
	
	/**
	 * Verifies if the data values are in GB
	 * @return true if values matched expected else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAllMBAmountsConvertedToGBForTotalDataDisplayedBelowLabelTotalDataPlusPlanAdded() {				
		return ((getReusableActionsInstance().getWhenReady(lblTotalDataDisplayedBelowLabelTotalDataPlusPlanAdded, 30).getText().trim().contains("GB") )
						|| getReusableActionsInstance().getWhenReady(lblTotalDataDisplayedBelowLabelTotalDataPlusPlanAdded, 30).getText().trim().contains("Go"));
				
	}
	
	/**
	 * Verifies if the data values are in GB
	 * @return true if values matched expected else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAllMBAmountsConvertedToGBForLabelDataRemaining() {					
		return ((getReusableActionsInstance().getWhenReady(lblDataRemaining, 30).getText().trim().contains("GB")
						|| getReusableActionsInstance().getWhenReady(lblDataRemaining, 30).getText().trim().contains("Go") ));
	}
	
	/**
	 * Verifies if the data values are in GB
	 * @return true if values matched expected else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAllMBAmountsConvertedToGBForlabelTotalDataDisplayedBelowBarRightSide() {					
		return ((getReusableActionsInstance().getWhenReady(lbltotalDataDisplayedBelowBarRightSide, 30).getText().trim().contains("GB")
						|| getReusableActionsInstance().getWhenReady(lbltotalDataDisplayedBelowBarRightSide, 30).getText().trim().contains("Go")));
	}
	
	/**
	 * regular expression pattern matcher
	 * @param strGBValues string value to match regular expression
	 * @return true or false based on pattern match
	 * @author Mirza.Kamran
	 */
	public boolean matchTwoDecimalPlacesPatterMatch(String strGBValues) {
		final String regExp = "[0-9]+([,.][0-9]{1,2})?";
        return Pattern.matches(regExp, strGBValues);
	}

	/**
	 * Verifies if the Talk has the remaining values
	 * @return true if the minutes remaining is displayed correctly
	 * @author Mirza.Kamran
	 */
	public boolean verifyTalkHaveMinutesRemainingValues() {		
		return ((getReusableActionsInstance().getWhenReady(lblTalkUsage).getText().toLowerCase().contains("minutes remaining")
				&& getReusableActionsInstance().getWhenReady(txtNumericValueTalk).getText().trim().matches("^[0-9]*$"))
				|| (getReusableActionsInstance().getWhenReady(lblTalkUsage).getText().toLowerCase().contains("minutes restantes")
						&& getReusableActionsInstance().getWhenReady(txtNumericValueTalk).getText().trim().matches("^[0-9]*$")));
	}
	
	/**
	 *Verifies if the Text has the remaining values
	 * @return true if the minutes remaining is displayed correctly
	 * @author Mirza.Kamran
	 */
	public boolean verifyTextHaveMinutesRemainingValues() {		
		return ((getReusableActionsInstance().getWhenReady(lblTextUsage).getText().toLowerCase().contains("texts remaining")
				&& getReusableActionsInstance().getWhenReady(txtNumericValueText).getText().trim().matches("^[0-9]*$"))
				|| (getReusableActionsInstance().getWhenReady(lblTextUsage).getText().toLowerCase().contains("messages texte restants")
				&& getReusableActionsInstance().getWhenReady(txtNumericValueText).getText().trim().matches("^[0-9]*$")));
	}

	/**
	 * Verifies talk and text doesn't contain view details
	 * @return false if the talk and text contains view details else true
	 * @author Mirza.Kamran
	 */
	public boolean verifyTalkAndTextDoesntContainViewDetails() {
		return (!getReusableActionsInstance().getWhenReady(divTalkAndTextContainer).getText().trim().contains("view details")
				&& !getReusableActionsInstance().getWhenReady(divTalkAndTextContainer).getText().trim().contains("Afficher les détails"));
	}

	/**
	 * Click on close on modal button
	 * @author Mirza.Kamran 
	 */
	public void closeDsModal() {
		getReusableActionsInstance().clickWhenReady(btnCloseOverLay);
	}
	
	/**
	 * To verify if the live chat button display in wireless dashboard page
	 * @return true if the button displayed otherwise false
	 * @author ning.xue
	 */
	public boolean verifyLiveChatButtonIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(btnLiveChat, 30);
	}
	
	/**
	 * Click the button Live chat in wireless dashboard page
	 * @author ning.xue
	 */
	public void clkBtnLiveChat() {
		getReusableActionsInstance().getWhenReady(btnLiveChat, 20).click();
	}
	
	/**
	 * To verify if the live chat overlay opened in wireless dashboard page
	 * @return true if the overlay opened otherwise false
	 * @author ning.xue
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
	 * Click the speed pass link in usage section of wireless dashboard page 
	 * @author ning.xue
	 */
	public void clkBtnSpeedPass() {
		//getReusableActionsInstance().waitForElementTobeClickable(btnSpeedPass, 60);
		getReusableActionsInstance().getWhenReady(btnSpeedPass, 60).click();
	} 

	/**
	 * My Plan details are displayed at the bottom of my plan
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyMyPlansDetailsIsDisplayedAtTheBottomOfMyPlan() {
		return getReusableActionsInstance().isElementVisible(lnkMyPlanDetailsAtBottom);
		
	}

	/**
	 * Verify if Plan name is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyPlanNameIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(txtPlanName);
		
	}

	/**
	 * Verify if Monthly service fee is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyMonthlyServiceFeeIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(txtMonthlyServiceCharge);
		
	}

	/**
	 * Verify if button change plan is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyButtonChangePlanIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(btnChangePricePlan);
		
	}

	/**
	 * Verify Included section is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIncludedSectionIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(txtHeadingIncluded);
	}

	/**
	 * Verify Title My wireless plan is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifTitleMyWirelessPlanIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(txtHeadingIncluded);
		
	}

	/**
	 * Click My Plan details link	 
	 * @author Mirza.Kamran
	 */
	public void clkMyPlanDetailsLink() {
		getReusableActionsInstance().clickWhenReady(lnkMyPlanDetails);
		
	}

	/**
	 * Verify My Plan details overlay is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyMyPlanDetailsOverlayIsDisplayed() {
		
		return getReusableActionsInstance().isElementVisible(lblFullPlanDetailsOverlayHeaders);
	}

	/**
	 * Click close button on My Plan details overlay
	 * @author Mirza.Kamran
	 */
	public void closeMyPlanDetailsOverlay() {
		getReusableActionsInstance().clickWhenReady(btnClosePlanDetailsOverlay);
		
	} 
	
	/**
	 * Validates the header of device section is "My Device" or "Mon appareil"
	 * @return true if the header matches; else false
	 * @author ning.xue
	 */
	public boolean verifyHeaderOfDeviceSection() {
		return getReusableActionsInstance().isElementVisible(headerMyDevice,30);
	}

	public boolean verifyHeaderOfDeviceSection(String strDeviceSectionHeader) {
		return getReusableActionsInstance().getWhenReady(headerMyDevice).getText().trim().contains(strDeviceSectionHeader);
	}

	/**
	 * Validates Device Balance of device section is displayed in $XXXX.XX format
	 * @return true if the format matches; else false
	 * @author ning.xue
	 */
	public boolean verifyDeviceBalanceOfDeviceSection() {
		String strPriceMain = devicePriceMain.getText();
		String strPriceCents = devicePriceCents.getText();
		if (strPriceCents.startsWith(",")) {
			strPriceCents = strPriceCents.replace(',', '.');
		}
		String strBalance = "$" + strPriceMain.concat(strPriceCents);
		Number number = null;
		try {
			number = NumberFormat.getCurrencyInstance(Locale.CANADA).parse(strBalance);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(number != null) {
			return true;
		}else {
			return false;
		}
		
	}

	public boolean verifyDeviceBalanceOfDeviceSection(String value) {
		String strPriceMain = devicePriceMain.getText();
		String strPriceCents = devicePriceCents.getText();
		if (strPriceCents.startsWith(",")) {
			strPriceCents = strPriceCents.replace(',', '.');
		}
		String strBalance = "$" + strPriceMain.concat(strPriceCents);
		Number number = null;
		try {
			number = NumberFormat.getCurrencyInstance(Locale.CANADA).parse(strBalance);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(number != null && strPriceMain.concat(strPriceCents).equals(value)) {
			return true;
		}else {
			return false;
		}

	}

	public boolean verifyDeviceMonthlyFinancingAmount(String value) {

			return getReusableActionsInstance().getWhenReady(lblMonthlyDeviceFinance).getText().trim().equals(value);
	}

	/**
	 * To click link upgrade My device in device section
	 * @author ning.xue
	 */
	public void clkLinkUpgradeMyDevice() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(getReusableActionsInstance().getWhenReady(By.xpath("//div[@class='tabs_lists container']")));
		getReusableActionsInstance().getWhenReady(lnkUpgradeMyDevice, 30).click();
	}
	
	/**
	 * Check link upgrade My device in device section
	 * @author Mirza.Kamran
	 * @return true if the element is visible else false
	 */
	public boolean verifyLinkUpgradeMyDevice() {
		return getReusableActionsInstance().isElementVisible(lnkUpgradeMyDevice);
	}
	
	/**
	 * Validates the link "Upgrade My Device", Choose phone page should display after click
	 * @return true if Choose phone page is displayed; else false
	 * @author ning.xue
	 */
	public boolean verifyChoosePhonePage() {
		return getReusableActionsInstance().isElementVisible(sectionChoosePhone, 20);
	}
	
	/**
	 * Navigate back to wireless dashboard page
	 * @author ning.xue
	 */
	public void navigateBacktoDashboardPage() {
		getReusableActionsInstance().backToPreviousPage();
	}
	
	/**
	 * Check if the Device Closing Date Message is Available
	 * @return true if the message is available, otherwise false
	 */
	public boolean isDeviceClosingDateMsgAvailable() {
		return getReusableActionsInstance().isElementVisible(txtEndDate,10);
	}
	
	/**
	 * Validates the message of device closing date in device section
	 * @return true if the closing date matches the specified format; else false
	 * @author ning.xue
	 */
	public boolean verifyDeviceClosingDateMsgIfAvailable() {

		String strDate = endDate.getText();
		String strBrowserLanguage = menuLanguage.getText();
		if (strBrowserLanguage.equalsIgnoreCase("FR")) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM. dd, yyyy");
			try {
			    formatter.parse(strDate);
			} catch (DateTimeParseException e) {
			    // Thrown if text could not be parsed in the specified format
				return false;
			}
		} else if (strBrowserLanguage.equalsIgnoreCase("EN")) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", new Locale("fr"));
			try {
			    formatter.parse(strDate);
			} catch (DateTimeParseException e) {
			    // Thrown if text could not be parsed in the specified format
				return false;
			}
		}
		return true;

	}
	
	/**
	 * Validates the link "My device Details", My device details modal should display after click
	 * @return true if View details modal is displayed; else false
	 * @author ning.xue
	 */
	public boolean verifyLinkMyDeviceDetailsOfDeviceSection() {
		getReusableActionsInstance().getWhenReady(lnkViewDeviceDetails, 30).click();
		return getReusableActionsInstance().isElementVisible(modalDeviceDetails, 20);
	}
	
	/**
	 * Validates the My device details modal should have activation date and expire date
	 * @return true if My device details modal have activation date and expire date; else false
	 * @author ning.xue
	 */
	public boolean verifyMyDeviceDetailsModalOfDeviceSection() {
		getReusableActionsInstance().getWhenReady(lnkViewDeviceDetails, 30).click();
		return (getReusableActionsInstance().isElementVisible(activationDateOnDeviceModal, 10)
				&& getReusableActionsInstance().isElementVisible(balanceClosingDate, 10));
	}
	
	/**
	 * Checks if view device section details link is displayed
	 * @return true if displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isViewDeviceDetailsDisplayed() {
		return getReusableActionsInstance().isElementVisible(lnkViewDeviceDetails);
	}
	
	/**
	 * Checks if new device section is displayed
	 * @return true if displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isSeeOffersOnNewPhonesDisplayed() {
		return getReusableActionsInstance().isElementVisible(btnSeeOffersOnNewPhones);
	}
	
	/**
	 * To click button close My device details modal 
	 * @author ning.xue
	 */
	public void clkCloseMyDeviceDetailsModal() {
		getReusableActionsInstance().getWhenReady(btnCloseDeviceDetailModal, 10).click();
	}
	
	/**
	 * Check if the Device Upgrade Modal is available, this modal will show when user is not eligible for device upgrade
	 * @return true if the device upgrade modal is available, otherwise false.
	 * @author ning.xue
	 */
	public boolean isModalDeviceUpgradeAvailable() {
		return getReusableActionsInstance().isElementVisible(modalDeviceUpgrade, 20);
	}
	
	/**
	 * To click button close device upgrade modal 
	 * @author ning.xue
	 */
	public void clkCloseDeviceUpgradeModal() {
		getReusableActionsInstance().getWhenReady(btnCloseDeviceUpgradeModal, 10).click();
	}
	
	/**
	 * Validates whether support section in Wireless Dash board page has loaded successfully
	 * @return true on successful load; else false
	 * @author ning.xue
	 */
	public boolean verifySupportSection() {
		return getReusableActionsInstance().isElementVisible(supportSection);
	}
	
	/**
	 * Validates the new page url after click link "FAQ: Unlocking Device"
	 * @param strBaseUrl, String of base url
	 * @return true on URL match; else false
	 * @author ning.xue
	 */
	public boolean verifyLinkFaqUnlockDevice(String strBaseUrl) {
		getReusableActionsInstance().getWhenReady(lnkFaqUnlockDevice, 20).click();
		return getReusableActionsInstance().verifyUrls(strBaseUrl + "/customer/support/article/unlocking-devices");
	}
	
	/**
	 * Validates the new page url after click link "NetworkAid"
	 * @param strBaseUrl, the base url to be added to the verify url.
	 * @return true on URL match; else false
	 * @author ning.xue
	 */
	public boolean verifyLinkNetworkAid(String strBaseUrl) {
		getReusableActionsInstance().getWhenReady(lnkNetworkAid, 60).click();
		//updated in july 24th release
		///customer/support/article/wireless-my-network
		return getReusableActionsInstance().verifyUrls(strBaseUrl + "/consumer/wireless/my-network");
	}
	
	/**
	 * Validates the new page url after click link "Device Protection"
	 * @param strBaseUrl, the base url to be added to the verify url.
	 * @return true on URL match; else false
	 * @author ning.xue
	 */
	public boolean verifyLinkDeviceProtection(String strBaseUrl) {
		getReusableActionsInstance().getWhenReady(lnkDeviceProtection, 60).click();
		return getReusableActionsInstance().verifyUrls(strBaseUrl + "/consumer/wireless/device-protection#,handset-protection--1");
	}

	/**
	 * Verifies running low state in the usage bar
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyRunningLowStateInTheUsageBar() {
		return getReusableActionsInstance().isElementVisible(divRunningLowInUsageBar);
	}


	/**
	 * Verifies Call out message to add data is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyCallOutMessageToAddDataIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(divCallOutMsgToAddData);
	}


	/**
	 * Verifies unlimited data no overage
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyUnlimitedDataNoOverage() {
		return getReusableActionsInstance().isElementVisible(lblUnlimitdeData);

		
	}


	/**
	 * Verifies data speed reduced message
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifySpeedReducedMsg() {
		return getReusableActionsInstance().isElementVisible(lblUsingDataAtReducedSpeed);
		
	}


	/**
	 * Verifies button to add speed pass is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifySpeedPassButtonIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(btnSpeedPass);
		
	}


	/**
	 * Verifies Call out message to add speed pass is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyCallOutMsgToAddSpeedPassIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(divSpeedPassPopOver);
	}


	/**
	 * Close call out message 
	 * @author Mirza.Kamran
	 */
	public void clkCloseCallOutMsg() {
		getReusableActionsInstance().clickWhenReady(btnCloseCallOutPopUp);
		
	}

	/**
	 * Close call out is closed
	 * @author Mirza.Kamran
	 * @return true if the call out is closed else false
	 */
	public boolean validateCloseCallOutIsClosed() {
		return !getReusableActionsInstance().isElementVisible(btnCloseCallOutPopUp);
	}
	
	/**
	 * This function validates if the Approaching Reduced Speed is displayed when total data bucket is 10% or less
	 * @return true if the label exits else false
	 * @author Mirza.Kamran
	 */
	public boolean validateDataRemainingOutOfTotalDataBucketTenPercentOrLess() {
		
		return getReusableActionsInstance().isElementVisible(lblApproachingReducedSpeed);
	}

	/**
	 * Checks if the data remaining is 10% or less
	 * @return true if the value is less than equal ten percent
	 * @author Mirza.Kamran
	 */
	public boolean checkIfTheDataIsTenPercentOrLess() {		
		String totalData = getReusableActionsInstance().getWhenReady(lblTotalData).getText()
				.split("GB")[0]
				.replace("Go", "")
				.replace(",", ".")
				.trim();
		String remainingData = getReusableActionsInstance().getWhenReady(lblremainingData).getText()
				.replace("Go", "")
				.replace(",", ".")
				.trim();	  
		return (Float.parseFloat(remainingData)<=(Float.parseFloat(totalData)*0.1));
	}

	/**
	 * Verifies if the usage bar is displayed
	 * @return true if the usage bar is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyUsageBarIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(divUsageBar);
	}

	/**
	 * Clicks on Add Data
	 * @author Mirza.Kamran
	 */
	public void clkAddData() {
		getReusableActionsInstance().clickWhenReady(lnkAddDataTopUp);
	}
	
	/**
	 * To get the value of usage in the given single CTN
	 * @param strCtn, the CTN number
	 * @return double, the value of usage
	 * @author ning.xue
	 */
	public double getSingleLineUsage(String strCtn) {
		
		String strLast4Digit = strCtn.substring(strCtn.length()-5);
		String strUsageInCtn = getReusableActionsInstance().getWhenReady(By.xpath("//span[contains(text(),'" + strLast4Digit
									+ "')]/parent::span/following-sibling::span/span"), 20).getText();
		return Double.parseDouble(strUsageInCtn.substring(0, strUsageInCtn.lastIndexOf("GB")-2).trim());
	}
	
	/**
	 * Click the CTN tab in wireless dash board
	 * @param strCtn, the CTN number
	 * @author ning.xue
	 */
	public void clkCtnTab(String strCtn) {
		
		String strLast4Digit = strCtn.substring(strCtn.length()-4);
		getReusableActionsInstance().getWhenReady(By.xpath("//span[contains(text(),'" + strLast4Digit + "')]"), 20).click();
	}

	/**
	 * The scrolls for CTNs is present
	 * @return true if the scroll bar is present else false
	 * @author Mirza.Kamran
	 */
	public boolean isScrollForCTNsPresent() {		
		return (getReusableActionsInstance().isElementVisible(btnLeftScrollCTN)
				&& getReusableActionsInstance().isElementVisible(btnRightScrollCTN));
	}

	/**
	 * Clicks on the Next CTN scroll
	 * @author Mirza.Kamran
	 */
	public void clkNextCTNScrollArrow() {
		getReusableActionsInstance().clickWhenReady(btnRightScrollCTN);
		
	}

	/**
	 * Checks if the 6th CTN badge is visible before we have scrolled right
	 * @return true if not visible else false 
	 * @author Mirza.Kamran
	 */
	public boolean isSixthCTNBadgeInVisibleBeforeScrollingOnDashBoard() {		
		return !getReusableActionsInstance().isElementVisible(lstOfCTNBadgesOnDashboardPage.get(5));
	}

	/**
	 * Checks if the 6th CTN badge is visible after scrolled right
	 * @return true if visible else false 
	 * @author Mirza.Kamran
	 */
	public boolean isSixthCTNVisible() {		
		return getReusableActionsInstance().isElementVisible(lstOfCTNBadgesOnDashboardPage.get(5));
	}

	/**
	 * Clicks the 6th CTN on dashboard page
	 * @author Mirza.Kamran
	 */
	public void clkTheSixthCTN() {
		getReusableActionsInstance().clickWhenReady(lstOfCTNBadgesOnDashboardPage.get(5));
		
	}

/**
 * Clicks on the CTN widget on dashboard page
 * @param intCtnNumber CTN badge number
 * @author Mirza.Kamran
 */
	public void clkTheNthCTNOnDashboardPage(int intCtnNumber) {
		getReusableActionsInstance().clickWhenReady(lstOfCTNBadgesOnDashboardPage.get(intCtnNumber-1));
		
	}
	
	/**
	 * To get total number of all added data including canceled and active ones in my plan section.
	 * @return HasMap of active and canceled MDT records and nonMDT records.
	 * @author Mirza.Kamran
	 */
	public HashMap<String, Integer> getAllExistingAddDataCountCancelledAndActiveOnMyPlanSection() {				
		int active=0;
		int cancelled=0;
		int nonMDT=0;
		HashMap<String, Integer> addData = new HashMap<String, Integer>();
		for(WebElement row:lstMyPlanAddOns)
		{
			if((row.getText().toLowerCase().contains("monthly data")&& row.getText().toLowerCase().contains("expires"))
				||(row.getText().toLowerCase().contains("mensuel")&& row.getText().toLowerCase().contains("prend fin")))
			{
				cancelled++;
				
			}else if((row.getText().toLowerCase().contains("monthly data")&& !row.getText().toLowerCase().contains("expires"))
					||(row.getText().toLowerCase().contains("mensuel")&& !row.getText().toLowerCase().contains("prend fin")))
			{
				active++;
			}else
			{
				nonMDT++;
			}
		}
		
		addData.put("active", active);
		addData.put("cancelled", cancelled);
		addData.put("nonMDT", nonMDT);
		return addData;		
	}

	/**
	 * Verify the record of canceled MDT in my plan section.
	 * @param countOfNewlyCancelled, the record of newly canceled MDT in this run.
	 * @param countOfPreviousCancelled, the record of previous canceled MDT before run.
	 * @return true if the newly canceled MDT id included in the record.
	 * @author Mirza.Kamran
	 */
	public boolean verifyCancelledAddedDataInMyPlan(int countOfNewlyCancelled, int countOfPreviousCancelled) {
		int cancelled= getAllExistingAddDataCountCancelledAndActiveOnMyPlanSection().get("cancelled");
		return (cancelled==(countOfNewlyCancelled+countOfPreviousCancelled));
	}

	/**
	 * verifies if the overages charges div is displayed
	 * @return true if the div for overage is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyOverageChargesInTheUsageBar() {
		return getReusableActionsInstance().isElementVisible(divOverageLowInUsageBar);
	}

	/**
	 * Verifies the overage call out pop 
	 * @return true if the pop out is displayed
	 * @author Mirza.Kamran
	 */
	public boolean verifyCallOutMessageToAddDataDueToOverageIsDisplayed() {
		
		return getReusableActionsInstance().isElementVisible(divCallOutMsgToAddDataForOverage);
	}
	
	
	/**
	 * Validates if the data manager is available
	 * @return true if the data manager is available else false
	 * @author Mirza.Kamran
	 */
	public boolean isAddDataManagerDisplayed() {
		return getReusableActionsInstance().isElementVisible(btnAddDataManager,60);
	}

	/**
	 * Clicks on Add data manager
	 * @author Mirza.Kamran
	 */
	public void clkAddDataManager() {
		getReusableActionsInstance().clickWhenReady(btnAddDataManager);
		
	}

	/**
	 * Clicks on Change data manager
	 * @author Mirza.Kamran
	 */
	public void clkChangeDataManager() {
		getReusableActionsInstance().clickWhenReady(btnChangeDataManager);
		
	}
	
	/**
	 * Checks if the data manager overlay is displayed
	 * @return true if the data manager overlay is displayed
	 * @author Mirza.Kamran
	 */
	public boolean isChooseDataManagerOverlayDisplayed() {		
		return getReusableActionsInstance().isElementVisible(titleChooseDataManager);
	}

	/**
	 * Selects the data manager
	 * @author Mirza.Kamran
	 */
	public void selectDataManager() {
		getReusableActionsInstance().selectWhenReady(selectDataManager, 0);
		
	}
	
	/**
	 * Selects the data manager
	 * @author Mirza.Kamran
	 * @param strCTNValue string value for CTN
	 */
	public void changeDataManager(String strCTNValue) {
		getReusableActionsInstance().selectWhenReady(selectDataManager,strCTNValue.replaceAll(" ", "").replaceAll("-", ""));
		
	}


	/**
	 * Clicks on save data manager
	 * @author Mirza.Kamran
	 */
	public void clkSaveButtonOnDataManager() {	
		getReusableActionsInstance().clickWhenReady(btnSaveDataManager);
		getReusableActionsInstance().staticWait(10000);
	}

	/**
	 * Checks if the set data alert button is displayed
	 * @return true if element displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isSetDataAlertDisplayed() {		
		return getReusableActionsInstance().isElementVisible(btnSetDataAlert);
	}

	/**
	 * Clicks on set data alert
	 * @author Mirza.Kamran
	 */
	public void clkSetDataAlert() {
		getReusableActionsInstance().clickWhenReady(btnSetDataAlert);
	}

	/**
	 * Sets Alert On
	 * @author Mirza.Kamran
	 */
	public void setAlertOn() {
		getReusableActionsInstance().clickWhenReady(btnSetAlertOn);

	}

	/**
	 * Checks if the data alert overlay is displayed
	 * @return true if the set data alert overlay is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isSetDataAlertOverlayDisplayed() {		
		return getReusableActionsInstance().isElementVisible(titleSetDataAlert);
	}

	/**
	 * Sets the data alert value
	 * @param strDataAlertValue data alert value
	 * @author Mirza.Kamran
	 */
	public void setDataAlertValue(String strDataAlertValue) {				
		getReusableActionsInstance().clickWhenReady(lblSetDataAlert);
		getReusableActionsInstance().getWhenReady(txtSetDataAlert).sendKeys(strDataAlertValue);
	}

	/**
	 * Clicks on save data alert
	 * @author Mirza.Kamran
	 */
	public void clkSaveButtonOnDataAlertOverlay() {
		getReusableActionsInstance().clickWhenReady(btnSaveDataAlert);
	}
	
	/**
	 *  Checks the data alert value set
	 * @param strDataAlert data alert value
	 * @return true if the Data Alert is correctly set, otherwise false.
	 */
	public boolean isDataAlertCorrectlySet(String strDataAlert) {
		String strDataAlertValue = getReusableActionsInstance().getWhenReady(lblDataAlertSetValue).getText().trim().replaceAll(",", ".").split(" ")[0];
		double doubleAlertValue = Double.parseDouble(strDataAlertValue);
		strDataAlertValue =  String.format("%.2f", new BigDecimal(doubleAlertValue));
		return strDataAlertValue.contains(strDataAlert);
	}

	/**
	 * Checks if the Change Data Manager is displayed
	 * @return true if the chnage data manager is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isChangeDataManagerDisplayed() {		
		return getReusableActionsInstance().isElementVisible(btnChangeDataManager);
	}
	
	/**
	 * Gets the Data Manager CTN
	 * @return string value containing the data manager CTN 
	 * @author Mirza.Kamran
	 */
	public String getDataManagerCTN() {	
		if(lstOfCTNBadgesOnDashboardPage.get(0).getText().toLowerCase().contains("data manager")
				|| lstOfCTNBadgesOnDashboardPage.get(0).getText().toLowerCase().contains("gestionnaire de données"))
		{
			return lstOfCTNBadgesOnDashboardPage.get(0).findElement(By.className("cta_no")).getText().trim();
		}else
		{
			return null;
		}
		 
	}

	/**
	 * Gets the Data Manager CTN
	 * @return string value containing the NON data manager CTN 
	 * @author Mirza.Kamran
	 */
	public String getNonDataManagerCTN() {
		if(!lstOfCTNBadgesOnDashboardPage.get(1).getText().toLowerCase().contains("data danager")
				|| !lstOfCTNBadgesOnDashboardPage.get(1).getText().toLowerCase().contains("gestionnaire de données"))
		{
			return lstOfCTNBadgesOnDashboardPage.get(1).findElement(By.className("cta_no")).getText().trim();
		}else
		{
			return null;
		}		
	}

	/**
	 * verifies if the Change Data Manager successful
	 * @param strDataManagerCTN String CTN value
	 * @return true if the value matches else false
	 * @author Mirza.Kamran
	 */
	public boolean isChangeDataManagerSuccessful(String strDataManagerCTN) {
		if((lstOfCTNBadgesOnDashboardPage.get(0).getText().toLowerCase().contains("data manager") ||
				lstOfCTNBadgesOnDashboardPage.get(0).getText().toLowerCase().contains("gestionnaire de données"))
			&& 	lstOfCTNBadgesOnDashboardPage.get(0).getText().toLowerCase().contains(strDataManagerCTN))
		{
			return true;
		}		
		return false;		
	}

	/**
	 * Clicks on Data Manager CTN
	 */
	public void clkDataManagerCTN() {
		getReusableActionsInstance().clickWhenReady(btnDataManagerCTN,30);
		
	}

	/**
	 * Checks if the change plan button is displayed
	 * @return true if the button is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyChangePlanButtonDisplayed() {		
		return getReusableActionsInstance().isElementVisible(btnChangePlan);
	}

	/**
	 * Checks if the change plan button is displayed
	 * @return true if the button is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyMyPlanDetailsDisplayed() {		
		return getReusableActionsInstance().isElementVisible(lblMyPlanDetails);
	}
	
	/**
	 * Checks if the change plan button is displayed
	 * @return true if the button is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyChangeMyNumberDisplayed() {		
		return getReusableActionsInstance().isElementVisible(lnkChangeMyPhoneNumber);
	}

	/**
	 * Verify if the screen saver displayed
	 * @return true if the screen saver is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyStreamSaverDisplayed() {		
		return getReusableActionsInstance().isElementVisible(lblStreamSaver);
	}

	/**
	 * Verify if the Data access is displayed
	 * @return true if the data access is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDataAccessDisplayed() { 
		return getReusableActionsInstance().isElementVisible(lblDataAccess);
	}

	/**
	 * Verify if the Data alert is  displayed
	 * @return true if the data alert is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDataAlertDisplayed() {
		return getReusableActionsInstance().isElementVisible(lblDataAlert);
	}

	/**
	 * Verify if the data manager displayed
	 * @return true if the screen saver is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDataManagerDisplayed() {
		return getReusableActionsInstance().isElementVisible(lbldataManager);
	}

	/**
	 * Checks if the Stream Saver ON is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isStreamSaverONDisplayed() {		
		return getReusableActionsInstance().isElementVisible(btnStreamSaverSwitchON,60);
	}

	/**
	 * Clicks on Stream Saver ON button
	 * @author Mirza.Kamran
	 */
	public void clkStreamSaverOn() {
		getReusableActionsInstance().getWhenReady(btnStreamSaverSwitchOff,60).click();
		
	}

	/**
	 * Checks if the data manager ON is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isDataAccessOnDisplayed() {		
		return getReusableActionsInstance().isElementVisible(divDataAccessOn,60);
	}

	/**
	 * Clicks on data access ON button
	 * @author Mirza.Kamran
	 */
	public void clkDataAccessOn() {
		getReusableActionsInstance().waitForElementTobeClickable(divDataAccessOFF, 60);
		getReusableActionsInstance().getWhenReady(divDataAccessOFF,60).click();
		
	}

	
	
	/**
	 * Checks if the data manager OFF is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isDataAccessOFF() {
		return getReusableActionsInstance().isElementVisible(divDataAccessOFF,60);
	}

	/**
	 * Clicks on data access OFF button
	 * @author Mirza.Kamran
	 */
	public void clkDataAccessOff() {
		getReusableActionsInstance().waitForElementTobeClickable(divDataAccessOn, 60);
		getReusableActionsInstance().getWhenReady(divDataAccessOn,60).click();
		
	}

	/**
	 * Checks if the Stream Saver OFF is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isStreamSaverOFF() {
		return getReusableActionsInstance().isElementVisible(btnStreamSaverSwitchOff,60);
	}

	/**
	 * Clicks on Stream Saver OFF button
	 * @author Mirza.Kamran
	 */
	public void clkStreamSaverOff() {
		getReusableActionsInstance().getWhenReady(btnStreamSaverSwitchON,60).click();
		
	}

	
	
	/**
	 * Checks if the data access is displayed
	 * @return true if the data access is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isDataAccessDisplayed() {
		return getReusableActionsInstance().isElementVisible(lblDataAccess,60);
	}

	/**
	 * Click left CTN scroll arrow
	 * @author Mirza.Kamran
	 */
	public void clkLeftCTNScrollArrow() {
		getReusableActionsInstance().clickIfAvailable(btnLeftScrollCTN);
	}

	/**
	 * Checks if the prepaid header is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidHeaderDisplayed() {
		return getReusableActionsInstance().isElementVisible(headerPrepaid);
		
	}

	/**
	 * Checks if the prepaid manage my plan and data add on header is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidManageMyPlanAndDataAddOnheaderDisplayed() {
		return getReusableActionsInstance().isElementVisible(lblPrepaidManageMyPlanAndDataAddOnHeader);
	}

	/**
	 * Checks if the prepaid Plan details is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidPlanDetailsSectionDisplayed() {
		return getReusableActionsInstance().isElementVisible(lblPrepaidPlanDetails);
	}

	/**
	 * Checks if the prepaid Next payment Date section is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidNextPaymentDateSectionDisplayed() {
		return (getReusableActionsInstance().isElementVisible(lblPrepaidNextPaymentDate)
				&& getReusableActionsInstance().isElementVisible(lblPrepaidNextPaymentMonthAndDate));
	}

	/**
	 * Checks if the prepaid Top Up Now is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidTopUpNowButtonDisplayed() {
		return getReusableActionsInstance().isElementVisible(btnTopUpNow);
	}

	/**
	 * Checks if the prepaid Change my plan is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidChangeMyPlanDisplayed() {
		return getReusableActionsInstance().isElementVisible(lnkChangeMyPlan);
	}

	/**
	 * Checks if the prepaid link Manage My Add ons is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidManageMyAddOnsDisplayed() {
		return getReusableActionsInstance().isElementVisible(lnkManageMyaddOns);
	}

	/**
	 * Checks if the prepaid My wireless number section is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isMyWirelessNumberSectionDisplayed() {
		return (getReusableActionsInstance().isElementVisible(lblMyWireLessNumberHeader)
				&& getReusableActionsInstance().isElementVisible(lblWirelessNumber));
	}

	/**
	 * Checks if the label prepaid Pin code is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidPinCodeDisplayed() {
		return getReusableActionsInstance().isElementVisible(lblPinCode);
				
	}

	/**
	 * Checks if the prepaid lnk change my pin code is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidChangeMyPinCodeDisplayed() {
		return getReusableActionsInstance().isElementVisible(lnkChangeMyPinCode);
	}

	/**
	 * Checks if the prepaid lnk Start or track a phone repair claim is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidStartOrTrackAPhoneRepairClaimDisplayed() {
		return getReusableActionsInstance().isElementVisible(lnkStartOrTrackAPhonerepairClaim);
	}

	/**
	 * Close chat image
	 * @author Mirza.Kamran
	 */
	public void closeChatImage() {
		getReusableActionsInstance().executeJavaScript("return document.getElementsByClassName('floating-live-chat')[0].remove();");
	}

	/**
	 * Clicks View Financing Details button
	 * @author Rohit.Kumar
	 */
	public void clkViewFinancingDetails() {
		getReusableActionsInstance().waitForElementTobeClickable(btnViewFinancingDetails, 60);
		getReusableActionsInstance().getWhenReady(btnViewFinancingDetails,60).click();

	}

	/**
	 * Checks if the View Financing Details Button is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isViewFinancingDetailsButtonDisplayed() {
		return (getReusableActionsInstance().isElementVisible(btnViewFinancingDetails));
	}

	/**
	 * Checks if the Monthly Financing Amount is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isMonthlyFinancingAmountDisplayed() {
		return getReusableActionsInstance().isElementVisible(monthlyFinancingAmount);
	}


	/**
	 * Checks if the Remaining Financing Balance is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isRemainingFinancingBalanceDisplayed() {
		return getReusableActionsInstance().isElementVisible(remainingFinancingBalance);
	}

	/**
	 * Checks if the Remaining Financing Balance is visible
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean checkRemainingFinancingBalanceAmount(String strRemainingFinanceAmount) {
		String amount = getReusableActionsInstance().getWhenReady(remainingFinancingBalance).getText().replaceAll("\n","").replaceAll(",",".").trim();
		return (amount.contains(strRemainingFinanceAmount));
	}

	/**
	 * Checks if the Financing Agreement Start Date is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isFinancingAgreementStartDateDisplayed() {
		return (getReusableActionsInstance().isElementVisible(financingAgreementStartDate));
	}


	/**
	 * Checks if the Financing Agreement End Date is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isFinancingAgreementEndDateDisplayed() {
		return (getReusableActionsInstance().isElementVisible(financingAgreementEndDate));
	}

	/**
	 * Checks if the Activation Date is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isActivationDateDisplayed() {
		return (getReusableActionsInstance().isElementVisible(modalActivationDate));
	}

	/**
	 * Checks if the Financing End Date is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isFinancingEndDateDisplayed() {
		return (getReusableActionsInstance().isElementVisible(modalFinancingEndDate));
	}

	/**
	 * Checks if the Total Remaining Device Financing Balance is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isTotalRemainingDeviceFinancingBalanceDisplayed() {
		return (getReusableActionsInstance().isElementVisible(modalTotalRemainingDeviceFinancingBalance));
	}

	/**
	 *
	 * @param strValue
	 * @return
	 * @author Mirza.Kamran
	 */
	public boolean isTotalRemainingDeviceFinancingBalanceDisplayed(String strValue) {
		String value =getReusableActionsInstance().getWhenReady(modalTotalRemainingDeviceFinancingBalance).getText().trim();
		value = value.replaceAll("\n","");
		return (value.replaceAll("$","").replaceAll(",",".").trim().contains(strValue))
				&& currencySymbolValidator(value);
	}

	/**
	 * Checks if the Remaining Device Financing Balance is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isRemainingDeviceFinancingBalanceDisplayed() {
		return getReusableActionsInstance().isElementVisible(modalRemainingDeviceFinancingBalance);
	}

	/**
	 * Checks if the Remaining Device Financing Balance is visible
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isRemainingDeviceFinancingBalanceDisplayed(String strValue) {
		String value =getReusableActionsInstance().getWhenReady(modalRemainingDeviceFinancingBalance).getText().trim();
		value = value.replaceAll("\n","");
		return (value.replaceAll("$","").replaceAll(",",".").trim().contains(strValue))
				&& currencySymbolValidator(value);

	}

	/**
	 * Checks if the Remaining Financed Taxes is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isRemainingFinancedTaxesDisplayed() {
		return getReusableActionsInstance().isElementVisible(modalRemainingFinancedTaxes);
	}


	/**
	 * Checks if the Remaining Financed Taxes is visible
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isRemainingFinancedTaxesDisplayed(String strValue) {
		String value =getReusableActionsInstance().getWhenReady(modalRemainingFinancedTaxes).getText().trim();
		value = value.replaceAll("\n","");
		return (value.replaceAll("$","").replaceAll(",",".").trim().contains(strValue))
				&& currencySymbolValidator(value);
	}

	/**
	 * Checks if the Monthly Financing Amount Total is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isMonthlyFinancingAmountTotalDisplayed() {
		return getReusableActionsInstance().isElementVisible(modalMonthlyFinancingAmountTotal);
	}

	/**
	 * Checks if the Monthly Financing Amount Total is visible
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isMonthlyFinancingAmountTotalDisplayed(String strValue) {
		String value =getReusableActionsInstance().getWhenReady(modalMonthlyFinancingAmountTotal).getText().trim();
		value = value.replaceAll("\n","");
		return (value.replaceAll("$","").replaceAll(",",".").trim().contains(strValue))
				&& currencySymbolValidator(value);
	}

	/**
	 * Checks if the Monthly Financing Amount Base is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isMonthlyFinancingAmountBaseDisplayed() {
		return getReusableActionsInstance().isElementVisible(modalMonthlyFinancingAmountBase);
	}

	/**
	 * Checks if the Monthly Financing Amount Base is visible
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isMonthlyFinancingAmountBaseDisplayed(String strValue) {
		String value =getReusableActionsInstance().getWhenReady(modalMonthlyFinancingAmountBase).getText().trim();
		value = value.replaceAll("\n","");
		return (value.replaceAll("$","").replaceAll(",",".").trim().contains(strValue))
				&& currencySymbolValidator(value);
	}

	/**
	 * Checks if the Monthly Financing Taxes is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isMonthlyFinancingTaxesDisplayed() {
		return getReusableActionsInstance().isElementVisible(modalMonthlyFinancingTaxes);
	}

	/**
	 * Checks if the Monthly Financing Taxes is visible
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isMonthlyFinancingTaxesDisplayed(String strValue) {
		String value =getReusableActionsInstance().getWhenReady(modalMonthlyFinancingTaxes).getText().trim();
		value = value.replaceAll("\n","");
		return (value.replaceAll("$","").replaceAll(",",".").trim().contains(strValue))
				&& currencySymbolValidator(value);
	}

	/**
	 * Checks if the Months Remaining is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isMonthsRemainingDisplayed() {
		return getReusableActionsInstance().isElementVisible(modalMonthsRemaining);
	}

	/**
	 * Checks if the Months Remaining is visible
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isMonthsRemainingDisplayed(String strMonths) {
		return (getReusableActionsInstance().isElementVisible(modalMonthsRemaining)
				&& getReusableActionsInstance().getWhenReady(modalMonthsRemaining).getText().trim().equals(strMonths));
	}

	/**
	 * Checks if the Legal Copy For Financing Program is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isLegalCopyForFinancingProgramDisplayed() {
		return (getReusableActionsInstance().isElementVisible(legalCopyForFinancingProgram));
	}

	/**
	 * To click Device Financing Details Button
	 * @author Rohit.Kumar
	 */
	public void clkDeviceFinancingDetailsButton() {
		getReusableActionsInstance().getWhenReady(deviceFinancingDetailsButton, 30).click();
	}

	/**
	 * checks if the Device remaining balance exits
	 * @return true if the amount is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean verifyDeviceRemainingBalanceExists() {

		String deviceBalance = deviceRemainingBalance.getAttribute("aria-label").replaceAll("[^0-9\\$.," +
				"]", "").replace(",", ".");
		

		return deviceBalance.contains("$");
	}

		public void  clkViewFinancedetailsButton(){
					getReusableActionsInstance().getWhenReady(btnViewFinancingDetails, 30).click();
				}

	public boolean  isViewFinancedetailsButtonDisplayedInTheBottom(){

		return getReusableActionsInstance().isElementVisible(btnViewFinancingDetails);
	}

	public boolean isFinancingActivationAndEndDateIsSameForFullyPaidOff() {
		return getReusableActionsInstance().getWhenReady(modalFinancingEndDate).getText().trim().equals(
				getReusableActionsInstance().getWhenReady(modalActivationDate).getText().trim());
	}

	public boolean isUpfrontEdgeAmountDisplayedCorrect() {
		String currencyValue = getReusableActionsInstance().getWhenReady(modalUpFrontEdgeAmount).getText().trim();
		currencyValue = currencyValue.replaceAll("\n","");
		return currencySymbolValidator(currencyValue);
	}

	public boolean currencySymbolValidator(String strCurrencyValue){
		if(strCurrencyValue.startsWith("$") || strCurrencyValue.endsWith("$")){
			return true;
		}else{
			return false;
		}
	}

//	public boolean currencyValueValidator(String strCurrencyValue){
//		strCurrencyValue = strCurrencyValue.replaceAll("$","").trim();
//		BigDecimalValidator validator = CurrencyValidator.getInstance();
//		BigDecimal amount =null;
//		if(System.getProperty("test_language")=="en") {
//			amount = validator.validate(strCurrencyValue, Locale.CANADA);
//		}else if(System.getProperty("test_language")=="fr"){
//			amount = validator.validate(strCurrencyValue, Locale.CANADA_FRENCH);
//		}
//		return amount!=null;
//
//
//
//	}

	public boolean isYouWIllNeedToReturnYourDeviceByDateDisplayedCorrectly() {
		String strDate = getReusableActionsInstance().getWhenReady(modalneedToReturnDeviceOn).getText().trim();
		return (getReusableActionsInstance().isElementVisible(modalneedToReturnDeviceOn)
				&& DateHelpersFunctions.isValidDAte(strDate));

	}

	public  boolean isValidDAte(String strDate){
		Locale locale=Locale.CANADA;;
		String datePattern = "MMM. d, u";
		ZoneId defaultZoneId = ZoneId.systemDefault();
		if(System.getProperty("test_language")=="en")
		{
			locale =Locale.CANADA;
			datePattern = "MMM. d, u";
		}else if(System.getProperty("test_language")=="fr"){
			locale =Locale.FRENCH;
			datePattern = "dd MMM yyyy";
		}

		try
		{
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(datePattern,locale);
			LocalDate date = LocalDate.parse(strDate, dateFormatter);
		}
		/* Date format is invalid */
		catch (DateTimeParseException e)
		{
			return false;
		}
		/* Return true if date format is valid */
		return true;
	}

	/**
	 * Checks if the "You brought your own phone with this plan." label is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isBroughtYourOwnPhoneVisible() {
		return getReusableActionsInstance().isElementVisible(lblYouBroughtYourOwnPhone);
	}

	/**
	 * click See Offers On New Phones Button
	 * @author Rohit.Kumar
	 */
	public void clkSeeOffersOnNewPhones() {
		getReusableActionsInstance().getWhenReady(btnSeeOffersOnNewPhones, 30).click();
	}
	/**
	 * Checks if the Device Balance date will be $0 is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isDeviceBalanceDateDisplayed() {
		return getReusableActionsInstance().isElementVisible(dateDeviceBalanceWillBeZero);
	}

	/**
	 * Checks if the My Device Details Link is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isMyDeviceDetailsLinkDisplayed() {
		return getReusableActionsInstance().isElementVisible(lnkViewDeviceDetails);
	}

	/**
	 * checks if the Device balance as of today exists
	 * @return true if the amount is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean verifyDeviceBalanceAsOfTodayExists() {
		String deviceBalance = deviceBalanceAsOfToday.getAttribute("aria-label").replaceAll("[^0-9\\$.," +
				"]", "").replace(",", ".");
		return deviceBalance.contains("$");
	}

	/**
	 * Checks if the up front edge is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isUpFrontEdgeDisplayed() {
		return getReusableActionsInstance().isElementVisible(upFrontEdgeAmount);
	}

	/**
	 * verifies the correct link after clicking "See offers on new phone" button
	 * @author Rohit.Kumar
	 */
	public boolean verifySeeOfferOnNewPhonesURL() {
		getReusableActionsInstance().waitForElementVisibility(visibleElement);
		return get_Driver_Url().contains("/web/totes/upgrade/#/choose-phone");

	}

	/**
	 * Checks if return your device date is visible
	 * @return true if the element is displayed else false
	 * @author Rohit.Kumar
	 */
	public boolean isReturnYourDeviceDateDisplayed() {
		return getReusableActionsInstance().isElementVisible(returnYourDevice);
	}

}
