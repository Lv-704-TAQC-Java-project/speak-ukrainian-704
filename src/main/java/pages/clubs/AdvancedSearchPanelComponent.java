package pages.clubs;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

import java.time.Duration;
import java.util.List;

public class AdvancedSearchPanelComponent extends BasePage {
    private List<WebElement> clubListSectionChildren;
    private List<WebElement> districtListSectionChildren;
    private WebElement asideAdvancedSearchMenu;
    private WebElement advancedSearchHeader;
    private WebElement citySelector;
    private WebElement districtSelector;
    private WebElement clearDistrictSelector;
    private WebElement availableOnline;
    private WebElement basicCategoriesCheckList;
    private List<WebElement> listOfCategoriesCheckList;

    public AdvancedSearchPanelComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getAsideAdvancedSearchMenu() {
        if (asideAdvancedSearchMenu == null) {
            waitVisibilityOfElement(By.xpath("//aside"), Duration.ofSeconds(2));
            asideAdvancedSearchMenu = driver.findElement(By.xpath("//aside"));
        }
        return asideAdvancedSearchMenu;
    }

    public WebElement getAdvancedSearchHeader() {
        if (advancedSearchHeader == null) {
            advancedSearchHeader = driver.findElement(By.xpath("//div[@class='club-list-label']"));
        }
        return advancedSearchHeader;
    }

    public WebElement getCitySelector() {
        if (citySelector == null) {
            citySelector = driver.findElement(By.xpath("//input[@id='basic_cityName']//ancestor::div[contains(@class, 'selector')]"));
        }
        return citySelector;
    }

    public WebElement getDistrictSelector() {
        if (districtSelector == null) {
            districtSelector = driver.findElement(By.xpath("//input[@id='basic_districtName']"));
        }
        return districtSelector;
    }

    public WebElement getClearDistrictSelector() {
        if (clearDistrictSelector == null) {
            clearDistrictSelector = driver.findElement(By.xpath("//input[@id='basic_districtName']/../../..//div"));
        }
        return clearDistrictSelector;
    }

    public WebElement getBasicCategoriesCheckList() {
        if (basicCategoriesCheckList == null) {
            basicCategoriesCheckList = driver.findElement(By.xpath("//div[@id='basic_categoriesName']"));
        }
        return basicCategoriesCheckList;
    }

    public List<WebElement> getClubListSectionChildren() {
        clubListSectionChildren = driver.findElements(By.xpath("//section[contains(@class, 'club-list')]/child::*"));
        return clubListSectionChildren;
    }

    public List<WebElement> getDistrictListSectionChildren() {
        districtListSectionChildren = driver.findElements(By.xpath("//div[@id='basic_districtName_list']/following-sibling::div//div[@class='rc-virtual-list-holder-inner']/div"));
        return districtListSectionChildren;
    }

    public WebElement getAvailableOnline() {
        if (availableOnline == null) {
            availableOnline = driver.findElement(By.xpath("//div[@id='basic_isOnline']"));
        }
        return availableOnline;
    }

    public List<WebElement> getListOfCategoriesCheckList() {
        if (listOfCategoriesCheckList == null) {
            listOfCategoriesCheckList = getBasicCategoriesCheckList()
                    .findElements(By.xpath(".//input[@type='checkbox']"));
        }
        return listOfCategoriesCheckList;
    }

    public String getAdvancedSearchHeaderText() {
        return getAdvancedSearchHeader().getText();
    }

    public boolean advancedSearchSideMenuIsVisible() {
        return getAsideAdvancedSearchMenu().isDisplayed();
    }

    public boolean citySelectionInputIsVisible() {
        return getCitySelector().isDisplayed();
    }

    public boolean basicCategoriesCheckListIsVisible() {
        return getBasicCategoriesCheckList().isDisplayed();
    }

    public boolean availableOnlineIsVisible() {
        return getAvailableOnline().isDisplayed();
    }

    public boolean advancedAsideMenuIsVisible() {
        try {
            return getAsideAdvancedSearchMenu().isDisplayed();
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

    public AdvancedSearchPanelComponent availableOnlineCheckboxClick() {
        getAvailableOnline().click();
        return this;
    }

    public AdvancedSearchPanelComponent openDistrictInputSelect() {
        Actions actions = new Actions(driver);
        actions.moveToElement(getDistrictSelector()).click().perform();
        return this;
    }

    public void categoryClick(String category) {
        driver.findElement(By.xpath(String.format("//input[@value='%s']", category))).click();
    }

    public AdvancedSearchPanelComponent clearDistrictInputSelect() {
        getClearDistrictSelector().click();
        return this;
    }


}
