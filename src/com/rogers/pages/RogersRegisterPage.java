package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

/**
 * 
 * @author rajesh.varalli1
 *
 */

public class RogersRegisterPage extends BasePageClass {

	public RogersRegisterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[contains(text(),'Wireless') or contains(text(),'services sans-fil')]")
	WebElement btnWirelessResidentialServices;

	@FindBy(xpath = "//div[@class='account-input']/input[@name='accountNumber']")
	WebElement txtAccountNumber;
	
	@FindBy(xpath = "//div[@class='postal-code']/input[@name='postalCode']")
	WebElement txtPostalCode;
	
	@FindBy(xpath = "//button[text()='Continue' or text()='Continuer']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement txtEnterEmail;
	
	@FindBy(xpath = "//input[@name='confirmEmail']")
	WebElement txtReEnterEmail;
	
	@FindBy(xpath = "//div[contains(@class,'one-or-more')]//button[contains(@class,'ute-primary-button')]")
	WebElement btnSelectService;
	
	@FindBy(xpath = "//button[contains(@class,'ute-primary-button')]")
	WebElement btnPrimaryButton;
	
	@FindBy(xpath = "//button[contains(@class,'ute-primary-button')]")
	WebElement btnContinueEmailVarification;
	
	@FindBy(xpath = "//iframe[contains(@src,'/web/totes/easylogin/signin')]")
	WebElement fraSignIn;
	
	@FindBy(xpath = "//a[text()='Register' or text()='S'inscrire']")
	WebElement lnkRegister;
	
	@FindBy(xpath = "//button[contains(@class,'ute-primary-button')]")
	WebElement btnRegisterNow;
	
	@FindAll({
	@FindBy(xpath = "//h1[contains(text(),'Already registered')]"),
	@FindBy(xpath = "//span[contains(text(),'This account is registered to:') or contains(text(),'compte est inscrit à l’adresse suivante')]")})
	WebElement lblProfileAlready;
	
	@FindBy(xpath = "//span[contains(text(),'able to find that account and/or postal code') or contains(text(),'avons pas trouvé ce compte ou ce code postal.')]")
	WebElement lblUnableToFindAccount;
	/**
	 * Clicks on the 'Wireless/Residential Services' button
	 * @author rajesh.varalli1
	 */
	public void clickWirelessOrResidentialServices() {
		 Capabilities cap = ((RemoteWebDriver)getDriver()).getCapabilities();
		if(cap.getBrowserName().toLowerCase().contains("firefox")) {
		reusableActions.getDriver().switchTo().defaultContent();//added for firefox dead object issue handling
		reusableActions.waitForElementTobeClickable(btnWirelessResidentialServices, 30);
		reusableActions.executeJavaScriptClick(btnWirelessResidentialServices);
		}else
		{
			reusableActions.clickWhenReady(btnWirelessResidentialServices);
		}
	}
	
	/**
	 * Enters the Account Number
	 * @param strAccountNumber Valid Account Number
	 * @author rajesh.varalli1
	 */
	public void setAccountNumber(String strAccountNumber) {
		txtAccountNumber.sendKeys(strAccountNumber);
	}
	
	/**
	 * Enters the Postal Code
	 * @param strPostalCode Valid Postal Code in A1A1A1 format 
	 * @author rajesh.varalli1
	 */
	public void setPostalCode(String strPostalCode) {
		txtPostalCode.sendKeys(strPostalCode);
	}
	
	/**
	 * Clicks on the 'Continue' button
	 * @return true if acoount found else false
	 * @author rajesh.varalli1
	 */
	public boolean clickContinue() {
		boolean clickSuccess=false;
		int count=0;
		while (count<=2 && !clickSuccess) {
			System.out.println("Attempt: "+(count+1)+" Trying to find Ban and postcode");
			reusableActions.clickIfAvailable(btnContinue);			
			if(reusableActions.isElementVisible(lblUnableToFindAccount, 10))
			{				
				count++;
			}else {				
				clickSuccess=true;				
				break;
			}
			
		}
		return clickSuccess;
		
	}
	
	/**
	 * Enters the email on the 'Enter email' field
	 * @param strEmail email address
	 * @author rajesh.varalli1
	 */
	public void setEmail(String strEmail) {
		txtEnterEmail.sendKeys(strEmail);
	}
	
	/**
	 * Enters the email on the 'Re-enter email' field
	 * @param strEmail email address
	 * @author rajesh.varalli1
	 */
	public void setReEnterEmail(String strEmail) {
		txtReEnterEmail.sendKeys(strEmail);
	}
	
	/**
	 * Validates whether the Error message is displayed or NOT
	 * @param strError Error Message text
	 * @return true if Error appears; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyExistingProfileError(String strError) {
		return (strError.toUpperCase().contains(driver.findElement(By.xpath("//div[@class='inline-error']/span[1]")).getText().toUpperCase()) &&
				strError.toUpperCase().contains(driver.findElement(By.xpath("//div[@class='inline-error']/span[2]")).getText().toUpperCase()));
	}

	/**
	 * Clicks on sekect service button
	 * @author Chinnarao.Vattam
	 */
	public void clkSelectService() {		
		reusableActions.scrollToElement(btnSelectService);
		reusableActions.clickWhenReady(btnSelectService,20);
	}

	
	/**
	 * Clicks on the Continue button on register page to validate email and to send the set password link
	 * @author chinnarao.vattam
	 */
	public void clkContinueEmailVarification() {
		reusableActions.getWhenReady(btnContinueEmailVarification).click();
	}
	
	/**
	 * Clicks on the 'Register' link on the Sign-in overlay
	 * @author rajesh.varalli1 
	 */
	public void clickRegister() {
		driver.switchTo().frame(fraSignIn);
		reusableActions.clickIfAvailable(lnkRegister);
	}
	
	/**
	 * Clicks on the 'Register Now' button on the Sign-in overlay
	 * @author rajesh.varalli1 
	 */
	public void clickRegisterNow() {
		reusableActions.clickIfAvailable(btnRegisterNow);
	}

	public boolean isProfileAlreadyStarted() {		
		return reusableActions.isElementVisible(lblProfileAlready);
	}
}