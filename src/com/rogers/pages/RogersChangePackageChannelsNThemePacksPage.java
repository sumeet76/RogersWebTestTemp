package com.rogers.pages;


import com.rogers.pages.base.BasePageClass;
import com.rogers.testdatamanagement.TestDataHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
	 * Clicks on Review Flex Channels button
	 */
	public void clkReviewFlexChannels() {
		getReusableActionsInstance().clickWhenReady(btnReviewFlexChannels, 60);
	}

	/**
	 * Clicks on Continue button after reviewing flex channels
	 */
	public void clkContinue() {
		getReusableActionsInstance().clickWhenVisible(btnContinue, 60);
	}

	/**
	 * Retrieves the total numbers flex channels (count) on Review Flex Channels section and compare it with the selected bundle (actual)
	 * @author: nandan.master
	 */
	public boolean validateFlexChannelCount(String bundleName) {
		List<WebElement> elements = getDriver().findElements(By.xpath("//div[@class='channel-component']//button"));
		int flexCount = 0;
		for (WebElement ele : elements) {
			try {
				flexCount++;
				System.out.println(ele.getText()); // to display the list of channel names
			} catch (StaleElementReferenceException exception) {
			}
		}

		String[] bundleId = bundleName.split(" ");
		String expected = bundleId[bundleId.length - 1];
		return String.valueOf(flexCount).equals(expected);
	}
}
