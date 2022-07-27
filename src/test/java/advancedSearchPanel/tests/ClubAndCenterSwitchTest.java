package advancedSearchPanel.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.clubs.ClubsPage;
import runners.BaseTestRunner;

import java.util.ArrayList;
import java.util.List;

public class ClubAndCenterSwitchTest extends BaseTestRunner {

    @Test
    public void centerSwitchTest() {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        clubsPage
                .getAdvancedSearchPanelComponent()
                .centerRadioButtonClick();

        SoftAssert softAssert = new SoftAssert();

        // softAssert.assertTrue(clubsPage.getAdvancedSearchPanelComponent().IsCenterButtonSelected());

        List<String> centerNamesExpected = new ArrayList<>();
        centerNamesExpected.add("jerome it school");
        centerNamesExpected.add("школа мистецтв імені миколи дмитровича леонтовича");
        centerNamesExpected.add("академія талановитих дітей");
        centerNamesExpected.add("комплекс інноваційної освіти для дітей \"release education\"");
        centerNamesExpected.add("академія професій майбутнього");
        centerNamesExpected.add("київська дитяча школа мистецтв ім. стефана турчака");


        List<String> centerNamesText = new ArrayList<>();
        for (int i = 0; i < clubsPage.getCenters().size(); i++) {
            centerNamesText.add(i, clubsPage.getCenters().get(i).getCenterName().getText().toLowerCase());
            System.out.println(centerNamesText.get(i));;
        }

        softAssert.assertEquals(centerNamesText.toString(), centerNamesExpected.toString());
        softAssert.assertAll();

    }


}
