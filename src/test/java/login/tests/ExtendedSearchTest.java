package login.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ClubsPage;

public class ExtendedSearchTest extends BaseTest {

    @Test
    public void checkExtendedSearchButtonFunctionality() {
        ClubsPage clubsPage = getHomePage()
                .clickExtendedSearchButton();

        clubsPage
                .waitForClubsPageToOpen();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(clubsPage.extendedSearchSideMenuIsVisible(), "Extended search menu is not visible.");
        softAssert.assertTrue(clubsPage.extendedAsideMenuIsVisible(), "Extended aside section is not visible.");
        softAssert.assertEquals(clubsPage.getExtendedSearchHeaderText().trim(), "Розширений пошук",
                "Extended search header title is not as expected.");
        softAssert.assertTrue(clubsPage.citySelectionInputIsVisible(), "City selector is not visible.");
        softAssert.assertTrue(clubsPage.basicCategoriesCheckListIsVisible(), "Basic category check list is not visible.");
        softAssert.assertAll();

        clubsPage
                .clickExtendedSearchButton();

        Assert.assertFalse(clubsPage.extendedAsideMenuIsVisible(), "Extended aside section is visible");
    }
}
