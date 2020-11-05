package com.rogers.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;



public class RogersRecoverPassOrNamePage extends BasePageClass {
	
	public RogersRecoverPassOrNamePage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//button[text()='Password' or text()=\"Mot de passe\"]")
	WebElement btnPassword;
	
	@FindBy (xpath = "//button[text()='Username' or text()=\"Nom d'utilisateur\"]")
	WebElement btnUserName;
	
	@FindBy (xpath = "//button[text()='Both username and password' or text()=\"Nom d'utilisateur et mot de passe\"]")
	WebElement btnBoth;
	
	@FindBy (xpath = "//input[@formcontrolname='email']")
	WebElement txtEmailAddress;
	
	
	@FindAll({
		@FindBy(xpath = "//span[contains(text(),'Continue') or contains(text(),'Continuer')]/ancestor::button"),
		@FindBy (xpath = "//button[contains(text(),'Continue') or contains(text(),'Continuer')]"),
		@FindBy (xpath = "//button[@class='primary-button state-btn']")	
	})	
	WebElement btnContinue;
	
	@FindBy (xpath = "//div[@class='email-recovery-method']/button")
	WebElement btnEmailNow;
	
	@FindBy (xpath = "//div[@class='sms-recovery-method']/button")
	WebElement btnTextNow;
	
	@FindBy (xpath = "//input[@formcontrolname='smsCode']")
	WebElement txtCode;
	
	@FindBy (xpath = "//button[@class='primary-button state-btn']")
	WebElement btnVerifyMe;
	
	@FindBy (xpath = "//input[@formcontrolname='newPassword']")
	WebElement txtNewPass;
	

	@FindBy (xpath = "//input[@formcontrolname='newPassword']/parent::div")
	WebElement lblNewPass;
	
	
	@FindBy (xpath = "//input[@formcontrolname='confirmPassword']")
	WebElement txtConfirmNewPass;
	
	@FindBy (xpath = "//input[@formcontrolname='confirmPassword']/parent::div")
	WebElement lblConfirmNewPass;
	
	@FindBy (xpath = "//button[contains(text(),'Set password') or contains(text(),'de passe')]")
	WebElement btnSetPassword;

	@FindBy(xpath = "//button[contains(text(),'Text to') or contains(text(),'texte')]")
	WebElement btnTextToRecovery; 
	
	@FindBy(xpath = "//*[@id='signin-interceptor-modal']//iframe")
	WebElement iframe;

	@FindBy(xpath = "//button[text()='Sign in to MyRogers' or text()='Accéder à MonRogers']")
	WebElement btnLogInToMyAccount;

	@FindBy(xpath = "//span[text()='Your password has been reset!' or text()='Votre mot de passe a été réinitialisé.']")
	WebElement txtYourPasswordHasBeenReset;
	
	@FindBy(xpath = "//i[@class='rogers-icon-circle-x']")
	WebElement btnCloseWeHaveTextedUserNameOverlay;

	@FindBy(xpath = "//input[@formcontrolname='accountNumber']")
	WebElement txtAcountNumber;
		
	@FindAll({
	@FindBy (xpath = "//*[contains(text(),'username is') or contains(text(),'Votre nom d’utilisateur est')]/parent::tr/following-sibling::tr/td"),
	@FindBy (xpath = "/html/body/table[1]//b[contains(text(),'Your username is') or contains(text(),'Votre nom d’utilisateur est')]/parent::td")})
	WebElement lblYourUsername;
	
	@FindBy (xpath = "/html/body/table[1]//img[@alt='Return to sign in' or @alt='Ouvrir une session']")
	WebElement btnReturnToSignin;

	@FindBy(xpath = "//a[text()='Use your account information instead.'or contains(text(),'t les renseignements de votre compte')]")
	WebElement lnkUseYourAccountInfoInstead;

	@FindBy(xpath = "//input[@formcontrolname='accountNumber']/parent::div")
	WebElement lblAccountNumber;

	@FindBy(xpath = "//input[@formcontrolname='postalCode']/parent::div")
	WebElement lblPostCode;

	@FindBy(xpath = "//input[@formcontrolname='postalCode']")
	WebElement txtPostCode;
		
	@FindBy(xpath = "//input[@formcontrolname='dob']/parent::div")
	WebElement lblDOB;

	@FindBy(xpath = "//input[@formcontrolname='dob']")
	WebElement txtDOB;

	@FindBy(xpath = "//ds-code-input/div/div[1]/input")
	WebElement inputCode;

	@FindBy(xpath = "//span[text()='Create a new MyRogers password for ' or contains(text(),'ez un nouveau mot de passe MonRogers pour')]/following-sibling::span")
	WebElement lblSetPasswordForUserName;

	@FindBy(xpath = "//h1//span[text()='Success!' or contains(text(),'ussi!')]")
	WebElement lblYourPasswordHasBeenReset;
	
	@FindBy(xpath = "//button//*[text()='Go to MyRogers' or contains(text(),'MonRogers')]")
	WebElement btnGoToMyRogers;

	@FindBy(xpath = "//input[@formcontrolname='username']")
	WebElement txtUsername;

	@FindBy(xpath = "//td[text()=' Verification code: ' or contains(text(),'Code de v')]/parent::tr/following-sibling::tr/td")
	WebElement lblYourVerificationCode;
	
	
	public void clkBtnPassword() {
		getReusableActionsInstance().getWhenVisible(btnPassword).click();
	}
	
	/**
	 * Click on the UserName button in user name and password recovery flow.
	 * @author Ning.Xue
	 */
	public void clkBtnUserName() {
		getReusableActionsInstance().getWhenVisible(btnUserName).click();
	}
	
	/**
	 * Click on Both button in user name and password recovery flow.
	 * @author Ning.Xue
	 */
	public void clkBtnBoth() {
		getReusableActionsInstance().getWhenVisible(btnBoth).click();
	}
	
	/**
	 * Input user name (email address) to the text area.
	 * @param strUsername, String, use email address as user name.
	 * @author ning.xue
	 */
	public void setEmailAddress(String strUsername) {
		getReusableActionsInstance().getWhenReady(txtEmailAddress).clear();
		getReusableActionsInstance().getWhenReady(txtEmailAddress).sendKeys(strUsername);
	}
	
	/**
	 * Click continue button  user name and password recovery flow.
	 * @author Ning.Xue
	 */
	public void clkBtnContinue() {
		getReusableActionsInstance().getWhenVisible(btnContinue).click();
	}
	//For captcha bypass
	public void sendEnter() {
		getReusableActionsInstance().getWhenVisible(btnContinue).sendKeys(Keys.ENTER);
		getReusableActionsInstance().getWhenVisible(btnContinue).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Click EmailNow button in user name and password recovery flow.
	 * @author Ning.Xue
	 */
	public void clkBtnEmailNowIfAvailable() {
		if (getReusableActionsInstance().isElementVisible(btnEmailNow, 5)) {
			getReusableActionsInstance().getWhenVisible(btnEmailNow).click();
		}
		
	}
	
	/**
	 * Click TextNow button in user name and password recovery flow.
	 * @author Ning.Xue
	 */
	public void clkBtnTextNow() {
		getReusableActionsInstance().getWhenReady(btnTextNow).click();
	}
	
	/**
	 * Input verification code to the text area in user name and password recovery flow.
	 * @param strCode, String of verification code
	 * @author Ning.Xue
	 */
	public void setCode(String strCode) {
		//getReusableActionsInstance().getWhenReady(txtCode).clear();
		getReusableActionsInstance().getWhenReady(txtCode).sendKeys(strCode);
	}
	
	/**
	 * Click VerifyMe button in user name and password recovery flow.
	 * @author Ning.Xue
	 */
	public void clkBtnVerifyMe() {
		getReusableActionsInstance().getWhenVisible(btnVerifyMe).click();
	}
	
	/**
	 * Input NewPassword to the new password text area in user name and password recovery flow.
	 * @param strNewPass, String of new password
	 * @author Ning.Xue
	 */
	public void setNewPassword(String strNewPass) {
		getReusableActionsInstance().getWhenReady(lblNewPass).click();
		//getReusableActionsInstance().getWhenReady(txtNewPass).clear();
		getReusableActionsInstance().getWhenReady(txtNewPass).sendKeys(strNewPass);
	}
	
	/**
	 * Input ConfirmPassword to the confirm password text area in user name and password recovery flow.
	 * @param strNewPass String of new password
	 * @author Ning.Xue
	 */
	public void setConfirmPassword(String strNewPass) {
		getReusableActionsInstance().getWhenReady(lblConfirmNewPass).click();
		//getReusableActionsInstance().getWhenReady(txtConfirmNewPass).clear();
		getReusableActionsInstance().getWhenReady(txtConfirmNewPass).sendKeys(strNewPass);
	}
	
	/**
	 * Click SetPassword button in user name and password recovery flow.
	 * @author Ning.Xue
	 */
	public void clkBtnSetPassword() {
		getReusableActionsInstance().waitForElementTobeClickable(btnSetPassword, 20);
		getReusableActionsInstance().executeJavaScriptClick(btnSetPassword);
		//getReusableActionsInstance().getWhenReady(btnSetPassword).click();
	}

	/**
	 * Click on text to recovery
	 * @author Mirza.Kamran
	 */
	public void clkTextToAsRecoveryOption() {
		getReusableActionsInstance().getWhenReady(btnTextToRecovery).click();
		
	}

	/**
	 * Switches to the iframe for setting code
	 * @author Mirza.Kamran
	 */
	public void switchToSetCodeIframe() {		
		getReusableActionsInstance().waitForFrameToBeAvailableAndSwitchToIt(iframe, 30);
	}

	/**
	 *Click on Verify Me
	 *@author Mirza.Kamran 
	 */
	public void clickVerifyMe() {
		getReusableActionsInstance().getWhenReady(btnVerifyMe).click();
		
	}

	/**
	 * Click into my account
	 * @author Mirza.Kamran
	 */
	public void clkLogInToMyAccount() {
		getReusableActionsInstance().getWhenReady(btnLogInToMyAccount).click();
	}

	/**
	 * Is password reset success displayed
	 * @return true if password reset successful else false
	 * @author Mirza.Kamran
	 */
	public boolean isPasswordRestSuccessIsDisplayed() {		
		return getReusableActionsInstance().isElementVisible(txtYourPasswordHasBeenReset);
	}

	/**
	 * Is password reset success displayed
	 * @return true if password reset successful else false
	 * @author Mirza.Kamran
	 */
	public boolean isPasswordRestSuccessForRecoveredUsernameOrPwd() {		
		return getReusableActionsInstance().isElementVisible(lblYourPasswordHasBeenReset);
	}
	
	/**
	 * Switches back to default content
	 * @author Mirza.Kamran
	 */
	public void switchToDefaultContent() {
		getDriver().switchTo().defaultContent();
	}

	/**
	 * Clicks on Close button we have texted username overlay
	 * @author Mirza.Kamran
	 */
	public void clkBtnCloseWeHaveTextedUserNameOverlay() {		
		getReusableActionsInstance().getWhenReady(By.xpath("//input[@formcontrolname='newPassword']/parent::div")).click();
		getReusableActionsInstance().getWhenReady(txtNewPass).sendKeys("rogers123");
		getReusableActionsInstance().getWhenReady(By.xpath("//input[@formcontrolname='confirmPassword']/parent::div")).click();
		getReusableActionsInstance().getWhenReady(txtConfirmNewPass).sendKeys("rogers123");
		//getReusableActionsInstance().clickWhenReady(btnCloseWeHaveTextedUserNameOverlay);
	}

	/**
	 * Sets the account number for recovery
	 * @param strAccountNumber, String, CTN 
	 * @author Mirza.Kamran
	 */
	public void setAccountNumber(String strAccountNumber) {
		getReusableActionsInstance().waitForElementTobeClickable(lblAccountNumber, 30);
		getReusableActionsInstance().getWhenReady(lblAccountNumber).click();
		//getReusableActionsInstance().getWhenReady(txtAcountNumber).clear();
		getReusableActionsInstance().getWhenReady(txtAcountNumber).sendKeys(strAccountNumber);
	}
	
	/**
	 * To get the recovery user name
	 * @return String, the recovered user name
	 * @author ning.xue
	 */
	public String getRecoveryUsername() {	
		String strMsg = lblYourUsername.getText();
		return strMsg.substring(strMsg.indexOf(":")+1).trim();
	}

	/**
	 * Click button "Return to Signin"
	 * @author ning.xue
	 */
	public void clkBtnReturnToSignin() {
		getReusableActionsInstance().getWhenReady(btnReturnToSignin).click();
	}
	
	/**
	 * Switch driver to set password tab
	 * @param intTabIndex, integer, the index of the tab
	 * @author ning.xue
	 */
	public void switchToSigninPage(int intTabIndex) {
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs.get(intTabIndex));
	}

	/**
	 * Clicks on the account link
	 * @author Mirza.Kamran
	 */
	public void clkUseYourAccountInfoInsteadLink() {
	  getReusableActionsInstance().getWhenReady(lnkUseYourAccountInfoInstead).click();
	}

	/**
	 * Sets the Postcode number for recovery
	 * @param strPostcode, String, postcode 
	 * @author Mirza.Kamran
	 */
	public void setPostCode(String strPostcode) {	
			getReusableActionsInstance().getWhenReady(lblPostCode).click();
			//getReusableActionsInstance().getWhenReady(txtPostCode).clear();
			getReusableActionsInstance().getWhenReady(txtPostCode).sendKeys(strPostcode);
	
	}

	/**
	 * Sets the DOB  for recovery
	 * @param strDOB, String, DOB 
	 * @author Mirza.Kamran
	 */
	public void setDOB(String strDOB) {
		getReusableActionsInstance().getWhenReady(lblDOB).click();
		//getReusableActionsInstance().getWhenReady(txtDOB).clear();
		getReusableActionsInstance().getWhenReady(txtDOB).sendKeys(strDOB);
	}

	/**
	 * @param strRecoveredUserName 
	 * 
	 */
	public void setRecoveryCode(String strRecoveredUserName) {
		
		getReusableActionsInstance().getWhenReady(inputCode).sendKeys(strRecoveredUserName);
	}

	/**
	 * gets the username 
	 * @author Mirza.Kamran
	 * @return string value username
	 */
	public String getRecoveryUsernameNew() {
		return getReusableActionsInstance().getWhenReady(lblSetPasswordForUserName).getText().trim();
		
	}
	
	/**
	 * Clicks on Go to my rogers
	 * @author Mirza.Kamran
	 */
	public void clkGoToMyRogers()
	{
		getReusableActionsInstance().getWhenReady(btnGoToMyRogers).click();
	}

	/**
	 * Sets the username for password recovery
	 * @param strUsername username
	 * @author Mirza.Kamran
	 */
	public void setUsernameIFrame(String strUsername) {		
		getReusableActionsInstance().getWhenVisible(txtUsername).sendKeys(strUsername);
		
	}

	public String getVerificationCodeForRecoverUsername() {
		String strMsg = getReusableActionsInstance().getWhenReady(lblYourVerificationCode).getText();
		return strMsg.trim();
	}
}
