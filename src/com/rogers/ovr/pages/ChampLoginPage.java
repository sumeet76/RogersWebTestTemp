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

    @FindBy(xpath = "//*[contains(text(),'Sign in') or contains(text(),'identifier') ]")
    WebElement corpSignInBtn;

    @FindBy(xpath = "//input[@value='Next' or @value='suivante']")
    WebElement corpLoginNextBtn;

    @FindBy(xpath = "//a[contains(text(),'Skip setup') or contains(text(),'sauter')]")
    WebElement corpLoginSkip2faSetup;

    @FindBy(xpath ="//*[text()=' Accept / Accepter ']" )
    WebElement btnaccept;

    @FindBy(xpath = "//a[contains(text(),'FR')]")
    WebElement frenchLanguageBtn;


    public ChampLoginPage(WebDriver driver) {
        super(driver);
    }

    public void logIntoChamp(String email, String password) {
        getReusableActionsInstance().getWhenVisible(txtEmail).sendKeys(email);
        getReusableActionsInstance().getWhenVisible(btnNext).click();
        getReusableActionsInstance().waitForElementStaleness(txtPassword, 5);
        getReusableActionsInstance().getWhenVisible(txtPassword).sendKeys(password);
        getReusableActionsInstance().getWhenVisible(signInButton).click();
        if(getReusableActionsInstance().isElementVisible(staySignedInNO, 10)){
            getReusableActionsInstance().getWhenVisible(staySignedInNO).click();
        }

    }

    public void logIntoCorpChamp(String email, String password) {

        getReusableActionsInstance().getWhenVisible(txtEmail).sendKeys(email);
        getReusableActionsInstance().getWhenVisible(btnNext).click();
        getReusableActionsInstance().waitForElementStaleness(txtPassword, 15);
        getReusableActionsInstance().getWhenVisible(txtPassword).sendKeys(password);
        getReusableActionsInstance().getWhenVisible(signInButton).click();
        //Skip the 2fa popup if presented
        if(getReusableActionsInstance().isElementVisible(corpLoginNextBtn)){
            getReusableActionsInstance().getWhenVisible(corpLoginNextBtn).click();
            //getReusableActionsInstance().getWhenVisible(corpLoginSkip2faSetup).click();
            if(getReusableActionsInstance().isElementVisible(staySignedInNO, 10)){
                getReusableActionsInstance().getWhenVisible(staySignedInNO).click();
            }
        }
        //Skip the stay signed in prompt
        if(getReusableActionsInstance().isElementVisible(staySignedInNO, 10)){
            getReusableActionsInstance().getWhenVisible(staySignedInNO).click();
        }

    }

    public void changeChampToFR(){
        if(getReusableActionsInstance().isElementVisible(btnaccept,5))
        {getReusableActionsInstance().clickWhenVisible(btnaccept);}
        getReusableActionsInstance().clickWhenReady(frenchLanguageBtn);
    }

}
