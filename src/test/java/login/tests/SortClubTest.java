package login.tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.clubs.ClubPageComponent;
import pages.clubs.ClubsPage;
import pages.clubs.SortClubComponent;
import java.util.ArrayList;
import java.util.List;

public class SortClubTest extends BaseTestRunner {

    @Test
    @Description("Verify that cards are displayed in a block view after clicking on blockViewButton")
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
    @Description("Verify that cards are displayed in a list view after clicking on listViewButton")
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
    @Description("Verify that cards are sorted in ascending order after clicking on sortByABCButton and arrowDownButton")
    public void sortByAbcASCTest() {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        SortClubComponent sortClubComponent = clubsPage.getSortClubComponent()
                .sortByABCButtonClick()
                .arrowUpButtonClick()
                .arrowDownButtonClick();

        SoftAssert softAssert = new SoftAssert();

        ClubPageComponent clubPageComponent = clubsPage.getClubPageComponent();

        List<String> namesActual = clubPageComponent
                .getUpperCaseTextFromWebElementsList(clubPageComponent.getListOfCardNames());

        for (String string : namesActual) {
            softAssert.assertTrue(string.startsWith("A"));
            System.out.println(string);
        }

        softAssert.assertAll();
    }

    @Test
    @Description("Verify that cards are sorted in descending order after clicking on sortByABCButton and arrowUpButton")
    public void sortByAbcDECTest() {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        SortClubComponent sortClubComponent = clubsPage.getSortClubComponent()
                .sortByABCButtonClick()
                .arrowUpButtonClick();

        ClubPageComponent clubPageComponent = clubsPage.getClubPageComponent();

        List<String> cardNamesDECActual = clubPageComponent
                .getUpperCaseTextFromWebElementsList(clubPageComponent.getListOfCardNames());

        SoftAssert softAssert = new SoftAssert();
        List<String> cardNamesDECExpected = new ArrayList<>();
        cardNamesDECExpected.add("ЯЧСЯЧЯЧС");
        cardNamesDECExpected.add("ШКОЛА ТАНЦІВ DREAM TEAM");
        cardNamesDECExpected.add("ШКОЛА РОБОТОТЕХНІКИ ТА ПРОГРАМУВАННЯ ДЛЯ ДІТЕЙ ROBOCODE");
        cardNamesDECExpected.add("ШКОЛА ЛІДЕРСТВА І БІЗНЕСУ KIDBI");
        cardNamesDECExpected.add("ШКОЛА ДЖАЗОВОГО ТА ЕСТРАДНОГО МИСТЕЦТВ");
        cardNamesDECExpected.add("ШКОЛА БОЙОВОГО ГОПАКА «ШАБЛЕЗУБ»");

        softAssert.assertEquals(cardNamesDECActual.toString(), cardNamesDECExpected.toString());
        softAssert.assertAll();
    }

}


