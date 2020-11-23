package com.rogers.test.tests.buyflows;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class RogersBFA_TC_01_NAC_NonRpotgTest extends BaseTestClass {

  
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
	}

    @Test(groups = {"RegressionBFA","SanityBFA","NACBFA"})
    public void redesignRogersNacRpotg() throws InterruptedException {
    	
    	 //**************************Device catalog page*****************************************
    	
        String deviceName=TestDataHandler.tc01NonRpotg.getDeviceName();
        String pricingBlockValueCataloguePage = getRogersDeviceCataloguePage().getPricingBlockCataloguePage(deviceName);
        String pricePlanInfoCataloguePage = getRogersDeviceCataloguePage().getPricePlanInfoCataloguePage(deviceName);
        String fullPriceValueCataloguePage = getRogersDeviceCataloguePage().getPhoneFullPrice(deviceName);
        reporter.reportLogPassWithScreenshot("Device Catalogue Page<br>"+"1.Device Name:"+deviceName+"\n2.Pricing block value:"+pricingBlockValueCataloguePage+"\n3.Full price Value:"+fullPriceValueCataloguePage);
        getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
        reporter.softAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen", "Modal element is not present on the screen");
        reporter.softAssert(getRogersDeviceCataloguePage().verifyGetStartedButtonOnModal(), "Get started button on the modal is present" ,"Get started button on the modal is not present");
        reporter.reportLogWithScreenshot("Modal window Popup");
        reporter.hardAssert(getRogersDeviceCataloguePage().clickGetStartedButtonOnModal(),"Clicked Get Started Button","Get Started button not able to click");
        //############################Device config page##############################
        String deviceNameDeviceConfigPage = getRogersDeviceConfigPage().deviceInfoDeviceNameDeviceConfigPage().toUpperCase();
        String deviceSizeDeviceConfigPage = getRogersDeviceConfigPage().deviceInfoDeviceSizeDeviceConfigPage().toUpperCase();
        String deviceColorDeviceConfigPage = getRogersDeviceConfigPage().deviceInfoDeviceColorDeviceConfigPage().toUpperCase();
        String deviceInfoDeviceConfigPage = deviceNameDeviceConfigPage + " " + deviceSizeDeviceConfigPage + " " + deviceColorDeviceConfigPage;
        reporter.softAssert(getRogersDeviceConfigPage().verifyDefaultSizeSelected(),"Default value for size is selected", "Default value for size is not selected");
        //reporter.softAssert(getRogersDeviceConfigPage().verifyDefaultColorSelected(),"Default value of color is selected","Default value of color is not selected");
		reporter.reportLogPassWithScreenshot("Device Config Page->"+"Device info:"+deviceInfoDeviceConfigPage);
		Thread.sleep(2000);
        String pricingBlockValueDeviceConfigPage = getRogersDeviceConfigPage().getPricingBlockValueDeviceConfigPage();
        reporter.hardAssert(pricingBlockValueCataloguePage.equals(pricingBlockValueDeviceConfigPage),"Pricing block value for device catalogue page matches with the device config page value", "Pricing blocks on Catalogue page and config page is not matching");
        String pricePlanInfoDeviceConfigPage = getRogersDeviceConfigPage().getPricePlanValueDeviceConfigPage();
        reporter.hardAssert(pricePlanInfoCataloguePage.equals(pricePlanInfoDeviceConfigPage),"Pricing Planfor device catalogue page matches with the device config page","Pricing plan in device catalogue page not matches with the device config page");
        reporter.softAssert(getRogersDeviceConfigPage().verifyBreadCrumb(),"BreadCrumb on Phone config page is working fine","BreadCrumb is not working fine");
        String fullPriceDeviceConfigPage = getRogersDeviceConfigPage().getFullPrice();
        reporter.hardAssert(fullPriceDeviceConfigPage.equals(fullPriceValueCataloguePage),"Device Full Price in device catalogue page matches with the device config page","Full price value on the device config page is not same as it is on device catalogue page");
        String promoBlockInformation = getRogersDeviceConfigPage().getPromoBlockText();
        reporter.reportLogPassWithScreenshot("Device config page Details"+"1. Price Block Value :"+pricingBlockValueDeviceConfigPage+"2. Priceplan Info:"+pricePlanInfoDeviceConfigPage+"3. Full Price:"+fullPriceDeviceConfigPage+"4. PromoBlock Info:"+promoBlockInformation);
        getRogersDeviceConfigPage().clickContinueButton();
        //############################Plan config page###############################
        reporter.softAssert(getRogersPlanConfigPage().verifyBreadCrumb(deviceName), "BreadCrumb on Plan config page is working fine","BreadCrumb is not working fine");
        reporter.hardAssert(getRogersPlanConfigPage().verifyDefaultPrice(fullPriceValueCataloguePage), "Default  price is same as it is shown in device catalogue & Config page page", "Default price is not same as it is shown in device catalogue page");
        getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
        //getRogersPlanConfigPage().selectDataOption(deviceName);
        reporter.reportLogPassWithScreenshot("Plan config page data option selected");
        getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
        getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page data protection selected");
        getRogersPlanConfigPage().clickOptionInDataProtection(deviceName);
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
        String monthlyFeesAmount = getRogersPlanConfigPage().getMonthlyFeesAmount();
        String oneTimeFeesAmount = getRogersPlanConfigPage().getOneTimeFeesAmount();
        reporter.reportLogPassWithScreenshot("Cart summary: Monthly & OneTimeFees"+monthlyFeesAmount+"&"+oneTimeFeesAmount);
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        
        //############################CheckoutPage############################//
        //***************Cart Summary*************//
        String totalMonthlyFees=getRogersCheckoutPage().getMonthlyFeeAfterTax();
        String oneTimeFee=getRogersCheckoutPage().getOneTimeFeeAfterTax();
        String purchaseIncludes=getRogersCheckoutPage().getPurchaseIncludesText();
        reporter.reportLog("Checkout page Cart Summary Info"+"1. Total Monthly Fees"+totalMonthlyFees+"2. oneTimeFee"+oneTimeFee+"3. Purchase Include"+purchaseIncludes);
        //***************Create Profile Stepper*************//
        reporter.softAssert(getRogersCheckoutPage().verifyCreateProfileTitle(),"Create profile Title Present","Create profile Title not present");
        String emailCreateProfile=getRogersCheckoutPage().setEmailCreateProfile();
        getRogersCheckoutPage().confirmEmailCreateProfile(emailCreateProfile);
        //String firstName = getRogersCheckoutPage().setFirstNameCreateProfile();
        //String lastName = getRogersCheckoutPage().setLastNameCreateProfile();
      //*************** AVS Data Code- Commented for future issue ******//
        String firstName = getRogersCheckoutPage().setFirstNameCreateProfile();
        String lastName = getRogersCheckoutPage().setLastNameCreateProfile();
        //String firstName = getRogersCheckoutPage().setFirstNameCreateProfilepage("AMARAssspeares");
        //String lastName = getRogersCheckoutPage().setLastNameCreateProfilepage("SPEARSsscheck");
        String fullNameCreateProfile=firstName+" "+lastName;
        String contactNumberCreateProfile=TestDataHandler.tc01NonRpotg.getContactNumber();
        getRogersCheckoutPage().setContactNumberCreateProfile(contactNumberCreateProfile);
        reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
        getRogersCheckoutPage().setBillingAddressCreateProfile(TestDataHandler.tc01NonRpotg.getBillingAddress());
        //getRogersCheckoutPage().clkUseBillingAddressRadioBtnCreateProfile();
        getRogersCheckoutPage().clkLanguageEnglishRadioBtnCreateProfile();
        reporter.reportLogPassWithScreenshot("Create Profile Page details provided for Address,Shipping Address & Language Selected");
        getRogersCheckoutPage().switchToRecaptchaIFrame();
        getRogersCheckoutPage().clkImNotRombotCheckbox();
        reporter.reportLogPassWithScreenshot("I'm not Robot Checked");
        getRogersCheckoutPage().switchOutOfGoogleIFrame();
        getRogersCheckoutPage().clkBtnGotoCreditEvalStepper();
        //***************Credit Evaluation Stepper*************//
        reporter.softAssert(getRogersCheckoutPage().verifyCreditEvaluationTitle(),"CreditEvaluation Title verified","CreditEvaluation Title not present");
		//getRogersCheckoutPage().setDateOfBirth(TestDataHandler.redesignRpotgData.getDateOfBirth());
		getRogersCheckoutPage().selectYearDropdownOption(TestDataHandler.tc01NonRpotg.getDateOfBirthYear());
		//span[text()='No, thanks']
		//getRogersCheckoutPage().clkNoThanks();
		getRogersCheckoutPage().selectMonthDropdownOption(TestDataHandler.tc01NonRpotg.getDateOfBirthMonth());
		getRogersCheckoutPage().selectDayDropdownOption(TestDataHandler.tc01NonRpotg.getDateOfBirthDay());
        getRogersCheckoutPage().switchToCreditCardIFrame();
        getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.tc01NonRpotg.getCreditCardDetails());
        reporter.reportLogPassWithScreenshot("DOB & Credit Card Details Entered Successfully");
        getRogersCheckoutPage().switchOutOfCreditCardIFrame();
        getRogersCheckoutPage().setExpiryDate(TestDataHandler.tc01NonRpotg.getExpiryDate());
        getRogersCheckoutPage().selectDropdownOption(TestDataHandler.tc01NonRpotg.getDropdownOption());
        getRogersCheckoutPage().setPassportNumber(TestDataHandler.tc01NonRpotg.getPassportNumber());
        reporter.reportLogPassWithScreenshot("PassportNumber Entered Successfully");
        getRogersCheckoutPage().clkCreditAuthorizationChkBox();
        getRogersCheckoutPage().clkCreditEvalContinue();
        reporter.softAssert(getRogersCheckoutPage().isCreditEvalPopupPresent(),"Credit Evaluation Popup Displayed", "Credit Evaluation popup not disaplayed");
        reporter.softAssert(getRogersCheckoutPage().isCreditEvalTextOnModalPresent(), "Credit Evaluation Text Displayed","Credit Evaluation Text not disaplayed on Modal");
        reporter.reportLogWithScreenshot("Credit Evaluation processing popup");
        reporter.hardAssert(getRogersCheckoutPage().isIdentificationLabel(),"Credit Evaluation Successful", "Credit Evaluation Identification Label not disaplayed");
       // ***************Choose a Number Stepper*************//      
        reporter.softAssert(getRogersCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed","Choose a Number Title not disaplayed");
        reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(),"Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
        getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc01NonRpotg.getCityName());
        reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully" );
        getRogersCheckoutPage().clkChosePhoneNumber();
        reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
        reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed","Find More Available Number Button not disaplayed");
        getRogersCheckoutPage().clkChooseNumberbutton();
        reporter.hardAssert(getRogersCheckoutPage().isChooseaNumberLabelDisplayed(),"Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
        reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
     // ***************Billing & Payment Stepper*************//
        reporter.softAssert(getRogersCheckoutPage().isBillingOptionsTitleDisplayed(),"Billing Options Title Displayed","Billing Options Title Not Present");
        reporter.softAssert(getRogersCheckoutPage().isPaymentMethodDropdownPresent(), "Select Payment Method Dropdown Displayed","Select Payment Method Dropdown not disaplayed");
        getRogersCheckoutPage().clkNoThanks();
        getRogersCheckoutPage().setNameOnCard(TestDataHandler.tc01NonRpotg.getNameOnCard());
        getRogersCheckoutPage().switchToCreditCardIFrame();
        getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.tc01NonRpotg.getBillingCreditCardNumber());
        getRogersCheckoutPage().switchOutOfCreditCardIFrame();
        getRogersCheckoutPage().setBillingExpiryDate(TestDataHandler.tc01NonRpotg.getExpiryDate());
        getRogersCheckoutPage().setCVVNumber(TestDataHandler.tc01NonRpotg.getCvvNumber());
        reporter.reportLogPassWithScreenshot("Billing & Payment Details Entered Successfully");
        getRogersCheckoutPage().clkAddCard();
        reporter.softAssert(getRogersCheckoutPage().isBillingOptionsTitleDisplayed(), "Billing Options Title Displayed",
				"Billing Options Title Not Present");
		reporter.softAssert(getRogersCheckoutPage().isPaymentMethodDropdownPresent(),
				"Select Payment Method Dropdown Displayed", "Select Payment Method Dropdown not disaplayed");
		getRogersCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.tc01NonRpotg.getPaymentMethod());
//        getRogersCheckoutPage().setNameOnCard(TestDataHandler.redesignRpotgData.getNameOnCard());
//        getRogersCheckoutPage().switchToCreditCardIFrame();
//        getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.redesignRpotgData.getBillingCreditCardNumber());
//        getRogersCheckoutPage().switchOutOfCreditCardIFrame();
//        getRogersCheckoutPage().setBillingExpiryDate(TestDataHandler.redesignRpotgData.getExpiryDate());
//        getRogersCheckoutPage().setCVVNumber(TestDataHandler.redesignRpotgData.getCvvNumber());
//        reporter.reportLogPassWithScreenshot("Billing & Payment Details Entered Successfully");
//        getRogersCheckoutPage().clkAddCard();
        getRogersCheckoutPage().clkBillingContinueButton();
//        reporter.hardAssert(getRogersCheckoutPage().isCardDetailsDisplayed(),"Card details disaplayed in Billing & Payment Options", "Card details not disaplayed in Billing & Payment Options");
        //***************Billing Options Stepper*************//
        reporter.softAssert(getRogersCheckoutPage().clkBillingAddress(),"Billing Address radio button is selected ","Billing Address is not selected");
        getRogersCheckoutPage().clkDeliveryMethodStandard();
        reporter.reportLogPassWithScreenshot("Billing Options Stepper");
        Thread.sleep(1000);
        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPassWithScreenshot("Continue button clicked from Billing Options Stepper");
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
      //***************Order Review Page*************//
        reporter.softAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(),"Order Review Page Title Present","Order Review Page Title is not Present");
        reporter.reportLogPass("Order Review Page");
        String totalMonthlyFeesReviewPage=getRogersReviewOrderPage().getMonthlyFeeAfterTax();
        reporter.hardAssert(totalMonthlyFees.equals(totalMonthlyFeesReviewPage),"Total Monthly Fee after tax matches with checkout page","Total Monthly Fee after tax not matches with checkout page");
        String oneTimeFeesReviewPage=getRogersReviewOrderPage().getOneTimeFeeAfterTax();
        reporter.hardAssert(oneTimeFee.equals(oneTimeFeesReviewPage),"Total One time fee after tax matches with checkout page","Total One time fee after tax not matches with checkout page");
        String puchaseIncludeReviewPage=getRogersReviewOrderPage().getPurchaseIncludesText();
        reporter.reportLogPassWithScreenshot("Order Review Page"+"1.Monthly Fees"+totalMonthlyFeesReviewPage+"2. OnetimeFees:"+oneTimeFeesReviewPage+"3.Purchase Include :"+puchaseIncludeReviewPage);
        String contactNameReviewPage=getRogersReviewOrderPage().getContactName();
        reporter.hardAssert(fullNameCreateProfile.equals(contactNameReviewPage),"Contact Name in Order Review Page matches as entered in Create Profile stepper","Contact Name in Order Review Page not matches as entered in Create Profile stepper");
        String contactEmailReviewPage=getRogersReviewOrderPage().getContactEmail();
        reporter.hardAssert(emailCreateProfile.equals(contactEmailReviewPage),"Contact email in Order Review Page matches as entered in Create Profile stepper","Contact email in Order Review Page not matches as entered in Create Profile stepper");
        reporter.reportLogPassWithScreenshot("Order Review Page : Contact Details");
        getRogersReviewOrderPage().clkFinancingConsentCheckbox();
        getRogersReviewOrderPage().clkAgreementConsentCheckbox();
        getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        getRogersReviewOrderPage().clkSubmitOrderBtn();
        //************Order Confirmation Page****************//
        reporter.hardAssert(getRogersNACOrderConfirmationPage().isOrderConfirmationTitlePresent(),"Order Confrimation Page Title Present","Order Confrimation Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Confirmation Page");
        String totalMonthlyFeesConfirmationPage=getRogersNACOrderConfirmationPage().getMonthlyFeeAfterTax();
        reporter.hardAssert(totalMonthlyFees.equals(totalMonthlyFeesConfirmationPage),"Total Monthly Fee after tax matches with checkout page","Total Monthly Fee after tax not matches with checkout page");
        String oneTimeFeesConfirmationPage=getRogersNACOrderConfirmationPage().getOneTimeFeeAfterTax();
        reporter.hardAssert(oneTimeFee.equals(oneTimeFeesConfirmationPage),"Total One time fee after tax matches with checkout page","Total One time fee after tax not matches with checkout page");
        String purchaseIncludesConfrimation=getRogersNACOrderConfirmationPage().getPurchaseIncludesText();
        reporter.reportLogPassWithScreenshot("Purchase includes captured as" + "-->" +purchaseIncludesConfrimation);
        //reporter.hardAssert(getRogersNACOrderConfirmationPage().isLearnMoreLinkDisplayed(),"Learn More Link Displayed","Learn More Link not Present");
        //reporter.reportLogPassWithScreenshot("Order Review Page: LearnMore Link");
        
  }


        @AfterMethod(alwaysRun = true)
        public void afterTest () throws InterruptedException {
            closeSession();
        }
    }


