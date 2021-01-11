package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class RogersHomePageServiceability extends BasePageClass {

	public RogersHomePageServiceability(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "//span[contains(text(),' See available bundles ')]")
	WebElement btnSeeAvailableBundles;


	@FindBy(xpath = "//span[contains(text(),'Check address')]")
	WebElement btnCheckServiceability;

	@FindBy(xpath = "//div[contains(@class,'inputContainer')]")
	WebElement elementAddress;

	@FindBy(xpath = "//input[contains(@class,'ds-input')]")
	WebElement inputBoxAddress;


	/**
	 * Click the Available Bundles button
	 *
	 * @author Rajat.Sharma
	 */
	public void clkAvailableBundles() {
		getReusableActionsInstance().getWhenReady(btnSeeAvailableBundles, 30).click();
	}


	/**
	 * Click the check serviceability button on home page
	 *
	 * @author Rajat.Sharma
	 */
	public void clkCheckServiceability() {
		getReusableActionsInstance().getWhenVisible(btnCheckServiceability, 30).click();
	}


	/**
	 * To set the address on the serviceability page
	 *
	 * @param strAddress is the address of the service required locality
	 * @author Rajat.Sharma
	 */
	public void setAddress(String strAddress) {
		getReusableActionsInstance().getWhenReady(elementAddress, 60).click();
		getReusableActionsInstance().getWhenReady(inputBoxAddress, 10).clear();
		getReusableActionsInstance().getWhenReady(inputBoxAddress, 10).sendKeys(strAddress);
		String strAddressResultXpath = "//ngb-highlight[contains(@ng-reflect-result,'') and contains(text(),'address')]";
		try{
			getReusableActionsInstance().getWhenReady(By.xpath(strAddressResultXpath.replace("address", strAddress.trim())), 10).click();

		}catch (Exception e){
			getReusableActionsInstance().getWhenReady(By.xpath("//ngb-highlight[contains(@ng-reflect-result,'')]"), 10).click();

		}

	}


	/**
	 * To verify the header value for  the serviceability page
	 *
	 * @param serviceabilityCode is the address serviceability code which will determine the appropriate header message
	 * @author Rajat.Sharma
	 */
	public boolean verifyServicebiltyHeader(String serviceabilityCode) {
		boolean headerFlag= false;
		String strServiceabilityHeader = "//h3/descendant::span[contains(text(),'headerText')]";
		switch (serviceabilityCode) {
			case "D":
				headerFlag=getReusableActionsInstance().isElementVisible(By.xpath(strServiceabilityHeader.replace("headerText", "Address found")),20);
				break;
			case "N":
				headerFlag=getReusableActionsInstance().isElementVisible(By.xpath(strServiceabilityHeader.replace("headerText", "Address not serviceable at this time")),20);
				break;
			case "E":
			case "P":
			case "S":
				headerFlag=getReusableActionsInstance().isElementVisible(By.xpath("//h2[contains(text(),'Bundles')]"),20);
				break;

		}

		return headerFlag;

	}


	/**
	 * To verify the subhead value for  the serviceability page
	 *
	 * @param serviceabilityCode is the address serviceability code which will determine the appropriate header message
	 * @author Rajat.Sharma
	 */
	public boolean verifyServicebiltySubhead(String serviceabilityCode) {
		boolean messageFlag1= false;
		boolean messageFlag2= false;
		String strServiceabilityHeader = "//h3/descendant::span[contains(text(),'headerText')]";
		switch (serviceabilityCode) {
			case "D":
				messageFlag1=getReusableActionsInstance().isElementVisible(By.xpath("//p[starts-with(text(),'Good news! We found')]"),10);
				if(messageFlag1)
					messageFlag2=getReusableActionsInstance().isElementVisible(By.xpath("//p[contains(text(),'Please contact us to get started on the Rogers Ignite service you’re interested in.')]"),10);

				break;
			case "N":
				messageFlag1=getReusableActionsInstance().isElementVisible(By.xpath("//p[starts-with(text(),'We found')]"),10);
				if(messageFlag1)
					messageFlag2=getReusableActionsInstance().isElementVisible(By.xpath("//p[contains(text(),'in our system, which means the Rogers service you’re looking for will be available at this address in the near future.')]"),10);

				break;


		}

		return messageFlag2;

	}


}

