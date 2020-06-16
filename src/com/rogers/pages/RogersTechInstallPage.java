package com.rogers.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

	@FindBy(xpath ="//input[@id='26']/ancestor::label[@class='a-radio']")
	WebElement rdoTechInstallSlot;
	//label[@for='slot-13']/ancestor::td[@class='monday']
	
		@FindBy(xpath ="//input[@id='ds-form-input-id-34']")
	WebElement txtMobielNumber;		
		//input[@id='enrouteMobile']
		
	@FindBy(xpath ="//div[@class='col-sm-6']//span[@class='ute-icon-calendar-icon']")
	WebElement imgStartingTechInstallSlot;
	
	@FindBy(xpath ="//div[contains(@class,'col-sm-6 margin-bottom-0')]//span[@class='ute-icon-calendar-icon']")
	WebElement imgEndingTechInstallSlot;
	
	@FindBy(xpath ="//input[@id='ds-form-input-id-35']")
	WebElement txtEmail;
	//input[@id='enRouteEmail']
	
	@FindBy(xpath ="//label[@for='ds-checkbox-id-1']")
	WebElement chkTechInstalConsent;
	//div[@class='self-install-concern']//input[@name='consent']
	//input[@id='deliveryConcern']
	//label[@for='deliveryConcern']
	//input[@id='ds-checkbox-id-1']
	
	@FindBy(xpath ="//span[@translate='global.checkout.fulfillment.confirm']")
	WebElement btnTechInstallContinue;
	//div[@class='buttons-block hidden-xs']//button[@class='ute-btn-primary']")
	//button[@class='ute-btn-primary']
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//input[@name='preferredDatesFirst']")
	WebElement prefferedDates;
	
	@FindBy(xpath = "//i[@class='glyphicon glyphicon-chevron-right']")
	WebElement clkNext;
	
	@FindBy(xpath = "(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[3]")
	WebElement clkChevron;
	//i[@class='glyphicon glyphicon-chevron-right']
	
	@FindBy(xpath = "//label[@class='ute-label-text']")
	WebElement clkIUnderStand;

	@FindBy(xpath = "//i[@class='rch-icon-calendar']")
	WebElement clkCalendarIcon;
	//span[@class='ute-icon-calendar-icon']
	
	@FindBy(xpath ="//i[@class='rch-icon-calendar']")
	WebElement imgTechInstallSlot;
	
	@FindBy(xpath = "//button[@class='knob collapsed']")
	WebElement downChevronYourCart;

	@FindBy(xpath = "//div[@class='mini-body']//div[contains(@ng-bind-html,'$root.gwpDetails')]")
	WebElement gwpYourCart;
	
	@FindBy(xpath ="//label[@for='tech-install-option']//span[@class='ute-icon-check']")
	WebElement chkPersonalizedInstall;
	
	@FindBy(xpath ="//h2[@translate='global.checkout.fulfillment.title']")
	WebElement txtTechInstalpage;
	//ins[@translate='global.label.personalizedInstallation']
	
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
		return	reusableActions.isElementVisible(txtTechInstalpage, 180);
	}
	
	
	public void clkPersonalizedInstall() {
		reusableActions.waitForElementVisibility(chkPersonalizedInstall, 180);
		reusableActions.getWhenReady(chkPersonalizedInstall, 180).click();
	}
	
	/**
	 * To verify the launch of Technical  Install Page
	 * @return true if the TechInstallSlot ratio has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyTechInstallCalendar() {	
		return	reusableActions.isElementVisible(imgStartingTechInstallSlot, 180);
	}
	
	/**
	 * To select the Technical Installation Start Date
	 * @author chinnarao.vattam
	 */
	public void selTechInstal() {
		reusableActions.waitForElementVisibility(imgTechInstallSlot,180); 
		reusableActions.scrollToElement(imgTechInstallSlot); 
		reusableActions.getWhenReady(imgTechInstallSlot, 20).click();
		Calendar calendar = Calendar.getInstance();
		int intDate = calendar.get(Calendar.DATE);
		int startDate = intDate + 5; 
		String strStartDate= Integer.toString(startDate);
		By selStartDate = By.xpath("//span[contains(text(),'" + strStartDate + "') and @class='owl-dt-calendar-cell-content']");
		reusableActions.getWhenReady(selStartDate, 20).click();
		//button[@class='btn btn-default btn-sm']//span[contains(text(),'" + strStartDate + "')]
	}
	
	/**
	 * Select Self install date and time
	 * @author Saurav.Goyal
	 */
	public void selSelffinstallDateAndTime() {
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
		By selStartDate = By.xpath("//span[contains(text(),'" + strStartDate + "') and @class='owl-dt-calendar-cell-content']");
		reusableActions.getWhenReady(selStartDate, 20).click();
	}
	
	/**
	 * Select the slot from the available list of slots from installation page
	 * @author Chinnarao.Vattam
	 */
	public void clkTechInstallSlot() {
		reusableActions.waitForElementVisibility(rdoTechInstallSlot, 180);
		reusableActions.getWhenReady(rdoTechInstallSlot, 180).click();
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
		reusableActions.waitForElementVisibility(imgStartingTechInstallSlot,60); 
		reusableActions.getWhenReady(imgStartingTechInstallSlot, 20).click();
		DateFormat dform = new SimpleDateFormat("dd-MM-yyyy");
		Calendar calendar = Calendar.getInstance();
		int intDate = calendar.get(Calendar.DATE);
		int iDate = intDate + 10; 
		if(iDate >= 30) {
		reusableActions.waitForElementVisibility(clkNext, 60);
		reusableActions.getWhenReady(clkNext, 60).click();		
		int selDate = intDate - 14 ;
		String strStartDate= Integer.toString(selDate);	
		By selStartDate = By.xpath("//button[@class='btn btn-default btn-sm']//span[contains(text(),'" + strStartDate + "')]");
		reusableActions.getWhenReady(selStartDate, 60).click();
		}
		else
		{
			String strStartDate= Integer.toString(intDate);
			By selStartDate = By.xpath("//button[@class='btn btn-default btn-sm']//span[contains(text(),'" + strStartDate + "')]");
			reusableActions.getWhenReady(selStartDate, 60).click();
		}
	}
	
	/**
	 * To select the Technical Installation End Date
	 * @author chinnarao.vattam
	 */
	public void selTechInstalEndDate() {
		reusableActions.waitForElementVisibility(imgEndingTechInstallSlot,60); 
		reusableActions.getWhenReady(imgEndingTechInstallSlot, 20).click();
		Calendar calendar = Calendar.getInstance();
		int intDate = calendar.get(Calendar.DATE);	
		int iDate = intDate + 10; 
		if(iDate >= 30) {
		reusableActions.waitForElementVisibility(clkNext, 60);
		reusableActions.getWhenReady(clkNext, 60).click();
		int selDate = intDate - 6 ;
		String strEndDate= Integer.toString(selDate);
		By selEndDate = By.xpath("//button[@class='btn btn-default btn-sm']//span[contains(text(),'" + strEndDate + "')]");
		reusableActions.getWhenReady(selEndDate, 30).click();
		}
		else
		{
			int endDate = intDate + 5;
			String strEndDate= Integer.toString(endDate);
			By selEndDate = By.xpath("//button[@class='btn btn-default btn-sm']//span[contains(text(),'" + strEndDate + "')]");
			reusableActions.getWhenReady(selEndDate, 30).click();
		}
		

	}
	
	/**
	 * To Click the Technical Install Consent check box
	 * @author chinnarao.vattam
	 */
	public void clkTechInstalConsent() {
		reusableActions.waitForElementVisibility(chkTechInstalConsent, 180);
		reusableActions.javascriptScrollByVisibleElement(chkTechInstalConsent);
		reusableActions.executeJavaScriptClick(chkTechInstalConsent);
	}
	
	
	/**
	 * Click the continue button to continue the TechInstall on installation page
	 * @author Chinnarao.Vattam
	 */
	public void clkTechInstallContinue() {
		reusableActions.waitForElementTobeClickable(btnTechInstallContinue, 180);
		reusableActions.javascriptScrollToMiddleOfPage();
		reusableActions.getWhenReady(btnTechInstallContinue, 120).click();
	}

}
