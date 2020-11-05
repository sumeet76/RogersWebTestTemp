package com.rogers.test.commonbusinessfunctions;

import org.testng.annotations.Listeners;

import com.rogers.test.base.BaseTestClass;


@Listeners ({com.rogers.test.listeners.TestListener.class ,
	com.rogers.test.listeners.AnnotationTransformer.class ,
	com.rogers.test.listeners.TestListener.class })


public class CommonBusinessFlows {
		
	BaseTestClass baseTestClass; 
	public CommonBusinessFlows(BaseTestClass baseTestClass) {
		this.baseTestClass = baseTestClass;
	}
	
	public void launchAndLoginApplication(String strUserName, String strPassword, String strAccount) {
		baseTestClass.getRogersHomePage().clkSignIn();    
		baseTestClass.getRogersLoginPage().switchToSignInIFrame();
		loginApplication(strUserName,strPassword); 
		baseTestClass.getRogersLoginPage().clkSkipIFrame();
		baseTestClass.getRogersLoginPage().switchOutOfSignInIFrame();
		 if (baseTestClass.getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
	        	baseTestClass.reporter.reportLogWithScreenshot("Select an account.");
	        	baseTestClass.getRogersAccountOverviewPage().selectAccount(strAccount);
	        }
		 baseTestClass.reporter.reportLogWithScreenshot("Account overview page."); 
	}

	/**
	 * 
	 * @param strUsername
	 * @param strPassword
	 */
	public void loginApplication(String strUsername, String strPassword) {
		baseTestClass.getRogersLoginPage().setUsernameIFrame(strUsername);           	
		baseTestClass.getRogersLoginPage().setPasswordIFrame(strPassword);
		baseTestClass.reporter.reportLogWithScreenshot("Login Credential is entered: UserName :- "+strUsername+" Password:- "+strPassword);
		baseTestClass.getRogersLoginPage().clkSignInIFrame();
		

	}

	/**
	 * Resets the password back from the profile and setting page
	 * @param oldPassword
	 * @param newPassword
	 * @author Mirza.Kamran
	 */
	public void resetPasswordBack(String oldPassword, String newPassword) {
		baseTestClass.getRogersAccountOverviewPage().clkLnkProfileNSettings();
		baseTestClass.getRogersProfileAndSettingsPage().clkLnkChangePassword();
		//verify the change password overlay is displayed or not
		baseTestClass.reporter.hardAssert(baseTestClass.getRogersProfileAndSettingsPage().isOverlayChangePasswordDisplayed(),
							"Change password process ready to set new password.",
							"Change password overlay didn't present.");
		baseTestClass.getRogersProfileAndSettingsPage().setCurrentPassword(oldPassword);
		baseTestClass.getRogersProfileAndSettingsPage().setNewPassword(newPassword);
		baseTestClass.getRogersProfileAndSettingsPage().setConfirmPassword(newPassword);
		baseTestClass.reporter.reportLogWithScreenshot("New password is entered.");
		baseTestClass.getRogersProfileAndSettingsPage().clkBtnChangePasswordSubmit();
		//verify success message --
		baseTestClass.reporter.hardAssert(baseTestClass.getRogersProfileAndSettingsPage().verifyChangePasswordSuccessMsg(),
        						"Successfully changed password.", 
        						"Change password failed.");
        baseTestClass.getRogersProfileAndSettingsPage().clkBtnChangePasswordDone();
	}
	
	/**
	 * Add speed pass flow, limit reached scenario is also checked here.
	 * @return integer, the times speed pass was added.
	 * @author ning.xue
	 */
	public int addSpeedPass() {
		baseTestClass.getRogersWirelessDashboardPage().clkBtnSpeedPass();
		int intAddedSpeedPassRecord = 0;
		if (baseTestClass.getRogersSpeedPassPage().verifySpeedPassPopupIsDisplayed()) {
			baseTestClass.reporter.hardAssert(baseTestClass.getRogersSpeedPassPage().verifySpeedPassPopupIsDisplayed(),
					"Speed Pass popup is displayed", "Speed Pass popup is NOT displayed");
			baseTestClass.getRogersSpeedPassPage().clkMaxSpeedDataInSpeedPassPopup();
			baseTestClass.reporter.reportLogWithScreenshot("Select Add on option");  
			baseTestClass.getRogersSpeedPassPage().clkBtnContinueInSpeedPassPopup();
			baseTestClass.reporter.hardAssert(baseTestClass.getRogersSpeedPassPage().verifyHeaderConfirmPurchaseIsDisplayed(),
					"Confirm Purchase is displayed", "Confirm Purchase is NOT displayed");
			baseTestClass.reporter.reportLogWithScreenshot("Add speed pass confirm page."); 
			baseTestClass.getRogersSpeedPassPage().clkBtnPurchaseInSpeedPassPopup();
			baseTestClass.reporter.hardAssert(baseTestClass.getRogersSpeedPassPage().verifyMsgSuccessAddedSpeedPassIsDisplayed(),
					"Message of success added speed pass is displayed",
					"Message of success added speed pass is NOT displayed");
			baseTestClass.reporter.reportLogWithScreenshot("Add speed pass purchase is clicked."); 
			intAddedSpeedPassRecord++;

		} else if (baseTestClass.getRogersSpeedPassPage().verifyCannotAddSpeedPassHeaderIsDisplayed()) {
			baseTestClass.reporter.reportLogWithScreenshot("Add Speed Pass limit reached popup is displayed");
		}
		baseTestClass.getRogersSpeedPassPage().clkBtnCloseInSpeedPassPopup();

		return intAddedSpeedPassRecord;

	}
	
	/**
	 * Add data flow, it will complete the flow from click "add data" button to click "purchase" button, 
	 * but will not verify after click purchase.
	 * @author ning.xue
	 */
	public void addDataFlow() {
		baseTestClass.getRogersWirelessDashboardPage().clkAddData();
		baseTestClass.reporter.hardAssert(baseTestClass.getRogersAddDataPage().verifyAddDataOverlayIsDisplayed(),
							"Add the Data top-up  window should be displayed. (completd an MDT add on)", 
						"Add the Data top-up  window is NOT displayed.");        
		baseTestClass.reporter.reportLogWithScreenshot("Add Data Add on");  
		baseTestClass.getRogersAddDataPage().selectDataAddOnOption(1);
		baseTestClass.reporter.reportLogWithScreenshot("Select Add on option");  
		baseTestClass.getRogersAddDataPage().clkContinue();
		baseTestClass.reporter.reportLogWithScreenshot("Select Purchase");  
		baseTestClass.getRogersAddDataPage().clkPurchase();
		baseTestClass.reporter.reportLogWithScreenshot("Purchase status");  

	}

	public void scrollToMiddleOfWebPage() {
		baseTestClass.getRogersAccountOverviewPage().scrollToMiddleOfPage();
	}
	

	public void scrollToTopOfWebPage() {
		baseTestClass.getRogersAccountOverviewPage().scrollToTopOfPage();
	}
	

	public void scrollToBottomOfWebPage() {
		baseTestClass.getRogersAccountOverviewPage().scrollToBottomOfPage();
	}
	
	/**
	 * Will close the feedback bar if available on mobile
	 * @author Mirza.Kamran
	 */
	public void clkCloseFeedbackIfAvailableMobile() {
		baseTestClass.getRogersProfileAndSettingsPage().clkCloseFeedbackIfAvailableMobile();
	}

	/**
	 * Log out and re sign in
	 * @param strUserName string username
	 * @param strPassword string password
	 * @author Mirza.Kamran
	 */
	public void logOutAndReSignIn(String strUserName, String strPassword)
	{
		baseTestClass.getRogersLoginPage().clickSignOut();
		baseTestClass.reporter.reportLogWithScreenshot("Sign Out clicked");  
		baseTestClass.reporter.reportLogWithScreenshot("Checking contentful URL..");  
        if(baseTestClass.getRogersHomePage().isContentFulURLDisplayed())
		{
        	baseTestClass.reporter.reportLogWithScreenshot("Contentful page is displayed");  
        	baseTestClass.getRogersHomePage().clkEasyLogin();
		}
        baseTestClass.reporter.reportLogWithScreenshot("Sign-in is being clicked");  
        baseTestClass.getRogersLoginPage().clkSignInAs();
        baseTestClass.reporter.reportLogWithScreenshot("Re sign In");  
        baseTestClass.getRogersLoginPage().switchToSignInIFrame();
        baseTestClass.reporter.reportLogWithScreenshot("Set password");             
        baseTestClass.getRogersLoginPage().setPasswordIFrame(strPassword);               
        baseTestClass.reporter.reportLogWithScreenshot("Login Credential is entered.");
        baseTestClass.getRogersLoginPage().clkSignInIFrame();	
        baseTestClass.reporter.reportLogWithScreenshot("Sign In clicked");  
        baseTestClass.getRogersLoginPage().switchOutOfSignInIFrame();		       
        baseTestClass.reporter.reportLogWithScreenshot("Account overview page.");   
	}
}
