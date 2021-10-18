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


    @FindBy(xpath = "//table[contains(@class, 'searchResults')]//tr[2]//select")
    WebElement drpdwnPlsSelect;

    @FindBy(xpath = "//*[text()='CONTINUE']")
    WebElement btncontnu_customerAuthen;

    public void searchForAccountAndSelectEnv(String banNumber,String postalCode,String env) {
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

}
