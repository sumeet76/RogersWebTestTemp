package com.rogers.yaml.pojo;

public class AALData {

	private String newDevice;
	private String newPlanCategory;
	private String username;
	private String password;
	private String ctnCity;
	private String ctn;
	private String postalCode;
	private String sharingType;
	private String deviceColor;
	private String deviceCostIndex;
	private String dataOptionIndex;
	private String talkOptionIndex;
	private String ccNumberOTP;
	private String expiryDateOTP;
	private String nameOnCard;
	private String cvvNumber;
	private String riskClass;
	private String ban;
	private String promoCode;
	private String dpIMEI;
	private String dpDeviceStorage;
	private String dpDeviceColor;
	private String passcode;
	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode of the customer
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the ctn
	 */
	public String getCtn() {
		return ctn;
	}
	
	/**
	 * @param ctn of the existing device
	 */
	public void setCtn(String ctn) {
		this.ctn = ctn;
	}
	/**
	 * @return the newDevice
	 */
	public String getNewDevice() {
		return newDevice;
	}
	/**
	 * @param newDevice the newDevice to set
	 */
	public void setNewDevice(String newDevice) {
		this.newDevice = newDevice;
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
	 * @return the ctnCity
	 */
	public String getCtnCity() {
		return ctnCity;
	}
	/**
	 * @param ctnCity the ctnCity to set
	 */
	public void setCtnCity(String ctnCity) {
		this.ctnCity = ctnCity;
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
	/**
	 * @return the devieColor
	 */
	public String getDeviceColor() {
		return deviceColor;
	}
	/**
	 * @param deviceColor the deviceColor to set
	 */
	public void setDeviceColor(String deviceColor) {
		this.deviceColor = deviceColor;
	}
	/**
	 * @return the deviceCostIndex
	 */
	public String getDeviceCostIndex() {
		return deviceCostIndex;
	}
	/**
	 * @param deviceCostIndex the deviceCostIndex to set
	 */
	public void setDeviceCostIndex(String deviceCostIndex) {
		this.deviceCostIndex = deviceCostIndex;
	}
	/**
	 * @return the dataOptionIndex
	 */
	public String getDataOptionIndex() {
		return dataOptionIndex;
	}
	/**
	 * @param dataOptionIndex the dataOptionIndex to set
	 */
	public void setdataOptionIndex(String dataOptionIndex) {
		this.dataOptionIndex = dataOptionIndex;
	}
	/**
	 * @return the talkOptionIndex
	 */
	public String getTalkOptionIndex() {
		return talkOptionIndex;
	}
	/**
	 * @param talkOptionIndex the dataOptionIndex to set
	 */
	public void setTalkOptionIndex(String talkOptionIndex) {
		this.talkOptionIndex = talkOptionIndex;
	}
	/**
	 * @return the ccNumberOTP
	 */
	public String getCcNumberOTP() {
		return ccNumberOTP;
	}
	/**
	 * @param ccNumberOTP the ccNumberOTP to set
	 */
	public void setCcNumberOTP(String ccNumberOTP) {
		this.ccNumberOTP = ccNumberOTP;
	}
	/**
	 * @return the expiryDateOTP
	 */
	public String getExpiryDateOTP() {
		return expiryDateOTP;
	}
	/**
	 * @param expiryDateOTP the ccNumberOTP to set
	 */
	public void setExpiryDateOTP(String expiryDateOTP) {
		this.expiryDateOTP = expiryDateOTP;
	}
	/**
	 * @return the nameOnCard
	 */
	public String getNameOnCard() {
		return nameOnCard;
	}
	/**
	 * @param nameOnCard the nameOnCard to set
	 */
	public void setNameOnCard(String nameOnCard) { this.nameOnCard = nameOnCard; }
	/**
	 * @return the cvvNumber
	 */
	public String getCvvNumber() { return cvvNumber; }
	/**
	 * @param cvvNumber the cvvNumber to set
	 */
	public void setCvvNumber(String cvvNumber) { this.cvvNumber = cvvNumber; }
	/**
	 * @return the risk class
	 */
	public String getRiskClass() {
		return riskClass;
	}
	/**
	 * @param riskClass the risk class value to set
	 */
	public void setRiskClass(String riskClass) {
		this.riskClass = riskClass;
	}
	/**
	 * @return ban
	 */
	public String getBan() {
		return ban;
	}
	/**
	 * @param ban to select
	 */
	public void setBan(String ban) {
		this.ban = ban;
	}
	/**
	 * @return the Promo Code
	 */
	public String getPromoCode() {return promoCode;}
	/**
	 * @param promoCode Promocode to set
	 */
	public void setPromoCode(String promoCode){
		this.promoCode = promoCode;
	}
	/**
	 * @return the DP IMEI from yaml
	 */
	public String getDpIMEI() {
		return dpIMEI;
	}
	/**
	 * @param dpIMEI DP IMEI to set
	 */
	public void setDpIMEI(String dpIMEI) {
		this.dpIMEI = dpIMEI;
	}
	/**
	 * @return the DP Device Storage from yaml
	 */
	public String getDpDeviceStorage() {
		return dpDeviceStorage;
	}
	/**
	 * @param dpDeviceStorage DP IMEI to set
	 */
	public void setDpDeviceStorage(String dpDeviceStorage) {
		this.dpDeviceStorage = dpDeviceStorage;
	}
	/**
	 * @return the DP Device Color from yaml
	 */
	public String getDpDeviceColor() {
		return dpDeviceColor;
	}
	/**
	 * @param dpDeviceColor DP IMEI to set
	 */
	public void setDpDeviceColor(String dpDeviceColor) {
		this.dpDeviceColor = dpDeviceColor;
	}
	/**
	 * @return the passcode from yaml
	 */
	public String getPasscode() {
		return passcode;
	}
	/**
	 * @param passcode to set
	 */
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
}
