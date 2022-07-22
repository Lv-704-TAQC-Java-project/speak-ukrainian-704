package login.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.clubs.ClubsPage;
import pages.HomePage;

public class AdvancedSearchTest extends BaseTestRunner {

    @Test
    public void checkExtendedSearchButtonFunctionality() {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        clubsPage
                .waitForClubsPageToOpen();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(clubsPage.advancedSearchSideMenuIsVisible(), "Extended search menu is not visible.");
        softAssert.assertTrue(clubsPage.advancedAsideMenuIsVisible(), "Extended aside section is not visible.");
        softAssert.assertEquals(clubsPage.getAdvancedSearchHeaderText().trim(), "Розширений пошук",
                "Advanced search header title is not as expected.");
        softAssert.assertTrue(clubsPage.citySelectionInputIsVisible(), "City selector is not visible.");
        softAssert.assertTrue(clubsPage.basicCategoriesCheckListIsVisible(), "Basic category check list is not visible.");
        softAssert.assertAll();

        clubsPage
                .clickAdvancedSearchButton();

        Assert.assertFalse(clubsPage.advancedAsideMenuIsVisible(), "Extended aside section is visible");
    }
}
