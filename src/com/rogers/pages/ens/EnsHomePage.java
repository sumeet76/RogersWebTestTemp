package com.rogers.pages.ens;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;


public class EnsHomePage extends BasePageClass{

	public EnsHomePage(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy (xpath = "//input[@type='email']")
	WebElement inputEmail;
	
	@FindBy (xpath = "//input[@type='submit']")
	WebElement btnNext;
	
	@FindBy (xpath = "//input[@name='Password']")
	WebElement inputPassword;

	@FindBy (xpath = "//button[@id='details-button']")
	WebElement btnAdvancedSettings;

	@FindBy (xpath = "//a[@id='proceed-link']")
	WebElement btnProceedEns;

	
	@FindBy (xpath = "//span[@class='submit']")
	WebElement btnSignIn;
	
	/**
	 * Open a new tab and launch ENS url.
	 * @param strEnsUrl, string of ENS url.
	 * @author ning.xue
	 */
	public void openNewTabForEns(String strEnsUrl) {
		JavascriptExecutor executor = (JavascriptExecutor)getDriver();
		String openNewWindow = "window.open('"+ strEnsUrl +"', '_blank')";
		executor.executeScript(openNewWindow);
		getReusableActionsInstance().waitForNumberOfWindowsToBe(2, 10);
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs.get(1));
		getReusableActionsInstance().staticWait(5000);
		//getDriver().get(strEnsUrl);
	}
	
	/**
	 * Set the email on login page
	 * @param strEmail email to login
	 * @author ning.xue
	 */
	public void setEmail(String strEmail) {
		getReusableActionsInstance().getWhenReady(inputEmail, 20).clear();
		getReusableActionsInstance().getWhenReady(inputEmail).click();
		getReusableActionsInstance().getWhenReady(inputEmail).sendKeys(strEmail);
	}
	
	/**
	 * Click on the next button
	 * @author ning.xue
	 */
	public void clkBtnNext() {		
		getReusableActionsInstance().getWhenVisible(btnNext,10).click();
	}
	
	/**
	 * Set the password on login page
	 * @param strPassword password to login
	 * @author ning.xue
	 */
	public void setPassword(String strPassword) {

		if(getReusableActionsInstance().isElementVisible(inputPassword)) {
			getReusableActionsInstance().getWhenReady(inputPassword, 20).clear();
			getReusableActionsInstance().getWhenReady(inputPassword).click();
			getReusableActionsInstance().getWhenReady(inputPassword).sendKeys(strPassword);
		}
		
	}
	public void clkSafeToProceed() {

		if(getReusableActionsInstance().isElementVisible(btnAdvancedSettings)) {
			getReusableActionsInstance().getWhenReady(btnAdvancedSettings).click();
			getReusableActionsInstance().getWhenReady(btnProceedEns).click();
		}

	}
	/**
	 * Click on the Sign In button
	 * @author ning.xue
	 */
	public void clkBtnSignIn() {	
		if(getReusableActionsInstance().isElementVisible(btnSignIn)) {
		getReusableActionsInstance().getWhenVisible(btnSignIn,10).click();
		}
	}
	
	 
}
