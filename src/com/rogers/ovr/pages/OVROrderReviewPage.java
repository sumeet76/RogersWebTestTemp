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

    @FindBy(xpath = "//*[@translate='global.label.oneTimeHeader']")
    WebElement oneTimeFees;

    @FindBy(xpath = "//*[@translate='global.label.monthlyBill']")
    WebElement monthlyCharges;

    @FindBy(xpath = "//h2[@translate='global.label.monthlyBill']//ancestor::button")
    WebElement monthlyChargesExpandButton;

    @FindBy(xpath = "//span[@translate='global.label.internetAddOns.header']")
    WebElement internetAddOnsCharges;

    @FindBy(xpath = "//span[@translate='global.cta.continue']")
    WebElement continueBtn;

    @FindBy(xpath = "//h1[@translate='global.label.OrderReview']")
    WebElement orderReviewPageHeader;

    @FindBy(xpath = "//rch-shm-monthly-section/descendant::div[text()='Automation Package' or text()='Forfait Automatisation']")
    WebElement smartHomeMonitoringMonthlyCharges;

    @FindBy(xpath = "//rch-shm-onetime-section/descendant::div[text()='Automation Package' or text()='Forfait Automatisation']")
    WebElement smartHomeMonitoringOneTimeCharges;


    public void clkContinue(){
        getReusableActionsInstance().waitForElementTobeClickable(continueBtn, 10);
        getReusableActionsInstance().javascriptScrollByVisibleElement(continueBtn);
        getReusableActionsInstance().executeJavaScriptClick(continueBtn);
    }

    public boolean verifyOrderOverviewHeader(){
        return getReusableActionsInstance().isElementVisible(orderReviewPageHeader,120);
    }

    public boolean verifyOneTimeFees(){
        return getReusableActionsInstance().isElementVisible(oneTimeFees, 120);
    }

    public boolean verifyMonthlyCharges(){
        getReusableActionsInstance().javascriptScrollByVisibleElement(monthlyCharges);
        return getReusableActionsInstance().isElementVisible(monthlyCharges,60);
    }

    /**
     * Verifies Internet Add ons Charges present in Monthly charges.
     * @return true if Internet Add ons are present in Monthly charges
     * @author Sameer.Ahuja
     */
    public boolean verifyInternetAddOns(){
        getReusableActionsInstance().javascriptScrollByVisibleElement(internetAddOnsCharges);
        return getReusableActionsInstance().isElementVisible(internetAddOnsCharges, 10);
    }

    /**
     * Expands the Monthly charges on Order Review page and validates SHM add ons charges are present
     * @return True if SHM Add on charges are present in monthly charges.
     * @author Sameer.Ahuja
     */
    public boolean validateSHMMonthlyChargesInCartSummary(){
        getReusableActionsInstance().javascriptScrollByVisibleElement(smartHomeMonitoringMonthlyCharges);
        return getReusableActionsInstance().isElementVisible(smartHomeMonitoringMonthlyCharges, 10);
    }

    /**
     * Expands the One Time charges on Order Review Page and validates SHM add ons charges are present
     * @return True if SHM Add on charges are present in one time charges.
     * @author Sameer.Ahuja
     */
    public boolean validateSHMOnetimeChargesInCartSummary(){
        getReusableActionsInstance().javascriptScrollByVisibleElement(smartHomeMonitoringOneTimeCharges);
        return getReusableActionsInstance().isElementVisible(smartHomeMonitoringOneTimeCharges,10);
    }

}
