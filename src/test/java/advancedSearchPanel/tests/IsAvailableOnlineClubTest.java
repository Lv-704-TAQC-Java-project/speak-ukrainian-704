package advancedSearchPanel.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.clubs.AdvancedSearchPanelComponent;
import pages.clubs.card.components.BlockCardComponent;
import pages.clubs.ClubsPage;
import runners.BaseTestRunner;

import java.util.List;

public class IsAvailableOnlineClubTest extends BaseTestRunner {
    @Test
    public void checkIsAllClubsIsAvailableOnline() {
        new HomePage(driver)
                .clickAdvancedSearchButton()
                .getAdvancedSearchPanelComponent()
                .availableOnlineCheckboxClick();

        SoftAssert softAssert = new SoftAssert();
        for (BlockCardComponent card : new ClubsPage(driver).getBlockCards()) {
            softAssert.assertTrue(card.isClubAvailableOnline(),
                    String.format("%s is not available online", card.getTextCardName()));
        }
        softAssert.assertAll();
    }
}
