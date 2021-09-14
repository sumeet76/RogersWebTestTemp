package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

public class RogersOneTimePaymentPage extends BasePageClass {
    public RogersOneTimePaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='ds-inputLabel d-block ds-no-overflow'][contains(text(),'CVV')]/ancestor::div/input")
    WebElement inputTxtCVV;

    //@FindBy(xpath = "//span[@class='ds-inputLabel d-block ds-no-overflow'][contains(text(),'CVV')]")
    @FindBy(xpath = "//ds-form-field[@data-test='cvv']//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white']")
    WebElement txtContainerCVV;

    @FindBy(xpath = "//*[@class='ds-formField__wrapper']//iframe")
    WebElement fraSemaphone;

    @FindBy(xpath = "//input[@id='pan']")
    WebElement txtCardNumber;

    @FindBy(xpath = "//ds-form-field[@data-test='expiry-date']//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white']")
    WebElement txtExpiryDate;

    //span[@class='ds-inputLabel d-block ds-no-overflow'][contains(text(),'Expiry Date') or contains(text(),'Date')]

    @FindBy(xpath = "//span[@class='ds-inputLabel d-block ds-no-overflow'][contains(text(),'Expiry Date') or contains(text(),'Date')]/ancestor::div/input")
    WebElement inputExpiryDate;

    @FindBy(xpath ="//button[@id='main-continue-button']")
    WebElement submitOrderBtn;

    @FindBy(xpath = "//ds-form-field[@data-test='name']")
    WebElement nameOnCard;

    @FindBy(xpath = "//ds-form-field[@data-test='name']//input")
    WebElement inputNameOnCard;

    /**
     * Verify the onetime payment page is getting displayed
     * @return true if onetime payment page displayed else false
     * @author saurav.goyal
     */
    public boolean verifyOneTimePaymentPage() {
        getReusableActionsInstance().waitForElementVisibility(fraSemaphone,60);
        return getReusableActionsInstance().isElementVisible(fraSemaphone, 30);
    }

    /**
     * Set the dynamic CVV for Pre-Auth credit card
     * @author saurav.goyal
     */
    public void setCVV() {
        String strCVV = FormFiller.generateCVVNumber();
        getReusableActionsInstance().waitForElementVisibility(txtContainerCVV,50);
        getReusableActionsInstance().getWhenReady(txtContainerCVV,10).click();
        inputTxtCVV.click();
        getReusableActionsInstance().getWhenReady(inputTxtCVV).sendKeys(strCVV);
    }
    /**
     * Switch to Credit Card Iframe in Credit Evaluation stepper
     * @author saurav.goyal
     */

    public void switchToCreditCardIFrame() { getDriver().switchTo().frame(getReusableActionsInstance().getWhenVisible(fraSemaphone)); }

    /**
     * Enter the Credit Card Number on the Credit Evaluation stepper, Credit Card Field
     *@param strAccountNumber xpath
     * @author saurav.goyal
     */

    public void setCreditCardNumberIFrame(String strAccountNumber) {
        getReusableActionsInstance().getWhenReady(txtCardNumber, 30).sendKeys(strAccountNumber);
    }

    /**
     * Switch out of Credit Card Iframe in Credit Evaluation stepper
     * @author saurav.goyal
     */

    public void switchOutOfCreditCardIFrame() { getDriver().switchTo().defaultContent(); }

    /**
     * Enter the Expiry Date on the Credit Evaluation stepper, Expiry Date Field
     * @param strExpiryDate xpath
     * @author saurav.goyal
     */

    public void setExpiryDate(String strExpiryDate) {
        getReusableActionsInstance().staticWait(4000);
        getReusableActionsInstance().getWhenReady(txtExpiryDate).click();
        getReusableActionsInstance().getWhenReady(inputExpiryDate, 10).sendKeys(strExpiryDate);
    }



    /**
     * Click on the 'Submit Order' Button on the onetime payment page
     * @author saurav.goyal
     */
    public void clkSubmitOrderBtn() {
        getReusableActionsInstance().clickWhenReady(submitOrderBtn,2);
        getReusableActionsInstance().staticWait(9000);
    }

    /**
     * Enter the firstName on the Create Profile stepper, First Name field
     * @author saurav.goyal
     */

    public void setNameonCard() {
        getReusableActionsInstance().javascriptScrollToTopOfPage();
        getReusableActionsInstance().clickWhenReady(nameOnCard);
        getReusableActionsInstance().getWhenReady(inputNameOnCard,3).sendKeys(FormFiller.generateRandomName()+FormFiller.generateRandomName());
    }
}
