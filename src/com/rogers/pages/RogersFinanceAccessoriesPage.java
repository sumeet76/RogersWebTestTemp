package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import com.rogers.test.helpers.CurrencyHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author rajesh.varalli1
 *
 */
public class RogersFinanceAccessoriesPage extends BasePageClass {

	public RogersFinanceAccessoriesPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "//h1[text()='Financed accessories' or text()='Accessoires financés']")
	WebElement headerFinancedAccessories;
	
	@FindBy(xpath = "//span[text()='Total monthly financing payment: ' or text()='Total mensuel du paiement pour le financement : ']/parent::div//ds-price")
	WebElement lblTotalMonthlyFinPayment;

	@FindBy(xpath = "//span[text()='Monthly financing payment:  ' or text()='Paiement mensuel pour le financement :  ']/parent::div//ds-price")
	WebElement lblMonthlyFinPayment;

	@FindBy(xpath = "//span[contains(text(),'Monthly financed taxes:') or contains(text(),'Taxes mensuelles sur le financement')]/parent::div//ds-price")
	WebElement lblMonthlyFinTaxes;

	@FindBy(xpath = "//span[contains(text(),'Total remaining financing balance:') or contains(text(),'Solde total du financement :')]/parent::div//ds-price")
	WebElement lblTotalRemainingFinBalance;

	@FindBy(xpath = "//span[contains(text(),'Remaining financing balance:') or contains(text(),'Solde restant du financement :')]/parent::div//ds-price")
	WebElement lblRemainingFinBalance;

	@FindBy(xpath = "//span[contains(text(),'Remaining financed taxes:') or contains(text(),'Taxes restantes du financement :')]/parent::div//ds-price")
	WebElement lblRemainingFinTaxes;

	@FindBy(xpath = "//span[contains(text(),'Financing ending:') or contains(text(),'Fin du financement :')]")
	WebElement lblFinEnding;

			@FindBy(xpath = "//span[contains(text(),'Started:') or contains(text(),'Début :')]")
			WebElement lblStarted;

			@FindBy(xpath = "//span[contains(text(),'Agreement ID:') or contains(text(),'ID de l’entente :')]")
			WebElement lblAgreementID;

			@FindBy(xpath = "//span[contains(text(),'Financing term:') or contains(text(),'Durée du financement :')]")
			WebElement lblFinTerm;

			@FindBy(xpath = "//span[contains(text(),'Balance remaining:') or contains(text(),'Paiement mensuel pour le financement :')]/following-sibling::ds-price")
			WebElement lblBalanceRemaining;

			@FindBy(xpath = "//button[@title='See more details about your accessory financing agreement' or @title=' Voir plus de détails ']")
			WebElement btnSeeMoreDetails;


			@FindBy(xpath = "//div[contains(@class,'accessory-item')]")
			WebElement paneAccecoryItem;

			@FindBy(xpath = "//div[contains(@class,'accessory-item')]/img")
			WebElement paneAccessoryImage;

			@FindBy(xpath = "//div[contains(@class,'accessory-item')]/div")
			WebElement getPaneAccecoryDetails;


			@FindBy(xpath = "//h2[contains(text(),'Your financing balance will be $0 on:') or contains(text(),'Votre solde de financement sera de 0 $ le :')]")
			WebElement modalHeaderYourFinBalanceWillBeZeroOn;

			@FindBy(xpath = "//span[contains(text(),'Accessory purchase date:') or contains(text(),'Date d’achat de l’accessoire :')]/following-sibling::span")
			WebElement modalAccessoryPurchaseDate;

			@FindBy(xpath = "//span[text()='Agreement ID:' or text()='Identifiant de l’entente :']/following-sibling::span")
			WebElement modalAgreementID;

			@FindBy(xpath = "//span[text()='Financing term:' or text()='Durée du financement :']/following-sibling::span")
			WebElement modalFinTerm;

			@FindBy(xpath = "//rss-accessories-details-modal//span[text()='Total monthly financing payment: ' or text()='Total mensuel du paiement pour le financement : ']/following-sibling::ds-price")
			WebElement modalTotalMonthlyFin;

			@FindBy(xpath = "//rss-accessories-details-modal//span[text()='Monthly financing payment: ' or text()='Paiement mensuel pour le financement : ']/following-sibling::ds-price")
			WebElement modalMonthlyFinPayment;

			@FindBy(xpath = "//rss-accessories-details-modal//span[text()='Monthly financed taxes: ' or text()='Taxes mensuelles sur le financement : ']/following-sibling::ds-price")
			WebElement modalFinTaxes;

			@FindBy(xpath = "//rss-accessories-details-modal//span[text()='Total remaining financing balance: ' or text()='Solde total du financement : ']/following-sibling::ds-price")
			WebElement modalTotalRemFinBal;

			@FindBy(xpath = "//rss-accessories-details-modal//span[text()='Remaining financing balance: ' or text()='Solde restant du financement : ']/following-sibling::ds-price")
			WebElement modalRemFinBal;

			@FindBy(xpath = "//rss-accessories-details-modal//span[text()='Remaining financed taxes: ' or text()='Taxes restantes du financement : ']/following-sibling::ds-price")
			WebElement modalRemFinTax;

			public boolean isAccessoryPageOpen(){
				return getReusableActionsInstance().isElementVisible(headerFinancedAccessories);

			}


			public boolean validateTotalMonthlyFinancingPayment(){
				String strValue =getReusableActionsInstance().getWhenReady(lblTotalMonthlyFinPayment).getText().trim();
				strValue = CurrencyHelpers.removeLineBreaksFromString(strValue);
				strValue
				return ;
			}

	public boolean validateMonthlyFinancingPayment(){
		return false;
	}

	public boolean validateMonthlyFinancedTaxes(){
		return false;
	}

	public boolean validateTotalRemainingFinancingBalance(){
		return false;
	}

	public boolean validateRemainingFinancingBalance(){
		return false;
	}

	public boolean validateRemainingFinancedTaxes(){
		return false;
	}


	public boolean validateFinancingEnding(){
		return false;
	}
	public boolean validateStarted(){
		return false;
	}
	public boolean validateAgreementID(){
		return false;
	}
	public boolean validateFinancingTerm(){
		return false;
	}
	public boolean validateMonthlyFinancingPaymentOfAnAgreement(){
		return false;
	}
	public boolean validateBalanceRemaining(){
		return false;
	}


	public boolean validateYourFinancingBalanceWillBeZeroOn(){
		return false;
	}
	public boolean clickCloseModal(){
		return false;
	}
	public boolean validateAccessoryPurchaseDate(){
		return false;
	}
	public boolean validateAgreementIDOndetailsModal(){
		return false;
	}
	public boolean validateFinancingTermOndetailsModal(){
		return false;
	}
	public boolean validateTotalMonthlyFinancingPaymentOndetailsModal(){
		return false;
	}
	public boolean validateMonthlyFinancingPaymentOndetailsModal(){
		return false;
	}
	public boolean validateMonthlyFinancedTaxesOndetailsModal(){
		return false;
	}
	public boolean validateTotalRemainingFinancingBalanceOndetailsModal(){
		return false;
	}
	public boolean validateRemainingFinancingBalanceOndetailsModal(){
		return false;
	}
	public boolean validateRemainingFinancedTaxesOndetailsModal(){
		return false;
	}


}