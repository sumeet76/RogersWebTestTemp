package com.rogers.ovr.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckAvailabilityPage extends BasePageClass {
    public  CheckAvailabilityPage(WebDriver driver){super(driver);
    }

    @FindBy(xpath = "//span[text()='Use this address' or text()='Utiliser cette adresse']")
    WebElement btnUseThisAddress;
    @FindBy(xpath = "//*[text()='Continue' or text()='Continuer']")
    WebElement btnContinue;

    @FindBy(xpath = "//div[contains(text(),'This address is serviceable') or contains(text(),'Cette adresse peut être desservie')]")
    WebElement lblAddressIsServiceable;

    @FindBy(xpath = "//p[contains(text(),'Multiple addresses found') or contains(text(),'Plusieurs adresses trouvées')]")
    WebElement lblMultipleAddressesFound;

    @FindBy(xpath = "//rch-dropdown/descendant::select")
    WebElement multipleAddressDropdown;

    @FindBy(xpath = "//span[@translate='global.cta.checkAvailability']//ancestor::button")
    WebElement checkAvailabilityBtn;

    @FindBy(xpath = "//p[text()='Check availability' or text()='Vérifier la disponibilité']")
    WebElement checkAvailabilityHeader;

    //@FindBy(xpath = "//*[@id='ds-modal-container-0']/ds-modal/descendant::div[@class='input-search']")
    @FindBy(xpath = "//input[contains(@id,'algoliaInput') or contains(@id,'canada-post-address-complete')]//parent::div")
    WebElement inputContainer;

    @FindBy(xpath = "//input[contains(@id,'algoliaInput') or contains(@id,'canada-post-address-complete')]")
    WebElement addressInput;

    @FindBy(xpath = "(//div[contains(@class,'ds-formField__autoComplete')]//descendant::li)[1]")
    WebElement searchResult;

    @FindBy(xpath = "//p[contains(text(),'Multiple addresses found') or contains(text(),'Plusieurs adresses trouvées')]//parent::div//following::div//descendant::li[2]")
    WebElement multipleAddressRadioBtn;

    @FindBy(xpath = "//span[@translate='global.cta.otherAddress']")
    WebElement otherAddressRadioButton;

    @FindBy(xpath = "//div[contains(text(),'account has not been consolidated')]")
    WebElement nonConsolidatedBanErrorMessage;


    public void useThisAddress()  {
        getReusableActionsInstance().getWhenVisible(btnContinue, 60).click();
        if(getReusableActionsInstance().isElementVisible(lblMultipleAddressesFound, 5)){
            getReusableActionsInstance().selectWhenReady(multipleAddressDropdown,2,  5);
        }
        getReusableActionsInstance().getWhenVisible(btnContinue).click();
    }


    public void addressIsServiceable(){
        if (getReusableActionsInstance().isElementVisible(lblAddressIsServiceable, 5)){
            getReusableActionsInstance().clickWhenReady(btnContinue);
        }
    }

    /**
     * Enter the address to search for service availability
     * If multiple addresses are found, select an address from list
     * @param address is the Address to check for availability
     * @param browser is the Browser to use
     * @author sameer.ahuja
     */
    public void checkAvailability(String address,String browser) {
        getReusableActionsInstance().clickWhenReady(inputContainer,60);
        if(browser.equals("chrome")) {
            getReusableActionsInstance().enterText(addressInput,address+ Keys.BACK_SPACE,120);
            getReusableActionsInstance().staticWait(8000);
        }
        else {
            getReusableActionsInstance().enterText(addressInput,address,120);
            getReusableActionsInstance().staticWait(3000);
        }
        getReusableActionsInstance().clickAndHoldFor(searchResult, 333);
        getReusableActionsInstance().staticWait(2000);
        getReusableActionsInstance().clickWhenReady(checkAvailabilityBtn, 15);
        if(getReusableActionsInstance().isElementVisible(lblMultipleAddressesFound, 5)){
            getReusableActionsInstance().selectWhenReady(multipleAddressDropdown, 2);
        }
        //getReusableActionsInstance().clickIfAvailable(btnContinue);
    }

    public void checkAvailabilityAtOtherAddress(String address, String browser){
        getReusableActionsInstance().getWhenReady(otherAddressRadioButton, 60);
        getReusableActionsInstance().clickWhenReady(otherAddressRadioButton);
        checkAvailability(address, browser);
    }

    public boolean verifyCheckAvailabilityPopup(){
        return getReusableActionsInstance().isElementVisible(checkAvailabilityHeader, 60) &&
                getReusableActionsInstance().isElementVisible(checkAvailabilityBtn, 60);
    }

    public boolean verifyNonConsolidatedBanErrorMessage(){
        return getReusableActionsInstance().isElementVisible(nonConsolidatedBanErrorMessage,60);
    }

}
