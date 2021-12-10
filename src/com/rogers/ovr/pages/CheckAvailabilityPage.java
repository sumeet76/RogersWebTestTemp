package com.rogers.ovr.pages;


import com.rogers.pages.base.BasePageClass;
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



    public void useThisAddress() {
        getReusableActionsInstance().getWhenVisible(btnUseThisAddress).click();
        if(getReusableActionsInstance().isElementVisible(lblMultipleAddressesFound, 5)){
            getReusableActionsInstance().selectWhenReady(multipleAddressDropdown, 2, 5);
        }
        getReusableActionsInstance().getWhenVisible(btnContinue).click();
    }


    public void addressIsServiceable(){
        if (getReusableActionsInstance().isElementVisible(lblAddressIsServiceable, 5)){
            getReusableActionsInstance().clickWhenReady(btnContinue);
        }
    }



}
