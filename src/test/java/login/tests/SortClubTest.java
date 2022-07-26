package login.tests;

import jdk.jfr.Description;
import login.tests.runners.BaseTestRunner;
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
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        SortClubComponent sortClubComponent = clubsPage.getSortClubComponent()
                .blockViewButtonClick();

        BlockCardComponent blockCardComponent = clubsPage.getBlockCardViewComponent();
        boolean isDisplayed = blockCardComponent.getBlockCard().isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    @Test
    @Description("Verify that cards are displayed in a list view")
    public void listCardViewIsDisplayed() {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        SortClubComponent sortClubComponent = clubsPage.getSortClubComponent()
                .listViewButtonClick();

        WideCardComponent WideCardComponent = clubsPage.getListCardViewComponent();

        boolean isDisplayed = WideCardComponent.getListCard().isDisplayed();
        Assert.assertTrue(isDisplayed);
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
            cardNamesText.add(i, clubsPage.getCards().get(i).getTextCardName());
            softAssert.assertTrue(cardNamesText.get(i).startsWith("A"));
            System.out.println(cardNamesText.get(i));;
        }

        softAssert.assertAll();

    }
//
//    @Test
//    @Description("Verify that cards are sorted in descending order by ABC")
//    public void sortByAbcDECTest() {
//        ClubsPage clubsPage = new HomePage(driver)
//                .clickAdvancedSearchButton();
//
//        SortClubComponent sortClubComponent = clubsPage.getSortClubComponent()
//                .sortByABCButtonClick()
//                .arrowUpButtonClick();
//
//        CardComponent clubPageComponent = clubsPage.getClubPageComponent();
//
//        List<String> cardNamesDECActual = clubPageComponent
//                .getUpperCaseTextFromWebElementsList(clubPageComponent.getCardNamesList());
//
//        SoftAssert softAssert = new SoftAssert();
//        List<String> cardNamesDECExpected = new ArrayList<>();
//        cardNamesDECExpected.add("ЯЧСЯЧЯЧС");
//        cardNamesDECExpected.add("ШКОЛА ТАНЦІВ DREAM TEAM");
//        cardNamesDECExpected.add("ШКОЛА РОБОТОТЕХНІКИ ТА ПРОГРАМУВАННЯ ДЛЯ ДІТЕЙ ROBOCODE");
//        cardNamesDECExpected.add("ШКОЛА ЛІДЕРСТВА І БІЗНЕСУ KIDBI");
//        cardNamesDECExpected.add("ШКОЛА ДЖАЗОВОГО ТА ЕСТРАДНОГО МИСТЕЦТВ");
//        cardNamesDECExpected.add("ШКОЛА БОЙОВОГО ГОПАКА «ШАБЛЕЗУБ»");
//
//        softAssert.assertEquals(cardNamesDECActual.toString(), cardNamesDECExpected.toString());
//        softAssert.assertAll();
//    }
//
//    @Test
//    @Description("Verify that cards are sorted in descending order by rating")
//    public void sortByRatingDECTest() {
//        ClubsPage clubsPage = new HomePage(driver)
//                .clickAdvancedSearchButton();
//
//        SortClubComponent sortClubComponent = clubsPage.getSortClubComponent()
//                .sortByRatingButtonClick();

//        boolean zeroStar = clubsPage.getClubPageComponent()
//                .getStarRatingZeroList().get(0).isDisplayed();

//        sortClubComponent.arrowUpButtonClick();
//
//        List<WebElement> starsAmountList = clubsPage.getClubPageComponent()
//                .getStarRatingFullList();
//
//        SoftAssert softAssert = new SoftAssert();
//       // softAssert.assertFalse(zeroStar);
//        softAssert.assertEquals(starsAmountList.size(), 5);
//
//        softAssert.assertAll();
//    }

//    @Test
//    @Description("Verify that cards are sorted in ascending order by rating")
//    public void sortByRatingASCTest() {
//        ClubsPage clubsPage = new HomePage(driver)
//                .clickAdvancedSearchButton();
//
//        SortClubComponent sortClubComponent = clubsPage.getSortClubComponent()
//                .sortByRatingButtonClick()
//                .arrowUpButtonClick()
//                .arrowDownButtonClick();
//
//        List<WebElement> starsZeroAmountList = clubsPage.getClubPageComponent()
//                .getStarRatingZeroList();
//
//        SoftAssert softAssert = new SoftAssert();
//
//        softAssert.assertEquals(starsZeroAmountList.size(), 5);
//        softAssert.assertAll();
//    }
//
}


