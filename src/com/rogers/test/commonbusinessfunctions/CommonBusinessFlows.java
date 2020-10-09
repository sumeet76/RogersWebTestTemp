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
		baseTestClass.rogers_home_page.clkSignIn();    
		baseTestClass.rogers_login_page.switchToSignInIFrame();
		loginApplication(strUserName,strPassword); 
		baseTestClass.rogers_login_page.clkSkipIFrame();
		baseTestClass.rogers_login_page.switchOutOfSignInIFrame();
		 if (baseTestClass.rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
	        	baseTestClass.reporter.reportLogWithScreenshot("Select an account.");
	        	baseTestClass.rogers_account_overview_page.selectAccount(strAccount);
	        }
		 baseTestClass.reporter.reportLogWithScreenshot("Account overview page."); 
	}

	/**
	 * 
	 * @param strUsername
	 * @param strPassword
	 */
	public void loginApplication(String strUsername, String strPassword) {
		baseTestClass.rogers_login_page.setUsernameIFrame(strUsername);           	
		baseTestClass.rogers_login_page.setPasswordIFrame(strPassword);
		baseTestClass.reporter.reportLogWithScreenshot("Login Credential is entered: UserName :- "+strUsername+" Password:- "+strPassword);
		baseTestClass.rogers_login_page.clkSignInIFrame();
		

	}

	/**
	 * Resets the password back from the profile and setting page
	 * @param oldPassword
	 * @param newPassword
	 * @author Mirza.Kamran
	 */
	public void resetPasswordBack(String oldPassword, String newPassword) {
		baseTestClass.rogers_account_overview_page.clkLnkProfileNSettings();
		baseTestClass.rogers_profile_and_settings_page.clkLnkChangePassword();
		//verify the change password overlay is displayed or not
		baseTestClass.reporter.hardAssert(baseTestClass.rogers_profile_and_settings_page.isOverlayChangePasswordDisplayed(),
							"Change password process ready to set new password.",
							"Change password overlay didn't present.");
		baseTestClass.rogers_profile_and_settings_page.setCurrentPassword(oldPassword);
		baseTestClass.rogers_profile_and_settings_page.setNewPassword(newPassword);
		baseTestClass.rogers_profile_and_settings_page.setConfirmPassword(newPassword);
		baseTestClass.reporter.reportLogWithScreenshot("New password is entered.");
		baseTestClass.rogers_profile_and_settings_page.clkBtnChangePasswordSubmit();
		//verify success message --
		baseTestClass.reporter.hardAssert(baseTestClass.rogers_profile_and_settings_page.verifyChangePasswordSuccessMsg(), 
        						"Successfully changed password.", 
        						"Change password failed.");
        baseTestClass.rogers_profile_and_settings_page.clkBtnChangePasswordDone();
	}
	
	/**
	 * Add speed pass flow, limit reached scenario is also checked here.
	 * @return integer, the times speed pass was added.
	 * @author ning.xue
	 */
	public int addSpeedPass() {
		baseTestClass.rogers_wireless_dashboard_page.clkBtnSpeedPass();
		int intAddedSpeedPassRecord = 0;
		if (baseTestClass.rogers_speed_pass_page.verifySpeedPassPopupIsDisplayed()) {
			baseTestClass.reporter.hardAssert(baseTestClass.rogers_speed_pass_page.verifySpeedPassPopupIsDisplayed(),
					"Speed Pass popup is displayed", "Speed Pass popup is NOT displayed");
			baseTestClass.rogers_speed_pass_page.clkMaxSpeedDataInSpeedPassPopup();
			baseTestClass.reporter.reportLogWithScreenshot("Select Add on option");  
			baseTestClass.rogers_speed_pass_page.clkBtnContinueInSpeedPassPopup();
			baseTestClass.reporter.hardAssert(baseTestClass.rogers_speed_pass_page.verifyHeaderConfirmPurchaseIsDisplayed(),
					"Confirm Purchase is displayed", "Confirm Purchase is NOT displayed");
			baseTestClass.reporter.reportLogWithScreenshot("Add speed pass confirm page."); 
			baseTestClass.rogers_speed_pass_page.clkBtnPurchaseInSpeedPassPopup();
			baseTestClass.reporter.hardAssert(baseTestClass.rogers_speed_pass_page.verifyMsgSuccessAddedSpeedPassIsDisplayed(),
					"Message of success added speed pass is displayed",
					"Message of success added speed pass is NOT displayed");
			baseTestClass.reporter.reportLogWithScreenshot("Add speed pass purchase is clicked."); 
			intAddedSpeedPassRecord++;

		} else if (baseTestClass.rogers_speed_pass_page.verifyCannotAddSpeedPassHeaderIsDisplayed()) {
			baseTestClass.reporter.reportLogWithScreenshot("Add Speed Pass limit reached popup is displayed");
		}
		baseTestClass.rogers_speed_pass_page.clkBtnCloseInSpeedPassPopup();

		return intAddedSpeedPassRecord;

	}
	
	/**
	 * Add data flow, it will complete the flow from click "add data" button to click "purchase" button, 
	 * but will not verify after click purchase.
	 * @author ning.xue
	 */
	public void addDataFlow() {
		baseTestClass.rogers_wireless_dashboard_page.clkAddData();
		//baseTestClass.reporter.hardAssert(baseTestClass.rogers_add_data_page.verifyAddDataOverlayIsDisplayed(), 
		//					"Add the Data top-up  window should be displayed. (completd an MDT add on)", 
		//					"Add the Data top-up  window is NOT displayed.");        
		baseTestClass.reporter.reportLogWithScreenshot("Add Data Add on");  
		baseTestClass.rogers_add_data_page.selectFirstDataAddOnOption();
		baseTestClass.reporter.reportLogWithScreenshot("Select Add on option");  
		baseTestClass.rogers_add_data_page.clkContinue();
		baseTestClass.reporter.reportLogWithScreenshot("Select Purchase");  
		baseTestClass.rogers_add_data_page.clkPurchase();
		baseTestClass.reporter.reportLogWithScreenshot("Purchase status");  

	}

	public void scrollToMiddleOfWebPage() {
		baseTestClass.rogers_account_overview_page.scrollToMiddleOfPage();
	}
	

	public void scrollToTopOfWebPage() {
		baseTestClass.rogers_account_overview_page.scrollToTopOfPage();
	}
	

	public void scrollToBottomOfWebPage() {
		baseTestClass.rogers_account_overview_page.scrollToBottomOfPage();
	}
	
	/**
	 * Will close the feedback bar if available on mobile
	 * @author Mirza.Kamran
	 */
	public void clkCloseFeedbackIfAvailableMobile() {
		baseTestClass.rogers_profile_and_settings_page.clkCloseFeedbackIfAvailableMobile();
	}

	/**
	 * Log out and re sign in
	 * @param strUserName string username
	 * @param strPassword string password
	 * @author Mirza.Kamran
	 */
	public void logOutAndReSignIn(String strUserName, String strPassword)
	{
		baseTestClass.rogers_login_page.clickSignOut();
		baseTestClass.reporter.reportLogWithScreenshot("Sign Out clicked");  
		baseTestClass.reporter.reportLogWithScreenshot("Checking contentful URL..");  
        if(baseTestClass.rogers_home_page.isContentFulURLDisplayed())
		{
        	baseTestClass.reporter.reportLogWithScreenshot("Contentful page is displayed");  
        	baseTestClass.rogers_home_page.clkEasyLogin();
		}
        baseTestClass.reporter.reportLogWithScreenshot("Sign-in is being clicked");  
        baseTestClass.rogers_login_page.clkSignInAs();
        baseTestClass.reporter.reportLogWithScreenshot("Re sign In");  
        baseTestClass.rogers_login_page.switchToSignInIFrame();
        baseTestClass.reporter.reportLogWithScreenshot("Set password");             
        baseTestClass.rogers_login_page.setPasswordIFrame(strPassword);               
        baseTestClass.reporter.reportLogWithScreenshot("Login Credential is entered.");
        baseTestClass.rogers_login_page.clkSignInIFrame();	
        baseTestClass.reporter.reportLogWithScreenshot("Sign In clicked");  
        baseTestClass.rogers_login_page.switchOutOfSignInIFrame();		       
        baseTestClass.reporter.reportLogWithScreenshot("Account overview page.");   
	}
}
