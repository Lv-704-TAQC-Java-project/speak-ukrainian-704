package pages.clubs;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.time.Duration;
import java.util.List;

public class AdvancedSearchPanelComponent extends BasePage {
    private ClubPageComponent clubPageComponent;
    private List<WebElement> clubListSectionChildren;
    private WebElement asideAdvancedSearchMenu;
    private WebElement advancedSearchHeader;
    private WebElement citySelector;
    private WebElement isAvailableOnline;
    private WebElement basicCategoriesCheckList;
    private List<WebElement> listOfBasicCategoriesCheckList;
    public AdvancedSearchPanelComponent(WebDriver driver) {
        super(driver);
    }

    public ClubPageComponent getClubPageComponent() {
        if (clubPageComponent == null) {
            clubPageComponent = new ClubPageComponent(driver);
        }
        return clubPageComponent;
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

    public WebElement getIsAvailableOnline() {
        if (isAvailableOnline == null) {
            isAvailableOnline = driver.findElement(By.xpath("//div[@id='basic_isOnline']"));
        }
        return isAvailableOnline;
    }

    public String getAdvancedSearchHeaderText() {
        return getAdvancedSearchHeader().getText();
    }

    public List<WebElement> getListOfBasicCategoriesCheckList() {
        if (listOfBasicCategoriesCheckList == null) {
            listOfBasicCategoriesCheckList = getBasicCategoriesCheckList()
                    .findElements(By.xpath(".//input[@type='checkbox']"));
        }
        return listOfBasicCategoriesCheckList;
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

    public boolean isAvailableOnlineIsVisible() {
        return getIsAvailableOnline().isDisplayed();
    }

    public boolean advancedAsideMenuIsVisible() {
        try {
            return getAsideAdvancedSearchMenu().isDisplayed();
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

    public AdvancedSearchPanelComponent isOnlineCheckboxClick() {
        getIsAvailableOnline().click();
        return this;
    }

    public boolean sectionsClick(){
        boolean isCategoryAvailableOnCard = true;
        List<WebElement> categories = getListOfBasicCategoriesCheckList();
        ClubPageComponent clubPageComponent = getClubPageComponent();
        for (WebElement category : categories){
            category.click();
            String categoryName = category.getAttribute("value");
//            sleep(5);
            List<WebElement> cards = clubPageComponent.getListOfCards();
            isCategoryAvailableOnCard = clubPageComponent.isCategoryAvailableOnCard(cards, categoryName);
            category.click();
        }
        return isCategoryAvailableOnCard;
    }
}
