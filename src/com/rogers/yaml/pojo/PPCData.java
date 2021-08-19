package com.rogers.yaml.pojo;

public class PPCData {

	private String username;
	private String password;
	private String ctn;
	private String newPlanType;
	private String newPlanCategory;
	private String contactID;
	private String banNo;
	private String dataOptionIndex;
	private String talkOptionIndex;
	private String ctn2;
	
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
	 * @return index value of price plan
	 */
	public String getDataOptionIndex() {
		return dataOptionIndex;
	}
	/**
	 * @param dataOptionIndex data option index to set
	 */
	public void setDataOptionIndex(String dataOptionIndex) {
		this.dataOptionIndex = dataOptionIndex;
	}
	/**
	 * @return index value of talk option
	 */
	public String getTalkOptionIndex() {
		return talkOptionIndex;
	}
	/**
	 * @param talkOptionIndex talk option index to set
	 */
	public void setTalkOptionIndex(String talkOptionIndex) {
		this.talkOptionIndex = talkOptionIndex;
	}
	/**
	 * @return string value of CTN2
	 */
	public String getCtn2() {
		return ctn2;
	}
	/**
	 * @param ctn2 value to set
	 */
	public void setCtn2(String ctn2) {
		this.ctn2 = ctn2;
	}



}
