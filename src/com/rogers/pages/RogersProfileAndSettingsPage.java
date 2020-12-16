package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
	@FindBy (xpath = "//button[@title='Display contact information' or @title='Afficher les coordonnées' or @title='Hide contact information' or @title='Masquer les coordonnées']")
	WebElement btnContactInfo;
	
	@FindBy (xpath = "//button[@title='Display billing settings' or @title='Afficher les préférences de facturation']")
	WebElement btnBilingAddressInfo;
	
	@FindBy (xpath = "//span[contains(text(),'email') or contains(text(),'adresse courriel')]")
	WebElement lnkAddContactEmail;
	
	@FindBy (xpath = "//span[contains(text(),'Change billing address') or contains(text(),'adresse de facturation')]")
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
	
	@FindBy(xpath = "//input[contains(@title,'Enter city') or @title='Entrer le nom de la ville']")
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
	
	@FindAll({
		@FindBy(xpath = "//div[text()='Email:' or text()='Email:']/parent::div/parent::div"),
		@FindBy(xpath = "//rss-contact-info//div")})	
	WebElement lblContactsDetailsSection;
	
	@FindAll({
		@FindBy(xpath = "//div[text()='Language:' or text()='Language:']/parent::div/parent::div"),
		@FindBy(xpath = "//rss-contact-info//div")})	
	WebElement lblLanguageSection;
	
	@FindBy(xpath = "//div[text()='Language:']/parent::div/following-sibling::div")
	WebElement lblContactsDetailsSectionMobile;

	@FindBy(xpath = "//input[@title='Enter street number' or @title='Entrer le numéro municipal']/parent::div")
	WebElement lblStreetNumber;

	@FindBy(xpath = "//input[@title='Enter street name' or @title='Entrer le nom de la rue']/parent::div")
	WebElement lblStreetName;

	@FindBy(xpath = "//input[contains(@title,'Enter city') or @title='Entrer le nom de la ville']/parent::div/parent::div/parent::ds-form-field")
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
	
	@FindBy (xpath = "//div[contains(text(),'Business number:') or contains(text(),'Numéro de téléphone au travail :') or contains(text(),'numéro à la maison')]/parent::div/parent::div//span[text()=' Update ' or text()=' Add ' or text()=' Mettre à jour ' or text()=' Ajouter ']")
	WebElement lnkAddBusinessNumberMobile;
	
	@FindBy (xpath = "//div[contains(text(),'Language:') or contains(text(),'Langue :') or contains(text(),'numéro à la maison')]/parent::div/parent::div//span[text()=' Change ' or text()=' Changer ' or text()=' Ajouter ']")
	WebElement lnkChangeLanguageMobile;

	@FindBy (xpath = "//p[text()='Before you start, we need to first verify your identity.' or text()='Avant de commencer, nous devons vérifier votre identité.']")
	WebElement lblVerifyYourIdentity;
		
	@FindBy(xpath = "//button//span[text()='Continuer' or text()='Continue']")
	WebElement btnContinueVerifyIdentity;
	
	@FindBy(xpath = "//iframe[@title='DAM Shield']")
	WebElement frameVerifyIdentity;

	@FindBy(xpath = "//span[text()='Sorry...' or text()='Désolé...']")
	WebElement lblSorry;

	@FindBy(xpath = "//p[text()='Due to recent changes on your account, we are unable to proceed with this transaction.' or text()='En raison de modifications récentes de votre compte, nous ne pouvons pas procéder avec cette transaction.']")
	WebElement msgUnableToProceed;
	
	/**
	 * Click on setup recovery number link
	 * @author ning.xue
	 */
	public void clkLnkSetupRecoveryNum() {
		getReusableActionsInstance().waitForElementTobeClickable(lnkSetupRecoveryNum, 30);
		getReusableActionsInstance().getWhenReady(lnkSetupRecoveryNum, 30).click();
	}
	
	/**
	 * To switch to the set recovery number iframe
	 * @author ning.xue
	 */
	public void switchToSetRecoveryNumIFrame() {
		getReusableActionsInstance().waitForFrameToBeAvailableAndSwitchToIt(iframeSmsRecovery, 10);
	}
	
	/**
	 * Set verification code for set number for SMS recovery flow 
	 * @param strRecoveryNumber, String, the recovery number to set
	 * @author ning.xue
	 */
	public void setPhoneNumberIframe(String strRecoveryNumber) {

		getReusableActionsInstance().getWhenReady(inputPhoneNumber,20).clear();
		getReusableActionsInstance().getWhenReady(inputPhoneNumber,2).sendKeys(strRecoveryNumber);
	}
	
	/**
	 * Click on continue button in set number for SMS recovery flow
	 * @author ning.xue
	 */
	public void clkBtnContinueIframe() {
		getReusableActionsInstance().clickIfAvailable(btnContinue, 30);
	}

	/**
	 * Set phone number for set number for SMS recovery flow 
	 * @param strVerifyCode, string of verify code got from ENS
	 * @author ning.xue
	 */
	public void setVerifyCodeIframe(String strVerifyCode) {
		getReusableActionsInstance().getWhenReady(inputSmsPin,20).clear();
		getReusableActionsInstance().getWhenReady(inputSmsPin,2).sendKeys(strVerifyCode);
	}
	
	/**
	 * Click on Verify me button in set number for SMS recovery flow
	 * @author ning.xue
	 */
	public void clkBtnVerifyMeIframe() {
		getReusableActionsInstance().clickWhenReady(btnVerifyMe, 30);
		//getReusableActionsInstance().executeJavaScriptClick(btnContinue);
	}
	
	/**
	 * Check if the recovery number set successfully confirm message is displayed
	 * @param strLast4DigitPhoneNum, the last 4 digit of the set phone number 
	 * @return true if the confirm message is displayed, otherwise false
	 * @author ning.xue
	 */
	public Boolean verifySetRecoverySuccessConfirmationMsg(String strLast4DigitPhoneNum) {
		return getReusableActionsInstance().isElementVisible(By.xpath("//div[contains(text(),'" + strLast4DigitPhoneNum + "')]"), 30);
	}
	
	/**
	 * Click on Continue to MyRogers button in set number for SMS recovery flow
	 * @author ning.xue
	 */
	public void clkBtnContinueToMyRogersIframe() {
		getReusableActionsInstance().getWhenReady(btnContinueToMyRogers, 30).click();
	}
	
	/**
	 * To switch out of the set recovery number iframe
	 * @author ning.xue
	 */
	public void switchOutofSetRecoveryNumIframe() {
		getDriver().switchTo().defaultContent();
	}
	
	/**
	 * Check if the recovery number is successfully set
	 * @param strLast4DigitPhoneNum, the last 4 digit of the set phone number 
	 * @return true if the number was set, otherwise false
	 * @author ning.xue
	 */
	public Boolean verifyRecoveryNumberSetSuccessfully(String strLast4DigitPhoneNum) {
		return getReusableActionsInstance().isElementVisible(By.xpath("//div[contains(text(),'" + strLast4DigitPhoneNum + "')]"), 30);
		
	}
	
	/**
	 * Click the link "Link another account" on Profile and Settings page
	 * @author ning.xue
	 */
	public void clklnkLinkAnotherAcct() {
		getReusableActionsInstance().clickWhenReady(lnkLinkAnotherAcct, 30);
	}
	
	/**
	 * Validates the Message - 'Your account was successfully linked to your profile!'
	 * @return true if message displayed ; else false;
	 */
	public boolean verifyLinkAccountSuccessful() {
		return getReusableActionsInstance().isElementVisible(lblLinkAccountSuccess);
	}
	
	/**
	 * Check if the account want to unlink is the working account
	 * @param strAccountNum, String, string of account number
	 * @return true if the account match, otherwise false
	 * @author ning.xue
	 */
	public Boolean isTheWorkingAccount(String strAccountNum) {
		return (getReusableActionsInstance().isElementVisible(By.xpath("//rss-account-info//*[contains(text(),'" + strAccountNum + "')]"), 30)
				||getReusableActionsInstance().isElementVisible(By.xpath("//div[contains(text(),'" + strAccountNum + "')]"), 30));
	}
	
	/**
	 * Click the link "Unlink this account" on Profile and Settings page
	 * @author ning.xue
	 */
	public void clkLnkUnlinkThisAcct() {
		getReusableActionsInstance().clickWhenReady(lnkUnlinkThisAcct, 30);
	}
	
	/**
	 * Click the button unlink this account
	 * @author ning.xue
	 */
	public void clkBtnUnlinkThisAccount() {
		getReusableActionsInstance().clickWhenReady(btnUnlinkThisAcct, 30);
	}
	
	/**
	 * Verify if the account unlink success message displayed
	 * @param strCtn, String, string of the CTN unlinked
	 * @return true if success, otherwise false
	 * @author ning.xue
	 */
	public Boolean verifyAccountUnlinkSuccessMsg(String strCtn) {
		return getReusableActionsInstance().isElementVisible(By.xpath("//span[contains(text(),'" + strCtn + "')]"), 30);
	}
	
	
	/**
	 * Click the button Done in unlink this account flow
	 * @author ning.xue
	 */
	public void clkBtnUnlinkDone() {
		getReusableActionsInstance().clickWhenReady(btnUnlinkDone, 30);
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().javascriptScrollToTopOfPage();

	}
	
	/**
	 * Click menu overview
	 * @author ning.xue
	 */
	public void clkLnkOverview() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		getReusableActionsInstance().waitForElementTobeClickable(menuOverview, 360);
		getReusableActionsInstance().scrollToElementAndClick(menuOverview);

	}
	
	/**
	 * Click the link "Change username" on Profile and Settings page
	 * @author ning.xue
	 */
	public void clkLnkChangeUsername() {
		getReusableActionsInstance().clickWhenReady(lnkChangeUsername, 30);
	}
	
	/**
	 * Check if current username show in the Change username overlay
	 * @param strUsername String, string of current user name
	 * @return true if current username match, otherwise false.
	 * @author ning.xue
	 */
	public Boolean verifyCurrentUsername(String strUsername) {
		return getReusableActionsInstance().isElementVisible(By.xpath("//span[text()='Current username: ' or contains(text(),'Nom d’utilisateur actuel:')]/following-sibling::span[contains(text(),'" + strUsername + "')]"), 30);
		
	}
	
	/**
	 * Set new username for change username flow.
	 * @param strNewUsername String, string of new username
	 * @author ning.xue
	 */
	public void setNewUsername(String strNewUsername) {
		getReusableActionsInstance().getWhenReady(labelNewUsername,20).click();
		//getReusableActionsInstance().getWhenReady(inputNewUsername,10).clear();
		getReusableActionsInstance().getWhenReady(inputNewUsername,2).sendKeys(strNewUsername);
	}
	
	/**
	 * Click the button "Continue" in change username flow
	 * @author ning.xue
	 */
	public void clkBtnChangeUsernameContinue() {
		getReusableActionsInstance().clickWhenReady(btnChangeUsernameContinue, 30);
	}
	
	/**
	 * Check if confirm new username message is displayed
	 * @param strNewUsername String string of new user name.
	 * @return true if new username match, otherwise false.
	 * @author ning.xue
	 */
	public Boolean verifyChangeUsernameConfirmMsg(String strNewUsername) {
		return 	getReusableActionsInstance().isElementVisible(By.xpath("//span[text()='New username will be: ' or contains(text(),'Votre nouveau nom d')]/following-sibling::span[contains(text(),'" + strNewUsername + "')]"), 30);
	}
	
	/**
	 * Click the button "Submit" in change username flow
	 * @author ning.xue
	 */
	public void clkBtnChangeUsernameSubmit() {
		getReusableActionsInstance().clickWhenReady(btnChangeUsernameSubmit, 30);
	}
	
	/**
	 * Check if change username success message is displayed
	 * @return true if success message is displayed, otherwise false.
	 * @author ning.xue
	 */
	public Boolean verifyChangeUsernameSuccessMsg() {
		return 	getReusableActionsInstance().isElementVisible(lblChangeUsernameSucMsg, 30);
	}
	
	/**
	 * Check if username match what has been set
	 * @param strUsername, String, string of user name
	 * @return true if the user name match, otherwise false
	 */
	public Boolean verifyUsername(String strUsername) {
		return getReusableActionsInstance().isElementVisible(By.xpath("//div[contains(text(),'" + strUsername + "')]"), 30);
	}
	
	/**
	 * Click the button "Done" in change username flow
	 * @author ning.xue
	 */
	public void clkBtnChangeUsernameDone() {
		getReusableActionsInstance().clickWhenReady(btnChangeUsernameDone, 30);
	}
	
	/**
	 * Click the link change password in Profile and Settings page
	 * @author ning.xue
	 */
	public void clkLnkChangePassword() {
		getReusableActionsInstance().clickWhenReady(lnkChangePassword, 30);
	}
	
	/**
	 * Check if the change password overlay displayed in change password flow
	 * @return true if the overlay displayed, otherwise false.
	 */
	public Boolean isOverlayChangePasswordDisplayed() {
		return getReusableActionsInstance().isElementVisible(overlayChangePassword, 30);
	}
	
	/**
	 * Set current password for change password flow.
	 * @param strCurrentPass String, string of current password
	 * @author ning.xue
	 */
	public void setCurrentPassword(String strCurrentPass) {
		
		getReusableActionsInstance().getWhenReady(divCurrentPassword,30).click();
		//JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		//jse.executeScript("arguments[0].value='"+ strCurrentPass +"';", divCurrentPassword);
		getReusableActionsInstance().getWhenReady(divCurrentPassword,30).click();
		getReusableActionsInstance().getWhenReady(inputCurrentPassword,2).sendKeys(strCurrentPass);
	}
	
	/**
	 * Set current password for change password flow.
	 * @param strCurrentPass String, string of current password
	 * @author Mirza.Kamran
	 */
	public void setCurrentPasswordMobile(String strCurrentPass) {
		//getReusableActionsInstance().getWhenReady(divCurrentPassword,30);
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("arguments[0].value='"+ strCurrentPass +"';", divCurrentPassword);
		getReusableActionsInstance().executeJavaScript("arguments[0].value='Test'");
		getReusableActionsInstance().getWhenReady(divCurrentPassword,30).click();
		getReusableActionsInstance().getWhenReady(divCurrentPassword,30).click();
		getReusableActionsInstance().getWhenReady(inputCurrentPassword,2).sendKeys(strCurrentPass);
	}
	
	/**
	 * Set new password for change password flow.
	 * @param strNewPass String, string of new password
	 * @author ning.xue
	 */
	public void setNewPassword(String strNewPass) {
		getReusableActionsInstance().getWhenReady(divNewPassword,30).click();
		getReusableActionsInstance().getWhenReady(divNewPassword,30).click();
		getReusableActionsInstance().getWhenReady(inputNewPassword,2).sendKeys(strNewPass);
	}
	
	/**
	 * Set confirm new password for change password flow.
	 * @param strConfirmPass String, string of confirm new password
	 * @author ning.xue
	 */
	public void setConfirmPassword(String strConfirmPass) {
		getReusableActionsInstance().getWhenReady(divConfirmPassword,30).click();
		getReusableActionsInstance().getWhenReady(divConfirmPassword,30).click();
		getReusableActionsInstance().getWhenReady(inputConfirmPassword,2).sendKeys(strConfirmPass);
	}
	
	/**
	 * Click the button "Submit" in change password flow
	 * @author ning.xue
	 */
	public void clkBtnChangePasswordSubmit() {
		getReusableActionsInstance().clickWhenReady(btnChangePassSubmit, 30);
	}
	
	/**
	 * Check if change password success message is displayed
	 * @return true if success message is displayed, otherwise false.
	 * @author ning.xue
	 */
	public Boolean verifyChangePasswordSuccessMsg() {
		return 	getReusableActionsInstance().isElementVisible(lblChangePassSucMsg, 30);
	}
	
	/**
	 * Click the button "Done" in change password flow
	 * @author ning.xue
	 */
	public void clkBtnChangePasswordDone() {
		getReusableActionsInstance().clickWhenReady(btnChangePassDone, 30);
	} 
	
	/**
	 * Click the button Contact Information in Profile and Settings page
	 * @author ning.xue
	 */
	public void clkBtnContactInfomation() {
		getReusableActionsInstance().clickWhenReady(btnContactInfo, 30);
		getReusableActionsInstance().staticWait(1000);
		getReusableActionsInstance().clickWhenReady(btnContactInfo, 30);
		getReusableActionsInstance().staticWait(1000);
		getReusableActionsInstance().clickWhenReady(btnContactInfo, 30);
		getReusableActionsInstance().staticWait(1000);
		getReusableActionsInstance().clickWhenReady(btnContactInfo, 30);
		getReusableActionsInstance().staticWait(1000);
		getReusableActionsInstance().clickWhenReady(btnContactInfo, 30);
		// The contact details is taking some time to load
	}	
	
	/**
	 * Click the button Billing Information in Profile and Settings page
	 * @author ning.xue
	 */
	public void clkBtnBillingInfomation() {
		getReusableActionsInstance().clickWhenReady(btnBilingAddressInfo, 30);
	}
	
	/**
	 * Click the link Add Contact Email in Contact Information section
	 * @author ning.xue
	 */
	public void clkLnkAddContactEmail() {
		getReusableActionsInstance().clickWhenReady(lnkAddContactEmail, 30);
	}
	
	/**
	 * Click the link Add Contact Email in Contact Information section
	 * @author ning.xue
	 */
	public void clkLnkChangeBillingAddress() {
		getReusableActionsInstance().clickWhenReady(lnkChangeBillingAddress, 30);
	}
	
	/**
	 * Click the link Add Contact Email in Contact Information section
	 * @author Mirza.Kamran
	 */
	public void clkLnkChangeBillingAddressMobile() {
		getReusableActionsInstance().clickWhenReady(lnkChangeBillingAddressMobile, 30);
	}
	
	/**
	 * Click the link Update Home Number in Contact Information section
	 * @author ning.xue
	 */
	public void clkLnkUpdateHomeNumber() {
		getReusableActionsInstance().clickWhenReady(By.xpath("//span[contains(text(),'home contact number') or contains(text(),'home number') or contains(text(),'numéro à la maison')]"), 30);
	}
	
	/**
	 * Click the link Add Business Number in Contact Information section
	 * @author ning.xue
	 */
	public void clkLnkAddBusinessNumber() {
		getReusableActionsInstance().clickWhenReady(lnkAddBusinessNumber, 30);
	}
	
	/**
	 * Click the link Add Business Number in Contact Information section
	 * @author Mirza.Kamran
	 */
	public void clkLnkAddBusinessNumberMobile() {
		getReusableActionsInstance().clickWhenReady(lnkAddBusinessNumberMobile, 30);
	}
	
	
	/**
	 * Click the link Change Contact Language in Contact Information section
	 * @author ning.xue
	 */
	public void clkLnkChangeContactLanguage() {
		getReusableActionsInstance().clickWhenReady(lnkChangeLanguage, 30);
	}
	
	/**
	 * Click the link Change Contact Language in Contact Information section
	 * @author Mirza.Kamran
	 */
	public void clkLnkChangeContactLanguageMobile() {
		getReusableActionsInstance().clickWhenReady(lnkChangeLanguageMobile, 30);
	}
	
	/**
	 * Set contact email for add contact email flow.
	 * @param strContactEmail String, string of contact email
	 * @author ning.xue
	 */
	public void setContactEmail(String strContactEmail) {
		getReusableActionsInstance().getWhenReady(lblContactEmail).click();
		//getReusableActionsInstance().getWhenReady(inputContactEmail,20).clear();
		getReusableActionsInstance().getWhenReady(inputContactEmail).sendKeys(strContactEmail);
		
	}
	
	/**
	 * Click the button Continue in Add contact email flow
	 * @author ning.xue
	 */
	public void clkBtnAddContactEmailContinue() {
		getReusableActionsInstance().clickWhenReady(btnAddContactEmailContinue, 30);
	}	
	
	/**
	 * Click the button Submit in Add contact email flow
	 * @author ning.xue
	 */
	public void clkBtnAddContactEmailSubmit() {
		getReusableActionsInstance().clickWhenReady(btnAddContactEmailSubmit, 30);
	} 
	
	/**
	 * Click the button Finish in Add contact email flow
	 * @author ning.xue
	 * @return true if finish is done else false
	 */
	public boolean clkBtnAddContactEmailFinish() {
		getReusableActionsInstance().staticWait(1000);
		if(getReusableActionsInstance().isElementVisible(btnAddContactEmailDone))
		{
		 getReusableActionsInstance().clickWhenReady(btnAddContactEmailDone, 30);
		 return true;
		}
			
		getReusableActionsInstance().clickIfAvailable(btnClose);
		return false;		
	}
	
	/**
	 * Check if contact email has been set successfully
	 * @param strContactEmail String string of contact email.
	 * @return true if contact email match, otherwise false.
	 * @author ning.xue
	 */
	public Boolean verifyContactEmailSuccessfullySet(String strContactEmail) {
		return 	getReusableActionsInstance().isElementVisible(By.xpath("//rss-contact-info//div[contains(text(),'" + strContactEmail + "')]"), 30);
	}
	
	/**
	 * Set home phone for update home number flow.
	 * @param strHomePhone String, string of home phone
	 * @author ning.xue
	 */
	public void setHomePhone(String strHomePhone) {
		getReusableActionsInstance().getWhenReady(lblHomePhone,30).click();
		//getReusableActionsInstance().getWhenReady(inputHomePhone,20).clear();
		getReusableActionsInstance().getWhenReady(inputHomePhone,2).sendKeys(strHomePhone);
	}
	
	/**
	 * Click the button Continue in update home number flow
	 * @author ning.xue
	 */
	public void clkBtnUpdateHomeNumberContinue() {
		getReusableActionsInstance().clickWhenReady(btnUpdateHomeNumberContinue, 30);
	} 
	
	/**
	 * Click the button Submit in update home number flow
	 * @author ning.xue
	 */
	public void clkBtnUpdateHomeNumberSubmit() {
		getReusableActionsInstance().clickWhenReady(btnUpdateHomeNumberSubmit, 30);
	} 
	
	/**
	 * Click the button Finish in update home number flow
	 * @return boolean true if click is successful else false
	 * @author ning.xue
	 */
	public boolean clkBtnUpdateHomeNumberFinish() {
		getReusableActionsInstance().staticWait(1000);
		if(getReusableActionsInstance().isElementVisible(btnUpdateHomeNumberDone))
		{
		 getReusableActionsInstance().clickWhenReady(btnUpdateHomeNumberDone, 30);
		 return true;
		}
			
		getReusableActionsInstance().clickIfAvailable(btnClose);
		return false;
	}
	
	/**
	 * Check if home number match what has been set
	 * @param strHomeNumber, String, string of last 4 digit home phone number
	 * @return true if the number match, otherwise false
	 */
	public Boolean verifyHomeNumber(String strHomeNumber) {
		return getReusableActionsInstance().isElementVisible(By.xpath("//div[contains(text(),'" + strHomeNumber + "')]"), 30);
	}
	
	/**
	 * Set business phone for Add business number flow.
	 * @param strBusinessPhone String, string of business phone
	 * @author ning.xue
	 */
	public void setBusinessPhone(String strBusinessPhone) {
		getReusableActionsInstance().getWhenReady(lblBusinessPhone,30).click();
		//getReusableActionsInstance().getWhenReady(inputBusinessPhone,20).clear();
		getReusableActionsInstance().getWhenReady(inputBusinessPhone,2).sendKeys(strBusinessPhone);
	}
	
	/**
	 * Click the button Continue in Add business number flow
	 * @author ning.xue
	 */
	public void clkBtnAddBusinessNumberContinue() {
		getReusableActionsInstance().clickWhenReady(btnAddBusinessNumberContinue, 30);
	} 
	
	/**
	 * Click the button Submit in Add business number flow
	 * @author ning.xue
	 */
	public void clkBtnAddBusinessNumberSubmit() {
		getReusableActionsInstance().clickWhenReady(btnAddBusinessNumberSubmit, 30);
	} 
	
	/**
	 * Click the button Submit in Add business number flow
	 * @author ning.xue
	 */
	public void clkBtnChangelanguageSubmit() {
		getReusableActionsInstance().clickWhenReady(btnChangeLanguageSubmit, 30);
	} 
	
	/**
	 * Click the button Done in Add business number flow
	 * @author ning.xue
	 * @return true if button done is clicked else false
	 */
	public boolean clkBtnAddBusinessNumberDone() {
		getReusableActionsInstance().staticWait(1000);
		if(getReusableActionsInstance().isElementVisible(btnAddBusinessNumberDone))
		{
		 getReusableActionsInstance().clickWhenReady(btnAddBusinessNumberDone, 30);
		 return true;
		}
			
		getReusableActionsInstance().clickIfAvailable(btnClose);
		return false;		
	}
	
	/**
	 * Click the button Done in Change language
	 * @author ning.xue
	 * @return true if button done is clicked else false
	 */
	public boolean clkBtnChangeLanguageDone() {
		getReusableActionsInstance().staticWait(1000);
		if(getReusableActionsInstance().isElementVisible(btnChangeLanguageDone))
		{
		 getReusableActionsInstance().clickWhenReady(btnChangeLanguageDone, 30);
		 return true;
		}
			
		getReusableActionsInstance().clickIfAvailable(btnClose);
		return false;		
	}
	
	/**
	 * Check if business number match what has been set
	 * @param strBusinessNumber, String, string of last 4 digit business phone number
	 * @return true if the number match, otherwise false
	 * @author ning.xue
	 */
	public Boolean verifyBusinessNumber(String strBusinessNumber) {
		return getReusableActionsInstance().isElementVisible(By.xpath("//div[contains(text(),'" + strBusinessNumber + "')]"), 30);
	}

	/**
	 * checks if the finish button is displayed
	 * @return true if the button is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean buttonFinishExists() {

		return getReusableActionsInstance().isElementVisible(btnAddContactEmailDone);
	}
	
	/**
	 * Clicks on the close button
	 * @author Mirza.Kamran
	 */
	public void clkCloseButton() {
		getReusableActionsInstance().executeJavaScriptClick(btnClose);
	}

	/**
	 * set the street number
	 * @param strStreetNumber street number
	 * @author Mirza.Kamran
	 */
	public void setStreetNumber(String strStreetNumber) {
		getReusableActionsInstance().getWhenReady(lblStreetNumber).click();;
		getReusableActionsInstance().getWhenReady(txtStreetNumber).sendKeys(strStreetNumber);
		
	}

	/**
	 * set the street name
	 * @param strStreetName street name
	 * @author Mirza.Kamran
	 */
	public void setStreetname(String strStreetName) {
		getReusableActionsInstance().getWhenReady(lblStreetName).click();
		getReusableActionsInstance().getWhenReady(txtStreetName).sendKeys(strStreetName);
	}

	/**
	 * select the street type
	 * @param strStreetType street type
	 * @author Mirza.Kamran
	 */
	public void selectStreetType(String strStreetType) {
		getReusableActionsInstance().selectWhenReadyByVisibleText(cboStreetType,strStreetType);
		
	}

	/**
	 * set the apartment type
	 * @param strApartment apartment value
	 * @author Mirza.Kamran
	 */
	public void setApartment(String strApartment) {
		getReusableActionsInstance().getWhenReady(lblApartmentNumber).click();
		getReusableActionsInstance().getWhenReady(txtApartmentNumber).sendKeys(strApartment);
	}

	/**
	 * set Apartment value
	 * @param strApartmentValue apartment value
	 * @author Mirza.Kamran
	 */
	public void selectAprtmentType(String strApartmentValue) {
		try {
			getReusableActionsInstance().selectWhenReadyByVisibleText(cboApartmentType,strApartmentValue);
		}catch (Exception e) {
					
		}
	}

	/**
	 * Set the city name
	 * @param strCityName city name
	 * @author Mirza.Kamran
	 */
	public void setCityName(String strCityName) {		
		getReusableActionsInstance().getWhenReady(lblCityName).click();
		getReusableActionsInstance().getWhenReady(txtCityName).sendKeys(strCityName);
	}

	/**
	 * select province
	 * @param strProvince province name'
	 * @author Mirza.Kamran
	 */
	public void selectProvince(String strProvince) {
		getReusableActionsInstance().selectWhenReadyByVisibleText(cboProvince,strProvince);
	}

	/**
	 * set postal code
	 * @param strPostalCode postal code value
	 * @author Mirza.Kamran
	 */
	public void setPostalCode(String strPostalCode) {
		getReusableActionsInstance().getWhenReady(lblPostCode).click();
		getReusableActionsInstance().getWhenReady(txtPostalCode).sendKeys(strPostalCode);
		
	}

	/**
	 * click change address continue button
	 * @author Mirza.Kamran
	 */
	public void clkChangeAddresContinueButton() {
		getReusableActionsInstance().clickIfAvailable(btnChangeAddressContinue);
		
	}

	/**
	 * Click selct and submit button
	 * @author Mirza.Kamran
	 */
	public void selectAndSubmit() {
		getReusableActionsInstance().clickIfAvailable(btnSelectAndSubmit);
	}

	/**
	 * Clicks on done button on change billing address
	 * @return true when done button is clicked else false
	 * @author Mirza.Kamran
	 */
	public boolean clickDoneChangeBillingAddress() {
		getReusableActionsInstance().staticWait(1000);
		if(getReusableActionsInstance().isElementVisible(btnChangeAddressDone))
		{
		 getReusableActionsInstance().clickWhenReady(btnChangeAddressDone, 30);
		 return true;
		}
			
		getReusableActionsInstance().clickIfAvailable(btnClose);
		return false;	
	}

	/**
	 * Checks if the billing address is valid
	 * @param strAddress string billing address
	 * @return true if the address is correct
	 */
	public boolean verifyBillingAddress(String strAddress) {		
		return getReusableActionsInstance().getWhenReady(lblBillingAddress).getText().trim().contains(strAddress);
	}

	/**
	 * gets the existing billing address displayed
	 * @return string value containing the billing address
	 * @author Mirza.Kamran
	 */
	public String getExistingBillingAddress() {
		return getReusableActionsInstance().getWhenReady(lblBillingAddress).getText().trim();
	}

	/**
	 * gets the existing language
	 * @return string language name
	 * @author Mirza.Kamran
	 */
	public String getExistingLanguage() {		
		return getReusableActionsInstance().getWhenReady(lblLanguageSection).getText();
	}

	/**
	 * gets the existing language
	 * @return string language name
	 * @author Mirza.Kamran
	 */
	public String getExistingLanguageMobile() {		
		return getReusableActionsInstance().getWhenReady(lblContactsDetailsSectionMobile).getText();
	}
	
	/**
	 * Clicks on the language radio button
	 * @param strlanguage language name
	 * @author Mirza.Kamran
	 */
	public void clkLanguage(String strlanguage) {
		getReusableActionsInstance().clickWhenReady(By.xpath("//span[text()='"+strlanguage+"']"));
		
	}

	/**
	 * New language parameter
	 * @param strNewLanguage Language
	 * @return true if the language is matched
	 * @author Mirza.Kamran
	 */
	public boolean verifyLanguageSetSuccessfully(String strNewLanguage) {		
		return getReusableActionsInstance().isElementVisible(By.xpath("//div[contains(text(),'" + strNewLanguage + "')]"), 30);
	}

	/**
	 * Get the contact email
	 * @return true 
	 *@author Mirza.Kamran
	 */
	public String getContactEmail() {
		return getReusableActionsInstance().getWhenReady(lblContactsDetailsSection).getText();
	}

	/**
	 * Clicks on the submit button
	 * @author Mirza.Kamran
	 */
	public void clkSubmit() {
		getReusableActionsInstance().clickWhenReady(btnSubmit);
		
	}
	
	/**
	 * Clicks on the Change button beside Email
	 * @author ning.xue
	 */
	public void clkBtnChangeEmailMobile() {
		getReusableActionsInstance().clickWhenReady(btnChangeEmailMobile);
		
	}
	
	/**
	 * Clicks on the Add button beside Email
	 * @author ning.xue
	 */
	public void clkBtnAddEmailMobile() {
		getReusableActionsInstance().clickWhenReady(btnAddEmailMobile);
		
	}
	
	/**
	 * Will close the feedback bar if available on mobile
	 * @author Mirza.Kamran
	 */
	public void clkCloseFeedbackIfAvailableMobile() {
		getReusableActionsInstance().clickIfAvailable(btnCloseFeedbackMobile);
	}

	/**
	 * Gets the contact email
	 * @return string value containing contact email
	 * @author Mirza.Kamran
	 */
	public String getContactEmailMobile() {		
		return getReusableActionsInstance().getWhenReady(lblContactEmailOnChgeContactEmailOverlay).getText().toLowerCase();
	}

	public void setContactEmailMobile(String strAltEmail) {
		getReusableActionsInstance().getWhenReady(lblContactEmail).click();
		//getReusableActionsInstance().getWhenReady(inputContactEmail,20).clear();
		getReusableActionsInstance().clickIfAvailable(lblContactEmail);
		getReusableActionsInstance().getWhenReady(inputContactEmail).sendKeys(strAltEmail);
		
	}

	/**
	 * 
	 */
	public void clkLnkUpdateHomeNumberMobile() {
		getReusableActionsInstance().getWhenReady(btnUpdateHomeNumberMobile).click();
		
	}
	
	/**
	 * Set home phone for update home number flow.
	 * @param strHomePhone String, string of home phone
	 * @author Mirza.Kamran
	 */
	public void setHomePhoneMobile(String strHomePhone) {
		getReusableActionsInstance().getWhenReady(lblHomePhone,30).click();
		getReusableActionsInstance().clickIfAvailable(lblHomePhone);
		getReusableActionsInstance().getWhenReady(inputHomePhone,2).sendKeys(strHomePhone);
	}
	
	/**
	 * Set business phone for Add business number flow.
	 * @param strBusinessPhone String, string of business phone
	 * @author Mirza.Kamran
	 */
	public void setBusinessPhoneMobile(String strBusinessPhone) {
		getReusableActionsInstance().getWhenReady(lblBusinessPhone,30).click();
		getReusableActionsInstance().clickIfAvailable(lblBusinessPhone);
		getReusableActionsInstance().getWhenReady(inputBusinessPhone,2).sendKeys(strBusinessPhone);
	}

	/**
	 * 
	 * @return
	 */
	public boolean isVerifyYourIdentityOverlayDisplayed() {			
		return getReusableActionsInstance().isElementVisible(frameVerifyIdentity);
	}
	
	/**
	 * Click continue button
	 * @author Mirza.Kamran
	 */
	public void clkContinueVerifyIdentity() {
		getReusableActionsInstance().getWhenReady(btnContinueVerifyIdentity).click();
	
	}

	public void switchToVerifyIdentityIFrame() {
		getDriver().switchTo().frame(frameVerifyIdentity);		
	}

	public boolean isInEligibleUser() {		
		return (getReusableActionsInstance().isElementVisible(lblSorry)
				&& getReusableActionsInstance().isElementVisible(msgUnableToProceed));
	}
	
	
	/**
	 * Click continue button
	 * @author Mirza.Kamran
	 */
	public void clkClose() {
		getReusableActionsInstance().getWhenReady(btnClose).click();
	
	}
}
