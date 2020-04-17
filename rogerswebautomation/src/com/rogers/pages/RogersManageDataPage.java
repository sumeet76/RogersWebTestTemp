package com.rogers.pages;

import java.util.List;

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
		int totalSpeedPass = getAllExistingSpeedPassCount();
		return totalSpeedPass == listAddedData + intCountOfSpeedPassBefore;
		
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
		return (reusableActions.isDisplayed(headerPlanDataOnDataDetailsPage)
				&& reusableActions.isDisplayed(headerUnlimitedDataInYourPlanOnDataDetailsPage));
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
	
}

