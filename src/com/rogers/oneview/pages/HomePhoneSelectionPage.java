package com.rogers.oneview.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

public class HomePhoneSelectionPage  extends BasePageClass {

	public HomePhoneSelectionPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement generatePhoneNumber;
	
	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button[@ng-reflect-disabled='false']")
	WebElement continueButton;
	
	@FindBy(xpath = "//input[@placeholder='Enter the desired digits here' or @placeholder='Entrez les chiffres voulus ici']/parent::div")
	WebElement phoneNoInput;
	
	@FindBy(xpath = "//input[@ng-reflect-name='cIdFirstName']")
	WebElement cIDfirstName;
	
	@FindBy(xpath = "//input[@ng-reflect-name='cIdFirstName']/parent::div")
	WebElement cIDfirstNameInputBox;
	
	@FindBy(xpath = "//input[@ng-reflect-name='cIdLastName']")
	WebElement cIDlastName;
	
	@FindBy(xpath = "//input[@ng-reflect-name='cIdLastName']/parent::div")
	WebElement cIDlastNameInputBox;
	
	@FindBy(xpath = "//input[@ng-reflect-name='dlFirstName']")
	WebElement dlfirstName;
	
	@FindBy(xpath = "//input[@ng-reflect-name='dlFirstName']/parent::div")
	WebElement dlfirstNameInputBox;
	
	@FindBy(xpath = "//input[@ng-reflect-name='dlLastName']")
	WebElement dllastName;
	
	@FindBy(xpath = "//input[@ng-reflect-name='dlLastName']/parent::div")
	WebElement dllastNameInputBox;
	
	@FindBy(xpath = "//span[text()='Update Caller ID']/ancestor::button")
	WebElement updateCIDbtn;
	
	@FindBy(xpath = "//span[text()='Update Directory Listing']/ancestor::button")
	WebElement updateDirectoryListingbtn;
	
	@FindBy(xpath = "//ul[@class='number-select-list']/li[1]")
	WebElement selectedPhoneNo;
	/**
	 * Click Generate Phone Number Button  
	 * @author Harpartap.Virk
	 */	
	public void clkGeneratePhoneNo() {
		//getReusableActionsInstance().javascriptScrollByVisibleElement(getReusableActionsInstance().getWhenReady(phoneNoInput,120));
		getReusableActionsInstance().getWhenReady(generatePhoneNumber,60).sendKeys(Keys.ENTER);
	}
	/**
	 * Verify the Phone Number is Selected
	 * @return true if Phone Number is selected, else false
	 * @author Harpartap.Virk
	 */	
	public boolean verifyNumber() {	
		return getReusableActionsInstance().isElementVisible(continueButton);
	}
	/**
	 * Click Continue Button  
	 * @author Harpartap.Virk
	 */	
	public void clkContinue() {	
		//getReusableActionsInstance().javascriptScrollByVisibleElement(getReusableActionsInstance().getWhenReady(continueButton));
		getReusableActionsInstance().getWhenReady(continueButton).sendKeys(Keys.ENTER);;
	}
	
	
	/**
	 * Click Update Caller ID Button  
	 * @author Harpartap.Virk
	 */	
	public void clkUpdateDirectoryListing() {
		//getReusableActionsInstance().javascriptScrollByVisibleElement(getReusableActionsInstance().getWhenReady(phoneNoInput,120));
		getReusableActionsInstance().getWhenReady(updateDirectoryListingbtn,60).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Verify the Phone Number is Selected
	 * @return true if Phone Number is selected, else false
	 * @author Harpartap.Virk
	 */	
	public boolean verifySelectedNumber() {	
		WebElement btn=getReusableActionsInstance().getWhenReady(selectedPhoneNo,120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		return getReusableActionsInstance().isElementVisible(selectedPhoneNo);
	}
}
