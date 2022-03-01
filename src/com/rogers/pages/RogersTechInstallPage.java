package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
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

	@FindBy(xpath ="//input[@id='26']/ancestor::label[contains(@class,'ds-radioLabel')]//div[@class='ds-radioButton__outerCircle my-12']")
	WebElement rdoTechInstallSlot;
	
	@FindBy(xpath ="//select[@id='preferredTimeSlot']")
	WebElement selPreferredTimeSlot;
	
	@FindBy(xpath ="//select[@id='backupTimeSlot']")
	WebElement selBackupTimeSlot;

	@FindBy(xpath ="//div[@class='appointment-content']")
	WebElement txtEnroute;
	
	@FindBy(xpath = "//input[@formcontrolname='enrouteMobileNumber']/ancestor::div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txtContainerMobile;

	@FindBy(xpath = "//input[@formcontrolname='contactNumber']/ancestor::div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txtContainerContactNumber;

	@FindBy(xpath ="//input[@formcontrolname='contactNumber']")
	WebElement txtContactNumber;

	@FindBy(xpath ="//label[@for='contactNumber']/ancestor::span")
	WebElement txtContactNumbersapn;

	@FindBy(xpath = "(//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white'])[2]")
	WebElement txtContainerMobileExistingCustomer;
	
	@FindBy(xpath = "(//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white'])[3]")
	WebElement txtContainerMobileMigration;
	
	@FindBy(xpath = "//input[@formcontrolname='enrouteEmail']/ancestor::div[contains(@class,'ds-formField__inputContainer')]")
	WebElement txtContainerEmail;
	
	@FindBy(xpath = "//input[@formcontrolname='enrouteEmail']/ancestor::div[contains(@class,'ds-formField__inputContainer')]")
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


	@FindAll({
	//@FindBy(xpath = "//label[@for='ds-radio-input-id-5']//div[@class='ds-radioButton__innerCircle']"),
			@FindBy(xpath = "//span[@translate='global.checkout.fulfillment.withProInstallUpgradeNo']")
	})
	WebElement chkNoThanks;

	@FindBy(xpath ="//span[@translate='global.checkout.fulfillment.withProInstallUpgradeYes']")
	WebElement clkProInstallUpgradeYes;


	@FindBy(xpath ="//span[@translate='global.checkout.fulfillment.withProInstallUpgradeNo']/parent::div/preceding-sibling::div")
	WebElement clkProInstallUpgradeNo;

	@FindBy(xpath ="//span[@translate='global.checkout.fulfillment.courierSetup']")
	WebElement txtSetUp;

	@FindBy(xpath = "//span[text()='Continue']")
	WebElement chkcontinue;

	@FindBy(xpath ="//label[@for='ds-checkbox-id-0']")
	WebElement chkTechInstalConsentExistingCustomer;


	@FindAll({
			@FindBy(xpath ="//a[@aria-label='Click here to continue']"),
			@FindBy(xpath ="//span[text()='Continue']")
	})
	WebElement btnTechInstallContinue;
//span[@translate='global.checkout.fulfillment.confirm']/ancestor::a


	@FindBy(xpath ="//span[@id='ariaClickToContinue']/ancestor::a")
	WebElement btnTechInstallContinueSelf;

	//span[@translate='global.checkout.fulfillment.confirm']
//button[@aria-label='Click here to continue']

	@FindBy(xpath ="//span[@translate='global.checkout.fulfillment.confirm']")
	WebElement btn3PTechInstallContinue;
//button[@aria-label='Click here to continue']

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

	@FindAll({
			@FindBy(xpath ="//h2[@translate='global.checkout.fulfillment.title']"),
			@FindBy(xpath ="//h1[text()='Setup options']")})
	WebElement txtTechInstalpage;

	@FindAll({
	@FindBy(xpath ="//div[@class='col-md-8 col-sm-8']//h3"),
	@FindBy(xpath ="//div[@class='row ng-star-inserted']//h3")})
	WebElement txtIgniteExpressSetup;

	@FindAll({
	@FindBy(xpath ="//div[@class='row -mb40 ng-star-inserted']//div[@class='ds-price__amountDollars text-semi ng-star-inserted']"),
	@FindBy(xpath ="//div[@class='row ng-star-inserted']//div[@class='ds-price__amountDollars text-semi ng-star-inserted']")})
	WebElement txtIgniteExpressSetupCost;

	@FindBy(xpath ="(//input[@format='MM/DD/YYYY']/ancestor::ds-form-field/div/div)[1]")
	WebElement txtStartDateContainer;

	@FindBy(xpath ="(//input[@id='backupDate']/ancestor::ds-form-field/div/div)[1]")
	WebElement txtEndDateContainer;

	@FindBy(xpath ="//input[@format='MM/DD/YYYY']")
	WebElement txtStartDateNew;

	@FindBy(xpath ="//input[@id='backupDate']")
	WebElement txtEndDateNew;

	/**
	 * To click on the chevron on the tech Install page
	 * @author Saurav.Goyal
	 */
	public void clkChevronYourCart() {
		getReusableActionsInstance().waitForElementVisibility(downChevronYourCart, 120);
		getReusableActionsInstance().getWhenReady(downChevronYourCart, 120).click();
	}


	/**
	 * To verify gwp promotion in the tech install page
	 * @return true if the promotion is available else return false
	 * @author Saurav.Goyal
	 */
	public boolean verifyGWPYourCartPromotion() {
		getReusableActionsInstance().waitForElementVisibility(gwpYourCart, 120);
		return	getReusableActionsInstance().isElementVisible(gwpYourCart);
	}

	/**
	 * Select checkbox for I understand
	 * @author Saurav.Goyal
	 */
	public void clkIUnderStand() {
		getReusableActionsInstance().getWhenReady(clkIUnderStand, 60).click();
	}

	/**
	 * Select slot from the available list of slots from installation page
	 * @author Saurav.Goyal
	 * @param date which date to be entered
	 */
	public void selectPrefferedDates(String date) {
		getReusableActionsInstance().getWhenReady(prefferedDates, 180).sendKeys(date);;
	}

	/**
	 * Select slot from the available list of slots from installation page
	 * @author chinnarao.vattam
	 */
	public void selectPreferredTimeSlot() {
		getReusableActionsInstance().waitForElementVisibility(selPreferredTimeSlot,30);
		getReusableActionsInstance().getWhenReady(selPreferredTimeSlot,20).click();
		getReusableActionsInstance().selectWhenReady(selPreferredTimeSlot,1,10);
	}
	
	/**
	 * Select slot from the available list of slots from installation page
	 * @author chinnarao.vattam
	 */
	public void selectBackupTimeSlot() {
		getReusableActionsInstance().waitForElementVisibility(selBackupTimeSlot,30);
		getReusableActionsInstance().getWhenReady(selPreferredTimeSlot,20).click();
		getReusableActionsInstance().selectWhenReady(selBackupTimeSlot,1,20);

	}

	public void  verifyAPICallTemp() {
		getReusableActionsInstance().staticWait(6000);
	}

	/**
	 * To verify the launch of Technical  Install Page
	 * @return true if the TechInstallSlot ratio has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyTechInstallPage() {
		getReusableActionsInstance().waitForElementVisibility(txtTechInstalpage, 120);
		return	getReusableActionsInstance().isElementVisible(txtTechInstalpage, 20);
	}

	/**
	 * To verify the launch of Technical  Install Page
	 * @return true if the TechInstallSlot ratio has available, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyIgniteExpressSetup() {
		getReusableActionsInstance().waitForElementVisibility(txtIgniteExpressSetup, 90);
		return	getReusableActionsInstance().isElementVisible(txtIgniteExpressSetup, 20);
	}

	public void clkPersonalizedInstall() {
		getReusableActionsInstance().waitForElementVisibility(chkPersonalizedInstall, 60);
		getReusableActionsInstance().getWhenReady(chkPersonalizedInstall, 30).click();
	}
	
	/**
	 * To verify the launch of Technical  Install Page
	 * @return true if the TechInstallSlot ratio has available, else false 
	 * @author chinnarao.vattam
	 */
	public boolean verifyTechInstallCalendar() {	
		return	getReusableActionsInstance().isElementVisible(imgStartingTechInstallSlot, 180);
	}
	
	/**
	 * To select the Technical Installation Start Date
	 * @author chinnarao.vattam
	 */
	public void selTechInstal() {
		getReusableActionsInstance().waitForElementVisibility(imgTechInstallSlot,180);
		getReusableActionsInstance().scrollToElement(imgTechInstallSlot);
		getReusableActionsInstance().getWhenReady(imgTechInstallSlot, 20).click();
		Calendar calendar = Calendar.getInstance();
		int intDate = calendar.get(Calendar.DATE);
		int startDate = intDate + 5; 
		String strStartDate= Integer.toString(startDate);
		By selStartDate = By.xpath("//span[contains(text(),'" + strStartDate + "') and @class='owl-dt-calendar-cell-content']");
		getReusableActionsInstance().getWhenReady(selStartDate, 20).click();
		//button[@class='btn btn-default btn-sm']//span[contains(text(),'" + strStartDate + "')]
	}
	
	/**
	 * Select Self install date and time
	 * @author chinnarao.vattam
	 */
	public void selSelffinstallDateAndTime() {
		if(getReusableActionsInstance().isElementVisible(rdoTechInstallSlot, 90))
		{
		getReusableActionsInstance().getWhenReady(rdoTechInstallSlot, 90).click();
		}
		else
		{	
		getReusableActionsInstance().waitForElementVisibility(clkCalendarIcon,20);
		getReusableActionsInstance().getWhenReady(clkCalendarIcon, 90).click();
		Calendar calendar = Calendar.getInstance();
		int intDate = calendar.get(Calendar.DATE);
		int startDate = intDate + 20; 
		//If startDate > 29 , 29 being the number of days in the month
		if(startDate>29) {
			getReusableActionsInstance().getWhenReady(clkChevron, 60).click();
			startDate = startDate - 29;
		}
		String strStartDate= Integer.toString(startDate + 5);
		By selStartDate = By.xpath("//span[contains(text(),'" + strStartDate + "') and @class='owl-dt-calendar-cell-content']");
		getReusableActionsInstance().getWhenReady(selStartDate, 90).click();
		getReusableActionsInstance().waitForElementVisibility(rdoTechInstallSlot, 90);
		getReusableActionsInstance().getWhenReady(rdoTechInstallSlot, 90).click();
		}
	}
	
	public void selSelffinstallDateAndTimeMigrartion() {
		if(getReusableActionsInstance().isElementVisible(rdoTechInstallSlot, 90))
		{
		getReusableActionsInstance().getWhenReady(rdoTechInstallSlot, 30).click();
		}
		else
		{
		getReusableActionsInstance().waitForElementVisibility(clkCalendarIcon,20);
		getReusableActionsInstance().getWhenReady(clkCalendarIcon, 20).click();
		Calendar calendar = Calendar.getInstance();
		int intDate = calendar.get(Calendar.DATE);
		int startDate = intDate + 20; 
		//If startDate > 29 , 29 being the number of days in the month
		if(startDate>29) {
			getReusableActionsInstance().getWhenReady(clkChevron, 60).click();
			startDate = startDate - 29;
		}
		String strStartDate= Integer.toString(startDate + 5);
		By selStartDate = By.xpath("//span[contains(text(),'" + strStartDate + "') and @class='owl-dt-calendar-cell-content']");
		getReusableActionsInstance().getWhenReady(selStartDate, 20).click();
		getReusableActionsInstance().waitForElementVisibility(rdoTechInstallSlot, 180);
		getReusableActionsInstance().getWhenReady(rdoTechInstallSlot, 90).click();
		}
	}
	
	/**
	 * Select Self install date and time
	 * @author chinnarao.vattam
	 */
	public void selSelffinstallDateAndTimeMobile() {
		if(getReusableActionsInstance().isElementVisible(rdoTechInstallSlot, 90))
		{
		getReusableActionsInstance().executeJavaScriptClick(rdoTechInstallSlot);
		}
		else
		{
		getReusableActionsInstance().waitForElementVisibility(clkCalendarIcon,50);
		getReusableActionsInstance().executeJavaScriptClick(clkCalendarIcon);
		Calendar calendar = Calendar.getInstance();
		int intDate = calendar.get(Calendar.DATE);
		int startDate = intDate + 20; 
		//If startDate > 29 , 29 being the number of days in the month
		if(startDate>29) {
			getReusableActionsInstance().waitForElementVisibility(clkChevron, 60);
			getReusableActionsInstance().executeJavaScriptClick(clkChevron);
			startDate = startDate - 29;
		}
		String strStartDate= Integer.toString(startDate + 5);
		By selStartDate = By.xpath("//span[contains(text(),'" + strStartDate + "') and @class='owl-dt-calendar-cell-content']");
		WebElement date = getDriver().findElement(selStartDate);
		getReusableActionsInstance().executeJavaScriptClick(date);
		}
	}

	/**
	 * Select the slot from the available list of slots from installation page
	 * @author Chinnarao.Vattam
	 */
	public void clkTechInstallSlot() {
		getReusableActionsInstance().waitForElementVisibility(rdoTechInstallSlot, 180);
		getReusableActionsInstance().getWhenReady(rdoTechInstallSlot, 180).click();
	}

	/**
	 * Select the slot from the available list of slots from installation page
	 *@return true if the ExchangeFlex Channel link is displayed; else false
	 * @author Chinnarao.Vattam
	 */
	public boolean clktxtIgniteExpressSetupCost() {
		String strCost=getReusableActionsInstance().getWhenReady(txtIgniteExpressSetupCost, 50).getText();
		return strCost.equals("0");
	}

	/**
	 * Select the slot from the available list of slots from installation page
	 * @author Chinnarao.Vattam
	 */
	public void clkTechInstallSlotMobile() {
		if(getReusableActionsInstance().isElementVisible(rdoTechInstallSlot, 90))
		{
			getReusableActionsInstance().getWhenReady(rdoTechInstallSlot, 30).click();
		}
		else
		{
			getReusableActionsInstance().waitForElementVisibility(clkCalendarIcon,20);
			getReusableActionsInstance().getWhenReady(clkCalendarIcon, 20).click();
			Calendar calendar = Calendar.getInstance();
			int intDate = calendar.get(Calendar.DATE);
			int startDate = intDate + 20;
			//If startDate > 29 , 29 being the number of days in the month
			if(startDate>29) {
				getReusableActionsInstance().getWhenReady(clkChevron, 60).click();
				startDate = startDate - 29;
			}
			String strStartDate= Integer.toString(startDate+ 5);
			By selStartDate = By.xpath("//span[contains(text(),'" + strStartDate + "') and @class='owl-dt-calendar-cell-content']");
			getReusableActionsInstance().getWhenReady(selStartDate, 20).click();
			getReusableActionsInstance().waitForElementVisibility(rdoTechInstallSlot, 180);
			getReusableActionsInstance().getWhenReady(rdoTechInstallSlot, 90).click();
		}
	}

	/**
	 * Set dynamic mobile number on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setContactNumber() {
		getReusableActionsInstance().staticWait(5000);
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		getReusableActionsInstance().waitForElementVisibility(txtContainerContactNumber, 90);
		getReusableActionsInstance().getWhenReady(txtContainerContactNumber, 20).click();
		getReusableActionsInstance().getWhenReady(txtContactNumber, 20);
		getReusableActionsInstance().getWhenReady(txtContactNumber, 20).click();
		getReusableActionsInstance().getWhenReady(txtContactNumber, 20).clear();
		getReusableActionsInstance().getWhenReady(txtContactNumber, 30).sendKeys(strPhoneNumber);
	}

	/**
	 * Set dynamic mobile number on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setMobielNumber() {
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		String strEmail = FormFiller.generateEmail();
		if(getReusableActionsInstance().isElementVisible(txtEnroute,90)) {
			getReusableActionsInstance().waitForElementVisibility(txtContainerMobile, 20);
			getReusableActionsInstance().getWhenReady(txtContainerMobile, 10).click();
			getReusableActionsInstance().getWhenReady(txtMobielNumber, 10).clear();
			getReusableActionsInstance().getWhenReady(txtMobielNumber, 3).sendKeys(strPhoneNumber);
			getReusableActionsInstance().waitForElementVisibility(txtContainerEmail, 30);
			getReusableActionsInstance().getWhenReady(txtContainerEmail, 10).click();
			getReusableActionsInstance().getWhenReady(txtEmail, 10).clear();
			getReusableActionsInstance().getWhenReady(txtEmail, 10).sendKeys(strEmail);
		}
		}
	
	/**
	 * Set dynamic mobile number on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setMobielNumberMobile() {
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		String strEmail = FormFiller.generateEmail();
		if(getReusableActionsInstance().isElementVisible(txtEnroute,90)) {
			getReusableActionsInstance().waitForElementVisibility(txtContainerMobile, 20);
			getReusableActionsInstance().getWhenReady(txtContainerMobile, 10).click();
			getReusableActionsInstance().getWhenReady(txtMobielNumber, 10).clear();
			getReusableActionsInstance().getWhenReady(txtMobielNumber, 3).sendKeys(strPhoneNumber);
			getReusableActionsInstance().waitForElementVisibility(txtContainerEmail, 30);
			getReusableActionsInstance().getWhenReady(txtContainerEmail, 10).click();
			getReusableActionsInstance().getWhenReady(txtEmail, 10).clear();
			getReusableActionsInstance().getWhenReady(txtEmail, 10).sendKeys(strEmail);
		}
}
	
	/**
	 * Set dynamic mobile number on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setMobielNumberMigration() {
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		getReusableActionsInstance().waitForElementVisibility(txtContainerMobileMigration,180);
		getReusableActionsInstance().getWhenReady(txtContainerMobileMigration,10).click();
		getReusableActionsInstance().getWhenReady(txtMobielNumberMigration, 30).clear();
		getReusableActionsInstance().getWhenReady(txtMobielNumberMigration, 3).sendKeys(strPhoneNumber);
	}
	/**
	 * Set dynamic email on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setEmailMobile() {
		String strEmail = FormFiller.generateEmail();
		getReusableActionsInstance().waitForElementVisibility(txtContainerEmail,30);
		getReusableActionsInstance().executeJavaScriptClick(txtContainerEmail);
		getReusableActionsInstance().getWhenReady(txtEmail, 30).clear();
		getReusableActionsInstance().getWhenReady(txtEmail,10).sendKeys(strEmail);
	}
	
	/**
	 * Set dynamic email on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setEmail() {
		String strEmail = FormFiller.generateEmail();
		getReusableActionsInstance().waitForElementVisibility(txtContainerEmail,30);
		getReusableActionsInstance().getWhenReady(txtContainerEmail,20).click();
		getReusableActionsInstance().getWhenReady(txtEmail, 30).clear();
		getReusableActionsInstance().getWhenReady(txtEmail,10).sendKeys(strEmail);
	}
	/**
	 * Set dynamic email on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setEmailMigration() {
		String strEmail = FormFiller.generateEmail();
		getReusableActionsInstance().waitForElementVisibility(txtContainerEmailMigration,180);
		getReusableActionsInstance().getWhenReady(txtContainerEmailMigration,10).click();
		getReusableActionsInstance().getWhenReady(txtEmailMigration, 30).clear();
		getReusableActionsInstance().getWhenReady(txtEmailMigration,10).sendKeys(strEmail);
	}
	
	/**
	 * Set dynamic mobile number on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setMobielNumberExistingCustomer() {
		String strPhoneNumber = FormFiller.generatePhoneNumber();
		String strEmail = FormFiller.generateEmail();
		if (getReusableActionsInstance().isElementVisible(txtEnroute, 90)) {
			getReusableActionsInstance().waitForElementVisibility(txtContainerMobileExistingCustomer, 20);
			getReusableActionsInstance().getWhenReady(txtContainerMobileExistingCustomer, 10).click();
			getReusableActionsInstance().getWhenReady(txtMobielNumberExistingCustomer, 30).clear();
			getReusableActionsInstance().getWhenReady(txtMobielNumberExistingCustomer, 3).sendKeys(strPhoneNumber);
			getReusableActionsInstance().waitForElementVisibility(txtContainerEmailExistingCustomer, 20);
			getReusableActionsInstance().getWhenReady(txtContainerEmailExistingCustomer, 30).click();
			getReusableActionsInstance().getWhenReady(txtEmailExistingCustomer, 30).clear();
			getReusableActionsInstance().getWhenReady(txtEmailExistingCustomer, 3).sendKeys(strEmail);
		}
	}
	/**
	 * Set dynamic email on the Order Summary Page
	 * @author Chinnarao.Vattam
	 */
	public void setEmailExistingCustomer() {
		String strEmail = FormFiller.generateEmail();
		getReusableActionsInstance().waitForElementVisibility(txtContainerEmailExistingCustomer,180);
		getReusableActionsInstance().getWhenReady(txtContainerEmailExistingCustomer,10).click();
		getReusableActionsInstance().getWhenReady(txtEmailExistingCustomer, 30).clear();
		getReusableActionsInstance().getWhenReady(txtEmailExistingCustomer, 3).sendKeys(strEmail);
	}
	/**
	 * To select the Technical Installation Start Date
	 * @author chinnarao.vattam
	 */
	public void selTechInstalStartDateOld() {
		getReusableActionsInstance().waitForElementVisibility(imgStartingTechInstallSlot,180);
		getReusableActionsInstance().getWhenReady(imgStartingTechInstallSlot, 60).click();
		Calendar calendar = Calendar.getInstance();
		int intDate = calendar.get(Calendar.DATE);
		int iDate = intDate + 10; 
		if(iDate >= 30) {
		getReusableActionsInstance().waitForElementVisibility(clkChevron, 60);
		getReusableActionsInstance().getWhenReady(clkChevron, 60).click();
		int selDate = intDate - 14 ;
		String strStartDate= Integer.toString(selDate+3);
		By selStartDate = By.xpath("//tr[@class='ng-star-inserted']//td//span[contains(text(),'" + strStartDate + "')]");
		getReusableActionsInstance().getWhenReady(selStartDate, 60).click();
		}
		else
		{
			String strStartDate= Integer.toString(intDate+5);
			By selStartDate = By.xpath("//tr[@class='ng-star-inserted']//td//span[contains(text(),'" + strStartDate + "')]");
			getReusableActionsInstance().getWhenReady(selStartDate, 60).click();
		}
	}

	/**
	 * To select the Technical Installation Start Date
	 * @author chinnarao.vattam
	 */
	public void selTechInstalStartDate() {
		getReusableActionsInstance().waitForElementVisibility(imgStartingTechInstallSlot,180);
		Calendar calendar = Calendar.getInstance();
		int intDate = calendar.get(Calendar.DATE);
		int iDate = intDate + 10;
		int iMonth=calendar.get(Calendar.MONTH) + 1;
		if(iDate >= 30) {
			int selDate = intDate - 14 ;
			int selMonth= iMonth+1;
			String strDate= Integer.toString(selDate+3);
			String strStartDate= selMonth+"/"+strDate +"/"+calendar.get(Calendar.YEAR);
			getReusableActionsInstance().getWhenReady(txtStartDateContainer, 20).click();
			getReusableActionsInstance().getWhenReady(txtStartDateNew, 20).sendKeys(strStartDate);
		}
		else
		{
			String strDate= Integer.toString(intDate+5);
			String strStartDate= iMonth+"/"+strDate +"/"+calendar.get(Calendar.YEAR);
			getReusableActionsInstance().getWhenReady(txtStartDateContainer, 20).click();
			getReusableActionsInstance().getWhenReady(txtStartDateNew, 20).sendKeys(strStartDate);
		}
	}
	/**
	 * To select the Technical Installation End Date
	 * @author chinnarao.vattam
	 */
	public void selTechInstalEndDate() {
		getReusableActionsInstance().waitForElementVisibility(imgEndingTechInstallSlot,90);
		getReusableActionsInstance().getWhenReady(imgEndingTechInstallSlot, 90).click();
		Calendar calendar = Calendar.getInstance();
		int intDate = calendar.get(Calendar.DATE);
		int iMonth=calendar.get(Calendar.MONTH) + 1;
		int iDate = intDate + 10;
		if(iDate >= 30) {
			int selDate = intDate - 6 ;
			int selMonth= iMonth+1;
			String strDate= Integer.toString(selDate+10);
			String strStartDate= selMonth+"/"+strDate +"/"+calendar.get(Calendar.YEAR);
			getReusableActionsInstance().getWhenReady(txtEndDateContainer, 20).click();
			getReusableActionsInstance().getWhenReady(txtEndDateNew, 20).sendKeys(strStartDate);
		}
		else
		{
			int endDate = intDate + 5;
			String strDate= Integer.toString(endDate+4);
			String strStartDate= iMonth+"/"+strDate +"/"+calendar.get(Calendar.YEAR);
			getReusableActionsInstance().getWhenReady(txtEndDateContainer, 20).click();
			getReusableActionsInstance().getWhenReady(txtEndDateNew, 20).sendKeys(strStartDate);
		}
	}
	/**
	 * To select the Technical Installation End Date
	 * @author chinnarao.vattam
	 */
	public void selTechInstalEndDateOld() {
		getReusableActionsInstance().waitForElementVisibility(imgEndingTechInstallSlot,90);
		getReusableActionsInstance().getWhenReady(imgEndingTechInstallSlot, 90).click();
		Calendar calendar = Calendar.getInstance();
		int intDate = calendar.get(Calendar.DATE);
		int iDate = intDate + 10;
		if(iDate >= 30) {
		getReusableActionsInstance().waitForElementVisibility(clkChevron, 60);
		getReusableActionsInstance().getWhenReady(clkChevron, 60).click();
		int selDate = intDate - 6 ;
		String strEndDate= Integer.toString(selDate+10);
		By selEndDate = By.xpath("//tr[@class='ng-star-inserted']//td//span[contains(text(),'" + strEndDate + "')]");
		getReusableActionsInstance().getWhenReady(selEndDate, 30).click();
		}
		else
		{
			int endDate = intDate + 5;
			String strEndDate= Integer.toString(endDate+10);
			By selEndDate = By.xpath("//tr[@class='ng-star-inserted']//td//span[contains(text(),'" + strEndDate + "')]");
			getReusableActionsInstance().getWhenReady(selEndDate, 90).click();
		}
	}
	
	/**
	 * To Click the Technical Install Consent check box
	 * @author chinnarao.vattam
	 */
	public void clkTechInstalConsent() {
		getReusableActionsInstance().waitForElementVisibility(chkTechInstalConsent, 60);
		getReusableActionsInstance().javascriptScrollByVisibleElement(chkTechInstalConsent);
		getReusableActionsInstance().executeJavaScriptClick(chkTechInstalConsent);
	}
	/**
	 * Click the continue button to continue the TechInstall on installation page
	 * @author dharani.up
	 */
	public void clkProInstallUpgradeYes() {
		getReusableActionsInstance().waitForElementTobeClickable(clkProInstallUpgradeYes, 60);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(clkProInstallUpgradeYes, 30).click();
	}

	/**
	 * Click the continue button to continue the TechInstall on installation page
	 * @author dharani.up
	 */
	public void clkProInstallUpgradeNo() {
		getReusableActionsInstance().waitForElementTobeClickable(clkProInstallUpgradeNo, 60);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(clkProInstallUpgradeNo, 30).click();
	}
	/**
	 * To verify the launch of Technical  Install Page
	 * @return true if the TechInstallSlot ratio has available, else false
	 * @author dharani.up
	 */
	public boolean verifyTechInstallSetUp() {
		getReusableActionsInstance().waitForElementVisibility(txtSetUp, 60);
		return	getReusableActionsInstance().isElementVisible(txtSetUp, 20);
	}

	/**
	 * To Click the Technical Install Consent check box
	 * @author chinnarao.vattam
	 */
	public void clkTechInstalConsentExistingCustomer() {
		getReusableActionsInstance().waitForElementVisibility(chkTechInstalConsentExistingCustomer, 60);
		getReusableActionsInstance().javascriptScrollByVisibleElement(chkTechInstalConsentExistingCustomer);
		getReusableActionsInstance().executeJavaScriptClick(chkTechInstalConsentExistingCustomer);
	}
	
	/**
	 * Click the continue button to continue the TechInstall on installation page
	 * @author Chinnarao.Vattam
	 */
	public void clkTechInstallContinue() {
		getReusableActionsInstance().waitForElementTobeClickable(btnTechInstallContinue, 60);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(btnTechInstallContinue, 30).click();
		getReusableActionsInstance().clickIfAvailable(btnTechInstallContinue, 30);
	}

	/**
	 * Click the continue button to continue the TechInstall on installation page
	 * @author Chinnarao.Vattam
	 */
	public void clkTechInstallContinueSelf() {
		getReusableActionsInstance().waitForElementTobeClickable(btnTechInstallContinueSelf, 60);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(btnTechInstallContinueSelf, 30).click();
	}
	/**
	 * Click the continue button to continue the TechInstall on installation page
	 * @author Chinnarao.Vattam
	 */
	public void clk3PTechInstallContinue() {
		getReusableActionsInstance().waitForElementTobeClickable(btn3PTechInstallContinue, 60);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(btn3PTechInstallContinue, 30).click();
	}

	/**
	 * Click the continue button to continue the TechInstall on installation page
	 * @author Chinnarao.Vattam
	 */
	public void clkTechInstallContinueMobile() {
		getReusableActionsInstance().waitForElementTobeClickable(btnTechInstallContinue, 90);
		getReusableActionsInstance().javascriptScrollByVisibleElement(btnTechInstallContinue);
		getReusableActionsInstance().waitForElementVisibility(btnTechInstallContinue, 60);
		getReusableActionsInstance().executeJavaScriptClick(btnTechInstallContinue);
	}

}
