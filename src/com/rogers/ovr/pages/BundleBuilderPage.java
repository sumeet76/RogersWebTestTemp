package com.rogers.ovr.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.Point;
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
    @FindBy(xpath = "//a[@role='button' and @aria-label='quick-links']")
    WebElement lnkExpandFooter;

    @FindBy(partialLinkText = "LNP Eligibility")
    WebElement lnklnpEligibility;
    @FindBy(partialLinkText = "Offline Agreement")
    WebElement lnkOfflineAgreement;

    @FindBy(xpath = "//span[contains(text(),'Professional Install') or contains(text(),'Installation professionnelle')]")
    WebElement igniteProfessionalInstall;

    @FindBy(xpath = "//span[text()='Continue' or text()='Continuer']")
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

    @FindBy(xpath ="//input[@id='12']/ancestor::label[contains(@class,'ds-radioLabel')]//div[@class='ds-radioButton__outerCircle my-12']")
    WebElement rdoTechInstallSlot;

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

    @FindBy(xpath = "//span[text()='Continue' or text()='Continuer']/ancestor::button")
    WebElement continueBtn;

    @FindBy(xpath = "//span[contains(text(),'Delivery by Appointment') or contains(text(),'Livraison par rendez-vous')]")
    WebElement deliveryByAppointmentInstall;

    @FindBy(xpath = "//h3[@translate='global.label.paymentOptionsBilling']/parent::div/following-sibling::div/descendant::span[2]")
    WebElement storedPaymentCardLabel;



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
    public void scrollAndClickContinue() {
        getReusableActionsInstance().javascriptScrollByVisibleElement(continueBtn);
        getReusableActionsInstance().clickWhenReady(continueBtn);
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

    public void selectDeliveryByAppointmentInstall() {
        getReusableActionsInstance().waitForElementVisibility(deliveryByAppointmentInstall, 60);
        getReusableActionsInstance().javascriptScrollByVisibleElement(deliveryByAppointmentInstall);
        getReusableActionsInstance().executeJavaScriptClick(deliveryByAppointmentInstall);
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
        return getReusableActionsInstance().isElementVisible(currentPlanSection, 5);
    }

    public boolean verifyOvrSessionTimer(){
        return getReusableActionsInstance().isElementVisible(ovrSessionTimer, 30);
    }

    public boolean verifyStoredPaymentCardPresent(){
        return getReusableActionsInstance().isElementVisible(storedPaymentCardLabel, 60);
    }
}
