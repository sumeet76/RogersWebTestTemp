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
import java.util.logging.FileHandler;
import java.util.stream.Collectors;

public class RogersPSEFPage extends BasePageClass {


	private By btnUsageAndServicesDropDown;
	private By lblSMPpromotionEnds;
	private By tabDisneyPlus;
	private By tabAppleMusic;


	public RogersPSEFPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//rss-subscriber-info/following-sibling::span//span[contains(text(),'Promotion ended') or contains(text(),'ended') or contains(text(),'La promotion prend fin le')]")
	WebElement lblSMPpromotionEnded;

	@FindBy(xpath = "//h3/following-sibling::rss-subscribed-ctn-item//span[@class='vas-subscriber-name']")
	List<WebElement> lblPendingTrialCTNName;

	@FindBy(xpath = "//h3/following-sibling::rss-subscribed-ctn-item//button[@title='Activate your Disney+ subscription now' or @title='Activer l’abonnement Disney+ maintenant']")
	List<WebElement> btnActivatePendingTrialCTN;

	@FindBy(xpath = "//h3/following-sibling::rss-subscribed-ctn-item//a[contains(@aria-label,'Cancel the Disney+ subscription for ')]")
	List<WebElement> btnCancelPendingTrialCTN;

	@FindBy(xpath = "//h3/following-sibling::rss-subscribed-ctn-item//span[@class='vas-subscriber-number']")
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

	@FindBy(xpath = "//ds-checkbox")
	List<WebElement> chkListCTnForDplusRedeem;

	@FindBy(xpath = "//a[@title='Sign up for Disney+'or @title='Abonnez-vous à Disney+']")
	WebElement btnSignUp;

	@FindBy(xpath = "//rss-subscriber-info")
	List<WebElement> lblRogersRedeemForSubs;

	@FindBy(xpath = "//button[@title='Continue and start this Disney+ subscription' or @title='Continuer et commencer l’abonnement Disney+']")
	WebElement btnSubscribeToSubsscription;

	@FindBy(xpath = "//*[text()='OK' or text()='Continue']")
	WebElement btnOK;

	@FindBy(xpath = "//span[contains(text(),'Promotion started') or contains(text(),'Paid subscription started') or contains(text(),' L’abonnement payant a commencé le') or contains(text(),' La promotion a commencé')]")
	WebElement lblSMPpromotionStarted;

	@FindBy(xpath = "//span[@class='vas-subscriber-number']")
	WebElement paneSMPSubsCTN;

	@FindBy(xpath = "//a[contains(@title,'Cancel the Apple Music subscription for') or contains(@title,'Annuler l’abonnement')]")
	WebElement btnCancelSubscription;

	@FindBy(xpath = "//ancestor::rss-subscribed-ctn-item//button[@title='Activate your Disney+ subscription now' or @title='Activer l’abonnement Disney+ maintenant']")
	WebElement btnActivateTrail;

	@FindBy(xpath = "//rss-value-prop-wrapper[@aria-label='Manage your Disney+ subscription' or @aria-label='Gérer l’abonnement Disney+']//a//span[contains(@class,'ds-button__copy') and (contains(text(),'Manage') or contains(text(),'Gérer'))]")
	WebElement btnDPSubscriptionManage;

	@FindBy(xpath = "//h1[text()='Cancel Disney+ Subscription' or contains(text(),'Annuler l’abonnement') or contains(text(),'Cancel Apple') or contains(text(),'abonnement à Disney+')]")
	WebElement headerCancelSubscription;

	@FindBy(xpath = "//rss-subscriber-info")
	WebElement lblRogersCancellationForSubs;

	@FindBy(xpath = "//rss-cancel//ds-form-field/div/div[contains(@class,'select')]")
	WebElement selectReasonForCancel;

	@FindBy(xpath = "//option[contains(text(),'I’m already paying for a Disney+ subscription') or contains(text(),' Je paie déjà un abonnement à Disney+') or @value='0: Object']")
	WebElement optReasonForImmediateCancel;

	@FindBy(xpath = "//option[contains(text(),\"I don't need Disney+ anymore\") or contains(text(),\"Je n'ai plus besoin de Disney+\") or@value=\"1: Object\"]")
	WebElement optReasonForDefferedCancel;

	@FindBy(xpath = "//*[contains(text(),'Continue') or contains(text(),'Continuer') or contains(text(),'Confirmer') or contains(text(),'Continuer')]")
	WebElement btnConfirm;


	@FindBy(xpath = "//p[text()='Subscription cancelled' or contains(text(),'Abonnement annul')]")
	WebElement headerCancelSuccess;


	@FindBy(xpath = "//span[contains(text(),' This Disney+ subscription has been cancelled immediately and you will not be charged.')]")
	WebElement lblImmediateCancelSuccess;
	//Subscribe ctn
	//span[text()=' 416 817-3435 ']/ancestor::rss-subscribed-ctn-item//button[@title='Activate your Disney+ subscription now']
    //span[text()=' 416 817-3435 ']/ancestor::rss-subscribed-ctn-item//a[contains(@aria-label,'Cancel the Disney+ subscription for ')]
	//subscribe
    //span[@class="vas-subscriber-number" and contains(text(),'416 817-3428')]/ancestor::rss-subscriber-info/parent::div/preceding-sibling::ds-checkbox

	@FindBy(xpath = "//h2[text()='Currently subscribed' or text()='Abonnement en cours']")
	WebElement headerCurrentlySubscribed;

	@FindBy(xpath = "//a[text()='Overview' or text()='Survol']")
	WebElement lnkAccountOverviewPage;

	@FindBy(xpath = "//img[@class='vas-tab-logo' and @alt='contentful.disney-plus.image-alt-text']")
	WebElement imgDisneyPlus;
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

	public boolean verifyIfEffectiveCancelDateForSubscriptionISImmediate(String test_language,String strCancelledCTN) {
		String cancelledEndDate= getReusableActionsInstance().getWhenReady(By.xpath("//span[@class=\"vas-subscriber-number\" and contains(text(),'"+strCancelledCTN.substring(strCancelledCTN.length()-4)+"')]/ancestor::rss-subscriber-info/following-sibling::span//span[contains(text(),'Promotion ended') or contains(text(),'ended') or contains(text(),'La promotion prend fin le')]")).getText();
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

    public boolean verifyIfDPAvaialbleForSubscription() {
		return chkListCTnForDplusRedeem.size()>0;
    }

	public boolean verifyIfDPAvaialbleForCancellation() {
		return lblPendingTrialCTNNumber.size()>0;
	}

	/**
	 * Verifies if the currently subscribed pane is displayed
	 * @return true if available else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfCurrentlySubscribedPaneIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(headerCurrentlySubscribed)
				;
	}


	/**
	 * Verifies if the currently subscribed pane is displayed
	 * @return true if available else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfDisneyPlusSMPViewPageIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(imgDisneyPlus)
				;
	}

	public String checkFirstDefaultCTNForRedeem() {
		String ctnSelected = chkListCTnForDplusRedeem.get(0).getAttribute("title").trim();
		getReusableActionsInstance().getWhenReady(chkListCTnForDplusRedeem.get(0)).click();
		return CurrencyHelpers.extractNumberFromString(ctnSelected);
	}

	public void checkCTNForRedeem(String strCTN) {
		for (WebElement ctn:
		chkListCTnForDplusRedeem) {
			if(ctn.getAttribute("title").trim().contains(strCTN.substring(strCTN.length()-4)))
			{
				getReusableActionsInstance().getWhenReady(ctn).click();
				break;
			}
		}
	}

	public String checkFirstDefaultCTNForCancel() {
		String ctnSelected = lblPendingTrialCTNNumber.get(0).getText().trim();
		ctnSelected = CurrencyHelpers.extractNumberFromString(ctnSelected);
		getReusableActionsInstance().getWhenReady(By.xpath("//span[contains(text(),'"+ctnSelected.substring(ctnSelected.length()-4)+"')]/ancestor::rss-subscribed-ctn-item//a[contains(@aria-label,'Cancel the Disney+ subscription for ') or contains(@aria-label,'Annuler l’abonnement à Disney+ de')]")).click();
		return ctnSelected;
	}

	public void clkSignUp() {

		getReusableActionsInstance().getWhenReady(btnSignUp).click();
	}

	/**
	 * Verifies if redeem details matches with CTN
	 * @param strSubscriberNumber CTN for which the subscription is redeem
	 * @return true if details match else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfRedeemSubscriptionDetailsIsDisplayedCorrectly(String strSubscriberNumber) {
		return getReusableActionsInstance().getWhenReady(lblRogersRedeemForSubs.get(0)).getText().trim().replaceAll(" ","").replaceAll("-","").contains(strSubscriberNumber);
	}

	/**
	 * Verifies if TnC is displayed
	 * @return true if displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfTnCForSubscriptionIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(headerTnC);
	}

	/**
	 * selects the TnC check box
	 * @author Mirza.Kamran
	 */
	public void checkTnC() {
		getReusableActionsInstance().getWhenReady(chkTnC).click();

	}

	/**
	 * Clicks subscribe button
	 * @author Mirza.Kamran
	 */
	public void clkSubscribeToSubs() {
		getReusableActionsInstance().getWhenReady(btnSubscribeToSubsscription).click();

	}

	/**
	 * verifies if the Subscription success overlay is displayed
	 * @return true if displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfSubscriptionSuccessfulOverLayDisplayed() {
		return getReusableActionsInstance().isElementVisible(By.xpath("//*[contains(text(),'Subscription successful') or contains(text(),'Abonnement réussi')]"));

	}

	/**
	 * Selects okay on Subscription success overlay
	 * @author Mirza.Kamran
	 */
	public void clkOKButtonOnSubscriptionSuccessOverlay() {
		getReusableActionsInstance().staticWait(15000);
		getReusableActionsInstance().getWhenReady(btnOK).click();
		getReusableActionsInstance().staticWait(3000);
	}

	/**
	 * Verifies if the subscribed details match
	 * @param strSubscriberNumber
	 * @return true if the details match else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfSMPIsDisplayedWithSubscribedCTN(String strSubscriberNumber) {
		return getReusableActionsInstance().isElementVisible(By.xpath("//h3/following-sibling::rss-subscribed-ctn-item//span[@class='vas-subscriber-number' and contains(text(),'"+strSubscriberNumber.substring(strSubscriberNumber.length()-4)+"')]"));

	}

	/**
	 * Verifies if the button cancel subscription is displayed
	 * @return true if available else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfHeaderCancelSubscriptionIsDisplayed() {
		return getReusableActionsInstance().isElementVisible(headerCancelSubscription);
	}

	/**
	 * Verifies if the cancel subscription details are correctly displayed
	 * @return true if available else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfCancelSubscriptionDetailsIsDisplayedCorrectly(String strSubscriberNumber) {
		return getReusableActionsInstance().getWhenReady(lblRogersCancellationForSubs).getText().trim().replaceAll(" ","").replaceAll("-","").contains(strSubscriberNumber);
	}

	/**
	 * Selects the cancellation reason
	 * @author Mirza.Kamran
	 */
	public void selectReasonForCancelSubscription(String strReason) {
		getReusableActionsInstance().getWhenReady(selectReasonForCancel).click();
		switch (strReason.toLowerCase())
		{

			case "immediate":
			{
				getReusableActionsInstance().waitForElementTobeClickable(optReasonForImmediateCancel, 5);
				getReusableActionsInstance().getWhenReady(optReasonForImmediateCancel).click();
				break;
			}
			case "deferred":
			{
				getReusableActionsInstance().waitForElementTobeClickable(optReasonForDefferedCancel, 5);
				getReusableActionsInstance().getWhenReady(optReasonForDefferedCancel).click();
				break;
			}
		}
	}


	/**
	 * Selects confirm cancel subscription
	 * @author Mirza.Kamran
	 */
	public void clkConfirmCancelSubscription() {
		getReusableActionsInstance().getWhenReady(btnConfirm).click();
	}

	/**
	 * verifies if the cancel success overlay is displayed
	 * @return true if displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfCancelSuccessfulOverLayDisplayed() {
		return getReusableActionsInstance().isElementVisible(headerCancelSuccess);
	}

	/**
	 * verifies if the cancel success overlay is displayed
	 * @return true if displayed else false
	 * @author Mirza.Kamran
	 */
	public boolean verifyIfCancelSuccessfulOverLayMentionsEffectiveImmediate() {
		return getReusableActionsInstance().isElementVisible(lblImmediateCancelSuccess);
	}

	/**
	 * Selects okay on cancel success overlay
	 * @author Mirza.Kamran
	 */
	public void clkOKButtonOnCancelSuccessOverlay() {
		getReusableActionsInstance().getWhenReady(btnOK).click();
	}


	public void clkAccountOverview() {
		getReusableActionsInstance().getWhenReady(lnkAccountOverviewPage).click();
	}


	public boolean verifyIfDisneyPlusIsDisplayedOnAO() {
	return	(getReusableActionsInstance().isElementVisible(btnSubscriptionSignUp)
		|| getReusableActionsInstance().isElementVisible(btnDPSubscriptionManage));
	}


	/**
	 * Verifies if the account has subscription available which can be redeem
	 * @author Mirza.Kamran
	 */
	public void clickDPlusSignUporManageButton() {
		if(getReusableActionsInstance().isElementVisible(btnSubscriptionSignUp))
		{
			getReusableActionsInstance().getWhenReady(btnSubscriptionSignUp).click();
		}else if(getReusableActionsInstance().isElementVisible(btnDPSubscriptionManage))
		{
			getReusableActionsInstance().getWhenReady(btnDPSubscriptionManage).click();
		}

	}

	public void clkDisneyPlusTab() {
		getReusableActionsInstance().getWhenReady(tabDisneyPlus).click();
	}

	public void clkAppleMusicTab() {
		getReusableActionsInstance().getWhenReady(tabAppleMusic).click();
	}
}
