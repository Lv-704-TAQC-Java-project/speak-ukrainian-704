package advancedSearchPanel.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.clubs.AdvancedSearchPanelComponent;
import pages.clubs.CardComponent;
import pages.clubs.ClubsPage;
import runners.BaseTestRunner;

import java.util.List;

public class IsAvailableOnlineClubTest extends BaseTestRunner {
    @Test
    public void checkIsAllClubsIsAvailableOnline() {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();


        AdvancedSearchPanelComponent advancedSearchPanelComponent = clubsPage.getAdvancedSearchPanelComponent();

        advancedSearchPanelComponent.availableOnlineCheckboxClick();

        List<CardComponent> cards = clubsPage.getCards();

        for (CardComponent card : cards) {
            Assert.assertTrue(card.isClubAvailableOnline(),
                    String.format("%s is not available online", card.getTextCardName()));
        }
    }
}
