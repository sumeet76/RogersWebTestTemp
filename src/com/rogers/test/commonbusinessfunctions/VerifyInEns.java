
package com.rogers.test.commonbusinessfunctions;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;

public class VerifyInEns{

	BaseTestClass baseTestClass; 
	public VerifyInEns(BaseTestClass baseTestClass) {
		this.baseTestClass = baseTestClass;
	}
	
	/**
	 * To launch the ENS URL, it will be different for different QA environment.
	 * @author ning.xue
	 */
	private void startVerify() {

		baseTestClass.getEnsHomePage().openNewTabForEns(TestDataHandler.ssConfig.getEnsURL());
		baseTestClass.reporter.reportLogWithScreenshot("Ens Window");
	}
	
	/**
	 * To login to ENS using operator name and password.
	 * @author ning.xue
	 */
	private void loginToEns() {
		baseTestClass.reporter.reportLogWithScreenshot("Ens Login Window");
		baseTestClass.getEnsHomePage().setEmail(System.getenv("ENS_USERNAME"));
		baseTestClass.reporter.reportLogWithScreenshot("Set ENS Login details");
		baseTestClass.getEnsHomePage().clkBtnNext();
		baseTestClass.getEnsHomePage().setPassword(System.getenv("ENS_PASSWORD"));
		baseTestClass.getEnsHomePage().clkBtnSignIn();
	}

	/**
	 * To get the verify code in pdf file from ENS and close ENS window.
	 * @param strPhoneNum, the recovery phone number
	 * @return String, the verification code.
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @author ning.xue
	 */
	public String getVerifyCode(String strPhoneNum){

		this.startVerify();
		this.loginToEns();
		
		baseTestClass.getEnsNotificationViewPage().clkMenuNotifViewer();
		baseTestClass.getEnsNotificationViewPage().clkBtnSearchNotification();
		baseTestClass.getEnsNotificationViewPage().clkLnkPdfForSmsVerify(strPhoneNum);
		String strVerifyCode = baseTestClass.getEnsNotificationViewPage().getNotificationCode();
		baseTestClass.reporter.reportLogWithScreenshot("Got message notification code.");
		baseTestClass.getEnsNotificationViewPage().clkBtnOk();
		baseTestClass.getEnsNotificationViewPage().closeEnsWindow();
		return strVerifyCode;
	}
	
	/**
	 * To get the email notification by clicking the html link in ENS, and switch to the new openned tab.
	 * @param strAccountId
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @author ning.xue
	 */
	public void getEmailVerifyPage(String strAccountId){
		this.startVerify();
		this.loginToEns();
		
		baseTestClass.getEnsNotificationViewPage().clkMenuNotifViewer();
		baseTestClass.getEnsNotificationViewPage().clkBtnSearchNotification();
		baseTestClass.setImplicitWait(baseTestClass.getDriver(), 2);
		baseTestClass.getEnsNotificationViewPage().clkLnkHtmlForEmailVerify(strAccountId);
		baseTestClass.setImplicitWait(baseTestClass.getDriver(), 2);
		baseTestClass.getEnsNotificationViewPage().switchToNewTab(2);
	}

	/**
	 * To get the user name sent to the recovery number in pdf file from ENS and close ENS window.
	 * @param strPhoneNum, String, recovery number.
	 * @return String, the verification code
	 */
	public String getAccountUserName(String strPhoneNum) {
		this.startVerify();
		this.loginToEns();
		
		baseTestClass.getEnsNotificationViewPage().clkMenuNotifViewer();
		baseTestClass.getEnsNotificationViewPage().clkBtnSearchNotification();
		baseTestClass.getEnsNotificationViewPage().clkLnkPdfForSmsVerify(strPhoneNum);
		String strVerifyCode = baseTestClass.getEnsNotificationViewPage().getUserName();
		baseTestClass.reporter.reportLogWithScreenshot("Got message notification code.");
		baseTestClass.getEnsNotificationViewPage().clkBtnOk();
		baseTestClass.getEnsNotificationViewPage().closeEnsWindow();
		return strVerifyCode;
	}
	
}

