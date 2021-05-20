package com.rogers.yaml.pojo;

public class ContactData {
	public ContactDetails contactDetails;
	public String planEng;
	public String planFr;
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
	 * @param Plan the Plan in English to set
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
}
