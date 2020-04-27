package com.rogers.yaml.pojo;

public class AccountData {

	private String username;
	private String password;
	private String newUsername;
	private String newpassword;
	public AccountDetails accountDetails;
	public String name;
	private String dealerCode;
	

	/**
	 * @return the accountDetails
	 */
	public AccountDetails getAccountDetails() {
		return accountDetails;
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
	 * @return the dealerCode
	 */
	public String getDealercode() {
		return dealerCode;
	}
	/**
	 * @param dealerCode the dealerCode to set
	 */
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}
	/**
	 * @return the newpassword
	 */
	public String getNewpassword() {
		return newpassword;
	}
	/**
	 * @param newpassword the newpassword to set
	 */
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	/**
	 * @return the newUsername
	 */
	public String getNewUsername() {
		return newUsername;
	}
	/**
	 * @param newUsername the newUsername to set
	 */
	public void setNewUsername(String newUsername) {
		this.newUsername = newUsername;
	}

	/**
	 * @return the accountDetails
	 */
	public AccountDetails getCableAccountDetails() {
		return accountDetails;
	}
	/**
	 * @param accountDetails the accountDetails to set
	 */
	public void setCableAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
