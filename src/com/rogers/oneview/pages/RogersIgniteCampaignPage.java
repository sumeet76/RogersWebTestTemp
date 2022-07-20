package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

import java.util.List;

public class RogersIgniteCampaignPage extends BasePageClass{

	public RogersIgniteCampaignPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//span[@translate='global.checkout.campaign.stickyTab']")
	WebElement campaignTab;

	@FindBy(xpath = "(//*/parent::div/parent::div//input/parent::div)[3]")
	WebElement couponInputContainer;

//	@FindBy(xpath = "//span[contains(text(),'Enter') or contains(text(),'Entrer')]/ancestor::span/following-sibling::input | //div[@class='campaign-codes disabled']/descendant::label")
	@FindBy(xpath = "(//input[contains(@id,'ds-form-input-id')])[1]")
	WebElement couponInput;



	@FindBy(xpath = "//div[@class='campaign-codes disabled']/descendant::label")
	WebElement couponInputSpan;



	@FindBy(xpath = "//span[@translate='global.checkout.campaign.apply']/ancestor::button")
	WebElement applyCoupon;

	@FindBy(xpath = "//span[@translate='global.checkout.campaign.remove']")
	WebElement couponRemoveLink;

	@FindBy(xpath = "//span[@class='ds-icon d-inline-flex rds-icon-close'] | //span[@class='ds-icon rds-icon-close']")
	WebElement closeCouponAlertBox;

	@FindBy(xpath = "(//div[@ng-reflect-name='backPocketOffersGroup']//div[@class='promotion-table__col3 py-12'])[1]")
	WebElement promoCode;


	/**
	 * get promo code value
	 * @author aditi.jain
	 */
	public String getPromoCode() {
		getReusableActionsInstance().waitForElementVisibility(promoCode, 30);
		String code = getReusableActionsInstance().getElementText(promoCode);
		return code;
	}

	/**
	 * verify coupon remove link exist
	 * @return true if available, else false
	 * @author Aditi.jain
	 */
	public boolean verifyCouponRemoveLink() {
		return getReusableActionsInstance().isElementVisible(couponRemoveLink,30);
	}

	/**
	 * click close Coupon Alert Box
	 * @author aditi.jain
	 */
	public void closeCouponAlert() {
		getReusableActionsInstance().waitForElementVisibility(closeCouponAlertBox);
		getReusableActionsInstance().executeJavaScriptClick(closeCouponAlertBox);
	}
	/**
	 * click Apply coupon
	 * @author aditi.jain
	 */
	public void clickApplyCoupon() {

		getReusableActionsInstance().clickWhenReady(applyCoupon,30);
	}


	/**
	 * Enter Coupon Input
	 * @param couponInputValue is the provider name
	 * @author Aditi.Jain
	 */
	public void enterCoupon(String couponInputValue) {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().waitForElementVisibility(couponInputContainer,60);
		getReusableActionsInstance().getWhenReady(couponInputContainer, 60).click();
		getReusableActionsInstance().getWhenReady(couponInput, 10).clear();
		getReusableActionsInstance().getWhenReady(couponInput, 10).sendKeys(couponInputValue);

//		getReusableActionsInstance().clickWhenReady(couponInputContainer,30);
//		getReusableActionsInstance().getWhenReady(couponInput,35).sendKeys(couponInputValue);
	}


	/**
	 * CLick sticky campaign tab
	 * @author aditi.jain
	 */
	public void clickCampaignTab() {
		getReusableActionsInstance().staticWait(5000);
		getReusableActionsInstance().waitForPageLoad();
		getReusableActionsInstance().waitForElementTobeClickable(campaignTab, 30);
		getReusableActionsInstance().clickWhenReady(campaignTab);
	}

}
