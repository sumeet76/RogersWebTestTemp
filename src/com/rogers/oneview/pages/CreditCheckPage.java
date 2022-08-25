package com.rogers.oneview.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;
import utils.FormFiller;

public class CreditCheckPage  extends BasePageClass {

	public CreditCheckPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "(//rch-dob/child::rch-date-selection/descendant::ds-form-field/descendant::select)[1]")
	WebElement year;


	@FindBy(xpath = "(//rch-dob/child::rch-date-selection/descendant::ds-form-field/descendant::select)[2]")
	WebElement month;


	@FindBy(xpath = "(//rch-dob/child::rch-date-selection/descendant::ds-form-field/descendant::select)[3]")
	WebElement date;

	@FindBy(xpath = "//span[contains(text(),'Your first ID option') or contains(text(), 'Votre première pièce d’identité')]/ancestor::span//following-sibling::select")
	WebElement iD;


	@FindBy(xpath = "//div[@class='rch-payment-options']/descendant::rch-dropdown/descendant::select | //div[@class='rch-payment-options']/descendant::select | //select[@id='ds-form-input-id-0']")
	WebElement paymentOption;

	@FindBy(xpath = "//div[@translate='chc.label.creditCheckMessageForTenure']")
	WebElement noIDRequired;

	@FindBy(xpath = "//span[contains(text(),'Select Province') or contains(text(),'Sélectionner une province')]/ancestor::span//following-sibling::select")
	WebElement province;


	@FindBy(xpath = "(//rch-drivers-license/child::rch-date-selection/descendant::select)[1]")
	WebElement licenseExpiryYear;


	@FindBy(xpath = "(//rch-drivers-license/child::rch-date-selection/descendant::select)[3]")
	WebElement licenseExpiryDay;


	@FindBy(xpath = "(//rch-drivers-license/child::rch-date-selection/descendant::select)[2]")
	WebElement licenseExpiryMonth;

	@FindBy(xpath = "//span[contains(text(),'License Number') or contains(text(),'Numéro du permis')]/ancestor::span/parent::div")
	WebElement licenseNoContainer;

	@FindBy(xpath = "//span[contains(text(),'License Number') or contains(text(),'Numéro du permis')]/ancestor::span//following-sibling::div/child::input")
	WebElement licenseNoInput;

	@FindBy(xpath = "//span[contains(text(),'Your second ID option') or contains(text(),'Deuxieme piece d’identite')]/ancestor::span//following-sibling::select")
	WebElement secondID;

	@FindBy(xpath = "//span[contains(text(),'Second ID') or contains(text(),'Deuxième pièce')]/parent::div/parent::div//input/parent::div")
	WebElement passportContainer;

	@FindBy(xpath = "//span[contains(text(),'Passport number') or contains(text(),'Numéro de passeport')]/ancestor::span//following-sibling::div/child::input")
	WebElement passportInput;


	@FindBy(xpath = "(//rch-passport/descendant::select)[1]")
	WebElement passportExpiryYear;


	@FindBy(xpath = "(//rch-passport/descendant::select)[2]")
	WebElement passportExpiryMonth;


	@FindBy(xpath = "(//rch-passport/descendant::select)[3]")
	WebElement passportExpiryDay;

	@FindBy(xpath = "//span[contains(text(),'The customer authorizes') or contains(text(),'Le client autorise Rogers à obtenir des renseignements')]/parent::div/ancestor::ds-checkbox//div[1]")
	WebElement authorizecheckbox;
	
	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement continueButton;


	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement continueButtonFromInstallOption;


	@FindBy(xpath = "//span[@class='ds-icon rds-icon-expand']/ancestor::button")
	WebElement collapse;


	@FindAll({
			//@FindBy(xpath = "//h2[text()='Self-installation option(s)' or contains(text(),'Options d’installation par l'utilisateur')]"),
			//@FindBy(xpath = "//h2[text()='Professional installation option(s)']"),
			@FindBy(xpath = "//h1[@translate='global.checkout.fulfillment.title']")
	})
	WebElement installationOption;

	@FindBy(xpath="//span[text()='Ignite Express Setup – Courier Delivery' or contains(text(),'Configuration express Élan – Livraison par messager')]")
	WebElement courierDelivery;


	@FindAll({
			@FindBy(xpath ="//div[@class='ds-checkbox__box my-12']"),
			@FindBy(xpath = "//div[@id='ds-checkbox-id-2-label-container']")
	})
	WebElement customerAgreement;

	@FindBy(xpath = "//h1[@translate='global.checkout.billingAndPayment.title']")
	WebElement billingAndPaymentOption;

	@FindBy(xpath ="//span[@translate='chc.creditCard.options.digitalFrontline']")
	WebElement digitalFrontline;

	@FindBy(xpath ="//span[contains(text(), 'No, continue')]/ancestor::button")
	WebElement noContinue;

	@FindBy(xpath = "//h1[@translate='global.checkout.billingAndPayment.title']")
	WebElement billingAndPaymentHeader;

	@FindBy(xpath = "//h1[@translate='global.checkout.fulfillment.title']")
	WebElement installationHeader;

	@FindBy(xpath = "//span[contains(text(),'Credit Evaluation') or contains(text(),'Évaluation de crédit')]")
	WebElement creditEvaluationHeader;

	@FindBy(xpath = "//div[contains(text(),'Please do not proceed with order') or contains(text(),'Les renseignements du client doivent être validés auprès de')]/ancestor::div[@class='nfdb']")
	WebElement fraudErrorMessage;

	@FindBy(xpath = "//div[contains(@class,'container position-relative py-16')]")
	WebElement recoEngineRecommendation;

	@FindBy(xpath = "//span[text()='RECOMMENDED' or text()='RECOMMANDATION']")
	WebElement recommendedBanner;

	@FindBy(xpath = "//span[@translate='chc.label.internationalId']")
	WebElement internationalIdRadioBtn;

	@FindBy(xpath = "//span[contains(text(),'Permit Number') or contains(text(),'Numéro du permis')]/ancestor::span//following-sibling::div/child::input")
	WebElement permitInput;

	@FindBy(xpath = "(//div[@class='container-fluid credit-check ng-star-inserted']/descendant::rch-work-study-permit/descendant::select)[1]")
	WebElement permitExpiryYear;

	@FindBy(xpath = "(//div[@class='container-fluid credit-check ng-star-inserted']/descendant::rch-work-study-permit/descendant::select)[2]")
	WebElement permitExpiryMonth;

	@FindBy(xpath = "(//div[@class='container-fluid credit-check ng-star-inserted']/descendant::rch-work-study-permit/descendant::select)[3]")
	WebElement permitExpiryDate;

	@FindBy(xpath ="//span[contains(text(),'Professional') or contains(text(),'Installation professionnelle')]/parent::div/preceding-sibling::div[@class='ds-radioButton__outerCircle my-12']")
	WebElement installationProfessional;

	@FindBy(xpath ="(//ds-radio-button[@ng-reflect-disabled='false']/descendant::input[@name='dateTime'])[1]")
	WebElement firstEnabledDateTime;

	@FindBy(xpath ="//input[@formControlName='enrouteMobileNumber']")
	WebElement mobileNumber;


	@FindBy(xpath ="//input[@formcontrolname='enrouteMobileNumber']/ancestor::div[@class='input_container']")
	WebElement mobileNumberContainer;


	@FindBy(xpath ="//input[@formcontrolname='enrouteEmail']/ancestor::div[@class='input_container']")
	WebElement emailAddressContainer;


	@FindBy(xpath ="//input[@formControlName='enrouteEmail']")
	WebElement emailMailAddress;

	//@FindBy(xpath ="//span[contains(text(),'Delivery by Appointment')]")
	@FindBy(xpath = "//span[text()='Delivery by Appointment' or text()='Livraison par rendez-vous']/parent::div/preceding-sibling::div[@class='ds-radioButton__outerCircle my-12']")
	WebElement deliveryByAppointment;

	@FindBy(xpath ="//input[@formControlName='specialInstructions']")
	WebElement specialInstructions;



	@FindBy(xpath = "//span[text()='Online billing' or text()='Facture en ligne']/parent::div/preceding-sibling::div")
	WebElement onlineBillingOption;

	@FindBy(xpath="//h3[text()='Payment Options']//following::div//following::rch-dropdown")
	WebElement selectPaymentOVR;




	/**
             * Validates that the 'Installation Option(s)' is displayed
             * @author aditi.jain
             */
	public boolean verifyInstallationOption() {
		getReusableActionsInstance().staticWait(5000);
		return getReusableActionsInstance().isElementVisible(installationOption,100);
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
		getReusableActionsInstance().staticWait(30000);
		return getReusableActionsInstance().isElementVisible(billingAndPaymentOption,60);
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

	public void clkCourierDelivery(){
		getReusableActionsInstance().waitForElementVisibility(courierDelivery,240);
		getReusableActionsInstance().executeJavaScriptClick(courierDelivery);
	}
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
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().selectWhenReadyByVisibleText(year, yearofBirth);
		getReusableActionsInstance().selectWhenReady(month,Integer.parseInt(monthofBirth));
		getReusableActionsInstance().selectWhenReadyByVisibleText(date, dayofBirth);
		getReusableActionsInstance().staticWait(5000);
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
		if(!getReusableActionsInstance().isElementVisible(noIDRequired, 2)) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(secondID);
			getReusableActionsInstance().selectWhenReady(secondID, 3);
			getReusableActionsInstance().javascriptScrollByVisibleElement(passportContainer);
			getReusableActionsInstance().executeJavaScriptClick(passportContainer);
			getReusableActionsInstance().javascriptScrollByVisibleElement(passportInput);
			getReusableActionsInstance().enterText(passportInput, passportNo, 45);
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
		if(!getReusableActionsInstance().isElementVisible(noIDRequired, 2)) {
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
			getReusableActionsInstance().executeJavaScriptClick(licenseNoContainer);
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
		getReusableActionsInstance().waitForPageLoad();
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().waitForElementVisibility(continueButton,80);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().executeJavaScriptClick(continueButton);
	}



	/**
	 * Click Continue Button after Credit Information Entered
	 * @author aditi.jain
	 */
	public void clkContinueInstallationOption() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().clickWhenReady(continueButtonFromInstallOption, 10);
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


	/**
	 * Verify Billing And Payment
	 * @return true if available, else false
	 * @author Aditi.jain
	 */
	public boolean verifyBillingAndPayment() {
		return getReusableActionsInstance().isElementVisible(billingAndPaymentHeader,45);
	}


	/**
	 * Verify Installation Header
	 * @return true if available, else false
	 * @author Aditi.jain
	 */
	public boolean verifyInstallationHeader() {
		return getReusableActionsInstance().isElementVisible(installationHeader,100);
	}

	/**
	 * Verify Credit Evaluation Header
	 * @return true if available, else false
	 * @author Aditi.jain
	 */
	public boolean verifyCreditEvaluationHeader() {
		return getReusableActionsInstance().isElementVisible(creditEvaluationHeader,45);
	}

	/**
	 * Verify Credit Evaluation Header
	 * @return true if available, else false
	 * @author Jarmanjeet.Batth
	 */
	public boolean verifyFraudErrorMessage() {
		getReusableActionsInstance().waitForElementVisibility(fraudErrorMessage, 45);
		return getReusableActionsInstance().isElementVisible(fraudErrorMessage,45);
	}

	/**
	 * Verify Credit Evaluation Header
	 * @return true if available, else false
	 * @author Jarmanjeet.Batth
	 */
	public boolean verifyRecoEngineRecommendation() {
		getReusableActionsInstance().waitForElementVisibility(recoEngineRecommendation, 20);
		return getReusableActionsInstance().isElementVisible(recoEngineRecommendation,20);
	}

	public boolean verifyRecommendationBanner() {
		return getReusableActionsInstance().isElementVisible(recommendedBanner,20);
	}

	/**
	 * Select Payment Option
	 * @author aditi.jain
	 */
	public void selectPaymentOption(int index) {
			getReusableActionsInstance().waitForElementVisibility(paymentOption, 45);
			getReusableActionsInstance().scrollToElement(paymentOption);
			getReusableActionsInstance().selectWhenReady(paymentOption, index);
			getReusableActionsInstance().staticWait(5000);

	}

	/**
	 * Selects International ID on Credit Eval Page for OVR and fills out ID details
	 * @param permitNumber is Study/Work permit number to set
	 * @param permitExpYear is permit expiry year to set
	 * @param permitExpMonth is permit expiry month to set
	 * @param permitExpDate is permit expiry date to set
	 * @param passportNo is passport number to set
	 * @param passportExpYear is passport expiry year to set
	 * @param passportExpMonth is passport expiry month to set
	 * @param passportExpDate is passport expiry date to set
	 * @author Sameer.Ahuja
	 */
	public void selectInternationalID(String permitNumber,String permitExpYear, String permitExpMonth, String permitExpDate,
									  String passportNo, String passportExpYear, String passportExpMonth, String passportExpDate) {
		if (getReusableActionsInstance().isElementVisible(internationalIdRadioBtn)) {
			getReusableActionsInstance().clickWhenReady(internationalIdRadioBtn);
			getReusableActionsInstance().javascriptScrollByVisibleElement(permitInput);
			getReusableActionsInstance().executeJavaScriptClick(permitInput);
			getReusableActionsInstance().enterText(permitInput, permitNumber, 30);
			getReusableActionsInstance().javascriptScrollByVisibleElement(permitExpiryYear);
			getReusableActionsInstance().selectWhenReadyByVisibleText(permitExpiryYear, permitExpYear);
			getReusableActionsInstance().javascriptScrollByVisibleElement(permitExpiryMonth);
			getReusableActionsInstance().selectWhenReady(permitExpiryMonth, Integer.parseInt(permitExpMonth));
			getReusableActionsInstance().javascriptScrollByVisibleElement(permitExpiryDate);
			getReusableActionsInstance().selectWhenReadyByVisibleText(permitExpiryDate, permitExpDate);

			getReusableActionsInstance().javascriptScrollByVisibleElement(passportInput);
			getReusableActionsInstance().executeJavaScriptClick(passportInput);
			getReusableActionsInstance().enterText(passportInput, passportNo, 45);
			getReusableActionsInstance().javascriptScrollByVisibleElement(passportExpiryYear);
			getReusableActionsInstance().selectWhenReadyByVisibleText(passportExpiryYear, passportExpYear);
			getReusableActionsInstance().javascriptScrollByVisibleElement(passportExpiryMonth);
			getReusableActionsInstance().selectWhenReady(passportExpiryMonth, Integer.parseInt(passportExpMonth));
			getReusableActionsInstance().javascriptScrollByVisibleElement(passportExpiryDay);
			getReusableActionsInstance().selectWhenReadyByVisibleText(passportExpiryDay, passportExpDate);
		}
	}

	public void selectProfessionalInstallation() {
		getReusableActionsInstance().waitForElementVisibility(installationProfessional);
		getReusableActionsInstance().scrollToElement(installationProfessional);
		getReusableActionsInstance().executeJavaScriptClick(installationProfessional);
	}


	public void clickDateTimeRadioButton() {
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().scrollToElement(firstEnabledDateTime);
		getReusableActionsInstance().executeJavaScriptClick(firstEnabledDateTime);
	}
	public void enterTextMobileNumber(String phoneNumber) {
		getReusableActionsInstance().scrollToElement(mobileNumberContainer);
		getReusableActionsInstance().executeJavaScriptClick(mobileNumberContainer);
		mobileNumber.clear();
		mobileNumber.sendKeys(phoneNumber);
	}

	public void enterEmailMailAddress (String emailAddress) {
		getReusableActionsInstance().scrollToElement(emailAddressContainer);
		getReusableActionsInstance().executeJavaScriptClick(emailAddressContainer);
		emailMailAddress.clear();
		emailMailAddress.sendKeys(emailAddress);
	}

	public void selectDeliveryByAppointment() {
		getReusableActionsInstance().isElementVisible(deliveryByAppointment);
		getReusableActionsInstance().scrollToElement(deliveryByAppointment);
		getReusableActionsInstance().executeJavaScriptClick(deliveryByAppointment);
	}


	public void enterSpecialInstructions() {
		getReusableActionsInstance().scrollToElement(specialInstructions);
		getReusableActionsInstance().executeJavaScriptClick(specialInstructions);
		specialInstructions.clear();
		specialInstructions.sendKeys("test");
		getReusableActionsInstance().staticWait(5000);
	}

	public void selectOnlineBilling()
	{
		getReusableActionsInstance().isElementVisible(onlineBillingOption);
		getReusableActionsInstance().clickWhenReady(onlineBillingOption);
	}

	public void selectPaymentOptionOVR()
	{
		getReusableActionsInstance().waitForElementTobeClickable(selectPaymentOVR,5);
		getReusableActionsInstance().clickWhenReady(selectPaymentOVR);
		getReusableActionsInstance().staticWait(3000);
	}

	public void refreshContinue() {
		getReusableActionsInstance().waitForAllElementsToBeRefreshedAndVisible(By.xpath("//span[text()='Continuer' or text()='Continue']/ancestor::button"),120);
	}
}

