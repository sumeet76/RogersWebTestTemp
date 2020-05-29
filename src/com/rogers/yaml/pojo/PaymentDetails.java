package com.rogers.yaml.pojo;

public class PaymentDetails {
	
	private CreditCardDetails creditCardDetails;
	private BankDetails bankDetails;
	/**
	 * @return the creditCardDetails
	 */
	public CreditCardDetails getCreditCardDetails() {
		return creditCardDetails;
	}
	/**
	 * @param creditCardDetails the creditCardDetails to set
	 */
	public void setCreditCardDetails(CreditCardDetails creditCardDetails) {
		this.creditCardDetails = creditCardDetails;
	}
	/**
	 * @return the bankDetails
	 */
	public BankDetails getBankDetails() {
		return bankDetails;
	}
	/**
	 * @param bankDetails the bankDetails to set
	 */
	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}

	public CreditCardDetails getCablePaymentDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
