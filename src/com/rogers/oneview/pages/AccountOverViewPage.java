package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class AccountOverViewPage extends BasePageClass {

    public AccountOverViewPage(WebDriver driver) {
        super(driver);
    }

    @FindAll({
            @FindBy(xpath = "//agent-notifications[contains(@state,'autopop')]/div[contains(@class,'blocker')]"),
            @FindBy(xpath = "//div[contains(@class,'blocker ng')]"),
            @FindBy(xpath = "//agent-notifications/div[contains(@class,'blocker')]"),
    })
    WebElement skipNotification;
    @FindBy(xpath = "//span[contains(text(), 'View offers') or contains(text(), 'Voir les offres')]")
    WebElement viewOffers;

    @FindBy(xpath = "//button[@aria-label='Select']")
    WebElement selectRecommendedOffer;

    @FindBy(xpath = "(//span[@translate='global.cta.select'])[1]")
    WebElement selectExclusiveOffer;

    @FindBy(xpath = "//span[contains(text(),'The customer authorizes') or contains(text(),'Le client autorise Rogers à obtenir des renseignements')]/parent::div/ancestor::ds-checkbox//div[1]")
    WebElement authorizecheckbox;

    @FindBy(xpath = "//h1[@translate='global.label.reviewYourOrder']/parent::div")
    WebElement ReviewYourOrder;

    @FindBy(xpath = "//rch-popup-modal/descendant::span[text()='Yes' or text()='Oui']/ancestor::button")
    WebElement yesPortInServices;

    @FindBy(xpath = "//span[contains(text(), 'Continue')]")
    WebElement ContinueChangePackage;

    @FindBy(xpath = "//span[text()='Yes, they do' or text()='Oui, il en a un']/ancestor::button")
    WebElement yesFor4K;

    @FindBy(xpath = "//*[@id=\"ds-modal-container-7\"]/rch-tv4k-modal/ds-modal/div[2]/div[2]/div[2]/div/button")
    WebElement fourKContinue;

    @FindBy(xpath = "//button[@rchtrackclickevent='exchangeLater']")
    WebElement ExchangeLaterBtn;

    @FindBy(xpath = "//h4[@translate='global.selfServe.reviewConfirm.previousPackage']")
    WebElement previousPackage;

    @FindBy(xpath = "(//span[@translate='global.selfServe.reviewConfirm.tvDetails'])[1]")
    WebElement tvDetails;

    @FindBy(xpath = "//h4[@translate='global.selfServe.reviewConfirm.newPackage']")
    WebElement newPackage;

    @FindBy(xpath = "(//span[@translate='global.selfServe.reviewConfirm.tvDetails'])[2]")
    WebElement NewtvDetails;

    @FindBy(xpath = "//span[@translate='global.cta.submit']")
    WebElement changeCallerNameSubmit;

    @FindBy(xpath = "//span[contains(text(),' Box 2')]")
    WebElement displayedMulitplsSTB;

    @FindBy(xpath = "//span[@translate='global.dashboard.tv.includedWithOnlyDefaultBundle']")
    WebElement IgniteTVBox;

    @FindBy(xpath = "//div[@class='customer-address flyout-address account-overview-padding']/span[contains(text(),'ON')]")
    WebElement Province;

    @FindBy(xpath = "//a[@class='oneview-icon-tick tick-css expanded']")
    WebElement arrowDownAccountOverview;

    @FindBy(xpath = "//t[text()='TV']/following::span[contains(text(),'Plan Details') or contains(text(),'Plan et détails')]")
    WebElement btnTVBadge;

    @FindBy(xpath = "//a[contains(text(),' Billing ')]")
    WebElement Billinglink;

    @FindBy(xpath = "//a[contains(text(),'Profile')]")
    WebElement ProfileLink;

    @FindBy(xpath = "//span[@class='rui-icon-arrow-down hide-details' and @role='button']")
    WebElement BillingDropDownbutton;

    @FindBy(xpath = "//span[contains(text(),'Change to paper billing')]")
    WebElement ChangetoPaperBilling;

    @FindBy(xpath = "//button[@class='lg red font-s btn-continue']")
    WebElement ConfirmBillingChange;

    @FindBy(xpath = "//span[contains(text(),'Change to online billing')]")
    WebElement ChangetoOnlineBilling;

    @FindBy(xpath = "//t[contains(text(),'Set up automatic payment')]")
    WebElement SlctAutopaymntlink;

    @FindBy(xpath = "//ng-component[@class='ng-star-inserted']/descendant::div[@tabindex='0']")
    WebElement PymntmethodBllngPage;

    @FindBy(xpath = "//input[@id='digitalFrontLine']")
    WebElement DtlFrntlnrdiobtn;

    @FindBy(xpath = "//select[@formcontrolname='month']")
    WebElement ExpirymonthBlngPopup;

    @FindBy(xpath = "//select[@formcontrolname='year']")
    WebElement ExpiryYearBlngPopup;

    @FindBy(xpath = "//input[@id='tokenNumber' and @type='text']")
    WebElement TokenField;

    @FindBy(xpath = "//input[@id='security-code']")
    WebElement SecurityCodeField;

    @FindBy(xpath = "//a[contains(text(),'Learn more about Wall-to-Wall Wi-Fi')]")
    WebElement LearnMoreAboutWallWiFiLink;

    @FindBy(xpath = "//t[contains(text(),'Continue')]/ancestor::button")
    WebElement CntinuebtnBillingpagepopup;

    @FindBy(xpath = "//h2/t[contains(text(),'MyRogers profile')]")
    WebElement ProfilePageHeader;

    @FindBy(xpath = "//t[contains(text(),'Make a payment')]")
    WebElement MakePaymentbtn;

    @FindBy(xpath = "//t[text()='Ignite Internet' or text()='Élan Internet']/following::span[contains(text(),'Plan and Usage') or contains(text(),'Détails du plan et de')]")
    WebElement btnInternetBadge;

    @FindAll({
            @FindBy(xpath = "//t[text()='Home Phone']/following::span[contains(text(),'Plan Details') or contains(text(),'Plan et détails')]"),
            @FindBy(xpath = "//span[@class='icon rui-icon-home-phone']"),
            @FindBy(xpath = "//span[@class='ds-icon d-inline-flex rds-icon-home-phone']/ancestor::div[@class='tile-border d-flex flex-column']/descendant::span[@class='ds-link__copy']/parent::span")
    })
    WebElement btnHomePhoneBadge;

    //	@FindBy(xpath = "//t[contains(text(),'Ignite')]/ancestor::a")})
//	@FindBy(xpath = "//div[@translate='myaccoverview_get_ignite_bundle']/ancestor::div[@role='button']"),
//	@FindAll({

    @FindBy(xpath = "//t[text()='TV']/following::span[contains(text(),'Plan Details') or contains(text(),'Plan et détails')]")
    WebElement btnGetIgniteTVBadge;

    @FindBy(xpath="//t[contains(text(),'Ignite')]")
    WebElement btnGetIgniteBadge;

    @FindBy(xpath = "//*[@translate='ute.rogers.account.balance.total_balance' or text()='Total balance' or text()='Total du solde'  or text()='Total Balance']")
    WebElement infoBalanceLable;

    //ToDo Change the index
    //@FindBy(xpath = "//div[@class='oneview-dialog']//button")
    @FindBy(xpath = "(//app-dialog//i[@class='close rui-icon-mobile-menu-exit'])[2]")
    WebElement btnOneViewDataManagerDialogue;

    @FindBy(xpath = "//div[@class='oneview-dialog']//button")
    WebElement btnOkOneViewDialogue;

    @FindAll({
            @FindBy(xpath = "//input[@class='hup-input']"),
            @FindBy(xpath = "//input[@name='dealerCode']")
    })
    WebElement delearCodeOneViewDialogue;

    @FindBy(xpath = "//button[@class='hup-button red']")
    WebElement btnSubmitOneViewDialogue;

    @FindAll({
            @FindBy(xpath = "//div[contains(@class,'other-services')]//t[contains(.,'Wireless') or contains(.,'Sans-fil')]"),
            @FindBy(xpath = "//t[contains(text(),'Add new wireless line')]"),
            @FindBy(xpath = "//t[contains(text(),'Add a line')]")
    })
    WebElement addNewWirelessLineButton;

    @FindAll({
            @FindBy(xpath = "//button[contains(text(),'View all alerts') or contains(text(), 'Voir toutes les alertes')]"),
            @FindBy(xpath = "//div[@class='agent-notifications-popup ng-star-inserted']")
    })
    WebElement viewAllAlerts;

    @FindBy(xpath = "//img[@class='bell-icon'] | //a[@class='agent-notifications-icon']")
    WebElement notificationBell;

    @FindBy(xpath = "//div[@class='button-set set-left ng-star-inserted']/descendant::span[contains(text(),'TV')]")
    WebElement changeTVBundle;

    @FindBy(xpath = "//t[text()='Add Ignite' or text()='Obtenez la Élan']")
    WebElement migrateToIgnite;

    @FindBy(xpath = "//h3[text()='Production']/ancestor::ds-selection-checkbox")
    WebElement envProduction;

    @FindBy(xpath = "//div[@class='proceed-button']/button")
    WebElement btnProceed;

    @FindBy(xpath = "//span[contains(text(),'OK')]")
    WebElement OK;

    @FindBy(xpath = "//h2[contains(text(),'Channels') or contains(text(), 'Chaînes')]")
    WebElement tvOrChannelHeader;

//    @FindBy(xpath = "//h2[@ng-reflect-translate='global.label.noOfChannels']")
//    WebElement tvOrChannelHeader;

    @FindBy(xpath = "//h3[@translate='global.dashboard.tv.ManageTabTitle']")
    WebElement customerFollowingHeader;

    @FindBy(xpath = "//a[@id='language-changed']")
    WebElement linkFrench;

    @FindBy(xpath="//input[@id='ds-radio-input-id-2']//parent::label//div")
    WebElement secondAddress;

    @FindBy(xpath="//p[@translate='global.modals.serviceability.bundleToChange']")
    WebElement bundleSection;

    @FindBy(xpath="//ds-radio-button[@ng-reflect-value='tv']//div")
    WebElement tvCheckbox;

    @FindBy(xpath = "(//ds-radio-button[@class='ds-radioButton'])[2]")
    WebElement selAddressRadioButton;

    @FindBy(xpath="//span[text()='Continue']")
    WebElement continueButton;

    @FindBy(xpath="//ds-modal[@identifier='planChangeDateModal']/descendant::span[@translate='global.cta.continue']")
    WebElement SelectChangeContinue;

    @FindBy(xpath = "//span[@class='dealer-code']")
    WebElement lnkDealerCode;

    @FindBy(xpath = "//input[@id='impersonate-code']")
    WebElement inputDealerCode;

    @FindBy(xpath = "(//span[@ng-bind-html='message.message'])[2]")
    WebElement requiredmessage;

    @FindBy(xpath = "(//span[@class='bb-amount ng-scope amount-xl'])[2]")
    WebElement billamount;

    @FindBy(xpath = "//div[@ng-class='message.textClass']")
    WebElement welcometext;

    @FindBy(xpath = "//div[@ng-bind-html='$ctrl.data.header.message']")
    WebElement billmessage;

    @FindBy(xpath = "//div[@class='product-header']")
    WebElement product;

    @FindBy(xpath = "//div[@id='bb-bs-bill-messages']/child::div/child::div/h2[text()='Account Messages']")
    WebElement accountMessages;

    @FindBy(xpath ="//iframe[contains(@class,'bill')]")
    WebElement iframewindow;

    /**
     * Validate if either TV or channel header is visible
     *
     * @author aditi.jain
     */
    public boolean verifyTVOrChannelHeader() {
        return getReusableActionsInstance().isElementVisible(tvOrChannelHeader, 90);
    }

    /**
     * Validate if customer following header is visible
     *
     * @author aditi.jain
     */
    public boolean verifyCustomerFollowingsHeader() {
        WebElement bTn = getReusableActionsInstance().getWhenReady(customerFollowingHeader, 60);
        getReusableActionsInstance().javascriptScrollByCoordinates(0, bTn.getLocation().y - 300);
        return getReusableActionsInstance().isElementVisible(customerFollowingHeader, 60);
    }

    /**
     * To skip notification panel with a bell icon
     *
     * @author sidhartha.vadrevu
     */
    public void setSkipNotification() {
        getReusableActionsInstance().clickIfAvailable(skipNotification, 30);
    }

    /**
     * This method clicks on wireless link to add a new wireless line
     *
     * @author praveen.kumar7
     */
    public void clkWirelessLink() {
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().staticWait(2000);
        getReusableActionsInstance().executeJavaScriptClick(getReusableActionsInstance().getWhenReady(By.xpath("//t[contains(.,'Wireless') or contains(.,'Sans-fil')]/ancestor::a[contains(@class,'nac-link')]"), 20));
    }

    /**
     * To enter dealer code in dealer code dialogue box
     *
     * @author Saurav.Goyal
     */
    public void enterDealerCodeDialogue() {
        if (getReusableActionsInstance().isElementVisible(delearCodeOneViewDialogue)) {
            getReusableActionsInstance().getWhenReady(delearCodeOneViewDialogue, 20).sendKeys("0MAAA");
            getReusableActionsInstance().clickIfAvailable(btnSubmitOneViewDialogue, 10);
        }
    }

    public void clickAccountOverview(){
        getReusableActionsInstance().getWhenReady(arrowDownAccountOverview, 20).click();
    }

    /**
     * Click notification bell if any notificaiton is present
     *
     * @author aditi.jain
     */
    public void clickNotificationIfPresent() {

        if (getReusableActionsInstance().isElementVisible(viewAllAlerts, 60)) {
            getReusableActionsInstance().waitForElementVisibility(notificationBell, 60);
            getReusableActionsInstance().executeJavaScriptClick(notificationBell);
        }
    }

    /* To Select the second address in the serviceability modal if available
     *  @suganya p
     */
    public void clickSecondAddressIfPresent()
    {

        if (verifyBundleChangeSection());
        else
        {
            getReusableActionsInstance().isElementVisible(secondAddress,10);
            getReusableActionsInstance().clickIfAvailable(secondAddress);
        }
    }
    /**
     * Selects the Get Ignite TV Badge on the account dashbaord
     *
     * @author aditi.jain
     */
    public void clickIgniteTVBadge() {

        if (getReusableActionsInstance().isElementVisible(viewAllAlerts)) {
            getReusableActionsInstance().clickWhenReady(skipNotification);
        }
        if (getReusableActionsInstance().isElementVisible(btnGetIgniteTVBadge, 60)) {
            getReusableActionsInstance().javascriptScrollToBottomOfPage();
            getReusableActionsInstance().clickWhenReady(btnGetIgniteTVBadge);
        }
    }

    /**
     * This method clicks on Ignite link
     *
     * @author aditi.jain
     */
    public void clickIgnite() {
        getReusableActionsInstance().staticWait(5000);
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().executeJavaScriptClick(migrateToIgnite);
       if (getReusableActionsInstance().isElementVisible(OK, 30)) {
            getReusableActionsInstance().executeJavaScriptClick(OK);
        }
    }

    /**
     * Select the environment as Production
     * @author Jarmanjeet.Batth
     */
    public void selectProduction(){
        getReusableActionsInstance().clickWhenReady(envProduction);
    }

    /**
     * Select the environment as Production
     * @author Jarmanjeet.Batth
     */
    public void clickProceed(){
        getReusableActionsInstance().waitForElementVisibility(btnProceed, 20);
        getReusableActionsInstance().clickWhenReady(btnProceed);
        if (getReusableActionsInstance().isElementVisible(OK, 30)) {
            getReusableActionsInstance().executeJavaScriptClick(OK);
        }
    }

    /**
     * Change TV Bundle, if present
     *
     * @author Aditi.jain
     */
    public void selectBundleChangeIfPresent() {
        getReusableActionsInstance().clickIfAvailable(changeTVBundle, 45);
    }

    /**
     * To click on submit button in dealer code dialogue box
     *
     * @author Saurav.Goyal
     */
    public void clkSubmitBtnDealerCodeDialogue() {
        getReusableActionsInstance().clickIfAvailable(btnSubmitOneViewDialogue, 30);
    }

    /**
     * To click on Assign data manager in the dialogue box
     *
     * @author Saurav.Goyal
     */
    public void clkCloseBtnAssignDataManager() {
        getReusableActionsInstance().staticWait(5000);
        getReusableActionsInstance().clickIfAvailable(btnOneViewDataManagerDialogue);
    }

    /**
     * Selects the Internet Badge on the account dashbaord
     *
     * @author chinnarao.vattam
     */
    public void selectInternetBadage() {
        if (getReusableActionsInstance().isElementVisible(delearCodeOneViewDialogue, 20)) {
            getReusableActionsInstance().getWhenReady(delearCodeOneViewDialogue, 50).sendKeys("0MAAA");
            getReusableActionsInstance().clickIfAvailable(btnSubmitOneViewDialogue, 30);
        }
        if (getReusableActionsInstance().isElementVisible(skipNotification, 20)) {
            getReusableActionsInstance().clickWhenReady(skipNotification);
        }
        WebElement btn = getReusableActionsInstance().getWhenReady(btnInternetBadge, 40);
        getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
        getReusableActionsInstance().clickWhenReady(btnInternetBadge, 45);
    }



    /**
     * Selects the Home Phone Badge on the account dashbaord
     *
     * @author chinnarao.vattam
     */
    public void selectHomePhoneBadge() {

        if (getReusableActionsInstance().isElementVisible(skipNotification, 10)) {
            getReusableActionsInstance().clickWhenReady(skipNotification);
        }

        WebElement btn = getReusableActionsInstance().getWhenReady(btnHomePhoneBadge, 120);
        getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
        getReusableActionsInstance().clickWhenReady(btnHomePhoneBadge, 45);
    }

    /**
     * Selects the TV Badge on the account dashbaord
     *
     * @author Chinnarao.Vattam
     */
    public void selectTVBadage() {
        if (getReusableActionsInstance().isElementVisible(delearCodeOneViewDialogue, 30)) {
            getReusableActionsInstance().getWhenReady(delearCodeOneViewDialogue, 50).sendKeys("0MAAA");
            getReusableActionsInstance().clickIfAvailable(btnSubmitOneViewDialogue, 30);
        }
        if (getReusableActionsInstance().isElementVisible(viewAllAlerts, 10)) {
            getReusableActionsInstance().clickWhenReady(skipNotification);
        }
        WebElement btn = getReusableActionsInstance().getWhenReady(btnTVBadge, 120);
        getReusableActionsInstance().javascriptScrollByCoordinates(0, btn.getLocation().y - 300);
        getReusableActionsInstance().clickWhenReady(btnTVBadge, 45);
    }

    /**
     * Selects the Get Ignite TV Badge on the account dashbaord
     *
     * @author Chinnarao.Vattam
     */
    public void selectGetIgniteTVBadge() {
        if (getReusableActionsInstance().isElementVisible(delearCodeOneViewDialogue, 30)) {
            getReusableActionsInstance().getWhenReady(delearCodeOneViewDialogue, 50).sendKeys("0MAAA");
            getReusableActionsInstance().clickIfAvailable(btnSubmitOneViewDialogue, 30);
        }
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().staticWait(5000);
        getReusableActionsInstance().getWhenReady(btnGetIgniteBadge, 50).click();
    }

    /**
     * Validates and clicks on the Wireless Phone Number
     *
     * @param strCTN - Phone Number
     * @return - true if Phone Number found; else false
     * @author Saurav.Goyal
     */
    public boolean verifyAndClickWirelessCTN(String strCTN) {
        strCTN = strCTN.replace("-", "").replace(" ", "");
        strCTN = "(" + strCTN.substring(0, 3) + ") " + strCTN.substring(3, 6) + "-" + strCTN.subSequence(6, 10);
        String strCTNXpath = "//*[contains(text(),'" + strCTN + "')]";
        WebElement subNumber = getDriver().findElement(By.xpath("//*[contains(text(),'" + strCTN + "')]"));
        getReusableActionsInstance().clickIfAvailable(By.xpath("//div[@class='rep-notifications permitted']//div[@class='blocker']"));
        if (getReusableActionsInstance().isElementVisible(By.xpath(strCTNXpath))) {
            getReusableActionsInstance().javascriptScrollToBottomOfPage();
            //getReusableActionsInstance().clickWhenReady(By.xpath(strCTNXpath), 120);
            getReusableActionsInstance().executeJavaScriptClick(subNumber);
            return true;
        } else if (verifyAndClickShareEverythingCTN(strCTN)) {
            return true;
        }
        return false;
    }

    /**
     * Validates and clicks on the Wireless Phone Number under Share Everything
     *
     * @param strCTN - Phone Number
     * @return - true if Phone Number found; else false
     * @author Saurav.Goyal
     */
    public boolean verifyAndClickShareEverythingCTN(String strCTN) {
        strCTN = strCTN.replace("-", "").replace(" ", "");
        strCTN = strCTN.substring(0, 3) + "-" + strCTN.substring(3, 6) + "-" + strCTN.subSequence(6, 10);
        String strCTNXpath = "//div[contains(@class,'sharedWireless')]//div[contains(text(),'" + strCTN + "')]/parent::div/button";
        if (getReusableActionsInstance().isElementVisible(By.xpath(strCTNXpath))) {
            getReusableActionsInstance().executeJavaScriptClick(getDriver().findElement(By.xpath(strCTNXpath)));
            return true;
        }
        return false;
    }

    /**
     * To verify the successful login
     *
     * @return true if the balance label is present ; else false
     * @author chinnarao.vattam
     */
    public boolean verifySuccessfulLogin() {
        return getReusableActionsInstance().isElementVisible(infoBalanceLable, 60);
    }

    /*
     * To verify the bundle change section in the serviceability modal
     * @author suganya p
     */
    public boolean verifyBundleChangeSection()
    {
        return getReusableActionsInstance().isElementVisible(bundleSection,20);
    }
    /**
     * Selects the Add a Wireless Line Button on the account dashbaord
     *
     * @author Sidhartha.Vadrevu
     */
    public void selectAddAWirelessLineButton() {
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().waitForElementVisibility(addNewWirelessLineButton);
        getReusableActionsInstance().executeJavaScriptClick(addNewWirelessLineButton);
    }

    /*
     * This method verifies if the dealer code is related to Fido, If so it changes it to Rogers dealer code
     * @author praveen.kumar7
     */
    public void changeFidoDealerToRogers() {
        if(getReusableActionsInstance().getWhenReady(lnkDealerCode).getText().trim().startsWith("F")) {
            getReusableActionsInstance().executeJavaScriptClick(lnkDealerCode);
            getReusableActionsInstance().clickWhenReady(inputDealerCode);
            getReusableActionsInstance().getWhenReady(inputDealerCode).sendKeys("0MAAA");
            getReusableActionsInstance().clickWhenReady(By.xpath("//input[@id='impersonate-code']/following::button[1]"));
            getReusableActionsInstance().waitForElementInvisibilityNOException(inputDealerCode,10);
            getReusableActionsInstance().staticWait(2000);
        }
    }

    /**
     * This method clicks on French link at the bottom of the screen
     *
     * @author praveen.kumar7
     */
    public void setLanguageFrench() {
        getReusableActionsInstance().waitForElementVisibility(linkFrench,60);
        //getReusableActionsInstance().clickWhenReady(infoBalanceLable);
        getReusableActionsInstance().executeJavaScriptClick(linkFrench);
    }

    /*
     * To select the tv check box in serviceability modal
     * @author suganya p
     */
    public void clickTVCheckbox()
    {
        getReusableActionsInstance().executeJavaScriptClick(tvCheckbox);
    }

    /*To select the address in the serviceability modal
     * @author Jarmanjeet.Batth
     */
    public void selectAddress(){
        getReusableActionsInstance().waitForElementVisibility(selAddressRadioButton, 20);
        getReusableActionsInstance().clickWhenReady(selAddressRadioButton);
    }

    /*To click continue in the serviceabilty modal
     * @author aditi.jain
     */

    public void clickContinue()
    {
        getReusableActionsInstance().waitForElementVisibility(continueButton);
        getReusableActionsInstance().executeJavaScriptClick(continueButton);
    }
    /*To click continue in the serviceabilty modal
     * @author aditi.jain
     */
    public void clickSelectChangeContinue()
    {
        getReusableActionsInstance().waitForElementVisibility(SelectChangeContinue);
        getReusableActionsInstance().executeJavaScriptClick(SelectChangeContinue);
    }

    /**
     * This method clicks on the billing link
     *
     * @author Amit.Goswami1
     */
    public void clickBillinglink() {
        if (getReusableActionsInstance().isElementVisible(delearCodeOneViewDialogue, 30)) {
            getReusableActionsInstance().getWhenReady(delearCodeOneViewDialogue, 50).sendKeys("0MAAA");
            getReusableActionsInstance().clickIfAvailable(btnSubmitOneViewDialogue, 30);
        }
        if (getReusableActionsInstance().isElementVisible(skipNotification, 50)) {
            getReusableActionsInstance().clickWhenReady(skipNotification);
        }
        WebElement btn = getReusableActionsInstance().getWhenReady(Billinglink, 90);
        getReusableActionsInstance().clickWhenReady(btn, 45);
    }

    /**
     * This method clicks on the Auto Payment link on billing page
     *
     * @author Amit.Goswami1
     */
    public void clkAutoPayLink() {
        getReusableActionsInstance().clickWhenReady(SlctAutopaymntlink);
    }

    /**
     * This method selects Auto payment method on  the billing page.
     *
     * @author Amit.Goswami1
     */
    public void selectPaymentMethod() {
        getReusableActionsInstance().clickWhenReady(PymntmethodBllngPage);
    }

    /**
     * This method selects Digital Frontline radio button on  the billing page.
     *
     * @author Amit.Goswami1
     */
    public void digtalFrontlinebtn() {
        getReusableActionsInstance().clickWhenReady(DtlFrntlnrdiobtn);
    }

    /**
     * This method fills in the details for the Automatic payment Setup on the billing page.
     *
     * @param ExpiryYear  is card Expiry Year to set
     * @param Expirymonth is ID Expiry month to set
     * @author Amit.Goswami1
     */
    public void SetCard(String Expirymonth, String ExpiryYear) {
        getReusableActionsInstance().javascriptScrollByVisibleElement(ExpirymonthBlngPopup);
        getReusableActionsInstance().selectWhenReady(ExpirymonthBlngPopup, 2);
        getReusableActionsInstance().selectWhenReady(ExpiryYearBlngPopup, 4);
    }

    /**
     * This method fills in the token Number in the token number Field
     *
     * @author Amit.Goswami1
     **/
    public void tokenFieldFiller() {
        getReusableActionsInstance().getWhenReady(TokenField).sendKeys("9429335453334010");
    }

    /**
     * This method generates inputs CVV in th Security Code field
     *
     * @author Amit.Goswami1
     **/

    public void securityFieldFiller(String cvv) {
        //getReusableActionsInstance().javascriptScrollByVisibleElement(SecurityCodeField);
        // getReusableActionsInstance().getWhenReady(SecurityCodeField,45);
        getReusableActionsInstance().enterText(SecurityCodeField, cvv, 45);
        getReusableActionsInstance().clickWhenReady(CntinuebtnBillingpagepopup);
    }

    /**
     * This method clicks on the Profile link
     *
     * @author Amit.Goswami1
     */
    public void clickProfileLink() {
        getReusableActionsInstance().waitForElementVisibility(ProfileLink,60);
        getReusableActionsInstance().executeJavaScriptClick(ProfileLink);
//        getReusableActionsInstance().clickWhenReady(ProfileLink, 30);
    }

    /**
     * This method clicks on the Billing Drop Down link
     *
     * @author Amit.Goswami1
     */
    public void clickonBillingDropDown() {
        getReusableActionsInstance().javascriptScrollByVisibleElement(BillingDropDownbutton);
        getReusableActionsInstance().executeJavaScriptClick(BillingDropDownbutton);
    }

    public void clickPaperBilling() {
        getReusableActionsInstance().clickWhenReady(ChangetoPaperBilling);
    }

    /**
     * This method clicks on the online Billing link
     *
     * @author Amit.Goswami1
     */
    public void clickOnlineBilling() {
        if(getReusableActionsInstance().isElementVisible(ChangetoPaperBilling)){
            getReusableActionsInstance().executeJavaScriptClick(ChangetoPaperBilling);
        }     else{
            getReusableActionsInstance().executeJavaScriptClick(ChangetoOnlineBilling);
        }
    }

    public void clickOnConfirmChange(){
        getReusableActionsInstance().waitForElementTobeClickable(ConfirmBillingChange,20);
        getReusableActionsInstance().clickWhenReady(ConfirmBillingChange,20);
    }
    /**
     * This method verifies the Profile Page is displayed
     *
     * @author Amit.Goswami1
     */
    public boolean verifyProfilePage() {
        return getReusableActionsInstance().isElementVisible(ProfilePageHeader);
    }

    /**
     * This method verifies the Billing Page is displayed
     *
     * @author Amit.Goswami1
     */
    public boolean verifyBillingPage(){
        return getReusableActionsInstance().isElementVisible(MakePaymentbtn);
    }

    public void clickWallWifiLink(){
        // getReusableActionsInstance().javascriptScrollToMiddleOfPage();
        // getReusableActionsInstance().staticWait(3000);
        getReusableActionsInstance().clickWhenReady(LearnMoreAboutWallWiFiLink,45);
    }
    /**
     * This method verifies the displayed Mulitpls STB
     *
     * @author  Aditi.jain
     */
    public boolean verifydisplayedMulitplsSTB() {
        getReusableActionsInstance().waitForPageLoad();
        getReusableActionsInstance().waitForElementVisibility(displayedMulitplsSTB, 120);
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        return getReusableActionsInstance().isElementVisible(displayedMulitplsSTB);
    }
    /**
     * This method verifies the IgniteTVBox is displayed
     *
     * @author  Aditi.jain
     */
    public boolean clickIgniteTVBox() {
        return getReusableActionsInstance().isElementVisible(IgniteTVBox);
    }

    public boolean verifyProvince() {
        return getReusableActionsInstance().isElementVisible(Province,10);
    }
    /**
     * This method click View Offers
     *
     * @author Aditi.jain
     */
    public void clickViewOffers() {
        getReusableActionsInstance().clickWhenReady(viewOffers, 30);
    }

    /**
     * Scroll to the bottom of the page
     *
     * @author Jarmanjeet.Batth
     */

    public void goToPageBottom() {
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
    }

    /**
     * This method  select Recommended Offer
     *
     * @author Aditi.jain
     */
    public void selectRecommendedOffer() {
        getReusableActionsInstance().waitForElementVisibility(selectRecommendedOffer,60);
        getReusableActionsInstance().executeJavaScriptClick(selectRecommendedOffer);
    }


    /**
     * This method  select First Exclusive Offer
     *
     * @author Aditi.jain
     */
    public void selectFirstExclusiveOffer() {
        getReusableActionsInstance().waitForElementVisibility(selectExclusiveOffer,60);
        getReusableActionsInstance().executeJavaScriptClick(selectExclusiveOffer);
    }

    /**
     * click exchange later button
     * @author Aditi.Jain
     */
    public void clickContinueChangePackage() {
        getReusableActionsInstance().clickWhenReady( ContinueChangePackage,60);
    }

    /**
     * Port-in opted as yes
     * @author aditi.jain
     */
    public void yesPortInPopup() {
        getReusableActionsInstance().clickWhenReady(yesPortInServices,30);
    }
    /**
     * CLick Yes if 4K pop up Appears
     * @author chinnarao.vattam
     */
    public void fourKTVPopup() {
        if(getReusableActionsInstance().isElementVisible(yesFor4K))
            getReusableActionsInstance().clickWhenReady(yesFor4K,120);}

    /**
     * CLick Continue for four K
     * @author aditi.jain
     */
    public void fourKContinue() {
        if(getReusableActionsInstance().isElementVisible(fourKContinue, 45))
            getReusableActionsInstance().clickWhenReady(fourKContinue, 30);}

    /**
     * click exchange later button
     * @author Aditi.Jain
     */
    public void clickExchangeLater() {
        getReusableActionsInstance().waitForElementVisibility( ExchangeLaterBtn,60);
        getReusableActionsInstance().executeJavaScriptClick( ExchangeLaterBtn);}


    /*To click on submit in change caller name dailog box
	@author Aditi.Jain
    */
    public void clickSubmit()
    {
        getReusableActionsInstance().waitForElementVisibility(changeCallerNameSubmit ,60);
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().clickWhenReady(changeCallerNameSubmit,30);
        getReusableActionsInstance().staticWait(5000);
    }
    /**
     * Click Authorization Checkbox
     * @author chinnarao.vattam
     */
    public void clkAuthorize() {
        if(!getReusableActionsInstance().isElementVisible(authorizecheckbox))
            getReusableActionsInstance().clickWhenReady(authorizecheckbox);}
    /**
     * verify Review Your Order
     * @return true if available, else false
     * @author Aditi.jain
     */
    public boolean verifyReviewYourOrder() {
        return getReusableActionsInstance().isElementVisible(ReviewYourOrder, 70);
    }

    /**
     * verify Previous Package
     * @return true if available, else false
     * @author Aditi.jain
     */
    public boolean verifyPreviousPackage() {
        return getReusableActionsInstance().isElementVisible(previousPackage,30);


    }

    /**
     * verify Tv Details
     * @return true if available, else false
     * @author Aditi.jain
     */
    public boolean verifyTvDetails() {
        return getReusableActionsInstance().isElementVisible(tvDetails,30);


    }
    /**
     * verify New Package
     * @return true if available, else false
     * @author Aditi.jain
     */
    public boolean verifyNewPackage() {
        return getReusableActionsInstance().isElementVisible(newPackage,30);


    }
    /**
     * verify  NEW Tv Details
     * @return true if available, else false
     * @author Aditi.jain
     */
    public boolean verifyNewTvDetails() {
        return getReusableActionsInstance().isElementVisible(NewtvDetails,30);


    }
    /**
     * verify  required message
     * @return true if available, else false
     * @author Aditi.jain
     */
    public boolean verifyRequiredMessage() {
        getReusableActionsInstance().scrollToElement(requiredmessage);
        return getReusableActionsInstance().isElementVisible(requiredmessage,60);



    }
    /**
     * verify  Bill Amount
     * @return true if available, else false
     * @author Aditi.jain
     */
            public boolean verifyBillAmount() {
                getReusableActionsInstance().scrollToElement(billamount);
                return getReusableActionsInstance().isElementVisible(billamount, 30);

            }
            /**
             * verify  welcome text
             * @return true if available, else false
             * @author Aditi.jain
             */

                public boolean verifyWelcomeText() {
                    getReusableActionsInstance().scrollToElement(welcometext);
                    return getReusableActionsInstance().isElementVisible(welcometext, 30);

                }


                /**
                 * verify bill message
                 * @return true if available, else false
                 * @author Aditi.jain
                 */
                public boolean verifyBillMessage() {
                    getReusableActionsInstance().scrollToElement(billmessage);
                    return getReusableActionsInstance().isElementVisible(billmessage, 30);
                }
                /**
                 * verify product
                 * @return true if available, else false
                 * @author Aditi.jain
                 */
                public boolean verifyProductDisplayed() {
                    // getReusableActionsInstance().scrollToElement(product);
                    return getReusableActionsInstance().isElementVisible(product, 30);
                }


                /**
                 * verify accountMessages
                 * @return true if available, else false
                 * @author Aditi.jain
                 */
                public boolean verifyAccountMessages() {
                    getReusableActionsInstance().scrollToElement(accountMessages);
                    return getReusableActionsInstance().isElementVisible(accountMessages, 30);

                }

                /**
                 * verify scroll To View Bill
                 * @return true if available, else false
                 * @author Aditi.jain
                 */
                public void scrollToViewBill() {
                    getReusableActionsInstance().waitForPageLoad();
                    getReusableActionsInstance().staticWait(6000);
                    getReusableActionsInstance().javascriptScrollToMiddleOfPage();
//        getReusableActionsInstance().scrollToElement(requiredmessage);
                }

                public boolean verifyInternetBadge () {

                    getReusableActionsInstance().waitForElementVisibility(btnInternetBadge, 30);
                    return getReusableActionsInstance().isElementVisible(btnInternetBadge);
                }

                public boolean verifyTvBadge() {

                    getReusableActionsInstance().waitForElementVisibility(btnTVBadge, 30);
                    return getReusableActionsInstance().isElementVisible(btnTVBadge);
                }
                /**
                 * verify  required message
                 * @return true if available, else false
                 * @author Aditi.jain
                 */
                public void moveToiframe() {
                    getReusableActionsInstance().staticWait(10000);
                    getReusableActionsInstance().waitForFrameToBeAvailableAndSwitchToIt(iframewindow, 20);
                }
            }
