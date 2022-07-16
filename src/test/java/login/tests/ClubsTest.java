package login.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ClubsPage;


public class ClubsTest extends BaseTest {

    @Test
    public void checkNumberOfClubsOnFirstPageEqualsExpected() {
        ClubsPage clubsPage = getHomePage()
                .openClubsPage()
                .waitForClubsPageToOpen();

        int quantityOfClubsOnFirstPage = clubsPage.getQuantityOfClubsOnCurrentPage();

        Assert.assertEquals(quantityOfClubsOnFirstPage, 8);
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

        Assert.assertEquals(totalNumberOfClubs, 368);
    }
}
