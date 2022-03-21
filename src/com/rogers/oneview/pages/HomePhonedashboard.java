package com.rogers.oneview.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class HomePhonedashboard  extends BasePageClass {

	public HomePhonedashboard(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//button[@class='a-btnPrimary ng-star-inserted']")
	WebElement btnContnue;

	//@FindBy(xpath = "//span[@class='ds-icon rds-icon-check-circle']")
	@FindBy(xpath = "//p[text()='Success!']")
	WebElement imgSuccess;

	@FindBy(xpath = "//button[@class='a-btnPrimary ng-star-inserted']")
	WebElement btnSuccessOk;

	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popupLoadingFinger;

	@FindBy(xpath = "//div[@class='header']")
	WebElement icnHeader;

	@FindBy(xpath = "//div[@class='header']")
	WebElement icnFooter;

	@FindBy(xpath = "//div[@class='second-level-nav__cta']//button[@class='b-linkCta']")
	WebElement btnBackToAccountOverview;

	@FindBy(xpath = "//span[text()='Reset voicemail password' or text()='Réinitialiser le mot de passe de Messagerie vocale']/ancestor::button")
	WebElement btnResetVoiceMail;

	@FindBy(xpath = "//span[text()='Confirmer' or text()='Confirm']/ancestor::button")
	WebElement confirm;

	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement continueButton;

	@FindBy(xpath = "//span[contains(text(),'Immédiatement') or contains(text(),'Immediately')]/parent::div")
	WebElement immediately;

	@FindBy(xpath = "//span[text()='Manage Add-Ons' or text()='Gérer les options']/ancestor::button")
	WebElement manageAddOns;

	@FindBy(xpath = "//span[text()='Yes, reset password' or text()='Oui, réinitialiser le mot de passe']/ancestor::button")
	WebElement btnYesResetPassword;

	@FindBy(xpath = "//span[@class='ds-icon d-inline-flex rds-icon-close']")
	WebElement cancel;

	@FindBy(xpath = "//span[@class='ds-icon d-inline-flex rds-icon-info']")
	WebElement onlineManagerInfo;

	@FindBy(xpath = "//div[@class='tippy-tooltip ds-theme']")
	WebElement imageOnlineManager;

	@FindBy(xpath = "//h2[text() ='You can add the following add-ons:' or text() = 'Vous pouvez ajouter les options suivantes :']")
	WebElement textAfterClickingOnManageAddOns;

	@FindBy(xpath = "//div[@class ='cdk-overlay-pane ds-modalWindow']")
	WebElement imageResetVoicemailPassword;

	@FindBy(xpath="//span[text()='Change Call Display Name']")
	WebElement ChangeCallDisplayName;

	@FindBy(xpath="//p[text()='Change Call Display Name']")
	WebElement displayNamePopUp;

	@FindBy(xpath="//strong[text()='Current Call Display Name:']/following-sibling::span")
	WebElement currentCallerName;

	@FindBy(xpath="//input[@id=\"ds-form-input-id-0\"]")
	WebElement changeCallerFirstName;

	@FindBy(xpath = "//input[@id='ds-form-input-id-1']")
	WebElement changeCallerSecondName;

	@FindBy(xpath = "//span[@translate='global.cta.submit']")
	WebElement changeCallerNameSubmit;

	@FindBy(xpath="//span[text()='Back to dashboard']")
	WebElement btnBackToDashboard;

	@FindBy(xpath="//p[text()=\"Pending Order\"]")
	WebElement pendingOrder;

	@FindBy(xpath = "//span[@class='ds-icon d-inline-flex rds-icon-info']")
	WebElement onlineManager;


	/**
	 * Click Yes,reset password button on the pop up "Reset Voicemail Password"
	 * @author Chinnarao.Vattam
	 */
	public void clickYesResetPassword() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(btnYesResetPassword);
		getReusableActionsInstance().getWhenReady(btnYesResetPassword,120).click();
		getReusableActionsInstance().staticWait(6000);

	}

	/*
	 * Click on Manage Add ons
	 * @author suganya P
	 **/
	public void clickManageAddOns()
	{
		WebElement btn=getReusableActionsInstance().getWhenReady(manageAddOns,60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().clickWhenReady(manageAddOns,45);

	}
	
	/**
	 * Click Reset password button
	 * @author Chinnarao.Vattam
	 */	
	public void clickResetVoiceMail() {
		WebElement btn=getReusableActionsInstance().getWhenReady(btnResetVoiceMail,120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		getReusableActionsInstance().clickWhenReady(btnResetVoiceMail,120);
		getReusableActionsInstance().staticWait(6000);
}

	/**
	 * Click the back to overview button which brings the account overview page up
	 * @author Chinnarao.Vattam
	 */
	public void clickBacktoAccountOverview() {
		getReusableActionsInstance().getWhenReady(btnBackToAccountOverview,120).click();
		}

		/*To click on Change call display Name
		* @author suganya p*/
		public void clickChangeCallDisplayName() {
			getReusableActionsInstance().isElementVisible(ChangeCallDisplayName,90);
			getReusableActionsInstance().executeJavaScriptClick(ChangeCallDisplayName);
		}

	public boolean verifyChangeCallNameDisplayPopUp() {
		getReusableActionsInstance().waitForElementVisibility(displayNamePopUp, 15);
		return getReusableActionsInstance().isElementVisible(displayNamePopUp);
	}


	/**
	 *click continue for the ongoing activity on Internet dashboard page
	 * @author Chinnarao.Vattam
	 */
	public void clickContinue() {
		getReusableActionsInstance().getWhenReady(btnContnue,120).click();
		}
	
	/**
	 * Verify the result
	 * @return true if operation is successful, else false
	 * @author Chinnarao.Vattam
	 */	
	public boolean verifySuccess() {
		return getReusableActionsInstance().isElementVisible(imgSuccess,120);
	}
	
	/**
	 * Click "Ok" on success popup
	 * @author Chinnarao.Vattam
	 */
	public void clickSuccessOk() {
		getReusableActionsInstance().getWhenReady(btnSuccessOk,120).click();
		}
	
	/**
	 * Verify the header availability
	 * @return true if header is available on TV DashboardPage, else false
	 * @author Chinnarao.Vattam
	 */	
	public boolean verifyHeader() {	
		getReusableActionsInstance().waitForElementVisibility(icnHeader,120);
		return getReusableActionsInstance().isElementVisible(icnHeader);
	}
	
	/**
	 * Verify the footer availability
	 * @return true if footer is available on TV DashboardPage, else false
	 * @author Chinnarao.Vattam
	 */	
	public boolean verifyFooter() {
		
		return getReusableActionsInstance().isElementVisible(icnFooter);
	}
	
	/**
	 * Go to Page bottom
	 * @author Chinnarao.Vattam
	 */	
	public void goToPageBottom() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
	}
	
	
	/**
	 * Go to Page bottom
	 * @author Chinnarao.Vattam
	 */	
	public void goToPageMid() {		
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();;
	}

	/**
	 * Click on cancel
	 * @author Sonika.Maheshwari
	 */

	public void clickCancel() {
		getReusableActionsInstance().getWhenReady(cancel,60).click();
	}

	/**
	 * Click on Online Manager i
	 * @author Sonika.Maheshwari
	 */

	public void clickOnlineManagerInfo() {
		WebElement btn = getReusableActionsInstance().getWhenReady(onlineManagerInfo, 60);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
		getReusableActionsInstance().clickWhenReady(onlineManagerInfo, 60);
	}

	/**
	 * Verify Online Manager i image availability
	 * @author Sonika.Maheshwari
	 */

	public boolean verifyOnlineManagerImage () {
		return getReusableActionsInstance().isElementVisible(imageOnlineManager,60);
	}

	/**
	 * Verify text availability when Manage Add Ons is clicked
	 * @author Sonika.Maheshwari
	 */

	public boolean verifyText() {
		return getReusableActionsInstance().isElementVisible(textAfterClickingOnManageAddOns,60);
	}

	/**
	 * Verify Reset Voicemail Password image availability
	 * @author Sonika.Maheshwari
	 */

	public boolean verifyResetVoicemailPasswordImage () {
		return getReusableActionsInstance().isElementVisible(imageResetVoicemailPassword,60);
	}

	/*To get the current caller name
	@author suganya p
	*/
	public String currentCallerName()
	{
		String callerName;
		callerName= currentCallerName.getText();
		return  callerName;
	}

	/*To enter the forst name and second name in the change caller name dailog box
	* @suganya p
	*/
	public void enterCallername(String fName, String sName)
	{
		getReusableActionsInstance().executeJavaScriptClick(changeCallerFirstName);
		changeCallerFirstName.sendKeys(fName);
		getReusableActionsInstance().executeJavaScriptClick(changeCallerSecondName);
		changeCallerSecondName.sendKeys(sName);
	}

	/*To click on submit in change caller name dailog box
	@author suganya p
    */
	public void clickSubmit()
	{
		getReusableActionsInstance().clickWhenReady(changeCallerNameSubmit,30);
	}

	/*To clic on back to dashboard page
	@author suganya P
	*/
	public void clickBackToDashboard()
	{
		getReusableActionsInstance().clickWhenReady(btnBackToDashboard,30);
		/*Adding static wait as the order will take some time to close in backend*/
		getReusableActionsInstance().staticWait(20000);
	}

	/*To verofy the pending order pop up
	@author suganya p
    */
	public boolean verifyPendingOrder()
	{
		getReusableActionsInstance().isElementVisible(pendingOrder,30);
		return true;
	}
	public void clickOnlineManagerPopUp() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().waitForElementVisibility(onlineManager, 30);
		getReusableActionsInstance().executeJavaScriptClick(onlineManager);


	}

	public boolean verifyResetVoicemailPassword()
	{
		return getReusableActionsInstance().isElementVisible(btnResetVoiceMail, 20);
	}

	public boolean verifyChangeCallDisplay()
	{
		return getReusableActionsInstance().isElementVisible(ChangeCallDisplayName, 20);
	}

	public boolean verifyManageAddOns()
	{
		return getReusableActionsInstance().isElementVisible(manageAddOns, 20);
	}
	}
	


