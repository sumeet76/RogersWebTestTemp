package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RogersTvStreamingPage extends BasePageClass {
    public RogersTvStreamingPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[@aria-label='Shop Ignite TV with Ignite Internet']//span[text()='Get it now']")
    WebElement buttonIgniteTVGetItNow;

    public void clkGetItNowForIgniteTV(){
        getReusableActionsInstance().waitForElementVisibility(buttonIgniteTVGetItNow,30);
        getReusableActionsInstance().clickIfAvailable(buttonIgniteTVGetItNow,10);
    }

}
