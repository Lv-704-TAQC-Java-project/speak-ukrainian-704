package pages.clubs;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;
import pages.clubs.card.components.CardComponent;

import java.time.Duration;
import java.util.List;

public class AdvancedSearchPanelComponent extends BasePage {
    private List<WebElement> clubListSectionChildren;
    private List<WebElement> districtListSectionChildren;
    private WebElement asideAdvancedSearchMenu;
    private WebElement advancedSearchHeader;
    private WebElement citySelector;
    private WebElement districtSelector;
    private WebElement metroSelector;
    private WebElement clearDistrictSelector;
    private WebElement basicCategoriesCheckList;
    private WebElement clubRadioButton;
    private WebElement centerRadioButton;
    private WebElement availableOnline;
    private WebElement scrollDistrictSelector;

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

    public WebElement getMetroSelector() {
        if (metroSelector == null) {
            metroSelector = driver.findElement(By.xpath("//input[@id='basic_stationName']"));
        }
        return metroSelector;
    }

    public WebElement getScrollDistrictSelector() {
        if (scrollDistrictSelector == null) {
            scrollDistrictSelector = driver.findElement(By.xpath("//div[@id='basic_districtName_list']/following-sibling::div//div[@class='rc-virtual-list-holder-inner']"));
        }
        return scrollDistrictSelector;
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

    public List<WebElement> getMetroListSectionChildren() {
        districtListSectionChildren = driver.findElements(By.xpath("//div[@id='basic_stationName_list']/following-sibling::div//div[@class='rc-virtual-list-holder-inner']/div"));
        return districtListSectionChildren;
    }

    public WebElement getAvailableOnline() {
        if (availableOnline == null) {
            availableOnline = driver.findElement(By.xpath("//div[@id='basic_isOnline']"));
        }

        return availableOnline;
    }

    public WebElement getClubRadioButton() {
        if (clubRadioButton == null) {
            clubRadioButton = driver.findElement(By.xpath("//label/span[contains(text(),'Гурток')"));
        }
        return clubRadioButton;
    }

    public WebElement getCenterRadioButton() {
        if (centerRadioButton == null) {
            centerRadioButton = driver.findElement(By.xpath("//label/span[contains(text(),'Центр')]"));
        }
        return centerRadioButton;
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
        try {
            return getAsideAdvancedSearchMenu().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
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
        clickManagingElement(getAvailableOnline());
        return this;
    }
    public void clickManagingElement(WebElement element) {
        List<CardComponent> cards = new ClubsPage(driver).getCards();
        element.click();
        for (CardComponent card: cards) {
            waitStalenessOfElement(card.getCardBody());
        }
    }

    public boolean availableOnlineCheckboxIsDisplayed() {
        try{
            return getAvailableOnline().isDisplayed();
        }
       catch (NoSuchElementException e) {
           return false;
       }
    }

    public AdvancedSearchPanelComponent openDistrictInputSelect() {
        Actions actions = new Actions(driver);
        actions.moveToElement(getDistrictSelector()).click().perform();
        return this;
    }

    public AdvancedSearchPanelComponent openMetroInputSelect() {
        Actions actions = new Actions(driver);
        actions.moveToElement(getMetroSelector()).click().perform();
        return this;
    }

    public AdvancedSearchPanelComponent openCityInputSelect() {
        Actions actions = new Actions(driver);
        actions.moveToElement(getCitySelector()).click().perform();
        return this;
    }

    public AdvancedSearchPanelComponent scrollDistrictInputSelect() {
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollTop=arguments[1].offsetTop",getScrollDistrictSelector());
        return this;
    }

    public WebElement getCategoryFromString(String name) {
//        waitVisibilityOfElement(By.xpath(String.format("//input[@value='%s']", name)), Duration.ofSeconds(2));
        return driver.findElement(By.xpath(String.format("//input[@value='%s']", name)));
    }

    public AdvancedSearchPanelComponent categoryClick(String categoryName) {
        WebElement card = driver.findElement(By.xpath("//div[contains(@class, 'card-body')]"));
        driver.findElement(By.xpath(String.format("//input[@value='%s']", categoryName))).click();
        waitStalenessOfElement(card);
        return this;
    }

    public AdvancedSearchPanelComponent clearDistrictInputSelect() {
        getClearDistrictSelector().click();
        return this;
    }

    public AdvancedSearchPanelComponent clubRadioButtonClick() {
        waitVisibilityOfWebElement(getClubRadioButton());
        getClubRadioButton().click();
        return this;
    }

    public AdvancedSearchPanelComponent centerRadioButtonClick() {
        waitVisibilityOfWebElement(getCenterRadioButton());
        getCenterRadioButton().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public AdvancedSearchPanelComponent centerRadioButtonClick2() {
        waitVisibilityOfWebElement(getClubRadioButton());
        getClubRadioButton().click();
        return this;
    }

    public boolean IsClubButtonSelected() {
        return getClubRadioButton().isSelected();
    }

    public boolean IsCenterButtonSelected() {
        return getCenterRadioButton().isSelected();
    }

}
