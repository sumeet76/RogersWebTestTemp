package com.rogers.ovr.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class OvrDashboardPage extends BasePageClass {
    public OvrDashboardPage(WebDriver driver) {
        super(driver);
    }


    //@FindBy(xpath = "//t[text()='Get Ignite' or text()='Obtenir Élan']/ancestor::a")
    @FindBy(xpath = "//t[text()='Add Ignite TV' or text()='Ajouter Télé Élan']/ancestor::a")
    WebElement lnkIgnite;

    @FindBy(xpath = "//a[contains(text(),'Français') and @id='language-changed']")
    WebElement changeLangToFR;

    @FindBy(xpath = "//t[text()='Internet']//following::span[text()=' Plan and Usage details ']")
    WebElement internetDashboard;

    @FindBy(xpath = "(//t[text()='TV']//following::span[text()=' Plan Details '])[1]")
    WebElement tvDashboard;

    @FindBy(xpath = "//t[text()='Home Phone']//following::span[text()=' Plan Details ']")
    WebElement homePhoneDashboard;

    @FindBy(xpath = "//t[text()='Ignite Streaming']//following::span[text()=' Plan Details ']")
    WebElement igniteStreamingDashboard;

    @FindBy(xpath = "//span[text()='Restart Box(es)' or text()='Redémarrer les terminaux numériques']//ancestor::button")
    WebElement btnRestartSetupbox;

    @FindBy(xpath = "//span[text()='Reset Parental Control PIN' or text()='Réinitialiser le NIP de contrôle parental']")
    WebElement btnResetParentalControl;

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

}
