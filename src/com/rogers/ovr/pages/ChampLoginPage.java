package com.rogers.ovr.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChampLoginPage extends BasePageClass {

    @FindBy(name = "loginfmt")
    WebElement txtEmail;
    @FindBy(id = "idSIButton9")
    WebElement btnNext;
    @FindBy(id = "userNameInput")
    WebElement txtUserName;
    @FindBy(id = "idSIButton9")
    WebElement signInButton;
    @FindBy(xpath = "//input[@type='password']")
    WebElement txtPassword;
    @FindBy(id= "idBtn_Back")
    WebElement staySignedInNO;

    @FindBy(xpath = "//span[contains(text(),'Sign in') or contains(text(),'identifier')]")
    WebElement corpSignInBtn;

    @FindBy(xpath = "//input[@value='Next' or @value='suivante']")
    WebElement corpLoginNextBtn;

    @FindBy(xpath = "//a[contains(text(),'Skip setup') or contains(text(),'sauter')]")
    WebElement corpLoginSkip2faSetup;


    public ChampLoginPage(WebDriver driver) {
        super(driver);
    }

    public void logIntoChamp(String email, String password) throws InterruptedException {

        getReusableActionsInstance().getWhenVisible(txtEmail).sendKeys(email);
        getReusableActionsInstance().getWhenVisible(btnNext).click();
        getReusableActionsInstance().getWhenVisible(txtPassword).sendKeys(password);
        getReusableActionsInstance().getWhenVisible(signInButton).click();
        if(getReusableActionsInstance().isElementVisible(staySignedInNO, 10)){
            getReusableActionsInstance().getWhenVisible(staySignedInNO).click();
        }

    }

    public void logIntoCorpChamp(String email, String password) throws InterruptedException {

        getReusableActionsInstance().getWhenVisible(txtEmail).sendKeys(email);
        getReusableActionsInstance().getWhenVisible(btnNext).click();
        getReusableActionsInstance().getWhenVisible(txtPassword).sendKeys(password);
        getReusableActionsInstance().getWhenVisible(corpSignInBtn).click();
        getReusableActionsInstance().getWhenVisible(corpLoginNextBtn).click();
        getReusableActionsInstance().getWhenVisible(corpLoginSkip2faSetup).click();
        if(getReusableActionsInstance().isElementVisible(staySignedInNO, 10)){
            getReusableActionsInstance().getWhenVisible(staySignedInNO).click();
        }
    }

}
