package com.rogers.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RogersChangePackageChannelsNThemePacksPage extends BasePageClass {

	public RogersChangePackageChannelsNThemePacksPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[contains(text(), 'Changes to your Ignite TV services')]")
	WebElement headerChannelsNThemePacksPage;

	@FindBy(xpath = "//h3[text() = 'Details about your channels']")
	WebElement subheaderAddOnsDetails;

	@FindBy(xpath = "//span[contains(text(),'Review Flex Channels')]")
	WebElement btnReviewFlexChannels;

	@FindBy(xpath = "//span[text() = 'Continue']")
	WebElement btnContinue;


	public boolean verifyChannelsNThemePacksPage() {
		return getReusableActionsInstance().isElementVisible(headerChannelsNThemePacksPage, 120);
	}

	public boolean verifyAddonsHeader() {
		return getReusableActionsInstance().isElementVisible(subheaderAddOnsDetails, 120);
	}

	/**
	 * Click on Reset Parental controls And Pin link
	 */
	public void clkReviewFlexChannels() {
		getReusableActionsInstance().clickWhenReady(btnReviewFlexChannels, 60);
	}

	public void clkContinue() {
		getReusableActionsInstance().clickWhenVisible(btnContinue, 60);
	}
}
