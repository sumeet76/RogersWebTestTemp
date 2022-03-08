package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RogersHTOPromotionPage extends BasePageClass {

	public RogersHTOPromotionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//p[contains(@class,'dsa-billboard__overline')]")
	WebElement txtSpecialOffer;


	@FindBy(xpath = "//div[@class='current-bundle-details']")
	WebElement divCurrentBundleContainer;

	@FindBy(xpath = "//h2[contains(text(),'old')]")
	WebElement txtCurrentBundle;

	@FindBy(xpath = "//h2[contains(text(),'new')]")
	WebElement txtOfferBundle;

	@FindBy(xpath = "//label[contains(@class,'ds-checkboxLabel')]")
	WebElement chkUpgrade;

	@FindBy(xpath ="//div[@class='ng-star-inserted overlay nsm-overlay-open']")
	WebElement overlayPromoPage;

	@FindBy(xpath = "//a[contains(@class,'upgrade-today')]/span/span")
	WebElement btnReviewYourUpgrade;

	@FindBy(xpath = "//div[@class='bundle-offer-details']")
	WebElement divOfferBundleContainer;

	@FindBy(xpath = "//button[contains(@class,'bundle-promo-dtl-link-')]/span")
	WebElement lnkLearnMore;

	@FindBy(xpath = "//button[@aria-label='View next Ignite feature']/span")
	WebElement btnViewNextFeature;

	@FindBy(xpath = "//button[@aria-label='View previous Ignite feature']/span")
	WebElement btnViewPreviousFeature;

	@FindBy(xpath = "//button[@aria-label='Close this pop-up']/span")
	WebElement btnCloseThisPopup;

	/**
	 * To verify the Home page
	 * @return true if the special offer text is available on promotion page, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyPromotionPage() {
		return getReusableActionsInstance().isElementVisible(txtSpecialOffer, 60);
	}

	/**
	 * To verify the Current Bundle Container
	 * @return true if the old bundle details is available on promotion page, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyCurrentBundle() {
		getReusableActionsInstance().waitForElementVisibility(divCurrentBundleContainer, 60);
		getReusableActionsInstance().javascriptScrollToMiddleOfPage();
		return getReusableActionsInstance().isElementVisible(txtCurrentBundle, 30);
	}

	/**
	 * To verify the Offer Bundle Container
	 * @return true if the new bundle details is available on promotion page, else false
	 * @author Manpreet.Kaur3
	 */
	public boolean verifyOfferBundle() {
		getReusableActionsInstance().waitForElementVisibility(divOfferBundleContainer, 30);
		return getReusableActionsInstance().isElementVisible(txtOfferBundle, 30);
	}

	/**
	 * To Click on Upgrade checkbox
	 * @author Manpreet.Kaur3
	 */
	public void clickIWantThisUpgrade() {
		getReusableActionsInstance().clickIfAvailable(chkUpgrade, 40);
	}

	/**
	 * To Click on Review your Upgrade button
	 * @author Manpreet.Kaur3
	 */
	public void clickReviewYourUpgrade() {
		if(getReusableActionsInstance().isElementVisible(overlayPromoPage,2))
		{
			getReusableActionsInstance().waitForElementInvisibility(overlayPromoPage,5);
		}
		getReusableActionsInstance().getWhenReady(btnReviewYourUpgrade, 60).click();
	}

	/**
	 * To Click on Learn More link
	 * @author Manpreet.Kaur3
	 */
	public void clickLearnMore() {
		getReusableActionsInstance().clickIfAvailable(lnkLearnMore, 30);
	}

	/**
	 * To Click on View Next Feature Button
	 * @author Manpreet.Kaur3
	 */
	public void clickViewNextFeature() {
		getReusableActionsInstance().clickWhenReady(btnViewNextFeature, 30);
	}

	/**
	 * To Click on View Previous Feature Button
	 * @author Manpreet.Kaur3
	 */
	public void clickViewPreviousFeature() {
		getReusableActionsInstance().clickWhenReady(btnViewPreviousFeature, 30);
	}

	/**
	 * To Click on Close This Popup Button
	 * @author Manpreet.Kaur3
	 */
	public void clickClosePopup() {
		getReusableActionsInstance().clickWhenReady(btnCloseThisPopup, 30);
	}
}

