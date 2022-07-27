package advancedSearchPanel.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.clubs.card.components.BlockCardComponent;
import pages.clubs.ClubsPage;
import pages.clubs.card.components.CardComponent;
import runners.BaseTestRunner;

public class IsAvailableOnlineClubTest extends BaseTestRunner {
    @Test
    public void checkIsAllClubsIsAvailableOnline() {
        new HomePage(driver)
                .clickAdvancedSearchButton()
                .getAdvancedSearchPanelComponent()
                .availableOnlineCheckboxClick();

        SoftAssert softAssert = new SoftAssert();
        for (CardComponent card : new ClubsPage(driver).getCards()) {
            softAssert.assertTrue(card.isClubAvailableOnline(),
                    String.format("%s is not available online", card.getTextCardName()));
        }
        softAssert.assertAll();
    }
}
