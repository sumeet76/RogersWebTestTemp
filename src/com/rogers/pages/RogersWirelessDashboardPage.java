package com.rogers.pages;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.regex.Pattern;
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
	
	@FindBy(xpath = "//span[@translate='mppc_entry_1_change_current_plan']")
	WebElement lnkChangeCurrentPlan;
	
	@FindBy(xpath = "//div[@role='button']/span[contains(@translate,'device_upgrade')]")
	WebElement btnUpgradeMyDevice;
	
	@FindBy (xpath = "//span[contains(text(),'phone repair claim') or contains(text(),'réparation de téléphone')]")
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
	
	@FindBy (xpath = "//div[@class='talk-text-card talk-usage']")
	WebElement lblTalkUsage;

	@FindBy(xpath = "//div[@class='talk-text-card text-usage']")
	WebElement lblTextUsage;	

	@FindBy(xpath = "//rss-talk-text[@class='lib-talk-text__holder']")
	WebElement divTalkAndTextContainer;

	@FindBy(xpath = "//div[@class='talk-text-card talk-usage']//div[@class='talkText_units']")
	WebElement txtNumericValueTalk;
	
	@FindBy(xpath = "//div[@class='talk-text-card text-usage']//div[@class='talkText_units']")
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
	
	@FindBy (xpath = "//*[@class='ute-reactivateCtn-Success-header-title']")
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

	@FindBy(xpath = "//h2[contains(text(),'My Device') or contains(text(),'Mon appareil')]")
	WebElement headerMyDevice;
	
	@FindBy(xpath = "//div[@class='card-price-info']//span[contains(text(),'Device balance') or contains(text(),'Solde de l’appareil')]")
	WebElement lblDeviceBalance;  
	
	@FindBy (xpath = "//div[@class='card-price-info']//span[@class='price']")
	WebElement devicePriceMain;
	
	@FindBy (xpath = "//div[@class='card-price-info']//span[@class='cents']")
	WebElement devicePriceCents;
	
	@FindBy (xpath = "//span[contains(text(),'Changer mon appareil') or contains(text(),'Upgrade my device')]")
	WebElement lnkUpgradeMyDevice;
	
	@FindBy (xpath = "//div[@id='deviceSection']")
	WebElement sectionChoosePhone;
	
	@FindBy (xpath = "//ds-modal[contains(@class,'device-upgrade-modal')]")
	WebElement modalDeviceUpgrade;
	
	@FindBy (xpath = "//button[@title='Close Device upgrade window' or @title='Fermer la rehaussement Détails de l’appareil']")
	WebElement btnCloseDeviceUpgradeModal;
	
	@FindBy (xpath = "//span[contains(text(),'sera/était de') or contains(text(),'will be/was $0')]")  
	WebElement txtClosingDate;
	
	@FindBy (xpath = "//span[contains(text(),'Détails de mon appareil') or contains(text(),'device details')]") 
	WebElement lnkViewDeviceDetails;
	
	@FindBy (xpath = "//div[@class='ds-modal__header d-flex align-items-start']")
	WebElement modalDeviceDetails;
	
	@FindBy (xpath = "//button[@title='Close Device details window' or @title='Fermer la fenêtre Détails de l’appareil']")
	WebElement btnCloseDeviceDetailModal;
	
	@FindBy (xpath = "//span[contains(text(),'activation')]")
	WebElement activationDateOnDeviceModal;
	
	@FindBy (xpath = "//span[contains(text(),'Balance will be/was $0 on:') or contains(text(),'Le solde sera/était de 0 $ le :')]")
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

	@FindBy(xpath = "//span[@translate='fdmModule.fdm.dataManager']")
	WebElement btnDataManagerCTN;

	private By lblMyPlanDetails;
		
	@FindBy(xpath = "//li/span[contains(text(),'Data Access:') or contains(text(),'Accès aux données :')]")
	WebElement lblDataAccess;
		
	@FindBy(xpath = "//li/span[contains(text(),'Stream Saver:') or contains(text(),'Maximiseur de données :')]")
	WebElement lblStreamSaver;
	
	@FindBy(xpath = "//ds-switch[contains(@title,'Stream Saver') or contains(@title,'Maximiseur de donn')]//span[text()='OFF' or text()='NON']")
	WebElement btnStreamSaverSwitchOff;
	
	@FindBy(xpath = "//ds-switch[@title='Stream Saver for DONOTUSE' or contains(@title,'Maximiseur de donn')]//span[text()='ON' text()='OUI']")
	WebElement btnStreamSaverSwitchON;
		
	@FindBy(xpath = "//li/span[contains(text(),'Data Alert:') or contains(text(),'Alertes de données :')]")
	WebElement lblDataAlert;
		
	@FindBy(xpath = "//li/span[@translate='fdmModule.dataManager.dataManager']")
	WebElement lbldataManager;

	@FindBy(xpath = "//span[contains(text(),'Change my phone number') or contains(text(),'Changer mon numéro de téléphone')]")
	WebElement lnkChangeMyPhoneNumber;

	@FindBy(xpath = "//ds-switch[@title='Data access for DONOTUSE' or @title='Accès aux données pour DONOTUSE']//Span[text()='ON' or text()='OUI']")
	WebElement divDataAccessOn;
	
	@FindBy(xpath = "//ds-switch[@title='Data access for DONOTUSE' or @title='Accès aux données pour DONOTUSE']//Span[text()='OFF' or text()='NON']")
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
	
	/**
	 * To click the link of lost or stolen device on wireless dashboard page
	 * @author ning.xue
	 */
	public void clkLnkLostOrStolenDevice() {
		reusableActions.getWhenReady(lnkLostOrStolenDevice, 10).click();
	}
	 
	/**
	 * To click the Switch off my service button of report lost or stolen device flow
	 * @author ning.xue
	 */
	public void clkBtnSwitchOffMyService() {
//		reusableActions.waitForElementTobeClickable(btnSwitchOffService, 10);
//		reusableActions.javascriptScrollByVisibleElement(btnSwitchOffService);
		reusableActions.getWhenReady(btnSwitchOffService, 20).click();

	}
	
	/**
	 * Validates whether service suspended message is displayed
	 * @return true if the message is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyServiceSuspendedMsgDisplayed() {
		return reusableActions.isElementVisible(msgServiceSuspended, 30);
	}
	
	/**
	 * Validates whether message to reactivate my service displayed in wireless dashobard page
	 * @return true if the message is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyToReactivateServiceMsgDisplayed() {
		return reusableActions.isElementVisible(msgToReactivateService, 30);
	}
	
	/**
	 * To click the link of reactivate service on wireless dashboard page
	 * @author ning.xue
	 */
	public void clkLnkReactivateService() {
		reusableActions.getWhenReady(lnkReactivateService, 10).click();
	}
	
	/**
	 * Validates whether service resumed message is displayed
	 * @return true if the message is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyServiceResumedMsgDisplayed() {
		return reusableActions.isElementVisible(msgServiceResumed, 30);
	}
	
	/**
	 * To click the link of track a phone repair claim on wireless dashboard page
	 * @author ning.xue
	 */
	public void clkLnkTrackPhoneRepairClaim() {
		reusableActions.getWhenReady(lnkTrackRepairClaim, 10).click();
	}
	
	/**
	 * To click the continue button of track a phone repair claim flow on pop up
	 * @author ning.xue
	 */
	public void clkBtnHelpYourPhoneContinue() {
		reusableActions.clickWhenReady(btnHlpYrPhoneContinue, 10);
	} 
	
	/**
	 * Validates whether repair Claim Modal is displayed
	 * @return true if repair Claim Modal is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyRepairClaimModalIsDisplayed() {
		return reusableActions.isElementVisible(repairClaimModal, 3);
	}
	
	/**
	 * Click the first CTN in the list for repair claim
	 * @author ning.xue
	 */
	public void clkFirstCtnInListForRepairClaim() {
		reusableActions.getWhenReady(radiosOfMultiCtnRepairClaim.get(0),20).click();
	}
	
	/**
	 * To verify if the url opened after click track repair claim is expected.
	 * @param expectedUrl, expected 3rd party url for track phone repair claim
	 * @return true if the url opened is expected, otherwise false
	 * @author ning.xue
	 */
	public boolean verifyBrightstarLinkOpenSuccessfully(String expectedUrl) {
		reusableActions.waitForNumberOfWindowsToBe(2, 5);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		String urlOpened = driver.getCurrentUrl();
		return urlOpened.contains(expectedUrl);
	} 
	
	/**
	 * Validates whether the Talk and Text usage module for full plan is displayed
	 * @return true if the Talk and Text usage module is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyFullPlanTalkTextUsageModuleIsDisplayed() {
		return reusableActions.isElementVisible(mixedTalkTextUsageModule, 30);
	}
	
	/**
	 * To click the view details link in talk and text usage module for full plan wireless dash board.
	 */
	public void clkViewDetailsInFullPlanTalkAndTextUsageModule() { 
		reusableActions.clickWhenReady(viewDetailTalkText, 10);
	} 
	
	/**
	 * Validates whether the Talk and Text detail ds-modal is displayed
	 * @return true if the Talk and Text detail ds-modal is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyDsModalTalkTextDetailIsDisplayed() {
		return reusableActions.isElementVisible(dsModalTalkTextDetail, 10);
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
			String strUsed = reusableActions.getWhenReady(litr.next()).getText();
			if (valueList.hasNext()) {
				String strDetail = reusableActions.getWhenReady(valueList.next()).getText();
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
		return reusableActions.isElementVisible(talkTextOnlyUsageModule, 30);
	}
	
	/**
	 * Validates whether the Talk usage minutes remaining is displayed
	 * @return true if the Talk usage minutes remaining is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyTalkMinutesRemainingIsDisplayed() {
		return reusableActions.isElementVisible(divMinutesRemaining, 30);
	}
	
	/**
	 * Validates whether the Talk usage any time is displayed
	 * @return true if the Talk usage any time is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyTalkUsageAnytimeIsDisplayed() {
		return reusableActions.isElementVisible(tdAnytime, 30);
	}
	
	/**
	 * checks talk usage detail data accuracy in wireless dash board
	 * @return true if the remaining time equal to total time minus used time, otherwise false
	 * @author Ning.Xue
	 */
	public boolean verifyLimitedTalkUsageDetailsAccuracy() {
		System.out.println("Limited Talk plan usage details is being checked");
		Integer intRemainMinutes = Integer.parseInt(reusableActions.getWhenReady(divMinutesRemaining).getText());
		Integer intTotalMinutes = Integer.parseInt(reusableActions.getWhenReady(minutesInclude).getText());
		String strMinutesUsed = reusableActions.getWhenReady(minutesTotalUsed).getText();
		Integer intMinutesUsed = Integer.parseInt(strMinutesUsed.substring(0, strMinutesUsed.length()-8));
		return intRemainMinutes == intTotalMinutes - intMinutesUsed;
	}	
	
	/**
	 * Validates whether the Text usage texts remaining is displayed
	 * @return true if the Text usage texts remaining is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyLimitedTextsRemainingIsDisplayed() {
		return reusableActions.isElementVisible(divTextsRemaining, 30);
	}
	
	/**
	 * Validates whether the Text usage texts message any time sent is displayed
	 * @return true if the Text usage texts message any time sent is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyLimitedTextsMsgSentIsDisplayed() {
		return reusableActions.isElementVisible(msgAnytimeSent, 30);
	}
	
	/**
	 * Validates whether the Text usage texts message any time received is displayed
	 * @return true if the Text usage texts message any time received is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyLimitedTextsMsgReceivedIsDisplayed() {
		return reusableActions.isElementVisible(msgAnytimeReceived, 30);
	}
	
	/**
	 * checks text usage detail data accuracy in wireless dash board
	 * @return true if the remaining texts equal to total messages minus used messages, otherwise false
	 * @author Ning.Xue
	 */
	public boolean verifyLimitedTextUsageDetailsAccuracy() {
		System.out.println("Limited Text usage details is being checked");
		Integer intRemainTexts = Integer.parseInt(reusableActions.getWhenReady(divTextsRemaining).getText());
		Integer intTotalTexts = Integer.parseInt(reusableActions.getWhenReady(msgIncluded).getText());
		String strTextsUsed = reusableActions.getWhenReady(msgTotalUsed).getText();
		Integer intTextsUsed = Integer.parseInt(strTextsUsed.substring(0, strTextsUsed.length()-9));
		return intRemainTexts == intTotalTexts - intTextsUsed;
	}	
	
	/**
	 * Validates whether the Talk usage unlimited minutes is displayed
	 * @return true if the Talk usage unlimited minutes is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyUnlimitedTalkMinutesIsDisplayed() {
		return reusableActions.isElementVisible(talkUnlimitedMinutes, 30);
	} 
	
	/**
	 * Validates whether the unlimited Talk weekday usage is displayed
	 * @return true if the unlimited Talk weekday usage is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyUnlimitedTalkWeekdayUsageIsDisplayed() {
		return reusableActions.isElementVisible(talkWeekday, 30);
	}
	
	
	
	/**
	 * Validates whether the unlimited Talk weekday night and weekend usage is displayed
	 * @return true if the unlimited Talk weekday night and weekend usage is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyUnlimitedTalkNightAndWeekendUsageIsDisplayed() {
		return reusableActions.isElementVisible(talkWeekend, 30);
	} 
	
	/**
	 * Validates whether the unlimited Talk weekday night and weekend usage is displayed
	 * @return true if the unlimited Talk weekday night and weekend usage is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyUnlimitedTalkWeekdayUsageIsInteger() {
	    try
	    {
	        Integer.parseInt(reusableActions.getWhenReady(totalUsedMinutes).getText());
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
			unlimitedTrue = reusableActions.getWhenReady(litr.next()).getText().equalsIgnoreCase("Unlimited") 
					|| reusableActions.getWhenReady(litr.next()).getText().equalsIgnoreCase("Illimités");
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
			String strUsed = reusableActions.getWhenReady(litr.next()).getText();
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
		return reusableActions.isElementVisible(textUnlimitedTexts, 30);
	} 
	
	/**
	 * Validates whether the Text usage messages picture and video is displayed
	 * @return true if the Text usage messages picture and video is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyUnlimitedTextsPictureAndVideoIsDisplayed() {
		return reusableActions.isElementVisible(textPictureAndVideoMsg, 30);
	}
	
	/**
	 * Validates whether the Text usage bundles messages is displayed
	 * @return true if the Text usage bundles messages is displayed, else false
	 * @author ning.xue
	 */
	public boolean verifyUnlimitedTextsBundlesMsgIsDisplayed() {
		return reusableActions.isElementVisible(textBundlesMsg, 30);
	}
	
	/**
	 * Validates whether Wireless page has loaded successfully
	 * @return true on successful load; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyWirelessPageLoad() {
		return reusableActions.isElementVisible(lblMyWlsUsage);
	}
	
	/**
	 * Clicks on the 'Change My Caller Id' link
	 * @author rajesh.varalli1
	 */
	public void clickChangeMyCallerId() {
		reusableActions.getWhenReady(lnkChangeMyCallerId, 20).click();
	} 
	
	/**
	 * Validates the First Name of the Caller ID for SE subscriber
	 * @param strFirstName First Name of the Caller ID 
	 * @return true if the name matches ; else false
	 * @author ning.xue
	 */
	public boolean verifyWirelessCallerIdUpdatedInSeCtnTab(String strFirstName) {
				
		return reusableActions.getWhenReady(nameSeCtnTab).getText().trim().contains(strFirstName);		
	}
	
	/**
	 * Clicks on the Overview button/link on the top menu
	 * @author rajesh.varalli1
	 */
	public void clickOverview() {
		reusableActions.waitForElementTobeClickable(lnkOverview, 10);
		reusableActions.executeJavaScriptClick(lnkOverview);
	}

	/**
	 * Validates and clicks on the 'Update My Voice mail Password' link
	 * @return true if link found; else false
	 * @author rajesh.varalli1
	 */
	public boolean clickUpdateMyVoicemailPwd() {
		if(reusableActions.isElementVisible(lnkUpdateMyVoicemailPwd, 30)) {
			Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
		    String browserName = cap.getBrowserName().toLowerCase();
			if(!browserName.trim().toLowerCase().equalsIgnoreCase("firefox"))
			{
				reusableActions.scrollToElement(lnkUpdateMyVoicemailPwd);
			}
			reusableActions.clickIfAvailable(lnkUpdateMyVoicemailPwd);
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
		reusableActions.getWhenReady(divNewVoicemailPwd, 10).click();
		//reusableActions.getWhenReady(txtNewVoicemailPwd, 5).clear();
		reusableActions.getWhenReady(txtNewVoicemailPwd, 5).sendKeys(strPassword);
	}
	
	/**
	 * Enters the password in the confirm voicemail password field
	 * @param strPassword New voicemail password
	 * @author ning.xue
	 */
	public void setConfirmVoicemailPassword(String strPassword) {
		reusableActions.getWhenReady(divConfirmVoicemailPwd, 10).click();
		//reusableActions.getWhenReady(txtConfirmVoicemailPwd, 5).clear();
		reusableActions.getWhenReady(txtConfirmVoicemailPwd, 5).sendKeys(strPassword);
	}
	
	/**
	 * Clicks on the 'Submit' button
	 * @author rajesh.varalli1
	 */
	public void clickSubmitButton() {
		reusableActions.getWhenReady(btnVoicemailPwdSubmit,10).click();
	}
	
	/**
	 * Validates the Reset Voicemail Password successful message
	 * @return true if message displayed; else false
	 * @author ning.xue
	 */
	public boolean verifyResetVoicemailPasswordSuccess() {
//		if (reusableActions.isElementVisible(imgLoading)) {
//			reusableActions.waitForElementInvisibility(imgLoading, 30);
//		}
		return reusableActions.isElementVisible(msgResetVoicemailPwdSuccess,30);
	}
	
	/**
	 * Clicks on the 'Done' button in reset voice mail password flow
	 * @author ning.xue
	 */
	public void clickResetVMPwdDoneButton() {
		reusableActions.getWhenReady(btnResetVMPwdDone,10).click();
	}
	
	/**
	 * Clicks on the 'Change Plan' button
	 * @author rajesh.varalli1
	 */
	public void clickChangePlanButton() {
		reusableActions.clickIfAvailable(btnChangePlan);
	}
	
	/**
	 * Clicks on the 'Make changes to your current plan' link on the overlay
	 * @author rajesh.varalli1
	 */
	public void clickMakeChangesToCurrentPlan() {
		reusableActions.clickIfAvailable(lnkChangeCurrentPlan);
	}
	
	/**
	 * Scroll to Top of wireless Dashboard page
	 * @author Mirza.Kamran
	 */
	public void scrollToTopOfDasboardPage() {
		reusableActions.javascriptScrollToTopOfPage();
		
	}
	
	/**
	 * Scroll to Mid of wireless Dashboard page
	 * @author Mirza.Kamran
	 */
	public void scrollToMidOfDasboardPage() {
		reusableActions.javascriptScrollToMiddleOfPage();
		
	}

	/**
	 * Scroll to bottom of wireless dashboard page
	 * @author Mirza.Kamran
	 */
	public void scrollToBottomOfPage() {
		reusableActions.javascriptScrollToBottomOfPage();
		
	}

	/**
	 * Clicks on Change my SIM link
	 * @author Mirza.Kamran
	 */
	public void clkLinkChangeMySIM() {
		reusableActions.clickWhenReady(lnkChangeMySIM);
	}

	/**
	 * Sets the string value in Current SIM textbox
	 * @param strOldSimNum String current SIM value
	 * @author Mirza.Kamran
	 */
	public void setOldSimNum(String strOldSimNum) {
		try {					
		reusableActions.waitForElementTobeClickable(txtCurrentSIMNumber, 60);		
		reusableActions.getWhenReady(txtCurrentSIMNumber, 30).clear();
		reusableActions.getWhenReady(txtCurrentSIMNumber).sendKeys(strOldSimNum);
		} catch (StaleElementReferenceException e) {
			reusableActions.staticWait(5000); // static wait to handle state ref error 
			reusableActions.waitForElementTobeClickable(txtCurrentSIMNumber, 60);		
			reusableActions.getWhenReady(txtCurrentSIMNumber, 30).clear();
			reusableActions.getWhenReady(txtCurrentSIMNumber).sendKeys(strOldSimNum);
		}
		
	}

	/**
	 * Sets the value for New SIM number
	 * @param strNewSimNum string value for new SIM number
	 * @author Mirza.Kamran
	 */
	public void setNewSimNum(String strNewSimNum) {
		reusableActions.waitForElementTobeClickable(txtNewSIMNumber, 60);
		//reusableActions.getWhenReady(txtNewSIMNumber, 30).clear();
		reusableActions.getWhenReady(txtNewSIMNumber).sendKeys(strNewSimNum);
	}

	/**
	 * Clicks button update SIM Continue
	 * @author Mirza.Kamran 
	 */
	public void clkBtnUpdateSimNext() {
		reusableActions.clickWhenReady(btnContinueChangeSIM);
		
	}

	/**
	 * Verifies the Update SIM review page
	 * @param strOldSimNum string value current SIM
	 * @param strNewSimNum string value new SIM
	 * @return true if the SIM values are correct else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyUpdateSimReview(String strOldSimNum, String strNewSimNum) {
		if (reusableActions.isElementVisible(titleReviewUpdateSIM, 30)
				&& reusableActions.getWhenReady(reviewNewSim).getText().trim().contains(strNewSimNum)) {
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
		return reusableActions.isElementVisible(lblDataDelayMsg, 30);
	}

	/**
	 * Verifies if the data remaining out of total data bucket is displayed
	 * @return true if element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDataRemainingOutOfTotalDataBucket() {		
		return reusableActions.isElementVisible(lblDataRemainingOutOfTotalDataBucket, 30);
		
	}

	/**
	 * gets the data remaining out of total data bucket is displayed
	 * @return returns the data remaining
	 * @author Mirza.Kamran
	 */
	public double getDataRemainingOutOfTotalDataBucket() {				
		String strTotalData = reusableActions.getWhenReady(lblDataRemainingValue, 30).getText().replaceAll(",", ".").trim();
		return Double.parseDouble(strTotalData.substring(0, strTotalData.length()-2).trim());
	}
	
	/**
	 * Verifies if total data bucket is displayed
	 * @return true if element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyTotalDataBucket() {
	
		return reusableActions.isElementVisible(lblTotalDataBucket, 30);
	}
	
	/**
	 * Verifies if total data bucket is displayed
	 * @return true if element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean getTotalDataBucket() {
	
		return reusableActions.isElementVisible(lblTotalDataBucket, 30);
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
		String strTotalData = reusableActions.getWhenReady(lblTotalDataDisplayedBelowLabelTotalDataPlusPlanAdded, 30).getText().trim().replaceAll(",", ".");
		return Double.parseDouble(strTotalData.substring(0, strTotalData.length()-2).trim());
	}

	/**
	 * Verifies if the data remaining out of total data bucket is displayed
	 * @return true if element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDaysRemainingInTheBillCycleIsDisplayed() {		
		return reusableActions.isElementVisible(lblDaysRemainingInBillCycle, 30);
	}
	
	/**
	 * Verifies if the data remaining out of total data bucket is displayed
	 * @return true if element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDaysRemainingInTheBillCycleIsDisplayedMobile() {		
		return reusableActions.isElementVisible(lblDaysRemainingInBillCycleMobile, 30);
	}
	
	
	/**
	 * Verifies if add data button displayed
	 * @return true if element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAddDataButtonIsDisplayed() {			
		return (reusableActions.getWhenReady(lnkAddDataTopUp, 30).getText().toLowerCase().contains("add data")
				||reusableActions.getWhenReady(lnkAddDataTopUp, 30).getText().toLowerCase().contains("ajouter des données"));
	}
	
	/**
	 * verifies if the data has values up to two decimal places
	 * @return true if values matched expected else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAllMBAmountsConvertedToGBUptoTwoDecimalPlacesForTotalDataPlusAddedPlan() {		
		//compares English and French 
		return ((matchTwoDecimalPlacesPatterMatch(reusableActions.getWhenReady(lblTotalDataDisplayedBelowLabelTotalDataPlusPlanAdded, 30).getText().split("GB")[0].trim())	
				  || matchTwoDecimalPlacesPatterMatch(reusableActions.getWhenReady(lblTotalDataDisplayedBelowLabelTotalDataPlusPlanAdded, 30).getText().split("Go")[0].trim())));
			
	}
	
	
	/**
	 * verifies if the data has values up to two decimal places
	 * @return true if values matched expected else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAllMBAmountsConvertedToGBUptoTwoDecimalPlacesOnLabelDataRemaining() {		
		//compares English and French
		return ((matchTwoDecimalPlacesPatterMatch(reusableActions.getWhenReady(lblDataRemaining, 30).getText().split("GB")[0].trim())
				  || matchTwoDecimalPlacesPatterMatch(reusableActions.getWhenReady(lblDataRemaining, 30).getText().split("Go")[0].trim())));
			
	}
	
	
	/**
	 * verifies if the data has values up to two decimal places
	 * @return true if values matched expected else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAllMBAmountsConvertedToGBUptoTwoDecimalPlacesOnTotalDataBelowUsageBarRightSide() {		
		//compares English and French 
		return ((matchTwoDecimalPlacesPatterMatch(reusableActions.getWhenReady(lbltotalDataDisplayedBelowBarRightSide, 30).getText().split("GB")[0].trim())
				  || matchTwoDecimalPlacesPatterMatch(reusableActions.getWhenReady(lbltotalDataDisplayedBelowBarRightSide, 30).getText().split("Go")[0].trim())));
	}
	
	
	/**
	 * Verifies if the data values are in GB
	 * @return true if values matched expected else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAllMBAmountsConvertedToGBForTotalDataDisplayedBelowLabelTotalDataPlusPlanAdded() {				
		return ((reusableActions.getWhenReady(lblTotalDataDisplayedBelowLabelTotalDataPlusPlanAdded, 30).getText().trim().contains("GB") )
						|| reusableActions.getWhenReady(lblTotalDataDisplayedBelowLabelTotalDataPlusPlanAdded, 30).getText().trim().contains("Go"));								
				
	}
	
	/**
	 * Verifies if the data values are in GB
	 * @return true if values matched expected else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAllMBAmountsConvertedToGBForLabelDataRemaining() {					
		return ((reusableActions.getWhenReady(lblDataRemaining, 30).getText().trim().contains("GB") 
						|| reusableActions.getWhenReady(lblDataRemaining, 30).getText().trim().contains("Go") ));
	}
	
	/**
	 * Verifies if the data values are in GB
	 * @return true if values matched expected else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAllMBAmountsConvertedToGBForlabelTotalDataDisplayedBelowBarRightSide() {					
		return ((reusableActions.getWhenReady(lbltotalDataDisplayedBelowBarRightSide, 30).getText().trim().contains("GB") 
						|| reusableActions.getWhenReady(lbltotalDataDisplayedBelowBarRightSide, 30).getText().trim().contains("Go")));
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
		return ((reusableActions.getWhenReady(lblTalkUsage).getText().toLowerCase().contains("minutes remaining")
				&& reusableActions.getWhenReady(txtNumericValueTalk).getText().trim().matches("^[0-9]*$"))
				|| (reusableActions.getWhenReady(lblTalkUsage).getText().toLowerCase().contains("minutes restantes")
						&& reusableActions.getWhenReady(txtNumericValueTalk).getText().trim().matches("^[0-9]*$")));
	}
	
	/**
	 *Verifies if the Text has the remaining values
	 * @return true if the minutes remaining is displayed correctly
	 * @author Mirza.Kamran
	 */
	public boolean verifyTextHaveMinutesRemainingValues() {		
		return ((reusableActions.getWhenReady(lblTextUsage).getText().toLowerCase().contains("texts remaining")
				&& reusableActions.getWhenReady(txtNumericValueText).getText().trim().matches("^[0-9]*$"))
				|| (reusableActions.getWhenReady(lblTextUsage).getText().toLowerCase().contains("messages texte restants")
				&& reusableActions.getWhenReady(txtNumericValueText).getText().trim().matches("^[0-9]*$")));
	}

	/**
	 * Verifies talk and text doesn't contain view details
	 * @return false if the talk and text contains view details else true
	 * @author Mirza.Kamran
	 */
	public boolean verifyTalkAndTextDoesntContainViewDetails() {
		return (!reusableActions.getWhenReady(divTalkAndTextContainer).getText().trim().contains("view details")
				&& !reusableActions.getWhenReady(divTalkAndTextContainer).getText().trim().contains("Afficher les détails"));
	}

	/**
	 * Click on close on modal button
	 * @author Mirza.Kamran 
	 */
	public void closeDsModal() {
		reusableActions.clickWhenReady(btnCloseOverLay);		
	}
	
	/**
	 * To verify if the live chat button display in wireless dashboard page
	 * @return true if the button displayed otherwise false
	 * @author ning.xue
	 */
	public boolean verifyLiveChatButtonIsDisplayed() {
		return reusableActions.isElementVisible(btnLiveChat, 30);
	}
	
	/**
	 * Click the button Live chat in wireless dashboard page
	 * @author ning.xue
	 */
	public void clkBtnLiveChat() {
		reusableActions.getWhenReady(btnLiveChat, 20).click();
	}
	
	/**
	 * To verify if the live chat overlay opened in wireless dashboard page
	 * @return true if the overlay opened otherwise false
	 * @author ning.xue
	 */
	public boolean verifyLiveChatOverlayOpened() {	
	  if(reusableActions.isElementVisible(fraLiveChat))
		{
		reusableActions.waitForFrameToBeAvailableAndSwitchToIt(fraLiveChat, 20);
		return reusableActions.isElementVisible(headerLiveChat, 30);
		}else
		{
			return reusableActions.isElementVisible(headerLiveChat, 30);
		}
		
	} 
	
	/**
	 * Click the speed pass link in usage section of wireless dashboard page 
	 * @author ning.xue
	 */
	public void clkBtnSpeedPass() {
		//reusableActions.waitForElementTobeClickable(btnSpeedPass, 60);
		reusableActions.getWhenReady(btnSpeedPass, 60).click();
	} 

	/**
	 * My Plan details are displayed at the bottom of my plan
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyMyPlansDetailsIsDisplayedAtTheBottomOfMyPlan() {
		return reusableActions.isElementVisible(lnkMyPlanDetailsAtBottom);		
		
	}

	/**
	 * Verify if Plan name is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyPlanNameIsDisplayed() {
		return reusableActions.isElementVisible(txtPlanName);		
		
	}

	/**
	 * Verify if Monthly service fee is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyMonthlyServiceFeeIsDisplayed() {
		return reusableActions.isElementVisible(txtMonthlyServiceCharge);		
		
	}

	/**
	 * Verify if button change plan is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyButtonChangePlanIsDisplayed() {
		return reusableActions.isElementVisible(btnChangePricePlan);		
		
	}

	/**
	 * Verify Included section is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIncludedSectionIsDisplayed() {
		return reusableActions.isElementVisible(txtHeadingIncluded);	
	}

	/**
	 * Verify Title My wireless plan is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifTitleMyWirelessPlanIsDisplayed() {
		return reusableActions.isElementVisible(txtHeadingIncluded);
		
	}

	/**
	 * Click My Plan details link	 
	 * @author Mirza.Kamran
	 */
	public void clkMyPlanDetailsLink() {
		reusableActions.clickWhenReady(lnkMyPlanDetails);
		
	}

	/**
	 * Verify My Plan details overlay is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyMyPlanDetailsOverlayIsDisplayed() {
		
		return reusableActions.isElementVisible(lblFullPlanDetailsOverlayHeaders);
	}

	/**
	 * Click close button on My Plan details overlay
	 * @author Mirza.Kamran
	 */
	public void closeMyPlanDetailsOverlay() {
		reusableActions.clickWhenReady(btnClosePlanDetailsOverlay);
		
	} 
	
	/**
	 * Validates the header of device section is "My Device" or "Mon appareil"
	 * @return true if the header matches; else false
	 * @author ning.xue
	 */
	public boolean verifyHeaderOfDeviceSection() {
		return reusableActions.isElementVisible(headerMyDevice,30);
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
		Pattern pat = Pattern.compile("^(0|0?[1-9]\\d*)\\.\\d\\d$");

		return reusableActions.isElementVisible(lblDeviceBalance,10) 
				&& Pattern.matches(pat.toString(), strPriceMain.concat(strPriceCents));
	}
	
	/**
	 * To click link upgrade My device in device section
	 * @author ning.xue
	 */
	public void clkLinkUpgradeMyDevice() {
		reusableActions.getWhenReady(lnkUpgradeMyDevice, 30).click();
	}
	
	/**
	 * Check link upgrade My device in device section
	 * @author Mirza.Kamran
	 * @return true if the element is visible else false
	 */
	public boolean verifyLinkUpgradeMyDevice() {
		return reusableActions.isElementVisible(lnkUpgradeMyDevice);
	}
	
	/**
	 * Validates the link "Upgrade My Device", Choose phone page should display after click
	 * @return true if Choose phone page is displayed; else false
	 * @author ning.xue
	 */
	public boolean verifyChoosePhonePage() {
		return reusableActions.isElementVisible(sectionChoosePhone, 20);
	}
	
	/**
	 * Navigate back to wireless dashboard page
	 * @author ning.xue
	 */
	public void navigateBacktoDashboardPage() {
		reusableActions.backToPreviousPage();
	}
	
	/**
	 * Check if the Device Closing Date Message is Available
	 * @return true if the message is available, otherwise false
	 */
	public boolean isDeviceClosingDateMsgAvailable() {
		return reusableActions.isElementVisible(txtClosingDate,10);
	}
	
	/**
	 * Validates the message of device closing date in device section
	 * @return true if the closing date matches the specified format; else false
	 * @author ning.xue
	 */
	public boolean verifyDeviceClosingDateMsgIfAvailable() {

		String strMsg = txtClosingDate.getText();
		String strDate = strMsg.substring(strMsg.length()-13).trim();
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
		reusableActions.getWhenReady(lnkViewDeviceDetails, 30).click();
		return reusableActions.isElementVisible(modalDeviceDetails, 20); 
	}
	
	/**
	 * Validates the My device details modal should have activation date and expire date
	 * @return true if My device details modal have activation date and expire date; else false
	 * @author ning.xue
	 */
	public boolean verifyMyDeviceDetailsModalOfDeviceSection() {
		reusableActions.getWhenReady(lnkViewDeviceDetails, 30).click();
		return (reusableActions.isElementVisible(activationDateOnDeviceModal, 10)
				&& reusableActions.isElementVisible(balanceClosingDate, 10)); 
	}
	
	/**
	 * To click button close My device details modal 
	 * @author ning.xue
	 */
	public void clkCloseMyDeviceDetailsModal() {
		reusableActions.getWhenReady(btnCloseDeviceDetailModal, 10).click();
	}
	
	/**
	 * Check if the Device Upgrade Modal is available, this modal will show when user is not eligible for device upgrade
	 * @return true if the device upgrade modal is available, otherwise false.
	 * @author ning.xue
	 */
	public boolean isModalDeviceUpgradeAvailable() {
		return reusableActions.isElementVisible(modalDeviceUpgrade, 20);
	}
	
	/**
	 * To click button close device upgrade modal 
	 * @author ning.xue
	 */
	public void clkCloseDeviceUpgradeModal() {
		reusableActions.getWhenReady(btnCloseDeviceUpgradeModal, 10).click();
	}
	
	/**
	 * Validates whether support section in Wireless Dash board page has loaded successfully
	 * @return true on successful load; else false
	 * @author ning.xue
	 */
	public boolean verifySupportSection() {
		return reusableActions.isElementVisible(supportSection);
	}
	
	/**
	 * Validates the new page url after click link "FAQ: Unlocking Device"
	 * @param strBaseUrl, String of base url
	 * @return true on URL match; else false
	 * @author ning.xue
	 */
	public boolean verifyLinkFaqUnlockDevice(String strBaseUrl) {
		reusableActions.getWhenReady(lnkFaqUnlockDevice, 20).click();
		return reusableActions.verifyUrls(strBaseUrl + "/customer/support/article/unlocking-devices");
	}
	
	/**
	 * Validates the new page url after click link "NetworkAid"
	 * @param strBaseUrl, the base url to be added to the verify url.
	 * @return true on URL match; else false
	 * @author ning.xue
	 */
	public boolean verifyLinkNetworkAid(String strBaseUrl) {
		reusableActions.getWhenReady(lnkNetworkAid, 60).click();
		//updated in july 24th release
		///customer/support/article/wireless-my-network
		return reusableActions.verifyUrls(strBaseUrl + "/consumer/wireless/my-network");
	}
	
	/**
	 * Validates the new page url after click link "Device Protection"
	 * @param strBaseUrl, the base url to be added to the verify url.
	 * @return true on URL match; else false
	 * @author ning.xue
	 */
	public boolean verifyLinkDeviceProtection(String strBaseUrl) {
		reusableActions.getWhenReady(lnkDeviceProtection, 60).click();
		return reusableActions.verifyUrls(strBaseUrl + "/consumer/wireless/device-protection#,handset-protection--1");
	}

	/**
	 * Verifies running low state in the usage bar
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyRunningLowStateInTheUsageBar() {
		return reusableActions.isElementVisible(divRunningLowInUsageBar);		
	}


	/**
	 * Verifies Call out message to add data is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyCallOutMessageToAddDataIsDisplayed() {
		return reusableActions.isElementVisible(divCallOutMsgToAddData);
	}


	/**
	 * Verifies unlimited data no overage
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyUnlimitedDataNoOverage() {
		return reusableActions.isElementVisible(lblUnlimitdeData);

		
	}


	/**
	 * Verifies data speed reduced message
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifySpeedReducedMsg() {
		return reusableActions.isElementVisible(lblUsingDataAtReducedSpeed);
		
	}


	/**
	 * Verifies button to add speed pass is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifySpeedPassButtonIsDisplayed() {
		return reusableActions.isElementVisible(btnSpeedPass);		
		
	}


	/**
	 * Verifies Call out message to add speed pass is displayed
	 * @return true if the element is visible else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyCallOutMsgToAddSpeedPassIsDisplayed() {
		return reusableActions.isElementVisible(divSpeedPassPopOver);		
	}


	/**
	 * Close call out message 
	 * @author Mirza.Kamran
	 */
	public void clkCloseCallOutMsg() {
		reusableActions.clickWhenReady(btnCloseCallOutPopUp);
		
	}

	/**
	 * Close call out is closed
	 * @author Mirza.Kamran
	 * @return true if the call out is closed else false
	 */
	public boolean validateCloseCallOutIsClosed() {
		return !reusableActions.isElementVisible(btnCloseCallOutPopUp);		
	}
	
	/**
	 * This function validates if the Approaching Reduced Speed is displayed when total data bucket is 10% or less
	 * @return true if the label exits else false
	 * @author Mirza.Kamran
	 */
	public boolean validateDataRemainingOutOfTotalDataBucketTenPercentOrLess() {
		
		return reusableActions.isElementVisible(lblApproachingReducedSpeed);
	}

	/**
	 * Checks if the data remaining is 10% or less
	 * @return true if the value is less than equal ten percent
	 * @author Mirza.Kamran
	 */
	public boolean checkIfTheDataIsTenPercentOrLess() {		
		String totalData = reusableActions.getWhenReady(lblTotalData).getText()
				.split("GB")[0]
				.replace("Go", "")
				.replace(",", ".")
				.trim();
		String remainingData = reusableActions.getWhenReady(lblremainingData).getText()
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
		return reusableActions.isElementVisible(divUsageBar);
	}

	/**
	 * Clicks on Add Data
	 * @author Mirza.Kamran
	 */
	public void clkAddData() {
		reusableActions.clickWhenReady(lnkAddDataTopUp);			
	}
	
	/**
	 * To get the value of usage in the given single CTN
	 * @param strCtn, the CTN number
	 * @return double, the value of usage
	 * @author ning.xue
	 */
	public double getSingleLineUsage(String strCtn) {
		
		String strLast4Digit = strCtn.substring(strCtn.length()-5);
		String strUsageInCtn = reusableActions.getWhenReady(By.xpath("//span[contains(text(),'" + strLast4Digit 
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
		reusableActions.getWhenReady(By.xpath("//span[contains(text(),'" + strLast4Digit + "')]"), 20).click();
	}

	/**
	 * The scrolls for CTNs is present
	 * @return true if the scroll bar is present else false
	 * @author Mirza.Kamran
	 */
	public boolean isScrollForCTNsPresent() {		
		return (reusableActions.isElementVisible(btnLeftScrollCTN)
				&& reusableActions.isElementVisible(btnRightScrollCTN));
	}

	/**
	 * Clicks on the Next CTN scroll
	 * @author Mirza.Kamran
	 */
	public void clkNextCTNScrollArrow() {
		reusableActions.clickWhenReady(btnRightScrollCTN);
		
	}

	/**
	 * Checks if the 6th CTN badge is visible before we have scrolled right
	 * @return true if not visible else false 
	 * @author Mirza.Kamran
	 */
	public boolean isSixthCTNBadgeInVisibleBeforeScrollingOnDashBoard() {		
		return !reusableActions.isElementVisible(lstOfCTNBadgesOnDashboardPage.get(5));
	}

	/**
	 * Checks if the 6th CTN badge is visible after scrolled right
	 * @return true if visible else false 
	 * @author Mirza.Kamran
	 */
	public boolean isSixthCTNVisible() {		
		return reusableActions.isElementVisible(lstOfCTNBadgesOnDashboardPage.get(5));
	}

	/**
	 * Clicks the 6th CTN on dashboard page
	 * @author Mirza.Kamran
	 */
	public void clkTheSixthCTN() {
		reusableActions.clickWhenReady(lstOfCTNBadgesOnDashboardPage.get(5));
		
	}

/**
 * Clicks on the CTN widget on dashboard page
 * @param intCtnNumber CTN badge number
 * @author Mirza.Kamran
 */
	public void clkTheNthCTNOnDashboardPage(int intCtnNumber) {
		reusableActions.clickWhenReady(lstOfCTNBadgesOnDashboardPage.get(intCtnNumber-1));
		
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
		return reusableActions.isElementVisible(divOverageLowInUsageBar);	
	}

	/**
	 * Verifies the overage call out pop 
	 * @return true if the pop out is displayed
	 * @author Mirza.Kamran
	 */
	public boolean verifyCallOutMessageToAddDataDueToOverageIsDisplayed() {
		
		return reusableActions.isElementVisible(divCallOutMsgToAddDataForOverage);
	}
	
	
	/**
	 * Validates if the data manager is available
	 * @return true if the data manager is available else false
	 * @author Mirza.Kamran
	 */
	public boolean isAddDataManagerDisplayed() {
		return reusableActions.isElementVisible(btnAddDataManager,60);
	}

	/**
	 * Clicks on Add data manager
	 * @author Mirza.Kamran
	 */
	public void clkAddDataManager() {
		reusableActions.clickWhenReady(btnAddDataManager);
		
	}

	/**
	 * Clicks on Change data manager
	 * @author Mirza.Kamran
	 */
	public void clkChangeDataManager() {
		reusableActions.clickWhenReady(btnChangeDataManager);
		
	}
	
	/**
	 * Checks if the data manager overlay is displayed
	 * @return true if the data manager overlay is displayed
	 * @author Mirza.Kamran
	 */
	public boolean isChooseDataManagerOverlayDisplayed() {		
		return reusableActions.isElementVisible(titleChooseDataManager);
	}

	/**
	 * Selects the data manager
	 * @author Mirza.Kamran
	 */
	public void selectDataManager() {
		reusableActions.selectWhenReady(selectDataManager, 0);
		
	}
	
	/**
	 * Selects the data manager
	 * @author Mirza.Kamran
	 * @param strCTNValue string value for CTN
	 */
	public void changeDataManager(String strCTNValue) {
		reusableActions.selectWhenReady(selectDataManager,strCTNValue.replaceAll(" ", "").replaceAll("-", ""));
		
	}


	/**
	 * Clicks on save data manager
	 * @author Mirza.Kamran
	 */
	public void clkSaveButtonOnDataManager() {	
		reusableActions.clickWhenReady(btnSaveDataManager);
		reusableActions.staticWait(10000);
	}

	/**
	 * Checks if the set data alert button is displayed
	 * @return true if element displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isSetDataAlertDisplayed() {		
		return reusableActions.isElementVisible(btnSetDataAlert);
	}

	/**
	 * Clicks on set data alert
	 * @author Mirza.Kamran
	 */
	public void clkSetDataAlert() {
		reusableActions.clickWhenReady(btnSetDataAlert);
	}

	/**
	 * Sets Alert On
	 * @author Mirza.Kamran
	 */
	public void setAlertOn() {
		reusableActions.clickWhenReady(btnSetAlertOn);

	}

	/**
	 * Checks if the data alert overlay is displayed
	 * @return true if the set data alert overlay is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isSetDataAlertOverlayDisplayed() {		
		return reusableActions.isElementVisible(titleSetDataAlert);		
	}

	/**
	 * Sets the data alert value
	 * @param strDataAlertValue data alert value
	 * @author Mirza.Kamran
	 */
	public void setDataAlertValue(String strDataAlertValue) {				
		reusableActions.clickWhenReady(lblSetDataAlert);
		reusableActions.getWhenReady(txtSetDataAlert).sendKeys(strDataAlertValue);		
	}

	/**
	 * Clicks on save data alert
	 * @author Mirza.Kamran
	 */
	public void clkSaveButtonOnDataAlertOverlay() {
		reusableActions.clickWhenReady(btnSaveDataAlert);				
	}
	
	/**
	 *  Checks the data alert value set
	 * @param strDataAlert data alert value
	 * @return true if the Data Alert is correctly set, otherwise false.
	 */
	public boolean isDataAlertCorrectlySet(String strDataAlert) {
		String strDataAlertValue = reusableActions.getWhenReady(lblDataAlertSetValue).getText().trim().replaceAll(",", ".").split(" ")[0];
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
		return reusableActions.isElementVisible(btnChangeDataManager);
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
		reusableActions.clickWhenReady(btnDataManagerCTN,30);
		
	}

	/**
	 * Checks if the change plan button is displayed
	 * @return true if the button is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyChangePlanButtonDisplayed() {		
		return reusableActions.isElementVisible(btnChangePlan);
	}

	/**
	 * Checks if the change plan button is displayed
	 * @return true if the button is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyMyPlanDetailsDisplayed() {		
		return reusableActions.isElementVisible(lblMyPlanDetails);
	}
	
	/**
	 * Checks if the change plan button is displayed
	 * @return true if the button is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyChangeMyNumberDisplayed() {		
		return reusableActions.isElementVisible(lnkChangeMyPhoneNumber);
	}

	/**
	 * Verify if the screen saver displayed
	 * @return true if the screen saver is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyStreamSaverDisplayed() {		
		return reusableActions.isElementVisible(lblStreamSaver);
	}

	/**
	 * Verify if the Data access is displayed
	 * @return true if the data access is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDataAccessDisplayed() { 
		return reusableActions.isElementVisible(lblDataAccess);
	}

	/**
	 * Verify if the Data alert is  displayed
	 * @return true if the data alert is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDataAlertDisplayed() {
		return reusableActions.isElementVisible(lblDataAlert);
	}

	/**
	 * Verify if the data manager displayed
	 * @return true if the screen saver is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyDataManagerDisplayed() {
		return reusableActions.isElementVisible(lbldataManager);
	}

	/**
	 * Checks if the Stream Saver ON is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isStreamSaverONDisplayed() {		
		return reusableActions.isElementVisible(btnStreamSaverSwitchON);
	}

	/**
	 * Clicks on Stream Saver ON button
	 * @author Mirza.Kamran
	 */
	public void clkStreamSaverOn() {
		reusableActions.getWhenReady(btnStreamSaverSwitchOff).click();
		
	}

	/**
	 * Checks if the data manager ON is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isDataAccessOnDisplayed() {		
		return reusableActions.isElementVisible(divDataAccessOn);
	}

	/**
	 * Clicks on data access ON button
	 * @author Mirza.Kamran
	 */
	public void clkDataAccessOn() {
		reusableActions.getWhenReady(divDataAccessOFF).click();
		
	}

	
	
	/**
	 * Checks if the data manager OFF is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isDataAccessOFF() {
		return reusableActions.isElementVisible(divDataAccessOFF);
	}

	/**
	 * Clicks on data access OFF button
	 * @author Mirza.Kamran
	 */
	public void clkDataAccessOff() {
		reusableActions.getWhenReady(divDataAccessOn).click();
		
	}

	/**
	 * Checks if the Stream Saver OFF is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isStreamSaverOFF() {
		return reusableActions.isElementVisible(btnStreamSaverSwitchOff);
	}

	/**
	 * Clicks on Stream Saver OFF button
	 * @author Mirza.Kamran
	 */
	public void clkStreamSaverOff() {
		reusableActions.getWhenReady(btnStreamSaverSwitchON).click();
		
	}

	
	
	/**
	 * Checks if the data access is displayed
	 * @return true if the data access is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isDataAccessDisplayed() {
		return reusableActions.isElementVisible(lblDataAccess);
	}

	/**
	 * Click left CTN scroll arrow
	 * @author Mirza.Kamran
	 */
	public void clkLeftCTNScrollArrow() {
		reusableActions.clickIfAvailable(btnLeftScrollCTN);
	}

	/**
	 * Checks if the prepaid header is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidHeaderDisplayed() {
		return reusableActions.isElementVisible(headerPrepaid);
		
	}

	/**
	 * Checks if the prepaid manage my plan and data add on header is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidManageMyPlanAndDataAddOnheaderDisplayed() {
		return reusableActions.isElementVisible(lblPrepaidManageMyPlanAndDataAddOnHeader);				
	}

	/**
	 * Checks if the prepaid Plan details is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidPlanDetailsSectionDisplayed() {
		return reusableActions.isElementVisible(lblPrepaidPlanDetails);
	}

	/**
	 * Checks if the prepaid Next payment Date section is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidNextPaymentDateSectionDisplayed() {
		return (reusableActions.isElementVisible(lblPrepaidNextPaymentDate)
				&& reusableActions.isElementVisible(lblPrepaidNextPaymentMonthAndDate));
	}

	/**
	 * Checks if the prepaid Top Up Now is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidTopUpNowButtonDisplayed() {
		return reusableActions.isElementVisible(btnTopUpNow);
	}

	/**
	 * Checks if the prepaid Change my plan is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidChangeMyPlanDisplayed() {
		return reusableActions.isElementVisible(lnkChangeMyPlan);
	}

	/**
	 * Checks if the prepaid link Manage My Add ons is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidManageMyAddOnsDisplayed() {
		return reusableActions.isElementVisible(lnkManageMyaddOns);
	}

	/**
	 * Checks if the prepaid My wireless number section is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isMyWirelessNumberSectionDisplayed() {
		return (reusableActions.isElementVisible(lblMyWireLessNumberHeader)
				&& reusableActions.isElementVisible(lblWirelessNumber));
	}

	/**
	 * Checks if the label prepaid Pin code is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidPinCodeDisplayed() {
		return reusableActions.isElementVisible(lblPinCode);
				
	}

	/**
	 * Checks if the prepaid lnk change my pin code is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidChangeMyPinCodeDisplayed() {
		return reusableActions.isElementVisible(lnkChangeMyPinCode);
	}

	/**
	 * Checks if the prepaid lnk Start or track a phone repair claim is displayed
	 * @return true if the element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean isPrepaidStartOrTrackAPhoneRepairClaimDisplayed() {
		return reusableActions.isElementVisible(lnkStartOrTrackAPhonerepairClaim);
	}

	/**
	 * Close chat image
	 * @author Mirza.Kamran
	 */
	public void closeChatImage() {
		reusableActions.executeJavaScript("return document.getElementsByClassName('floating-live-chat')[0].remove();");		
	}
}
