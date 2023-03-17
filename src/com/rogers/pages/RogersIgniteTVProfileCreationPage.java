package com.rogers.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;
public class RogersIgniteTVProfileCreationPage extends BasePageClass {


	public RogersIgniteTVProfileCreationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h1[@translate='global.checkout.profile.createProfile']")
	WebElement txtProfile;
	
	@FindBy(xpath = "//input[@name='email']/ancestor::div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txtContainerEmail;

	@FindBy(xpath = "//input[@name='confirmEmail']/ancestor::div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txtContainerConfirmEmail;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement txtEmail;
		
	@FindBy(xpath = "//input[@name='confirmEmail']")
	WebElement txtConfirmEmail;

	@FindAll({
	//@FindBy(xpath = "//input[contains(@a11ydescription,'First Name')]"),
	//@FindBy(xpath = "//input[contains(@ng-reflect-a11y-description,'First Name')]"),
	@FindBy(xpath = "//span[@translate='global.checkout.profile.firstNameHeader']/parent::div/descendant::ds-form-field[@rchapiexposer='customerDetails.firstName']//input")

	})
	WebElement txtFirstName;

	@FindAll({
	//@FindBy(xpath = "//input[contains(@a11ydescription,'Last Name')]"),
	//@FindBy(xpath = "//input[contains(@ng-reflect-a11y-description,'Last Name')]"),
	@FindBy(xpath = "//span[@translate='global.checkout.profile.lastNameHeader']/parent::div/descendant::ds-form-field[@rchapiexposer='customerDetails.firstName']//input")
	})
	WebElement txtLastName;

	@FindAll({
	//@FindBy(xpath = "//input[contains(@a11ydescription,'your phone number')]"),
	@FindBy(xpath = "//input[contains(@ng-reflect-a11y-description,'your phone number')]"),
	@FindBy(xpath = "//span[@translate='global.checkout.profile.phoneHeader']//parent::div/following-sibling::div//input")
	})
	WebElement btnPhone;

	@FindBy(xpath = "//span[@translate='global.cta.cancel']")
	WebElement btnProfielSubmitCancel;

	@FindBy(xpath = "//span[@translate='global.cta.continue']")
	WebElement btnProfielSubmit;	
	//input[@class='ute-btn-primary profile-submit-button']
	//button[@class='ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -primary -large']
	
	@FindBy(xpath = "//label[@class='ute-label-text anotherAddress']")
	WebElement rdoUseAnotherAddress;
	
	@FindBy(xpath = "//span[@translate='global.modals.migrationModal.title']")
	WebElement popImportantInformation;
	
	@FindBy(xpath = "//button[@class='ute-btn-primary']")
	WebElement btnIUnderstand;	
	
	@FindBy(xpath = "//input[@name='anotherBillingAddress']")
	WebElement txtAnotherAddress;
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//button[@data-target='#miniCollapse']")
	WebElement downChevronYourCart;
	
	@FindBy(xpath = "//div[@class='mini-body']//div[contains(@ng-bind-html,'$root.gwpDetails')]")
	WebElement gwpYourCart;
	
	/**
	 * To verify the launch of Profile Page
	 * @return true if the email text box has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyProfilePage() {
		return getReusableActionsInstance().isElementVisible(txtProfile,90);
	}
	
	/**
	 * Set dynamic email and confirm email on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setEmailMobile() {
		String strEmail = FormFiller.generateEmail();
		getReusableActionsInstance().waitForElementVisibility(txtContainerEmail,20);
		getReusableActionsInstance().executeJavaScriptClick(txtContainerEmail);
		getReusableActionsInstance().getWhenReady(txtEmail, 30).clear();
		getReusableActionsInstance().getWhenReady(txtEmail,10).sendKeys(strEmail);
		getReusableActionsInstance().executeJavaScriptClick(txtConfirmEmail);
		getReusableActionsInstance().getWhenReady(txtConfirmEmail, 10).clear();
		getReusableActionsInstance().getWhenReady(txtConfirmEmail,3).sendKeys(strEmail);
	}

	/**
	 * Set dynamic email and confirm email on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setEmail() {
		String strEmail = FormFiller.generateEmail();
		getReusableActionsInstance().waitForElementVisibility(txtContainerEmail, 20);
		getReusableActionsInstance().getWhenReady(txtContainerEmail, 10).click();
		getReusableActionsInstance().getWhenReady(txtEmail, 30).clear();
		getReusableActionsInstance().getWhenReady(txtEmail, 10).sendKeys(strEmail);
		getReusableActionsInstance().executeJavaScriptClick(txtConfirmEmail);
		getReusableActionsInstance().getWhenReady(txtConfirmEmail, 10).clear();
		getReusableActionsInstance().getWhenReady(txtConfirmEmail, 3).sendKeys(strEmail);
	}
	/**
	 * Set dynamic email and confirm email on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setEmail(String strEmail) {
		getReusableActionsInstance().waitForElementVisibility(txtContainerEmail, 90);
		getReusableActionsInstance().getWhenReady(txtContainerEmail, 10).click();
		getReusableActionsInstance().clickWhenReady(txtEmail);
		txtEmail.clear();
		txtEmail.sendKeys(strEmail);
		getReusableActionsInstance().executeJavaScriptClick(txtConfirmEmail);
		txtConfirmEmail.clear();
		txtConfirmEmail.sendKeys(strEmail);

	}
	/**
	 * Set dynamic first name on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setFirstname() {
		String strName = FormFiller.generateRandomName();
		getReusableActionsInstance().executeJavaScriptClick(txtFirstName);
		txtFirstName.clear();
		txtFirstName.sendKeys(strName);
	}

	/**
	 * Set dynamic first name on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setFirstname(String strName) {
		getReusableActionsInstance().executeJavaScriptClick(txtFirstName);
		txtFirstName.clear();
		txtFirstName.sendKeys(strName);
	}

	/**
	 * Set dynamic last name on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setLastName(String strName) {
		getReusableActionsInstance().executeJavaScriptClick(txtLastName);
		txtLastName.clear();
		txtLastName.sendKeys(strName);
	}

	/**
	 * Set dynamic last name on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setLastName() {
		String strName = FormFiller.generateRandomName();
		getReusableActionsInstance().executeJavaScriptClick(txtLastName);
		txtLastName.clear();
		txtLastName.sendKeys(strName);
	}

	/**
	 * Set dynamic phone number on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setPhone() {
		getReusableActionsInstance().executeJavaScriptClick(btnPhone);
		btnPhone.clear();
		//String strPhoneNumber = FormFiller.generatePhoneNumber();
		String strPhoneNumber ="1010000061";
		btnPhone.sendKeys(strPhoneNumber);
	}

	/**
	 * Set dynamic phone number on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setPhone(String strPhoneNumber) {
		getReusableActionsInstance().executeJavaScriptClick(btnPhone);
		btnPhone.clear();
		btnPhone.sendKeys(strPhoneNumber);
	}

	/**
	 * To click on the chevron on the TV profile creation page
	 * @author Saurav.Goyal
	 */
	public void clkChevronYourCart() {
		getReusableActionsInstance().waitForElementVisibility(downChevronYourCart, 120);
		getReusableActionsInstance().getWhenReady(downChevronYourCart, 120).click();
	}

	/**
	 * To verify gwp promotion in the profile creation page
	 * @return true if the promotion is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPYourCartPromotion() {
		getReusableActionsInstance().waitForElementVisibility(gwpYourCart, 120);
		return	getReusableActionsInstance().isElementVisible(gwpYourCart);
	}
	
	/**
	 * Click the Submit button on the profile page
	 * @author Chinnarao.Vattam
	 */
	public void clkSubmitProfile() {
		getReusableActionsInstance().getWhenReady(btnProfielSubmit, 60);
		getReusableActionsInstance().executeJavaScriptClick(btnProfielSubmit);
	}

	/**
	 * Click the Submit button on the profile page
	 * @author Chinnarao.Vattam
	 */
	public void clkSubmitCancel() {
		getReusableActionsInstance().getWhenReady(btnProfielSubmitCancel, 60);
		getReusableActionsInstance().executeJavaScriptClick(btnProfielSubmitCancel);
	}

	/**
	 * Click the Submit button on the profile page
	 * @author Chinnarao.Vattam
	 */
	public void clkSubmitProfileMobile() {
		getReusableActionsInstance().waitForElementVisibility(btnProfielSubmit, 120);
		getReusableActionsInstance().executeJavaScriptClick(btnProfielSubmit);
	}

	/**
	 * To verify the abandon popup while leaving the flow 
	 * @return true if the abandon  popup has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyImportantInformation() {
		getReusableActionsInstance().waitForElementVisibility(popImportantInformation, 120);
		return	getReusableActionsInstance().isElementVisible(popImportantInformation);
	}
	
	/**
	 * Click I understand button on abandon popup
	 * @author chinnarao.vattam
	 */
	public void clkIUnderstand(){
		getReusableActionsInstance().getWhenReady(btnIUnderstand, 120).click();
	}
	
	/**
	 * Click the Use Another Address radio button on the profile page
	 * @author Chinnarao.Vattam
	 */
	public void clkUseAnotherAddress() {
		getReusableActionsInstance().getWhenReady(rdoUseAnotherAddress, 30).click();
	}

	/**
	 * Set the new address on the profile page
	 * @author Chinnarao.Vattam
	 * @param strAddress address string
	 */
	public void setNewAddress(String strAddress) {
		getReusableActionsInstance().getWhenReady(txtAnotherAddress, 3).click();
		getReusableActionsInstance().getWhenReady(txtAnotherAddress, 3).clear();
		getReusableActionsInstance().getWhenReady(txtAnotherAddress, 3).sendKeys(strAddress);
		getReusableActionsInstance().getWhenVisible(txtAnotherAddress, 10).sendKeys(Keys.ARROW_DOWN);
		getReusableActionsInstance().getWhenVisible(txtAnotherAddress).sendKeys(Keys.ENTER);
	}
	
}
