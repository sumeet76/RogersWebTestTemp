package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RogersOVInstallationPage extends BasePageClass {

    /**
     * Instantiates a new Base page class.
     *
     * @param driver the driver
     */
    public RogersOVInstallationPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath="//div[@class='ds-checkbox__box my-12']")
    WebElement activationCheckbox;

    @FindBy(xpath="//span[contains(text(),'Continue') or contains(text(),'Continuer')]/ancestor::button")
    WebElement btnContinue;

    @FindBy(xpath="//span[text()='Ignite Express Setup – Courier Delivery' or text()='Configuration express Élan – Livraison par messager']")
    WebElement courierDelivery;

    /*Clicks on Activation check box
    * @author suganya p
    * */
    public void clickInstallationCheckBox() {
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        WebElement btn=getReusableActionsInstance().getWhenReady(activationCheckbox, 60);
        getReusableActionsInstance().javascriptScrollByCoordinates(0,btn.getLocation().y-300);
        getReusableActionsInstance().getWhenReady(activationCheckbox,60).click();

    }
    /*Clicks on continue
    * @author suganya P
    * */
    public void clickContinue() {
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
        getReusableActionsInstance().getWhenReady(btnContinue,60).click();
    }

    /*Clicks on continue
     * @author Jarmanjeet.Batth
     * */
    public void clkCourierDelivery(){
        getReusableActionsInstance().waitForElementVisibility(courierDelivery,240);
        getReusableActionsInstance().executeJavaScriptClick(courierDelivery);
    }
}
