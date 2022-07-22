package login.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.clubs.ClubPageComponent;
import pages.clubs.ClubsPage;
import pages.clubs.SortClubComponent;

import java.util.ArrayList;
import java.util.List;

public class SortClubTest extends BaseTestRunner {

    @Test
    public void blockCardViewIsDisplayed() {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        SortClubComponent sortClubComponent = clubsPage.getSortClubComponent()
                .blockViewButtonClick();

        ClubPageComponent clubPageComponent = clubsPage.getClubPageComponent();

        boolean isDisplayed = clubPageComponent.getBlockCard().isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Test
    public void listCardViewIsDisplayed() {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        SortClubComponent sortClubComponent = clubsPage.getSortClubComponent()
                .listViewButtonClick();

        ClubPageComponent clubPageComponent = clubsPage.getClubPageComponent();

        boolean isDisplayed = clubPageComponent.getListCard().isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Test
    public void sortByAbcASCTest() {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        SortClubComponent sortClubComponent = clubsPage.getSortClubComponent()
                .sortByABCButtonClick()
                .arrowUpButtonClick()
                .arrowDownButtonClick();

        ClubPageComponent clubPageComponent = clubsPage.getClubPageComponent();

        List<String> namesActual = new ArrayList<>();
        for (int i = 0; i < clubPageComponent.getListOfCardNames().size(); i++) {
            namesActual.add(i, clubPageComponent.getListOfCardNames().get(i).getText().toUpperCase());
            Assert.assertTrue(namesActual.get(i).startsWith("A"));
        }

    }


}
