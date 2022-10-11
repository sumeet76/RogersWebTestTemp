package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
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

    @FindBy(xpath = "//h1[contains(text(),'Review Your Order') or contains(text(),'Vérifiez votre')]")
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

    @FindBy(xpath ="//ds-checkbox[@data-test='bopis-consent']")
    WebElement chBopisConsent;

    @FindBy(xpath = "//input[@name='accessoriesFinancingConsent']/..")
    WebElement chAccessoriesConsent;

    @FindAll({
            @FindBy(xpath = "//button[@title='Submit order - test1' or @title='Soumettre la commande']"),
            @FindBy(xpath = "//a[contains(@data-test,'cancel')]/preceding-sibling::button")
    })
    WebElement submitOrderBtn;

    @FindBy(xpath = "//span[contains(text(),'Protect supér appareil') or contains(text(),'Prem Device Protection')]//ancestor::div[contains(@class,'dsa-orderTable__row')]")
    WebElement dpAddonCarLineItem;

    @FindAll({
            @FindBy(xpath="//span[contains(text(),'Delivery Method') or contains(text(),'Mode de livraison')]/following::a[@class='link']"),
            @FindBy(xpath = "//a[@class='link' and contains(text(),'Edit')]")
    })
    WebElement editDeliveryMethod;

    @FindBy(xpath="//div[@data-test='in-store-pickup-address']/p[1]")
    WebElement selectedStoreLocation;

    @FindBy(xpath = "//p[contains(.,'Shipping Address')]/following-sibling::p")
    WebElement selectedShippingAddress;

    @FindBy(xpath = "//h4[contains(text(),'Order Summary')]/ancestor::div[@data-test='addOn-summary']")
    WebElement addonOrderSummary;

    @FindBy(xpath = "//ds-checkbox[@formcontrolname='checkboxControl']/label[contains(@class,'ds-checkboxLabel')]")
    WebElement addonsAgreement;

    @FindBy(xpath = "//button[@data-test='add-to-plan-btn' and contains(.,'Add to my plan')]")
    WebElement addToPlanButton;

    @FindBy(xpath = "//button[@data-test='remove-addon-btn' and contains(.,'Remove')]")
    WebElement addonRemoveButton;

    @FindBy(xpath = "//p[contains(text(),'Remove add-on')]")
    WebElement addonRemovalModal;

    @FindBy(xpath = "//button[@data-test='addOn-removal-modal-button' and contains(.,'Remove')]")
    WebElement addonRemovalModalbtn;

    /**
     * To Verify the Title of Order Review Page is Present
     * @return true or false
     * @author nimmy.george
     */
    public boolean isOrderReviewPageTitlePresent() {
        getReusableActionsInstance().staticWait(5000);
       return getReusableActionsInstance().isElementVisible(orderReviewPageTitle , 60);
    }

    /**
     * This method will get the total monthly fees amount after tax from the cart summary
	 * @return String having total monthly fees amount after tax from the cart summary
	 * @author nimmy.george
	 */

    public String getMonthlyFeeAfterTax() {
    	getReusableActionsInstance().javascriptScrollByVisibleElement(monthlyFeeAfterTax);
    	getReusableActionsInstance().staticWait(1500);
    	System.out.println(monthlyFeeAfterTax.getText());
    	String[] str = monthlyFeeAfterTax.getText().replaceAll("\\n","").split("\\$");
    	String[] splittedStr = str[1].split("\\/");
    	return splittedStr[0];
    	
    	}

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
        getReusableActionsInstance().clickIfAvailable(chReturningUTDeviceConsent,5);
    }

    /**
     * Clicks on the 'Upfront Consent' checkbox
     * @author nimmy.george
     */
    public void clkUpfrontConsentCheckbox() {
        getReusableActionsInstance().clickIfAvailable(chUpfrontConsent,2);
    }

    /**
     * Clicks on the 'Email Communication Consent' checkbox
     * @author karthic.hasan
     */
    public void clkEmailConsentCheckbox() {
        getReusableActionsInstance().clickIfAvailable(chEmailConsent,5);
    }

    /**
     * This method clicks on the BOPIS consent checkbox
     * @author praveen.kumar7
     */
    public void clkBopisConsentCheckbox() {
        getReusableActionsInstance().clickWhenReady(chBopisConsent,5);
    }

    /**
     * Clicks on the 'Accessories financing consent' checkbox
     * @author praveen.kumar7
     */
    public void clkAccessoriesFinancingAgreementCheckBox() {
        getReusableActionsInstance().clickWhenVisible(chAccessoriesConsent,5);
    }

    /**
     * Clicks on all Agreement consent checkboxes based on device tier
     * @param isSelectedDeviceTier String value of the deviceTier
     * @author praveen.kumar7
     */
    public void clkAllAgreementConsentCheckbox(String isSelectedDeviceTier) {
        if(isSelectedDeviceTier.equalsIgnoreCase("UPFRONT")) {
            getReusableActionsInstance().clickWhenReady(chFinancingConsent,10);
            getReusableActionsInstance().clickWhenReady(chAgreementConsent,10);
            getReusableActionsInstance().clickWhenReady(chUpfrontConsent,10);
        }
        else if(isSelectedDeviceTier.equalsIgnoreCase("FINANCING")) {
            getReusableActionsInstance().clickWhenReady(chFinancingConsent,10);
            getReusableActionsInstance().clickWhenReady(chAgreementConsent,10);
        }
        else {
            getReusableActionsInstance().clickWhenReady(chFinancingConsent, 10);
            getReusableActionsInstance().clickWhenReady(chAgreementConsent, 10);
        }
    }

    /**
     * Click on the 'Submit Order' Button
     * @author karthic.hasan
     */
    public void clkSubmitOrderBtn() {
        getReusableActionsInstance().clickWhenReady(submitOrderBtn,5);
        getReusableActionsInstance().staticWait(9000);
    }

    /**
     * This method verifies the Device Protection Add-on added to Cart
     * @return True if Device Protection Line Item is displayed in Cart summary; else false
     * @author Subash.Nedunchezhian
     */
    public boolean verifyDPCartLineItem(){
        getReusableActionsInstance().javascriptScrollByVisibleElement(dpAddonCarLineItem);
        return getReusableActionsInstance().isElementVisible(dpAddonCarLineItem);
    }
    /**
     * This method will get the Device Protection Addon amount from the cart summary
     * @return String having Device Protection Addon and amount
     * @author subash.nedunchezhian
     */
    public String getDeviceProtectionAddon() {
        return dpAddonCarLineItem.getText().replaceAll("\\n", "");
    }

    /**
     * This method clicks on Edit Shipping Method on Order Review page
     * @author Subash.Nedunchezhian
     */
    public void clickEditShipping(){
        getReusableActionsInstance().clickWhenReady(editDeliveryMethod);
    }

    /**
     * This method gets the Express Pickup Store Location on Order Review page
     *  @return String Express Pickup Store Location
     * @author Subash.Nedunchezhian
     */
    public String getSelectedStoreLocation(){
        return getReusableActionsInstance().getWhenReady(selectedStoreLocation).getText().replaceAll("\\n", "");
    }

    /**
     * This method gets the Selected Shipping Address on Order Review page
     *  @return String Selected Shipping Address
     * @author Subash.Nedunchezhian
     */
    public String getSelectedShippingAddress(){
        return getReusableActionsInstance().getWhenReady(selectedShippingAddress).getText().replaceAll("\\n", "");
    }

    /**
     * This method verify if url contains Review on Order Review page
     *  @return true if review page displayed; else false
     * @author Subash.Nedunchezhian
     */
    public boolean isAddonReviewPageDisplayed(){
        if (getDriver().getCurrentUrl().contains("review")) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * This method gets the Order Summary content on Review page
     * @return String text of Order Summary
     * @author subash.nedunchezhian
     */
    public String addonOrderSummary(){
        getReusableActionsInstance().javascriptScrollByVisibleElement(addonOrderSummary);
        return  getReusableActionsInstance().getWhenReady(addonOrderSummary).getText().replaceAll("\\n", "");
    }

    /**
     * This method clicks the Addons Agreement checkbox on Order Review page
     * @author Subash.Nedunchezhian
     */
    public void clkAddonsAgreementConsent(){
        getReusableActionsInstance().clickWhenVisible(addonsAgreement,15);
    }

    /**
     * This method clicks Add To Plan button on Order Review page
     * @author Subash.Nedunchezhian
     */
    public void clkAddToPlanBtn(){
        getReusableActionsInstance().clickWhenVisible(addToPlanButton,10);
    }

    /**
     * This method clicks Remove Button on Order Review page
     * @author Subash.Nedunchezhian
     */
    public void clkRemoveBtn(){
        getReusableActionsInstance().clickWhenVisible(addonRemoveButton,10);
    }

    /**
     * This method clicks Remove button on Addon Removal Modal
     *  @return true if Remove button on Addon Removal Modal clicked; else false
     * @author Subash.Nedunchezhian
     */
    public boolean clkRemovalModalBtn(){
        getReusableActionsInstance().isElementVisible(addonRemovalModal,10);
        getReusableActionsInstance().clickWhenReady(addonRemovalModalbtn,10);
        return true;
    }
}
