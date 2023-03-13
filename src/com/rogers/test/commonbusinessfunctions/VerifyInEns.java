
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

		BaseTestClass.getEnsHomePage().openNewTabForEns(TestDataHandler.ssConfig.getEnsURL());
		baseTestClass.reporter.reportLogWithScreenshot("Ens Window");
	}

	/**
	 * To login to ENS using operator name and password.
	 * @author ning.xue
	 */
	private void loginToEns() {
		baseTestClass.reporter.reportLogWithScreenshot("Ens Login Window");
		BaseTestClass.getEnsHomePage().setEmail(System.getenv("ENS_USERNAME"));
		baseTestClass.reporter.reportLogWithScreenshot("Set ENS Login details");
		BaseTestClass.getEnsHomePage().clkBtnNext();
		BaseTestClass.getEnsHomePage().setPassword(System.getenv("ENS_PASSWORD"));
		BaseTestClass.getEnsHomePage().clkBtnSignIn();
		BaseTestClass.getEnsHomePage().clkSafeToProceed();

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
		
		BaseTestClass.getEnsNotificationViewPage().clkMenuNotifViewer();
		BaseTestClass.getEnsNotificationViewPage().clkBtnSearchNotification();
		BaseTestClass.getEnsNotificationViewPage().clkLnkPdfForSmsVerify(strPhoneNum);
		String strVerifyCode = BaseTestClass.getEnsNotificationViewPage().getNotificationCode();
		baseTestClass.reporter.reportLogWithScreenshot("Got message notification code.");
		BaseTestClass.getEnsNotificationViewPage().clkBtnOk();
		BaseTestClass.getEnsNotificationViewPage().closeEnsWindow();
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
		
		BaseTestClass.getEnsNotificationViewPage().clkMenuNotifViewer();
		BaseTestClass.getEnsNotificationViewPage().clkBtnSearchNotification();
		baseTestClass.setImplicitWait(baseTestClass.getDriver(), 2);
		BaseTestClass.getEnsNotificationViewPage().clkLnkHtmlForEmailVerify(strAccountId);
		baseTestClass.setImplicitWait(baseTestClass.getDriver(), 2);
		BaseTestClass.getEnsNotificationViewPage().switchToNewTab(2);
	}

	/**
	 * To get the user name sent to the recovery number in pdf file from ENS and close ENS window.
	 * @param strPhoneNum, String, recovery number.
	 * @return String, the verification code
	 */
	public String getAccountUserName(String strPhoneNum) {
		this.startVerify();
		this.loginToEns();
		
		BaseTestClass.getEnsNotificationViewPage().clkMenuNotifViewer();
		BaseTestClass.getEnsNotificationViewPage().clkBtnSearchNotification();
		BaseTestClass.getEnsNotificationViewPage().clkLnkPdfForSmsVerify(strPhoneNum);
		String strVerifyCode = BaseTestClass.getEnsNotificationViewPage().getUserName();
		baseTestClass.reporter.reportLogWithScreenshot("Got message notification code.");
		BaseTestClass.getEnsNotificationViewPage().clkBtnOk();
		BaseTestClass.getEnsNotificationViewPage().closeEnsWindow();
		return strVerifyCode;
	}


	private void startVerify(String strEnsUrl) {
		BaseTestClass.getEnsHomePage().openNewTabForEns(strEnsUrl);
		baseTestClass.reporter.reportLogWithScreenshot("Ens Window");
	}

	private void startVerifyCH(String strEnsUrl) {
		String strEnsStsUrl = "https://"+System.getenv("ENS_USERNAME")+":"+System.getenv("ENS_PASSWORD")+"@sts.rci.rogers.ca/adfs/ls/wia?client-request-id=5be570eb-c7e2-49f8-b3f5-57b29e72515f&wa=wsignin1.0&wtrealm=urn%3afederation%3aMicrosoftOnline&wctx=LoginOptions%3D3%26estsredirect%3d2%26estsrequest%3drQQIARAA42KwEkzNKy5MNNEryk9PLSrWS87PLRLiEnhd8DT60fEfnpu_hm-aVxQYv4rRMKOkpKDYSl8fQ72-q1-wfnFGfrlvYmZeQGJ6ql5icklmft4hRtVQS6NUC4NE8yTdJEOjNF2TFDNLXctUE0tdI1NTizQzC9PkFBODC4yMLxgZbzGxBifm5hj9YjIpLcqzyk8sziy2ykvMTS22Kkm2Cnb09bEy0jMAi2Sm6KblF-UmllgVAJ2QWVySmlcyi1laPy-_JDMtMzkRZHlxWGZqeWoR1CmbmFUMEpNMkpOSgI5ISjbXNbEwMtNNMjVK1k00NElLTTE1sjBLsnzELJObmFdQlJpaopedWFpk7FCUnAn3aeIFFp5XLDwGzFYcHFwCDBIMCgw_WBgXsQKDqyCs5RBX_CXffuNzzyVWTGM4xarv6B7pFxrkFVTuEZhhXBWaUpGaGWCRZpSl7-0UkhSZWWFq6JruG-lraZlkYWtmZTiBjfcUG8MHNsYOdoZZ7Ay7OEkP7wO8DD_4pr08c3zLthNvPQA1&cbcxt=&username=&mkt=&lc=";
		BaseTestClass.getEnsHomePage().openNewTabForEns(strEnsStsUrl);
		baseTestClass.getDriver().get(strEnsUrl);
		baseTestClass.reporter.reportLogWithScreenshot("Ens Window");
	}

	public String getTextVerificationCodeCH(String strPhoneNum, String strEnsUrl) throws IOException {
		this.startVerifyCH(strEnsUrl);
		BaseTestClass.getEnsNotificationViewPage().clkMenuNotifViewer();
		BaseTestClass.getEnsNotificationViewPage().clkBtnSearchNotification();
		BaseTestClass.getEnsNotificationViewPage().clkLnkPdfForSmsVerify(strPhoneNum);
		String strVerifyCode = BaseTestClass.getEnsNotificationViewPage().getUserName();
		baseTestClass.reporter.reportLogWithScreenshot("Got message notification code.");
		BaseTestClass.getEnsNotificationViewPage().clkBtnOk();
		BaseTestClass.getEnsNotificationViewPage().closeEnsWindow();
		return strVerifyCode;
	}
	public String getTextVerificationCode(String strPhoneNum, String strEnsUrl) {
		this.startVerify(strEnsUrl);
		this.loginToEns();

		BaseTestClass.getEnsNotificationViewPage().clkMenuNotifViewer();
		BaseTestClass.getEnsNotificationViewPage().clkBtnSearchNotification();
		BaseTestClass.getEnsNotificationViewPage().clkLnkPdfForSmsVerify(strPhoneNum);
		String strVerifyCode = BaseTestClass.getEnsNotificationViewPage().getUserName();
		baseTestClass.reporter.reportLogWithScreenshot("Got message notification code.");
		BaseTestClass.getEnsNotificationViewPage().clkBtnOk();
		BaseTestClass.getEnsNotificationViewPage().closeEnsWindow();
		return strVerifyCode;
	}
}

