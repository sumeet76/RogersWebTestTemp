package com.rogers.ovr.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OVROrderConfirmationPage extends BasePageClass {
    /**
     * Instantiates a new Base page class.
     *
     * @param driver the driver
     */
    public OVROrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Thanks! We received the order.' or text()='Merci!  Nous avons reçu la commande.  ']")
    WebElement orderConfirmation;

    @FindBy(xpath = "//p[contains(text(),'order number is')]")
    WebElement orderNumberLbl;

    @FindBy(xpath = "//*[text()='One-Time Fees and Credits' or text()='Frais et crédits uniques']/ancestor::button")
    WebElement oneTimeFees;

    @FindBy(xpath = "//*[text()='Monthly charges']/ancestor::button")
    WebElement monthlyCharges;

    public boolean verifyOrderConfirmation() {
        getReusableActionsInstance().waitForElementVisibility(orderConfirmation, 15);
        return getReusableActionsInstance().isElementVisible(orderConfirmation);
    }

    public boolean verifyOrderNumberPresent() {
        getReusableActionsInstance().waitForElementVisibility(orderNumberLbl, 15);
        return getReusableActionsInstance().isElementVisible(orderNumberLbl);
    }

    public boolean verifyOneTimeFees() {
        getReusableActionsInstance().waitForElementVisibility(oneTimeFees, 15);
        return getReusableActionsInstance().isElementVisible(oneTimeFees);
    }
    public boolean verifyMonthlyCharges() {
        getReusableActionsInstance().waitForElementVisibility(monthlyCharges, 15);
        return getReusableActionsInstance().isElementVisible(monthlyCharges);
    }

}
