package advancedSearchPanel.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
                {0, new int[]{6, 6, 6, 6, 6, 6, 6, 6, 6, 2}}
        };
    }

    @DataProvider(name = "countMetros")
    public Object[][] countMetros() {
        return new Object[][]{
                {0, new int[]{6, 0, 3, 0, 0, 0, 2, 1}}
        };
    }

    @DataProvider(name = "countDistrictsCenter")
    public Object[][] countDistrictsCenter() {
        return new Object[][]{
                {0, new int[]{6, 6, 1, 3, 2, 4, 1, 5}}
        };
    }

    @DataProvider(name = "countMetrosCenter")
    public Object[][] countMetrosCenter() {
        return new Object[][]{
                {0, new int[]{6, 3, 0, 0, 2, 0, 3, 0}}
        };
    }

    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "countDistricts")
    public void checkClubsInRegionsOfCity(int indexCity, int[] countExpect) {

        AdvancedSearchPanelComponent inputSearchDistrict = new HomePage(driver)
                .clickAdvancedSearchButton()
                .getAdvancedSearchPanelComponent()
                .openDistrictInputSelect();
        List<WebElement> listDistricts = inputSearchDistrict.getDistrictListSectionChildren();
        inputSearchDistrict
                .openDistrictInputSelect();
        sleep(1000);

        int counter = 0;
        int clubsNumber = 0;

        ClubsPage clubsPage = new ClubsPage(driver);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        for (int i = 0; i < listDistricts.size(); i++) {
            inputSearchDistrict
                    .openDistrictInputSelect();
            executor.executeScript("arguments[0].click();", listDistricts.get(i));
            sleep(500);
            System.out.println(driver.findElement(By.xpath("(//span[contains(@class, 'select-selection-item')])[2]")).getText());

            System.out.println("Start cycle clubs number: " + clubsNumber);
            List<WebElement> paginationPages = driver.findElements(By.xpath("//li[contains(@class, 'pagination-item')]"));
            if (!paginationPages.isEmpty()) {
                clubsNumber += clubsPage.getCards().size() * (clubsPage.getPaginationComponent().getNumberOfPagesInPagination() - 1);
                System.out.println("Pages in pagination: " + clubsPage.getPaginationComponent().getNumberOfPagesInPagination());
                System.out.println("Added clubs from full pages: " + clubsNumber);
                int lastPaginationPage = paginationPages.size() - 1;
                paginationPages.get(lastPaginationPage).click();
                sleep(500);
            }
            System.out.println("Spare clubs on last page: " + clubsPage.getCards().size());
            clubsNumber += clubsPage.getCards().size();
            System.out.println("Added spare clubs on last page: " + clubsNumber);
            if (!paginationPages.isEmpty()) {
                paginationPages.get(0).click();
            }
            sleep(500);
            counter++;
            System.out.println(clubsNumber);
        }
        System.out.println(counter);
        System.out.println(clubsNumber);
        Assert.assertEquals(listDistricts.size(), 10);
    }


    @Test(dataProvider = "countMetros")
    public void checkClubsNearMetroOfCity(int indexCity, int[] countExpect) {

        AdvancedSearchPanelComponent inputSearchMetro = new HomePage(driver)
                .clickAdvancedSearchButton()
                .getAdvancedSearchPanelComponent()
                .openMetroInputSelect();
        List<WebElement> listMetros = inputSearchMetro.getMetroListSectionChildren();
        inputSearchMetro
                .openMetroInputSelect();

        inputSearchMetro
                .openMetroInputSelect();

//        for (int i = 0; i < listDistricts.size(); i++) {
//            if (i >= 8) inputSearchDistrict.scrollDistrictInputSelect();
        for (int i = 0; i < 8; i++) {
            listMetros.get(i).click();
            int clubsNumber = new ClubsPage(driver).openPaginationComponent().getQuantityOfClubsOnCurrentPage();
            System.out.println(listMetros.get(i).getAccessibleName() + " " + clubsNumber + " groups");
            Assert.assertEquals(clubsNumber, countExpect[i]);
            inputSearchMetro
                    .openMetroInputSelect();
            if (i == listMetros.size() - 1) break;
        }
        Assert.assertEquals(listMetros.size(), 10);
    }

    @Test(dataProvider = "countDistrictsCenter")
    public void checkCentersInRegionsOfCity(int indexCity, int[] countExpect) {
        AdvancedSearchPanelComponent inputSearchDistrict = new HomePage(driver)
                .clickAdvancedSearchButton()
                .getAdvancedSearchPanelComponent()
                .centerRadioButtonClick()
                .openDistrictInputSelect();
        List<WebElement> listDistricts = inputSearchDistrict.getDistrictListSectionChildren();
        inputSearchDistrict
                .openDistrictInputSelect();

        inputSearchDistrict
                .openDistrictInputSelect();

//        for (int i = 0; i < listDistricts.size(); i++) {
//            if (i >= 8) inputSearchDistrict.scrollDistrictInputSelect();

        for (int i = 0; i < 8; i++) {
            listDistricts.get(i).click();
            int clubsNumber = new ClubsPage(driver).openPaginationComponent().getQuantityOfClubsOnCurrentPage();
            System.out.println(listDistricts.get(i).getAccessibleName() + " " + clubsNumber + " groups");
            Assert.assertEquals(clubsNumber, countExpect[i]);
            inputSearchDistrict
                    .openDistrictInputSelect();
            if (i == listDistricts.size() - 1) break;
        }
        Assert.assertEquals(listDistricts.size(), 10);
    }

    @Test(dataProvider = "countMetrosCenter")
    public void checkCentersNearMetroOfCity(int indexCity, int[] countExpect) {

        AdvancedSearchPanelComponent inputSearchMetro = new HomePage(driver)
                .clickAdvancedSearchButton()
                .getAdvancedSearchPanelComponent()
                .centerRadioButtonClick()
                .openMetroInputSelect();
        List<WebElement> listMetros = inputSearchMetro.getMetroListSectionChildren();
        System.out.println(listMetros.size());
        inputSearchMetro
                .openMetroInputSelect();

        inputSearchMetro
                .openMetroInputSelect();

//        for (int i = 0; i < listDistricts.size(); i++) {
//            if (i >= 8) inputSearchDistrict.scrollDistrictInputSelect();
        for (int i = 0; i < 8; i++) {
            listMetros.get(i).click();
            int clubsNumber = new ClubsPage(driver).openPaginationComponent().getQuantityOfClubsOnCurrentPage();
            System.out.println(listMetros.get(i).getAccessibleName() + " " + clubsNumber + " groups");
            Assert.assertEquals(clubsNumber, countExpect[i]);
            inputSearchMetro
                    .openMetroInputSelect();
            if (i == listMetros.size() - 1) break;
        }
        Assert.assertEquals(listMetros.size(), 10);
    }
}