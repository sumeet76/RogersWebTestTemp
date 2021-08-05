package com.rogers.oneview.pages;

import com.rogers.testdatamanagement.TestDataHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

import java.util.Locale;


public class EnvironmentSelectionPage extends BasePageClass {

	public EnvironmentSelectionPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//select[@name='envList']")
	WebElement ddlenvList;
	
	@FindBy(xpath = "//button[@class='btn']")
	WebElement btnGo;
	
	@FindBy(xpath = "//div[@class='oneview-dialog']")
	WebElement dlgDealerCode;

	@FindBy(xpath = "//input[@placeholder='Enter dealer code']")
	WebElement txtDealerCode;
	
	@FindBy(xpath = "//div[@class='input']//button")
	WebElement btnSubmit;

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
		getReusableActionsInstance().javascriptScrollByVisibleElement(targetUrl);
		String url = "https://"+env.toLowerCase()+"-oneview.rogers.com/web/a/dashboard";
		getReusableActionsInstance().selectWhenReadyByVisibleText(targetUrl, url);
//		getReusableActionsInstance().selectWhenReady(targetUrl, url);
	}

	/**
	 * Enter account number
	 * @param  acctNumber
	 * @author aditi.jain
	 */
	public void enterAccountNumber(String acctNumber) {
		getReusableActionsInstance().waitForElementVisibility(accountNumber, 60);
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
		getReusableActionsInstance().clickWhenReady(launch,30);
	}



	/**
	 * Selects the first identification on Credit check page
	 * @param accountNumber to of the user logging in
	 * @param contactId to of the user logging in
	 * @author aditi.jain
	 */
	public void launchOneView(String accountNumber, String contactId) {
		enterAccountNumber(accountNumber);
		enterContactId(contactId);
		enterUserRoles("CSR,Oneview Pilot-1,Oneview BRT-1,R76,BT User,R33,R45,R47,R52,R54,R55,R65,R68,R75,R77,R246,R252,R261,R167,R306,R307,R304,R311,BRT Authorized CSR-3,BRT Authorized CSR-4,Ignite Learning Lab Additive Role");
		String env = System.getProperty("OneViewEnv").substring(4);
		selectOneViewUrl(env);
		launch();
	}

	/**
	 * Selects the first identification on Credit check page
	 * @param env to select on oneview portal
	 * @author Chinnarao.Vattam
	 */
	public void selectOneViewEnv(String env) {
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlenvList, env);
		getReusableActionsInstance().getWhenReady(btnGo, 30).click();
		
		}
	
	/**
	 * Enter the dealer code on capture dealer code page
	 * @param strDealerCode dealer code
	 * @author Chinnarao.Vattam
	 */
	public void enterDealerCode(String strDealerCode) {
		getReusableActionsInstance().waitForElementVisibility(dlgDealerCode, 60);
		getReusableActionsInstance().getWhenReady(txtDealerCode, 10).click();
		getReusableActionsInstance().getWhenReady(txtDealerCode).sendKeys(strDealerCode);
	}
	
	/**
	 * Submit the capture dealer code page
	 * @author Chinnarao.Vattam
	 */
	public void submitDealerCode() {
		getReusableActionsInstance().getWhenReady(btnSubmit, 30).click();
	}
	
	/**
	 * Click on go button
	 * @author Saurav.Goyal
	 */
	public void clkGo() {
		getReusableActionsInstance().clickWhenReady(btnGo , 30);
	}
	
	/**
	 * Check the presence of the go button
	 * @return true if environment selection page displayed else false
	 * @author Saurav.Goyal
	 */
	public boolean presenceOfTheGoButton() {
		return getReusableActionsInstance().isElementVisible(btnGo, 30);
	}
}
