package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RogersOVChangeSharePlanPage  extends BasePageClass {

	public RogersOVChangeSharePlanPage(WebDriver driver) {
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
			getReusableActionsInstance().waitForPageLoad();
			getReusableActionsInstance().waitForElementVisibility(lbllineDetailData, 30);
			getReusableActionsInstance().clickWhenReady(btnEdit.get(0),30);
			//getReusableActionsInstance().staticWait(2000);
	}
}

