package com.rogers.ovr.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OVROrderReviewPage extends BasePageClass {
    /**
     * Instantiates a new Base page class.
     *
     * @param driver the driver
     */
    public OVROrderReviewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[text()='One-Time Fees and Credits' or text()='Frais et crédits uniques']/ancestor::button")
    WebElement oneTimeFees;

    @FindBy(xpath = "//*[text()='Monthly charges']/ancestor::button")
    WebElement monthlyCharges;

    @FindBy(xpath = "//span[text()='Continue']")
    WebElement continueBtn;

    public void clkContinue(){
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().clickWhenReady(continueBtn);
    }

    public boolean verifyOneTimeFees(){
        return getReusableActionsInstance().isElementVisible(oneTimeFees, 10);
    }

    public boolean verifyMonthlyCharges(){
        return getReusableActionsInstance().isElementVisible(monthlyCharges, 10);
    }
}
