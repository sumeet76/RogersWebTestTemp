package com.rogers.oneview.pages;

//import com.rogers.test.listeners.TestListener;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

import java.util.List;

public class RogersIgniteBundlesPage extends BasePageClass{

	public RogersIgniteBundlesPage(WebDriver driver) {
		super(driver);
		
	}

//	@FindBy(xpath = "//input[contains(@id,'canada-post-address-complete')]")
	@FindBy(xpath="//input[@id='algoliaInput']")
	WebElement addressInput;

	@FindBy(xpath = "//span[@class='ds-icon d-inline-flex rds-icon-expand']/ancestor::button")
	WebElement collapse;

//	@FindBy(xpath = "//div[@class='pcaautocomplete pcatext' and not(contains(@style,'none'))]")
	@FindBy(xpath="//div[contains(@class,'ds-formField__autoComplete')]")
	WebElement searchResult;

	@FindBy(xpath = "//button[@rchtrackclickevent='checkServiceability'] | //button[@ng-reflect-rch-track-click-event='checkServiceability']")
	WebElement checkAvailabilitybtn;

//	@FindBy(xpath = "(//*[@id='ds-modal-container-0']/ds-modal/div[2]/div[1]/div/div/div/div/div)[1] | //*[@id='ds-modal-container-0']/ds-modal/div[2]/div[1]/div/div[2]/div/div/rch-pca-address-lookup/div/ds-form-field/div/div[1] | //*[@id='ds-modal-container-0']/ds-modal/descendant::div[@class='input-search']")
	@FindBy(xpath="//div[contains(@class,'ds-formField__inputContainer')]")
	WebElement inputContainer;

	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement continueButton;

	@FindBy(xpath = "//div[contains(text(),'This address is serviceable') or contains(text(),'Cette adresse peut être desservie')]")
	WebElement serviceavailableMessage;

	@FindBy(xpath = "//input[@id='ds-checkbox-id-3']/following-sibling::div//input[@id='ds-checkbox-id-32-label-container']/following-sibling::div | //div[text()=' TV ' or text()=' Télé ']")
	WebElement tvCheckbox;

	@FindBy(xpath="//span[@translate='global.cta.reviewAddonsLink'] | //span[contains(text(),'reviewed the customer’s add-ons') or contains(text(),'revue les options du client')]")
	WebElement reviewAddons;

		@FindBy (xpath = "//input[@id='ds-checkbox-id-32-label-container']/following-sibling::div | //div[text()=' Internet ']")
	WebElement internetCheckbox;

	@FindBy(xpath = "//input[@id='ds-checkbox-id-3']/following-sibling::div//input[@id='ds-checkbox-id-32-label-container']/following-sibling::div | //div[text()=' Home Phone ' or text()=' Téléphonie résidentielle ']")
	WebElement homePhoneCheckbox;

	@FindBy(xpath = "//div[text()='Rogers Ignite Flex 5']/parent::div/parent::div//span[text()='Ajouter au panier' or text()='Add to cart']/ancestor::button | (//span[@translate='global.cta.addToCart'])[1]")
	WebElement addToCart;

	//@FindBy(xpath = "(//(span[@translate='global.cta.addToCart'])[2]")
	@FindBy(xpath = "//span[contains(text(),'Ignite 50 Ultd + SmartStream')or contains(text(),'Élan Internet 150 illimité + Diffusion futée')]/ancestor::div[3]/following-sibling::div/rch-bundle-price/child::div/child::div[3]/child::button")
	WebElement firstAddToCart;

	@FindBy(xpath = "//span[text()='No, continue' or text()='Non, continuer']/ancestor::button")
	WebElement noPortin;

	@FindBy(xpath = "//span[text()='Retirer' or text()='Remove']/ancestor::button")
	WebElement remove;

	@FindBy(xpath = "//span[text()='Yes, they do' or text()='Oui, il en a un']/ancestor::button")
	WebElement yesFor4K;


	@FindBy(xpath = "//span[contains(text(), 'No, they')]/ancestor::button")
	WebElement noFor4K;


	@FindBy(xpath = "//p[text()='The following 4K content is available to the customer:']/parent::div//span[text()='Continuer' or text()='Continue']/ancestor::button  | //rch-tv4k-modal/descendant::span[@translate='global.cta.continue']/ancestor::button")
	WebElement continueFor4K;

	@FindBy(xpath = "//span[text()='Passer à la caisse' or text()='Checkout']/ancestor::button")
	WebElement checkOut;

	@FindBy(xpath = "//span[@translate='global.cta.checkout']/ancestor::button | //span[contains(text(), 'Checkout') or contains(text(), 'Passer à la caisse')]" )
	WebElement checkOutFromCartSummary;


	@FindBy(xpath = "//span[contains(text(), 'Express') or contains(text(), 'Paiement')]/ancestor::button" )
	WebElement expressCheckout;


	@FindBy(xpath = "//span[text()='Oui, continuer' or text()='Yes, continue']/ancestor::button")
	WebElement continueforCheckout;

	@FindBy(xpath = "//span[text()='Show offers']/ancestor::button")
	WebElement showOffers;

	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement progressIndicator;

	@FindBy(xpath = "//span[text()='Exchange later' or text()='Échanger plus tard']/ancestor::button")
	WebElement exchangeLaterbtn;

	@FindBy(xpath = "//div[text()='Internet']")
	WebElement pointsToMentionInternet;

	@FindBy(xpath = "//div[text()='Home Phone' or text()='Téléphonie résidentielle']")
	WebElement pointsToMentionHomePhone;

	@FindBy(xpath = "//div[text()='Battery Back-Up, Medical Alert and Security Systems' or text()='Batterie de secours']")
	WebElement pointsToMentionBatteryBackup;

	@FindBy(xpath = "//label[text()='I have reviewed all the Points to Mention with the customer.' or text()='J’ai passé en revue tous les points à mentionner avec le client.']")
	WebElement chkboxpointsToMentionReview;

	@FindBy(xpath = "//span[text()='Use this address'  or text()='Utiliser cette adresse']/ancestor::button")
	WebElement btnUsethisaddress;

	@FindBy(xpath = "//span[text()='Yes, keep number' or text()='Oui, garder mon numéro']/ancestor::button")
	WebElement btnKeepNumber;

	@FindBy(xpath = "//span[text()='I have reviewed the customer’s add-ons.' or text()='J’ai passé en revue les options du client.']")
	WebElement customerAddonReveiwLink;

	@FindBy(xpath = "//span[text()='Non, choisir un nouveau numéro' or text()='No, select new number']/ancestor::button")
	WebElement chooseNewNumber;

	@FindBy(xpath = "//div[@class='rch-modal']//span[text()='Yes' or text()='Oui']/ancestor::button")
	WebElement yesBtn;


	@FindAll({
			@FindBy(xpath = "//span[text()='Load offers']/ancestor::button"),
			@FindBy(xpath = "//span[@translate='global.cta.loadOffer']/ancestor::button")
	})
	WebElement loadOffers;

	@FindBy(xpath = "//span[text()='No' or text()='Non']/ancestor::button")
	WebElement noPortInServices;

//	@FindBy(xpath = "//*[@id=\"ds-modal-container-7\"]/rch-tv4k-modal/ds-modal/div[2]/div[2]/div[2]/div/button")
	@FindBy(xpath = "//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large']")
	WebElement fourKContinue;




	@FindAll({
			@FindBy(xpath = "//rch-tv4k-modal/descendant::button/descendant::span[@translate='global.cta.continue']/ancestor::button"),
			@FindBy(xpath = "//rch-tv4k-modal/descendant::span[text()='Continuer' or text()='Continue']/ancestor::button")
	})
	WebElement continue4KContent;


	@FindAll({
			@FindBy(xpath = "//div[contains(text(),'SmartStream')]/ancestor::label"),
			@FindBy(xpath = "//div[@id='ds-checkbox-id-2-label-container']"),
			@FindBy(xpath = "//div[contains(text(), ' SmartStream ')]")
	})
	WebElement smartStreamCheckbox;

	@FindBy(xpath = "//h1[text()='Cart Summary']")
	WebElement cartSummaryLabel;

	@FindBy(xpath = "//button[@rchtrackclickevent='exchangeLater']")
	WebElement exchangeLater;



	@FindBy(xpath = "//span[@translate='global.modals.serviceability.ptm.iHaveReviewed']")
	WebElement reviewTermsAndCondition;

//	String collapsible = "(//rch-collapsible[@ng-reflect-is-open='false'])";
	String collapsible = "(//rch-collapsible[@_nghost-ecx-c166])";

	@FindBy(xpath = "//div[@class='serviceability-ptm-modal-footer']/descendant::span[@translate='global.cta.continue']/ancestor::button")
	WebElement continueFromPointsToMention;



	@FindBy(xpath = "//span[@translate='global.label.learnPageText']")
	WebElement selectServiceCustomerWant;

	@FindBy(xpath = "//span[@translate='global.label.totalMonthlyFees']")
	WebElement monthFeesInCollapse;

	@FindBy(xpath = "//h1[@translate='global.label.personalizeYourChannels']")
	WebElement personalizeYourChannels;

	@FindBy(xpath = "//div[@translate='global.label.cartSummary']")
	WebElement cartSummaryHeader;

	@FindBy(xpath = "//span[contains(text(),'Account Number') or contains(text(),'Numéro de compte')]/ancestor::span//following-sibling::div/child::input")
	WebElement inputAccountNumber;

	@FindBy(xpath = "//span/following-sibling::select")
	WebElement provider;

	@FindBy(xpath = "(//*/parent::div/parent::div//input/parent::div)[1]")
	WebElement inputAccountNumberContainer;

	@FindBy(xpath = "//rch-service-provider-selector/descendant::span[@translate='global.cta.continue']/ancestor::button")
	WebElement portInContinue;

	@FindBy(xpath = "//span[@translate='global.cta.cancel']//ancestor::button/following-sibling::button")
	WebElement continueFromPort;

	@FindBy(xpath = "//rch-port-in-service-selector/descendant::span[@translate='global.cta.continue']/ancestor::button")
	WebElement clickContinue3PPortIn;

	@FindBy(xpath = "//rch-popup-modal/descendant::span[text()='Yes' or text()='Oui']/ancestor::button")
	WebElement yesPortInServices;

	@FindBy(xpath = "//h2[text()='Port-In Services' or text()='Transfert de services']")
	WebElement headerPortInServices;

	@FindBy(xpath ="//p[contains(text(),'Recommended Offer(s)') or contains(text(),'Offres recommandées')]")
	WebElement recommendedOffer;

	@FindBy(xpath="//span[text()='BEST' or 'MEILLEUR' and ng-reflect-translate='global.dynamic.offerLevel.1']/parent::div/following-sibling::div//button//span[@translate='global.cta.addToCart']")
	WebElement clickBstOffer;

	@FindBy(xpath="//ds-icon[@ng-reflect-name='chevron-right']/ancestor::button")
	WebElement selectBestOffer;

	@FindBy(xpath = "//span[text()='Select' or text()='Sélectionner']/ancestor::button")
	WebElement clickRecommendedOffer;

	@FindBy(xpath = "(//select[contains(@id,'ds-form-input-id') and contains(@class,'select')])[1]")
	WebElement additionalIgniteTVBoxes;

	@FindBy(xpath="//p[text()='Ignite Home Phone Setup']")
	WebElement homePhoneSetUp;

	@FindBy(xpath="//span[contains(@translate,'showIgniteHomePhoneSetupModal') and text()='Yes, keep number']")
	WebElement keepNumber;

	@FindBy(xpath="//span[contains(@translate,'showIgniteHomePhoneSetupModal') and text()='No, select new number']")
	WebElement newNumber;


	@FindBy(xpath = "//span[@translate='global.cta.otherAddress']")
	WebElement otherAddress;


	@FindBy(xpath = "//div[@translate='global.modals.serviceability.moveMigration']")
	WebElement moveMigration;


	@FindBy(xpath = "//input[contains(@id, 'canada-post-address-complete')]")
	WebElement enterNewAddress;

	@FindBy(xpath = "//span[@translate='global.cta.checkAvailability']/ancestor::button")
	WebElement availabilityButton;



	@FindBy(xpath = "//span[@translate='global.cta.yes']/ancestor::button")
	WebElement yesButton;


	@FindBy(xpath = "//div[@translate='global.modals.serviceability.moveMigrationNotSupported']")
	WebElement verifyMoveMigrationNotSupported;

	@FindBy(xpath = "//*[@id='ds-modal-container-1']/descendant::div[@class='input-search']")
	WebElement adddressInputContainer;


	@FindBy(xpath="//span[@translate='global.cta.continue']/ancestor::button")
	WebElement continueButtonServiceable;

	@FindBy(xpath="(//span[@translate='global.cta.continue']/ancestor::button)[2]")
	WebElement continueButtonPTM;

	@FindBy(xpath = "//p[contains(text(),'Entrez le numéro') or contains(text(),'Enter number')]/parent::div/child::div/descendant::input")
	WebElement inputHomePhoneNumberPortIn;

	@FindBy(xpath = "(//*/parent::div/parent::div//input/parent::div)[3]")
	WebElement inputHomePhoneNumberPortInContainer;

	@FindBy(xpath = "//span[@translate='global.cta.checkEligibility']/ancestor::button")
	WebElement checkHomePhoneNumberEligibilityButton;

	@FindBy(xpath = "//span[@translate='global.cta.no']/ancestor::button")
	WebElement noButton;

	@FindBy(xpath = "//rch-service-provider-selector/descendant::span[@translate='global.cta.continue']/ancestor::button")
	WebElement continueButtonHomePhoneServiceProvider;

	@FindBy(xpath = "//rch-home-phone-port-in-step/descendant::span[@translate='global.cta.continue']/ancestor::button")
	WebElement continueButtonHomePhonePortIn;

	@FindBy(xpath = "//span[contains(text(),'Numéro de compte') or contains(text(),'Account Number')]/following::div[1]")
	WebElement inputPortInAccountNumberContainer;

	@FindBy(xpath = "//span[@translate='global.cta.addToCart']/ancestor::button")
	WebElement addOnAddToCart;

	@FindBy(xpath="//div[text()=' Smart Home Monitoring ' or text()=' Système de domotique ']")
	WebElement smartHomeMonitoring ;

	@FindBy(xpath = "//ds-modal[@ng-reflect-heading='4K Content']/descendant::span[@translate='global.cta.continue']")
	WebElement fourKContentContinue;

	@FindBy(xpath = "//rch-monthly-section//span[text()=' Show price breakdown ' or text()=' Afficher la répartition du prix ']//ancestor::button")
	WebElement monthlyChargesExpandButton;

	@FindBy(xpath = "//rch-one-time-section//span[text()='Show price breakdown' or text()='Afficher la répartition du prix']//ancestor::button")
	WebElement oneTimeChargesExpandButton;

	@FindBy(xpath = "//span[@translate='global.label.internetAddOns.header']")
	WebElement internetAddOnsCharges;

	@FindBy(xpath = "//*[@translate='global.label.monthlyBill']")
	WebElement monthlyCharges;

	@FindBy(xpath = "//*[@translate='global.label.oneTimeHeader']")
	WebElement oneTimeCharges;

	@FindBy(xpath = "//h1[contains(text(),'Options du Système de domotique Rogers') or contains(text(),'Smart Home Monitoring Add-ons')]")
	WebElement smartHomeAddOnsPageH1;

	@FindBy(xpath = "(//span[text()='Smoke & Fire Sensor' or text()='Détecteur de fumée et d’incendie']//parent::div/parent::div/parent::div//child::button)[1]")
	WebElement smartHomeMonitoringAddOn;

	@FindBy(xpath = "//rch-shm-monthly-section/descendant::div[text()='Automation Package' or text()='Forfait Automatisation']")
	WebElement smartHomeMonitoringMonthlyCharges;

	@FindBy(xpath = "//rch-shm-onetime-section/descendant::div[text()='Automation Package' or text()='Forfait Automatisation']")
	WebElement smartHomeMonitoringOneTimeCharges;


	@FindBy(xpath = "//span[@translate='global.modals.serviceability.ptm.iHaveReviewed']/ancestor::div[@class='col-10 py-16']/following-sibling::div/child::div/child::button")
	WebElement reviewTermsAndConditionsContinueButton;

	@FindBy(xpath = "//div[@class='header']")
	WebElement internetAddOnsHeader;

	@FindBy(xpath = "//span[text()='Exchange now' or text()='Échanger maintenant']/ancestor::button")
	WebElement exchangeNow;

	//@FindBy(xpath = "//div[@class='ng-tns-c166-6 ng-star-inserted'] | //div[@class='ng-tns-c166-10 ng-star-inserted']")
	@FindBy(xpath = "//div[text()='Internet' or text()='l'Internet']")
	WebElement internetCollapse;

	//@FindBy(xpath = "//div[@class='ng-tns-c166-7 ng-star-inserted']")
	@FindBy(xpath = "//div[text()='Home Phone' or text()='téléphone fixe']")
	WebElement homePhoneCollapse;

	//@FindBy(xpath = "//div[@class='ng-tns-c166-8 ng-star-inserted']")
	@FindBy(xpath = "//div[text()='Battery Back-Up, Medical Alert and Security Systems' or text()='Batterie de secours, alerte médicale et systèmes de sécurité']")
	WebElement batteryBackUpCollapse;

	@FindBy(xpath = "(//span[text()='View details'])[1]")
	WebElement viewDetails;

	@FindBy(xpath="//span[@translate='sai.modals.pricingModal.packageDetail']")
	WebElement expandPackageDetails;

	@FindBy(xpath="//button[@title='close']")
	WebElement closeBtn;

	@FindBy(xpath = "//span[text()='CUSTOMER WILL BE ACTIVATED ON FIBRE']")
	WebElement fibreActivationMsg;
	@FindBy(xpath = "ng-tns-c166-16 ng-star-inserted")
	WebElement tvCollapse;

	/**
	 * Click Load Offers button
	 * @author aditi.jain
	 */
	public void clickContinueFromPointsToMention() {
		getReusableActionsInstance().waitForElementVisibility(continueFromPointsToMention, 60);
		getReusableActionsInstance().executeJavaScriptClick(continueFromPointsToMention);
	}

	/**
	 * Review Terms & Condition
	 * @author aditi.jain
	 */
	public void 	reviewTermsAndCondition() {

		List<WebElement> allCollapsible = getDriver().findElements(By.xpath(collapsible));
		for (int i=1; i<=allCollapsible.size(); i++) {
			getReusableActionsInstance().staticWait(5000);
			WebElement currentCollapisble = getReusableActionsInstance().getWhenReady(By.xpath(collapsible +"[1]"));
			getReusableActionsInstance().scrollToElement(currentCollapisble);
			getReusableActionsInstance().clickWhenReady(currentCollapisble);
		}

		getReusableActionsInstance().waitForElementVisibility(reviewTermsAndCondition, 30);
		getReusableActionsInstance().scrollToElement(reviewTermsAndCondition);
		getReusableActionsInstance().executeJavaScriptClick(reviewTermsAndCondition);
	}

	public void clickTermsAndConditionsCheckbox(){
		getReusableActionsInstance().waitForElementVisibility(reviewTermsAndCondition, 30);
		getReusableActionsInstance().scrollToElement(reviewTermsAndCondition);
		getReusableActionsInstance().executeJavaScriptClick(reviewTermsAndCondition);
	}
	/**
	 * Click Load Offers button
	 * @author aditi.jain
	 */
	public void clkLoadOffers() {
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().scrollToElement(loadOffers);
		getReusableActionsInstance().waitForElementVisibility(loadOffers, 30);
		getReusableActionsInstance().executeJavaScriptClick(loadOffers);
	}


	/**
	 * Selects the additional ignite TV boxes
	 * @author aditi.jain
	 */
	public void selectAdditionalIgniteTVBoxes() {
		getReusableActionsInstance().getWhenReady(additionalIgniteTVBoxes,30);
		getReusableActionsInstance().selectWhenReadyByVisibleText(additionalIgniteTVBoxes, "1");
		getReusableActionsInstance().staticWait(5000);
	}

	/**
	 * Selects the given number of additional ignite TV boxes
	 * @author sameer.ahuja
	 * @param noOfBoxes No of boxes to select.
	 */
	public void selectAdditionalIgniteTVBoxes(String noOfBoxes) {
		getReusableActionsInstance().getWhenReady(additionalIgniteTVBoxes,30);
		getReusableActionsInstance().selectWhenReadyByVisibleText(additionalIgniteTVBoxes, noOfBoxes);
		getReusableActionsInstance().staticWait(5000);
	}

	/**
	 * Port-in not supported Pop UP
	 * @author aditi.jain
	 */
	public void noPortInPopup() {
		getReusableActionsInstance().clickWhenReady(noPortInServices,60);
	}

	/**
	 * click Add To Cart for Smartstream
	 * @author aditi.jain
	 */
	public void clickFirstAddToCart() {
		getReusableActionsInstance().waitForElementVisibility(firstAddToCart,45);
		getReusableActionsInstance().scrollToElement(firstAddToCart);
		getReusableActionsInstance().executeJavaScriptClick(firstAddToCart);
	}

	/**
	 * Enter the address to search for service availability
	 * @param address is the Address to check for availability
	 * @author Aditi.jain
	 */
	public void checkAvailability(String address) {
		getReusableActionsInstance().clickWhenReady(inputContainer,45);
		getReusableActionsInstance().enterText(addressInput,address+Keys.BACK_SPACE,60);
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().clickAndHoldFor(searchResult, 333);//.clickWhenReady(searchResult);
		getReusableActionsInstance().staticWait(10000);
		getReusableActionsInstance().clickWhenReady(checkAvailabilitybtn);
		getReusableActionsInstance().staticWait(5000);
//		getReusableActionsInstance().clickIfAvailable(continueButton);
	}

	/**
	 * Enter the address to search for service availability
	 * @param address is the Address to check for availability
	 * @param browser is the Browser to use
	 * @author chinnarao.vattam
	 */
	public void checkAvailability(String address,String browser) {
		getReusableActionsInstance().clickWhenReady(inputContainer,120);
		if(browser.equals("chrome")) {
			getReusableActionsInstance().enterText(addressInput,address+Keys.BACK_SPACE,120);
			getReusableActionsInstance().staticWait(8000);
		}
		else {
			getReusableActionsInstance().enterText(addressInput,address,120);
			getReusableActionsInstance().staticWait(3000);
			}
		getReusableActionsInstance().clickAndHoldFor(searchResult, 333);//.clickWhenReady(searchResult);
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().clickWhenReady(checkAvailabilitybtn);
		getReusableActionsInstance().clickIfAvailable(continueButton);
	}


	/**
	 * scroll to continue button
	 * @author aditi.jain
	 */
	public void scrollToContinue() {
		getReusableActionsInstance().staticWait(2000);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().scrollToElement(continueButton);
	}
	/**
	 * Verify the service availability message
	 * @return true if service available, else false
	 * @author chinnarao.vattam
	 */	
	public boolean verifyServiceAvailabilityMessage() {	
		return getReusableActionsInstance().isElementVisible(serviceavailableMessage,60);
	}
	/**
	 * Click Continue Button after Address availability
	 * @author chinnarao.vattam
	 */	
	public void clkContinue() {
		getReusableActionsInstance().waitForElementVisibility(continueButton);
		getReusableActionsInstance().staticWait(2000);
		getReusableActionsInstance().scrollToElement(continueButton);
		getReusableActionsInstance().executeJavaScriptClick(continueButton);
	}


	/**
	 * refresh continue button
	 * @author aditi.jain
	 */
	public void refreshContinue() {
		getReusableActionsInstance().waitForAllElementsToBeRefreshedAndVisible(By.xpath("//span[text()='Continuer' or text()='Continue']/ancestor::button"),120);
	}

	/**
	 * Port-in not supported Pop UP
	 * @author chinnarao.vattam
	 */	
	public void portInPopup() {	
		getReusableActionsInstance().clickWhenReady(noPortin,120);
	}	
	/**
	 * Click Add to Cart for Selected Product
	 * @param planEn is the Plam Name in English
	 * @param planFr is the Plam Name in French
	 * @author chinnarao.vattam
	 */	
	public void clkAddtoCart(String planEn,String planFr) {
		getReusableActionsInstance().getWhenReady(By.xpath("//div[text()='"+planEn+"' or text()='"+planFr+"']/parent::div/parent::div//span[text()='Ajouter au panier' or text()='Add to cart']/ancestor::button"),120).sendKeys(Keys.ENTER);
	}
	/**
	 * Click Opt out for Home Phone
	 * @param planEn is the Plam Name in English
	 * @param planFr is the Plam Name in French
	 * @author chinnarao.vattam
	 */	
	public void selectOptout(String planEn,String planFr) {
		WebElement btn=getReusableActionsInstance().getWhenReady(By.xpath("//div[text()='"+planEn+"' or text()='"+planFr+"']/parent::div/parent::div//label[text()='Se désinscrire' or text()='Opt out']"),120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		btn.click();
	}



	/**
	 * Click Add to Cart for Selected Product
	 * @param planEn is the Plam Name in English
	 * @param planFr is the Plam Name in French
	 * @author chinnarao.vattam
	 */

	/**
	 * Verify the Product is Added to Cart
	 * @return true if Product is added, else false
	 * @author chinnarao.vattam
	 */	
	public boolean verifyProductinCart() {	
		if(getReusableActionsInstance().isElementVisible(remove,120)) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(remove);
			return true;
		}else
		return false;
	}
	/**
	 * CLick Continue for 4K content pop up
	 * @author chinnarao.vattam
	 */	
	public void fourKContentPopup() {	
		if(getReusableActionsInstance().isElementVisible(continueFor4K))
			getReusableActionsInstance().clickWhenReady(continueFor4K,120);
	}
	/**
	 * CLick Yes if 4K pop up Appears
	 * @author chinnarao.vattam
	 */	
	public void fourKTVPopup() {
		if(getReusableActionsInstance().isElementVisible(yesFor4K))
			getReusableActionsInstance().clickWhenReady(yesFor4K,120);
	}

	/**
	 * CLick No if 4K pop up Appears
	 * @author Aditi.jain
	 */
	public void noTo4KTVPopup() {
		if(getReusableActionsInstance().isElementVisible(noFor4K, 5))
			getReusableActionsInstance().clickWhenReady(noFor4K,120);
	}
	/**
	 * Click Checkout for channels Exchange
	 * @author chinnarao.vattam
	 */	
	public void clkCheckOut() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().waitForElementVisibility(checkOut, 45);
		getReusableActionsInstance().getWhenReady(checkOut,30).sendKeys(Keys.ENTER);

	}

	/**
	 * Click Express Checkout in OVR
	 * @author Sameer.Ahuja
	 */
	public void clkExpressCheckout() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().waitForElementVisibility(expressCheckout, 45);
		getReusableActionsInstance().getWhenReady(expressCheckout,30).sendKeys(Keys.ENTER);
	}

	/**
	 * Click Checkout for Cart Summary
	 * @author chinnarao.vattam
	 */	
	public void clkCheckOutforCartSummary() {
		getReusableActionsInstance().staticWait(5000);
	//	getReusableActionsInstance().scrollToElement(checkOut);
	//	getReusableActionsInstance().getWhenReady(checkOut,120).sendKeys(Keys.ENTER);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().executeJavaScriptClick(checkOut);
	}

	/**
	 * CLick Continue for four K
	 * @author aditi.jain
	 */
	public void fourKContinue() {
		if(getReusableActionsInstance().isElementVisible(fourKContinue, 45))
			getReusableActionsInstance().clickWhenReady(fourKContinue, 30);
	}

	/**
	 * CLick Continue
	 * @author aditi.jain
	 */
	public void contiue4KContent() {
		getReusableActionsInstance().waitForElementVisibility(continue4KContent, 30);
		getReusableActionsInstance().clickWhenReady(continue4KContent, 30);
	}
	/**
	 * Customer Wish to Continue Popup
	 * @author chinnarao.vattam
	 */	
	public void customerWishtoContinue() {
		getReusableActionsInstance().clickWhenReady(continueforCheckout,90);
	}
	/**
	 * Click Collapse(Down Arrow)
	 * @author chinnarao.vattam
	 */	
	public void clkCollapse() {
		getReusableActionsInstance().clickIfAvailable(collapse,45);
	}

	/**
	 * click exchange later button
	 * @author Aditi.Jain
	 */
	public void clickExchangeLater() {
		getReusableActionsInstance().clickWhenReady(exchangeLater,60);
	}

	/**
	 * Click TV checkbox
	 * @author chinnarao.vattam
	 */	
	public void clkTVCheckbox() {
		getReusableActionsInstance().waitForElementVisibility(tvCheckbox, 30);
		getReusableActionsInstance().executeJavaScriptClick(tvCheckbox);

	}
	/**
	 * Click Internet checkbox
	 * @author chinnarao.vattam
	 */	
	public void clkInternetCheckbox() {
		getReusableActionsInstance().staticWait(3000);
//		getReusableActionsInstance().scrollToElement(internetCheckbox);
		getReusableActionsInstance().waitForElementVisibility(internetCheckbox, 30);
		getReusableActionsInstance().executeJavaScriptClick(internetCheckbox);
	}

	public void goToPageBottom() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
	}
	/**
	 * Click SmartStream
	 * @author aditi.jain
	 */
	public void clkSmartStream() {
		getReusableActionsInstance().scrollToElement(smartStreamCheckbox);
		getReusableActionsInstance().executeJavaScriptClick(smartStreamCheckbox);
	}
	/**
	 * Click Home Phone checkbox
	 * @author chinnarao.vattam
	 */	
	public void clkHomePhoneCheckbox() {
		getReusableActionsInstance().waitForElementVisibility(homePhoneCheckbox, 30);
		getReusableActionsInstance().executeJavaScriptClick(homePhoneCheckbox);
	}	
	/**
	 * Click Exchange Later btn
	 * @author chinnarao.vattam
	 */	
	public void clkexchangeLater() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().clickWhenReady(exchangeLaterbtn,120);
	}	
	/**
	 * Click Show Offers button
	 * @author chinnarao.vattam
	 */	
	public void clkShowOffers() {
		getReusableActionsInstance().clickWhenReady(showOffers,120);
	}	
	/**
	 * Click Internet to Expand in Points to Mention
	 * @author chinnarao.vattam
	 */	
	public void expandInternetdiv() {
		getReusableActionsInstance().clickWhenReady(pointsToMentionInternet,120);
	}	
	/**
	 * Click Home Phone to Expand in Points to Mention
	 * @author chinnarao.vattam
	 */	
	public void expandHomePhonediv() {
		getReusableActionsInstance().clickWhenReady(pointsToMentionHomePhone,120);
	}	
	/**
	 * Click Battery Back-Up to Expand in Points to Mention
	 * @author chinnarao.vattam
	 */	
	public void expandBatteryBackUpdiv() {
		getReusableActionsInstance().clickWhenReady(pointsToMentionBatteryBackup,120);
	}	
	/**
	 * Select check box for points to mention rev
	 * @author chinnarao.vattam
	 */	
	public void selectchkboxpointsToMentionReviewed() {
		getReusableActionsInstance().clickWhenReady(chkboxpointsToMentionReview,120);
	}	
/**
 * Click Use this Address
 * @author chinnarao.vattam
 */
public void clkUsethisAddress() {
		getReusableActionsInstance().getWhenReady(btnUsethisaddress, 120).click();
	}
/**
 * Verify the check Availability pop up appears
 * @return true if Pop up appears, else false
 * @author chinnarao.vattam
 */	
public boolean verifyCheckAvailabilityPopUp() {	
	return getReusableActionsInstance().isElementVisible(btnUsethisaddress,120);
		
}
/**
 * Verify the Home Phone Setup pop up appears
 * @return true if Pop up appears, else false
 * @author chinnarao.vattam
 */	
public boolean verifyHomePhoneSetupPopUp() {	
	return getReusableActionsInstance().isElementVisible(btnKeepNumber,120);
		
}
/**
 * Click Yes, Keep Number
 * @author chinnarao.vattam
 */
public void clkKeepNumberbtn() {
		getReusableActionsInstance().getWhenReady(btnKeepNumber, 120).click();
	}
/**
 * Click No, Choose new Number
 * @author chinnarao.vattam
 */
public void clkChooseNewNumberbtn() {
		getReusableActionsInstance().getWhenReady(chooseNewNumber, 120).click();
	}
/**
 * Click Customer Add-On review
 * @author chinnarao.vattam
 */
public void clkCustomerAddonReview() {
		getReusableActionsInstance().getWhenReady(customerAddonReveiwLink,120).click();
	}
/**
 * Click yes for Verify Home Phone Later
 * @author chinnarao.vattam
 */	
public void activateHomePhoneltrPopUp() {	
	getReusableActionsInstance().getWhenReady(yesBtn,120).click();
}

	/**
	 * Verify Select services customer may opt for available
	 * @return true if available, else false
	 * @author Aditi.jain
	 */
	public boolean verifyAvailableServicesCheckboxes() {
		return getReusableActionsInstance().isElementVisible(selectServiceCustomerWant,45);
	}


	/**
	 * Verify Monthly Fees available
	 * @return true if available, else false
	 * @author Aditi.jain
	 */
	public boolean verifyMonthlyFeesInCollapsible() {
		return getReusableActionsInstance().isElementVisible(monthFeesInCollapse,90);
	}

	/**
	 * Verify Personalize Your Channel header
	 * @return true if available, else false
	 * @author Aditi.jain
	 */
	public boolean verifyPersonalizeYourChannels() {
		return getReusableActionsInstance().isElementVisible(personalizeYourChannels,45);
	}

	/**
	 * Verify Cart Summary Header
	 * @return true if available, else false
	 * @author Aditi.jain
	 */
	public boolean verifyCartSummaryHeader() {
		return getReusableActionsInstance().isElementVisible(cartSummaryHeader,60);
	}

	/**
	 * Port-in opted as yes
	 * @author aditi.jain
	 */
	public void yesPortInPopup() {
		getReusableActionsInstance().clickWhenReady(yesPortInServices,30);
	}
	/**
	 * Port-in Services Header
	 * @author aditi.jain
	 */
	public boolean headerPortInService() {
		return getReusableActionsInstance().isElementVisible(headerPortInServices,30);
	}

	/**
	 * Select Provider
	 * @param providerName is the provider name
	 * @author Aditi.Jain
	 */
	public void setProvider(String providerName) {
		getReusableActionsInstance().selectWhenReadyByVisibleText(provider, providerName);
	}

	/**
	 * Enter the account number
	 * @param accountNumber is the account number of the provider
	 * @author aditi.jain
	 */
	public void enterAccountNumber(String accountNumber) {
		Point point = inputAccountNumber.getLocation();
		getReusableActionsInstance().javascriptScrollByCoordinates(point.getX()-20, point.getY()-200);
		getReusableActionsInstance().executeJavaScriptClick(inputAccountNumberContainer);
		getReusableActionsInstance().javascriptScrollByVisibleElement(inputAccountNumber);
		getReusableActionsInstance().enterText(inputAccountNumber, accountNumber, 30);
	}


	/**
	 * CLick Continue from Port In screen
	 * @author aditi.jain
	 */
	public void contiueFromPortIn() {
		getReusableActionsInstance().clickWhenReady(portInContinue, 30);
	}
	/**
	 * CLick Continue from Port In screen
	 * @author aditi.jain
	 */
	public void contiueToCartSummary() {
		getReusableActionsInstance().clickWhenReady(continueFromPort, 10);
	}

	/**
	 * Click Continue Button
	 * @author aditi.jain
	 */
	public void clkContinueFor3PPortIn() {
		getReusableActionsInstance().scrollToElement(clickContinue3PPortIn);
		getReusableActionsInstance().executeJavaScriptClick(clickContinue3PPortIn);
	}
	/*
	* To Verify the display of targeted offer for the customer
	* @author suganya.p
	*/
	public boolean verifyRecommendedOffers() {
//		getReusableActionsInstance().javascriptScrollByVisibleElement(recommendedOffer);
		return getReusableActionsInstance().isElementVisible(recommendedOffer);
	}
	/*
	*Click Add to cart for the recommended offer
	* @author suganya p
	*/
	public void clkAddToCartForBestOffer() {
		getReusableActionsInstance().waitForElementVisibility(clickBstOffer, 60);
		getReusableActionsInstance().javascriptScrollByVisibleElement(clickBstOffer);
		getReusableActionsInstance().executeJavaScriptClick(clickBstOffer);
	}


	/*
	 *select best offer
	 * @author aditi.jain
	 */
	public void selectBestOffer() {
		getReusableActionsInstance().waitForElementTobeClickable(selectBestOffer, 30);
		getReusableActionsInstance().executeJavaScriptClick(selectBestOffer);
	}

	public void selectRecommendedOffer(){
		getReusableActionsInstance().waitForElementTobeClickable(clickRecommendedOffer, 30);
		getReusableActionsInstance().javascriptScrollByVisibleElement(clickRecommendedOffer);
		getReusableActionsInstance().clickWhenReady(clickRecommendedOffer);
	}

	/*To click review addon link in channels and theme packs page
	* @author suganya p
	*
	*/
	public void clickReviewAddons() {
		if (getReusableActionsInstance().isElementVisible(reviewAddons,30))
		getReusableActionsInstance().clickWhenReady(reviewAddons);
	}
	/* To verify the Ignite Home Phone Setup check box
	* @suganya p
	*/
	public boolean verifyIgniteHomePhoneSetup()
	{
		return getReusableActionsInstance().isElementVisible(homePhoneSetUp,60);
	}
	/*To Select the keep number in Home phone setup
	* @suganya p
	*/
	public void clickKeepNumber()
	{
		getReusableActionsInstance().getWhenReady(keepNumber,30).click();
	}

	/*
	* To select new nuber option in Home Phone Setup
	* @suganya p
	*/
	public void clickNewNumber()
	{
		getReusableActionsInstance().getWhenReady(newNumber,30).click();
	}

	/**
	 * click Apply coupon
	 * @author aditi.jain
	 */
	public void clickOtherAddress() {
		getReusableActionsInstance().clickWhenReady(otherAddress,30);
	}

	/**
	 * Verify Credit Check Information is correct
	 * @return true if Continue Button in Enable else return False
	 * @author chinnarao.vattam
	 *
	 */
	public boolean verifyMoveMigration() {
		return getReusableActionsInstance().isElementVisible(moveMigration,30);
	}

	/**
	 * click Apply coupon
	 * @author aditi.jain
	 */
	public void enterNewAddress(String address) {

		getReusableActionsInstance().clickWhenReady(adddressInputContainer,45);
		getReusableActionsInstance().enterText(enterNewAddress,(address+Keys.BACK_SPACE),60);
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().clickAndHoldFor(searchResult, 333);//.clickWhenReady(searchResult);
		getReusableActionsInstance().staticWait(10000);
	}


	/**
	 * Verify Credit Check Information is correct
	 * @return true if Continue Button in Enable else return False
	 * @author aditi.jain
	 *
	 */
	public boolean verifyMoveMigrationNotSupported() {
		return getReusableActionsInstance().isElementVisible(verifyMoveMigrationNotSupported);
	}
	/**
	 * * click Apply coupon
	 * @author aditi.jain
	 */
	public void clickYes() {
		getReusableActionsInstance().clickWhenReady(yesButton,30);
	}


	/**
	 * click Apply coupon
	 * @author aditi.jain
	 */
	public void clickAvailability() {
		getReusableActionsInstance().clickWhenReady(availabilityButton,30);
	}

	/**
	 * Click Checkout for channels Exchange
	 * @author chinnarao.vattam
	 */
	public void clkExpressCheckOut() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().waitForElementVisibility(expressCheckout, 45);
		getReusableActionsInstance().executeJavaScriptClick(expressCheckout);
//    getReusableActionsInstance().getWhenReady(expressCheckout,30).sendKeys(Keys.ENTER);
	}

	public void clkContinueServiceable()
	{
		getReusableActionsInstance().staticWait(8000);
		getReusableActionsInstance().getWhenReady(continueButtonServiceable,30).click();
	}
	public void clkContinuePTM()
	{
		getReusableActionsInstance().clickWhenReady(continueButtonPTM,120);
	}
	public void clkContinueInternetAddon()
	{
		getReusableActionsInstance().staticWait(10000);
		getReusableActionsInstance().staticWait(9000);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().getWhenReady(continueButton,60);
		getReusableActionsInstance().executeJavaScriptClick(continueButton);
	}

	/* click Apply coupon
	 * @author aditi.jain
	 */
	public void clickAddOnAddToCart() {
		getReusableActionsInstance().clickWhenReady(addOnAddToCart,30);
	}
	/**
	 * Click smartHomeMonitoring to Expand in Points to Mention
	 * @author aditi.jain
	 */
	public void clickSmartHomeMonitoring() {
		getReusableActionsInstance().waitForElementVisibility(smartHomeMonitoring, 10);
		getReusableActionsInstance().executeJavaScriptClick(smartHomeMonitoring);
	}

	/**
	 * CLick Continue for four K Content
	 * @author aditi.jain
	 */
	public void fourKContentContinue() {
		if(getReusableActionsInstance().isElementVisible(fourKContentContinue, 180))
			getReusableActionsInstance().executeJavaScriptClick(fourKContentContinue);
	}

	/*TO add pods in the internet addons page
	@suganya p
	*/
	public void addPods(int amount)
	{
		By podsLocator = By.xpath("//div[text()=' "+amount+" ']/ancestor::div[@class='internet-tile__pricing']/following-sibling::div//span[@translate='global.cta.addToCart']");
		getReusableActionsInstance().getWhenReady(podsLocator, 20);
		WebElement addToCart = getDriver().findElement(podsLocator);
		getReusableActionsInstance().executeJavaScriptClick(addToCart);
	}
	/**
	 * Adds Additional pods after the first pods is added to cart.
	 * @param podsPrice is the price of pod to be added.($0 or $5)
	 * @author Sameer.ahuja
	 */
	public void addAdditionalPods(int podsPrice){
		By addPodsLocator = By.xpath("//div[text()=' "+podsPrice+" ']/ancestor::div[@class='internet-tile__pricing']/following-sibling::div/descendant::span[text()=' + ']/ancestor::button");
		getReusableActionsInstance().getWhenReady(addPodsLocator, 30);
		WebElement addPodsButton = getDriver().findElement(addPodsLocator);
		getReusableActionsInstance().executeJavaScriptClick(addPodsButton);
	}


	/**
	 * Click No button on Move Migration pop up.
	 * @author Sameer.Ahuja
	 */
	public void clickNo(){
		getReusableActionsInstance().clickWhenReady(noButton, 10);
	}

	/**
	 * Continue from Home Phone service provider form for Home-Phone Port-In
	 * @author Sameer.Ahuja
	 */
	public void clkContinueFromHomePhoneServiceProvider(){
		getReusableActionsInstance().scrollToElement(continueButtonHomePhoneServiceProvider);
		getReusableActionsInstance().waitForElementTobeClickable(continueButtonHomePhoneServiceProvider, 60);
		getReusableActionsInstance().clickWhenReady(continueButtonHomePhoneServiceProvider);
	}

	/**
	 * Enters account number for Home Phone account for Home Phone Port in.
	 * @param accountNumber Account number to entered
	 * @author sameer.ahuja
	 */
	public void enterHomePhoneAccountNumber(String accountNumber){
		getReusableActionsInstance().javascriptScrollByVisibleElement(inputPortInAccountNumberContainer);
		getReusableActionsInstance().clickWhenReady(inputPortInAccountNumberContainer);
		getReusableActionsInstance().javascriptScrollByVisibleElement(inputAccountNumber);
		getReusableActionsInstance().enterText(inputAccountNumber, accountNumber, 30);
	}

	/**
	 * Enters the 10 digit home phone number to be used for port in
	 * @param phoneNumber 10 digit home phone number
	 * @author sameer.ahuja
	 */
	public void enterHomePhoneNumberPortIn(String phoneNumber){
		getReusableActionsInstance().javascriptScrollByVisibleElement(inputHomePhoneNumberPortInContainer);
		getReusableActionsInstance().clickWhenReady(inputHomePhoneNumberPortInContainer);
		getReusableActionsInstance().javascriptScrollByVisibleElement(inputHomePhoneNumberPortIn);
		getReusableActionsInstance().getWhenReady(inputHomePhoneNumberPortIn,3).sendKeys(phoneNumber.substring(0,3));
		getReusableActionsInstance().getWhenReady(inputHomePhoneNumberPortIn,3).sendKeys(phoneNumber.substring(3,6));
		getReusableActionsInstance().getWhenReady(inputHomePhoneNumberPortIn,3).sendKeys(phoneNumber.substring(6));

		getReusableActionsInstance().waitForElementTobeClickable(checkHomePhoneNumberEligibilityButton, 10);
		getReusableActionsInstance().clickWhenReady(checkHomePhoneNumberEligibilityButton);
	}

	/**
	 * Continue from Home Phone Port In Phone Number details
	 * @author Sameer.Ahuja
	 */
	public void clkContinueFromHomePhonePortIn(){
		getReusableActionsInstance().scrollToElement(continueButtonHomePhonePortIn);
		getReusableActionsInstance().waitForElementTobeClickable(continueButtonHomePhonePortIn, 10);
		getReusableActionsInstance().clickWhenReady(continueButtonHomePhonePortIn);
	}

	/**
	 * Expands the Monthly charges on cart Summary page and validates Internet add ons charges are present
	 * @return True if Internet Add on charges are present in monthly charges.
	 * @author Sameer.Ahuja
	 */
	public boolean validateInternetAddOnsInCartSummary(){
		getReusableActionsInstance().getWhenReady(monthlyCharges, 10);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().clickWhenReady(monthlyChargesExpandButton);
		getReusableActionsInstance().javascriptScrollByVisibleElement(internetAddOnsCharges);
		return getReusableActionsInstance().isElementVisible(internetAddOnsCharges, 10);
	}

	public boolean validateInternetAddOnsHeader(){
		return getReusableActionsInstance().isElementVisible(internetAddOnsCharges,60);
	}

	public boolean validateSmartHomeAddOnsHeader() {
		return getReusableActionsInstance().isElementVisible(smartHomeAddOnsPageH1, 30);
	}

	public void addSHMAddOn(){
		getReusableActionsInstance().waitForElementVisibility(smartHomeMonitoringAddOn);
		getReusableActionsInstance().scrollToElementAndClick(smartHomeMonitoringAddOn);
	}
	/**
	 * Expands the Monthly charges on cart Summary page and validates SHM add ons charges are present
	 * @return True if SHM Add on charges are present in monthly charges.
	 * @author Sameer.Ahuja
	 */
	public boolean validateSHMMonthlyChargesInCartSummary(){
		getReusableActionsInstance().getWhenReady(monthlyCharges, 20);
		getReusableActionsInstance().javascriptScrollByVisibleElement(monthlyChargesExpandButton);
		getReusableActionsInstance().executeJavaScriptClick(monthlyChargesExpandButton);
		getReusableActionsInstance().javascriptScrollByVisibleElement(smartHomeMonitoringMonthlyCharges);
		return getReusableActionsInstance().isElementVisible(smartHomeMonitoringMonthlyCharges, 10);
	}
	/**
	 * Expands the One Time charges on cart Summary page and validates SHM add ons charges are present
	 * @return True if SHM Add on charges are present in one time charges.
	 * @author Sameer.Ahuja
	 */
	public boolean validateSHMOnetimeChargesInCartSummary(){
		getReusableActionsInstance().getWhenReady(oneTimeCharges, 20);
		getReusableActionsInstance().executeJavaScriptClick(oneTimeChargesExpandButton);
		getReusableActionsInstance().javascriptScrollByVisibleElement(smartHomeMonitoringOneTimeCharges);
		return getReusableActionsInstance().isElementVisible(smartHomeMonitoringOneTimeCharges,10);
	}

	public void clickReviewTearmAndConditionsContinueButton()
	{
		getReusableActionsInstance().getWhenReady(reviewTermsAndConditionsContinueButton, 10);
		getReusableActionsInstance().clickWhenReady(reviewTermsAndConditionsContinueButton);
	}

	public boolean verifyInternetAddOnsHeader(){
		return getReusableActionsInstance().isElementVisible((internetAddOnsHeader));
	}

	public void clickExchangeNow()
	{
		getReusableActionsInstance().getWhenReady(exchangeNow, 10);
		getReusableActionsInstance().clickWhenReady(exchangeNow);
	}

	public void clickInternetCollapse()
	{
		getReusableActionsInstance().getWhenReady(internetCollapse, 10);
		getReusableActionsInstance().clickWhenReady(internetCollapse);
	}

	public void clickHomePhoneCollapse()
	{
		getReusableActionsInstance().scrollToElement(homePhoneCollapse);
		getReusableActionsInstance().clickWhenReady(homePhoneCollapse);
	}

	public void clickBatteryBackUpCollapse()
	{
		getReusableActionsInstance().scrollToElement(batteryBackUpCollapse);
		getReusableActionsInstance().clickWhenReady(batteryBackUpCollapse);
	}

	public void clickViewDetails()
	{
		getReusableActionsInstance().waitForElementTobeClickable(viewDetails, 30);
		getReusableActionsInstance().executeJavaScriptClick(viewDetails);
	}

	public void clkExpandPackageDetails(){
		getReusableActionsInstance().getWhenReady(expandPackageDetails);
		getReusableActionsInstance().clickWhenReady(expandPackageDetails);
	}

	public void clkCloseBtn(){
		getReusableActionsInstance().getWhenReady(closeBtn);
		getReusableActionsInstance().clickWhenReady(closeBtn);
	}

	public boolean verifyFibreActivationMSg(){
		getReusableActionsInstance().waitForElementVisibility(fibreActivationMsg,20);
		return getReusableActionsInstance().isElementVisible(fibreActivationMsg);
	}

	public void clickTvCollapse()
	{
		getReusableActionsInstance().scrollToElement(tvCollapse);
		getReusableActionsInstance().clickWhenReady(tvCollapse);
	}
}


