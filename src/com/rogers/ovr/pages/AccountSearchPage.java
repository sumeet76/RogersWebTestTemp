package com.rogers.ovr.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSearchPage extends BasePageClass {
    public AccountSearchPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//input[@value='Account Number or Phone Number']")
    WebElement txtbannumber;
    @FindBy(xpath = "//*[@id='postalcode']")
    WebElement txtpostalcode;

    @FindBy(id = "searchCustomerBtn")
    WebElement btnSearch;

    @FindBy(xpath = "//button[contains(text(),'Accept')]")
    WebElement acceptNoticeBtn;


    @FindBy(xpath = "//table[contains(@class, 'searchResults')]//tr[2]//select")
    WebElement drpdwnPlsSelect;

    @FindBy(xpath = "//*[text()='New Ignite Customer']//following::div//select")
    WebElement newCustomerDropDown;

    @FindBy(xpath = "//*[text()='CONTINUE']")
    WebElement btncontnu_customerAuthen;

    public void searchForAccountAndSelectEnv(String banNumber,String postalCode,String env) {
        if(getReusableActionsInstance().isElementVisible(acceptNoticeBtn, 5)){
            getReusableActionsInstance().clickWhenReady(acceptNoticeBtn);
        }
        searchForAccount(banNumber,postalCode);
        selectEnvInAccntSearchPage(env);
    }
    public void selectEnvInAccntSearchPage(String env){
        getReusableActionsInstance().selectWhenReady(drpdwnPlsSelect, env);
        getReusableActionsInstance().getWhenVisible(btncontnu_customerAuthen).click();
    }

    public void searchForAccount(String banNumber,String postalCode){
        getReusableActionsInstance().getWhenVisible(txtbannumber).sendKeys(banNumber);
        getReusableActionsInstance().getWhenVisible(txtpostalcode).sendKeys(postalCode);
        getReusableActionsInstance().getWhenVisible(btnSearch).click();

    }

    public void selectNewCustomerEnv(String env){
        getReusableActionsInstance().selectWhenReady(newCustomerDropDown, env, 5);
    }

}
