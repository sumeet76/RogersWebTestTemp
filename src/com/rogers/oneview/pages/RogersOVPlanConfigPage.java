package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utils.FormFiller;

import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.XMLFormatter;

public class RogersOVPlanConfigPage extends BasePageClass {
    public String xpathDeviceName;

    public RogersOVPlanConfigPage(WebDriver driver) {
        super(driver);
    }

    String xpathDcDoTo;
    String updatedXpathDcDoTo;
    String dataProtectionOption;

    @FindBy(xpath = "//button[contains(@class,'ds-button ds-corners')]//span[contains(text(),'options')]")
    WebElement viewMoreOptions;

    @FindBy(xpath = "//button[contains(@class,'ds-button ds-corners')]//span[contains(text(),' Show More') or contains(text(),' Afficher les ')]")
    WebElement showMoreDetails;

    @FindBy(xpath = "//button[contains(@title,'Plan')]")
    WebElement showPlans;

    @FindBy(xpath = "//button[contains(@title,'Plan')]//span/span[contains(text(),'')]")
    WebElement showPlansText;

    @FindBy(xpath = "//dsa-selection[contains(@data-test,'stepper-1-edit-step-selection-option-')]//label[1]")
    List<WebElement> noOfDeviceTiers;

    @FindBy(xpath = "//dsa-selection[contains(@data-test,'stepper-2-edit-step-selection-option-infinite-')]//label[1]")
    List<WebElement> noofDataOptions;

    @FindBy(xpath = "//dsa-selection[contains(@data-test,'stepper-3-edit-step-selection-option-')]//label[1]")
    List<WebElement> noOfTalkOptions;

    @FindBy(xpath = "//span[text()='Monthly device financing payment' or text()='Paiement mensualité']")
    WebElement financingOptionCheck;

    @FindBy(xpath = "//span[contains(text(),'with Upfront') or contains(text(),'avec Voie')]")
    WebElement upfrontOptionCheck;

    @FindBy(xpath = "//button[contains(@class,'active text-semi')]")
    WebElement deviceProtectiontab;

    @FindBy(xpath = "//button[contains(@class,'active text-semi')]//following-sibling::button")
    WebElement longDistancetab;

    @FindBy(xpath = "//nav[@class='ds-breadcrumb']")
    WebElement breadCrumb;

    @FindBy(xpath = "(//div[contains(@class,'dsa-orderTable')])[1]")
    WebElement monthlyFeesCartSummarySection;

    @FindBy(xpath = "//ds-radio-button[contains(@data-test,'device-payment-type-financing')]//div/div")
    WebElement financingRadioButton;

    @FindBy(xpath = "//ds-radio-button[contains(@data-test,'device-payment-type-fullPrice')]//div/div")
    WebElement fullPriceRadioButton;

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

    @FindBy(xpath = "//button[@data-test='build-plan-checkout-flow-button']/span")
    WebElement continueButtonOnCartSummary;

    @FindBy(xpath = "//button[contains(@data-test,'bpo-offer-modal') or @id='get-bpo-offer-button']")
    WebElement getBPOOffer;

    @FindAll({
            @FindBy(xpath = "//button[@data-test='bpo-offer-modal-button-primary']"),
            @FindBy(xpath = "//button[@id='Skip the Offer']"),
            @FindBy(xpath = "//div[@class='ds-modal__footer mb-24 mb-sm-40']//button[contains(@class,'-tertiary -large')]")
    })
    WebElement skipBPOOfferOnDeviceProtection;

    @FindBy(xpath = "//div[@class='d-flex flex-row']")
    List<WebElement> buildPlanDetails;

    @FindBy(xpath = "//div[contains(@class,'dsa-orderTable__row')]")
    List<WebElement> cartSummaryElements;

    @FindBy(xpath = "(//div[contains(@class,'dsa-orderTable__totalRow')])[1]")
    WebElement monthlyFeesAmount;

    @FindBy(xpath = "(//div[contains(@class,'dsa-orderTable__totalRow')])[2]")
    WebElement oneTimeFeesAmount;

    //@FindBy(xpath = "//p[contains(text(),'1.')]//following-sibling::r-data-block-selection//input[@checked='checked']//following-sibling::span//span[contains(@class,'dsa-selection__caption')]")
    @FindBy(xpath = "//p[contains(text(),'1.')]/./following-sibling::div/div[@class='pb-16 ng-star-inserted']//input[@checked='checked']//following-sibling::span//span[contains(@class,'dsa-dataBlock__tileLeftFeatureInfo text-body-sm ds-color-grey ng-star-inserted')]")
    WebElement priceForSelectedDeviceCost;

    //@FindBy(xpath = "//div[@class='dsa-promoBlock ds-bgcolor-misty ng-star-inserted']")
    @FindBy(xpath = "//div[@class='dsa-promoBlock p-md-24 p-16 ds-bgcolor-misty']")
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

    @FindBy(xpath = "//ds-checkbox//div[@class='ds-checkbox__box my-12']")
    WebElement checkBoxKeepMyCurrentPlan;

    @FindBy(xpath = "//ds-modal")
    WebElement modalToDoWithOldPhone;

    @FindBy(xpath = "//ds-modal//button[contains(@title,'Continue')]")
    WebElement btnContinueOnModalToDoWithOldPhone;

    @FindBy(xpath = "//div[@class='dsa-layout container']//ds-checkbox")
    WebElement checkBoxAdditionalLineOPtion;

    @FindBy(xpath = "//button[@data-test='add-to-cart-btn']")
    WebElement btnAddToCart;

    @FindBy(xpath = "//button[@data-test='continue-btn']")
    WebElement btnProceedToCheckout;

    @FindBy(xpath = "//input[@id='ds-form-input-id-0']/parent::div//input")
    WebElement inputFirstName;

    @FindBy(xpath = "//input[@id='ds-form-input-id-0']/parent::div")
    WebElement inputFirstNameDiv;

    @FindBy(xpath = "//input[@id='ds-form-input-id-1']/parent::div//input")
    WebElement inputLastName;

    @FindBy(xpath = "//input[@id='ds-form-input-id-1']/parent::div")
    WebElement inputLastNameDiv;

    @FindBy(xpath = "//span[contains(text(),'CONTINUE')]")
    WebElement callerIDContinue;

    /**
     * Select Device Protection Header on Plan config page
     */
    public void selectDeviceProtectionHeaderTab() {
        getReusableActionsInstance().clickIfAvailable(deviceProtectiontab);
    }

    /**
     * This method verifies if the selected device section is displayed
     * @param deviceName String value of the device
     * @return a boolean true if selected device section is displayed else returns false
     * @author praveen.kumar7
     */
    public boolean verifySelectedDeviceSection(String deviceName) {
       return getReusableActionsInstance().isElementVisible(By.xpath("//div[contains(@class,'completed')]//p[contains(.,'" +deviceName+ "')]"),40);
    }

    public boolean verifyByodSelectedDeviceSection() {
        return getReusableActionsInstance().isElementVisible(By.xpath("//div[contains(@class,'completed')]//p[contains(.,'Bring') or contains(.,'Apportez')]"));
    }

    /**
     * Clicks on View More Options to expand device cost stepper
     * @author praveen.kumar7
     */
    public void clickViewMoreOptions() {
        getReusableActionsInstance().clickIfAvailable(viewMoreOptions);
    }

    /**
     * Clicks on Show More details to expand Data stepper
     * @author praveen.kumar7
     */
    public void clickShowMoreDetails() {
        getReusableActionsInstance().clickIfAvailable(showPlans, 40);
        getReusableActionsInstance().clickIfAvailable(showMoreDetails,40);
    }

    /**
     * Creates an xpath for the provided stepper with index value which is passed as parameter
     * @param dC_DO_TO string value of device cost, data option and talk option stepper
     * @param stepper String value of the stepper index
     * @return String value of an xpath
     * @author praveen.kumar7
     */
    public String createXpathWithInputData(String dC_DO_TO,int stepper) {
        if (stepper == 1) {
            return xpathDcDoTo = "//dsa-selection[contains(@data-test,'stepper-" + stepper + "-edit-step-selection-option-" + dC_DO_TO + "')]//label[1]";
        }
        else if (stepper == 2) {
            return xpathDcDoTo = "//dsa-selection[contains(@data-test,'stepper-" + stepper + "-edit-step-selection-option-infinite-" + dC_DO_TO + "')]//label[1]";
        }
        else if(stepper == 3) {
            return xpathDcDoTo = "//dsa-selection[contains(@data-test,'stepper-" + stepper + "-edit-step-selection-option-" + dC_DO_TO + "')]//label[1]";
        }
        else {
            return xpathDcDoTo = "//dsa-selection[contains(@data-test,'stepper-" + stepper + "-edit-step-selection-option-" + dC_DO_TO + "')]//label[1]";
        }
    }

    public String createXpathWithInputData(String dataOption) {
        String a = showPlansText.getText();
        if (showPlansText.getText().contains("Outbound")) {
            return updatedXpathDcDoTo = "(//div[contains(@data-test,'outbound-plans')]//label)["+dataOption+"]";
        } else if (showPlansText.getText().contains("Field Sales")) {
            return updatedXpathDcDoTo = "(//div[contains(@data-test,'field-sales-plans')]//label)["+dataOption+"]";
        }
        return updatedXpathDcDoTo;
    }

    /**
     * This method creates Xpath for protection plan
     *
     * @return returns a String value having xpath for the protection plan
     * @param    protectionPlanDetails : String value of protection plan
     * @author saurav.goyal
     */
    public String createXpathWithInputDataForProtectionPlan(String protectionPlanDetails) {
        //String xpathProtectionPlan = "//span[contains(text(),'" + protectionPlanDetails + "')]/ancestor::span";
        String xpathProtectionPlan = "//span[contains(text(),'" + protectionPlanDetails + "')]";
        return xpathProtectionPlan;
    }

    /**
     * This method sets the value for deviceCostIndex
     * @param deviceCostIndex String value of deviceCostIndex
     * @return returs the String value of index
     * @author praveen.kumar
     */
    public String getUpdatedDeviceCostIndex(String deviceCostIndex) {
        if((deviceCostIndex == null) || (deviceCostIndex.isEmpty()) || (Integer.parseInt(deviceCostIndex) > noOfDeviceTiers.size()-1)) {
            deviceCostIndex="0";
            return deviceCostIndex;
        }
        return deviceCostIndex;
    }

    /**
     * This method sets the value for dataOptionIndex
     * @param dataOptionIndex String value of dataOptionIndex
     * @return returs the String value of index
     * @author praveen.kumar
     */
    public String getupdatedDataOptionIndex(String dataOptionIndex) {
        if ((dataOptionIndex == null) || (dataOptionIndex.isEmpty()) || (Integer.parseInt(dataOptionIndex) > noofDataOptions.size()-1)) {
            dataOptionIndex = "0";
            return dataOptionIndex;
        }
        return dataOptionIndex;
    }

    /**
     * This method sets the value for talkOptionIndex
     * @param talkOptionIndex String value of talkOptionIndex
     * @return returs the String value of index
     * @author praveen.kumar
     */
    public String getupdatedTalkOptionIndex(String talkOptionIndex) {
        if ((talkOptionIndex == null) || (talkOptionIndex.isEmpty()) || (Integer.parseInt(talkOptionIndex) > noOfTalkOptions.size()-1)) {
            talkOptionIndex = "0";
            return talkOptionIndex;
        }
        return talkOptionIndex;
    }

    /**
     * Select Device Cost tier on Plan config page and clicks on continue button
     * @param    deviceCostIndex : String value of Device Cost to be selected
     * @author praveen.kumar
     */
    public void selectDeviceCostAndClickOnContinueButton(String deviceCostIndex) {
        int stepper = 1;
        String xpathDcDoTo = createXpathWithInputData(deviceCostIndex, stepper);
        //if (Integer.parseInt(deviceCostIndex) == 0) {
        if ((deviceCostIndex == null) || (deviceCostIndex.isEmpty()) || (Integer.parseInt(deviceCostIndex) > noOfDeviceTiers.size()-1)) {
            getReusableActionsInstance().staticWait(3000);
            getReusableActionsInstance().clickWhenVisible(preCartDeviceCostContinueButton, 30);
        } else {
            getReusableActionsInstance().clickWhenVisible(By.xpath(xpathDcDoTo), 60);
            getReusableActionsInstance().staticWait(3000);
            getReusableActionsInstance().clickWhenVisible(preCartDeviceCostContinueButton, 30);
        }

    }

    public void selectDeviceCostAndClickOnContinueButton(String deviceCostIndex, String deviceCostType) {
        if (deviceCostType.equalsIgnoreCase("Finance")) {
            getReusableActionsInstance().executeJavaScriptClick(financingRadioButton);
        } else {
            getReusableActionsInstance().executeJavaScriptClick(fullPriceRadioButton);
        }
        int stepper = 1;
        String xpathDcDoTo = createXpathWithInputData(deviceCostIndex, stepper);
        //if (Integer.parseInt(deviceCostIndex) == 0) {
        if ((deviceCostIndex == null) || (deviceCostIndex.isEmpty()) || (Integer.parseInt(deviceCostIndex) > noOfDeviceTiers.size()-1)) {
            getReusableActionsInstance().staticWait(3000);
            getReusableActionsInstance().clickWhenVisible(preCartDeviceCostContinueButton, 30);
        } else {
            getReusableActionsInstance().clickWhenVisible(By.xpath(xpathDcDoTo), 60);
            getReusableActionsInstance().staticWait(3000);
            getReusableActionsInstance().clickWhenVisible(preCartDeviceCostContinueButton, 30);
        }

    }


    /**
     * Select No term Device Cost on Plan config page
     *
     * @author saurav.goyal
     */
    public void selectNoTermDeviceDeviceCost() {
        getReusableActionsInstance().scrollToElement(viewMoreOptions);
        clickViewMoreOptions();
        getReusableActionsInstance().clickWhenReady(By.xpath("//span[@data-caption='NOTERM_false']//ancestor::label"), 30);
    }

    /**
     * Select No term Device Cost on Plan config page
     *
     * @author saurav.goyal
     */
    public void setCheckBoxKeepMyCurrentPlan() {
        getReusableActionsInstance().clickWhenReady(checkBoxKeepMyCurrentPlan, 30);
    }

    /**
     * Select data option on Plan config page
     *
     * @param    dataOptionIndex : String value of data option to be selected
     * @author praveen.kumar7
     */
    public void selectDataOptionAndClickonContinueButton(String dataOptionIndex) {
        int stepper=2;
        String xpathDcDoTo = createXpathWithInputData(dataOptionIndex,stepper);
        if(Integer.parseInt(dataOptionIndex) == 0) {
            getReusableActionsInstance().clickWhenVisible(preCartDataOtionContinueButton, 30);
        }
        else {
            getReusableActionsInstance().clickWhenVisible(By.xpath(xpathDcDoTo),40);
            getReusableActionsInstance().clickWhenVisible(preCartDataOtionContinueButton,40);
        }
    }

    public void selectDataOptionButton(String dataOptionIndex) {
        String xpathDcDoTo = createXpathWithInputData(dataOptionIndex);
        if(Integer.parseInt(dataOptionIndex) == 0) {
            getReusableActionsInstance().clickWhenVisible(preCartDataOtionContinueButton, 30);
        }
        else {
            getReusableActionsInstance().clickWhenVisible(By.xpath(xpathDcDoTo),40);
            getReusableActionsInstance().clickWhenVisible(preCartDataOtionContinueButton,40);
        }
    }

    /**
     * Select data option on Plan config page
     *
     * @return true if the difference between dataStrikedPriceValue and dataNonStrikedPriceValue is 1000 for MSF in gerenal it should be 10.00 but we have removed dot from that
     * @param    dataOption : String value of data option to be selected
     * @author saurav.goyal
     */
    public boolean verifyDataOptionMSFValue(String dataOption) {
        final String dataStrikedPrice;
        final String dataNonStrikedPrice;
        final int dataStrikedPriceValue;
        final int dataNonStrikedPriceValue;
        if (dataOption != null) {
            xpathDcDoTo = createXpathWithInputData(dataOption,3);
            List<WebElement> noOfTiers = getDriver().findElements(By.xpath(xpathDcDoTo));
            if (noOfTiers.size() == 1) {
                dataStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(xpathDcDoTo + "//p[@class='text-line-through text-body-sm mb-0 ng-star-inserted']")).getText();
                dataNonStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(xpathDcDoTo + "//p[@class='text-body-lg text-semi mb-0 ng-star-inserted']")).getText();
                dataStrikedPriceValue = Integer.parseInt(dataStrikedPrice.replaceAll("[^-?0-9]+", ""));
                dataNonStrikedPriceValue = Integer.parseInt(dataNonStrikedPrice.replaceAll("[^-?0-9]+", ""));
                if (dataStrikedPriceValue - dataNonStrikedPriceValue == 1000)
                    return true;
                else
                    return false;
            } else {
                dataStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(By.xpath(xpathDcDoTo + "[1]") + "//p[@class='text-line-through text-body-sm mb-0 ng-star-inserted']")).getText();
                dataNonStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(xpathDcDoTo + "//p[@class='text-body-lg text-semi mb-0 ng-star-inserted']")).getText();
                dataStrikedPriceValue = Integer.parseInt(dataStrikedPrice.replaceAll("[^-?0-9]+", ""));
                dataNonStrikedPriceValue = Integer.parseInt(dataNonStrikedPrice.replaceAll("[^-?0-9]+", ""));
                if (dataStrikedPriceValue - dataNonStrikedPriceValue == 1000)
                    return true;
                else
                    return false;

            }
        } else {
            xpathDcDoTo = "//p[contains(text(),'2.')]//following-sibling::div//div[@class='pb-16 ng-star-inserted'][1]//p[@class='text-line-through text-body-sm mb-0 ng-star-inserted']";
            dataStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(xpathDcDoTo)).getText();
            dataNonStrikedPrice = getReusableActionsInstance().getWhenReady(By.xpath(xpathDcDoTo + "//following-sibling::p")).getText();
            dataStrikedPriceValue = Integer.parseInt(dataStrikedPrice.replaceAll("[^-?0-9]+", ""));
            dataNonStrikedPriceValue = Integer.parseInt(dataNonStrikedPrice.replaceAll("[^-?0-9]+", ""));
            if (dataStrikedPriceValue - dataNonStrikedPriceValue == 1000)
                return true;
            else
                return false;

        }
    }

    /**
     * Selects talk option and verifies if addons stepper continue button is displayed
     * @param talkOptionIndex : String value of talk option to be selected
     * return boolean true if continue button is displayed in addons stepper else false
     * @author praveen.kumar7
     */
    public boolean verifyTalkOptionSelectionAndAddonsContinueButton(String talkOptionIndex) {
        int stepper = 3;
        String xpathDcDoTo = createXpathWithInputData(talkOptionIndex, stepper);
        if(Integer.parseInt(talkOptionIndex) == 0) {
            getReusableActionsInstance().clickIfAvailable((preCartTalkOptionContinueButton),20);
        }
        if(Integer.parseInt(talkOptionIndex) == 1) {
            getReusableActionsInstance().clickIfAvailable(By.xpath(xpathDcDoTo),30);
            getReusableActionsInstance().clickIfAvailable(preCartTalkOptionContinueButton);
        }
        return getReusableActionsInstance().isElementVisible(preCartAddonsContinueButton,30);
    }

    /**
     * This method creates Xpath for device protection option
     *
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
     *
     * @param dataProtectionOption : String for the data Protection plan option
     * @author saurav.goyal
     */
    public void clickOptionInDataProtection(String dataProtectionOption) {
        if (dataProtectionOption != null && !dataProtectionOption.isEmpty()) {
            xpathDcDoTo = createXpathWithInputDataForProtectionPlan(dataProtectionOption);
            getReusableActionsInstance().clickIfAvailable(By.xpath(xpathDcDoTo));
        } else
            getReusableActionsInstance().clickIfAvailable(noDeviceProtection, 10);
    }

    /**
     * Verify tooltip in Data protection on Plan config page
     *
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
     *
     * @author saurav.goyal
     */
    public void clickPreCartSummaryContinueButton() {
        getReusableActionsInstance().clickIfAvailable(preCartSummaryContinueButton, 5);
    }

    /**
     * Click continue on modal what would you like to do with your old phone
     *
     * @author saurav.goyal
     */
    public void clickContinueOnModalToDoWithOldPhone() {
        if (getReusableActionsInstance().isElementVisible(modalToDoWithOldPhone, 20))
            getReusableActionsInstance().clickWhenReady(btnContinueOnModalToDoWithOldPhone, 5);
    }

    /**
     * Click continue on Plan config page before cart summary
     *
     * @author saurav.goyal
     */
    public void clickPreCartSummaryContinueButtonTalkOptions() {
        getReusableActionsInstance().clickIfAvailable(preCartSummaryContinueButtonTalkOptions, 5);
    }

    /**
     * Click continue on Device Cost Section
     *
     * @author karthic.hasan
     */
    public void clickPreCartDeviceCostContinueButton() {
        getReusableActionsInstance().clickWhenReady(preCartDeviceCostContinueButton);
        getReusableActionsInstance().clickIfAvailable(btnContinueOnModalToDoWithOldPhone, 30);
    }

    /**
     * Click continue on Data Option Section
     *
     * @author karthic.hasan
     */
    public void clickPreCartDataOptionContinueButton() {
        getReusableActionsInstance().clickIfAvailable(preCartDataOtionContinueButton);
    }

    /**
     * Click continue on Talk Option Section
     *
     * @author karthic.hasan
     */
    public void clickPreCartTalkOptionContinueButton() {
        getReusableActionsInstance().clickIfAvailable(preCartTalkOptionContinueButton);
    }

    /**
     * Click continue on Addons Section
     *
     * @author karthic.hasan
     */
    public void clickPreCartAddonsContinueButton() {
        getReusableActionsInstance().clickIfAvailable(preCartAddonsContinueButton, 10);
    }

    /**
     * Click continue on Plan config page before cart summary
     *
     * @author saurav.goyal
     */
    public void clickPreCartSummaryContinueButtonAddOns() {
        getReusableActionsInstance().clickIfAvailable(preCartSummaryContinueButtonAddOns, 5);
    }

    /**
     * This is to verify the data option price in cart summary
     *
     * @return boolean true if data price in cart summary matches with the selected data price else return false
     * @author saurav.goyal
     */
    public boolean verifyDataPriceOnCartSummary() {
        for (WebElement cartSummaryElement : cartSummaryElements) {
            if (cartSummaryElement.getText().toLowerCase().contains("data") || cartSummaryElement.getText().toLowerCase().contains("données")) {
                for (WebElement buildPlanElement : buildPlanDetails) {
                    if (buildPlanElement.getText().toLowerCase().contains("data") || buildPlanElement.getText().toLowerCase().contains("données")) {
                        return buildPlanElement.getText().contains(cartSummaryElement.getText().toString().substring(cartSummaryElement.getText().toString().indexOf("\\n") + 1));
                    }
                }

            }
        }
        return false;
    }

    /**
     * This is to verify the talk option price on cart summary
     *
     * @return boolean true if talk price in cart summary matches with the selected talk price else return false
     * @author saurav.goyal
     */
    public boolean verifyTalkPriceOnCartSummary() {
        for (WebElement cartSummaryElement : cartSummaryElements) {
            if (cartSummaryElement.getText().toLowerCase().contains("calling") || cartSummaryElement.getText().toLowerCase().contains("appel")) {
                for (WebElement buildPlanElement : buildPlanDetails) {
                    if (buildPlanElement.getText().toLowerCase().contains("calling") || buildPlanElement.getText().toLowerCase().contains("calling")) {
                        return buildPlanElement.getText().contains(cartSummaryElement.getText().toString().substring(cartSummaryElement.getText().toString().indexOf("\\n") + 1));
                    }
                }

            }
        }
        return false;
    }


    /**
     * This is to verify the protection price on cart summary
     *
     * @return boolean true if protection price in cart summary matches with the selected protection price else return false
     * @author saurav.goyal
     */
    public boolean verifyProtectionPriceOnCartSummary() {
        for (WebElement cartSummaryElement : cartSummaryElements) {
            if (cartSummaryElement.getText().toLowerCase().contains("protection") || cartSummaryElement.getText().toLowerCase().contains("protection")) {
                for (WebElement buildPlanElement : buildPlanDetails) {
                    if (buildPlanElement.getText().toLowerCase().contains("protection") || buildPlanElement.getText().toLowerCase().contains("protection ")) {
                        return buildPlanElement.getText().contains(cartSummaryElement.getText().toString().substring(cartSummaryElement.getText().toString().indexOf("\\n") + 1));
                    }
                }

            }
        }
        return false;
    }

    /**
     * This is to verify the device price on cart summary
     *
     * @param deviceName : give the name of the device as given in the cart summary
     * @return boolean true if device price in cart summary matches with the selected device price else return false
     * @author saurav.goyal
     */
    public boolean verifyDevicePriceOnCartSummary(String deviceName) {
        for (WebElement cartSummaryElement : cartSummaryElements) {
            if (cartSummaryElement.getText().toLowerCase().contains(deviceName.toLowerCase())) {
                for (WebElement buildPlanElement : buildPlanDetails) {
                    if (buildPlanElement.getText().toLowerCase().contains("Device cost") || buildPlanElement.getText().toLowerCase().contains("le coût de votre appareil")) {
                        return buildPlanElement.getText().contains(cartSummaryElement.getText().toString().substring(cartSummaryElement.getText().toString().indexOf("\\n") + 1));

                    }
                }
            }
        }
        return false;
    }

    /**
     * Click continue on cart summary in Plan config page
     *
     * @author saurav.goyal
     */
    public void clickCartSummaryContinueButton() {
        getReusableActionsInstance().javascriptScrollByVisibleElement(continueButtonOnCartSummary);
        getReusableActionsInstance().staticWait(3000);
        getReusableActionsInstance().executeJavaScriptClick(continueButtonOnCartSummary);
        //clickGetBPOOffer();
//        getReusableActionsInstance().waitForElementTobeClickable(continueButtonOnCartSummary, 10);
        //getReusableActionsInstance().clickWhenReady(continueButtonOnCartSummary);
    }

    /**
     * This method select the additional line plan option and Clicks on proceed to checkout button
     * @author praveen.kumar7
     */
    public void clkAdditionalLineOptions() {
        getReusableActionsInstance().clickWhenReady(checkBoxAdditionalLineOPtion, 30);
        getReusableActionsInstance().clickWhenReady(btnAddToCart);
        getReusableActionsInstance().scrollToElement(btnProceedToCheckout);
        getReusableActionsInstance().clickWhenReady(btnProceedToCheckout, 30);
    }

    /**
     * Select BPO offer on Plan config page
     *
     * @author saurav.goyal
     */
    public void clickGetBPOOffer() {
        getReusableActionsInstance().clickIfAvailable(getBPOOffer, 5);
    }

    /**
     * Select first edit button i.e. in device cost
     *
     * @author saurav.goyal
     */
    public void clickEditButtonDeviceCost() {
        getReusableActionsInstance().clickIfAvailable(editButtonDeviceCost, 5);
    }

    /**
     * skip BPO offer on Plan config page
     *
     * @author saurav.goyal
     */
    public void skipBPOOffer() {
        if (getReusableActionsInstance().isElementVisible(skipBPOOfferOnDeviceProtection, 20))
            getReusableActionsInstance().clickIfAvailable(skipBPOOfferOnDeviceProtection, 5);
    }

    /**
     * This method will get the monthly fees amount from the cart summary
     *
     * @return String having monthly fees amount from the cart summary
     * @author saurav.goyal
     */
    public String getMonthlyFeesAmount() {
        return getReusableActionsInstance().getWhenReady(monthlyFeesAmount,10).getText().replaceAll("\\n","");
    }

    @FindBy(xpath = "//p[contains(@data-test,'stepper-0-completed-step-device-name')]")
    WebElement deviceInfo;

    /**
     * This method will get the selected device info
     *
     * @return String having device info
     * @author nimmy.george
     */
    public String getDeviceInfo() {
        return deviceInfo.getText().toUpperCase();
    }

    @FindBy(xpath = "//p[@class='ng-star-inserted']")
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
     *
     * @return String having one time fees amount from the cart summary
     * @author saurav.goyal
     */
    public String getOneTimeFeesAmount() {
        return getReusableActionsInstance().getWhenReady(oneTimeFeesAmount,10).getText().replaceAll("\\n","");
    }

    /**
     * This method will verify BreadCrumb on Plan config Page
     *
     * @param deviceName: String of device name
     * @return true if breadcrumb is displayed fine else false
     * @author saurav.goyal
     */
    public boolean verifyBreadCrumb(String deviceName) {
        if (getReusableActionsInstance().isElementVisible(devicesInBreadCrumb) && getReusableActionsInstance().isElementVisible(buildPlanInBreadCrumb) && breadCrumb.getText().toUpperCase().contains((deviceName).toUpperCase())) {
            return true;
        }
        return false;
    }

    /**
     * This method verifies the BreadCrumb on Plan config Page for BYOD device
     * @return true if breadcrumb is displayed, else false
     * @author saurav.goyal
     */
    public boolean verifyAalByodBreadCrumb() {
        if(getReusableActionsInstance().isElementVisible(devicesInBreadCrumb) && getReusableActionsInstance().isElementVisible(buildPlanInBreadCrumb) &&
                (breadCrumb.getText().toUpperCase().contains("BRING") || breadCrumb.getText().toUpperCase().contains("APPORTEZ"))) {
            return true;
        }
        return false;
    }

    /**
     * This method will verify BreadCrumb on Plan config Page for NAC BYOD
     *
     * @return true if breadcrumb is displayed fine else false
     * @author saurav.goyal
     */
    public boolean verifyBreadCrumb() {
        if (getReusableActionsInstance().isElementVisible(plansInBreadCrumb) && getReusableActionsInstance().isElementVisible(buildPlanInBreadCrumb) && getReusableActionsInstance().isElementVisible(bringYourOwnDeviceInBreadCrumb))
            return true;
        return false;
    }

    /**
     * This method will verify the Device info on the plan config page
     *
     * @param deviceInfoConfigPage : String of device infor from config page
     * @param deviceName:          String of device name
     * @return boolean true if Device info on plan config page and matches with device info on device config page
     * @author saurav.goyal
     */
    public boolean verifyDeviceInfo(String deviceInfoConfigPage, String deviceName) {
        String deviceInfoXpath = "//p[contains(text(),'" + deviceName + "')]";
        if (getReusableActionsInstance().getWhenReady(By.xpath(deviceInfoXpath), 10).getText().replace(" ", "").toUpperCase().equalsIgnoreCase(deviceInfoConfigPage.replace(" ", "").toUpperCase()))
            return true;
        return false;
    }

    /**
     * This method will verify the default price on the device catalogue page with the default selected price on Plan config page
     *
     * @param downPriceValueCataloguePage : down price on device catalogue page
     * @return boolean: true if both the value will match else return false
     * @author saurav.goyal
     */
    public boolean verifyDefaultPrice(String downPriceValueCataloguePage) {
        if (getReusableActionsInstance().getWhenReady(priceForSelectedDeviceCost, 30).getText().toUpperCase().replace(" ", "").contains(downPriceValueCataloguePage.toUpperCase().replaceAll("/", "").replace(" ", "")))
            return true;
        return false;
    }

    /**
     * This method will get the promo block text from Plan config page displayed below the cart summary
     *
     * @return String : Return the promo block text from Plan config page displayed below the cart summary
     * @author Pranav.Shaligram
     */
    public String getPromoBlockText() {
        return getReusableActionsInstance().getWhenReady(promoBlock, 10).getText().trim().replaceAll("\\n", " ");
    }

    /**
     * This method will get the label text from Plan config page displayed on the tier
     *
     * @return String : Return label text from Plan config page displayed on the tier
     * @author Pranav.Shaligram
     */
    public String getLabelText() {
        return getReusableActionsInstance().getWhenReady(tierLabel, 10).getText().trim();
    }

    @FindBy(xpath = "//p[contains(@class,'dsa-info__contentBody text-body mb-0')]")
    WebElement eligiblePostalCodeinBanner;

    public String verifyeligiblePostalCodeinBanner() {
        getReusableActionsInstance().getWhenVisible(eligiblePostalCodeinBanner, 20);
        return eligiblePostalCodeinBanner.getText().replaceAll("\\s+", "");
    }

    /**
     * Checks for the selected device tier in plan config page
     * @return a String value of tieroption
     * @author praveen.kumar7
     */
    public String getDeviceCostTierSelected() {
        String tierOption="noterm";
        getReusableActionsInstance().scrollToElement(monthlyFeesCartSummarySection);
        if(getReusableActionsInstance().isElementVisible(upfrontOptionCheck,40)) {
            tierOption="upfront";
            return tierOption;
        }
        else if(getReusableActionsInstance().isElementVisible(financingOptionCheck,40)) {
            tierOption="financing";
            return tierOption;
        }
        else {
            return tierOption;
        }
    }

    public boolean verifyDeviceCostContinueButton() {
        getReusableActionsInstance().scrollToElement(preCartDeviceCostContinueButton);
        return getReusableActionsInstance().isElementVisible(preCartDeviceCostContinueButton,30);
    }

    public boolean verifyTabletDataTalkOptionSelected() {
        getReusableActionsInstance().clickIfAvailable(preCartDataOtionContinueButton,10);
        getReusableActionsInstance().clickIfAvailable(preCartTalkOptionContinueButton,10);
        return getReusableActionsInstance().isElementVisible(preCartAddonsContinueButton,30);
    }

    /**
     * Enter First name on the phone plans page
     * @author Sidhartha.Vadrevu
     */
    public void enterFirstName() {
        String strFirstName = FormFiller.generateRandomName();
        getReusableActionsInstance().getWhenReady(inputFirstNameDiv, 30).click();
        getReusableActionsInstance().getWhenReady(inputFirstName, 30).sendKeys(strFirstName);
    }

    /**
     * Enter Last name on the phone plans page
     * @author Saurav.Goyal
     */
    public void enterSecondName() {
        getReusableActionsInstance().waitForElementVisibility(inputLastNameDiv, 5);
        String strLastName = FormFiller.generateRandomName();
        getReusableActionsInstance().getWhenReady(inputLastNameDiv, 30).click();
        getReusableActionsInstance().getWhenReady(inputLastName, 30).sendKeys(strLastName);
    }

    /**
     * Clicks on the 'Continue' button after giving first name and last name details. Tablet has default values which is covered with try/catch block.
     * @author Sidhartha.Vadrevu
     */
    public void clkContinueCallerID() {
        try {
            enterFirstName();
            enterSecondName();
            getReusableActionsInstance().waitForElementVisibility(callerIDContinue, 20);
            getReusableActionsInstance().executeJavaScriptClick(callerIDContinue);
            //getReusableActionsInstance().clickIfAvailable(callerIDContinue, 20);
        }catch (ElementClickInterceptedException except){
            getReusableActionsInstance().waitForElementVisibility(callerIDContinue, 20);
            getReusableActionsInstance().executeJavaScriptClick(callerIDContinue);
            //getReusableActionsInstance().clickIfAvailable(callerIDContinue, 20);
        }
    }

}