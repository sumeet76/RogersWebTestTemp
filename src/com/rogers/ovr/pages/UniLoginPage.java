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

    @FindBy(xpath = "//span[text()='Entrer code de concessionnaire' or text()='Enter dealer code']//ancestor::span[1]//parent::div")
    WebElement eledealercode;

    @FindBy(xpath = "//span[text()='Entrer code de concessionnaire' or text()='Enter dealer code']//ancestor::span[1]//preceding-sibling::input")
    WebElement txtdealercode;

    @FindBy(xpath = "//span[text()=' Soumettre ' or text()=' Submit ']")
    WebElement btnSubmit;
    @FindBy(xpath ="//*[text()=' Accept / Accepter ']" )
    WebElement btnaccept;

    String sspbtn_xpath = "//span[contains(text(),'SSP Rogers SSP_ENV') or contains(text(),'PVS Rogers SSP_ENV')]";

    String fidoSSPBtnXpath = "//span[contains(text(),'SSP Fido SSP_ENV') or contains(text(),'PVS Fido SSP_ENV')]";

    @FindBy(xpath = "//input[@value='Next' or @value='suivante']")
    WebElement corpLoginNextBtn;

    @FindBy(xpath = "//a[contains(text(),'Skip setup') or contains(text(),'sauter')]")
    WebElement corpLoginSkip2faSetup;

    @FindBy(id= "idBtn_Back")
    WebElement staySignedInNO;

    @FindBy(xpath = "//span[contains(text(),'OK')]/ancestor::button")
    WebElement okButton;


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
    public void searchWithDealerCode(){
        String dealerCodeSelectorXpath = "//span[contains(text(),'RCP')]/preceding::ds-radio-button[1]";
        WebElement dealerCodeSelector = getReusableActionsInstance().getWhenReady(By.xpath(dealerCodeSelectorXpath),45);
        getReusableActionsInstance().clickWhenReady(dealerCodeSelector);
        getReusableActionsInstance().getWhenVisible(okButton).click();
    }

    public void selectSSPEnv(String env){
        sspbtn_xpath = sspbtn_xpath.replace("SSP_ENV", env);
        getReusableActionsInstance().getWhenVisible(By.xpath(sspbtn_xpath)).click();


    }

    public void selectSSPEnvAndSwitchWindow(String env){
        sspbtn_xpath = sspbtn_xpath.replace("SSP_ENV", env);
        getReusableActionsInstance().waitForPageLoad();
        getReusableActionsInstance().getWhenVisible(By.xpath(sspbtn_xpath)).click();
        getReusableActionsInstance().switchToNewWindow();


    }

    public void selectCorpSSPEnvAndSwitchWindow(String env){
        sspbtn_xpath = sspbtn_xpath.replace("SSP_ENV", env);
        getReusableActionsInstance().waitForPageLoad();
        getReusableActionsInstance().getWhenVisible(By.xpath(sspbtn_xpath)).click();
        getReusableActionsInstance().switchToNewWindow();

        if(getReusableActionsInstance().isElementVisible(corpLoginNextBtn)){
            getReusableActionsInstance().getWhenVisible(corpLoginNextBtn).click();
            //getReusableActionsInstance().getWhenVisible(corpLoginSkip2faSetup).click();
            if(getReusableActionsInstance().isElementVisible(staySignedInNO, 10)){
                getReusableActionsInstance().getWhenVisible(staySignedInNO).click();
            }
        }

    }

    public void selectFidoSSPEnvAndSwitchWindow(String env){
        fidoSSPBtnXpath = fidoSSPBtnXpath.replace("SSP_ENV", env);
        getReusableActionsInstance().waitForPageLoad();
        getReusableActionsInstance().getWhenVisible(By.xpath(fidoSSPBtnXpath)).click();
        getReusableActionsInstance().switchToNewWindow();


    }


}
