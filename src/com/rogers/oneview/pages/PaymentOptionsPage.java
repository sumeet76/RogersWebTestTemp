package com.rogers.oneview.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

public class PaymentOptionsPage  extends BasePageClass {

	public PaymentOptionsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@translate='global.label.informPaymentOption']/parent::p/parent::div/parent::div/parent::div//select")
	WebElement paymentOption;

	@FindBy(xpath = "//span[@class='ds-icon rds-icon-expand']/ancestor::button")
	WebElement collapse;

	@FindBy(xpath = "//*[text()='Options de paiement' or text()='Payment Options']")
	WebElement paymentText;

	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement continueButton;
	/**
	 * Click Paper Billing  
	 * @param paymentopt is Payment Option to select
	 * @author chinnarao.vattam
	 */	
	public void selectPaymentOption(String paymentopt) {
		if(getReusableActionsInstance().isElementVisible(collapse,120))
			getReusableActionsInstance().clickWhenReady(collapse);
		getReusableActionsInstance().javascriptScrollByVisibleElement(paymentText);
		getReusableActionsInstance().selectWhenReady(paymentOption, 1);
		}
	/**
	 * Click Continue Button  
	 * @author chinnarao.vattam
	 */	
	public void clkContinue() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().scrollToElement(continueButton);
		getReusableActionsInstance().waitForElementTobeClickable(continueButton,5);
		getReusableActionsInstance().executeJavaScriptClick(continueButton);
	}
/**
 * Click Continue Button 
 * @return true if payment page appeared else false
 * @author chinnarao.vattam
 */	
public boolean verifyPaymentPage() {	
	return getReusableActionsInstance().isElementVisible(paymentText,120);
}
	}

