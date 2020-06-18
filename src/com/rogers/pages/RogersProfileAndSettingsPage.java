package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersProfileAndSettingsPage extends BasePageClass {
	
	
	public RogersProfileAndSettingsPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy (xpath = "//rss-sms-recovery//button")
	WebElement lnkSetupRecoveryNum;
	
	@FindBy (xpath = "//iframe[@src='/web/totes/easylogin/sms/input']")
	WebElement iframeSmsRecovery;
	
	@FindBy (xpath = "//input[@formcontrolname='phoneNumber']")
	WebElement inputPhoneNumber;
	
	@FindAll({
		@FindBy (xpath = "//button[text()=' Continue ' or text()=' Continuer ']"),
		@FindBy (xpath = "//button[@class='primary-button state-btn state-btn-active']")	
	})		
	WebElement btnContinue;	
	
	@FindBy (xpath = "//input[@formcontrolname='smsPin']")
	WebElement inputSmsPin;
	
	@FindBy (xpath = "//button[@class='primary-button state-btn state-btn-active']")
	WebElement btnVerifyMe;
	
	@FindBy (xpath = "//button[contains(text(),'Continue to MyRogers') or contains(text(),'Continuer dans MonRogers')]")
	WebElement btnContinueToMyRogers;
	
	@FindBy (xpath = "//div[@class='link-account ds-color-link']")
	WebElement lnkLinkAnotherAcct;
	
	@FindBy (xpath = "//div[@translate='linked_acc_success']")
	WebElement lblLinkAccountSuccess;
	
	@FindBy (xpath = "//div[@class='unlink-account-container']/button")
	WebElement lnkUnlinkThisAcct;
	
	@FindBy (xpath = "//rss-unlink-account//span[text()=' Unlink this account ' or text()=' Dissocier ce compte ']")
	WebElement btnUnlinkThisAcct;

	@FindBy (xpath = "//span[contains(text(),'Done') or contains(text(),'Termin')]") 
	WebElement btnUnlinkDone;
	
	@FindAll({
		@FindBy (xpath = "//a[contains(text(),'Survol') or contains(text(),'Overview')]"),
		@FindBy (xpath = "//a[@translate='nav.overview.header']")
	})	
	WebElement menuOverview;
	
	@FindBy (xpath = "//button[@title='Change username' or @title='Changer le nom d’utilisateur']")
	WebElement lnkChangeUsername;
	
	@FindBy (xpath = "//input[@id='username']//parent::div")
	WebElement labelNewUsername;
	
	@FindBy (xpath = "//input[@id='username']")
	WebElement inputNewUsername;
	
	@FindBy(xpath = "//span[@class='badge-ind-wireless-name']")
	WebElement inputInnerNewUserName;
	
	@FindBy (xpath = "//span[contains(text(),'Continue') or contains(text(),'Continuer')]")
	WebElement btnChangeUsernameContinue;
	
	@FindBy (xpath = "//span[contains(text(),'Submit') or contains(text(),'Soumettre')]")
	WebElement btnChangeUsernameSubmit;
	
	//TODO: xpath will add French
	@FindBy (xpath = "//span[contains(text(),'Username changed') or contains(text(),'Nom d’utilisateur modifié')]")
	WebElement lblChangeUsernameSucMsg;
	
	@FindBy (xpath = "//button[@title='Done' or @title='Terminé']")
	WebElement btnChangeUsernameDone;
	
	@FindBy (xpath = "//button[@title='Change password' or @title='Changer le mot de passe']")
	WebElement lnkChangePassword;
	
	@FindBy (xpath = "//ds-modal-container")
	WebElement overlayChangePassword;
	
	@FindBy (xpath = "//input[@id='oldpassword']//parent::div")
	WebElement divCurrentPassword;
	
	@FindBy (xpath = "//input[@formcontrolname='oldPasswordField']")
	WebElement inputCurrentPassword;
	
	@FindBy (xpath = "//input[@formcontrolname='passwordField']//parent::div")
	WebElement divNewPassword;
	
	@FindBy (xpath = "//input[@formcontrolname='passwordField']")
	WebElement inputNewPassword;
	
	@FindBy (xpath = "//input[@formcontrolname='confirmPasswordField']//parent::div")
	WebElement divConfirmPassword;
	
	@FindBy (xpath = "//input[@formcontrolname='confirmPasswordField']")
	WebElement inputConfirmPassword;
	
	@FindBy (xpath = "//strong")
	WebElement btnChangePassSubmit;

	@FindBy (xpath = "//p[contains(text(),'Password changed') or contains(text(),'mot de passe a été modifié')]")
	WebElement lblChangePassSucMsg;
	
	@FindBy (xpath = "//strong")
	WebElement btnChangePassDone;
	
	@FindBy (xpath = "//button[@title='Display contact information' or @title='Afficher les coordonnées']")
	WebElement btnContactInfo;
	
	@FindBy (xpath = "//button[@title='Display billing settings' or @title='Afficher les préférences de facturation']")
	WebElement btnBilingAddressInfo;
	
	@FindBy (xpath = "//span[contains(text(),'email') or contains(text(),'adresse courriel')]")
	WebElement lnkAddContactEmail;
	
	@FindBy (xpath = "//span[contains(text(),'Change billing address') or contains(text(),'Changer l’adresse de facturation')]")
	WebElement lnkChangeBillingAddress;
	
	@FindBy(xpath = "//button[@title='Change billing address' or @title='Changer l’adresse de facturation']")
	WebElement lnkChangeBillingAddressMobile;
	
	@FindBy (xpath = "//span[contains(text(),'home number') or contains(text(),'numéro à la maison')]")
	WebElement lnkUpdateHomeNumber;
	
	@FindBy (xpath = "//span[contains(text(),'business number') or contains(text(),'téléphone au travail')]")
	WebElement lnkAddBusinessNumber;
	
	@FindAll({
		@FindBy (xpath = "//button[@title='Change preferred contact language']"),
		@FindBy (xpath = "//span[contains(text(),'contact language') or contains(text(),'Changer la langue')]")
	})	
	WebElement lnkChangeLanguage;
	
	@FindBy (xpath = "//input[@id='email']//parent::div")	
	WebElement lblContactEmail;
	
	@FindBy (xpath = "//input[@id='email']")
	WebElement inputContactEmail;
	
	@FindBy (xpath = "//button[@title='Continue' or @title='Continuer']")
	WebElement btnAddContactEmailContinue;
	
	@FindBy (xpath = "//button[@title='Submit' or @title='Soumettre']")
	WebElement btnAddContactEmailSubmit;
	
	@FindBy (xpath = "//div[@footer]//span[contains(text(),'Done') or contains(text(),'Termin')]")
	WebElement btnAddContactEmailDone;
	
	@FindBy (xpath = "//input[@id='homePhone' or @id='mobilePhone']//parent::div")
	WebElement lblHomePhone;
	
	@FindBy (xpath = "//input[@id='homePhone']")
	WebElement inputHomePhone;
	
	@FindBy (xpath = "//button[@title='Continue' or @title='Continuer']")
	WebElement btnUpdateHomeNumberContinue;
	
	@FindBy (xpath = "//button[@title='Submit' or @title='Soumettre']")
	WebElement btnUpdateHomeNumberSubmit;
	
	@FindBy (xpath = "//div[@footer]//span[contains(text(),'Done') or contains(text(),'Termin')]")
	WebElement btnUpdateHomeNumberDone;  
	
	@FindBy (xpath = "//input[@id='businessPhone']//parent::div")
	WebElement lblBusinessPhone;
	
	@FindBy (xpath = "//input[@id='businessPhone']")
	WebElement inputBusinessPhone;
	
	@FindBy (xpath = "//button[@title='Continue' or @title='Continuer']")
	WebElement btnAddBusinessNumberContinue;
	
	@FindBy (xpath = "//button[@title='Submit' or @title='Soumettre']")
	WebElement btnAddBusinessNumberSubmit;
	
	@FindBy (xpath = "//div[@footer]//span[contains(text(),'Done') or contains(text(),'Termin')]")
	WebElement btnAddBusinessNumberDone;
	
	@FindBy (xpath = "//div[@footer]//span[contains(text(),'Done') or contains(text(),'Termin')]")
	WebElement btnChangeLanguageDone;

	@FindBy(xpath = "//button[@title='Close' or @title='Fermer']")
	WebElement btnClose;

	@FindBy(xpath = "//button[@title='Submit'  or @title='Soumettre']")
	WebElement btnChangeLanguageSubmit;
	
	@FindBy(xpath = "//input[@title='Enter street number' or @title='Entrer le numéro municipal']")
	WebElement txtStreetNumber;
	
	@FindBy(xpath = "//input[@title='Enter street name' or @title='Entrer le nom de la rue']")
	WebElement txtStreetName;
	
	@FindBy(xpath = "//select[@title='Select street type' or @title='Sélectionner le type de rue']")
	WebElement cboStreetType;
	
	@FindBy(xpath = "//input[@title='Enter apartment number' or @title='Entrer le numéro d’appartement']")
	WebElement txtApartmentNumber;
	
	@FindBy(xpath = "//select[@title='Select type' or @title='Sélectionner le type']")
	WebElement cboApartmentType;
	
	@FindBy(xpath = "//input[@title='Enter city’s name' or @title='Entrer le nom de la ville']")
	WebElement txtCityName;
	
	@FindBy(xpath = "//select[@title='Select a province/territory' or @title='Sélectionner une province/un territoire']")
	WebElement cboProvince;
	
	@FindBy(xpath = "//input[@title='Enter postal code' or @title='Entrer le code postal']")
	WebElement txtPostalCode;
	
	@FindBy(xpath = "//button[@title='Continue' or @title='Continuer']")
	WebElement btnChangeAddressContinue;

	@FindBy(xpath ="//button[@title='Select and submit address suggested by Canada Post' or @title='Sélectionner et soumettre l’adresse suggérée par Poste Canada' or text()=' Submit ']")
	WebElement btnSelectAndSubmit;
	
	@FindBy(xpath = "//button//span[text()=' Submit ']")
	WebElement btnSubmit;

	@FindBy(xpath ="//button/span/span[contains(text(),'Done') or contains(text(),'Termin')]")
	WebElement btnChangeAddressDone;

	@FindBy(xpath = "//div[text()='Billing address:' or text()='Adresse de facturation :']/parent::div/following-sibling::div[1]")
	WebElement lblBillingAddress;
	
	@FindBy(xpath = "//rss-contact-info//div")
	WebElement lblContactsDetailsSection;
	
	
	@FindBy(xpath = "//div[text()='Language:']/parent::div/following-sibling::div")
	WebElement lblContactsDetailsSectionMobile;

	@FindBy(xpath = "//input[@title='Enter street number' or @title='Entrer le numéro municipal']/parent::div")
	WebElement lblStreetNumber;

	@FindBy(xpath = "//input[@title='Enter street name' or @title='Entrer le nom de la rue']/parent::div")
	WebElement lblStreetName;

	@FindBy(xpath = "//input[@title='Enter city’s name' or @title='Entrer le nom de la ville']/parent::div")
	WebElement lblCityName;

	@FindBy(xpath = "//input[@title='Enter postal code' or @title='Entrer le code postal']/parent::div")
	WebElement lblPostCode;

	@FindBy(xpath = "//input[@title='Enter apartment number' or @title='Entrer le numéro d’appartement']/parent::div")
	WebElement lblApartmentNumber;
	
	@FindBy (xpath = "//div[contains(text(),'Email') or contains(text(),'Adresse courriel :')]/following-sibling::div")
	WebElement btnChangeEmailMobile;
	
	@FindBy (xpath = "//div[contains(text(),'Email') or contains(text(),'Adresse courriel :')]/following-sibling::div/button")
	WebElement btnAddEmailMobile;
	
	@FindBy(xpath = "//div[contains(@class,'QSISlider')]/div/following-sibling::div//img")
	WebElement btnCloseFeedbackMobile;

	@FindBy(xpath = "//span[contains(text(),'Current contact email: ') or contains(text(),'Adresse courriel actuelle : ')]/following-sibling::span")
	WebElement lblContactEmailOnChgeContactEmailOverlay;

	@FindBy(xpath = "//div[contains(text(),'Home number') or contains(text(),'Numéro de sans-fil :') or contains(text(),'numéro à la maison')]/parent::div/parent::div//span[text()=' Update ' or text()=' Mettre à jour ' or text()=' Ajouter ']")
	WebElement btnUpdateHomeNumberMobile;
	
	@FindBy (xpath = "//div[contains(text(),'Business number:') or contains(text(),'Numéro de téléphone au travail :') or contains(text(),'numéro à la maison')]/parent::div/parent::div//span[text()=' Update ' or text()=' Mettre à jour ' or text()=' Ajouter ']")
	WebElement lnkAddBusinessNumberMobile;
	
	@FindBy (xpath = "//div[contains(text(),'Language:') or contains(text(),'Langue :') or contains(text(),'numéro à la maison')]/parent::div/parent::div//span[text()=' Change ' or text()=' Changer ' or text()=' Ajouter ']")
	WebElement lnkChangeLanguageMobile;
		
	/**
	 * Click on setup recovery number link
	 * @author ning.xue
	 */
	public void clkLnkSetupRecoveryNum() {
		reusableActions.waitForElementTobeClickable(lnkSetupRecoveryNum, 30);
		reusableActions.clickIfAvailable(lnkSetupRecoveryNum, 30);
	}
	
	/**
	 * To switch to the set recovery number iframe
	 * @author ning.xue
	 */
	public void switchToSetRecoveryNumIFrame() {
		reusableActions.waitForFrameToBeAvailableAndSwitchToIt(iframeSmsRecovery, 10);
	}
	
	/**
	 * Set verification code for set number for SMS recovery flow 
	 * @param strRecoveryNumber, String, the recovery number to set
	 * @author ning.xue
	 */
	public void setPhoneNumberIframe(String strRecoveryNumber) {

		reusableActions.getWhenReady(inputPhoneNumber,20).clear();
		reusableActions.getWhenReady(inputPhoneNumber,2).sendKeys(strRecoveryNumber);
	}
	
	/**
	 * Click on continue button in set number for SMS recovery flow
	 * @author ning.xue
	 */
	public void clkBtnContinueIframe() {
		reusableActions.clickIfAvailable(btnContinue, 30);
	}

	/**
	 * Set phone number for set number for SMS recovery flow 
	 * @param strVerifyCode, string of verify code got from ENS
	 * @author ning.xue
	 */
	public void setVerifyCodeIframe(String strVerifyCode) {
		reusableActions.getWhenReady(inputSmsPin,20).clear();
		reusableActions.getWhenReady(inputSmsPin,2).sendKeys(strVerifyCode);
	}
	
	/**
	 * Click on Verify me button in set number for SMS recovery flow
	 * @author ning.xue
	 */
	public void clkBtnVerifyMeIframe() {
		reusableActions.clickWhenReady(btnVerifyMe, 30);
		//reusableActions.executeJavaScriptClick(btnContinue);
	}
	
	/**
	 * Check if the recovery number set successfully confirm message is displayed
	 * @param strLast4DigitPhoneNum, the last 4 digit of the set phone number 
	 * @return true if the confirm message is displayed, otherwise false
	 * @author ning.xue
	 */
	public Boolean verifySetRecoverySuccessConfirmationMsg(String strLast4DigitPhoneNum) {
		return reusableActions.isElementVisible(By.xpath("//div[contains(text(),'" + strLast4DigitPhoneNum + "')]"), 30);
	}
	
	/**
	 * Click on Continue to MyRogers button in set number for SMS recovery flow
	 * @author ning.xue
	 */
	public void clkBtnContinueToMyRogersIframe() {
		reusableActions.clickIfAvailable(btnContinueToMyRogers, 30);
	}
	
	/**
	 * To switch out of the set recovery number iframe
	 * @author ning.xue
	 */
	public void switchOutofSetRecoveryNumIframe() {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * Check if the recovery number is successfully set
	 * @param strLast4DigitPhoneNum, the last 4 digit of the set phone number 
	 * @return true if the number was set, otherwise false
	 * @author ning.xue
	 */
	public Boolean verifyRecoveryNumberSetSuccessfully(String strLast4DigitPhoneNum) {
		return reusableActions.isElementVisible(By.xpath("//div[contains(text(),'" + strLast4DigitPhoneNum + "')]"), 30);
		
	}
	
	/**
	 * Click the link "Link another account" on Profile and Settings page
	 * @author ning.xue
	 */
	public void clklnkLinkAnotherAcct() {
		reusableActions.clickWhenReady(lnkLinkAnotherAcct, 30);
	}
	
	/**
	 * Validates the Message - 'Your account was successfully linked to your profile!'
	 * @return true if message displayed ; else false;
	 */
	public boolean verifyLinkAccountSuccessful() {
		return reusableActions.isElementVisible(lblLinkAccountSuccess);
	}
	
	/**
	 * Check if the account want to unlink is the working account
	 * @param strAccountNum, String, string of account number
	 * @return true if the account match, otherwise false
	 * @author ning.xue
	 */
	public Boolean isTheWorkingAccount(String strAccountNum) {
		return reusableActions.isElementVisible(By.xpath("//div[contains(text(),'" + strAccountNum + "')]"), 30);
	}
	
	/**
	 * Click the link "Unlink this account" on Profile and Settings page
	 * @author ning.xue
	 */
	public void clkLnkUnlinkThisAcct() {
		reusableActions.clickWhenReady(lnkUnlinkThisAcct, 30);
	}
	
	/**
	 * Click the button unlink this account
	 * @author ning.xue
	 */
	public void clkBtnUnlinkThisAccount() {
		reusableActions.clickWhenReady(btnUnlinkThisAcct, 30);
	}
	
	/**
	 * Verify if the account unlink success message displayed
	 * @param strCtn, String, string of the CTN unlinked
	 * @return true if success, otherwise false
	 * @author ning.xue
	 */
	public Boolean verifyAccountUnlinkSuccessMsg(String strCtn) {
		return reusableActions.isElementVisible(By.xpath("//span[contains(text(),'" + strCtn + "')]"), 30);
	}
	
	
	/**
	 * Click the button Done in unlink this account flow
	 * @author ning.xue
	 */
	public void clkBtnUnlinkDone() {
		reusableActions.clickWhenReady(btnUnlinkDone, 30);
		reusableActions.staticWait(3000);
		reusableActions.javascriptScrollToTopOfPage();

	}
	
	/**
	 * Click menu overview
	 * @author ning.xue
	 */
	public void clkLnkOverview() {
		reusableActions.javascriptScrollToTopOfPage();
		reusableActions.waitForElementTobeClickable(menuOverview, 360);
		reusableActions.scrollToElementAndClick(menuOverview);	

	}
	
	/**
	 * Click the link "Change username" on Profile and Settings page
	 * @author ning.xue
	 */
	public void clkLnkChangeUsername() {
		reusableActions.clickWhenReady(lnkChangeUsername, 30);
	}
	
	/**
	 * Check if current username show in the Change username overlay
	 * @param strUsername String, string of current user name
	 * @return true if current username match, otherwise false.
	 * @author ning.xue
	 */
	public Boolean verifyCurrentUsername(String strUsername) {
		return reusableActions.isElementVisible(By.xpath("//span[text()='Current username: ' or contains(text(),'Nom d’utilisateur actuel:')]/following-sibling::span[contains(text(),'" + strUsername + "')]"), 30);
		
	}
	
	/**
	 * Set new username for change username flow.
	 * @param strNewUsername String, string of new username
	 * @author ning.xue
	 */
	public void setNewUsername(String strNewUsername) {
		reusableActions.getWhenReady(labelNewUsername,20).click();
		//reusableActions.getWhenReady(inputNewUsername,10).clear();
		reusableActions.getWhenReady(inputNewUsername,2).sendKeys(strNewUsername);
	}
	
	/**
	 * Click the button "Continue" in change username flow
	 * @author ning.xue
	 */
	public void clkBtnChangeUsernameContinue() {
		reusableActions.clickWhenReady(btnChangeUsernameContinue, 30);
	}
	
	/**
	 * Check if confirm new username message is displayed
	 * @param strNewUsername String string of new user name.
	 * @return true if new username match, otherwise false.
	 * @author ning.xue
	 */
	public Boolean verifyChangeUsernameConfirmMsg(String strNewUsername) {
		return 	reusableActions.isElementVisible(By.xpath("//span[text()='New username will be: ' or contains(text(),'Votre nouveau nom d')]/following-sibling::span[contains(text(),'" + strNewUsername + "')]"), 30);
	}
	
	/**
	 * Click the button "Submit" in change username flow
	 * @author ning.xue
	 */
	public void clkBtnChangeUsernameSubmit() {
		reusableActions.clickWhenReady(btnChangeUsernameSubmit, 30);
	}
	
	/**
	 * Check if change username success message is displayed
	 * @return true if success message is displayed, otherwise false.
	 * @author ning.xue
	 */
	public Boolean verifyChangeUsernameSuccessMsg() {
		return 	reusableActions.isElementVisible(lblChangeUsernameSucMsg, 30);
	}
	
	/**
	 * Check if username match what has been set
	 * @param strUsername, String, string of user name
	 * @return true if the user name match, otherwise false
	 */
	public Boolean verifyUsername(String strUsername) {
		return reusableActions.isElementVisible(By.xpath("//div[contains(text(),'" + strUsername + "')]"), 30);
	}
	
	/**
	 * Click the button "Done" in change username flow
	 * @author ning.xue
	 */
	public void clkBtnChangeUsernameDone() {
		reusableActions.clickWhenReady(btnChangeUsernameDone, 30);
	}
	
	/**
	 * Click the link change password in Profile and Settings page
	 * @author ning.xue
	 */
	public void clkLnkChangePassword() {
		reusableActions.clickWhenReady(lnkChangePassword, 30);
	}
	
	/**
	 * Check if the change password overlay displayed in change password flow
	 * @return true if the overlay displayed, otherwise false.
	 */
	public Boolean isOverlayChangePasswordDisplayed() {
		return reusableActions.isElementVisible(overlayChangePassword, 30);
	}
	
	/**
	 * Set current password for change password flow.
	 * @param strCurrentPass String, string of current password
	 * @author ning.xue
	 */
	public void setCurrentPassword(String strCurrentPass) {
		
		reusableActions.getWhenReady(divCurrentPassword,30).click();
		//reusableActions.getWhenReady(inputCurrentPassword,2).clear();
		reusableActions.getWhenReady(inputCurrentPassword,2).sendKeys(strCurrentPass);
	}
	
	/**
	 * Set new password for change password flow.
	 * @param strNewPass String, string of new password
	 * @author ning.xue
	 */
	public void setNewPassword(String strNewPass) {
		reusableActions.getWhenReady(divNewPassword,30).click();
		//reusableActions.getWhenReady(inputNewPassword,10).clear();
		reusableActions.getWhenReady(inputNewPassword,2).sendKeys(strNewPass);
	}
	
	/**
	 * Set confirm new password for change password flow.
	 * @param strConfirmPass String, string of confirm new password
	 * @author ning.xue
	 */
	public void setConfirmPassword(String strConfirmPass) {
		reusableActions.getWhenReady(divConfirmPassword,30).click();
		//reusableActions.getWhenReady(inputConfirmPassword,10).clear();
		reusableActions.getWhenReady(inputConfirmPassword,2).sendKeys(strConfirmPass);
	}
	
	/**
	 * Click the button "Submit" in change password flow
	 * @author ning.xue
	 */
	public void clkBtnChangePasswordSubmit() {
		reusableActions.clickWhenReady(btnChangePassSubmit, 30);
	}
	
	/**
	 * Check if change password success message is displayed
	 * @return true if success message is displayed, otherwise false.
	 * @author ning.xue
	 */
	public Boolean verifyChangePasswordSuccessMsg() {
		return 	reusableActions.isElementVisible(lblChangePassSucMsg, 30);
	}
	
	/**
	 * Click the button "Done" in change password flow
	 * @author ning.xue
	 */
	public void clkBtnChangePasswordDone() {
		reusableActions.clickWhenReady(btnChangePassDone, 30);
	} 
	
	/**
	 * Click the button Contact Information in Profile and Settings page
	 * @author ning.xue
	 */
	public void clkBtnContactInfomation() {
		reusableActions.clickWhenReady(btnContactInfo, 30);
	}	
	
	/**
	 * Click the button Billing Information in Profile and Settings page
	 * @author ning.xue
	 */
	public void clkBtnBillingInfomation() {
		reusableActions.clickWhenReady(btnBilingAddressInfo, 30);
	}
	
	/**
	 * Click the link Add Contact Email in Contact Information section
	 * @author ning.xue
	 */
	public void clkLnkAddContactEmail() {
		reusableActions.clickWhenReady(lnkAddContactEmail, 30);
	}
	
	/**
	 * Click the link Add Contact Email in Contact Information section
	 * @author ning.xue
	 */
	public void clkLnkChangeBillingAddress() {
		reusableActions.clickWhenReady(lnkChangeBillingAddress, 30);
	}
	
	/**
	 * Click the link Add Contact Email in Contact Information section
	 * @author Mirza.Kamran
	 */
	public void clkLnkChangeBillingAddressMobile() {
		reusableActions.clickWhenReady(lnkChangeBillingAddressMobile, 30);
	}
	
	/**
	 * Click the link Update Home Number in Contact Information section
	 * @author ning.xue
	 */
	public void clkLnkUpdateHomeNumber() {
		reusableActions.clickWhenReady(By.xpath("//span[contains(text(),'home contact number') or contains(text(),'home number') or contains(text(),'numéro à la maison')]"), 30);
	}
	
	/**
	 * Click the link Add Business Number in Contact Information section
	 * @author ning.xue
	 */
	public void clkLnkAddBusinessNumber() {
		reusableActions.clickWhenReady(lnkAddBusinessNumber, 30);
	}
	
	/**
	 * Click the link Add Business Number in Contact Information section
	 * @author Mirza.Kamran
	 */
	public void clkLnkAddBusinessNumberMobile() {
		reusableActions.clickWhenReady(lnkAddBusinessNumberMobile, 30);
	}
	
	
	/**
	 * Click the link Change Contact Language in Contact Information section
	 * @author ning.xue
	 */
	public void clkLnkChangeContactLanguage() {
		reusableActions.clickWhenReady(lnkChangeLanguage, 30);
	}
	
	/**
	 * Click the link Change Contact Language in Contact Information section
	 * @author Mirza.Kamran
	 */
	public void clkLnkChangeContactLanguageMobile() {
		reusableActions.clickWhenReady(lnkChangeLanguageMobile, 30);
	}
	
	/**
	 * Set contact email for add contact email flow.
	 * @param strContactEmail String, string of contact email
	 * @author ning.xue
	 */
	public void setContactEmail(String strContactEmail) {
		reusableActions.getWhenReady(lblContactEmail).click();
		//reusableActions.getWhenReady(inputContactEmail,20).clear();		
		reusableActions.getWhenReady(inputContactEmail).sendKeys(strContactEmail);
		
	}
	
	/**
	 * Click the button Continue in Add contact email flow
	 * @author ning.xue
	 */
	public void clkBtnAddContactEmailContinue() {
		reusableActions.clickWhenReady(btnAddContactEmailContinue, 30);
	}	
	
	/**
	 * Click the button Submit in Add contact email flow
	 * @author ning.xue
	 */
	public void clkBtnAddContactEmailSubmit() {
		reusableActions.clickWhenReady(btnAddContactEmailSubmit, 30);
	} 
	
	/**
	 * Click the button Finish in Add contact email flow
	 * @author ning.xue
	 * @return true if finish is done else false
	 */
	public boolean clkBtnAddContactEmailFinish() {
		reusableActions.staticWait(1000);
		if(reusableActions.isDisplayed(btnAddContactEmailDone))
		{
		 reusableActions.clickWhenReady(btnAddContactEmailDone, 30);
		 return true;
		}
			
		reusableActions.clickIfAvailable(btnClose);
		return false;		
	}
	
	/**
	 * Check if contact email has been set successfully
	 * @param strContactEmail String string of contact email.
	 * @return true if contact email match, otherwise false.
	 * @author ning.xue
	 */
	public Boolean verifyContactEmailSuccessfullySet(String strContactEmail) {
		return 	reusableActions.isElementVisible(By.xpath("//rss-contact-info//div[contains(text(),'" + strContactEmail + "')]"), 30);
	}
	
	/**
	 * Set home phone for update home number flow.
	 * @param strHomePhone String, string of home phone
	 * @author ning.xue
	 */
	public void setHomePhone(String strHomePhone) {
		reusableActions.getWhenReady(lblHomePhone,30).click();
		//reusableActions.getWhenReady(inputHomePhone,20).clear();
		reusableActions.getWhenReady(inputHomePhone,2).sendKeys(strHomePhone);
	}
	
	/**
	 * Click the button Continue in update home number flow
	 * @author ning.xue
	 */
	public void clkBtnUpdateHomeNumberContinue() {
		reusableActions.clickWhenReady(btnUpdateHomeNumberContinue, 30);
	} 
	
	/**
	 * Click the button Submit in update home number flow
	 * @author ning.xue
	 */
	public void clkBtnUpdateHomeNumberSubmit() {
		reusableActions.clickWhenReady(btnUpdateHomeNumberSubmit, 30);
	} 
	
	/**
	 * Click the button Finish in update home number flow
	 * @return boolean true if click is successful else false
	 * @author ning.xue
	 */
	public boolean clkBtnUpdateHomeNumberFinish() {
		reusableActions.staticWait(1000);
		if(reusableActions.isDisplayed(btnUpdateHomeNumberDone))
		{
		 reusableActions.clickWhenReady(btnUpdateHomeNumberDone, 30);
		 return true;
		}
			
		reusableActions.clickIfAvailable(btnClose);
		return false;
	}
	
	/**
	 * Check if home number match what has been set
	 * @param strHomeNumber, String, string of last 4 digit home phone number
	 * @return true if the number match, otherwise false
	 */
	public Boolean verifyHomeNumber(String strHomeNumber) {
		return reusableActions.isElementVisible(By.xpath("//div[contains(text(),'" + strHomeNumber + "')]"), 30);
	}
	
	/**
	 * Set business phone for Add business number flow.
	 * @param strBusinessPhone String, string of business phone
	 * @author ning.xue
	 */
	public void setBusinessPhone(String strBusinessPhone) {
		reusableActions.getWhenReady(lblBusinessPhone,30).click();
		//reusableActions.getWhenReady(inputBusinessPhone,20).clear();
		reusableActions.getWhenReady(inputBusinessPhone,2).sendKeys(strBusinessPhone);
	}
	
	/**
	 * Click the button Continue in Add business number flow
	 * @author ning.xue
	 */
	public void clkBtnAddBusinessNumberContinue() {
		reusableActions.clickWhenReady(btnAddBusinessNumberContinue, 30);
	} 
	
	/**
	 * Click the button Submit in Add business number flow
	 * @author ning.xue
	 */
	public void clkBtnAddBusinessNumberSubmit() {
		reusableActions.clickWhenReady(btnAddBusinessNumberSubmit, 30);
	} 
	
	/**
	 * Click the button Submit in Add business number flow
	 * @author ning.xue
	 */
	public void clkBtnChangelanguageSubmit() {
		reusableActions.clickWhenReady(btnChangeLanguageSubmit, 30);
	} 
	
	/**
	 * Click the button Done in Add business number flow
	 * @author ning.xue
	 * @return true if button done is clicked else false
	 */
	public boolean clkBtnAddBusinessNumberDone() {
		reusableActions.staticWait(1000);
		if(reusableActions.isDisplayed(btnAddBusinessNumberDone))
		{
		 reusableActions.clickWhenReady(btnAddBusinessNumberDone, 30);
		 return true;
		}
			
		reusableActions.clickIfAvailable(btnClose);
		return false;		
	}
	
	/**
	 * Click the button Done in Change language
	 * @author ning.xue
	 * @return true if button done is clicked else false
	 */
	public boolean clkBtnChangeLanguageDone() {
		reusableActions.staticWait(1000);
		if(reusableActions.isDisplayed(btnChangeLanguageDone))
		{
		 reusableActions.clickWhenReady(btnChangeLanguageDone, 30);
		 return true;
		}
			
		reusableActions.clickIfAvailable(btnClose);
		return false;		
	}
	
	/**
	 * Check if business number match what has been set
	 * @param strBusinessNumber, String, string of last 4 digit business phone number
	 * @return true if the number match, otherwise false
	 * @author ning.xue
	 */
	public Boolean verifyBusinessNumber(String strBusinessNumber) {
		return reusableActions.isElementVisible(By.xpath("//div[contains(text(),'" + strBusinessNumber + "')]"), 30);
	}

	/**
	 * checks if the finish button is displayed
	 * @return true if the button is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean buttonFinishExists() {

		return reusableActions.isDisplayed(btnAddContactEmailDone);
	}
	
	/**
	 * Clicks on the close button
	 * @author Mirza.Kamran
	 */
	public void clkCloseButton() {
		reusableActions.executeJavaScriptClick(btnClose);
	}

	/**
	 * set the street number
	 * @param strStreetNumber street number
	 * @author Mirza.Kamran
	 */
	public void setStreetNumber(String strStreetNumber) {
		reusableActions.getWhenReady(lblStreetNumber).click();;
		reusableActions.getWhenReady(txtStreetNumber).sendKeys(strStreetNumber);
		
	}

	/**
	 * set the street name
	 * @param strStreetName street name
	 * @author Mirza.Kamran
	 */
	public void setStreetname(String strStreetName) {
		reusableActions.getWhenReady(lblStreetName).click();
		reusableActions.getWhenReady(txtStreetName).sendKeys(strStreetName);		
	}

	/**
	 * select the street type
	 * @param strStreetType street type
	 * @author Mirza.Kamran
	 */
	public void selectStreetType(String strStreetType) {
		reusableActions.selectWhenReadyByVisibleText(cboStreetType,strStreetType);	
		
	}

	/**
	 * set the apartment type
	 * @param strApartment apartment value
	 * @author Mirza.Kamran
	 */
	public void setApartment(String strApartment) {
		reusableActions.getWhenReady(lblApartmentNumber).click();
		reusableActions.getWhenReady(txtApartmentNumber).sendKeys(strApartment);				
	}

	/**
	 * set Apartment value
	 * @param strApartmentValue apartment value
	 * @author Mirza.Kamran
	 */
	public void selectAprtmentType(String strApartmentValue) {
		try {
			reusableActions.selectWhenReadyByVisibleText(cboApartmentType,strApartmentValue);
		}catch (Exception e) {
					
		}
	}

	/**
	 * Set the city name
	 * @param strCityName city name
	 * @author Mirza.Kamran
	 */
	public void setCityName(String strCityName) {
		reusableActions.getWhenReady(lblCityName).click();
		reusableActions.getWhenReady(txtCityName).sendKeys(strCityName);
	}

	/**
	 * select province
	 * @param strProvince province name'
	 * @author Mirza.Kamran
	 */
	public void selectProvince(String strProvince) {
		reusableActions.selectWhenReadyByVisibleText(cboProvince,strProvince);
	}

	/**
	 * set postal code
	 * @param strPostalCode postal code value
	 * @author Mirza.Kamran
	 */
	public void setPostalCode(String strPostalCode) {
		reusableActions.getWhenReady(lblPostCode).click();
		reusableActions.getWhenReady(txtPostalCode).sendKeys(strPostalCode);
		
	}

	/**
	 * click change address continue button
	 * @author Mirza.Kamran
	 */
	public void clkChangeAddresContinueButton() {
		reusableActions.clickIfAvailable(btnChangeAddressContinue);
		
	}

	/**
	 * Click selct and submit button
	 * @author Mirza.Kamran
	 */
	public void selectAndSubmit() {
		reusableActions.clickIfAvailable(btnSelectAndSubmit);		
	}

	/**
	 * Clicks on done button on change billing address
	 * @return true when done button is clicked else false
	 * @author Mirza.Kamran
	 */
	public boolean clickDoneChangeBillingAddress() {
		reusableActions.staticWait(1000);
		if(reusableActions.isDisplayed(btnChangeAddressDone))
		{
		 reusableActions.clickWhenReady(btnChangeAddressDone, 30);
		 return true;
		}
			
		reusableActions.clickIfAvailable(btnClose);
		return false;	
	}

	/**
	 * Checks if the billing address is valid
	 * @param strAddress string billing address
	 * @return true if the address is correct
	 */
	public boolean verifyBillingAddress(String strAddress) {		
		return reusableActions.getWhenReady(lblBillingAddress).getText().trim().contains(strAddress);
	}

	/**
	 * gets the existing billing address displayed
	 * @return string value containing the billing address
	 * @author Mirza.Kamran
	 */
	public String getExistingBillingAddress() {
		return reusableActions.getWhenReady(lblBillingAddress).getText().trim();
	}

	/**
	 * gets the existing language
	 * @return string language name
	 * @author Mirza.Kamran
	 */
	public String getExistingLanguage() {		
		return reusableActions.getWhenReady(lblContactsDetailsSection).getText();
	}

	/**
	 * gets the existing language
	 * @return string language name
	 * @author Mirza.Kamran
	 */
	public String getExistingLanguageMobile() {		
		return reusableActions.getWhenReady(lblContactsDetailsSectionMobile).getText();
	}
	
	/**
	 * Clicks on the language radio button
	 * @param strlanguage language name
	 * @author Mirza.Kamran
	 */
	public void clkLanguage(String strlanguage) {
		reusableActions.clickWhenReady(By.xpath("//span[text()='"+strlanguage+"']"));
		
	}

	/**
	 * New language parameter
	 * @param strNewLanguage Language
	 * @return true if the language is matched
	 * @author Mirza.Kamran
	 */
	public boolean verifyLanguageSetSuccessfully(String strNewLanguage) {		
		return reusableActions.isElementVisible(By.xpath("//div[contains(text(),'" + strNewLanguage + "')]"), 30);
	}

	/**
	 * Get the contact email
	 * @return true 
	 *@author Mirza.Kamran
	 */
	public String getContactEmail() {
		return reusableActions.getWhenReady(lblContactsDetailsSection).getText();
	}

	/**
	 * Clicks on the submit button
	 * @author Mirza.Kamran
	 */
	public void clkSubmit() {
		reusableActions.clickWhenReady(btnSubmit);
		
	}
	
	/**
	 * Clicks on the Change button beside Email
	 * @author ning.xue
	 */
	public void clkBtnChangeEmailMobile() {
		reusableActions.clickWhenReady(btnChangeEmailMobile);
		
	}
	
	/**
	 * Clicks on the Add button beside Email
	 * @author ning.xue
	 */
	public void clkBtnAddEmailMobile() {
		reusableActions.clickWhenReady(btnAddEmailMobile);
		
	}
	
	/**
	 * Will close the feedback bar if available on mobile
	 * @author Mirza.Kamran
	 */
	public void clkCloseFeedbackIfAvailableMobile() {
		reusableActions.clickIfAvailable(btnCloseFeedbackMobile);
	}

	/**
	 * Gets the contact email
	 * @return string value containing contact email
	 * @author Mirza.Kamran
	 */
	public String getContactEmailMobile() {		
		return reusableActions.getWhenReady(lblContactEmailOnChgeContactEmailOverlay).getText().toLowerCase();
	}

	public void setContactEmailMobile(String strAltEmail) {
		reusableActions.getWhenReady(lblContactEmail).click();
		//reusableActions.getWhenReady(inputContactEmail,20).clear();
		reusableActions.clickIfAvailable(lblContactEmail);
		reusableActions.getWhenReady(inputContactEmail).sendKeys(strAltEmail);
		
	}

	/**
	 * 
	 */
	public void clkLnkUpdateHomeNumberMobile() {
		reusableActions.getWhenReady(btnUpdateHomeNumberMobile).click();
		
	}
	
	/**
	 * Set home phone for update home number flow.
	 * @param strHomePhone String, string of home phone
	 * @author Mirza.Kamran
	 */
	public void setHomePhoneMobile(String strHomePhone) {
		reusableActions.getWhenReady(lblHomePhone,30).click();
		reusableActions.clickIfAvailable(lblHomePhone);
		reusableActions.getWhenReady(inputHomePhone,2).sendKeys(strHomePhone);
	}
	
	/**
	 * Set business phone for Add business number flow.
	 * @param strBusinessPhone String, string of business phone
	 * @author Mirza.Kamran
	 */
	public void setBusinessPhoneMobile(String strBusinessPhone) {
		reusableActions.getWhenReady(lblBusinessPhone,30).click();
		reusableActions.clickIfAvailable(lblBusinessPhone);
		reusableActions.getWhenReady(inputBusinessPhone,2).sendKeys(strBusinessPhone);
	}
}
