package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

import java.util.Calendar;

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
	
	@FindBy(xpath ="//select[@id='preferredTimeSlot']")
	WebElement selPreferredTimeSlot;
	
	@FindBy(xpath ="//select[@id='backupTimeSlot']")
	WebElement selBackupTimeSlot;

	@FindBy(xpath ="//div[@class='appointment-content']")
	WebElement txtEnroute;
	
	@FindBy(xpath = "//input[@formcontrolname='enrouteMobileNumber']/ancestor::div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txtContainerMobile;
	
	@FindBy(xpath = "(//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white'])[2]")
	WebElement txtContainerMobileExistingCustomer;
	
	@FindBy(xpath = "(//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white'])[3]")
	WebElement txtContainerMobileMigration;
	
	@FindBy(xpath = "//input[@formcontrolname='enrouteEmail']/ancestor::div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txtContainerEmail;
	
	@FindBy(xpath = "//ds-form-field[contains(@class,'ds-formField ng-tns-c3-40')]//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white']")
	WebElement txtContainerEmailExistingCustomer;
	
	@FindBy(xpath = "(//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white'])[4]")
	WebElement txtContainerEmailMigration;
	
    @FindBy(xpath ="//input[@formcontrolname='enrouteMobileNumber']")
	WebElement txtMobielNumber;		
		//input[@id='enrouteMobile']
    
    @FindBy(xpath ="//input[@formcontrolname='enrouteMobileNumber']")
	WebElement txtMobielNumberMigration;

	@FindBy(xpath ="//input[@formcontrolname='enrouteMobileNumber']")  
	WebElement txtMobielNumberExistingCustomer;	
		
		
	@FindBy(xpath ="(//span[@class='ds-icon rds-icon-calendar'])[1]")
	WebElement imgStartingTechInstallSlot;
			
	@FindBy(xpath ="(//span[@class='ds-icon rds-icon-calendar'])[2]")
	WebElement imgEndingTechInstallSlot;
	
	@FindBy(xpath ="//input[@formcontrolname='enrouteEmail']")
	WebElement txtEmail;
	//input[@id='enRouteEmail']
	
	@FindBy(xpath ="//input[@formcontrolname='enrouteEmail']")
	WebElement txtEmailMigration;		
	
	@FindBy(xpath ="//input[@formcontrolname='enrouteEmail']")   
	WebElement txtEmailExistingCustomer;

	@FindBy(xpath = "//label[contains(@class,'ds-checkboxLabel')]")
	WebElement chkTechInstalConsent;
	
	@FindBy(xpath ="//label[@for='ds-checkbox-id-0']")
	WebElement chkTechInstalConsentExistingCustomer;
	
	@FindBy(xpath ="//button[@aria-label='Click here to continue']")
	WebElement btnTechInstallContinue;
	//span[@translate='global.checkout.fulfillment.confirm']

	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//input[@name='preferredDatesFirst']")
	WebElement prefferedDates;
	
	@FindBy(xpath = "//i[@class='glyphicon glyphicon-chevron-right']")
	WebElement clkNext;
	
	@FindBy(xpath = "(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[3]")
	WebElement clkChevron;
	
	@FindBy(xpath = "//label[@class='ute-label-text']")
	WebElement clkIUnderStand;

	@FindBy(xpath = "//i[@class='rch-icon-calendar']")
	WebElement clkCalendarIcon;
	
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
	 * Select slot from the available list of slots from installation page
	 * @author chinnarao.vattam
	 * @param slot which slot to be entered
	 */
	public void selectPreferredTimeSlot(String slot) {
		reusableActions.getWhenReady(selPreferredTimeSlot, 180).sendKeys(slot);;
	}
	
	/**
	 * Select slot from the available list of slots from installation page
	 * @author chinnarao.vattam
	 * @param slot which slot to be entered
	 */
	public void selectBackupTimeSlot(String slot) {
		reusableActions.getWhenReady(selBackupTimeSlot, 180).sendKeys(slot);;
	}
	
	/**
	 * To verify the launch of Technical  Install Page
	 * @return true if the TechInstallSlot ratio has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyTechInstallPage() {
		return	reusableActions.isElementVisible(txtTechInstalpage, 120);
	}
	
	
	public void clkPersonalizedInstall() {
		reusableActions.waitForElementVisibility(chkPersonalizedInstall, 60);
		reusableActions.getWhenReady(chkPersonalizedInstall, 30).click();
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
	 * @author chinnarao.vattam
	 */
	public void selSelffinstallDateAndTime() {
		if(reusableActions.isElementVisible(rdoTechInstallSlot, 90))
		{
		reusableActions.getWhenReady(rdoTechInstallSlot, 30).click();	
		}
		else
		{	
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
		reusableActions.waitForElementVisibility(rdoTechInstallSlot, 180);
		reusableActions.getWhenReady(rdoTechInstallSlot, 90).click();
		}
	}
	
	public void selSelffinstallDateAndTimeMigrartion() {
		if(reusableActions.isElementVisible(rdoTechInstallSlot, 90))
		{
		reusableActions.getWhenReady(rdoTechInstallSlot, 30).click();	
		}
		else
		{
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
		reusableActions.waitForElementVisibility(rdoTechInstallSlot, 180);
		reusableActions.getWhenReady(rdoTechInstallSlot, 90).click();
		}
	}
	
	/**
	 * Select Self install date and time
	 * @author chinnarao.vattam
	 */
	public void selSelffinstallDateAndTimeMobile() {
		if(reusableActions.isElementVisible(rdoTechInstallSlot, 90))
		{
		reusableActions.executeJavaScriptClick(rdoTechInstallSlot);	
		}
		else
		{
		reusableActions.waitForElementVisibility(clkCalendarIcon,50); 
		reusableActions.executeJavaScriptClick(clkCalendarIcon);
		Calendar calendar = Calendar.getInstance();
		int intDate = calendar.get(Calendar.DATE);
		int startDate = intDate + 20; 
		//If startDate > 29 , 29 being the number of days in the month
		if(startDate>29) {
			reusableActions.waitForElementVisibility(clkChevron, 60);
			reusableActions.executeJavaScriptClick(clkChevron);
			startDate = startDate - 29;
		}
		String strStartDate= Integer.toString(startDate);
		By selStartDate = By.xpath("//span[contains(text(),'" + strStartDate + "') and @class='owl-dt-calendar-cell-content']");
		WebElement date = driver.findElement(selStartDate);
		reusableActions.executeJavaScriptClick(date);
		}
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
	 * Select the slot from the available list of slots from installation page
	 * @author Chinnarao.Vattam
	 */
	public void clkTechInstallSlotMobile() {
		if(reusableActions.isElementVisible(rdoTechInstallSlot, 90))
		{
			reusableActions.getWhenReady(rdoTechInstallSlot, 30).click();
		}
		else
		{
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
			reusableActions.waitForElementVisibility(rdoTechInstallSlot, 180);
			reusableActions.getWhenReady(rdoTechInstallSlot, 90).click();
		}
	}
	
	/**
	 * Set dynamic mobile number on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setMobielNumber() {
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		String strEmail = FormFiller.generateEmail();
		if(reusableActions.isElementVisible(txtEnroute,90)) {
			reusableActions.waitForElementVisibility(txtContainerMobile, 20);
			reusableActions.getWhenReady(txtContainerMobile, 10).click();
			reusableActions.getWhenReady(txtMobielNumber, 10).clear();
			reusableActions.getWhenReady(txtMobielNumber, 3).sendKeys(strPhoneNumber);
			reusableActions.waitForElementVisibility(txtContainerEmail, 30);
			reusableActions.getWhenReady(txtContainerEmail, 10).click();
			reusableActions.getWhenReady(txtEmail, 10).clear();
			reusableActions.getWhenReady(txtEmail, 10).sendKeys(strEmail);
		}
		}
	
	/**
	 * Set dynamic mobile number on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setMobielNumberMobile() {
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		String strEmail = FormFiller.generateEmail();
		if(reusableActions.isElementVisible(txtEnroute,90)) {
			reusableActions.waitForElementVisibility(txtContainerMobile, 20);
			reusableActions.getWhenReady(txtContainerMobile, 10).click();
			reusableActions.getWhenReady(txtMobielNumber, 10).clear();
			reusableActions.getWhenReady(txtMobielNumber, 3).sendKeys(strPhoneNumber);
			reusableActions.waitForElementVisibility(txtContainerEmail, 30);
			reusableActions.getWhenReady(txtContainerEmail, 10).click();
			reusableActions.getWhenReady(txtEmail, 10).clear();
			reusableActions.getWhenReady(txtEmail, 10).sendKeys(strEmail);
		}
}
	
	/**
	 * Set dynamic mobile number on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setMobielNumberMigration() {
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		reusableActions.waitForElementVisibility(txtContainerMobileMigration,180);
		reusableActions.getWhenReady(txtContainerMobileMigration,10).click();
		reusableActions.getWhenReady(txtMobielNumberMigration, 30).clear();
		reusableActions.getWhenReady(txtMobielNumberMigration, 3).sendKeys(strPhoneNumber);
	}
	/**
	 * Set dynamic email on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setEmailMobile() {
		String strEmail = FormFiller.generateEmail();
		reusableActions.waitForElementVisibility(txtContainerEmail,30);
		reusableActions.executeJavaScriptClick(txtContainerEmail);
		reusableActions.getWhenReady(txtEmail, 30).clear();
		reusableActions.getWhenReady(txtEmail,10).sendKeys(strEmail);
	}
	
	/**
	 * Set dynamic email on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setEmail() {
		String strEmail = FormFiller.generateEmail();
		reusableActions.waitForElementVisibility(txtContainerEmail,30);
		reusableActions.getWhenReady(txtContainerEmail,20).click();
		reusableActions.getWhenReady(txtEmail, 30).clear();
		reusableActions.getWhenReady(txtEmail,10).sendKeys(strEmail);
	}
	/**
	 * Set dynamic email on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setEmailMigration() {
		String strEmail = FormFiller.generateEmail();
		reusableActions.waitForElementVisibility(txtContainerEmailMigration,180);
		reusableActions.getWhenReady(txtContainerEmailMigration,10).click();
		reusableActions.getWhenReady(txtEmailMigration, 30).clear();
		reusableActions.getWhenReady(txtEmailMigration,10).sendKeys(strEmail);
	}
	
	/**
	 * Set dynamic mobile number on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setMobielNumberExistingCustomer() {
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		String strEmail = FormFiller.generateEmail();
		if (reusableActions.isElementVisible(txtEnroute, 90)) {
			reusableActions.waitForElementVisibility(txtContainerMobileExistingCustomer, 20);
			reusableActions.getWhenReady(txtContainerMobileExistingCustomer, 10).click();
			reusableActions.getWhenReady(txtMobielNumberExistingCustomer, 30).clear();
			reusableActions.getWhenReady(txtMobielNumberExistingCustomer, 3).sendKeys(strPhoneNumber);
			reusableActions.waitForElementVisibility(txtContainerEmailExistingCustomer, 20);
			reusableActions.getWhenReady(txtContainerEmailExistingCustomer, 10).click();
			reusableActions.getWhenReady(txtEmailExistingCustomer, 30).clear();
			reusableActions.getWhenReady(txtEmailExistingCustomer, 3).sendKeys(strEmail);
		}
	}
	/**
	 * Set dynamic email on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setEmailExistingCustomer() {
		String strEmail = FormFiller.generateEmail();
		reusableActions.waitForElementVisibility(txtContainerEmailExistingCustomer,180);
		reusableActions.getWhenReady(txtContainerEmailExistingCustomer,10).click();
		reusableActions.getWhenReady(txtEmailExistingCustomer, 30).clear();
		reusableActions.getWhenReady(txtEmailExistingCustomer, 3).sendKeys(strEmail);
	}
	/**
	 * To select the Technical Installation Start Date
	 * @author chinnarao.vattam
	 */
	public void selTechInstalStartDate() {
		reusableActions.staticWait(5000);
		reusableActions.waitForElementVisibility(imgStartingTechInstallSlot,180); 
		reusableActions.getWhenReady(imgStartingTechInstallSlot, 20).click();
		Calendar calendar = Calendar.getInstance();
		int intDate = calendar.get(Calendar.DATE);
		int iDate = intDate + 10; 
		if(iDate >= 30) {
		reusableActions.waitForElementVisibility(clkChevron, 60);
		reusableActions.getWhenReady(clkChevron, 60).click();		
		int selDate = intDate - 14 ;
		String strStartDate= Integer.toString(selDate);	
		By selStartDate = By.xpath("//tr[@class='ng-star-inserted']//td//span[contains(text(),'" + strStartDate + "')]");
		reusableActions.getWhenReady(selStartDate, 60).click();
		}
		else
		{
			String strStartDate= Integer.toString(intDate);
			By selStartDate = By.xpath("//tr[@class='ng-star-inserted']//td//span[contains(text(),'" + strStartDate + "')]");
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
		reusableActions.waitForElementVisibility(clkChevron, 60);
		reusableActions.getWhenReady(clkChevron, 60).click();
		int selDate = intDate - 6 ;
		String strEndDate= Integer.toString(selDate);
		By selEndDate = By.xpath("//tr[@class='ng-star-inserted']//td//span[contains(text(),'" + strEndDate + "')]");
		reusableActions.getWhenReady(selEndDate, 30).click();
		}
		else
		{
			int endDate = intDate + 5;
			String strEndDate= Integer.toString(endDate);
			By selEndDate = By.xpath("//tr[@class='ng-star-inserted']//td//span[contains(text(),'" + strEndDate + "')]");
			reusableActions.getWhenReady(selEndDate, 30).click();
		}
		

	}
	
	/**
	 * To Click the Technical Install Consent check box
	 * @author chinnarao.vattam
	 */
	public void clkTechInstalConsent() {
		reusableActions.waitForElementVisibility(chkTechInstalConsent, 60);
		reusableActions.javascriptScrollByVisibleElement(chkTechInstalConsent);
		reusableActions.executeJavaScriptClick(chkTechInstalConsent);
	}
	
	/**
	 * To Click the Technical Install Consent check box
	 * @author chinnarao.vattam
	 */
	public void clkTechInstalConsentExistingCustomer() {
		reusableActions.waitForElementVisibility(chkTechInstalConsentExistingCustomer, 60);
		reusableActions.javascriptScrollByVisibleElement(chkTechInstalConsentExistingCustomer);
		reusableActions.executeJavaScriptClick(chkTechInstalConsentExistingCustomer);
	}
	
	/**
	 * Click the continue button to continue the TechInstall on installation page
	 * @author Chinnarao.Vattam
	 */
	public void clkTechInstallContinue() {
		reusableActions.waitForElementTobeClickable(btnTechInstallContinue, 60);
		reusableActions.javascriptScrollToMiddleOfPage();
		reusableActions.getWhenReady(btnTechInstallContinue, 30).click();
	}

	/**
	 * Click the continue button to continue the TechInstall on installation page
	 * @author Chinnarao.Vattam
	 */
	public void clkTechInstallContinueMobile() {
		reusableActions.waitForElementTobeClickable(btnTechInstallContinue, 90);
		reusableActions.javascriptScrollByVisibleElement(btnTechInstallContinue);
		reusableActions.waitForElementVisibility(btnTechInstallContinue, 60);
		reusableActions.executeJavaScriptClick(btnTechInstallContinue);
	}

}
