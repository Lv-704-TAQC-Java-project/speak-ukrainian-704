package header.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.clubs.ClubsPage;
import pages.clubs.card.components.CardComponent;
import pages.header.HeaderComponent;
import runners.BaseTestOneWindowRunner;

import java.util.List;


public class LocationExtensiveTest extends BaseTestOneWindowRunner {

    @DataProvider(name = "locationWithNoClubs")
    public Object[][] locationWithNoClubs() {
        return new Object[][]{
                {"Київ"},
                {"Харків"},
                {"Дніпро"},
                {"Одеса"},
                {"Запоріжжя"},
                {"Черкаси"},
                {"Львів"},
                {"Рівне"},
                {"Луцьк"},
                {"Солонка"},
                {"Бібрка"},
                {"Винники"},
                {"Тернопіль"},
                {"Гельмязов"},
                {"Каленики"},
                {"Днепр"},
                {"Новомосковськ"},
                {"Знаменовка"},
                {"Затока"}
        };
    }

    @Test(dataProvider = "locationWithNoClubs")
    public void headerLocationSelectionTestWithNoClubs(String city) {
        new HeaderComponent(driver)
                .getLocationComponent()
                .clickLocationMenuButton()
                .selectLocationByCity(city);
        ClubsPage clubsPage = new ClubsPage(driver);
        String headerText = clubsPage.headerTitleText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(headerText.contains(city), String.format("Missing %s city in 'Clubs' page header (%s).", city, headerText));
        softAssert.assertAll();
    }


    @DataProvider(name = "locationOnePage")
    public Object[][] locationOnePage() {
        return new Object[][]{
                {"Львів"}
        };
    }

    @Test(dataProvider = "locationOnePage")
    public void headerLocationSelectionTestOnePage(String city) {
        new HeaderComponent(driver)
                .getLocationComponent()
                .clickLocationMenuButton()
                .selectLocationByCity(city);
        ClubsPage clubsPage = new ClubsPage(driver);
        String headerText = clubsPage.headerTitleText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(headerText.contains(city), String.format("Missing %s city in 'Clubs' page header (%s).", city, headerText));

        List<CardComponent> cards = clubsPage.getCards();

        for (CardComponent club : cards) {
            softAssert.assertTrue(club.getAddress().getText().contains(city),
                    String.format("Club address '%s' does not contain searched city %s.",
                            club.getAddress().getText(),
                            city));
        }
        softAssert.assertAll();
    }


    @DataProvider(name = "locationWithPagination")
    public Object[][] locationWithPagination() {
        return new Object[][]{
                {"Київ"},
                {"Харків"},
                {"Дніпро"},
                {"Одеса"},
                {"Запоріжжя"}
        };
    }

    @Test(dataProvider = "locationWithPagination")
    public void headerLocationSelectionTestWithPagination(String city) {
        new HeaderComponent(driver)
                .getLocationComponent()
                .clickLocationMenuButton()
                .selectLocationByCity(city);
        ClubsPage clubsPage = new ClubsPage(driver);
        String headerText = clubsPage.headerTitleText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(headerText.contains(city), String.format("Missing %s city in 'Clubs' page header (%s).", city, headerText));

        List<CardComponent> cards = clubsPage.getCards();

        int numPages = clubsPage.getPaginationComponent().getNumberOfPagesInPagination();
        int currentPage = 1;
        while (currentPage <= numPages) {
            for (CardComponent club : cards) {
                softAssert.assertTrue(club.getAddress().getText().contains(city),
                        String.format("Club address '%s' on %d page does not contain searched city %s.", club.getAddress().getText(), currentPage, city));
            }
            if (currentPage != numPages) {
                clubsPage.getPaginationComponent().clickNextPageButton(currentPage);
            }
            currentPage++;
            cards = clubsPage.getCards();
        }
        clubsPage.getPaginationComponent().clickFirstPageButton();
        softAssert.assertAll();
    }
}

