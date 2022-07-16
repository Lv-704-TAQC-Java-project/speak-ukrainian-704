package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class ClubsPage extends BasePage {
    private final String listOfClubsOnCurrentPagePath = "//div[contains(@class, 'ant-card-body')]";
    private final String listOfPaginationPagesPath = "//li[contains(@class, 'ant-pagination-item')]";
    private final String asideExtendedSearchMenuPath = "//aside";
    private final String extendedSearchHeaderPath = "//div[@class='club-list-label']";
    private final String citySelectorPath = "//input[@id='basic_cityName']//ancestor::div[contains(@class, 'selector')]";
    private final String basicCategoriesCheckListPath = "//div[@id='basic_categoriesName']";
    private final String extendedSearchButtonPath = "//span[contains(@class, 'anticon-control')]";
    private final String clubListSectionChildrenPath = "//section[contains(@class, 'club-list')]/child::*";
    private List<WebElement> listOfClubsOnCurrentPage;
    private List<WebElement> listOfPaginationPages;
    private WebElement lastPaginationPage;


    public ClubsPage(WebDriver driver) {
        super(driver);
    }

    public ClubsPage waitForClubsPageToOpen() {
        waitForPageToReload();
        return this;
    }

    public int getQuantityOfClubsOnCurrentPage() {
        listOfClubsOnCurrentPage = driver.findElements(By.xpath(listOfClubsOnCurrentPagePath));
        return listOfClubsOnCurrentPage.size();
    }

    public int getNumberOfPagesInPagination() {
        listOfPaginationPages = driver.findElements(By.xpath(listOfPaginationPagesPath));
        lastPaginationPage = listOfPaginationPages.get(listOfPaginationPages.size() - 1);
        return Integer.parseInt(lastPaginationPage.findElement(By.xpath("./child::a")).getText());
    }

    public ClubsPage openLastPageInPagination() {
        listOfPaginationPages = driver.findElements(By.xpath(listOfPaginationPagesPath));
        lastPaginationPage = listOfPaginationPages.get(listOfPaginationPages.size() - 1);
        lastPaginationPage.click();
        return this;
    }

    public ClubsPage waitForPageToRefresh() {
        WebElement firstClubPOnPage = listOfClubsOnCurrentPage.get(0);
        waitInvisibilityOfElement(firstClubPOnPage);
        return this;
    }

    public boolean extendedSearchSideMenuIsVisible() {
        waitVisibilityOfElement(By.xpath(asideExtendedSearchMenuPath));
        WebElement asideExtendedSearchMenu = driver.findElement(By.xpath(asideExtendedSearchMenuPath));
        return asideExtendedSearchMenu.isDisplayed();
    }

    public String getExtendedSearchHeader() {
        WebElement extendedSearchHeader = driver.findElement(By.xpath(extendedSearchHeaderPath));
        return extendedSearchHeader.getText();
    }

    public boolean citySelectionInputIsVisible() {
        return driver.findElement(By.xpath(citySelectorPath)).isDisplayed();
    }

    public boolean basicCategoriesCheckListIsVisible() {
        return driver.findElement(By.xpath(basicCategoriesCheckListPath)).isDisplayed();
    }

    public ClubsPage clickExtendedSearchButton() {
        waitVisibilityOfElement(By.xpath(extendedSearchButtonPath));
        WebElement extendedSearchButton = driver.findElement(By.xpath(extendedSearchButtonPath));
        action.moveToElement(extendedSearchButton).click().perform();
        return this;
    }

    public int getNumberOfChildrenOfClubListSection() {
        return driver.findElements(By.xpath(clubListSectionChildrenPath)).size();
    }
}
