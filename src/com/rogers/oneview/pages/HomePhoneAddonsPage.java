package com.rogers.oneview.pages;
import org.openqa.selenium.By;
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

	@FindBy(xpath = "//div[contains(@id,'ds-radio-input-id-1-label-container')]/preceding-sibling::div[contains(@class,'ds-radioButton')]")
	WebElement btnImmediateBill;

	@FindBy(xpath = "//p[text()='Select Change Date' or text()='Sélectionner la date du changement' ]/ancestor::div//span[text()='Continue' or text()='Continuer']")
	WebElement btnContinueChangeDate;

	@FindBy(xpath="//span[@translate='global.cta.confirm']/ancestor::button")
	WebElement confirmButton;

	/*
	 * Select the specified add on
	 * @author suganya P
	 */
	public void chooseAddon(String AddOnEn, String AddOnFr)
	{
		By addonlocator= By.xpath("//h3[contains(text(),'"+AddOnEn+"') or contains(text(),'"+AddOnFr+"')]/parent::div[@class='card-content']//div[@class='add-on-button-set']//button");
		getReusableActionsInstance().getWhenReady(addonlocator,60);
		WebElement addon= getDriver().findElement(addonlocator);
		getReusableActionsInstance().executeJavaScriptClick(addon);
	}



	public void removeAddon(String AddOnEn, String AddOnFr)
	{
		By addonlocator= By.xpath("//h3[contains(text(),'"+AddOnEn+"') or contains(text(),'"+AddOnFr+"')]/parent::div[@class='card-content']//div[@class='add-on-button-set']//span[contains(text(),'Remove') or contains(text(),'Retirer')]//ancestor::button");
		getReusableActionsInstance().getWhenReady(addonlocator,60);
		WebElement addon= getDriver().findElement(addonlocator);
		getReusableActionsInstance().executeJavaScriptClick(addon);
	}

	/*Selects the Immediate Billing option
	 * @author suganya p
	 * */
	public void clickImmediateBill() {
		getReusableActionsInstance().getWhenReady(btnImmediateBill,60).click();
	}
	/*
	 * Click on continue in Select billing date pop up
	 * @author suganya P
	 * */
	public void clickContinueOnSelectDateChange() {
		getReusableActionsInstance().getWhenReady(btnContinueChangeDate,60).click();
	}



	/*
	 * To click on confirm button
	 * @author suganya p
	 */
	public void clickConfirmButton()
	{
		getReusableActionsInstance().getWhenReady(confirmButton,60).click();
	}



	/**
	 * Click Exchange Later btn
	 * @author Chinnarao.Vattam
	 */	
	public void clkexchangeLater() {
		getReusableActionsInstance().clickWhenReady(exchangeLaterbtn);
	}
	
		/**
	 * Click Collapse(Down Arrow)
	 * @author Chinnarao.Vattam
	 */	
	public void clkCollapse() {
		getReusableActionsInstance().clickIfAvailable(collapse,60);
	}
	/**
	 * Click Customer Add-On review
	 * @author Chinnarao.Vattam
	 */
	public void clkCustomerAddonReview() {
			getReusableActionsInstance().getWhenReady(customerAddonReveiwLink,120).click();
		}
	
	/**
	 * Verify reviewed all of the customer’s legacy add-ons.
	 * @return true if reviewed, else false
	 * @author Chinnarao.Vattam
	 */	
	public boolean verifyreviewed() {	
		return getReusableActionsInstance().isElementVisible(continueButton,120);
			
	}
	
	/**
	 * Click Checkout for channels Exchange
	 * @author Chinnarao.Vattam
	 */	
	public void clkCheckOut() {
		getReusableActionsInstance().clickWhenReady(checkOut,120);
	}
	/**
	 * Click Continue
	 * @author Chinnarao.Vattam
	 */	
	public void clkContinue() {
		getReusableActionsInstance().getWhenReady(continueButton,120).sendKeys(Keys.ENTER);
	}
}

