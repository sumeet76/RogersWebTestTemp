package com.rogers.ovr.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

/**
 *
 */
public class BundleBuilderPage extends BasePageClass {
    public BundleBuilderPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[contains(text(),'Professional Install') or contains(text(),'Installation professionnelle')]")
    WebElement igniteProfessionalInstall;

    @FindBy(xpath = "//span[@translate='global.cta.continue']/ancestor::button")
    WebElement continueInstallation;

    @FindBy(xpath = "//span[text()='Continue' or text()='Continuer']/ancestor::button")
    WebElement continueBillingAndPayment;

    @FindBy(xpath = "//*[text()='Exchange later']")
    WebElement btnexchangelater;
    @FindBy(xpath = "//div[contains(@class,'exchange-tip')]")
    WebElement btnTip;
    @FindBy(xpath = "//*[contains(text(),'Channel Personalization')]")
    WebElement txtChannelPersonalization;

    @FindBy(xpath = "//span[text()='Year']/parent::ds-input-label/parent::label/parent::span/following-sibling::select")
    WebElement select_year;

    @FindBy(xpath = "//span[text()='Month']/parent::ds-input-label/parent::label/parent::span/following-sibling::select")
    WebElement select_month;
    @FindBy(xpath = "//span[text()='Day']/parent::ds-input-label/parent::label/parent::span/following-sibling::select")
    WebElement select_day;

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
    WebElement txtMobileNumber;

    @FindBy(xpath ="//input[@formcontrolname='enrouteEmail']")
    WebElement txtEmail;

    @FindBy(xpath ="(//div[@class='a-radio'])[1]/ds-radio-button")
    WebElement rdoTechInstallSlot;

    @FindBy(xpath ="//input[@id='12']/ancestor::label[contains(@class,'ds-radioLabel')]//div[@class='ds-radioButton__outerCircle my-12']")
    WebElement rdoTechInstallSlot12;

    @FindBy(xpath = "//div[text()='Customer current' or text()='Offre actuelle du client']//following-sibling::div")
    WebElement currentPlanSection;

    @FindBy(xpath = "//span[@class='ds-icon rds-icon-close']")
    WebElement popupCloseBtn;

    @FindBy(xpath = "//h1[contains(text(),'Billing and Payment') or contains(text(),'Options de facturation et de paiement')]")
    WebElement billingAndPaymentH1;

    @FindBy(xpath = "//h3[@translate='global.label.paymentOptionsBilling']//parent::div//following-sibling::div//child::select[1]")
    WebElement drpSelectBillingPaymentMethod;

    @FindBy(xpath = "//span[contains(text(),'Select the services') or contains(text(),'Sélectionnez les services demandés par le client')]")
    WebElement lblSelectServiceBundles;

    @FindBy(xpath = "//*[@title='Rogers']/ancestor::div[2]//child::span")
    WebElement ovrSessionTimer;

    @FindBy(xpath = "//span[text()='Continue' or @translate='global.cta.continue']")
    WebElement continueBtn;

    @FindBy(xpath = "//span[contains(text(),'Courier Delivery') or contains(text(),'Livraison par messager')]")
    WebElement deliveryByAppointmentInstall;

    @FindBy(xpath = "//h3[@translate='global.label.paymentOptionsBilling']/parent::div/following-sibling::div/descendant::span[2]")
    WebElement storedPaymentCardLabel;

    @FindBy(xpath = "//span[text()='Ignite Express Setup – Courier Delivery' or contains(text(),'Configuration express Élan – Livraison par messager')]")
    WebElement courierDeliveryInstall;

    @FindBy(xpath = "//span[contains(text(),'Ignite Express Setup – Grab and Go')]")
    WebElement grabAndGoInstall;

    @FindBy(xpath = "//span[contains(text(),'receive the equipment delivery.')]")
    WebElement courierDeliveryCheckbox;

    @FindBy(xpath = "//p[contains(text(),'Sorry, this Service combination is unavailable.')]")
    WebElement nonValidBundlesErrorMessage;

    @FindBy(xpath = "//p[contains(text(),'This service change is not supported in Oneview')]")
    WebElement downgradeMigrationFlowErrorMessage;

    @FindBy(xpath = "//a[@id='session-indicator-remaining-time']")
    WebElement footerSessionTimer;

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement footerSignOutLink;

    @FindBy(xpath = "//a[contains(text(),'Search for another customer')]")
    WebElement searchForAnotherCustLink;

    @FindBy(xpath = "//a[contains(text(),'Logout of Oneview & SSP')]")
    WebElement logoutOneviewAndSSP;

    @FindBy(xpath = "//h1[contains(text(),'successfully logged out')]")
    WebElement loggedOutOfChampLbl;

    @FindBy(xpath = "(//rch-grab-n-go-install//child::input)[1]//parent::div")
    WebElement grabAndGoSerialNumber;

    @FindBy(xpath = "(//rch-grab-n-go-install//child::input)[2]//parent::div")
    WebElement grabAndGoSerialNumberEntertainmentBox;

    @FindBy(xpath = "(//rch-grab-n-go-install//child::input)[1]")
    WebElement grabAndGoSerialNumberInput;
    @FindBy(xpath = "(//rch-grab-n-go-install//child::input)[2]")
    WebElement grabAndGoSerialNumberInput2;
    @FindBy(xpath = "//span[contains(text(),'Customer understands billing starts today and equipment must be self installed')]")
    WebElement grabAndGoCheckbox;

    @FindBy(xpath = "//span[contains(text(),'Success! Serial number added')]")
    WebElement grabAndGoSerialNumberSuccess;


    public void switchToTab(String windowHandle){
        getReusableActionsInstance().waitForNumberOfWindowsToBe(3);
        getReusableActionsInstance().waitForPageLoad();
        getReusableActionsInstance().closeCurrentWindow();
        getReusableActionsInstance().switchToMainWindow(windowHandle);
    }

    public void switchToMainTab(){
        getReusableActionsInstance().waitForPageLoad();
        getReusableActionsInstance().closeCurrentWindow();
        getReusableActionsInstance().switchToMainWindow();
    }


    public void scrollAndClickContinue() {
        getReusableActionsInstance().staticWait(2000);
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().waitForElementTobeClickable(continueBtn,60);
        getReusableActionsInstance().executeJavaScriptClick(continueBtn);
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

    public void selectGrabAndGoInstall() {
        getReusableActionsInstance().waitForElementVisibility(grabAndGoInstall, 60);
        getReusableActionsInstance().javascriptScrollByVisibleElement(grabAndGoInstall);
        getReusableActionsInstance().executeJavaScriptClick(grabAndGoInstall);
    }

    public void selectDeliveryByAppointmentInstall() {
        getReusableActionsInstance().waitForElementVisibility(deliveryByAppointmentInstall, 60);
        getReusableActionsInstance().javascriptScrollByVisibleElement(deliveryByAppointmentInstall);
        getReusableActionsInstance().executeJavaScriptClick(deliveryByAppointmentInstall);
    }

    public void selectDeliveryByCourier(){
        getReusableActionsInstance().waitForElementVisibility(courierDeliveryInstall, 60);
        getReusableActionsInstance().javascriptScrollByVisibleElement(courierDeliveryInstall);
        getReusableActionsInstance().executeJavaScriptClick(courierDeliveryInstall);
        //Scroll to checkbox and click it
        getReusableActionsInstance().waitForElementVisibility(courierDeliveryCheckbox, 15);
        getReusableActionsInstance().javascriptScrollByVisibleElement(courierDeliveryCheckbox);
        getReusableActionsInstance().executeJavaScriptClick(courierDeliveryCheckbox);
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
            getReusableActionsInstance().getWhenReady(txtMobileNumber, 10).clear();
            getReusableActionsInstance().getWhenReady(txtMobileNumber, 3).sendKeys(strPhoneNumber);
//            getReusableActionsInstance().waitForElementVisibility(txtContainerEmail, 30);
//            getReusableActionsInstance().getWhenReady(txtContainerEmail, 10).click();
//            getReusableActionsInstance().getWhenReady(txtEmail, 10).clear();
//            getReusableActionsInstance().getWhenReady(txtEmail, 10).sendKeys(strEmail);
        }
    }

    /**
     * Select the slot from the available list of slots from installation page
     * @author Sameer.Ahuja
     */
    public void clkTechInstallSlot() {
        getReusableActionsInstance().waitForElementVisibility(rdoTechInstallSlot, 180);
        getReusableActionsInstance().javascriptScrollToMiddleOfPage();
        getReusableActionsInstance().scrollToElement(rdoTechInstallSlot);
        //getReusableActionsInstance().javascriptScrollByVisibleElement(rdoTechInstallSlot);
        getReusableActionsInstance().getWhenReady(rdoTechInstallSlot12).click();
    }

    public void clkContinueInstallation() {
       // getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().staticWait(2000);
        getReusableActionsInstance().waitForElementTobeClickable(continueInstallation,30);
        getReusableActionsInstance().executeJavaScriptClick(continueInstallation);
    }

    public boolean verifyBillingAndPaymentPage(){
        return getReusableActionsInstance().isElementVisible(billingAndPaymentH1, 180);
    }

    public boolean verifyBundleBuilderPage(){
        return getReusableActionsInstance().isElementVisible(lblSelectServiceBundles, 60);
    }

    public void clkContinueBillingAndPayment() {
        if(getReusableActionsInstance().isElementVisible(billingAndPaymentH1, 60)){
            getReusableActionsInstance().javascriptScrollByVisibleElement(continueBillingAndPayment);
            getReusableActionsInstance().clickWhenReady(continueBillingAndPayment, 15);
        }
        if(getReusableActionsInstance().isElementVisible(popupCloseBtn, 5)){
            getReusableActionsInstance().clickWhenReady(popupCloseBtn, 3);
            getReusableActionsInstance().clickWhenReady(continueBillingAndPayment, 3);

        }
    }
    public void setDrpSelectBillingPaymentMethod(String paymentMethod){
        getReusableActionsInstance().selectWhenReadyByVisibleText(drpSelectBillingPaymentMethod, paymentMethod);
    }

    public boolean verifyCustomerCurrentPlan(){
        return getReusableActionsInstance().isElementVisible(currentPlanSection, 60);
    }

    public boolean verifyOvrSessionTimer(){
        return getReusableActionsInstance().isElementVisible(ovrSessionTimer, 60);
    }

    public boolean verifyStoredPaymentCardPresent(){
        return getReusableActionsInstance().isElementVisible(storedPaymentCardLabel, 60);
    }

    public void validateSessionTimerWait(int waitTime){
        getReusableActionsInstance().staticWait(waitTime);
    }

    public boolean verifyNonValidBundlesMessage(){
        return getReusableActionsInstance().isElementVisible(nonValidBundlesErrorMessage,20);
    }

    public boolean verifyDowngradeMigrationFlowErrorMessage(){
        return getReusableActionsInstance().isElementVisible(downgradeMigrationFlowErrorMessage,20);
    }

    public boolean verifySessionTimerInFooter(){
        return getReusableActionsInstance().isElementVisible(footerSessionTimer,10);
    }

    public boolean verifyFooterLinks(){
        getReusableActionsInstance().clickWhenVisible(footerSignOutLink,10);
        return getReusableActionsInstance().isElementVisible(searchForAnotherCustLink,5) &&
                getReusableActionsInstance().isElementVisible(logoutOneviewAndSSP,5);
    }

    public boolean clickLogoutOneviewAndSSP(){
        getReusableActionsInstance().clickWhenVisible(logoutOneviewAndSSP,5);
        return getReusableActionsInstance().isElementVisible(loggedOutOfChampLbl,30);
    }

    public void enterGrabAndGoSerialNumber2(String serialNumber,String serialNumber2){
        getReusableActionsInstance().getWhenVisible(grabAndGoSerialNumber,30);
        getReusableActionsInstance().javascriptScrollByVisibleElement(grabAndGoSerialNumber);
        getReusableActionsInstance().executeJavaScriptClick(grabAndGoSerialNumber);
        getReusableActionsInstance().enterText(grabAndGoSerialNumberInput, serialNumber, 20);
        getReusableActionsInstance().javascriptScrollByVisibleElement(grabAndGoSerialNumberEntertainmentBox);
        getReusableActionsInstance().executeJavaScriptClick(grabAndGoSerialNumberEntertainmentBox);
        getReusableActionsInstance().enterText(grabAndGoSerialNumberInput2, serialNumber2, 20);
        getReusableActionsInstance().scrollToElement(grabAndGoCheckbox);
        getReusableActionsInstance().clickWhenReady(grabAndGoCheckbox);
    }
    public void enterGrabAndGoSerialNumber(String serialNumber){
        getReusableActionsInstance().getWhenVisible(grabAndGoSerialNumber,30);
        getReusableActionsInstance().javascriptScrollByVisibleElement(grabAndGoSerialNumber);
        getReusableActionsInstance().executeJavaScriptClick(grabAndGoSerialNumber);
        getReusableActionsInstance().enterText(grabAndGoSerialNumberInput, serialNumber, 20);
//        getReusableActionsInstance().javascriptScrollByVisibleElement(grabAndGoSerialNumberEntertainmentBox);
//        getReusableActionsInstance().executeJavaScriptClick(grabAndGoSerialNumberEntertainmentBox);
//        getReusableActionsInstance().enterText(grabAndGoSerialNumberInput2, serialNumber2, 20);
        getReusableActionsInstance().scrollToElement(grabAndGoCheckbox);
        getReusableActionsInstance().clickWhenReady(grabAndGoCheckbox);
    }

    public boolean verifyGrabAndGoSerialNumber(){
        return getReusableActionsInstance().isElementVisible(grabAndGoSerialNumberSuccess,20);
    }

}
