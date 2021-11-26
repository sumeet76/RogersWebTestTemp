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

    @FindBy(xpath = "//p[contains(text(),'order number is') or contains(text(),'Le numéro de commande est le')]")
    WebElement orderNumberLbl;

    @FindBy(xpath = "//h2[@translate='global.label.oneTimeHeader']/ancestor::button")
    WebElement oneTimeFees;

    @FindBy(xpath = "//h2[@translate='global.label.monthlyBill']/ancestor::button")
    WebElement monthlyCharges;

    @FindBy(xpath = "//span[@translate='global.label.backToOverView']/ancestor::button")
    WebElement backToOverviewPageBtn;

    @FindBy(xpath = "//span[text()='Continue']/ancestor::button")
    WebElement continueToOverviewBtn;

    @FindBy(xpath = "//p[contains(text(),'Leave this page')]")
    WebElement leavePagePopup;

    @FindBy(xpath = "//a[contains(text(),'Overview')]")
    WebElement overviewPageMenu;

    String ovrOverviewPageUrlEN = "https://qa06-cfa.rogers.com/web/a/dashboard/overview?lang=en&userType=dealer&prov=ON";

    public boolean verifyOrderConfirmation() throws InterruptedException {
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

    public void clkBackToOverview(){
        getReusableActionsInstance().clickWhenReady(backToOverviewPageBtn);
        getReusableActionsInstance().waitForElementVisibility(leavePagePopup, 45);
        getReusableActionsInstance().clickWhenReady(continueToOverviewBtn);
    }

    public boolean verifyOverviewPage(){
        return getReusableActionsInstance().isElementVisible(overviewPageMenu, 120) && getReusableActionsInstance().verifyUrls(ovrOverviewPageUrlEN);
    }


}
