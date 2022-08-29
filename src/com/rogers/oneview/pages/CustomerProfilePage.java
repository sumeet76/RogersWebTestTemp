package com.rogers.oneview.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

public class CustomerProfilePage  extends BasePageClass {

	public CustomerProfilePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h1[text()='Profil client' or text()='Customer Profile']")
	WebElement customerProfile;

	@FindBy(xpath = "//h1[text()='Smart Home Monitoring Add-ons' or text()='Options du Système de domotique Rogers']")
	WebElement shmHeader;
	
	@FindBy(xpath = "//span[@translate='global.cta.continue' and contains(text(),'Continue') ]/ancestor::button")
	WebElement continueButton;
	
	@FindBy(xpath = "//span[@class='ds-icon rds-icon-expand']/ancestor::button")
	WebElement collapse;

	@FindBy(xpath = "//span[contains(text(),'Yes, cancel')]")
	WebElement YesCancelButton;

	@FindBy(xpath = "//span[contains(text(),'No, continue')]")
	WebElement NoContinue;

	@FindBy(xpath = "//p[@class='ds-modal__heading mb-24 text-title-3' and contains(text(),'Are you sure you want to cancel?')]")
	WebElement AreYouSureToCancelModal;

	@FindBy(xpath = "//div[contains(text(),'Use another address')]")
	WebElement useAnotherAddress;

	@FindBy(xpath = "//div[@class='address-lookup space-for-address ng-star-inserted']//div[@class='ng-star-inserted']")
	WebElement enternewAdress;

	@FindBy(xpath = "(//div[@title='105 Abbeywood Trail'])[1]")
	WebElement newAddressSearchResult;

	@FindBy(xpath = "//input[@type='text']")
	WebElement inputAddress;
	
	/**
	 * Verify the Customer Profile Page is Displayed
	 * @return true if Customer Profile is Displayed, else false
	 * @author chinnarao.vattam
	 */	
	public boolean verifyCustomerProfile() {
		//getReusableActionsInstance().clickIfAvailable(collapse,60);
		return getReusableActionsInstance().isElementVisible(customerProfile,120);
	
	}

	/**
	 * Verify SHM Header
	 * @author Jarmanjeet.batth
	 */
	public boolean verifySHMAddonsHeader() {
		//getReusableActionsInstance().clickIfAvailable(collapse,60);
		return getReusableActionsInstance().isElementVisible(shmHeader,60);
	}

	/**
	 * Click Continue Button 
	 * @author chinnarao.vattam
	 */	
	public void clkContinue() {	
//		getReusableActionsInstance().getWhenReady(continueButton,120).sendKeys(Keys.ENTER);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().clickWhenReady(continueButton,90);
	}

	/**
	 * go to the bottom
	 * @author aditi.jain
	 */
	public void goToTheBottom() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();

	}

	public void clickBackButton(){
		getReusableActionsInstance().backToPreviousPage();
	}


	public void clickYesCancelButton(){
		getReusableActionsInstance().staticWait(2000);
		getReusableActionsInstance().clickWhenReady(YesCancelButton);
	}

	public void clickNoContinue(){
		getReusableActionsInstance().clickWhenReady(NoContinue);
	}

	public boolean verifyAreYouSureModal(){
		return getReusableActionsInstance().isElementVisible(AreYouSureToCancelModal,60);
	}

	public void useAnotheraddress(){
		getReusableActionsInstance().scrollToElement(useAnotherAddress);
		getReusableActionsInstance().executeJavaScriptClick(useAnotherAddress);
	}

	public void enterNewAddress(String address){
	//	getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().scrollToElement(enternewAdress);
		getReusableActionsInstance().clickWhenReady(enternewAdress,30);
		getReusableActionsInstance().enterText(inputAddress,address+Keys.BACK_SPACE,30);
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().clickAndHoldFor(newAddressSearchResult,333);

	}

	public void clickContinueWithoutScrollDown(){
		getReusableActionsInstance().clickWhenReady(continueButton,30);
	}
}
