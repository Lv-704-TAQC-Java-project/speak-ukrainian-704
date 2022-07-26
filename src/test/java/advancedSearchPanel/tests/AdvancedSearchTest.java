package advancedSearchPanel.tests;

import runners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.clubs.AdvancedSearchPanelComponent;
import pages.clubs.ClubsPage;
import pages.HomePage;


public class AdvancedSearchTest extends BaseTestRunner {

    @Test
    public void checkExtendedSearchButtonFunctionality() {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        clubsPage
                .waitForClubsPageToOpen();

        AdvancedSearchPanelComponent advancedSearchPanelComponent = clubsPage.getAdvancedSearchPanelComponent();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(advancedSearchPanelComponent.advancedSearchSideMenuIsVisible(), "Extended search menu is not visible.");
        softAssert.assertTrue(advancedSearchPanelComponent.advancedAsideMenuIsVisible(), "Extended aside section is not visible.");
        softAssert.assertEquals(advancedSearchPanelComponent.getAdvancedSearchHeaderText().trim(), "Розширений пошук",
                "Advanced search header title is not as expected.");
        softAssert.assertTrue(advancedSearchPanelComponent.citySelectionInputIsVisible(), "City selector is not visible.");
        softAssert.assertTrue(advancedSearchPanelComponent.isAvailableOnlineIsVisible(), "Checkbox 'available online' is not visible.");
        softAssert.assertTrue(advancedSearchPanelComponent.basicCategoriesCheckListIsVisible(), "Basic category check list is not visible.");

        softAssert.assertAll();

        clubsPage
                .clickAdvancedSearchButton();

        Assert.assertFalse(advancedSearchPanelComponent.advancedAsideMenuIsVisible(), "Extended aside section is visible");
    }
}
