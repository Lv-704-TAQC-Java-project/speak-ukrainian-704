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
    @DataProvider(name = "locationSelectionData")
    public Object[][] locationSelectionData() {
        return new Object[][]{
                {"Київ"},
                {"Харків"},
                {"Дніпро"},
                {"Одеса"},
                {"Запоріжжя"},
//                {"Кропивницький"},
//                {"Херсон"},
//                {"Миколаїв"},
//                {"Суми"},
//                {"Маріуполь"},
//                {"Чернігів"},
//                {"Полтава"},
//                {"Кременчук"},
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

    @Test(dataProvider = "locationSelectionData")
    public void headerLocationSelectionTest(String city) {
        new HeaderComponent(driver)
                .getLocationComponent()
                .clickLocationMenuButton()
                .selectLocationByCity(city);
//        System.out.println(city);
        ClubsPage clubsPage = new ClubsPage(driver);
        SoftAssert softAssert = new SoftAssert();
        String headerText = clubsPage.headerTitleText();

        softAssert.assertTrue(headerText.contains(city), String.format("Missing %s city in 'Clubs' page header (%s).", city, headerText));

        List<CardComponent> cards = clubsPage.getCards();

        if (cards.isEmpty()) {
            boolean clubsNotFoundMessageIsVisible = clubsPage.clubsNotFoundMessageVisible();
            String clubsNotFoundMessage = clubsPage.clubsNotFoundMessage();
            softAssert.assertTrue(clubsNotFoundMessageIsVisible, "Missing not found clubs for selected city message.");
            softAssert.assertTrue(clubsNotFoundMessage.contains("гуртків не знайдено"), "Not found message does not contain expected phrase.");
        } else {
            boolean paginationIsPresent = clubsPage.getPaginationComponent().paginationIsPresent();
            int currentPage = 1;
            if (paginationIsPresent) {
                int numPages = clubsPage.getPaginationComponent().getNumberOfPagesInPagination();
//                System.out.println(numPages);
                while (currentPage < numPages) {
//                    System.out.println(String.format("%d page, number of clubs %d", currentPage, cards.size()));
                    for (CardComponent club : cards) {
                        softAssert.assertTrue(club.getAddress().getText().contains(city),
                                String.format("Club address '%s' on %d page does not contain searched city %s.", club.getAddress().getText(), currentPage, city));
                    }
                    clubsPage.getPaginationComponent().clickNextPageButton(currentPage);
                    currentPage++;
                    cards = clubsPage.getCards();
                }
                ;
            }
//            System.out.println("Hi, from last page");
//            System.out.println(String.format("%d page, number of clubs %d", currentPage, cards.size()));
            for (CardComponent club : cards) {
                softAssert.assertTrue(club.getAddress().getText().contains(city),
                        String.format("Club address '%s' %s does not contain searched city %s.",
                                club.getAddress().getText(),
                                paginationIsPresent ? "on last page" : "",
                                city));
            }
            if (paginationIsPresent) {
                clubsPage.getPaginationComponent().clickFirstPageButton();
            }

        }

        softAssert.assertAll();
    }
}
