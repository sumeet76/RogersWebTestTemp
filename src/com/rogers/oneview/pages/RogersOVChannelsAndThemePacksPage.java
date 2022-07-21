package com.rogers.oneview.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

public class RogersOVChannelsAndThemePacksPage  extends BasePageClass {

	public RogersOVChannelsAndThemePacksPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//span[text()='Exchange later' or text()='Échanger plus tard']/ancestor::button")
	WebElement exchangeLaterbtn;

	@FindBy(xpath = "//span[@class='ds-icon rds-icon-expand']/ancestor::button")
	WebElement collapse;

	@FindBy(xpath = "//span[text()='I have reviewed the customer’s add-ons.' or text()='J’ai passé en revue les options du client.']")
	WebElement customerAddonReveiwLink;

	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//span[text()='Passer à la caisse' or text()='Checkout']/ancestor::button")
	WebElement checkOut;

	@FindBy(xpath = "//div[@class='mini-cart-ss']//span[text()='Continuer' or text()='Continue']/ancestor::button[@ng-reflect-disabled='false']")
	WebElement minicartContinue;

	@FindBy(xpath = "//div[@class='ds-modal__footer mb-24 mb-sm-40']//span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement btnContinueOn4kChannelPack;

	@FindBy(xpath = "//span[text()='Yes, they do' or text()='Oui, il en a un']/ancestor::button")
	WebElement btnContinueOn4kTv;

	@FindBy(xpath = "//*[text()='No, they don’t'")
	WebElement noTheyDontBtn;

	@FindBy(xpath = "(//span[@translate='global.cta.add']/ancestor::button)[2]")
	WebElement addChannel;

	@FindBy(xpath = "(//button[@name='tab-themepack'])[2]")
	WebElement themePacksTab;

		@FindBy(xpath = "(//div[@class='channels-container themepack-detail']/descendant::span[@translate='global.cta.add'])[2]")
	WebElement addThemepack;

	@FindBy(xpath = "//*[text()='Yes, they do']")
	WebElement yesTheyDoBtn;


	/**
	 * Click Exchange Later btn
	 * @author chinnarao.vattam
	 */
	public void clkexchangeLater() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().clickWhenReady(exchangeLaterbtn,30);
	}
	/**
	 * Click Collapse(Down Arrow)
	 * @author chinnarao.vattam
	 */
	public void clkCollapse() {
		getReusableActionsInstance().clickIfAvailable(collapse,20);
	}
	/**
	 * Click Customer Add-On review
	 * @author chinnarao.vattam
	 */
	public void clkCustomerAddonReview() {
			getReusableActionsInstance().getWhenReady(customerAddonReveiwLink,120).click();
		}

	/**
	 * Verify reviewed all of the customer’s legacy add-ons.
	 * @return true if reviewed, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyreviewed() {
		return getReusableActionsInstance().isElementVisible(continueButton,120);

	}
	/**
	 * Click Checkout for channels Exchange
	 * @author chinnarao.vattam
	 */
	public void clkCheckOut() {
		getReusableActionsInstance().clickWhenReady(checkOut,120);
	}
	/**
	 * Click Continue
	 * @author chinnarao.vattam
	 */
	public void clkContinue() {
		getReusableActionsInstance().javascriptScrollToBottomOfPage();
		getReusableActionsInstance().staticWait(30000);
		getReusableActionsInstance().clickWhenReady(continueButton,120);
	}

	/**
	 * Click Continue in Minicart
	 * @author chinnarao.vattam
	 */
	public void clkMinicartContinue() {
		getReusableActionsInstance().clickWhenReady(minicartContinue,120);
		getReusableActionsInstance().waitForElementVisibility(btnContinueOn4kTv,120);
	}
	/**
	 * Click Continue on 4k tv popup
	 * @author Amit Goswami
	 */
	public void clkbtnContinueOn4ktv(){
		getReusableActionsInstance().clickWhenReady(btnContinueOn4kTv);
	}

	public void clkbtnContinueOn4KChannelPack(){
		getReusableActionsInstance().waitForElementVisibility(btnContinueOn4kChannelPack, 30);
		getReusableActionsInstance().clickWhenReady(btnContinueOn4kChannelPack);
	}

	public void clickNoTheyDont() {
		getReusableActionsInstance().waitForElementVisibility(noTheyDontBtn, 30);
		getReusableActionsInstance().clickWhenReady(noTheyDontBtn);


	}

	public void clickAddChannel() {
		WebElement bTn = getReusableActionsInstance().getWhenReady(addChannel, 90);
		getReusableActionsInstance().javascriptScrollByCoordinates(0, bTn.getLocation().y - 300);
		getReusableActionsInstance().getWhenReady(addChannel, 60).click();
		getReusableActionsInstance().staticWait(3000);
	}

	public void clickThemepacksTab() {

//		if (getReusableActionsInstance().isElementVisible(cancel)) {
//			clickCancel();
//		}
		getReusableActionsInstance().waitForElementVisibility(themePacksTab, 45);
		getReusableActionsInstance().scrollToElement(themePacksTab);
		getReusableActionsInstance().executeJavaScriptClick(themePacksTab);
//		getReusableActionsInstance().getWhenReady(themePacksTab, 30).click();
	}

	public void addThemepack() {
		getReusableActionsInstance().waitForElementVisibility(addThemepack, 300);
		getReusableActionsInstance().executeJavaScriptClick(addThemepack);
		/*if (getReusableActionsInstance().isElementVisible(yesToContinue, 120)) {
			getReusableActionsInstance().clickWhenReady(yesToContinue);
		}*/
	}

	public void clickYesTheyDo() {
		getReusableActionsInstance().waitForElementVisibility(yesTheyDoBtn, 30);
		getReusableActionsInstance().clickWhenReady(yesTheyDoBtn);


	}


}

