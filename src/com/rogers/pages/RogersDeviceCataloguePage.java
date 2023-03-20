package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import com.rogers.test.base.BaseTestClass;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.LoginSessionAuth;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    @FindBy(xpath = "//div[contains(@data-test,'credit-evaluation')]/ancestor::ds-modal-container")
    WebElement popupCreditEval;

    @FindBy(xpath = "//ds-modal-container//p[contains(text(),'Credit Evaluation') or contains(text(),'Évaluation de crédit')]")
    WebElement txtCreditEval;

    @FindBy(xpath = "//ds-modal[contains(@data-test,'sharedNonShared')]/ancestor::ds-modal-container")
    WebElement sharedNonSharedModal;

    @FindBy(xpath = "//ds-modal-container//label[contains(@class,'dsa-selection d-inline-block ds-pointer')][contains(@aria-label,'partager') or contains(@aria-label,'shared Rogers')]")
    WebElement sharedOption;

    @FindBy(xpath = "//ds-modal-container//label[contains(@class,'dsa-selection d-inline-block ds-pointer')][contains(@aria-label,'Forfait distinct sans') or contains(@aria-label,'separate plan')]")
    WebElement nonSharedOption;

    @FindBy(xpath = "//span[contains(text(),'Continue')]/ancestor::button[contains(@data-test,'shared-nonshared-continue')]")
    WebElement modalContinueButton;

    @FindAll({
            @FindBy(xpath = "//div[contains(@class,'dsa-tile-teaser')]//p[contains(text(),'Bring') or contains(text(),'Apportez')]"),
            @FindBy(xpath = "(//div[contains(@class,'dsa-tile-teaser')]//a[contains(@aria-label,'SHOP PLANS SHOP PLANS')])[1]")
    })
     WebElement byodDeviceTile;

    @FindAll({
            @FindBy(xpath = "//p[contains(text(),'Bring') or contains(text(),'Apportez')]/parent::div[contains(@class,'dsa-tile-teaser')]//a"),
            @FindBy(xpath = "(//div[contains(@class,'dsa-tile-teaser')]//a[contains(@aria-label,'SHOP PLANS SHOP PLANS')])[1]")
    })
    WebElement byodTileContinueButton;

    @FindBy(xpath = "//span[contains(text(),'postal')]/ancestor::span[contains(@class,'ds-button__copy text-button text')]")
    WebElement changePostalCodeRpotgBanner;

    @FindBy(xpath = "//a[@class='learMoreLink ds-pointer mw-100']")
    WebElement learnMoreBannerLearnMore;

    @FindBy(xpath = "(//span[contains(.,'Check eligibility') or contains(.,'Disponibilité')])[2]")
    WebElement checkEligibilityRpotgBanner;

    @FindAll({
            @FindBy(xpath = "//div[contains(@class,'ds-formField__wrapper')]/ancestor::ds-form-field"),
            @FindBy(xpath = "//div[@class='ds-formField__inputContainer d-flex ds-corners position-relative ds-borders ds-brcolor-slate ds-bgcolor-white']")
    })
    WebElement postalCodeRpotgBanner;

    @FindBy(xpath = "//input[contains(@id,'ds-form-input-id')]")
    WebElement inputPostalCodeRpotgBanner;

    @FindBy(xpath = "//div[@class='tippy-content']")
    WebElement popOver;

    @FindBy(xpath = "//div[@class='tippy-content']")
    WebElement comingSoonTextTitle;

    @FindBy(xpath = "//button[@id='trident-cta-hup']//span[contains(@class,'ds-button__copy')]")
    WebElement modalContainerDeviceUpgradebutton;

    @FindBy(xpath = "//button[@id='trident-cta-nac']//span[contains(@class,'ds-button__copy')]")
    WebElement modalContainerGetStartedbutton;

    @FindBy(xpath = "//button[@id='trident-cta-aal']//span[contains(@class,'ds-button__copy')]")
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

    @FindBy(xpath = "//p[contains(@class,'dsa-info__contentHeader align-self-center')]")
    WebElement rpotgBannerText;

    @FindBy(xpath = "//button[@title='Check' or @title='Vérifier']")
    WebElement checkBtn;

    @FindAll({
            @FindBy(xpath = "//button[@title='Continue' or @title='Continuer']"),
            @FindBy(xpath = "(//ds-modal//button)[3]")
    })
    WebElement continueBtn;

    @FindBy(xpath = "//button[@data-id='continue']")
    WebElement continueBtnHupCtnSelectionModal;

    @FindBy(xpath = "//button[@data-id='continue']")
    WebElement btnPPCshareNonShareModalContinue;

    @FindBy(xpath = "//dsa-info[contains(@class,'d-block mb-40')]//p[contains(@class,'dsa-info__contentBody text-body mb-0')]")
    WebElement eligiblePostalCodeinBanner;


    String deviceTextXpath = xpathDeviceName + "//following-sibling::dsa-price//span[contains(@class,'dsa-price__copyBottom')]";

    @FindAll({
            @FindBy(xpath = "//div[@class='dds-navbar-nav']//a[@aria-label='Sign in to My Rogers']//span[text()='Sign in'  or text()='Connexion']"),
            @FindBy(xpath = "//div[@class='rcl-navbar-nav']//a[@class='m-navLink -navbar -login']//span[text()='Sign in'  or text()='Connexion']")
    })
    WebElement lnkSignIn;
    
    @FindBy(xpath = "//span[contains(@class,'m-navLink__chevron')]/parent::a[@role='button']")
    WebElement provinceDropDown;

    @FindBy(xpath = "//ds-form-field[@data-test='rpp-passcode']")
    WebElement frmFieldRppPasscode;

    @FindBy(xpath = "//input[@formcontrolname='passCode']")
    WebElement inputRppPasscode;

    @FindBy(xpath = "//button[@data-test='RPP']")
    WebElement btnContinuePasscodeModal;

    @FindBy(xpath = "//p[contains(.,'New customer') or contains(.,'Nouveau client')]")
    WebElement txtNewCustomerInExistingCustModal;

    @FindBy(xpath = "//button[@data-test='rpp-migration-accept-cta']//span[contains(text(),'Continue')]")
    WebElement btnContinuemigrationRpp;

    @FindBy(xpath = "//button[@data-test='trident-cta-cnac']")
    WebElement btnAddALineForIgniteCustomer;

    @FindBy(xpath = "//a[contains(@aria-label,'Sign in')]/span[contains(.,'Sign in')]")
    WebElement bannerSignIn;

    /**
     * To verify the Home page
     * @return true if the signin link is available on home page, else false
     * @author Saurav.Goyal
     */
    public boolean verifyHomepage() {
        return getReusableActionsInstance().isElementVisible(lnkSignIn, 60);
    }
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
        xpathDeviceName="//p[contains(@class,'text-title-5 ')][.='"+deviceName+"']";
        return xpathDeviceName;
    }

    /**
     * verifies if BYOD device tile is present in device catalog page
     * @return: true if BYOD tile is present, else false
     * @author praveen.kumar7
     */
    public boolean verifyByodDeviceTile() {
        return getReusableActionsInstance().isElementVisible(byodDeviceTile,40);
    }

    /**
     * Clicks on BYOD device tile in device catalog page
     * @author praveen.kumar7
     */
    public void clkByodDeviceTileContinueBtn() {
        getReusableActionsInstance().clickWhenReady(byodTileContinueButton);
        getReusableActionsInstance().staticWait(2000);
    }

    /**
     * verifies if device is eligible for upfront edge
     * @param deviceName Name of the device that needs to be verified
     * @return: true if BYOD device is eligible for upfront edge, else false
     * @author praveen.kumar7
     */
    public boolean isDeviceUpfrontEdgeEligible(String deviceName) {
       return getReusableActionsInstance().isElementVisible(By.xpath("//p[contains(@class,'text-title-5 ')][.='"+deviceName+"']/ancestor::div[@class='dsa-nacTile__top']/following-sibling::div//span[contains(.,'Upfront') or contains(.,'express')]"),40);
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
        String ctaButtonXpath = xpathDeviceName + "/ancestor::div[@class='dsa-nacTile__top']//following-sibling::div//following-sibling::div//a";
        return ctaButtonXpath;
    }

    /**
     * This method Clicks on a device Tile CTA button for a particular phone
     * @param deviceName : name of the Device to be used to generate Xpath
     * @author saurav.goyal
     */
    public void clickDeviceTileCTAButton(String deviceName) {
        WebElement deviceCtaButton = getReusableActionsInstance().getWhenReady(By.xpath(createXpathForCTAButton(deviceName)));
        getReusableActionsInstance().scrollToElement(deviceCtaButton);
        getReusableActionsInstance().executeJavaScriptClick(deviceCtaButton);
    }

    /**
     * This method will verify that the device tile CTA button is present or not
     * @param deviceName : name of the Device for which we want to verify device tile CTA button
     * @return boolean true if the CTA button is present else false
     * @author saurav.goyal
     */
    public boolean verifyDeviceTileCTAButton(String deviceName) {
        return getReusableActionsInstance().isElementVisible(By.xpath(createXpathForCTAButton(deviceName)), 60);
    }

    /**
     * This method check whether a Modal page is getting displayed or not
     * @return a boolean value true if a modal window will appear else false
     * @author saurav.goyal
     */
    public boolean isModalDisplayed() {
        return getReusableActionsInstance().isElementVisible(modalContainer,30);
    }

    /**
     * This method will select the required CTN from the list
     * @author saurav.goyal
     */
    public void selectCTN(String ctnNumber) {
        String xpathCTN =  "//ds-modal-container//input[@value='" +  ctnNumber + "']/following-sibling::span[@class='dsa-radio__checkmark']";
        getReusableActionsInstance().clickWhenReady(By.xpath(xpathCTN) , 30);
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
        return getReusableActionsInstance().isElementVisible(modalContainerGetStartedbutton,10);

    }

    /**
     * This method verifies whether or not Get Started button is available in a modal
     * @return a boolean true if element is present else false
     * @author praveen.kumar7
     */
    public boolean verifyOnModal() {
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
     * This method clicks on Upgrade my phone button on the modal
     * @author saurav.goyal
     */
    public void clickUpgradeMyPhoneButtonOnModal() {
        getReusableActionsInstance().clickWhenReady(modalContainerDeviceUpgradebutton , 20);
    }

    /**
     *  This method clicks on Add a line button on the existing customer modal
     *  @author praveeen.kumar7
     */
    public void clickAddALineButtonOnModal() {
        getReusableActionsInstance().clickWhenReady(modalContainerAddALinebutton,20);
    }

    /**
     *  This method verifies if credit evaluation modal is displayed
     *  @return a boolean true if element is present else false
     *  @author praveeen.kumar7
     */
    public boolean verifyCreditEvaluationPopupPresent() {
        return getReusableActionsInstance().isElementVisible(popupCreditEval,30);
    }

    /**
     *  This method checks whether Credit Evaluation text is present on the modal
     *  @return a boolean true if element is present else false
     *  @author praveeen.kumar7
     */
    public boolean verifyCreditEvalTextOnModalPresent() {
        return getReusableActionsInstance().isElementVisible(txtCreditEval,10);
    }

    /**
     *  This method verifies whether Shared/NonShared modal is displayed
     *  @return a boolean true if element is present else false
     *  @author praveeen.kumar7
     */
    public boolean verifySharedNonSharedModalPresent() {
        return getReusableActionsInstance().isElementVisible(sharedNonSharedModal,30);
    }

    /**
     *  This method selects shared or nonshared sharing type based on the string passed
     *  @param sharingType passing the String value of sharingType to select the sharing option
     *  @author praveeen.kumar7
     */
    public void selectAALSharingType(String sharingType) {
        if(sharingType.equalsIgnoreCase("SHARE")) {
            getReusableActionsInstance().clickWhenReady(sharedOption, 20);
        }
        else if(sharingType.equalsIgnoreCase("NONSHARE")){
            getReusableActionsInstance().clickWhenReady(nonSharedOption, 20);
        }
        else {
            getReusableActionsInstance().clickWhenReady(sharedOption, 20);
        }
    }

    /**
     *  This method clicks on the Continue button on shared/nonshared modal
     *  @author praveeen.kumar7
     */
    public void clickContinueButtonOnModal() {
        getReusableActionsInstance().clickWhenReady(modalContinueButton,30);
    }

    /**
     * This method verifies whether or not Add a line button is available in a model
     * @return a boolean true if element is present else false
     * @author praveen.kumar7
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
     * This method will click on the continue button in the RPOTG eligibility banner
     * @author Saurav.Goyal
     */

    public void clickContinueBtn() {
        getReusableActionsInstance().clickWhenReady(continueBtn, 60);
    }

    /**
     * This method will click on the continue button in the ctn selection modal during HUP flow
     * @author praveen.kumar7
     */
    public void clkContinueBtnHupCtnSelectionModal() {
        getReusableActionsInstance().clickWhenReady(continueBtnHupCtnSelectionModal);
    }

    /**
     * This method will click on the continue button in the ctn selection modal during HUP flow
     * @author praveen.kumar7
     */
    public void clkContinueBtnPPCShareNonShareModal() {
        getReusableActionsInstance().clickWhenReady(btnPPCshareNonShareModalContinue);
    }

    /**
     * This method clicks on a Get Started button in a Consumer NAC Modal window
     * @return a boolean true if continue is present on the next device config page
     * Question about getting methods of one page to other
     * @author saurav.goyal
     */
    public boolean clickGetStartedButtonOnModal() {
        do {
            getReusableActionsInstance().clickWhenVisible(modalContainerGetStartedbutton);
            getReusableActionsInstance().staticWait(3000);
            if (getDriver().getCurrentUrl().toUpperCase().contains("STORAGE")) {
                return (getReusableActionsInstance().isElementVisible(new RogersDeviceConfigPage(getDriver()).continueButton, 30));
            }
            do {
                getDriver().get(System.getProperty("AWSUrl"));
                clickDeviceTileCTAButton("Samsung Galaxy S20 FE 5G");
                getReusableActionsInstance().staticWait(2000);
            } while (!verifyGetStartedButtonOnModal());

        } while(!getDriver().getCurrentUrl().toUpperCase().contains("STORAGE"));
                return (getReusableActionsInstance().isElementVisible(new RogersDeviceConfigPage(getDriver()).continueButton, 30));
    }

    /**
     * This method clicks on a Get Started button in RPP Modal window
     * @return true if continue button is displayed on the next device config page else false
     * @author Subash.Nedunchezhian
     */
    public boolean clickGetStartedButtonOnModalRPP(){
        getReusableActionsInstance().clickIfAvailable(modalContainerGetStartedbutton);
        return (getReusableActionsInstance().isElementVisible(new RogersDeviceConfigPage(getDriver()).continueButton, 30));
    }

    /**
     * This method clicks on a Get Started button in SOHO NAC Modal window
     * @return true if continue button is displayed on the next device config page else false
     * @author Subash.Nedunchezhian
     */
    public boolean clickGetStartedButtonOnModalSoho() {
        do {
            getReusableActionsInstance().clickWhenVisible(modalContainerGetStartedbutton);
            getReusableActionsInstance().staticWait(3000);
            if (getDriver().getCurrentUrl().toUpperCase().contains("STORAGE")) {
                return (getReusableActionsInstance().isElementVisible(new RogersDeviceConfigPage(getDriver()).continueButton, 30));
            }
            do {
                getDriver().get(System.getProperty("AWSUrl")+"/?type=soho");
                clickDeviceTileCTAButton("iPhone 13 Pro Max");
                getReusableActionsInstance().staticWait(2000);
            } while (!verifyGetStartedButtonOnModal());

        } while(!getDriver().getCurrentUrl().toUpperCase().contains("STORAGE"));
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
        String pricingBlockContentXpath = xpathDeviceName + "/ancestor::div[@class='dsa-nacTile__top']//following-sibling::div//div[@class='ds-price']";
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
     * Clicks on Change postal code in RPOTG Banner
     * @author praveen.kumar7
     */
    public void clkPostalCodeEligibilityBanner() {
        getReusableActionsInstance().clickWhenReady(changePostalCodeRpotgBanner);
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
        getReusableActionsInstance().doubleClick(checkBtn,0);
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

    /**
     * This method will select the province based on the input
     * @param province
     * @author praveen.kumar7
     */
    public void setProvince(String province) {
        getReusableActionsInstance().clickWhenReady(provinceDropDown, 10);
        getReusableActionsInstance().clickWhenReady(By.xpath("//span[contains(@class,'m-navLink__chevron')]/parent::a[@role='button']/following-sibling::ul//a[@title='"+province+"']"),10);
    }

    /**
     * This method verifies if the passcode modal is displayed or not
     * @return true if passcode modal is displayed, else false
     * @author praveen.kumar7
     */
    public boolean verifyRppPasscodeModal() {
       return getReusableActionsInstance().isElementVisible(frmFieldRppPasscode);
    }

    /**
     * This method enters passcode in text field
     * @param passcode to enter in text field
     * @author praveen.kumar7
     */
    public void enterPasscodeInPasscodeModal(String passcode) {
        getReusableActionsInstance().clickWhenReady(frmFieldRppPasscode);
        getReusableActionsInstance().getWhenReady(inputRppPasscode).sendKeys(passcode);
    }

    /**
     * This method clicks on continue button in passcode validation modal
     * @author praveen.kumar7
     */
    public void clkContinueBtnPassCodeMoodal() {
        getReusableActionsInstance().clickWhenReady(btnContinuePasscodeModal,10);
    }

    /**
     * This method verifies if new or existing customer modal is displayed
     * @return true if new or existing customer modal is displayed else false
     * @author praveen.kumar7
     */
    public boolean verifyPasscode() {
       return getReusableActionsInstance().isElementVisible(txtNewCustomerInExistingCustModal);
    }

    /**
     * This method will click on the continue button in RPP Migration Fee modal during the consumer to RPP migration flow
     * @author subash.nedunchezhian
     */
    public void clkContinueBtnMigrationFeeRpp() {
        if(getReusableActionsInstance().isElementVisible(btnContinuemigrationRpp,10)) {
            getReusableActionsInstance().clickWhenReady(btnContinuemigrationRpp);
        }
    }

    /**
     * This method gets the customer info from accounts API and stores it in Map
     * @param email
     * @param password
     * @return Customer info map
     * @throws IOException
     * @author praveen.kumar7
     */
    public Map<String,String> getCustomerInfoMap(String email,String password) throws IOException {
        LoginSessionAuth loginSessionAuth = new LoginSessionAuth();
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        JSONObject jsonObject= null;
        Map<String,String> customerInfoMap = new HashMap<>();
        HttpGet httpGet = new HttpGet(System.getProperty("QaUrl")+"/api/subscriptions/v1/accounts");
        httpGet.addHeader("content-type", "application/json");
        httpGet.addHeader("province","ON");
        httpGet.addHeader("lang","en");
        httpGet.addHeader("applicationid","Rogers.com");
        httpGet.addHeader("Cookie",(BaseTestClass.getAuthHeaders(loginSessionAuth.getLoginSessionToken("https://qa0"+System.getProperty("QaUrl").split("qa")[1].charAt(0)+"-mservices.rogers.com/v1",email,password),System.getProperty("QaUrl"))).get("Cookie"));
        HttpResponse response = closeableHttpClient.execute(httpGet);
        HttpEntity httpEntity = response.getEntity();
        if (httpEntity != null) {
            String responseStr = EntityUtils.toString(httpEntity, "UTF-8");
            jsonObject = new JSONObject(responseStr);
            System.out.println(jsonObject);
            Assert.assertEquals(response.getStatusLine().getStatusCode(),200,"accounts API failed");
            boolean flag = (boolean) jsonObject.get("isWirelessCustomer");
            Assert.assertFalse(flag, "Customer already has wireless a product");
        }
        JSONArray linkedAccountsJsonArray = jsonObject.getJSONArray("linkedAccounts");
        JSONObject custInfoJsonObejct = linkedAccountsJsonArray.getJSONObject(0);
        if (custInfoJsonObejct.get("emailAddress").toString().equals("null")) {
            customerInfoMap.put("emailAddress","null");
        }
        if (custInfoJsonObejct.get("firstName").toString().equals("null")) {
            customerInfoMap.put("firstName","null");
        }
        if (custInfoJsonObejct.get("lastName").toString().equals("null")) {
            customerInfoMap.put("lastName","null");
        }
        if (custInfoJsonObejct.get("homePhone").toString().equals("null")) {
            customerInfoMap.put("homePhone","null");
        }
        if (custInfoJsonObejct.get("billingProvince").toString().equals("null")) {
            customerInfoMap.put("billingProvince", "null");
        }
        return customerInfoMap;
    }

    /**
     * This method verifies if add a line CTA is present in existing customer modal
     * @return true if Add a line button is present, else false
     * @author praveen.kumar7
     */
    public boolean verifyAddALineBtnForIgniteCustomer() {
        return getReusableActionsInstance().isElementVisible(btnAddALineForIgniteCustomer);
    }

    /**
     * Clicks on Add a line button in existing customer modal
     * @author praveen.kumar7
     */
    public void clkAddALineBtnForIgniteCustomer() {
        getReusableActionsInstance().clickWhenVisible(btnAddALineForIgniteCustomer);
    }

    /**
     * This method clicks on Sign In on the Sign In Banner in Device Catalog
     * @author Subash.Nedunchezhian
     */
    public void clickBannerSignIn() {
        getReusableActionsInstance().clickWhenReady(bannerSignIn, 10);
    }

}
