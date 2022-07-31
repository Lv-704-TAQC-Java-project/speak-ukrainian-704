package header.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.clubs.ClubsPage;
import pages.clubs.card.components.CardComponent;
import pages.header.HeaderComponent;
import runners.BaseTestOneWindowRunner;

import java.util.List;


public class LocationTest extends BaseTestOneWindowRunner {

    @DataProvider(name = "locationSelectionData")
    public Object[][] locationSelectionData() {
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

    @Test(dataProvider = "locationSelectionData")
    public void headerLocationSelectionTest(String city) {
        new HeaderComponent(driver)
                .getLocationComponent()
                .clickLocationMenuButton()
                .selectLocationByCity(city);

        ClubsPage clubsPage = new ClubsPage(driver);
        String headerText = clubsPage.headerTitleText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(headerText.contains(city), String.format("Missing %s city in 'Clubs' page header (%s).", city, headerText));

        List<CardComponent> cards = clubsPage.getCards();

        if (cards.isEmpty()) {
            boolean clubsNotFoundMessageIsVisible = clubsPage.clubsNotFoundMessageVisible();
            String clubsNotFoundMessage = clubsPage.clubsNotFoundMessage();
            softAssert.assertTrue(clubsNotFoundMessageIsVisible, "Missing not found clubs for selected city message.");
            softAssert.assertTrue(clubsNotFoundMessage.contains("гуртків не знайдено"), "Not found message does not contain expected phrase.");
        } else {
            for (CardComponent club : cards) {
                softAssert.assertTrue(club.getAddress().getText().contains(city),
                        String.format("Club address '%s' does not contain searched city %s.", club.getAddress().getText(), city));
            }
        }
        softAssert.assertAll();
    }
}
