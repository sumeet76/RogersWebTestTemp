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
	 * @author Harpartap.Virk
	 */	
	public void selectPaymentOption(String paymentopt) {
		if(reusableActions.isElementVisible(collapse,120)) 
			reusableActions.clickWhenReady(collapse);
		reusableActions.javascriptScrollByVisibleElement(paymentText);
		//reusableActions.selectWhenReadyByVisibleText(paymentOption,paymentopt);
		reusableActions.selectWhenReady(paymentOption, 1);
		}
	/**
	 * Click Continue Button  
	 * @author Harpartap.Virk
	 */	
	public void clkContinue() {	
		//reusableActions.javascriptScrollToBottomOfPage();
		reusableActions.getWhenReady(continueButton,120).sendKeys(Keys.ENTER);
		System.out.println("213123");
	}
/**
 * Click Continue Button 
 * @return true if payment page appeared else false
 * @author Harpartap.Virk
 */	
public boolean verifyPaymentPage() {	
	return reusableActions.isElementVisible(paymentText,120);
}
	}

