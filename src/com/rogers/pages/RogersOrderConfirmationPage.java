package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import java.util.List;

import com.rogers.pages.base.BasePageClass;

public class RogersOrderConfirmationPage extends BasePageClass {

	public RogersOrderConfirmationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='info-bubble ute-large-right']")
	WebElement infoSubmit;
	
	@FindBy(xpath = "//a[@href='/consumer/rogers-internet' and @class='rui-cta-button']")
	WebElement btnContinueShopping;
	
	// Thanks! We received your order. 
	@FindBy(xpath = "//div[@class='confirmation-bubble']")
	WebElement infoChangeOrderConfirmationnew;
	
	@FindBy(xpath = "//ins[@translate='global.message.orderConfirmationThanksV3']")
	WebElement infoChangeOrderConfirmation;
	//ins[@translate='global.message.orderConfirmationThanksV3']

	@FindBy(xpath = "//img[@src='/cms/rogers/page-specific/shop/ordersummary/thankyou/images/thankyou-badge-desktop.png']")
	WebElement infoChangeOrderConfirmationLegacy;
	
	@FindBy(xpath = "//div[@class='confirmation-bubble']")
	WebElement infoOrderConfirmation;
	//ins[@translate='global.message.orderConfirmationThanksV2']

	@FindAll({
		@FindBy(xpath = "//p[contains(text(),'Thank you')]"),
		@FindBy(xpath = "//span[@class='thank-you']"),
		@FindBy(xpath = "//span[@class='UConfirmationHeading']"),
		@FindBy(xpath = "//p[@class='text-body mb-40 ng-star-inserted']")
	})	
	WebElement lblThankYou;

	@FindAll({
		@FindBy(xpath = "//h1[@id='bfa-page-title'][contains(text(),'Confirmation')]"),
		@FindBy(xpath = "//span[@checkout-res='checkout_order_confirmation']")
	})
	WebElement lblOrderConfirmation;
	
	@FindBy(xpath = "//div[@class='orderSummary']")
	WebElement btnDTVOrderSummary;
	
	@FindBy(className = "shoppingCartCheckOutButton")
	WebElement btnUpgradeCartCheckOutButton;
	
	@FindBy(xpath = "//div[contains(@class,'preloader')]")
	WebElement popupLoadingFingers;
	
	@FindBy(xpath = "//ngx-smart-modal[@id='loadingModal']")
	WebElement popupLoadingFingersciam;
	
	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popupLoadingFingersInternet;

	@FindAll({
			@FindBy(xpath = "//ds-expander[@id='orderTable-refId-11']//div[@class='ds-price']"),
			@FindBy(xpath = "//span[@checkout-res='checkout_order_summary_total']")
	})
	WebElement lblOrderSummaryTotal;

	@FindBy(xpath = "//div[contains(@class,'dsa-orderTable__priceRows')]")
	List<WebElement> cartSummarySection;

	@FindAll({
			@FindBy(xpath = "//div[contains(@class,'my-12 ng-star-inserted')]"),
			@FindBy(xpath = "//div[contains(@class,'col-xs-5 ng-star-inserted')]")
	})
	List<WebElement> bopisContent;

	@FindBy(xpath="//h4[@data-test='rpotgTitle']")
	WebElement rpotgTitle;

	@FindBy(xpath="//h5[contains(@class,'text-title-5')]")
	WebElement appointmentDetailsTitle;

	@FindBy(xpath="//p[contains(@class,'text-bold text-title')][contains(text(),'Appointment date') or contains(text(),'Date du rendez-vous')]")
	WebElement appointmentDateTitle;

	@FindBy(xpath="//p[contains(@class,'text-bold text-title')][contains(text(),'Appointment address') or contains(text(),'Adresse où le rendez-vous se tiendra')]")
	WebElement appointmentAddressTitle;

	@FindBy(xpath="//img[@alt='largeImage_1']")
	WebElement deviceImage;

	@FindBy(xpath="//div[@class='my-12 ng-star-inserted']/p[@class='text-bold text-title-6']/..")
	WebElement appointmentCompleteAddress;

	@FindBy(xpath="(//div[contains(@class,'totalRow d-flex align-items-center')])[1]")
	WebElement monthlyFeeAfterTax;

	@FindBy(xpath="(//div[contains(@class,'dsa-orderTable__totalRow d-flex align-items-center')])[2]")
	WebElement oneTimeFeeAfterTax;
	
	
	/**
	 * Verify the the yellow banner with order success information
	 * @return true if the page display the yellow banner with order success information , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyOrderConfirmationLegacy() {
		getReusableActionsInstance().waitForElementVisibility(infoChangeOrderConfirmationLegacy,90);
		return getReusableActionsInstance().isElementVisible(infoChangeOrderConfirmationLegacy, 30);
	}
	
	/**
	 * Verify the the yellow banner with order success information
	 * @return true if the page display the yellow banner with order success information , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyOrderConfirmation() {
		return getReusableActionsInstance().isElementVisible(infoOrderConfirmation, 120);
	}
	
	/**
	 * Verify the the yellow banner with order success information
	 * @return true if the page display the yellow banner with order success information , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyOrderConfirmationNew() {
		return getReusableActionsInstance().isElementVisible(infoChangeOrderConfirmationnew, 120);
	}
	/**
	 * Verify the the yellow banner with order success information
	 * @return true if the page display the yellow banner with order success information , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyOrderSuccess() {
		getReusableActionsInstance().waitForElementVisibility(infoOrderConfirmation,90);
		return getReusableActionsInstance().isElementVisible(infoOrderConfirmation, 30);
	}
	
	
	/**
	 * Verify the Continue Shopping button on order confirmation page
	 * @return true if the page display Continue Shopping button, else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyContinueShopping() {
		return getReusableActionsInstance().isElementVisible(btnContinueShopping, 10);
	}
	
	/**
	 * Validates whether the Order Confirmation page has loaded
	 * @return true if 'Order Confirmation' header displayed; else false
	 * @author rajesh.varalli1
	 */
	public boolean verifyOrderConfirmationPageLoad() {
		getReusableActionsInstance().staticWait(10000);
		return getReusableActionsInstance().isElementVisible(lblOrderConfirmation, 60);
	}
	
	/**
	 * Validates if the 'Thank You' message id displayed
	 * @return true if displayed; else false
	 * @author Saurav.Goyal
	 */
	public boolean verifyThankYouDisplayed() {
		getReusableActionsInstance().waitForAllElementsVisible(cartSummarySection,60);
		if(lblThankYou.isDisplayed()) {
			return getReusableActionsInstance().isElementVisible(lblThankYou,60);
		}
		return false;
	}

	/**
	 * This method verifies if BOPIS contents are displayed in order confirmation page
	 * @return a boolean true if BOPIS contents are displayed else false
	 * @author praveen.kumar7
	 */
	public boolean verifyBopisContentDisplayed() {
		boolean isElementPresent = true;
		for(WebElement element : bopisContent) {
			isElementPresent = getReusableActionsInstance().isElementVisible(element, 40);
			if(!isElementPresent) {
				return false;
			}
		}
		getReusableActionsInstance().scrollToElement(bopisContent.get(0));
		return true;
	}
	
	/**
	 * Verify the the yellow banner with order success information
	 * @return true if the page display the yellow banner with order success information , else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyLegacyUpgardeOrderConfirmation() {
		return getReusableActionsInstance().isElementVisible(btnDTVOrderSummary, 180);
	}
	
	/**
	 * click on  the CheckOut Button
	 * @author chinnarao.vattam
	 */
	public void clkUpgradeCartCheckOutButton() {
		getReusableActionsInstance().waitForElementVisibility(btnUpgradeCartCheckOutButton, 180);
		getReusableActionsInstance().executeJavaScriptClick(btnUpgradeCartCheckOutButton);
	}

	/**
	 * verifies RPOTG title in confirmation page
	 * @return true if RPOTG title is present; else false
	 * @author praveen.kumar7
	 */
	public boolean verifyRpotgTitle() {
		getReusableActionsInstance().staticWait(1000);
		return getReusableActionsInstance().isElementVisible(rpotgTitle,5);
	}

	/**
	 * verifies if AppointmentDetails Title is present in confirmation page
	 * @return true if AppointmentDetails title is present; else false
	 * @author praveen.kumar7
	 */
	public boolean verifyAppointmentDetailsTitle() {
		return getReusableActionsInstance().isElementVisible(appointmentDetailsTitle,5);
	}

	/**
	 * verifies if AppointmentDate Title is present in confirmation page
	 * @return true if AppointmentDate title is present; else false
	 * @author praveen.kumar7
	 */
	public boolean verifyAppointmentDateTitle() {
		return getReusableActionsInstance().isElementVisible(appointmentDateTitle,5);
	}

	/**
	 * verifies if Appointment address Title is present in confirmation page
	 * @return true if Appointment Address title is present; else false
	 * @author praveen.kumar7
	 */
	public boolean verifyAppointmentAddressTitle() {
		return getReusableActionsInstance().isElementVisible(appointmentAddressTitle,5);
	}

	/**
	 * verifies if device image is present in confirmation page
	 * @return true if device image is present; else false
	 * @author praveen.kumar7
	 */
	public boolean verifyDeviceImage() {
		return getReusableActionsInstance().isElementVisible(deviceImage,5);
	}

	/**
	 * This method checks for appointment address in confirmation page
	 * @return String value of Appointment address
	 * @author praveen.kumar7
	 */
	public String getAppointmentAddressText() {
		getReusableActionsInstance().scrollToElement(appointmentCompleteAddress);
		return getReusableActionsInstance().getWhenReady(appointmentCompleteAddress,10).getText().trim().replaceAll("\\n", " ");
	}

	/**
	 * This method looks for monthly fee after tax in confirmation page
	 * @return String value of Monthly fee after tax
	 * @author praveen.kumar7
	 */
	public String getMonthlyFeeAfterTax() {
		getReusableActionsInstance().scrollToElement(monthlyFeeAfterTax);
		return monthlyFeeAfterTax.getText().replaceAll("\\n","");
	}

	/**
	 * This method looks for one time fee after tax in confirmation page
	 * @return String value of one time fee after tax
	 * @author praveen.kumar7
	 */
	public String getOneTimeFeeAfterTax() {
		getReusableActionsInstance().scrollToElement(oneTimeFeeAfterTax);
		return oneTimeFeeAfterTax.getText().replaceAll("\\n","");
	}
	
}
