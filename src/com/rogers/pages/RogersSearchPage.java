package com.rogers.pages;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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

	@FindBy(id = "ds-form-input-id-0")
	WebElement txtSearch;
	
	@FindBy(xpath = "//p[starts-with(text(),'Other') or starts-with(text(),'Magasiner')]")
    WebElement ddlOther;

    @FindBy(xpath = "//button[@title='Reset Filter']")
    WebElement btnResetAllFilters;

    @FindBy(xpath = "//button[@title='Close search']")
    WebElement txtSearchCloseIcon;

    /**
     * check if expected filters displayed or not
     *
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
     *
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
     *
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
     *
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
                    System.out.println("Expected Grand Parent Filter value:" + strFilterList.get(grandParentFiltercounter));
                    System.out.println("Actual grand parent filter value:" + strTagText[0].trim());
                    System.out.println("Expected Parent Filter value:" + parentFiltersList.get(parentFilterCounter).getText().split("\\Q[\\E")[0].trim());
                    System.out.println("Actual parent filter value:" + strTagText[1].trim());

                    if (!strFilterList.get(grandParentFiltercounter).equalsIgnoreCase(strTagText[0].trim())
                            || !parentFiltersList.get(parentFilterCounter).getText().split("\\Q[\\E")[0].trim().equalsIgnoreCase(strTagText[1].trim())) {
                        blnFlag = false;
                        break;
                    }
                    System.out.println("Category Tag Counter:" + categoryTagsCounter);
                    System.out.println("Size of list result with category Tag is:" + lstResultsWithCategoryTags.size());

                }

            }

        }
        return blnFlag;

    }


    /**
     * clicking on grand parent filter
     *
     * @return true if displayed, otherwise false
     * @author pankaj.patil
     */

    public void clkGrandParentFilter(String strFilterName) {
        WebElement grandParentFilter = driver.findElement(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button//p[starts-with(text(),'"
                + strFilterName + "')]"));

        reusableActions.javascriptScrollToTopOfPage();
        reusableActions.scrollToElementAndClick(grandParentFilter);
        reusableActions.staticWait(1500);
    }

    /**
     * clicking on parent filter
     *
     * @return true if displayed, otherwise false
     * @author pankaj.patil
     */

    public void clkParentFilter(WebElement parentFilter) {
        reusableActions.clickWhenReady(parentFilter);
    }

    public List<WebElement> getParentFilters(String strGrandParentFilterName) {
        return driver.findElements(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button//p[starts-with(text(),'" + strGrandParentFilterName + "')]/ancestor::button/following-sibling::ds-expander//p"));
    }

    public boolean isParentFilterExpanded(WebElement parentFilter) {

        WebElement expandedFilter = parentFilter.findElement(By.xpath("ancestor::button"));

        if (expandedFilter.getAttribute("aria-expanded").equals("true")) {

            return true;

        }

        return false;

    }


    public boolean isGrandParentFilterExpanded(String strFilterName) {

        WebElement expandedFilter = driver.findElement(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button//p[starts-with(text(),'" + strFilterName + "')]/ancestor::button//following-sibling::ds-expander"));


        if (expandedFilter.getAttribute("ng-reflect-expanded").equals("true")) {

            return true;

        }

        return false;

    }

    /**
     * clicking on shop grand parent filter and then wireless parent filter
     *
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

        for (int i = 0; i < lstColorFilter.size(); i++) {

            System.out.println("value of color filter is:" + driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value"));

            reusableActions.staticWait(2000);

            reusableActions.clickWhenReady(By.xpath("//span[starts-with(text(),'" + driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value") + "')]"));
            reusableActions.staticWait(2000);

            List<WebElement> lstColorResults = driver.findElements(By.xpath("//span[starts-with(@style,'background: ')]"));

            for (int j = 0; j < lstColorResults.size(); j++) {

                System.out.println("value of Color Result is:" + lstColorResults.get(j).getAttribute("style"));

                String[] strColorResult = lstColorResults.get(j).getAttribute("style").split(" ");

                reusableActions.getWhenReady(driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i), 20);

                System.out.println("Before if statement - value of strColorResult is:" + strColorResult[1].replaceAll(";", ""));
                System.out.println("Before if statement - value of color filter is:" + driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value"));

		reusableActions.getWhenReady(driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i), 20);
		
		System.out.println("Before if statement - value of strColorResult is:"+strColorResult[1].replaceAll(";", ""));
		System.out.println("Before if statement - value of color filter is:"+driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value"));
		
		if(!(driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value").equalsIgnoreCase(strColorResult[1].replaceAll(";", "")))) {
			
			blnFlag = false;
			break;
			
		}
		
	}
	
	reusableActions.staticWait(2000);
		
	}
	
return blnFlag;	

}
	

	
	public boolean validateResultsLinks(String strGrandParentFilter, String strParentFilter) {
		List<WebElement> resultlinks = driver.findElements(By.xpath("//app-search-results//span[contains(@class,'categorylbl')]/preceding-sibling::a"));
		for (int counter=0;counter<resultlinks.size();counter++){
			if(!(resultlinks.get(counter).getAttribute("href").equals(""))) {
				return true;
			}
		}
		return false;
	}
	
	public void enterTextSearch(String searchText)
	{
		txtSearch.click();
		txtSearch.clear();
		txtSearch.sendKeys(searchText);
	}
	
	public boolean validateLabelVisible(String str)
	{
		return reusableActions.isElementVisible(By.xpath("//h2[contains(text(),'"+str+"')]"), 10);
	}
	public boolean validateLinksVisible(String str)
	{
		return !driver.findElements(By.xpath("//h2[contains(text(),'"+str+"')]/ancestor::div/a")).isEmpty();
	}


/*
	public boolean verifyParentFilterSelection() {	
		boolean blnFlag = true;
		if (!(driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value").equalsIgnoreCase(strColorResult[1].replaceAll(";", "")))) {
			blnFlag = false;
			break;
		}
	}
	reusableActions.clickWhenReady(By.xpath("//span[starts-with(text(),'" + driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value") + "')]"));
	reusableActions.staticWait(2000);
}
return blnFlag;
} */


    public boolean verifyDifferentColorResultsDisplay() {

        boolean blnFlag = false;


        List<WebElement> lstColorFilter = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]"));

        for (int i = 0; i < lstColorFilter.size(); i++) {

            System.out.println("value of color filter is:" + driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value"));

            reusableActions.staticWait(500);

            reusableActions.clickWhenReady(By.xpath("//span[starts-with(text(),'" + driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value") + "')]"));
            reusableActions.staticWait(500);

            List<WebElement> lstColorResults = driver.findElements(By.xpath("//span[starts-with(@style,'background: ')]"));

            for (int j = 0; j < lstColorResults.size(); j++) {

                System.out.println("value of Color Result is:" + driver.findElements(By.xpath("//span[starts-with(@style,'background: ')]")).get(j).getAttribute("style"));

                String[] strColorResult = driver.findElements(By.xpath("//span[starts-with(@style,'background: ')]")).get(j).getAttribute("style").split(" ");

                List<String> lstColorResultText = Arrays.asList(strColorResult[1].replaceAll(";", ""));

                for (int k = 0; k < lstColorResultText.size(); k++) {

                    if ((driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value").equalsIgnoreCase(lstColorResultText.get(k)))) {

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

        for (int i = 0; i < lstResults.size(); i++) {


            List<WebElement> resultColorList = driver.findElements(By.xpath("//a[@class='text-title-5']/parent::div/parent::div")).get(i).findElements(By.tagName("ds-selection"));

            for (int j = 0; j < resultColorList.size(); j++) {
                String selectedColor = driver.findElements(By.xpath("//a[@class='text-title-5']/parent::div/parent::div")).get(i).findElements(By.tagName("ds-selection")).get(j).getAttribute("ng-reflect-color");
                reusableActions.javascriptScrollByVisibleElement(driver.findElements(By.xpath("//a[@class='text-title-5']/parent::div/parent::div")).get(i).findElements(By.tagName("ds-selection")).get(j));
                reusableActions.scrollToElementAndClick(driver.findElements(By.xpath("//a[@class='text-title-5']/parent::div/parent::div")).get(i).findElements(By.tagName("ds-selection")).get(j));
                WebElement resultLink = driver.findElements(By.xpath("//a[@class='text-title-5']/parent::div/parent::div")).get(i).findElement(By.tagName("a"));
                reusableActions.getWhenVisible(resultLink).sendKeys(Keys.ENTER);
                reusableActions.staticWait(4000);
                String colorLabel;
                if (driver.getCurrentUrl().contains("watch")) {
                    colorLabel = driver.findElement(By.xpath("//div[contains(@class,'color-switch') and contains(@class,'active') and @style='display: block;']/a")).getAttribute("class").split("-")[0];
                } else {
                    colorLabel = reusableActions.getWhenReady(By.xpath("//span[text()='Colour:']//following-sibling::span")).getText();
                }

                if (!selectedColor.equalsIgnoreCase(colorLabel)) {
                    blnFlag = false;
                    System.out.println(blnFlag);
                    System.out.println("Selected Color : " + selectedColor);
                    System.out.println("Actual Color : " + colorLabel);
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


    public boolean verifyResultsStorageLabelWithSelectedStorage() {

        boolean blnFlag = true;

        List<WebElement> lstStorageFilter = driver.findElements(By.xpath("//input[@name='storage']"));

        for (int i = 0; i < lstStorageFilter.size(); i++) {
            reusableActions.waitForAllElementsVisible(driver.findElements(By.xpath("//input[@name='storage']")), 40);
            String strStorageFilter = driver.findElements(By.xpath("//input[@name='storage']")).get(i).getAttribute("value");

            System.out.println("value of storage filter is:" + driver.findElements(By.xpath("//input[@name='storage']")).get(i).getAttribute("value"));

            reusableActions.staticWait(2000);

            reusableActions.clickWhenReady(
                    By.xpath("//ds-checkbox[@ng-reflect-value='" + driver.findElements(By.xpath("//input[@name='storage']")).get(i).getAttribute("value") + "']"));
            reusableActions.staticWait(2000);

            List<WebElement> lstStorageResultsLink = driver.findElements(By.xpath("//a[contains(@href,'storage')]"));

            for (int j = 0; j < lstStorageResultsLink.size(); j++) {

                System.out.println("Storage results link list:" + driver.findElements(By.xpath("//a[contains(@href,'storage')]")).get(j).getText());

                reusableActions.getWhenVisible(driver.findElements(By.xpath("//a[contains(@href,'storage')]")).get(j)).sendKeys(Keys.ENTER);
                //reusableActions.staticWait(4000);

                //reusableActions.clickWhenReady(lstStorageResultsLink.get(j));

                reusableActions.staticWait(5000);

                WebElement storageLabel = driver.findElement(By.xpath("//span[text()='Storage:']//following-sibling::span"));
                reusableActions.waitForElementVisibility(storageLabel);
                System.out.println("Storage Label is:" + storageLabel.getText().replaceAll("\\s", ""));
                System.out.println("Storage filter value is:" + strStorageFilter);

                //System.out.println(strStorageFilter.equalsIgnoreCase(storageLabel.getText()));
                if (!(strStorageFilter.equalsIgnoreCase(storageLabel.getText().replaceAll("\\s", "")))) {

                    blnFlag = false;
                    System.out.println("Inside if loop");
                    break;

                }

                System.out.println("Before Navigation");
                driver.navigate().back();
                System.out.println("After Navigation");
                reusableActions.staticWait(4000);


            }
            if (blnFlag == false) {

                break;
            }

            reusableActions.waitForElementVisibility(driver.findElement(By.xpath("//input[@name='storage']")), 40);

            //reusableActions.clickWhenReady(By.xpath("//ds-checkbox[@ng-reflect-value='"+lstStorageFilter.get(i).getAttribute("value")+"']"));
            reusableActions.clickWhenReady(By.xpath("//ds-checkbox[@ng-reflect-value='" + strStorageFilter + "']"));


        }

        return blnFlag;
    }

    public boolean verifyResultsSizeLabelWithSelectedSize() {

        boolean blnFlag = true;

        List<WebElement> lstSizeFilter = driver.findElements(By.xpath("//input[contains(@id,'size')]"));

        for (int i = 0; i < lstSizeFilter.size(); i++) {
            reusableActions.waitForAllElementsVisible(driver.findElements(By.xpath("//input[contains(@id,'size')]")), 40);
            String strSizeFilter = driver.findElements(By.xpath("//input[contains(@id,'size')]")).get(i).getAttribute("value");

            System.out.println("value of size filter is:" + driver.findElements(By.xpath("//input[contains(@id,'size')]")).get(i).getAttribute("value"));

            reusableActions.staticWait(2000);

            reusableActions.clickWhenReady(
                    By.xpath("//ds-checkbox[@ng-reflect-value='" + driver.findElements(By.xpath("//input[contains(@id,'size')]")).get(i).getAttribute("value") + "']"));
            reusableActions.staticWait(2000);

            List<WebElement> lstSizeResultsLink = driver.findElements(By.xpath("//a[contains(@href,'watch')]"));

            for (int j = 0; j < lstSizeResultsLink.size(); j++) {

                System.out.println("Size results link list:" + driver.findElements(By.xpath("//a[contains(@href,'watch')]")).get(j).getText());

                reusableActions.getWhenVisible(driver.findElements(By.xpath("//a[contains(@href,'watch')]")).get(j)).sendKeys(Keys.ENTER);
                //reusableActions.staticWait(4000);

                //reusableActions.clickWhenReady(lstStorageResultsLink.get(j));

                reusableActions.staticWait(5000);

                //WebElement sizeLabel = driver.findElement(By.xpath("//div[contains(@class,'active')]/a[text()='"+strSizeFilter+"']"));
                WebElement sizeLabel = driver.findElement(By.xpath("//a[text()='" + strSizeFilter + "']"));

                reusableActions.waitForElementVisibility(sizeLabel);
                System.out.println("Size Label is:" + sizeLabel.getText());
                System.out.println("Size filter value is:" + strSizeFilter);

                //System.out.println(strStorageFilter.equalsIgnoreCase(storageLabel.getText()));

                if (!strSizeFilter.equalsIgnoreCase(sizeLabel.getText()) || !sizeLabel.isSelected()) {

                    blnFlag = false;
                    System.out.println("Inside if loop");
                    break;

                }

                System.out.println("Before Navigation");
                driver.navigate().back();
                System.out.println("After Navigation");
                reusableActions.staticWait(4000);


            }
            if (blnFlag == false) {

                break;
            }

            reusableActions.waitForElementVisibility(driver.findElement(By.xpath("//input[contains(@id,'size')]")), 40);

            //reusableActions.clickWhenReady(By.xpath("//ds-checkbox[@ng-reflect-value='"+lstStorageFilter.get(i).getAttribute("value")+"']"));
            reusableActions.clickWhenReady(By.xpath("//ds-checkbox[@ng-reflect-value='" + strSizeFilter + "']"));


        }

        return blnFlag;

    }


    public boolean verifyChildFilterSelection() {

        boolean blnFlag = true;

        List<WebElement> lstColorFilter = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]"));

        for (int i = 0; i < 1; i++) {

            System.out.println("value of color filter is:" + driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value"));

            reusableActions.staticWait(2000);

            reusableActions.clickWhenReady(By.xpath("//span[starts-with(text(),'" + driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value") + "')]"));
            reusableActions.staticWait(2000);

            List<WebElement> lstColorResults = driver.findElements(By.xpath("//span[starts-with(@style,'background: ')]"));

            for (int j = 0; j < lstColorResults.size(); j++) {

                System.out.println("value of Color Result is:" + lstColorResults.get(j).getAttribute("style"));

                String[] strColorResult = lstColorResults.get(j).getAttribute("style").split(" ");

                reusableActions.getWhenReady(driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i), 20);

                System.out.println("Before if statement - value of strColorResult is:" + strColorResult[1].replaceAll(";", ""));
                System.out.println("Before if statement - value of color filter is:" + driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value"));

                if (!(driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value").equalsIgnoreCase(strColorResult[1].replaceAll(";", "")))) {

                    blnFlag = false;
                    break;

                }

            }

            reusableActions.staticWait(2000);

        }

        return blnFlag;

    }


    public boolean validateResultsTag(String strGrandParentFilter, String strParentFilter) {
        String[] strParentFilterName = strParentFilter.split("\\[");
        String strExpectedTag = strGrandParentFilter.trim() + " - " + strParentFilterName[0].trim();
        List<WebElement> resultlinkTags = driver.findElements(By.xpath("//app-search-results//span[contains(@class,'categorylbl')]"));
        for (int counter = 0; counter < resultlinkTags.size(); counter++) {
            if (!(resultlinkTags.get(counter).getText().equals(strExpectedTag))) {
                return false;
            }
        }
        return true;
    }

    public boolean validateResultsTag(String strGrandParentFilter) {
        String strExpectedTag = strGrandParentFilter.trim() + " - ";
        List<WebElement> resultlinkTags = driver.findElements(By.xpath("//app-search-results//span[contains(@class,'categorylbl')]"));
        for (int counter = 0; counter < resultlinkTags.size(); counter++) {
            if (!(resultlinkTags.get(counter).getText().startsWith(strExpectedTag))) {
                return false;
            }
        }
        return true;
    }


    public boolean verifyParentFilterSelection() {

        boolean blnFlag = true;


	/*List<String> strFilterList = Arrays.asList(strFilterArray);

	System.out.println("List of Grand Parent Filter:" + strFilterList);

	boolean blnFlag = true;

	for (int grandParentFiltercounter = 0; grandParentFiltercounter < strFilterList.size(); grandParentFiltercounter++) {

		System.out.println("Parent filter values:" + strFilterList.get(grandParentFiltercounter));

		clkGrandParentFilter(strFilterList.get(grandParentFiltercounter));*/

        System.out.println("After clicking parent filter" + getDriver().getCurrentUrl());

        List<WebElement> parentFiltersList = driver.findElements(By.xpath("//p[starts-with(text(),'Shop')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p"));

        for (int parentFilterCounter = 0; parentFilterCounter < 1; parentFilterCounter++) {
            reusableActions.staticWait(4000);
            //System.out.println("Sub Filter values:" + parentFiltersList.get(parentFilterCounter).getText());
            System.out.println("Sub Filter values:" + driver.findElements(By.xpath("//p[starts-with(text(),'Shop')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p")).get(parentFilterCounter).getText());


            reusableActions.javascriptScrollToTopOfPage();
            reusableActions.clickWhenReady(By.xpath("//p[starts-with(text(),'Shop')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p[starts-with(text(),'" + parentFiltersList.get(parentFilterCounter).getText() + "')]"), 20);
            //reusableActions.javascriptScrollByVisibleElement(driver.findElement(By.xpath("//p[starts-with(text(),'Shop')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p[starts-with(text(),'"+ parentFiltersList.get(parentFilterCounter).getText() + "')]")));
            //reusableActions.staticWait(4000);
            //reusableActions.scrollToElementAndClick(driver.findElement(By.xpath("//p[starts-with(text(),'Shop')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p[starts-with(text(),'"+ parentFiltersList.get(parentFilterCounter).getText() + "')]")));

            //reusableActions.javascriptScrollByVisibleElement(driver.findElements(By.xpath("//p[starts-with(text(),'Shop')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p")).get(parentFilterCounter));
            //reusableActions.staticWait(4000);
            //reusableActions.scrollToElementAndClick(driver.findElements(By.xpath("//p[starts-with(text(),'Shop')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p")).get(parentFilterCounter));

            System.out.println("After clicking sub filter" + getDriver().getCurrentUrl());

            reusableActions.staticWait(1000);
            List<WebElement> lstResultsWithCategoryTags = driver.findElements(By.xpath("//span[contains(@class,'categorylbl')]"));
            for (int categoryTagsCounter = 0; categoryTagsCounter < lstResultsWithCategoryTags.size(); categoryTagsCounter++) {

                reusableActions.staticWait(500);
                String strTagText[] = reusableActions.getWhenReady(driver.findElements(By.xpath("//span[contains(@class,'categorylbl')]")).get(categoryTagsCounter), 10).getText().split("-");
                System.out.println("Expected Grand Parent Filter value is Shop");
                System.out.println("Actual grand parent filter value:" + strTagText[0].trim());
                System.out.println("Expected Parent Filter value:" + parentFiltersList.get(parentFilterCounter).getText().split("\\Q[\\E")[0].trim());
                System.out.println("Actual parent filter value:" + strTagText[1].trim());

                if (!(strTagText[0].trim()).equalsIgnoreCase("Shop")
                        || !parentFiltersList.get(parentFilterCounter).getText().split("\\Q[\\E")[0].trim().equalsIgnoreCase(strTagText[1].trim())) {
                    blnFlag = false;
                    break;
                }
                System.out.println("Category Tag Counter:" + categoryTagsCounter);
                System.out.println("Size of list result with category Tag is:" + lstResultsWithCategoryTags.size());

            }

        }

        return blnFlag;

    }

    public boolean isGrandParentFilterDisplayed(String strGrandParentFilterName) {
        return reusableActions.isElementVisible(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button" +
                "//p[starts-with(text(),'" + strGrandParentFilterName + "')]"));
    }

    public boolean isParentFilterDisplayed(String strGrandParentFilterName,String strParentFilterName) {
        return reusableActions.isElementVisible(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button" +
                "//p[starts-with(text(),'" +strGrandParentFilterName+"')]/ancestor::button/following-sibling::ds-expander" +
                "//p[starts-with(text(),'" +strParentFilterName+"')]"));
    }

    public void clkParentFilter(String strGrandParentFilterName, String strParentFilterName) {
        reusableActions.clickWhenReady(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button" +
                    "//p[starts-with(text(),'"+strGrandParentFilterName+"')]/ancestor::button/following-sibling::ds-expander" +
                    "//p[starts-with(text(),'"+strParentFilterName+"')]"));
        reusableActions.staticWait(1500);
    }

    public List<String> getStorageSelections() {
        List<String> strStorageSelections = new ArrayList<String>();
        List<WebElement> chkStorageSelections = driver.findElements(By.xpath("//input[@name='storage']"));
        for(int i=0;i<chkStorageSelections.size();i++) {
            strStorageSelections.add(chkStorageSelections.get(i).getAttribute("value"));
        }
        return strStorageSelections;
    }

    public List<String> getColorSelections() {
        List<String> strColorSelections = new ArrayList<String>();
        List<WebElement> chkColorSelections = driver.findElements(By.xpath("//input[@name='color']"));
        for(int i=0;i<chkColorSelections.size();i++) {
            strColorSelections.add(chkColorSelections.get(i).getAttribute("value"));
        }
        return strColorSelections;
    }

    public void clkStorageType(String strStorage) {
        reusableActions.clickWhenReady(By.xpath("//ds-checkbox[@ng-reflect-value='"+strStorage+"']"));
        reusableActions.javascriptScrollToTopOfPage();
        reusableActions.staticWait(1500);
    }

    public void clkColorType(String strColor) {
        reusableActions.clickWhenReady(By.xpath("//span[contains(@class,'color') and starts-with(text(),'"+strColor+"')]"));
        reusableActions.staticWait(1500);
    }

    public List<WebElement> getAllResultLinks() {
        return driver.findElements(By.xpath("//app-search-results//span[contains(@class,'categorylbl')]/preceding-sibling::a"));
    }

    public void clkResultLink(WebElement resultLink) {
        reusableActions.javascriptScrollToTopOfPage();
        reusableActions.clickWhenReady(resultLink);
    }

    public boolean isParentFilterExpanded(String strGrandParentFilter, String strParentFilter) {
        return isParentFilterExpanded(driver.findElement(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button" +
                "//p[starts-with(text(),'"+strGrandParentFilter+"')]/ancestor::button/following-sibling::ds-expander" +
                "//p[starts-with(text(),'"+strParentFilter+"')]")));
    }

    public void clkResetAllFilters() {
        reusableActions.clickWhenReady(btnResetAllFilters);
    }

    public boolean validateAllFiltersCollapsed() {
        boolean collapsedFlag = true;
        List<WebElement> grandParentFilters = driver.findElements(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button//p"));
        for(int i=0; i< grandParentFilters.size();i++) {
            if(isGrandParentFilterExpanded(grandParentFilters.get(i).getText())) {
                collapsedFlag = false;
            }
        }
        return collapsedFlag;
    }

    public void clkDeviceType(String strDeviceType) {
        reusableActions.clickWhenReady(By.xpath("//ds-checkbox[@ng-reflect-value='"+strDeviceType+"']"));
        reusableActions.javascriptScrollToTopOfPage();
        reusableActions.staticWait(1500);
    }

    public void clkBrandType(String strBrandType) {
        reusableActions.clickWhenReady(By.xpath("//ds-checkbox[@ng-reflect-value='"+strBrandType+"']"));
        reusableActions.javascriptScrollToTopOfPage();
        reusableActions.staticWait(1500);
    }

    public boolean validateResultsLinks() {
        List<WebElement> resultlinks = driver.findElements(By.xpath("//app-search-results//span[contains(@class,'categorylbl')]/preceding-sibling::a"));
        for (int counter=0;counter<resultlinks.size();counter++){
            if(!(resultlinks.get(counter).getAttribute("href").equals(""))) {
                return true;
            }
        }
        return false;
    }

    public void clkSizeType(String strSize) {
        reusableActions.clickWhenReady(By.xpath("//ds-checkbox[@ng-reflect-value='"+strSize+"']"));
        reusableActions.javascriptScrollToTopOfPage();
        reusableActions.staticWait(1500);
    }

    public List<String> getSizeSelections() {
        List<String> strSizeSelections = new ArrayList<String>();
        List<WebElement> chkSizeSelections = driver.findElements(By.xpath("//input[contains(@id,'size')]"));
        for(int i=0;i<chkSizeSelections.size();i++) {
            strSizeSelections.add(chkSizeSelections.get(i).getAttribute("value"));
        }
        return strSizeSelections;
    }

    public void clkOnMagnifyingLens() {
        txtSearch.sendKeys(Keys.ENTER);
        System.out.println("Enter key is clicked");
        reusableActions.staticWait(4000);
    }

    public boolean validateResultLandingPageURL(String strQuery) throws UnsupportedEncodingException{
        String strUrl = URLDecoder.decode(driver.getCurrentUrl(), StandardCharsets.UTF_8.name());
        boolean blnFlag = false;
        if(strUrl.contains(strQuery)) {
            blnFlag = true;
        }
        return blnFlag;
    }

    public void clkCloseSearchIcon() {
        txtSearchCloseIcon.click();
    }

    public boolean validateSearchBoxIsEmpty() {
        boolean blnFlag = true;
        String txtSearchValue = txtSearch.getAttribute("ng-reflect-value");
        if(txtSearchValue.isEmpty()) {
            return blnFlag;
        }
        return false;
    }
}