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

	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']")
	WebElement continueButton;
	/**
	 * Click Paper Billing  
	 * @param paymentopt is Payment Option to select
	 * @author chinnarao.vattam
	 */	
	public void selectPaymentOption(String paymentopt) {
//		if(getReusableActionsInstance().isElementVisible(collapse,120))
//			getReusableActionsInstance().clickWhenReady(collapse);
		getReusableActionsInstance().javascriptScrollByVisibleElement(paymentText);
		int index =Integer.parseInt(paymentopt);
		getReusableActionsInstance().selectWhenReady(paymentOption, index);
		}
	/**
	 * Click Continue Button  
	 * @author chinnarao.vattam
	 */	
	public void clkContinue() {
		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().waitForElementTobeClickable(continueButton,10);
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

