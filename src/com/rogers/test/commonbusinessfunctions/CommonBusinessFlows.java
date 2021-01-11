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
		baseTestClass.reporter.hardAssert(BaseTestClass.getRogersAddDataPage().verifyAddDataOverlayIsDisplayed(),
							"Add the Data top-up  window should be displayed. (completd an MDT add on)", 
						"Add the Data top-up  window is NOT displayed.");        
		baseTestClass.reporter.reportLogWithScreenshot("Add Data Add on");  
		BaseTestClass.getRogersAddDataPage().selectDataAddOnOption(2);
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
}
