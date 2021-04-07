package com.rogers.yaml.pojo;

public class AALOVData {

	private String username;
	private String password;
	private String ctn;
	private String newPlanType;
	private String newPlanCategory;
	private String contactID;
	private String banNo;
	private String customerRiskLevel;
	private String sharingType;

	public String getBanNo() {
		return banNo;
	}
	public void setBanNo(String banNo) {
		this.banNo = banNo;
	}
	public String getContactID() {
		return contactID;
	}
	public void setContactID(String contactID) {
		this.contactID = contactID;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the ctn
	 */
	public String getCtn() {
		return ctn;
	}
	/**
	 * @param ctn the ctn to set
	 */
	public void setCtn(String ctn) {
		this.ctn = ctn;
	}
	/**
	 * @return the newPlanType
	 */
	public String getNewPlanType() {
		return newPlanType;
	}
	/**
	 * @param newPlanType the newPlanType to set
	 */
	public void setNewPlanType(String newPlanType) {
		this.newPlanType = newPlanType;
	}
	/**
	 * @return the newPlanCategory
	 */
	public String getNewPlanCategory() {
		return newPlanCategory;
	}
	/**
	 * @param newPlanCategory the newPlanCategory to set
	 */
	public void setNewPlanCategory(String newPlanCategory) {
		this.newPlanCategory = newPlanCategory;
	}
	/**
	 * @return the customerRiskLevel
	 */
	public String getCustomerRiskLevel() {
		return customerRiskLevel;
	}
	/**
	 * @param customerRiskLevel the newPlanCategory to set
	 */
	public void setCustomerRiskLevel(String customerRiskLevel) {
		this.customerRiskLevel = customerRiskLevel;
	}
	/**
	 * @return the sharingType
	 */
	public String getSharingType() {
		return sharingType;
	}
	/**
	 * @param sharingType the sharingType to set
	 */
	public void setSharingType(String sharingType) {
		this.sharingType = sharingType;
	}

}
