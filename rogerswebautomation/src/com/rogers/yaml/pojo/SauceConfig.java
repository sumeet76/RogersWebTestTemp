package com.rogers.yaml.pojo;

public class SauceConfig {
		
	private String sauceUser;
	private String sauceKey;
	private String browserName;
	private String browserVersion;
	private String platform;
	/**
	 * @return the sauceUser
	 */
	public String getSauceUser() {
		return sauceUser;
	}
	/**
	 * @param sauceUser the sauceUser to set
	 */
	public void setSauceUser(String sauceUser) {
		this.sauceUser = sauceUser;
	}
	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}
	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	/**
	 * @return the browserVersion
	 */
	public String getBrowserVersion() {
		return browserVersion;
	}
	/**
	 * @param browserVersion the browserVersion to set
	 */
	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}
	/**
	 * @return the sauceKey
	 */
	public String getSauceKey() {
		return sauceKey;
	}
	/**
	 * @param sauceKey the sauceKey to set
	 */
	public void setSauceKey(String sauceKey) {
		this.sauceKey = sauceKey;
	}
	/**
	 * @return the browserName
	 */
	public String getBrowserName() {
		return browserName;
	}
	/**
	 * @param browserName the browserName to set
	 */
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	
	
}
