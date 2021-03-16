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

	@FindBy(xpath = "//h2[@translate='global.checkout.profile.createProfile']")
	WebElement txtSaiProfile;

	@FindBy(xpath = "//div[@class='text-semi mt-3 -f24 ng-star-inserted']")
	WebElement popupSessionModel;

	@FindBy(xpath = "//button[@ng-reflect-variant='primary']//span[@ng-reflect-klass='ds-button__copy text-button te']")
	WebElement btnContinueSession;
	
	@FindBy(xpath = "(//div[contains(@class,'ds-formField__inputContainer')])[1]")
	WebElement txtContainerEmail;
	
	@FindBy(xpath = "(//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white'])[2]")
	WebElement txtContainerConfirmEmail;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@name='confirmEmail']")
	WebElement txtConfirmEmail;
	
	@FindBy(xpath = "//input[contains(@id,'ds-form-input-id-') and @ng-reflect-a11y-description='Please enter your First Name.']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[contains(@id,'ds-form-input-id-') and @ng-reflect-a11y-description='Please enter your Last Name.']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[contains(@id,'ds-form-input-id-') and @ng-reflect-a11y-description='Please enter your phone number']")
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
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		//String strPhoneNumber ="1010000062";
		getReusableActionsInstance().executeJavaScriptClick(btnPhone);
		getReusableActionsInstance().getWhenReady(btnPhone, 3).clear();
		getReusableActionsInstance().getWhenReady(btnPhone,3).sendKeys(strPhoneNumber);
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
