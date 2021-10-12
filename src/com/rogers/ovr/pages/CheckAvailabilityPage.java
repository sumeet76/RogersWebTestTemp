package com.rogers.ovr.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckAvailabilityPage extends BasePageClass {
    public  CheckAvailabilityPage(WebDriver driver){super(driver);
    }

    @FindBy(xpath = "//span[text()='Use this address']")
    WebElement btnusethisAddrs;
    @FindBy(xpath = "//*[text()='Continue'] ")
    WebElement btncontnu;


    public void useThisAddress() {
        getReusableActionsInstance().getWhenVisible(btnusethisAddrs).click();
        getReusableActionsInstance().getWhenVisible(btncontnu).click();
    }



}
