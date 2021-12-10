package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import javafx.scene.chart.ScatterChart;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardBillingPage extends BasePageClass {

    public DashboardBillingPage(WebDriver driver) {super(driver);}

    @FindBy(xpath = "//div[@class='action stacked']/child::button[1]")
    WebElement mkPayment;

    @FindBy(xpath= "//input[@id='txtPaymentAmount']")
    WebElement txtPaymentAmt;

    @FindBy(xpath = "//input[@id='digitalFrontLine']")
    WebElement rdDigitalFrontLine;

    @FindBy(xpath = "//input[@id='tokenNumber']")
    WebElement txtTokenNumber;

    @FindBy(xpath = "//select[@formcontrolname='month']")
    WebElement expiryMonth;

    @FindBy(xpath = "//select[@formcontrolname='year']")
    WebElement expiryYear;

    @FindBy(xpath = "//input[@id='security-code']")
    WebElement securityCode;

    @FindBy(xpath = "//section[@class='signup']//input")
    WebElement chkSignUp;



    public void clickMakePayment() {

        getReusableActionsInstance().isElementVisible(mkPayment, 60);
        //getReusableActionsInstance().scrollToElementAndClick(mkPayment);
        getReusableActionsInstance().clickIfAvailable(mkPayment,45);
    }

    public void enterPaymentAmount(String paymentAmt) {

        getReusableActionsInstance().isElementVisible(txtPaymentAmt, 60);
        //getReusableActionsInstance().scrollToElementAndClick(txtPaymentAmt);
        txtPaymentAmt.clear();
       txtPaymentAmt.sendKeys(paymentAmt);
    }




    public void selectDigitalFrontLine(){
        getReusableActionsInstance().isElementVisible(rdDigitalFrontLine, 60);
        //getReusableActionsInstance().scrollToElementAndClick(rdDigitalFrontLine);
        getReusableActionsInstance().clickWhenReady(rdDigitalFrontLine);
        rdDigitalFrontLine.sendKeys(Keys.TAB);
    }

    public void SelectTokenNumber(String tokenNo)
    {
        //  getReusableActionsInstance().isElementVisible(tokenNo, 60);
        //getReusableActionsInstance().scrollToElementAndClick(TokenNo);
        //getReusableActionsInstance().clickWhenReady(txtTokenNumber);
        securityCode.sendKeys(tokenNo);
    }

    public void selectExpiryMonth(){
        getReusableActionsInstance().selectWhenReady(expiryMonth,"07");

    }

    public void selectExpiryYear(){
        getReusableActionsInstance().selectWhenReady(expiryYear,"6: 2026");

    }

    public void selectSecurityCode( String strCCSecurityCode)
    {
        getReusableActionsInstance().isElementVisible(securityCode, 60);
        //getReusableActionsInstance().scrollToElementAndClick(securityCode);
        securityCode.sendKeys(strCCSecurityCode);
    }

    public void selectSignUp(){
        getReusableActionsInstance().isElementVisible(chkSignUp, 60);
        //getReusableActionsInstance().scrollToElementAndClick(chkSignUp);
        getReusableActionsInstance().clickWhenReady(chkSignUp);
    }
}
