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

    @FindBy(xpath = "//h1[@translate='global.label.orderConfirmation']")
    WebElement orderConfirmation;

    @FindBy(xpath = "//p[contains(text(),'order number is') or contains(text(),'Le numéro de commande est le')]")
    WebElement orderNumberLbl;

    @FindBy(xpath = "//*[@translate='global.label.oneTimeHeader']")
    WebElement oneTimeFees;

    @FindBy(xpath = "//*[@translate='global.label.monthlyBill']")
    WebElement monthlyCharges;

    @FindBy(xpath = "//span[@translate='global.label.backToOverView']/ancestor::button")
    WebElement backToOverviewPageBtn;

    @FindBy(xpath = "//span[text()='Continue' or text()='Continuer']/ancestor::button")
    WebElement continueToOverviewBtn;

    @FindBy(xpath = "//p[contains(text(),'Leave this page') or contains(text(),'Vous quittez cette page')]")
    WebElement leavePagePopup;

    @FindBy(xpath = "//a[contains(text(),'Overview') or contains(text(),'Survol du compte')]")
    WebElement overviewPageMenu;

    @FindBy(xpath = "//t[text()='Get Ignite' or text()='Obtenir Élan']/ancestor::a")
    WebElement lnkIgnite;


    public boolean verifyOrderConfirmation(){
        getReusableActionsInstance().waitForElementVisibility(orderConfirmation, 60);
        return getReusableActionsInstance().isElementVisible(orderConfirmation);
    }

    public boolean verifyOrderNumberPresent() {
        getReusableActionsInstance().waitForElementVisibility(orderNumberLbl, 60);
        return getReusableActionsInstance().isElementVisible(orderNumberLbl);
    }

    public boolean verifyOneTimeFees() {
        getReusableActionsInstance().waitForElementVisibility(oneTimeFees, 60);
        return getReusableActionsInstance().isElementVisible(oneTimeFees);
    }
    public boolean verifyMonthlyCharges() {
        getReusableActionsInstance().waitForElementVisibility(monthlyCharges, 60);
        getReusableActionsInstance().javascriptScrollByVisibleElement(monthlyCharges);
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        return getReusableActionsInstance().isElementVisible(monthlyCharges);
    }

    public void clkBackToOverview(){
        getReusableActionsInstance().clickWhenReady(backToOverviewPageBtn);
        getReusableActionsInstance().waitForElementVisibility(leavePagePopup, 45);
        getReusableActionsInstance().clickWhenReady(continueToOverviewBtn);
    }

    public boolean verifyOverviewPage(){
        return getReusableActionsInstance().isElementVisible(lnkIgnite, 120);
    }


}
