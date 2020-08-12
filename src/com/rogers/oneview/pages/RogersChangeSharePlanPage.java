package com.rogers.oneview.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersChangeSharePlanPage  extends BasePageClass {

	public RogersChangeSharePlanPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[@class='btn edit ng-scope']")
	List<WebElement> btnEdit;
	
	
	@FindBy(xpath = "//button[@class='btn edit ng-scope']")
	WebElement lbllineDetailData;

	/**
	 * This function will click edit button on change share plan page
	 * @author Saurav.Goyal
	 */
	public void clickEditButton() {
			reusableActions.waitForPageLoad();
			reusableActions.waitForElementVisibility(lbllineDetailData, 30);
			reusableActions.clickWhenReady(btnEdit.get(0),30);
			//reusableActions.staticWait(2000);		
	}
}

