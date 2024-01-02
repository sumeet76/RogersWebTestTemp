package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePhoneSelectionPage  extends BasePageClass {

	public HomePhoneSelectionPage(WebDriver driver) {
		super(driver);
	}

//	@FindBy(xpath = "//span[contains(text(),'Cancel') or contains(text(),'Annuler')]//following::button//child::span[contains(text(),'Continue') or contains(text(),'Continuer')]")

	@FindBy(xpath = "//span[@translate='global.cta.cancel']/following::span[@translate='global.cta.continue']")
	WebElement continueOnGeneratePhone;

	//@FindBy(xpath = "(//span[@translate='global.cta.continue'])/ancestor::button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large']")
	@FindBy(xpath = "(//span[@translate='global.cta.continue'])[3]")
	WebElement continueOnCallDisplayName;

	@FindBy(xpath = "(//span[@translate='global.cta.continue'])[3]")
	WebElement continueOnDirectoryListing;

	@FindBy(xpath = "//span[@class='ng-star-inserted' and contains(text(),'Générer les numéros de téléphone') or contains(text(),'Generate phone numbers')]")
	WebElement generatePhoneNumber;

	@FindBy(xpath = "//div[@class='button-set']/descendant::span[@translate='global.cta.continue']")
	WebElement finalcontinueOnGeneratePhone;

	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button[@ng-reflect-disabled='false']")
	WebElement continueButton;

	@FindBy(xpath = "//input[@placeholder='Enter the desired digits here' or @placeholder='Entrez les chiffres voulus ici']/parent::div")
	WebElement phoneNoInput;

	@FindBy(xpath = "//input[@ng-reflect-name='cIdFirstName']")
	WebElement cIDfirstName;

	@FindBy(xpath = "//input[@ng-reflect-name='cIdFirstName']/parent::div")
	WebElement cIDfirstNameInputBox;

	@FindBy(xpath = "//input[@ng-reflect-name='cIdLastName']")
	WebElement cIDlastName;

	@FindBy(xpath = "//input[@ng-reflect-name='cIdLastName']/parent::div")
	WebElement cIDlastNameInputBox;

	@FindBy(xpath = "//input[@ng-reflect-name='dlFirstName']")
	WebElement dlfirstName;

	@FindBy(xpath = "//input[@ng-reflect-name='dlFirstName']/parent::div")
	WebElement dlfirstNameInputBox;

	@FindBy(xpath = "//input[@ng-reflect-name='dlLastName']")
	WebElement dllastName;

	@FindBy(xpath = "//input[@ng-reflect-name='dlLastName']/parent::div")
	WebElement dllastNameInputBox;

	@FindBy(xpath = "//span[text()='Update Caller ID']/ancestor::button")
	WebElement updateCIDbtn;

	@FindBy(xpath = "//span[text()='Update Directory Listing']/ancestor::button")
	WebElement updateDirectoryListingbtn;

	//@FindBy(xpath = "//ul[@class='number-select-list']/li[1]")
	@FindBy(xpath = "//*[@id='ds-radio-input-id-5-label']")
	WebElement selectedPhoneNo;

	@FindBy(xpath = "//li[contains(text(),'You may use ampersands, hyphens and spaces but not at the beginning or end of a name')] or //li[contains(text(),'Vous pouvez utiliser des perluètes, des traits d’union et des espaces, mais pas au début ni à la fin d’un nom')]")
	WebElement thingsToKnowFirstName;

	@FindBy(xpath = "//li[contains(text(),'You may use hyphens, apostrophes and spaces but not at the beginning or end of a name')]  or //li[contains(text(),'Vous pouvez utiliser des traits d’union, des apostrophes et des espaces, mais pas au début ni à la fin d’un nom')]")
	WebElement thingsToKnowLastName;

	@FindBy(xpath = "//div/h1[@class='mb-0 ng-star-inserted' and contains(text(),' Review Call Display Name and Directory Listing ')]")
	WebElement callDisplayNameAndDiretoryListingHeader;

	@FindBy(xpath = "//span[text()='Home Phone Personalization' or text()='Personnalisation du téléphone résidentiel']")
	WebElement homePhonePersonalizationHeader;

	@FindBy(xpath = "//*[@id='ds-radio-input-id-78-label']")
	WebElement selectDifferentNumber;


	/**
	 * Click Generate Phone Number Button  
	 * @author chinnarao.vattam
	 */	
	public void clkGeneratePhoneNo() {
		getReusableActionsInstance().waitForElementVisibility(homePhonePersonalizationHeader, 120);
		getReusableActionsInstance().staticWait(5000);
		WebElement btn=getReusableActionsInstance().getWhenReady(generatePhoneNumber,120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().executeJavaScriptClick(generatePhoneNumber);

	}
	/**
	 * Verify the Phone Number is Selected
	 * @return true if Phone Number is selected, else false
	 * @author chinnarao.vattam
	 */	
	public boolean verifyNumber() {	
		return getReusableActionsInstance().isElementVisible(continueButton);
	}
	/**
	 * Click Continue Button  
	 * @author chinnarao.vattam
	 */	
	public void clkContinue() {
		getReusableActionsInstance().waitForElementVisibility(finalcontinueOnGeneratePhone,45);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().executeJavaScriptClick(finalcontinueOnGeneratePhone);
//		getReusableActionsInstance().clickWhenReady(finalcontinueOnGeneratePhone,120);
	}
	
	
	/**
	 * Click Update Caller ID Button  
	 * @author chinnarao.vattam
	 */	
	public void clkUpdateDirectoryListing() {
		getReusableActionsInstance().getWhenReady(updateDirectoryListingbtn,60).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Verify the Phone Number is Selected
	 * @return true if Phone Number is selected, else false
	 * @author chinnarao.vattam
	 */	
	public boolean verifySelectedNumber() {	
		WebElement btn=getReusableActionsInstance().getWhenReady(selectedPhoneNo,120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		return getReusableActionsInstance().isElementVisible(selectedPhoneNo);
	}

	/**
	 * Click Continue Button after Credit Information Entered
	 * @author chinnarao.vattam
	 */
	public void clkContinueOnGeneratePhone() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().waitForElementVisibility(continueOnGeneratePhone,45);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().waitForPageLoad();
		getReusableActionsInstance().executeJavaScriptClick(continueOnGeneratePhone);


	}

	public void clickOnContinueCallDisplay(){
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().javascriptScrollByVisibleElement(continueOnCallDisplayName);
		getReusableActionsInstance().clickWhenReady(continueOnCallDisplayName);
	}
	public void clickContinueDirectoryListing(){
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().executeJavaScriptClick(continueOnDirectoryListing);

	}

	public boolean verifythingsToKnowFirstname(){
		getReusableActionsInstance().staticWait(5000);
		 return getReusableActionsInstance().isElementVisible(thingsToKnowFirstName,60);
	}

	public boolean verifyThingsToKnowLastName(){
		return getReusableActionsInstance().isElementVisible(thingsToKnowLastName);
	}

	public boolean verifyConfigureCallDisplayAndDirectoryListingHeader() {
		return getReusableActionsInstance().isElementVisible(callDisplayNameAndDiretoryListingHeader, 45);
	}

	public boolean verifyHomePhonePersonalizationHeader () {
		return getReusableActionsInstance().isElementVisible(homePhonePersonalizationHeader, 120);

	}
	public void selectDiffNumb(){
		getReusableActionsInstance().getWhenReady(selectDifferentNumber,30);
		getReusableActionsInstance().executeJavaScriptClick(selectDifferentNumber);
	}


}
