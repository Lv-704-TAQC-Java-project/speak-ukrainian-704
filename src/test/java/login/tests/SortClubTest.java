package login.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.clubs.ClubPageComponent;
import pages.clubs.ClubsPage;
import pages.clubs.SortClubComponent;

public class SortClubTest extends BaseTestRunner {

    @Test
    public void sortingByABCTest() {
        SortClubComponent sortClubComponent = new HomePage(driver)
                .clickAdvancedSearchButton()
                .getSortClubComponent()
                .listViewButtonClick();

        ClubPageComponent clubPageComponent = new ClubPageComponent(driver);
        int quantityOfClubCardsListType = clubPageComponent.getListOfCardsTypeList().size();

        Assert.assertEquals(quantityOfClubCardsListType, 6);

    }


}
