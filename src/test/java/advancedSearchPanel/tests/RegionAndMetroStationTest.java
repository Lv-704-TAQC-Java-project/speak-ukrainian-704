package advancedSearchPanel.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.clubs.AdvancedSearchPanelComponent;
import pages.clubs.ClubsPage;
import runners.BaseTestRunner;

import java.util.List;

public class RegionAndMetroStationTest extends BaseTestRunner {

    @DataProvider(name = "countDistricts")
    public Object[][] countDistricts() {
        return new Object[][]{
                {new int[]{6, 6, 6, 6, 6, 6, 6, 6, 6, 2}}
        };
    }


    @Test(dataProvider = "countDistricts")
    public void checkClubsInRegionsOfCity(int[] countExpect) {
        AdvancedSearchPanelComponent inputSearchDistrict= new HomePage(driver)
                .clickAdvancedSearchButton()
                .getAdvancedSearchPanelComponent()
                .openDistrictInputSelect();
        List<WebElement> listDistricts=inputSearchDistrict.getDistrictListSectionChildren();
        inputSearchDistrict
                .openDistrictInputSelect();

        inputSearchDistrict
                .openDistrictInputSelect();

        for (int i = 0; i < 8; i++) {
            listDistricts.get(i).click();
            int clubsNumber = new ClubsPage(driver).openPaginationComponent().getQuantityOfClubsOnCurrentPage();
            Assert.assertEquals(clubsNumber, countExpect[i]);
            inputSearchDistrict
                    .openDistrictInputSelect();
        }

        Assert.assertEquals(listDistricts.size(),10);
    }
}
