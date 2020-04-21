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
		
	@FindBy(xpath ="//div[@class='buttons-block hidden-xs']//button[@class='ute-btn-primary']")
	WebElement btnTechInstallContinue;
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//input[@name='preferredDatesFirst']")
	WebElement prefferedDates;

	@FindBy(xpath = "//i[@class='glyphicon glyphicon-chevron-right']")
	WebElement clkChevron;

	@FindBy(xpath = "//label[@class='ute-label-text']")
	WebElement clkIUnderStand;

	@FindBy(xpath = "//span[@class='ute-icon-calendar-icon']")
	WebElement clkCalendarIcon;

	@FindBy(xpath = "//button[@class='knob collapsed']")
	WebElement downChevronYourCart;

	@FindBy(xpath = "//div[@class='mini-body']//div[contains(@ng-bind-html,'$root.gwpDetails')]")
	WebElement gwpYourCart;
	
	/**
	 * To click on the chevron on the tech Install page
	 * @author Saurav.Goyal
	 */
	public void clkChevronYourCart() {
		reusableActions.waitForElementVisibility(downChevronYourCart, 120);
		reusableActions.getWhenReady(downChevronYourCart, 120).click();
	}

	/**
	 * To verify gwp promotion in the tech install page
	 * @return true if the promotion is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPYourCartPromotion() {
		reusableActions.waitForElementVisibility(gwpYourCart, 120);
		return	reusableActions.isElementVisible(gwpYourCart);
	}

	/**
	 * Select Self install date and time
	 * @author Saurav.Goyal
	 */
	public void selSelffinstallDateAndTime() {
		reusableActions.staticWait(10000);
		reusableActions.waitForElementVisibility(clkCalendarIcon,20); 
		reusableActions.getWhenReady(clkCalendarIcon, 20).click();
		Calendar calendar = Calendar.getInstance();
		int intDate = calendar.get(Calendar.DATE);
		int startDate = intDate + 20; 
		//If startDate > 29 , 29 being the number of days in the month
		if(startDate>29) {
			reusableActions.getWhenReady(clkChevron, 60).click();
			startDate = startDate - 29;
		}
		String strStartDate= Integer.toString(startDate);
		By selStartDate = By.xpath("//button[@class='btn btn-default btn-sm']//span[contains(text(),'" + strStartDate + "')]");
		reusableActions.getWhenReady(selStartDate, 20).click();
	}

	/**
	 * Select checkbox for I understand
	 * @author Saurav.Goyal
	 */
	public void clkIUnderStand() {
		reusableActions.getWhenReady(clkIUnderStand, 60).click();
	}

	/**
	 * Select slot from the available list of slots from installation page
	 * @author Saurav.Goyal
	 * @param date which date to be entered
	 */
	public void selectPrefferedDates(String date) {
		reusableActions.getWhenReady(prefferedDates, 180).sendKeys(date);;
	}

	
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
		//reusableActions.waitForElementInvisibility(popupLoadingFingers,120);
		reusableActions.javascriptScrollToBottomOfPage();
		reusableActions.executeJavaScriptClick(chkTechInstalConsent);
	}
	
	
	/**
	 * Click the continue button to continue the TechInstall on installation page
	 * @author Chinnarao.Vattam
	 */
	public void clkTechInstallContinue() {   
		reusableActions.waitForElementTobeClickable(btnTechInstallContinue, 120);
		reusableActions.javascriptScrollByVisibleElement(btnTechInstallContinue);
		reusableActions.getWhenReady(btnTechInstallContinue, 120).click();
	}

}
