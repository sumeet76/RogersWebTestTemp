package com.rogers.pages;

import java.util.List;

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

	//div[contains(@class,'button') and (@res='details_devicemodel' or @res='upgrade' or @res='_add')]
	@FindBy(xpath = "//div[contains(@class,'button') and (@res='details_devicemodel' or @res='upgrade' or @res='_add')]")
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
	
	//2nd findby: https://qa06-ciam.rogers.com/
	//div[@class='uniEligibleDevice ng-scope']
	@FindAll({
		@FindBy(xpath = "//div[@res='_add']"),
		@FindBy(xpath = "//span[text()='$0' or text()='0']/ancestor::section[@class='phoneModel']//div[@res='details_devicemodel' or @res='upgrade']"),
		@FindBy(xpath = "//span[text()='$0' or text()='0']/ancestor::section[@class='phoneModel']//div[@res='_add']")
	})
	WebElement btnAdd;
	
	@FindBy(xpath = "//span[@class='-messageFont']")
	WebElement lblProOntheGo;
	
	@FindBy(xpath = "//span[text()='$0' or text()='0']/ancestor::section[@class='phoneModel']//div[@res='details_devicemodel' or @res='upgrade']")
	List<WebElement> btnZeroUpfrontDeviceDetails;
	
	@FindBy(xpath = "//span[text()='$0' or text()='0']/ancestor::section[@class='phoneModel']//div[@res='_add']")
	List<WebElement> btnZeroUpfrontDeviceAdd;
	
	@FindBy(xpath = "//div[@class='choose-ctn-modal']")
	WebElement lblChooseALine;
	
	@FindBy(xpath = "//section[@class='phoneModel']")
	List<WebElement> deviceModal;
	
	@FindBy(xpath = "//*[@res='check_eligibility']")
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

	@FindBy(xpath = "//button[@title='Select' or @title='Continue' or @title='Continuer' or @title='Ship to home' or @title='Expédier à la maison']")
	public
	WebElement continueButton;

	/**
	 * To verify the Rogers Choose Phone Page
	 * @return true if the search text filter for phone is available on page, else false 
	 * @author Saurav.Goyal
	 */
	public boolean verifyRogersChoosePhonePage() {
		return getReusableActionsInstance().isElementVisible(txtSearch, 60);
	}
	
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
		getReusableActionsInstance().getWhenReady(txtSearch, 60).sendKeys(strDeviceName);
		getReusableActionsInstance().executeJavaScriptClick(imgSearch);
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
					detailButtonFlag = true;
					//getReusableActionsInstance().isElementVisible(element.findElement(By.xpath("//section[@class='phoneModel']//span[@res='device_eligible']")));
					WebElement proOnTheGoMsgDisplay  = element.findElement(By.xpath("//span[@class='-messageFont']"));
					getReusableActionsInstance().isElementVisible(proOnTheGoMsgDisplay);
					//getReusableActionsInstance().isElementVisible(element.findElement(By.xpath("//span[@class='-messageFont']")));
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
	 * This method clicks on the continue button after device selection
	 * @auther: Nitin.Arora
	 */
	public void clickContinueButton() {
		 getReusableActionsInstance().isElementVisible(continueButton,60);
		 getReusableActionsInstance().scrollToElement(continueButton);
		 getReusableActionsInstance().executeJavaScriptClick(continueButton);
	}
}