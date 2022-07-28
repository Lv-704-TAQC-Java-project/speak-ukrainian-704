package advancedSearchPanel.tests;

import runners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.clubs.PaginationComponent;


public class ClubsTest extends BaseTestRunner {

    @Test
    public void checkNumberOfClubsOnFirstPageEqualsExpected() {
        PaginationComponent paginationComponent = new HomePage(driver)
                .getHeader()
                .openClubsPage()
                .openPaginationComponent();

        int quantityOfClubsOnFirstPage = paginationComponent.getQuantityOfClubsOnCurrentPage();

        Assert.assertEquals(quantityOfClubsOnFirstPage, 8,
                String.format("Number of clubs per page is expected to be 8, but was %s instead.", quantityOfClubsOnFirstPage));
    }

    @Test
    public void checkTotalNumberOfClubsEqualsExpected() {
        PaginationComponent paginationComponent = new HomePage(driver)
                .getHeader()
                .openClubsPage().openPaginationComponent();

        int quantityOfClubsOnFirstPage = paginationComponent.getQuantityOfClubsOnCurrentPage();
        int numberOfPagesInPagination = paginationComponent.getNumberOfPagesInPagination();

        paginationComponent
                .openLastPageInPagination();

        int quantityOfClubsOnLastPage = paginationComponent.getQuantityOfClubsOnCurrentPage();
        int totalNumberOfClubs = quantityOfClubsOnFirstPage * (numberOfPagesInPagination - 1) + quantityOfClubsOnLastPage;

        Assert.assertEquals(totalNumberOfClubs, 368,
                String.format("Total number of clubs is expected to be 368, but was %s instead.", totalNumberOfClubs));
    }
}
