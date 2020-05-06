package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;



public class RogersLoginPage extends BasePageClass {

	public RogersLoginPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(id = "username")
	WebElement txtUsername;

	@FindBy(id = "password")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@data-dtname='signin submit']")
	WebElement btnSignIn;

	@FindBy(xpath = "//iframe[contains(@src,'/web/totes/easylogin/signin')]")
	WebElement fraSignIn;
	
	@FindBy (xpath = "//span[contains(text(),'is not recognized') or contains(text(),'entré n’est pas reconnu')]")
	WebElement failLoginMsg;

	@FindBy(xpath = "//button[text()='Skip' or text()='Continuer']")
	WebElement btnSkip;
	
	@FindBy(xpath = "//a[text()='Register' or text()=\"S'inscrire\"]")
	WebElement lnkRegister;
	
	@FindBy(xpath = "//button[text()='Register now' or text()=\"S'inscrire maintenant\"]")
	WebElement btnRegisterNow;

	@FindBy(xpath = "//a[@class='m-navLink -navbar -login']")
	WebElement lnkUserName;

	@FindBy(xpath = "//a[@title='Sign out' or @title='Fermer la session' and @tabindex='0']")
	WebElement lnkSignOut;

	@FindBy(xpath = "//a[contains(@class,'signin-interceptor dds_m-navLink -navbar -login dropdown-hide')]")
	WebElement lnkReSignInAs;

	@FindBy(xpath = "//a[text()='Forgot username and/or password?' or contains(text(),\"Nom d'utilisateur ou mot de passe oublié?\")]")
	WebElement btnForgotUserNameAndPassword;

	/**
	 * To switch to the iframe
	 * @author chinnarao.vattam
	 */
	public void switchToSignInIFrame() {
		reusableActions.waitForFrameToBeAvailableAndSwitchToIt(fraSignIn, 100);
	}
	
	/**
	 * Enter the user name on Sign in frame
	 * @param strUsername user name to be login
	 * @author chinnarao.vattam
	 */	

	public void setUsernameIFrame(String strUsername) {
		reusableActions.getWhenVisible(txtUsername, 30).clear();
		reusableActions.getWhenVisible(txtUsername).sendKeys(strUsername);
	}
	/**
	 * Enter the password on Sign in frame
	 * @param strPassword user password to be login
	 * @author chinnarao.vattam
	 */
	public void setPasswordIFrame(String strPassword) {
		reusableActions.getWhenVisible(txtPassword,20).clear();
		reusableActions.getWhenVisible(txtPassword).sendKeys(strPassword);
	}

	/**
	 * Click on the SignIn button
	 * @author chinnarao.vattam
	 */
	public void clkSignInIFrame() {
		reusableActions.getWhenReady(btnSignIn,30).click();		
		
	}
	
	/**
	 * Check if the login failed message displayed
	 * @return true if login fail message is displayed, otherwise false.
	 */
	public Boolean verifyLoginFailMsgIframe() {
		return reusableActions.isElementVisible(failLoginMsg, 30);
	}

	/**
	 * Click on the skip button on secure sign in recovery popup
	 * @author chinnarao.vattam
	 */
	public void clkSkipIFrame() {
		reusableActions.clickIfAvailable(btnSkip,30);
	}
	
	/**
	 * Switch out from the frame
	 * @author chinnarao.vattam
	 */
	public void switchOutOfSignInIFrame() {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * Clicks on the 'Register' link on the Sign-in overlay
	 * @author rajesh.varalli1 
	 */
	public void clickRegister() {
		reusableActions.clickIfAvailable(lnkRegister);
	}
	
	
	/**
	 * Clicks on the 'Register Now' button on the Sign-in overlay
	 * @author rajesh.varalli1 
	 */
	public void clickRegisterNow() {
		reusableActions.clickIfAvailable(btnRegisterNow);
	}

	/**
	 * Clicks on sign out
	 * @author Mirza.Kamran
	 */
	public void clickSignOut() {
		reusableActions.clickIfAvailable(lnkUserName);
		reusableActions.waitForElementVisibility(lnkSignOut, 20);
		reusableActions.clickIfAvailable(lnkSignOut);
		reusableActions.waitForPageLoad();
		
	}
	
	/**
	 * Click on SignInAs in header Navigation bar after user logout
	 * @author Mirza.Kamran
	 */
	public void clkSignInAs() {	
		boolean clickSuccess=false;
		int count=0;
		while (count<=3 && !clickSuccess) {
			if(!reusableActions.isDisplayed(fraSignIn))
			{
				reusableActions.waitForElementTobeClickable(lnkReSignInAs, 120);
				reusableActions.javascriptScrollByVisibleElement(lnkReSignInAs);
				reusableActions.executeJavaScriptClick(lnkReSignInAs);
				reusableActions.staticWait(3000);
				if(reusableActions.isDisplayed(fraSignIn))
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
		reusableActions.clickIfAvailable(btnForgotUserNameAndPassword);
	}

	

	
}
