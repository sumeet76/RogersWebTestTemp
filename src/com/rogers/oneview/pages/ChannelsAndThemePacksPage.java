package com.rogers.oneview.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

public class ChannelsAndThemePacksPage  extends BasePageClass {

	public ChannelsAndThemePacksPage(WebDriver driver) {
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
	
	@FindBy(xpath = "//div[@class='mini-cart-ss']//span[text()='Continuer' or text()='Continue']/ancestor::button[@ng-reflect-disabled='false']")
	WebElement minicartContinue;
	
	@FindBy(xpath = "//div[@class='rch-modal']//span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement btnContinueOn4kChannelPack;
	
	@FindBy(xpath = "//span[text()='Yes, they do' or text()='Oui, il en a un']/ancestor::button")
	WebElement btnContinueOn4kTv;
	/**
	 * Click Exchange Later btn
	 * @author Harpartap.Virk
	 */	
	public void clkexchangeLater() {
		reusableActions.clickWhenReady(exchangeLaterbtn);
	}	
	/**
	 * Click Collapse(Down Arrow)
	 * @author Harpartap.Virk
	 */	
	public void clkCollapse() {
		reusableActions.clickIfAvailable(collapse,20);
	}
	/**
	 * Click Customer Add-On review
	 * @author harpartap.virk
	 */
	public void clkCustomerAddonReview() {
			//reusableActions.javascriptScrollByVisibleElement(btnGetIgniteTVBadge);
			reusableActions.getWhenReady(customerAddonReveiwLink,120).click();	
		}
	
	/**
	 * Verify reviewed all of the customer’s legacy add-ons.
	 * @return true if reviewed, else false
	 * @author Harpartap.Virk
	 */	
	public boolean verifyreviewed() {	
		return reusableActions.isElementVisible(continueButton,120);
			
	}
	/**
	 * Click Checkout for channels Exchange
	 * @author Harpartap.Virk
	 */	
	public void clkCheckOut() {
		reusableActions.clickWhenReady(checkOut,120);
		//reusableActions.clickIfAvailable(checkOut,45);
		//reusableActions.clickIfAvailable(continueforCheckout,45);
	}
	/**
	 * Click Continue
	 * @author Harpartap.Virk
	 */	
	public void clkContinue() {
		reusableActions.clickWhenReady(continueButton,120);
		//reusableActions.clickIfAvailable(checkOut,45);
		//reusableActions.clickIfAvailable(continueforCheckout,45);
	}
	
	/**
	 * Click Continue in Minicart
	 * @author Harpartap.Virk
	 */	
	public void clkMinicartContinue() {
		reusableActions.clickWhenReady(minicartContinue,120);
		reusableActions.waitForElementVisibility(btnContinueOn4kTv,120);
		//reusableActions.clickIfAvailable(checkOut,45);
		//reusableActions.clickIfAvailable(continueforCheckout,45);
	}
}

