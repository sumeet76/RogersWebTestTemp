package com.rogers.ovr.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OVRAgreementPage extends BasePageClass {
    /**
     * Instantiates a new Base page class.
     *
     * @param driver the driver
     */
    public OVRAgreementPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[contains(text(),'Sign Agreement')]/ancestor::button")
    WebElement signAgreementBtn;

    @FindBy(xpath = "//span[contains(text(),'Customer has read and agrees to the ')]")
    WebElement agreementCheckbox;

    @FindBy(xpath = "//span[contains(text(),'Complete Order')]/ancestor::button")
    WebElement completeOrderBtn;

    public void signAgreement() {
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().clickWhenReady(signAgreementBtn);
        String currentWindow = getDriver().getWindowHandle();

        getReusableActionsInstance().switchToNewWindow();
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().switchToMainWindow(currentWindow);
    }

    public void clkAgreementCheckbox() {
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().clickWhenReady(agreementCheckbox);
    }

    public void clkCompleteOrder() {
        getReusableActionsInstance().clickWhenReady(completeOrderBtn);
    }
}
