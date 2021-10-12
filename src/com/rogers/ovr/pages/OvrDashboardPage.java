package com.rogers.ovr.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OvrDashboardPage extends BasePageClass {
    public OvrDashboardPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//app-dashboard/div[2]/div/div[2]/a/span")
    WebElement lnkIgnite;

    public void clickIgniteLink() {
        getReusableActionsInstance().javascriptScrollByVisibleElement(lnkIgnite);
        getReusableActionsInstance().getWhenVisible(lnkIgnite).click();
    }
}
