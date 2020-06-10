package com.rogers.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;

public class RogersIgniteTVProfileCreationPage extends BasePageClass {

	public RogersIgniteTVProfileCreationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h4[@translate='global.checkout.profile.createProfile']")
	WebElement txtProfile;
	
	@FindBy(xpath = "//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-bgcolor-errorField b-2 ds-brcolor-error']")
	WebElement txtContainerEmail;
	
		@FindBy(xpath = "//input[@id='ds-form-input-id-14']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='ds-form-input-id-15']")
	WebElement txtConfirmEmail;
	
	@FindBy(xpath = "//input[@id='ds-form-input-id-9']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='ds-form-input-id-10']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='ds-form-input-id-12']")
	WebElement btnPhone;
		
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
		//reusableActions.waitForElementInvisibility(popupLoadingFingers,100);
		return reusableActions.isElementVisible(txtProfile);
	}
	
	/**
	 * Set dynamic email and confirm email on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setEmail() {
		String strEmail = FormFiller.generateEmail();
		reusableActions.waitForElementVisibility(txtContainerEmail,120);
		reusableActions.getWhenReady(txtContainerEmail,3).click();
		reusableActions.getWhenReady(txtEmail, 180).clear();
		reusableActions.getWhenReady(txtEmail,10).sendKeys(strEmail);
		reusableActions.executeJavaScriptClick(txtConfirmEmail);
		reusableActions.getWhenReady(txtConfirmEmail, 10).clear();
		reusableActions.getWhenReady(txtConfirmEmail,3).sendKeys(strEmail);
	}

	/**
	 * Set dynamic first name on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setFirstname() {
		String strName = FormFiller.generateRandomName();
		reusableActions.executeJavaScriptClick(txtFirstName);
		reusableActions.getWhenReady(txtFirstName, 3).clear();
		reusableActions.getWhenReady(txtFirstName,3).sendKeys(strName);
	}

	/**
	 * Set dynamic last name on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setLastName() {
		String strName = FormFiller.generateRandomName();
		reusableActions.executeJavaScriptClick(txtLastName);
		reusableActions.getWhenReady(txtLastName, 3).clear();
		reusableActions.getWhenReady(txtLastName,3).sendKeys(strName);
	}

	/**
	 * Set dynamic phone number on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setPhone() {
		//String strPhoneNumber = FormFiller.generatePhoneNumber();
		String strPhoneNumber ="1010000062";
		reusableActions.executeJavaScriptClick(btnPhone);
		reusableActions.getWhenReady(btnPhone, 3).clear();
		reusableActions.getWhenReady(btnPhone,3).sendKeys(strPhoneNumber);
	}
	
	/**
	 * To click on the chevron on the TV profile creation page
	 * @author Saurav.Goyal
	 */
	public void clkChevronYourCart() {
		reusableActions.waitForElementVisibility(downChevronYourCart, 120);
		reusableActions.getWhenReady(downChevronYourCart, 120).click();
	}

	/**
	 * To verify gwp promotion in the profile creation page
	 * @return true if the promotion is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPYourCartPromotion() {
		reusableActions.waitForElementVisibility(gwpYourCart, 120);
		return	reusableActions.isElementVisible(gwpYourCart);
	}
	
	/**
	 * Click the Submit button on the profile page
	 * @author Chinnarao.Vattam
	 */
	public void clkSubmitProfile() {
		reusableActions.getWhenReady(btnProfielSubmit, 120).click();
	}

	/**
	 * To verify the abandon popup while leaving the flow 
	 * @return true if the abandon  popup has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyImportantInformation() {
		reusableActions.waitForElementVisibility(popImportantInformation, 120);
		return	reusableActions.isElementVisible(popImportantInformation);
	}
	
	/**
	 * Click I understand button on abandon popup
	 * @author chinnarao.vattam
	 */
	public void clkIUnderstand(){
		reusableActions.getWhenReady(btnIUnderstand, 120).click();
	}
	
	/**
	 * Click the Use Another Address radio button on the profile page
	 * @author Chinnarao.Vattam
	 */
	public void clkUseAnotherAddress() {
		reusableActions.getWhenReady(rdoUseAnotherAddress, 30).click();
	}

	/**
	 * Set the new address on the profile page
	 * @author Chinnarao.Vattam
	 * @param strAddress address string
	 */
	public void setNewAddress(String strAddress) {
		reusableActions.getWhenReady(txtAnotherAddress, 3).click();
		reusableActions.getWhenReady(txtAnotherAddress, 3).clear();
		reusableActions.getWhenReady(txtAnotherAddress, 3).sendKeys(strAddress);
		reusableActions.getWhenVisible(txtAnotherAddress, 10).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtAnotherAddress).sendKeys(Keys.ENTER);
	}
	
}
