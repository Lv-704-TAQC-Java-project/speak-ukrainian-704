package advancedSearchPanel.tests;

import org.apache.hc.core5.http.Header;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.clubs.AdvancedSearchPanelComponent;
import pages.clubs.ClubsPage;
import pages.clubs.PaginationComponent;
import pages.header.HeaderComponent;
import runners.BaseTestOpenAdvancedSearch;
import runners.BaseTestRunner;

import java.util.List;

public class RegionAndMetroStationTest extends BaseTestRunner {

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

    @DataProvider(name = "countDistrictsCenter")
    public Object[][] countDistrictsCenter() {
        return new Object[][]{
                {"Деснянський", 10},
                {"Святошинський", 10},
                {"Дніпровський", 1},
                {"Голосіївський", 2},
                {"Дарницький", 4},
                {"Оболонський", 1},
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


    @Test(dataProvider = "countDistricts")
    public void checkClubsInRegionsOfCity(String nameDistrict, int countExpect) {

        AdvancedSearchPanelComponent inputSearchDistrict = new HomePage(driver)
                .getHeader()
                .openClubsPage()
                .clickAdvancedSearchButton()
                .openDistrictInputSelect();

//        AdvancedSearchPanelComponent inputSearchDistrict = new AdvancedSearchPanelComponent(driver)
//                .openDistrictInputSelect();

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
//        new HeaderComponent(driver)
//                .openHomePage()
//                .getHeader()
//                .openClubsPage()
//                .clickAdvancedSearchButton();
    }

    @Test(dataProvider = "countMetros")
    public void checkClubsInMetrosOfCity(String nameMetroStation, int countExpect) {

        AdvancedSearchPanelComponent inputSearchMetro = new HomePage(driver)
                .getHeader()
                .openClubsPage()
                .clickAdvancedSearchButton()
                .openMetroInputSelect();

//        AdvancedSearchPanelComponent inputSearchMetro = new AdvancedSearchPanelComponent(driver)
//                .openMetroInputSelect();

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
//        new HeaderComponent(driver)
//                .openHomePage()
//                .getHeader()
//                .openClubsPage()
//                .clickAdvancedSearchButton();
    }

    @Test(dataProvider = "countDistrictsCenter")
    public void checkCentersInRegionsOfCity(String nameDistrict, int countExpect) {

        AdvancedSearchPanelComponent inputSearchDistrict = new HomePage(driver)
                .getHeader()
                .openClubsPage()
                .clickAdvancedSearchButton()
                .centerRadioButtonClick()
                .openDistrictInputSelectCenter();

//        AdvancedSearchPanelComponent inputSearchDistrict = new AdvancedSearchPanelComponent(driver)
//                .centerRadioButtonClick()
//                .openDistrictInputSelect();

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
//        new HeaderComponent(driver)
//                .openHomePage()
//                .getHeader()
//                .openClubsPage()
//                .clickAdvancedSearchButton();
    }

    @Test(dataProvider = "countMetrosCenter")
    public void checkCentersInMetrosOfCity(String nameMetroStation, int countExpect) {

        AdvancedSearchPanelComponent inputSearchMetro = new HomePage(driver)
                .getHeader()
                .openClubsPage()
                .clickAdvancedSearchButton()
                .centerRadioButtonClick()
                .openMetroInputSelectCenter();

//        AdvancedSearchPanelComponent inputSearchMetro = new AdvancedSearchPanelComponent(driver)
//                .openMetroInputSelect();

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
//        new HeaderComponent(driver)
//                .openHomePage()
//                .getHeader()
//                .openClubsPage()
//                .clickAdvancedSearchButton();
    }

}