package com.rogers.oneview.pages;

import java.util.List;

import com.rogers.testdatamanagement.TestDataHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersChoosePhonePage extends BasePageClass {

	public RogersChoosePhonePage(WebDriver driver) {
		super(driver);
	}

	String customerType = null;
	public String xpathDeviceName;

	@FindBy(xpath = "//div[contains(@class,'button') and (@res='details_devicemodel' or @res='upgrade')]")
	WebElement btnDetails;
	
	@FindBy(xpath = "//span[@translate='_newCustomer']/parent::button")
	WebElement btnNewCustomer;
	
	@FindBy(xpath = "//span[@translate='_upgrade']/parent::button")
	WebElement btnUpgrade;
	
	@FindBy(xpath = "//span[@translate='see.add_line']/parent::button")
	WebElement btnAddALine;
	
	@FindBy(xpath = "//input[@id='searchBar']")
	WebElement txtSearch;
	
	@FindBy(xpath = "//input[@id='searchBar']/../span")
	WebElement imgSearch;
	
	@FindBy(xpath = "//section[@class='phoneModel']")
	List<WebElement> deviceModal;

	@FindBy(xpath = "//ds-modal-container")
	WebElement modalContainer;
	
	//2nd findby: https://qa06-ciam.rogers.com/
	@FindAll({
		@FindBy(xpath = "//div[@res='_add']"),
		@FindBy(xpath = "//span[text()='$0' or text()='0']/ancestor::section[@class='phoneModel']//div[@res='details_devicemodel' or @res='upgrade']"),
		@FindBy(xpath = "//span[text()='$0' or text()='0']/ancestor::section[@class='phoneModel']//div[@res='_add']")
	})
	WebElement btnAdd;
	
	@FindBy(xpath = "//span[text()='$0' or text()='0']/ancestor::section[@class='phoneModel']//div[@res='details_devicemodel' or @res='upgrade']")
	List<WebElement> btnZeroUpfrontDeviceDetails;
	
	@FindBy(xpath = "//span[text()='$0' or text()='0']/ancestor::section[@class='phoneModel']//div[@res='_add']")
	List<WebElement> btnZeroUpfrontDeviceAdd;
	
	@FindBy(xpath = "//div[@class='choose-ctn-modal']")
	WebElement lblChooseALine;
	
	@FindBy(xpath = "//span[@res='check_eligibility']")
	WebElement linkProOnTheGoCheckEligibility;
	
	@FindBy(xpath = "//input[@id='zipcode']")
	WebElement inputPostalCodeOnForm;
	
	@FindBy(xpath = "//div[contains(@class,'hidden-xs')]//button[@class='btn checkAvailabilityBtn btn-active']")
	WebElement btnCheckPostalCodeOnForm;
	
	@FindBy(xpath = "//img[@alt='success-icon']")
	WebElement imgSuccess;
	
	@FindBy(xpath = "//button[@res='eligible_continue']")
	WebElement formProOnTheGoContinue;
	
	@FindBy(xpath = "//button[@res='eligible_cancel']")
	WebElement formProOnTheGoCancel;

	@FindAll({
			@FindBy(xpath = "(//td[contains(@class,'text-title-5 text-bold text-right py-12')])[2]"),
			@FindBy(xpath = "//p[contains(text(),'Security deposit required')]//following::p[1]")
	})
	WebElement securityDepositAmount;

	@FindAll({
			@FindBy(xpath = "(//td[contains(@class,'text-title-5 text-bold text-right py-12')])[3]"),
			@FindBy(xpath = "//p[contains(text(),'Security deposit required')]//following::p[3]")
	})
	WebElement cLMAmount;

	@FindAll({
			@FindBy(xpath = "(//td[contains(@class,'text-title-5 text-bold text-right py-12')])[4]"),
			@FindBy(xpath = "//p[contains(text(),'Security deposit required')]//following::p[5]")
	})
	WebElement riskLevel;

	@FindBy(xpath = "//span[contains(text(),' Accept and Continue ')]")
	WebElement acceptAndContinueOnCreditEvalModal;

	@FindBy(xpath = "//ds-modal[contains(@data-test,'sharedNonShared')]/ancestor::ds-modal-container")
	WebElement sharedNonSharedModal;

	@FindBy(xpath = "//ds-modal-container//label[contains(@class,'dsa-selection d-inline-block ds-pointer')][contains(@aria-label,'partager') or contains(@aria-label,'shared Rogers')]")
	WebElement sharedOption;

	@FindBy(xpath = "//ds-modal-container//label[contains(@class,'dsa-selection d-inline-block ds-pointer')][contains(@aria-label,'Forfait distinct sans') or contains(@aria-label,'separate plan')]")
	WebElement nonSharedOption;

	@FindBy(xpath = "//span[contains(text(),'Continue')]")
	WebElement modalContinueButton;

	@FindBy(xpath = "//button[@title='Select' or @title='Continue' or @title='Continuer' or @title='Ship to home' or @title='Expédier à la maison']")
	public
	WebElement continueButton;

	/**
	 * Clicks on the 'Details' button on the first available device
	 * @author rajesh.varalli1
	 */
	public void selectFirstAvailableDevice() {
		getReusableActionsInstance().clickWhenVisible(btnDetails);
	}
	
	/**
	 * Clicks on the 'Add' button on the first available device
	 * @author rajesh.varalli1
	 */
	public void addFirstAvailableDevice() {
		getReusableActionsInstance().executeJavaScriptClick(btnAdd);
	}
	
	/**
	 * Clicks on the 'New Customer' button on the overlay
	 * @author rajesh.varalli1
	 */
	public void clkNewCustomer() {
		getReusableActionsInstance().clickWhenVisible(btnNewCustomer);
	}
	
	/**
	 * Clicks on the 'Upgrade' button on the overlay
	 * @author rajesh.varalli1
	 */
	public void clkUpgrade() {
		getReusableActionsInstance().clickWhenVisible(btnUpgrade);
	}
	
	/**
	 * Clicks on the 'Add a line' button on the overlay
	 * @author rajesh.varalli1
	 */
	public void clkAddALine() {
		getReusableActionsInstance().clickWhenVisible(btnAddALine);
	}
	
	/**
	 * Search the device name or model or feature
	 * @param strDeviceName Full or partial name of the device or feature
	 * @author rajesh.varalli1
	 */
	public void searchDevice(String strDeviceName) {
		getReusableActionsInstance().getWhenReady(txtSearch, 80).sendKeys(strDeviceName);
		getReusableActionsInstance().executeJavaScriptClick(imgSearch);
	}

	/**
	 * Verify Choose phone page
	 * @return  true if page loaded properly else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyChoosePhonePage() {
		return getReusableActionsInstance().isElementVisible(txtSearch, 60);
	}
	
	/**
	 * Clicks on the 'Details' button against the first available device with '$0' upfront cost
	 * @author rajesh.varalli1
	 */
	public void selectFirstZeroUpfrontDeviceAvailable() {
		getReusableActionsInstance().executeJavaScriptClick(btnZeroUpfrontDeviceDetails.get(0));
	}
	
	/**
	 * Clicks on the 'Add' button against the first available device with '$0' upfront cost
	 * @author rajesh.varalli1
	 */
	public void addFirstZeroUpfrontDeviceAvailable() {
		getReusableActionsInstance().executeJavaScriptClick(btnZeroUpfrontDeviceAdd.get(0));
	}
	
	/**
	 * Selects the CTN which has to be upgraded in case of Multi-Line Accounts
	 * @param strCTN The HUP Eligible Phone Number
	 * @author rajesh.varalli1
	 */
	public void selectLineForUpgrade(String strCTN) {
		if(getReusableActionsInstance().isElementVisible(lblChooseALine, 20)) {
			strCTN = strCTN.replace("-", "").replace(" ", "");
			strCTN = strCTN.substring(0, 3) + " " + strCTN.substring(3, 6) + "-" + strCTN.subSequence(6, 10);
			getReusableActionsInstance().clickWhenReady(By.xpath("//div[text()='"+ strCTN +"']"));
		}
	}
	
	/**
	 * This method will check whether the device is pro on the go or not
	 * @return true if the device is pro on the go else false
	 * @author Saurav.Goyal
	 */
	public boolean checkProOnTheGo() {
		boolean detailButtonFlag; 
		for(WebElement element: deviceModal) {
			if(getReusableActionsInstance().isElementVisible(element , 30))
				try {
					WebElement btnDetail =  element.findElement(By.xpath("//div[contains(@class,'button') and (@res='details_devicemodel' or @res='upgrade' or @res='_add')]"));
					getReusableActionsInstance().isElementVisible(btnDetail);
					//getReusableActionsInstance().isElementVisible(element.findElement(By.xpath("//div[contains(@class,'button') and (@res='details_devicemodel' or @res='upgrade')]")));
					detailButtonFlag = true;
					WebElement proOnTheGoMsgDisplay  = element.findElement(By.xpath("//section[@class='phoneModel']//span[@res='device_eligible']"));
					getReusableActionsInstance().isElementVisible(proOnTheGoMsgDisplay);
					//getReusableActionsInstance().isElementVisible(element.findElement(By.xpath("//section[@class='phoneModel']//span[@res='device_eligible']")));
					return detailButtonFlag;
				} catch (Exception e) {
					if(detailButtonFlag = true) {
						return false;
					}
			}
		}
		return false;
	}
	
	/**
	 * This method will check whether the customer address is eligible to deliver pro on the go device or not
	 * @return true if the customer address is eligible to deliver pro on the go device in there ares else false
	 * @param postalCode : customer's postal code
	 * @author Saurav.Goyal
	 */
	public boolean checkProOnTheGoAtAddress(String postalCode) {
		if(getReusableActionsInstance().isElementVisible(linkProOnTheGoCheckEligibility, 30)) {
			getReusableActionsInstance().clickWhenReady(linkProOnTheGoCheckEligibility, 30);
			getReusableActionsInstance().getWhenReady(inputPostalCodeOnForm).sendKeys(postalCode);
			getReusableActionsInstance().clickWhenReady(btnCheckPostalCodeOnForm, 30);
			if(getReusableActionsInstance().isElementVisible(imgSuccess, 30)) {
				getReusableActionsInstance().clickWhenReady(formProOnTheGoContinue, 30);
				return true;
			}
			getReusableActionsInstance().clickWhenReady(formProOnTheGoCancel, 30);
		}
		return false;
	}

	/**
	 * Checks for the presence of 'Accept and Continue' Button on Crdit Evaluation Modal
	 * @return returns if the element is visible or not
	 * @author sidhartha.vadrevu
	 */
	public boolean checkAcceptAndContinueOnCreditEvalModal() {
		getReusableActionsInstance().waitForElementVisibility(acceptAndContinueOnCreditEvalModal,30);
		return getReusableActionsInstance().isElementVisible(acceptAndContinueOnCreditEvalModal);
	}

	/**
	 * Checks the customer type based on the attribute values present on the Credit Evaluation Modal
	 * @return returns the customerType value
	 * @author sidhartha.vadrevu
	 */
	public String checkCustomerType() {
		String[] security = securityDepositAmount.getText().split("\\$");
		String[] clmValue = cLMAmount.getText().split("\\$");
		Double securityDeposit = Double.parseDouble(security[1]);
		Double clm = Double.parseDouble(clmValue[1]);
		String risk = riskLevel.getText();
		if (securityDeposit <= 0 && clm <=0 && risk.equalsIgnoreCase("Low")) {
			customerType = "Low Risk";
		} else if(securityDeposit == 500 && (clm >0 && clm<450) && risk.equalsIgnoreCase("Medium")) {
			customerType = "Medium Risk";
		} else if(securityDeposit == 300 && clm >= 450 && risk.equalsIgnoreCase("High")) {
			customerType = "High Risk";
		}
		System.out.println(customerType);
		return customerType;
	}

	/**
	 * Validates whether the customer type of the provided data matches to the customer type deduced from the data provided on the Credit Evaluation Modal
	 * @return true if customer types match, false if they don't match
	 * @author sidhartha.vadrevu
	 */
	public boolean validateCustomerType() {
		checkCustomerType();
		String customer = TestDataHandler.buyFlowsOVtestCase08.getCustomerRiskLevel();
		if (customer!=null && !customer.isEmpty() && customerType.matches(customer)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Clicks on the 'Accept and Continue' Button from the Crdit Evaluation Modal
	 * @author sidhartha.vadrevu
	 */
	public void clickAcceptAndContinueOnCreditEvalModal() {
		getReusableActionsInstance().waitForElementVisibility(acceptAndContinueOnCreditEvalModal);
		getReusableActionsInstance().executeJavaScriptClick(acceptAndContinueOnCreditEvalModal);
	}

	/**
	 *  This method verifies whether Shared/NonShared modal is displayed
	 *  @return a boolean true if element is present else false
	 *  @author praveeen.kumar7
	 */
	public boolean verifySharedNonSharedModalPresent() {
		return getReusableActionsInstance().isElementVisible(sharedNonSharedModal,30);
	}

	/**
	 *  This method selects shared or nonshared sharing type based on the string passed
	 *  @param sharingType passing the String value of sharingType to select the sharing option
	 *  @author praveeen.kumar7
	 */
	public void selectAALSharingType(String sharingType) {
		if(sharingType.equalsIgnoreCase("SHARE")) {
			getReusableActionsInstance().clickWhenReady(sharedOption, 20);
		}
		else if(sharingType.equalsIgnoreCase("NONSHARE")){
			getReusableActionsInstance().clickWhenReady(nonSharedOption, 20);
		}
		else {
			getReusableActionsInstance().clickWhenReady(sharedOption, 20);
		}
	}

	/**
	 *  This method clicks on the Continue button on shared/nonshared modal
	 *  @author praveeen.kumar7
	 */
	public void clickContinueButtonOnModal() {
		getReusableActionsInstance().clickWhenReady(modalContinueButton,40);
	}

	/**
	 * This method creates Xpath of a particular device with device name
	 * @param	deviceName : Name of the device to be used as reference for creating the xpath
	 * @return a String value which is an xpath for a device name
	 * @author nimmy.george
	 */
	public String createXpathWithDeviceName(String deviceName) {
		xpathDeviceName="//p[contains(@class,'text-title-5 ')][contains(text(),'"+deviceName+"')]";
		return xpathDeviceName;
	}

	/**
	 * This method creates Xpath of a particular CTA button
	 * @param	deviceName : name of the device used to create the xpath
	 * @return a String value which is an xpath for a CTA button
	 * @author saurav.goyal
	 */
	public String createXpathForCTAButton(String deviceName) {
		xpathDeviceName = createXpathWithDeviceName(deviceName);
		String ctaButtonXpath = xpathDeviceName + "/ancestor::div[@class='dsa-nacTile__top']//following-sibling::div//span[contains(@class,'ds-button__copy')]";
		return ctaButtonXpath;
	}

	/**
	 * This method Clicks on a device Tile CTA button for a particular phone
	 * @param deviceName : name of the Device to be used to generate Xpath
	 * @author saurav.goyal
	 */
	public void clickDeviceTileCTAButton(String deviceName) {
		getReusableActionsInstance().clickWhenVisible(By.xpath(createXpathForCTAButton(deviceName)), 30);
	}

	/**
	 * This method will verify that the device tile CTA button is present or not
	 * @param deviceName : name of the Device for which we want to verify device tile CTA button
	 * @return boolean true if the CTA button is present else false
	 * @author saurav.goyal
	 */
	public boolean verifyDeviceTileCTAButton(String deviceName) {
		return getReusableActionsInstance().isElementVisible(By.xpath(createXpathForCTAButton(deviceName)), 60);
	}

	/**
	 * This method check whether a Modal page is getting displayed or not
	 * @return a boolean value true if a modal window will appear else false
	 * @author saurav.goyal
	 */
	public boolean isModalDisplayed() {
		return getReusableActionsInstance().isElementVisible(modalContainer,30);
	}

	/***
	 * This method will click on the continue button
	 * @author saurav.goyal
	 */
	public void clickContinueButton() {
		if (getReusableActionsInstance().isElementVisible(continueButton))
			getReusableActionsInstance().clickWhenReady(continueButton);
		getReusableActionsInstance().staticWait(3000);
	}
}