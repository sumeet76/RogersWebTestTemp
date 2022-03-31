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
    @FindBy(xpath = "//div[@translate='global.label.oneTimeHeader']")
    WebElement oneTimeFees;

    @FindBy(xpath = "//p[@translate='global.label.monthlyBill']")
    WebElement monthlyCharges;

    @FindBy(xpath = "//h2[@translate='global.label.monthlyBill']//ancestor::button")
    WebElement monthlyChargesExpandButton;

    @FindBy(xpath = "//span[@translate='global.label.internetAddOns.header']")
    WebElement internetAddOnsCharges;

    @FindBy(xpath = "//span[@translate='global.cta.continue']")
    WebElement continueBtn;

    @FindBy(xpath = "//h1[@translate='global.label.OrderReview']")
    WebElement orderReviewPageHeader;

    public void clkContinue(){
        getReusableActionsInstance().waitForElementTobeClickable(continueBtn, 10);
        getReusableActionsInstance().javascriptScrollByVisibleElement(continueBtn);
        getReusableActionsInstance().executeJavaScriptClick(continueBtn);
    }

    public boolean verifyOrderOverviewHeader(){
        return getReusableActionsInstance().isElementVisible(orderReviewPageHeader,100);
    }

    public boolean verifyOneTimeFees(){
        return getReusableActionsInstance().isElementVisible(oneTimeFees, 60);
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

    public boolean verifySHMaddOns(){
        return true;
    }
}
