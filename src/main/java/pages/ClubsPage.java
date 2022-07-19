package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class ClubsPage extends BasePage {
    private List<WebElement> listOfClubsOnCurrentPage;
    private List<WebElement> listOfPagesInPagination;
    private List<WebElement> clubListSectionChildren;
    private WebElement asideExtendedSearchMenu;
    private WebElement lastPaginationPage;
    private WebElement extendedSearchHeader;
    private WebElement citySelector;
    private WebElement basicCategoriesCheckList;
    private WebElement extendedSearchButton;


    public ClubsPage(WebDriver driver) {
        super(driver);
    }

    public ClubsPage waitForClubsPageToOpen() {
        waitForPageToReload();
        return this;
    }

    public List<WebElement> getListOfClubsOnCurrentPage() {
        listOfClubsOnCurrentPage = driver.findElements(By.xpath("//div[contains(@class, 'ant-card-body')]"));
        return listOfClubsOnCurrentPage;
    }

    public List<WebElement> getListOfPagesInPagination() {
        waitVisibilityOfElements(By.xpath("//li[contains(@class, 'ant-pagination-item')]"));
        if (listOfPagesInPagination == null) {
            listOfPagesInPagination = driver.findElements(By.xpath("//li[contains(@class, 'ant-pagination-item')]"));
        }
        return listOfPagesInPagination;
    }

    public WebElement getAsideExtendedSearchMenu() {
        waitVisibilityOfElement(By.xpath("//aside"));
        if (asideExtendedSearchMenu == null) {
            asideExtendedSearchMenu = driver.findElement(By.xpath("//aside"));
        }
        return asideExtendedSearchMenu;
    }

    public WebElement getExtendedSearchHeader() {
        if (extendedSearchHeader == null) {
            extendedSearchHeader = driver.findElement(By.xpath("//div[@class='club-list-label']"));
        }
        return extendedSearchHeader;
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

    public WebElement getExtendedSearchButton() {
        waitVisibilityOfElement(By.xpath("//span[contains(@class, 'anticon-control')]"));
        if (extendedSearchButton == null) {
            extendedSearchButton = driver.findElement(By.xpath("//span[contains(@class, 'anticon-control')]"));
        }
        return extendedSearchButton;
    }

    public List<WebElement> getClubListSectionChildren() {
        clubListSectionChildren = driver.findElements(By.xpath("//section[contains(@class, 'club-list')]/child::*"));
        return clubListSectionChildren;
    }

    public int getQuantityOfClubsOnCurrentPage() {
        return getListOfClubsOnCurrentPage().size();
    }

    public String getExtendedSearchHeaderText() {
        return getExtendedSearchHeader().getText();
    }

    public WebElement getLastPaginationPage() {
        if (lastPaginationPage == null) {
            lastPaginationPage = getListOfPagesInPagination().get(getListOfPagesInPagination().size() - 1);
        }
        return lastPaginationPage;
    }

    public int getNumberOfPagesInPagination() {
        return Integer.parseInt(getLastPaginationPage().findElement(By.xpath("./child::a")).getText());
    }

    public ClubsPage openLastPageInPagination() {
        getLastPaginationPage().click();
        return this;
    }

    public ClubsPage waitForPageToRefresh() {
        WebElement firstClubPOnPage = listOfClubsOnCurrentPage.get(0);
        waitInvisibilityOfElement(firstClubPOnPage);
        return this;
    }

    public boolean extendedSearchSideMenuIsVisible() {
        return getAsideExtendedSearchMenu().isDisplayed();
    }

    public boolean citySelectionInputIsVisible() {
        return getCitySelector().isDisplayed();
    }

    public boolean basicCategoriesCheckListIsVisible() {
        return getBasicCategoriesCheckList().isDisplayed();
    }

    public ClubsPage clickExtendedSearchButton() {
        getExtendedSearchButton().click();
        return this;
    }

    public int getNumberOfChildrenOfClubListSection() {
        return getClubListSectionChildren().size();
    }
}
