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
import utils.FormFiller;

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

    @FindBy(xpath = "//span[text()='Continue']/ancestor::button")
    WebElement btncontinue;
    @FindBy(xpath = "//*[contains(@id,'ds-modal-container')]//button/span/span/span")
    WebElement btncontinueonPointsToMention;

    @FindBy(xpath = "//span[contains(text(),'Professional Install')]")
    WebElement igniteProfessionalInstall;

    @FindBy(xpath = "//span[text()='Continue']")
    WebElement continueInstallation;

    @FindBy(xpath = "//span[text()='Continue']/ancestor::button")
    WebElement continueBillingAndPayment;



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

    @FindBy(xpath = "//span[text()='Oui, continuer' or text()='Yes, continue']/ancestor::button")
    WebElement btnyescontinue;

    @FindBy(xpath = "//span[text()='No, continue']/ancestor::button")
    WebElement btnNoContinue;

    @FindBy(xpath = "//span[text()='Year']/parent::ds-input-label/parent::label/parent::span/following-sibling::select")
    WebElement select_year;


    @FindBy(xpath = "//span[text()='Month']/parent::ds-input-label/parent::label/parent::span/following-sibling::select")
    WebElement select_month;
    @FindBy(xpath = "//span[text()='Day']/parent::ds-input-label/parent::label/parent::span/following-sibling::select")
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

    @FindBy(xpath ="//div[@class='appointment-content']")
    WebElement txtEnroute;

    @FindBy(xpath = "//input[@formcontrolname='enrouteMobileNumber']/ancestor::div[contains(@class,'ds-formField__inputContainer')]")
    WebElement txtContainerMobile;

    @FindBy(xpath = "//input[@formcontrolname='enrouteEmail']/ancestor::div[contains(@class,'ds-formField__inputContainer')]")
    WebElement txtContainerEmail;

    @FindBy(xpath ="//input[@formcontrolname='enrouteMobileNumber']")
    WebElement txtMobielNumber;

    @FindBy(xpath ="//input[@formcontrolname='enrouteEmail']")
    WebElement txtEmail;

    @FindBy(xpath ="//input[@id='26']/ancestor::label[contains(@class,'ds-radioLabel')]//div[@class='ds-radioButton__outerCircle my-12']")
    WebElement rdoTechInstallSlot;

    @FindBy(xpath = "//div[text()='Customer current']//following-sibling::div")
    WebElement currentPlanSection;

    @FindBy(xpath = "//span[@class='ds-icon rds-icon-close']")
    WebElement popupCloseBtn;

    @FindBy(xpath = "//h1[contains(text(),'Billing and Payment')]")
    WebElement billingAndPaymentH1;

    @FindBy(xpath = "//h3[text()='Payment Options']//parent::div//following-sibling::div//child::select[1]")
    WebElement drpSelectBillingPaymentMethod;

    @FindBy(xpath = "//span[contains(text(),'Select the services') or contains(text(),'Sélectionnez les services demandés par le client')]")
    WebElement lblSelectServiceBundles;


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
        getReusableActionsInstance().javascriptScrollByVisibleElement(btncontinue);
        getReusableActionsInstance().clickWhenReady(btncontinue);

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
            //Thread.sleep(5000);
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

        getReusableActionsInstance().waitForElementStaleness(btnyescontinue, 5);
        getReusableActionsInstance().moveToElementAndClick(btnyescontinue, 3);
        Thread.sleep(3000);
        if(getReusableActionsInstance().isElementVisible(popupCloseBtn)){
            getReusableActionsInstance().clickWhenReady(popupCloseBtn, 3);
            getReusableActionsInstance().clickWhenReady(btncheckout, 3);
            //Click "Yes, Continue again"
            getReusableActionsInstance().waitForElementTobeClickable(btnyescontinue, 5);
            getReusableActionsInstance().moveToElementAndClick(btnyescontinue, 3);
        }

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
    public void enterdateOfBirth(String yearofBirth,String monthofBirth,String dayofBirth) throws InterruptedException {
        getReusableActionsInstance().selectWhenReadyByVisibleText(select_year,yearofBirth);
        getReusableActionsInstance().selectWhenReady(select_month,Integer.parseInt(monthofBirth));
        getReusableActionsInstance().selectWhenReadyByVisibleText(select_day, dayofBirth);

    }

    public void selectExpressProInstall() {
        getReusableActionsInstance().waitForElementVisibility(igniteProfessionalInstall, 60);
        getReusableActionsInstance().javascriptScrollByVisibleElement(igniteProfessionalInstall);
        getReusableActionsInstance().executeJavaScriptClick(igniteProfessionalInstall);
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

    /**
     * Set dynamic mobile number on the Order Summary Page
     * @author Sameer.Ahuja
     */
    public void setMobileNumber() {
        String strPhoneNumber = FormFiller.generatePhoneNumber();
        String strEmail = FormFiller.generateEmail();
        if(getReusableActionsInstance().isElementVisible(txtEnroute,90)) {
            getReusableActionsInstance().javascriptScrollToBottomOfPage();
            getReusableActionsInstance().waitForElementVisibility(txtContainerMobile, 20);
            getReusableActionsInstance().getWhenReady(txtContainerMobile, 10).click();
            getReusableActionsInstance().getWhenReady(txtMobielNumber, 10).clear();
            getReusableActionsInstance().getWhenReady(txtMobielNumber, 3).sendKeys(strPhoneNumber);
            getReusableActionsInstance().waitForElementVisibility(txtContainerEmail, 30);
            getReusableActionsInstance().getWhenReady(txtContainerEmail, 10).click();
            getReusableActionsInstance().getWhenReady(txtEmail, 10).clear();
            getReusableActionsInstance().getWhenReady(txtEmail, 10).sendKeys(strEmail);
        }
    }

    /**
     * Select the slot from the available list of slots from installation page
     * @author Sameer.Ahuja
     */
    public void clkTechInstallSlot() {
        getReusableActionsInstance().waitForElementVisibility(rdoTechInstallSlot, 180);
        getReusableActionsInstance().javascriptScrollToMiddleOfPage();
        getReusableActionsInstance().getWhenReady(rdoTechInstallSlot, 180).click();
    }

    public void clkContinueInstallation() {
        getReusableActionsInstance().clickWhenReady(continueInstallation);
    }

    public boolean verifyBillingAndPaymentPage(){
        return getReusableActionsInstance().isElementVisible(billingAndPaymentH1, 60);
    }

    public boolean verifyBundleBuilderPage(){
        return getReusableActionsInstance().isElementVisible(lblSelectServiceBundles, 5);
    }

    public void clkContinueBillingAndPayment() throws InterruptedException {
        if(getReusableActionsInstance().isElementVisible(billingAndPaymentH1, 60)){
            getReusableActionsInstance().javascriptScrollByVisibleElement(continueBillingAndPayment);
            getReusableActionsInstance().clickWhenReady(continueBillingAndPayment);
        }


        if(getReusableActionsInstance().isElementVisible(popupCloseBtn)){
            getReusableActionsInstance().clickWhenReady(popupCloseBtn, 3);
            getReusableActionsInstance().clickWhenReady(continueBillingAndPayment, 3);

        }
    }
    public void setDrpSelectBillingPaymentMethod(String paymentMethod){
        getReusableActionsInstance().selectWhenReadyByVisibleText(drpSelectBillingPaymentMethod, paymentMethod);
    }

    public boolean verifyCustomerCurrentPlan(){
        return getReusableActionsInstance().isElementVisible(currentPlanSection, 5);
    }
}
