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
	@FindBy(xpath = "//input[@id='email1']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='emailAlt1']")
	WebElement txtConfirmEmail;
	
	@FindBy(xpath = "//input[@id='firstName1']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='lastName1']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='phone1']")
	WebElement btnPhone;
		
	@FindBy(xpath = "//input[@class='ute-btn-primary profile-submit-button']")
	WebElement btnProfielSubmit;
	
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
	
	/**
	 * To verify the launch of Profile Page
	 * @return true if the email text box has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyProfilePage() {
		return reusableActions.isElementVisible(txtEmail);
	}
	
	/**
	 * Set dynamic email and confirm email on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setEmail() {
		String strEmail = FormFiller.generateEmail();
		reusableActions.getWhenReady(txtEmail, 60).clear();
		reusableActions.getWhenReady(txtEmail,10).sendKeys(strEmail);
		reusableActions.getWhenReady(txtConfirmEmail, 10).clear();
		reusableActions.getWhenReady(txtConfirmEmail,3).sendKeys(strEmail);
	}

	/**
	 * Set dynamic first name on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setFirstname() {
		String strName = FormFiller.generateRandomName();
		reusableActions.getWhenReady(txtFirstName, 3).clear();
		reusableActions.getWhenReady(txtFirstName,3).sendKeys(strName);
	}

	/**
	 * Set dynamic last name on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setLastName() {
		String strName = FormFiller.generateRandomName();
		reusableActions.getWhenReady(txtLastName, 3).clear();
		reusableActions.getWhenReady(txtLastName,3).sendKeys(strName);
	}

	/**
	 * Set dynamic phone number on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setPhone() {
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		reusableActions.getWhenReady(btnPhone, 3).clear();
		reusableActions.getWhenReady(btnPhone,3).sendKeys(strPhoneNumber);
	}
	
	/**
	 * Click the Submit button on the profile page
	 * @author Chinnarao.Vattam
	 */
	public void clkSubmitProfile() {
		reusableActions.clickWhenReady(btnProfielSubmit, 60);
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
