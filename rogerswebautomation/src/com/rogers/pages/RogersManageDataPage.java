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
	WebElement totalDataInDataDetail;
	
	@FindBy (xpath = "//a[@title='Back to usage dashboard' or @title='Retour au tableau de bord']")
	WebElement btnBackFromManageUsers;

	@FindBy (xpath = "//p[@class='text-md text-semi add-title mt-15']")
	WebElement addedDataInDataManagePage;


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
		return reusableActions.isElementVisible(totalDataInDataDetail, 30);
	}
	

	/**
	 * Clicks on back button 
	 * @author Mirza.Kamran
	 */
	public void clkBackOnManageDataUsagePage() {
		reusableActions.clickWhenReady(btnBackFromManageUsers, 60);		
	}
}

