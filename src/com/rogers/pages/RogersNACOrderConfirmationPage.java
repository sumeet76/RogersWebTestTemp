package com.rogers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersNACOrderConfirmationPage extends BasePageClass {

	public RogersNACOrderConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	 @FindBy(xpath = "//h1[@id='bfa-page-title']")
	 WebElement orderConfirmationTitle;
	 
	 @FindBy(xpath="//p[@class='text-title-6 mb-40 ng-star-inserted']")
	 WebElement orderConfirmationContent;
	 
	 @FindBy(xpath="//h4[@data-test='rpotgTitle']")
	 WebElement rpotgTitle;
	 
	 @FindBy(xpath="//h5[@class='text-title-5 my-24']")
	 WebElement appointmentDetailsTitle;
	 
	 @FindBy(xpath="//p[@class='text-bold text-title-6' and contains(text(),'Appointment date:')]")
	 WebElement appointmentDateTitle;
	 
	 @FindBy(xpath ="//p[@class='text-bold text-title-6' and contains(text(),'Appointment date:')]/../p[2]")
	 WebElement appointmentDate;
		
	 @FindBy(xpath ="//p[@class='text-bold text-title-6' and contains(text(),'Appointment date:')]/../p[3]")
	 WebElement appointmentTime;
	 
	 @FindBy(xpath="//p[@class='text-bold text-title-6' and contains(text(),'Appointment address:')]")
	 WebElement appointmentAddressTitle;
	 
	 @FindBy(xpath="//img[@alt='largeImage_1']")
	 WebElement deviceImage;
	 
	 @FindBy(xpath="(//div[contains(@class,'totalRow d-flex align-items-center')])[1]")
	 WebElement monthlyFeeAfterTax;

	 @FindBy(xpath="(//div[contains(@class,'dsa-orderTable__totalRow d-flex align-items-center')])[2]")
	 WebElement oneTimeFeeAfterTax;

	 @FindBy(xpath="//div[contains(@class,'dsa-promoBlock p-md-24 p-16 ds-bgcolor-misty')]")
	 WebElement purchaseIncludes;
	 
	 @FindBy(xpath="//div[@class='my-12 ng-star-inserted']/p[@class='text-bold text-title-6']/..")
	 WebElement appointmentCompleteAddress;

	 @FindBy(xpath ="//a[@title='Learn more']")
	 WebElement learnMoreLink;
	 
	 
	    /**
	     * To get the Title of Order Confirmation Page
	     *
	     * @author Karthic.hasan
	     */
	    public boolean getOrderConfirmationTitle() {
	       return reusableActions.isElementVisible(orderConfirmationTitle);
	    }
	    
		/**
		 * To verify Order Confirmation Content Element present in the page.
		 *
		 * @author karthic.hasan
		 */
		
		public boolean verifyOrderConfirmationContent()
		{
			return reusableActions.isElementVisible(orderConfirmationContent);
		}
	 
	    /**
	     * This method will get the total monthly fees amount after tax from the cart summary
		 * @return String having total monthly fees amount after tax from the cart summary
		 * @author Karthic.hasan
		 */

	    public String getMonthlyFeeAfterTax() 
	    { 
	    	return monthlyFeeAfterTax.getText().replaceAll("\\n","");
	    }
	    

	    /**
	     * This method will get the total one time fees amount after tax from the cart summary
	     * @return String having total monthly fees amount after tax from the cart summary
	     * @author Karthic.hasan
	     */

	    public String getOneTimeFeeAfterTax() 
	    { 
	    	return oneTimeFeeAfterTax.getText().replaceAll("\\n",""); 
	    }

	    /**
		 * This method will get the purchase includes section displayed below the cart summary
		 * @return String : Return the purchase includes text displayed below the cart summary
		 * @author Karthic.hasan
		 */

		public String getPurchaseIncludesText()
		{ 
			return reusableActions.getWhenReady(purchaseIncludes,10).getText().trim().replaceAll("\\n", " "); 
			
		}

		/**
		 * To verify Learn More Link present in the Order Confirmation page.
		 *
		 * @author karthic.hasan
		 */
		
		public boolean verifyLearnMoreLink()
		{
			return reusableActions.isDisplayed(learnMoreLink);
		}
	   
		/**
		 * To verify RPOTG Title present in the Order Confirmation page.
		 *
		 * @author karthic.hasan
		 */
		
		public boolean verifyRpotgTitle()
		{
			reusableActions.staticWait(1000);
			return reusableActions.isDisplayed(rpotgTitle);
		}
		
		/**
		 * To verify Your Appointment Details Title present in the Order Confirmation page for RPOTG.
		 *
		 * @author karthic.hasan
		 */
		
		public boolean verifyAppointmentDetailsTitle()
		{
			return reusableActions.isDisplayed(appointmentDetailsTitle);
		}
		
		/**
		 * To verify  Appointment Date Title present in the Order Confirmation page for RPOTG.
		 *
		 * @author karthic.hasan
		 */
		
		public boolean verifyAppointmentDateTitle()
		{
			return reusableActions.isDisplayed(appointmentDateTitle);
		}
		
		/**
		 * To verify Appointment Address Title present in the Order Confirmation page for RPOTG.
		 *
		 * @author karthic.hasan
		 */
		
		public boolean verifyAppointmentAddressTitle()
		{
			return reusableActions.isDisplayed(appointmentAddressTitle);
		}
		
		/**
		 * To verify Phone Image present in the Order Confirmation page for RPOTG.
		 *
		 * @author karthic.hasan
		 */
		
		public boolean verifyDeviceImage()
		{
			return reusableActions.isDisplayed(deviceImage);
		}
		
		/**
		 * This method will get Appointment Date from Shipping Stepper
		 * @return String having Appointment Date from Shipping stepper
		 * @author karthic.hasan
		 */

		public String getAppointmentDate() { 
			reusableActions.javascriptScrollByVisibleElement(appointmentDate);
	   	    reusableActions.staticWait(3000);
			return appointmentDate.getText().replaceAll("\\n",""); 
		}

		/**
		 * This method will get Appointment Time from Shipping Stepper
		 * @return String having Appointment Time from Shipping stepper
		 * @author karthic.hasan
		 */

		public String getAppointmentTime() { 
			reusableActions.javascriptScrollByVisibleElement(appointmentTime);
	   	    reusableActions.staticWait(3000);
			return appointmentTime.getText().replaceAll("Between","Between:"); 
		}
		
		/**
		 * This method will get Appointment Complete Address  from Shipping Stepper
		 * @return String having Appointment Complete Address  from Shipping stepper
		 * @author karthic.hasan
		 */

		public String getAppointmentAddressText() { 
			return reusableActions.getWhenReady(appointmentCompleteAddress,10).getText().trim().replaceAll("\\n", " ");
		}
		
}
