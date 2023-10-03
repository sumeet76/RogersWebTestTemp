package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RogersShippingCartPage  extends BasePageClass{
    public RogersShippingCartPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(xpath="//button[@data-test='proceed-to-checkout-btn']")
    WebElement proceedToCheckOut;

    public void clkproceedToCheckOut()
    {
        getReusableActionsInstance().staticWait(5000);
        getReusableActionsInstance().javascriptScrollByVisibleElement(proceedToCheckOut);
        getReusableActionsInstance().executeJavaScriptClick(proceedToCheckOut);
        getReusableActionsInstance().waitForElementInvisibilityNOException(proceedToCheckOut, 60);

    }
}
