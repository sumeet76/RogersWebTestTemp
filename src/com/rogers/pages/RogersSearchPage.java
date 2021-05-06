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

    @FindBy(xpath = "//span[contains(@class,'text-title')]")
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

    @FindBy(xpath = "//span[@class='text-overline mb-0']/following-sibling::span")
    WebElement filterCount;

    @FindBy(xpath = "//div[@class='resultList']/div[1]")
    WebElement resultsCount;

    @FindBy(xpath = "//dsa-selector[@data-test='storage-selector']//span[@class='dsa-selector__header text-title-5']/following-sibling::span")
    WebElement lblStorageValue;

    @FindBy(xpath = "//span[@class='m-navLink__icon rds-icon-search -open' or @class='rds-navLink__icon rds-icon-search -open']")
    WebElement searchTextIcon;

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement searchTextBox;

    @FindBy(xpath = "//span[@class='a-icon rds-icon-search']")
    WebElement submitSearchIcon;

    @FindBy(xpath = "//div[@id='searchDescription']")
    WebElement searchResults;

    @FindBy(xpath = "//button[contains (@class, 'active') and @title='Page 1']")
    WebElement firstPagePaginationHighlighted;

    @FindBy(xpath = "//button[contains (@class, 'active') and @title='Page 2']")
    WebElement secondPagePaginationHighlighted;

    @FindBy(xpath = "//button[contains (@class, '-active')]/div")
    WebElement currentPageNumberHighlighted;

    @FindBy(xpath = "//button[@title='Page 2']")
    WebElement page2;

    @FindBy(xpath = "//select[contains(@id,'form-input-id')]")
    WebElement resultPerPageDropdown;

    @FindBy(xpath = "//button[@title='Next page']")
    WebElement firstForwardArrowKey;

    @FindBy(xpath = "//button[@title='Previous page']")
    WebElement firstBackwardArrowKey;

    @FindBy(xpath = "//button[@title='Last page']")
    WebElement lastForwardArrowKey;

    @FindBy(xpath = "//button[@title='First page']")
    WebElement lastBackwardArrowKey;

    @FindBy(xpath = "(//a[@class='m-navLink -navbar']/span[@class='m-navLink__caption'])[3]")
    WebElement toggleLanguage;

    @FindBy(xpath = "(//span[@class='m-navLink__chevron rds-icon-expand'])[1]")
    WebElement provinceDropdown;

    @FindBy(xpath = "//dsa-selector[@data-test='color-selector']//span[@class='dsa-selector__header text-title-5']/following-sibling::span[1]")
    WebElement lblColorValue;

    public static final By provinceDropdownValues = By.xpath("//ul[@class='o-headerNavDropdown -navbar nav-list-opened']/li/a");

    public static final By provinceInToggle = By.xpath("(//a[@class='m-navLink -navbar'])[2]");

    public static final By FilterComponent = By.xpath("//div[@class='ds-filter__listWrapper']");

    public static final By PaginationComponent = By.xpath("//div[@class='d-flex ng-star-inserted']");

    public static final By titleOnDetailsPage = By.xpath("//h1[@id='bfa-page-title']");

    public static final By numberOfPagesDisplayedAtBottom = By.xpath("//button[contains(@class,'paginationButton')]/div");

    public static final By allGrandParentFilters = By.xpath("//button[contains(@class,'filter')]/following-sibling::ds-expander/div");

    public static final By categoryLabelInResults = By.xpath("//span[contains(@class,'categorylbl')]");

    public static final By storageLabelInFilter = By.xpath("//input[@name='storage']");

    public static final By allDevicesInFilter = By.xpath("//input[@name='devicetype']");

    public static final By allColorsSwatchInResults = By.xpath("//ds-selection[@type='color']/label");

    public static final By allResultLinksTitle = By.xpath("//a[contains(@id,'searchtitle')]");

    public static final By allColorsInFilter = By.xpath("//span[contains(@class,'checkbox-color-copy')]");

    public static final By allLinksInResults = By.xpath("//span[contains(@class,'categorylbl')]/preceding-sibling::a");

    public static final By filterSection = By.xpath("//div[@class='ds-filter']");

    public static final By watchSize = By.xpath("//input[contains(@id,'size')]");
    //Mobile Page Objects

    @FindBy(xpath = "//span[contains(@class,'icon-filter')]")
    WebElement filterIconMobile;

    @FindBy(xpath = "//button[contains(@class,'inline-block -primary -large')]")
    WebElement showResultBtnMobile;

    @FindBy(xpath = "//span[@class='rds-navLink__icon rds-icon-search -open']")
    WebElement searchTextIconMobile;

    @FindBy(xpath = "//input[@id='searchInputMobile']")
    WebElement searchTextBoxMbl;

    @FindBy(xpath = "//button[@class='o-mobileSearchBar__submit']/span[@class='a-icon rds-icon-search']")
    WebElement submitSearchIconMbl;

    @FindBy(xpath = "//a[@class='m-mobileNavLink']/span[@aria-label]")
    WebElement toggleLanguageMbl;

    @FindBy(xpath = "//button[@class='rcl-header-mobilenav']")
    WebElement topFilterMbl;

    @FindBy(xpath = "(//a[@class='m-mobileNavLink -dropdown'])[5]")
    WebElement provinceDropdownMbl;

    @FindBy(xpath = "//button[@title='Navigation']")
    WebElement crossMarkTopMbl;

    //button[@title='Navigation']
    public static final By provinceDropdownValuesMbl = By.xpath("//ul[@class='o-mobileNavDropdown nav-list-opened']/li/a");

    Boolean isPagePresent = false;
    JavascriptExecutor js = null;
    List<WebElement> elementName;
    int expectedDefaultSearchResults = 10;
    String pageTwoPresent = "Page 2 is present and it is clicked";
    String pageTwoNotPresent = "Cannot select page 2 as only one page exist";
    String pageTwoHighlighted = "Page 2 is highlighted";
    String pageTwoNotHighlighted = "Page 2 is not highlighted";
    String expectedDefaultPageSize = "10";
    String cannotClickLastForwKey = "Cannot click on last forward arrow key because available page is 1";
    String clickLastForwKey = "Clicked on last forward arrow key";
    String cannotClickLastBackKey = "Cannot click on last backward arrow key because available page is 1";
    String clickLastBackKey = "Clicked on last backward arrow key";
    String cannotClickFwdKey = "Cannot click on forward arraw key because available page is 1";
    String clkFwdKey = "Clicked on Forward arrow key";
    String invalidSearchTerm = "@!#";
    String cannotClkBackKey = "Cannot click on backward arraw key because available page is 1";
    String clkBackKey = "Clicked on backward arrow key";

    /**
     * check if expected filters displayed or not
     *
     * @return true if displayed, otherwise false
     * @author pankaj.patil
     */
    public boolean isFilterDisplayed(String strFilterName) {
        return getReusableActionsInstance().isElementVisible(
                By.xpath("//button[contains(@id,'" + strFilterName + "-heading')]/div/p[starts-with(text(),'" + strFilterName + "')]"));
    }

    public boolean isFilterSectionDisplayed() {
        return getReusableActionsInstance().isElementVisible(filterSection);
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
            for (WebElement categoryTag : categoryTags) {
                String[] strTagText = categoryTag.getText().split("-");
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

    public boolean validateResultsLinks() {
        List<WebElement> resultlinks = getDriver().findElements(allLinksInResults);
        for (WebElement resultlink : resultlinks) {
            if (!(resultlink.getAttribute("href").equals(""))) {
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
        for (WebElement resultlinkTag : resultlinkTags) {
            String actualValue = resultlinkTag.getText();
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
            for (WebElement resultlinkTag : resultlinkTags) {
                String tag = (resultlinkTag.getText());
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
        for (WebElement chkStorageSelection : chkStorageSelections) {
            strStorageSelections.add(chkStorageSelection.getAttribute("value"));
        }
        return strStorageSelections;
    }

    /**
     * This method will return a list of all device values under wireless filter
     *
     * @author pankaj.patil
     */
    public List<String> getDeviceSelections() {
        List<String> strDeviceSelections = new ArrayList<>();
        List<WebElement> chkDeviceSelections = getDriver().findElements(allDevicesInFilter);
        for (WebElement chkDeviceSelection : chkDeviceSelections) {
            strDeviceSelections.add(chkDeviceSelection.getAttribute("value"));
        }
        return strDeviceSelections;
    }

    public List<String> getColorSelections() {
        List<String> strColorSelections = new ArrayList<>();
        List<WebElement> chkColorSelections = getDriver().findElements(allColorsInFilter);
        for (WebElement chkColorSelection : chkColorSelections) {
            strColorSelections.add(chkColorSelection.getText());
        }
        return strColorSelections;
    }

    public void clkStorageType(String strStorage) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ds-checkbox[contains(@id,'" + strStorage + "-host')]")));
            WebElement element = getDriver().findElement(By.xpath("//ds-checkbox[contains(@id,'" + strStorage + "-host')]"));
            Actions action = new Actions(getDriver());
            action.moveToElement(element).click().build().perform();
            waitTime();
        } catch (Exception e) {
            throw new DigiAutoCustomException(e);
        }
    }

    public void clickingOnDevice(String device) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ds-checkbox[contains(@id,'" + device + "-host')]")));
            WebElement element = getDriver().findElement(By.xpath("//ds-checkbox[contains(@id,'" + device + "-host')]"));
            Actions action = new Actions(getDriver());
            action.moveToElement(element).click().build().perform();
            isPageLoaded();
        } catch (Exception e) {
            throw new DigiAutoCustomException(e);
        }
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
                WebElement element = getDriver().findElement(By.xpath("//span[contains(@class,'color') and starts-with(text(),'" + strColor + "')]"));
                // getReusableActionsInstance().scrollToElement(element);
                javascriptClickWithPerform(element);
                isPageLoaded();
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
            attempt++;
        }
    }

    /**
     * This method will click on a device passed in the method argument
     *
     * @author naina.agarwal
     */
    public void clkDevice(String deviceType) {
        int attempt = 0;
        while (attempt < 2) {
            try {
                WebElement element = getDriver().findElement(By.xpath("//ds-checkbox[contains(@id,'" + deviceType + "-host')]"));
                getReusableActionsInstance().scrollToElement(element);
                getReusableActionsInstance().clickWhenReady(element);
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

    public boolean isParentFilterExpanded(String strParentFilter) {
        try {
            WebElement expandedFilter = getDriver().findElement(By.xpath("//button[contains(@id,'" + strParentFilter + "-heading')]"));
            return expandedFilter.getAttribute("aria-expanded").equals("true");
        } catch (Exception e) {
            throw new DigiAutoCustomException(e);
        }
    }

    public void clkResetAllFilters() {
        getReusableActionsInstance().clickWhenReady(btnResetAllFilters);
    }

    public boolean validateAllFiltersCollapsed() {
        boolean collapsedFlag = true;
        List<WebElement> grandParentFilters = getDriver().findElements(By.xpath("//ds-accordion-panel[contains(@class,'-main-level')]/div/button//p"));
        for (WebElement grandParentFilter : grandParentFilters) {
            if (isGrandParentFilterExpanded(grandParentFilter.getText())) {
                collapsedFlag = false;
            }
        }
        return collapsedFlag;
    }

    public void clkWatchDeviceType() {
        String strDeviceType = null;
        getReusableActionsInstance().javascriptScrollToTopOfPage();
        String language = getSystemLanguage();
        switch (language) {
            case "en":
                strDeviceType = "Watch";
                break;
            case "fr":
                strDeviceType = "la montre";
                break;
        }
        getReusableActionsInstance().clickWhenReady(By.xpath("//div[contains(@id, 'devicetype_" + strDeviceType + "-label-container')]"));
        isPageLoaded();
    }

    public void clkBrandType(String strBrandType) {
        // getReusableActionsInstance().javascriptScrollToTopOfPage();
        getReusableActionsInstance().clickWhenReady(By.xpath("//ds-checkbox[@id='Shop_Wireless_brand_" + strBrandType + "-host']"));
        getReusableActionsInstance().staticWait(1000);
    }

    public void clkSizeType(String strSize) {
        getReusableActionsInstance().clickWhenReady(By.xpath("//ds-checkbox[contains (@id, 'size_" + strSize + "')]"));
        getReusableActionsInstance().javascriptScrollToTopOfPage();
        isPageLoaded();
    }

    public List<String> getSizeSelections() {
        List<String> strSizeSelections = new ArrayList<>();
        List<WebElement> chkSizeSelections = getDriver().findElements(watchSize);
        for (WebElement chkSizeSelection : chkSizeSelections) {
            strSizeSelections.add(chkSizeSelection.getAttribute("value"));
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
        boolean noResult = false;
        String message = null;
        boolean noResultIsVisible = getReusableActionsInstance().isElementVisible(lblNoResultsMsg);
        if (noResultIsVisible)
            message = getReusableActionsInstance().getElementText(lblNoResultsMsg);
        if (message != null) noResult = true;
        return noResult;
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
        for (WebElement hoverSuggestionSelection : hoverSuggestionSelections) {
            strSuggestionSelections.add(hoverSuggestionSelection.getText());
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
        for (WebElement suggestionsSectionLink : suggestionsSectionLinks) {
            if (suggestionsSectionLink.getAttribute("href") == null) {
                return false;
            }
        }
        return true;
    }

    public void clkSuggestionsType(String strSuggestion) {
        getReusableActionsInstance().clickWhenReady(By.xpath("//div[@ng-reflect-heading='Suggestions']//span[starts-with(text(),' " + strSuggestion + "')]"));
    }

    /**
     * This method check "strGrandParentFilter_strParentFilter" is displayed in URL
     *
     * @author naina.agarwal
     */
    public boolean validateFiltersInUrl(String strGrandParentFilter, String strParentFilter) {
        try {
            String[] parts = strParentFilter.split("[\\s@&.?$+-]+");
            String part1 = parts[0];
            String strQuery = "f=" + strGrandParentFilter.trim() + "_" + part1.trim();
            return validateURLContains(strQuery);
        } catch (Exception e) {
            throw new DigiAutoCustomException(e);
        }
    }

    public boolean filterCount() {
        String filterCountInFilterSection;
        filterCountInFilterSection = getReusableActionsInstance().getElementText(filterCount).trim();
        return filterCountInFilterSection.contains("(0)");
    }

    public boolean validateStoragesInUrl(String[] strStorage) throws UnsupportedEncodingException {
        String strQuery = "storage:";
        try {
            for (int i = 0; i < strStorage.length; i++) {
                if (strStorage[i] != null) {
                    strQuery = strQuery.concat(strStorage[i].trim());
                    if (i != strStorage.length - 1) {
                        strQuery = strQuery + ",";
                    }
                }
            }
        } catch (NullPointerException e) {
            throw new DigiAutoCustomException(e);
        }
        return validateURLContains(strQuery);
    }

    public boolean validateColorsInUrl(String[] strColor) throws UnsupportedEncodingException {
        String strQuery = "color:";
        try {
            for (int i = 0; i < strColor.length; i++) {
                if (strColor[i] != null) {
                    strQuery = strQuery.concat(strColor[i].trim());
                    if (i != strColor.length - 1) {
                        strQuery = strQuery + ",";
                    }
                }
            }
        } catch (NullPointerException e) {
            throw new DigiAutoCustomException(e);
        }
        return validateURLContains(strQuery);
    }

    public boolean isFilterChecked(String strFilter) {
        return getReusableActionsInstance().getWhenReady(By.xpath("//ds-checkbox//input[@value='" + strFilter.trim() + "']"))
                .getAttribute("aria-checked").equals("true");
    }

    public ArrayList<String> filters(List<String> filterData, String filter) {
        int count = 0;
        ArrayList<String> listArrayFilter = new ArrayList<>();
        for (int i = 0; i < filterData.size(); i++) {
            switch (filter) {
                case "Color":
                    clkColorType(filterData.get(i));
                    break;
                case "Storage":
                    clkStorageType(filterData.get(i));
                    break;
                case "Brand":
                    clkBrandType(filterData.get(i));
                    break;
                case "Device":
                    clickingOnDevice(filterData.get(i));
                    break;
            }
            listArrayFilter.add(filterData.get(i));
            count++;
            if (count == 2)
                break;
        }
        return listArrayFilter;
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

    /**
     * Fetch all the colors from the colors filter
     *
     * @author pankaj.patil
     */
    public List<String> getColorFilters() {
        List<String> colorFilters = new ArrayList<>();
        List<WebElement> colorFilterElements = getDriver().findElements(allColorsInFilter);
        for (WebElement colorFilterElement : colorFilterElements) {
            colorFilters.add(colorFilterElement.getText().split("\\(")[0].trim());
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
        int count = 0, attempt = 0;
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
        for (WebElement resultColorOption : resultColorOptions) {
            colorOptions.add(resultColorOption.getAttribute("title"));
        }
        return colorOptions;
    }

    public void clkResultColor(WebElement resultLink, String strColor) {
        getReusableActionsInstance().javascriptScrollToTopOfPage();
        WebElement resultColor = resultLink.findElement(By.xpath("parent::div/following-sibling::ds-radio-group//ds-selection/label[@title='" + strColor + "']"));
        //getReusableActionsInstance().clickWhenReady(resultColor);
        javascriptClickWithPerform(resultColor);
        isPageLoaded();
    }

    /**
     * Wait for page to load
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

    /**
     * Fetch the language parameter passed through framework properties
     *
     * @author naina.agarwal
     */
    public String getSystemLanguage() {
        String systemLanguage = null;
        if (System.getProperty("Language").equalsIgnoreCase("en"))
            systemLanguage = "en";
        else if (System.getProperty("Language").equalsIgnoreCase("fr"))
            systemLanguage = "fr";
        return systemLanguage;
    }

    /**
     * Check on shop/magasiner filter based on language
     *
     * @author naina.agarwal
     */
    public String clkShopFilter() {
        String filter = null;
        Actions act = new Actions(getDriver());
        String language = getSystemLanguage();
        if (language.equalsIgnoreCase("en"))
            filter = "Shop";
        else if (language.equalsIgnoreCase("fr"))
            filter = "Magasiner";
        if (filter != null)
            act.moveToElement(getDriver().findElement(By.xpath("//button[contains(@id,'" + filter + "-heading')]"))).click().perform();
        isPageLoaded();
        return filter;
    }

    public String clkWirelessFilter() {
        String filter = null;
        String language = getSystemLanguage();
        if (language.equalsIgnoreCase("en"))
            filter = "Wireless";
        else if (language.equalsIgnoreCase("fr"))
            filter = "Sans-fil";
        if (filter != null)
            getReusableActionsInstance().clickWhenReady(By.xpath("//button[contains(@id,'" + filter + "-heading')]"), 5);
        isPageLoaded();
        return filter;
    }

    public String numberOfResults() {
        return getReusableActionsInstance().getElementText(resultsCount);
    }

    public String getSelectedStorage() {
        return lblStorageValue.getText().trim().replace(" ", "");
    }

    public boolean stringMatch(String a, String b) {
        boolean equalFlag = true;
        if (!a.equals(b)) {
            equalFlag = false;
        }
        return equalFlag;
    }

    public void waitTime() {
        Long loadTime;
        js = (JavascriptExecutor) getDriver();
        try {
            loadTime = (Long) js.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
            Thread.sleep(loadTime);
        } catch (TimeoutException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Click on the top search icon
     *
     * @author naina.agarwal
     */
    public void clickSearchIcon() {
        boolean isMobile = isMobileSelected();
        if (isMobile)
            getReusableActionsInstance().clickWhenReady(searchTextIconMobile);
        else
            getReusableActionsInstance().clickWhenReady(searchTextIcon);
    }

    /**
     * Enter the search text in the search text box
     *
     * @author naina.agarwal
     */
    public void enterTextToBeSearched(String searchText) {
        boolean isMobile = isMobileSelected();
        if (isMobile)
            getReusableActionsInstance().enterText(searchTextBoxMbl, searchText, 1000);
        else
            getReusableActionsInstance().enterText(searchTextBox, searchText, 1000);
    }

    /**
     * Return the number of results if they are displayed
     *
     * @author naina.agarwal
     */
    public String getSearchResults() {
        getReusableActionsInstance().waitForElementVisibility(searchResults, 3000);
        return getReusableActionsInstance().getElementText(searchResults);
    }

    public boolean presenceOfResults() {
        boolean resultPresent = false;
        int numberOfResult = 0;
        try {
            WebElement element = getDriver().findElement(allLinksInResults);
            getReusableActionsInstance().waitForElementVisibility(element);
            numberOfResult = getDriver().findElements(allLinksInResults).size();
            if (numberOfResult >= 1)
                resultPresent = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultPresent;
    }

    /**
     * Click the submit search icon in the search text box after entering text
     *
     * @author naina.agarwal
     */
    public void clickSubmitSearchIcon() {
        boolean isMobile = isMobileSelected();
        if (isMobile)
            javascriptClickWithPerform(submitSearchIconMbl);
        else
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

    /**
     * Clicking on element with help of Javascript executor
     *
     * @author naina.agarwal
     */
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
     * Click on page 2 from the bottom pagination if more than 1 page is present
     *
     * @author naina.agarwal
     */
    public String selectPageTwo() {
        String message = null;
        boolean isMobile = isMobileSelected();
        if (isMobile) {
            boolean isRightArrowKeyEnabled = firstForwardArrowKey.isEnabled();
            if (isRightArrowKeyEnabled) {
                javascriptClickWithPerform(firstForwardArrowKey);
                message = pageTwoPresent;
            } else
                message = pageTwoNotPresent;
        } else {
            isPagePresent = getDriver().findElements(numberOfPagesDisplayedAtBottom).size() > 1;
            if (isPagePresent) {
                javascriptClickWithPerform(page2);
                message = pageTwoPresent;
            } else
                message = pageTwoNotPresent;
        }
        return message;
    }

    /**
     * Check if Page 2 of the pagination is highlighted
     *
     * @author naina.agarwal
     */
    public String isSecondPageNumberHighlighted() {
        String message;
        boolean isMobile = isMobileSelected();
        if (isMobile) {
            boolean isRightArrowKeyEnabled = firstForwardArrowKey.isEnabled();
            if (isRightArrowKeyEnabled) {
                getReusableActionsInstance().isElementVisible(secondPagePaginationHighlighted);
                message = pageTwoHighlighted;
            } else
                message = pageTwoNotHighlighted;
        } else {
            isPagePresent = getDriver().findElements(numberOfPagesDisplayedAtBottom).size() > 1;
            if (isPagePresent) {
                getReusableActionsInstance().isElementVisible(secondPagePaginationHighlighted);
                message = pageTwoHighlighted;
            } else
                message = pageTwoNotHighlighted;
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
        String message = null;
        try {
            javascriptClickWithPerform(currentPageNumberHighlighted);
            String currentPageNumberInPagination = getReusableActionsInstance().getElementText(currentPageNumberHighlighted);
            if (!url.endsWith("pg=" + currentPageNumberInPagination))
                message = "Page number on Pagination and URL does not match";
            else
                message = "Page number on Pagination and URL match";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    /**
     * This method will check if page size selected matches with the URL
     *
     * @author naina.agarwal
     */
    public boolean validatePageSizeInURL(String url) {
        String pageSize;
        try {
            Select dropdown = new Select(resultPerPageDropdown);
            WebElement option = dropdown.getFirstSelectedOption();
            String defaultItem = option.getText().trim();
            pageSize = "psize=" + defaultItem;
        } catch (Exception e) {
            throw new DigiAutoCustomException(e);
        }
        return url.contains(pageSize);
    }

    /**
     * Validate the search result number on top is displayed based on page number highlighted
     *
     * @author naina.agarwal
     */
    public boolean validateSearchResultNumberAreInSyncWithPagination() {
        Select dropdown = new Select(resultPerPageDropdown);
        WebElement option = dropdown.getFirstSelectedOption();
        int currentPageSize = Integer.parseInt(option.getText().trim());
        int currentPageNumberInPagination = Integer.parseInt(getReusableActionsInstance().getElementText(currentPageNumberHighlighted));
        String expectedSearchResultNumberStartsWith = Integer.toString((currentPageNumberInPagination - 1) * currentPageSize + 1);
        String actualSearchResultOnPage = getReusableActionsInstance().getElementText(searchResults);
        String firstPartOfSearchResult = actualSearchResultOnPage.split("-")[0];
        return firstPartOfSearchResult.equals(expectedSearchResultNumberStartsWith);
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
        int numberOfResults = resultsInPage.size();
        return numberOfResults <= expectedDefaultSearchResults;
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
            List<WebElement> dropdownOptions = dropdown.getOptions();
            Random rand = new Random();
            pageSizeNumber = rand.nextInt(dropdownOptions.size());
            dropdownOptions.get(pageSizeNumber).click();
            isPageLoaded();
            pageSize = dropdownOptions.get(pageSizeNumber).getText();
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
     * For eg if "1-10 of 464 results" is displayed, 464 will be returned
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
     * To check if the result links count is displayed correctly based on the random page size selected from the dropdown
     *
     * @author naina.agarwal
     */
    public boolean validateResultsAfterPageSizeSelection(String randomPageSize, int totalResults) {
        int pageSize;
        List<WebElement> resultLinks;
        resultLinks = getAllResultLinks();
        int resultSize = resultLinks.size();
        pageSize = Integer.parseInt(randomPageSize.trim());
        if ((pageSize < totalResults) && (resultSize == pageSize)) return true;
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
            if (results.equals(numbers[0]))
                verifyResult = true;
        } else if (pageSize > totalResults && resultSize == totalResults) {
            results = "1-".concat(String.valueOf(totalResults));
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
        boolean isMobile = isMobileSelected();
        if (isMobile) {
            boolean isFirstFwKeyEnabled = firstForwardArrowKey.isEnabled();
            if (isFirstFwKeyEnabled) {
                javascriptClickWithPerform(firstForwardArrowKey);
                message = clkFwdKey;
            } else
                message = cannotClickFwdKey;
        } else {
            elementName = getDriver().findElements(numberOfPagesDisplayedAtBottom);
            int numberOfPages = elementName.size();
            if (numberOfPages > 1) {
                getReusableActionsInstance().clickWhenReady(firstForwardArrowKey);
                message = clkFwdKey;
            } else if (numberOfPages == 1) message = cannotClickFwdKey;
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
        boolean isMobile = isMobileSelected();
        if (isMobile) {
            boolean isFirstBkKeyEnabled = firstBackwardArrowKey.isEnabled();
            if (isFirstBkKeyEnabled) {
                javascriptClickWithPerform(firstBackwardArrowKey);
                message = clkBackKey;
            } else
                message = cannotClkBackKey;
        } else {
            elementName = getDriver().findElements(numberOfPagesDisplayedAtBottom);
            int numberOfPages = elementName.size();
            if (numberOfPages > 1) {
                getReusableActionsInstance().executeJavaScriptClick(firstBackwardArrowKey);
                message = clkBackKey;
            } else message = cannotClkBackKey;
        }
        return message;
    }

    /**
     * This method will click on the last forward arrow key if more than one page is present
     *
     * @author naina.agarwal
     */
    public String clickLastForwardArrow() {
        String message;
        boolean isMobile = isMobileSelected();
        if (isMobile) {
            boolean islastFwKeyEnabled = lastForwardArrowKey.isEnabled();
            if (islastFwKeyEnabled) {
                javascriptClickWithPerform(lastForwardArrowKey);
                message = clickLastForwKey;
            } else
                message = cannotClickLastForwKey;
        } else {
            elementName = getDriver().findElements(numberOfPagesDisplayedAtBottom);
            int numberOfPages = elementName.size();
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
        boolean lastPageHighlighted = false;
        boolean isMobile = isMobileSelected();
        if (isMobile) {
            if (currentPageNumberHighlighted.isDisplayed())
                lastPageHighlighted = true;
        } else {
            String currentPageNumberInPagination = getReusableActionsInstance().getElementText(currentPageNumberHighlighted);
            elementName = getDriver().findElements(numberOfPagesDisplayedAtBottom);
            int pages = elementName.size();
            String pageSelected = elementName.get(pages - 1).getText();
            lastPageHighlighted = currentPageNumberInPagination.trim().equals(pageSelected.trim());
        }
        return lastPageHighlighted;
    }

    /**
     * This method will click on the last backward arrow if more than one page is present
     *
     * @author naina.agarwal
     */
    public String clickLastBackwardArrow() {
        String message;
        boolean isMobile = isMobileSelected();
        if (isMobile) {
            boolean islastBkKeyEnabled = lastBackwardArrowKey.isEnabled();
            if (islastBkKeyEnabled) {
                javascriptClickWithPerform(lastBackwardArrowKey);
                message = clickLastBackKey;
            } else
                message = cannotClickLastBackKey;
        } else {
            elementName = getDriver().findElements(numberOfPagesDisplayedAtBottom);
            int numberOfPages = elementName.size();
            if (numberOfPages > 1) {
                getReusableActionsInstance().executeJavaScriptClick(lastBackwardArrowKey);
                message = clickLastBackKey;
            } else
                message = cannotClickLastBackKey;
        }
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
        boolean isMobile = isMobileSelected();
        if (!isMobile) {
            getReusableActionsInstance().switchToNewWindow();
        }
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
     * @return the language before Toggle
     * @author naina.agarwal
     */
    public String toggleLanguage() {
        boolean isMobile = isMobileSelected();
        String currentLanguageBeforeToggle = null;
        if (isMobile) {
            getReusableActionsInstance().clickWhenReady(topFilterMbl);
            isPageLoaded();
            currentLanguageBeforeToggle = getReusableActionsInstance().getElementText(toggleLanguageMbl);
            currentLanguageBeforeToggle = currentLanguageBeforeToggle.substring(0, 2);
            getReusableActionsInstance().clickWhenReady(toggleLanguageMbl);
        } else {
            currentLanguageBeforeToggle = getReusableActionsInstance().getElementText(toggleLanguage);
            getReusableActionsInstance().clickWhenReady(toggleLanguage);
            isPageLoaded();
        }
        return currentLanguageBeforeToggle;
    }

    public boolean isGrandParentFilterUnexpanded() {
        boolean filterExpanded = true;
        int attempts = 0;
        while (attempts < 2) {
            try {
                List<WebElement> listofItems = getDriver().findElements(allGrandParentFilters);
                for (WebElement listofItem : listofItems) {
                    if (listofItem.getAttribute("aria-hidden").equals("false"))
                        filterExpanded = false;
                }
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }
            attempts++;
        }
        return filterExpanded;
    }

    /**
     * Validate that search term in search results matches the passed search term.
     *
     * @author naina.agarwal
     */
    public boolean searchTermRetained(String searchTerm) {
        boolean termIsRetained = false;
        String termInSearchResult = getReusableActionsInstance().getElementText(searchResults);
        if (termInSearchResult.endsWith(searchTerm)) termIsRetained = true;
        return termIsRetained;
    }

    public boolean validateLanguageInUrl(String language) throws UnsupportedEncodingException {
        String strQuery = "language=" + language.trim().toLowerCase();
        return validateURLContains(strQuery);
    }

    public String updateURLWithDifferentLanguage() {
        boolean isMobile = isMobileSelected();
        String currentLanguage;
        currentLanguage = toggleLanguage();
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
        boolean toggleUpdate = false;
        String currentURL = getDriver().getCurrentUrl();
        String currentDisplayedLanguageOnToggle = toggleLanguage().toLowerCase();
        if ((currentURL.contains("language=en") && (currentDisplayedLanguageOnToggle.contains("fr"))) | (currentURL.contains("language=fr") && (currentDisplayedLanguageOnToggle.equals("en"))))
            toggleUpdate = true;
        return toggleUpdate;
    }

    /**
     * Validate if filter component is displayed when single result is found.
     * Return true when no component is found.
     *
     * @author naina.agarwal
     */
    public boolean isFilterDisplayed() {
        boolean singleResult = false;
        List<WebElement> filter = getDriver().findElements(FilterComponent);
        if (filter.size() > 0)
            singleResult = true;
        return singleResult;
    }

    public boolean isPaginationDisplayed() {
        boolean singleResult = false;
        List<WebElement> pagination = getDriver().findElements(PaginationComponent);
        if (pagination.size() > 0)
            singleResult = true;
        return singleResult;
    }

    public boolean isDetailsPageDisplayed(String searchTerm) {
        boolean detailsPage, detailsPageNotPresent = false;
        try {
            detailsPage = getDriver().findElement(titleOnDetailsPage).isDisplayed();
            if (detailsPage)
                detailsPageNotPresent = false;
        } catch (Exception e) {
            detailsPageNotPresent = true;
        }
        return detailsPageNotPresent;
    }

    /**
     * This method will wait for the product details page
     *
     * @author naina.agarwal
     */
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

    /**
     * This method will select a random province from the province dropdown
     *
     * @author naina.agarwal
     */
    public String selectRandomProvince() {
        boolean isMobile = isMobileSelected();
        List<WebElement> province;
        String provinceSelected = null;
        try {
            if (isMobile) {
                getReusableActionsInstance().clickWhenReady(topFilterMbl);
                javascriptClickWithPerform(provinceDropdownMbl);
                WebDriverWait wait = new WebDriverWait(getDriver(), 15);
                wait.until(ExpectedConditions.visibilityOfElementLocated(provinceDropdownValuesMbl));
                province = getDriver().findElements(provinceDropdownValuesMbl);
            } else {
                getReusableActionsInstance().clickWhenReady(provinceDropdown);
                WebDriverWait wait = new WebDriverWait(getDriver(), 15);
                wait.until(ExpectedConditions.visibilityOfElementLocated(provinceDropdownValues));
                province = getDriver().findElements(provinceDropdownValues);
            }
            int numberOfProvinces = province.size() - 1;
            int randomNumber = randomNumber(numberOfProvinces);
            provinceSelected = province.get(randomNumber).getText();
            isPageLoaded();
            javascriptClickWithPerform(province.get(randomNumber));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return provinceSelected;
    }

    public boolean validateProvinceAfterToggle(String province) {
        boolean isMobile = isMobileSelected();
        boolean provinceMatch = false;
        try {
            if (isMobile) {
                getReusableActionsInstance().clickWhenReady(topFilterMbl);
                String currentProvince = (provinceDropdownMbl).getAttribute("aria-label");
                if (province.equals(currentProvince))
                    provinceMatch = true;
            } else {
                String currentProvince = getDriver().findElement(provinceInToggle).getAttribute("aria-label");
                if (province.equals(currentProvince))
                    provinceMatch = true;
            }
        } catch (Exception e) {
            throw new DigiAutoCustomException(e);
        }
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

    /**
     * This method will check if home page is displayed for search
     *
     * @author naina.agarwal
     */
    public boolean validateHomeURL() {
        boolean homeURL = false;
        String currentURL = null;
        try {
            wait = new WebDriverWait(getDriver(), 2000);
            String defaultURL = System.getProperty("SearchUrl");
            if (defaultURL.contains("qa")) {
                wait.until(ExpectedConditions.urlContains("home"));
                currentURL = getDriver().getCurrentUrl();
                if (currentURL.contains("home"))
                    homeURL = true;
            } else {
                currentURL = getDriver().getCurrentUrl();
                if (currentURL.equals("https://www.rogers.com/"))
                    homeURL = true;
            }
        } catch (Exception e) {
            throw new DigiAutoCustomException(e);
        }
        return homeURL;
    }
    //Mobile Methods

    /**
     * This method will click on the filter icon displayed on the mobile browser.
     *
     * @author naina.agarwal
     */
    public void clkFilterIconMobile() {
        javascriptClickWithPerform(filterIconMobile);
    }

    /**
     * This method will fetch the current browser value.
     *
     * @return true if browser equals androidchrome,sauceandroidchrome,sauceioschrome,chromemobile
     * @author naina.agarwal
     */
    public boolean isMobileSelected() {
        String browser = System.getProperty("Browser");
        if (browser != null && browser.equals("androidchrome") || browser.equals("sauceandroidchrome") || browser.equals("sauceioschrome") || browser.equals("chromemobile"))
            return true;
        else return false;
    }

    public void clkShowResultBtnMobile() {
        getReusableActionsInstance().clickWhenReady(showResultBtnMobile);
    }

    public void clkOnCrossMarkMbl() {
        getReusableActionsInstance().clickWhenReady(crossMarkTopMbl);
    }

    public void isEnvQA() {
        String url = null;
        url = getDriver().getCurrentUrl();
        if (url.contains("qa")) {
            getDriver().get(System.getProperty("SearchUrl") + "wireless");
            isPageLoaded();
        }
    }
}
