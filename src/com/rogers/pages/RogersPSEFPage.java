package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import com.rogers.test.helpers.CurrencyHelpers;
import com.rogers.test.helpers.DateHelpersFunctions;
import javafx.collections.transformation.SortedList;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class RogersPSEFPage extends BasePageClass {


	private By btnUsageAndServicesDropDown;
	private By lblSMPpromotionEnded;
	private By lblSMPpromotionEnds;

	public RogersPSEFPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h3/following-sibling::rss-subscribed-ctn-item//span[@class='vas-subscriber-name']")
	List<WebElement> lblPendingTrialCTNName;

	@FindBy(xpath = "//span[text()='The following subscriptions are still waiting to be activated on Disney+' or text()='Les abonnements suivants sont en attente d’activation sur Disney+']/ancestor::h3/parent::div//span[@class='vas-subscriber-number']")
	List<WebElement> lblPendingTrialCTNNumber;

	@FindBy(xpath = "//h3/preceding-sibling::rss-subscribed-ctn-item//span[@class='vas-subscriber-name']")
	List<WebElement> lblActiveTrialCTName;


	@FindBy(xpath = "//span[(contains(text(),'Promotion started') or contains(text(),'La promotion a commencé le')) and not(contains(text(),'Les abonnements suivants sont en attente d’activation sur Disney+') or contains(text(),'The following subscriptions are still waiting to be activated on Disney+') )]/ancestor::rss-subscribed-ctn-item//span[@class='vas-subscriber-number']")
	List<WebElement> lblActiveTrialCTNNumber;

	@FindBy(xpath = "//a//span[contains(@class,'ds-button__copy') and (contains(text(),'Sign up') or contains(text(),'S’abonner'))]")
	WebElement btnSubscriptionSignUp;

	@FindAll({
			@FindBy(xpath = "//h2[text()='Terms & Conditions' or text()='']"),
			@FindBy(xpath = "//h1[@class='signup-page-title']")})
	WebElement headerTnC;

	@FindBy(xpath = "//ds-checkbox")
	WebElement chkTnC;



	@FindAll({
	@FindBy(xpath = "//span[@class='ds-icon rds-icon-tv']"),
	@FindBy(xpath = "//span[@class='ds-icon d-inline-flex rds-icon-tv']")})
	WebElement btnSmartStream;

	@FindAll({
        @FindBy(xpath = "//rss-subscription-detail//a//span[contains(text(),'Internet')]"),
        @FindBy(xpath = "//span[contains(@class,'rui-icon-internet icon')]/ancestor::div[@role='button']")})
	WebElement btnLegacyInternetBadge;
	
		//Subscribe ctn
	//span[text()=' 416 817-3435 ']/ancestor::rss-subscribed-ctn-item//button[@title='Activate your Disney+ subscription now']
    //span[text()=' 416 817-3435 ']/ancestor::rss-subscribed-ctn-item//a[contains(@aria-label,'Cancel the Disney+ subscription for ')]


	//subscribe
//span[@class="vas-subscriber-number" and contains(text(),'416 817-3428')]/ancestor::rss-subscriber-info/parent::div/preceding-sibling::ds-checkbox



	/**
	 * clicks the drop and and checks to see if the account show in Menu UsageAndService drop down on account overview page.
	 * @param strLast4DigAcctNum string account number
	 * @return true if element visible else false
	 * @author Rohit.Kumar
	 */
	public boolean checkIfAccountIsShowInDropDown(String strLast4DigAcctNum) {
		getReusableActionsInstance().getWhenReady(btnUsageAndServicesDropDown).click();
		return getReusableActionsInstance().isElementVisible(
				(By.xpath("//span[contains(@data-translate-values,'" + strLast4DigAcctNum + "') or contains(text(),'" + strLast4DigAcctNum + "')]")),
				10);
	}

	public boolean verifyIfEffectiveCancelDateForSubscriptionISImmediate(String test_language) {
		String cancelledEndDate= getReusableActionsInstance().getWhenReady(lblSMPpromotionEnded).getText();
		cancelledEndDate = cancelledEndDate.split("ended")[1].trim();
		DateHelpersFunctions.isValidDAte(cancelledEndDate);
		Locale locale=Locale.CANADA;;
		String datePattern = "MMM. d, u";
		ZoneId defaultZoneId = ZoneId.systemDefault();
		if(test_language=="en")
		{
			locale =Locale.CANADA;
			datePattern = "MMM. d, u";
		}else if(test_language=="fr"){
			locale =Locale.FRENCH;
			datePattern = "dd MMM yyyy";
		}
		LocalDate cancelEffectiveDate = parseDate(cancelledEndDate, datePattern,locale);

		if(isDateEqulas(Date.from(cancelEffectiveDate.atStartOfDay(defaultZoneId).toInstant()),Date.from(getTodaysDate().atStartOfDay(defaultZoneId).toInstant())))
		{
			return true;
		}
		return false;
	}


	public boolean verifyIfEffectiveCancelDateForSubscriptionIsDefferred(String test_language) {
		String cancelledEndDate= getReusableActionsInstance().getWhenReady(lblSMPpromotionEnds).getText();
		cancelledEndDate = cancelledEndDate.split("ends |fin le ")[1].trim();
		Locale locale=Locale.CANADA;;
		String datePattern = "MMM. d, u";
		ZoneId defaultZoneId = ZoneId.systemDefault();
		if(test_language=="en")
		{
			locale =Locale.CANADA;
			datePattern = "MMM. d, u";
		}else if(test_language=="fr"){
			locale =Locale.FRENCH;
			datePattern = "dd MMM yyyy";
		}
		LocalDate cancelEffectiveDate = parseDate(cancelledEndDate, datePattern,locale);

		if(isDateGreaterThan(Date.from(cancelEffectiveDate.atStartOfDay(defaultZoneId).toInstant()),Date.from(getTodaysDate().atStartOfDay(defaultZoneId).toInstant())))
		{
			return true;
		}
		return false;
	}

	public boolean isDateGreaterThan(Date date1, Date date2)
	{
		return date1.after(date2);
	}

	public boolean isDateEqulas(Date date1, Date date2)
	{
		return date1.equals(date2);
	}
	public LocalDate getTodaysDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		return now.toLocalDate();
	}

	public LocalDate parseDate(String strDate, String pattern, Locale locale){
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern,locale);
		LocalDate date = LocalDate.parse(strDate, dateFormatter);
		return date;
	}

	/**
	 *
	 * @return
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfSMPDisplaysActiveTrialWLSubscriptionsInAlphabeticalOrder() {
		List<String> activeTrialNameWithoutSortLst = new ArrayList<>();
		boolean sorted = false;
		for (WebElement activeTrialName:lblActiveTrialCTName) {
			activeTrialNameWithoutSortLst.add(activeTrialName.getText().trim());
		}
		List<String> sortedList = activeTrialNameWithoutSortLst.stream().sorted().collect(Collectors.toList());
		//SortedList<String> sortedList = new SortedList<String>();
		//for (WebElement activeTrialName:lblActiveTrialCTNNumber) {
		//	sortedList.add(activeTrialName.getText().trim());
		//}

		//compare sorted and unsorted list to see if they are same
		Iterator<String> i = sortedList.iterator();
		int lstIndexCounter=0;
		while (i.hasNext()) {
			if(i.next().equals(activeTrialNameWithoutSortLst.get(lstIndexCounter)))
			{
				sorted = true;
				lstIndexCounter++;
			}else {
				sorted = false;
				break;
			}
		}
		return  sorted;
	}



	public boolean verifyIfSMPDisplaysPendinTrialWLSubscriptionsInAlphabeticalOrder() {
		List<String> activeTrialNameWithoutSortLst = new ArrayList<>();
		boolean sorted = false;
		for (WebElement activeTrialName:lblPendingTrialCTNName) {
			activeTrialNameWithoutSortLst.add(activeTrialName.getText().trim());
		}

		List<String> sortedList = activeTrialNameWithoutSortLst.stream().sorted().collect(Collectors.toList());

		//compare sorted and unsorted list to see if they are same
		Iterator<String> i = sortedList.iterator();
		int lstIndexCounter=0;
		while (i.hasNext()) {
			if(i.next().equals(activeTrialNameWithoutSortLst.get(lstIndexCounter)))
			{
				sorted = true;
				lstIndexCounter++;
			}else {
				sorted = false;
				break;
			}
		}
		return  sorted;
	}
}
