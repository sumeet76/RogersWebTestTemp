package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DashboardProfilePage extends BasePageClass {
    public DashboardProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//t[text()='Create new profile']")
    WebElement newAccountLink;

    @FindBy(xpath = "//input[@id='email']")
    WebElement txtNewEmailAddress;

    @FindBy(xpath = "//input[@id='confirm-email']")
    WebElement txtConfirmEmail;

    @FindBy(xpath = "//*[text()='Create']")
    WebElement btnCreate;

    @FindBy(xpath = "//button[@class='sm red']")
    WebElement btnClose;


    public void clickCreateNewProfileLink() {
        getReusableActionsInstance().isElementVisible(newAccountLink, 60);
        //getReusableActionsInstance().scrollToElementAndClick(newAccountLink);
        getReusableActionsInstance().clickIfAvailable(newAccountLink, 45);

    }

    public void enterNewEmailAddressForProfile(String newEmailAddress) {
        getReusableActionsInstance().isElementVisible(txtNewEmailAddress, 60);
        //getReusableActionsInstance().scrollToElementAndClick(txtNewEmailAddress);
        getReusableActionsInstance().executeJavaScriptClick(txtNewEmailAddress);
        txtNewEmailAddress.sendKeys(newEmailAddress);
    }

    public void enterConfirmEmailForProfile(String confirmEmailAddress) {
        getReusableActionsInstance().isElementVisible(txtNewEmailAddress, 60);
        //getReusableActionsInstance().scrollToElementAndClick(confirmEmailAddress);
        getReusableActionsInstance().executeJavaScriptClick(txtConfirmEmail);
        txtConfirmEmail.sendKeys(confirmEmailAddress);
        txtConfirmEmail.sendKeys(Keys.TAB);
    }

    public boolean verifyEmailAddressForNewProfileUser(String newEmail, String confirmEmail) {
        getReusableActionsInstance().isElementVisible(txtNewEmailAddress, 60);
        Assert.assertEquals(newEmail, confirmEmail);
        return true;
    }

    public void clickCreateButton() {
        getReusableActionsInstance().isElementVisible(btnCreate, 60);
        //getReusableActionsInstance().scrollToElementAndClick(btnCreate);
        getReusableActionsInstance().clickIfAvailable(btnCreate, 45);
    }

    public void clickCloseButton(){
        getReusableActionsInstance().isElementVisible(btnClose, 60);
        //getReusableActionsInstance().scrollToElementAndClick(btnClose);
        getReusableActionsInstance().clickIfAvailable(btnClose, 45);
    }
}