package com.rogers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersBuyPage extends BasePageClass {

	public RogersBuyPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "(//button[@class='change-button ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -secondary -large ng-star-inserted'])[1]")
	WebElement btnIgniteInternetSpeed;	
	//button[@translate='global.modals.serviceability.changeTVPackage']
	
	@FindBy(xpath = "(//button[@class='change-button ds-button ds-corners ds-pointer text-center mw-100 d-inline-block -secondary -large ng-star-inserted'])[3]")
	WebElement btnExchangeFlexChannel;	
	//button[@translate='global.modals.serviceability.changeTVPackage']
	
	@FindBy(xpath = "//label[@for='existingActiveAddress-1']")
	WebElement rdoSecondAddress;

	// tv#/packages
	@FindBy(xpath = "//a[@data-smartserviceability-config='{ \"lob\": \"dtv\", \"data\": { \"package\": \"QDPA\" } }']")
	WebElement lnkDigitalTVPackage;

	@FindBy(id = "addressLookupField-0")
	WebElement txtAddressLookup;

	@FindBy(id = "addressLookupSubmit-0")
	WebElement btnAddressLookupSubmit;

	@FindBy(xpath = "//div[@class='pcaitem pcafirstitem pcalastitem pcaselected']")
	WebElement linkOption;
	
	
	@FindBy(xpath = "//i[@class='rui-icon-success']")
	WebElement infoDTVAvailabilitySuccess;

	// rogers-internet
	@FindBy(xpath = "//a[@class='contact-online-link ways-to-change-cta']")
	WebElement btnBuyOnline;
	
	@FindBy(xpath = "(//div//a[@class='rogers-btn-solid'])[4]")
	WebElement btnControlPackage;
	
		
	/**
	 * To select the solaris bundle package
	 * @param strBundleName is the desired solaris package name of the Rogers's customer
	 * @author chinnarao.vattam 
	 */
	public void selectSolarisBundlePackage(String strBundleName) {		
		By bundleNameLocator = By.xpath("//span[contains(text(),'Select') or contains(text(),' Populaire')]/ancestor::div[@class='solaris-carousel-item']//ins[@translate='global.cta.addToCart']");
		reusableActions.clickWhenReady(bundleNameLocator, 60); 
	}
	
	/**
	 * Select the solaris bundle package
	 * @param strBundleName Bundle Name
	 * @author Mirza.Kamran
	 */
	public void selectSolarisBundlePackage1(String strBundleName) {
		
		By bundleNameLocator = By.xpath("//span[contains(text(),'"+ strBundleName+ "')]/ancestor::div[@class='solaris-carousel-item']//ins[@translate='global.cta.addToCart']");
		reusableActions.clickWhenReady(bundleNameLocator, 60);
	}
	//or contains(text(),'Sélection')

	/**
	 * To select the Internet Speed from Ignite bundle package
	 * @author chinnarao.vattam 
	 */
	public void clkIgniteInternetSpeed() {
			reusableActions.clickWhenReady(btnIgniteInternetSpeed, 40);
	}

	/**
	 * To select the Exchange Flex Channel from Ignite bundle package
	 * @author chinnarao.vattam 
	 */
	public void clkExchangeFlexChannel() {
		reusableActions.clickWhenReady(btnExchangeFlexChannel, 60);
		//for Prod issue, click the same link second time
		reusableActions.clickIfAvailable(btnExchangeFlexChannel, 60);
	}
	
	
	/**
	 * To select the DTV Package from the shop menu
	 * @author chinnarao.vattam 
	 */
	public void clkDTVPackage() {				
		reusableActions.clickWhenReady(lnkDigitalTVPackage, 30);		
	}
	
/**
 * To set the Lookup address on the service ability Lookup page
 * @param strAddress is the address of the service required locality
 * @author chinnarao.vattam
 */
	public void setAddressLookup(String strAddress) {
		reusableActions.getWhenReady(txtAddressLookup,20).clear();
		reusableActions.getWhenReady(txtAddressLookup, 20).sendKeys(strAddress);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.TAB);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ARROW_DOWN);
		reusableActions.getWhenVisible(txtAddressLookup).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Click the Lookup Submit button to check service availability 
	 * @author chinnarao.vattam
	 */
	public void clkAddressLookupSubmit() {
		reusableActions.clickWhenReady(btnAddressLookupSubmit, 90);
	
	}

	/**
	 * To verify the  DTV Availability Success popup after the address lockup
	 * @return true if the Availability Success popup is displayed; else false
	 * @author chinnarao.vattam
	 */
	public boolean verifyDTVAvailabilitySuccess() {
		return reusableActions.isElementVisible(infoDTVAvailabilitySuccess, 90);
	}

	/**
	 * To select the Internet package on the Internet buy page
	 * @param strInternetBundle internet bundle to be select to buy
	 * @author chinnarao.vattam 
	 */
	public void selectInternetPackage(String strInternetBundle) {
		WebElement  bundleLocator = (WebElement)driver.findElement(By.xpath("//p[@class='rate-card-data desktop-rate-details']/strong[contains(text(),'"+ strInternetBundle+ "')]/ancestor::div[@id='main-box']//a[@class='btn ways-to-buy']"));
		reusableActions.waitForElementVisibility(bundleLocator,30);
		reusableActions.executeJavaScriptClick(bundleLocator);	
	}	
	
	/**
	 * To select the Home Monitering package on the Internet buy page
	 * @param strHomeMoniteringEn Home Monitering bundle to be select to buy
	 * @param strHomeMoniteringFr Home Monitering bundle to be select to buy
	 * @author chinnarao.vattam 
	 */
	public void selectHomeMoniteringPackage(String strHomeMoniteringEn, String strHomeMoniteringFr ) {
		WebElement  rhmLocator = (WebElement)driver.findElement(By.xpath("//h3[contains(text(),'"+strHomeMoniteringEn+ "') or contains(text(),'"+ strHomeMoniteringFr+ "')]/ancestor::div[@class='package-tile']//div[@class='how-to-get-it']//a[@class='rogers-btn-solid']"));
		reusableActions.waitForElementVisibility(rhmLocator,30);
		reusableActions.executeJavaScriptClick(rhmLocator);	
	}
	
	/**
	 * Click on BuyOnline button on buy options Popup
	 * @author chinnarao.vattam 
	 */
	public void clkBuyOnline() {
		reusableActions.clickWhenReady(btnBuyOnline, 30);
	}

	}
