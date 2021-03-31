package com.rogers.pages;

import com.rogers.pages.base.BasePageClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @FindBy(id = "ds-form-input-id-0")
    WebElement txtSearch;

    @FindBy(xpath = "//button[@title='Reset Filter']")
    WebElement btnResetAllFilters;

    @FindBy(xpath = "//button[@title='Close search']")
    WebElement txtSearchCloseIcon;

    @FindBy(xpath = "//app-search-noresults//span[contains(text(),'Sorry! No results found on')]")
    WebElement lblNoResultsMsg;

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

    @FindBy(xpath = "//div[@class='resultList']/div[1]")
    WebElement resultsCount;

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

    @FindBy(xpath = "//button[@title='Page 2']")
    WebElement page2;

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

    @FindBy(xpath = "(//a[@class='m-navLink -navbar']/span[@class='m-navLink__caption'])[3]")
    WebElement toggleLanguage;

    @FindBy(xpath = "(//span[@class='m-navLink__chevron rds-icon-expand'])[1]")
    WebElement provinceDropdown;

    @FindBy(xpath = "//dsa-selector[@data-test='color-selector']//span[@class='dsa-selector__header text-title-5']/following-sibling::span[1]")
    WebElement lblColorValue;

    public static final By FilterComponent = By.xpath("//div[@class='ds-filter__listWrapper']");

    public static final By PaginationComponent = By.xpath("//div[@class='d-flex ng-star-inserted']");

    public static final By titleOnDetailsPage = By.xpath("//h1[@id='bfa-page-title']");

    public static final By provinceDropdownValues = By.xpath("//ul[@class='o-headerNavDropdown -navbar nav-list-opened']/li/a");

    public static final By provinceInToggle = By.xpath("(//a[@class='m-navLink -navbar'])[2]");

    public static final By numberOfPagesDisplayedAtBottom = By.xpath("//div[@class='d-flex ng-star-inserted']/button/div");

    public static final By allGrandParentFilters = By.xpath("//button[contains(@id,'-heading')]/following-sibling::ds-expander/div");

    public static final By categoryLabelInResults = By.xpath("//span[contains(@class,'categorylbl')]");

    public static final By storageLabelInFilter = By.xpath("//input[@name='storage']");

    public static final By allColorsSwatchInResults = By.xpath("//ds-selection[@type='color']/label");

    public static final By allResultLinksTitle = By.xpath("//a[contains(@id,'searchtitle')]");

    Boolean isPagePresent = true;
    JavascriptExecutor js = null;
    List<WebElement> elementName;
    String pageTwoPresent = "Page 2 is present and it is clicked";
    String pageTwoNotPresent = "Cannot select page 2 as only one page exist";
    String pageTwoHighlighted = "Page 2 is highlighted";
    String pageTwoNotHighlighted = "Page 2 is not highlighted";
    String expectedDefaultPageSize = "10";
    String cannotClickLastForwKey = "Cannot click on last forward arrow key because available page is 1";
    String clickLastForwKey = "Clicked on last forward arrow key";
    String cannotClickLastBackKey = "Cannot click on last backward arrow key because available page is 1";
    String clickLastBackKey = "Clicked on last backward arrow key";
    String invalidSearchTerm = "@!#";

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
     * check if expected results tags are out of the search filters displayed
     *
     * @return true if displayed, otherwise false
     * @author pankaj.patil
     */

    public boolean verifyResultsCategoryTagRelevancy(String[] strFilterArray) {
        boolean blnFlag = false;
        int count = 0;
        try {
            getReusableActionsInstance().waitForElementVisibility(searchResults);
            List<WebElement> categoryTags = getDriver().findElements(categoryLabelInResults);
            List<String> strFilterValues = Arrays.asList(strFilterArray);
            for (int i = 0; i < categoryTags.size(); i++) {
                String[] strTagText = categoryTags.get(i).getText().split("-");
                if (!strFilterValues.contains(strTagText[0].trim())) {
                    count++;
                    break;
                }
            }
            if (count == 0)
                blnFlag = true;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
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
     * clicking on parent filter @return true if displayed, otherwise false
     *
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

    /**
     * Get list of parent filters from the grandparent filter
     *
     * @author pankaj.patil
     */
    public List<WebElement> getParentFilters(String strGrandParentFilterName) {
        return getDriver().findElements(By.xpath("//div[contains(@id,'" + strGrandParentFilterName + "-body')]/div/button"));
    }

    /**
     * Checks if parent filter is expanded. Return true if yes else return false
     *
     * @author pankaj.patil
     */
    public boolean isParentFilterExpanded(WebElement parentFilter) {
        return parentFilter.getAttribute("aria-expanded").equals("true");
    }

    /**
     * Checks if grand parent filter is expanded. Return true if yes else return false
     *
     * @author pankaj.patil
     */

    public boolean isGrandParentFilterExpanded(String strFilterName) {
        try {
            WebElement expandedFilter = getDriver().findElement(By.xpath("//button[contains(@id,'" + strFilterName + "-heading')]/following-sibling::ds-expander/div"));
            return expandedFilter.getAttribute("aria-hidden").equals("false");
        } catch (Exception e) {
            throw new DigiAutoCustomException(e);
        }
    }

    /**
     * clicking on shop grand parent filter and then wireless parent filter, return true if displayed, otherwise false
     *
     * @author pankaj.patil
     */

    public void clkShopAndThenWirelessFilter() {
        getReusableActionsInstance().clickWhenReady(By.xpath("//button[contains(@id,'Shop-heading')]"));
        getReusableActionsInstance().clickWhenReady(By.xpath("//div[contains(@id,'Shop-body')]/div/button[contains(@id,'Wireless-heading')]"));
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

    public boolean verifyResultsSizeLabelWithSelectedSize() {
        boolean blnFlag = true;
        List<WebElement> lstSizeFilter = getDriver().findElements(By.xpath("//input[contains(@id,'size')]"));
        for (int i = 0; i < lstSizeFilter.size(); i++) {
            String strSizeFilter = getDriver().findElements(By.xpath("//input[contains(@id,'size')]")).get(i).getAttribute("value");
            System.out.println("value of size filter is:" + getDriver().findElements(By.xpath("//input[contains(@id,'size')]")).get(i).getAttribute("value"));
            getReusableActionsInstance().clickWhenReady(
                    By.xpath("//ds-checkbox[@ng-reflect-value='" + getDriver().findElements(By.xpath("//input[contains(@id,'size')]")).get(i).getAttribute("value") + "']"));
            getReusableActionsInstance().staticWait(2000);
            List<WebElement> lstSizeResultsLink = getDriver().findElements(By.xpath("//a[contains(@href,'watch')]"));
            for (int j = 0; j < lstSizeResultsLink.size(); j++) {
                System.out.println("Size results link list:" + getDriver().findElements(By.xpath("//a[contains(@href,'watch')]")).get(j).getText());
                getReusableActionsInstance().getWhenVisible(getDriver().findElements(By.xpath("//a[contains(@href,'watch')]")).get(j)).sendKeys(Keys.ENTER);
                getReusableActionsInstance().staticWait(5000);
                WebElement sizelabel = getDriver().findElement(By.xpath("//div[contains(@class,'common-devices') and contains(@class,'active')]//div[contains(@class,'size-switch') and contains(@class,'active')]/a"));
                getReusableActionsInstance().waitForElementVisibility(sizelabel);
                System.out.println("Size Label is:" + sizelabel.getText());
                System.out.println("Size filter value is:" + strSizeFilter);
                if (!strSizeFilter.equalsIgnoreCase(sizelabel.getText())) {
                    blnFlag = false;
                    System.out.println("Inside if loop");
                    break;
                }
                System.out.println("Before Navigation");
                getDriver().navigate().back();
                System.out.println("After Navigation");
                getReusableActionsInstance().staticWait(4000);
            }
            if (!blnFlag) {
                break;
            }
            getReusableActionsInstance().waitForElementVisibility(getDriver().findElement(By.xpath("//input[contains(@id,'size')]")), 40);
            //getReusableActionsInstance().clickWhenReady(By.xpath("//ds-checkbox[@ng-reflect-value='"+lstStorageFilter.get(i).getAttribute("value")+"']"));
            getReusableActionsInstance().clickWhenReady(By.xpath("//ds-checkbox[@ng-reflect-value='" + strSizeFilter + "']"));
        }
        return blnFlag;
    }

    /**
     * Validates results tags are displayed correctly based on grandparent-parent filter selection
     *
     * @author pankaj.patil
     */
    public boolean validateResultsTag(String strGrandParentFilter, String strParentFilter) {
        boolean resultTag = false;
        int count = 0;
        String[] strParentFilterName = strParentFilter.split("\\(");
        String strExpectedTag = strGrandParentFilter.trim() + " - " + strParentFilterName[0].trim();
        getReusableActionsInstance().waitForAllElementsToBeRefreshedAndVisible(categoryLabelInResults, 10);
        List<WebElement> resultlinkTags = getDriver().findElements(categoryLabelInResults);
        for (int counter = 0; counter < resultlinkTags.size(); counter++) {
            String actualValue = resultlinkTags.get(counter).getText();
            if (!(actualValue.equalsIgnoreCase(strExpectedTag))) {
                count++;
            }
        }
        if (count == 0)
            resultTag = true;
        return resultTag;
    }

    /**
     * check if expected result tag is displayed for selected grandparent filter
     *
     * @return true if displayed, otherwise false
     * @author pankaj.patil
     */
    public boolean validateResultsTag(String strGrandParentFilter) {
        boolean tagMatch = false;
        int count = 0;
        try {
            String strExpectedTag = strGrandParentFilter.trim() + " - ";
            List<WebElement> resultlinkTags = getDriver().findElements(categoryLabelInResults);
            for (int i = 0; i < resultlinkTags.size(); i++) {
                String tag = (resultlinkTags.get(i).getText());
                if (!tag.startsWith(strExpectedTag)) {
                    count++;
                    break;
                }
            }
            if (count == 0)
                tagMatch = true;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return tagMatch;
    }

    public void clkParentFilter(String strGrandParentFilterName, String strParentFilterName) {
        getReusableActionsInstance().clickWhenReady(By.xpath("//div[contains(@id,'" + strGrandParentFilterName + "-body')]/div/button[contains(@id,'" + strParentFilterName + "')]"));
        getReusableActionsInstance().staticWait(1500);
    }

    /**
     * This method will return a list of all storage values under wireless filter
     *
     * @author pankaj.patil
     */
    public List<String> getStorageSelections() {
        List<String> strStorageSelections = new ArrayList<>();
        List<WebElement> chkStorageSelections = getDriver().findElements(storageLabelInFilter);
        for (int i = 0; i < chkStorageSelections.size(); i++) {
            strStorageSelections.add(chkStorageSelections.get(i).getAttribute("value"));
        }
        return strStorageSelections;
    }

    public List<String> getColorSelections() {
        List<String> strColorSelections = new ArrayList<>();
        List<WebElement> chkColorSelections = getDriver().findElements(By.xpath("//input[@name='color']"));
        for (int i = 0; i < chkColorSelections.size(); i++) {
            strColorSelections.add(chkColorSelections.get(i).getAttribute("value"));
        }
        return strColorSelections;
    }

    public void clkStorageType(String strStorage) {
        WebElement element = getDriver().findElement(By.xpath("//ds-checkbox[@id='Shop_Wireless_storage_" + strStorage + "-host']"));
        Actions action = new Actions(getDriver());
        action.moveToElement(element).click().build().perform();
        getReusableActionsInstance().staticWait(1000);
        isPageLoaded();
    }

    /**
     * This method will click on a color passed in the method argument
     *
     * @author pankaj.patil
     */
    public void clkColorType(String strColor) {
        int attempt = 0;
        while (attempt < 2) {
            try {
                getReusableActionsInstance().javascriptScrollToTopOfPage();
                getReusableActionsInstance().clickWhenReady(By.xpath("//span[contains(@class,'color') and starts-with(text(),'" + strColor + "')]"));
                isPageLoaded();
                break;
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }
            attempt++;
        }
    }

    public List<WebElement> getAllResultLinks() {
        return getDriver().findElements(allResultLinksTitle);
    }

    public void clkResultLink(WebElement resultLink) {
        getReusableActionsInstance().javascriptScrollToTopOfPage();
        getReusableActionsInstance().clickWhenReady(resultLink);
        isPageLoaded();
    }

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

    public void clkSizeType(String strSize) {
        getReusableActionsInstance().clickWhenReady(By.xpath("//ds-checkbox[@ng-reflect-value='" + strSize + "']"));
        getReusableActionsInstance().javascriptScrollToTopOfPage();
        getReusableActionsInstance().staticWait(1500);
    }

    public List<String> getSizeSelections() {
        List<String> strSizeSelections = new ArrayList<>();
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

    public List<String> getSuggestionSelections() {
        List<String> strSuggestionSelections = new ArrayList<>();
        List<WebElement> hoverSuggestionSelections = getDriver().findElements(By.xpath("//div[@ng-reflect-heading='Suggestions']/a/div/span/span[@class='ds-link__copy']"));
        for (int i = 0; i < hoverSuggestionSelections.size(); i++) {
            strSuggestionSelections.add(hoverSuggestionSelections.get(i).getText());
        }
        return strSuggestionSelections;
    }

    public boolean isSuggestionsSectionDisplayed() {
        return getReusableActionsInstance().isElementVisible(suggestionsSection);
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
        String[] parts = strParentFilter.split("[/\\s@&.?$+-]+");
        String part1 = parts[0];
        String strQuery = "f=" + strGrandParentFilter.trim() + "_" + part1.trim();
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

    /**
     * Fetch the number of results from result window
     *
     * @author pankaj.patil
     */
    public String getResultWindowText() {
        getReusableActionsInstance().waitForElementTextToBe(searchResults, " ", 10);
        return searchResults.getText();
    }

    public List<String> getColorFilters() {
        List<String> colorFilters = new ArrayList<>();
        List<WebElement> colorFilterElements = getDriver().findElements(By.xpath("//span[contains(@class,'checkbox-color-copy')]"));
        for (int i = 0; i < colorFilterElements.size(); i++) {
            colorFilters.add(colorFilterElements.get(i).getText().split("\\(")[0].trim());
        }
        return colorFilters;
    }

    /**
     * Validate whether the results have same color highlighted as selected from the filter
     *
     * @author pankaj.patil
     */
    public boolean validateResultsColor(String strColor) {
        List<WebElement> resultColoursList = getDriver().findElements(allColorsSwatchInResults);
        boolean colorFlag = false;
        int count = 0;
        int attempt = 0;
        while (attempt < 2) {
            try {
                for (int i = 0; i < resultColoursList.size(); i++) {
                    if ((resultColoursList.get(i).getAttribute("title")
                            .trim().equalsIgnoreCase(strColor))) {
                        String colorBorder = getDriver().findElement(By.xpath("(//ds-selection[@type='color']/label/span)[" + (i + 1) + "]")).getCssValue("border");
                        if (!colorBorder.contains("3px"))
                            count++;
                    }
                }
                if (count == 0)
                    colorFlag = true;
                break;
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }
            attempt++;
        }
        return colorFlag;
    }

    public List<String> getResultColorOptions(WebElement resultLink) {
        List<String> colorOptions = new ArrayList<>();
        List<WebElement> resultColorOptions = resultLink.findElements(By.xpath("parent::div/following-sibling::ds-radio-group//ds-selection/label"));
        for (int i = 0; i < resultColorOptions.size(); i++) {
            colorOptions.add(resultColorOptions.get(i).getAttribute("title"));
        }
        return colorOptions;
    }

    public void clkResultColor(WebElement resultLink, String strColor) {
        getReusableActionsInstance().javascriptScrollToTopOfPage();
        WebElement resultColor = resultLink.findElement(By.xpath("parent::div/following-sibling::ds-radio-group//ds-selection/label[@title='" + strColor + "']"));
        getReusableActionsInstance().clickWhenReady(resultColor);
        isPageLoaded();
    }

    /**
     * Click on the top search icon
     *
     * @author naina.agarwal
     */
    public void isPageLoaded() {
        js = (JavascriptExecutor) getDriver();
        for (int i = 0; i < 60; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }

    public String getSystemLanguage() {
        String systemLanguage = null;
        if (System.getProperty("Language").equalsIgnoreCase("en"))
            systemLanguage = "en";
        else if (System.getProperty("Language").equalsIgnoreCase("fr"))
            systemLanguage = "fr";
        return systemLanguage;
    }

    public void clkShopFilter() {
        String filter = null;
        String language = getSystemLanguage();
        if (language.equalsIgnoreCase("en"))
            filter = "Shop";
        else if (language.equalsIgnoreCase("fr"))
            filter = "Magasiner";
        if (filter != null)
            getReusableActionsInstance().clickWhenReady(By.xpath("//button[contains(@id,'" + filter + "-heading')]"), 5);
        isPageLoaded();
    }

    public void clkWirelessFilter() {
        String filter = null;
        String language = getSystemLanguage();
        if (language.equalsIgnoreCase("en"))
            filter = "Wireless";
        else if (language.equalsIgnoreCase("fr"))
            filter = "Sans-fil";
        if (filter != null)
            getReusableActionsInstance().clickWhenReady(By.xpath("//button[contains(@id,'" + filter + "-heading')]"), 5);
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
        js = (JavascriptExecutor) getDriver();
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
        if (getReusableActionsInstance().isElementVisible(searchResults)) {
            return getReusableActionsInstance().getElementText(searchResults);
        } else
            return "No result";
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

    public void javascriptClickWithPerform(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView();", element);
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            throw new DigiAutoCustomException(e);
        }
    }

    /**
     * Click on page 2 from the bottom pagination
     *
     * @author naina.agarwal
     */
    public String selectPageTwo() {
        String message;
        isPagePresent = getDriver().findElements(numberOfPagesDisplayedAtBottom).size() > 1;
        if (isPagePresent) {
            javascriptClickWithPerform(page2);
            message = pageTwoPresent;
        } else
            message = pageTwoNotPresent;
        return message;
    }

    /**
     * Check if Page 2 of the pagination is highlighted
     *
     * @author naina.agarwal
     */
    public String isSecondPageNumberHighlighted() {
        String message;
        isPagePresent = getDriver().findElements(numberOfPagesDisplayedAtBottom).size() > 1;
        if (isPagePresent) {
            getReusableActionsInstance().isElementVisible(secondPagePaginationHighlighted);
            message = pageTwoHighlighted;
        } else
            message = pageTwoNotHighlighted;
        return message;
    }

    /**
     * Check if url contains page number info same as selected from the pagination component.
     * For eg : URL should contain 2 if page 2 was selected in pagination
     *
     * @author naina.agarwal
     */
    public String validatePageNumberInURL(String url) {
        String message;
        String currentPageNumberInPagination = getReusableActionsInstance().getElementText(currentPageNumberHighlighted);
        isPagePresent = getDriver().findElements(numberOfPagesDisplayedAtBottom).size() > 1;
        if (isPagePresent) {
            if (!url.endsWith("=" + currentPageNumberInPagination)) {
                message = "Page number on Pagination and URL does not match";
            } else
                message = "Page number on Pagination and URL match";
        } else
            message = "There is only one page";
        return message;
    }

    /**
     * This method will check if page size selected matches with the URL
     *
     * @author naina.agarwal
     */
    public boolean validatePageSizeInURL(String url) {
        boolean urlFlag = true;
        Select dropdown = new Select(resultPerPageDropdown);
        WebElement option = dropdown.getFirstSelectedOption();
        String defaultItem = option.getText().trim();
        String pageSize = "psize=" + defaultItem;
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
        boolean numberOfResultsOnAPage = false;
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
        int pageSizeNumber;
        String pageSize;
        try {
            Select dropdown = new Select(resultPerPageDropdown);
            List<WebElement> dd = dropdown.getOptions();
            Random rand = new Random();
            pageSizeNumber = rand.nextInt(dd.size());
            dd.get(pageSizeNumber).click();
            pageSize = dd.get(pageSizeNumber).getText();
            return pageSize;
        } catch (Exception e) {
            throw new DigiAutoCustomException(e);
        }
    }

    /**
     * This method will check if default value of page size dropdown is 10
     *
     * @author naina.agarwal
     */
    public boolean validateDefaultResultDropdownValue() {
        boolean pageSizeDefaultValue = true;
        try {
            Select dropdown = new Select(resultPerPageDropdown);
            WebElement option = dropdown.getFirstSelectedOption();
            String defaultItem = option.getText().trim();
            if (!defaultItem.equals(expectedDefaultPageSize))
                pageSizeDefaultValue = false;
            return pageSizeDefaultValue;
        } catch (Exception e) {
            throw new DigiAutoCustomException(e);
        }
    }

    /**
     * To method extracts the total results displayed for the searched term
     *
     * @author naina.agarwal
     */
    public int totalResult() {
        int totalResultDisplayed;
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
        int pageSize;
        List<WebElement> resultLinks;
        resultLinks = getAllResultLinks();
        int resultSize = resultLinks.size();
        pageSize = Integer.parseInt(randomPageSize.trim());
        System.out.println("Total result displayed on top is " + totalResults);
        System.out.println("Page size selected is " + pageSize);
        System.out.println("Total result in list is " + resultSize);
        if (pageSize < totalResults && resultSize == pageSize)
            return true;
        else return pageSize > totalResults && resultSize == totalResults;
    }

    /**
     * To check if the number of results on the top is displayed correctly based on the random page selected from the dropdown
     *
     * @author naina.agarwal
     */
    public boolean verifyResultsOnTop(String randomPageSize, int totalResults) {
        int pageSize;
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
        String message;
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
        String message;
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
        boolean isPresent = getDriver().findElements(numberOfPagesDisplayedAtBottom).size() > 0;
        elementName = getDriver().findElements(numberOfPagesDisplayedAtBottom);
        int numberOfPages = elementName.size();
        if (isPresent) {
            if (numberOfPages > 1) {
                getReusableActionsInstance().executeJavaScriptClick(lastForwardArrowKey);
                message = clickLastForwKey;
            } else
                message = cannotClickLastForwKey;
        }
        return message;
    }

    /**
     * This method will check if last page is highlighted
     *
     * @author naina.agarwal
     */
    public boolean lastPageIsHighlighted() {
        boolean highlighted = true;
        String currentPageNumberInPagination = getReusableActionsInstance().getElementText(currentPageNumberHighlighted);
        elementName = getDriver().findElements(numberOfPagesDisplayedAtBottom);
        int pages = elementName.size();
        String pageSelected = elementName.get(pages - 1).getText();
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
        String message;
        elementName = getDriver().findElements(numberOfPagesDisplayedAtBottom);
        int numberOfPages = elementName.size();
        if (numberOfPages > 1) {
            getReusableActionsInstance().executeJavaScriptClick(lastBackwardArrowKey);
            message = clickLastBackKey;
        } else
            message = cannotClickLastBackKey;
        return message;
    }

    /**
     * This method will send a valid page number and page size to the url
     *
     * @author naina.agarwal
     */
    public String updateURLWithValidData() {
        String url1 = getDriver().getCurrentUrl();
        int validPageNumber = clickOnRandomPageNumber();
        Select dropdown = new Select(resultPerPageDropdown);
        List<WebElement> list = dropdown.getOptions();
        String firstOption = list.get(0).getText().trim();
        System.out.println("first option is " + firstOption);
        int indexOfPsize = url1.indexOf("psize");
        String firstHalfURL = url1.substring(0, indexOfPsize);
        String secondHalfURL = url1.substring(indexOfPsize);
        secondHalfURL = secondHalfURL.replace(secondHalfURL, "psize=" + firstOption + "&pg=" + validPageNumber);
        String updatedURL = firstHalfURL.concat(secondHalfURL);
        getDriver().get(updatedURL);
        return updatedURL;
    }

    /**
     * This method will send a invalid page number and page size as 0 to the url
     *
     * @author naina.agarwal
     */
    public String updateURLWithInvalidData() {
        String url1 = getDriver().getCurrentUrl();
        int indexOfPsize = url1.indexOf("psize");
        String firstHalfURL = url1.substring(0, indexOfPsize);
        String secondHalfURL = url1.substring(indexOfPsize);
        secondHalfURL = secondHalfURL.replace(secondHalfURL, "psize=0&pg=0");
        String updatedURL = firstHalfURL.concat(secondHalfURL);
        getDriver().get(updatedURL);
        return updatedURL;
    }

    /**
     * This method will open a new tab in the browser with the current tab URL
     *
     * @author naina.agarwal
     */
    public void openURLInNewTab(String url) {
        //Open new tab
        ((JavascriptExecutor) getDriver()).executeScript("window.open('about:blank','_blank');");
        getReusableActionsInstance().switchToNewWindow();
        getDriver().get(url);
        getReusableActionsInstance().staticWait(5000);
    }

    /**
     * This method will refresh the current page 3 times
     *
     * @author naina.agarwal
     */
    public void refreshPage() {
        for (int i = 0; i < 3; i++) {
            getDriver().navigate().refresh();
            isPageLoaded();
        }
    }

    /**
     * This method will select the language *en/fr* from the search page to toggle to other language
     *
     * @author naina.agarwal
     */
    public String toggleLanguage() {
        String currentLanguageBeforeToggle = getReusableActionsInstance().getElementText(toggleLanguage);
        getReusableActionsInstance().clickWhenReady(toggleLanguage);
        return currentLanguageBeforeToggle;
    }

    public boolean isGrandParentFilterUnexpanded() {
        boolean filterExpanded = true;
        int attempts = 0;
        while (attempts < 2) {
            try {
                List<WebElement> listofItems = getDriver().findElements(allGrandParentFilters);
                for (int i = 0; i < listofItems.size(); i++) {
                    if (listofItems.get(i).getAttribute("aria-hidden").equals("false"))
                        filterExpanded = false;
                }
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }
            attempts++;
        }
        return filterExpanded;
    }

    public boolean searchTermRetained(String searchTerm) {
        boolean termIsRetained = true;
        String termInSearchResult = getReusableActionsInstance().getElementText(searchResults);
        if (!termInSearchResult.endsWith(searchTerm)) {
            termIsRetained = false;
        }
        return termIsRetained;
    }

    public boolean validateLanguageInUrl(String language) throws UnsupportedEncodingException {
        String strQuery = "language=" + language.trim().toLowerCase();
        return validateURLContains(strQuery);
    }

    public String updateURLWithDifferentLanguage() {
        String currentLanguage = getReusableActionsInstance().getElementText(toggleLanguage);
        String currentURL = getDriver().getCurrentUrl();
        int indexOfLanguage = currentURL.indexOf("language");
        String firstHalfURL = currentURL.substring(0, indexOfLanguage);
        String secondHalfURL = currentURL.substring(indexOfLanguage);
        secondHalfURL = secondHalfURL.replace(secondHalfURL, "language=" + currentLanguage);
        String updatedURL = firstHalfURL.concat(secondHalfURL);
        getDriver().get(updatedURL);
        return updatedURL;
    }

    public String updateURLwithSearchTerm() {
        String currentURL = System.getProperty("SearchUrl");
        int indexOfSearchTerm = currentURL.indexOf("q=");
        String firstHalfURL = currentURL.substring(0, indexOfSearchTerm);
        String secondHalfURL = currentURL.substring(indexOfSearchTerm);
        secondHalfURL = secondHalfURL.replace(secondHalfURL, "q=" + invalidSearchTerm);
        String updatedURL = firstHalfURL.concat(secondHalfURL);
        getDriver().get(updatedURL);
        return updatedURL;
    }

    public boolean checkLanguageDisplayedOnPage() {
        boolean toggleUpdate = true;
        String currentURL = getDriver().getCurrentUrl();
        String currentDisplayedLanguageOnToggle = getReusableActionsInstance().getElementText(toggleLanguage);
        if (!currentURL.contains("language=en") && (currentDisplayedLanguageOnToggle.equals("FR"))) {
            if (!currentURL.contains("language=fr") && (currentDisplayedLanguageOnToggle.equals("EN"))) {
                toggleUpdate = false;
            }
        }
        return toggleUpdate;
    }

    public boolean isFilterDisplayedForSingleResult() {
        boolean singleResult = true;
        List<WebElement> filter = getDriver().findElements(FilterComponent);
        if (filter.size() > 0)
            singleResult = false;
        return singleResult;
    }

    public boolean isPaginationDisplayedForSingleResult() {
        boolean singleResult = true;
        List<WebElement> pagination = getDriver().findElements(PaginationComponent);
        if (pagination.size() > 0)
            singleResult = false;
        return singleResult;
    }

    public boolean isDetailsPageDisplayed(String searchTerm) {
        boolean titleDetailsPage = true;
        String title = getDriver().findElement(titleOnDetailsPage).getText();
        if (!title.toLowerCase().contains(searchTerm.toLowerCase()))
            titleDetailsPage = false;
        return titleDetailsPage;
    }

    public void waitForDetailsPage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleOnDetailsPage));
    }

    public void waitForToggleToBeDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(provinceInToggle));
    }

    public void waitForPage() {
        getReusableActionsInstance().staticWait(3000);
    }

    public void waitForResultPage() {
        getReusableActionsInstance().waitForElementVisibility(searchResults);
    }

    public String getSelectedColor() {
        return lblColorValue.getText();
    }

    public String selectRandomProvince() {
        getReusableActionsInstance().clickWhenReady(provinceDropdown);
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(provinceDropdownValues));
        List<WebElement> province = getDriver().findElements(provinceDropdownValues);
        int numberOfProvinces = province.size() - 1;
        int randomNumber = randomNumber(numberOfProvinces);
        String provinceSelected = province.get(randomNumber).getText();
        isPageLoaded();
        province.get(randomNumber).click();
        return provinceSelected;
    }

    public boolean validateProvinceAfterToggle(String province) {
        boolean provinceMatch = true;
        String currentProvince = getDriver().findElement(provinceInToggle).getAttribute("aria-label");
        if (!province.equals(currentProvince))
            provinceMatch = false;
        return provinceMatch;
    }

    public boolean searchResultMatch(String searchResult) {
        boolean searchResultMatch = true;
        waitTime();
        String currentSearchResult = getReusableActionsInstance().getElementText(searchResults);
        if (!searchResult.trim().equals(currentSearchResult.trim()))
            searchResultMatch = false;
        return searchResultMatch;
    }

    public boolean validateHomeURL() {
        boolean homeURL = true;
        wait = new WebDriverWait(getDriver(), 2000);
        wait.until(ExpectedConditions.urlContains("home"));
        String currentURL = getDriver().getCurrentUrl();
        if (!currentURL.contains("home"))
            homeURL = false;
        return homeURL;
    }
}
