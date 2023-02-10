package com.rogers.pages;


import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.ITestResult;
import utils.DigiAutoCustomException;

import java.util.List;

public class RogersDeviceConfigPage extends BasePageClass {

    public RogersDeviceConfigPage(WebDriver driver) {
        super(driver);
    }

    public String xpathDeviceName;

    @FindBy(xpath = "//button[@title='Select' or @title='Continue' or @title='Continuer' or @title='Ship to home' or @title='Expédier à la maison']")
    WebElement continueButton;

    @FindBy(xpath = "//span[contains(text(),'Pre-order Ship Home') or contains(text(),'PREORDER RESERVE')]")
    WebElement backOrderShipHome;

    @FindBy(xpath = "//h1[@id='bfa-page-title']")
    WebElement deviceName;

    @FindBy(xpath = "//button[contains(@class,'ds-popover outline-none ds-pointer')]//span[contains(.,'Upfront')]")
    WebElement deviceUpfrontEligibleCheck;

    @FindBy(xpath = "//label[contains(@class,'position-relative -color')]//input[@checked='checked']")
    WebElement checkedDeviceColor;

    @FindBy(xpath = "//span[@class='dsa-selection__caption text-center sr-only -absolute']/ancestor::label/input")
    List<WebElement> allDeviceColor;

    @FindBy(xpath = "//span[@class='dsa-selection__caption text-center']/ancestor::label//input[@checked='checked']/ancestor::label")
    WebElement checkedDeviceSize;

    //@FindBy(xpath = "//div[@class='ds-price']/ancestor::div[contains(@class,'dsa-price')]")
    @FindBy(xpath="//div[@class='d-flex']")
    WebElement pricingBlock;

    @FindBy(xpath="//p[@class='text-sm mb-24 ng-star-inserted']")
    WebElement pricePlan;

    @FindBy(xpath = "//nav[@class='ds-breadcrumb']")
    WebElement breadCrumb;

    @FindBy(xpath = "//span[@class='dsa-selection__caption text-center']/ancestor::label//input")
    List<WebElement> allDeviceSize;

    @FindBy(xpath = "//div[@class='ds-price']")
    WebElement getPhoneDownPrice;

    @FindBy(xpath = "//p[@class='ng-star-inserted']")
    WebElement getPhoneFullPrice;

    //@FindBy(xpath = "//label[@class='dsa-selection -color']/ancestor::fieldset//legend//span[@class='text-title-5 pl-16']")
    @FindBy(xpath = "(//span[contains(@class,'text-title-5 pl-16')])[1]")
    WebElement colourText;

    @FindBy(xpath = "//div[@class='dsa-promoBlock p-md-24 p-16 ds-bgcolor-misty']")
    WebElement promoBlock;

    @FindBy(xpath = "//nav[@class='ds-breadcrumb']//span[@role='text']")
    WebElement devicesInBreadCrumb;

    @FindBy(xpath = "//span[@class='d-flex mt-16 mb-8 ng-star-inserted']")
    WebElement labelRpotg;

    @FindBy(xpath = "//dsa-selector[@data-test='storage-selector']//span[text()='Storage:']/following-sibling::span")
    WebElement lblStorageValue;

    @FindBy(xpath = "//dsa-selector[@data-test='color-selector']//span[text()='Colour:']/following-sibling::span[1]")
    WebElement lblColorValue;

    @FindBy(xpath = "//div[contains(@data-test,'device-config')]//p[contains(.,'Full') or contains(.,'Plein')]//span")
    WebElement txtDeviceCost;

    @FindBy(xpath = "//span[@class='d-block' and (contains(.,'Upfront') or contains(.,'Voie'))]/following::div[1]")
    WebElement upfrontAmtTxt;

    @FindBy(xpath = "//p[contains(.,'Add Accessories') or contains(.,'Ajoutez des accessoires')]/..")
    WebElement addAccessoriesOption;

    @FindBy(xpath = "//button[@id='continue-accessory-button']")
    WebElement btnContinueAccessories;

    @FindBy(xpath = "//div[contains(@class,'ds-checkboxLabel')]//parent::label[contains(@title,'Device Protection') or contains(@title,'supérieure  de l’appareil')]")
    WebElement deviceProtectionAddon;

    @FindBy(xpath = "//span[@data-test='wirelessDiscount-promo-ribbon']")
    WebElement regularPromoRibbon;

    @FindBy(xpath = "//span[@data-test='wirelessDiscount-promo-ribbon']/following::p[1]")
    WebElement regularPromoDetail;

    @FindBy(xpath = "//button[@id='trident-cta-hup']//span[contains(@class,'ds-button__copy')]")
    WebElement modalContainerDeviceUpgradebutton;

    @FindBy(xpath = "//button[@id='trident-cta-nac']//span[contains(@class,'ds-button__copy')]")
    WebElement modalContainerGetStartedbutton;

    @FindBy(xpath = "//button[@id='trident-cta-aal']//span[contains(@class,'ds-button__copy')]")
    WebElement modalContainerAddALinebutton;

    @FindBy(xpath = "//dsa-promo-block//*[contains(text(),'financing program promotion')]")
    WebElement financeCreditAmount;

    @FindBy(xpath = "//dsa-promo-block//*[contains(text(),'Upfront Edge credit')]")
    WebElement upfrontEdgeAmount;


    /***
     * This method will check the presence of continue button and will return true if present else false
     * @return boolean if the Continue button is visible then return true else false
     * @author saurav.goyal
     */
    public boolean verifyContinueButton() {
        getReusableActionsInstance().waitForElementTobeClickable(continueButton,60);
        if (getReusableActionsInstance().isElementVisible(continueButton)) {
            getReusableActionsInstance().scrollToElement(continueButton);
            return true;
        }
        else
            return false;
    }

    public boolean verifyIsDeviceUpfrontEligible() {
        return getReusableActionsInstance().isElementVisible(deviceUpfrontEligibleCheck,30);
    }

    /***
     * This method will click on Back Order Ship Home button
     * @author saurav.goyal
     */
    public void clickOnBackOrderShipHomebutton() {
        if (getReusableActionsInstance().isElementVisible(backOrderShipHome))
            getReusableActionsInstance().clickIfAvailable(backOrderShipHome, 10);
    }

    /***
     * This method will click on the continue button
     * @author saurav.goyal
     */
    public void clickContinueButton() {
        if (getReusableActionsInstance().isElementVisible(continueButton,60))
            getReusableActionsInstance().staticWait(10000);
            getReusableActionsInstance().clickWhenReady(continueButton);
    }

    /***
     * This method will verify the Device name as it is given in the Deeplink
     * @param deeplink : exact deeplink which we have given in the YML data file
     * @return boolean: return true if the device name on the page matches with the device name in the Deeplink else false
     * @author saurav.goyal
     */
    public boolean verifyDeviceNameWithDeepLink(String deeplink) {
        String phoneNameFromPage = getReusableActionsInstance().getWhenReady(deviceName, 30).getText();
        int phoneIndexInDeepLink = deeplink.indexOf("/phones/") + 8;
        String phoneNameFromDeepLink = deeplink.substring(phoneIndexInDeepLink, deeplink.substring(phoneIndexInDeepLink).indexOf("?") + phoneIndexInDeepLink).replace("-", " ").replaceAll(" Plus", "+");
        if (phoneNameFromPage.equalsIgnoreCase(phoneNameFromDeepLink)) {
            return true;
        }
        return false;
    }

    /**
     * This method will verify the color of a device as it is given in the Deeplink
     *
     * @param deeplink : exact deeplink which we have given in the YML data file
     * @return boolean: return true if the device color on the page matches with the device color in the Deeplink else false
     * @author saurav.goyal
     */
    public boolean verifyDevicecolorWithDeepLink(String deeplink) {
        String phoneColorFromPage = checkedDeviceColor.getAttribute("value");
        int colorIndexInDeepLink = deeplink.indexOf("colour=") + 7;
        String phoneColorFromDeepLink = deeplink.substring(colorIndexInDeepLink, deeplink.substring(colorIndexInDeepLink).indexOf("&") + colorIndexInDeepLink).replace("%20", " ");
        if (phoneColorFromPage.equalsIgnoreCase(phoneColorFromDeepLink)) {
            return true;
        }
        return false;
    }

    /**
     * This method will verify the size of a device as it is given in the Deeplink
     * @param deeplink : exact deeplink which we have given in the YML data file
     * @return boolean: return true if the device size on the page matches with the device size in the Deeplink else false
     * @author saurav.goyal
     */
    public boolean verifyDeviceSizeWithDeepLink(String deeplink) {
        String phoneSizeFromPage = checkedDeviceSize.getAttribute("value");
        String phoneSizeFromDeepLink = deeplink.substring(deeplink.indexOf("storage=") + 8, deeplink.lastIndexOf("&"));
        if (phoneSizeFromPage.equalsIgnoreCase(phoneSizeFromDeepLink)) {
            return true;
        }
        return false;
    }
    /**
     * This method will get Rpotg label info from the device config page
     *
     * @return labelRpotgInfo
     * @author nimmy.george
     */
    public String getRpotgLabelDeviceConfigPage() {
        String labelRpotgInfo = labelRpotg.getText();
        return labelRpotgInfo;
    }

    /**
     * This method will verify whether RPOTG  banner has the eligible postal code displayed once closed
     *
     * @author nimmy.george
     */

    @FindBy(xpath="//dsa-info[contains(@class,'d-block mb-40')]//p[contains(@class,'dsa-info__contentBody text-body mb-0')]")
    WebElement eligiblePostalCodeinBanner;

    public String verifyeligiblePostalCodeinBanner(){
        getReusableActionsInstance().getWhenVisible(eligiblePostalCodeinBanner,20);
        return eligiblePostalCodeinBanner.getText().replaceAll("\\s+","");
    }




    /**
     * This method will get pricing block value from the device config page
     *
     * @return pricingBlockContent : Pricing block value
     * @author saurav.goyal
     */

    public String getPricingBlockValueDeviceConfigPage() {
        String pricingBlockContent = pricingBlock.getText().replaceAll("\\s+","");
        return pricingBlockContent;
    }

    public String getPricePlanValueDeviceConfigPage() {
        String pricePlanContent = pricePlan.getText().replaceAll("\\n+","");
        return pricePlanContent;
    }



    public boolean verifyDefaultColorSelected() {
        for (WebElement deviceColor : allDeviceColor) {
            if (!getReusableActionsInstance().isAttribtuePresent(deviceColor, "disabled")) {
                if (deviceColor.getAttribute("checked").equalsIgnoreCase("true")){
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /**
     * This method will verify whether the default size is selected or not
     * @return true if default size is selected else false
     * @author saurav.goyal
     */
    public boolean verifyDefaultSizeSelected () {
        for (WebElement deviceSize : allDeviceSize) {
            if (!getReusableActionsInstance().isAttribtuePresent(deviceSize, "disabled")) {
                if (deviceSize.getAttribute("checked").equalsIgnoreCase("true")) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /**
     * This method will verify breadcrumb on the device congif page
     * @return true if breadcrumb is appearing fine else false
     * @author saurav.goyal
     */
    public boolean verifyBreadCrumb () {
        String phoneNameFromPage = getReusableActionsInstance().getWhenReady(deviceName, 30).getText();
        if (getReusableActionsInstance().isElementVisible(devicesInBreadCrumb) && breadCrumb.getText().contains(phoneNameFromPage))
            return true;
        return false;
    }

    /**
     * This method will get Down price of a phone
     * @return: String having a down price value
     * @author saurav.goyal
     */
    public String getDownPrice(){
        return getReusableActionsInstance().getWhenReady(getPhoneDownPrice, 10).getText().replaceAll("\\n", " ");
    }

    /**
     * This method will get Full price of a phone
     * @return: String having a Full price value
     * @author Nimmy.George
     */
    public String getFullPrice(){
        return getReusableActionsInstance().getWhenReady(getPhoneFullPrice, 10).getText().replaceAll("\\n", " ");
    }



    /**
     * This method will get device info like name , size , colour
     * @return: String having a device info like name , size , colour
     * @author saurav.goyal
     */
    public String deviceInfoDeviceConfigPage(){
        return getReusableActionsInstance().getWhenReady(deviceName, 30).getText().toUpperCase() + " " + checkedDeviceSize.getAttribute("value").toUpperCase() + " " + colourText.getText().trim().toUpperCase();
    }

    /**
     * This method will get device info like name
     * @return: String having a device info like name
     * @author saurav.goyal
     */
    public String deviceInfoDeviceNameDeviceConfigPage () {
        return getReusableActionsInstance().getWhenReady(deviceName, 30).getText().toUpperCase();
    }

    /**
     * This method will get device info like size
     * @return: String having a device info like size
     * @author saurav.goyal
     */
    public String deviceInfoDeviceSizeDeviceConfigPage () {
        return checkedDeviceSize.getAttribute("aria-label").toUpperCase();
    }

    /**
     * This method will get device info like colour
     * @return: String having a device info like colour
     * @author saurav.goyal
     */
    public String deviceInfoDeviceColorDeviceConfigPage () {
        if (colourText.getText().trim().toUpperCase().equals("GREY"))
            return "Grey";
        else if (colourText.getText().trim().toUpperCase().equalsIgnoreCase("Gris"))
            return "Gris Cosmique";
        return colourText.getText().trim().toUpperCase();
    }

    /**
     * This method checks if
     * @param colorOfDevice : color of the device
     * @param allDeviceSkus List of all device SKUs
     * @return boolean true if device color is present in device config page else false
     * @author praveen.kumar7
     */
    public boolean isSkuValid(List<WebElement> allDeviceSkus, String colorOfDevice) {
        for(WebElement deviceSku : allDeviceSkus) {
            if((deviceSku.getAttribute("value").equals(colorOfDevice)))
                return true;
        }
        return false;
    }

    /**
     * This method creates a xpath for the device color based on the string passed
     * @param colorOfDevice : color of the device to be selected
     * @return a string format of xpath
     * @author praveen.kumar7
     */
    public String createXpathWithDeviceColor(String colorOfDevice) {
        List<WebElement> allDeviceSkus = getDriver().findElements(By.xpath("//label[contains(@class,'position-relative -color')]//input"));
        boolean isSkuColorExist = isSkuValid(allDeviceSkus,colorOfDevice);
        if((colorOfDevice == null) || (colorOfDevice.isEmpty()) || !(isSkuColorExist)) {
            WebElement element = allDeviceSkus.get(0);
            String firstSkuColor = element.getAttribute("value");
            return "//label[contains(@class,'position-relative -color')]//input[@value='"+firstSkuColor+"']/following::span[1]";
        }
        else return "//label[contains(@class,'position-relative -color')]//input[@value='"+colorOfDevice+"']/following::span[1]";
    }

    /**
     * This method will select a device color on device config page
     * @param deviceColor : color of the device which we needs to be selected
     * @author praveen.kumar7
     */
    public void selectDeviceColor(String deviceColor){
        String xPathOfSkuToBeSelected = createXpathWithDeviceColor(deviceColor);
        getReusableActionsInstance().clickWhenVisible(By.xpath(xPathOfSkuToBeSelected),30);
    }

    /**
     * This method will select a device size on device config page
     * @param deviceSize: color of the device which we need to select
     * @author saurav.goyal
     */
    public void selectDeviceSize (String deviceSize){
        getReusableActionsInstance().clickWhenReady(By.xpath("//span[contains(@data-caption,'" + deviceSize + "')]/ancestor::span"), 10);
    }

    /**
     * This method will get Promo Block Text
     * @return String : of a get Promo Block Text
     * @author Pranav.Shaligram
     */
    public String getPromoBlockText () {
    	getReusableActionsInstance().javascriptScrollByVisibleElement(promoBlock);
        return getReusableActionsInstance().getWhenReady(promoBlock, 10).getText().trim().replaceAll("\\n", " ");
    }

    /**
     * This method will be used to convert color from english to french
     * @param color : Accept a color in english from the user which we need to convert to french
     * @return String : Returns the corresponding name of the color in French
     * @author Saurav.Goyal
     */
    public String convertColor (String color){
        if (color.equalsIgnoreCase("green"))
            return "Vert";
        else if (color.equalsIgnoreCase("black"))
            return "Noir";
        else if (color.equalsIgnoreCase("purple"))
            return "Violet";
        else if (color.equalsIgnoreCase("red"))
            return "Rouge";
        else if (color.equalsIgnoreCase("white"))
            return "Blanc";
        else if (color.equalsIgnoreCase("yellow"))
            return "Jaune";
        else
            return "no color";
    }

    /**
     * Get the Device Name as in the page title
     * @return Device Name
     * @author rajesh.varalli1
     */
    public String getDeviceName() {
        try {
            getReusableActionsInstance().waitForElementTobeClickable(deviceName,30);
        } catch (DigiAutoCustomException e) {
            return null;
        }
        return deviceName.getText().trim();
    }

    /**
     * Navigates back to the previous page
     * and waits for 3 seconds
     * @author rajesh.varalli1
     */
    public void navigateBack() {
        getDriver().navigate().back();
        getReusableActionsInstance().staticWait(1000);
    }

    public String getSelectedStorage() {
        return lblStorageValue.getText().trim().replace(" ","");
    }

    public String getSelectedColor() {
        return lblColorValue.getText().trim().replace(" ","");
    }

    public String getSelectedSize() {
        getReusableActionsInstance().staticWait(3000);
        WebElement lblSizeValue = getDriver().findElement(By.xpath("//div[contains(@class,'common-devices') and contains(@class,'active')]//div[contains(@class,'size-switch') and contains(@class,'active')]/a"));
        return lblSizeValue.getText().trim().replace(" ","");
    }

    public String getSelectedWatchColor() {
        String btnWatchColor = getDriver().findElement(By.xpath("//div[contains(@class,'color-switch') and contains(@class,'active') and @style='display: block;']/a")).getAttribute("class").split("-")[0];
        return btnWatchColor.trim().replace(" ","");
    }

    /**
     * This method will get the NOTERM cost of the device
     * @param className name of the classname from where the method is called
     * @return full price of the device
     * @author praveen.kumar7
     */
    public String getDeviceFullPrice(String className) {
        if (className.toUpperCase().contains("_FR")) {
            String deviceFullPriceFR = getReusableActionsInstance().getWhenReady(txtDeviceCost).getText().trim();
            return deviceFullPriceFR.substring(0, deviceFullPriceFR.indexOf(","));
        } else {
            String deviceFullPriceEN = getReusableActionsInstance().getWhenReady(txtDeviceCost).getText().trim();
            return deviceFullPriceEN.replaceAll("[^0-9.]","");
        }
    }

    /**
     * Finance Program Credit price will be return
     * @param className name of the classname from where the method is called
     * @return Finance Program Credit price
     * @author Vedachalam.Vasudevan
     */
    public String getFinanceProgramCreditPrice(String className) {
        String financeCredit = "0.0";
        if(getReusableActionsInstance().isElementVisible(financeCreditAmount)) {
             financeCredit = getReusableActionsInstance().getWhenReady(financeCreditAmount).getText().trim();
             return financeCredit.substring(financeCredit.indexOf("$") + 1, financeCredit.indexOf("/"));
        } else {
            return financeCredit;
        }
    }

    /**
     * Upfront Edge price will be return
     * @param className name of the classname from where the method is called
     * @return Upfront Edge price
     * @author Vedachalam.Vasudevan
     */
    public String getUpfrontEdgePrice(String className) {
        String upfrontEdgeAmt = "0.0";
        if(getReusableActionsInstance().isElementVisible(upfrontEdgeAmount)) {
            upfrontEdgeAmt = getReusableActionsInstance().getWhenReady(upfrontEdgeAmount).getText().trim();
            return upfrontEdgeAmt.substring(upfrontEdgeAmt.indexOf("$")+1,upfrontEdgeAmt.indexOf("U")-1);
        } else {
            return upfrontEdgeAmt;
        }
    }

    /**
     * This method will get the upfront edge amount of the device
     * @param className className name of the classname from where the method is called
     * @return upfront edge amount of the device
     * @author praveen.kumar7
     */
    public String getUpfrontEdgeAmt(String className) {
        if(className.toUpperCase().contains("_FR")) {
            getReusableActionsInstance().clickWhenVisible(By.xpath("//ds-icon[contains(@class,'ds-popover__icon')]"),10);
            String upfrontEdgeAmt = getReusableActionsInstance().getWhenReady(upfrontAmtTxt).getText().trim();
            getReusableActionsInstance().clickWhenVisible(By.xpath("//button[contains(@class,'close')]//ds-icon[@name='close']"),10);
            return upfrontEdgeAmt.substring(1, upfrontEdgeAmt.indexOf(","));
        }
        else {
            getReusableActionsInstance().executeJavaScriptClick(getReusableActionsInstance().getWhenReady(By.xpath("//ds-icon[contains(@class,'ds-popover__icon')]"),10));
            String upfrontEdgeAmt = getReusableActionsInstance().getWhenReady(upfrontAmtTxt).getText().trim();
            getReusableActionsInstance().javascriptScrollToTopOfPage();
            getReusableActionsInstance().executeJavaScriptClick(getReusableActionsInstance().getWhenReady(By.xpath("//button[contains(@class,'close')]//ds-icon[@name='close']"),10));
            return upfrontEdgeAmt.substring(2, upfrontEdgeAmt.indexOf("."));
        }
    }

    /**
     * This method verifies if accessories option is displayed
     * @return true if Add accessories option is displayed, else false
     * @author praveen.kumar7
     */
    public boolean verifyAddAccessoriesOption() {
        return getReusableActionsInstance().isElementVisible(addAccessoriesOption);
    }

    /**
     * This method clicks on Add accessories option
     * @author praveen.kumar7
     */
    public void clkAddAccessoriesOption() {
        getReusableActionsInstance().clickWhenVisible(addAccessoriesOption);
    }

    /**
     * This method add the accessories to the cart
     * @param accessoryCount
     * @param accessory1
     * @param accessory2
     * @author praveen.kumar7
     */
    public void addAccessoriesToCart(String accessoryCount, String accessory1, String accessory2) {
        if(accessoryCount.equalsIgnoreCase("MULTIPLE")) {
            //getReusableActionsInstance().clickWhenVisible(By.xpath("//p[contains(.,'"+accessory1+"')]/../following-sibling::div//button[@title='Add']"));
            //getReusableActionsInstance().clickWhenVisible(By.xpath("//button[@id='ds-tabs-0-tab-2']"));
            getReusableActionsInstance().clickWhenVisible(By.xpath("//p[contains(.,'"+accessory1+"')]/../following-sibling::div//button[@data-test='add-to-cart']"));
            getReusableActionsInstance().clickWhenVisible(By.xpath("//p[contains(.,'"+accessory2+"')]/../following-sibling::div//button[@data-test='add-to-cart']"));
            getReusableActionsInstance().javascriptScrollToTopOfPage();
            getReusableActionsInstance().clickWhenVisible(By.xpath("//span[contains(.,'"+accessory1+"')]/../following-sibling::div//button[@title='Add']"));
        }
        else {
            getReusableActionsInstance().clickWhenVisible(By.xpath("//p[contains(.,'"+accessory1+"')]/../following-sibling::div//button[@data-test='add-to-cart']"));
        }
    }

    /**
     * This method clicks on continue button after selecting accessories
     * @author praveen.kumar7
     */
    public void clkContinueAccessories() {
        getReusableActionsInstance().clickWhenVisible(btnContinueAccessories);

    }

    /**
     * This method clicks on Device Protection Tab in Add-ons stepper
     * @author Subash.Nedunchezhian
     */
    public void selectDeviceProtectionAddon(){
        getReusableActionsInstance().clickWhenReady(deviceProtectionAddon,20);
    }

    /**
     * This method verifies Regular Promo Ribbon on Device Config page
     * @return true if Regular Promo Ribbon displayed else false
     * @author subash.nedunchezhian
     */
    public boolean verifyRegularPromoRibbon() {
        getReusableActionsInstance().waitForElementVisibility(regularPromoRibbon,10);
        getReusableActionsInstance().scrollToElement(regularPromoRibbon);
        return getReusableActionsInstance().isElementVisible(regularPromoRibbon);
    }

    /**
     * This method gets Regular Promo Discount value and Promo Duration text on Device Config page
     * @return Regular Promo Discount value and Promo Duration text
     * @author subash.nedunchezhian
     */
    public String getRegularPromoDetails(){
        getReusableActionsInstance().scrollToElement(regularPromoDetail);
        return regularPromoDetail.getText().replaceAll("\\n", "");
    }

    /**
     * This method clicks on Upgrade my phone button on the modal
     * @author Subash.Nedunchezhian
     */
    public void clickUpgradeMyPhoneButtonOnModal() {
        getReusableActionsInstance().clickWhenReady(modalContainerDeviceUpgradebutton , 20);
    }

    /**
     *  This method clicks on Add a line button on the existing customer modal
     *  @author Subash.Nedunchezhian
     */
    public void clickAddALineButtonOnModal() {
        getReusableActionsInstance().clickWhenReady(modalContainerAddALinebutton,20);
    }
}