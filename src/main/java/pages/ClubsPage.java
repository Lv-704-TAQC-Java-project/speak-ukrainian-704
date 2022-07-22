package pages;

import org.openqa.selenium.*;
import pages.components.AdvancedSearchPanelComponent;

import java.util.List;


public class ClubsPage extends BasePageWithHeader {
    private List<WebElement> listOfClubsOnCurrentPage;
    private List<WebElement> listOfPagesInPagination;
    private WebElement lastPaginationPage;
    private AdvancedSearchPanelComponent advancedSearchPanelComponent;
    private WebElement advancedSearchButton;


    public ClubsPage(WebDriver driver) {
        super(driver);
    }

    public ClubsPage waitForClubsPageToOpen() {
        waitForPageToReload();
        return this;
    }

    public AdvancedSearchPanelComponent getAdvancedSearchPanelComponent() {
        if (advancedSearchPanelComponent == null) {
            advancedSearchPanelComponent = new AdvancedSearchPanelComponent(driver);
        }
        return advancedSearchPanelComponent;
    }

    public List<WebElement> getListOfClubsOnCurrentPage() {
        listOfClubsOnCurrentPage = driver.findElements(By.xpath("//div[contains(@class, 'ant-card-body')]"));
        return listOfClubsOnCurrentPage;
    }

    public List<WebElement> getListOfPagesInPagination() {
        if (listOfPagesInPagination == null) {
            waitVisibilityOfElements(By.xpath("//li[contains(@class, 'ant-pagination-item')]"));
            listOfPagesInPagination = driver.findElements(By.xpath("//li[contains(@class, 'ant-pagination-item')]"));
        }
        return listOfPagesInPagination;
    }


    public WebElement getAdvancedSearchButton() {
        waitVisibilityOfElement(By.xpath("//span[contains(@class, 'anticon-control')]"));
        if (advancedSearchButton == null) {
            advancedSearchButton = driver.findElement(By.xpath("//span[contains(@class, 'anticon-control')]"));
        }
        return advancedSearchButton;
    }

    public int getQuantityOfClubsOnCurrentPage() {
        return getListOfClubsOnCurrentPage().size();
    }

    public String getAdvancedSearchHeaderText() {
        return getAdvancedSearchPanelComponent().getAdvancedSearchHeader().getText();
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

    public boolean advancedSearchSideMenuIsVisible() {
        return getAdvancedSearchPanelComponent().getAsideAdvancedSearchMenu().isDisplayed();
    }

    public boolean citySelectionInputIsVisible() {
        return getAdvancedSearchPanelComponent().getCitySelector().isDisplayed();
    }

    public boolean basicCategoriesCheckListIsVisible() {
        return getAdvancedSearchPanelComponent().getBasicCategoriesCheckList().isDisplayed();
    }

    public AdvancedSearchPanelComponent clickAdvancedSearchButton() {
        getAdvancedSearchButton().click();
        return getAdvancedSearchPanelComponent();
    }

    public boolean advancedAsideMenuIsVisible() {
        try {
            return getAdvancedSearchPanelComponent().getAsideAdvancedSearchMenu().isDisplayed();
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }
}
