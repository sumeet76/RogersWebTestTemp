package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CallerInformationPage extends BasePageClass {
    /**
     * Instantiates a new Base page class.
     *
     * @param driver the driver
     */
    public CallerInformationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//span[contains(text(),'Caller Information Review') or contains(text(),'Examen des informations sur')]")
    WebElement callerInfoVerify;

    @FindBy(xpath="//span[@translate='global.cta.continue']")
    WebElement continueButton;

    @FindBy(xpath="(//span[@translate='global.cta.continue']//ancestor::button)[3]")
    WebElement finalContinueButton;

    /*To verify caller information page
    * @suganya p
    */
    public boolean callerInfoPageLoad()
    {
        return getReusableActionsInstance().isElementVisible(callerInfoVerify,60);
    }

    /*To click on continue button
    * @suganya p
    */
    public void clickContinue()
    {
        getReusableActionsInstance().getWhenReady(continueButton,30).click();
    }
    /**
     * Go to Page bottom
     * @author aditi.jain
     */
    public void goToPageBottom() {
        getReusableActionsInstance().javascriptScrollToBottomOfPage();
    }

    public void clickFinalContinue()
    {
        getReusableActionsInstance().staticWait(2000);
        getReusableActionsInstance().getWhenReady(finalContinueButton,30).click();
    }
}
