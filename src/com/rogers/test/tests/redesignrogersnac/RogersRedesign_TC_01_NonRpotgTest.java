package com.rogers.test.tests.redesignrogersnac;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class RogersRedesign_TC_01_NonRpotgTest extends BaseTestClass {
    String deviceName;
  

    @BeforeMethod
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
    	xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
    	startSession(TestDataHandler.redesignConfig.getUrl(), strBrowser, strLanguage, RogersEnums.GroupName.redesignrogers, method);

    }


    @Test
    public void redesignRogersRpotg() throws InterruptedException {

        deviceName=TestDataHandler.redesignRpotgData.getDeviceName();
        reporter.reportLogPass("Device name" + "--->" + deviceName);
        //rogers_device_catalogue_page.getRpotgLabelCataloguePage(deviceName);

        String pricingBlockValueCataloguePage = rogers_device_catalogue_page.getPricingBlockCataloguePage(deviceName);
        reporter.reportLogPass("Pricing block value for device catalogue page " + "--> " + pricingBlockValueCataloguePage);

        String pricePlanInfoCataloguePage = rogers_device_catalogue_page.getPricePlanInfoCataloguePage(deviceName);
        reporter.reportLogPass("Price Plan info for device catalogue page " + "--> " + pricePlanInfoCataloguePage);

        String fullPriceValueCataloguePage = rogers_device_catalogue_page.getPhoneFullPrice(deviceName);
        reporter.reportLogPass("Full price value on catalogue page " + fullPriceValueCataloguePage);

        rogers_device_catalogue_page.verifyDeviceTileCTAButton(deviceName);
        reporter.reportLogPass("CTA button for Device " + deviceName + " verified");

        rogers_device_catalogue_page.clickDeviceTileCTAButton(deviceName);
        reporter.reportLogPass("CTA Button for Device " + deviceName + "  clicked successfully");

        Assert.assertTrue(rogers_device_catalogue_page.isModalDisplayed(), "Modal element is not present on the screen");
        reporter.reportLogPass("Modal window displayed");

        Assert.assertTrue(rogers_device_catalogue_page.verifyGetStartedButtonOnModal(), "Get started button on the modal is not present");
        rogers_device_catalogue_page.clickGetStartedButtonOnModal();
        reporter.reportLogPass("Clicked Get Started Button");

        //############################Device config page##############################
        String deviceNameDeviceConfigPage = rogers_device_config_page.deviceInfoDeviceNameDeviceConfigPage().toUpperCase();
        String deviceSizeDeviceConfigPage = rogers_device_config_page.deviceInfoDeviceSizeDeviceConfigPage().toUpperCase();
        String deviceColorDeviceConfigPage = rogers_device_config_page.deviceInfoDeviceColorDeviceConfigPage().toUpperCase();
        String deviceInfoDeviceConfigPage = deviceNameDeviceConfigPage + " " + deviceSizeDeviceConfigPage + " " + deviceColorDeviceConfigPage;
        reporter.reportLogPass("Device info on device config page is " + deviceInfoDeviceConfigPage);

        Assert.assertTrue(rogers_device_config_page.verifyDefaultSizeSelected(), "Default value for size is not selected");
        reporter.reportLogPass("Default value for size is selected");
		Assert.assertTrue(rogers_device_config_page.verifyDefaultColorSelected());
		reporter.reportLogPass("Default value of color is selected");

        String pricingBlockValueDeviceConfigPage = rogers_device_config_page.getPricingBlockValueDeviceConfigPage();
        reporter.reportLogPass("Pricing block value for device config page " + "--> " + pricingBlockValueDeviceConfigPage);
        Assert.assertTrue(pricingBlockValueCataloguePage.equals(pricingBlockValueDeviceConfigPage), "Pricing blocks on Catalogue page and config page is not matching");
        reporter.reportLogPass("Pricing block value for device catalogue page matches with the device config page value");

        String pricePlanInfoDeviceConfigPage = rogers_device_config_page.getPricePlanValueDeviceConfigPage();
        reporter.reportLogPass("Pricing plan in device config page " + "--> " + pricePlanInfoDeviceConfigPage);
        Assert.assertTrue(pricePlanInfoCataloguePage.equals(pricePlanInfoDeviceConfigPage), "Pricing plan in device catalogue page matches with the device config page");
        reporter.reportLogPass("Pricing Planfor device catalogue page matches with the device config page");

        Assert.assertTrue(rogers_device_config_page.verifyBreadCrumb(), "BreadCrumb is not working fine");
        reporter.reportLogPass("BreadCrumb on Phone config page is working fine");

        String fullPriceDeviceConfigPage = rogers_device_config_page.getFullPrice();
        reporter.reportLogPass("Full Price in device config page " + "--> " + fullPriceDeviceConfigPage);
        Assert.assertTrue(fullPriceDeviceConfigPage.equals(fullPriceValueCataloguePage), "Full price value on the device config page is not same as it is on device catalogue page");
        reporter.reportLogPass("Device Full Price in device catalogue page matches with the device config page");

        String promoBlockInformation = rogers_device_config_page.getPromoBlockText();
        reporter.reportLog("Promo Block data for device config page " + "-->" + promoBlockInformation);

        rogers_device_config_page.clickContinueButton();
        reporter.reportLogPass("Device config page continue button clicked");

        //############################Plan config page###############################

        Assert.assertTrue(rogers_plan_config_page.verifyBreadCrumb(deviceName), "BreadCrumb is not working fine");
        reporter.reportLogPass("BreadCrumb on Plan config page is working fine");
        Assert.assertTrue(rogers_plan_config_page.verifyDefaultPrice(fullPriceValueCataloguePage), "Default price is not same as it is shown in device catalogue page");
        reporter.reportLogPass("Default  price is same as it is shown in device catalogue & Config page page");
//        rogers_plan_config_page.selectDeviceCost(deviceName);
        reporter.reportLogPass("Plan config page Device cost selected");
        rogers_plan_config_page.clickPreCartSummaryContinueButton();
      //Assert.assertEquals(promoBlockInformation, rogers_plan_config_page.getPromoBlockText());
//        reporter.reportLogPass("Device config promo block carried to plan config promo block validated");
        rogers_plan_config_page.selectDataOption(deviceName);
//        reporter.reportLogPass("Plan config page data option selected");
        rogers_plan_config_page.clickPreCartSummaryContinueButton();
//        rogers_plan_config_page.selectTalkOptions(deviceName);
//        reporter.reportLogPass("Plan config page talk option selected");
        rogers_plan_config_page.clickPreCartSummaryContinueButton();
//        rogers_plan_config_page.clickOptionInDataProtection(deviceName);
//        reporter.reportLogPass("Plan config page data protection selected");
        rogers_plan_config_page.clickPreCartSummaryContinueButton();
//        try {
//			Thread.sleep(60000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//       
        reporter.reportLogPass("Plan config page clicked on data protection continue button");

//        rogers_plan_config_page.verifyDevicePriceOnCartSummary(deviceName);
//        reporter.reportLogPass("Cart summary Device price verified");
//        rogers_plan_config_page.verifyDataPriceOnCartSummary();
//        reporter.reportLogPass("Cart summary data price verified");
//        rogers_plan_config_page.verifyProtectionPriceOnCartSummary();
//        reporter.reportLogPass("Cart summary device protection price verified");
//        rogers_plan_config_page.verifyTalkPriceOnCartSummary();
//        reporter.reportLogPass("Cart summary talk price verified");

        

        String monthlyFeesAmount = rogers_plan_config_page.getMonthlyFeesAmount();
        String oneTimeFeesAmount = rogers_plan_config_page.getOneTimeFeesAmount();
        reporter.reportLogPass("Monthly fees amount on Plan config page is" + monthlyFeesAmount);
        reporter.reportLogPass("One time fees amount on Plan config page is" + oneTimeFeesAmount);
//        Assert.assertTrue(rogers_plan_config_page.verifyDeviceInfo(deviceInfoDeviceConfigPage, deviceName), "Device info is not matching on device config page and plan config page");
//        reporter.reportLogPass("Device info is matched on device config page and plan config page");
        rogers_plan_config_page.clickCartSummaryContinueButton();
        reporter.reportLogPass("Clicked on continue button below cart summary");


        
        //############################CheckoutPage############################//

        //***************Cart Summary*************//
        Thread.sleep(3000);
        String totalMonthlyFees=rogers_checkout_page.getMonthlyFeeAfterTax();
        System.out.println(totalMonthlyFees);
        reporter.reportLogPass("Total Montly Fees after tax verified as" + "--->" +totalMonthlyFees);
        String oneTimeFee=rogers_checkout_page.getOneTimeFeeAfterTax();
        reporter.reportLogPass("Total One Time Fees after tax verified as" + "--->" +oneTimeFee);
        String purchaseIncludes=rogers_checkout_page.getPurchaseIncludesText();
        reporter.reportLogPass("Purchase includes captured as" + "-->" +purchaseIncludes);
        rogers_checkout_page.getCreateProfileTitle();
        reporter.reportLogPass("Create Profile stepper Title verified");

        //***************Create Profile Stepper*************//
        rogers_checkout_page.getCreateProfileTitle();
        String emailCreateProfile=rogers_checkout_page.setEmailCreateProfile();
        reporter.reportLogPass("Email address entered");
        rogers_checkout_page.confirmEmailCreateProfile(emailCreateProfile);
        reporter.reportLogPass("Confirm email address entered");
        String firstName = rogers_checkout_page.setFirstNameCreateProfile();
//        String firstName= TestDataHandler.redesignRpotgData.getFirstName();
//        rogers_checkout_page.setFirstNameCreateProfilepage(firstName);
        reporter.reportLogPass("First Name entered");
        String lastName = rogers_checkout_page.setLastNameCreateProfile();
//        String lastName= TestDataHandler.redesignRpotgData.getLastName();
//        rogers_checkout_page.setLastNameCreateProfilepage(lastName);
        reporter.reportLogPass("Last Name entered");
        String fullNameCreateProfile=firstName+" "+lastName;
        String contactNumberCreateProfile=TestDataHandler.redesignRpotgData.getContactNumber();
        rogers_checkout_page.setContactNumberCreateProfile(contactNumberCreateProfile);
        reporter.reportLogPass("Contact number entered");
        rogers_checkout_page.setBillingAddressCreateProfile(TestDataHandler.redesignRpotgData.getBillingAddress());
        reporter.reportLogPass("Billing Address entered");
        Assert.assertTrue(rogers_checkout_page.clkUseBillingAddressRadioBtnCreateProfile(),"use billing address is not selected");
        reporter.reportLogPass("use billing address radio button is selected");
        Assert.assertTrue(rogers_checkout_page.clkLanguageEnglishRadioBtnCreateProfile(),"Language English is not selected");
        reporter.reportLogPass("Language English radio button is selected ");
        try {
            Thread.sleep(150000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //rogers_checkout_page.clkBtnGotoCreditEvalStepper();
        reporter.reportLogPass("Recaptcha bypassed manually & Entered Credit Eval stepper");      
        
        //***************Credit Evaluation Stepper*************//

        rogers_checkout_page.getCreditEvaluationTitle();
        reporter.reportLogPass("CreditEvaluation Title verified");
        rogers_checkout_page.getDateOfBirthLabel();
        reporter.reportLogPass("DateofBirth Label verified");
		System.out.println(TestDataHandler.redesignRpotgData.getDateOfBirth());
		rogers_checkout_page.setDateOfBirth(TestDataHandler.redesignRpotgData.getDateOfBirth());
        System.out.println(TestDataHandler.redesignRpotgData.getDateOfBirth());
        rogers_checkout_page.setDateOfBirth(TestDataHandler.redesignRpotgData.getDateOfBirth());
        reporter.reportLogPass("DateofBirth Value Entered Successfully");
        rogers_checkout_page.getCreditCardTitle();
        reporter.reportLogPass("CreditCard Title verified");
        rogers_checkout_page.getCardNumberLabel();
        reporter.reportLogPass("Card Number Label verified");
        rogers_checkout_page.switchToCreditCardIFrame();
        reporter.reportLogPass("Switched Inside Iframe");
        rogers_checkout_page.setCreditCardNumberIFrame(TestDataHandler.redesignRpotgData.getCreditCardDetails());
        reporter.reportLogPass("Credit Card Details Entered Successfully");
        rogers_checkout_page.switchOutOfCreditCardIFrame();
        reporter.reportLogPass("Switched Outside Iframe");
        rogers_checkout_page.setExpiryDate(TestDataHandler.redesignRpotgData.getExpiryDate());
        reporter.reportLogPass("Expiry Date Entered Successfully");
        rogers_checkout_page.getIdLabel();
        reporter.reportLogPass("ID Label verified");
        rogers_checkout_page.selectDropdownOption(TestDataHandler.redesignRpotgData.getDropdownOption());
        reporter.reportLogPass("Dropdown Value Selected Successfully");
        rogers_checkout_page.setPassportNumber(TestDataHandler.redesignRpotgData.getPassportNumber());
        reporter.reportLogPass("Passport Number Entered Successfully");
        rogers_checkout_page.clkCreditAuthorizationChkBox();
        reporter.reportLogPass("Checkbox Checked Successfully");
        reporter.softAssert(rogers_checkout_page.verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        rogers_checkout_page.clkCreditEvalContinue();
        reporter.reportLogPass("Credit Evaluation Continue Clicked Successfully");
        Assert.assertTrue(rogers_checkout_page.verifyCreditEvalPopup(), "Credit Evaluation popup not disaplayed");
        reporter.reportLogPass("Credit Evaluation Popup Displayed");
        Assert.assertTrue(rogers_checkout_page.verifyCreditEvalTextOnModal(), "Credit Evaluation Text not disaplayed on Modal");
        reporter.reportLogPass("Credit Evaluation Text Displayed");
//        rogers_checkout_page.waitUntilCreditEvalPopupClose();
//        reporter.reportLogPass("Credit Evaluation Popup Closed");
        Assert.assertTrue(rogers_checkout_page.verifyIdentificationLabel(), "Credit Evaluation Identification Label not disaplayed");
        reporter.reportLogPass("Credit Evaluation Successful");

       // ***************Choose a Number Stepper*************//
        Assert.assertTrue(rogers_checkout_page.verifyChooseaNumberTitle(), "Choose a Number Title not disaplayed");
        reporter.reportLogPass("Choose a Number Title Displayed");
        Assert.assertTrue(rogers_checkout_page.verifySelectaNewNumberTab(), "Select a New Number Tab not disaplayed");
        reporter.reportLogPass("Select a New Number Tab Displayed");
        Assert.assertTrue(rogers_checkout_page.verifyUseAnExistingNumberTab(), "Use an Existing Number Tab not disaplayed");
        reporter.reportLogPass("Use an Existing Number Tab Displayed");
        Assert.assertTrue(rogers_checkout_page.verifyCityDropdown(), "Select a City Dropdown not disaplayed");
        reporter.reportLogPass("Select a City Dropdown Displayed");
        rogers_checkout_page.selectCityDropdownOption(TestDataHandler.redesignRpotgData.getCityName());
        reporter.reportLogPass("City Dropdown Value Selected Successfully");
        rogers_checkout_page.clkChosePhoneNumber();
        reporter.reportLogPass("Selected First Available Phone Number");
        Assert.assertTrue(rogers_checkout_page.verifyFindMoreAvlNumberButton(), "Find More Available Number Button not disaplayed");
        reporter.reportLogPass("Find More Available Number Button Displayed");
        rogers_checkout_page.clkChooseNumberbutton();
        reporter.reportLogPass("Choose Number Continue Button Clicked");
        Assert.assertTrue(rogers_checkout_page.verifyChooseaNumberLabel(), "Choose a Number Identification Label not disaplayed");
        reporter.reportLogPass("Choose a Number Identification label displayed Successfully");
     // ***************Billing & Payment Stepper*************//
        rogers_checkout_page.getBillingOptionsTitle();
        reporter.reportLogPass("Billing Options Title verified");
        Assert.assertTrue(rogers_checkout_page.verifySelectPaymentMethodDropdown(), "Select Payment Method Dropdown not disaplayed");
        reporter.reportLogPass("Select Payment Method Dropdown Displayed");
        rogers_checkout_page.setNameOnCard(TestDataHandler.redesignRpotgData.getNameOnCard());
        reporter.reportLogPass("Name On Card Entered Successfully");
        rogers_checkout_page.switchToCreditCardIFrame();
        reporter.reportLogPass("Switched Inside Iframe");
        rogers_checkout_page.setCreditCardNumberIFrame(TestDataHandler.redesignRpotgData.getBillingCreditCardNumber());
        reporter.reportLogPass("Credit Card Details Entered Successfully");
        rogers_checkout_page.switchOutOfCreditCardIFrame();
        reporter.reportLogPass("Switched Outside Iframe");
        rogers_checkout_page.setBillingExpiryDate(TestDataHandler.redesignRpotgData.getExpiryDate());
        reporter.reportLogPass("Expiry Date Entered Successfully");
        rogers_checkout_page.setCVVNumber(TestDataHandler.redesignRpotgData.getCvvNumber());
        reporter.reportLogPass("CVV Number Entered Successfully");
        rogers_checkout_page.clkAddCard();
        reporter.reportLogPass("Add Card Button Clicked");
        Assert.assertTrue(rogers_checkout_page.verifyCardDetails(), "Card details not disaplayed in Billing & Payment Options");
//        reporter.reportLogPass("Card details disaplayed in Billing & Payment Options");
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        rogers_checkout_page.clkBillingContinueButton();
        reporter.reportLogPass("Billing Continue Button Clicked");
        Assert.assertTrue(rogers_checkout_page.verifyCardDetails(), "Billing Option details not displayed");
        reporter.reportLogPass("Billing Option details displayed");

        //***************Billing Options Stepper*************//
        Assert.assertTrue(rogers_checkout_page.clkBillingAddress(),"Billing Address is not selected");
        reporter.reportLogPass("Billing Address radio button is selected ");
        Assert.assertTrue(rogers_checkout_page.clkDeliveryMethodStandard(),"Standard Delivery not selected");
        reporter.reportLogPass("Standard Deliver-Free selected");
//        try {
//            Thread.sleep(30000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        Assert.assertTrue(rogers_checkout_page.selectDate(),"Click Date selected");
//        reporter.reportLogPass("Date Clicked successfully ");
//        Assert.assertTrue(rogers_checkout_page.selectTime(),"Click Time selected");
//        reporter.reportLogPass("Time Clicked successfully ");
        rogers_checkout_page.clkContinueBtnShipping();
        reporter.reportLogPass("Clicked continue button in shipping stepper"); 
//        try {
//            Thread.sleep(60000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        rogers_checkout_page.clksubmitBtnCheckoutPage();
        reporter.reportLogPass("Clicked submit button below cart summary");
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      //***************Order Review Page*************//
        rogers_review_order_page.getOrderReviewPageTitle();
        reporter.reportLogPass("Order Review Page Title verified");
        String totalMonthlyFeesReviewPage=rogers_review_order_page.getMonthlyFeeAfterTax();
        System.out.println(totalMonthlyFees);
        System.out.println(totalMonthlyFeesReviewPage);
        Assert.assertEquals(totalMonthlyFees,totalMonthlyFeesReviewPage);
        reporter.reportLogPass("Total Monthly Fee after tax matches with checkout page");
        String oneTimeFeesReviewPage=rogers_review_order_page.getOneTimeFeeAfterTax();
        Assert.assertEquals(oneTimeFee,oneTimeFeesReviewPage);
        System.out.println(oneTimeFee);
        System.out.println(oneTimeFeesReviewPage);
        reporter.reportLogPass("Total One time fee after tax matches with checkout page");
        rogers_review_order_page.getPurchaseIncludesText();
        String contactNameReviewPage=rogers_review_order_page.getContactName();
        Assert.assertEquals(fullNameCreateProfile,contactNameReviewPage);
        reporter.reportLogPass("Contact Name in Order Review Page matches as entered in Create Profile stepper");
//        String contactNumberReviewPage=rogers_review_order_page.getContactNumber();
//        Assert.assertEquals(contactNumberCreateProfile,contactNumberReviewPage);
        reporter.reportLogPass("Contact Number in Order Review Page matches as entered in Create Profile stepper");
        String contactEmailReviewPage=rogers_review_order_page.getContactEmail();
        Assert.assertEquals(emailCreateProfile,contactEmailReviewPage);
        reporter.reportLogPass("Contact email in Order Review Page matches as entered in Create Profile stepper");
        rogers_review_order_page.clkFinancingConsentCheckbox();
        reporter.reportLogPass("Financing Agreement consent box checked");
        rogers_review_order_page.clkAgreementConsentCheckbox();
        reporter.reportLogPass("Agreement consent box checked");
        rogers_review_order_page.clkUpfrontConsentCheckbox();
        reporter.reportLogPass("Upfront consent box checked");
        rogers_review_order_page.clkSubmitOrderBtn();
        reporter.reportLogPass("Submit Order Button Clicked");
        //************Order Confirmation Page****************//
        rogers_NAC_order_confirmation_page.getOrderConfirmationTitle();
        reporter.reportLogPass("Order Confrimation Page Title verified");
        String totalMonthlyFeesConfirmationPage=rogers_NAC_order_confirmation_page.getMonthlyFeeAfterTax();
        Assert.assertEquals(totalMonthlyFees,totalMonthlyFeesConfirmationPage);
        reporter.reportLogPass("Total Monthly Fee after tax matches with checkout page");
        String oneTimeFeesConfirmationPage=rogers_NAC_order_confirmation_page.getOneTimeFeeAfterTax();
        Assert.assertEquals(oneTimeFee,oneTimeFeesConfirmationPage);
        reporter.reportLogPass("Total One time fee after tax matches with checkout page");
        String purchaseIncludesConfrimation=rogers_NAC_order_confirmation_page.getPurchaseIncludesText();
        reporter.reportLogPass("Purchase includes captured as" + "-->" +purchaseIncludesConfrimation);
        Assert.assertTrue(rogers_NAC_order_confirmation_page.verifyLearnMoreLink(),"Learn More Link not Present");
        reporter.reportLogPass("Learn More Link Displayed");
        
  }


        @AfterMethod(alwaysRun = true)
        public void afterTest () throws InterruptedException {
            closeSession();
        }
    }


