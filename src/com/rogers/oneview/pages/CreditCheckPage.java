package com.rogers.oneview.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

public class CreditCheckPage  extends BasePageClass {

	public CreditCheckPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//div[@class='container-md credit-check']/descendant::rch-dob/child::rch-date-selection/descendant::ds-form-field/descendant::select)[1]")
	WebElement year;

	@FindBy(xpath = "(//div[@class='container-md credit-check']/descendant::rch-dob/child::rch-date-selection/descendant::ds-form-field/descendant::select)[2]")
	WebElement month;

	@FindBy(xpath = "(//div[@class='container-md credit-check']/descendant::rch-dob/child::rch-date-selection/descendant::ds-form-field/descendant::select)[3]")
	WebElement date;

	@FindBy(xpath = "//span[contains(text(),'Your first ID option')]/ancestor::span//following-sibling::select")
	WebElement iD;

	@FindBy(xpath = "//div[@translate='chc.label.creditCheckMessageForTenure']")
	WebElement noIDRequired;

	@FindBy(xpath = "//span[contains(text(),'Select Province')]/ancestor::span//following-sibling::select")
	WebElement province;

	@FindBy(xpath = "(//div[@class='container-md credit-check']/descendant::rch-drivers-license/child::rch-date-selection/descendant::select)[1]")
	WebElement licenseExpiryYear;

	@FindBy(xpath = "(//div[@class='container-md credit-check']/descendant::rch-drivers-license/child::rch-date-selection/descendant::select)[3]")
	WebElement licenseExpiryDay;

	@FindBy(xpath = "(//div[@class='container-md credit-check']/descendant::rch-drivers-license/child::rch-date-selection/descendant::select)[2]")
	WebElement licenseExpiryMonth;

	@FindBy(xpath = "//span[contains(text(),'License Number')]/ancestor::span/parent::div")
	WebElement licenseNoContainer;

	@FindBy(xpath = "//span[contains(text(),'License Number')]/ancestor::span//following-sibling::div/child::input")
	WebElement licenseNoInput;

	@FindBy(xpath = "//span[contains(text(),'Your second ID option')]/ancestor::span//following-sibling::select")
	WebElement secondID;

	@FindBy(xpath = "//span[contains(text(),'Second ID') or contains(text(),'Deuxième pièce')]/parent::div/parent::div//input/parent::div")
	WebElement passportContainer;

	@FindBy(xpath = "//span[contains(text(),'Passport number')]/ancestor::span//following-sibling::div/child::input")
	WebElement passportInput;

	@FindBy(xpath = "(//div[@class='container-md credit-check']/descendant::rch-passport/descendant::select)[1]")
	WebElement passportExpiryYear;

	@FindBy(xpath = "(//div[@class='container-md credit-check']/descendant::rch-passport/descendant::select)[2]")
	WebElement passportExpiryMonth;

	@FindBy(xpath = "(//div[@class='container-md credit-check']/descendant::rch-passport/descendant::select)[3]")
	WebElement passportExpiryDay;

	@FindBy(xpath = "//span[contains(text(),'The customer authorizes') or contains(text(),'Le client autorise Rogers à obtenir des renseignements')]/parent::div/ancestor::ds-checkbox//div[1]")
	WebElement authorizecheckbox;
	
	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button[@ng-reflect-disabled='false']")
	WebElement continueButton;
	
	@FindBy(xpath = "//span[@class='ds-icon rds-icon-expand']/ancestor::button")
	WebElement collapse;

	@FindBy(xpath = "//h2[@translate='global.checkout.fulfillment.installationOption']")
	WebElement installationOption;


	@FindAll({
			@FindBy(xpath ="//div[@class='ds-checkbox__box my-12']"),
			@FindBy(xpath = "//div[@id='ds-checkbox-id-2-label-container']")
	})
	WebElement customerAgreement;

	@FindBy(xpath = "//h2[@translate='global.checkout.billingAndPay']")
	WebElement billingAndPaymentOption;

	@FindBy(xpath ="//span[@translate='chc.creditCard.options.digitalFrontline']")
	WebElement digitalFrontline;

	@FindBy(xpath ="//span[contains(text(), 'No, continue')]/ancestor::button")
	WebElement noContinue;

	/**
	 * Validates that the 'Installation Option(s)' is displayed
	 * @author aditi.jain
	 */
	public boolean verifyInstallationOption() {
		return getReusableActionsInstance().isElementVisible(installationOption,60);
	}

	/**
	 * Go to Page bottom
	 * @author aditi.jain
	 */
	public void goToPageBottom() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
	}
	/**
	 * Validates that the label 'Billing and Payment Options' is displayed
	 * @author aditi.jain
	 */
	public boolean verifyBillingAndPaymentOption() {
		return getReusableActionsInstance().isElementVisible(billingAndPaymentOption,120);
	}

	/**
	 * Choose option digital frontline
	 * @author aditi.jain
	 */
	public void clickDigitalFrontline() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(digitalFrontline);
		getReusableActionsInstance().executeJavaScriptClick(digitalFrontline);
	}

	/**
	 * Customer agree for in person delivery
	 * @author aditi.jain
	 */
	public void clickInPersonDelivery() {
		getReusableActionsInstance().waitForElementVisibility(customerAgreement, 240);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().getWhenReady(customerAgreement, 30).click();
	}
	/**
	 * Select Date of Birth
	 * @param yearofBirth is the Birth Year to set
	 * @param monthofBirth is the Birth Month to set
	 * @param dayofBirth is the Birth day to set
	 * @author chinnarao.vattam
	 */	
	public void setDOB(String yearofBirth,String monthofBirth,String dayofBirth) {	
		getReusableActionsInstance().selectWhenReadyByVisibleText(year, yearofBirth);
		getReusableActionsInstance().selectWhenReady(month,Integer.parseInt(monthofBirth));
		getReusableActionsInstance().selectWhenReadyByVisibleText(date, dayofBirth);
	}
	/**
	 * Select ID's Type and Details
	 * @param expiryYear is ID Expiry Year to set
	 * @param idExpiryMonth is ID Expiry Month to set
	 * @param idExpiryDay is the ID Expiry Day to set 
	 * @param passportNo is the Passport no. to set
	 * @author chinnarao.vattam
	 */	
	public void setPassport(String expiryYear, String idExpiryMonth,String idExpiryDay,String passportNo ) {
		if(!getReusableActionsInstance().isElementVisible(noIDRequired, 5)) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(secondID);
			getReusableActionsInstance().selectWhenReady(secondID, 3);
			getReusableActionsInstance().javascriptScrollByVisibleElement(passportContainer);
			getReusableActionsInstance().clickWhenReady(passportContainer);
			getReusableActionsInstance().javascriptScrollByVisibleElement(passportInput);
			getReusableActionsInstance().enterText(passportInput, passportNo, 30);
			getReusableActionsInstance().javascriptScrollByVisibleElement(passportExpiryYear);
			getReusableActionsInstance().selectWhenReadyByVisibleText(passportExpiryYear, expiryYear);
			getReusableActionsInstance().javascriptScrollByVisibleElement(passportExpiryMonth);
			getReusableActionsInstance().selectWhenReady(passportExpiryMonth, Integer.parseInt(idExpiryMonth));
			getReusableActionsInstance().javascriptScrollByVisibleElement(passportExpiryDay);
			getReusableActionsInstance().selectWhenReadyByVisibleText(passportExpiryDay, idExpiryDay);
		}
	}
	/**
	 * Select ID's Type and Details
	 * @param provinc is the Province to set
	 * @param expiryYear is ID Expiry Year to set
	 * @param idExpiryMonth is ID Expiry Month to set
	 * @param idExpiryDay is the ID Expiry Day to set 
	 * @param licenseNo is the DL No. to set
	 * @author chinnarao.vattam
	 */	
	public void setDriversLicense(String provinc,String expiryYear, String idExpiryMonth,String idExpiryDay,String licenseNo) {
		if(!getReusableActionsInstance().isElementVisible(noIDRequired, 5)) {
			//getReusableActionsInstance().selectWhenReadyByVisibleText(iD, iD1);
			getReusableActionsInstance().selectWhenReady(iD, 2);
			getReusableActionsInstance().selectWhenReadyByVisibleText(province, provinc);
			getReusableActionsInstance().javascriptScrollByVisibleElement(licenseExpiryYear);
			getReusableActionsInstance().selectWhenReadyByVisibleText(licenseExpiryYear, expiryYear);
			getReusableActionsInstance().javascriptScrollByVisibleElement(licenseExpiryMonth);
			getReusableActionsInstance().selectWhenReady(licenseExpiryMonth, Integer.parseInt(idExpiryMonth));
			getReusableActionsInstance().javascriptScrollByVisibleElement(licenseExpiryDay);
			getReusableActionsInstance().selectWhenReadyByVisibleText(licenseExpiryDay, idExpiryDay);
			getReusableActionsInstance().javascriptScrollByVisibleElement(licenseNoContainer);
			getReusableActionsInstance().clickWhenReady(licenseNoContainer);
			getReusableActionsInstance().javascriptScrollByVisibleElement(licenseNoInput);
			getReusableActionsInstance().enterText(licenseNoInput, licenseNo, 30);
		}
	}
	/**
	 * Verify Credit Check Information is correct
	 * @return true if Continue Button in Enable else return False
	 * @author chinnarao.vattam
	 */	
	public boolean verifyCreditInfo() {	
		return getReusableActionsInstance().isElementVisible(continueButton);
	}
	/**
	 * Click Continue Button after Credit Information Entered 
	 * @author chinnarao.vattam
	 */	
	public void clkContinue() {	
		getReusableActionsInstance().clickWhenReady(continueButton);
	}
	/**
	 * Click "No, continue" button to negate cancellation
	 * @author aditi.jain
	 */
	public void continueConfirmation() {
		if(getReusableActionsInstance().isElementVisible(noContinue, 30)){
			getReusableActionsInstance().clickWhenReady(noContinue);
		}
	}
	/**
	 * Click Authorization Checkbox 
	 * @author chinnarao.vattam
	 */	
	public void clkAuthorize() {
		if(!getReusableActionsInstance().isElementVisible(noIDRequired, 5)) {
			getReusableActionsInstance().clickWhenReady(authorizecheckbox);
		}
	}
	/**
	 * Click Collapse(Down Arrow)
	 * @author chinnarao.vattam
	 */	
	public void clkCollapse() {
		getReusableActionsInstance().clickIfAvailable(collapse,60);
	}
}

