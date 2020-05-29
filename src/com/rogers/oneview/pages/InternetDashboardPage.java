package com.rogers.oneview.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class InternetDashboardPage  extends BasePageClass {

	public InternetDashboardPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	@FindBy(xpath = "//button[@class='a-btnPrimary ng-star-inserted']")
	WebElement btnContnue;
	
	@FindBy(xpath = "//div[@class='nsm-dialog success nsm-dialog-open']//preceding::i[@class='rch-icon']")
	WebElement imgSuccess;
	
	@FindBy(xpath = "//button[@class='a-btnPrimary ng-star-inserted']")
	WebElement btnSuccessOk;
	
	
	@FindBy(xpath = "//i[@class='li-loader']")
	WebElement popupLoadingFinger;
	
	@FindBy(xpath = "//div[@class='header']")
	WebElement icnHeader;
	
	@FindBy(xpath = "//div[@class='header']")
	WebElement icnFooter;
	
	@FindBy(xpath = "//div[@class='second-level-nav__cta']//button[@class='b-linkCta']")
	WebElement btnBackToAccountOverview;
	
	@FindBy(xpath = "//button[@class='ds-button ds-focus ds-active -secondary -large ng-star-inserted']")
	WebElement btnUsageAndAlerts;
	
	@FindBy(xpath = "//a[@href='https://www.rogers.com/consumer/internet/mesh-whole-home-wifi-network?ipn=1']")
	WebElement lnkLearnMoreWallToWallWifi;
		
	@FindBy(xpath = "//a[@href='/customer/support/article/understanding-wi-fi']")
	WebElement lnkUnderstandingWifi;
	
	@FindBy(xpath = "//a[@href='/customer/support/article/tips-for-placing-eeros']")
	WebElement lnkTipsForPlacingEero;
	
	@FindBy(xpath = "//a[@href='/customer/support/article/internet-speedtest']")
	WebElement lnkTestInternetSpeed;
	
	@FindBy(xpath = "//a[@href='/customer/support/article/how-to-optimize-your-internet-speed-and-wi-fi']")
	WebElement lnkHowToOptimizeSpeed;
	
	@FindBy(xpath = "//a[@href='/consumer/support/internet/IgniteInternet']")
	WebElement lnkGoToSupportSection;
	
	
	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author Drashti.Patel
	 */	
	public boolean verifLlnkLearnMoreWallToWallWifi() {
		reusableActions.waitForElementVisibility(lnkLearnMoreWallToWallWifi, 120);	
		WebElement btn=reusableActions.getWhenReady(lnkLearnMoreWallToWallWifi,120);
		reusableActions.javascriptScrollByCoordinates(0,btn.getLocation().y-100);
		return reusableActions.isElementVisible(lnkLearnMoreWallToWallWifi,120);
	}
	
	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author Drashti.Patel
	 */	
	public boolean verifyLnkUnderstandingWifi() {		
		return reusableActions.isElementVisible(lnkUnderstandingWifi,120);
	}
	
	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author Drashti.Patel
	 */	
	public boolean verifyLnkTipsForPlacingEero() {		
		return reusableActions.isElementVisible(lnkTipsForPlacingEero,120);
	}
	
	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author Drashti.Patel
	 */	
	public boolean verifyLnkTestInternetSpeed() {		
		return reusableActions.isElementVisible(lnkTestInternetSpeed,120);
	}
	
	
	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author Drashti.Patel
	 */	
	public boolean verifyLnkHowToOptimizeSpeed() {		
		return reusableActions.isElementVisible(lnkHowToOptimizeSpeed,120);
	}
	
	/**
	 * Verify the result
	 * @return true if link is visible, else false
	 * @author Drashti.Patel
	 */	
	public boolean verifyLnkGoToSupportSection() {		
		return reusableActions.isElementVisible(lnkGoToSupportSection,120);
	}

	
	/**
	 * Click the view usage and alerts button
	 * @author Drashti.Patel
	 */
	public void clickbtnUsageAndAlerts() {
		WebElement btn=reusableActions.getWhenReady(btnUsageAndAlerts,120);
		reusableActions.javascriptScrollByCoordinates(0,btn.getLocation().y-300);
		reusableActions.clickWhenReady(btnUsageAndAlerts,45);
		}
	
	/**
		
	
	/**
	 * Click the back to overview button which brings the account overview page up
	 * @author Drashti.Patel
	 */
	public void clickBacktoAccountOverview() {
		reusableActions.getWhenReady(btnBackToAccountOverview,120).click();
		}
	
	/**
		
	
	/**
	 *click continue for the ongoing activity on Internet dashboard page
	 * @author Drashti.Patel
	 */
	public void clickContinue() {
		reusableActions.getWhenReady(btnContnue,120).click();
		}
	
	/**
	 * Verify the result
	 * @return true if operation is successful, else false
	 * @author Drashti.Patel
	 */	
	public boolean verifySuccess() {
		reusableActions.waitForElementInvisibility(popupLoadingFinger, 120);		
		return reusableActions.isElementVisible(imgSuccess);
	}
	
	/**
	 * Click "Ok" on success popup
	 * @author Drashti.Patel
	 */
	public void clickSuccessOk() {
		reusableActions.getWhenReady(btnSuccessOk, 120).click();
		}
	
	/**
	 * Verify the header availability
	 * @return true if header is available on TV DashboardPage, else false
	 * @author Drashti.Patel
	 */	
	public boolean verifyHeader() {	
		reusableActions.waitForElementVisibility(icnHeader,120);
		return reusableActions.isElementVisible(icnHeader);
	}
	
	/**
	 * Verify the footer availability
	 * @return true if footer is available on TV DashboardPage, else false
	 * @author Drashti.Patel
	 */	
	public boolean verifyFooter() {
		
		return reusableActions.isElementVisible(icnFooter,120);
	}
	
	/**
	 * Go to Page bottom
	 * @author Drashti.Patel
	 */	
	public void goToPageBottom() {		
		reusableActions.javascriptScrollToBottomOfPage();
	}
	
	
	/**
	 * Go to Page bottom
	 * @author Drashti.Patel
	 */	
	public void goToPageMid() {		
		reusableActions.javascriptScrollToMiddleOfPage();;
	}
	
	
}

