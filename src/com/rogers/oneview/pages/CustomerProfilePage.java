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
	
	@FindBy(xpath = "//span[@translate='global.cta.continue' and contains(text(),'Continue') ]")
	WebElement continueButton;
	
	@FindBy(xpath = "//span[@class='ds-icon rds-icon-expand']/ancestor::button")
	WebElement collapse;

	@FindBy(xpath = "//span[contains(text(),'Yes, cancel')]")
	WebElement YesCancelButton;

	@FindBy(xpath = "//span[contains(text(),'No, continue')]")
	WebElement NoContinue;

	@FindBy(xpath = "//p[@class='ds-modal__heading mb-24 text-title-3' and contains(text(),'Are you sure you want to cancel?')]")
	WebElement AreYouSureToCancelModal;
	
	/**
	 * Verify the Customer Profile Page is Displayed
	 * @return true if Customer Profile is Displayed, else false
	 * @author chinnarao.vattam
	 */	
	public boolean verifyCustomerProfile() {
		getReusableActionsInstance().clickIfAvailable(collapse,60);
		return getReusableActionsInstance().isElementVisible(customerProfile,120);
	
	}
	/**
	 * Click Continue Button 
	 * @author chinnarao.vattam
	 */	
	public void clkContinue() {	
		//getReusableActionsInstance().getWhenReady(continueButton,120).sendKeys(Keys.ENTER);
		getReusableActionsInstance().staticWait(5000);
	//	getReusableActionsInstance().clickWhenReady(continueButton,60);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().executeJavaScriptClick(continueButton);
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
}
