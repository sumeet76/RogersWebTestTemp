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
    WebElement proceedToCheckOutShoppingCart;

    /* This method is used to click on Proceed to checkout on ML NAC view
     *@author sonali.bansal */
    public void clkProceedShoppingCart()
    {
        getReusableActionsInstance().staticWait(5000);
        getReusableActionsInstance().javascriptScrollByVisibleElement(proceedToCheckOutShoppingCart);
        getReusableActionsInstance().executeJavaScriptClick(proceedToCheckOutShoppingCart);
        getReusableActionsInstance().waitForElementInvisibilityNOException(proceedToCheckOutShoppingCart, 60);

    }
}
