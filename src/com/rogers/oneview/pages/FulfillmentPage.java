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
	WebElement alert;
	
	@FindBy(xpath = "//div[@class='date-picker']")
	WebElement datePicker;
	
	@FindBy(xpath = "//div[contains(@class,'fadeInPicker')]")
	WebElement dates;
	/**
	 * Click First Available Appointment
	 * @author Harpartap.Virk
	 */	
	public void clkFirstAvailableAppointment() {
		String ki="";
		String result=  LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy"))	;
		if(reusableActions.isElementVisible(alert,65)) {
			reusableActions.clickWhenReady(datePicker);
			List<WebElement> webElements=dates.findElements(By.tagName("td"));
			reusableActions.waitForAllElementsVisible(webElements,120);
			int no=webElements.size();
			for(int ind=0;ind<no;ind++) {
				if(ind>0) {
			webElements=dates.findElements(By.tagName("td"));
			reusableActions.waitForAllElementsVisible(webElements,120);
				}
	
				if(webElements.get(ind).getAttribute("aria-label").equals(result) || ki.equals("flag")) {
					ki="flag";
					webElements.get(ind+1).click();
					if(!reusableActions.isElementVisible(alert,30)) {
						break;
					}else {
						reusableActions.clickWhenReady(datePicker);
							}
						}
				}
		}
		reusableActions.getWhenReady(firstAvailableAppointment,60);
		reusableActions.javascriptScrollByVisibleElement(firstAvailableAppointment);
		//reusableActions.staticWait(3000);
		reusableActions.executeJavaScriptClick(firstAvailableAppointment);
	}
	/**
	 * Click Continue Button  
	 * @author Harpartap.Virk
	 */	
	public void clkContinue() {	
		//reusableActions.javascriptScrollToBottomOfPage();
		reusableActions.getWhenReady(continueButton).sendKeys(Keys.ENTER);
	}
	/**
	 * Click Agree Condition  
	 * @author Harpartap.Virk
	 */	
	public void selectChkboxAgreeCondition() {	
		WebElement btn=reusableActions.getWhenReady(agreeCondition,120);
		reusableActions.javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		btn.click();
	}
}

