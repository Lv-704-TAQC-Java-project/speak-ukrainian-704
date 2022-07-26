package header.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.clubs.CardComponent;
import pages.clubs.ClubsPage;
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
                {"Львів"},
                {"Рівне"},
                {"Луцьк"}
        };
    }

    @Test(dataProvider = "locationSelectionData")
    public void headerLocationSelectionTest(String city) {
        new HeaderComponent(driver)
                .getLocationComponent()
                .clickLocationMenuButton()
                .selectLocationByCity(city);

        SoftAssert softAssert = new SoftAssert();

        String headerTitle = new ClubsPage(driver)
                .readHeaderTitle();
        softAssert.assertTrue(headerTitle.contains(city), "Missing searched city name in 'Clubs' page header.");

        List<CardComponent> cards = new ClubsPage(driver).getCards();

        if (cards.isEmpty()) {
            boolean clubsNotFoundMessageIsVisible = new ClubsPage(driver).clubsNotFoundMessageVisible();
            String clubsNotFoundMessage = new ClubsPage(driver).clubsNotFoundMessage();
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
