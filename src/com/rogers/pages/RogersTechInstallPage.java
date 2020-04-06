package com.rogers.pages;

import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

import utils.FormFiller;

/**
 * @author chinnarao.vattam
 *
 */
public class RogersTechInstallPage extends BasePageClass {

	public RogersTechInstallPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath ="//label[@for='slot-13']/ancestor::td[@class='monday']")
	WebElement rdoTechInstallSlot;
	
	@FindBy(xpath ="//input[@id='enrouteMobile']")
	WebElement txtMobielNumber;
	
	@FindBy(xpath ="//div[@class='col-sm-6']//span[@class='ute-icon-calendar-icon']")
	WebElement imgStartingTechInstallSlot;
	
	@FindBy(xpath ="//div[contains(@class,'col-sm-6 margin-bottom-0')]//span[@class='ute-icon-calendar-icon']")
	WebElement imgEndingTechInstallSlot;
	
	
	@FindBy(xpath ="//input[@id='enRouteEmail']")
	WebElement txtEmail;
	
	@FindBy(xpath ="//div[@class='self-install-concern']//input[@name='consent']")
	WebElement chkTechInstalConsent;
		
	@FindBy(xpath ="//button[@class='ute-btn-primary']")
	WebElement btnTechInstallContinue;
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	/**
	 * To verify the launch of Technical  Install Page
	 * @return true if the TechInstallSlot ratio has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyTechInstallPage() {
		return	reusableActions.isElementVisible(rdoTechInstallSlot, 180);
	}
	
	/**
	 * Select the slot from the available list of slots from installation page
	 * @author Chinnarao.Vattam
	 */
	public void clkTechInstallSlot() {
		reusableActions.getWhenReady(rdoTechInstallSlot, 60).click();
	}
	
	/**
	 * Set dynamic mobile number on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setMobielNumber() {
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		reusableActions.getWhenReady(txtMobielNumber, 30).clear();
		reusableActions.getWhenReady(txtMobielNumber, 3).sendKeys(strPhoneNumber);
	}
	
	/**
	 * Set dynamic email on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setEmail() {
		String strEmail = FormFiller.generateEmail();
		reusableActions.getWhenReady(txtEmail, 30).clear();
		reusableActions.getWhenReady(txtEmail, 3).sendKeys(strEmail);
	}
	
	/**
	 * To select the Technical Installation Start Date
	 * @author chinnarao.vattam
	 */
	public void selTechInstalStartDate() {
		reusableActions.waitForElementVisibility(imgStartingTechInstallSlot,20); 
		reusableActions.getWhenReady(imgStartingTechInstallSlot, 20).click();
		Calendar calendar = Calendar.getInstance();
		int intDate = calendar.get(Calendar.DATE);
		int startDate = intDate + 9; 
		String strStartDate= Integer.toString(startDate);
		By selStartDate = By.xpath("//button[@class='btn btn-default btn-sm']//span[contains(text(),'" + strStartDate + "')]");
		reusableActions.getWhenReady(selStartDate, 20).click();
	}
	
	/**
	 * To select the Technical Installation End Date
	 * @author chinnarao.vattam
	 */
	public void selTechInstalEndDate() {
		reusableActions.waitForElementVisibility(imgEndingTechInstallSlot,20); 
		reusableActions.getWhenReady(imgEndingTechInstallSlot, 20).click();
		Calendar calendar = Calendar.getInstance();
		int intDate = calendar.get(Calendar.DATE);
		int endDate = intDate + 13; 
		String strEndDate= Integer.toString(endDate);
		By selStartDate = By.xpath("//button[@class='btn btn-default btn-sm']//span[contains(text(),'" + strEndDate + "')]");
		reusableActions.getWhenReady(selStartDate, 20).click();
	}
	
	/**
	 * To Click the Technical Install Consent check box
	 * @author chinnarao.vattam
	 */
	public void clkTechInstalConsent() {		
		reusableActions.waitForElementInvisibility(popupLoadingFingers,120);
		reusableActions.javascriptScrollToBottomOfPage();
		reusableActions.executeJavaScriptClick(chkTechInstalConsent);
	}
	
	
	/**
	 * Click the continue button to continue the TechInstall on installation page
	 * @author Chinnarao.Vattam
	 */
	public void clkTechInstallContinue() {   
		reusableActions.waitForElementTobeClickable(btnTechInstallContinue, 120);
		reusableActions.getWhenReady(btnTechInstallContinue, 120).click();
	}

}
