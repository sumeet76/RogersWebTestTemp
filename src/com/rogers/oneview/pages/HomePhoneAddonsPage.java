package com.rogers.oneview.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

public class HomePhoneAddonsPage  extends BasePageClass {

	public HomePhoneAddonsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[text()='Exchange later' or text()='Échanger plus tard']/ancestor::button")
	WebElement exchangeLaterbtn;
	
	@FindBy(xpath = "//span[@class='ds-icon rds-icon-expand']/ancestor::button")
	WebElement collapse;
	
	@FindBy(xpath = "//span[text()='I have reviewed the customer’s add-ons.' or text()='J’ai passé en revue les options du client.']")
	WebElement customerAddonReveiwLink;
	
	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button[@ng-reflect-disabled='false']")
	WebElement continueButton;
	
	@FindBy(xpath = "//span[text()='Passer à la caisse' or text()='Checkout']/ancestor::button")
	WebElement checkOut;
	/**
	 * Click Exchange Later btn
	 * @author Harpartap.Virk
	 */	
	public void clkexchangeLater() {
		getReusableActionsInstance().clickWhenReady(exchangeLaterbtn);
	}	
	/**
	 * Click Collapse(Down Arrow)
	 * @author Harpartap.Virk
	 */	
	public void clkCollapse() {
		getReusableActionsInstance().clickIfAvailable(collapse,60);
	}
	/**
	 * Click Customer Add-On review
	 * @author harpartap.virk
	 */
	public void clkCustomerAddonReview() {
			//getReusableActionsInstance().javascriptScrollByVisibleElement(btnGetIgniteTVBadge);
			getReusableActionsInstance().getWhenReady(customerAddonReveiwLink,120).click();
		}
	
	/**
	 * Verify reviewed all of the customer’s legacy add-ons.
	 * @return true if reviewed, else false
	 * @author Harpartap.Virk
	 */	
	public boolean verifyreviewed() {	
		return getReusableActionsInstance().isElementVisible(continueButton,120);
			
	}
	/**
	 * Click Checkout for channels Exchange
	 * @author Harpartap.Virk
	 */	
	public void clkCheckOut() {
		getReusableActionsInstance().clickWhenReady(checkOut,120);
		//getReusableActionsInstance().clickIfAvailable(checkOut,45);
		//getReusableActionsInstance().clickIfAvailable(continueforCheckout,45);
	}
	/**
	 * Click Continue
	 * @author Harpartap.Virk
	 */	
	public void clkContinue() {
		getReusableActionsInstance().getWhenReady(continueButton,120).sendKeys(Keys.ENTER);
		//getReusableActionsInstance().clickIfAvailable(checkOut,45);
		//getReusableActionsInstance().clickIfAvailable(continueforCheckout,45);
	}
}

