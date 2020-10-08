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
        String pricingBlockValueCataloguePage = rogers_device_catalogue_page.getPricingBlockCataloguePage(deviceName);
        String pricePlanInfoCataloguePage = rogers_device_catalogue_page.getPricePlanInfoCataloguePage(deviceName);
        String fullPriceValueCataloguePage = rogers_device_catalogue_page.getPhoneFullPrice(deviceName);
        reporter.reportLogPassWithScreenshot("Device Catalogue Page<br>"+"1.Device Name:"+deviceName+"\n2.Pricing block value:"+pricingBlockValueCataloguePage+"\n3.Full price Value:"+fullPriceValueCataloguePage);
        rogers_device_catalogue_page.clickDeviceTileCTAButton(deviceName);
        reporter.softAssert(rogers_device_catalogue_page.isModalDisplayed(), "Modal element is present on the screen", "Modal element is not present on the screen");
        reporter.softAssert(rogers_device_catalogue_page.verifyGetStartedButtonOnModal(), "Get started button on the modal is present" ,"Get started button on the modal is not present");
        reporter.reportLogWithScreenshot("Modal window Popup");
        reporter.hardAssert(rogers_device_catalogue_page.clickGetStartedButtonOnModal(),"Clicked Get Started Button","Get Started button not able to click");
        //############################Device config page##############################
        String deviceNameDeviceConfigPage = rogers_device_config_page.deviceInfoDeviceNameDeviceConfigPage().toUpperCase();
        String deviceSizeDeviceConfigPage = rogers_device_config_page.deviceInfoDeviceSizeDeviceConfigPage().toUpperCase();
        String deviceColorDeviceConfigPage = rogers_device_config_page.deviceInfoDeviceColorDeviceConfigPage().toUpperCase();
        String deviceInfoDeviceConfigPage = deviceNameDeviceConfigPage + " " + deviceSizeDeviceConfigPage + " " + deviceColorDeviceConfigPage;
        reporter.softAssert(rogers_device_config_page.verifyDefaultSizeSelected(),"Default value for size is selected", "Default value for size is not selected");
        //reporter.softAssert(rogers_device_config_page.verifyDefaultColorSelected(),"Default value of color is selected","Default value of color is not selected");
		reporter.reportLogPassWithScreenshot("Device Config Page->"+"Device info:"+deviceInfoDeviceConfigPage);
		Thread.sleep(2000);
        String pricingBlockValueDeviceConfigPage = rogers_device_config_page.getPricingBlockValueDeviceConfigPage();
        reporter.hardAssert(pricingBlockValueCataloguePage.equals(pricingBlockValueDeviceConfigPage),"Pricing block value for device catalogue page matches with the device config page value", "Pricing blocks on Catalogue page and config page is not matching");
        String pricePlanInfoDeviceConfigPage = rogers_device_config_page.getPricePlanValueDeviceConfigPage();
        reporter.hardAssert(pricePlanInfoCataloguePage.equals(pricePlanInfoDeviceConfigPage),"Pricing Planfor device catalogue page matches with the device config page","Pricing plan in device catalogue page not matches with the device config page");
        reporter.softAssert(rogers_device_config_page.verifyBreadCrumb(),"BreadCrumb on Phone config page is working fine","BreadCrumb is not working fine");
        String fullPriceDeviceConfigPage = rogers_device_config_page.getFullPrice();
        reporter.hardAssert(fullPriceDeviceConfigPage.equals(fullPriceValueCataloguePage),"Device Full Price in device catalogue page matches with the device config page","Full price value on the device config page is not same as it is on device catalogue page");
        String promoBlockInformation = rogers_device_config_page.getPromoBlockText();
        reporter.reportLogPassWithScreenshot("Device config page Details"+"1. Price Block Value :"+pricingBlockValueDeviceConfigPage+"2. Priceplan Info:"+pricePlanInfoDeviceConfigPage+"3. Full Price:"+fullPriceDeviceConfigPage+"4. PromoBlock Info:"+promoBlockInformation);
        rogers_device_config_page.clickContinueButton();        
        //############################Plan config page###############################
        reporter.softAssert(rogers_plan_config_page.verifyBreadCrumb(deviceName), "BreadCrumb on Plan config page is working fine","BreadCrumb is not working fine");
        reporter.hardAssert(rogers_plan_config_page.verifyDefaultPrice(fullPriceValueCataloguePage), "Default  price is same as it is shown in device catalogue & Config page page", "Default price is not same as it is shown in device catalogue page");
        rogers_plan_config_page.clickPreCartDeviceCostContinueButton();
        //rogers_plan_config_page.selectDataOption(deviceName);	
        reporter.reportLogPassWithScreenshot("Plan config page data option selected");
        rogers_plan_config_page.clickPreCartDataOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
        rogers_plan_config_page.clickPreCartTalkOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page data protection selected");
        rogers_plan_config_page.clickOptionInDataProtection(deviceName);
        rogers_plan_config_page.clickPreCartAddonsContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
        String monthlyFeesAmount = rogers_plan_config_page.getMonthlyFeesAmount();
        String oneTimeFeesAmount = rogers_plan_config_page.getOneTimeFeesAmount();
        reporter.reportLogPassWithScreenshot("Cart summary: Monthly & OneTimeFees"+monthlyFeesAmount+"&"+oneTimeFeesAmount);
        rogers_plan_config_page.clickCartSummaryContinueButton();
        
        //############################CheckoutPage############################//
        //***************Cart Summary*************//
        String totalMonthlyFees=rogers_checkout_page.getMonthlyFeeAfterTax();
        String oneTimeFee=rogers_checkout_page.getOneTimeFeeAfterTax();
        String purchaseIncludes=rogers_checkout_page.getPurchaseIncludesText();
        reporter.reportLog("Checkout page Cart Summary Info"+"1. Total Monthly Fees"+totalMonthlyFees+"2. oneTimeFee"+oneTimeFee+"3. Purchase Include"+purchaseIncludes);
        //***************Create Profile Stepper*************//
        reporter.softAssert(rogers_checkout_page.verifyCreateProfileTitle(),"Create profile Title Present","Create profile Title not present");
        String emailCreateProfile=rogers_checkout_page.setEmailCreateProfile();
        rogers_checkout_page.confirmEmailCreateProfile(emailCreateProfile);
        //String firstName = rogers_checkout_page.setFirstNameCreateProfile();
        //String lastName = rogers_checkout_page.setLastNameCreateProfile();
      //*************** AVS Data Code- Commented for future issue ******//
        String firstName = rogers_checkout_page.setFirstNameCreateProfile();
        String lastName = rogers_checkout_page.setLastNameCreateProfile();
        //String firstName = rogers_checkout_page.setFirstNameCreateProfilepage("AMARAssspeares");
        //String lastName = rogers_checkout_page.setLastNameCreateProfilepage("SPEARSsscheck");
        String fullNameCreateProfile=firstName+" "+lastName;
        String contactNumberCreateProfile=TestDataHandler.tc01NonRpotg.getContactNumber();
        rogers_checkout_page.setContactNumberCreateProfile(contactNumberCreateProfile);
        reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
        rogers_checkout_page.setBillingAddressCreateProfile(TestDataHandler.tc01NonRpotg.getBillingAddress());
        rogers_checkout_page.clkUseBillingAddressRadioBtnCreateProfile();
        rogers_checkout_page.clkLanguageEnglishRadioBtnCreateProfile();
        reporter.reportLogPassWithScreenshot("Create Profile Page details provided for Address,Shipping Address & Language Selected");
        rogers_checkout_page.switchToRecaptchaIFrame();
        rogers_checkout_page.clkImNotRombotCheckbox();
        reporter.reportLogPassWithScreenshot("I'm not Robot Checked");
        rogers_checkout_page.switchOutOfGoogleIFrame();
        rogers_checkout_page.clkBtnGotoCreditEvalStepper();
        //***************Credit Evaluation Stepper*************//
        reporter.softAssert(rogers_checkout_page.verifyCreditEvaluationTitle(),"CreditEvaluation Title verified","CreditEvaluation Title not present");
		//rogers_checkout_page.setDateOfBirth(TestDataHandler.redesignRpotgData.getDateOfBirth());
		rogers_checkout_page.selectYearDropdownOption(TestDataHandler.tc01NonRpotg.getDateOfBirthYear());
		//span[text()='No, thanks']
		//rogers_checkout_page.clkNoThanks();
		rogers_checkout_page.selectMonthDropdownOption(TestDataHandler.tc01NonRpotg.getDateOfBirthMonth());
		rogers_checkout_page.selectDayDropdownOption(TestDataHandler.tc01NonRpotg.getDateOfBirthDay());
        rogers_checkout_page.switchToCreditCardIFrame();
        rogers_checkout_page.setCreditCardNumberIFrame(TestDataHandler.tc01NonRpotg.getCreditCardDetails());
        reporter.reportLogPassWithScreenshot("DOB & Credit Card Details Entered Successfully");
        rogers_checkout_page.switchOutOfCreditCardIFrame();
        rogers_checkout_page.setExpiryDate(TestDataHandler.tc01NonRpotg.getExpiryDate());
        rogers_checkout_page.selectDropdownOption(TestDataHandler.tc01NonRpotg.getDropdownOption());
        rogers_checkout_page.setPassportNumber(TestDataHandler.tc01NonRpotg.getPassportNumber());
        reporter.reportLogPassWithScreenshot("PassportNumber Entered Successfully");
        rogers_checkout_page.clkCreditAuthorizationChkBox();
        rogers_checkout_page.clkCreditEvalContinue();
        reporter.softAssert(rogers_checkout_page.isCreditEvalPopupPresent(),"Credit Evaluation Popup Displayed", "Credit Evaluation popup not disaplayed");
        reporter.softAssert(rogers_checkout_page.isCreditEvalTextOnModalPresent(), "Credit Evaluation Text Displayed","Credit Evaluation Text not disaplayed on Modal");
        reporter.reportLogWithScreenshot("Credit Evaluation processing popup");
        reporter.hardAssert(rogers_checkout_page.isIdentificationLabel(),"Credit Evaluation Successful", "Credit Evaluation Identification Label not disaplayed");
       // ***************Choose a Number Stepper*************//      
        reporter.softAssert(rogers_checkout_page.isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed","Choose a Number Title not disaplayed");
        reporter.softAssert(rogers_checkout_page.isChooseNumberTabsDisplayed(),"Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
        rogers_checkout_page.selectCityDropdownOption(TestDataHandler.tc01NonRpotg.getCityName());
        reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully" );
        rogers_checkout_page.clkChosePhoneNumber();
        reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
        reporter.softAssert(rogers_checkout_page.isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed","Find More Available Number Button not disaplayed");
        rogers_checkout_page.clkChooseNumberbutton();
        reporter.hardAssert(rogers_checkout_page.isChooseaNumberLabelDisplayed(),"Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
        reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
     // ***************Billing & Payment Stepper*************//
        reporter.softAssert(rogers_checkout_page.isBillingOptionsTitleDisplayed(),"Billing Options Title Displayed","Billing Options Title Not Present");
        reporter.softAssert(rogers_checkout_page.isPaymentMethodDropdownPresent(), "Select Payment Method Dropdown Displayed","Select Payment Method Dropdown not disaplayed");
        rogers_checkout_page.clkNoThanks();
        rogers_checkout_page.setNameOnCard(TestDataHandler.tc01NonRpotg.getNameOnCard());
        rogers_checkout_page.switchToCreditCardIFrame();
        rogers_checkout_page.setCreditCardNumberIFrame(TestDataHandler.tc01NonRpotg.getBillingCreditCardNumber());
        rogers_checkout_page.switchOutOfCreditCardIFrame();
        rogers_checkout_page.setBillingExpiryDate(TestDataHandler.tc01NonRpotg.getExpiryDate());
        rogers_checkout_page.setCVVNumber(TestDataHandler.tc01NonRpotg.getCvvNumber());
        reporter.reportLogPassWithScreenshot("Billing & Payment Details Entered Successfully");
        rogers_checkout_page.clkAddCard();
        reporter.softAssert(rogers_checkout_page.isBillingOptionsTitleDisplayed(), "Billing Options Title Displayed",
				"Billing Options Title Not Present");
		reporter.softAssert(rogers_checkout_page.isPaymentMethodDropdownPresent(),
				"Select Payment Method Dropdown Displayed", "Select Payment Method Dropdown not disaplayed");
		rogers_checkout_page.selectPaymentMethodDropdownOption(TestDataHandler.tc01NonRpotg.getPaymentMethod());
//        rogers_checkout_page.setNameOnCard(TestDataHandler.redesignRpotgData.getNameOnCard());
//        rogers_checkout_page.switchToCreditCardIFrame();
//        rogers_checkout_page.setCreditCardNumberIFrame(TestDataHandler.redesignRpotgData.getBillingCreditCardNumber());
//        rogers_checkout_page.switchOutOfCreditCardIFrame();
//        rogers_checkout_page.setBillingExpiryDate(TestDataHandler.redesignRpotgData.getExpiryDate());
//        rogers_checkout_page.setCVVNumber(TestDataHandler.redesignRpotgData.getCvvNumber());
//        reporter.reportLogPassWithScreenshot("Billing & Payment Details Entered Successfully");
//        rogers_checkout_page.clkAddCard();
        rogers_checkout_page.clkBillingContinueButton();
//        reporter.hardAssert(rogers_checkout_page.isCardDetailsDisplayed(),"Card details disaplayed in Billing & Payment Options", "Card details not disaplayed in Billing & Payment Options");
        //***************Billing Options Stepper*************//
        reporter.softAssert(rogers_checkout_page.clkBillingAddress(),"Billing Address radio button is selected ","Billing Address is not selected");
        rogers_checkout_page.clkDeliveryMethodStandard();
        reporter.reportLogPassWithScreenshot("Billing Options Stepper");
        Thread.sleep(1000);
        rogers_checkout_page.clkContinueBtnShipping();
        reporter.reportLogPassWithScreenshot("Continue button clicked from Billing Options Stepper");
        rogers_checkout_page.clksubmitBtnCheckoutPage();
      //***************Order Review Page*************//
        reporter.softAssert(rogers_review_order_page.isOrderReviewPageTitlePresent(),"Order Review Page Title Present","Order Review Page Title is not Present");
        reporter.reportLogPass("Order Review Page");
        String totalMonthlyFeesReviewPage=rogers_review_order_page.getMonthlyFeeAfterTax();
        reporter.hardAssert(totalMonthlyFees.equals(totalMonthlyFeesReviewPage),"Total Monthly Fee after tax matches with checkout page","Total Monthly Fee after tax not matches with checkout page");
        String oneTimeFeesReviewPage=rogers_review_order_page.getOneTimeFeeAfterTax();
        reporter.hardAssert(oneTimeFee.equals(oneTimeFeesReviewPage),"Total One time fee after tax matches with checkout page","Total One time fee after tax not matches with checkout page");
        String puchaseIncludeReviewPage=rogers_review_order_page.getPurchaseIncludesText();
        reporter.reportLogPassWithScreenshot("Order Review Page"+"1.Monthly Fees"+totalMonthlyFeesReviewPage+"2. OnetimeFees:"+oneTimeFeesReviewPage+"3.Purchase Include :"+puchaseIncludeReviewPage);
        String contactNameReviewPage=rogers_review_order_page.getContactName();
        reporter.hardAssert(fullNameCreateProfile.equals(contactNameReviewPage),"Contact Name in Order Review Page matches as entered in Create Profile stepper","Contact Name in Order Review Page not matches as entered in Create Profile stepper");
        String contactEmailReviewPage=rogers_review_order_page.getContactEmail();
        reporter.hardAssert(emailCreateProfile.equals(contactEmailReviewPage),"Contact email in Order Review Page matches as entered in Create Profile stepper","Contact email in Order Review Page not matches as entered in Create Profile stepper");
        reporter.reportLogPassWithScreenshot("Order Review Page : Contact Details");
        rogers_review_order_page.clkFinancingConsentCheckbox();
        rogers_review_order_page.clkAgreementConsentCheckbox();
        rogers_review_order_page.clkUpfrontConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        rogers_review_order_page.clkSubmitOrderBtn();
        //************Order Confirmation Page****************//
        reporter.hardAssert(rogers_NAC_order_confirmation_page.isOrderConfirmationTitlePresent(),"Order Confrimation Page Title Present","Order Confrimation Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Confirmation Page");
        String totalMonthlyFeesConfirmationPage=rogers_NAC_order_confirmation_page.getMonthlyFeeAfterTax();
        reporter.hardAssert(totalMonthlyFees.equals(totalMonthlyFeesConfirmationPage),"Total Monthly Fee after tax matches with checkout page","Total Monthly Fee after tax not matches with checkout page");
        String oneTimeFeesConfirmationPage=rogers_NAC_order_confirmation_page.getOneTimeFeeAfterTax();
        reporter.hardAssert(oneTimeFee.equals(oneTimeFeesConfirmationPage),"Total One time fee after tax matches with checkout page","Total One time fee after tax not matches with checkout page");
        String purchaseIncludesConfrimation=rogers_NAC_order_confirmation_page.getPurchaseIncludesText();
        reporter.reportLogPassWithScreenshot("Purchase includes captured as" + "-->" +purchaseIncludesConfrimation);
        //reporter.hardAssert(rogers_NAC_order_confirmation_page.isLearnMoreLinkDisplayed(),"Learn More Link Displayed","Learn More Link not Present");
        //reporter.reportLogPassWithScreenshot("Order Review Page: LearnMore Link");
        
  }


        @AfterMethod(alwaysRun = true)
        public void afterTest () throws InterruptedException {
            closeSession();
        }
    }


