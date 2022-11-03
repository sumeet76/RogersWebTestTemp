package com.rogers.pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;



public class RogersLoginPage extends BasePageClass {

	public RogersLoginPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(xpath = "//input[@type='email']")
	WebElement txtUsername;

	@FindBy(xpath="//input[@id='username']")
	WebElement txtUsernameMobile;

	@FindBy(xpath="//input[@id='password']")
	WebElement txtPasswordMobile;

	@FindBy(xpath = "//input[@type='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@title='Sign in' or @title='Select to sign in to MyRogers']")
	WebElement btnSignIn;

	@FindBy(xpath = "//iframe[contains(@src,'/web/totes/easylogin/signin')]")
	WebElement fraSignIn;
	
	@FindBy (xpath = "//ds-alert[@variant='error']")
	WebElement failLoginMsg;

	@FindBy(xpath = "//button[@title='Sauter cette étape' or @title= 'Skip']")
	WebElement btnSkip;

	@FindBy(xpath = "//h5[@class='registerButton']//*[text()='Register' or text()=\"S'inscrire\"]")
	WebElement lnkRegister;
	
	@FindBy(xpath = "//button[text()='Register now' or text()=\"S'inscrire maintenant\"]")
	WebElement btnRegisterNow;

	@FindBy(xpath = "//a[@class='m-navLink -navbar -login']")
	WebElement lnkUserName;

	@FindBy(xpath = "//a[@title='Sign out' or @title='Fermer la session' and @tabindex='0']")
	WebElement lnkSignOut;
		
	@FindAll({
		@FindBy(xpath = "//dsa-header/header[contains(@class,'rcl-header l-headerDesk')]//*[text()='Sign in' or text()='Connexion']"),
        @FindBy(xpath = "//div[@class='dds-navbar-nav']//a[@aria-label='Sign in to My Rogers']//span[text()='Sign in'  or text()='Connexion']"),
        @FindBy(xpath = "//a[contains(@class,'signin-interceptor dds_m-navLink -navbar -login dropdown-hide')]")})	
	WebElement lnkReSignInAs;

	@FindBy(xpath = "//a[text()='Forgot username and/or password?' or contains(text(),\"Nom d'utilisateur ou mot de passe oublié?\")]")
	WebElement btnForgotUserNameAndPassword;
	
	@FindBy(xpath = "//span[text()='Forgot username' or contains(text(),'utilisateur oubli')]")
	WebElement lnkForgotUserName;

	@FindBy(xpath = "//input[@id='input_password' or @id='password']/parent::div[contains(@class,'ds-formField__inputContainer')]")
	WebElement lblPassword;
	
	@FindBy(xpath = "//input[@formcontrolname='username']/parent::div[contains(@class,'ds-formField__inputContainer')]")
	WebElement lblUserName;

	@FindBy(xpath = "//span[text()='Forgot password ' or contains(text(),'Mot de passe oubli')]")
	WebElement lnkForgotPassword;

	@FindBy(xpath = "//div[contains(@class,'cdk-overlay-pane ds-modalWindow')]")
	WebElement overlayContainer;

	@FindBy(xpath = "//a[@title='Continue in browser']/span/span")
	WebElement btnContinueInBrowser;

	@FindBy(xpath="//button//span[text()='Continue' or text()='Continuer']")
	WebElement btnContinueSignIn;


	/**
	 * To switch to the iframe
	 * @author chinnarao.vattam
	 */
	public void switchToSignInIFrame() {
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().getWhenReady(fraSignIn,10);
		getDriver().switchTo().frame(fraSignIn);
//		getReusableActionsInstance().waitForFrameToBeAvailableAndSwitchToIt(fraSignIn, 30);
	}
	
	/**
	 * Is sign in frame displayed
	 * @return boolean, true if sign-in iframe is displayed, otherwise false.
	 * @author Mirza.Kamran
	 */
	 public boolean isSignInFrameDisplayed() {
		 return (getReusableActionsInstance().isElementVisible(fraSignIn,30)
				 || getReusableActionsInstance().isElementVisible(lblPassword)
				 || getReusableActionsInstance().isElementVisible(txtPassword));
	 }
	/**
	 * Check if the overlay container to continue in browser is display or not
	 * @return true if it display, otherwise false.
	 * @author manpreet.kaur3
	 */
	public Boolean isOverlayContainerDisplayed() {
		return getReusableActionsInstance().isElementVisible(overlayContainer);
	}
	/**
	 * To Click Continue in browser button on login page
	 * @author manpreet.kaur3
	 */
	public void clkContinueInBrowser() {
		getReusableActionsInstance().waitForElementVisibility(btnContinueInBrowser, 30);
		getReusableActionsInstance().clickWhenReady(btnContinueInBrowser);
	}

	/**
	 * Click continue button after entering username
	 * @author Konstantin.Stoianov
	 */
	public void clkContinueSignIn(){
		getReusableActionsInstance().clickWhenReady(btnContinueSignIn, 5);
	}

	/**
	 * Enter the user name on Sign in frame
	 * @param strUsername user name to be login
	 * @author chinnarao.vattam
	 */	

	public void setUsernameIFrame(String strUsername) {
		getReusableActionsInstance().getWhenReady(lblUserName,20).click();
		getReusableActionsInstance().getWhenVisible(txtUsername, 30).clear();
		//getReusableActionsInstance().clickIfAvailable(lblUserName,20);
		getReusableActionsInstance().getWhenVisible(txtUsername).sendKeys(strUsername);
		//getReusableActionsInstance().clickWhenReady(lblUserName,5);
		//getReusableActionsInstance().getWhenVisible(txtUsername, 5).clear();
		//getReusableActionsInstance().clickIfAvailable(lblUserName,5);
		//getReusableActionsInstance().getWhenVisible(txtUsername).sendKeys(strUsername);
		//getReusableActionsInstance().enterText(txtUsername, strUsername, 5);
	}

	/**
	 * Enter the user name on Mobile login page
	 * @param strUsername user name to be login
	 * @author manpreet.kaur3
	 */

	public void setUsernameMobile(String strUsername) {
		getReusableActionsInstance().getWhenReady(txtUsernameMobile).sendKeys(strUsername);
	}

	/**
	 * Enter the password on Mobile login page
	 * @param strPassword user password to be login
	 * @author manpreet.kaur3
	 */
	public void setPasswordMobile(String strPassword) {
			getReusableActionsInstance().getWhenReady(lblPassword).click();
			//getReusableActionsInstance().getWhenVisible(txtPasswordMobile, 20).clear();
			getReusableActionsInstance().getWhenVisible(txtPasswordMobile).sendKeys(strPassword);

	}
	/**
	 * Enter the user name on Sign in frame
	 * @param strUsername user name to be login
	 * @author chinnarao.vattam
	 */	

	public void setUsernameIFrameMobile(String strUsername) {
		//getReusableActionsInstance().clickIfAvailable(lblUserName,20);
		getReusableActionsInstance().getWhenVisible(txtUsername, 30).clear();
		getReusableActionsInstance().getWhenVisible(txtUsername).sendKeys(strUsername);
	}
	
	
	/**
	 * Enter the password on Sign in frame
	 * @param strPassword user password to be login
	 * @author chinnarao.vattam
	 */
	public void setPasswordIFrame(String strPassword) {
		//getReusableActionsInstance().waitForElementTobeClickable(txtPassword, 30);
		try {
			getReusableActionsInstance().scrollToElement(lblPassword);
			getReusableActionsInstance().getWhenReady(lblPassword).click();
			getReusableActionsInstance().getWhenVisible(txtPassword, 20).clear();
			getReusableActionsInstance().getWhenVisible(txtPassword).sendKeys(strPassword);
		}catch (Exception ex)
		{
			//getReusableActionsInstance().scrollToElement(lblPassword);
			getReusableActionsInstance().getWhenReady(lblPassword).click();
			getReusableActionsInstance().getWhenVisible(txtPassword, 20).clear();
			getReusableActionsInstance().getWhenVisible(txtPassword).sendKeys(strPassword);
		}

	}

	/**
	 * Enter the password on Sign in frame
	 * @param strPassword user password to be login
	 * @author chinnarao.vattam
	 */
	public void setPasswordIFrameMobile(String strPassword) {
		//getReusableActionsInstance().waitForElementTobeClickable(txtPassword, 30);
		try {
			getReusableActionsInstance().scrollToElement(btnSignIn);
			getReusableActionsInstance().getWhenReady(lblPassword).click();
			getReusableActionsInstance().getWhenVisible(txtPassword, 20).clear();
			getReusableActionsInstance().getWhenVisible(txtPassword).sendKeys(strPassword);
		}catch (Exception ex)
		{
			getReusableActionsInstance().scrollToElement(btnSignIn);
			getReusableActionsInstance().getWhenReady(lblPassword).click();
			getReusableActionsInstance().getWhenVisible(txtPassword, 20).clear();
			getReusableActionsInstance().getWhenVisible(txtPassword).sendKeys(strPassword);
		}

	}

	/**
	 * Click on the SignIn button
	 * @author chinnarao.vattam
	 */
	public void clkSignInIFrame() {
		try {
			getReusableActionsInstance().waitForElementTobeClickable(btnSignIn, 2);
			getReusableActionsInstance().getWhenReady(btnSignIn, 20).click();
			//getReusableActionsInstance().clickIfAvailable(btnSkip);
		}catch (ElementClickInterceptedException ex) {
			getReusableActionsInstance().getWhenReady(btnSignIn, 20).click();
		}
	}
	//*[text()='Remember username']
	/**
	 * Check if the login failed message displayed
	 * @return true if login fail message is displayed, otherwise false.
	 */
	public boolean verifyLoginFailMsgIframe() {
		return getReusableActionsInstance().isElementVisible(failLoginMsg, 10);
	}

	/**
	 * Click on the skip button on secure sign in recovery popup
	 * @author chinnarao.vattam
	 */
	public void clkSkipIFrame() {
		getReusableActionsInstance().clickIfAvailable(btnSignIn,2);
		getReusableActionsInstance().clickIfAvailable(btnSkip,10);
		if(getReusableActionsInstance().isElementVisible(btnSkip, 10)) {
			getReusableActionsInstance().clickWhenReady(btnSkip);
		}
	}
	
	/**
	 * Switch out from the frame
	 * @author chinnarao.vattam
	 */
	public void switchOutOfSignInIFrame() {
		getDriver().switchTo().defaultContent();
	}
	
	/**
	 * Clicks on the 'Register' link on the Sign-in overlay
	 * @author rajesh.varalli1 
	 */
	public void clickRegister() {
		getReusableActionsInstance().getWhenReady(lnkRegister).click();
	}
	
	
	/**
	 * Clicks on the 'Register Now' button on the Sign-in overlay
	 * @author rajesh.varalli1 
	 */
	public void clickRegisterNow() {
		getReusableActionsInstance().clickIfAvailable(btnRegisterNow);
	}

	/**
	 * Clicks on sign out
	 * @author Mirza.Kamran
	 */
	public void clickSignOut() {
		getReusableActionsInstance().clickIfAvailable(lnkUserName);
		getReusableActionsInstance().waitForElementVisibility(lnkSignOut, 20);
		getReusableActionsInstance().clickIfAvailable(lnkSignOut);
		getReusableActionsInstance().waitForPageLoad();
		
	}
	
	/**
	 * Click on SignInAs in header Navigation bar after user logout
	 * @author Mirza.Kamran
	 */
	public void clkSignInAs() {	
		boolean clickSuccess=false;
		int count=0;
		while (count<=3 && !clickSuccess) {
			if(!getReusableActionsInstance().isElementVisible(fraSignIn))
			{
				getReusableActionsInstance().waitForElementTobeClickable(lnkReSignInAs, 120);
				getReusableActionsInstance().javascriptScrollByVisibleElement(lnkReSignInAs);
				getReusableActionsInstance().executeJavaScriptClick(lnkReSignInAs);
				getReusableActionsInstance().staticWait(3000);
				if(getReusableActionsInstance().isElementVisible(fraSignIn))
				{
					clickSuccess=true;
					break;
				}
				count++;
			}else
			{
				clickSuccess=true;
				break;
			}
			
		}
		
	}

	/**
	 * Click on button forgot username and password
	 * @author Mirza.Kamran
	 */
	public void clkForgotPassOrNameIframe() {	
		
		getReusableActionsInstance().clickIfAvailable(btnForgotUserNameAndPassword);
	}

	/**
	 * Clicks on Forgot Username iframe
	 */
	public void clkForgotUsernameIframe() {
		getReusableActionsInstance().getWhenReady(lnkForgotUserName).click();
		
	}

	
	/**
	 * Clicks on Forgot Password iframe
	 * @author Mirza.Kamran
	 */
	public void clkForgotPasswordIframe() {
		getReusableActionsInstance().getWhenReady(lnkForgotPassword).click();
		
	}
	
}
