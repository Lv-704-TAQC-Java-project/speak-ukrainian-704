package advancedSearchPanel.tests;

import jdk.jfr.Description;
import runners.BaseTestRunner;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.clubs.*;

import java.util.ArrayList;
import java.util.List;

public class SortClubTest extends BaseTestRunner {

    @Test
    @Description("Verify that cards are displayed in a block view")
    public void blockCardViewIsDisplayed() {
        new HomePage(driver)
                .clickAdvancedSearchButton()
                .getSortClubComponent()
                .blockViewButtonClick();

        boolean isDisplayed = new ClubsPage(driver).getBlockCardContainer().isDisplayed();
        Assert.assertTrue(isDisplayed, "Clubs are not displayed in block type view");
    }

    @Test
    @Description("Verify that cards are displayed in a list view")
    public void listCardViewIsDisplayed() {
        new HomePage(driver)
                .clickAdvancedSearchButton()
                .getSortClubComponent()
                .listViewButtonClick();

        boolean isDisplayed = new ClubsPage(driver).getWideCardContainer().isDisplayed();
        Assert.assertTrue(isDisplayed, "Clubs are not displayed in list type view");
    }

    @Test
    @Description("Verify that cards are sorted in ascending order by ABC")
    public void sortByAbcASCTest() {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        SortClubComponent sortClubComponent = clubsPage.getSortClubComponent()
                .sortByABCButtonClick()
                .arrowUpButtonClick()
                .arrowDownButtonClick();

        SoftAssert softAssert = new SoftAssert();

        List<String> cardNamesText = new ArrayList<>();
        for (int i = 0; i < clubsPage.getCards().size(); i++) {
            cardNamesText.add(i, clubsPage.getCards().get(i).getTextCardName().toUpperCase());
            softAssert.assertTrue(cardNamesText.get(i).startsWith("A"), "Club name doesn't start with A");
            System.out.println(cardNamesText.get(i));
        }

        softAssert.assertAll();
    }

    @Test
    @Description("Verify that cards are sorted in descending order by ABC")
    public void sortByAbcDECTest() {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        SortClubComponent sortClubComponent = clubsPage.getSortClubComponent()
                .sortByABCButtonClick()
                .arrowUpButtonClick();

        SoftAssert softAssert = new SoftAssert();
        List<String> cardNamesDECExpected = new ArrayList<>();
        cardNamesDECExpected.add("ЯЧСЯЧЯЧС");
        cardNamesDECExpected.add("ШКОЛА ТАНЦІВ DREAM TEAM");
        cardNamesDECExpected.add("ШКОЛА РОБОТОТЕХНІКИ ТА ПРОГРАМУВАННЯ ДЛЯ ДІТЕЙ ROBOCODE");
        cardNamesDECExpected.add("ШКОЛА ЛІДЕРСТВА І БІЗНЕСУ KIDBI");
        cardNamesDECExpected.add("ШКОЛА ДЖАЗОВОГО ТА ЕСТРАДНОГО МИСТЕЦТВ");
        cardNamesDECExpected.add("ШКОЛА БОЙОВОГО ГОПАКА «ШАБЛЕЗУБ»");

        List<String> cardNamesText = new ArrayList<>();
        for (int i = 0; i < clubsPage.getCards().size(); i++) {
            cardNamesText.add(i, clubsPage.getCards().get(i).getTextCardName().toUpperCase());
        }

        softAssert.assertEquals(cardNamesText.toString(), cardNamesDECExpected.toString());
        softAssert.assertAll();
    }

    @Test
    @Description("Verify that cards are sorted in descending order by rating")
    public void sortByRatingDECTest() {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        SortClubComponent sortClubComponent = clubsPage.getSortClubComponent()
                .sortByRatingButtonClick();

        sortClubComponent.arrowUpButtonClick();

        List<WebElement> starsFull = new ArrayList<>();
        if (!clubsPage.getCards().isEmpty()) {
            starsFull.addAll(clubsPage.getCards().get(0).getStarRatingFullList());
        }

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(starsFull.size(), 5, "The amount of full stars doesn't equal 5");
        softAssert.assertAll();
    }

    @Test
    @Description("Verify that cards are sorted in ascending order by rating")
    public void sortByRatingASCTest() {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        SortClubComponent sortClubComponent = clubsPage.getSortClubComponent()
                .sortByRatingButtonClick()
                .arrowUpButtonClick()
                .arrowDownButtonClick();

        List<WebElement> starsZero = new ArrayList<>();
        starsZero.addAll(clubsPage.getCards().get(0).getStarRatingZeroList());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(starsZero.size(), 5, "The amount of zero stars doesn't equal 5");
        softAssert.assertAll();
    }

}