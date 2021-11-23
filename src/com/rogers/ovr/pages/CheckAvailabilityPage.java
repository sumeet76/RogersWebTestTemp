package com.rogers.ovr.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckAvailabilityPage extends BasePageClass {
    public  CheckAvailabilityPage(WebDriver driver){super(driver);
    }

    @FindBy(xpath = "//span[text()='Use this address' or text()='Utiliser cette adresse']")
    WebElement btnusethisAddrs;
    @FindBy(xpath = "//*[text()='Continue' or text()='Continuer']")
    WebElement btncontnu;

    @FindBy(xpath = "//div[contains(text(),'This address is serviceable') or contains(text(),'Cette adresse peut être desservie')]")
    WebElement lblAddressIsServiceable;



    public void useThisAddress() {
        getReusableActionsInstance().getWhenVisible(btnusethisAddrs).click();
        getReusableActionsInstance().getWhenVisible(btncontnu).click();
    }

    public void addressIsServiceable(){
        if (getReusableActionsInstance().isElementVisible(lblAddressIsServiceable, 5)){
            getReusableActionsInstance().clickWhenReady(btncontnu);
        }
    }



}
