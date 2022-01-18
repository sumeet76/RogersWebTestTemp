package com.rogers.test.tests.buyflows;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * TC01 - Regression - [RNAC TERM] - Perform Rogers Net New Activation - TERM with Standard Shipping(Finance plan with Non POTG)_E2E
 */

public class RogersBFA_TC01_Consumer_NAC_TermNpotgSS_HighRisk_DBValidation_Test extends BaseTestClass {

  
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
	}

    @Test(groups = {"RegressionBFA","NACBFA","RegressionOnlineBFA"})
    public void rogersNACTermNpotgSSTest() throws InterruptedException {
    	 //**************************Device catalog page****************************************
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        String deviceName=TestDataHandler.tc01NACTermNpotgSS.getDeviceName();
        getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
        reporter.softAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen", "Modal element is not present on the screen");
        reporter.softAssert(getRogersDeviceCataloguePage().verifyGetStartedButtonOnModal(), "Get started button on the modal is present" ,"Get started button on the modal is not present");
        reporter.reportLogWithScreenshot("Modal window Popup");
        reporter.hardAssert(getRogersDeviceCataloguePage().clickGetStartedButtonOnModal(),"Clicked Get Started Button","Get Started button not able to click");
        // ***************************Device config page************************************
        reporter.hardAssert(getRogersDeviceConfigPage().verifyContinueButton(), "BreadCrumb on Phone config page is working fine", "BreadCrumb is not working fine");
        reporter.reportLogWithScreenshot("Device config page");
        String deviceCost = getRogersDeviceConfigPage().getDeviceFullPrice(this.getClass().getSimpleName());
        getRogersDeviceConfigPage().clickContinueButton();
        //############################Plan config page###############################
        //reporter.softAssert(getRogersPlanConfigPage().verifyBreadCrumb(deviceName), "BreadCrumb on Plan config page is working fine","BreadCrumb is not working fine");
        getRogersPlanConfigPage().clkDownPaymentChkBox();
        getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
        getRogersPlanConfigPage().clickShowMoreDetails();
        getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc01NACTermNpotgSS.getDataOptionIndex()),this.getClass().getSimpleName());
        reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
        getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page data protection selected");
        //getRogersPlanConfigPage().clickOptionInDataProtection(deviceName);
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        getRogersPlanConfigPage().clkContinueDeviceProtection();
        reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
        /*String monthlyFeesAmount = getRogersPlanConfigPage().getMonthlyFeesAmount();
        String oneTimeFeesAmount = getRogersPlanConfigPage().getOneTimeFeesAmount();
        reporter.reportLogPassWithScreenshot("Cart summary: Monthly & OneTimeFees"+monthlyFeesAmount+"&"+oneTimeFeesAmount);*/
        List<String> planDetails = getRogersPlanConfigPage().getPlanData();
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
        String contactNumberCreateProfile=TestDataHandler.tc01NACTermNpotgSS.getContactNumber();
        getRogersCheckoutPage().setContactNumberCreateProfile(contactNumberCreateProfile);
        reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
        getRogersCheckoutPage().setBillingAddressCreateProfile(TestDataHandler.tc01NACTermNpotgSS.getBillingAddress());
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
		getRogersCheckoutPage().selectYearDropdownOption(TestDataHandler.tc01NACTermNpotgSS.getDateOfBirthYear());
		getRogersCheckoutPage().selectMonthDropdownOption(TestDataHandler.tc01NACTermNpotgSS.getDateOfBirthMonth());
		getRogersCheckoutPage().selectDayDropdownOption(TestDataHandler.tc01NACTermNpotgSS.getDateOfBirthDay());
        getRogersCheckoutPage().switchToCreditCardIFrame();
        getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.tc01NACTermNpotgSS.getCreditCardDetails());
        reporter.reportLogPassWithScreenshot("DOB & Credit Card Details Entered Successfully");
        getRogersCheckoutPage().switchOutOfCreditCardIFrame();
        getRogersCheckoutPage().setExpiryDate(TestDataHandler.tc01NACTermNpotgSS.getExpiryDate());
        getRogersCheckoutPage().selectDropdownOption(TestDataHandler.tc01NACTermNpotgSS.getDropdownOption());
        getRogersCheckoutPage().setPassportNumber(TestDataHandler.tc01NACTermNpotgSS.getPassportNumber());
        reporter.reportLogPassWithScreenshot("PassportNumber Entered Successfully");
        getRogersCheckoutPage().clkCreditAuthorizationChkBox();
        getRogersCheckoutPage().clkCreditEvalContinue();
        reporter.softAssert(getRogersCheckoutPage().isCreditEvalPopupPresent(),"Credit Evaluation Popup Displayed", "Credit Evaluation popup not disaplayed");
        //reporter.softAssert(getRogersCheckoutPage().isCreditEvalTextOnModalPresent(), "Credit Evaluation Text Displayed","Credit Evaluation Text not disaplayed on Modal");
        reporter.reportLogWithScreenshot("Credit Evaluation processing popup");
        /*reporter.hardAssert(getRogersCheckoutPage().verifyClaDownPaymentModalPresent(),
                "CLA and Security deposit modal is displayed", "Cla and Security Deposit Modal is not dislayed");
        reporter.softAssert(getRogersCheckoutPage().verifyDownPaymentTextPresent(),
                "Down payment info dislayed in modal", "Down payment info not dislayed in modal");
        reporter.reportLogWithScreenshot("CLA/Down payment Modal");*/
        String expectedDownPayment = getRogersCheckoutPage().setDownPayment(TestDataHandler.tc01NACTermNpotgSS.getRiskClass(),deviceCost);
        reporter.hardAssert(getRogersCheckoutPage().verifyDownPaymentAmt(expectedDownPayment),
               "Downpayment amount is displayed correctly", "Downpayment amoount is not displayed correctly");
        //reporter.hardAssert(getRogersCheckoutPage().verifyClaTextOnModal(), "CLA text on modal displayed properly", "CLA text on modal not displayed");
        getRogersCheckoutPage().clkAcceptButton();
        reporter.hardAssert(getRogersCheckoutPage().isIdentificationLabel(),"Credit Evaluation Successful", "Credit Evaluation Identification Label not disaplayed");
       // ***************Choose a Number Stepper*************//      
        reporter.softAssert(getRogersCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed","Choose a Number Title not disaplayed");
        reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(),"Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
        getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc01NACTermNpotgSS.getCityName());
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
		getRogersCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.tc01NACTermNpotgSS.getPaymentMethod());
        //reporter.hardAssert(getRogersCheckoutPage().verifyOneTimeFeesAfterSecDeposit(TestDataHandler.tc01NACTermNpotgSS.getDepositAmount()),
                //"Security deposit amount displayed correctly in cart summary", "Security deposit amount not displayed correctly in cart summary");
        Long ctn = getRogersCheckoutPage().getSelectedCtn();
        getRogersCheckoutPage().clkBillingContinueButton();
        //***************Shipping Stepper*************//
        //reporter.softAssert(getRogersCheckoutPage().clkBillingAddress(),"Billing Address radio button is selected ","Billing Address is not selected");
        getRogersCheckoutPage().clkDeliveryMethodStandard();
        reporter.reportLogWithScreenshot("Shipping stepper");
        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPassWithScreenshot("Continue button clicked from Billing Options Stepper");
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
      //***************Order Review Page*************//
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(),"Order Review Page Title Present","Order Review Page Title is not Present");
        reporter.reportLogPass("Order Review Page");
        /*String puchaseIncludeReviewPage=getRogersReviewOrderPage().getPurchaseIncludesText();
        reporter.reportLogPassWithScreenshot("Order Review Page"+"1.Monthly Fees"+totalMonthlyFeesReviewPage+"2. OnetimeFees:"+oneTimeFeesReviewPage+"3.Purchase Include :"+puchaseIncludeReviewPage);
        String contactNameReviewPage=getRogersReviewOrderPage().getContactName();
        reporter.hardAssert(fullNameCreateProfile.equals(contactNameReviewPage),"Contact Name in Order Review Page matches as entered in Create Profile stepper","Contact Name in Order Review Page not matches as entered in Create Profile stepper");
        String contactEmailReviewPage=getRogersReviewOrderPage().getContactEmail();
        reporter.hardAssert(emailCreateProfile.equals(contactEmailReviewPage),"Contact email in Order Review Page matches as entered in Create Profile stepper","Contact email in Order Review Page not matches as entered in Create Profile stepper");*/
        reporter.reportLogPassWithScreenshot("Order Review Page : Contact Details");
        getRogersReviewOrderPage().clkFinancingConsentCheckbox();
        getRogersReviewOrderPage().clkAgreementConsentCheckbox();
        getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        getRogersReviewOrderPage().clkSubmitOrderBtn();
        //---------------------One Time Payment page------------------------------//
        reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentPage(),
                "Pay with Credit card details are present on OneTime payment page", "Pay with Credit card details are not present on OneTime payment page");
        getRogersOneTimePaymentPage().setNameonCard();
        getRogersOneTimePaymentPage().switchToCreditCardIFrame();
        getRogersOneTimePaymentPage().setCreditCardNumberIFrame(TestDataHandler.tc01NACTermNpotgSS.getCreditCardDetailsOTP());
        getRogersOneTimePaymentPage().switchOutOfCreditCardIFrame();
        getRogersOneTimePaymentPage().setExpiryDate(TestDataHandler.tc01NACTermNpotgSS.getExpiryDateOTP());
        getRogersOneTimePaymentPage().setCVV();
        reporter.reportLogPassWithScreenshot("Credit Card Details Entered Successfully");
        
        getRogersOneTimePaymentPage().clkSubmitOrderBtn();
        //************Order Confirmation Page****************//
        reporter.hardAssert(getRogersNACOrderConfirmationPage().isOrderConfirmationTitlePresent(),"Order Confrimation Page Title Present","Order Confrimation Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Confirmation Page");
        /*String totalMonthlyFeesConfirmationPage=getRogersNACOrderConfirmationPage().getMonthlyFeeAfterTax();
        reporter.hardAssert(totalMonthlyFees.equals(totalMonthlyFeesConfirmationPage),"Total Monthly Fee after tax matches with checkout page","Total Monthly Fee after tax not matches with checkout page");
        String oneTimeFeesConfirmationPage=getRogersNACOrderConfirmationPage().getOneTimeFeeAfterTax();
        reporter.hardAssert(oneTimeFeesConfirmationPage.contains(TestDataHandler.tc01NACTermNpotgSS.getDepositAmount()),
                "Security deposit amount is displayed correctly in one time fees section","Security deposit amount is not displayed correctly in one time fees section");
        String purchaseIncludesConfrimation=getRogersNACOrderConfirmationPage().getPurchaseIncludesText();
        reporter.reportLogPassWithScreenshot("Purchase includes captured as" + "-->" +purchaseIncludesConfrimation);*/

        Map<Object, Object> dblists = getDbConnection().connectionMethod(System.getProperty("DbEnvUrl"))
                .executeDBQuery("select ba.ACCOUNT_TYPE,ba.ACCOUNT_SUB_TYPE,es.BAN,es.SUBSCRIBER_NO,es.INIT_PP,sc.SOC_DESCRIPTION," +
                        "es.TOTAL_NONTERMED_MSF,es.PROVINCE,es.FN_CREDIT_TERM,es.FN_CREDIT_AMT,es.MONTHLY_INSTALLMENT_AMT,es.TOTAL_FINANCING_OBLIG," +
                        "p.PYM_METHOD,es.MANDATORY_CHG,p.ORIGINAL_AMT,ch.CLA,ch.CAS_TOTAL_APPROVE_CTN from equipment_subsidy es inner join billing_account ba" +
                        " on es.ban=ba.ban inner join payment p on es.ban=p.ban inner join credit_history ch on es.ban=ch.ban inner join soc sc" +
                        " on es.init_pp=sc.soc where es.subscriber_no='"+ctn+"'", false);

        reporter.softAssert(dblists.get("ACCOUNT_TYPE").equals("I"), "ACCOUNT_TYPE is verified as I", "ACCOUNT_SUB_TYPE is not verified as I");
        reporter.softAssert(dblists.get("ACCOUNT_SUB_TYPE").equals("R"),"ACCOUNT_SUB_TYPE is verified as R","Account type is not updated as R");
        reporter.softAssert(dblists.get("SOC_DESCRIPTION").toString().contains(planDetails.get(0)),"Plan data is updated properly as "+planDetails.get(0)+" GB","Plan data is not updated properly");
        reporter.softAssert(dblists.get("TOTAL_NONTERMED_MSF").toString().equals(planDetails.get(1)),"Plan cost is updated properly as "+planDetails.get(1)+" GB","Plan data is not updated properly");
        //reporter.softAssert(dblists.get("FN_CREDIT_TERM").toString().equals("24"),"Financing credit term is verified as 24 months","Financing credit term is verified as 24 months");
        reporter.softAssert(dblists.get("MANDATORY_CHG").toString().equals(expectedDownPayment.substring(0,expectedDownPayment.indexOf("."))),
                "Downpayment amt is verified successfully as "+expectedDownPayment+"","Downpayment amt is not verified as "+expectedDownPayment+"");
        reporter.softAssert(dblists.get("PYM_METHOD").equals("CC"), "Payment type is verified successflly as CC", "Payment type is not verified as CC");
        reporter.softAssert(dblists.get("CAS_TOTAL_APPROVE_CTN").equals("1"),"Approved CTN is verified as 1","Approved CTN is not verified as 1");


        /*
        "select ba.ACCOUNT_TYPE,ba.ACCOUNT_SUB_TYPE,es.BAN,es.SUBSCRIBER_NO,es.INIT_PP,sc.SOC_DESCRIPTION,es.TOTAL_NONTERMED_MSF,es.PROVINCE,es.FN_CREDIT_TERM,es.FN_CREDIT_AMT,es.MONTHLY_INSTALLMENT_AMT,es.TOTAL_FINANCING_OBLIG,p.PYM_METHOD,es.MANDATORY_CHG,p.ORIGINAL_AMT,ch.CLA,ch.CAS_TOTAL_APPROVE_CTN from equipment_subsidy es inner join billing_account ba on es.ban=ba.ban inner join payment p on es.ban=p.ban inner join credit_history ch on es.ban=ch.ban inner join soc sc on es.init_pp=sc.soc where es.subscriber_no='"+ctn+"'"

        billing_account ba
        equipment_subsidy es
        payment p
        credit_history ch
        soc sc
        */
    }


        @AfterMethod(alwaysRun = true)
        public void afterTest () throws InterruptedException {
            closeSession();
        }
    }


