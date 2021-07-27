package com.rogers.oneview.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	@FindBy(xpath = "//div[contains(text(),'TV')]/ancestor::label  | //div[@id='ds-checkbox-id-0-label-container'] | //div[contains(text(), ' TV ')]")
	WebElement tvCheckbox;

	@FindBy (xpath = "//div[contains(text(),'Internet')]/ancestor::label | //div[@id='ds-checkbox-id-1-label-container'] | //div[contains(text(), ' Internet ')]")
	WebElement internetCheckbox;

	@FindBy(xpath = "//div[contains(text(),'Home Phone')]/ancestor::label  | //div[@id='ds-checkbox-id-3-label-container'] | //div[contains(text(), ' Home Phone ')]")
	WebElement homePhoneCheckbox;

	@FindBy(xpath = "//div[text()='Rogers Ignite Flex 5']/parent::div/parent::div//span[text()='Ajouter au panier' or text()='Add to cart']/ancestor::button")
	WebElement addToCart;

	@FindBy(xpath = "//span[text()='No, continue' or text()='Non, continuer']/ancestor::button")
	WebElement noPortin;

	@FindBy(xpath = "//span[text()='Retirer' or text()='Remove']/ancestor::button")
	WebElement remove;

	@FindBy(xpath = "//span[text()='Yes, they do' or text()='Oui, il en a un']/ancestor::button")
	WebElement yesFor4K;

	@FindBy(xpath = "//p[text()='The following 4K content is available to the customer:']/parent::div//span[text()='Continuer' or text()='Continue']/ancestor::button  | //rch-tv4k-modal/descendant::span[@translate='global.cta.continue']/ancestor::button")
	WebElement continueFor4K;

	@FindBy(xpath = "//span[text()='Passer à la caisse' or text()='Checkout']/ancestor::button")
	WebElement checkOut;

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
	 * Port-in not supported Pop UP
	 * @author aditi.jain
	 */
	public void noPortInPopup() {
		getReusableActionsInstance().clickWhenReady(noPortInServices,30);
	}

	/**
	 * click Add To Cart for Smartstream
	 * @author aditi.jain
	 */
	public void clkAddtoCartISS(String planEn) {
		getReusableActionsInstance().getWhenReady(By.xpath("//span[text()='"+planEn+"']/parent::div/parent::div//span[text()='Add to cart']/ancestor::button"),120).sendKeys(Keys.ENTER);
	}

	/**
	 * Enter the address to search for service availability
	 * @param address is the Address to check for availability
	 * @param browser is the Browser to use
	 * @author chinnarao.vattam
	 */
	public void checkAvailability(String address,String browser) {
		getReusableActionsInstance().clickWhenReady(inputContainer,120);
		//getReusableActionsInstance().enterText(addressInput,address,60);
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
			getReusableActionsInstance().clickWhenReady(continueFor4K,120);
			}
	/**
	 * CLick Yes if 4K pop up Appears
	 * @author chinnarao.vattam
	 */	
	public void fourKTVPopup() {	
		getReusableActionsInstance().clickWhenReady(yesFor4K,120);
	}
	/**
	 * Click Checkout for channels Exchange
	 * @author chinnarao.vattam
	 */	
	public void clkCheckOut() {
		getReusableActionsInstance().waitForElementVisibility(checkOut, 60);
		getReusableActionsInstance().executeJavaScriptClick(checkOut);
	}
	/**
	 * Click Checkout for Cart Summary
	 * @author chinnarao.vattam
	 */	
	public void clkCheckOutforCartSummary() {
		getReusableActionsInstance().getWhenReady(checkOut,120).sendKeys(Keys.ENTER);
	}

	/**
	 * CLick Continue for four K
	 * @author aditi.jain
	 */
	public void fourKContinue() {
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
		getReusableActionsInstance().clickWhenReady(continueforCheckout,120);
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
		getReusableActionsInstance().waitForElementVisibility(internetCheckbox, 120);
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
		return getReusableActionsInstance().isElementVisible(monthFeesInCollapse,45);
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
		return getReusableActionsInstance().isElementVisible(cartSummaryHeader,45);
	}




}
