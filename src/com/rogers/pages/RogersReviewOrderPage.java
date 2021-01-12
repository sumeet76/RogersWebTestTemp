package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RogersReviewOrderPage extends BasePageClass {
    /**
     * Instantiates a new Base page class.
     *
     * @param driver the driver
     */
    public RogersReviewOrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@id='bfa-page-title' and text()='Review Your Order']")
    WebElement orderReviewPageTitle;

    @FindBy(xpath="(//div[contains(@class,'totalRow d-flex align-items-center')])[1]")
    WebElement monthlyFeeAfterTax;

    @FindBy(xpath="(//div[contains(@class,'dsa-orderTable__totalRow d-flex align-items-center')])[2]")
    WebElement oneTimeFeeAfterTax;

    @FindBy(xpath="//div[contains(@class,'dsa-promoBlock p-md-24 p-16 ds-bgcolor-misty')]")
    WebElement purchaseIncludes;

    @FindBy(xpath="(//p[@class='text-body-sm my-8'])[1]")
    WebElement contactName;

    @FindBy(xpath="(//p[@class='text-body-sm my-8'])[2]")
    WebElement contactNumber;

    @FindBy(xpath="(//p[@class='text-body-sm my-8'])[3]")
    WebElement contactEmail;

    @FindBy(xpath="//p[@class='text-body-lg mb-0' and contains(text(),'Shipping Address')]/..")
    WebElement shippingCompleteAddress;
    
    @FindBy(xpath="//p[@class='text-body-lg mb-0 ng-star-inserted' and contains(text(),'Delivery Method')]")
    WebElement deliveryMethodTitle;
    
    @FindBy(xpath="//p[@class='text-body-sm my-8' and contains(text(),'Rogers Pro On-the-Go')]/../p[2]")
    WebElement deliveryDate;
    
    @FindBy(xpath="//p[@class='text-body-sm my-8' and contains(text(),'Rogers Pro On-the-Go')]/../p[3]")
    WebElement deliveryTime;
    
    @FindBy(xpath="//p[@class='text-body text-bold mt-40']")
    WebElement txtPleaseReadAgreement;
    
    @FindBy(xpath="//input[contains(@name,'financingConsent')]/..")
    WebElement chFinancingConsent;

    @FindBy(xpath="//input[contains(@name,'agreementConsent')]/..")
    WebElement chAgreementConsent;

    @FindBy(xpath="//input[contains(@name,'returningUEDeviceConsent')]/parent::label")
    WebElement chReturningUTDeviceConsent;

    @FindBy(xpath = "//input[contains(@name,'upfrontConsent')]/..")
    WebElement chUpfrontConsent;
    
    @FindBy(xpath ="//ds-checkbox[@name='credit-check']")
    WebElement chEmailConsent;

    
	 @FindBy(xpath ="//button[@title='Submit order - test1']")
	 WebElement submitOrderBtn;



    /**
     * To Verify the Title of Order Review Page is Present
     * @return true or false
     * @author nimmy.george
     */
    public boolean isOrderReviewPageTitlePresent() {
    	getReusableActionsInstance().waitForElementVisibility(orderReviewPageTitle, 60);
       return getReusableActionsInstance().isElementVisible(orderReviewPageTitle);
    }

    /**
     * This method will get the total monthly fees amount after tax from the cart summary
	 * @return String having total monthly fees amount after tax from the cart summary
	 * @author nimmy.george
	 */

    public String getMonthlyFeeAfterTax() {
    	getReusableActionsInstance().javascriptScrollByVisibleElement(monthlyFeeAfterTax);
    	getReusableActionsInstance().staticWait(3000);
    	System.out.println(monthlyFeeAfterTax.getText());
    	return monthlyFeeAfterTax.getText().replaceAll("\\n",""); }

    /**
     * This method will get the total one time fees amount after tax from the cart summary
     * @return String having total monthly fees amount after tax from the cart summary
     * @author nimmy.george
     */

    public String getOneTimeFeeAfterTax() { return oneTimeFeeAfterTax.getText().replaceAll("\\n",""); }

    /**
     * This method will get the purchase includes section displayed below the cart summary
     * @return String : Return the purchase includes text displayed below the cart summary
     * @author nimmy.george
     */

    public String getPurchaseIncludesText(){ return getReusableActionsInstance().getWhenReady(purchaseIncludes,10).getText().trim().replaceAll("\\n", " "); }


    /**
     * to get the contact name from the Review Order Page
     * @return the contact name
     * @author nimmy.george
     */
    public String getContactName() {
    	getReusableActionsInstance().javascriptScrollToTopOfPage();
        getReusableActionsInstance().getWhenReady(contactName);
        return getReusableActionsInstance().getWhenReady(contactName).getText();
    }

    /**
     * to get the contact number from the Review Order Page
     * @return the contact number
     * @author nimmy.george
     */
    public String getContactNumber() {
        getReusableActionsInstance().getWhenReady(contactNumber);
        return getReusableActionsInstance().getWhenReady(contactNumber,20).getText().trim();
    }

    /**
     * to get the contact email from the Review Order Page
     * @return the contact email
     * @author nimmy.george
     */
    public String getContactEmail() {
        getReusableActionsInstance().getWhenReady(contactEmail);
        return getReusableActionsInstance().getWhenReady(contactEmail).getText();
    }

    /**
	 * This method will get Shipping Complete Address  from Order Review Page
	 ** @return String having Shipping Complete Address  from Order Review Page
	 * @author karthic.hasan
	 */

	public String getShippingAddressText() { 
		return getReusableActionsInstance().getWhenReady(shippingCompleteAddress,10).getText().trim().replaceAll("\\n", " ");
	}

    /**
     * To get the Delivery Address Title in Order Review Page
     * @return true or false
     * @author Karthic.hasan
     */
    public boolean verifyDeliveryAddressTitle() {
       return getReusableActionsInstance().isElementVisible(deliveryMethodTitle);
    }
	
    
    /**
	 * This method will get Delivery Date from Order Review Page
	 * @return String having Delivery Date from Order Review Page
	 * @author karthic.hasan
	 */

	public String getDeliveryDate() { 
		getReusableActionsInstance().javascriptScrollByVisibleElement(deliveryDate);
   	    getReusableActionsInstance().staticWait(3000);
		return deliveryDate.getText().replaceAll("\\n",""); 
	}
	
	 
    /**
	 * This method will get Delivery Time from Order Review Page
	 * @return String having Delivery Time from Order Review Page
	 * @author karthic.hasan
	 */

	public String getDeliveryTime() { 
		getReusableActionsInstance().javascriptScrollByVisibleElement(deliveryTime);
   	    getReusableActionsInstance().staticWait(3000);
		return deliveryTime.getText().replaceAll("\\s",""); 
	}
	
    /**
     * Clicks on the 'Financing Terms' checkbox
     * @author nimmy.george
     */
    public void clkFinancingConsentCheckbox() {
        getReusableActionsInstance().javascriptScrollByVisibleElement(txtPleaseReadAgreement);
        getReusableActionsInstance().staticWait(1000);
        getReusableActionsInstance().clickWhenReady(chFinancingConsent,2);
    }

    /**
     * Clicks on the 'Agreement Consent' checkbox
     * @author nimmy.george
     */
    public void clkAgreementConsentCheckbox() {
        getReusableActionsInstance().clickWhenReady(chAgreementConsent,2);
    }

    /**
     * Clicks on the 'Returning UE device consent' checkbox
     * @author saurav.goyal
     */
    public void clkReturningUEDeviceConsentCheckbox() {
        getReusableActionsInstance().clickWhenReady(chReturningUTDeviceConsent,2);
    }

    /**
     * Clicks on the 'Upfront Consent' checkbox
     * @author nimmy.george
     */
    public void clkUpfrontConsentCheckbox() {
        getReusableActionsInstance().clickWhenReady(chUpfrontConsent,2);
    }

    /**
     * Clicks on the 'Email Communication Consent' checkbox
     * @author karthic.hasan
     */
    public void clkEmailConsentCheckbox() {
        getReusableActionsInstance().clickWhenReady(chEmailConsent,2);
    }

    
    /**
     * Click on the 'Submit Order' Button
     * @author karthic.hasan
     */
    public void clkSubmitOrderBtn() {
        getReusableActionsInstance().clickWhenReady(submitOrderBtn,2);
        getReusableActionsInstance().staticWait(9000);
    }

}
