package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RogersPlanConfigPage extends BasePageClass {
    public String xpathDeviceName;
    public RogersPlanConfigPage(WebDriver driver) {
        super(driver);
    }
    String xpathDcDoTo;
    String dataProtectionOption;

    @FindBy(xpath = "//button[contains(@class,'active text-semi')]")
    WebElement deviceProtectiontab;

    @FindBy(xpath = "//button[contains(@class,'active text-semi')]//following-sibling::button")
    WebElement longDistancetab;

    @FindBy(xpath = "//nav[@class='ds-breadcrumb']")
    WebElement breadCrumb;
    
    @FindBy(xpath = "//button[@data-test='stepper-1-edit-step-continue-button']")
    WebElement preCartDeviceCostContinueButton;
    
    @FindBy(xpath = "//button[@data-test='stepper-2-edit-step-continue-button']")
    WebElement preCartDataOtionContinueButton;
    
    @FindBy(xpath = "//button[@data-test='stepper-3-edit-step-continue-button']")
    WebElement preCartTalkOptionContinueButton;
    
    @FindBy(xpath = "//button[@data-test='stepper-4-edit-step-continue-button']")
    WebElement preCartAddonsContinueButton;
    
    @FindBy(xpath = "//div[contains(@class,'ds-step__content ds-border-bottom ds-brcolor-concrete p-16 p-md-24 ds-bgcolor-misty')]//button[contains(@class,'primary -large')]")
    WebElement preCartSummaryContinueButton;
    
    @FindBy(xpath = "//div[contains(@class,'ds-step__hide ng-trigger ng-trigger-bodyExpansion ds-step__show')]//button[contains(@class,'primary -large')]")
    WebElement preCartSummaryContinueButtonTalkOptions;
    
    @FindBy(xpath = "//ds-step[@id='stepper-addons']//div[@class='d-flex flex-row-reverse']//button")
    WebElement preCartSummaryContinueButtonAddOns;

    @FindBy(xpath ="//button[@data-test='build-plan-checkout-flow-button']/span")
    WebElement continueButtonOnCartSummary;
    
    @FindBy(xpath = "//button[@id='get-bpo-offer-button' or @data-test='bpo-offer-modal-button-primary']")
    WebElement getBPOOfferOnDeviceProtection;

    @FindBy(xpath = "//button[@id='Skip the Offer']")
    WebElement skipBPOOfferOnDeviceProtection;

    @FindBy(xpath = "//div[@class='d-flex flex-row']")
    List<WebElement> buildPlanDetails;

    @FindBy(xpath = "//div[contains(@class,'dsa-orderTable__row')]")
    List<WebElement> cartSummaryElements;

    @FindBy(xpath = "//ds-expander[@id='orderTable-refId-0']//div[contains(@class,'dsa-orderTable__totalRow')]")
    WebElement monthlyFeesAmount;

    @FindBy(xpath = "//ds-expander[@id='orderTable-refId-1']//div[contains(@class,'dsa-orderTable__totalRow')]")
    WebElement oneTimeFeesAmount;

    //@FindBy(xpath = "//p[contains(text(),'1.')]//following-sibling::r-data-block-selection//input[@checked='checked']//following-sibling::span//span[contains(@class,'dsa-selection__caption')]")
    @FindBy(xpath ="//p[contains(text(),'1.')]/./following-sibling::div/div[@class='pb-16 ng-star-inserted']//input[@checked='checked']//following-sibling::span//span[contains(@class,'dsa-dataBlock__tileLeftFeatureInfo text-body-sm ds-color-grey ng-star-inserted')]")
    WebElement priceForSelectedDeviceCost;

    //@FindBy(xpath = "//div[@class='dsa-promoBlock ds-bgcolor-misty ng-star-inserted']")
    @FindBy(xpath ="//div[@class='dsa-promoBlock p-md-24 p-16 ds-bgcolor-misty']")
    WebElement promoBlock;

    @FindBy(xpath = "//div[@class='dsa-dataBlock']//div[contains(text(), 'upfront savings') or contains(text(),'sur le montant initial')]")
    WebElement tierLabel;

    @FindBy(xpath = "//span[contains(text(),'Appareils') or contains(text(),'Devices')]")
    WebElement devicesInBreadCrumb;

    @FindBy(xpath = "//span[contains(text(),'Créer forfait') or contains(text(),'Build Plan')]")
    WebElement buildPlanInBreadCrumb;

    @FindBy(xpath = "//span[contains(text(),'No Device Protection') or contains(text(),'Aucune protection de l’appareil')]")
    WebElement noDeviceProtection;

    @FindBy(xpath = "//button[@id='ds-stepper-id-1-editButtonId-1']//span[@class='ds-button__copy text-button text-nowrap ds-no-overflow mw-100']")
    WebElement editButtonDeviceCost;

    @FindBy(xpath = "//span[contains(text(),'Plans') or contains(text(),'Forfaits')]")
    WebElement plansInBreadCrumb;

    @FindBy(xpath = "//span[contains(text(),'Apportez votre propre appareil') or contains(text(),'Bring Your Own Device')]")
    WebElement bringYourOwnDeviceInBreadCrumb;

    /**
     * Select Device Protection Header on Plan config page
     */
    public void selectDeviceProtectionHeaderTab() {
        getReusableActionsInstance().clickIfAvailable(deviceProtectiontab);
    }

    /**
     * This method creates Xpath of a Device Cost , data option , Talk Options
     * @param	dC_DO_TO : String value of Device Cost , data option , Talk Options
     * @return returns a String value having xpath for the Device Cost or  data option or Talk Options
     * DC_DO_TO stands for device cost , data option , talk options
     * @author saurav.goyal
     */
    public String createXpathWithInputData(String dC_DO_TO) {
        if(dC_DO_TO != null && !dC_DO_TO.isEmpty())
            xpathDcDoTo = "//div[@class='pb-16 ng-star-inserted'][contains(@data-id,'"+ dC_DO_TO + "')]";
        else
            xpathDcDoTo = "(//div[@class='pb-16 ng-star-inserted'][contains(@data-id,'')])[1]";
        return xpathDcDoTo;
    }

    /**
     * This method creates Xpath for protection plan
     * @param	protectionPlanDetails : String value of protection plan
     * @return returns a String value having xpath for the protection plan
     * @author saurav.goyal
     */
    public String createXpathWithInputDataForProtectionPlan(String protectionPlanDetails) {
        //String xpathProtectionPlan = "//span[contains(text(),'" + protectionPlanDetails + "')]/ancestor::span";
        String xpathProtectionPlan = "//span[contains(text(),'" + protectionPlanDetails + "')]";
        return xpathProtectionPlan;
    }


    /**
     * Select Device Cost on Plan config page
     * @param	deviceCost : String value of Device Cost to be selected
     * @author saurav.goyal
     */
    public void selectDeviceCost(String deviceCost) {
        if(deviceCost != null) {
            xpathDcDoTo = createXpathWithInputData(deviceCost);
            List<WebElement> noOfTiers = getDriver().findElements(By.xpath(xpathDcDoTo));
            if(noOfTiers.size() == 1)
                getReusableActionsInstance().clickIfAvailable(By.xpath(xpathDcDoTo));
            else
                getReusableActionsInstance().clickIfAvailable(By.xpath(xpathDcDoTo + "[1]"));
        }else{
            xpathDcDoTo = createXpathWithInputData(deviceCost);
            getReusableActionsInstance().clickIfAvailable(By.xpath(xpathDcDoTo));
        }
    }

    /**
     * Select data option on Plan config page
     * @param	dataOption : String value of data option to be selected
     * @author saurav.goyal
     */
    public void selectDataOption(String dataOption) {
        if(dataOption != null) {
            xpathDcDoTo = createXpathWithInputData(dataOption);
            List<WebElement> noOfTiers = getDriver().findElements(By.xpath(xpathDcDoTo));
            if(noOfTiers.size() == 1)
                getReusableActionsInstance().clickIfAvailable(By.xpath(xpathDcDoTo));
            else
                getReusableActionsInstance().clickIfAvailable(By.xpath(xpathDcDoTo + "[1]"));
        }else{
            xpathDcDoTo = "//p[contains(text(),'2.')]//following-sibling::div//div[@class='pb-16 ng-star-inserted'][1]";
            getReusableActionsInstance().clickIfAvailable(By.xpath(xpathDcDoTo));
        }
    }

    /**
     * Select data option on Plan config page
     * @param	dataOption : String value of data option to be selected
     * @author saurav.goyal
     * @return true if the difference between dataStrikedPriceValue and dataNonStrikedPriceValue is 1000 for MSF in gerenal it should be 10.00 but we have removed dot from that
     */
    public boolean verifyDataOptionMSFValue(String dataOption) {
        final String dataStrikedPrice;
        final String dataNonStrikedPrice;
        final int dataStrikedPriceValue;
        final int dataNonStrikedPriceValue;
        if(dataOption != null) {
            xpathDcDoTo = createXpathWithInputData(dataOption);
            List<WebElement> noOfTiers = getDriver().findElements(By.xpath(xpathDcDoTo));
            if(noOfTiers.size() == 1) {
                dataStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(xpathDcDoTo+"//p[@class='text-line-through text-body-sm mb-0 ng-star-inserted']")).getText();
                dataNonStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(xpathDcDoTo+"//p[@class='text-body-lg text-semi mb-0 ng-star-inserted']")).getText();
                dataStrikedPriceValue = Integer.parseInt(dataStrikedPrice.replaceAll("[^-?0-9]+", ""));
                dataNonStrikedPriceValue = Integer.parseInt(dataNonStrikedPrice.replaceAll("[^-?0-9]+", ""));
                if(dataStrikedPriceValue - dataNonStrikedPriceValue == 1000 )
                    return true;
                else
                    return false;
            }
            else {
                dataStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(By.xpath(xpathDcDoTo + "[1]")+"//p[@class='text-line-through text-body-sm mb-0 ng-star-inserted']")).getText();
                dataNonStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(xpathDcDoTo+"//p[@class='text-body-lg text-semi mb-0 ng-star-inserted']")).getText();
                dataStrikedPriceValue = Integer.parseInt(dataStrikedPrice.replaceAll("[^-?0-9]+", ""));
                dataNonStrikedPriceValue = Integer.parseInt(dataNonStrikedPrice.replaceAll("[^-?0-9]+", ""));
                if(dataStrikedPriceValue - dataNonStrikedPriceValue == 1000 )
                    return true;
                else
                    return false;

            }
        }else{
            xpathDcDoTo = "//p[contains(text(),'2.')]//following-sibling::div//div[@class='pb-16 ng-star-inserted'][1]//p[@class='text-line-through text-body-sm mb-0 ng-star-inserted']";
            dataStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(xpathDcDoTo)).getText();
            dataNonStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(xpathDcDoTo+"//following-sibling::p")).getText();
            dataStrikedPriceValue = Integer.parseInt(dataStrikedPrice.replaceAll("[^-?0-9]+", ""));
            dataNonStrikedPriceValue = Integer.parseInt(dataNonStrikedPrice.replaceAll("[^-?0-9]+", ""));
            if(dataStrikedPriceValue - dataNonStrikedPriceValue == 1000 )
                return true;
            else
                return false;

        }
    }

    /**
     * Select talk option on Plan config page
     * @param	talkOptions : String value of data option to be selected
     * @author saurav.goyal
     */
    public void selectTalkOptions(String talkOptions) {
        if(talkOptions != null) {
            xpathDcDoTo = createXpathWithInputData(talkOptions);
            List<WebElement> noOfTiers = getDriver().findElements(By.xpath(xpathDcDoTo));
            if(noOfTiers.size() == 1)
                getReusableActionsInstance().clickIfAvailable(By.xpath(xpathDcDoTo));
            else
                getReusableActionsInstance().clickIfAvailable(By.xpath(xpathDcDoTo + "[1]"));
        }else{
            xpathDcDoTo = "//p[contains(text(),'3.')]//following-sibling::div//div[@class='pb-16 ng-star-inserted'][1]";
            getReusableActionsInstance().clickIfAvailable(By.xpath(xpathDcDoTo + "[1]"));
        }
    }


    /**
     * This method creates Xpath for device protection option
     * @param dataProtectionOption : String value of data protection option
     * @return returns a String value having xpath for data protection option
     * @author saurav.goyal
     */
    public String createXpathforDataProtectionOption(String dataProtectionOption) {
        dataProtectionOption = "//label[@class='dsa-radio']//span[text()='" + dataProtectionOption + "']";
        return dataProtectionOption;
    }

    /**
     * This method will Click Data Protection on Plan config page
     * @param dataProtectionOption : String for the data Protection plan option
     * @author saurav.goyal
     */
    public void clickOptionInDataProtection(String dataProtectionOption) {
        if(dataProtectionOption != null && !dataProtectionOption.isEmpty()) {
            xpathDcDoTo = createXpathWithInputDataForProtectionPlan(dataProtectionOption);
            getReusableActionsInstance().clickIfAvailable(By.xpath(xpathDcDoTo));
        }else
            getReusableActionsInstance().clickIfAvailable(noDeviceProtection, 10);
    }

    /**
     * Verify tooltip in Data protection on Plan config page
     * @param dataProtectionOption : This will verify the tooltip for the data protection option
     * @return String having tooltip value for that particular data protection option
     * @author saurav.goyal
     * check facing some issues
     */
    public String verifyToolTipInDataProtection(String dataProtectionOption) {
        String xpathProtectionPlan = createXpathWithInputDataForProtectionPlan(dataProtectionOption);
        return getReusableActionsInstance().getTitle(getDriver().findElement(By.xpath(xpathProtectionPlan))).trim();
    }

    /**
     * Click continue on Plan config page before cart summary
     * @author saurav.goyal
     */
    public void clickPreCartSummaryContinueButton() {
        getReusableActionsInstance().clickIfAvailable(preCartSummaryContinueButton, 5);
    }
    
    /**
     * Click continue on Plan config page before cart summary
     * @author saurav.goyal
     */
    public void clickPreCartSummaryContinueButtonTalkOptions() {
        getReusableActionsInstance().clickIfAvailable(preCartSummaryContinueButtonTalkOptions, 5);
    }
    
    /**
     * Click continue on Device Cost Section
     * @author karthic.hasan
     */
    public void clickPreCartDeviceCostContinueButton() {
        getReusableActionsInstance().clickWhenReady(preCartDeviceCostContinueButton);
    }
    
    /**
     * Click continue on Data Option Section
     * @author karthic.hasan
     */
    public void clickPreCartDataOptionContinueButton() {
        getReusableActionsInstance().clickWhenReady(preCartDataOtionContinueButton);
    }
    
    /**
     * Click continue on Talk Option Section
     * @author karthic.hasan
     */
    public void clickPreCartTalkOptionContinueButton() {
        getReusableActionsInstance().clickWhenReady(preCartTalkOptionContinueButton);
    }
    
    /**
     * Click continue on Addons Section
     * @author karthic.hasan
     */
    public void clickPreCartAddonsContinueButton() {
        getReusableActionsInstance().clickWhenReady(preCartAddonsContinueButton);
    }
    
    /**
     * Click continue on Plan config page before cart summary
     * @author saurav.goyal
     */
    public void clickPreCartSummaryContinueButtonAddOns() {
        getReusableActionsInstance().clickIfAvailable(preCartSummaryContinueButtonAddOns, 5);
    }

    /**
     * This is to verify the data option price in cart summary
     * @return boolean true if data price in cart summary matches with the selected data price else return false
     * @author saurav.goyal
     */
    public boolean verifyDataPriceOnCartSummary() {
        for(WebElement cartSummaryElement: cartSummaryElements) {
            if(cartSummaryElement.getText().toLowerCase().contains("data") || cartSummaryElement.getText().toLowerCase().contains("données")) {
                for(WebElement buildPlanElement: buildPlanDetails) {
                    if(buildPlanElement.getText().toLowerCase().contains("data") || buildPlanElement.getText().toLowerCase().contains("données")) {
                        return buildPlanElement.getText().contains(cartSummaryElement.getText().toString().substring(cartSummaryElement.getText().toString().indexOf("\\n")+1));
                    }
                }

            }
        }
        return false;
    }

    /**
     * This is to verify the talk option price on cart summary
     * @return boolean true if talk price in cart summary matches with the selected talk price else return false
     * @author saurav.goyal
     */
    public boolean verifyTalkPriceOnCartSummary() {
        for(WebElement cartSummaryElement:  cartSummaryElements) {
            if(cartSummaryElement.getText().toLowerCase().contains("calling") || cartSummaryElement.getText().toLowerCase().contains("appel")) {
                for(WebElement buildPlanElement: buildPlanDetails) {
                    if(buildPlanElement.getText().toLowerCase().contains("calling") || buildPlanElement.getText().toLowerCase().contains("calling")) {
                        return buildPlanElement.getText().contains(cartSummaryElement.getText().toString().substring(cartSummaryElement.getText().toString().indexOf("\\n")+1));
                    }
                }

            }
        }
        return false;
    }


    /**
     * This is to verify the protection price on cart summary
     * @return boolean true if protection price in cart summary matches with the selected protection price else return false
     * @author saurav.goyal
     */
    public boolean verifyProtectionPriceOnCartSummary() {
        for(WebElement cartSummaryElement: cartSummaryElements) {
            if(cartSummaryElement.getText().toLowerCase().contains("protection") || cartSummaryElement.getText().toLowerCase().contains("protection")) {
                for(WebElement buildPlanElement: buildPlanDetails) {
                    if(buildPlanElement.getText().toLowerCase().contains("protection") || buildPlanElement.getText().toLowerCase().contains("protection ")) {
                        return buildPlanElement.getText().contains(cartSummaryElement.getText().toString().substring(cartSummaryElement.getText().toString().indexOf("\\n")+1));
                    }
                }

            }
        }
        return false;
    }

    /**
     * This is to verify the device price on cart summary
     * @param deviceName : give the name of the device as given in the cart summary
     * @return boolean true if device price in cart summary matches with the selected device price else return false
     * @author saurav.goyal
     */
    public boolean verifyDevicePriceOnCartSummary(String deviceName) {
        for(WebElement cartSummaryElement: cartSummaryElements) {
            if(cartSummaryElement.getText().toLowerCase().contains(deviceName.toLowerCase())) {
                for(WebElement buildPlanElement: buildPlanDetails) {
                    if(buildPlanElement.getText().toLowerCase().contains("Device cost") || buildPlanElement.getText().toLowerCase().contains("le coût de votre appareil")) {
                        return buildPlanElement.getText().contains(cartSummaryElement.getText().toString().substring(cartSummaryElement.getText().toString().indexOf("\\n")+1));

                    }
                }
            }
        }
        return false;
    }

    /**
     * Click continue on cart summary in Plan config page
     * @author saurav.goyal
     */
    public void clickCartSummaryContinueButton() {
    	getReusableActionsInstance().javascriptScrollByVisibleElement(continueButtonOnCartSummary);
        getReusableActionsInstance().executeJavaScriptClick(continueButtonOnCartSummary);
//        getReusableActionsInstance().waitForElementTobeClickable(continueButtonOnCartSummary, 10);
//        getReusableActionsInstance().clickWhenReady(continueButtonOnCartSummary);
    }

    /**
     * Select BPO offer on Plan config page
     * @author saurav.goyal
     */
    public void clickGetBPOOffer() {
        getReusableActionsInstance().clickIfAvailable(getBPOOfferOnDeviceProtection, 5);
    }

    /**
     * Select first edit button i.e. in device cost
     * @author saurav.goyal
     */
    public void clickEditButtonDeviceCost() {
        getReusableActionsInstance().clickIfAvailable(editButtonDeviceCost, 5);
    }

    /**
     * skip BPO offer on Plan config page
     * @author saurav.goyal
     */
    public void skipBPOOffer() {
        if(getReusableActionsInstance().isElementVisible(skipBPOOfferOnDeviceProtection, 5))
            getReusableActionsInstance().clickIfAvailable(skipBPOOfferOnDeviceProtection, 5);
    }

    /**
     * This method will get the monthly fees amount from the cart summary
     * @return String having monthly fees amount from the cart summary
     * @author saurav.goyal
     */
    public String getMonthlyFeesAmount() {
        return monthlyFeesAmount.getText().replaceAll("\\n","");
    }

    @FindBy(xpath="//p[contains(@data-test,'stepper-0-completed-step-device-name')]")
    WebElement deviceInfo;

    /**
     * This method will get the selected device info
     * @return String having device info
     * @author nimmy.george
     */
    public String getDeviceInfo() {
        return deviceInfo.getText().toUpperCase();
    }

    @FindBy(xpath="//p[@class='ng-star-inserted']")
    WebElement labelRpotg;

    /**
     * This method will get Rpotg label info from the Plan config page
     *
     * @return labelRpotgInfo
     * @author nimmy.george
     */
    public String getRpotgLabelPlanConfigPage() {
        String labelRpotgInfo = labelRpotg.getText();
        return labelRpotgInfo;
    }

    /**
     * This method will get the one time fees amount from the cart summary
     * @return String having one time fees amount from the cart summary
     * @author saurav.goyal
     */
    public String getOneTimeFeesAmount() {
    	getReusableActionsInstance().javascriptScrollByVisibleElement(oneTimeFeesAmount);
        return oneTimeFeesAmount.getText().replaceAll("\\n","");
    }

    /**
     * This method will verify BreadCrumb on Plan config Page
     * @param deviceName: String of device name
     * @return true if breadcrumb is displayed fine else false
     * @author saurav.goyal
     */
    public boolean verifyBreadCrumb(String deviceName) {
        if(getReusableActionsInstance().isElementVisible(devicesInBreadCrumb) && getReusableActionsInstance().isElementVisible(buildPlanInBreadCrumb) && breadCrumb.getText().toUpperCase().contains((deviceName).toUpperCase()))
            return true;
        return false;
    }
    
    /**
     * This method will verify BreadCrumb on Plan config Page for NAC BYOD
     * @return true if breadcrumb is displayed fine else false
     * @author saurav.goyal
     */
    public boolean verifyBreadCrumb() {
        if(getReusableActionsInstance().isElementVisible(plansInBreadCrumb) && getReusableActionsInstance().isElementVisible(buildPlanInBreadCrumb) && getReusableActionsInstance().isElementVisible(bringYourOwnDeviceInBreadCrumb))
            return true;
        return false;
    }

    /**
     * This method will verify the Device info on the plan config page
     * @param deviceInfoConfigPage : String of device infor from config page
     * @param deviceName: String of device name
     * @return boolean true if Device info on plan config page and matches with device info on device config page
     * @author saurav.goyal
     */
    public boolean verifyDeviceInfo(String deviceInfoConfigPage , String deviceName) {
        String deviceInfoXpath = "//p[contains(text(),'" + deviceName + "')]";
        if(getReusableActionsInstance().getWhenReady(By.xpath(deviceInfoXpath), 10).getText().replace(" ", "").toUpperCase().equalsIgnoreCase(deviceInfoConfigPage.replace(" ", "").toUpperCase()))
            return true;
        return false;
    }

    /**
     * This method will verify the default price on the device catalogue page with the default selected price on Plan config page
     * @param downPriceValueCataloguePage : down price on device catalogue page
     * @return boolean: true if both the value will match else return false
     * @author saurav.goyal
     */
    public boolean verifyDefaultPrice(String downPriceValueCataloguePage) {
        if(getReusableActionsInstance().getWhenReady(priceForSelectedDeviceCost, 30).getText().toUpperCase().replace(" ", "").contains(downPriceValueCataloguePage.toUpperCase().replaceAll("/", "").replace(" ", "")))
            return true;
        return false;
    }

    /**
     * This method will get the promo block text from Plan config page displayed below the cart summary
     * @return String : Return the promo block text from Plan config page displayed below the cart summary
     * @author Pranav.Shaligram
     */
    public String getPromoBlockText(){
        return getReusableActionsInstance().getWhenReady(promoBlock,10).getText().trim().replaceAll("\\n", " ");
    }

    /**
     * This method will get the label text from Plan config page displayed on the tier
     * @return String : Return label text from Plan config page displayed on the tier
     * @author Pranav.Shaligram
     */
    public String getLabelText(){
        return getReusableActionsInstance().getWhenReady(tierLabel, 10).getText().trim();
    }

    @FindBy(xpath="//p[contains(@class,'dsa-info__contentBody text-body mb-0')]")
    WebElement eligiblePostalCodeinBanner;

    public String verifyeligiblePostalCodeinBanner(){
        getReusableActionsInstance().getWhenVisible(eligiblePostalCodeinBanner,20);
        return eligiblePostalCodeinBanner.getText().replaceAll("\\s+","");
    }

}
