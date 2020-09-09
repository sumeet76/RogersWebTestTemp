package com.rogers.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersManageDataPage extends BasePageClass {

	public RogersManageDataPage(WebDriver driver) {
		super(driver);
	}


	@FindBy (xpath = "//a[@title='View data details' or @title='Afficher les détails des données']")
	WebElement lnkViewDetails;
	
	@FindBy (xpath = "//*[contains(text(),'Your data details') or contains(text(),'Détails de vos données')]")
	WebElement headerYourDataDetails;
	
	@FindBy (xpath = "//a[@title='Add/manage authorized users' or @title='Gérer les utilisateurs autorisés et en ajouter']")
	WebElement lnkAddmanageAuthorizeUsers;
	
	@FindBy (xpath = "//span[@class='text-semi ng-star-inserted']/span[1]")
	List<WebElement> valuesAddedData;
	
	@FindBy(xpath = "//p[text()=' Data added to your plan 'or contains(text(),'Données ajoutées à votre forfait')]/ancestor::div[@class='row']//table[contains(@class,'top-ups-details-table')]//tr")
	List<WebElement> rowsAddedData;
	
	@FindBy (xpath = "//p[contains(text(),'Total Data') or contains(text(),'Données totales')]")
	WebElement lblTotalDataInDataDetail;
	
	@FindBy (xpath = "//a[@title='Back to usage dashboard' or @title='Retour au tableau de bord']")
	WebElement btnBackFromManageUsers;

	@FindBy (xpath = "//p[@class='text-md text-semi add-title mt-15']")
	WebElement lblAddedDataInDataManagePage;	

	//SE infinite view details page
	
	@FindBy(xpath = "//p[contains(text(),' Speed Pass') or contains(text(),'Accès Rapido de')]")
	WebElement lblSpeedPassInTotalData;
	
	@FindBy(xpath = "//p[text()=' Plan Data ' or contains(text(),'Données du forfait')]")
	WebElement headerPlanDataOnDataDetailsPage;
	
	@FindBy(xpath = "//p[text()=' Unlimited data in your plan ' or contains(text(),'Données illimitées avec votre forfait')]")
	WebElement headerUnlimitedDataInYourPlanOnDataDetailsPage;
	
	@FindBy(xpath = "//p[text()='Reduced speeds thereafter' or text()='La vitesse est réduite ensuite']/ancestor::td")
	WebElement lblShareableMaxSpeedData;
	
	@FindBy(xpath = "//p[text()=' Total Data ' or contains(text(),'Données totales')]")
	WebElement headerTotalDataViewDataDetails;
	
	@FindBy(xpath = "//span[text()=' shareable max speed data ' or contains(text(),'de données à vitesse maximale à partager')]/ancestor::p")
	WebElement lblTotalDataMessageInViewDetails;

	@FindBy(xpath = "//p[text()=' Data added to your plan 'or contains(text(),'Données ajoutées à votre forfait')]/ancestor::div[@class='row']//table[contains(@class,'top-ups-details-table')]//tr//a[@title='Cancel this add-on' or @title='Annuler cette option']")
	List<WebElement> tableRowsAddDataWithCancel;

	@FindBy (xpath = "//a[@title='Cancel this add-on' or contains(@title,'Annuler cette option')]")
	WebElement lnkCancel;
	
	@FindBy (xpath = "//button//span[text()='Yes, cancel' or text()='Oui, annuler']")
	WebElement btnYesCancel;

	@FindBy(xpath = "//p[text()='Add-on cancelled' or contains(text(),'Option annulée')]")
	WebElement titleAddOnCancelled;
	
	@FindBy(xpath = "//button[@title='Close' or @title='Fermer']//span[contains(text(),'Fermer') or contains(text(),'Close')]/parent::span/parent::button")
	WebElement btnCloseAddOnCancelled;



	/**
	 * Verifies View Details link 
	 * @return true if element is displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean validateViewDetailsLink() {
		boolean isDisplayed=false;
		reusableActions.waitForElementTobeClickable(lnkViewDetails, 30);
		reusableActions.getWhenReady(lnkViewDetails, 50).click();
		if(reusableActions.isElementVisible(headerYourDataDetails,30)
			&& reusableActions.isElementVisible(lnkAddmanageAuthorizeUsers, 30)	)
		{				
			isDisplayed=true;			
		}		
		return isDisplayed;
	}
	
	
	/**
	 * Verifies if the added data is displayed separately in data details
	 * @return true if the new added count plus previous records matches total records else false
	 * @param listAddedData int, new added record count
	 * @param intCountOfSpeedPassBefore int, the previous record
	 * @author ning.xue
	 */
	public boolean verifyAddedDataInDataDetails(int listAddedData, int intCountOfSpeedPassBefore) {		
		int totalSpeedPass1 = getAllExistingSpeedPassCount();
		return totalSpeedPass1 == listAddedData + intCountOfSpeedPassBefore;
		
	}

	/**
	 * This method gets the Speed pass count
	 * @return int count of all speed pass
	 * @author Mirza.Kamran
	 */
	public int getAllExistingSpeedPassCount() {				
		return rowsAddedData.size();
	}

	/**
	 * This method gets the Speed pass count and total value of data
	 * @return int count of all speed pass data
	 * @author Mirza.Kamran
	 */
	public int getAllExistingSpeedPassTotalGB() {
		int sum = 0;
		for (WebElement row : rowsAddedData) 
		{ 			
			String str = row.getText().split(" ")[0];
			String numberOnly= str.replaceAll("[^0-9]", "");
			sum = sum + Integer.parseInt(numberOnly);
		}
		return sum;
	}
	
	/**
	 * Verifies if the total data is displayed in data details
	 * @return true if element is displayed else false
	 * @author ning.xue
	 */
	public boolean verifyTotalDataInDataDetails() {		
		return reusableActions.isElementVisible(lblTotalDataInDataDetail, 30);
	}
	

	/**
	 * Clicks on back button 
	 * @author Mirza.Kamran
	 */
	public void clkBackOnManageDataUsagePage() {
		reusableActions.clickWhenReady(btnBackFromManageUsers, 60);		
	}
	
	/**
	 * Verifies if the total data is displayed in data details
	 * @return true if element is displayed else false
	 * @param countOfExistSpeedPassTotalGB int, value for total gb added
	 * @param totalSharedDataDisplayedInPlanDataSection, int, the value of total shared data
	 * @author ning.xue
	 */
	public boolean verifyTotalDataInDataDetailsWithMaxSpeedAndTotalOfSpeedPasses(int countOfExistSpeedPassTotalGB, int totalSharedDataDisplayedInPlanDataSection) {
		String strtotalShared = reusableActions.getWhenReady(lblTotalDataMessageInViewDetails).getText().split("GB|Go")[0].replace(",", ".");		
		if (!reusableActions.isElementVisible(lblSpeedPassInTotalData, 10)) {
			return false;
		} else {
			String strSpeedPassTotal = reusableActions.getWhenReady(lblSpeedPassInTotalData).getText();
			String strTotalSpeedPass= strSpeedPassTotal.replaceAll("[^0-9]", "");
			return (((int)Double.parseDouble(strtotalShared) == totalSharedDataDisplayedInPlanDataSection)
					&& (Integer.parseInt(strTotalSpeedPass) == countOfExistSpeedPassTotalGB));
		}

	}

	/**
	 * Verifies if the Plan data is displayed (shared data across all lines)
	 * @return true if the elements exists else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyPlanDataIsDisplayed() {
		return (reusableActions.isElementVisible(headerPlanDataOnDataDetailsPage)
				&& reusableActions.isElementVisible(headerUnlimitedDataInYourPlanOnDataDetailsPage));
	} 

	/**
	 * Gets the total plan data for Infinite plan.
	 * @return int value of total shared data
	 * @author Mirza.Kamran
	 */
	public int getTotalPlanData() {	
		String str = reusableActions.getWhenReady(lblShareableMaxSpeedData).getText().split("GB|Go")[0].replace(",", ".");
		String numberOnly= str.replaceAll("[^0-9]", "");
		return Integer.parseInt(numberOnly);
	}


	/**
	 * This method gets all the existing added data records.
	 * @return int count of all speed pass
	 * @author Mirza.Kamran
	 */
	public HashMap<String, Integer> getAllExistingAddDataCountCancelledAndActive() {
		int active=0;
		int cancelled=0;
		int nonMTT=0;
		HashMap<String, Integer> addData = new HashMap<String, Integer>();
		for(WebElement row:rowsAddedData)
		{
			if(row.getText().toLowerCase().contains("cancel") ||row.getText().toLowerCase().contains("annuler"))
			{
				active++;
				
			}else if(row.getText().toLowerCase().contains("expires") || row.getText().toLowerCase().contains("prend"))
			{
				cancelled++;
			}else
			{
				nonMTT++;
			}
		}
		
		addData.put("active", active);
		addData.put("cancelled", cancelled);
		addData.put("nonMTT", nonMTT);
		return addData;
	}
	
	/**
	 * Clicks on the cancel MDT link
	 * @author Mirza.Kamran
	 */
	public void clkCancelMDTLink() {
		Boolean found = false;
		for(WebElement row : tableRowsAddDataWithCancel) {
			if(found ==false 
				&&	(row.getText().toLowerCase().contains("cancel")
				|| row.getText().toLowerCase().contains("annuler"))) {
				lnkCancel.click();
				found = true;
				break;
			}
		}
		
	}

	/**
	 * Clicks on Yes cancel on Overlay
	 * @author Mirza.Kamran
	 */
	public void clkYesRemoveTopUpButton() {
		reusableActions.clickIfAvailable(btnYesCancel);		
	}

	/**
	 * Verify if the canceled MDT is showing as canceled in manage data page.
	 * @param countOfNewlyCancelled, the number of records for newly canceled MDT.
	 * @param countOfPreviousCancelled, the number of records for previous canceled MDT.
	 * @return true if the count match else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyCancelledMDTInManageData(int countOfNewlyCancelled, int countOfPreviousCancelled) {
		int cancelled= getAllExistingAddDataCountCancelledAndActive().get("cancelled");
		return (cancelled==(countOfNewlyCancelled+countOfPreviousCancelled));
	}

	/**
	 * Clicks on the close overlay
	 * @author Mirza.Kamran
	 */
	public void clkCloseButtonOnCancelSuccessOverlay() {
		reusableActions.getWhenReady(btnCloseAddOnCancelled).click();
	}

	/**
	 * Check if  MDT is cancelled successfully.
	 * @return true if the cancelled is successful
	 * @author Mirza.Kamran
	 */
	public boolean isCancelSuccessdisplayed() {		
		return reusableActions.isElementVisible(titleAddOnCancelled,30);
	}


	public Map<String, Integer> getCountOfAllExistingAddedDataValues() {
		HashMap<String, Integer> addedDataValues = new HashMap<String, Integer>();
		for(WebElement row:rowsAddedData)
		{		
			int addedValueCount=0;
			String strAddedValue = getNumbersFromString(row.getText());
			if(addedDataValues.containsKey(strAddedValue))
			{
				addedValueCount =	addedDataValues.get(strAddedValue);
				addedValueCount++;
				addedDataValues.put(strAddedValue, addedValueCount);
			}else
			{
				addedDataValues.put(strAddedValue, 1);
			}
			
		}
		
	
		return addedDataValues;
	}
	
	/**
	 * This will extract the numbers from string
	 * @param strMatch complete string to be matched
	 * @return String number
	 */
	public String getNumbersFromString(String strMatch) {
		Pattern pattern = Pattern.compile("[0-9]+([,.][0-9]{1,2})?");
        Matcher match = pattern.matcher(strMatch);  
        match.find();
        return match.group();
	}


	/**
	 * Gets the count of all previously added data
	 * @return int count value of added data
	 * @author Mirza.Kamran
	 */
	public int getAllExistingAddedDataCount() {
		return rowsAddedData.size();
		
	}
	
}

