package advancedSearchPanel.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.clubs.AdvancedSearchPanelComponent;
import pages.clubs.ClubsPage;
import pages.clubs.PaginationComponent;
import pages.header.HeaderComponent;
import runners.BaseTestOpenAdvancedSearch;


public class RegionAndMetroStationClubsTest extends BaseTestOpenAdvancedSearch {

    @DataProvider(name = "countDistricts")
    public Object[][] countDistricts() {
        return new Object[][]{
                {"Деснянський", 9},
                {"Святошинський", 11},
                {"Дніпровський", 12},
                {"Голосіївський", 253},
                {"Дарницький", 12},
                {"Оболонський", 11},
        };
    }

    @DataProvider(name = "countMetros")
    public Object[][] countMetros() {
        return new Object[][]{
                {"Арсенальна", 8},
                {"Берестейська", 0},
                {"Бориспільська", 3},
                {"Вирлиця", 2},
                {"Виставковий центр", 1}
        };
    }

    @Test(dataProvider = "countDistricts")
    public void checkClubsInRegionsOfCity(String nameDistrict, int countExpect) {

        AdvancedSearchPanelComponent inputSearchDistrict = new AdvancedSearchPanelComponent(driver)
                .openDistrictInputSelect();

        inputSearchDistrict.clickDistrictWithName(nameDistrict);
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

    @Test(dataProvider = "countMetros")
    public void checkClubsInMetrosOfCity(String nameMetroStation, int countExpect) {

        AdvancedSearchPanelComponent inputSearchMetro = new AdvancedSearchPanelComponent(driver)
                .openMetroInputSelect();

        inputSearchMetro.clickMetroWithName(nameMetroStation);
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