package com.rogers.oneview.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinancedAccessoriesPage extends BasePageClass {

	public FinancedAccessoriesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[contains(text(), ' See more details ') or contains(text(), ' Voir plus de détails ')]")
	WebElement seeMoreDetailsButton;

	//Modal
	@FindBy(xpath = "//p[@class='ds-modal__heading text-title-3 mb-24']")
	WebElement modalHeader;

	@FindBy(xpath = "//span[contains(text(), 'Accessory purchase date:') or contains(text(), ' Voir plus de détails ')]/following-sibling::span")
	WebElement accessoryPurchaseDate;

	@FindBy(xpath = "//span[contains(text(), 'Agreement ID:') or contains(text(), ' Voir plus de détails ')]/following-sibling::span")
	WebElement agreementID;

	@FindBy(xpath = "//span[contains(text(), 'Financing term:') or contains(text(), ' Voir plus de détails ')]/following-sibling::span")
	WebElement financingTerm;

	@FindBy(xpath = "(//span[contains(text(), 'Total monthly financing payment: ') or contains(text(), ' Voir plus de détails ')])[2]/following::ds-price/div")
	WebElement totalMonthlyFinancingPayment;

	@FindBy(xpath = "(//span[contains(text(), 'Monthly financing payment: ') or contains(text(), ' Voir plus de détails ')])[3]/following::ds-price/div")
	WebElement monthlyFinancingPayment;

	@FindBy(xpath = "(//span[contains(text(), 'Monthly financed taxes: ') or contains(text(), ' Voir plus de détails ')])[2]/following::ds-price/div")
	WebElement monthlyFinancedTaxes;

	@FindBy(xpath = "(//span[contains(text(), 'Total remaining financing balance: ') or contains(text(), ' Voir plus de détails ')])[2]/following::ds-price/div")
	WebElement totalRemainingFinancingBalance;

	@FindBy(xpath = "(//span[contains(text(), 'Remaining financing balance: ') or contains(text(), ' Voir plus de détails ')])[2]/following::ds-price/div")
	WebElement remainingFinancingBalance;

	@FindBy(xpath = "(//span[contains(text(), 'Remaining financed taxes: ') or contains(text(), ' Voir plus de détails ')])[2]/following::ds-price/div")
	WebElement remainingFinancedTaxes;

	@FindBy(xpath = "//button[@title='Close']")
	WebElement closeModal;

	@FindBy(xpath = "//rss-accessories-details-modal[@class='ng-star-inserted']")
	WebElement modalWindow;

	/**
	 * Verifies if the modal Header is visible
	 * @return true if present ; else false
	 * @author Rohit.Kumar
	 */
	public boolean verifyFinancedAccessoriesIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(modalHeader);
	}

	/**
	 * Verifies if the modal Header is visible
	 * @return true if present ; else false
	 * @author Rohit.Kumar
	 */
	public boolean verifyAccessoryPurchaseIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(accessoryPurchaseDate);
	}


	/**
	 * Verifies if the Agreement ID is visible
	 * @return true if present ; else false
	 * @author Rohit.Kumar
	 */
	public boolean verifyAgreementIDIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(agreementID);
	}

	/**
	 * Verifies if the Financing Term is visible
	 * @return true if present ; else false
	 * @author Rohit.Kumar
	 */
	public boolean verifyFinancingTermIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(financingTerm);
	}


	/**
	 * Verifies Total Monthly Financing Payment is displayed
	 * @return true if present ; else false
	 * @author Rohit.Kumar
	 */
	public boolean verifyTotalMonthlyFinancingPaymentIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(totalMonthlyFinancingPayment);
	}


	/**
	 * Verifies Monthly Financing Payment is displayed
	 * @return true if present ; else false
	 * @author Rohit.Kumar
	 */
	public boolean verifyMonthlyFinancingPaymentIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(monthlyFinancingPayment);
	}

	/**
	 * Verifies Monthly Financed Taxes is displayed
	 * @return true if present ; else false
	 * @author Rohit.Kumar
	 */
	public boolean verifyMonthlyFinancedTaxesIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(monthlyFinancedTaxes);
	}


	/**
	 * Verifies Monthly Financed Taxes is displayed
	 * @return true if present ; else false
	 * @author Rohit.Kumar
	 */
	public boolean verifyTotalRemainingFinancingBalanceIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(totalRemainingFinancingBalance);
	}

	/**
	 * Verifies Remaining Financing Balance is displayed
	 * @return true if present ; else false
	 * @author Rohit.Kumar
	 */
	public boolean verifyRemainingFinancingBalanceIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(remainingFinancingBalance);
	}

	/**
	 * Verifies Remaining Financed Taxes is displayed
	 * @return true if present ; else false
	 * @author Rohit.Kumar
	 */
	public boolean verifyRemainingFinancedTaxesIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(remainingFinancedTaxes);
	}

	/**
	 * Verifies if the Modal Window is displayed
	 * @return true if present ; else false
	 * @author Rohit.Kumar
	 */
	public boolean verifyModalWindowIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(modalWindow);
	}


	/**
	 * closes the modal
	 * @author Rohit.Kumar
	 */
	public void clkCloseModal() {
		getReusableActionsInstance().getWhenReady(closeModal).click();
	}

	/**
	 * click See more details modal
	 * @author Rohit.Kumar
	 */
	public void clkSeeMoreDetailsModal() {
		getReusableActionsInstance().getWhenReady(seeMoreDetailsButton).click();
	}



}

