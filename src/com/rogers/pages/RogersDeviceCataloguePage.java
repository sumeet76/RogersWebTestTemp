package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RogersDeviceCataloguePage extends BasePageClass {

    public String xpathDeviceName;
    public String manufacturerFilterXpath;
    public String manufacturerFilterLableXpath;
    public String pageRadioButtonXpath;
    public String postalCode;

    public RogersDeviceCataloguePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ds-modal-container")
    WebElement modalContainer;

    @FindBy(xpath = "//a[@class='learMoreLink ds-pointer mw-100']")
    WebElement learnMoreBannerLearnMore;

    @FindBy(xpath = "(//span[contains(.,'Check eligibility')])[2]")
    WebElement checkEligibilityRpotgBanner;

    @FindBy(xpath="//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white']")
    WebElement postalCodeRpotgBanner;

    @FindBy(xpath = "//input[@id='ds-form-input-id-0']")
    WebElement inputPostalCodeRpotgBanner;

    @FindBy(xpath = "//div[@class='tippy-content']")
    WebElement popOver;

    @FindBy(xpath = "//div[@class='tippy-content']")
    WebElement comingSoonTextTitle;

    @FindBy(xpath = "//ds-modal-container//*[@id=\"trident-cta10\"]")
    WebElement modalContainerDeviceUpgradebutton;

    @FindBy(xpath = "//button[@id='trident-cta-nac']")
    WebElement modalContainerGetStartedbutton;

    @FindBy(xpath = "//ds-modal-container//*[@id=\"trident-cta11\"]")
    WebElement modalContainerAddALinebutton;

    @FindBy(xpath = "(//button[contains(@variant,'icon')])[2]")
    WebElement modalContainerClosebutton;

    @FindBy(xpath = "//*[contains(@class,'ds-radioButton__innerCircle')]")
    List<WebElement> filterRadioButton;

    @FindBy(xpath = "//input[contains(@class,'ds-radioButton__input')]")
    List<WebElement> filterRadioButtonText;

    @FindBy(xpath = "//*[contains(@class,'ds-checkbox__input')]")
    List<WebElement> filterCheckBox;

    @FindBy(xpath = "//dsa-device-tile/ancestor::div[@class='row']//p[contains(@class,'text-title')][not(contains(@class,'dsa-info'))]")
    List<WebElement> allFilteredDevices;

    @FindBy(xpath = "//div[@class='m-buttonSet']")
    WebElement resetAllFiltersbutton;

    @FindBy(xpath = "(//p[@class='dsa-info__contentHeader align-self-center text-title-4 mb-0'])[2]")
    WebElement rpotgBannerText;

    @FindBy(xpath = "//button[@title='Check']")
    WebElement checkBtn;

    @FindBy(xpath = "//button[@title='Continue']")
    WebElement continueBtn;

    @FindBy(xpath = "(//p[contains(@class,'dsa-info__contentBody text-body mb-0')])[2]")
    WebElement eligiblePostalCodeinBanner;


    String deviceTextXpath = xpathDeviceName + "//following-sibling::dsa-price//span[contains(@class,'dsa-price__copyBottom')]";

    /**
     * This method gets the title text of a coming soon Device
     *
     * @param deviceName : Device name given in the yml file
     * @return : String of title text
     * @author saurav.goyal
     */
    public String getComingSoonTextTitle(String deviceName) {
        xpathDeviceName = createXpathWithDeviceName(deviceName);
        deviceTextXpath = xpathDeviceName + "//following-sibling::p";
        return getReusableActionsInstance().getWhenReady(By.xpath(deviceTextXpath), 10).getText();
    }

    /**
     * This method creates Xpath of a particular device with device name
     * @param	deviceName : Name of the device to be used as reference for creating the xpath
     * @return a String value which is an xpath for a device name
     * @author nimmy.george
     */
    public String createXpathWithDeviceName(String deviceName) {
        xpathDeviceName="//p[@class='text-title-5 '][contains(.,'"+deviceName+"')]";
        return xpathDeviceName;
    }



    /**
     * This method will get Down price of a phone
     * @param deviceName : name of the Device for which we need down price
     * @return: String having a down price value
     * @author saurav.goyal
     */
    public String getDownPrice(String deviceName) {
        xpathDeviceName = createXpathWithDeviceName(deviceName);
        String deviceDownPriceXpath = xpathDeviceName + "//following-sibling::dsa-price//ds-price";
        return getReusableActionsInstance().getWhenReady(By.xpath(deviceDownPriceXpath), 10).getText().replaceAll("\\n"," ");
    }

    /**
     * This method will give you the Name of the phone over the page
     * @param deviceName : name of the Device to be used to generate Xpath
     * @return return the name of Device
     * @author saurav.goyal
     */
    public String getPhoneName(String deviceName) {
        xpathDeviceName = createXpathWithDeviceName(deviceName);
        return getReusableActionsInstance().getWhenReady(By.xpath(xpathDeviceName), 10).getText().trim();
    }

    /**
     * This method gets the title text of a Device from the Device Tile
     * @param deviceName : name of the Device to be used to generate Xpath
     * @return returns the title of the Phone
     * @author saurav.goyal
     */
    public String getPhoneTileText(String deviceName) {
        xpathDeviceName = createXpathWithDeviceName(deviceName);
        deviceTextXpath = xpathDeviceName + "//following-sibling::dsa-price//span[contains(@class,'dsa-price__copyBottom')]";
        return getReusableActionsInstance().getWhenReady(By.xpath(deviceTextXpath), 10).getText().trim();
    }

    /**
     * This method gets the strike price of a given device
     * @param deviceName : name of the Device to be used to generate Xpath
     * @return return the strike price of the phone
     * @author saurav.goyal
     */
    public String getPhoneStrikePrice(String deviceName) {
        xpathDeviceName = createXpathWithDeviceName(deviceName);
        String deviceStrikePriceXpath = xpathDeviceName + "//following-sibling::p//strike";
        return getReusableActionsInstance().getWhenReady(By.xpath(deviceStrikePriceXpath), 10).getText().trim();
    }

    /**
     * This method gets the full price of a phone
     * @param deviceName : name of the Device to be used to generate Xpath
     * @return return the full price of the phone
     * @author nimmy.george
     */
    public String getPhoneFullPrice(String deviceName) {
        xpathDeviceName = createXpathWithDeviceName(deviceName);
        String deviceFullPriceXpath = xpathDeviceName + "/../p[@class='text-body-sm mb-0 text-semi']";
        return getReusableActionsInstance().getWhenReady(By.xpath(deviceFullPriceXpath), 10).getText().trim();
    }

    /**
     * This method creates Xpath of a particular CTA button
     * @param	deviceName : name of the device used to create the xpath
     * @return a String value which is an xpath for a CTA button
     * @author saurav.goyal
     */
    public String createXpathForCTAButton(String deviceName) {
        xpathDeviceName = createXpathWithDeviceName(deviceName);
        String ctaButtonXpath = xpathDeviceName + "/..//following-sibling::div//span[contains(@class,'ds-button__copy')]";
        return ctaButtonXpath;
    }

    /**
     * This method Clicks on a device Tile CTA button for a particular phone
     * @param deviceName : name of the Device to be used to generate Xpath
     * @author saurav.goyal
     */
    public void clickDeviceTileCTAButton(String deviceName) {
        getReusableActionsInstance().clickWhenVisible(By.xpath(createXpathForCTAButton(deviceName)), 10);
    }

    /**
     * This method will verify that the device tile CTA button is present or not
     * @param deviceName : name of the Device for which we want to verify device tile CTA button
     * @return boolean true if the CTA button is present else false
     * @author saurav.goyal
     */
    public boolean verifyDeviceTileCTAButton(String deviceName) {
        return getReusableActionsInstance().isElementVisible(By.xpath(createXpathForCTAButton(deviceName)), 10);
    }

    /**
     * This method check whether a Modal page is getting displayed or not
     * @return a boolean value true if a modal window will appear else false
     * @author saurav.goyal
     */
    public boolean isModalDisplayed() {
        return getReusableActionsInstance().isElementVisible(modalContainer);
    }

    /**
     * This method will click over the pop over of a phone
     * @param deviceName : name of the Device to be used to generate Xpath
     * @author saurav.goyal
     */
    public void clickPopOverVerifyText(String deviceName) {
        xpathDeviceName = createXpathWithDeviceName(deviceName);
        String popOverXpath = xpathDeviceName + "//following-sibling::dsa-price//span[@class='ds-popover__iconWrapper']";
        getReusableActionsInstance().clickWhenVisible(By.xpath(popOverXpath),10);
    }

    /**
     * This method gets the text from the popover the available text
     * @return a text of the particular element (PopOver)
     * @author saurav.goyal
     */
    public String getTextPopOver() {
        return getReusableActionsInstance().getWhenReady(popOver, 10).getText();
    }

    /**
     * This Method will create xpath for all the check boxes on the Device catalogue page
     * @param filterName	: name of the Filter e.g: Samsung , Apple
     * @return a String of xpath for that particular object
     * @author saurav.goyal
     */
    public String createXpathForCheckBox(String filterName) {
        pageRadioButtonXpath = "//*[contains(@class,'ds-checkbox__input')][@name='" + filterName + "']";
        return pageRadioButtonXpath;
    }

    /**
     * This method will check which filter is selected as per the DeepLink provided
     * @param filteredLink : deeplink which we have used to to get the device name against which filter is applied
     * @return boolean : Return true if same filter is checked else false
     * @author saurav.goyal
     */
    public boolean verifyFilteredDevicesCheckBox(String filteredLink) {
        String filterParameterInDeeplink = filteredLink.substring(filteredLink.indexOf("=") + 1);
        String pageRadioButtonXpath = createXpathForCheckBox(filterParameterInDeeplink);
        return getReusableActionsInstance().getWhenReady(By.xpath(pageRadioButtonXpath), 10).getAttribute("aria-checked").equalsIgnoreCase("true");
    }

    /**
     * This Method will create xpath for all the radio buttons on the Device catalogue page
     * @param filterName	: name of the Filter e.g: New , Certified Pre-Owned
     * @return a String of xpath for that particular object
     * @author saurav.goyal
     */
    public String createXpathForRadiobuttons(String filterName) {
        pageRadioButtonXpath = "//div[contains(text(),filterName)]/..//div[@class='ds-radioButton__innerCircle']";
        return pageRadioButtonXpath;
    }

    /**
     * This method will check which filter radio button is selected as per the DeepLink provided
     * @param filteredLink 	: deeplink which we have used to to get the device name against which filter is applied
     * @return boolean : if radio button is selected then return true else false
     * @author saurav.goyal
     */
    public boolean verifyFilteredDevicesRadioButton(String filteredLink) {
        String filterON = filteredLink.substring(filteredLink.indexOf("=") + 1);
        pageRadioButtonXpath = createXpathForRadiobuttons(filterON);
        return getReusableActionsInstance().getWhenReady(By.xpath(pageRadioButtonXpath), 20).getCssValue("opacity").equals("1");
    }

    /**
     * This method will check deepLink with Default Language as FR or EN
     * @param deeplink :exact deeplink which we have given in the YML data file
     * @param languageFromElement: language which we want to verify in the deeplink
     * @return boolean : if language is correctly selected as per the deeplink then return true else false
     * @author saurav.goyal
     */
    public boolean verifyDeepLinkWithLanguage(String deeplink , String languageFromElement) {
        String languageFromDeeplink = deeplink.substring(deeplink.indexOf("=") + 1, deeplink.indexOf("&"));
        if(languageFromDeeplink.toUpperCase().contains("EN") && languageFromElement.contains("FR")) {
            return true;
        }else return languageFromDeeplink.toUpperCase().contains("FR") && languageFromElement.contains("EN");
    }

    /**
     * This method will verify that no filter is selected by default
     * @return boolean : True if no filter is selected by default else false
     * @author saurav.goyal
     */
    public boolean verifyNoFilterSelectedByDefault() {
        getReusableActionsInstance().waitForAllElementsVisible(filterCheckBox, 10);
        for(WebElement eachCheckBox: filterCheckBox) {
            if(getReusableActionsInstance().getWhenReady(eachCheckBox, 10).getAttribute("aria-checked").equalsIgnoreCase("true")) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method will create a xpath for the manufacturer filter
     * @param manufacturerName : Name of the manufacturer for which we want to filter
     * @return String having a xpath for that particular manufacturer
     * @author saurav.goyal
     */
    public String createXpathForManufacturerFilter(String manufacturerName) {
        manufacturerFilterXpath = "//input[@type='checkbox'][@id='" + manufacturerName + "']//following-sibling::div[contains(@class,'ds-checkbox__box')]";
        return manufacturerFilterXpath;
    }

    /**
     * This method will select a particular Manufacturer filter
     * @param manufacturerName : Name of the manufacturer for which we need to apply a filter
     * @author saurav.goyal
     */
    public void selectManufacturerFilter(String manufacturerName) {
        manufacturerFilterXpath = createXpathForManufacturerFilter(manufacturerName);
        getReusableActionsInstance().clickWhenReady(By.xpath(manufacturerFilterXpath));
    }

    /**
     * This method will verify the Filtered devices on the page after applying filter
     * @param manufacturerName : Pass the name of the manufacturer for which filter has been applied
     * @return boolean returns true if the filtered devices matches with manufacturer else return false
     * @author saurav.goyal
     */
    public boolean verifyManufacturerFilteredDevices(String manufacturerName) {
        if(manufacturerName.equalsIgnoreCase("Apple")) {
            for(WebElement filteredDeviceText: allFilteredDevices) {
                if(!getReusableActionsInstance().getWhenReady(filteredDeviceText, 10).getText().toUpperCase().contains("IPHONE")) {
                    if(!getReusableActionsInstance().getWhenReady(filteredDeviceText, 10).getText().toUpperCase().contains("APPLE"))
                        return false;
                }
            }
        }else if(manufacturerName.equalsIgnoreCase("Motorola")) {
            for(WebElement filteredDeviceText: allFilteredDevices) {
                if(!getReusableActionsInstance().getWhenReady(filteredDeviceText, 10).getText().toUpperCase().contains("MOTO"))
                    return false;
            }
        }else {
            for(WebElement filteredDeviceText: allFilteredDevices) {
                if(!getReusableActionsInstance().getWhenReady(filteredDeviceText, 10).getText().toUpperCase().contains(manufacturerName.toUpperCase()))
                    return false;
            }
        }
        return true;
    }

    /**
     * This method will create xpath to get label value of a manufacturer filter
     * @param manufacturerName :  Pass the name of the manufacturer for which filter has been applied
     * @return : the String xpath of a label value of a manufacturer filter
     * @author saurav.goyal
     */
    public String createXpathForManufacturerFilterLabelValue(String manufacturerName) {
        manufacturerFilterLableXpath = "//input[@type='checkbox'][@id='" + manufacturerName + "']//following-sibling::div[contains(@class,'ds-checkboxLabel')]";
        return manufacturerFilterLableXpath;
    }

    /**
     * This method will compare the Filtered Device count with the total count present in the label
     * @param manufacturerName : Pass the name of the manufacturer for which filter has to apply
     * @return boolean true if count matches else false
     * @author saurav.goyal
     */
    public boolean compareCountManufacturerFilterValueAndActualAfterFilter(String manufacturerName) {
        int numberOfDevicesAfterfilter = allFilteredDevices.size();
        return numberOfDevicesAfterfilter == getCountManufacturerFilterValue(manufacturerName);
    }

    /**
     * This method will get the count of the filtered value from the label
     * @param manufacturerName : Pass the name of the manufacturer for which filter has to apply
     * @return : int having the count from the label of a filtered value
     * @author saurav.goyal
     */
    public int getCountManufacturerFilterValue(String manufacturerName) {
        manufacturerFilterLableXpath = createXpathForManufacturerFilterLabelValue(manufacturerName);
        String manufacturerFilterLabel= getReusableActionsInstance().getWhenReady(By.xpath(manufacturerFilterLableXpath) , 10).getText();
        return Integer.valueOf(manufacturerFilterLabel.substring(manufacturerFilterLabel.length()-2,manufacturerFilterLabel.length()-1));
    }

    /**
     * This method verifies whether or not Get Started button is available in a model
     * @return a boolean true if element is present else false
     * @author saurav.goyal
     */
    public boolean verifyGetStartedButtonOnModal() {
        return getReusableActionsInstance().isElementVisible(modalContainerGetStartedbutton);

    }

    /**
     * This method verifies whether or not Device Upgrade button is available in a model
     * @return a boolean true if element is present else false
     * @author saurav.goyal
     */
    public Boolean verifyDeviceUpgradeButtonOnModal() {
        return getReusableActionsInstance().isElementVisible(modalContainerDeviceUpgradebutton);
    }

    /**
     * This method verifies whether or not Add a line button is available in a model
     * @return a boolean true if element is present else false
     * @author saurav.goyal
     */
    public Boolean verifyAddALineButtonOnModal() {
        return getReusableActionsInstance().isElementVisible(modalContainerAddALinebutton);
    }

    /**
     * This method verifies whether or not a close(X) button is available in a model
     * @return a boolean true if element is present else false
     * @author saurav.goyal
     */
    public Boolean verifyCloseButtonOnModal() {
        return getReusableActionsInstance().isElementVisible(modalContainerClosebutton);
    }

    /**
     * This method clicks on a close(X) button available in a model
     * @author saurav.goyal
     */
    public void clickCloseButtonOnModal() {
        getReusableActionsInstance().clickIfAvailable(modalContainerClosebutton, 10);
    }

    /**
     * This method clicks on a Get Started button in a Modal window
     * @return a boolean true if continue is present on the next device config page
     * Question about getting methods of one page to other
     * @author saurav.goyal
     */
    public Boolean clickGetStartedButtonOnModal() {
        getReusableActionsInstance().clickIfAvailable(modalContainerGetStartedbutton);
        return (getReusableActionsInstance().isElementVisible(new RogersDeviceConfigPage(getDriver()).continueButton, 30));
    }


    /**
     * This method will click on Reset all filters
     * @author saurav.goyal
     */
    public void clickResetAllFilters() {
        getReusableActionsInstance().clickIfAvailable(resetAllFiltersbutton, 10);
    }

    /**
     * This method will get pricing block value from the device catalogue page
     * @param deviceName : name of the device for which pricing block is required
     * @return pricingBlockContent : Pricing block value
     * @author nimmy.george
     * @throws InterruptedException 
     */
    public String getPricingBlockCataloguePage(String deviceName) throws InterruptedException{
    	Thread.sleep(5000);
        xpathDeviceName=createXpathWithDeviceName(deviceName);
        String pricingBlockContentXpath = xpathDeviceName + "/parent::div/div";
        getReusableActionsInstance().waitForElementVisibility(getDriver().findElement(By.xpath(createXpathForCTAButton(deviceName))),40);
        return getReusableActionsInstance().getWhenReady(By.xpath(pricingBlockContentXpath), 20).getText().replaceAll("\\s+","");
    }


    /**
     * This method will get pricing Plan value from the device catalogue page
     * @param deviceName : name of the device for which pricing plan info is required
     * @return pricePlanContent : Price Plan value
     * @author Nimmy. George
     */
    public String getPricePlanInfoCataloguePage(String deviceName){
        xpathDeviceName=createXpathWithDeviceName(deviceName);
        String pricePlanContentXpath=xpathDeviceName + "/..//p[@class='text-sm mb-24']";
        return getReusableActionsInstance().getWhenReady(By.xpath(pricePlanContentXpath), 10).getText().replaceAll("\\n"," ");
    }


    /**
     * This method will get the label of the phone
     * @return String: Label of the phone
     * @param deviceName : name of the Device to be used to generate Xpath
     * @author Pranav.Shaligram
     */
    public String getPhoneLabelText(String deviceName) {
        xpathDeviceName = createXpathWithDeviceName(deviceName);
        String deviceLblXpath = xpathDeviceName + "//ancestor::ds-tile//span[contains(@class,'dsa-deviceTile__label')]";
        return getReusableActionsInstance().getWhenReady(By.xpath(deviceLblXpath), 10).getText();
    }

    public String getDeviceNameFromDeepLink(String deeplink) {
        int phoneIndexInDeepLink = deeplink.indexOf("/phones/") + 8;
        String phoneNameFromDeepLink = deeplink.substring(phoneIndexInDeepLink, deeplink.substring(phoneIndexInDeepLink).indexOf("?") + phoneIndexInDeepLink).replace("-", " ").replace("_", " ").replaceAll(" Plus", "+");
        return phoneNameFromDeepLink;
    }

    /**
     * This method will check whether RPOTG Banner is present in the Device Catalog Page
     *
     * @author nimmy.george
     */

    public boolean isRpotgBannerPresent() {
         return getReusableActionsInstance().isElementVisible(rpotgBannerText,40);
    }


    /**
     * This method will click on Rpotg Banner LearnMore link
     *
     * @author nimmy.george
     */

    public void clickRpotgBannerLearnMore() {
        getReusableActionsInstance().clickIfAvailable(learnMoreBannerLearnMore);

    }

    /**
     * This method will click on the Check Eligibility button in the RPOTG banner
     *
     * @author nimmy.george
     */

    public void clickCheckEligibilityRpotgBanner() {
        getReusableActionsInstance().clickWhenReady(checkEligibilityRpotgBanner);
    }

    /**
     * This method will enter the Postalcode in the check eligibility Rpotg Banner
     *
     * @author nimmy.george
     */
    public void validateRpotgPostalCode(String postalCode) {
        getReusableActionsInstance().javascriptScrollByVisibleElement(postalCodeRpotgBanner);
        getReusableActionsInstance().getWhenReady(postalCodeRpotgBanner).click();
        getReusableActionsInstance().getWhenVisible(inputPostalCodeRpotgBanner).sendKeys(postalCode);
    }

    /**
     * This method will click on the postal code check button in the RPOTG eligibility banner
     *
     * @author nimmy.george
     */

    public void clickCheckBtn() {
        getReusableActionsInstance().getWhenVisible(checkBtn, 30);
        getReusableActionsInstance().doubleClick(checkBtn,0);
        getReusableActionsInstance().doubleClick(checkBtn,0);
    }

    /**
     * This method will click on the continue button in the RPOTG eligibility banner
     *
     * @author nimmy.george
     */

    public void clickContinueBtn() {
        getReusableActionsInstance().clickWhenReady(continueBtn, 30);
    }


    /**
     * This method will verify whether RPOTG  banner has the eligible postal code displayed once closed
     *
     * @author nimmy.george
     */

    public String verifyeligiblePostalCodeinBanner() {
        getReusableActionsInstance().getWhenVisible(eligiblePostalCodeinBanner, 20);
        return eligiblePostalCodeinBanner.getText().replaceAll("\\s+", "");
    }

    /**
     * This method will get Rpotg label from the Device Tile
     *
     * @param deviceName : name of the device for which Rpotg label is required
     * @return deviceTileRpotgLabel : Rpotg Label
     * @author nimmy.george
     */

    public String getRpotgLabelCataloguePage(String deviceName){
        xpathDeviceName=createXpathWithDeviceName(deviceName);
        String deviceTileRpotgLabelXpath = xpathDeviceName + "/../../..//span[@variant='custom']";
        return getReusableActionsInstance().getWhenReady(By.xpath(deviceTileRpotgLabelXpath),20).getText();
    }
}