package com.rogers.ovr.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LNPEligibilityPage extends BasePageClass {
    public LNPEligibilityPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//*[@id='top-right-links']/li/a")
    WebElement lnkfrenchlang ;

    @FindBy(xpath="//*[@id='content_inner']/div/h4")
    WebElement eleVerifyPortEligibity ;

    public void changeLanguageTOFrench() throws InterruptedException {
        getReusableActionsInstance().getWhenVisible(lnkfrenchlang, 10).click();
        Thread.sleep(5000);
    }

    public String getTextForVerifyPortEligibility() {
        return getReusableActionsInstance().getElementText(eleVerifyPortEligibity);

    }



}
