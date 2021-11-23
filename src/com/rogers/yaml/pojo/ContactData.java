package com.rogers.yaml.pojo;

public class ContactData {
	public ContactDetails contactDetails;
	public String planEng;
	public String planEngISS;
	public String planEngSAI;
	public String planFr;
	public CreditCardDetails creditCardDetails;
	public String coupon;
	public TokenDetails tokenDetails;

	/** @return the tokenDetails */
	public TokenDetails getTokenDetails() {
		return tokenDetails;}
	/** @param tokenDetails the tokenDetails to set */
	public void setTokenDetails(TokenDetails tokenDetails) {
		this.tokenDetails = tokenDetails;}

	/**
	 * @return the plan in English for SAI flow
	 */
	public String getPlanEngSAI() {
		return planEngSAI;
	}
	/**
	 * @param planEngSAI the Plan in English to set
	 */
	public void setPlanEngSAI(String planEngSAI) {
		this.planEngSAI = planEngSAI;
	}

	/**
	 * @return the plan in English for ISS flow
	 */
	public String getPlanEngISS() {
		return planEngISS;
	}
	/**
	 * @param planEngISS the Plan in English to set
	 */
	public void setPlanEngISS(String planEngISS) {
		this.planEngISS = planEngISS;
	}

	/**
	 * @return the cardDetails
	 */
	public CreditCardDetails getCreditCardDetails() {
		return creditCardDetails;
	}
	/**
	 * @param creditCardDetails the credit card Details to set
	 */
	public void setCreditCardDetails(CreditCardDetails creditCardDetails) {
		this.creditCardDetails = creditCardDetails;
	}

	/**
	 * @return the contactDetails
	 */
	public ContactDetails getcontactDetails() {
		return contactDetails;
	}
	/**
	 * @param contactDetails the contactDetails to set
	 */
	public void setaccountDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}
	/**
	 * @return the plan in English
	 */
	public String getplanEng() {
		return planEng;
	}
	/**
	 * @param planEng the Plan in English to set
	 */
	public void setplanEng(String planEng) {
		this.planEng = planEng;
	}
	/**
	 * @return the plan in French
	 */
	public String getplanFr() {
		return planFr;
	}
	/**
	 * @param planFr the Plan in French to set
	 */
	public void setplanFr(String planFr) {
		this.planFr = planFr;
	}

	/**
	 * get coupon code
	 */
	public String getCoupon() {
		return coupon;
	}
	/**
	 * @param coupon code to apply discount on a plan
	 */
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}


}
