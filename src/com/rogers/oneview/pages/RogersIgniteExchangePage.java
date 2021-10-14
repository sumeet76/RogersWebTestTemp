package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RogersIgniteExchangePage extends BasePageClass{

	public RogersIgniteExchangePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//span[@ng-reflect-translate='global.cta.bysSwapNow']/ancestor::button")
	WebElement buttonExchangeNow;

	@FindBy(xpath = "//h3[@translate='global.label.channelsToSwapOut']")
	WebElement headerChannels;

	@FindBy(xpath = "(//div[@class='cg-channels-list']/descendant::button)[1]")
	WebElement firstChannelToRemove;

	@FindBy(xpath = "//span[@translate='global.cta.select']/ancestor::button")
	WebElement buttonSelect;

	@FindBy(xpath = "(//rch-exchange-in/descendant::div[@class='cg-channels-list']/descendant::button)[1]")
	WebElement firstChannelToAdd;

	@FindBy(xpath = "//span[@translate='global.cta.continue']/ancestor::button")
	WebElement continueButton;




	/**
	 * click button exchange now
	 * @author aditi.jain
	 */
	public void clickExchangeNow() {
		getReusableActionsInstance().waitForElementVisibility(buttonExchangeNow, 60);
		getReusableActionsInstance().executeJavaScriptClick(buttonExchangeNow);
	}


	/*
	* Verify remove channel header
	* @author aditi.jain
	*/
	public boolean verifyChannelToSwapHeader() {
		return getReusableActionsInstance().isElementVisible(headerChannels,30);
	}

	/* select first channel to remove
	* @author aditi.jain
	*
	*/
	public void selectFirstChannelToRemove() {
		if (getReusableActionsInstance().isElementVisible(firstChannelToRemove,30)){
			getReusableActionsInstance().executeJavaScriptClick(firstChannelToRemove);
		}
	}

	/* select first channel to add
	 * @author aditi.jain
	 *
	 */
	public void selectFirstChannelToAdd() {
		if (getReusableActionsInstance().isElementVisible(firstChannelToAdd,30)){
			getReusableActionsInstance().executeJavaScriptClick(firstChannelToAdd);
		}
	}


	/* select button click
	 * @author aditi.jain
	 *
	 */
	public void clickSelectButton() {
		if (getReusableActionsInstance().isElementVisible(buttonSelect,30)){
			getReusableActionsInstance().executeJavaScriptClick(buttonSelect);
		}
	}


	/**
	 * Click Continue Button
	 * @author aditi.jain
	 */
	public void clkContinue() {
		getReusableActionsInstance().isElementVisible(continueButton,30);
		getReusableActionsInstance().executeJavaScriptClick(continueButton);
	}
}
