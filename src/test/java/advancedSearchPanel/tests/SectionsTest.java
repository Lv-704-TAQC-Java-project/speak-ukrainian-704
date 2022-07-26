package advancedSearchPanel.tests;

import login.tests.runners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.clubs.AdvancedSearchPanelComponent;
import pages.clubs.ClubPageComponent;
import pages.clubs.ClubsPage;

public class SectionsTest extends BaseTestRunner {
    @Test
    public void checkIsAllClubsIsAvailableOnline() {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        AdvancedSearchPanelComponent advancedSearchPanelComponent = clubsPage.getAdvancedSearchPanelComponent();

        Assert.assertTrue(advancedSearchPanelComponent.sectionsClick(),
                "Some of categories are not available on card");
    }
}
