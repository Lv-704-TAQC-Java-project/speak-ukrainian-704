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
        }

        boolean availableOnlineCheckboxIsDisplayed = clubsPage
                .getAdvancedSearchPanelComponent().availableOnlineCheckboxIsDisplayed();

        boolean centerButtonIsSelected = clubsPage.getAdvancedSearchPanelComponent().IsCenterButtonSelected();

        boolean clubButtonIsSelected = clubsPage.getAdvancedSearchPanelComponent().IsClubButtonSelected();

        boolean categoriesIsDisplayed = clubsPage.getAdvancedSearchPanelComponent().categoriesBlockIsDisplayed();

        boolean ageBlockIsDisplayed = clubsPage.getAdvancedSearchPanelComponent().childAgeBlockIsDisplayed();

        softAssert.assertTrue(centerButtonIsSelected, "Center Button is not selected");
        softAssert.assertFalse(clubButtonIsSelected, "ClubButton is selected");

        softAssert.assertEquals(centerNamesText.toString(), centerNamesExpected.toString(),
                "Center names do not correspond to expected");

        softAssert.assertFalse(availableOnlineCheckboxIsDisplayed, "availableOnlineCheckbox is Displayed");
        softAssert.assertFalse(categoriesIsDisplayed, "Categories section is Displayed");
        softAssert.assertFalse(ageBlockIsDisplayed, "Child age section is displayed");
        softAssert.assertAll();
    }

    @Test
    public void clubSwitchTest() {
        ClubsPage clubsPage = new HomePage(driver)
                .clickAdvancedSearchButton();

        clubsPage
                .getAdvancedSearchPanelComponent()
                .centerRadioButtonClick()
                .clubRadioButtonClick();

        SoftAssert softAssert = new SoftAssert();

        List<String> clubNamesExpected = new ArrayList<>();
        clubNamesExpected.add("jerome it school");
        clubNamesExpected.add("american gymnastics club");
        clubNamesExpected.add("it освіта: курси \"гранд\"");
        clubNamesExpected.add("онлайн-школа точних наук youstud");
        clubNamesExpected.add("театральна студія \"зоряні діти''");
        clubNamesExpected.add("студія танцю \"несамовиті\"");

        List<String> clubNamesText = new ArrayList<>();
        for (int i = 0; i < clubsPage.getCenters().size(); i++) {
            clubNamesText.add(i, clubsPage.getCards().get(i).getCardName().getText().toLowerCase());
        }

        boolean availableOnlineCheckboxIsDisplayed = clubsPage
                .getAdvancedSearchPanelComponent().availableOnlineCheckboxIsDisplayed();

        boolean clubButtonIsSelected = clubsPage.getAdvancedSearchPanelComponent().IsClubButtonSelected();

        boolean centerButtonIsSelected = clubsPage.getAdvancedSearchPanelComponent().IsCenterButtonSelected();

        boolean categoriesIsDisplayed = clubsPage.getAdvancedSearchPanelComponent().categoriesBlockIsDisplayed();

        boolean ageBlockIsDisplayed = clubsPage.getAdvancedSearchPanelComponent().childAgeBlockIsDisplayed();

        softAssert.assertTrue(clubButtonIsSelected, "ClubRadioButton is not selected");
        softAssert.assertFalse(centerButtonIsSelected, "CenterRadioButton is selected");

        softAssert.assertEquals(clubNamesText.toString(), clubNamesExpected.toString(),
                "Club names do not correspond to expected ones");

        softAssert.assertTrue(availableOnlineCheckboxIsDisplayed, "availableOnlineCheckbox is not Displayed");
        softAssert.assertTrue(categoriesIsDisplayed, "Categories section is not Displayed");
        softAssert.assertTrue(ageBlockIsDisplayed, "Child age section is not displayed");
        softAssert.assertAll();
    }
}
