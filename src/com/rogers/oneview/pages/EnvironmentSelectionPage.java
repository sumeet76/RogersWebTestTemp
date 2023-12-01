package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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

	@FindBy(xpath = "//input[@formcontrolname='employeeNumber']")
	WebElement inputEmpNo;

	@FindBy(xpath = "//input[@formcontrolname='sub']")
	WebElement inputEmpName;

	//@FindBy(xpath = "//h3[text()='Production']/ancestor::ds-selection-checkbox")
@FindBy(xpath="//input[@id='ds-selection-checkbox-id-1']")
	WebElement envProduction;

	@FindBy(xpath = "//div[@class='proceed-button']/button")
	WebElement btnProceed;

	@FindBy(xpath = "//span[contains(text(),'OK')]")
	WebElement OK;

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

	public void selectOneViewFidoUrl(String env) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(targetUrl);
		String url = "https://"+env.toLowerCase()+"-oneview.fido.ca";
		getReusableActionsInstance().selectWhenReadyByVisibleText(targetUrl, url);
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
		enterUserRoles("CSR,BRT Authorized CSR-3,Oneview Pilot-1,Oneview Pilot-2,Oneview Pilot-4,Oneview BRT-1,Oneview BRT-2,Oneview BRT-3,R76,BT User,R21,R39,R60,R75,R77,R180,R182,R185,R246,R252,R261,R167,R306,R307,R304,R309,R311,R310,BRT Authorized CSR-1,BRT Authorized CSR-3,BRT Authorized CSR-4,IgniteLearningLabAdditiveRole");
		String env = System.getProperty("OneViewEnv").substring(4);
		selectOneViewUrl(env);
		launch();
	}

	public void launchOneViewFido(String accountNumber, String contactId) {
		enterAccountNumber(accountNumber);
		enterContactId(contactId);
		enterUserRoles("R76,BT User,R21,R39,R60,R75,R77,R180,R182,R185,R246,R252,R261,R167,R306,R307,R304,R309,R311,R310");
		String env = System.getProperty("OneViewEnv").substring(4);
		selectOneViewFidoUrl(env);
		launch();
	}

	/**
	 * Selects the first identification on Credit check page
	 * @param env to select on oneview portal
	 * @author Chinnarao.Vattam
	 */
	public void selectOneViewEnv(String env) {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().selectWhenReadyByVisibleText(ddlenvList, env);
		getReusableActionsInstance().getWhenReady(btnGo, 30).click();
		getReusableActionsInstance().staticWait(5000);
		
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

	/**
	 * This method enters value of employee number and employee name
	 * @param empNo to set
	 * @param empName to set
	 * @author praveen.kumar7
	 */
	public void enterEmpNoAndName(String empNo,String empName) {
		getReusableActionsInstance().waitForElementVisibility(inputEmpNo, 60);
		getReusableActionsInstance().getWhenReady(inputEmpNo, 10).click();
		getReusableActionsInstance().getWhenReady(inputEmpNo).sendKeys(empNo);
		getReusableActionsInstance().getWhenReady(inputEmpName, 10).click();
		getReusableActionsInstance().getWhenReady(inputEmpName).sendKeys(empName);
		getReusableActionsInstance().javascriptScrollToTopOfPage();
	}

	public void selectProduction(){
		getReusableActionsInstance().waitForElementVisibility(envProduction, 40);
		getReusableActionsInstance().clickWhenReady(envProduction);
	}

	public void clickProceed(){
		getReusableActionsInstance().waitForElementVisibility(btnProceed, 20);
		getReusableActionsInstance().clickWhenReady(btnProceed);
		if (getReusableActionsInstance().isElementVisible(OK, 30)) {
			getReusableActionsInstance().executeJavaScriptClick(OK);
		}
	}

}
