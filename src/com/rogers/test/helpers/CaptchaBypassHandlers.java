package com.rogers.test.helpers;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import utils.CookieFetcher;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

public class CaptchaBypassHandlers {

	private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
	public CaptchaBypassHandlers(WebDriver driver) {
		webDriverThreadLocal.set(driver);
	}
	private WebDriver getDriver(){
		return webDriverThreadLocal.get();
	}
	/**
	 * To Bypass Captcha for Legacy Anonymous Buy Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
	public void captchaBypassURLLegacyAnonymousBuyFlows(String strUrl, String strLanguage) throws IOException {
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		        getDriver().get(strUrl+"/consumer/easyloginriverpage"+"?setLanguage="+ strLanguage);
        }

	/**
	 * To Bypass Captcha for Legacy Anonymous Buy Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
	public void captchaBypassURLIgniteAnonymousBuyFlows(String strUrl, String strLanguage) throws IOException {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getDriver().get(strUrl+"?setLanguage="+ strLanguage);
	}

	/**
	 * To Bypass Captcha for Legacy login Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
	public void captchaBypassUrlLoginFlows(String strUrl, String strLanguage) throws IOException {		
		
		@SuppressWarnings("deprecation")	
		 int strMin = new Date().getMinutes();
		strMin = strMin/15;
		int intRandom=0;
		if(strMin>=0 && strMin <1)
		{
			intRandom = 1;
		}else if(strMin>=1 && strMin <2)
		{
			intRandom = 2;	
		}else if(strMin>=2 && strMin < 3)
		{
			intRandom = 3;
		}else if(strMin>=3 && strMin <4)
		{
			intRandom = 4;
		}
		String strCookieUserName= "rogers"+ new Date().getDay()+new Date().getHours()+intRandom+"@hmail.com";//TestDataHandler.fidoConfig.getCookieUserName();
		String strCookieUserPassword= strCookieUserName;
		String strCookieFetchURL = generateCookieFetchURL(strUrl);
		String strCookieRegistrationURL = generateCookieRegistrationURL(strUrl);
		String strCookieFileType = "rogers";
		String strCookieName = "temp_token_r";
		Cookie captchBypass = new Cookie ("temp_token_r",CookieFetcher.setAndFetchCookie(strCookieUserName, strCookieUserPassword, strUrl, strCookieFetchURL, strCookieRegistrationURL , strCookieFileType , strCookieName));
		//Add wait time for the add cookie to work on Firefox.
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getDriver().manage().addCookie(captchBypass);
	}

	/**
	 * To Bypass Captcha for login Flows
	 * @param strUrl                     string of test url
	 */
	public String generateCookieRegistrationURL(String strUrl) {
		String cookieEnv = envMapping(strUrl);
		if(!strUrl.contains("www.rogers.com")) {
			return cookieEnv + ".qa01.eks.rogers.com/api/recaptcha/v1/user/recaptchaBypass/register";
		}
		return cookieEnv + ".eks.rogers.com/api/recaptcha/v1/user/recaptchaBypass/register";
	}

	/**
	 * To Bypass Captcha for login Flows
	 * @param strUrl                     string of test url
	 */
	public String generateCookieFetchURL(String strUrl) {
		String cookieEnv = envMapping(strUrl);
		if(!strUrl.contains("www.rogers.com")) {
			return cookieEnv + ".qa01.eks.rogers.com/api/recaptcha/v1/user/recaptchaBypass/login";
		}
		return cookieEnv + ".eks.rogers.com/api/recaptcha/v1/user/recaptchaBypass/login";
	}

	/**
	 * To give the QA env mapping
	 * @param strUrl String of test url
	 * @return String of url starter after mapping
	 */
	public String envMapping(String strUrl) {
		String cookieEnv=null;
		if (strUrl.contains("qa")) {
			cookieEnv = "https://self-serve" + strUrl.split("qa")[1].charAt(0);
		} else if (strUrl.contains("www.rogers.com")) {
			cookieEnv = "https://self-serve.proda01";
		}
		else {
			cookieEnv = System.getProperty("CookieFetcherMapping");
		}
		return cookieEnv;
	}

//	/**
//	 * To Bypass Captcha for login Flows
//	 * @param strUrl                     string of test url
//	 * @param strLanguage                string of language to use
//	 */
//	public void chOnewviewFlows(String strUrl, String strAccNo,  String strLoginID, String strLanID, String strLanguage,String strBrowser,  Method currentTestMethodName ,String strContactID) throws IOException {
//		String oneViewUrl="";
//		if(strContactID.equals(""))
//		oneViewUrl= CaptchaBypassHandlers.urlOneViewExistingCustomer(strUrl, strLoginID, strLanID, strAccNo, strLanguage);
//		else
//			oneViewUrl=CaptchaBypassHandlers.urlOneViewMigration(strUrl, strLoginID, strLanID, strAccNo, strLanguage, strContactID);
//		System.out.println(oneViewUrl + "----------------------------------------------------------------------------");
//		getDriver().get(oneViewUrl);
//  }

	/**
	 * To Bypass Captcha for login Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
	public void chOnewviewFlows(String strUrl, String strAccNo,  String strLoginID, String strLanID, String strLanguage,String strBrowser,  Method currentTestMethodName ,String strContactID) throws IOException {
		String oneViewUrl="";
		if (strLoginID.isEmpty())
			//oneViewUrl = "https://dev-entry-oneview.rogers.com/#/";
		     oneViewUrl=strUrl;
		else if(strContactID.equals(""))
			oneViewUrl = CaptchaBypassHandlers.urlOneViewExistingCustomer(strUrl, strLoginID, strLanID, strAccNo, strLanguage);
		else
			oneViewUrl = CaptchaBypassHandlers.ChOVNACUrl(strUrl, strLoginID, strLanID, strAccNo, strLanguage, strContactID);
		System.out.println(oneViewUrl + "----------------------------------------------------------------------------");
		getDriver().get(oneViewUrl);
	}

	/**
	 * To Bypass Captcha for login Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
	public void chOnewviewNACFlows(String strUrl,  String strLoginID, String strLanID, String strLanguage,String strBrowser,  Method currentTestMethodName ,String strContactID) throws IOException {
		String oneViewUrl="";
		if(strContactID.equals(""))
			oneViewUrl= CaptchaBypassHandlers.urlOneViewNAC(strUrl, strLoginID, strLanID, strLanguage, currentTestMethodName);
		System.out.println(oneViewUrl + "----------------------------------------------------------------------------");
		getDriver().get(oneViewUrl);
	}
	
	public static String  urlOneViewExistingCustomer(String strUrl, String strLoginID, String strLanID, String strAccNo, String strLanguage) {
		String queryParam="";
		if(!strAccNo.startsWith("C"))
		    queryParam="LoginId="+strLoginID+"&UserRole=CSR,BRT%20Authorized%20CSR-3,Oneview Pilot-1,Oneview Pilot-2,Oneview Pilot-4,Oneview BRT-1,Oneview BRT-2,Oneview BRT-3,Oneview BRT-4,R76,BT User,R21,R39,R60,R75,R77,R180,R182,R185,R246,R252,R261,R167,R306,R307,R304,R309,R311,R310,BRT Authorized CSR-1,BRT Authorized CSR-3,BRT Authorized CSR-4&AccNo="+strAccNo+"&Target=UTE&TimeStamp=2021-07-25T11:29:45.442-04:00&Lang="+strLanguage+"&AppId=CRM&li="+strLanID;
		else
			queryParam="LoginId="+strLoginID+"&UserRole=CSR,BRT%20Authorized%20CSR-3,Ignite Learning Lab Additive Role,R252&IntID=&AccNo=&Target=UTE&TimeStamp=2020-01-20T11:29:45.442-04:00&Lang="+strLanguage+"&AppId=CRM&li="+strLanID+"&ContactID="+strAccNo+"&targetURL=IgniteNAC&connid=";
		String oneViewUrl= strUrl+queryParam;
		return oneViewUrl;
	}

	public static String  urlOneViewNAC(String strUrl, String strLoginID, String strLanID, String strLanguage, Method currentTestMethodName) {
		String queryParam="";
		if (currentTestMethodName.getName().contains("Outbound")){
			queryParam="LoginId="+strLoginID+"&UserRole=CSR,BRT%20Authorized%20CSR-3,Oneview Pilot-1,Oneview Pilot-2,Oneview Pilot-4,Oneview BRT-1,Oneview BRT-2,Oneview BRT-3,Oneview BRT-4,R76,BT User,R21,R39,R60,R75,R77,R180,R182,R185,R246,R252,R261,R167,R306,R307,R304,R309,R311,R310,BRT Authorized CSR-1,BRT Authorized CSR-3,BRT Authorized CSR-4&Target=UTE&TimeStamp=2021-09-25T11:29:45.442-04:00&Lang="+strLanguage+"&AppId=CRM&li="+strLanID;
		} else if(currentTestMethodName.getName().contains("FieldSales")) {
			queryParam="LoginId=" + strLoginID + "&UserRole=R59,R57&AccNo=&Target=UTE&TimeStamp=2021-09-25T11:29:45.442-04:00&Lang="+strLanguage+"&AppId=CRM&li="+strLanID;
		} else {
			queryParam="LoginId="+strLoginID+"&UserRole=CSR&AccNo=&Target=UTE&TimeStamp=2021-09-25T11:29:45.442-04:00&Lang="+strLanguage+"&AppId=CRM&li="+strLanID;
		}
		String oneViewUrl= strUrl+queryParam;
		return oneViewUrl;
	}

	public static String ChOVNACUrl(String strUrl, String strLoginID, String strLanID, String strAccNo, String strLanguage, String strContactID) {
		String queryParam = "LoginId="+strLoginID+"&UserRole=R76,BT%20User,R21,R75,R77,R180,R182,R185,R246,R252,R261,R167,R306,R307,R304,R309,R311,R310&IntID=&Target=UTE&TimeStamp=2023-03-18T11:29:45.4412-04:00&Lang="+strLanguage+"&AppId=CRM&li="+strLanID+"&AccNo=&ContactID="+strContactID+"&targetURL=IgniteNAC";
		String oneViewUrl = strUrl + queryParam;
		return oneViewUrl;
	}

	
}
