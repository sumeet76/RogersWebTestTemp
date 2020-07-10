package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;

public class RogersInternetProfilePage extends BasePageClass {

	public RogersInternetProfilePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h4[@translate='global.checkout.profile.createProfile']")
	WebElement txtProfile;
	
	@FindBy(xpath = "//ds-form-field[contains(@class,'ds-formField ng-tns-c3-31')]//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white']")
	WebElement txtContainerEmail;
	
	@FindBy(xpath = "//ds-form-field[contains(@class,'ds-formField ng-tns-c3-32')]//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white']")
	WebElement txtContainerConfirmEmail;
	
		@FindBy(xpath = "//input[@id='ds-form-input-id-9']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='ds-form-input-id-10']")
	WebElement txtConfirmEmail;
	
	@FindBy(xpath = "//input[@id='ds-form-input-id-4']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='ds-form-input-id-5']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='ds-form-input-id-7']")
	WebElement btnPhone;
		
	@FindBy(xpath = "//span[@translate='global.cta.continue']")
	WebElement btnProfielSubmit;	
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	/**
	 * To verify the launch of Profile Page
	 * @return true if the email text box has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyProfilePage() {
		return reusableActions.isElementVisible(txtProfile);
	}
	
		/**
	 * Set dynamic email and confirm email on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setEmail() {
		String strEmail = FormFiller.generateEmail();
		reusableActions.waitForElementVisibility(txtContainerEmail,180);
		reusableActions.getWhenReady(txtContainerEmail,10).click();
		reusableActions.getWhenReady(txtEmail, 30).clear();
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
	 * Click the Submit button on the profile page
	 * @author Chinnarao.Vattam
	 */
	public void clkSubmitProfile() {
		reusableActions.getWhenReady(btnProfielSubmit, 120).click();
	}
	
	/**
	 * Click the Submit button on the profile page
	 * @author Chinnarao.Vattam
	 */
	public void clkSubmitProfileMobile() {
		reusableActions.waitForElementVisibility(btnProfielSubmit, 120);
		reusableActions.executeJavaScriptClick(btnProfielSubmit);
	}

}
