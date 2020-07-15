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

	/**
	 * This function will click edit button
	 * @author Saurav.Goyal
	 */
	public void clickEditButton() {
		reusableActions.clickWhenReady(btnEdit.get(0),45);
		
	}
		
}

