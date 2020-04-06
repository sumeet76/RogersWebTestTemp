package com.rogers.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersAddDataPage extends BasePageClass {

	public RogersAddDataPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//select[@formcontrolname='selectedDataTopup']/option")
	List<WebElement> divListAddDataOpt;
	
	@FindBy (xpath = "//span[contains(text(),'Continue') or contains(text(),'Continuer')]")
	WebElement btnContinue;
	
	@FindBy (xpath = "//ins[@translate='purchaseData.purchaseBtn']")
	WebElement btnPurchase;
	
	@FindBy (xpath = "//h2[@class='add-data-modal-title success-title']")
	WebElement lblAddDataSuccess;
	
	@FindBy (xpath = "//rss-add-data//button[@title='Close' or @title='Fermer']")
	WebElement btnCloseAddData;	


	/**
	 * Verifies if Add data overlay displayed
	 * @return true if element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyAddDataOverlayIsDisplayed() {			
		return reusableActions.isElementVisible(divListAddDataOpt.get(1), 60);
	}
	
	/**
	 * Clicks on first add data option
	 * @author Mirza.Kamran
	 */
	public void selectFirstDataAddOnOption() {
		reusableActions.clickWhenReady(divListAddDataOpt.get(1), 60);
		
	}
	
	/**
	 * Clicks on continue button for add data
	 * @author Mirza.Kamran
	 */
	public void clkContinue() {
		reusableActions.clickWhenReady(btnContinue, 30);
		
	}

	/**
	 * Clicks on purchase button for add data
	 * @author Mirza.Kamran
	 */
	public void clkPurchase() {
		reusableActions.clickWhenReady(btnPurchase, 30);
		reusableActions.waitForPageLoad();
		reusableActions.staticWait(3000);//buffer for sync
		
	}

	/**
	 * clicks on close button add data overlay 
	 * @author Mirza.Kamran
	 * @return true if add data succeed, otherwise false.
	 */
	public boolean clkCloseAddDataIfSuccessful() {
		boolean status = false;
		if(reusableActions.isElementVisible(lblAddDataSuccess))
		{
			reusableActions.clickWhenReady(btnCloseAddData, 30);
			status = true;
		}else if(reusableActions.isElementVisible(By.xpath("//h2[@class='add-data-modal-title error-title']")))
		{
			System.out.print("Limit reached");
			reusableActions.clickWhenReady(btnCloseAddData, 30);
			status = false;
		}
		return status;
		
	}
}

