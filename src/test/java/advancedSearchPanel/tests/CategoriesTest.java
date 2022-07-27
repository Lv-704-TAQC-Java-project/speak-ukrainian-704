package advancedSearchPanel.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.clubs.AdvancedSearchPanelComponent;
import pages.clubs.ClubsPage;
import pages.clubs.ExpandedCardComponent;
import pages.clubs.card.components.CardComponent;
import runners.BaseTestOpenAdvancedSearch;

public class CategoriesTest extends BaseTestOpenAdvancedSearch {
    @DataProvider(name = "categoriesChecklist")
    public Object[][] locationSelectionData() {
        return new Object[][]{
                {"Спортивні секції"},
                {"Танці, хореографія"},
                {"Студії раннього розвитку"},
                {"Програмування, робототехніка, STEM"},
                {"Вокальна студія, музика, музичні інструменти"},
                {"Акторська майстерність, театр"},
                {"Вчіться, діти"},
                {"Основи"},
                {"Основи Java444"},
                {"Особистісний розвиток"},
                {"Журналістика, дитяче телебачення, монтаж відео, влогів"},
                {"Центр розвитку"},
                {"Інше"},
        };
    }

    @Test(dataProvider = "categoriesChecklist")
    public void checkIsAllCategoriesIsAvailableOnCard(String categoryName) {
//        ClubsPage clubsPage = new HomePage(driver)
//                .clickAdvancedSearchButton();
//
//
//        if (!clubsPage.getAdvancedSearchPanelComponent().advancedSearchSideMenuIsVisible()) {
//            clubsPage.clickAdvancedSearchButton();
//        }

        AdvancedSearchPanelComponent advancedSearchPanelComponent = new ClubsPage(driver).getAdvancedSearchPanelComponent();

        advancedSearchPanelComponent.categoryClick(categoryName);

        ExpandedCardComponent expandedCardComponent = new ClubsPage(driver).getExpandedCardComponent();

        SoftAssert softAssert = new SoftAssert();

        for (CardComponent card : new ClubsPage(driver).getCards()) {
            card.cardTitleClick();
            softAssert.assertTrue(expandedCardComponent.getListOfNamesOfCategories().contains(categoryName));
            expandedCardComponent.exitButtonClick();
        }
        advancedSearchPanelComponent.categoryClick(categoryName);
        softAssert.assertAll();
    }
}
