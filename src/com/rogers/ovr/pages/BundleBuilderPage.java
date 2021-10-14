package com.rogers.ovr.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 *
 */
public class BundleBuilderPage extends BasePageClass {
    public BundleBuilderPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@role='button' and @aria-label='quick-links']")
    WebElement lnkExpandFooter;

    @FindBy(partialLinkText = "LNP Eligibility")
    WebElement lnklnpEligibility;
    @FindBy(partialLinkText = "Offline Agreement")
    WebElement lnkOfflineAgreement;


    @FindBy(xpath ="//ds-checkbox[1]/label/div[1]")
    WebElement chckbox_tv;

    @FindBy(xpath ="//ds-checkbox[2]/label/div[1]")
    WebElement chckbox_internet ;

    @FindBy(xpath ="//ds-checkbox[3]/label/div[1]")
    WebElement chckbox_smartstream ;

    @FindBy(xpath ="//ds-checkbox[4]/label/div[1]")
    WebElement chckbox_homephone ;

    @FindBy(xpath = "//*[text()='Load offers']")
    WebElement btnloadoffers;



    @FindBy(xpath ="(//span[text()='Add to cart'])[1]")
//    @FindBy(xpath ="(//span[text()='Add to cart'])[1]")
    ///ancestor::button
    WebElement btnAddToCartFirst;

    @FindBy(xpath = "//*[text()='Yes']")
    WebElement btnyes_portinservices;

    @FindBy(xpath = "//*[text()='No']")
    WebElement btnNo_portinservices;

    @FindBy(xpath = "//*[text()='Continue']")
    WebElement btncontinue;
    @FindBy(xpath = "//*[contains(@id,'ds-modal-container')]//button/span/span/span")
    WebElement btncontinueonPointsToMention;



    @FindBy(xpath = "//i[contains(@class,'icon-expand')]")
    List<WebElement> btnsexpand_pointsTomention;



    @FindBy(xpath = "//span[text()='I have reviewed all the Points to Mention with the customer.']")
    WebElement chkbox_pointstomention;


    @FindBy(xpath = "//*[contains(@id,'ds-modal-container')]//button/span/span/span")
    WebElement btncontinue_pointsTomention;


    @FindBy(xpath = "//*[text()='No, they don’t']")
    WebElement btnnotheydonot;

    @FindBy(xpath = "//*[text()='Exchange later']")
    WebElement btnexchangelater;
    @FindBy(xpath = "//div[contains(@class,'exchange-tip')]")
    WebElement btnTip;
    @FindBy(xpath = "//*[contains(text(),'Channel Personalization')]")
    WebElement txtChannelPersonalization;

    @FindBy(xpath ="(//rch-themepack-detail//button/span/span/span)[1]")
    WebElement btnAdd_FirstThemepack;


    @FindBy(xpath ="(//rch-themepack-detail//button/span/span/span)[2]")
    WebElement btnAdd_SecondThemepack;

    @FindBy(xpath = "//*[contains(text(),'I have')]")
    WebElement lnkreviewedthecustomeraddons;

    @FindBy(xpath = "//*[contains(text(),'Details for Home')]")
    WebElement eleDetailsForHome;

    @FindBy(xpath = "//*[contains(text(),'Add to cart')]")
    WebElement btnhomephoneaddonaddtocart;


    //   @FindBy(id = "ds-form-input-id-11")
    // WebElement txtboxAccountnumber;

    // @FindBy(id = "ds-form-input-id-12")
    // WebElement txtboxpin;
    //CLICK CONTINUE
    // @FindBy(id = "ds-form-input-id-23")
    @FindBy(xpath = "//*[text()='Checkout']")
    WebElement btncheckout;

    @FindBy(xpath = "//*[text()='Yes, continue']")
    WebElement btnyescontinue;

    @FindBy(xpath = "//span[text()='Year']/parent::ds-input-label/parent::label/parent::span/following-sibling::select")
    WebElement select_year;


    @FindBy(xpath = "//span[text()='Month']/parent::ds-input-label/parent::label/parent::span/following-sibling::select")
    WebElement select_month;
    @FindBy(id = "(/descendant::rch-dob/child::rch-date-selection/descendant::ds-form-field/descendant::select)[3] or //span[text()='Day']/parent::ds-input-label/parent::label/parent::span/following-sibling::select")
    WebElement select_day;

    @FindBy(id = "ds-form-input-id-3")
    WebElement select_proof;


    @FindBy(xpath = "//*[text()='Generate phone numbers']")
    WebElement btngeneratephonenumbers;

    //span[@translate='global.cta.continue']/ancestor::span
    @FindBy(xpath = "//*[text()='Continue']")
    WebElement btncontinuegeneratephonenumbers;

    @FindBy(xpath = "//*[contains(text(),'View details')]")
    WebElement lnkViewPricing;

    @FindBy(xpath = "//*[@name='View details']")
    WebElement btnInfo;





    public void openFooter() throws InterruptedException {
        getReusableActionsInstance().getWhenVisible(lnkExpandFooter).click();
        Thread.sleep(5000);
    }

    public void openLNPEligibilityPage() throws InterruptedException {
        getReusableActionsInstance().getWhenVisible(lnklnpEligibility).click();
        Thread.sleep(5000);
    }


    public void openFooterAndNavigateToLNPPage() throws InterruptedException {
        openFooter();
        openLNPEligibilityPage();

    }
    public void openFooterAndNavigateToLofflinragreementPage() throws InterruptedException {
        openFooter();
        openLNPEligibilityPage();

    }



    public void selectTv(){

        getReusableActionsInstance().javascriptScrollByVisibleElement(chckbox_tv);
        getReusableActionsInstance().clickWhenVisible(chckbox_tv);
    }
    public void selectInternet(){
        getReusableActionsInstance().javascriptScrollByVisibleElement(chckbox_internet);
        getReusableActionsInstance().clickWhenVisible(chckbox_internet);
        //getReusableActionsInstance().scrollToElementAndClick(chckbox_internet);
    }
    public void selectsmartstream(){
        getReusableActionsInstance().scrollToElementAndClick(chckbox_smartstream);
    }

    public void selecthomephone(){
        getReusableActionsInstance().scrollToElementAndClick(chckbox_homephone);
    }

    public void clickloadoffers() throws InterruptedException {
        getReusableActionsInstance().javascriptScrollByVisibleElement(btnloadoffers);
        getReusableActionsInstance().getWhenVisible(btnloadoffers).click();
        Thread.sleep(10000);
    }

    public void selectFirstAddToCart() throws InterruptedException {

//        getReusableActionsInstance().scrollToElement(btnInfo);
//        Thread.sleep(10000);
        getReusableActionsInstance().scrollToElementAndClick(btnAddToCartFirst);
        getReusableActionsInstance().waitForElementTobeClickable(btnAddToCartFirst,5);
//        getReusableActionsInstance().getWhenReady(btnAddToCartFirst).click();
        getReusableActionsInstance().executeJavaScriptClick(btnAddToCartFirst);
        Thread.sleep(10000);


    }

    public void selectYesPortInService() {

        getReusableActionsInstance().getWhenVisible(btnyes_portinservices).click();
    }

    public void selectNoPortInService() {

        getReusableActionsInstance().getWhenVisible(btnNo_portinservices).click();
    }
    public void scrollAndclickcontinue() throws InterruptedException {
        //  WebDriverWait wait = new WebDriverWait(getDriver(),3000);
        //   Thread.sleep(15000);
        //  wait.until(ExpectedConditions.elementToBeClickable(liveChatIcon));
        //  liveChatIcon.click();
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().scrollToElementAndClick(btncontinue);
        getReusableActionsInstance().executeJavaScriptClick(btncontinue);
        //getReusableActionsInstance().clickWhenReady(btncontinue,120);
        Thread.sleep(10000);

    }

    public void clickContiueWithOutScroll() throws InterruptedException {
        getReusableActionsInstance().getWhenReady(btncontinue,160);
        // Thread.sleep(20000);
        getReusableActionsInstance().executeJavaScriptClick(btncontinue);
        // Thread.sleep(20000);

    }
    public void expandPointsToMentionAndContinue() throws InterruptedException {
        for(WebElement ele:btnsexpand_pointsTomention) {
            getReusableActionsInstance().getWhenVisible(ele).click();
            Thread.sleep(5000);
        }
        getReusableActionsInstance().getWhenVisible(chkbox_pointstomention).click();
        getReusableActionsInstance().clickWhenReady(btncontinueonPointsToMention);


    }


    public void selectNoFor4KTv() {
        getReusableActionsInstance().getWhenVisible(btnnotheydonot).click();

    }
    public void clickExchangeLater() throws InterruptedException {
        getReusableActionsInstance().clickWhenReady(txtChannelPersonalization);

        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        //getReusableActionsInstance().getWhenVisible(btnexchangelater).click();
        getReusableActionsInstance().javascriptScrollByVisibleElement(btnTip);
        getReusableActionsInstance().javascriptScrollByVisibleElement(btnexchangelater);
        Thread.sleep(5000);
        getReusableActionsInstance().javascriptScrollByCoordinates(0,200);
        getReusableActionsInstance().getWhenReady(btnexchangelater).click();

    }
    //  public void clickAddFirstThemePack() throws InterruptedException {
    //  getReusableActionsInstance().javascriptScrollToBottomOfPage();
    //  getReusableActionsInstance().scrollToElement(btnAdd_SecondThemepack);
    //  getReusableActionsInstance().clickWhenReady(btnAdd_FirstThemepack);

    // }
    public void clickAddFirstThemePackAndContinue() throws InterruptedException {
        //clickAddFirstThemePack();
        getReusableActionsInstance().javascriptScrollToTopOfPage();
        Thread.sleep(10000);
        getReusableActionsInstance().scrollToElement(lnkreviewedthecustomeraddons);
        Thread.sleep(5000);
        getReusableActionsInstance().clickWhenReady(lnkreviewedthecustomeraddons);
        Thread.sleep(5000);
        scrollAndclickcontinue();
    }

    public void clickContinueHomePhoneAddon() throws InterruptedException {
        //  getReusableActionsInstance().javascriptScrollToBottomOfPage();
        //btncontinue.getLocation();

        getReusableActionsInstance().scrollToElementAndClick(btnhomephoneaddonaddtocart);
        //getReusableActionsInstance().clickWhenReady(btncontinue,120);

        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        Thread.sleep(10000);
        getReusableActionsInstance().executeJavaScriptClick(btncontinue);



        scrollAndclickcontinue();

    }
    public void clickCheckout() throws InterruptedException {
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        Thread.sleep(10000);
        //getReusableActionsInstance().getWhenReady(btncheckout);
        // getReusableActionsInstance().clickWhenVisible(btncheckout);
        //getReusableActionsInstance().executeJavaScriptClick(btncheckout);
        // getReusableActionsInstance().executeJavaScriptClick(btncheckout);
        WebElement btn=getReusableActionsInstance().getWhenReady(btncheckout,120);
        getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
        getReusableActionsInstance().clickWhenReady(btncheckout,45);

    }
    public void selectyescontinue() throws InterruptedException {
        getReusableActionsInstance().getWhenVisible(btnyescontinue).click();
        Thread.sleep(10000);
    }

   /*public void enterAccountNumberAndPin() throws InterruptedException {
        getReusableActionsInstance().scrollToElement(eleDetailsForHome);
        Thread.sleep(9000);
        getReusableActionsInstance().clickWhenVisible(txtboxAccountnumber);
        Thread.sleep(9000);
        getReusableActionsInstance().getWhenReady(txtboxAccountnumber).sendKeys("12345678");
       getReusableActionsInstance().getWhenReady(txtboxpin).sendKeys("1234");

    }*/

    public  void refreshAndContinue() throws InterruptedException {
        getDriver().navigate().refresh();
        Thread.sleep(15000);
        scrollAndclickcontinue();
    }
    public void enterdateOfBirth(String yearofBirth,String monthofBirth,String dayofBirth) {
        getReusableActionsInstance().selectWhenReadyByVisibleText(select_year,yearofBirth);
        getReusableActionsInstance().selectWhenReady(select_month,Integer.parseInt(monthofBirth));
        getReusableActionsInstance().selectWhenReadyByVisibleText(select_day, dayofBirth);
    }
    public void creditevaluationAndContinue() throws InterruptedException {
        getReusableActionsInstance().executeJavaScriptClick(btncontinue);
        Thread.sleep(2000);

    }

    public void generatePhonenumber() throws InterruptedException {
        //   getReusableActionsInstance().getWhenReady(btngeneratephonenumbers,90);
        //getReusableActionsInstance().scrollToElementAndClick(btngeneratephonenumbers);
        //  getReusableActionsInstance().getWhenReady(btncontinue,120);
        getReusableActionsInstance().executeJavaScriptClick(btngeneratephonenumbers);
        //getReusableActionsInstance().getWhenReady(btngeneratephonenumbers,60).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }
    public void generatephonenumberAndContinue(){
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().executeJavaScriptClick(btncontinuegeneratephonenumbers);
        //Thread.sleep(12000);
        //scrollAndclickcontinue();
        // getReusableActionsInstance().getWhenReady(btncontinuegeneratephonenumbers).sendKeys(Keys.ENTER);
    }
    @FindBy(xpath ="//ds-checkbox[1]/label/div[1]")
    WebElement chckbox_installtion;
    public  void clickchcbxInstallAndContinue() throws InterruptedException {
        //  getReusableActionsInstance().getWhenReady(btncontinuegeneratephonenumbers,120);
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().javascriptScrollByVisibleElement(chckbox_installtion);
        getReusableActionsInstance().clickWhenVisible(chckbox_installtion);
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        //  getReusableActionsInstance().scrollToElementAndClick(chckbox_installtion);
        getReusableActionsInstance().scrollToElementAndClick(btncontinue);
        Thread.sleep(2000);


    }
    public void billingandpaymentoptionscontinue() throws InterruptedException {
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().getWhenReady(btncontinue,120);
        getReusableActionsInstance().executeJavaScriptClick(btncontinue);

        // Thread.sleep(15000);
    }
    public void orderreviewpageandcontinue() throws InterruptedException {
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().getWhenReady(btncontinue,120);
        getReusableActionsInstance().executeJavaScriptClick(btncontinue);
        Thread.sleep(2000);
    }
    @FindBy(id ="ds-checkbox-id-1")
    WebElement chckbox_signinAgreement;
    public  void clickchcbxSigninAgreement() throws InterruptedException {
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().scrollToElementAndClick(chckbox_signinAgreement);
        //getReusableActionsInstance().scrollToElementAndClick(btncontinue);
        Thread.sleep(10000);
    }




}
