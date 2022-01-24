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
	
	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement continueButton;
	
	@FindBy(xpath = "//span[@class='ds-icon rds-icon-expand']/ancestor::button")
	WebElement collapse;
	
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
		getReusableActionsInstance().getWhenReady(continueButton,60);
		getReusableActionsInstance().executeJavaScriptClick(continueButton);
	}

	/**
	 * go to the bottom
	 * @author aditi.jain
	 */
	public void goToTheBottom() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();

	}
}
