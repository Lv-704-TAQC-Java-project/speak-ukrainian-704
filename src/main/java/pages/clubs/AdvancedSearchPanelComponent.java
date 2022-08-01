package pages.clubs;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

import java.time.Duration;
import java.util.List;

public class AdvancedSearchPanelComponent extends BasePage {
    private List<WebElement> clubListSectionChildren;
    private WebElement districtListSectionChildren;
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
    private WebElement categoriesBlock;
    private WebElement childAgeBlock;
    private WebElement childAgeInput;
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

    public WebElement getChildAgeInput() {
        if (childAgeInput == null) {
            childAgeInput = driver.findElement(By.xpath("//span[@id='basic_age']//input"));
        }
        return childAgeInput;
    }

    public List<WebElement> getClubListSectionChildren() {
        clubListSectionChildren = driver.findElements(By.xpath("//section[contains(@class, 'club-list')]/child::*"));
        return clubListSectionChildren;
    }

    public WebElement getDistrictListSectionChildren(String district) {
        districtListSectionChildren = driver.findElement(By.xpath(String.format("//div[@title='%s']",district)));
        return districtListSectionChildren;
    }



    public WebElement getMetroListSectionChildren(String metroStation) {
        districtListSectionChildren = driver.findElement(By.xpath(String.format("//div[@title='%s']",metroStation)));
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
            clubRadioButton = driver.findElement(By.xpath("//label/span[contains(text(),'Гурток')]"));
        }
        return clubRadioButton;
    }

    public WebElement getCenterRadioButton() {
        if (centerRadioButton == null) {
            centerRadioButton = driver.findElement(By.xpath("//label/span[contains(text(),'Центр')]"));
        }
        return centerRadioButton;
    }

    public WebElement getCategoriesBlock() {
        if (categoriesBlock == null) {
            categoriesBlock = driver.findElement(By.xpath("//label[contains(text(),'Категорії')]/../.."));
        }
        return categoriesBlock;
    }

    public WebElement getChildAgeBlock() {
        if (childAgeBlock == null) {
            childAgeBlock = driver.findElement(By.xpath("//label[contains(text(),'Вік дитини')]/../.."));
        }
        return childAgeBlock;
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
        clickManagingClubsPageElement(getAvailableOnline());
        return this;
    }

    public boolean availableOnlineCheckboxIsDisplayed() {
        try {
            return getAvailableOnline().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean categoriesBlockIsDisplayed() {
        try {
            return getCategoriesBlock().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean childAgeBlockIsDisplayed() {
        try {
            return getChildAgeBlock().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public AdvancedSearchPanelComponent openDistrictInputSelect() {
        clickManagingClubsPageElement(getDistrictSelector());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public AdvancedSearchPanelComponent clickDistrictWithName(String district) {
        clickManagingClubsPageElement(getDistrictListSectionChildren(district));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public AdvancedSearchPanelComponent openMetroInputSelect() {
        clickManagingClubsPageElement(getMetroSelector());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public AdvancedSearchPanelComponent clickMetroWithName(String district) {
        clickManagingClubsPageElement(getDistrictListSectionChildren(district));
        return this;
    }

    public AdvancedSearchPanelComponent openDistrictInputSelectCenter() {
        clickManagingCenterPageElement(getDistrictSelector());
        return this;
    }

    public AdvancedSearchPanelComponent clickDistrictWithNameCenter(String district) {
        clickManagingCenterPageElement(getDistrictListSectionChildren(district));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public AdvancedSearchPanelComponent openMetroInputSelectCenter() {
        clickManagingCenterPageElement(getMetroSelector());
        return this;
    }

    public AdvancedSearchPanelComponent clickMetroWithNameCenter(String district) {
        clickManagingCenterPageElement(getDistrictListSectionChildren(district));
        return this;
    }

    public AdvancedSearchPanelComponent openCityInputSelect() {
        Actions actions = new Actions(driver);
        actions.moveToElement(getCitySelector()).click().perform();
        return this;
    }

    public AdvancedSearchPanelComponent scrollDistrictInputSelect() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollTop=arguments[1].offsetTop",getScrollDistrictSelector());
        return this;
    }

    public WebElement getCategoryFromString(String name) {
//        waitVisibilityOfElement(By.xpath(String.format("//input[@value='%s']", name)), Duration.ofSeconds(2));
        return driver.findElement(By.xpath(String.format("//input[@value='%s']", name)));
    }

    public AdvancedSearchPanelComponent categoryClick(String categoryName) {
        clickManagingClubsPageElement(getCategoryFromString(categoryName));
        return this;
    }

    public AdvancedSearchPanelComponent clearDistrictInputSelect() {
        getClearDistrictSelector().click();
        return this;
    }

    public AdvancedSearchPanelComponent clubRadioButtonClick() {
        waitVisibilityOfWebElement(getClubRadioButton());
        getClubRadioButton().click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this;
    }

    public AdvancedSearchPanelComponent centerRadioButtonClick() {
        waitVisibilityOfWebElement(getCenterRadioButton());
        clickManagingClubsPageElement(getCenterRadioButton());
        return this;
    }
    public AdvancedSearchPanelComponent centerRadioButtonClickAnother() {
        waitVisibilityOfWebElement(getCenterRadioButton());
        getCenterRadioButton().click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public boolean IsClubButtonSelected() {
        try {
            return driver.findElement(By.xpath("//label[contains(@class,'ant-radio-wrapper-checked')]/span[contains(text(),'Гурток')]")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean IsCenterButtonSelected() {
        try {
            return driver.findElement(By.xpath("//label[contains(@class,'ant-radio-wrapper-checked')]/span[contains(text(),'Центр')]")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public AdvancedSearchPanelComponent enterChildAge(Integer age){
        getChildAgeInput().click();
        getChildAgeInput().clear();
        getChildAgeInput().sendKeys(age.toString());
        clickManagingClubsPageElement(getChildAgeInput());
        return this;
    }

    public AdvancedSearchPanelComponent clearChildAge(){
        getChildAgeInput().click();
        getChildAgeInput().clear();
        clickManagingClubsPageElement(getChildAgeInput());
        return this;
    }

}
