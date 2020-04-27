package com.rogers.oneview.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

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
	
	@FindBy(xpath = "//div[@ng-reflect-klass='ds-formField__inputContainer d']")
	WebElement inputContainer;
	
	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement continueButton;
	
	@FindBy(xpath = "//div[text()='This address is serviceable!' or text()='Cette adresse peut être desservie!']")
	WebElement serviceavailableMessage;
	
	@FindBy(xpath = "//div[contains(text(),'TV')]/ancestor::label")
	WebElement tvCheckbox;
	
	@FindBy(xpath = "//div[contains(text(),'Internet')]/ancestor::label")
	WebElement internetCheckbox;
	
	@FindBy(xpath = "//div[contains(text(),'Home Phone')]/ancestor::label")
	WebElement homePhoneCheckbox;
	
	@FindBy(xpath = "//div[text()='Rogers Ignite Flex 5']/parent::div/parent::div//span[text()='Ajouter au panier' or text()='Add to cart']/ancestor::button")
	WebElement addToCart;
	
	@FindBy(xpath = "//span[text()='No, continue' or text()='Non, continuer']/ancestor::button")
	WebElement noPortin;
	
	@FindBy(xpath = "//span[text()='Retirer' or text()='Remove']/ancestor::button")
	WebElement remove;
	
	@FindBy(xpath = "//span[text()='Yes, they do' or text()='Oui, il en a un']/ancestor::button")
	WebElement yesFor4K;
	
	@FindBy(xpath = "//p[text()='The following 4K content is available to the customer:']/parent::div//span[text()='Continuer' or text()='Continue']/ancestor::button")
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
	/**
	 * Enter the address to search for service availability
	 * @param address is the Address to check for availability
	 * @param browser is the Browser to use
	 * @author Harpartap.Virk
	 */
	public void checkAvailability(String address,String browser) {
		reusableActions.clickWhenReady(inputContainer,120);
		//reusableActions.enterText(addressInput,address,60);
		if(browser.equals("chrome")) {
			reusableActions.enterText(addressInput,address+Keys.BACK_SPACE,120);
			reusableActions.staticWait(8000);
		}
		else {
			reusableActions.enterText(addressInput,address,120);
			reusableActions.staticWait(3000);
			}
		reusableActions.clickAndHoldFor(searchResult, 333);//.clickWhenReady(searchResult);
		reusableActions.staticWait(3000);
		reusableActions.clickWhenReady(checkAvailabilitybtn);
		reusableActions.clickIfAvailable(continueButton);
		
	}
	/**
	 * Verify the service availability message
	 * @return true if service available, else false
	 * @author Harpartap.Virk
	 */	
	public boolean verifyServiceAvailabilityMessage() {	
		return reusableActions.isElementVisible(serviceavailableMessage,120);
	}
	/**
	 * Click Continue Button after Address availability
	 * @author Harpartap.Virk
	 */	
	public void clkContinue() {	
		reusableActions.clickWhenReady(continueButton,120);
	}
	/**
	 * Port-in not supported Pop UP
	 * @author Harpartap.Virk
	 */	
	public void portInPopup() {	
		reusableActions.clickWhenReady(noPortin,120);
	}	
	/**
	 * Click Add to Cart for Selected Product
	 * @param planEn is the Plam Name in English
	 * @param planFr is the Plam Name in French
	 * @author Harpartap.Virk
	 */	
	public void clkAddtoCart(String planEn,String planFr) {
		//reusableActions.javascriptScrollByVisibleElement(reusableActions.getWhenReady(By.xpath("//div[text()='"+planEn+"' or text()='"+planFr+"']")));
		reusableActions.getWhenReady(By.xpath("//div[text()='"+planEn+"' or text()='"+planFr+"']/parent::div/parent::div//span[text()='Ajouter au panier' or text()='Add to cart']/ancestor::button"),120).sendKeys(Keys.ENTER);
	}
	/**
	 * Click Opt out for Home Phone
	 * @param planEn is the Plam Name in English
	 * @param planFr is the Plam Name in French
	 * @author Harpartap.Virk
	 */	
	public void selectOptout(String planEn,String planFr) {
		//reusableActions.javascriptScrollByVisibleElement(reusableActions.getWhenReady(By.xpath("//div[text()='"+planEn+"' or text()='"+planFr+"']")));
		WebElement btn=reusableActions.getWhenReady(By.xpath("//div[text()='"+planEn+"' or text()='"+planFr+"']/parent::div/parent::div//label[text()='Se désinscrire' or text()='Opt out']"),120);
		reusableActions.javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		btn.click();
	}
	/**
	 * Verify the Product is Added to Cart
	 * @return true if Product is added, else false
	 * @author Harpartap.Virk
	 */	
	public boolean verifyProductinCart() {	
		if(reusableActions.isElementVisible(remove,120)) {
			reusableActions.javascriptScrollByVisibleElement(remove);	
			return true;
		}else
		return false;
	}
	/**
	 * CLick Continue for 4K content pop up
	 * @author Harpartap.Virk
	 */	
	public void fourKContentPopup() {	
			reusableActions.clickWhenReady(continueFor4K,120);	
			}
	/**
	 * CLick Yes if 4K pop up Appears
	 * @author Harpartap.Virk
	 */	
	public void fourKTVPopup() {	
		reusableActions.clickWhenReady(yesFor4K,120);
	}
	/**
	 * Click Checkout for channels Exchange
	 * @author Harpartap.Virk
	 */	
	public void clkCheckOut() {
		reusableActions.clickWhenReady(checkOut,120);
		//reusableActions.clickIfAvailable(checkOut,45);
		//reusableActions.clickIfAvailable(continueforCheckout,45);
	}
	/**
	 * Click Checkout for Cart Summary
	 * @author Harpartap.Virk
	 */	
	public void clkCheckOutforCartSummary() {
		reusableActions.getWhenReady(checkOut,120).sendKeys(Keys.ENTER);
		//reusableActions.clickIfAvailable(checkOut,45);
		//reusableActions.clickIfAvailable(continueforCheckout,45);
	}
	/**
	 * Customer Wish to Continue Popup
	 * @author Harpartap.Virk
	 */	
	public void customerWishtoContinue() {
		reusableActions.clickWhenReady(continueforCheckout,120);
	}
	/**
	 * Click Collapse(Down Arrow)
	 * @author Harpartap.Virk
	 */	
	public void clkCollapse() {
		reusableActions.clickIfAvailable(collapse,45);
	}
	/**
	 * Click TV checkbox
	 * @author Harpartap.Virk
	 */	
	public void clkTVCheckbox() {
		reusableActions.clickWhenReady(tvCheckbox,120);
	}
	/**
	 * Click Internet checkbox
	 * @author Harpartap.Virk
	 */	
	public void clkInternetCheckbox() {
		reusableActions.clickWhenReady(internetCheckbox,120);
	}
	/**
	 * Click Home Phone checkbox
	 * @author Harpartap.Virk
	 */	
	public void clkHomePhoneCheckbox() {
		reusableActions.clickWhenReady(homePhoneCheckbox,120);
	}	
	/**
	 * Click Exchange Later btn
	 * @author Harpartap.Virk
	 */	
	public void clkexchangeLater() {
		reusableActions.clickWhenReady(exchangeLaterbtn,120);
	}	
	/**
	 * Click Show Offers button
	 * @author Harpartap.Virk
	 */	
	public void clkShowOffers() {
		reusableActions.clickWhenReady(showOffers,120);
	}	
	/**
	 * Click Internet to Expand in Points to Mention
	 * @author Harpartap.Virk
	 */	
	public void expandInternetdiv() {
		reusableActions.clickWhenReady(pointsToMentionInternet,120);
	}	
	/**
	 * Click Home Phone to Expand in Points to Mention
	 * @author Harpartap.Virk
	 */	
	public void expandHomePhonediv() {
		reusableActions.clickWhenReady(pointsToMentionHomePhone,120);
	}	
	/**
	 * Click Battery Back-Up to Expand in Points to Mention
	 * @author Harpartap.Virk
	 */	
	public void expandBatteryBackUpdiv() {
		reusableActions.clickWhenReady(pointsToMentionBatteryBackup,120);
	}	
	/**
	 * Select check box for points to mention rev
	 * @author Harpartap.Virk
	 */	
	public void selectchkboxpointsToMentionReviewed() {
		reusableActions.clickWhenReady(chkboxpointsToMentionReview,120);
	}	
/**
 * Click Use this Address
 * @author harpartap.virk
 */
public void clkUsethisAddress() {
		//reusableActions.javascriptScrollByVisibleElement(btnGetIgniteTVBadge);
		reusableActions.getWhenReady(btnUsethisaddress, 120).click();	
	}
/**
 * Verify the check Availability pop up appears
 * @return true if Pop up appears, else false
 * @author Harpartap.Virk
 */	
public boolean verifyCheckAvailabilityPopUp() {	
	return reusableActions.isElementVisible(btnUsethisaddress,120);
		
}
/**
 * Verify the Home Phone Setup pop up appears
 * @return true if Pop up appears, else false
 * @author Harpartap.Virk
 */	
public boolean verifyHomePhoneSetupPopUp() {	
	return reusableActions.isElementVisible(btnKeepNumber,120);
		
}
/**
 * Click Yes, Keep Number
 * @author harpartap.virk
 */
public void clkKeepNumberbtn() {
		//reusableActions.javascriptScrollByVisibleElement(btnGetIgniteTVBadge);
		reusableActions.getWhenReady(btnKeepNumber, 120).click();	
	}
/**
 * Click No, Choose new Number
 * @author harpartap.virk
 */
public void clkChooseNewNumberbtn() {
		//reusableActions.javascriptScrollByVisibleElement(btnGetIgniteTVBadge);
		reusableActions.getWhenReady(chooseNewNumber, 120).click();	
	}
/**
 * Click Customer Add-On review
 * @author harpartap.virk
 */
public void clkCustomerAddonReview() {
		//reusableActions.javascriptScrollByVisibleElement(btnGetIgniteTVBadge);
		reusableActions.getWhenReady(customerAddonReveiwLink,120).click();	
	}
/**
 * Click yes for Verify Home Phone Later
 * @author Harpartap.Virk
 */	
public void activateHomePhoneltrPopUp() {	
	reusableActions.getWhenReady(yesBtn,120).click();	
		
}
}
