package login.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ClubsPage;


public class ClubsTest extends BaseTestRunner {

    @Test
    public void checkNumberOfClubsOnFirstPageEqualsExpected() {
        ClubsPage clubsPage = getHomePage()
                .openClubsPage()
                .waitForClubsPageToOpen();

        int quantityOfClubsOnFirstPage = clubsPage.getQuantityOfClubsOnCurrentPage();

        Assert.assertEquals(quantityOfClubsOnFirstPage, 8,
                String.format("Number of clubs per page is expected to be 8, but was %s instead.", quantityOfClubsOnFirstPage));
    }

    @Test
    public void checkTotalNumberOfClubsEqualsExpected() {
        ClubsPage clubsPage = getHomePage()
                .openClubsPage()
                .waitForClubsPageToOpen();

        int quantityOfClubsOnFirstPage = clubsPage.getQuantityOfClubsOnCurrentPage();
        int numberOfPagesInPagination = clubsPage.getNumberOfPagesInPagination();

        clubsPage
                .openLastPageInPagination()
                .waitForPageToRefresh();

        int quantityOfClubsOnLastPage = clubsPage.getQuantityOfClubsOnCurrentPage();
        int totalNumberOfClubs = quantityOfClubsOnFirstPage * (numberOfPagesInPagination - 1) + quantityOfClubsOnLastPage;

        Assert.assertEquals(totalNumberOfClubs, 368,
                String.format("Total number of clubs is expected to be 368, but was %s instead.", totalNumberOfClubs));
    }
}
