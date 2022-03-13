package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import com.rogers.testdatamanagement.TestDataHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.FormFiller;

public class RogersOVCheckoutPage extends BasePageClass {
	public RogersOVCheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[@id='bfa-page-title']")
	WebElement checkoutTitle;
	String customerType = null;
	String strTokenNumber = null;

	//***Cart summary*****

	@FindBy(xpath = "(//div[contains(@class,'totalRow d-flex align-items-center')])[1]")
	WebElement monthlyFeeAfterTax;

	@FindBy(xpath = "(//div[contains(@class,'dsa-orderTable__totalRow d-flex align-items-center')])[2]")
	WebElement oneTimeFeeAfterTax;

	@FindBy(xpath = "//div[contains(@class,'dsa-promoBlock p-md-24 p-16 ds-bgcolor-misty')]")
	WebElement purchaseIncludes;

	@FindBy(xpath = "//span[contains(@class,'px-24 ds-borders ds-bgcolor-white ds-label px-8 mw-100 ng-star-inserted')]")
	WebElement labelRpotg;

	//****Create Profile stepper*****

	@FindBy(xpath = "//h2[@data-test='personal-info-title']")
	WebElement createProfileTitle;

	@FindBy(xpath = "(//div[contains(@class,'ds-formField')])[2]")
	WebElement emailCreateProfile;

	@FindBy(xpath = "//input[@id='email' or (contains(@formcontrolname,'email') and  not(contains(@formcontrolname,'Confirm')))]")
	WebElement inputEmail;

	@FindBy(xpath = "(//div[contains(.,'Confirm E-mail Address')])[11] | //input[@name='confirmEmail']/parent::div")
	WebElement confirmEmailCreateProfile;

	@FindBy(xpath = "//input[@id='confirmEmail' or @id='cemail' or contains(@formcontrolname,'Confirm') or contains(@formcontrolname,'confirm')]")
	WebElement inputConfirmEmail;

	@FindBy(xpath = "//input[@formcontrolname='firstName']/parent::div")
	WebElement firstNameCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	WebElement inputFirstName;

	@FindBy(xpath = "//input[@formcontrolname='lastName']/parent::div")
	WebElement lastNameCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	WebElement inputLastName;

	@FindBy(xpath = "//ds-form-field[@data-test='personal-info-business-name']//div[@class='ds-formField__wrapper']")
	WebElement businessNameCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='companyName']")
	WebElement inputBusinessName;

	@FindBy(xpath = "//ds-form-field[@data-test='personal-info-business-number']//div[@class='ds-formField__wrapper']")
	WebElement businessNumberCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='businessNumber']")
	WebElement inputBusinessNumber;

	@FindBy(xpath = "//ds-form-field[@data-test='personal-info-company-size']//div[contains(@class,'ds-formField__inputContainer')]")
	WebElement companySizeCreateProfile;

	@FindBy(xpath = "//input[@formcontrolname='companySize']")
	WebElement inputCompanySize;

	@FindBy(xpath = "//input[contains(@formcontrolname,'contact')]/parent::div")
	WebElement contactNumberCreateProfile;

	@FindBy(xpath = "//input[contains(@formcontrolname,'contact')]")
	WebElement inputContactNumber;

	@FindBy(xpath = "(//div[contains(.,'Billing Address')])[13]")
	WebElement billingAddressCreateProfile;

	@FindBy(xpath = "(//div[contains(.,'Billing Address')])[13]//input[contains(@id,'ds-form-input-id')]")
	WebElement inputBillingAddress;

	@FindBy(xpath = "//r-address-auto-complete[@data-test='personal-info-address']//li[@class='ng-star-inserted'][1]")
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

	@FindBy(xpath = "//*[@id='step-2-open']/form//p[contains(text(),'Date of Birth')]")
	WebElement dateOfBirthLabel;

	@FindBy(xpath = "//*[@id='step-2-open']/form/div[1]/ds-form-field/div[1]/div[1]")
	//@FindBy(xpath="//ds-form-field[@data-test='credit-eval-dob']//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-bgcolor-errorField ds-brcolor-error']")
	WebElement txtDOB;

	//@FindBy(xpath= "//*[@id='step-2-open']/form/div[1]/ds-form-field/div[1]/div[1]/input[@format='DD/MM/YYYY']")
	@FindBy(xpath = "//ds-form-field[@data-test='credit-eval-dob']//input[@formcontrolname='dateOfBirth']")
	WebElement inputTxtDOB;

	@FindBy(xpath = "//select[@data-test='dob-select-year']")
	WebElement inputYearDOB;

	@FindBy(xpath = "//*[@data-test='dob-select-month']")
	WebElement inputMonthDOB;

	@FindBy(xpath = "//*[@data-test='dob-select-day']")
	WebElement inputDayDOB;

	@FindBy(xpath = "//*[@id='step-2-open']/form//p[contains(text(),'Credit Card')]")
	WebElement creditCardTitle;

	@FindBy(xpath = "//*[@class='ds-inputLabel d-block ds-no-overflow']/span[contains(text(),'Card Number')]")
	WebElement cardNumberLabel;

	@FindBy(xpath = "//*[@class='ds-formField__wrapper']//iframe")
	WebElement fraSemaphone;

	@FindBy(xpath = "//input[@id='pan']")
	WebElement txtCardNumber;

	@FindBy(xpath = "//*[@class='d-flex']//input/..")
	WebElement txtExpiryDate;

	@FindAll({
			@FindBy(xpath = "//ds-form-field[@data-test='expiry-date']//input"),
			@FindBy(xpath = "//ds-form-field[@data-test='expiry-date']//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white']")
	})
	WebElement txtDateOfExpiry;

	@FindBy(xpath = "//*[@class='d-flex']//input")
	WebElement inputExpiryDate;

	@FindBy(xpath = "//*[@id='step-2-open']/form//p[contains(text(),'ID')]")
	WebElement idLabel;

	@FindBy(xpath = "//option[@value='PASSPORT']/..")
	WebElement dropdownidclick;

	@FindBy(xpath = "//select[contains(@formcontrolname,'secondaryId')]")
	WebElement secondDropdownIdClick;

	@FindBy(xpath = "//input[@formcontrolname='passport']/..")
	WebElement txtPasportNumber;

	@FindBy(xpath = "//input[@formcontrolname='passport']")
	WebElement inputPasportNumber;

	@FindBy(xpath = "//input[@formcontrolname='number']/..")
	WebElement txtLicenseNumber;

	@FindBy(xpath = "//input[@formcontrolname='number']")
	WebElement inputLicenseNumber;

	@FindBy(xpath = "//input[@formcontrolname='expiryDate']/..")
	WebElement txtLicenseExpiryDate;

	@FindBy(xpath = "//input[@formcontrolname='expiryDate']")
	WebElement inputLicenseExpiryDate;

	@FindBy(xpath = "//input[@formcontrolname='provincialId']/..")
	WebElement txtProvincialIDNumber;

	@FindBy(xpath = "//input[@formcontrolname='provincialId']")
	WebElement inputProvincialIDNumber;

	@FindBy(xpath = "//input[@formcontrolname='sin']/..")
	WebElement txtSINNumber;

	@FindBy(xpath = "//input[@formcontrolname='sin']")
	WebElement inputSINNumber;

	@FindBy(xpath = "//input[@formcontrolname='birthCertificate']/..")
	WebElement txtBirthCertificateNumber;

	@FindBy(xpath = "//input[@formcontrolname='birthCertificate']")
	WebElement inputBirthCertificateNumber;

	@FindBy(xpath = "//ds-form-field[@data-test='name']")
	WebElement nameOnTheCard;

	@FindBy(xpath = "//ds-form-field[@data-test='name']//input")
	WebElement inputNameOnTheCard;

	@FindBy(xpath = "//ds-form-field[@data-test='number']//input")
	WebElement txtInputTokenNumber;

	@FindBy(xpath = "//span[@class='ds-inputLabel d-block ds-no-overflow'][contains(text(),'CVV')]/ancestor::div/input")
	WebElement inputTxtCVV;

	//@FindBy(xpath = "//span[@class='ds-inputLabel d-block ds-no-overflow'][contains(text(),'CVV')]")
	@FindBy(xpath = "//ds-form-field[@data-test='cvv']//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white']")
	WebElement txtContainerCVV;

	@FindAll({
			@FindBy(xpath = "//div[@class='ds-checkbox__box my-12']"),
			@FindBy(xpath = "//ds-checkbox[@name='credit-check']")
	})
	WebElement chkCreditAuthorization;

	@FindBy(xpath = "//button[@data-test='credit-eval-continue']")
	WebElement btnCreditEvalContinue;

	@FindBy(xpath = "//span[contains(text(),' Accept and Continue ')]")
	WebElement acceptAndContinueOnCreditEvalModal;

	@FindBy(xpath = "//th[contains(text(),' Security deposit required ')]//following-sibling::td")
	WebElement securityDepositAmount;

	@FindBy(xpath = "//th[contains(text(),' CLM ')]//following-sibling::td")
	WebElement cLMAmount;

	@FindBy(xpath = "//th[contains(text(),' Risk level ')]//following-sibling::td")
	WebElement riskLevel;

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

	@FindBy(xpath = "(//button[contains(@id,'ds-tabs')])[2]")
	WebElement useAnExistingNumberTab;

	@FindBy(xpath = "(//button[contains(@id,'ds-tabs')])[1]")
	//button[contains(@id,'ds-tabs-3-tab-1')]
	WebElement selectaNewNumberTab;

	@FindBy(xpath = "//button[contains(@data-test,'port-in')]")
	WebElement portinEligibilityCheckBtn;

	@FindBy(xpath = "//button[contains(@data-test,'port-in')]/following::p[2]")
	WebElement portinSuccessTxt;

	@FindBy(xpath = "//button[contains(@data-test,'port-in')]/following::p[3]")
	WebElement tempNumberTxt;

	//@FindBy(xpath = "//select[@id='ds-form-input-id-13']")
	@FindBy(xpath = "//ds-form-field[@data-test='choose-number-city']//select")
	WebElement cityDropdown;

	@FindBy(xpath = "//ds-radio-group[@formcontrolname='newNumber']/div/div[1]")
	WebElement rdoChoosePhoneNumber;

	@FindBy(xpath = "//input[contains(@formcontrolname,'existingNumber')]//..")
	WebElement clickExistingPhoneNumber;

	@FindBy(xpath = "//input[contains(@formcontrolname,'existingNumber')]")
	WebElement fillExistingPhoneNumber;

	@FindBy(xpath = "//div[@class='my-16']/button")
	WebElement btnFindMoreAvlNumber;

	@FindBy(xpath = "//button[contains(@data-test,'choose-number-continue')]//span[contains(@class,'ds-button__copy text-button text-nowrap')]")
	WebElement btnChooseNumberContinue;

	@FindBy(xpath = "//ds-icon[@data-test='choose-number-complete']/../div/p[1]")
	WebElement lblChooseaNumber;

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

	@FindBy(xpath = "//ds-radio-button[@data-test='from-value-same-shipping']/label")
	WebElement billingAddressShipping;

	@FindBy(xpath = "//ds-radio-button[@data-test='from-value-same-shipping']/parent::div//p")
	WebElement prepopulatedShippingAddress;

	@FindBy(xpath = "//div[@data-test='delivery-information']//p[@class='text-body']/button/..")
	WebElement contactNumberDetails;

	@FindBy(xpath = "//span[@data-test='email-address']")
	WebElement prepopulatedEmailId;

	@FindBy(xpath = "//p[@data-test='step-title-shipping']")
	WebElement deliveryMethodHeader;

	@FindBy(xpath = "//ds-radio-button[@data-test='standard-delivery']/label")
	WebElement deliveryMethodStandard;

	@FindBy(xpath = "//ds-radio-button[@data-test='potg-delivery']/label")
	WebElement deliveryMethodProOnTheGo;

	@FindBy(xpath = "//ds-radio-button[@data-test='in-store-pickup']/label")
	WebElement deliveryMethodExpress;

	@FindBy(xpath = "//location-container//div[@id='store-map-div']")
	WebElement deliveryMethodExpressLocationMap;

	@FindBy(xpath = "//p[@data-test='timeslot-appointment']")
	WebElement deliveryAppointmentTime;

	@FindBy(xpath = "//span[@data-test='email-address']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//td[last()-1]/button[@class='w-100 h-100 p-6 p-sm-16']")
	WebElement selDate;

	@FindBy(xpath = "//div[last()][@class='mb-16 w-50 ng-star-inserted']//following::span[@class='ds-selection__label ds-no-overflow text-body mb-0 w-100 py-12 px-16 px-md-24']")
	WebElement selTime;

	@FindBy(xpath = "//button[@data-test='shipping-continue']")
	WebElement continueBtnShipping;

	@FindBy(xpath = "//div[@data-test='delivery-information']//child::div/p[2]")
	WebElement appointmentDate;

	@FindBy(xpath = "//div[@data-test='delivery-information']//child::div/p[3]")
	WebElement appointmentTime;

	@FindBy(xpath = "//button[@id='main-continue-button']")
	WebElement submitBtnCheckoutPage;

	@FindBy(xpath = "//p[@class='text-body mb-8']")
	WebElement txtBillingDetails;

	@FindBy(xpath = "//ds-accordion-panel[@data-test='shipping-delivery-options']//button")
	WebElement viewAnotherOption;

	@FindBy(xpath = "(//span[text()='No, thanks']//ancestor::div[@tabindex='0'])[1]")
	WebElement btnNoThanks;

	@FindBy(xpath = "//P[@data-test='timeslot-appointment']")
	WebElement lblAppointmentTime;

	@FindBy(xpath = "//table[contains(@data-test,'ov-credit-eval')]//th[contains(.,'Downpayment')]/following-sibling::td")
	WebElement downPaymentAmt;

	@FindBy(xpath = "//rch-security-code//ds-form-field")
	WebElement cvvCode;

	@FindBy(xpath = "//rch-security-code//ds-form-field/child::div/child::div/child::input")
	WebElement cardCVV;

	@FindBy(xpath = "//div[@class='input_container']/child::ds-form-field/child::div/child::div/child::div/child::input")
	WebElement token;

	@FindBy(xpath = "//input[@id='transit-code']")
	WebElement transitNumber;

	@FindBy(xpath = "//input[@id='bank-code']")
	WebElement institutionCode;

	@FindBy(xpath = "//input[@id='account-number']")
	WebElement accountNumber;

	@FindBy(xpath = "//div[@class='rch-payment-options']/child::div/child::div/child::rch-pre-authorized-credit-card/child::div/child::div/child::rch-credit-card/child::rch-expiry-date-credit-card/child::div/child::div/following-sibling::div/following-sibling::div//child::ds-form-field/child::div/child::div/child::select")
	WebElement cardExpiryYear;

	@FindBy(xpath = "//div[@class='rch-payment-options']/child::div/child::div/child::rch-pre-authorized-credit-card/child::div/child::div/child::rch-credit-card/child::rch-expiry-date-credit-card/child::div/child::div/child::ds-form-field/child::div/child::div/child::select")
	WebElement cardExpiryMonth;

	@FindBy(xpath = "//span[@translate='global.cta.submit']")
	WebElement submitButton;

	@FindBy(xpath = "//h1[@translate='global.label.OrderReview']")
	WebElement orderReview;

	@FindBy(xpath = "//td[contains(text(),'K4X')]")
	WebElement appliedCouponExists;

	@FindBy(xpath = "//rch-campaign-table/descendant::h3[contains(text(), 'Total savings applied before taxes') or contains(text(), 'Économies totales applicables avant taxes') ]")
	WebElement totalSavingAppliedExists;

	@FindBy(xpath = "//th[@translate='global.label.campaignTable.savings']")
	WebElement savingsExists;

	@FindBy(xpath = "//input[@formcontrolname='emailAddressField']")
	WebElement txtEmailShipping;

	@FindBy(xpath = "//div[@data-test='delivery-information']//ds-form-field")
	WebElement shippingEmailFormField;

	@FindBy(xpath = "//ds-radio-button[@data-test='from-value-different-shipping']/label")
	WebElement radioBtnNewAddress;

	@FindBy(xpath = "(//*[@data-test='shipping-delivery-address']//input)[1]")
	WebElement inputNewAddress;

	@FindBy(xpath = "(//*[@data-test='shipping-delivery-address']//ds-form-field)[1]")
	WebElement newAddressFormField;

	@FindBy(xpath = "//div[@data-test='modal-credit-evaluation-fraud']")
	WebElement nfdbFraudPopup;


	/**
	 * Verify Savings exists
	 * @author aditi.jain
	 */
	public boolean verifySavingsExist() {
		return getReusableActionsInstance().isElementVisible(savingsExists, 30);
	}

	/**
	 * Set expiry month and year of credit card
	 * @author aditi.jain
	 */
	public void setCardExpiryMonthAndYear() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(cardExpiryMonth);
		getReusableActionsInstance().selectWhenReady(cardExpiryMonth, 3);
		getReusableActionsInstance().staticWait(10000);
		getReusableActionsInstance().javascriptScrollByVisibleElement(cardExpiryYear);
		getReusableActionsInstance().selectWhenReady(cardExpiryYear, 3);
	}

	/**
	 * Enter CVV
	 * @author aditi.jain
	 */
	public void setCardCVV(String cvv) {
		getReusableActionsInstance().javascriptScrollByVisibleElement(cvvCode);
		getReusableActionsInstance().clickWhenReady(cvvCode);
		cardCVV.clear();
		cardCVV.sendKeys(cvv);
	}

	/**
	 * Verify Order Review Page
	 * @author aditi.jain
	 */
	public boolean verifyOrderReviewPage() {
		return getReusableActionsInstance().isElementVisible(orderReview, 60);
	}

	/**
	 * Enter credit card number
	 * @author aditi.jain
	 */
	public void enterCardToken(String ccdNumber){
		token.clear();
		token.sendKeys(ccdNumber);
	}


	/**
	 * Enter transit number
	 * @author aditi.jain
	 */
	public void enterTransitNumber(String value){
		transitNumber.clear();
		transitNumber.sendKeys(value);
	}

	/**
	 * Enter institution number
	 * @author aditi.jain
	 */
	public void enterInstitutionNumber(String institutionNumber){
		institutionCode.clear();
		institutionCode.sendKeys(institutionNumber);
	}

	/**
	 * Enter account number
	 * @author aditi.jain
	 */
	public void enterAccountNumber(String value){
		accountNumber.clear();
		accountNumber.sendKeys(value);
	}


	/**
	 * To get the Title of post checkout page
	 *
	 * @return checkoutTitle
	 * @author nimmy.george
	 */

	public WebElement getCheckoutTitle() {
		getReusableActionsInstance().getWhenReady(checkoutTitle);
		return checkoutTitle;
	}

	/**
	 * This method will get the total monthly fees amount after tax from the cart summary
	 *
	 * @return String having total monthly fees amount after tax from the cart summary
	 * @author nimmy.george
	 */

	public String getMonthlyFeeAfterTax() {
		getReusableActionsInstance().waitForElementVisibility(createProfileTitle, 50);
		getReusableActionsInstance().waitForElementVisibility(monthlyFeeAfterTax, 50);
		getReusableActionsInstance().javascriptScrollByVisibleElement(monthlyFeeAfterTax);
		return monthlyFeeAfterTax.getText().replaceAll("\\n", "");
	}

	/**
	 * This method will get the total one time fees amount after tax from the cart summary
	 *
	 * @return String having total monthly fees amount after tax from the cart summary
	 * @author nimmy.george
	 */

	public String getOneTimeFeeAfterTax() {
		return oneTimeFeeAfterTax.getText().replaceAll("\\n", "");
	}

	/**
	 * Verifies the security depopist amount in one time fees section
	 *
	 * @param depositAmount security deposit amount from yml file
	 * @return true if deposit amount is displayed correctly in one time fees section, else false
	 * @author praveen.kumar7
	 */
	public boolean verifyOneTimeFeesAfterSecDeposit(String depositAmount) {
		getReusableActionsInstance().scrollToElement(oneTimeFeeAfterTax);
		if (oneTimeFeeAfterTax.getText().replaceAll("\\n", "").contains(depositAmount)) {
			return true;
		} else
			return false;
	}

	/**
	 * This method will get the purchase includes section displayed below the cart summary
	 *
	 * @return String : Return the purchase includes text displayed below the cart summary
	 * @author nimmy.george
	 */

	public String getPurchaseIncludesText() {
		return getReusableActionsInstance().getWhenReady(purchaseIncludes, 10).getText().trim().replaceAll("\\n", " ");
	}

	/**
	 * This method will get the RPOTG label from the purchase includes section displayed below the cart summary
	 *
	 * @return String : Return the RPOTG label from the the cart summary
	 * @author nimmy.george
	 */

	public String getRpotgLabelPurchaseIncludes() {
		return getReusableActionsInstance().getWhenReady(labelRpotg, 10).getText().trim();
	}


	/**
	 * To Verify Title of Create Profile stepper
	 *
	 * @return boolean value
	 * @author nimmy.george
	 */
	public boolean verifyCreateProfileTitle() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		if (getReusableActionsInstance().getWhenReady(createProfileTitle, 30) != null)
			return true;
		else
			return false;
	}


	/**
	 * Enter the email on the Create Profile stepper, email address field
	 *
	 * @return the generated email address
	 * @author nimmy.george
	 */

	public String setEmailCreateProfile() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		getReusableActionsInstance().clickWhenReady(emailCreateProfile);
		getReusableActionsInstance().getWhenReady(inputEmail, 40).sendKeys(FormFiller.generateEmail());
		return getReusableActionsInstance().getWhenReady(inputEmail, 40).getAttribute("value");
	}

	/**
	 * Enter the email on the Create Profile stepper, confirm email address field
	 *
	 * @param confirmEmail email address to create a profile
	 * @author nimmy.george
	 */

	public void confirmEmailCreateProfile(String confirmEmail) {
		getReusableActionsInstance().clickWhenReady(confirmEmailCreateProfile);
		getReusableActionsInstance().getWhenReady(inputConfirmEmail, 3).sendKeys(confirmEmail);
	}

	/**
	 * Enter the firstName on the Create Profile stepper, First Name field
	 *
	 * @return FirstName
	 * @author nimmy.george
	 */

	public String setFirstNameCreateProfile() {
		getReusableActionsInstance().getWhenReady(firstNameCreateProfile,15);
		getReusableActionsInstance().scrollToElementAndClick(firstNameCreateProfile);
		//getReusableActionsInstance().javascriptScrollByVisibleElement(firstNameCreateProfile);
		//getReusableActionsInstance().clickWhenReady(firstNameCreateProfile, 20);
		inputFirstName.sendKeys(FormFiller.generateRandomName() + FormFiller.generateRandomName());
		return getReusableActionsInstance().getWhenReady(inputFirstName, 20).getAttribute("value");
	}

	/**
	 * Enter the firstName on the Create Profile stepper, First Name field [AVS DATA]
	 *
	 * @param firstName xpath
	 * @return FirstName Value
	 * @author karthic.hasan
	 */

	public String setFirstNameCreateProfilepage(String firstName) {
		getReusableActionsInstance().clickWhenReady(firstNameCreateProfile);
		getReusableActionsInstance().getWhenReady(inputFirstName, 3).sendKeys(firstName);
		return getReusableActionsInstance().getWhenReady(inputFirstName, 20).getAttribute("value");
	}

	/**
	 * Enter the lastName on the Create Profile stepper, Last Name field [AVS DATA]
	 *
	 * @param lastName xpath
	 * @return LastName
	 * @author karthic.hasan
	 */

	public String setLastNameCreateProfilepage(String lastName) {
		getReusableActionsInstance().clickWhenReady(lastNameCreateProfile);
		getReusableActionsInstance().getWhenReady(inputLastName, 3).sendKeys(lastName);
		return getReusableActionsInstance().getWhenReady(inputLastName, 20).getAttribute("value");
	}


	public void clkNoThanks() {
		getReusableActionsInstance().clickIfAvailable(btnNoThanks, 8);
	}

	/**
	 * Enter the lastName on the Create Profile stepper, Last Name field
	 *
	 * @return LastName
	 * @author nimmy.george
	 */

	public String setLastNameCreateProfile() {
		getReusableActionsInstance().getWhenReady(lastNameCreateProfile,5);
		getReusableActionsInstance().scrollToElementAndClick(lastNameCreateProfile);
		inputLastName.sendKeys(FormFiller.generateRandomName() + FormFiller.generateRandomName());
		return getReusableActionsInstance().getWhenReady(inputLastName, 20).getAttribute("value");
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
	 *
	 * @param contactNumber from yml file
	 * @return contactNumber Contact number to create a profile
	 * @author nimmy.george
	 */

	public String setContactNumberCreateProfile(String contactNumber) {
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		getReusableActionsInstance().getWhenReady(contactNumberCreateProfile);
		getReusableActionsInstance().scrollToElement(contactNumberCreateProfile);
		getReusableActionsInstance().clickWhenReady(contactNumberCreateProfile);
		getReusableActionsInstance().getWhenReady(inputContactNumber, 3).sendKeys(contactNumber);
		return getReusableActionsInstance().getWhenReady(inputContactNumber, 20).getAttribute("value").trim();
	}

	/**
	 * Enter the Billing Address on the Create Profile stepper, Billing Address field and select it from the dropdown
	 *
	 * @param billingAddress from yaml file
	 * @return billingAddress Billing Address to create a profile
	 * @author nimmy.george
	 */

	public String setBillingAddressCreateProfile(String billingAddress) {
		getReusableActionsInstance().clickWhenReady(billingAddressCreateProfile);
		inputBillingAddress.sendKeys(billingAddress);
		//getReusableActionsInstance().getWhenReady(inputBillingAddress,15).sendKeys(billingAddress);
		getReusableActionsInstance().moveToElementAndClick(billingAddressSelection, 5);
		return getReusableActionsInstance().getWhenReady(inputBillingAddress, 20).getAttribute("value");
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
	 *
	 * @author nimmy.george
	 */

	public void clkUseBillingAddressRadioBtnCreateProfile() {
		getReusableActionsInstance().clickWhenReady(useBillingAddressRadioBtnCreateProfile, 3);
	}

	/**
	 * To click on the Language English radio button in the Create Profile stepper
	 *
	 * @author nimmy.george
	 */

	public void clkLanguageEnglishRadioBtnCreateProfile() {
		getReusableActionsInstance().clickWhenReady(languageEnglishRadioBtnCreateProfile, 3);
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
	 *
	 * @author nimmy.george
	 */

	public void clkImNotRombotCheckbox() {
		getReusableActionsInstance().waitForPageLoad();
		getReusableActionsInstance().scrollToElement(radioCheckboxCreateProfile);
		getReusableActionsInstance().clickWhenReady(radioCheckboxCreateProfile, 10);
	}

	/**
	 * Switch out of Google Iframe in Create profile stepper
	 *
	 * @author Karthic.hasan
	 */

	public void switchOutOfGoogleIFrame() {
		getDriver().switchTo().defaultContent();
	}

	/**
	 * To click "Continue" button in Create profile stepper, that takes you to Credit Evaluation stepper
	 *
	 * @author nimmy.george
	 */
	public void clkBtnGotoCreditEvalStepper() {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@data-test='personal-info-continue']")));

		getReusableActionsInstance().clickWhenReady(btnGotoCreditEvalStepper, 40);
	}

	/**
	 * To Verify the Title of Credit Evaluation stepper
	 *
	 * @return True or false
	 * author Karthic.Hasan
	 */

	public boolean verifyCreditEvaluationTitle() {
		//getReusableActionsInstance().getWhenReady(creditEvaluationTitle);
		if (getReusableActionsInstance().isElementVisible(creditEvaluationTitle, 10)) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(creditEvaluationTitle);
			return true;
		} else
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
	 *
	 * @author Karthic.hasan
	 */

	public void switchToCreditCardIFrame() {
		getDriver().switchTo().frame(getReusableActionsInstance().getWhenVisible(fraSemaphone));
	}

	/**
	 * Enter the Credit Card Number on the Credit Evaluation stepper, Credit Card Field
	 *
	 * @param strAccountNumber xpath
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

	public void switchOutOfCreditCardIFrame() {
		getDriver().switchTo().defaultContent();
	}

	/**
	 * Enter the Expiry Date on the Credit Evaluation stepper, Expiry Date Field
	 *
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
	 *
	 * @param strYear from Yaml file
	 * @author karthic.hasan
	 */

	public void selectYearDropdownOption(String strYear) {
		getReusableActionsInstance().staticWait(8000);
		getReusableActionsInstance().moveToElementAndClick(inputYearDOB, 10);
		getReusableActionsInstance().selectWhenReady(inputYearDOB, strYear);

	}

	/**
	 * Select DOB-Month Dropdown Option on the Credit Evaluation stepper.
	 *
	 * @param strMonth from Yaml file
	 * @author karthic.hasan
	 */

	public void selectMonthDropdownOption(String strMonth) {
		clkNoThanks();
		getReusableActionsInstance().javascriptScrollByVisibleElement(creditEvaluationTitle);
		getReusableActionsInstance().clickWhenReady(inputMonthDOB);
		getReusableActionsInstance().selectWhenReadyByVisibleText(inputMonthDOB, strMonth);
	}

	/**
	 * Select DOB-Date Dropdown Option on the Credit Evaluation stepper.
	 *
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
	 *
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
	 *
	 * @param strPasportNumber from Yaml file
	 * @author karthic.hasan
	 */

	public void setPassportNumber(String strPasportNumber) {
		//getReusableActionsInstance().javascriptScrollByVisibleElement(txtPasportNumber);
		getReusableActionsInstance().clickWhenReady(txtPasportNumber);
		getReusableActionsInstance().getWhenReady(inputPasportNumber, 3).sendKeys(strPasportNumber);
	}

	/**
	 * Enter the Driver's License Number on the Credit Evaluation Stepper , Driver's License NumberField
	 *
	 * @param strLicenseNumber from Yaml file
	 * @author Sidhartha.Vadrevu
	 */

	public void setLicenseNumber(String strLicenseNumber) {
		//new Select(getDriver().findElement(By.xpath("//select[contains(@formcontrolname,'province')]"))).selectByVisibleText(province);
		getReusableActionsInstance().clickWhenReady(txtLicenseNumber);
		getReusableActionsInstance().getWhenReady(inputLicenseNumber, 3).sendKeys(strLicenseNumber);
		getReusableActionsInstance().clickWhenReady(txtLicenseExpiryDate);
		getReusableActionsInstance().getWhenReady(inputLicenseExpiryDate).sendKeys("07312024");
	}

	/**
	 * Enter the Provincial ID Number on the Credit Evaluation Stepper , Provincial ID NumberField
	 *
	 * @param strProvincialIDNumber from Yaml file
	 * @author Sidhartha.Vadrevu
	 */

	public void setProvincialIDNumber(String strProvincialIDNumber) {
		getReusableActionsInstance().clickWhenReady(txtProvincialIDNumber);
		getReusableActionsInstance().getWhenReady(inputProvincialIDNumber, 3).sendKeys(strProvincialIDNumber);
	}

	/**
	 * Enter the SIN Number on the Credit Evaluation Stepper , SecondaryID SIN NumberField
	 *
	 * @param strSINNumber from Yaml file
	 * @author Sidhartha.Vadrevu
	 */

	public void setSINNumber(String strSINNumber) {
		// getReusableActionsInstance().javascriptScrollByVisibleElement(txtPasportNumber);
		getReusableActionsInstance().clickWhenReady(txtSINNumber);
		getReusableActionsInstance().getWhenReady(inputSINNumber, 3).sendKeys(strSINNumber);
	}

	/**
	 * Enter the Birth Certificate Number on the Credit Evaluation Stepper , SecondaryID Birth Certificate NumberField
	 *
	 * @param strBirthNumber from Yaml file
	 * @author Sidhartha.Vadrevu
	 */

	public void setBirthCertificateNumber(String strBirthNumber) {
		// getReusableActionsInstance().javascriptScrollByVisibleElement(txtPasportNumber);
		getReusableActionsInstance().clickWhenReady(txtBirthCertificateNumber);
		getReusableActionsInstance().getWhenReady(inputBirthCertificateNumber, 3).sendKeys(strBirthNumber);
	}

	/**
	 * Enter the Pre Authorized Credit Card Token Number on the Credit Evaluation Stepper , SecondaryID Pre Authorized Credit Card Token NumberField
	 * @param strTokenNumber from Yaml file
	 * @author Sidhartha.Vadrevu
	 */
	public void setPreAuthCreditTokenNumber(String strTokenNumber) {
		txtInputTokenNumber.click();
		txtInputTokenNumber.sendKeys(strTokenNumber);
		getReusableActionsInstance().staticWait(3000);
		txtExpiryDate.click();
		getReusableActionsInstance().getWhenReady(txtDateOfExpiry, 10).sendKeys("1223");
	}

	/**
	 * This method enters the Pre Authorized CC Token Number on the Credit Evaluation Stepper , SecondaryID Pre Authorized Credit Card Token NumberField
	 * @param strTokenNumber to enter in Token number field
	 * @author praveen.kumar7
	 */
	public void setPreAuthCreditTokenNumberBillingAndOTPPage(String strTokenNumber) {
		getReusableActionsInstance().clickWhenReady(nameOnTheCard);
		getReusableActionsInstance().getWhenReady(inputNameOnTheCard, 3).sendKeys(FormFiller.generateRandomName() + FormFiller.generateRandomName());
		txtInputTokenNumber.click();
		txtInputTokenNumber.sendKeys(strTokenNumber);
		getReusableActionsInstance().staticWait(3000);
		txtExpiryDate.click();
		getReusableActionsInstance().getWhenReady(txtDateOfExpiry, 10).sendKeys("1223");
		String strCVV = FormFiller.generateCVVNumber();
		getReusableActionsInstance().waitForElementVisibility(txtContainerCVV, 50);
		getReusableActionsInstance().getWhenReady(txtContainerCVV, 10).click();
		inputTxtCVV.click();
		getReusableActionsInstance().getWhenReady(inputTxtCVV).sendKeys(strCVV);
	}

	/**
	 * Select Primary Dropdown Option on the Credit Evaluation stepper, Id Dropdown Field
	 *
	 * @param selectYourPrimaryIdOption value from yaml file
	 * @author Sidhartha.Vadrevu
	 */

	public void selectPrimaryDropdownOption(String selectYourPrimaryIdOption, String number) {
		new Select(getDriver().findElement(By.xpath("//select[contains(@formcontrolname,'thirdIdType')]"))).selectByVisibleText(selectYourPrimaryIdOption);
		if (selectYourPrimaryIdOption != null && !selectYourPrimaryIdOption.isEmpty() && (selectYourPrimaryIdOption.contains("Canadian Passport") || selectYourPrimaryIdOption.contains("Passeport Canadien"))) {
			setPassportNumber(number);
		} else if (selectYourPrimaryIdOption != null && !selectYourPrimaryIdOption.isEmpty() && selectYourPrimaryIdOption.contains("Driver's License")) {
			setLicenseNumber(number);
		} else if (selectYourPrimaryIdOption != null && !selectYourPrimaryIdOption.isEmpty() && selectYourPrimaryIdOption.contains("Provincial ID")) {
			setProvincialIDNumber(number);
		} else if (selectYourPrimaryIdOption != null && !selectYourPrimaryIdOption.isEmpty() && selectYourPrimaryIdOption.contains("Social Insurance Number")) {
			setSINNumber(number);
		} else {
			setLicenseNumber(number);
		}

	}

	/**
	 * Select Secondary Dropdown Option on the Credit Evaluation stepper, Id Dropdown Field
	 *
	 * @param selectYourSecondIdOption value from yaml file
	 * @author Sidhartha.Vadrevu
	 */

	public void selectSecondDropdownOption(String selectYourSecondIdOption, String secondNumber) {
		new Select(getDriver().findElement(By.xpath("//select[contains(@formcontrolname,'secondaryId')]"))).selectByVisibleText(selectYourSecondIdOption);
		if (selectYourSecondIdOption != null && !selectYourSecondIdOption.isEmpty() && selectYourSecondIdOption.contains("Canadian Passport")) {
			setPassportNumber(secondNumber);
		} else if (selectYourSecondIdOption != null && !selectYourSecondIdOption.isEmpty() && (selectYourSecondIdOption.contains("Pre-authorized Credit Card - Token") || selectYourSecondIdOption.contains("Carte de crédit préautorisée"))) {
			setPreAuthCreditTokenNumber(secondNumber);
		} else if (selectYourSecondIdOption != null && !selectYourSecondIdOption.isEmpty() && selectYourSecondIdOption.contains("Provincial ID")) {
			setProvincialIDNumber(secondNumber);
		} else if (selectYourSecondIdOption != null && !selectYourSecondIdOption.isEmpty() && (selectYourSecondIdOption.contains("Social Insurance Number") || selectYourSecondIdOption.contains("Numéro d'assurance sociale(SIN)"))) {
			setSINNumber(secondNumber);
		} else if (selectYourSecondIdOption != null && !selectYourSecondIdOption.isEmpty() && selectYourSecondIdOption.contains("Birth Certificate")) {
			setBirthCertificateNumber(secondNumber);
		}
	}

	/**
	 * To click on the Authorization Checkbox in the Create Profile stepper
	 *
	 * @author karthic.hasan
	 */
	public void clkCreditAuthorizationChkBox() {
		getReusableActionsInstance().getWhenReady(chkCreditAuthorization).click();
	}

	/**
	 * To click on the Credit Evaluation Continue button in the Credit Evaluation stepper
	 *
	 * @author karthic.hasan
	 */
	public void clkCreditEvalContinue() {
		getReusableActionsInstance().getWhenReady(btnCreditEvalContinue).click();
	}

	/**
	 * To verify Credit Evaluation popup is present in the Credit Evaluation stepper
	 *
	 * @return True or False
	 * @author karthic.hasan
	 */
	public boolean isCreditEvalPopupPresent() {
		return getReusableActionsInstance().isElementVisible(popCreditEval);
	}

	/**
	 * To verify Credit Evaluation text is present in the Credit Evaluation Model and return Boolean value.
	 *
	 * @return True or False
	 * @author karthic.hasan
	 */

	public boolean isCreditEvalTextOnModalPresent() {
		return getReusableActionsInstance().isElementVisible(txtCreditEval);
	}

	/**
	 * Checks for the presence of 'Accept and Continue' Button on Crdit Evaluation Modal
	 *
	 * @return returns if the element is visible or not
	 * @author sidhartha.vadrevu
	 */
	public boolean checkAcceptAndContinueOnCreditEvalModal() {
		getReusableActionsInstance().waitForElementVisibility(acceptAndContinueOnCreditEvalModal, 30);
		return getReusableActionsInstance().isElementVisible(acceptAndContinueOnCreditEvalModal);
	}

	/**
	 * Checks the customer type based on the attribute values present on the Credit Evaluation Modal
	 *
	 * @return returns the customerType value
	 * @author sidhartha.vadrevu
	 */
	public String checkCustomerType() {
		String[] security = securityDepositAmount.getText().split("\\$");
		String[] clmValue = cLMAmount.getText().split("\\$");
		Double securityDeposit = Double.parseDouble(security[1]);
		Double clm = Double.parseDouble(clmValue[1]);
		String risk = riskLevel.getText();
		if (securityDeposit <= 0 && clm <= 0 && risk.equalsIgnoreCase("Low")) {
			customerType = "Low Risk";
		} else if (securityDeposit == 500 && (clm > 0 && clm < 450) && risk.equalsIgnoreCase("Medium")) {
			customerType = "Medium Risk";
		} else if (securityDeposit == 300 && clm >= 450 && risk.equalsIgnoreCase("High")) {
			customerType = "High Risk";
		}
		System.out.println(customerType);
		return customerType;
	}

	/**
	 * Validates whether the customer type of the provided data matches to the customer type deduced from the data provided on the Credit Evaluation Modal
	 *
	 * @return true if customer types match, false if they don't match
	 * @author sidhartha.vadrevu
	 */
	public boolean validateCustomerType() {
		checkCustomerType();
		String customer = TestDataHandler.buyFlowsOVtestCase08.getCustomerRiskLevel();
		if (customer != null && !customer.isEmpty() && customerType.matches(customer)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Clicks on the 'Accept and Continue' Button from the Crdit Evaluation Modal
	 *
	 * @author sidhartha.vadrevu
	 */
	public void clickAcceptAndContinueOnCreditEvalModal() {
		getReusableActionsInstance().waitForElementVisibility(acceptAndContinueOnCreditEvalModal);
		getReusableActionsInstance().executeJavaScriptClick(acceptAndContinueOnCreditEvalModal);
	}

	/**
	 * Verifies if CLA/Security Deposit modal is present after credit evaluation
	 *
	 * @return true if modal is present, else false
	 * @author praveen.kumar7
	 */
	public boolean verifyClaSecurityDepositModalPresent() {
		return getReusableActionsInstance().isElementVisible(claSecurityDepositModal, 30);
	}

	/**
	 * Verifies if Security Deposit content is present in the CLA/Security Deposit modal
	 *
	 * @return true if security deposit content is displayed, else false
	 * @author praveen.kumar7
	 */
	public boolean verifySecurityDepositTextPresent() {
		return getReusableActionsInstance().isElementVisible(txtSecurityDeposit);
	}

	/**
	 * This method verifies if security deposit amount is displayed properly
	 *
	 * @param depositAmount security deposit amount from yml file
	 * @return true if deposit is displayed correctly, else false
	 * @author praveen.kumar7
	 */
	public boolean verifySecurityDepositAmount(String depositAmount) {
		if (getReusableActionsInstance().getWhenReady(depositAmt).getText().trim().contains(depositAmount)) {
			return true;
		} else return false;
	}

	/**
	 * This method verifies if CLA text is displayed properly
	 *
	 * @return true if CLA text is displayed correctly, else false
	 * @author praveen.kumar7
	 */
	public boolean verifyClaTextOnModal() {
		return getReusableActionsInstance().isElementVisible(txtCla);
	}

	/**
	 * This method clicks on the Accpet button in security deposit modal
	 *
	 * @author praveen.kumar7
	 */
	public void clkAcceptButton() {
		getReusableActionsInstance().clickWhenReady(acceptButton, 30);
	}

	/**
	 * To return true if the express location map is available else false
	 *
	 * @return True or False
	 * @author Saurav.Goyal
	 */

	public boolean verifyExpressLocationMapPresent() {
		return getReusableActionsInstance().isElementVisible(deliveryMethodExpressLocationMap, 30);
	}


	/**
	 * WaitUntill Credit Evaluation text get invisible from the Credit Evaluation Model
	 *
	 * @author karthic.hasan
	 */

	public void waitUntilCreditEvalPopupClose() {
		getReusableActionsInstance().waitForElementVisibility(identificationLabel);
	}

	/**
	 * To verify Credit Evaluation Identification Label is present in the Credit Evaluation stepper
	 *
	 * @author karthic.hasan
	 */
	public boolean isIdentificationLabel() {
		getReusableActionsInstance().waitForElementVisibility(identificationLabel, 50);
		getReusableActionsInstance().javascriptScrollByVisibleElement(identificationLabel);
		return getReusableActionsInstance().isElementVisible(identificationLabel);
	}

	/**
	 * To verify Choose A Number Title in the Choose a Number stepper
	 *
	 * @return True or False
	 * @author karthic.hasan
	 */

	public boolean isChooseaNumberTitleDisplayed() {
		return getReusableActionsInstance().isElementVisible(chooseNumberTitle, 60);
	}

	/**
	 * To verify Select A Number Tab UseAnExistingNumber Tab is present in the Choose a Number stepper and return boolean value.
	 *
	 * @return True or False
	 * @author karthic.hasan
	 */

	public boolean isChooseNumberTabsDisplayed() {
		clkNoThanks();
		return (getReusableActionsInstance().isElementVisible(selectaNewNumberTab) && getReusableActionsInstance().isElementVisible(useAnExistingNumberTab));
	}

	/**
	 * Select City Dropdown Option on the Choose a Number stepper, City Dropdown Field
	 *
	 * @param selectYourOption value from yaml file.
	 * @author karthic.hasan
	 */

	public void selectCityDropdownOption(String selectYourOption) {
		getReusableActionsInstance().waitForElementVisibility(cityDropdown, 20);
		new Select(getDriver().findElement(By.xpath("//ds-form-field[@data-test='choose-number-city']//select"))).selectByVisibleText(selectYourOption);
		/*getReusableActionsInstance().waitForElementVisibility(cityDropdown, 20);
		getReusableActionsInstance().clickWhenReady(cityDropdown);
		getReusableActionsInstance().selectWhenReadyByVisibleText(cityDropdown, selectYourOption);*/
	}

	/**
	 * To click on the first Available Phone number Radio button in the Choose a Number stepper
	 *
	 * @author karthic.hasan
	 */

	public void clkChosePhoneNumber() {
		getReusableActionsInstance().getWhenReady(rdoChoosePhoneNumber, 80).click();
	}

	/**
	 * To verify Find More Avaialble Number Button in the Choose a Number stepper
	 *
	 * @return True or false
	 * @author karthic.hasan
	 */

	public boolean isFindMoreAvlNumberButtonPresent() {
		return getReusableActionsInstance().isElementVisible(btnFindMoreAvlNumber);
	}

	/**
	 * To click on the Choose Number button in the Credit Evaluation stepper
	 *
	 * @author karthic.hasan
	 */

	public void clkChooseNumberbutton() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(cityDropdown);
		getReusableActionsInstance().getWhenReady(btnChooseNumberContinue, 60).click();
	}

	/**
	 * To verify Choose A Number Label in the Choose a Number stepper
	 *
	 * @return boolean value
	 * @author karthic.hasan
	 */

	public boolean isChooseaNumberLabelDisplayed() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(lblChooseaNumber);
		return getReusableActionsInstance().isElementVisible(lblChooseaNumber);
	}

	/**
	 * This method enters the portin number in the portin number field
	 *
	 * @param selectExistingNumber value from yaml file.
	 * @author praveen.kumar
	 */
	public void chooseExistingNumberOption(String selectExistingNumber) {
		getReusableActionsInstance().clickWhenReady(clickExistingPhoneNumber);
		fillExistingPhoneNumber.sendKeys(selectExistingNumber);
	}

	/**
	 * Clicks on Existing number(portin) tab in Choose phone number stepper
	 *
	 * @author praveen.kumar7
	 */
	public void selectPortinOption() {
		getReusableActionsInstance().clickWhenReady(useAnExistingNumberTab, 20);
	}

	/**
	 * This method verifies if the entered number is eligible to portin
	 *
	 * @return true if eligible, else false
	 * @author praveen.kumar
	 */
	public boolean verifyPortinEligibility() {
		getReusableActionsInstance().waitForElementVisibility(portinEligibilityCheckBtn, 30);
		getReusableActionsInstance().clickWhenReady(portinEligibilityCheckBtn, 30);
		getReusableActionsInstance().staticWait(5000);
		return getReusableActionsInstance().isElementVisible(By.xpath("//span[@data-test='port-in-success']"), 30);
	}

	/**
	 * This method gets the portin success message
	 *
	 * @return string value of portin success message and temporary number
	 * @author praveen.kumar
	 */
	public String getPortinSuccessMessage() {
		String successMsg = getReusableActionsInstance().getWhenReady(portinSuccessTxt, 20).getText();
		String tempNumber = getReusableActionsInstance().getWhenReady(tempNumberTxt, 20).getText();
		return successMsg + " and here is your " + tempNumber;
	}

	/**
	 * This method clicks on continue button in portin stepper
	 *
	 * @author praveen.kumar
	 */
	public void clkContinueBtnPorinStepper() {
		getReusableActionsInstance().scrollToElement(getReusableActionsInstance().getWhenReady(By.xpath("//button[@data-test='choose-number-continue']")));
		getReusableActionsInstance().clickWhenReady(By.xpath("//button[@data-test='choose-number-continue']"), 20);
	}


	/**
	 * To Verify the Title of Billing Options stepper Displayed
	 *
	 * @return True or False Boolean Value.
	 * @author nimmy.george
	 */

	public boolean isBillingOptionsTitleDisplayed() {
		getReusableActionsInstance().getWhenReady(billingOptionsTitle);
		return getReusableActionsInstance().isElementVisible(billingOptionsTitle);
	}

	/**
	 * To verify Payment Method Dropdown is Present in the Billing Payment option stepper
	 *
	 * @return True or False
	 * @author karthic.hasan
	 */

	public boolean isPaymentMethodDropdownPresent() {
		return getReusableActionsInstance().isElementVisible(drpSelectPaymentMethod);
	}

	/**
	 * To Select Payment Method from Billing Payment option stepper
	 *
	 * @param strPaymentMethod from yaml file.
	 * @author karthic.hasan
	 */
	public void selectPaymentMethodDropdownOption(String strPaymentMethod) {
		//getReusableActionsInstance().scrollToElementAndClick(drpSelectPaymentMethod);
		new Select(getDriver().findElement(By.xpath("//select[@data-test='select-payment-option']"))).selectByVisibleText(strPaymentMethod);
		if (strPaymentMethod.equalsIgnoreCase("Pre-authorized Credit Card - Token") || strPaymentMethod.equalsIgnoreCase("Pre-authorized Credit Card - Token-fr")) {
			strTokenNumber = TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getNumber3();
			setPreAuthCreditTokenNumberBillingAndOTPPage(strTokenNumber);
		}
/*		getReusableActionsInstance().scrollToElementAndClick(drpSelectPaymentMethod);
		getReusableActionsInstance().selectWhenReady(drpSelectPaymentMethod, strPaymentMethod);*/
	}

	public void selectPayWithExistingCard() {
		getReusableActionsInstance().clickWhenVisible(By.xpath("//ds-radio-button[@data-test='payment-credit-card-type-new']"),10);
		getReusableActionsInstance().clickWhenVisible(By.xpath("//ds-radio-button[@data-test='payment-credit-card-type-existing']"),10);
	}

	/**
	 * Enter Name on Card in the Billing Payment Option Stepper , Name on Card Field
	 *
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
	 *
	 * @param strBillingExpiryDate from Yaml file
	 * @author karthic.hasan
	 */
	public void setBillingExpiryDate(String strBillingExpiryDate) {
		getReusableActionsInstance().getWhenReady(txtBillingExpiryDate).click();
		getReusableActionsInstance().staticWait(1000);
		getReusableActionsInstance().getWhenReady(inputBillingExpiryDate, 10).sendKeys(strBillingExpiryDate);
	}

	/**
	 * Enter CVVNumber in the Billing Payment Option Stepper , CVV Number Field
	 *
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
	 *
	 * @author karthic.hasan
	 */

	public void clkAddCard() {
		getReusableActionsInstance().getWhenReady(btnAddCard).click();
	}

	/**
	 * To verify Card Details displayed in the Billing Payment option stepper
	 *
	 * @return True or False
	 * @author karthic.hasan
	 */

	public boolean isCardDetailsDisplayed() {
		return getReusableActionsInstance().isElementVisible(txtCreditDetails, 30);
	}

	/**
	 * To click Billing Payment Continue Button from the Billing Payment Option stepper
	 *
	 * @author karthic.hasan
	 */

	public void clkBillingContinueButton() {
		getReusableActionsInstance().waitForElementTobeClickable(btnBillingContinueButton, 30);
		getReusableActionsInstance().scrollToElement(btnBillingContinueButton);
		getReusableActionsInstance().getWhenReady(btnBillingContinueButton, 30).click();
	}

	/**
	 * To click on the Billing Address radio button in the Shipping stepper
	 *
	 * @return true if selected, else false.
	 * @author nimmy.george
	 */

	public boolean clkBillingAddress() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		getReusableActionsInstance().waitForElementTobeClickable(billingAddressShipping, 30);
		getReusableActionsInstance().scrollToElement(billingAddressShipping);
		getReusableActionsInstance().clickWhenReady(billingAddressShipping, 30);
		billingAddressShipping.isSelected();
		return true;
	}


	/**
	 * to get the Complete Address from the Shipping Stepper
	 *
	 * @return The Complete Address
	 * * @author karthic.hasan
	 */
	public String getShippingAddress() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		return getReusableActionsInstance().getWhenReady(prepopulatedShippingAddress).getText();
	}

	/**
	 * This method will get Complete Contact Number details from Shipping Stepper
	 *
	 * @return Complete Contact Number from Shipping stepper
	 * @author karthic.hasan
	 */

	public String getContactNumber() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(contactNumberDetails);
		getReusableActionsInstance().staticWait(3000);
		return contactNumberDetails.getText().replaceAll("\\n", "");
	}

	/**
	 * to get the Email ID from the Shipping Stepper
	 *
	 * @return the Email ID
	 * @author karthic.hasan
	 */
	public String getEmailId() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		return getReusableActionsInstance().getWhenReady(prepopulatedEmailId).getText();
	}

	/**
	 * To click on Standard Delivery Method in the shipping stepper
	 *
	 * @author nimmy.george
	 */

	public void clkDeliveryMethodStandard() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().javascriptScrollByVisibleElement(deliveryMethodHeader);
		if (getReusableActionsInstance().isElementVisible(viewAnotherOption)) {
			System.out.println("inside loop");
			getReusableActionsInstance().scrollToElementAndClick(viewAnotherOption);
			getReusableActionsInstance().clickWhenReady(deliveryMethodStandard);

		} else {
			getReusableActionsInstance().clickWhenReady(deliveryMethodStandard, 30);
		}

	}

	/**
	 * To click on Express Delivery Method in the shipping stepper
	 *
	 * @author Saurav.Goyal
	 */

	public void clkDeliveryMethod(String deliveryMethod) {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		getReusableActionsInstance().staticWait(2000);
		if (deliveryMethod.equalsIgnoreCase("EXPRESS")) {
			getReusableActionsInstance().staticWait(5000);
			getReusableActionsInstance().clickWhenReady(deliveryMethodExpress, 30);
		} else if (deliveryMethod.equalsIgnoreCase("PRO")) {
			getReusableActionsInstance().staticWait(5000);
			getReusableActionsInstance().clickWhenReady(deliveryMethodProOnTheGo, 30);
		} else {
			getReusableActionsInstance().staticWait(5000);
			getReusableActionsInstance().clickWhenReady(deliveryMethodStandard, 30);
		}
	}

	/**
	 * To Verify the appointment time
	 *
	 * @return true if Appointment time is available else false
	 * @author saurav.goyal
	 */
	public boolean isAppointmentTimeAvailable() {
		return getReusableActionsInstance().isElementVisible(deliveryAppointmentTime, 30);
	}

	/**
	 * To Select Date from the Shipping stepper
	 *
	 * @author karthic.hasan
	 */

	public void selectDate() {
		//getReusableActionsInstance().javascriptScrollByVisibleElement(selDate);
		getReusableActionsInstance().moveToElementAndClick(selDate, 3);
	}

	/**
	 * To Select Time from the Shipping stepper
	 *
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
		clkNoThanks();
		getReusableActionsInstance().getWhenReady(continueBtnShipping, 30);
		getReusableActionsInstance().scrollToElement(continueBtnShipping);
		getReusableActionsInstance().clickWhenReady(continueBtnShipping, 30);
	}

	/**
	 * To verify the Apoointment label for pro on the go devices
	 *
	 * @return true if label is available else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyAppointmentLabel() {
		return getReusableActionsInstance().isElementVisible(lblAppointmentTime, 30);
	}


	/**
	 * This method will get Appointment Date from Shipping Stepper
	 *
	 * @return String having Appointment Date from Shipping stepper
	 * @author karthic.hasan
	 */

	public String getAppointmentDate() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(appointmentDate);
		getReusableActionsInstance().staticWait(3000);
		return appointmentDate.getText().replaceAll("\\n", "");
	}

	/**
	 * This method will get Appointment Time from Shipping Stepper
	 *
	 * @return String having Appointment Time from Shipping stepper
	 * @author karthic.hasan
	 */

	public String getAppointmentTime() {
		getReusableActionsInstance().javascriptScrollByVisibleElement(appointmentTime);
		getReusableActionsInstance().staticWait(3000);
		return appointmentTime.getText().replaceAll("\\s", "");
	}

	/**
	 * To click on submit button below cart summary in the checkout page, that takes you to Order Review Page
	 *
	 * @author nimmy.george
	 */

	public void clksubmitBtnCheckoutPage() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().waitForElementTobeClickable(submitBtnCheckoutPage, 50);
		getReusableActionsInstance().scrollToElement(submitBtnCheckoutPage);
		getReusableActionsInstance().getWhenReady(submitBtnCheckoutPage, 30);
		getReusableActionsInstance().executeJavaScriptClick(submitBtnCheckoutPage);
	}

	/**
	 * Click Submit Button
	 * @author Aditi.jain
	 */
	public void clkSubmit() {
		getReusableActionsInstance().staticWait(120000);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().clickWhenReady(submitButton);
		getReusableActionsInstance().staticWait(60000);

	}
	/**
	 * To verify Billing Details in the Billing Payment option stepper
	 *
	 * @return True or False
	 * @author karthic.hasan
	 */

	public boolean verifyBillingDetails() {
		return getReusableActionsInstance().isElementVisible(txtBillingDetails);
	}

	/**
	 * This method compares the downpayment amount displayed in FE with required value
	 * @param deviceCost NOTERM cost of the device
	 * @param riskClass risk class of the customer
	 * @return true if downpayment amt is matched, else false
	 * @author praveen.kumar7
	 */
	public boolean verifyDownPayment(String deviceCost, String riskClass) {
		if (riskClass.toLowerCase().contains("high")) {
			String deviceCost1 = deviceCost.replaceAll(",", ".");
			double expectedDownPayment = (Double.parseDouble(deviceCost1)) / 100.0 * 40.0;
			String expectedDP[] = String.valueOf(expectedDownPayment).split("\\.");
			String actualDownPayment[] = getReusableActionsInstance().getWhenReady(downPaymentAmt, 20).getText().trim().split("\\$");
			String actualDP[] = actualDownPayment[0].replaceAll(",", ".").split("\\.");
			if (expectedDP[0].equals(actualDP[0])) {
				return true;
			} else return false;
		} else if (riskClass.toLowerCase().contains("medium")) {
			String deviceCost1 = deviceCost.replaceAll(",", ".");
			double expectedDownPayment = (Double.parseDouble(deviceCost1)) / 100.0 * 20.0;
			String expectedDP[] = String.valueOf(expectedDownPayment).split("\\.");
			String actualDownPayment[] = getReusableActionsInstance().getWhenReady(downPaymentAmt, 20).getText().trim().split("\\$");
			String actualDP[] = actualDownPayment[0].replaceAll(",", ".").split("\\.");
			if (expectedDP[0].equals(actualDP[0])) {
				return true;
			} else return false;

		} else { return false; }
	}

	/**
	 * This method verifies the CLM amount with the expected value
	 * @param riskClass risk class of customer
	 * @return true if CLM amt is matched else false
	 * @author praveen.kumar7
	 */
	public boolean verifyCLMAmount(String riskClass) {
		if (riskClass.toLowerCase().contains("low")) {
			String actualCLMAmount = getReusableActionsInstance().getWhenReady(cLMAmount, 20).getText().trim();
			if (actualCLMAmount.equals("$0.00") || actualCLMAmount.equals("0,00 $")) {
				return true;
			} else return false;
		} else if (riskClass.toLowerCase().contains("medium")) {
			String actualCLMAmount = getReusableActionsInstance().getWhenReady(cLMAmount, 20).getText().trim();
			if (actualCLMAmount.equals("$500.00") || actualCLMAmount.equals("500,00 $")) {
				return true;
			} else return false;
		} else if (riskClass.toLowerCase().contains("high")) {
			String actualCLMAmount = getReusableActionsInstance().getWhenReady(cLMAmount, 20).getText().trim();
			if (actualCLMAmount.equals("$300.00") || actualCLMAmount.equals("300,00 $")) {
				return true;
			} else return false;
		} else return false;
	}

	/**
	 * To verify applied coupons appear
	 *
	 * @return True or False
	 * @author aditi.jain
	 */
	public boolean doesAppliedCouponExist() {
		return (getReusableActionsInstance().isElementVisible(totalSavingAppliedExists, 15) && getReusableActionsInstance().isElementVisible(appliedCouponExists, 15));
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
	 * To click on the Billing Address radio button in the Shipping stepper
	 * @author praveen.kumar7
	 */
	public void clkNewAddress() {
		getReusableActionsInstance().javascriptScrollToTopOfPage();
		getReusableActionsInstance().waitForElementTobeClickable(radioBtnNewAddress,20);
		getReusableActionsInstance().clickWhenReady(radioBtnNewAddress, 30);
	}

	/**
	 * This method enters new address in Enter new address field
	 * @param newShippingAddrress to enter
	 * @author praveen.kumar7
	 */
	public void enterNewAddress(String newShippingAddrress) {
		getReusableActionsInstance().clickWhenVisible(newAddressFormField);
		getReusableActionsInstance().getWhenReady(inputNewAddress).sendKeys(newShippingAddrress);
		getReusableActionsInstance().clickIfAvailable(By.xpath("(//ul[@role='listbox']//li)[1]"),10);
		getReusableActionsInstance().staticWait(5000);
	}

	/**
	 * This method verifies if NFDB popup is displayed
	 * @return true if popup displayed, else false
	 * @author praveen.kumar7
	 */
	public boolean verifyNFDBErrorMsg() {
		return getReusableActionsInstance().isElementVisible(nfdbFraudPopup);
	}

}
