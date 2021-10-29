package com.rogers.oneview.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

import java.util.List;

public class RogersIgniteBundlesPage extends BasePageClass{

	public RogersIgniteBundlesPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//input[contains(@id,'canada-post-address-complete')]")
	WebElement addressInput;

	@FindBy(xpath = "//span[@class='ds-icon rds-icon-expand']/ancestor::button")
	WebElement collapse;

	@FindBy(xpath = "//div[@class='pcaautocomplete pcatext' and not(contains(@style,'none'))]")
	WebElement searchResult;

	@FindBy(xpath = "//button[@ng-reflect-rch-track-click-event='checkServiceability']")
	WebElement checkAvailabilitybtn;

	@FindBy(xpath = "//*[@id='ds-modal-container-0']/ds-modal/div[2]/div[1]/div/div[2]/div/div/rch-pca-address-lookup/div/ds-form-field/div/div[1]")
	WebElement inputContainer;

	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement continueButton;

	@FindBy(xpath = "//div[text()='This address is serviceable!' or text()='Cette adresse peut être desservie!']")
	WebElement serviceavailableMessage;

	@FindBy(xpath = "//input[@id='ds-checkbox-id-0']/following-sibling::div")
	WebElement tvCheckbox;

	@FindBy(xpath="//span[contains(text(),'reviewed the customer’s add-ons') or contains(text(),'revue les options du client')]")
	WebElement reviewAddons;

	@FindBy (xpath = "//input[@id='ds-checkbox-id-32-label-container']/following-sibling::div | //div[text()=' Internet ']")
	WebElement internetCheckbox;

	@FindBy(xpath = "//input[@id='ds-checkbox-id-3']/following-sibling::div")
	WebElement homePhoneCheckbox;

	@FindBy(xpath = "//div[text()='Rogers Ignite Flex 5']/parent::div/parent::div//span[text()='Ajouter au panier' or text()='Add to cart']/ancestor::button | (//span[@translate='global.cta.addToCart'])[1]")
	WebElement addToCart;

	@FindBy(xpath = "(//span[@translate='global.cta.addToCart'])[1]")
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

	@FindBy(xpath = "//div[text()='Battery Back-Up' or text()='Batterie de secours']")
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

	@FindBy(xpath = "//*[@id=\"ds-modal-container-7\"]/rch-tv4k-modal/ds-modal/div[2]/div[2]/div[2]/div/button")
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

	String collapsible = "(//rch-collapsible[@ng-reflect-is-open='false'])";

	@FindBy(xpath = "//div[@class='serviceability-ptm-modal-footer']/descendant::span[@translate='global.cta.continue']/ancestor::button")
	WebElement continueFromPointsToMention;



	@FindBy(xpath = "//span[@translate='global.label.learnPageText']")
	WebElement selectServiceCustomerWant;

	@FindBy(xpath = "//span[@translate='global.label.totalMonthlyFees']")
	WebElement monthFeesInCollapse;

	@FindBy(xpath = "//h1[@translate='global.label.personalizeYourChannels']")
	WebElement personalizeYourChannels;

	@FindBy(xpath = "//h1[@translate='global.label.cartSummary']")
	WebElement cartSummaryHeader;

	@FindBy(xpath = "//span[contains(text(),'Account Number')]/ancestor::span//following-sibling::div/child::input")
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

	@FindBy(xpath = "(//rch-dropdown[@ng-reflect-selected-key='0']//select[contains(@id,'ds-form-input-id') and contains(@class,'select')])[1]")
	WebElement additionalIgniteTVBoxes;

	@FindBy(xpath="//p[text()='Ignite Home Phone Setup']")
	WebElement homePhoneSetUp;

	@FindBy(xpath="//span[contains(@translate,'showIgniteHomePhoneSetupModal') and text()='Yes, keep number']")
	WebElement keepNumber;

	@FindBy(xpath="//span[contains(@translate,'showIgniteHomePhoneSetupModal') and text()='No, select new number']")
	WebElement newNumber;
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
	public void reviewTermsAndCondition() {

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
	/**
	 * Click Load Offers button
	 * @author aditi.jain
	 */
	public void clkLoadOffers() {
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
		getReusableActionsInstance().clickIfAvailable(continueButton);
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
	 * Verify the service availability message
	 * @return true if service available, else false
	 * @author chinnarao.vattam
	 */	
	public boolean verifyServiceAvailabilityMessage() {	
		return getReusableActionsInstance().isElementVisible(serviceavailableMessage,120);
	}
	/**
	 * Click Continue Button after Address availability
	 * @author chinnarao.vattam
	 */	
	public void clkContinue() {	
		getReusableActionsInstance().clickWhenReady(continueButton,120);
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
		if(getReusableActionsInstance().isElementVisible(noFor4K))
			getReusableActionsInstance().clickWhenReady(noFor4K,120);
	}
	/**
	 * Click Checkout for channels Exchange
	 * @author chinnarao.vattam
	 */	
	public void clkCheckOut() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().waitForElementVisibility(checkOutFromCartSummary, 45);
		getReusableActionsInstance().getWhenReady(checkOutFromCartSummary,30).sendKeys(Keys.ENTER);

	}
	/**
	 * Click Checkout for Cart Summary
	 * @author chinnarao.vattam
	 */	
	public void clkCheckOutforCartSummary() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().getWhenReady(checkOut,120).sendKeys(Keys.ENTER);
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
		getReusableActionsInstance().clickWhenReady(continueforCheckout,30);
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
		getReusableActionsInstance().waitForElementVisibility(tvCheckbox, 120);
		getReusableActionsInstance().executeJavaScriptClick(tvCheckbox);
	}
	/**
	 * Click Internet checkbox
	 * @author chinnarao.vattam
	 */	
	public void clkInternetCheckbox() {
		getReusableActionsInstance().waitForElementVisibility(internetCheckbox, 30);
		getReusableActionsInstance().executeJavaScriptClick(internetCheckbox);
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
		getReusableActionsInstance().waitForElementVisibility(homePhoneCheckbox, 120);
		getReusableActionsInstance().executeJavaScriptClick(homePhoneCheckbox);
	}	
	/**
	 * Click Exchange Later btn
	 * @author chinnarao.vattam
	 */	
	public void clkexchangeLater() {
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
	public void verifyRecommendedOffers() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(recommendedOffer);


	}
	/*
	*Click Add to cart for the recommended offer
	* @author suganya p
	*/
	public void clkAddToCartForBestOffer() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(clickBstOffer);
		getReusableActionsInstance().executeJavaScriptClick(clickBstOffer);
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
}
