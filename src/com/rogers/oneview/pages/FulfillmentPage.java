package com.rogers.oneview.pages;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;

public class FulfillmentPage  extends BasePageClass {

	public FulfillmentPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "(//div[@class='a-radio'])[1]/ds-radio-button")
	WebElement firstAvailableAppointment;
	
	@FindBy(xpath = "//span[text()='Continuer' or text()='Continue']/ancestor::button")
	WebElement continueButton;
	
	@FindBy(xpath = "//ds-checkbox[@formcontrolname='agreeCondition']")
	WebElement agreeCondition;
	
	@FindBy(xpath = "//div[contains(@class,'alert-box-copy')]")
	WebElement 	alert;
	
	@FindBy(xpath = "//div[@class='date-picker']")
	WebElement 	datePicker;
	
	@FindBy(xpath = "//div[contains(@class,'fadeInPicker')]")
	WebElement dates;

	@FindBy(xpath = "//input[@id='ds-form-input-id-40']")
	WebElement enterDate;

	/**
	 * Click First Available Appointment
	 * @author Chinnarao.Vattam
	 */	
	public void clkFirstAvailableAppointment() {
		String ki="";
		String result=  LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy"))	;
		if(getReusableActionsInstance().isElementVisible(alert,65)) {
			getReusableActionsInstance().clickWhenReady(datePicker);
			List<WebElement> webElements=dates.findElements(By.tagName("td"));
			getReusableActionsInstance().waitForAllElementsVisible(webElements,120);
			int no=webElements.size();
			for(int ind=0;ind<no;ind++) {
				if(ind>0) {
			webElements=dates.findElements(By.tagName("td"));
			getReusableActionsInstance().waitForAllElementsVisible(webElements,120);
				}
	
				if(webElements.get(ind).getAttribute("aria-label").equals(result) || ki.equals("flag")) {
					ki="flag";
					webElements.get(ind+1).click();
					if(!getReusableActionsInstance().isElementVisible(alert,30)) {
						break;
					}else {
						getReusableActionsInstance().clickWhenReady(datePicker);
							}
						}
				}
		}
		getReusableActionsInstance().getWhenReady(firstAvailableAppointment,60);
		getReusableActionsInstance().javascriptScrollByVisibleElement(firstAvailableAppointment);
		getReusableActionsInstance().executeJavaScriptClick(firstAvailableAppointment);
	}
	/**
	 * Click Continue Button  
	 * @author Chinnarao.Vattam
	 */	
	public void clkContinue() {	
		getReusableActionsInstance().getWhenReady(continueButton).sendKeys(Keys.ENTER);
	}
	/**
	 * Click Agree Condition  
	 * @author Chinnarao.Vattam
	 */	
	public void selectChkboxAgreeCondition() {	
		WebElement btn=getReusableActionsInstance().getWhenReady(agreeCondition,120);
		getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		btn.click();
	}
}

