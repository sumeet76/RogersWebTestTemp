package com.rogers.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rogers.pages.base.BasePageClass;

public class RogersSearchPage extends BasePageClass {

	public RogersSearchPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath = "//p[starts-with(text(),'Support') or starts-with(text(),'Soutien')]")
	WebElement ddlSupport;

	@FindBy(xpath = "//p[starts-with(text(),'Shop') or starts-with(text(),'Shop FR')]")
	WebElement ddlShop;

	@FindBy(xpath = "//p[contains(text(),'Help & Support') or contains(text(),'Aide et Soutien')]")
	WebElement ddlHelpNSupport;

	@FindBy(xpath = "//p[starts-with(text(),'Other') or starts-with(text(),'Magasiner')]")
	WebElement ddlOther;
	

	/**
	 * check if expected filters displayed or not 
	 * @return true if displayed, otherwise false
	 * @author pankaj.patil
	 */

	public boolean isFilterDisplayed(String strFilterName) {

		return reusableActions.isElementVisible(
				By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button//p[starts-with(text(),'"
						+ strFilterName + "')]"));

	}
	

	/**
	 * check if expected results displayed or not
	 * @return true if displayed, otherwise false
	 * @author pankaj.patil
	 */

	public boolean verifyResultsCategoryTagRelevancy(String[] strFilterArray) {

		List<WebElement> categoryTags = driver.findElements(By.xpath("//span[contains(@class,'categorylbl')]"));

		List<String> strFilterValues = Arrays.asList(strFilterArray);
		boolean blnFlag = true;
		for (int i = 0; i < categoryTags.size(); i++) {

			String strTagText[] = categoryTags.get(i).getText().split("-");

			if (!strFilterValues.contains(strTagText[0].trim())) {
				blnFlag = false;
				break;
			}
		}
		return blnFlag;

	}
	

	/**
	 * check if expected results displayed or not after clicking on grand parent filter
	 * @return true if displayed, otherwise false
	 * @author pankaj.patil
	 */

	public boolean clkGrandParentFilterAndVerifyResultsCategoryTagRelevancy(String[] strFilterArray) {

		List<String> strFilterValues = Arrays.asList(strFilterArray);

		boolean blnFlag = true;

		for (int j = 0; j < strFilterValues.size(); j++) {

			reusableActions.clickIfAvailable(
					By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button//p[starts-with(text(),'"
							+ strFilterValues.get(j) + "')]"));

			List<WebElement> categoryTags = driver.findElements(By.xpath("//span[contains(@class,'categorylbl')]"));

			for (int i = 0; i < categoryTags.size(); i++) {

				String strTagText[] = categoryTags.get(i).getText().split("-");

				if (!strFilterValues.get(j).equals(strTagText[0].trim())) {
					blnFlag = false;
					break;
				}
			}

		}
		return blnFlag;

	}
	

	/**
	 * check if expected results displayed or not after clicking on parent filter
	 * @return true if displayed, otherwise false
	 * @author pankaj.patil
	 */
	
	
	public boolean clkParentFilterAndVerifyResultsCategoryTagRelevancy(String[] strFilterArray) {

		List<String> strFilterList = Arrays.asList(strFilterArray);

		System.out.println("List of Parent Filter:" + strFilterList);

		boolean blnFlag = true;

		for (int grandParentFiltercounter = 0; grandParentFiltercounter < strFilterList.size(); grandParentFiltercounter++) {

			System.out.println("Parent filter values:" + strFilterList.get(grandParentFiltercounter));

			clkGrandParentFilter(strFilterList.get(grandParentFiltercounter));
			System.out.println("After clicking parent filter" + getDriver().getCurrentUrl());

			List<WebElement> parentFiltersList = driver.findElements(By.xpath("//p[starts-with(text(),'" + strFilterList.get(grandParentFiltercounter)
					+ "')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p"));
			
			for (int parentFilterCounter = 0; parentFilterCounter < parentFiltersList.size(); parentFilterCounter++) {
				reusableActions.staticWait(1500);
				System.out.println("Sub Filter values:" + parentFiltersList.get(parentFilterCounter).getText());

				reusableActions.clickWhenReady(By.xpath("//p[starts-with(text(),'" + strFilterList.get(grandParentFiltercounter)
						+ "')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p[starts-with(text(),'"
						+ parentFiltersList.get(parentFilterCounter).getText() + "')]"), 20);
				System.out.println("After clicking sub filter" + getDriver().getCurrentUrl());
		
				reusableActions.staticWait(1000);
				List<WebElement> lstResultsWithCategoryTags = driver.findElements(By.xpath("//span[contains(@class,'categorylbl')]"));
				for (int categoryTagsCounter = 0; categoryTagsCounter < lstResultsWithCategoryTags.size(); categoryTagsCounter++) {
				
					reusableActions.staticWait(500);
					String strTagText[] = reusableActions.getWhenReady(driver.findElements(By.xpath("//span[contains(@class,'categorylbl')]")).get(categoryTagsCounter), 10).getText().split("-");
					System.out.println("Expected Grand Parent Filter value:"+strFilterList.get(grandParentFiltercounter));
					System.out.println("Actual grand parent filter value:"+strTagText[0].trim());
					System.out.println("Expected Parent Filter value:"+parentFiltersList.get(parentFilterCounter).getText().split("\\Q[\\E")[0].trim());
					System.out.println("Actual parent filter value:"+strTagText[1].trim());
					
					if (!strFilterList.get(grandParentFiltercounter).equalsIgnoreCase(strTagText[0].trim())
							|| !parentFiltersList.get(parentFilterCounter).getText().split("\\Q[\\E")[0].trim().equalsIgnoreCase(strTagText[1].trim())) {
						blnFlag = false;
						break;
					}
				System.out.println("Category Tag Counter:"+categoryTagsCounter);
				System.out.println("Size of list result with category Tag is:"+lstResultsWithCategoryTags.size());
				
				}
	
			}

		}
		return blnFlag;

	}

	
	/**
	 * clicking on grand parent filter
	 * @return true if displayed, otherwise false
	 * @author pankaj.patil
	 */
	
	public void clkGrandParentFilter(String strFilterName) {
		WebElement parentFilter = driver.findElement(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button//p[starts-with(text(),'"
				+ strFilterName + "')]"));
		
		reusableActions.scrollToElementAndClick(parentFilter);
						
		
	}
	
	/**
	 * clicking on parent filter
	 * @return true if displayed, otherwise false
	 * @author pankaj.patil
	 */
	
	public void clkParentFilter(WebElement parentFilter) {

		reusableActions.clickWhenReady(parentFilter);
		
	}
	
	public List<WebElement> getParentFilters(String strGrandParentFilterName){
		
		return driver.findElements(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button//p[starts-with(text(),'"+strGrandParentFilterName+"')]/ancestor::button/following-sibling::ds-expander//p"));
		
		
	}
	
	public boolean isParentFilterExpanded(WebElement parentFilter) {
		
		WebElement expandedFilter = parentFilter.findElement(By.xpath("ancestor::button"));
		
		if(expandedFilter.getAttribute("aria-expanded").equals("true")) {
			
			return true;
			
		}
		
		return false;
		
	}

	
	
	public boolean isGrandParentFilterExpanded(String strFilterName) {
		
		WebElement expandedFilter = driver.findElement(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button//p[starts-with(text(),'"+strFilterName+"')]/ancestor::button//following-sibling::ds-expander"));
		
		
		if(expandedFilter.getAttribute("ng-reflect-expanded").equals("true")) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * clicking on shop grand parent filter and then wireless parent filter
	 * @return true if displayed, otherwise false
	 * @author pankaj.patil
	 */
	
	public void clkShopAndThenWirelessFilter() {
		
		reusableActions.clickWhenReady(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button//p[starts-with(text(),'Shop')]"));
		reusableActions.clickWhenReady(By.xpath("//p[starts-with(text(),'Shop')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p[starts-with(text(),'Wireless')]"));
		
		/*WebElement parentFilter = driver.findElement(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button//p[starts-with(text(),'"
				+ strFilterName + "')]"));
		
		reusableActions.scrollToElementAndClick(parentFilter);*/
						
		
	}
	
	public boolean verifyColorResultsDisplay() {
		
		boolean blnFlag = true;
		
		
		List<WebElement> lstColorFilter = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]"));
		
		for(int i=0; i<lstColorFilter.size(); i++) {
			
			System.out.println("value of color filter is:"+driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value"));
			
			reusableActions.staticWait(2000);
			
			reusableActions.clickWhenReady(By.xpath("//span[starts-with(text(),'"+driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value")+"')]"));
			reusableActions.staticWait(2000);
			
		List<WebElement> lstColorResults = driver.findElements(By.xpath("//span[starts-with(@style,'background: ')]"));
		
		for(int j=0; j<lstColorResults.size(); j++) {
			
			System.out.println("value of Color Result is:"+lstColorResults.get(j).getAttribute("style"));
			
			String[] strColorResult = lstColorResults.get(j).getAttribute("style").split(" ");

			reusableActions.getWhenReady(driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i), 20);
			
			System.out.println("Before if statement - value of strColorResult is:"+strColorResult[1].replaceAll(";", ""));
			System.out.println("Before if statement - value of color filter is:"+driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value"));
			
			if(!(driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value").equalsIgnoreCase(strColorResult[1].replaceAll(";", "")))) {
				
				blnFlag = false;
				break;
				
			}
			
		}
		
		reusableActions.clickWhenReady(By.xpath("//span[starts-with(text(),'"+driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value")+"')]"));
		reusableActions.staticWait(2000);
			
		}
		
	return blnFlag;	
		
	}
	
	
public boolean verifyDifferentColorResultsDisplay() {
		
		boolean blnFlag = false;
		
		
		List<WebElement> lstColorFilter = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]"));
		
		for(int i=0; i<lstColorFilter.size(); i++) {
			
			System.out.println("value of color filter is:"+driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value"));
			
			reusableActions.staticWait(500);
			
			reusableActions.clickWhenReady(By.xpath("//span[starts-with(text(),'"+driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value")+"')]"));
			reusableActions.staticWait(500);
			
		List<WebElement> lstColorResults = driver.findElements(By.xpath("//span[starts-with(@style,'background: ')]"));
		
		for(int j=0; j<lstColorResults.size(); j++) {
			
			System.out.println("value of Color Result is:"+driver.findElements(By.xpath("//span[starts-with(@style,'background: ')]")).get(j).getAttribute("style"));
			
			String[] strColorResult = driver.findElements(By.xpath("//span[starts-with(@style,'background: ')]")).get(j).getAttribute("style").split(" ");
			
			List<String> lstColorResultText = Arrays.asList(strColorResult[1].replaceAll(";", ""));
			
			for(int k=0; k<lstColorResultText.size(); k++) {
				
				if((driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value").equalsIgnoreCase(lstColorResultText.get(k)))) {
					
					blnFlag = true;
					break;
					
				}
				
				
			}
			
		}
		
		}
		
		return blnFlag;
		
}

public boolean verifyResultsColorLabelWithSelectedColor() {
	
	boolean blnFlag = true;
	
	List<WebElement> lstResults = driver.findElements(By.xpath("//a[@class='text-title-5']/parent::div/parent::div"));
	
	for(int i=0; i<lstResults.size(); i++) {


		List<WebElement> resultColorList = driver.findElements(By.xpath("//a[@class='text-title-5']/parent::div/parent::div")).get(i).findElements(By.tagName("ds-selection"));

		for(int j=0; j<resultColorList.size(); j++) {
			String selectedColor=driver.findElements(By.xpath("//a[@class='text-title-5']/parent::div/parent::div")).get(i).findElements(By.tagName("ds-selection")).get(j).getAttribute("ng-reflect-color");
			reusableActions.scrollToElementAndClick(driver.findElements(By.xpath("//a[@class='text-title-5']/parent::div/parent::div")).get(i).findElements(By.tagName("ds-selection")).get(j));
			WebElement resultLink= driver.findElements(By.xpath("//a[@class='text-title-5']/parent::div/parent::div")).get(i).findElement(By.tagName("a"));
			reusableActions.getWhenVisible(resultLink).sendKeys(Keys.ENTER);
			reusableActions.staticWait(4000);
			WebElement colorLabel = reusableActions.getWhenReady(By.xpath("//span[text()='Colour:']//following-sibling::span"));
			if(!selectedColor.equalsIgnoreCase(colorLabel.getText())) {
				blnFlag = false;
				System.out.println(blnFlag);
				System.out.println("Selected Color : "+ selectedColor);
				System.out.println("Actual Color : "+ colorLabel.getText());
				break;
			}
			driver.navigate().back();
			reusableActions.staticWait(1000);


		}

		driver.navigate().back();
		reusableActions.staticWait(1000);

			
		}
	
		return blnFlag;
	}

}

			
		

	