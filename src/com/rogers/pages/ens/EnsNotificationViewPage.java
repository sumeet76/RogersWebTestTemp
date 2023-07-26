package com.rogers.pages.ens;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;


public class EnsNotificationViewPage extends BasePageClass {

	public EnsNotificationViewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//a[contains(text(),'Notification Viewer')]")
	WebElement menuNotificationViewer;
	
	@FindBy (xpath = "//input[@id='accountID']")
	WebElement txtAccountId;
	
	@FindBy (xpath = "//input[@value='Search Notificatons']")
	WebElement btnSearchNotification;
	
	@FindBy (xpath = "//div[@class='bd']/table/tbody/tr/td")
	WebElement notificationText;
	
	@FindBy (xpath = "//button[contains(text(),'OK')]")
	WebElement btnOk;

	@FindBy(id="contactEmail")
	WebElement txtContactEmail;

	@FindBy (xpath = "//img[@alt='Set password']")
	WebElement btnSetPasswordInEmail;

	/**
	 * Click on menu Notification Viewer
	 * @author ning.xue 
	 */
	public void clkMenuNotifViewer() {
		getReusableActionsInstance().getWhenVisible(menuNotificationViewer).click();
	}
	
	/**
	 * Set account ID for notification
	 * @param strAccountId, string of account ID
	 * @author ning.xue
	 */
	public void setAccountId(String strAccountId) {
		getReusableActionsInstance().getWhenReady(txtAccountId).clear();
		getReusableActionsInstance().getWhenReady(txtAccountId).sendKeys(strAccountId);
	}
	
	/**
	 * Click the button "Search Notification" in ENS page
	 * @author ning.xue
	 */
	public void clkBtnSearchNotification() {
		getReusableActionsInstance().staticWait(6000);
		getReusableActionsInstance().clickWhenVisible(btnSearchNotification);
	}
	/**
	 * To verify in email by clicking the html file image by locating the first(latest) record by account ID.
	 * @param strAccountId, string of account email
	 * @author ning.xue
	 */
	public void clkLnkHtmlForEmailVerify(String strAccountId) {
		getReusableActionsInstance().waitForAllElementsVisible(getDriver().findElements(By.xpath("//td[contains(text(),'" + strAccountId + "')]")), 30);
		List<WebElement> lnkHtml = getDriver().findElements(By.xpath("//td[contains(text(),'" + strAccountId + "')]//following-sibling::td/a[@class='img_html_png']"));
		getReusableActionsInstance().getWhenReady(lnkHtml.get(0), 30).click();
		getReusableActionsInstance().waitForNumberOfWindowsToBe(3, 20);
	}
	
	/**
	 * To get verify code in SMS by clicking the pdf file image by locating the first(latest) record by phone number.
	 * @param strPhoneNum, string of phone number
	 * @author ning.xue
	 */
	public void clkLnkPdfForSmsVerify(String strPhoneNum) {
		getReusableActionsInstance().waitForAllElementsVisible(getDriver().findElements(By.xpath("//td[contains(text(),'" + strPhoneNum + "')]//following-sibling::td/a[@class='img_pdf_png']")), 30);
		List<WebElement> lnkHtml = getDriver().findElements(By.xpath("//td[contains(text(),'" + strPhoneNum + "')]//following-sibling::td/a[@class='img_pdf_png']"));
		getReusableActionsInstance().getWhenVisible(lnkHtml.get(0)).click();
	}
	
	/**
	 * To get the notification code from the last 7 digital string.
	 * @return verification code, string
	 * @author ning.xue
	 */
	public String getNotificationCode() {
		getReusableActionsInstance().staticWait(5000);
		String strNotification = notificationText.getText();
		String strCode = strNotification.substring(strNotification.length()-8);
		return strCode;
	}
	
	/**
	 * To get the notification email from t
	 * @return login username, string
	 * @author Mirza.Kamran
	 */
	public String getUserName() {
		getReusableActionsInstance().staticWait(5000);
		String strNotification = notificationText.getText();
		String struserName = strNotification.split(": ")[1].trim();
		return struserName;
	}
	
	/**
	 * To click the OK button in the pdf pop up.
	 * @author ning.xue
	 */
	public void clkBtnOk() {
		getReusableActionsInstance().clickWhenVisible(btnOk, 10);
	}
	
	/**
     * Sets the email id
     * @param strEmail, email string.
     */
    public void setEmailId(String strEmail) {
    	getReusableActionsInstance().getWhenReady(txtContactEmail).sendKeys(strEmail);
    }
    
    /**
	 * Switch to specific tab
	 * @param intTabIndex the index of the tab
	 */
	public void switchToNewTab(int intTabIndex) {
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs.get(intTabIndex));
	}
	
	/**
	 * To click set password button in email details page
	 * @author ning.xue
	 */
	public void clkBtnSetPasswordInEmail() {
		getReusableActionsInstance().clickWhenReady(btnSetPasswordInEmail, 30);
	}
	
	/**
	 * Close the ENS Window
	 * @author ning.xue
	 */
	public void closeEnsWindow() {
		getReusableActionsInstance().closeCurrentWindow();
	}

}
