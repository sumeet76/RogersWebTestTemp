package com.rogers.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
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

		reusableActions.clickWhenReady(
				By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button//p[starts-with(text(),'"
						+ strFilterName + "')]"));
		
	}
	
	
	/**
	 * verify only one grand parent filter selection display
	 * @return true if collapsed, otherwise false
	 * @author pankaj.patil
	 */
	
	public boolean verifyOnlyOneGrandParentFilterSelectionDisplay(String[] strFilterArray) {

		List<String> strFilterList = Arrays.asList(strFilterArray);
		System.out.println("List of Parent Filter:" + strFilterList);
		boolean blnFlag = true;

		for (int selectedFilterCounter = 0; selectedFilterCounter < strFilterList.size(); selectedFilterCounter++) {

			System.out.println("Parent filter values:" + strFilterList.get(selectedFilterCounter));

			clkGrandParentFilter(strFilterList.get(selectedFilterCounter));
			System.out.println("After clicking parent filter" + getDriver().getCurrentUrl());

			WebElement selectedFilter = driver.findElement(By.xpath("//p[starts-with(text(),'" + strFilterList.get(selectedFilterCounter)
					+ "')]/ancestor::button//following-sibling::ds-expander"));

			selectedFilter.getAttribute("ng-reflect-expanded");

			System.out.println("Selected Filter Flag is:"+selectedFilter.getAttribute("ng-reflect-expanded"));
			
			for (int unSelectedFilterCounter=selectedFilterCounter+1; unSelectedFilterCounter<strFilterList.size(); unSelectedFilterCounter++) {
				
				WebElement unSelectedFilter = driver.findElement(By.xpath("//p[starts-with(text(),'" + strFilterList.get(unSelectedFilterCounter)
				+ "')]/ancestor::button//following-sibling::ds-expander"));

				unSelectedFilter.getAttribute("ng-reflect-expanded");

				System.out.println("Unselected Filter Flag is:"+unSelectedFilter.getAttribute("ng-reflect-expanded"));
				
				if (!selectedFilter.getAttribute("ng-reflect-expanded").equalsIgnoreCase("true") || !unSelectedFilter.getAttribute("ng-reflect-expanded").equalsIgnoreCase("false")) {

					System.out.println("Inside if statement");
					blnFlag = false;
					break;
				}
				
			}
			
		}

		return blnFlag;

	}		
		

}
