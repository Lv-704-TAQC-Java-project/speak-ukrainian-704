package pages.clubs;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import java.util.List;

public class PaginationComponent extends BasePage {
    private List<WebElement> listOfClubsOnCurrentPage;
    private List<WebElement> listOfPagesInPagination;
    private WebElement lastPaginationPage;
    private WebElement paginationContainer;

    public PaginationComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getPaginationContainer() {
        paginationContainer = driver.findElement(By.xpath("//ul[contains(@class, 'pagination')]"));
        return paginationContainer;
    }

    public boolean paginationIsPresent() {
        try {
            return getPaginationContainer().isDisplayed();
        } catch (NoSuchElementException ignore) {
            return false;
        }
    }

    public void clickNextPageButton(int currentPage) {
        WebElement nextPageButton = driver.findElement(By.xpath(String.format("//li[contains(@class, 'pagination-item') and @title=%d]", currentPage + 1)));
        clickManagingClubsPageElement(nextPageButton);
    }

    public void clickFirstPageButton() {
        WebElement firstPageButton = driver.findElement(By.xpath("//li[contains(@class, 'pagination-item') and @title=1]"));
        clickManagingClubsPageElement(firstPageButton);
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

    public WebElement getLastPaginationPage() {
        lastPaginationPage = getListOfPagesInPagination().get(getListOfPagesInPagination().size() - 1);
        return lastPaginationPage;
    }

    public int getQuantityOfClubsOnCurrentPage() {
        return getListOfClubsOnCurrentPage().size();
    }

    public int getNumberOfPagesInPagination() {
        return Integer.parseInt(getLastPaginationPage().findElement(By.xpath("./child::a")).getText());
    }

    public PaginationComponent openLastPageInPagination() {
        getLastPaginationPage().click();
        return this.waitForPageToRefresh();
    }

    public PaginationComponent waitForPaginationComponentToOpen() {
        waitForPageToReload();
        return this;
    }

    public PaginationComponent waitForPageToRefresh() {
        WebElement firstClubPOnPage = getListOfClubsOnCurrentPage().get(0);
        waitInvisibilityOfElement(firstClubPOnPage);
        return this;
    }
}
