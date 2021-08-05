package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LaunchPage extends BasePageClass {

	public LaunchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='agent-roles']")
	WebElement userRoles;
	
	@FindBy(xpath = "//input[@id='contact-id']")
	WebElement contactId;
	
	@FindBy(xpath = "//input[@id='account-number']")
	WebElement accountNumber;

	@FindBy(xpath = "//select[@id='target-url']")
	WebElement targetUrl;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement launch;


	/**
	 * Enter user roles
	 * @param env to select on oneview portal
	 * @author aditi.jain
	 */
	public void selectOneViewUrl(String env) {
		getReusableActionsInstance().selectWhenReadyByVisibleText(targetUrl, "https://"+env+"-oneview.rogers.com/web/a/dashboard");
		}
	
	/**
	 * Enter account number
	 * @param  acctNumber
	 * @author aditi.jain
	 */
	public void enterAccountNumber(String acctNumber) {
		getReusableActionsInstance().waitForElementVisibility(accountNumber, 30);
		getReusableActionsInstance().getWhenReady(accountNumber, 10).click();
		getReusableActionsInstance().getWhenReady(accountNumber).sendKeys(acctNumber);
	}

	/**
	 * Enter contactId
	 * @param  userContactId
	 * @author aditi.jain
	 */
	public void enterContactId(String userContactId) {
		getReusableActionsInstance().waitForElementVisibility(contactId, 30);
		getReusableActionsInstance().getWhenReady(contactId, 10).click();
		getReusableActionsInstance().getWhenReady(contactId).sendKeys(userContactId);
	}



	/**
	 * Enter userRoles
	 * @param  userRoleValue
	 * @author aditi.jain
	 */
	public void enterUserRoles(String userRoleValue) {
		getReusableActionsInstance().waitForElementVisibility(userRoles, 30);
		getReusableActionsInstance().getWhenReady(userRoles, 10).click();
		getReusableActionsInstance().getWhenReady(userRoles).sendKeys(userRoleValue);
	}
	
	/**
	 * Launch OneView
	 * @return true if environment selection page displayed else false
	 * @author aditi.jain
	 */
	public void launch() {
		getReusableActionsInstance().isElementVisible(launch, 30);
		getReusableActionsInstance().executeJavaScriptClick(launch);
	}
}
