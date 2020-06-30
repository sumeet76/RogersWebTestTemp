package com.rogers.oneview.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.rogers.pages.base.BasePageClass;


public class EnvironmentSelectionPage extends BasePageClass {

	public EnvironmentSelectionPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//select[@name='envList']")
	WebElement ddlenvList;
	
	@FindBy(xpath = "//button[@class='btn']")
	WebElement btnGo;
	
	@FindBy(xpath = "//div[@class='dialog'] ")
	WebElement dlgDealerCode;
	
	@FindBy(xpath = "//input[@placeholder='Enter dealer code']")
	WebElement txtDealerCode;
	
	@FindBy(xpath = "//div[@class='ute-dc-padding-zero col-xs-8']//button[@translate='ute.rogers.captureDealerCode.submit']")
	WebElement btnSubmit;
	
	/**
	 * Selects the first identification on Credit check page
	 * @param env to select on oneview portal
	 * @author Chinnarao.Vattam
	 */
	public void selectOneViewEnv(String env) {
		reusableActions.selectWhenReadyByVisibleText(ddlenvList, env);
		reusableActions.getWhenReady(btnGo, 30).click();
		
		}
	
	/**
	 * Enter the dealer code on capture dealer code page
	 * @param strDealerCode dealer code
	 * @author Chinnarao.Vattam
	 */
	public void enterDealerCode(String strDealerCode) {
		reusableActions.waitForElementVisibility(dlgDealerCode, 60);
		reusableActions.getWhenReady(txtDealerCode, 10).click();
		reusableActions.getWhenReady(txtDealerCode).sendKeys(strDealerCode);		
	}
	
	/**
	 * Submit the capture dealer code page
	 * @author Chinnarao.Vattam
	 */
	public void submitDealerCode() {
		reusableActions.getWhenReady(btnSubmit, 30).click();
	}
	
	/**
	 * Click on go button
	 * @author Saurav.Goyal
	 */
	public void clkGo() {
		reusableActions.clickWhenReady(btnGo , 30);
	}
	
	/**
	 * Check the presence of the go button
	 * @author Saurav.Goyal
	 */
	public void presenceOfTheGoButton() {
		reusableActions.isElementVisible(btnGo, 10);
	}
}
