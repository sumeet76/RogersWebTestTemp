package com.rogers.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersChangeSEPlanPage extends BasePageClass {

	public RogersChangeSEPlanPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[contains(@translate,'change_wireless_plan')]")
	WebElement lblChangeYourPlan;
	
	@FindBy(xpath = "//div[@class='line-details']/..//button[text()='Edit' and @aria-hidden='false']")
	WebElement btnPrimaryLineEdit;
	
	@FindBy(xpath = "//div[contains(@class,'available-plan')]/button/span[@translate='_select']")
	WebElement btnSelect;
	
	/**
	 * Validates whether Change Share Plan page has loaded successfully
	 * @return true on successful load; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyChangeSEPlanPageLoad() {
		return reusableActions.isElementVisible(lblChangeYourPlan);
	}
	
	/**
	 * Clicks on the Edit button corresponding to the Primary line CTN
	 * @author rajesh.varalli1
	 */
	public void clickPrimaryLineEdit() {
		reusableActions.clickWhenReady(btnPrimaryLineEdit);
	}
	
	/**
	 * Clicks on the 'Edit' button under the specified line CTN
	 * @param ctn Subscriber CTN
	 * @author rajesh.varalli1
	 */
	public void clickSpecificLineEdit(String ctn) {
		List<WebElement> lines = new ArrayList<WebElement>();
		lines = driver.findElements(By.xpath("//div[@class='line-details']"));
		System.out.println("LINES - " + lines.size());
		for (WebElement line : lines) {
			System.out.println(line.getText().replaceAll("-", "").replaceAll(" ", ""));
			System.out.println(ctn);
			if(line.getText().replaceAll("-", "").replaceAll(" ", "").contains(ctn)) {
				reusableActions.clickWhenReady(line.findElement(By.xpath("./..//button[text()='Edit' and @aria-hidden='false']")));
				System.out.println("HEREEEEEEEEEEEEEEEEEEEEE");
			}
		}
	}
	
	/**
	 * Clicks on the 'Select' button against first available plan
	 * @author rajesh.varalli1
	 */
	public void selectFirstAvailablePlan() {
		reusableActions.clickWhenReady(btnSelect);
	}

}