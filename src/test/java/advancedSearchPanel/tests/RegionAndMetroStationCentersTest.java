package advancedSearchPanel.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.clubs.AdvancedSearchPanelComponent;
import pages.clubs.ClubsPage;
import pages.clubs.PaginationComponent;
import pages.header.HeaderComponent;
import runners.BaseTestOpenAdvancedSearch;


public class RegionAndMetroStationCentersTest extends BaseTestOpenAdvancedSearch {


    @DataProvider(name = "countDistrictsCenter")
    public Object[][] countDistrictsCenter() {
        return new Object[][]{
                {"Деснянський", 10},
                {"Святошинський", 10},
                {"Дніпровський", 1},
                {"Голосіївський", 2},
                {"Дарницький", 4},
                {"Оболонський", 5},
        };
    }

    @DataProvider(name = "countMetrosCenter")
    public Object[][] countMetrosCenter() {
        return new Object[][]{
                {"Арсенальна", 6},
                {"Берестейська", 3},
                {"Бориспільська", 0},
                {"Вирлиця", 3},
                {"Виставковий центр", 0}
        };
    }


    @Test(dataProvider = "countDistrictsCenter")
    public void checkCentersInRegionsOfCity(String nameDistrict, int countExpect) {

        AdvancedSearchPanelComponent inputSearchDistrict = new AdvancedSearchPanelComponent(driver)
                .centerRadioButtonClickAnother()
                .openDistrictInputSelectCenter();

        inputSearchDistrict.clickDistrictWithNameCenter(nameDistrict);
        PaginationComponent paginationComponent = new PaginationComponent(driver);

        int quantityOfClubsOnFirstPage = paginationComponent.getQuantityOfClubsOnCurrentPage();
        int totalNumberOfClubs = quantityOfClubsOnFirstPage;
        boolean paginationVisible = new ClubsPage(driver).paginationComponentIsVisible();

        if (paginationVisible){
            int numberOfPagesInPagination = paginationComponent.getNumberOfPagesInPagination();
            paginationComponent
                    .openLastPageInPagination();
            int quantityOfClubsOnLastPage = paginationComponent.getQuantityOfClubsOnCurrentPage();
            totalNumberOfClubs = quantityOfClubsOnFirstPage * (numberOfPagesInPagination - 1) + quantityOfClubsOnLastPage;
        }

        Assert.assertEquals(totalNumberOfClubs, countExpect);
        new HeaderComponent(driver)
                .openHomePage()
                .getHeader()
                .openClubsPage()
                .clickAdvancedSearchButton();
    }

    @Test(dataProvider = "countMetrosCenter")
    public void checkCentersInMetrosOfCity(String nameMetroStation, int countExpect) {

        AdvancedSearchPanelComponent inputSearchMetro = new AdvancedSearchPanelComponent(driver)
                .centerRadioButtonClick()
                .openMetroInputSelectCenter();

        inputSearchMetro.clickMetroWithNameCenter(nameMetroStation);
        PaginationComponent paginationComponent = new PaginationComponent(driver);
        int quantityOfClubsOnFirstPage = paginationComponent.getQuantityOfClubsOnCurrentPage();
        int totalNumberOfClubs = quantityOfClubsOnFirstPage;
        boolean paginationVisible = new ClubsPage(driver).paginationComponentIsVisible();

        if (paginationVisible){
            int numberOfPagesInPagination = paginationComponent.getNumberOfPagesInPagination();
            paginationComponent
                    .openLastPageInPagination();
            int quantityOfClubsOnLastPage = paginationComponent.getQuantityOfClubsOnCurrentPage();
            totalNumberOfClubs = quantityOfClubsOnFirstPage * (numberOfPagesInPagination - 1) + quantityOfClubsOnLastPage;
        }

        Assert.assertEquals(totalNumberOfClubs, countExpect);
        new HeaderComponent(driver)
                .openHomePage()
                .getHeader()
                .openClubsPage()
                .clickAdvancedSearchButton();
    }

}