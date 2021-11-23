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

    @FindBy(xpath = "//h1[text()='Sign Agreements']")
    WebElement signAgreementH1;

    public boolean verifySignAgreementPage() throws InterruptedException {
        return getReusableActionsInstance().isElementVisible(signAgreementH1, 60);
    }

    public void signAgreement() {
        getReusableActionsInstance().waitForElementTobeClickable(signAgreementBtn, 120);
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().executeJavaScriptClick(signAgreementBtn);
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
