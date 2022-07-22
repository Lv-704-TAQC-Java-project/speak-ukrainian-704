package login.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ClubsPage;
import pages.components.PaginationComponent;


public class ClubsTest extends BaseTest {

    @Test
    public void checkNumberOfClubsOnFirstPageEqualsExpected() {
        PaginationComponent paginationComponent = getHomePage()
                .openClubsPage().openPaginationComponent();

        int quantityOfClubsOnFirstPage = paginationComponent.getQuantityOfClubsOnCurrentPage();

        Assert.assertEquals(quantityOfClubsOnFirstPage, 8,
                "Number of clubs per page is expected to be 8, but was " + quantityOfClubsOnFirstPage + " instead.");
    }

    @Test
    public void checkTotalNumberOfClubsEqualsExpected() {
        PaginationComponent paginationComponent = getHomePage()
                .openClubsPage().openPaginationComponent();

        int quantityOfClubsOnFirstPage = paginationComponent.getQuantityOfClubsOnCurrentPage();
        int numberOfPagesInPagination = paginationComponent.getNumberOfPagesInPagination();

        paginationComponent
                .openLastPageInPagination();

        int quantityOfClubsOnLastPage = paginationComponent.getQuantityOfClubsOnCurrentPage();
        int totalNumberOfClubs = quantityOfClubsOnFirstPage * (numberOfPagesInPagination - 1) + quantityOfClubsOnLastPage;

        Assert.assertEquals(totalNumberOfClubs, 368,
                "Total number of clubs is expected to be 368, but was " + totalNumberOfClubs + " instead.");
    }
}
