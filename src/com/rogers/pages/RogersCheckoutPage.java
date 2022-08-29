package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.FormFiller;

public class RogersCheckoutPage extends BasePageClass {
	public RogersCheckoutPage(WebDriver driver){super(driver);}

	@FindBy(xpath = "//h1[@id='bfa-page-title']")
	WebElement checkoutTitle;

	//***Cart summary*****

    @FindBy(xpath="(//div[contains(@class,'totalRow d-flex align-items-center')])[1]")
    WebElement monthlyFeeAfterTax;

    @FindBy(xpath="(//div[contains(@class,'dsa-orderTable__totalRow d-flex align-items-center')])[2]")
    WebElement oneTimeFeeAfterTax;

    @FindBy(xpath="//div[contains(@class,'dsa-promoBlock p-md-24 p-16 ds-bgcolor-misty')]")
    WebElement purchaseIncludes;

    @FindBy(xpath="//span[contains(@class,'px-24 ds-borders ds-bgcolor-white ds-label px-8 mw-100 ng-star-inserted')]")
	WebElement labelRpotg;

    //****Create Profile stepper*****

	@FindBy(xpath = "//h2[@data-test='personal-info-title']")
	WebElement createProfileTitle;

	@FindBy(xpath = "//input[@formcontrolname='emailAddress']/ancestor::ds-form-field")
	WebElement emailCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='emailAddress']")
	WebElement inputEmail;

	@FindBy(xpath = "//input[@formcontrolname='emailAddressConfirm']/ancestor::ds-form-field")
	WebElement confirmEmailCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='emailAddressConfirm']")
	WebElement inputConfirmEmail;

	@FindBy(xpath = "//input[@formcontrolname='firstName']/ancestor::ds-form-field")
	WebElement firstNameCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	WebElement inputFirstName;

	@FindBy(xpath = "//input[@formcontrolname='lastName']/ancestor::ds-form-field")
	WebElement lastNameCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	WebElement inputLastName;

	@FindBy(xpath = "//ds-form-field[@data-test='personal-info-business-name']//div[@class='ds-formField__wrapper']")
	WebElement businessNameCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='companyName']")
	WebElement inputBusinessName;

	@FindBy(xpath = "//ds-form-field[@data-test='personal-info-business-number']//div[contains(@class,'ds-formField__wrapper')]")
	WebElement businessNumberCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='businessNumber']")
	WebElement inputBusinessNumber;

	@FindBy(xpath = "//ds-form-field[@data-test='personal-info-company-size']//div[contains(@class,'ds-formField__inputContainer')]")
	WebElement companySizeCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='companySize']")
	WebElement inputCompanySize;

	@FindBy(xpath = "//input[@formcontrolname='contactNumber']/ancestor::ds-form-field")
	WebElement contactNumberCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='contactNumber']")
	WebElement inputContactNumber;

	@FindBy(xpath = "//div[@class='auto-suggest']//ds-form-field")
	WebElement billingAddressCreateProfile;

	@FindBy(xpath = "//div[@class='auto-suggest']//input")
	WebElement inputBillingAddress;

	@FindAll({
			@FindBy(xpath = "(//ds-auto-complete//li)[1]"),
			@FindBy(xpath = "//ul[@role='listbox']//li[last()]")
	})
	WebElement billingAddressSelection;

	@FindBy(xpath = "//div[@data-test='ba-eligible']/div")
	WebElement successMessageRpotg;

	@FindBy(xpath = "//*[@data-test='from-value-same']")
	WebElement useBillingAddressRadioBtnCreateProfile;

	@FindBy(xpath = "//ds-radio-button[@data-test='preferred-language-en']")
	WebElement languageEnglishRadioBtnCreateProfile;

	@FindBy(xpath = "//ngx-recaptcha2[@data-test='recaptcha']//iframe[@role='presentation']")
	WebElement fraGoolgeRecaptcha;
	
	@FindBy(xpath = "//button[@data-test='personal-info-continue']")
	WebElement btnGotoCreditEvalStepper;

	//***Create Profile stepper****

	@FindBy(xpath = "//*[@data-test='credit-eval-title']")
	WebElement creditEvaluationTitle;

	@FindBy(xpath="//*[@id='step-2-open']/form//p[contains(text(),'Date of Birth')]")
	WebElement dateOfBirthLabel;

	@FindBy(xpath="//*[@id='step-2-open']/form/div[1]/ds-form-field/div[1]/div[1]")
	//@FindBy(xpath="//ds-form-field[@data-test='credit-eval-dob']//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-bgcolor-errorField ds-brcolor-error']")
	WebElement txtDOB;

	//@FindBy(xpath= "//*[@id='step-2-open']/form/div[1]/ds-form-field/div[1]/div[1]/input[@format='DD/MM/YYYY']")
	@FindBy(xpath= "//ds-form-field[@data-test='credit-eval-dob']//input[@formcontrolname='dateOfBirth']")
	WebElement inputTxtDOB;

	@FindBy(xpath= "//select[@data-test='dob-select-year']")
	WebElement inputYearDOB;
	
	@FindBy(xpath= "//*[@data-test='dob-select-month']")
	WebElement inputMonthDOB;
	
	@FindBy(xpath= "//*[@data-test='dob-select-day']")
	WebElement inputDayDOB;
	
	@FindBy(xpath="//*[@id='step-2-open']/form//p[contains(text(),'Credit Card')]")
	WebElement creditCardTitle;

	@FindBy(xpath="//*[@class='ds-inputLabel d-block ds-no-overflow']/span[contains(text(),'Card Number')]")
	WebElement cardNumberLabel;

	@FindBy(xpath = "//*[@class='ds-formField__wrapper']//iframe")
	WebElement fraSemaphone;

	@FindBy(xpath = "//input[@id='pan']")
	WebElement txtCardNumber;

	@FindBy(xpath = "//*[@class='d-flex']//input/..")
	WebElement txtExpiryDate;

	@FindBy(xpath = "//*[@class='d-flex']//input")
	WebElement inputExpiryDate;

	@FindBy(xpath = "//*[@id='step-2-open']/form//p[contains(text(),'ID')]")
	WebElement idLabel;

	@FindBy(xpath = "//option[@value='PASSPORT']/..")
	WebElement dropdownidclick;

	@FindBy(xpath = "//input[@formcontrolname='passport']/..")
	WebElement txtPasportNumber;

	@FindBy(xpath = "//input[@formcontrolname='passport']")
	WebElement inputPasportNumber;

	@FindBy(xpath = "//div[@class='ds-checkbox__box my-12']")
	WebElement chkCreditAuthorization;

	@FindBy(xpath = "//button[@data-test='credit-eval-continue']")
	WebElement btnCreditEvalContinue;

	@FindBy(xpath = "//ds-modal-container")
	WebElement popCreditEval;

	@FindBy(xpath = "//ds-modal-container//p[contains(text(),'Credit Evaluation')]")
	WebElement txtCreditEval;

	@FindBy(xpath = "//ds-modal-container//div[@data-state='SECURITY_DEPOSIT']")
	WebElement claSecurityDepositModal;

	@FindBy(xpath = "//ds-modal-container//p[contains(.,'you will need to pay') or contains(.,'un dépôt de garantie')]")
	WebElement txtSecurityDeposit;

	@FindBy(xpath = "((//div[@data-state='SECURITY_DEPOSIT']//div)[2]//p)[3]")
	WebElement depositAmt;

	@FindAll({
		@FindBy(xpath = "//p[@data-test='modal-credit-evaluation-deposit']/following-sibling::div[@class='d-flex']//div[contains(@class,'text-right')]//p[2]"),
		@FindBy(xpath = "//div[contains(@class,'ds-price__amountDollars')]")
	})
	WebElement downPaymentAmt;

	@FindBy(xpath = "//div[@data-test='modal-credit-evaluation-cla']//p[contains(.,'$300.00 credit limit') or contains(.,'de crédit de 300,00 $')]")
	WebElement txtCla;

	@FindBy(xpath = "//button[@title='I Accept' or contains(@title,'accepte')]")
	WebElement acceptButton;

	@FindBy(xpath = "//*[@id='ds-stepper-id-2-completedContent-1']//div[@class='w-100']/p")
	WebElement identificationLabel;
	
	@FindBy(xpath = "(//div[contains(@class,'recaptcha-checkbox-border')])[1]")
	WebElement radioCheckboxCreateProfile;
	
	@FindBy(xpath = "//label[@for='ds-radio-input-id-4']")
	WebElement lblFrenchLanguage;

	@FindBy(xpath = "//div[@id='step-3-open']//h2")
	WebElement chooseNumberTitle;

	@FindBy(xpath = "//div[@role='tablist']/button[@tabindex='0']")
	WebElement selectaNewNumberTab;

	@FindBy(xpath = "//div[@role='tablist']/button[@tabindex='-1']")
	WebElement useAnExistingNumberTab;

	//@FindBy(xpath = "//select[@id='ds-form-input-id-13']")
	@FindBy(xpath = "//ds-form-field[@data-test='choose-number-city']//select")
	WebElement cityDropdown;

	@FindBy(xpath = "//ds-radio-group[@formcontrolname='newNumber']/div/div[1]")
	WebElement rdoChoosePhoneNumber;

	@FindBy(xpath = "//div[@class='my-16']/button")
	WebElement btnFindMoreAvlNumber;

	@FindBy(xpath = "//button[contains(@data-test,'choose-number-continue')]//span[contains(@class,'ds-button__copy text-button text-nowrap')]")
	WebElement btnChooseNumberContinue;

	@FindBy(xpath = "//ds-icon[@data-test='choose-number-complete']/../div/p[1]")
	WebElement lblChooseaNumber;

	@FindBy(xpath = "//p[contains(text(),'Use an existing number') or contains(text(),'Utilisez un numéro actuel')]")
	WebElement existingNumberTab;

	@FindBy(xpath = "//ds-form-field[@data-test='choose-number-existing-number']")
	WebElement existingNumberField;

	@FindBy(xpath = "//input[@formcontrolname='existingNumber']")
	WebElement inputPortInNumber;

	@FindBy(xpath = "//span[contains(text(),'Vérifiez la disponibilité') or contains(text(),'Check availability')]")
	WebElement btnCheckEligibility;

	@FindBy(xpath = "//span[@data-test='port-in-success' or @data-test='Bonne nouvelle']")
	WebElement successPortInMessage;

	@FindBy(xpath = "//ds-modal-container[contains(@id,'ds-modal-container-3')]//p[contains(.,'Promo code cannot be used')]")
	WebElement pomErrorModal;

	@FindBy(xpath = "//div[contains(@class,'ds-modal__wrapper')]//li[contains(.,'Age')]")
	WebElement pomAgeDisQualifier;

	@FindBy(xpath = "//div[contains(@class,'ds-modal__wrapper')]//li[contains(.,'location or area')]")
	WebElement pomLocationDisQualifier;

	@FindBy(xpath = "//span[contains(text(),'Promo code:') or contains(text(),'Code promotionnel :')]//ancestor::div[contains(@class,'dsa-orderTable__row')]")
	WebElement promoCartLineItem;

	@FindBy(xpath = "//span[contains(@class,'ds-button__copy') and contains(.,' Continue without promo code')]")
	WebElement continueWithoutPromoBtn;

	//***Billing & Payment Options stepper

	@FindBy(xpath = "//h2[contains(@data-test,'payment-method-title')]")
	WebElement billingOptionsTitle;

	@FindBy(xpath = "//select[@data-test='select-payment-option']")
	WebElement drpSelectPaymentMethod;

	@FindBy(xpath = "//input[@formcontrolname='name']/..")
	WebElement txtNameOnCard;

	@FindBy(xpath = "//input[@formcontrolname='name']")
	WebElement inputNameOnCard;

	@FindBy(xpath = "//input[@formcontrolname='expiryDate']/..")
	WebElement txtBillingExpiryDate;

	@FindBy(xpath = "//input[@formcontrolname='expiryDate']")
	WebElement inputBillingExpiryDate;

	@FindBy(xpath = "//input[@formcontrolname='cvv']/..")
	WebElement txtCVVNumber;

	@FindBy(xpath = "//input[@formcontrolname='cvv']")
	WebElement inputCVVNumber;

	@FindBy(xpath = "//button[@data-test='add-card-btn']")
	WebElement btnAddCard;

	@FindBy(xpath = "//p[@class='text-body text-bold mb-8']")
	WebElement txtCreditDetails;

	@FindBy(xpath = "//button[@data-test='payment-method-continue']")
	WebElement btnBillingContinueButton;

	//*****Shipping stepper******

	@FindBy(xpath="//ds-radio-button[@data-test='from-value-same-shipping']/label")
	WebElement billingAddressShipping;
	
	@FindBy(xpath="//ds-radio-button[@data-test='from-value-same-shipping']/parent::div//p")
	WebElement prepopulatedShippingAddress;
	
	@FindBy(xpath="//div[@data-test='delivery-information']//p[@class='text-body']/button/..")
	WebElement contactNumberDetails;
	
	@FindBy(xpath="//span[@data-test='email-address']")
	WebElement prepopulatedEmailId;

	@FindBy(xpath="//p[@data-test='step-title-shipping']")
	WebElement deliveryMethodHeader;

	@FindAll({
			@FindBy(xpath = "//ds-radio-button[@data-test='standard-delivery']/label"),
			@FindBy(xpath = "//ds-selection[@data-test='shipping-option-standard']//p[contains(text(),'Standard Delivery')]"),
			@FindBy(xpath = "//p[contains(text(),'Standard Delivery')]/ancestor::span[contains(@class,'ds-selection__label')]")
	})
	WebElement deliveryMethodStandard;

	@FindBy(xpath ="//ds-radio-button[@data-test='potg-delivery']/label")
	WebElement deliveryMethodProOnTheGo;

	@FindAll({
			@FindBy(xpath = "//ds-radio-button[@data-test='in-store-pickup']/label"),
			@FindBy(xpath = "//p[contains(text(),'Express Pickup')]/ancestor::span[contains(@class,'ds-selection__label')]"),
			@FindBy(xpath = "//ds-selection[@data-test='shipping-option-inStorePickUP']//p[contains(text(),' Express Pickup – FREE')]")
	})
	WebElement deliveryMethodExpress;

	@FindBy(xpath ="//location-container//div[@id='store-map-div']")
	WebElement deliveryMethodExpressLocationMap;

	@FindBy(xpath ="//p[@data-test='timeslot-appointment']")
	WebElement deliveryAppointmentTime;

	@FindAll({
			@FindBy(xpath = "//span[contains(@class,'ds-button__copy text-button') and contains(.,'Change address')]"),
			@FindBy(xpath = "//button[@data-test='change-address-btn']//span[contains(text(),'Change address')]")
	})
	WebElement changeShipAddressbtn;

	@FindBy(xpath = "//input[contains(@class,'ds-input') and contains(@id,'ds-form-input-id')]")
	WebElement inputNewShippingAddress;

	@FindBy(xpath = "//button[@data-test='edit-email-btn']//span[contains(text(),'Edit')]")
	WebElement editEmail;

	@FindBy(xpath = "//div[@data-test='location-item']//span[contains(text(),'2')]")
	WebElement selectAnotherBOPISStore;

	@FindBy(xpath = "//div[@data-test='location-item']//span[contains(text(),'2')]/following::div[2]/p")
	WebElement selectedBOPISStoreLoc;

	@FindBy(xpath="//span[@data-test='email-address']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath = "//td[last()-1]/button[@class='w-100 h-100 p-6 p-sm-16']")
	WebElement selDate;

	@FindBy(xpath = "//div[last()][@class='mb-16 w-50 ng-star-inserted']//following::span[@class='ds-selection__label ds-no-overflow text-body mb-0 w-100 py-12 px-16 px-md-24']")
	WebElement selTime;

	@FindBy(xpath = "//button[@data-test='shipping-continue']")
	WebElement continueBtnShipping;
	
	@FindBy(xpath ="//div[@data-test='delivery-information']//child::div/p[2]")
	WebElement appointmentDate;
	
	@FindBy(xpath ="//div[@data-test='delivery-information']//child::div/p[3]")
	WebElement appointmentTime;

	@FindBy(xpath = "//button[@id='main-continue-button']")
	WebElement submitBtnCheckoutPage;

	@FindBy(xpath = "//p[@class='text-body mb-8']")
	WebElement txtBillingDetails;

	@FindBy(xpath = "//ds-accordion-panel[@data-test='shipping-delivery-options']//button")
	WebElement viewAnotherOption;

	@FindAll({
			@FindBy(xpath = "(//div[contains(@class,'button-container')]//button)[2]"),
			@FindBy(xpath = "//div[contains(@class,'button-container')]//button[contains(.,'No,')]"),
	})
	WebElement btnClkNoThanks;

	@FindBy(xpath = "//P[@data-test='timeslot-appointment']")
	WebElement lblAppointmentTime;

	@FindBy(xpath = "//div[contains(@id,'completedContent-2')]//p[3]")
	WebElement txtCtn;

	@FindBy(xpath = "//input[@formcontrolname='emailAddressField']")
	WebElement txtEmailShipping;

	@FindBy(xpath = "//div[@data-test='delivery-information']//ds-form-field")
	WebElement shippingEmailFormField;

	@FindBy(xpath="//input[@id='firstName' or @id='fname' or @formcontrolname='firstName']/parent::div")
	WebElement txtFirstName;

	@FindBy(xpath = "//span[contains(.,'Good News') or contains(.,'Bonne nouvelle')]")
	WebElement txtGoodNewsAccessoryShipMsg;

	@FindBy(xpath = "(//div[contains(@class,'button-container')]//button[contains(.,'No,')]")
	WebElement btnNoThanksVertical;

	@FindBy(xpath = "//auto-pay-promo-banner")
	WebElement autoPayBanner;

	@FindBy(xpath = "//*[@data-test='transit-number']")
	WebElement formTransitNumber;

	@FindBy(xpath = "//*[@data-test='institution-number']")
	WebElement formInstitutionNumber;

	@FindBy(xpath = "//*[@data-test='account-number']")
	WebElement formAccountNumber;

	@FindBy(xpath = "//*[@data-test='transit-number']//input")
	WebElement inputTransitNumber;

	@FindBy(xpath = "//*[@data-test='institution-number']//input")
	WebElement inputInstitutionNumber;

	@FindBy(xpath = "//*[@data-test='account-number']//input")
	WebElement inputAccountNumber;

	@FindBy(xpath = "//ds-checkbox[contains(@id,'dsa-terms-conditions')]")
	WebElement chAutoPayConsent;

	@FindBy(xpath = "//div[contains(text(),'Not now')]/parent::label")
	WebElement skipAutoPay;

	@FindBy(xpath = "//button[@data-test='payment-method-continue']")
	WebElement paymentContinueButton;

	@FindBy(xpath = "//button[@data-test='auto-pay-removal-modal-button']//span[contains(text(),'Continue')]")
	WebElement autoPayRemovalCtnBtn;

	/**
	 * To get the Title of post checkout page
	 * @return checkoutTitle
	 * @author nimmy.george
	 */

	public WebElement getCheckoutTitle()
	{
		getReusableActionsInstance().getWhenReady(checkoutTitle);
		return checkoutTitle;
	}

	/**
	 * This method will get the total monthly fees amount after tax from the cart summary
	 * @return String having total monthly fees amount after tax from the cart summary
	 * @author nimmy.george
	 */

	public String getMonthlyFeeAfterTax() { 
		getReusableActionsInstance().waitForElementVisibility(createProfileTitle, 50);
		getReusableActionsInstance().waitForElementVisibility(monthlyFeeAfterTax, 50);
		getReusableActionsInstance().javascriptScrollByVisibleElement(monthlyFeeAfterTax);
		return monthlyFeeAfterTax.getText().replaceAll("\\n",""); }

	/**
	 * This method will get the total one time fees amount after tax from the cart summary
	 * @return String having total monthly fees amount after tax from the cart summary
	 * @author nimmy.george
	 */

	public String getOneTimeFeeAfterTax() { return oneTimeFeeAfterTax.getText().replaceAll("\\n",""); }

	/**
	 * Verifies the security depopist amount in one time fees section
	 * @param depositAmount security deposit amount from yml file
	 * @return true if deposit amount is displayed correctly in one time fees section, else false
	 * @author praveen.kumar7
	 */
	public boolean verifyOneTimeFeesAfterSecDeposit(String depositAmount) {
		getReusableActionsInstance().scrollToElement(oneTimeFeeAfterTax);
		if(oneTimeFeeAfterTax.getText().replaceAll("\\n","").contains(depositAmount)) {
			return true;
		}
		else
			return false;
	}

	/**
	 * This method will get the purchase includes section displayed below the cart summary
	 * @return String : Return the purchase includes text displayed below the cart summary
	 * @author nimmy.george
	 */

	public String getPurchaseIncludesText(){ return getReusableActionsInstance().getWhenReady(purchaseIncludes,10).getText().trim().replaceAll("\\n", " "); }

	/**
	 * This method will get the RPOTG label from the purchase includes section displayed below the cart summary
	 * @return String : Return the RPOTG label from the the cart summary
	 * @author nimmy.george
	 */

	public String getRpotgLabelPurchaseIncludes(){ return getReusableActionsInstance().getWhenReady(labelRpotg,10).getText().trim(); }


	/**
	 * To Verify Title of Create Profile stepper
	 * @return boolean value
	 * @author nimmy.george
	 */
	public boolean  verifyCreateProfileTitle() { 
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		if(getReusableActionsInstance().getWhenReady(createProfileTitle,30)!= null)
			return true;
				else
					return false;
					}
	

	/**
	 * Enter the email on the Create Profile stepper, email address field
	 * @return the generated email address
	 * @author nimmy.george
	 */

	public String setEmailCreateProfile() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		getReusableActionsInstance().clickWhenReady(emailCreateProfile);
		getReusableActionsInstance().getWhenReady(inputEmail,40).sendKeys(FormFiller.generateEmail());
		return getReusableActionsInstance().getWhenReady(inputEmail,40).getAttribute("value");
	}

	/**
	 * Enter the email on the Create Profile stepper, confirm email address field
	 * @param confirmEmail email address to create a profile
	 * @author nimmy.george
	 */

	public void confirmEmailCreateProfile(String confirmEmail) {
		getReusableActionsInstance().clickWhenReady(confirmEmailCreateProfile);
		getReusableActionsInstance().getWhenReady(inputConfirmEmail, 3).sendKeys(confirmEmail);
	}

	/**
	 * Enter the firstName on the Create Profile stepper, First Name field
	 *@return FirstName
	 * @author nimmy.george
	 */

	public String setFirstNameCreateProfile() {

		getReusableActionsInstance().clickWhenReady(firstNameCreateProfile);
		getReusableActionsInstance().getWhenReady(inputFirstName,3).sendKeys(FormFiller.generateRandomName()+FormFiller.generateRandomName());
		return getReusableActionsInstance().getWhenReady(inputFirstName,20).getAttribute("value");
	}
	
	/**
	 * Enter the firstName on the Create Profile stepper, First Name field [AVS DATA]
	 * @return FirstName Value
	 * @param firstName xpath
	 * @author karthic.hasan
	 */

	public String setFirstNameCreateProfilepage(String firstName) {
		getReusableActionsInstance().clickWhenReady(firstNameCreateProfile);
		getReusableActionsInstance().getWhenReady(inputFirstName,3).sendKeys(firstName);
		return getReusableActionsInstance().getWhenReady(inputFirstName,20).getAttribute("value");
	}

	/**
	 * Enter the lastName on the Create Profile stepper, Last Name field [AVS DATA]
	 * @return LastName
	 * @param lastName xpath
	 * @author karthic.hasan
	 */

	public String setLastNameCreateProfilepage(String lastName) {
		getReusableActionsInstance().clickWhenReady(lastNameCreateProfile);
		getReusableActionsInstance().getWhenReady(inputLastName,3).sendKeys(lastName);
		return getReusableActionsInstance().getWhenReady(inputLastName,20).getAttribute("value");
	}

	/**
	 * This method clicks on No Thanks button in survey modal if available
	 * @author praveen.kumar7
	 */
	 public void clkNoThanks() {
			if(getReusableActionsInstance().isElementVisible(btnClkNoThanks,10)) {
				getReusableActionsInstance().executeJavaScriptClick(btnClkNoThanks);
			}
		}
	/**
	 * Enter the lastName on the Create Profile stepper, Last Name field
	 * @return LastName
	 * @author nimmy.george
	 */

	public String setLastNameCreateProfile() {
		getReusableActionsInstance().clickWhenReady(lastNameCreateProfile);
		getReusableActionsInstance().getWhenReady(inputLastName,3).sendKeys(FormFiller.generateRandomName()+FormFiller.generateRandomName());
		return getReusableActionsInstance().getWhenReady(inputLastName,20).getAttribute("value");
	}

	/**
	 * This method enters value for Business name field
	 * @author praveen.kumar7
	 */
	public void setBusinessName() {
		getReusableActionsInstance().clickWhenReady(businessNameCreateProfile,10);
		getReusableActionsInstance().getWhenReady(inputBusinessName,3).sendKeys(FormFiller.generateRandomName()+FormFiller.generateRandomName());
	}

	/**
	 * This method enters value for Business number field
	 * @param businessNumber business number to be entered in textfield
	 * @author praveen.kumar7
	 */
	public void setBusinessNumber(String businessNumber) {
		getReusableActionsInstance().clickWhenReady(businessNumberCreateProfile,10);
		getReusableActionsInstance().getWhenReady(inputBusinessNumber).sendKeys(businessNumber);
	}

	/**
	 * This method enters value for company size field
	 * @author praveen.kumar7
	 */
	public void setCompanySize(String companySize) {
		getReusableActionsInstance().clickWhenReady(companySizeCreateProfile);
		getReusableActionsInstance().getWhenReady(inputCompanySize,3).sendKeys(companySize);
	}

	/**
	 * Enter the contact number on the Create Profile stepper, Contact number field
	 * @return contactNumber Contact number to create a profile
	 * @param contactNumber from yml file
	 * @author nimmy.george
	 */

	public String setContactNumberCreateProfile(String contactNumber) {
		getReusableActionsInstance().clickWhenReady(contactNumberCreateProfile);
		getReusableActionsInstance().getWhenReady(inputContactNumber,3).sendKeys(contactNumber);
		return getReusableActionsInstance().getWhenReady(inputContactNumber,20).getAttribute("value").trim();
	}

	/**
	 * Enter the Billing Address on the Create Profile stepper, Billing Address field and select it from the dropdown
	 * @return billingAddress Billing Address to create a profile
	 * @param billingAddress from yaml file
	 * @author nimmy.george
	 */

	public String setBillingAddressCreateProfile(String billingAddress) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(txtFirstName);
		getReusableActionsInstance().clickWhenReady(billingAddressCreateProfile);
		inputBillingAddress.sendKeys(billingAddress);
		//getReusableActionsInstance().waitForElementVisibility(billingAddressSelection,20);
		getReusableActionsInstance().executeJavaScriptClick(billingAddressSelection);
		if(getReusableActionsInstance().isElementVisible(billingAddressSelection,10)) {
			getReusableActionsInstance().executeJavaScriptClick(billingAddressSelection);
		}
		return getReusableActionsInstance().getWhenReady(inputBillingAddress,20).getAttribute("value");
	}

	/**
	 * To get the RPOTG success message for the eligible billing address
	 *
	 * @author nimmy.george
	 */

	public void getRpotgSuccessMessage() {
		getReusableActionsInstance().getWhenReady(successMessageRpotg);
	}

	/**
	 * To click on the Use billing address radio button in the Create Profile stepper
	 * @author nimmy.george
	 */

	public void clkUseBillingAddressRadioBtnCreateProfile() {
		getReusableActionsInstance().clickWhenReady(useBillingAddressRadioBtnCreateProfile,3);
	}

	/**
	 * To click on the Language English radio button in the Create Profile stepper
	 * @author nimmy.george
	 */

	public void clkLanguageEnglishRadioBtnCreateProfile() {
		getReusableActionsInstance().clickWhenReady(languageEnglishRadioBtnCreateProfile,3);
	}

	/**
	 * Switch to Credit Card Iframe in Create Profile  stepper
	 *
	 * @author Karthic.hasan
	 */

	public void switchToRecaptchaIFrame() { 
		getDriver().switchTo().frame(getReusableActionsInstance().getWhenVisible(fraGoolgeRecaptcha));
		System.out.println("Switched to iframe");
		}

	/**
	 * To click on the I'm not robot in the Create Profile stepper.
	 * @author nimmy.george
	 */

	public void clkImNotRombotCheckbox() {
		getReusableActionsInstance().waitForPageLoad();
		//getReusableActionsInstance().scrollToElement(radioCheckboxCreateProfile);
		getReusableActionsInstance().clickWhenReady(radioCheckboxCreateProfile,10);
	}

	/**
	 * Switch out of Google Iframe in Create profile stepper
	 *
	 * @author Karthic.hasan
	 */

	public void switchOutOfGoogleIFrame() { getDriver().switchTo().defaultContent(); }
	
	/**
	 * To click "Continue" button in Create profile stepper, that takes you to Credit Evaluation stepper
	 * @author nimmy.george
	 */
	public void clkBtnGotoCreditEvalStepper() {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@data-test='personal-info-continue']")));
		getReusableActionsInstance().clickWhenReady(btnGotoCreditEvalStepper, 40);
	}

	/**
	 * To Verify the Title of Credit Evaluation stepper 
	 * @return True or false
	 * author Karthic.Hasan
	 */

	public boolean verifyCreditEvaluationTitle() {
		//getReusableActionsInstance().getWhenReady(creditEvaluationTitle);
		if(getReusableActionsInstance().isElementVisible(creditEvaluationTitle,10))
		{
		getReusableActionsInstance().javascriptScrollByVisibleElement(creditEvaluationTitle);
		   return true;
		}
		else 
	        return false;
	}

//	/**
//	 * To select DOB dropdown from Credit Evaluation stepper 
//	 * @param strDOB from yaml file
//	 * author Karthic.Hasan
//	 */
//
//	public void setDateOfBirth(String strDOB) {
//		getReusableActionsInstance().getWhenReady(txtDOB).click();
//		getReusableActionsInstance().getWhenVisible(inputTxtDOB).sendKeys(strDOB);
//	}

	
	/**
	 * Switch to Credit Card Iframe in Credit Evaluation stepper
	 * @author Karthic.hasan
	 */

	public void switchToCreditCardIFrame() { getDriver().switchTo().frame(getReusableActionsInstance().getWhenVisible(fraSemaphone)); }

	/**
	 * Enter the Credit Card Number on the Credit Evaluation stepper, Credit Card Field
	 *@param strAccountNumber xpath
	 * @author karthic.hasan
	 */

	public void setCreditCardNumberIFrame(String strAccountNumber) {
//		getReusableActionsInstance().getWhenReady(txtCardNumber, 90);
		getReusableActionsInstance().getWhenReady(txtCardNumber, 30).sendKeys(strAccountNumber);
	}


	/**
	 * Switch out of Credit Card Iframe in Credit Evaluation stepper
	 *
	 * @author Karthic.hasan
	 */

	public void switchOutOfCreditCardIFrame() { getDriver().switchTo().defaultContent(); }

	/**
	 * Enter the Expiry Date on the Credit Evaluation stepper, Expiry Date Field
	 * @param strExpiryDate xpath
	 * @author karthic.hasan
	 */

	public void setExpiryDate(String strExpiryDate) {
		getReusableActionsInstance().staticWait(4000);
		getReusableActionsInstance().getWhenReady(txtExpiryDate).click();
		getReusableActionsInstance().getWhenReady(inputExpiryDate, 10).sendKeys(strExpiryDate);
	}
	/**
	 * Select DOB-Year Dropdown Option on the Credit Evaluation stepper.
	 * @param strYear from Yaml file 
	 * @author karthic.hasan
	 */

	public void selectYearDropdownOption(String strYear) {
		getReusableActionsInstance().staticWait(8000);
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		getReusableActionsInstance().moveToElementAndClick(inputYearDOB,10);
		getReusableActionsInstance().selectWhenReady(inputYearDOB, strYear);

	}
	/**
	 * Select DOB-Month Dropdown Option on the Credit Evaluation stepper.
	 * @param strMonth from Yaml file
	 * @author karthic.hasan
	 */

	public void selectMonthDropdownOption(String strMonth) {
			//clkNoThanks();
			getReusableActionsInstance().javascriptScrollByVisibleElement(creditEvaluationTitle);
			getReusableActionsInstance().clickWhenReady(inputMonthDOB);
			getReusableActionsInstance().selectWhenReady(inputMonthDOB, strMonth);
	}
	/**
	 * Select DOB-Date Dropdown Option on the Credit Evaluation stepper.
	 * @param strDay from yaml file
	 * @author karthic.hasan
	 */

	public void selectDayDropdownOption(String strDay) {
			getReusableActionsInstance().staticWait(5000);
			clkNoThanks();
			getReusableActionsInstance().javascriptScrollByVisibleElement(creditEvaluationTitle);
			getReusableActionsInstance().clickWhenReady(inputDayDOB);
			getReusableActionsInstance().selectWhenReady(inputDayDOB, strDay);
	}

	/**
	 * Select Dropdown Option on the Credit Evaluation stepper, Id Dropdown Field
	 * @param selectYourIdOption value from yaml file
	 * @author karthic.hasan
	 */

	public void selectDropdownOption(String selectYourIdOption) {
		getReusableActionsInstance().waitForElementVisibility(dropdownidclick, 20);
		getReusableActionsInstance().clickWhenReady(dropdownidclick);
		getReusableActionsInstance().selectWhenReady(dropdownidclick, selectYourIdOption);
	}

	/**
	 * Enter the Passport Number on the Credit Evaluation Stepper , Passport NumberField
	 * @param strPasportNumber from Yaml file
	 * @author karthic.hasan
	 */

	public void setPassportNumber(String strPasportNumber) {
		// getReusableActionsInstance().javascriptScrollByVisibleElement(txtPasportNumber);
		getReusableActionsInstance().clickWhenReady(txtPasportNumber);
		getReusableActionsInstance().getWhenReady(inputPasportNumber, 3).sendKeys(strPasportNumber);
	}

	/**
	 * To click on the Authorization Checkbox in the Create Profile stepper
	 * @author karthic.hasan
	 */

	public void clkCreditAuthorizationChkBox() 
	{
		getReusableActionsInstance().getWhenReady(chkCreditAuthorization).click();
		}

	/**
	 * To click on the Credit Evaluation Continue button in the Credit Evaluation stepper
	 * @author karthic.hasan
	 */

	public void clkCreditEvalContinue() { getReusableActionsInstance().getWhenReady(btnCreditEvalContinue).click(); }

	/**
	 * To verify Credit Evaluation popup is present in the Credit Evaluation stepper
	 * @return True or False
	 * @author karthic.hasan
	 */
	public boolean isCreditEvalPopupPresent() { return getReusableActionsInstance().isElementVisible(popCreditEval); }

	/**
	 * To verify Credit Evaluation text is present in the Credit Evaluation Model and return Boolean value.
	 * @return True or False
	 * @author karthic.hasan
	 */

	public boolean isCreditEvalTextOnModalPresent() { return getReusableActionsInstance().isElementVisible(txtCreditEval); }

	/**
	 * Verifies if CLA/Downpayment modal is present after credit evaluation
	 * @return true if modal is present, else false
	 * @author praveen.kumar7
	 */
	public boolean verifyClaDownPaymentModalPresent() {
		return getReusableActionsInstance().isElementVisible(claSecurityDepositModal, 30);
	}

	/**
	 * Verifies if Security Deposit content is present in the CLA/Security Deposit modal
	 * @return true if security deposit content is displayed, else false
	 * @author praveen.kumar7
	 */
	public boolean verifyDownPaymentTextPresent() {
		return getReusableActionsInstance().isElementVisible(txtSecurityDeposit);
	}

	/**
	 * This method verifies if mandatory downpayment amount is displayed properly
	 * @param expectedDownPayment min DownPayment for the device
	 * @return true if deposit is displayed correctly, else false
	 * @author praveen.kumar7
	 */
	public boolean verifyDownPaymentAmt(String expectedDownPayment) {
		//if(riskClass.toUpperCase().contains("HIGH")) {
			String actualDownPayment = getReusableActionsInstance().getWhenReady(downPaymentAmt, 20).getText().trim().replace("$", "");
			if(actualDownPayment.contains(expectedDownPayment) || actualDownPayment.replace(",", ".").contains(expectedDownPayment)) {
				return true;
			} else return false;
		/*} else if (riskClass.toUpperCase().contains("MEDIUM")) {
			double expectedDownPayment = (Double.parseDouble(deviceCost)) / 100.0 * 20.0;
			String actualDownPayment = getReusableActionsInstance().getWhenReady(downPaymentAmt, 20).getText().trim();
			if(actualDownPayment.contains(String.valueOf(expectedDownPayment)) ||
					actualDownPayment.replace(",", ".").contains(String.valueOf(expectedDownPayment))) {
				return true;
			} else return false;
		} else {
			return false;
		}*/
	}

	/**
	 * This method calculates expected mandatory down payment amount(deviceCost-upfrontEdgeAmt) based on Risk
	 * @param upfrontEdgeAmt upfrontEdge Offer for the device
	 * @param deviceCost full price of the device
	 * @param riskClass HIGH/MEDIUM risk
	 * @author subash.nedunchezhian
	 */
	public String setDownPaymentUpfrontEdge(String riskClass, String deviceCost,String upfrontEdgeAmt) {
		double mandatoryDownPayment = (Double.parseDouble(deviceCost)) - (Double.parseDouble(upfrontEdgeAmt));
		if (riskClass.toUpperCase().contains("HIGH")) {
			double expectedDownPayment = (mandatoryDownPayment / 100) * 40.0;
			return String.valueOf(expectedDownPayment);
		} else if (riskClass.toUpperCase().contains("MEDIUM")) {
			double expectedDownPayment = (mandatoryDownPayment / 100.0) * 20.0;
			return String.valueOf(expectedDownPayment);
		} else return "0";
	}

	/**
	 * This method verifies if CLA text is displayed properly
	 * @return true if CLA text is displayed correctly, else false
	 * @author praveen.kumar7
	 */
	public boolean verifyClaTextOnModal() {
		return getReusableActionsInstance().isElementVisible(txtCla);
	}

	/**
	 * This method clicks on the Accpet button in security deposit modal
	 * @author praveen.kumar7
	 */
	public void clkAcceptButton() {
		getReusableActionsInstance().clickIfAvailable(acceptButton, 20);
	}

	/**
	 * To return true if the express location map is available else false
	 * @return True or False
	 * @author Saurav.Goyal
	 */

	public boolean verifyExpressLocationMapPresent() {
		return getReusableActionsInstance().isElementVisible(deliveryMethodExpressLocationMap,30);
	}



	/**
	 * WaitUntill Credit Evaluation text get invisible from the Credit Evaluation Model
	 * @author karthic.hasan
	 */

	public void waitUntilCreditEvalPopupClose() { getReusableActionsInstance().waitForElementVisibility(identificationLabel); }

	/**
	 * To verify Credit Evaluation Identification Label is present in the Credit Evaluation stepper
	 * @author karthic.hasan
	 */
	public boolean isIdentificationLabel() {
		getReusableActionsInstance().waitForElementVisibility(identificationLabel, 50);
		getReusableActionsInstance().javascriptScrollByVisibleElement(identificationLabel);
		return getReusableActionsInstance().isElementVisible(identificationLabel);
	}

	/**
	 * To verify Choose A Number Title in the Choose a Number stepper
	 * @return True or False
	 * @author karthic.hasan
	 */

	public boolean isChooseaNumberTitleDisplayed() { return getReusableActionsInstance().isElementVisible(chooseNumberTitle,30); }

	/**
	 * To verify Select A Number Tab UseAnExistingNumber Tab is present in the Choose a Number stepper and return boolean value.
	 * @return True or False
	 * @author karthic.hasan
	 */

	public boolean isChooseNumberTabsDisplayed() {
		//clkNoThanks();
		return (getReusableActionsInstance().isElementVisible(selectaNewNumberTab) && getReusableActionsInstance().isElementVisible(useAnExistingNumberTab));
	}

	/**
	 * Select City Dropdown Option on the Choose a Number stepper, City Dropdown Field
	 * @param selectYourOption value from yaml file.
	 * @author karthic.hasan
	 */

	public void selectCityDropdownOption(String selectYourOption) {
		getReusableActionsInstance().waitForElementVisibility(cityDropdown, 60);
		getReusableActionsInstance().clickWhenReady(cityDropdown);
		getReusableActionsInstance().selectWhenReadyByVisibleText(cityDropdown, selectYourOption);
	}

	/**
	 * To click on the first Available Phone number Radio button in the Choose a Number stepper
	 * @author karthic.hasan
	 */

	public void clkChosePhoneNumber() {
		getReusableActionsInstance().getWhenReady(rdoChoosePhoneNumber, 80).click();
	}

	/**
	 * To verify Find More Avaialble Number Button in the Choose a Number stepper
	 * @return True or false
	 * @author karthic.hasan
	 */

	public boolean isFindMoreAvlNumberButtonPresent() {
		return getReusableActionsInstance().isElementVisible(btnFindMoreAvlNumber);
	}

	/**
	 * To click on the Choose Number button in the Credit Evaluation stepper
	 * @author karthic.hasan
	 */

	public void clkChooseNumberbutton() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(cityDropdown);
		getReusableActionsInstance().getWhenReady(btnChooseNumberContinue, 60).click();
	}

	/**
	 * To verify Choose A Number Label in the Choose a Number stepper 
	 * @return boolean value
	 * @author karthic.hasan
	 */

	public boolean isChooseaNumberLabelDisplayed() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(lblChooseaNumber);
		return getReusableActionsInstance().isElementVisible(lblChooseaNumber);
	}

	/**
	 * This method clicks on Use an Existing Number Tab in Choose Number Stepper
	 * @author subash.nedunchezhian
	 */
	public void clkExistingNumberTab(){
		getReusableActionsInstance().executeJavaScriptClick(existingNumberTab);
	}

	/**
	 * This method enters PortInNumber from yaml file in Existing Number input field
	 * @author subash.nedunchezhian
	 */
	public void setExistingPortInNumber(String eligiblePortInNumber){
	getReusableActionsInstance().getWhenReady(existingNumberField).click();
	getReusableActionsInstance().getWhenReady(inputPortInNumber).sendKeys(eligiblePortInNumber);
	}

	/**
	 * This method clicks on Check Eligibility button in Choose Number stepper
	 * @author subash.nedunchezhian
	 */
	public void clkCheckEligibilityBtn(){
		getReusableActionsInstance().clickWhenVisible(btnCheckEligibility);
	}

	/**
	 * This method check PortIn Eligible success message after checking the port-in eligibility
	 * @return True if entered number is eligible for port-in or False if not eligible.
	 * @author subash.nedunchezhian
	 */
	public boolean verifyPortInSuccess(){
		return getReusableActionsInstance().isElementVisible(successPortInMessage);
	}

	/**
	 * This method clicks on Continue button in Choose Number stepper
	 * @author subash.nedunchezhian
	 */
	public void clkContinueChooseNumber(){
		getReusableActionsInstance().clickWhenReady(btnChooseNumberContinue);
	}

	/**
	 * This method verifies the POM Error Modal due to Disqualification
	 * @return True if POM Error Modal is displayed else False if not displayed.
	 * @author subash.nedunchezhian
	 */
	public boolean verifyPomErrorModal() {
		return getReusableActionsInstance().isElementVisible(pomErrorModal);
	}
	/**
	 * This method verifies Age Disqualification Message in POM Error Modal
	 * @return True if Age Disqualified message is displayed else False if not displayed.
	 * @author subash.nedunchezhian
	 */
	public boolean verifyAgeDisQualifierMsg() {
		getReusableActionsInstance().waitForElementVisibility(pomAgeDisQualifier);
		String ageQualifierMsg = getReusableActionsInstance().getWhenReady(pomAgeDisQualifier).getText();
		if (ageQualifierMsg.contains("Age")) {
			return true;
		} else return false;
	}
	/**
	 * This method verifies Location Disqualification Message in POM Error Modal
	 * @return True if Location/Area/Province Disqualified message is displayed else False if not displayed.
	 * @author subash.nedunchezhian
	 */
	public boolean verifyLocationDisQualifierMsg() {
		getReusableActionsInstance().waitForElementVisibility(pomLocationDisQualifier);
		String locationQualifierMsg = getReusableActionsInstance().getWhenReady(pomLocationDisQualifier).getText();
		if (locationQualifierMsg.contains("location")) {
			return true;
		} else return false;
	}

	/**
	 * Validates the Line Item of the Promotion in cart summary
	 * @return true if the Promo code and discount amount line item displayed; else false
	 * @author Subash.Nedunchezhian
	 */
	public boolean verifyCartLineItem() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(promoCartLineItem);
		return getReusableActionsInstance().isElementVisible(promoCartLineItem);
	}
	/**
	 * Validates the Line Item of the Promotion is removed from the cart summary
	 * @return true if the Promo code and discount amount line item is not displayed; else false if displayed
	 * @author Subash.Nedunchezhian
	 */
	public boolean verifyPromoRemovedFrmCart(){
			if(getReusableActionsInstance().isElementVisible(promoCartLineItem)){
				return false;
			}else return true;
	}

	/**
	 * This method clicks on Continue Without Promo code button in POM Disqualification Modal
	 * @author subash.nedunchezhian
	 */
	public void clkContinueWithoutPromo(){
		getReusableActionsInstance().clickWhenVisible(continueWithoutPromoBtn);
	}

	/**
	 * To Verify the Title of Billing Options stepper Displayed 
	 * @return True or False Boolean Value.
	 * @author nimmy.george
	 */

	public boolean isBillingOptionsTitleDisplayed() {
		getReusableActionsInstance().getWhenReady(billingOptionsTitle);
		return getReusableActionsInstance().isElementVisible(billingOptionsTitle);
	}

	/**
	 * To verify Payment Method Dropdown is Present in the Billing Payment option stepper
	 * @return True or False
	 * @author karthic.hasan
	 */

	public boolean isPaymentMethodDropdownPresent() {
		return getReusableActionsInstance().isElementVisible(drpSelectPaymentMethod);
	}

	/**
	 * To Select Payment Method from Billing Payment option stepper
	 * @param strPaymentMethod from yaml file.
	 * @author karthic.hasan
	 */	
	public void selectPaymentMethodDropdownOption(String strPaymentMethod) {
		getReusableActionsInstance().scrollToElementAndClick(drpSelectPaymentMethod);
		getReusableActionsInstance().selectWhenReady(drpSelectPaymentMethod, strPaymentMethod);

	}

	/**
	 * Enter Name on Card in the Billing Payment Option Stepper , Name on Card Field
	 * @param strNameOnCard from yaml file.
	 * @author karthic.hasan
	 */

	public void setNameOnCard(String strNameOnCard) {
		getReusableActionsInstance().staticWait(2000);
		getReusableActionsInstance().getWhenReady(txtNameOnCard).click();
		getReusableActionsInstance().getWhenVisible(inputNameOnCard).sendKeys(strNameOnCard);
	}

	/**
	 * Enter Billing Expiry Date in the Billing Payment Option Stepper , Expir Date Field
	 *@param strBillingExpiryDate from Yaml file
	 * @author karthic.hasan
	 */
	public void setBillingExpiryDate(String strBillingExpiryDate) {
		getReusableActionsInstance().getWhenReady(txtBillingExpiryDate).click();
		getReusableActionsInstance().staticWait(1000);
		getReusableActionsInstance().getWhenReady(inputBillingExpiryDate, 10).sendKeys(strBillingExpiryDate);
	}

	/**
	 * Enter CVVNumber in the Billing Payment Option Stepper , CVV Number Field
	 * @param strCVVNumber from yaml file.
	 * @author karthic.hasan
	 */

	public void setCVVNumber(String strCVVNumber) {
		getReusableActionsInstance().getWhenReady(txtCVVNumber).click();
		getReusableActionsInstance().staticWait(1000);
		getReusableActionsInstance().getWhenReady(inputCVVNumber, 10).sendKeys(strCVVNumber);
	}

	/**
	 * To click Add Card button in the Billing Payment Option stepper
	 * @author karthic.hasan
	 */

	public void clkAddCard() {
		getReusableActionsInstance().getWhenReady(btnAddCard).click();
	}

	/**
	 * To verify Card Details displayed in the Billing Payment option stepper
	 *@return True or False
	 * @author karthic.hasan
	 */

	public boolean isCardDetailsDisplayed() {
		return getReusableActionsInstance().isElementVisible(txtCreditDetails,30);
	}

	/**
	 * To click Billing Payment Continue Button from the Billing Payment Option stepper
	 * @author karthic.hasan
	 */

	public void clkBillingContinueButton() {
		getReusableActionsInstance().waitForElementTobeClickable(btnBillingContinueButton , 10);
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		getReusableActionsInstance().clickWhenVisible(btnBillingContinueButton,30);
		getReusableActionsInstance().staticWait(3000);
	}

	/**
	 * To click on the Billing Address radio button in the Shipping stepper
	 * @return true if selected, else false.
	 * @author nimmy.george
	 */

	public boolean clkBillingAddress() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		getReusableActionsInstance().waitForElementTobeClickable(billingAddressShipping , 20);
		getReusableActionsInstance().scrollToElement(billingAddressShipping);
		getReusableActionsInstance().clickWhenReady(billingAddressShipping,20);
		billingAddressShipping.isSelected();
		return true;
	}

	
	/**
     * to get the Complete Address from the Shipping Stepper
     * @return The Complete Address
     ** @author karthic.hasan
     */
    public String getShippingAddress() {
    	getReusableActionsInstance().javascriptScrollToTopOfPage();
        return getReusableActionsInstance().getWhenReady(prepopulatedShippingAddress).getText();
    }
    
    /**
	 * This method will get Complete Contact Number details from Shipping Stepper
	 * @return Complete Contact Number from Shipping stepper
	 * @author karthic.hasan
	 */

	public String getContactNumber() { 
		getReusableActionsInstance().javascriptScrollByVisibleElement(contactNumberDetails);
   	    getReusableActionsInstance().staticWait(3000);
		return contactNumberDetails.getText().replaceAll("\\n",""); 
	}
    
    /**
     * to get the Email ID from the Shipping Stepper
     * @return the Email ID
     * @author karthic.hasan
     */
    public String getEmailId() {
    	getReusableActionsInstance().javascriptScrollToTopOfPage();
        return getReusableActionsInstance().getWhenReady(prepopulatedEmailId).getText();
    }  
    
	/**
	 * To click on Standard Delivery Method in the shipping stepper
	 * @author nimmy.george
	 */

	public void clkDeliveryMethodStandard() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().javascriptScrollByVisibleElement(deliveryMethodHeader);
		if(getReusableActionsInstance().isElementVisible(viewAnotherOption))
		{
		System.out.println("inside loop");
		getReusableActionsInstance().scrollToElementAndClick(viewAnotherOption);
		getReusableActionsInstance().clickWhenReady(deliveryMethodStandard);
		
		}
		else {
			getReusableActionsInstance().clickWhenReady(deliveryMethodStandard,30);
		}
		
	}

	/**
	 * To click on Express Delivery Method in the shipping stepper
	 * @author Saurav.Goyal
	 */

	public void clkDeliveryMethod(String deliveryMethod) {
		getReusableActionsInstance().staticWait(2000);
		if(deliveryMethod.equalsIgnoreCase("EXPRESS")){
			getReusableActionsInstance().staticWait(2000);
			getReusableActionsInstance().clickWhenReady(deliveryMethodExpress,20);
		}else if(deliveryMethod.equalsIgnoreCase("PRO")){
			getReusableActionsInstance().staticWait(2000);
			getReusableActionsInstance().clickWhenReady(deliveryMethodProOnTheGo,20);
		}else{
			getReusableActionsInstance().staticWait(2000);
			getReusableActionsInstance().clickWhenReady(deliveryMethodStandard,20);
		}
	}

	/**
	 * This method selects the another Express Pickup Store Location on Shipping page
	 * @author Subash.Nedunchezhian
	 */
	public void selectAnotherBOPISStore(){
		getReusableActionsInstance().executeJavaScriptClick(selectAnotherBOPISStore);
	}
	/**
	 * This method gets the Express Pickup Store Location on Order Review page
	 *  @return String Express Pickup Store Location
	 * @author Subash.Nedunchezhian
	 */
	public String getSelectedBOPISStoreLoc(){
		return getReusableActionsInstance().getWhenReady(selectedBOPISStoreLoc).getText().replaceAll("\\n", "");
	}

	/**
	 * Enter the new Shipping Address on the Shipping page and select it from the dropdown
	 * @param newShippingAddress from yaml file
	 * @author subash.nedunchezhian
	 */
	public void selectNewShippingAddress(String newShippingAddress) {
		getReusableActionsInstance().clickWhenVisible(changeShipAddressbtn);
		getReusableActionsInstance().executeJavaScriptClick(inputNewShippingAddress);
		getReusableActionsInstance().getWhenReady(inputNewShippingAddress, 5).sendKeys(newShippingAddress);
		if(getReusableActionsInstance().isElementVisible(billingAddressSelection,10)) {
			getReusableActionsInstance().executeJavaScriptClick(billingAddressSelection);
		}
	}

	/**
	 * This method opts out AutoPay payment method and clicks Continue in AutoPay Removal Modal
	 * @author subash.nedunchezhian
	 */
	public void clickSkipAutopay(){
		getReusableActionsInstance().clickWhenVisible(skipAutoPay);
		getReusableActionsInstance().clickWhenReady(paymentContinueButton,20);
		getReusableActionsInstance().clickWhenReady(autoPayRemovalCtnBtn,20);
	}
	/**
	 * This method opts out AutoPay payment method and clicks Continue in AutoPay Removal Modal in NAC flow
	 * @author subash.nedunchezhian
	 */
	public void clickSkipNacAutopay(){
		getReusableActionsInstance().clickWhenReady(autoPayRemovalCtnBtn,20);
	}
	/**
	 * To Verify the appointment time
	 * @return true if Appointment time is available else false
	 * @author saurav.goyal
	 */
	public boolean isAppointmentTimeAvailable() {
		return getReusableActionsInstance().isElementVisible(deliveryAppointmentTime , 30);
	}

	/**
	 * To Select Date from the Shipping stepper
	 * @author karthic.hasan
	 */

	public void selectDate() {
		//getReusableActionsInstance().javascriptScrollByVisibleElement(selDate);
		getReusableActionsInstance().moveToElementAndClick(selDate, 3);
	}

	/**
	 * To Select Time from the Shipping stepper
	 * @author karthic.hasan
	 */

	public void selectTime() {
		getReusableActionsInstance().moveToElementAndClick(selTime, 3);
	}

	/**
	 * To click continue button in the shipping stepper
	 *
	 * @author nimmy.george
	 */


	public void clkContinueBtnShipping() {
		//clkNoThanks();
		getReusableActionsInstance().getWhenReady(continueBtnShipping,30);
        getReusableActionsInstance().scrollToElement(continueBtnShipping);
		getReusableActionsInstance().clickWhenReady(continueBtnShipping, 30);
	}

	/**
	 * To verify the Apoointment label for pro on the go devices
	 * @return true if label is available else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyAppointmentLabel() {
		return getReusableActionsInstance().isElementVisible(lblAppointmentTime, 30);
	}


	
	/**
	 * This method will get Appointment Date from Shipping Stepper
	 * @return String having Appointment Date from Shipping stepper
	 * @author karthic.hasan
	 */

	public String getAppointmentDate() { 
		getReusableActionsInstance().javascriptScrollByVisibleElement(appointmentDate);
   	    getReusableActionsInstance().staticWait(3000);
		return appointmentDate.getText().replaceAll("\\n",""); 
	}

	/**
	 * This method will get Appointment Time from Shipping Stepper
	 * @return String having Appointment Time from Shipping stepper
	 * @author karthic.hasan
	 */

	public String getAppointmentTime() { 
		getReusableActionsInstance().javascriptScrollByVisibleElement(appointmentTime);
   	    getReusableActionsInstance().staticWait(3000);
		return appointmentTime.getText().replaceAll("\\s",""); 
	}
	
    /**
     * To click on submit button below cart summary in the checkout page, that takes you to Order Review Page
     *
     * @author nimmy.george
     */

    public void clksubmitBtnCheckoutPage(){
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().waitForElementTobeClickable(submitBtnCheckoutPage,40);
		getReusableActionsInstance().scrollToElement(submitBtnCheckoutPage);
		getReusableActionsInstance().getWhenReady(submitBtnCheckoutPage,30);
		getReusableActionsInstance().executeJavaScriptClick(submitBtnCheckoutPage);
    }

	/**
	 * To verify Billing Details in the Billing Payment option stepper
	 * @return True or False
	 * @author karthic.hasan
	 */

	public boolean verifyBillingDetails() {
		return getReusableActionsInstance().isElementVisible(txtBillingDetails);
	}

	/**
	 * This method will get the subscriber number selected in choose number stepper
	 * @return CTN number in long data type
	 * @author praveen.kumar7
	 */
	public long getSelectedCtn() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		String ctn = getReusableActionsInstance().getWhenReady(txtCtn,10).getText().trim().replace(" ", "");
		String updatedCtn = ctn.substring(1,4)+ctn.substring(5,8)+ctn.substring(9);
		return Long.parseLong(updatedCtn);
	}

	/**
	 * This method enters the value in email address field in shipping page
	 * @author praveen.kumar7
	 */
	public void setEmailShippingPage() {
		if (getReusableActionsInstance().isElementVisible(shippingEmailFormField, 20)) {
			getReusableActionsInstance().getWhenReady(txtEmailShipping, 20).click();
			getReusableActionsInstance().getWhenReady(txtEmailShipping,10).sendKeys(FormFiller.generateEmail());
		}
	}

	/**
	 * This method verifies if accessory shipping good news message is displayed
	 * @return true if Accessory good news msg is displayed, else false
	 * @author praveen.kumar7
	 */
	public boolean verifyAccessoriesShippingMessage(){
		return getReusableActionsInstance().isElementVisible(txtGoodNewsAccessoryShipMsg);
	}

	/**
	 * This method clicks on No Thanks button in survey modal if available
	 * @author praveen.kumar7
	 */
	public void clkBtnNoThanks() {
		getReusableActionsInstance().clickIfAvailable(btnNoThanksVertical, 5);
	}

	/**
	 * This method verifies the presence of autopay page
	 * @return true if autopay page is displayed, else false
	 * @author praveen.kumar7
	 */
	public boolean verifyAutoPaymentPage() {
		return getReusableActionsInstance().isElementVisible(autoPayBanner,60);
	}

	/**
	 * This method fills the necessary form fields in Automatic payment page
	 * @author praveen.kumar7
	 */
	public void enterBankDetails() {
		getReusableActionsInstance().getWhenReady(formTransitNumber).click();
		inputTransitNumber.sendKeys("00011");
		getReusableActionsInstance().getWhenReady(formInstitutionNumber).click();
		inputInstitutionNumber.sendKeys("001");
		getReusableActionsInstance().getWhenReady(formAccountNumber).click();
		inputAccountNumber.sendKeys(FormFiller.generateRandomNumber(10));
	}

	/**
	 * Clicks on automatic payment consent checkbox
	 * @author praveen.kumar7
	 */
	public void clkAutoPayConsentCheckBox() {
		getReusableActionsInstance().clickWhenReady(chAutoPayConsent);
	}
}

