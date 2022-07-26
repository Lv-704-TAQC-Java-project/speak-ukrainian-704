package advancedSearchPanel.tests;

import runners.BaseTestRunner;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.clubs.AdvancedSearchPanelComponent;
import pages.clubs.ClubPageComponent;
import pages.clubs.ClubsPage;

import java.util.List;

public class IsOnlineClubTest extends BaseTestRunner {
    @Test
    public void checkIsAllClubsIsAvailableOnline() {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        AdvancedSearchPanelComponent advancedSearchPanelComponent = clubsPage.getAdvancedSearchPanelComponent();

        advancedSearchPanelComponent.isOnlineCheckboxClick();

//        ClubPageComponent clubPageComponent = clubsPage.getClubPageComponent();
//        List<WebElement> cards = clubPageComponent.getListOfCards();
//        Assert.assertTrue(clubPageComponent.isAllClubsAvailableOnline(cards), "Some of clubs are not available online");
    }
}
