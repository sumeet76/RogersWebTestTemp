package com.rogers.ovr.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChampLoginPage extends BasePageClass {

    //ChampLoginPage
    @FindBy(name = "loginfmt")
    WebElement txtemail;
    @FindBy(id = "idSIButton9")
    WebElement btnext;
    @FindBy(id = "userNameInput")
    WebElement txtusername;
    @FindBy(id = "idSIButton9")
    WebElement signinbutton;
    @FindBy(xpath = "//input[@type='password']")
    WebElement txtPassword;
    @FindBy(id= "idBtn_Back")
    WebElement staySignedInNO;


    //UniLoginPage
    @FindBy(xpath = "//*[@id='dsa-accordion-panel-0-body-0']/div/raap-dealer-code-auth/section/form/ds-form-field/div/div[1]")
    WebElement eledealercode;

    @FindBy(id = "ds-form-input-id-0")
    WebElement txtdealercode;

    @FindBy(xpath = "//*[text()=' Submit ']")
    WebElement btnSubmit;
//-----

    //AccountSearchPage
    //*[@id='dsa-accordion-panel-0-body-0']/div/raap-dealer-code-auth/section/form/ds-form-field/div/div[1]
    @FindBy(xpath = "//input[@value='Account Number or Phone Number']")
    WebElement txtbannumber;
    @FindBy(xpath = "//*[@id='postalcode']")
    WebElement txtpostalcode;

    @FindBy(id = "searchCustomerBtn")
    WebElement btnSearch;


    @FindBy(id = "viewUTEMyRogersLink1")
    WebElement drpdwnPlsSelect;

    @FindBy(xpath = "//*[text()='CONTINUE']")
    WebElement btncontnu_customerAuthen;

    @FindBy(xpath = "//*[text()='Continue'] ")
    WebElement btncontnu;




    @FindBy(xpath = "//app-dashboard/div[2]/div/div[2]/a/span")
    WebElement lnkIgnite;

    @FindBy(xpath = "//span[text()='Use this address']")
    WebElement btnusethisAddrs;


    @FindBy(xpath = "//a[@role='button' and @aria-label='quick-links']")
    WebElement lnkExpandFooter;

    @FindBy(partialLinkText = "LNP Eligibility")
    WebElement lnklnpEligibility;

    @FindBy(xpath="//*[@id='top-right-links']/li/a")
    WebElement lnkfrenchlang ;

    @FindBy(xpath="//*[@id='content_inner']/div/h4")
    WebElement eleVerifyPortEligibity ;


    String sspbtn_xpath = "//span[contains(text(),'SSP Rogers SSP_ENV')]";


    public ChampLoginPage(WebDriver driver) {
        super(driver);
    }

    public void logIntoChamp(String email, String password) throws InterruptedException {

        getReusableActionsInstance().getWhenVisible(txtemail).sendKeys(email);
        getReusableActionsInstance().getWhenVisible(btnext).click();
        getReusableActionsInstance().getWhenVisible(txtPassword).sendKeys(password);
        getReusableActionsInstance().getWhenVisible(signinbutton).click();
        if(getReusableActionsInstance().isElementVisible(staySignedInNO, 10)){
            getReusableActionsInstance().getWhenVisible(staySignedInNO).click();
        }


        Thread.sleep(3000);
    }

}
