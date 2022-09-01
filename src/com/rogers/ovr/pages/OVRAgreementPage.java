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
    @FindBy(xpath = "//span[@translate='global.checkout.orderAgreement.signAgreement']/ancestor::button")
    WebElement signAgreementBtn;

    @FindBy(xpath = "//span[contains(text(),'Customer has read and agrees to the') or contains(text(),'Le client a lu et accepté')]")
    WebElement agreementCheckbox;

    @FindBy(xpath = "//h3[@translate='global.checkout.orderAgreement.additionalAgreements.label']")
    WebElement additionalAgreementsH3;

    @FindBy(xpath = "//span[@translate='global.cta.completeOrder']/ancestor::button")
    WebElement completeOrderBtn;

    @FindBy(xpath = "//h1[text()='Sign Agreements' or text()='Signature des ententes']")
    WebElement signAgreementH1;

    public boolean verifySignAgreementPage() {
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
        getReusableActionsInstance().staticWait(3000);
        getReusableActionsInstance().javascriptScrollToMiddleOfPage();
        getReusableActionsInstance().javascriptScrollByVisibleElement(additionalAgreementsH3);
        getReusableActionsInstance().clickWhenReady(agreementCheckbox);
    }

    public void clkCompleteOrder() {
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().clickWhenReady(completeOrderBtn);
    }
}
