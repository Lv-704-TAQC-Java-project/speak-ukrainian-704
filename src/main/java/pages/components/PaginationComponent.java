package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePageWithHeader;

import java.util.List;

public class PaginationComponent extends BasePageWithHeader {
    private List<WebElement> listOfClubsOnCurrentPage;
    private List<WebElement> listOfPagesInPagination;
    private WebElement lastPaginationPage;

    public PaginationComponent(WebDriver driver) {
        super(driver);
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
        if (lastPaginationPage == null) {
            lastPaginationPage = getListOfPagesInPagination().get(getListOfPagesInPagination().size() - 1);
        }
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
