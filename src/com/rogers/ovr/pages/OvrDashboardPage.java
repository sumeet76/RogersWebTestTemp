package com.rogers.ovr.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class OvrDashboardPage extends BasePageClass {
    public OvrDashboardPage(WebDriver driver) {
        super(driver);
    }


    //@FindBy(xpath = "//t[text()='Get Ignite' or text()='Obtenir Élan']/ancestor::a")
    @FindBy(xpath = "//t[text()='Add Ignite' or text()='Ajouter Élan']/ancestor::a")
    WebElement lnkIgnite;

    @FindBy(xpath = "//a[contains(text(),'Français') and @id='language-changed']")
    WebElement changeLangToFR;

    @FindBy(xpath = "//t[contains(text(),'Internet')]//following::span[contains(text(),'Plan and Usage details')]")
    WebElement internetDashboard;

    @FindBy(xpath = "//t[contains(text(),'TV')]//following::span[contains(text(),'Plan Details')]")
    WebElement tvDashboard;

    @FindBy(xpath = "//t[contains(text(),'Home Phone')]//following::span[contains(text(),'Plan Details')]")
    WebElement homePhoneDashboard;

    @FindBy(xpath = "//t[contains(text(),'Ignite Streaming')]//following::span[contains(text(),'Plan Details')]")
    WebElement igniteStreamingDashboard;

    @FindBy(xpath = "//span[text()='Restart Box(es)' or text()='Redémarrer les terminaux numériques']//ancestor::button")
    WebElement btnRestartSetupbox;

    @FindBy(xpath = "//span[text()='Reset Parental Control PIN' or text()='Réinitialiser le NIP de contrôle parental']")
    WebElement btnResetParentalControl;

    @FindBy(xpath = "//div[@class='blocker visible']")
    WebElement closeFooter;

    @FindBy(xpath = "//a[@aria-label='Open Live Chat']//parent::div//child::div[1]")
    WebElement closeLiveChat;

    @FindBy(partialLinkText = "Retail Campaign Tool")
    WebElement linkRetailCampaignTool;

    @FindBy(partialLinkText = "FidoTrade")
    WebElement fidoTradeTool;

    @FindBy(partialLinkText = "Getting Started")
    WebElement gettingStartedLink;

    @FindBy(partialLinkText = "The Loop")
    WebElement theLoopLink;

    @FindBy(xpath = "//a[text()=' Device Eligibility Tool ']")
    WebElement deviceEligibilityTool;

    @FindBy(xpath = "(//t[text()='Cancel'])[2]")
    WebElement cancelLink;

    @FindBy(xpath = "//a[text()=' SIM Validation Tool ']")
    WebElement simValidationTool;

    @FindBy(xpath = "//button[text()='BACK TO ONEVIEW']")
    WebElement backToOneviewBtn;

    @FindBy(xpath = "//a[@aria-label='Open Live Chat']")
    WebElement liveChatButton;

    @FindBy(xpath = "//t[text()='Refresh']//parent::a")
    WebElement refreshLiveChatButton;

    @FindBy(xpath = "//button[@id='QSIFeedbackButton-btn']")
    WebElement feedbackFormButton;

    @FindBy(xpath = "//button[@id='QSIFeedbackButton-close-btn']")
    WebElement feedbackFormCloseButton;

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logOutOptionsButton;

    @FindBy(xpath = "//H1[contains(text(),'You are successfully logged out')]")
    WebElement successfulLogoutMessageLabel;

    @FindBy(xpath = "//a[@role='button' and @aria-label='quick-links']")
    WebElement lnkExpandFooter;
    @FindBy(partialLinkText = "LNP Eligibility")
    WebElement lnklnpEligibility;
    @FindBy(partialLinkText = "Offline Agreement")
    WebElement lnkOfflineAgreement;
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement careLogoutLink;

    @FindBy(xpath="//t[contains(text(),'Your Session has expired')]")
    WebElement careLogoutMessage;

    public void clickIgniteLink() {
        getReusableActionsInstance().waitForElementVisibility(lnkIgnite,60);
        getReusableActionsInstance().javascriptScrollByVisibleElement(lnkIgnite);
        getReusableActionsInstance().getWhenVisible(lnkIgnite).click();
    }

    public void changeLangToFR(){
        getReusableActionsInstance().clickWhenReady(changeLangToFR,60);
    }

    public void clkInternetDashboard(){
        getReusableActionsInstance().waitForElementVisibility(internetDashboard,60);
        getReusableActionsInstance().javascriptScrollByVisibleElement(internetDashboard);
        getReusableActionsInstance().getWhenVisible(internetDashboard).click();
    }

    public void clkTVDashboard(){
        getReusableActionsInstance().waitForElementVisibility(tvDashboard,60);
        getReusableActionsInstance().javascriptScrollByVisibleElement(tvDashboard);
        getReusableActionsInstance().getWhenVisible(tvDashboard).click();
    }

    public void clkHomePhoneDashboard(){
        getReusableActionsInstance().waitForElementVisibility(homePhoneDashboard,60);
        getReusableActionsInstance().javascriptScrollByVisibleElement(homePhoneDashboard);
        getReusableActionsInstance().getWhenVisible(homePhoneDashboard).click();
    }

    public void clkIgniteStreamingDashboard() {
        getReusableActionsInstance().waitForElementVisibility(igniteStreamingDashboard,60);
        getReusableActionsInstance().javascriptScrollByVisibleElement(igniteStreamingDashboard);
        getReusableActionsInstance().getWhenVisible(igniteStreamingDashboard).click();
    }

    public boolean verifyRestartSetUpBox() {
        return getReusableActionsInstance().isElementVisible(btnRestartSetupbox, 30);
    }

    public void clickRestartSetupbox() {
        getReusableActionsInstance().waitForElementVisibility(btnRestartSetupbox, 120);
        getReusableActionsInstance().javascriptScrollByVisibleElement(btnRestartSetupbox);
        getReusableActionsInstance().clickWhenReady(btnRestartSetupbox, 30);

    }

    public boolean verifyResetParentalControl() {
        return getReusableActionsInstance().isElementVisible(btnResetParentalControl, 30);
    }

    public void clickResetParentalControl() {
        getReusableActionsInstance().waitForElementVisibility(btnResetParentalControl, 60);
        getReusableActionsInstance().javascriptScrollByVisibleElement(btnResetParentalControl);
        getReusableActionsInstance().clickWhenReady(btnResetParentalControl, 30);
    }

    public void openFooter() {
        getReusableActionsInstance().waitForPageLoad();
        getReusableActionsInstance().getWhenVisible(lnkExpandFooter).click();
        getReusableActionsInstance().staticWait(3000);
    }

    public void closeFooter(){
        getReusableActionsInstance().waitForPageLoad();
        getReusableActionsInstance().getWhenVisible(closeFooter).click();
    }

    public void closeLiveChatWindow(){
        getReusableActionsInstance().getWhenVisible(closeLiveChat).click();
    }
    public void openLNPEligibilityPage() throws InterruptedException {
        getReusableActionsInstance().getWhenVisible(lnklnpEligibility).click();
        Thread.sleep(5000);
    }


    public void openFooterAndNavigateToLNPPage() throws InterruptedException {
        openFooter();
        openLNPEligibilityPage();
        getReusableActionsInstance().waitForPageLoad();
    }
    public void openFooterAndNavigateToOfflineAgreementPage(){
        openFooter();
        getReusableActionsInstance().getWhenVisible(lnkOfflineAgreement).click();
        getReusableActionsInstance().waitForPageLoad();
    }

    public void openRetailCampaignTool(){
        openFooter();
        getReusableActionsInstance().getWhenVisible(linkRetailCampaignTool).click();
        getReusableActionsInstance().waitForPageLoad();
    }

    public void openFidoTradeTool(){
        openFooter ();
        int numberOfWindows = getDriver().getWindowHandles().size();
        getReusableActionsInstance().getWhenVisible(fidoTradeTool).click();
        getReusableActionsInstance().waitForNumberOfWindowsToBe(numberOfWindows + 1);
        getReusableActionsInstance().switchToNewWindow();
        //getReusableActionsInstance().staticWait(5000);
    }

    public String getCurrentWindowHandle(){
        getReusableActionsInstance().waitForPageLoad();
        return getDriver().getWindowHandle();
    }


    public void openDeviceEligibilityTool(){
        getReusableActionsInstance().getWhenVisible(deviceEligibilityTool).click();
        getReusableActionsInstance().staticWait(1000);
    }
    public void openSIMValidationTool(){
        getReusableActionsInstance().getWhenVisible(simValidationTool).click();
        getReusableActionsInstance().staticWait(1000);
    }

    public void clickCancelOnPopup(){
        getReusableActionsInstance().getWhenVisible(cancelLink).click();
    }

    public String openLink(String linkText){
        String currentWindow = getDriver().getWindowHandle();
        int numberOfWindows = getDriver().getWindowHandles().size();
        String linkXpath = "//t[text()='"+linkText+"']//parent::a";
        WebElement linkElement = getDriver().findElement(By.xpath(linkXpath));
        getReusableActionsInstance().getWhenVisible(linkElement).click();
        getReusableActionsInstance().waitForNumberOfWindowsToBe(numberOfWindows + 1);
        getReusableActionsInstance().switchToNewWindow();
        getReusableActionsInstance().staticWait(5000);
        return currentWindow;
    }

    public String openRogersLink(String linkText){
        String currentWindow = getDriver().getWindowHandle();
        int numberOfWindows = getDriver().getWindowHandles().size();
        String linkXpath = "//a[text()='"+linkText+"']";
        WebElement linkElement = getDriver().findElement(By.xpath(linkXpath));
        getReusableActionsInstance().getWhenVisible(linkElement).click();
        getReusableActionsInstance().waitForNumberOfWindowsToBe(numberOfWindows + 1);
        getReusableActionsInstance().switchToNewWindow();
        getReusableActionsInstance().staticWait(5000);
        return currentWindow;
    }

    public void goBackToOneview(){
        getReusableActionsInstance().getWhenVisible(backToOneviewBtn).click();
        getReusableActionsInstance().waitForPageLoad();
    }
    public void openLiveChat(){
        getReusableActionsInstance().getWhenVisible(liveChatButton).click();
        getReusableActionsInstance().staticWait(2000);
        getReusableActionsInstance().getWhenVisible(refreshLiveChatButton).click();

    }

    public void openFeedbackForm(){
        getReusableActionsInstance().getWhenVisible(feedbackFormButton).click();
        getReusableActionsInstance().staticWait(3000);
    }

    public void closeFeedbackForm(){
        getReusableActionsInstance().getWhenVisible(feedbackFormCloseButton).click();
        getReusableActionsInstance().staticWait(2000);
    }

    public void openLogoutOptions(){
        getReusableActionsInstance().getWhenVisible(logOutOptionsButton).click();
        getReusableActionsInstance().staticWait(2000);
    }

    public boolean verifySuccessfulLogout(){
        getReusableActionsInstance().waitForPageLoad();
        return getReusableActionsInstance().isElementVisible(successfulLogoutMessageLabel, 15);
    }

    public void logoutOfCare(){
        getReusableActionsInstance().getWhenReady(careLogoutLink).click();
    }

    public boolean verifylogoutOfCare(){
        return getReusableActionsInstance().isElementVisible(careLogoutMessage, 45);
    }

}
