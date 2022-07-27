package advancedSearchPanel.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.clubs.AdvancedSearchPanelComponent;
import pages.clubs.CardComponent;
import pages.clubs.ClubsPage;
import pages.clubs.ExpandedCardComponent;
import pages.clubs.card.components.BlockCardComponent;
import runners.BaseTestRunner;

import java.util.List;

public class CategoriesTest extends BaseTestRunner {
    @DataProvider(name = "categoriesChecklist")
    public Object[][] locationSelectionData() {
        return new Object[][]{
                {"Спортивні секції", "Спортивні секції"},
                {"Танці, хореографія", "Танці, хореографія"},
                {"Студії раннього розв...", "Студії раннього розвитку"},
                {"Програмування, роб...", "Програмування, робототехніка, STEM"},
                {"Вокальна студія, музи...", "Вокальна студія, музика, музичні інструменти"},
                {"Акторська майстерні...", "Акторська майстерність, театр"},
                {"Вчіться, діти", "Вчіться, діти"},
                {"Основи", "Основи"},
                {"Основи Java444", "Основи Java444"},
                {"Особистісний розвит...", "Особистісний розвиток"},
                {"Журналістика, дитяче...", "Журналістика, дитяче телебачення, монтаж відео, влогів"},
                {"Центр розвитку", "Центр розвитку"},
                {"Інше", "Інше"},
        };
    }

    @Test(dataProvider = "categoriesChecklist")
    public void checkIsAllCategoriesIsAvailableOnCard(String categoryToClick) {
        new HomePage(driver)
                .clickAdvancedSearchButton()
                .getAdvancedSearchPanelComponent()
                .categoryClick(categoryToClick);

        ExpandedCardComponent expandedCardComponent = new ClubsPage(driver).getExpandedCardComponent();

        SoftAssert softAssert = new SoftAssert();

        for (BlockCardComponent card : new ClubsPage(driver).getBlockCards()) {
            card.cardTitleClick();
            softAssert.assertTrue(expandedCardComponent.getListOfNamesOfCategories().contains(categoryToClick));
            expandedCardComponent.exitButtonClick();
        }
        softAssert.assertAll();
    }
}
