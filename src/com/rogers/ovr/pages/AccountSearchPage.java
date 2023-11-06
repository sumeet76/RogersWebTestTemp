package com.rogers.ovr.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSearchPage extends BasePageClass {
    public AccountSearchPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//input[@value='Account Number or Phone Number' or @value='Numéro de compte ou numéro de téléphone']")
    WebElement txtbannumber;
    @FindBy(xpath = "//input[@value='Postal Code' or @value='Code postal']")
    WebElement txtpostalcode;

    @FindBy(id = "searchCustomerBtn")
    WebElement btnSearch;

    @FindBy(xpath = "//button[contains(text(),'Ok') or contains(text(),'Accepter')]")
    WebElement acceptNoticeBtn;

    @FindBy(xpath = "//table[contains(@class, 'searchResults')]//tr[2]//select")
    WebElement drpdwnPlsSelect;

    @FindBy(xpath = "//*[text()='New Ignite Customer' or text()='Nouveau client Élan']//following::div//select")
    WebElement newCustomerDropDown;

    @FindBy(xpath = "//*[text()='CONTINUE' or text()='CONTINUER']")
    WebElement btncontnu_customerAuthen;

    @FindBy(xpath = "//a[contains(text(),'Français')]")
    WebElement frenchLanguageBtn;

    public void changelanguageToFR(){
        if(getReusableActionsInstance().isElementVisible(acceptNoticeBtn, 10)){
            getReusableActionsInstance().clickWhenReady(acceptNoticeBtn);
        }
        getReusableActionsInstance().clickWhenReady(frenchLanguageBtn);
    }

    public void searchForAccountAndSelectEnv(String banNumber,String postalCode,String env) {
        if(getReusableActionsInstance().isElementVisible(acceptNoticeBtn, 10)){
            getReusableActionsInstance().clickWhenReady(acceptNoticeBtn);
        }
        searchForAccount(banNumber,postalCode);
        selectEnvInAccountSearchPage(env);
    }

    public void searchForAccountAndSelectNAC(String banNumber,String postalCode,String env){
        if(getReusableActionsInstance().isElementVisible(acceptNoticeBtn, 10)){
            getReusableActionsInstance().clickWhenReady(acceptNoticeBtn);
        }
        searchForAccount(banNumber,postalCode);
        getReusableActionsInstance().selectWhenReady(newCustomerDropDown, env, 5);
    }
    public void selectEnvInAccountSearchPage(String env){
        getReusableActionsInstance().selectWhenReady(drpdwnPlsSelect, env);
        getReusableActionsInstance().getWhenVisible(btncontnu_customerAuthen).click();
    }

    public void searchForAccount(String banNumber,String postalCode){
        getReusableActionsInstance().getWhenVisible(txtbannumber).sendKeys(banNumber);
        getReusableActionsInstance().getWhenVisible(txtpostalcode).sendKeys(postalCode);
        getReusableActionsInstance().getWhenVisible(btnSearch).click();

    }

    public void selectNewCustomerEnv(String env){
        if(getReusableActionsInstance().isElementVisible(acceptNoticeBtn, 5)){
            getReusableActionsInstance().clickWhenReady(acceptNoticeBtn);
        }
        getReusableActionsInstance().selectWhenReady(newCustomerDropDown, env, 5);
    }

    public boolean validateAccountSearchPage(){
        return getReusableActionsInstance().isElementVisible(txtbannumber,60) &&
                getReusableActionsInstance().isElementVisible(txtpostalcode,60);
    }

}
