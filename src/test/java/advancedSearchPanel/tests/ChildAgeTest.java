package advancedSearchPanel.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.clubs.AdvancedSearchPanelComponent;
import pages.clubs.ClubsPage;
import pages.clubs.ExpandedCardComponent;
import pages.clubs.card.components.CardComponent;
import runners.BaseTestRunner;


public class ChildAgeTest extends BaseTestRunner {
    @DataProvider(name = "childAge")
    public Object[][] locationSelectionData() {
        return new Object[][]{
                {3},
                {2},
                {10},
                {15},
                {18}
        };
    }
    @Test(dataProvider = "childAge")
    public void enterValidChildAgeTest(Integer childAge) {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        AdvancedSearchPanelComponent advancedSearchPanelComponent = new ClubsPage(driver).getAdvancedSearchPanelComponent();

        advancedSearchPanelComponent.enterChildAge(childAge);

        ExpandedCardComponent expandedCardComponent = new ClubsPage(driver).getExpandedCardComponent();

        SoftAssert softAssert = new SoftAssert();

        for (CardComponent card : new ClubsPage(driver).getCards()) {
            card.cardTitleClick();
            Integer fromAge = expandedCardComponent.getAgeRestriction()[0];
            Integer toAge = expandedCardComponent.getAgeRestriction()[1];
            softAssert.assertTrue((fromAge <= childAge && toAge >= childAge));
            expandedCardComponent.exitButtonClick();
        }

        softAssert.assertAll();
    }
}
