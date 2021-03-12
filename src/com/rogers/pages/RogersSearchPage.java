package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.DigiAutoCustomException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    @FindBy(xpath = "//app-search-noresults//span[contains(text(),'Sorry! No results found on')]")
    WebElement lblNoResultsMsg;

    @FindBy(xpath = "//section[@class='col-12 col-md-6 h-md-100 ds-overflow-y-auto d-none d-md-block']")
    WebElement firstSectionValues;

    @FindBy(xpath = "//div[@ng-reflect-heading='Suggestions']/parent::section/parent::div/section[1]/div")
    WebElement leftSectionResults;

    @FindBy(xpath = "//div[@ng-reflect-heading='Support']/parent::section")
    WebElement supportSection;

    @FindBy(xpath = "//div[@ng-reflect-heading='Support']/parent::section//a")
    WebElement supportSectionLinks;

    @FindBy(xpath = "//div[@ng-reflect-heading='Suggestions']/parent::section")
    WebElement suggestionsSection;

    @FindBy(xpath = "//div[@ng-reflect-heading='Suggestions']/parent::section//a")
    List<WebElement> suggestionsSectionLinks;

    @FindBy(xpath = "//div[@class='resultList']/div[contains(@class,'pt-4')]")
    WebElement resultsCountAndPageDetails;

    @FindBy(xpath = "//div[@class='resultList']/div[1]")
    WebElement resultsCount;

    @FindBy(xpath = "//app-search-results/div[@class='resultList']")
    WebElement resultsWindow;

    @FindBy(xpath = "//div[@class='ds-filter__listSet']/div/button/div/p[starts-with(text(),'')]/parent::div/parent::button")
    List<WebElement> grandParentFilters;

    @FindBy(xpath = "//div[contains(@id,'Shop-body')]/div/button[contains(@id,'Wireless-heading')]")
    WebElement Wireless;

    List<WebElement> elementName;

    /**
     * @author naina.agarwal
     */
    @FindBy(xpath = "//span[@class='m-navLink__icon rds-icon-search -open']")
    WebElement searchTextIcon;

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement searchTextBox;

    @FindBy(xpath = "//span[@class='a-icon rds-icon-search']")
    WebElement submitSearchIcon;

    @FindBy(xpath = "//div[@class=' my-16 pt-4 pb-8']")
    WebElement searchResults;

    @FindBy(xpath = "//button[contains (@class, 'active') and @title='Page 1']")
    WebElement firstPagePaginationHighlighted;

    @FindBy(xpath = "//button[contains (@class, 'active') and @title='Page 2']")
    WebElement secondPagePaginationHighlighted;

    @FindBy(xpath = "//button[contains (@class, 'active')]/div")
    WebElement currentPageNumberHighlighted;

    @FindBy(xpath = "//button[@title='Page 1']")
    WebElement page1;

    @FindBy(xpath = "//button[@title='Page 2']")
    WebElement page2;

    @FindBy(xpath = "//button[@title='Page 3']")
    WebElement page3;

    public static final By numberOfPagesDisplayedAtBottom = By.xpath("//div[@class='d-flex ng-star-inserted']/button/div");

    @FindBy(xpath = "//select[@id='ds-form-input-id-0']")
    WebElement resultPerPageDropdown;

    @FindBy(xpath = "//span[@class='ds-icon rds-icon-right']")
    WebElement firstForwardArrowKey;

    @FindBy(xpath = "//span[@class='ds-icon rds-icon-left']")
    WebElement firstBackwardArrowKey;

    @FindBy(xpath = "//span[@class='ds-icon rds-icon-last']")
    WebElement lastForwardArrowKey;

    @FindBy(xpath = "//span[@class='ds-icon rds-icon-first']")
    WebElement lastBackwardArrowKey;

    Boolean isPagePresent=true;


    /**
     * check if expected filters displayed or not
     *
     * @return true if displayed, otherwise false
     * @author pankaj.patil
     */

    public boolean isFilterDisplayed(String strFilterName) {
        return getReusableActionsInstance().isElementVisible(
                By.xpath("//div[@class='ds-filter__listSet']/div/button/div/p[starts-with(text(),'"
                        + strFilterName + "')]"));
    }


    /**
     * check if expected results displayed or not
     *
     * @return true if displayed, otherwise false
     * @author pankaj.patil
     */

    public boolean verifyResultsCategoryTagRelevancy(String[] strFilterArray) {

        List<WebElement> categoryTags = getDriver().findElements(By.xpath("//span[contains(@class,'categorylbl')]"));

        List<String> strFilterValues = Arrays.asList(strFilterArray);
        boolean blnFlag = true;
        for (int i = 0; i < categoryTags.size(); i++) {

            String[] strTagText = categoryTags.get(i).getText().split("-");

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

            getReusableActionsInstance().clickIfAvailable(
                    By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button//p[starts-with(text(),'"
                            + strFilterValues.get(j) + "')]"));

            List<WebElement> categoryTags = getDriver().findElements(By.xpath("//span[contains(@class,'categorylbl')]"));

            for (int i = 0; i < categoryTags.size(); i++) {

                String[] strTagText = getDriver().findElements(By.xpath("//span[contains(@class,'categorylbl')]")).get(i).getText().split("-");

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

            List<WebElement> parentFiltersList = getDriver().findElements(By.xpath("//p[starts-with(text(),'" + strFilterList.get(grandParentFiltercounter)
                    + "')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p"));

            for (int parentFilterCounter = 0; parentFilterCounter < parentFiltersList.size(); parentFilterCounter++) {
                getReusableActionsInstance().staticWait(1500);
                System.out.println("Sub Filter values:" + parentFiltersList.get(parentFilterCounter).getText());

                getReusableActionsInstance().clickWhenReady(By.xpath("//p[starts-with(text(),'" + strFilterList.get(grandParentFiltercounter)
                        + "')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p[starts-with(text(),'"
                        + parentFiltersList.get(parentFilterCounter).getText() + "')]"), 20);
                System.out.println("After clicking sub filter" + getDriver().getCurrentUrl());

                getReusableActionsInstance().staticWait(1000);
                List<WebElement> lstResultsWithCategoryTags = getDriver().findElements(By.xpath("//span[contains(@class,'categorylbl')]"));
                for (int categoryTagsCounter = 0; categoryTagsCounter < lstResultsWithCategoryTags.size(); categoryTagsCounter++) {

                    getReusableActionsInstance().staticWait(500);
                    String[] strTagText = getReusableActionsInstance().getWhenReady(getDriver().findElements(By.xpath("//span[contains(@class,'categorylbl')]")).get(categoryTagsCounter), 10).getText().split("-");
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
     * @author pankaj.patil
     */
    public void clkGrandParentFilter(String strFilterName) {
        getReusableActionsInstance().javascriptScrollToTopOfPage();
        getReusableActionsInstance().clickWhenReady(By.xpath("//button[contains(@id,'" + strFilterName + "-heading')]"), 5);
    }

    /**
     * clicking on parent filter
     *
     * @return true if displayed, otherwise false
     * @author pankaj.patil
     */
    public void clkParentFilter(WebElement parentFilter) {
        getReusableActionsInstance().javascriptScrollToTopOfPage();
        getReusableActionsInstance().clickWhenReady(parentFilter);
        getReusableActionsInstance().waitForAttributeToBe(parentFilter, "aria-expanded", "true", 5);
    }

    public void DeselectParentFilter(WebElement parentFilter) {
        getReusableActionsInstance().javascriptScrollToTopOfPage();
        getReusableActionsInstance().clickWhenReady(parentFilter);
        getReusableActionsInstance().waitForAttributeToBe(parentFilter, "aria-expanded", "false", 5);
    }


    public List<WebElement> getParentFilters(String strGrandParentFilterName) {
        return getDriver().findElements(By.xpath("//div[contains(@id,'" + strGrandParentFilterName + "-body')]/div/button"));
    }

    public boolean isParentFilterExpanded(WebElement parentFilter) {
        return parentFilter.getAttribute("aria-expanded").equals("true");
    }

    public String getResultsCountAndCurrentPageDetails() {
        //Waiting for right details to be available
        getReusableActionsInstance().staticWait(1000);
        return resultsCountAndPageDetails.getText();
    }


    public boolean isGrandParentFilterExpanded(String strFilterName) {

        //getReusableActionsInstance().staticWait(1000);

        WebElement expandedFilter = getDriver().findElement(By.xpath("//button[contains(@id,'" + strFilterName + "-heading')]/following-sibling::ds-expander/div"));

        return expandedFilter.getAttribute("aria-hidden").equals("false");

    }


    /**
     * clicking on shop grand parent filter and then wireless parent filter
     *
     * @return true if displayed, otherwise false
     * @author pankaj.patil
     */

    public void clkShopAndThenWirelessFilter() {

        getReusableActionsInstance().clickWhenReady(By.xpath("//button[contains(@id,'Shop-heading')]"));
        //getReusableActionsInstance().staticWait(500);
        //  getReusableActionsInstance().clickWhenReady(By.xpath("//p[starts-with(text(),'Shop')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p[starts-with(text(),'Wireless')]"));
        getReusableActionsInstance().clickWhenReady(By.xpath("//div[contains(@id,'Shop-body')]/div/button[contains(@id,'Wireless-heading')]"));
		/*WebElement parentFilter = getDriver().findElement(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button//p[starts-with(text(),'"
				+ strFilterName + "')]"));

		getReusableActionsInstance().scrollToElementAndClick(parentFilter);*/


    }

    public boolean verifyColorResultsDisplay() {

        boolean blnFlag = true;


        List<WebElement> lstColorFilter = getDriver().findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]"));


        for (int i = 0; i < lstColorFilter.size(); i++) {

            System.out.println("value of color filter is:" + getDriver().findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value"));

            getReusableActionsInstance().staticWait(500);
            getReusableActionsInstance().javascriptScrollToTopOfPage();
            getReusableActionsInstance().clickWhenReady(By.xpath("//span[starts-with(text(),'" + getDriver().findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value") + "')]"));
            //getDriver().findElements(By.xpath("//ds-checkbox[@ng-reflect-checked='true']/label/input[@type='checkbox' and contains(@id,'color')]"));
            getReusableActionsInstance().staticWait(1000);
            String strSelectedColors = "";
            for (int k = 0; k < getDriver().findElements(By.xpath("//ds-checkbox[@ng-reflect-checked='true']/label/input[@type='checkbox' and contains(@id,'color')]")).size(); k++) {
                strSelectedColors = strSelectedColors + getDriver().findElements(By.xpath("//ds-checkbox[@ng-reflect-checked='true']/label/input[@type='checkbox' and contains(@id,'color')]")).get(k).getAttribute("value");
            }

            List<WebElement> lstColorResults = getDriver().findElements(By.xpath("//span[starts-with(@style,'background: ')]"));

            for (int j = 0; j < lstColorResults.size(); j++) {

                System.out.println("value of Color Result is:" + lstColorResults.get(j).getAttribute("style"));

                String[] strColorResult = lstColorResults.get(j).getAttribute("style").split(" ");

                getReusableActionsInstance().getWhenReady(getDriver().findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i), 20);

                System.out.println("Before if statement - value of strColorResult is:" + strColorResult[1].replaceAll(";", ""));
                System.out.println("Before if statement - value of color filter is:" + getDriver().findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value"));

                getReusableActionsInstance().getWhenReady(getDriver().findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i), 20);

                System.out.println("Before if statement - value of strColorResult is:" + strColorResult[1].replaceAll(";", ""));
                System.out.println("Before if statement - value of color filter is:" + getDriver().findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value"));

                if (!(strSelectedColors.toLowerCase().contains((strColorResult[1].replaceAll(";", "").toLowerCase())))) {

                    blnFlag = false;
                    break;

                }

            }

            getReusableActionsInstance().staticWait(2000);

        }

        return blnFlag;

    }

    public boolean validateResultsLinks(String strGrandParentFilter, String strParentFilter) {
        List<WebElement> resultlinks = getDriver().findElements(By.xpath("//app-search-results//span[contains(@class,'categorylbl')]/preceding-sibling::a"));
        for (int counter = 0; counter < resultlinks.size(); counter++) {
            if (!(resultlinks.get(counter).getAttribute("href").equals(""))) {
                return true;
            }
        }
        return false;
    }

    public void enterTextSearch(String searchText) {
        txtSearch.click();
        txtSearch.clear();
        txtSearch.sendKeys(searchText);
    }

    public boolean verifyDifferentColorResultsDisplay() {

        boolean blnFlag = false;


        List<WebElement> lstColorFilter = getDriver().findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]"));

        for (int i = 0; i < lstColorFilter.size(); i++) {

            System.out.println("value of color filter is:" + getDriver().findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value"));

            getReusableActionsInstance().staticWait(500);
            getReusableActionsInstance().javascriptScrollToTopOfPage();
            getReusableActionsInstance().clickWhenReady(By.xpath("//span[starts-with(text(),'" + getDriver().findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value") + "')]"));
            getReusableActionsInstance().staticWait(500);

            List<WebElement> lstColorResults = getDriver().findElements(By.xpath("//span[starts-with(@style,'background: ')]"));

            for (int j = 0; j < lstColorResults.size(); j++) {

                System.out.println("value of Color Result is:" + getDriver().findElements(By.xpath("//span[starts-with(@style,'background: ')]")).get(j).getAttribute("style"));

                String[] strColorResult = getDriver().findElements(By.xpath("//span[starts-with(@style,'background: ')]")).get(j).getAttribute("style").split(" ");

                List<String> lstColorResultText = Arrays.asList(strColorResult[1].replaceAll(";", ""));

                for (int k = 0; k < lstColorResultText.size(); k++) {

                    if ((getDriver().findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value").equalsIgnoreCase(lstColorResultText.get(k)))) {

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

        List<WebElement> lstResults = getDriver().findElements(By.xpath("//a[@class='text-title-5']/parent::div/parent::div"));

        for (int i = 0; i < lstResults.size(); i++) {


            List<WebElement> resultColorList = getDriver().findElements(By.xpath("//a[@class='text-title-5']/parent::div/parent::div")).get(i).findElements(By.tagName("ds-selection"));

            for (int j = 0; j < resultColorList.size(); j++) {
                String selectedColor = getDriver().findElements(By.xpath("//a[@class='text-title-5']/parent::div/parent::div")).get(i).findElements(By.tagName("ds-selection")).get(j).getAttribute("ng-reflect-color");
                getReusableActionsInstance().javascriptScrollByVisibleElement(getDriver().findElements(By.xpath("//a[@class='text-title-5']/parent::div/parent::div")).get(i).findElements(By.tagName("ds-selection")).get(j));
                getReusableActionsInstance().scrollToElementAndClick(getDriver().findElements(By.xpath("//a[@class='text-title-5']/parent::div/parent::div")).get(i).findElements(By.tagName("ds-selection")).get(j));
                WebElement resultLink = getDriver().findElements(By.xpath("//a[@class='text-title-5']/parent::div/parent::div")).get(i).findElement(By.tagName("a"));
                getReusableActionsInstance().getWhenVisible(resultLink).sendKeys(Keys.ENTER);
                getReusableActionsInstance().staticWait(4000);
                String colorLabel;
                if (getDriver().getCurrentUrl().contains("watch")) {
                    colorLabel = getDriver().findElement(By.xpath("//div[contains(@class,'color-switch') and contains(@class,'active') and @style='display: block;']/a")).getAttribute("class").split("-")[0];
                } else {
                    colorLabel = getReusableActionsInstance().getWhenReady(By.xpath("//span[text()='Colour:']//following-sibling::span")).getText();
                }

                if (!selectedColor.equalsIgnoreCase(colorLabel)) {
                    blnFlag = false;
                    System.out.println(blnFlag);
                    System.out.println("Selected Color : " + selectedColor);
                    System.out.println("Actual Color : " + colorLabel);
                    break;
                }
                getDriver().navigate().back();
                getReusableActionsInstance().staticWait(1000);


            }

            getDriver().navigate().back();
            getReusableActionsInstance().staticWait(1000);


        }

        return blnFlag;
    }


    public boolean verifyResultsStorageLabelWithSelectedStorage() {

        boolean blnFlag = true;

        List<WebElement> lstStorageFilter = getDriver().findElements(By.xpath("//input[@name='storage']"));

        for (int i = 0; i < lstStorageFilter.size(); i++) {
            getReusableActionsInstance().waitForAllElementsVisible(getDriver().findElements(By.xpath("//input[@name='storage']")), 40);
            String strStorageFilter = getDriver().findElements(By.xpath("//input[@name='storage']")).get(i).getAttribute("value");

            System.out.println("value of storage filter is:" + getDriver().findElements(By.xpath("//input[@name='storage']")).get(i).getAttribute("value"));

            getReusableActionsInstance().staticWait(2000);

            getReusableActionsInstance().clickWhenReady(
                    By.xpath("//ds-checkbox[@ng-reflect-value='" + getDriver().findElements(By.xpath("//input[@name='storage']")).get(i).getAttribute("value") + "']"));
            getReusableActionsInstance().staticWait(2000);

            List<WebElement> lstStorageResultsLink = getDriver().findElements(By.xpath("//a[contains(@href,'storage')]"));

            for (int j = 0; j < lstStorageResultsLink.size(); j++) {

                System.out.println("Storage results link list:" + getDriver().findElements(By.xpath("//a[contains(@href,'storage')]")).get(j).getText());

                getReusableActionsInstance().getWhenVisible(getDriver().findElements(By.xpath("//a[contains(@href,'storage')]")).get(j)).sendKeys(Keys.ENTER);
                //getReusableActionsInstance().staticWait(4000);

                //getReusableActionsInstance().clickWhenReady(lstStorageResultsLink.get(j));

                getReusableActionsInstance().staticWait(5000);

                WebElement storageLabel = getDriver().findElement(By.xpath("//span[text()='Storage:']//following-sibling::span"));
                getReusableActionsInstance().waitForElementVisibility(storageLabel);
                System.out.println("Storage Label is:" + storageLabel.getText().replaceAll("\\s", ""));
                System.out.println("Storage filter value is:" + strStorageFilter);

                //System.out.println(strStorageFilter.equalsIgnoreCase(storageLabel.getText()));
                if (!(strStorageFilter.equalsIgnoreCase(storageLabel.getText().replaceAll("\\s", "")))) {

                    blnFlag = false;
                    System.out.println("Inside if loop");
                    break;

                }

                System.out.println("Before Navigation");
                getDriver().navigate().back();
                System.out.println("After Navigation");
                getReusableActionsInstance().staticWait(4000);


            }
            if (blnFlag == false) {

                break;
            }

            getReusableActionsInstance().waitForElementVisibility(getDriver().findElement(By.xpath("//input[@name='storage']")), 40);

            //getReusableActionsInstance().clickWhenReady(By.xpath("//ds-checkbox[@ng-reflect-value='"+lstStorageFilter.get(i).getAttribute("value")+"']"));
            getReusableActionsInstance().clickWhenReady(By.xpath("//ds-checkbox[@ng-reflect-value='" + strStorageFilter + "']"));


        }

        return blnFlag;
    }

    public boolean verifyResultsSizeLabelWithSelectedSize() {

        boolean blnFlag = true;


        List<WebElement> lstSizeFilter = getDriver().findElements(By.xpath("//input[contains(@id,'size')]"));

        for (int i = 0; i < lstSizeFilter.size(); i++) {
            //   getReusableActionsInstance().waitForElementVisibility(getDriver().findElements(By.xpath("//input[contains(@id,'size')]");
            String strSizeFilter = getDriver().findElements(By.xpath("//input[contains(@id,'size')]")).get(i).getAttribute("value");
            //  String strSizeFilter = lstSizeFilter.get(i).getAttribute("value");

            System.out.println("value of size filter is:" + getDriver().findElements(By.xpath("//input[contains(@id,'size')]")).get(i).getAttribute("value"));
            // System.out.println("value of size filter is: "+strSizeFilter+" ");

            // getReusableActionsInstance().staticWait(2000);

            getReusableActionsInstance().clickWhenReady(
                    By.xpath("//ds-checkbox[@ng-reflect-value='" + getDriver().findElements(By.xpath("//input[contains(@id,'size')]")).get(i).getAttribute("value") + "']"));
            //   By.xpath("//ds-checkbox[@ng-reflect-value='" +strSizeFilter + " ']"));
            // "//ds-checkbox[@id='Shop_Wireless_storage_"+strStorage+"-host']"

            getReusableActionsInstance().staticWait(2000);

            List<WebElement> lstSizeResultsLink = getDriver().findElements(By.xpath("//a[contains(@href,'watch')]"));

            for (int j = 0; j < lstSizeResultsLink.size(); j++) {

                System.out.println("Size results link list:" + getDriver().findElements(By.xpath("//a[contains(@href,'watch')]")).get(j).getText());

                getReusableActionsInstance().getWhenVisible(getDriver().findElements(By.xpath("//a[contains(@href,'watch')]")).get(j)).sendKeys(Keys.ENTER);
                //getReusableActionsInstance().staticWait(4000);

                //getReusableActionsInstance().clickWhenReady(lstStorageResultsLink.get(j));

                getReusableActionsInstance().staticWait(5000);


                // WebElement sizelabelvalue = getDriver().findElement(By.xpath("//a[text()=" + getDriver().findElements(By.xpath("//input[contains(@id,'size')]")).get(i).getAttribute("value") + " ]"));
                WebElement sizelabel = getDriver().findElement(By.xpath("//div[contains(@class,'common-devices') and contains(@class,'active')]//div[contains(@class,'size-switch') and contains(@class,'active')]/a"));
                getReusableActionsInstance().waitForElementVisibility(sizelabel);
                System.out.println("Size Label is:" + sizelabel.getText());
                System.out.println("Size filter value is:" + strSizeFilter);

                //System.out.println(strStorageFilter.equalsIgnoreCase(storageLabel.getText()));

                //  if (!strSizeFilter.equalsIgnoreCase(sizeLabel.getText()) || !sizeLabel.isSelected()) {
                if (!strSizeFilter.equalsIgnoreCase(sizelabel.getText())) {

                    blnFlag = false;
                    System.out.println("Inside if loop");
                    break;

                }

                /*    if (strSizeFilter.equalsIgnoreCase(sizelabelvalue.getText()) && sizeLabel.getAttribute("class").contains("active")) {


                    blnFlag = true;
                    System.out.println("Inside if loop");
                    break;

                }

                 */


                System.out.println("Before Navigation");
                getDriver().navigate().back();
                System.out.println("After Navigation");
                getReusableActionsInstance().staticWait(4000);


            }
            if (blnFlag == false) {

                break;
            }

            getReusableActionsInstance().waitForElementVisibility(getDriver().findElement(By.xpath("//input[contains(@id,'size')]")), 40);

            //getReusableActionsInstance().clickWhenReady(By.xpath("//ds-checkbox[@ng-reflect-value='"+lstStorageFilter.get(i).getAttribute("value")+"']"));
            getReusableActionsInstance().clickWhenReady(By.xpath("//ds-checkbox[@ng-reflect-value='" + strSizeFilter + "']"));


        }

        return blnFlag;

    }


    public boolean verifyChildFilterSelection() {

        boolean blnFlag = true;

        List<WebElement> lstColorFilter = getDriver().findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]"));

        for (int i = 0; i < 1; i++) {

            System.out.println("value of color filter is:" + getDriver().findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value"));

            getReusableActionsInstance().staticWait(2000);

            getReusableActionsInstance().clickWhenReady(By.xpath("//span[starts-with(text(),'" + getDriver().findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value") + "')]"));
            getReusableActionsInstance().staticWait(2000);

            List<WebElement> lstColorResults = getDriver().findElements(By.xpath("//span[starts-with(@style,'background: ')]"));

            for (int j = 0; j < lstColorResults.size(); j++) {

                System.out.println("value of Color Result is:" + lstColorResults.get(j).getAttribute("style"));

                String[] strColorResult = lstColorResults.get(j).getAttribute("style").split(" ");

                getReusableActionsInstance().getWhenReady(getDriver().findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i), 20);

                System.out.println("Before if statement - value of strColorResult is:" + strColorResult[1].replaceAll(";", ""));
                System.out.println("Before if statement - value of color filter is:" + getDriver().findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value"));

                if (!(getDriver().findElements(By.xpath("//input[@type='checkbox' and contains(@id,'color')]")).get(i).getAttribute("value").equalsIgnoreCase(strColorResult[1].replaceAll(";", "")))) {

                    blnFlag = false;
                    break;

                }

            }

            getReusableActionsInstance().staticWait(2000);

        }

        return blnFlag;

    }


    public boolean validateResultsTag(String strGrandParentFilter, String strParentFilter) {
        String[] strParentFilterName = strParentFilter.split("\\(");
        String strExpectedTag = strGrandParentFilter.trim() + " - " + strParentFilterName[0].trim();
        getReusableActionsInstance().waitForAllElementsToBeRefreshedAndVisible(By.xpath("//app-search-results//span[contains(@class,'categorylbl')]"), 10);
        List<WebElement> resultlinkTags = getDriver().findElements(By.xpath("//app-search-results//span[contains(@class,'categorylbl')]"));
        for (int counter = 0; counter < resultlinkTags.size(); counter++) {
            String actualValue = resultlinkTags.get(counter).getText();
            if (!(resultlinkTags.get(counter).getText().equalsIgnoreCase(strExpectedTag))) {
                return false;
            }
        }
        return true;
    }

    public boolean validateResultsTag(String strGrandParentFilter) {
        isPageLoaded();
        String strExpectedTag = strGrandParentFilter.trim() + " - ";
        List<WebElement> resultlinkTags = getDriver().findElements(By.xpath("//app-search-results//span[contains(@id,'searchcategory')]"));
        for (int counter = 0; counter < resultlinkTags.size(); counter++) {
            String tag = (resultlinkTags.get(counter).getText());
            if (!tag.startsWith(strExpectedTag)) {
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

        List<WebElement> parentFiltersList = getDriver().findElements(By.xpath("//p[starts-with(text(),'Shop')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p"));

        for (int parentFilterCounter = 0; parentFilterCounter < 1; parentFilterCounter++) {
            getReusableActionsInstance().staticWait(4000);
            //System.out.println("Sub Filter values:" + parentFiltersList.get(parentFilterCounter).getText());
            System.out.println("Sub Filter values:" + getDriver().findElements(By.xpath("//p[starts-with(text(),'Shop')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p")).get(parentFilterCounter).getText());


            getReusableActionsInstance().javascriptScrollToTopOfPage();
            getReusableActionsInstance().clickWhenReady(By.xpath("//p[starts-with(text(),'Shop')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p[starts-with(text(),'" + parentFiltersList.get(parentFilterCounter).getText() + "')]"), 20);
            //getReusableActionsInstance().javascriptScrollByVisibleElement(getDriver().findElement(By.xpath("//p[starts-with(text(),'Shop')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p[starts-with(text(),'"+ parentFiltersList.get(parentFilterCounter).getText() + "')]")));
            //getReusableActionsInstance().staticWait(4000);
            //getReusableActionsInstance().scrollToElementAndClick(getDriver().findElement(By.xpath("//p[starts-with(text(),'Shop')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p[starts-with(text(),'"+ parentFiltersList.get(parentFilterCounter).getText() + "')]")));

            //getReusableActionsInstance().javascriptScrollByVisibleElement(getDriver().findElements(By.xpath("//p[starts-with(text(),'Shop')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p")).get(parentFilterCounter));
            //getReusableActionsInstance().staticWait(4000);
            //getReusableActionsInstance().scrollToElementAndClick(getDriver().findElements(By.xpath("//p[starts-with(text(),'Shop')]/ancestor::button//following-sibling::ds-expander//ds-accordion-panel[contains(@class,'-sub-level')]/div/button/div/div/p")).get(parentFilterCounter));

            System.out.println("After clicking sub filter" + getDriver().getCurrentUrl());

            getReusableActionsInstance().staticWait(1000);
            List<WebElement> lstResultsWithCategoryTags = getDriver().findElements(By.xpath("//span[contains(@class,'categorylbl')]"));
            for (int categoryTagsCounter = 0; categoryTagsCounter < lstResultsWithCategoryTags.size(); categoryTagsCounter++) {

                getReusableActionsInstance().staticWait(500);
                String[] strTagText = getReusableActionsInstance().getWhenReady(getDriver().findElements(By.xpath("//span[contains(@class,'categorylbl')]")).get(categoryTagsCounter), 10).getText().split("-");
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
        return getReusableActionsInstance().isElementVisible(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button" +
                "//p[starts-with(text(),'" + strGrandParentFilterName + "')]"));
    }

    public boolean isParentFilterDisplayed(String strGrandParentFilterName, String strParentFilterName) {
        return getReusableActionsInstance().isElementVisible(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button" +
                "//p[starts-with(text(),'" + strGrandParentFilterName + "')]/ancestor::button/following-sibling::ds-expander" +
                "//p[starts-with(text(),'" + strParentFilterName + "')]"));
    }

    public void clkParentFilter(String strGrandParentFilterName, String strParentFilterName) {
        /**  getReusableActionsInstance().clickWhenReady(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button" +
         "//p[starts-with(text(),'"+strGrandParentFilterName+"')]/ancestor::button/following-sibling::ds-expander" +
         "//p[starts-with(text(),'"+strParentFilterName+"')]"));
         */
        getReusableActionsInstance().clickWhenReady(By.xpath("//div[contains(@id,'" + strGrandParentFilterName + "-body')]/div/button[contains(@id,'" + strParentFilterName + "')]"));

        getReusableActionsInstance().staticWait(1500);
    }

    public List<String> getStorageSelections() {
        List<String> strStorageSelections = new ArrayList<String>();
        List<WebElement> chkStorageSelections = getDriver().findElements(By.xpath("//input[@name='storage']"));
        for (int i = 0; i < chkStorageSelections.size(); i++) {
            strStorageSelections.add(chkStorageSelections.get(i).getAttribute("value"));
        }
        return strStorageSelections;
    }

    public List<String> getColorSelections() {
        List<String> strColorSelections = new ArrayList<String>();
        List<WebElement> chkColorSelections = getDriver().findElements(By.xpath("//input[@name='color']"));
        for (int i = 0; i < chkColorSelections.size(); i++) {
            strColorSelections.add(chkColorSelections.get(i).getAttribute("value"));
        }
        return strColorSelections;
    }

    public void clkStorageType(String strStorage) {
        //getReusableActionsInstance().javascriptScrollToTopOfPage();
        WebElement element = getDriver().findElement(By.xpath("//ds-checkbox[@id='Shop_Wireless_storage_" + strStorage + "-host']"));
        Actions action = new Actions(getDriver());
        action.moveToElement(element).click().build().perform();
        // getReusableActionsInstance().clickWhenReady(By.xpath("//ds-checkbox[@ng-reflect-value='" + strStorage + "']/label/div[1]"));
        getReusableActionsInstance().staticWait(1000);
    }

    public void clkColorType(String strColor) {
        getReusableActionsInstance().javascriptScrollToTopOfPage();
        getReusableActionsInstance().clickWhenReady(By.xpath("//span[contains(@class,'color') and starts-with(text(),'" + strColor + "')]"));
        isPageLoaded();
    }

    public List<WebElement> getAllResultLinks() {
        return getDriver().findElements(By.xpath("//a[contains(@id,'searchtitle')]"));
    }

    public void clkResultLink(WebElement resultLink) {
        getReusableActionsInstance().javascriptScrollToTopOfPage();
        getReusableActionsInstance().clickWhenReady(resultLink);
    }

    /*   public boolean isParentFilterExpanded(String strGrandParentFilter, String strParentFilter) {
           return isParentFilterExpanded(getDriver().findElement(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button" +
                   "//p[starts-with(text(),'"+strGrandParentFilter+"')]/ancestor::button/following-sibling::ds-expander" +
                   "//p[starts-with(text(),'"+strParentFilter+"')]")));
       }

     */
    public boolean isParentFilterExpanded(String strGrandParentFilter, String strParentFilter) {
        WebElement isParentFilterExpanded = getDriver().findElement(By.xpath("//button[contains(@id,'" + strGrandParentFilter + "-heading')]/following-sibling::ds-expander//button[contains(@id,'" + strParentFilter + "')]/following-sibling::ds-expander"));

        return isParentFilterExpanded.getAttribute("ng-reflect-expanded").equals("true");

    }


    public void clkResetAllFilters() {
        getReusableActionsInstance().clickWhenReady(btnResetAllFilters);
    }

    public boolean validateAllFiltersCollapsed() {
        boolean collapsedFlag = true;
        List<WebElement> grandParentFilters = getDriver().findElements(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button//p"));
        for (int i = 0; i < grandParentFilters.size(); i++) {
            if (isGrandParentFilterExpanded(grandParentFilters.get(i).getText())) {
                collapsedFlag = false;
            }
        }
        return collapsedFlag;
    }

    public void clkDeviceType(String strDeviceType) {
        //getReusableActionsInstance().javascriptScrollToTopOfPage();
        getReusableActionsInstance().clickWhenReady(By.xpath("//ds-checkbox[@id='Shop_Wireless_devicetype_" + strDeviceType + "-host']"));
        getReusableActionsInstance().staticWait(1000);
    }

    public void clkBrandType(String strBrandType) {
        // getReusableActionsInstance().javascriptScrollToTopOfPage();
        getReusableActionsInstance().clickWhenReady(By.xpath("//ds-checkbox[@id='Shop_Wireless_brand_" + strBrandType + "-host']"));
        getReusableActionsInstance().staticWait(1000);
    }

    public boolean validateResultsLinks() {
        List<WebElement> resultlinks = getDriver().findElements(By.xpath("//app-search-results//span[contains(@class,'categorylbl')]/preceding-sibling::a"));
        for (int counter = 0; counter < resultlinks.size(); counter++) {
            if (!(resultlinks.get(counter).getAttribute("href").equals(""))) {
                return true;
            }
        }
        return false;
    }

    public void clkSizeType(String strSize) {
        getReusableActionsInstance().clickWhenReady(By.xpath("//ds-checkbox[@ng-reflect-value='" + strSize + "']"));
        getReusableActionsInstance().javascriptScrollToTopOfPage();
        getReusableActionsInstance().staticWait(1500);
    }

    public List<String> getSizeSelections() {
        List<String> strSizeSelections = new ArrayList<String>();
        List<WebElement> chkSizeSelections = getDriver().findElements(By.xpath("//input[contains(@id,'size')]"));
        for (int i = 0; i < chkSizeSelections.size(); i++) {
            strSizeSelections.add(chkSizeSelections.get(i).getAttribute("value"));
        }
        return strSizeSelections;
    }

    public void clkOnMagnifyingLens() {
        txtSearch.sendKeys(Keys.ENTER);
        System.out.println("Enter key is clicked");
        getReusableActionsInstance().staticWait(4000);
    }

    public boolean validateURLContains(String strQuery) throws UnsupportedEncodingException {
        String strUrl = URLDecoder.decode(getDriver().getCurrentUrl(), StandardCharsets.UTF_8.name());
        boolean blnFlag = false;
        if (strUrl.contains(strQuery.trim())) {
            blnFlag = true;
        }
        return blnFlag;
    }

    public void clkCloseSearchIcon() {
        txtSearchCloseIcon.click();
    }

    public boolean validateSearchBoxIsEmpty() {
        boolean blnFlag = false;
        String txtSearchValue = txtSearch.getAttribute("ng-reflect-value");
        if (txtSearchValue.isEmpty()) {
            blnFlag = true;
        }
        return blnFlag;
    }

    public boolean isNoResultsDisplayed() {
        return getReusableActionsInstance().isElementVisible(lblNoResultsMsg);
    }

    public void hoverSuggestionsType(String strSuggestions) {
        WebElement suggestionValue = getDriver().findElement(By.xpath("//span[(@class='ds-link__wrapper d-inline-block text-button')]/span[text()='" + " " + strSuggestions + " " + "']"));
        getReusableActionsInstance().scrollToElement(suggestionValue);
        getReusableActionsInstance().javascriptScrollToTopOfPage();
        getReusableActionsInstance().staticWait(1500);
    }

    public boolean verifyLeftSectionInnerHTML() {
        boolean blnFlag = true;

        String strInnerHTML = firstSectionValues.getAttribute("innerHTML");
        System.out.println("Value of Inner HTML is:" + strInnerHTML);
        List<String> lstInnerHTML = new ArrayList<String>();
        lstInnerHTML.add(strInnerHTML);

        for (int i = 0; i < lstInnerHTML.size() - 1; i++)
            for (int j = i + 1; j < lstInnerHTML.size(); j++)
                if (lstInnerHTML.get(i) == lstInnerHTML.get(j)) {
                    blnFlag = false;
                }

        return blnFlag;
    }

    public List<String> getSuggestionSelections() {
        List<String> strSuggestionSelections = new ArrayList<String>();
        List<WebElement> hoverSuggestionSelections = getDriver().findElements(By.xpath("//div[@ng-reflect-heading='Suggestions']/a/div/span/span[@class='ds-link__copy']"));
        for (int i = 0; i < hoverSuggestionSelections.size(); i++) {
            strSuggestionSelections.add(hoverSuggestionSelections.get(i).getText());
        }
        return strSuggestionSelections;
    }

    public boolean isSuggestionsSectionDisplayed() {
        return getReusableActionsInstance().isElementVisible(suggestionsSection);
    }

    public boolean isSuggestionsSectionPopulated() {
        return suggestionsSectionLinks.size() != 0;
    }

    public boolean isSupportSectionDisplayed() {
        return getReusableActionsInstance().isElementVisible(supportSection, 1);
    }

    public boolean isSupportSectionPopulated() {
        return getReusableActionsInstance().isElementVisible(supportSectionLinks, 1);
    }

    public boolean isLeftSectionPopulated() {
        return getReusableActionsInstance().isElementVisible(leftSectionResults, 1);
    }

    public String getLeftSectionInnerhtml() {
        return leftSectionResults.getAttribute("innerHTML");
    }

    public String getSupportInnerhtml() {
        return supportSection.getAttribute("innerHTML");
    }

    public boolean validateSupportLinks() {
        for (int i = 0; i < suggestionsSectionLinks.size(); i++) {
            if (suggestionsSectionLinks.get(i).getAttribute("href") == null) {
                return false;
            }
        }
        return true;
    }

    public void clkSuggestionsType(String strSuggestion) {
        getReusableActionsInstance().clickWhenReady(By.xpath("//div[@ng-reflect-heading='Suggestions']//span[starts-with(text(),' " + strSuggestion + "')]"));
    }

    public boolean validateFiltersInUrl(String strGrandParentFilter, String strParentFilter) throws UnsupportedEncodingException {
        String strQuery = "f=" + strGrandParentFilter.trim() + "_" + strParentFilter.trim();
        return validateURLContains(strQuery);
    }

    public boolean validateDeviceTypesInUrl(String[] strDeviceType) throws UnsupportedEncodingException {
        String strQuery = "devicetype:";
        for (int i = 0; i < strDeviceType.length; i++) {
            strQuery = strQuery + strDeviceType[i].trim();
            if (i != strDeviceType.length - 1) {
                strQuery = strQuery + ",";
            }
        }
        return validateURLContains(strQuery);
    }

    public boolean validateBrandsInUrl(String[] strBrand) throws UnsupportedEncodingException {
        String strQuery = "brand:";
        for (int i = 0; i < strBrand.length; i++) {
            strQuery = strQuery + strBrand[i].trim();
            if (i != strBrand.length - 1) {
                strQuery = strQuery + ",";
            }
        }
        return validateURLContains(strQuery);
    }

    public boolean validateStoragesInUrl(String[] strStorage) throws UnsupportedEncodingException {
        String strQuery = "storage:";
        for (int i = 0; i < strStorage.length; i++) {
            strQuery = strQuery + strStorage[i].trim();
            if (i != strStorage.length - 1) {
                strQuery = strQuery + ",";
            }
        }
        return validateURLContains(strQuery);
    }

    public boolean validateColorsInUrl(String[] strColor) throws UnsupportedEncodingException {
        String strQuery = "color:";
        for (int i = 0; i < strColor.length; i++) {
            strQuery = strQuery + strColor[i].trim();
            if (i != strColor.length - 1) {
                strQuery = strQuery + ",";
            }
        }
        return validateURLContains(strQuery);
    }

    public boolean isFilterChecked(String strFilter) {
        return getReusableActionsInstance().getWhenReady(By.xpath("//ds-checkbox//input[@value='" + strFilter.trim() + "']"))
                .getAttribute("aria-checked").equals("true");
    }

    public boolean validateGrandParentFiltersCount(int count) {
        // return getDriver().findElements(By.xpath("//div[@class='ds-filter__listSet']/div[contains(@class,'ds-border-bottom')]"))
        //       .size()==count;
        return grandParentFilters.size() == count;
    }

    public String getResultWindowText() {
        getReusableActionsInstance().waitForElementTextToBe(resultsCountAndPageDetails, " ", 10);
        return resultsCountAndPageDetails.getText();
    }

    public boolean verifyResultWindowText(String strExpectedText) {
        getReusableActionsInstance().waitForElementTextToBe(resultsCountAndPageDetails, strExpectedText, 4);
        return true;
    }

    public List<String> getColorFilters() {
        List<String> colorFilters = new ArrayList<String>();
        List<WebElement> colorFilterElements = getDriver().findElements(By.xpath("//span[contains(@class,'checkbox-color-copy')]"));
        for (int i = 0; i < colorFilterElements.size(); i++) {
            colorFilters.add(colorFilterElements.get(i).getText().split("\\(")[0].trim());
        }
        return colorFilters;
    }

    public boolean validateResultsColor(String strColor) {
        List<WebElement> resultColoursList = getDriver().findElements(By.xpath("//app-search-results//ds-selection[@ng-reflect-type='color']"));
        for (int i = 0; i < resultColoursList.size(); i++) {
            //  if(resultColoursList.get(i).getAttribute("ng-reflect-checked").equals("true"))
            //return true;

            /**   if(!(resultColoursList.get(i).getAttribute("ng-reflect-value")
             .trim().toLowerCase().equals(strColor.toLowerCase()))) {
             return false;
             } */
            if ((resultColoursList.get(i).getAttribute("ng-reflect-value")
                    .trim().toLowerCase().equals(strColor.toLowerCase()))) {
                return resultColoursList.get(i).getAttribute("ng-reflect-checked").equals("true");

            }

        }
        return true;
    }

    public List<String> getResultColorOptions(WebElement resultLink) {
        List<String> colorOptions = new ArrayList<String>();
        List<WebElement> resultColorOptions = resultLink.findElements(By.xpath("parent::div/following-sibling::ds-radio-group//ds-selection"));
        for (int i = 0; i < resultColorOptions.size(); i++) {
            colorOptions.add(resultColorOptions.get(i).getAttribute("ng-reflect-value"));
        }
        return colorOptions;
    }

    public void clkResultColor(WebElement resultLink, String strColor) {
        getReusableActionsInstance().javascriptScrollToTopOfPage();
        WebElement resultColor = resultLink.findElement(By.xpath("parent::div/following-sibling::ds-radio-group//ds-selection[@ng-reflect-value='" + strColor + "']"));
        getReusableActionsInstance().clickWhenReady(resultColor);
    }

    public void isPageLoaded() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        for (int i = 0; i < 60; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }

        }
    }

    public void clkShopFilter() {

        getReusableActionsInstance().clickWhenReady(By.xpath("//button[contains(@id,'Shop-heading')]"));
        isPageLoaded();
    }

    public void clkWirelessFilter() {
        getReusableActionsInstance().scrollToElement(Wireless);
        getReusableActionsInstance().clickWhenReady(Wireless);
        isPageLoaded();
    }

    public String numberOfResults() {
        return getReusableActionsInstance().getElementText(resultsCount);
    }

    public boolean stringMatch(String a, String b) {
        boolean equalFlag = true;
        if (!a.equals(b)) {
            equalFlag = false;
        }
        return equalFlag;
    }

    public boolean waitTime() {
        boolean status;
        Long loadTime;
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        try {
            loadTime = (Long) js.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
            Thread.sleep(loadTime);
            status = true;
        } catch (TimeoutException | InterruptedException e) {
            status = false;
        }
        return status;
    }

    /**
     * Click on the top search icon
     *
     * @author naina.agarwal
     */
    public void clickSearchIcon() {
        getReusableActionsInstance().clickWhenReady(searchTextIcon);
    }

    /**
     * Enter the search text in the search text box
     *
     * @author naina.agarwal
     */
    public void enterTextToBeSearched(String searchText) {
        getReusableActionsInstance().enterText(searchTextBox, searchText, 1000);
    }

    /**
     * Check the number of results displayed or return no result if none are found
     *
     * @author naina.agarwal
     */
    public String getSearchResults() {
        if (getReusableActionsInstance().isElementVisible(searchResults) == true) {
            return getReusableActionsInstance().getElementText(resultsCount);
        } else {
            return "No result";
        }
    }

    /**
     * Click the submit search icon in the search text box after entering text
     *
     * @author naina.agarwal
     */
    public void clickSubmitSearchIcon() {
        getReusableActionsInstance().clickWhenReady(submitSearchIcon);
    }

    /**
     * Check if Page 1 of the pagination is highlighted
     *
     * @author naina.agarwal
     */
    public boolean isFirstPageNumberHighlighted() {
        return getReusableActionsInstance().isElementVisible(firstPagePaginationHighlighted);
    }
public void javascriptClickWithPerform(WebElement element)
{
    try {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
        js.executeScript("arguments[0].click();", element);
    }
    catch (Exception e)
    {
        throw new DigiAutoCustomException(e);}
}
    /**
     * Click on page 2 from the bottom pagination
     *
     * @author naina.agarwal
     */
    public String selectPageTwo() {

        String message =null;
        isPagePresent = getDriver().findElements(numberOfPagesDisplayedAtBottom).size() > 1;
        if(isPagePresent) {
            javascriptClickWithPerform(page2);
            message ="Page 2 is present and it is clicked";
        }
        else
        {
            message = "Cannot select page 2 as only one page exist";
        }
        return message;
    }

    /**
     * Check if Page 2 of the pagination is highlighted
     *
     * @author naina.agarwal
     */
    public String isSecondPageNumberHighlighted() {

        String message =null;
        isPagePresent = getDriver().findElements(numberOfPagesDisplayedAtBottom).size() > 1;
        if(isPagePresent) {
            getReusableActionsInstance().isElementVisible(secondPagePaginationHighlighted);
            message ="Page 2 is highlighted";
        }
        else
        {
            message = "Page 2 is not highlighted";
        }
        return message;
    }

    /**
     * Check if url contains page number info same as selected from the pagination component.
     * For eg : URL should contain 2 if page 2 was selected in pagination
     *
     * @author naina.agarwal
     */
    public String validatePageNumberInURL(String url) {
        String message =null;
        String currentPageNumberInPagination = getReusableActionsInstance().getElementText(currentPageNumberHighlighted);
        isPagePresent = getDriver().findElements(numberOfPagesDisplayedAtBottom).size() > 1;
        if (isPagePresent) {
            if (!url.endsWith("=" + currentPageNumberInPagination)) {
                message = "Page number on Pagination and URL does not match";
            }
            else
            {
                message = "Page number on Pagination and URL match";
            }
        }
        else {
            message = "There is only one page";
        }
        return message;
    }
    /**
     * This method will check if page size selected mataches with the URL
     *
     * @author naina.agarwal
     */
    public boolean validatePageSizeInURL(String url) {
        Boolean urlFlag = true;
        int list = 0;
        Select dropdown = new Select(resultPerPageDropdown);
        //Get all options
        WebElement option = dropdown.getFirstSelectedOption();
        String defaultItem = option.getText().trim();
        String pageSize="psize="+defaultItem;
        if (!url.contains(pageSize)) {
            urlFlag = false;
        }
        return urlFlag;
    }

    public boolean validateSearchResultNumberAreInSyncWithPagination() {
        boolean expectedSearchResultNumber = true;
        int currentPageNumberInPagination = Integer.parseInt(getReusableActionsInstance().getElementText(currentPageNumberHighlighted));
        String expectedSearchResultNumberStartsWith = Integer.toString((currentPageNumberInPagination - 1) * 10 + 1);
        String actualSearchResultOnPage = getReusableActionsInstance().getElementText(searchResults);
        String firstPartOfSearchResult = actualSearchResultOnPage.split("-")[0];
        if (!firstPartOfSearchResult.equals(expectedSearchResultNumberStartsWith)) {
            return expectedSearchResultNumber = false;
        }
        return expectedSearchResultNumber;
    }

    /**
     * Clicking on a random page number out of the total pages in the pagination component
     * and this method will return a random page number of out of all pages
     *
     * @author naina.agarwal
     */
    public int clickOnRandomPageNumber() {
        List<WebElement> elementName = getDriver().findElements(numberOfPagesDisplayedAtBottom);
        int numberOfPages = elementName.size();
        int randomNumber = randomNumber(numberOfPages);
        String randomPageXpath = "//button[@title='Page " + randomNumber + "']";
        System.out.println("xpath is" + randomPageXpath);
        WebElement randomPageTobeSelected = getDriver().findElement(By.xpath(randomPageXpath));
        getReusableActionsInstance().executeJavaScriptClick(randomPageTobeSelected);
        isPageLoaded();
        return randomNumber;
    }

    /**
     * To generate a random number between 1 and a upperlimit passed by user
     *
     * @author naina.agarwal
     */
    public int randomNumber(int upperLimit) {
        Random rand = new Random();
        int n = rand.nextInt(upperLimit);
        n += 1;
        return n;
    }

    /**
     * To method will check the number of results on a page should be <=10 by default
     *
     * @author naina.agarwal
     */
    public boolean validateNumberOfSearchResultsOnPage(List resultsInPage) {
        Boolean numberOfResultsOnAPage = false;
        int numberOfResults = resultsInPage.size();
        System.out.println("The number of results are" + numberOfResults);
        if (numberOfResults <= 10) {
            numberOfResultsOnAPage = true;
        }
        return numberOfResultsOnAPage;
    }

    /**
     * To method will select a random value from the result per page dropdown
     *
     * @author naina.agarwal
     */
    public String selectRandomValueFromResultPerPageDropdown() {

        int list = 0;
        Select dropdown = new Select(resultPerPageDropdown);
        //Get all options
        List<WebElement> dd = dropdown.getOptions();
        //Get the length
        System.out.println("size dropdown size " + dd.size());
        // Loop to print one by one
        for (int j = 0; j < dd.size(); j++) {
            System.out.println("**" + dd.get(j).getText());
        }
        Random rand = new Random();
        for (WebElement select : dd) {

            list = rand.nextInt(dd.size());
            dd.get(list).click();
            System.out.println("element selected is" + dd.get(list).getText());
            break;
        }
        return dd.get(list).getText();

    }
    /**
     * This method will check if default value of page size dropdown is 10
     *
     * @author naina.agarwal
     */
    public boolean validateDefaultResultDropdownValue()
    {
        boolean pageSizeDefaultValue=true;
        Select dropdown = new Select(resultPerPageDropdown);
        //Get all options
        WebElement option = dropdown.getFirstSelectedOption();
        String defaultItem = option.getText().trim();
        if (!defaultItem.equals("10"))
        {
            pageSizeDefaultValue=false;
        }
        return pageSizeDefaultValue;
    }

    /**
     * To method extracts the total results displayed for the searched term
     *
     * @author naina.agarwal
     */
    public int totalResult() {
        int totalResultDisplayed = 0;
        String totalResult = getReusableActionsInstance().getElementText(resultsCount);
        String[] numbers = totalResult.split(" ");
        System.out.print("the result is " + numbers[2]);
        totalResultDisplayed = Integer.parseInt(numbers[2]);
        return totalResultDisplayed;
    }

    /**
     * To check if the result list is displayed correctly based on the random page selected from the dropdown
     *
     * @author naina.agarwal
     */
    public boolean validateResultsAfterPageSizeSelection(String randomPageSize, int totalResults) {
        int pageSize = 0;
        List<WebElement> resultLinks;
        resultLinks = getAllResultLinks();
        int resultSize = resultLinks.size();
        pageSize = Integer.parseInt(randomPageSize.trim());
        System.out.println("Total result displayed on top is " + totalResults);
        System.out.println("Page size selected is " + pageSize);
        System.out.println("Total result in list is " + resultSize);
        if (pageSize < totalResults && resultSize == pageSize)
            return true;
        else if (pageSize > totalResults && resultSize == totalResults)
            return true;
        else return false;
    }

    /**
     * To check if the number of results on the top is displayed correctly based on the random page selected from the dropdown
     *
     * @author naina.agarwal
     */
    public boolean verifyResultsOnTop(String randomPageSize, int totalResults) {
        int pageSize = 0;
        boolean verifyResult = false;
        String results;
        List<WebElement> resultLinks;
        resultLinks = getAllResultLinks();
        int resultSize = resultLinks.size();
        pageSize = Integer.parseInt(randomPageSize.trim());
        String searchResult = getReusableActionsInstance().getElementText(searchResults);
        String[] numbers = searchResult.split(" ");
        if (pageSize < totalResults && resultSize == pageSize) {
            results = "1-".concat(randomPageSize.trim());
            System.out.println("First if , result concat is " + results + "number[0] is " + numbers[0]);
            if (results.equals(numbers[0]))
                verifyResult = true;
        } else if (pageSize > totalResults && resultSize == totalResults) {
            results = "1-".concat(String.valueOf(totalResults));
            System.out.println("under else if , result concat is " + results + "number[0] is " + numbers[0]);
            if (results.equals(numbers[0]))
                return true;
        }
        return verifyResult;
    }
    /**
     * This method will click on the first forward arrow key if more than one page is present
     *
     * @author naina.agarwal
     */
    public String clickFirstForwardArrow() {

        String message = null;
        elementName = getDriver().findElements(numberOfPagesDisplayedAtBottom);
        int numberOfPages = elementName.size();
        if (numberOfPages > 1) {
            getReusableActionsInstance().clickWhenReady(firstForwardArrowKey);
            message = "Clicked on the forward arrow key";
        } else {
            message = "Cannot click on forward arraw key because available page is 1";
        }
        return message;
    }
    /**
     * This method will click on the first backward arrow key if more than one page is present
     *
     * @author naina.agarwal
     */
    public String clickFirstBackwardArrow() {
        String message = null;
        elementName = getDriver().findElements(numberOfPagesDisplayedAtBottom);
        int numberOfPages = elementName.size();
        if (numberOfPages > 1) {
            getReusableActionsInstance().executeJavaScriptClick(firstBackwardArrowKey);
            message = "Clicked on backward arrow key";
        } else {
            message = "Cannot click on backward arraw key because available page is 1";
        }
        return message;
    }
    /**
     * This method will click on the last forward arrow key if more than one page is present
     *
     * @author naina.agarwal
     */
    public String clickLastForwardArrow() {
        String message = null;
        elementName = getDriver().findElements(numberOfPagesDisplayedAtBottom);
        int numberOfPages = elementName.size();
        if (numberOfPages > 1) {
            getReusableActionsInstance().executeJavaScriptClick(lastForwardArrowKey);
            message = "Clicked on Last Forward arrow key";
        } else {
            message = "Cannot click on last forward arrow key because available page is 1";
        }
        return message;
    }

    /**
     * This method will check if last page is highlighted
     *
     * @author naina.agarwal
     */
    public boolean lastPageIsHighlighted() {
        Boolean highlighted = true;
        String currentPageNumberInPagination = getReusableActionsInstance().getElementText(currentPageNumberHighlighted);
        elementName = getDriver().findElements(numberOfPagesDisplayedAtBottom);
        int page1 = elementName.size();
        String pageSelected = elementName.get(page1 - 1).getText();
        if (!currentPageNumberInPagination.trim().equals(pageSelected.trim())) {
            highlighted = false;
        }
        return highlighted;
    }

    /**
     * This method will click on the last backward arrow if more than one page is present
     *
     * @author naina.agarwal
     */
    public String clickLastBackwardArrow() {
        String message = null;
        elementName = getDriver().findElements(numberOfPagesDisplayedAtBottom);
        int numberOfPages = elementName.size();
        if (numberOfPages > 1) {
            getReusableActionsInstance().executeJavaScriptClick(lastBackwardArrowKey);
            message = "Clicked on Last Backward arrow key";
        } else {
            message = "Cannot click on last Backward arrow key because available page is 1";
        }
        return message;

    }
    /**
     * This method will send a valid page number and page size to the url
     *
     * @author naina.agarwal
     */
    public String updateURLWithValidData()
    {
        String url1 =getDriver().getCurrentUrl();
        int index=0;
        int validPageNumber = clickOnRandomPageNumber();
        Select dropdown = new Select(resultPerPageDropdown);
        List<WebElement> list = dropdown.getOptions();
        String firstOption=list.get(0).getText().trim();
        System.out.println("first option is " + firstOption);
        //String validPazeSize = selectRandomValueFromResultPerPageDropdown().trim();
        int indexOfPsize=url1.indexOf("psize");
        String firstHalfURL=url1.substring(0,indexOfPsize);
        String secondHalfURL=url1.substring(indexOfPsize);
        secondHalfURL=secondHalfURL.replace(secondHalfURL,"psize=" +firstOption + "&pg=" +validPageNumber);
        String updatedURL=firstHalfURL.concat(secondHalfURL);
        getDriver().get(updatedURL);
        return updatedURL;
    }
    /**
     * This method will send a invalid page number and page size as 0 to the url
     *
     * @author naina.agarwal
     */
    public String updateURLWithInvalidData()
    {
        String url1 =getDriver().getCurrentUrl();
        int indexOfPsize=url1.indexOf("psize");
        String firstHalfURL=url1.substring(0,indexOfPsize);
        String secondHalfURL=url1.substring(indexOfPsize);
        secondHalfURL=secondHalfURL.replace(secondHalfURL,"psize=0&pg=0");
        String updatedURL=firstHalfURL.concat(secondHalfURL);
        getDriver().get(updatedURL);
        return updatedURL;
    }
    /**
     * This method will open a new tab in the browser with the current tab URL
     *
     * @author naina.agarwal
     */
    public void openURLInNewTab(String url)
    {
        //Open new tab
        ((JavascriptExecutor)getDriver()).executeScript("window.open('about:blank','_blank');");
        getReusableActionsInstance().switchToNewWindow();
        getDriver().get(url);
    }
    /**
     * This method will refresh the current page 5 times
     *
     * @author naina.agarwal
     */
    public void refreshPage()
    {
        for(int i=0; i<5;i++) {
            getDriver().navigate().refresh();
            isPageLoaded();
        }
    }
}



