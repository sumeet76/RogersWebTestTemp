package com.rogers.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersPaymentHistoryPage extends BasePageClass {
	
	public enum MakePayOptions {
	    Bank,
	    Creditcard
	  }

	public RogersPaymentHistoryPage(WebDriver driver) {
		super(driver);
	}

	@FindAll({
	@FindBy(xpath = "//button[contains(@aria-label,'Payment History') or contains(text(),'Historique des paiements')]"),
	@FindBy (xpath = "//div[contains(text(),'Payment History') or contains(text(),'Historique des paiements')]//parent::button")})
	WebElement btnPaymentHistory;

	@FindBy (xpath="//table")
	WebElement tablePaymentHistory;
	
	@FindBy (xpath = "//tbody")
	WebElement tableBody;

	@FindBy(xpath = "//button[@aria-label='Payment History']")
	WebElement tabPaymentHistory;
	
	@FindBy (xpath = "//dsa-alert")
	WebElement alertForNoPayment;
	
	/**
	 * Verify if the payment History tab is selected and payment history is displayed
	 * @return true if the payment history tab is selected otherwise false.
	 * @author ning.xue
	 */
	public boolean verifyPaymentHistoryIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(btnPaymentHistory, 10);
	}
	
	/**
	 * To get the total number of pages (pagination) present for payment history table rows  
	 * @return Integer value for number of pages 
	 * @author Mirza.Kamran
	 */
	public int getTotalPage() {
		
		List < WebElement > pages = getDriver().findElements(By.xpath("//td//div[@class='pull-right pagination-ctn']//span[@class='page-numbers ng-star-inserted']"));
	   	//To calculate no of rows In table.
		if(pages.size()==0)
		{
			return pages.size();
		}else
		{
			return pages.size()-2;
	   	}
	}
	
	/**
	 * Perform click on the page number (pagination) for the payment history rows
	 * @param pageNumber Integer value for page number
	 * @author Mirza.Kamran
	 */
	public void clkPageNumber(int pageNumber) {
		getReusableActionsInstance().clickIfAvailable(By.xpath("//td//div[@class='pull-right pagination-ctn']//span[@class='page-numbers ng-star-inserted']/span[text()='"+Integer.toString(pageNumber)+"']"));
		
	}
	   
	/**
	 * Gets total number of visible rows displayed for payment history
	 * @return Interger value for number of rows
	 * @author Mirza.Kamran
	 */
	public int getTotalRowCount() {
		
		getReusableActionsInstance().waitForElementVisibility(tableBody, 120);
		List < WebElement > rowsTable = tableBody.findElements(By.tagName("tr"));
	   	//To calculate no of rows In table.
	   	return rowsTable.size();
	}

	/**
	 * Gets total number columns for payment history
	 * @param rowNo The row number for payment history
	 * @return Integer value for column number
	 * @author Mirza.Kamran
	 */
	public int getTotalColumnCount(int rowNo) {
		
		List < WebElement > rowsTable = tableBody.findElements(By.tagName("tr"));
		List < WebElement > columnsRow = rowsTable.get(rowNo).findElements(By.xpath("./child::*"));
   	    //To calculate no of columns (cells). In that specific row.
   	    return columnsRow.size();
	}
	
	/**
	 * Checks if the payment history table is visible
	 * @return True if the payment history table is present else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyIfPaymenyHistoryTablePresent() {		
		return getReusableActionsInstance().isElementVisible(tablePaymentHistory, 10);
	}
	
	/**
	 * Checks if the No payment history alert is visible
	 * @return True if the no payment history alert is present else false
	 * @author ning.xue
	 */
	public Boolean verifyNoPaymenyHistoryAlertPresent() {		
		return getReusableActionsInstance().isElementVisible(alertForNoPayment,10);
	}
		
	/**
	 * Checks if the payment history table is visible
	 * @return True if the payment history table is present else false
	 * @author Mirza.Kamran
	 */
	public Boolean verifyIfPaymenyHistoryTabPresent() {		
		return getReusableActionsInstance().getWhenReady(tabPaymentHistory).getAttribute("aria-selected").toString().equalsIgnoreCase("true");
	}
	
	/**
	 * This method will validate each and every row of payment history table and validate if the data is consistent (works for both english and french)
	 * @return True if data is consistent , else false
	 * @author Mirza.Kamran
	 */
   public Boolean verifyIfThePaymentHistoryDataIsConsistent()
   {	 
	    Boolean isDataConsistent=false;
	   	int rowsCount=getTotalRowCount();
	   	//Loop will execute till the last row of table.
	   	for (int intRow = 0; intRow <rowsCount; intRow++) {
	   	    
	   		int columnCount = getTotalColumnCount(intRow);
	   	    System.out.println("Number of cells In Row " + (intRow+1) + " are " + columnCount);
		   	    if(verifyCellDateColumnDataContainsExpectedValuesOnly(intRow)
		   	    && verifyCellAmountColumnDataContainsExpectedValuesOnly(intRow) 	
		   	    && verifyCellTransactionColumnDataContainsExpectedValuesOnly(intRow) 
		   	    && verifyCellDetailsColumnDataContainsExpectedValuesOnly(intRow)
		   	    && verifyCellReferenceColumnDataContainsExpectedValuesOnly(intRow))
		   	    {
		   	    	isDataConsistent= true;
		   	    }else
		   	    {
		   	    	isDataConsistent =false;
		   	    	break;
		   	    }
	   	   }
	   	return isDataConsistent;
   	
  	}
   
   /**
    * Verifies if the Date column of payment history contains correct data in expected format
    * @param intRow Row Number
    * @return true if the cell values match the regular expresions else false
    * @author Mirza.Kamran
    */
   public Boolean verifyCellDateColumnDataContainsExpectedValuesOnly(int intRow){
	   String cellDate = getCellDateData(intRow);
	   if(cellDate.matches("(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s+\\d{1,2},\\s+\\d{4}")								
				//french								
				|| cellDate.matches("\\d{1,2}+\\s+(janvier|février|mars|avril|mai|juin|juillet|août|septembre|octobre|novembre|décembre)\\s+\\d{4}"))
			 {				 
				 System.out.println("The data in row No:"+ intRow +  " columName Date " + cellDate);
				 return true;
				
			 }else
			 {
				 
				 System.out.println("Seems some mismatch found in below data-------- please investigate------");
				 System.out.println("The data in row No:"+ intRow +  " columName Date " + cellDate);
				 return false;				 
			 }	 	
			 
	 }

   /**
    * Verifies if the Amount column of payment history contains correct data in expected format
    * @param intRow Row Number
    * @return true if the cell values match the regular expresions else false
    * @author Mirza.Kamran
    */
   public Boolean verifyCellAmountColumnDataContainsExpectedValuesOnly(int intRow){
	   String cellAmount = getCellAmountData(intRow);
	   if(cellAmount.split("\\$")[0].matches("^\\d+(\\,\\d{1,2})?+\\s+$")
			   || cellAmount.split("\\$")[1].matches("^\\d+(\\.\\d{1,2})?$"))
			 {				 
				 System.out.println("The data in row No:"+ intRow +  " columName Amount " + cellAmount);
				 return true;
				
			 }else
			 {
				 
				 System.out.println("Seems some mismatch found in below data-------- please investigate------");
				 System.out.println("The data in row No:"+ intRow +  " columName Amount " + cellAmount);
				 return false;				 
			 }	 	
			 
	 }
   
   /**
    * Verifies if the Transaction column of payment history contains correct data in expected format
    * @param intRow Row Number
    * @return true if the cell values match the regular expresions else false
    * @author Mirza.Kamran
    */
   public Boolean verifyCellTransactionColumnDataContainsExpectedValuesOnly(int intRow){
	   String cellTransaction = getCellTransactionData(intRow);
	   if(cellTransaction.toLowerCase().contains("credit card") 
				||cellTransaction.toLowerCase().contains("interac")
				||cellTransaction.contains("Rogers Store")
				||cellTransaction.contains("Other")
				||cellTransaction.contains("**** **** ****") 								
				//french								
				|| (cellTransaction.toLowerCase().contains("arte de crédit") 
						||cellTransaction.toLowerCase().contains("interac")
						||cellTransaction.contains("Rogers Store")
						||cellTransaction.contains("Autre")
						||cellTransaction.contains("**** **** ****") ))
			 {				 
				 System.out.println("The data in row No:"+ intRow +  " columName Transaction " + cellTransaction);
				 return true;
				
			 }else
			 {
				 
				 System.out.println("Seems some mismatch found in below data-------- please investigate------");
				 System.out.println("The data in row No:"+ intRow +  " columName Transaction " + cellTransaction);
				 return false;				 
			 }	 	
			 
	 }
   
   /**
    * Verifies if the Details column of payment history contains correct data in expected format
    * @param intRow Row Number
    * @return true if the cell values match the regular expresions else false
    * @author Mirza.Kamran
    */
   public Boolean verifyCellDetailsColumnDataContainsExpectedValuesOnly(int intRow){
	   String cellDetails = getCellDetailsData(intRow);
	   //Below are the details of all possible transaction status messages in both languages
	   if((cellDetails.contains("Successful")
				||cellDetails.contains("Unsuccessful")
				||cellDetails.contains("Credited to you")
				||cellDetails.contains("Credit reversal")
				||cellDetails.contains("Amount you transferred")
				||cellDetails.contains("Transferred to you"))								
				//french								
				|| (cellDetails.contains("Réussi")
						||cellDetails.contains("Infructueux")
						||cellDetails.contains("Crédité à vous")
						||cellDetails.contains("Renversement de crédit")
						||cellDetails.contains("Montant que vous avez transféré")
						||cellDetails.contains("Transféré à vous")))
			 {				 
				 System.out.println("The data in row No:"+ intRow +  " columName Details " + cellDetails);
				 return true;
				
			 }else
			 {
				 
				 System.out.println("Seems some mismatch found in below data-------- please investigate------");
				 System.out.println("The data in row No:"+ intRow +  " columName Details " + cellDetails);
				 return false;				 
			 }	 	
			 
	 }
     
   /**
    * Verifies if the Reference column of payment history contains correct data in expected format
    * @param intRow Row Number
    * @return true if the cell values match the regular expresions else false
    * @author Mirza.Kamran
    */
   public Boolean verifyCellReferenceColumnDataContainsExpectedValuesOnly(int intRow){
	   String cellReference = getCellReferenceData(intRow);
	   if(cellReference.matches("\\d+"))
			 {				 
				 System.out.println("The data in row No:"+ intRow +  " columName reference " + cellReference);
				 return true;
				
			 }else
			 {
				 
				 System.out.println("Seems some mismatch found in below data-------- please investigate------");
				 System.out.println("The data in row No:"+ intRow +  " columName reference " + cellReference);
				 return false;				 
			 }	 	
			 
	 }
   
   /**
    * Gets the Column Date cell data 
    * @param intRow Row number to fetch data from
    * @return String value containing the cell data
    * @author Mirza.Kamran
    */
   public String getCellDateData(int intRow) {
	   return getReusableActionsInstance().getWhenReady(By.xpath("//tbody/tr["+(intRow+1)+"]/td[1]")).getText();
   }
   
   /**
    * Gets the Column Amount cell data 
    * @param intRow Row number to fetch data from
    * @return String value containing the cell data
    * @author Mirza.Kamran
    */
   public String getCellAmountData(int intRow) {
	   return getReusableActionsInstance().getWhenReady(By.xpath("//tbody/tr["+(intRow+1)+"]/td[2]")).getText();
   }
   
   /**
    * Gets the Column Transaction cell data 
    * @param intRow Row number to fetch data from
    * @return String value containing the cell data
    * @author Mirza.Kamran
    */
   public String getCellTransactionData(int intRow) {
	   return getReusableActionsInstance().getWhenReady(By.xpath("//tbody/tr["+(intRow+1)+"]/td[3]")).getText();
   }
   
   /**
    * Gets the Column Details cell data 
    * @param intRow Row number to fetch data from
    * @return String value containing the cell data
    * @author Mirza.Kamran
    */
   public String getCellDetailsData(int intRow) {
	   return getReusableActionsInstance().getWhenReady(By.xpath("//tbody/tr["+(intRow+1)+"]/td[4]")).getText();
   }
   
   /**
    * Gets the Column Reference cell data 
    * @param intRow Row number to fetch data from
    * @return String value containing the cell data
    * @author Mirza.Kamran
    */
   public String getCellReferenceData(int intRow) {
	   return getReusableActionsInstance().getWhenReady(By.xpath("//tbody/tr["+(intRow+1)+"]/td[5]")).getText();
   }
   
   /**
    * Verifies the transaction type value on payment history record
    * @param intRow Row number for which the transaction columns needs to be checked
    * @param strTransactionTypeValue String containing the transaction name
    * @return true if the transaction values match, else false
    * @author Mirza.Kamran
    */
   public Boolean verifyTransationTypeValue(int intRow, String strTransactionTypeValue)
   {
	   if(!strTransactionTypeValue.toLowerCase().contains(getCellTransactionData(intRow).toLowerCase().substring(0,getCellTransactionData(intRow).toLowerCase().length()-4)))
	   {
		   System.out.println("The transaction expected value was : "+strTransactionTypeValue+ " But displayed value is : "+getCellTransactionData(intRow));
		   return false;
	   }
	   return true;
   }
   
   /**
    * Verifies the transaction details value on payment history record
    * @param intRow Row number for which the transaction columns needs to be checked
    * @param strCellValue String containing the transaction details
    * @return true if the transaction details column values match, else false
    * @author Mirza.Kamran
    */
   public Boolean verifyTransactionDetailsCellValue(int intRow, String strCellValue) {
	   if(!strCellValue.contains(getCellDetailsData(intRow)))
	   {
		   System.out.println("The transaction Details cell expected value was : "+strCellValue+ " But displayed value is : "+getCellDetailsData(intRow));
		   return false;   
	   }
	   return true;
	   
   }
   
   /**
    * It will navigate each page of payment history table and search each row to verify if the successful transaction record is displayed correctly
    * @param strRefrenceNumber The unique payment reference number genearted after any successful transaction
    * @param enumPayOption Enum values of type MakePayOptions
    * @return True if the payment history record is verified after successful transaction,else false
    * @author Mirza.Kamran
    */
   public Boolean verifyPaymentHistory(String strRefrenceNumber,MakePayOptions enumPayOption)
   {
	 
		Boolean found = false; 
		String transactionType = getTransactionTypeName(enumPayOption);		
	   	int pageCount = getTotalPage();
	   	 
	   	//if we have more than one page for payment history record
		if(pageCount != 0)
		{
			for(int page = 1; page <= pageCount; page++)
			{
				if(!found)
				{
					clkPageNumber(page);				  
					found=verifyPaymentHistoryRowForSuccessFulTransaction(strRefrenceNumber, transactionType);
				}else
				{
					break;
				}
			}
		}else //for No paginations
		{			
			found=verifyPaymentHistoryRowForSuccessFulTransaction(strRefrenceNumber, transactionType);
		}	
		
   		if(!found)
   		{
   			System.out.println("Seems no record found for  "+strRefrenceNumber );
   			return false;
   		}else
   		{   			
   			return true;
   		}
   }
   
   
   /**
    * It will verify if the successful transaction row is displayed correctly in the payment history table
    * @param strRefrenceNumber The unique payment reference number generated after any successful transaction
    * @param strTransactionType The transaction type name  (e.g: creditcard,interac etc)
    * @return true if the values match in payment history row else false
    * @author Mirza.Kamran
    */   
   public boolean verifyPaymentHistoryRowForSuccessFulTransaction(String strRefrenceNumber, String strTransactionType) {
	   int rowsCount = getTotalRowCount();	
	   Boolean match=false;
	   	for (int intRow = 0; intRow < rowsCount; intRow++) {	   	    	   		
			
	   		String refnumber = getCellReferenceData(intRow);	   		
  			if(refnumber.trim().equals(strRefrenceNumber))
	   	    {		   						   				   		 		   		 
		   		 if((verifyCellDateColumnDataContainsExpectedValuesOnly(intRow)
		 		   	  && verifyCellAmountColumnDataContainsExpectedValuesOnly(intRow) 
		   			  && verifyTransationTypeValue(intRow, strTransactionType)
		   			  && verifyTransactionDetailsCellValue(intRow, "Successful Réussi"))	 			   					   					   		    
		   			)
		   		 {
		   			match= true; 
		   		 }else
		   		 {
		   			 match=false;
		   			 break;
		   		 }
		   		break;				   							   				   		 
		   	  }			   			   	   
	   	  }
	   	
	   	return match;
   }
   
   /**
    * This will get the transaction type name as displayed on the payment history row in english and french
    * @param enumPayOption enum values containing the transaction type 
    * @return transaction name string value
    * @author Mirza.Kamran 
    */
   public String getTransactionTypeName(MakePayOptions enumPayOption) {
	   String transactionType = "";
	  
	   //will return text for english and french language both
		switch (enumPayOption) {
		case Bank:
			transactionType="**** **** ****";
			break;
		case Creditcard:
			transactionType="Payment by credit card Paiement - carte de crédit Carte de crédit";	
			break;
		default:
			break;
		}
		
		return transactionType;
   }

}