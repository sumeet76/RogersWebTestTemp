package com.rogers.test.helpers;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import com.rogers.testdatamanagement.TestDataHandler;
import utils.CookieFetcher;

public class CaptchaBypassHandlers {
	
	private WebDriver driver;
	public CaptchaBypassHandlers(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/**
	 * To Bypass Captcha for Self serve Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
		public void captchaBypassURLSelfserveFlows(String strUrl, String strLanguage) throws IOException {
			driver.get(strUrl+"?setLanguage="+ strLanguage );
		
		String strCookieUserName= TestDataHandler.ssConfig.getCookieUserName();
		String strCookieUserPassword= TestDataHandler.ssConfig.getCookieUserPassword();
		
		String strBaseUrl = "";
		if(strUrl.substring(strUrl.length()-3).equalsIgnoreCase("com")) {
			strBaseUrl = strUrl;
		} else {
			strBaseUrl = strUrl.substring(0, strUrl.lastIndexOf("com")+3);
		}
		//Use https url in config.yml, replace https with http here will by pass the certificate issue	
		Cookie captchBypass = new Cookie ("temp_token_r",
		CookieFetcher.setAndFetchCookie(strCookieUserName, strCookieUserPassword, strBaseUrl));			
		driver.manage().addCookie(captchBypass);
    }
	
	/**
	 * To Bypass Captcha for Legacy Anonymous Buy Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
	public void captchaBypassURLLegacyAnonymousBuyFlows(String strUrl, String strLanguage) throws IOException {
				driver.get(strUrl+"/web/totes/api/v1/bypassCaptchaAuth");
				driver.get(strUrl+"?setLanguage="+ strLanguage );
        }

	/**
	 * To Bypass Captcha for Ignite Anonymous Buy Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
	public void captchaBypassURLIgniteAnonymousBuyFlows(String strUrl, String strLanguage) throws IOException {
				driver.get(strUrl+"/web/totes/browsebuy/v1/byPassCaptcha");
				driver.get(strUrl+"?setLanguage="+ strLanguage );
        }
	
	/**
	 * To Bypass Captcha for Legacy login Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
	public void captchaBypassURLLegacyLoginFlows(String strUrl, String strLanguage) throws IOException {
		driver.get(strUrl+"/web/totes/api/v1/bypassCaptchaAuth");		
		driver.get(strUrl+"?setLanguage="+ strLanguage );
		String strCookieUserName= TestDataHandler.rogersConfig.getCookieUserName();
		String strCookieUserPassword= TestDataHandler.rogersConfig.getCookieUserPassword();			
		Cookie captchBypass = new Cookie ("temp_token_r",CookieFetcher.setAndFetchCookie(strCookieUserName, strCookieUserPassword, strUrl));
		driver.manage().addCookie(captchBypass);
  }
	
	/**
	 * To Bypass Captcha for Ignite login Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
	public void captchaBypassURLIgniteLoginFlows(String strUrl, String strLanguage) throws IOException {
		driver.get(strUrl+"/web/totes/browsebuy/v1/byPassCaptcha");		
		driver.get(strUrl+"?setLanguage="+ strLanguage );
		String strCookieUserName= TestDataHandler.rogersConfig.getCookieUserName();
		String strCookieUserPassword= TestDataHandler.rogersConfig.getCookieUserPassword();			
		Cookie captchBypass = new Cookie ("temp_token_r",CookieFetcher.setAndFetchCookie(strCookieUserName, strCookieUserPassword, strUrl));
		driver.manage().addCookie(captchBypass);
  }
	
	/**
	 * To Bypass Captcha for login Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
	public void captchaBypassURLLoginFlows(String strUrl, String strLanguage) throws IOException {
		driver.get(strUrl);		
		driver.get(strUrl+"?setLanguage="+ strLanguage );
		String strCookieUserName= TestDataHandler.rogersConfig.getCookieUserName();
		String strCookieUserPassword= TestDataHandler.rogersConfig.getCookieUserPassword();			
		Cookie captchBypass = new Cookie ("temp_token_r",CookieFetcher.setAndFetchCookie(strCookieUserName, strCookieUserPassword, strUrl));
		driver.manage().addCookie(captchBypass);
  }

	/**
	 * To Bypass Captcha for login Flows
	 * @param strUrl                     string of test url
	 * @param strLanguage                string of language to use
	 */
	public void chOnewviewFlows(String strUrl, String strAccNo,  String strLoginID, String strLanID, String strLanguage,String strBrowser,  Method currentTestMethodName ,String strContactID) throws IOException {
		String oneViewUrl="";
		if(strContactID.equals(""))
		oneViewUrl= CaptchaBypassHandlers.urlOneViewExistingCustomer(strUrl, strLoginID, strLanID, strAccNo, strLanguage);	
		else
			oneViewUrl=CaptchaBypassHandlers.urlOneViewMigration(strUrl, strLoginID, strLanID, strAccNo, strLanguage, strContactID);	
		System.out.println(oneViewUrl + "----------------------------------------------------------------------------");	
		driver.get(oneViewUrl);
  }
	
	public static String  urlOneViewExistingCustomer(String strUrl, String strLoginID, String strLanID, String strAccNo, String strLanguage) {
		String queryParam="";
		if(!strAccNo.startsWith("C"))
		    queryParam="LoginId="+strLoginID+"&UserRole=CSR,BRT%20Authorized%20CSR-3,R76,BTUser,R33,R45,R47,R52,R54,R55,R65,R68,R75,R77,R246,R252,R261,R167,R306,R307,R304,R311,BRT Authorized CSR-3,BRT Authorized CSR-4&AccNo="+strAccNo+"&Target=UTE&TimeStamp=2020-10-03T11:29:45.442-04:00&Lang="+strLanguage+"&AppId=CRM&li="+strLanID;
		else
			queryParam="LoginId="+strLoginID+"&UserRole=CSR,BRT%20Authorized%20CSR-3,Ignite Learning Lab Additive Role,R252&IntID=&AccNo=&Target=UTE&TimeStamp=2020-01-20T11:29:45.442-04:00&Lang="+strLanguage+"&AppId=CRM&li="+strLanID+"&ContactID="+strAccNo+"&targetURL=IgniteNAC&connid=";
		String oneViewUrl= strUrl+queryParam;
		return oneViewUrl;
	}

	public static String urlOneViewAnonymous(String strUrl, String strLoginID, String strLanID, String strAccNo, String strLanguage) {
		String queryParam="LoginId="+strLoginID+"&UserRole=CSR,BRT%20Authorized%20CSR-3,Ignite Learning Lab Additive Role,R252&IntID=&AccNo=&Target=UTE&TimeStamp=2020-01-20T11:29:45.442-04:00&Lang="+strLanguage+"&AppId=CRM&li="+strLanID+"&ContactID="+strAccNo+"&targetURL=IgniteNAC&connid=";
		String oneViewUrl= strUrl+queryParam;
		return oneViewUrl;
	}
	public static String urlOneViewMigration(String strUrl, String strLoginID, String strLanID, String strAccNo,String strLanguage,String strContactID) {
		String queryParam="LoginId="+ strLanID+"&UserRole=CSR,OneviewBRT-1,R76,BT User,R33,R45,R47,R52,R54,R55,R65,R68,R75,R77,R246,R252,R261,R167,R306,R307,R304,R311,BRT Authorized CSR-3,BRT Authorized CSR-4,Ignite Learning Lab Additive Role&AccNo="+strAccNo+"&Target=UTE&TimeStamp=2020-02-18T11:29:45.442-04:00&ContactID="+strContactID+"&Lang="+strLanguage+"&AppId=CRM&li="+strLoginID;
		String oneViewUrl= strUrl+queryParam;
		return oneViewUrl;
	}
	
}
