package com.rogers.test.commonbusinessfunctions;

import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.annotations.Listeners;

import com.rogers.test.base.BaseTestClass;

import java.util.HashMap;


@Listeners ({com.rogers.test.listeners.TestListener.class ,
	com.rogers.test.listeners.AnnotationTransformer.class ,
	com.rogers.test.listeners.TestListener.class })


public class CommonBusinessFlows {

	BaseTestClass baseTestClass; 
	public CommonBusinessFlows(BaseTestClass baseTestClass) {
		this.baseTestClass = baseTestClass;
	}
	
	public void launchAndLoginApplication(String strUserName, String strPassword, String strAccount) {
		BaseTestClass.getRogersHomePage().clkSignIn();    
		BaseTestClass.getRogersLoginPage().switchToSignInIFrame();
		loginApplication(strUserName,strPassword); 
		BaseTestClass.getRogersLoginPage().clkSkipIFrame();
		BaseTestClass.getRogersLoginPage().switchOutOfSignInIFrame();
		 if (BaseTestClass.getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
	        	baseTestClass.reporter.reportLogWithScreenshot("Select an account.");
	        	BaseTestClass.getRogersAccountOverviewPage().selectAccount(strAccount);
	        }
		 baseTestClass.reporter.reportLogWithScreenshot("Account overview page."); 
	}

	/**
	 * 
	 * @param strUsername
	 * @param strPassword
	 */
	public void loginApplication(String strUsername, String strPassword) {
		BaseTestClass.getRogersLoginPage().setUsernameIFrame(strUsername);           	
		BaseTestClass.getRogersLoginPage().setPasswordIFrame(strPassword);
		baseTestClass.reporter.reportLogWithScreenshot("Login Credential is entered: UserName :- "+strUsername+" Password:- "+strPassword);
		BaseTestClass.getRogersLoginPage().clkSignInIFrame();
		

	}

	/**
	 * Resets the password back from the profile and setting page
	 * @param oldPassword
	 * @param newPassword
	 * @author Mirza.Kamran
	 */
	public void resetPasswordBack(String oldPassword, String newPassword) {
		BaseTestClass.getRogersAccountOverviewPage().clkLnkProfileNSettings();
		BaseTestClass.getRogersProfileAndSettingsPage().clkLnkChangePassword();
		//verify the change password overlay is displayed or not
		baseTestClass.reporter.hardAssert(BaseTestClass.getRogersProfileAndSettingsPage().isOverlayChangePasswordDisplayed(),
							"Change password process ready to set new password.",
							"Change password overlay didn't present.");
		BaseTestClass.getRogersProfileAndSettingsPage().setCurrentPassword(oldPassword);
		BaseTestClass.getRogersProfileAndSettingsPage().setNewPassword(newPassword);
		BaseTestClass.getRogersProfileAndSettingsPage().setConfirmPassword(newPassword);
		baseTestClass.reporter.reportLogWithScreenshot("New password is entered.");
		BaseTestClass.getRogersProfileAndSettingsPage().clkBtnChangePasswordSubmit();
		//verify success message --
		baseTestClass.reporter.hardAssert(BaseTestClass.getRogersProfileAndSettingsPage().verifyChangePasswordSuccessMsg(),
        						"Successfully changed password.", 
        						"Change password failed.");
        BaseTestClass.getRogersProfileAndSettingsPage().clkBtnChangePasswordDone();
	}
	
	/**
	 * Add speed pass flow, limit reached scenario is also checked here.
	 * @return integer, the times speed pass was added.
	 * @author ning.xue
	 */
	public int addSpeedPass() {
		BaseTestClass.getRogersWirelessDashboardPage().clkBtnSpeedPass();
		int intAddedSpeedPassRecord = 0;
		if (BaseTestClass.getRogersSpeedPassPage().verifySpeedPassPopupIsDisplayed()) {
			baseTestClass.reporter.hardAssert(BaseTestClass.getRogersSpeedPassPage().verifySpeedPassPopupIsDisplayed(),
					"Speed Pass popup is displayed", "Speed Pass popup is NOT displayed");
			baseTestClass.reporter.hardAssert(BaseTestClass.getRogersSpeedPassPage().verifyIfTopUpPriceIsCorrect(),
					"New Top up price Price plan is reflected correctly",
					"Add speed pass overlay failed.");
			BaseTestClass.getRogersSpeedPassPage().clkMaxSpeedDataInSpeedPassPopup();
			baseTestClass.reporter.reportLogWithScreenshot("Select Add on option");  
			BaseTestClass.getRogersSpeedPassPage().clkBtnContinueInSpeedPassPopup();
			baseTestClass.reporter.hardAssert(BaseTestClass.getRogersSpeedPassPage().verifyHeaderConfirmPurchaseIsDisplayed(),
					"Confirm Purchase is displayed", "Confirm Purchase is NOT displayed");
			baseTestClass.reporter.reportLogWithScreenshot("Add speed pass confirm page."); 
			BaseTestClass.getRogersSpeedPassPage().clkBtnPurchaseInSpeedPassPopup();
			baseTestClass.reporter.hardAssert(BaseTestClass.getRogersSpeedPassPage().verifyMsgSuccessAddedSpeedPassIsDisplayed(),
					"Message of success added speed pass is displayed",
					"Message of success added speed pass is NOT displayed");
			baseTestClass.reporter.reportLogWithScreenshot("Add speed pass purchase is clicked."); 
			intAddedSpeedPassRecord++;

		} else if (BaseTestClass.getRogersSpeedPassPage().verifyCannotAddSpeedPassHeaderIsDisplayed()) {
			baseTestClass.reporter.reportLogWithScreenshot("Add Speed Pass limit reached popup is displayed");
		}
		BaseTestClass.getRogersSpeedPassPage().clkBtnCloseInSpeedPassPopup();

		return intAddedSpeedPassRecord;

	}
	
	/**
	 * Add data flow, it will complete the flow from click "add data" button to click "purchase" button, 
	 * but will not verify after click purchase.
	 * @author ning.xue
	 */
	public void addDataFlow() {
		BaseTestClass.getRogersWirelessDashboardPage().clkAddData();
		baseTestClass.reporter.hardAssert(BaseTestClass.getRogersAddDataPage().verifyAddDataOverlayIsDisplayedNew(),
							"Add the Data top-up  window should be displayed. (completd an MDT add on)", 
						"Add the Data top-up  window is NOT displayed.");        
		baseTestClass.reporter.reportLogWithScreenshot("Add Data Add on");  
		BaseTestClass.getRogersAddDataPage().selectDataAddOnOptionNew(1);
		baseTestClass.reporter.reportLogWithScreenshot("Select Add on option");  
		BaseTestClass.getRogersAddDataPage().clkContinue();
		baseTestClass.reporter.reportLogWithScreenshot("Select Purchase");  
		BaseTestClass.getRogersAddDataPage().clkPurchase();
		baseTestClass.reporter.reportLogWithScreenshot("Purchase status");  

	}

	/**
	 * Add data flow, it will complete the flow from click "add data" button to click "purchase" button,
	 * but will not verify after click purchase.
	 * @author ning.xue
	 */
	public void addDataFlow(HashMap<String, String> addDataPricing) {
		BaseTestClass.getRogersWirelessDashboardPage().clkAddData();
		baseTestClass.reporter.hardAssert(BaseTestClass.getRogersAddDataPage().verifyAddDataOverlayIsDisplayedNew(),
				"Add the Data top-up  window should be displayed. (completd an MDT add on)",
				"Add the Data top-up  window is NOT displayed.");
		baseTestClass.reporter.reportLogWithScreenshot("Add Data Add on");
		BaseTestClass.getRogersAddDataPage().selectDataAddOnOptionNew(1);
		baseTestClass.reporter.reportLogWithScreenshot("Select Add on option");
		BaseTestClass.getRogersAddDataPage().clkContinue();
		baseTestClass.reporter.reportLogWithScreenshot("Select Purchase");
		BaseTestClass.getRogersAddDataPage().clkPurchase();
		baseTestClass.reporter.reportLogWithScreenshot("Purchase status");

	}

	public void scrollToMiddleOfWebPage() {
		BaseTestClass.getRogersAccountOverviewPage().scrollToMiddleOfPage();
	}
	

	public void scrollToTopOfWebPage() {
		BaseTestClass.getRogersAccountOverviewPage().scrollToTopOfPage();
	}
	

	public void scrollToBottomOfWebPage() {
		BaseTestClass.getRogersAccountOverviewPage().scrollToBottomOfPage();
	}
	
	/**
	 * Will close the feedback bar if available on mobile
	 * @author Mirza.Kamran
	 */
	public void clkCloseFeedbackIfAvailableMobile() {
		BaseTestClass.getRogersProfileAndSettingsPage().clkCloseFeedbackIfAvailableMobile();
	}

	/**
	 * Log out and re sign in
	 * @param strUserName string username
	 * @param strPassword string password
	 * @author Mirza.Kamran
	 */
	public void logOutAndReSignIn(String strUserName, String strPassword)
	{
		BaseTestClass.getRogersLoginPage().clickSignOut();
		baseTestClass.reporter.reportLogWithScreenshot("Sign Out clicked");  
		baseTestClass.reporter.reportLogWithScreenshot("Checking contentful URL..");  
        if(BaseTestClass.getRogersHomePage().isContentFulURLDisplayed())
		{
        	baseTestClass.reporter.reportLogWithScreenshot("Contentful page is displayed");  
        	BaseTestClass.getRogersHomePage().clkEasyLogin();
		}
        baseTestClass.reporter.reportLogWithScreenshot("Sign-in is being clicked");  
        BaseTestClass.getRogersLoginPage().clkSignInAs();
        baseTestClass.reporter.reportLogWithScreenshot("Re sign In");  
        BaseTestClass.getRogersLoginPage().switchToSignInIFrame();
        baseTestClass.reporter.reportLogWithScreenshot("Set password");             
        BaseTestClass.getRogersLoginPage().setPasswordIFrame(strPassword);               
        baseTestClass.reporter.reportLogWithScreenshot("Login Credential is entered.");
        BaseTestClass.getRogersLoginPage().clkSignInIFrame();	
        baseTestClass.reporter.reportLogWithScreenshot("Sign In clicked");  
        BaseTestClass.getRogersLoginPage().switchOutOfSignInIFrame();		       
        baseTestClass.reporter.reportLogWithScreenshot("Account overview page.");   
	}

	/**
	 * Switches Payment method to one of Credit, Bank or Manual Payment Types
	 * @param paymentMethodType takes a PaymenType that the test case will switch to
	 * @author Rohit.Kumar
	 */
	public void switchPaymentMethodTo(BaseTestClass.PaymentMethodType paymentMethodType)
	{
		String currentMethod =  baseTestClass.getRogersAccountOverviewPage().getCurrentAccountPaymentMethod();
		if (paymentMethodType.toString().trim().contains(currentMethod.toUpperCase().trim()))
		{			
			return;
		}
		switch (paymentMethodType) {
			case CREDIT:

				baseTestClass.getRogersAccountOverviewPage().clkViewBill();

				if(currentMethod.equals("Manual")){
					baseTestClass.getRogersBillingPage().clkSetUpAutomaticPaymentsLink();
				} else {
					baseTestClass.getRogersBillingPage().clkChangePaymentMethodLink();
				}

				baseTestClass.reporter.reportLogWithScreenshot("Rogers Change Payment Method Page");
				baseTestClass.getRogersSecurePaymentPage().setCardNumberNew(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
			    String strDDMM = TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryMonth() + 
			        			TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear().substring(2);
			    baseTestClass.getRogersSecurePaymentPage().setCardExpiry(strDDMM);	       
			    baseTestClass.getRogersSecurePaymentPage().setSecurityCode(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
			    baseTestClass.reporter.reportLogWithScreenshot("CC details entered");
			    baseTestClass.getRogersChangePaymentMethodPage().clkContinueSettingCC();
			    baseTestClass.reporter.hardAssert(baseTestClass.getRogersChangePaymentMethodPage().isReviewCCDetailsPageDisplayed(),
						"CC Details encrypted msg displayed",
						"CC Details encrypted msg NOT displayed");
			    baseTestClass.reporter.reportLogWithScreenshot("CC secured details");
				
			    baseTestClass.getRogersChangePaymentMethodPage().clkContinueOnReviewPg();
			    baseTestClass.reporter.hardAssert(baseTestClass.getRogersChangePaymentMethodPage().verifySuccessMessageIsDisplayed(),
						"Set up auto payment is successful",
						"Set up auto payment is not successful");
			    baseTestClass.reporter.reportLogWithScreenshot("Payment complete page.");
			    baseTestClass.getRogersChangePaymentMethodPage().clkOnDone();
				
				/*
				baseTestClass.reporter.hardAssert(baseTestClass.getRogersChangePaymentMethodPage().setCreditInformation(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber(),
						TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryMonth(), TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear(),
						TestDataHandler.paymentInfo.getCreditCardDetails().getCVV()),
						"Set up Credit Card payment is successful",
						"Set up Credit Card payment is not successful");
				baseTestClass.reporter.reportLogWithScreenshot("Set up Credit Card payment is successful");
				baseTestClass.getRogersChangePaymentMethodPage().clkButtonDoneChangePayment();
				*/
				break;

			case BANK:

				baseTestClass.getRogersAccountOverviewPage().clkViewBill();

				if(currentMethod.equals("Manual")){
					baseTestClass.getRogersBillingPage().clkSetUpAutomaticPaymentsLink();
				} else {
					baseTestClass.getRogersBillingPage().clkChangePaymentMethodLink();
				}
				baseTestClass.getRogersChangePaymentMethodPage().clkUseBankAccountForAutomaticPayments();
				baseTestClass.getRogersChangePaymentMethodPage().setTransitCode(TestDataHandler.paymentInfo.getBankDetails().getTransitCode());
				baseTestClass.getRogersChangePaymentMethodPage().setBankCode(TestDataHandler.paymentInfo.getBankDetails().getBankCode());
				baseTestClass.getRogersChangePaymentMethodPage().setAccountNumber(TestDataHandler.paymentInfo.getBankDetails().getAccountNumber());
				baseTestClass.getRogersChangePaymentMethodPage().clkContinue();
				baseTestClass.getRogersChangePaymentMethodPage().clkTermsAndCond();
				baseTestClass.getRogersChangePaymentMethodPage().clkSubmit();
				baseTestClass.reporter.hardAssert(baseTestClass.getRogersChangePaymentMethodPage().verifySuccessMessageIsDisplayed(),
						"Set up Bank payment is successful",
						"Set up Bank payment is not successful");

				baseTestClass.reporter.reportLogWithScreenshot("Set up Bank payment is successful");

				baseTestClass.getRogersChangePaymentMethodPage().clkButtonDoneChangePayment();
				break;

			case MANUAL:

				if(currentMethod.equals("Manual")){
					baseTestClass.reporter.hardAssert(false,
							"",
							"Current Payment Method Type Is Manual - You Cannot Switch Payment Method Type from Manual to Manual");
				} else {

					baseTestClass.getRogersAccountOverviewPage().clkViewBill();
					baseTestClass.getRogersBillingPage().clkChangePaymentMethodLink();
					baseTestClass.getRogersChangePaymentMethodPage().clkSwitchToManualPayments();
					baseTestClass.getRogersChangePaymentMethodPage().clkContinue();
					baseTestClass.getRogersChangePaymentMethodPage().clkYesCancelAutomaticPayment();
					baseTestClass.reporter.hardAssert(baseTestClass.getRogersChangePaymentMethodPage().verifySuccessMessageIsDisplayed(),
							"Set up Manual payment is successful",
							"Set up Manual payment is not successful");
					baseTestClass.getRogersChangePaymentMethodPage().clkButtonDoneChangePayment();
				}
				break;
		}


	}
}
