package com.rogers.ovr.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UniLoginPage extends BasePageClass {
    public UniLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='dsa-accordion-panel-0-body-0']/div/raap-dealer-code-auth/section/form/ds-form-field/div/div[1]")
    WebElement eledealercode;

    @FindBy(id = "ds-form-input-id-0")
    WebElement txtdealercode;

    @FindBy(xpath = "//*[text()=' Submit ']")
    WebElement btnSubmit;
    @FindBy(xpath ="//*[text()=' Accept / Accepter ']" )
    WebElement btnaccept;

    String sspbtn_xpath = "//span[contains(text(),'SSP Rogers SSP_ENV')]";

    @FindBy(xpath = "//input[@value='Next']")
    WebElement corpLoginNextBtn;

    @FindBy(xpath = "//a[text()='Skip setup']")
    WebElement corpLoginSkip2faSetup;

    @FindBy(id= "idBtn_Back")
    WebElement staySignedInNO;

    /**
     * Login to unilogin page by entering dealer code
     * @author Vikas.gorla
     */
    public void searchWithDealerCode(String dealerCode) {
        if(getReusableActionsInstance().isElementVisible(btnaccept,5))
        {getReusableActionsInstance().clickWhenVisible(btnaccept);}
        getReusableActionsInstance().getWhenVisible(eledealercode).click();
        getReusableActionsInstance().getWhenVisible(txtdealercode, 30).sendKeys(dealerCode);
        getReusableActionsInstance().getWhenVisible(btnSubmit).click();

    }

    public void selectSSPEnv(String env){
        sspbtn_xpath = sspbtn_xpath.replace("SSP_ENV", env);
        getReusableActionsInstance().getWhenVisible(By.xpath(sspbtn_xpath)).click();


    }

    public void selectSSPEnvAndSwitchWindow(String env){
        sspbtn_xpath = sspbtn_xpath.replace("SSP_ENV", env);
        getReusableActionsInstance().getWhenVisible(By.xpath(sspbtn_xpath)).click();
        getReusableActionsInstance().switchToNewWindow();


    }

    public void selectCorpSSPEnvAndSwitchWindow(String env){
        sspbtn_xpath = sspbtn_xpath.replace("SSP_ENV", env);
        getReusableActionsInstance().getWhenVisible(By.xpath(sspbtn_xpath)).click();
        getReusableActionsInstance().switchToNewWindow();

        if(getReusableActionsInstance().isElementVisible(corpLoginNextBtn)){
            getReusableActionsInstance().getWhenVisible(corpLoginNextBtn).click();
            getReusableActionsInstance().getWhenVisible(corpLoginSkip2faSetup).click();
            if(getReusableActionsInstance().isElementVisible(staySignedInNO, 10)){
                getReusableActionsInstance().getWhenVisible(staySignedInNO).click();
            }
        }

    }

}
