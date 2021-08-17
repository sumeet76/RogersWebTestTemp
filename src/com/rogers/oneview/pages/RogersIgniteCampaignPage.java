package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RogersIgniteCampaignPage extends BasePageClass{

	public RogersIgniteCampaignPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//span[@translate='global.checkout.campaign.stickyTab']")
	WebElement campaignTab;

	@FindBy(xpath = "(//*/parent::div/parent::div//input/parent::div)[3]")
	WebElement couponInputContainer;

	@FindBy(xpath = "//span[contains(text(),'Enter') or contains(text(),'Entrer')]/ancestor::span/following-sibling::input")
	WebElement couponInput;

	@FindBy(xpath = "//span[@translate='global.checkout.campaign.apply']/ancestor::button")
	WebElement applyCoupon;

	@FindBy(xpath = "//span[@translate='global.checkout.campaign.remove']")
	WebElement couponRemoveLink;

	@FindBy(xpath = "//span[@class='ds-icon rds-icon-close']")
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
	public void clickCouponAlert() {
		getReusableActionsInstance().clickWhenReady(closeCouponAlertBox,30);
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
		getReusableActionsInstance().executeJavaScriptClick(couponInputContainer);
		getReusableActionsInstance().clickWhenReady(couponInput);
		getReusableActionsInstance().clickWhenReady(couponInput);
//		getReusableActionsInstance().staticWait(3000);
		getReusableActionsInstance().enterText(couponInput, couponInputValue, 30);

//		getReusableActionsInstance().getWhenReady(couponInput,60).clear();
//		getReusableActionsInstance().getWhenReady(couponInput, 10).sendKeys(couponInputValue);

	}


	/**
	 * CLick sticky campaign tab
	 * @author aditi.jain
	 */
	public void clickCampaignTab() {
		getReusableActionsInstance().waitForElementTobeClickable(campaignTab, 30);
		getReusableActionsInstance().clickWhenReady(campaignTab);
	}

}
