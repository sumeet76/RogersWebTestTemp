package com.rogers.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	@FindBy (xpath = "//span[contains(text(),'added!') or contains(text(),'ajout!')]")
	WebElement msgDataAddedVolume;
	
	@FindBy (xpath = "//rss-add-data//button[@title='Close' or @title='Fermer']")
	WebElement btnCloseAddData;	
	
	@FindBy (xpath = "//h2[@class='add-data-modal-title error-title']")
	WebElement msgError;

	@FindBy (xpath = "//h2[text()='Limit reached' or text()='Limite atteinte']")
	WebElement lblLimitReached;	

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
	 * Selctes an add data option
	 * @param strAddOn string add on value
	 * @author Mirza.Kamran
	 */
	public void selectAddOnOption(String strAddOn) {
		for(WebElement element:divListAddDataOpt)
		{
			if(getNumbersFromString(element.getText()).equals(strAddOn))
			{
				element.click();
				break;
			}
		}	
		
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
	 * Check if add data success message is displayed
	 * @return true if the message is displayed, otherwise false.
	 * @author ning.xue
	 */
	public boolean verifyAddDataSuccessMsgIsDisplayed() {
		return reusableActions.isElementVisible(lblAddDataSuccess);
	}
	
	/**
	 * Get the added data volume from success message.
	 * @return double, the value of added data.
	 */
	public double getAddedDataVolume() {
		String strMsgAddedData = reusableActions.getWhenReady(msgDataAddedVolume, 20).getText();

		double addedDataVolume = 0;
		if (strMsgAddedData.contains("GB")||strMsgAddedData.contains("Go")) {
			String strVolume = strMsgAddedData.substring(0, strMsgAddedData.indexOf("G")-1).trim();
			addedDataVolume = Double.parseDouble(strVolume);
		}
		if (strMsgAddedData.contains("MB")||strMsgAddedData.contains("Mo")) {
			String strVolume = strMsgAddedData.substring(0, strMsgAddedData.indexOf("M")-1).trim();
			addedDataVolume = Double.parseDouble(strVolume)/1000;
		}
		return addedDataVolume;
	}
	
	/**
	 * Check if the error message displayed after click "Purchase" button
	 * @return true if the error message displayed, otherwise false.
	 * @author ning.xue
	 */
	public boolean verifyErrorMsgIsDisplayed() {
		return reusableActions.isElementVisible(msgError);
	}
	
	/**
	 * To click the close button on add data overlay.
	 * @author ning.xue
	 */
	public void clkCloseOnAddDataOverlay() {
		reusableActions.clickWhenReady(btnCloseAddData, 30);
	}

	/**
	 * 
	 * @return
	 */
	public boolean verifyAddDataLimitReachedIsDisplayed() {
		
		return reusableActions.isElementVisible(lblLimitReached);
	}

		public boolean clkTheDataAddOnWhichAreNotAddedMoreThanThreeTime(Map<String, Integer> mapcountOfAlreadyAddedData) {
		boolean foundLessThanThree = false;
		reusableActions.waitForElementVisibility(divListAddDataOpt.get(1), 60);
		for(WebElement btn: divListAddDataOpt)
		{
			String addedvalue = getNumbersFromString(btn.getText());
			if(mapcountOfAlreadyAddedData.containsKey(addedvalue))
			{
				if(mapcountOfAlreadyAddedData.get(addedvalue)<3)
				{
					btn.click();
					foundLessThanThree = true;
					break;
				}
			
			}else
			{
				btn.click();
				foundLessThanThree = true;
				break;
			}
		}
		return foundLessThanThree;
	}


		/**
		 * This will extract the numbers from string
		 * @param strMatch complete string to be matched
		 * @return String number
		 */
		public static String getNumbersFromString(String strMatch) {
			Pattern pattern = Pattern.compile("[0-9]+([,.][0-9]{1,2})?");
	        Matcher match = pattern.matcher(strMatch);  
	        match.find();
	        try {
	        return match.group();
	        }catch (Exception e) {
	        	return "";
			}
		}

		public boolean addDataThreeTimes(Map<String, Integer> countOfAlreadyAddedData) {
		
			return false;
		}

		

		public List<String> getAllAddDataOptions() {
			Integer count = divListAddDataOpt.size();
			List<String> values = new ArrayList<String>();
			for(int itr=1;itr<=count-1;itr++) 
			{
				values.add(getNumbersFromString(divListAddDataOpt.get(itr).getText()));
			}
								
			return values;
		}


}

