package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;

public class RogersInternetProfilePage extends BasePageClass {

	public RogersInternetProfilePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h4[@translate='global.checkout.profile.createProfile']")
	WebElement txtProfile;

	@FindBy(xpath = "//h1[@translate='global.checkout.profile.createProfile']")
	WebElement txtSaiProfile;

	@FindBy(xpath = "//div[@class='text-semi mt-3 -f24 ng-star-inserted']")
	WebElement popupSessionModel;

	@FindBy(xpath = "//button[@ng-reflect-variant='primary']//span[@ng-reflect-klass='ds-button__copy text-button te']")
	WebElement btnContinueSession;
	
	@FindBy(xpath = "//input[@name='email']/..")
	WebElement txtContainerEmail;
	
	@FindBy(xpath = "//input[@name='confirmEmail']/..")
	WebElement txtContainerConfirmEmail;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@name='confirmEmail']")
	WebElement txtConfirmEmail;

	@FindAll({
			@FindBy(xpath = "//span[@translate='global.checkout.profile.firstNameHeader']/parent::div/descendant::ds-form-field[@rchapiexposer='customerDetails.firstName']//input"),
			@FindBy(xpath = "//input[contains(@id,'ds-form-input-id-') and @ng-reflect-a11y-description='Please enter your First Name.']")})
	WebElement txtFirstName;

	@FindAll({
			@FindBy(xpath = "//span[@translate='global.checkout.profile.lastNameHeader']/parent::div/descendant::ds-form-field[@rchapiexposer='customerDetails.firstName']//input"),
			@FindBy(xpath = "//input[contains(@id,'ds-form-input-id-') and @ng-reflect-a11y-description='Please enter your Last Name.']")})
	WebElement txtLastName;

	@FindAll({
			@FindBy(xpath = "//span[@translate='global.checkout.profile.phoneHeader']//parent::div/following-sibling::div//input"),
			@FindBy(xpath = "//input[contains(@id,'ds-form-input-id-') and contains(@ng-reflect-a11y-description,'Please enter your phone number')]")})
	WebElement btnPhone;
		
	@FindBy(xpath = "//span[@translate='global.cta.continue']")
	WebElement btnProfielSubmit;	
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;

	@FindBy(xpath = "//i[contains(@class,'li-loader')]")
	WebElement popupLoadingFingersPackage;

	
	/**
	 * To verify the launch of Profile Page
	 * @return true if the email text box has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyProfilePage() {
		getReusableActionsInstance().waitForElementVisibility(txtProfile,60);
		return getReusableActionsInstance().isElementVisible(txtProfile);
	}

	/**
	 * To verify the launch of Profile Page
	 * @return true if the email text box has available, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyProfilePageSAI() {
		//getReusableActionsInstance().waitForElementInvisibility(popupLoadingFingersPackage,60);
		getReusableActionsInstance().staticWait(6000);
		getReusableActionsInstance().waitForElementVisibility(txtSaiProfile,90);
		return getReusableActionsInstance().isElementVisible(txtSaiProfile);
	}

	/**
	 * To verify the Session expiry Model
	 * @return true if the Session expiry Model has available, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifySessionModel() {
		//Session expiry time  2 minutes
		getReusableActionsInstance().staticWait(120000);
		return getReusableActionsInstance().isElementVisible(popupSessionModel,60);
	}

	/**
	 * Click the Continue button on the profile page
	 * @author Chinnarao.Vattam
	 */
	public void clkContinue() {
		getReusableActionsInstance().getWhenReady(btnContinueSession, 20).click();
	}


	/**
	 * Set dynamic email and confirm email on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setEmail() {
		String strEmail = FormFiller.generateEmail();
		getReusableActionsInstance().waitForElementVisibility(txtContainerEmail,20);
		getReusableActionsInstance().getWhenReady(txtContainerEmail,10).click();
		getReusableActionsInstance().getWhenReady(txtEmail, 30).clear();
		getReusableActionsInstance().getWhenReady(txtEmail,10).sendKeys(strEmail);
		getReusableActionsInstance().executeJavaScriptClick(txtConfirmEmail);
		getReusableActionsInstance().getWhenReady(txtConfirmEmail, 10).clear();
		getReusableActionsInstance().getWhenReady(txtConfirmEmail,3).sendKeys(strEmail);
	}
	/**
	 * Set dynamic email and confirm email on profile page
	 * @author manpreet.kaur3
	 */
	public void setEmailMobile() {
		String strEmail = FormFiller.generateEmail();
		getReusableActionsInstance().waitForElementVisibility(txtContainerEmail,20);
		getReusableActionsInstance().executeJavaScriptClick(txtContainerEmail);
		getReusableActionsInstance().getWhenReady(txtEmail, 30).clear();
		getReusableActionsInstance().getWhenReady(txtEmail,10).sendKeys(strEmail);
		getReusableActionsInstance().executeJavaScriptClick(txtContainerConfirmEmail);
		getReusableActionsInstance().getWhenReady(txtConfirmEmail, 10).clear();
		getReusableActionsInstance().getWhenReady(txtConfirmEmail,3).sendKeys(strEmail);
	}

	/**
	 * Set dynamic first name on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setFirstname() {
		String strName = FormFiller.generateRandomName();
		getReusableActionsInstance().executeJavaScriptClick(txtFirstName);
		getReusableActionsInstance().getWhenReady(txtFirstName, 3).clear();
		getReusableActionsInstance().getWhenReady(txtFirstName,3).sendKeys(strName);
	}

	/**
	 * Set dynamic last name on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setLastName() {
		String strName = FormFiller.generateRandomName();
		getReusableActionsInstance().executeJavaScriptClick(txtLastName);
		getReusableActionsInstance().getWhenReady(txtLastName, 3).clear();
		getReusableActionsInstance().getWhenReady(txtLastName,3).sendKeys(strName);
	}

	/**
	 * Set dynamic phone number on profile page
	 * @author Chinnarao.Vattam
	 */
	public void setPhone() {
		String strPhoneNumber = "1010000067";
		getReusableActionsInstance().executeJavaScriptClick(btnPhone);
		getReusableActionsInstance().getWhenReady(btnPhone, 3).clear();
		getReusableActionsInstance().getWhenReady(btnPhone,3).sendKeys(strPhoneNumber);
	}

	public boolean chkIfPhoneNumberExists() {
		return btnPhone.getAttribute("value").isEmpty();
	}
	
	/**
	 * Click the Submit button on the profile page
	 * @author Chinnarao.Vattam
	 */
	public void clkSubmitProfile() {
		getReusableActionsInstance().getWhenReady(btnProfielSubmit, 60).click();
	}

	/**
	 * Click the Submit button on the profile page
	 * @author Chinnarao.Vattam
	 */
	public void clkSubmitProfileMobile() {
		getReusableActionsInstance().waitForElementVisibility(btnProfielSubmit, 90);
		getReusableActionsInstance().executeJavaScriptClick(btnProfielSubmit);
	}

}
