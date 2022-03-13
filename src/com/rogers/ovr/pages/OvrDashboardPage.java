package com.rogers.ovr.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OvrDashboardPage extends BasePageClass {
    public OvrDashboardPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//t[text()='Get Ignite' or text()='Obtenir Élan']/ancestor::a")
    WebElement lnkIgnite;

    @FindBy(xpath = "//a[contains(text(),'Français') and @id='language-changed']")
    WebElement changeLangToFR;

    public void clickIgniteLink() {
        getReusableActionsInstance().waitForElementVisibility(lnkIgnite,30);
        getReusableActionsInstance().javascriptScrollByVisibleElement(lnkIgnite);
        getReusableActionsInstance().getWhenVisible(lnkIgnite).click();
    }

    public void changeLangToFR(){
        getReusableActionsInstance().clickWhenReady(changeLangToFR);
    }
}
